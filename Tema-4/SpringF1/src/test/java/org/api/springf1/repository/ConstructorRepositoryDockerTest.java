package org.api.springf1.repository;

import org.api.springf1.model.Constructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@DataJpaTest
public class ConstructorRepositoryDockerTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15.5");

    @Autowired ConstructorRepository constructorRepository;

    Constructor constructor;
    @BeforeEach
    public void setUp() {
        constructor = new Constructor();
        constructor.setId(1L);
        constructor.setName("McLaren");
        constructor.setNationality("British");
        constructor.setUrl("https://en.wikipedia.org/wiki/McLaren");
    }

    @Test
    void shouldReturnSavedConstructorWhenSave() {
        Constructor constructorSaved = constructorRepository.save(constructor);

        assertThat(constructorSaved).isNotNull();
        assertThat(constructorSaved.getId()).isGreaterThan(0);
    }

    @Test
    void shouldReturnMoreThanOneConstructorWhenSaveTwoConstructors(){
        Constructor constructor2 = new Constructor();
        constructor2.setId(2L);
        constructor2.setName("Ferrari");
        constructor2.setNationality("Italian");
        constructor2.setUrl("https://en.wikipedia.org/wiki/Scuderia_Ferrari");

        constructorRepository.save(constructor);
        constructorRepository.save(constructor2);

        assertThat(constructorRepository.count()).isEqualTo(2);
    }

    @Test
    void shouldReturnConstructorNotNullWhenFindByName(){
        constructorRepository.save(constructor);
        Constructor constructorFound = constructorRepository.findByName("McLaren");

        assertThat(constructorFound).isNotNull();
    }

    @Test
    void shouldReturnConstructorNotNullWhenUpdateConstructor(){
        constructorRepository.save(constructor);
        constructor.setName("Mercedes");
        constructorRepository.save(constructor);

        Constructor constructorUpdated = constructorRepository.findByName("Mercedes");

        assertThat(constructorUpdated).isNotNull();
    }

    @Test
    void shouldReturnNullConstructorWhenDelete(){
        constructorRepository.save(constructor);
        constructorRepository.deleteByName("McLaren");

        assertThat(constructorRepository.findByName("McLaren")).isNull();
    }
}

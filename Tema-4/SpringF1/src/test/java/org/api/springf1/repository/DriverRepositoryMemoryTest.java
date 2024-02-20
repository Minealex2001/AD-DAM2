package org.api.springf1.repository;

import org.api.springf1.model.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class DriverRepositoryMemoryTest {

    @Autowired DriverRepository driverRepository;

    Driver driver;

    @BeforeEach
    public void setUp() {
        driver = new Driver();
        driver.setCode("HAM");
        driver.setForename("Lewis");
        driver.setSurname("Hamilton");
        driver.setNationality("British");
        driver.setUrl("https://en.wikipedia.org/wiki/Lewis_Hamilton");
    }

    @Test
    void shouldReturnSavedDriverWhenSave() {
        Driver driverSaved = driverRepository.save(driver);

        assertThat(driverSaved).isNotNull();
        assertThat(driverSaved.getId()).isGreaterThan(0);
    }

    @Test
    void shouldReturnMoreThanOneDriverWhenSaveTwoDrivers(){
        Driver driver2 = new Driver();
        driver2.setCode("BOT");
        driver2.setForename("Valtteri");
        driver2.setSurname("Bottas");
        driver2.setNationality("Finnish");
        driver2.setUrl("https://en.wikipedia.org/wiki/Valtteri_Bottas");

        driverRepository.save(driver);
        driverRepository.save(driver2);

        assertThat(driverRepository.count()).isEqualTo(2);
    }

    @Test
    void shouldReturnDriverNotNullWhenFindByCode(){
        driverRepository.save(driver);
        Driver driverFound = driverRepository.findByCode("HAM");

        assertThat(driverFound).isNotNull();
    }

    @Test
    void shouldReturnDriverNotNullWhenUpdateDriver(){
        driverRepository.save(driver);
        Driver driverFound = driverRepository.findByCode("HAM");

        driverFound.setForename("Lewis Carl");
        driverRepository.save(driverFound);

        assertThat(driverRepository.findByCode("HAM").getForename()).isEqualTo("Lewis Carl");
    }

    @Test
    void shouldReturnNullDriverWhenDelete(){
        driverRepository.save(driver);
        driverRepository.deleteByCodeIgnoreCase("HAM");

        assertThat(driverRepository.findByCode("HAM")).isNull();
    }
}

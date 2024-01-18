package org.alejandro.ejercicio3.repository;

import org.alejandro.ejercicio3.model.Constructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConstructorRepository extends JpaRepository<Constructor, Long> {

}

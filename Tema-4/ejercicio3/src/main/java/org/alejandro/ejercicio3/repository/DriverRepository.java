package org.alejandro.ejercicio3.repository;

import org.alejandro.ejercicio3.model.Driver;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends org.springframework.data.jpa.repository.JpaRepository<org.alejandro.ejercicio3.model.Driver, Long> {
    Optional<Driver> findByCodeIgnoreCase(String code);
    void deleteByCode(String code);
}
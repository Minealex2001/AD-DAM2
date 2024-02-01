package org.alejandro.ejercicio3.repository;

import org.alejandro.ejercicio3.entity.Driver;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

// Repositorio para la entidad Driver
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    // Método para buscar un driver por su código, ignorando mayúsculas y minúsculas
    Optional<Driver> findByCodeIgnoreCase(String code);

    // Método para eliminar un driver por su código
    void deleteByCode(String code);
}
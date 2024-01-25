package org.alejandro.ejercicio3.service.Driver;

import org.alejandro.ejercicio3.model.Driver;
import org.springframework.stereotype.Service;
import org.alejandro.ejercicio3.repository.DriverRepository;
import org.alejandro.ejercicio3.service.Driver.DriverService;

import java.util.List;
import java.util.Optional;

// Implementación del servicio para la entidad Driver
@Service
public class DriverServiceImpl implements DriverService{
    // Repositorio para gestionar los drivers en la base de datos
    private final DriverRepository driverRepository;

    // Inyección de dependencias del repositorio
    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    // Método para obtener todos los drivers
    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    // Método para obtener un driver por su código
    @Override
    public Optional<Driver> getDriverByCode(String code) {
        return driverRepository.findByCodeIgnoreCase(code);
    }

    // Método para guardar un driver (tanto para crear como para actualizar)
    @Override
    public void saveDriver(Driver driver) {
        driverRepository.save(driver);
    }

    // Método para eliminar un driver por su código
    @Override
    public void deleteDriver(String code) {
        driverRepository.deleteByCode(code);
    }
}
package org.alejandro.ejercicio3.service;

import org.alejandro.ejercicio3.model.Driver;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements org.alejandro.ejercicio3.service.DriverService{
    private final org.alejandro.ejercicio3.repository.DriverRepository driverRepository;

    public DriverServiceImpl(org.alejandro.ejercicio3.repository.DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Optional<Driver> getDriverByCode(String code) {
        return driverRepository.findByCodeIgnoreCase(code);
    }

    @Override
    public void saveDriver(Driver driver) {
        driverRepository.save(driver);
    }

    @Override
    public void deleteDriver(String code) {
        driverRepository.deleteByCode(code);
    }
}
package org.alejandro.ejercicio2.service;

import org.alejandro.ejercicio2.model.Driver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements org.alejandro.ejercicio2.service.DriverService{
   private final org.alejandro.ejercicio2.repository.DriverRepository driverRepository;

    public DriverServiceImpl(org.alejandro.ejercicio2.repository.DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }
}

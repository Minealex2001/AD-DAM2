package org.alejandro.ejercicio3.service;

import org.alejandro.ejercicio3.model.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    List<Driver> getAllDrivers();

    Optional<Driver> getDriverByCode(String code);
}
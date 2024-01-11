package org.alejandro.ejercicio3.controller;

import org.alejandro.ejercicio3.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DriverRestController {

    private final org.alejandro.ejercicio3.service.DriverService driverService;

    @Autowired
    public DriverRestController(org.alejandro.ejercicio3.service.DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/drivers")
    public java.util.List<org.alejandro.ejercicio3.model.Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/drivers/{code}")
    public ResponseEntity<Driver> getByCode(@PathVariable String code) {
        return this.driverService.getDriverByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

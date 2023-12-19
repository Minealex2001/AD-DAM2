package org.alejandro.ejercicio2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DriverRestController {

    private final org.alejandro.ejercicio2.service.DriverService driverService;

    @Autowired
    public DriverRestController(org.alejandro.ejercicio2.service.DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/drivers")
    public java.util.List<org.alejandro.ejercicio2.model.Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

}

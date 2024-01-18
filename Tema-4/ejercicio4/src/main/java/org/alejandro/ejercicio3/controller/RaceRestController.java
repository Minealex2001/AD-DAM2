package org.alejandro.ejercicio3.controller;

import org.alejandro.ejercicio3.model.Race;
import org.alejandro.ejercicio3.service.Race.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RaceRestController {
    private final RaceService raceService;

    @Autowired
    public RaceRestController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping("/race")
    public List<Race> getAllRaces() {
        return raceService.getAllRaces();
    }

//

}

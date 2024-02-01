package org.alejandro.ejercicio3.controller;

import org.alejandro.ejercicio3.entity.Race;
import org.alejandro.ejercicio3.service.Race.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RaceRestController {
    private final RaceService raceService;

    @Autowired
    public RaceRestController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping("/races")
    public List<Race> getAllRaces() {
        return raceService.getAllRaces();
    }

    @GetMapping("/race/{round}")
    public Race getByRound(@PathVariable int round) {
        return raceService.getRaceByRound(round);
    }

    @PostMapping( "/race/add")
    public ResponseEntity<Race> create(@Validated @RequestBody Race race){
        if(race.getId() != null){
            return ResponseEntity.badRequest().build();
        } else {
            this.raceService.saveRace(race);
            return ResponseEntity.ok(race);
        }
    }

    @PutMapping("/race/delete/{round}")
    public ResponseEntity<Race> deleteByRound(int round){
        return ResponseEntity.ok().build();
    }
}

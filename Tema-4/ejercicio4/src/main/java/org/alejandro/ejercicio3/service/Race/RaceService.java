package org.alejandro.ejercicio3.service.Race;

import org.alejandro.ejercicio3.model.Race;

import java.util.List;

public interface RaceService {
    List<Race> getAllRaces();

    void saveRace(Race race);

//    void deleteRace(String round);
}

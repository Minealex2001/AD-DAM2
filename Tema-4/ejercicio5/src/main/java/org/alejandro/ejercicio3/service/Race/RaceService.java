package org.alejandro.ejercicio3.service.Race;

import org.alejandro.ejercicio3.entity.Race;

import java.util.List;

public interface RaceService {
    List<Race> getAllRaces();

    void saveRace(Race race);

    Race getRaceByRound(int round);

//    void deleteRace(String round);
}

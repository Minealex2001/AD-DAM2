package org.alejandro.ejercicio3.service.Race;

import org.alejandro.ejercicio3.model.Race;
import org.alejandro.ejercicio3.repository.RaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceServiceImpl implements RaceService{

    private final RaceRepository raceRepository;

    public RaceServiceImpl(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @Override
    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    @Override
    public void saveRace(Race race){
        raceRepository.save(race);
    }

//    @Override
//    public void deleteRace(String round){
//        raceRepository.deleteByRound(round);
//    }
}

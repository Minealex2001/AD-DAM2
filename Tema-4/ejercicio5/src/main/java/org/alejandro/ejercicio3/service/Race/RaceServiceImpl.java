package org.alejandro.ejercicio3.service.Race;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.alejandro.ejercicio3.entity.Race;
import org.alejandro.ejercicio3.repository.RaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

        @Service
        public class RaceServiceImpl implements RaceService {

            private final RaceRepository raceRepository;

            @PersistenceContext
            private EntityManager entityManager;

            public RaceServiceImpl(RaceRepository raceRepository) {
                this.raceRepository = raceRepository;
            }

            @Override
            public List<Race> getAllRaces() {
                return raceRepository.findAll();
            }

            @Override
            @Transactional
            public void saveRace(Race race) {
                if (race.getCircuit() != null) {
                    if (race.getCircuit().getCircuitid() != null) {
                        race.setCircuit(entityManager.merge(race.getCircuit()));
                    } else {
                        raceRepository.save(race);
                        race.getCircuit().setRace(race);
                        entityManager.persist(race.getCircuit());
                    }
                } else {
                    raceRepository.save(race);
                }
            }
            @Override
            public Race getRaceByRound(int round) {
                return raceRepository.findByRound(round);
            }
        }
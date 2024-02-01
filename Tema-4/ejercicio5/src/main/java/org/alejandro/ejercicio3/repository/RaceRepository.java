package org.alejandro.ejercicio3.repository;

import org.alejandro.ejercicio3.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceRepository extends JpaRepository<Race, Long> {
    Race findByRound(int round);
//    void deleteByRound(String round);
}

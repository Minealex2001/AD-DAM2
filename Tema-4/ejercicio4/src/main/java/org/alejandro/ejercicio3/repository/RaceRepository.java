package org.alejandro.ejercicio3.repository;

import org.alejandro.ejercicio3.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceRepository extends JpaRepository<Race, Long> {
//    void deleteByRound(String round);
}

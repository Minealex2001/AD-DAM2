package org.alejandro.ejercicio3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "results")
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resultid")
    private Long resultid;

    @ManyToOne
    @JoinColumn(name = "raceid")
    Race race;

    @ManyToOne
    @JoinColumn(name = "driverid")
    Driver driver;

    private int grid;
    private String position;
    private int points;

}

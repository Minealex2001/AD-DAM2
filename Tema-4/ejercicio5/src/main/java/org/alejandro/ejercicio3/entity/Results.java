package org.alejandro.ejercicio3.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties
    Race race;

    @ManyToOne
    @JoinColumn(name = "driverid")
    @JsonIgnoreProperties
    Driver driver;

    private int grid;
    private Integer position;
    private int points;

}

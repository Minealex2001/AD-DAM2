package org.alejandro.ejercicio3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Data
@Table(name = "races")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "raceid")
    private Long id;

    private int year;

    @OneToMany(mappedBy = "race")
    @JsonIgnore
    private Set<Results> results;

    private int round;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "circuitid")
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private Circuit circuit;

    private String name;
    private LocalDate date;
    private LocalTime time;
    private String url;
}

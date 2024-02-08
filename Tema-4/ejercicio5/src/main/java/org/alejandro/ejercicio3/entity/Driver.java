package org.alejandro.ejercicio3.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

// Entidad Driver que representa la tabla "drivers" en la base de datos
@Entity
@Data
@Table(name = "drivers")
public class Driver {
    // Identificador único del driver
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driverid")
    private Long driverId;

    // Código único del driver
    @Column(unique = true, name = "code")
    private String code;
    @Column(nullable = false, name = "forename")
    private String forename;
    @Column(nullable = false, name = "surname")
    private String surname;

    @Column(nullable = false, name = "dob")
    @JsonProperty("dateofbirth")
    private LocalDate dob;

    @Column(nullable = false)
    private String nationality;

    private String url;

    @ManyToOne
    @JoinColumn(name = "constructorid")
    @JsonIgnoreProperties
    private Constructor constructor;

    @OneToMany(mappedBy = "driver")
    @JsonIgnore
    private Set<Results> results;
}
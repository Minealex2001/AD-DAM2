package org.alejandro.ejercicio3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

// Entidad Driver que representa la tabla "drivers" en la base de datos
@Entity
@Data
@Table(name = "drivers")
public class Driver {
    // Identificador único del driver
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driverid")
    private Long id;

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
    @JsonIgnoreProperties("listaDrivers")
    private Constructor constructor;
}
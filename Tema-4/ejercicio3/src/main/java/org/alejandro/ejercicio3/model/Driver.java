package org.alejandro.ejercicio3.model;

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
    private String forename;
    private String surname;
    @JsonProperty("dateofbirth")
    private LocalDate dob;
    private String nationality;
    private String url;
}
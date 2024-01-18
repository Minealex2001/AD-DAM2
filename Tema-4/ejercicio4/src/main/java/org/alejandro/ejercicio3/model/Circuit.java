package org.alejandro.ejercicio3.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "circuits")
public class Circuit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "circuitid")
    private int circuitid;
    @Column(unique = true, nullable = false, name = "circuitref")
    private String circuitref;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "location")
    private String location;
    @Column(nullable = false, name = "country")
    private String country;
    private float lat;
    private float lng;
    private int alt;
    private String url;

    @OneToOne(mappedBy = "circuit")
    private Race race;

}

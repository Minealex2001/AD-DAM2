package org.alejandro;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Funko implements Serializable {
    private final String id;
    private String nombre;
    private String modelo;
    private double precio;
    private String fechaLanzamiento;

    public Funko(String id, String nombre, String modelo, String precioString, String fechaLanzamiento) {
        this.id = id;
        this.nombre = nombre;
        this.modelo = modelo;
        this.precio = precioStringToDouble(precioString);
        this.fechaLanzamiento = fechaLanzamiento;
    }

    private double precioStringToDouble(String precioString) {
        try{
            return Double.parseDouble(precioString);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    @Override
    public String toString() {
        return "main.Funko{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                ", fechaLanzamiento=" + fechaLanzamiento +
                '}';
    }
}

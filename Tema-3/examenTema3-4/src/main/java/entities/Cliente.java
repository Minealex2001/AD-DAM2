package entities;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.Date;

@Data
public class Cliente {
    ObjectId id;
    String apellido;
    int clientid;
    String dni;
    String nombre;
    String nacionalidad;
    String telefono;

    String email;
    String usuario;
    String contrasenya;

    public Cliente(int clientid, String dni, String nombre, String apellido, String nacionalidad, String telefono, String email, String usuario, String contrasenya) {
        this.clientid = clientid;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.email = email;
        this.usuario = usuario;
        this.contrasenya = contrasenya;
    }

    public Cliente() {
    }

    public int getId() {
        return clientid;
    }

    public void setId(int id) {
        this.clientid = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
}

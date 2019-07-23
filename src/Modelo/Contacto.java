/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Nacho
 */
public class Contacto {
    
    private String id;
    private String nombre;
    private String apellido;
    private String relacion;
    private String telefono;
    private String email;
    private String idCiudad;
    private String datosVarios;

    public Contacto(
            String id, 
            String nombre, 
            String apellido, 
            String relacion, 
            String telefono, 
            String email, 
            String idCiudad, 
            String datosVarios) {
        
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.relacion = relacion;
        this.telefono = telefono;
        this.email = email;
        this.idCiudad = idCiudad;
        this.datosVarios = datosVarios;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
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

    public String getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(String idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getDatosVarios() {
        return datosVarios;
    }

    public void setDatosVarios(String datosVarios) {
        this.datosVarios = datosVarios;
    }
}

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
public class Usuario {

    private String id;
    private String activo;
    private String idEmpleado;
    private String idDatos;
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private String idDireccion;
    private String ciudad;
    private String idCiudad;
    private String cp;
    private String idCp;
    private String fechaNacimiento;
    private String fechaInicio;
    private String fechaFin;
    private String idDatosFacturacion;
    private String sesionesSemanales;
    private String gradoDiscapacidad;
    private String diagnostico;
    private String motivoConsulta;
    private String objetivos;
    private String observaciones;
    private String email;
    private String idEmail;
    private String telefono;
    private String idTelefono;

    public Usuario(String id, String activo, String idEmpleado, String nombre,
            String apellidos, String dni, String direccion, String ciudad,
            String cp, String fechaNacimiento, String fechaInicio,
            String fechaFin, String idDatosFacturacion,
            String sesionesSemanales, String gradoDiscapacidad,
            String diagnostico, String motivoConsulta, String objetivos,
            String observaciones, String email, String telefono, String idDatos) {
        this.id = id;
        this.activo = activo;
        this.idEmpleado = idEmpleado;
        this.idDatos = idDatos;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.cp = cp;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idDatosFacturacion = idDatosFacturacion;
        this.sesionesSemanales = sesionesSemanales;
        this.gradoDiscapacidad = gradoDiscapacidad;
        this.diagnostico = diagnostico;
        this.motivoConsulta = motivoConsulta;
        this.objetivos = objetivos;
        this.observaciones = observaciones;
        this.email = email;
        this.telefono = telefono;
        
        idEmpleado="1";
        activo="1";
        idDatosFacturacion="null";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getIdDatos() {
        return idDatos;
    }

    public void setIdDatos(String idDatos) {
        this.idDatos = idDatos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getIdDatosFacturacion() {
        return idDatosFacturacion;
    }

    public void setIdDatosFacturacion(String idDatosFacturacion) {
        this.idDatosFacturacion = idDatosFacturacion;
    }

    public String getSesionesSemanales() {
        return sesionesSemanales;
    }

    public void setSesionesSemanales(String sesionesSemanales) {
        this.sesionesSemanales = sesionesSemanales;
    }

    public String getGradoDiscapacidad() {
        return gradoDiscapacidad;
    }

    public void setGradoDiscapacidad(String gradoDiscapacidad) {
        this.gradoDiscapacidad = gradoDiscapacidad;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public String getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(String idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(String idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getIdCp() {
        return idCp;
    }

    public void setIdCp(String idCp) {
        this.idCp = idCp;
    }

    public String getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(String idEmail) {
        this.idEmail = idEmail;
    }

    public String getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(String idTelefono) {
        this.idTelefono = idTelefono;
    }
    
    

}

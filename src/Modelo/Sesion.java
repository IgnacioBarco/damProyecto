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
public class Sesion {
    
 
    private String id;
    private String idUsuario;
    private String idDatosFacturacion;
    private String concepto;
    private String beca;
    private String coste;
    private String pagado;
    private String fecha;
    private String observaciones;

    public Sesion(
            String id, 
            String idUsuario, 
            String idDatosFacturacion, 
            String concepto, 
            String beca, 
            String coste, 
            String pagado, 
            String fecha, 
            String observaciones) {
        
        this.id = id;
        this.idUsuario = idUsuario;
        this.idDatosFacturacion = idDatosFacturacion;
        this.concepto = concepto;
        this.beca = beca;
        this.coste = coste;
        this.pagado = pagado;
        this.fecha = fecha;
        this.observaciones = observaciones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdDatosFacturacion() {
        return idDatosFacturacion;
    }

    public void setIdDatosFacturacion(String idDatosFacturacion) {
        this.idDatosFacturacion = idDatosFacturacion;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getBeca() {
        return beca;
    }

    public void setBeca(String beca) {
        this.beca = beca;
    }

    public String getCoste() {
        return coste;
    }

    public void setCoste(String coste) {
        this.coste = coste;
    }

    public String getPagado() {
        return pagado;
    }

    public void setPagado(String pagado) {
        this.pagado = pagado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}

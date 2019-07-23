/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.*;

/**
 *
 * @author Nacho
 */
public class ControlPrincipal {


    private static Conexion conexion;

    private static VentanaPrincipal vPrincipal;
    private static VUsuarios vUsuario;
    private static VContactos vContactos;
    private static VSesion vSesion;
    private static VAgenda vAgenda;
    private static VOpcionesEmpleado vOpcionesEmpleado;
    private static VOpcionesAdmin vOpcionesAdmin;
    private static VInformes vInformes;

    private static ControlPrincipal instanciaControl;
   
    public ControlPrincipal() {

    }

    public static synchronized ControlPrincipal getInstanciaControl() {
        if (instanciaControl == null) {
            instanciaControl = new ControlPrincipal();
            
            vPrincipal = new VentanaPrincipal();
            vUsuario = new VUsuarios();
            vContactos = new VContactos();
            vSesion = new VSesion();
            vAgenda = new VAgenda();
            vInformes = new VInformes();
            vOpcionesEmpleado = new VOpcionesEmpleado();
            vOpcionesAdmin = new VOpcionesAdmin();

            conexion = new Conexion();

            vPrincipal.setVisible(true);

        }
        return instanciaControl;
    }

    public VUsuarios getVentanaUsuarios() {

        return vUsuario;
    }

    public VContactos getVentanaContactos() {

        return vContactos;
    }

    public VSesion getVentanaSesion() {

        return vSesion;
    }

    public VAgenda getVentanaAgenda() {

        return vAgenda;
    }

    public VOpcionesEmpleado getVentanaOpcionesEmpleado() {

        return vOpcionesEmpleado;
    }

    public VInformes getVentanaInformes() {

        return vInformes;
    }

    public VOpcionesAdmin getVentanaOpcionesAdmin() {

        return vOpcionesAdmin;
    }

    //
    //
    public VSesion getVentanaSesion(String sesionNueva) {

        vSesion.setEstadoNuevo();
        return vSesion;
    }

    public VUsuarios getVentanaUsuarios(String usuarioNuevo) {

        vUsuario.setEstadoNuevo();
        return vUsuario;
    }
    
    
    public VContactos getVentanaContactos(String contactoNuevo) {

        vContactos.setEstadoNuevo();
        return vContactos;
    }

    //
    //
    public Conexion getConexion() {

        return conexion;
    }

}

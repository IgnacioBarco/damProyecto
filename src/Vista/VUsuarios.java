/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

/**
 *
 * @author Nacho
 */
public class VUsuarios extends javax.swing.JPanel {

    private final String texto_estado_vista = "vista";
    private final String texto_estado_editar = "editar";
    private final String texto_estado_nuevo = "nuevo";
    private final String texto_campo_vacio = "";

    private String estado = texto_estado_vista;

    //parte de datos
    private final String texto_etiqueta_01 = "*Nombre: ";
    private final String texto_etiqueta_02 = "*Apellidos: ";
    private final String texto_etiqueta_03 = "F. Nacimiento: ";
    private final String texto_etiqueta_04 = "Edad: ";
    private final String texto_etiqueta_05 = "F. Inicio: ";
    private final String texto_etiqueta_06 = "F. Fin: ";
    private final String texto_etiqueta_07 = "Sesiones semanales: ";
    private final String texto_etiqueta_08 = "Grado de discapacidad: ";
    private final String texto_etiqueta_09 = "DNI: ";
    private final String texto_etiqueta_10 = "Dirección: ";
    private final String texto_etiqueta_11 = "Ciudad: ";
    private final String texto_etiqueta_12 = "CP: ";
    private final String texto_etiqueta_13 = "Email: ";
    private final String texto_etiqueta_14 = "Teléfono: ";
    private final String texto_etiqueta_20 = "Diagnóstico: ";
    private final String texto_etiqueta_21 = "Motivo Consulta: ";
    private final String texto_etiqueta_22 = "Objetivos: ";
    private final String texto_etiqueta_23 = "Observaciones: ";

    //parte de botones
    private final String texto_Editar = "Editar";
    private final String texto_Guardar = "Guardar";
    private final String texto_Cancelar = "Cancelar";
    private final String texto_Borrar = "Borrar";
    private final String texto_Nuevo = "Nuevo";

    private final String MSG_Usuario_modificado_correctamente
            = "El usuario ha sido modificado correctamente";

    private final String MSG_Usuario_creado_correctamente
            = "El usuario ha sido creado correctamente";

    private final String MSG_Usuario_ya_existe
            = "Ya existe un usuario con ese nombre y apellidos";

    private final String MSG_Operacion_SQL_Erronea
            = "El usuario no se ha podido crear correctamente, "
            + "ha habido un error con la conexión a la base de datos";

    private ResultSet rsUsuario;
    private Usuario usuarioNuevo;
    private Usuario usuarioModificado;
    private Usuario usuarioRecuperado;
    private String idDNI;
    private String idDireccion;
    private String idCiudad;
    private String idCP;

    private String mensajeError;

    private String Sentencia_SQL_nuevo_usuario = "";
    private String Sentencia_SQL2_nuevo_usuario = "";
    private String Sentencia_SQL_modifiacar_usuario;
    private String Sentencia_SQL_eliminar_usuario;

    private boolean datosValidos;
    private boolean verificarPatron;
    boolean validarCampos;
    boolean validarTablas;
    boolean validarOperacionSQL;

    private boolean nombre;
    private boolean apellidos;
    private boolean fechaNacimiento;
    private boolean fechaInicio;
    private boolean fechaFin;
    private boolean dni;
    private boolean telefono;

    private boolean cpBoolean;
    private String cpId;
    private String cpRes;

    private boolean email;

    private Pattern pat = null;
    private Matcher mat = null;

    /**
     * Creates new form vUsuarios
     */
    public VUsuarios() {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        setBounds(0, 0, 1185, 677);
        initComponents();

        etiqueta_01.setText(texto_etiqueta_01);
        etiqueta_02.setText(texto_etiqueta_02);
        etiqueta_03.setText(texto_etiqueta_03);
        etiqueta_04.setText(texto_etiqueta_04);
        etiqueta_04.setVisible(false);
        etiqueta_04_campo.setVisible(false);

        etiqueta_05.setText(texto_etiqueta_05);
        etiqueta_06.setText(texto_etiqueta_06);

        etiqueta_07.setText(texto_etiqueta_07);
        etiqueta_08.setText(texto_etiqueta_08);
        etiqueta_09.setText(texto_etiqueta_09);
        etiqueta_10.setText(texto_etiqueta_10);
        etiqueta_11.setText(texto_etiqueta_11);
        etiqueta_12.setText(texto_etiqueta_12);
        etiqueta_13.setText(texto_etiqueta_13);
        etiqueta_14.setText(texto_etiqueta_14);
        etiqueta_20.setText(texto_etiqueta_20);
        etiqueta_21.setText(texto_etiqueta_21);
        etiqueta_22.setText(texto_etiqueta_22);
        etiqueta_23.setText(texto_etiqueta_23);

        boton_01.setText(texto_Editar);
        boton_02.setVisible(false);
        boton_02.setText(texto_Guardar);
        boton_03.setText(texto_Borrar);

        bloquearCampos();

    }

    public JPanel getVUsuarios() {
        updateUI();
        return this;
    }

    /**
     * Bloqueamos los campos para que no sean modificables
     */
    public void bloquearCampos() {

        etiqueta_01_campo.setEnabled(false);
        etiqueta_02_campo.setEnabled(false);
        etiqueta_03_campo.setEnabled(false);
        etiqueta_04_campo.setEnabled(false);
        etiqueta_05_campo.setEnabled(false);
        etiqueta_06_campo.setEnabled(false);
        etiqueta_07_campo.setEnabled(false);
        etiqueta_08_campo.setEnabled(false);
        etiqueta_09_campo.setEnabled(false);
        etiqueta_10_campo.setEnabled(false);
        etiqueta_11_campo.setEnabled(false);
        etiqueta_12_campo.setEnabled(false);
        etiqueta_13_campo.setEnabled(false);
        etiqueta_14_campo.setEnabled(false);
        etiqueta_20_campo.setEnabled(false);
        etiqueta_21_campo.setEnabled(false);
        etiqueta_22_campo.setEnabled(false);
        etiqueta_23_campo.setEnabled(false);

    }

    /**
     * Desbloqueamos los campos para que sean modificables
     */
    public void desbloquearCampos() {

        etiqueta_01_campo.setEnabled(true);
        etiqueta_02_campo.setEnabled(true);
        etiqueta_03_campo.setEnabled(true);
        etiqueta_04_campo.setEnabled(true);
        etiqueta_05_campo.setEnabled(true);
        etiqueta_06_campo.setEnabled(true);
        etiqueta_07_campo.setEnabled(true);
        etiqueta_08_campo.setEnabled(true);
        etiqueta_09_campo.setEnabled(true);
        etiqueta_10_campo.setEnabled(true);
        etiqueta_11_campo.setEnabled(true);
        etiqueta_12_campo.setEnabled(true);
        etiqueta_13_campo.setEnabled(true);
        etiqueta_14_campo.setEnabled(true);
        etiqueta_20_campo.setEnabled(true);
        etiqueta_21_campo.setEnabled(true);
        etiqueta_22_campo.setEnabled(true);
        etiqueta_23_campo.setEnabled(true);

    }

    /**
     * Limpia todos los campos
     */
    public void limpiarCampos() {

        etiqueta_01_campo.setText(texto_campo_vacio);
        etiqueta_02_campo.setText(texto_campo_vacio);
        etiqueta_03_campo.setText(texto_campo_vacio);
        etiqueta_04_campo.setText(texto_campo_vacio);
        etiqueta_05_campo.setText(texto_campo_vacio);
        etiqueta_06_campo.setText(texto_campo_vacio);
        etiqueta_07_campo.setText(texto_campo_vacio);
        etiqueta_08_campo.setText(texto_campo_vacio);
        etiqueta_09_campo.setText(texto_campo_vacio);
        etiqueta_10_campo.setText(texto_campo_vacio);
        etiqueta_11_campo.setText(texto_campo_vacio);
        etiqueta_12_campo.setText(texto_campo_vacio);
        etiqueta_13_campo.setText(texto_campo_vacio);
        etiqueta_14_campo.setText(texto_campo_vacio);
        etiqueta_20_campo.setText(texto_campo_vacio);
        etiqueta_21_campo.setText(texto_campo_vacio);
        etiqueta_22_campo.setText(texto_campo_vacio);
        etiqueta_23_campo.setText(texto_campo_vacio);

    }

    /**
     * ponemos estado nuevo
     */
    public void setEstadoNuevo() {
        desbloquearCampos();
        limpiarCampos();
        boton_01.setText(texto_Cancelar);
        boton_02.setText(texto_Guardar);
        boton_02.setVisible(true);
                boton_03.setEnabled(false);

        estado = texto_estado_nuevo;
    }

    /**
     * ponemos estado editar
     */
    public void setEstadoEditar() {
        desbloquearCampos();
        boton_01.setText(texto_Cancelar);
        boton_02.setText(texto_Guardar);
        boton_02.setVisible(true);
        boton_03.setEnabled(true);
        estado = texto_estado_editar;
    }

    /**
     * ponemos estado listar usuarios
     */
    public void setEstadoVista() {
        bloquearCampos();
        boton_01.setText(texto_Editar);
        boton_02.setVisible(false);
        boton_03.setEnabled(true);
        estado = texto_estado_vista;
    }

//////////////////////////////////////////////////////////////////////////////////
//                   Parte de Datos                                    //////////
//////////////////////////////////////////////////////////////////////////////// 
   
    /**
     * creamos usuario desde los datos que nos pasa la ventanaprincipal
     */
    public void crearUsuarioRecuperado() {
        try {
            usuarioRecuperado = new Usuario(
                    rsUsuario.getString(1), rsUsuario.getString(2),
                    rsUsuario.getString(3), rsUsuario.getString(4),
                    rsUsuario.getString(5), rsUsuario.getString(6),
                    rsUsuario.getString(7), rsUsuario.getString(8),
                    rsUsuario.getString(9), rsUsuario.getString(10),
                    rsUsuario.getString(11), rsUsuario.getString(12),
                    rsUsuario.getString(13), rsUsuario.getString(14),
                    rsUsuario.getString(15), rsUsuario.getString(16),
                    rsUsuario.getString(17), rsUsuario.getString(18),
                    rsUsuario.getString(19), rsUsuario.getString(20),
                    rsUsuario.getString(21), rsUsuario.getString(22));

        } catch (SQLException ex) {
            Logger.getLogger(VUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearUsuarioModificado() {

        usuarioModificado = new Usuario(
                usuarioRecuperado.getId(),
                usuarioRecuperado.getActivo(),
                usuarioRecuperado.getIdEmpleado(),
                etiqueta_01_campo.getText(),
                etiqueta_02_campo.getText(),
                etiqueta_09_campo.getText(),
                etiqueta_10_campo.getText(),
                etiqueta_11_campo.getText(),
                etiqueta_12_campo.getText(),
                etiqueta_03_campo.getText(),
                etiqueta_05_campo.getText(),
                etiqueta_06_campo.getText(),
                usuarioRecuperado.getIdDatosFacturacion(),
                etiqueta_07_campo.getText(),
                etiqueta_08_campo.getText(),
                etiqueta_20_campo.getText(),
                etiqueta_21_campo.getText(),
                etiqueta_22_campo.getText(),
                etiqueta_23_campo.getText(),
                etiqueta_13_campo.getText(),
                etiqueta_14_campo.getText(),
                usuarioRecuperado.getIdDatos());

    }

    
    /**
     * creamos un usuario nuevo con los campos que ha introducido el usuario
     */
    public void crearUsuarioNuevo() {

        usuarioNuevo = new Usuario(
                usuarioRecuperado.getId(),
                usuarioRecuperado.getActivo(),
                usuarioRecuperado.getIdEmpleado(),
                etiqueta_01_campo.getText(),
                etiqueta_02_campo.getText(),
                etiqueta_09_campo.getText(),
                etiqueta_10_campo.getText(),
                etiqueta_11_campo.getText(),
                etiqueta_12_campo.getText(),
                etiqueta_03_campo.getText(),
                etiqueta_05_campo.getText(),
                etiqueta_06_campo.getText(),
                usuarioRecuperado.getIdDatosFacturacion(),
                etiqueta_07_campo.getText(),
                etiqueta_08_campo.getText(),
                etiqueta_20_campo.getText(),
                etiqueta_21_campo.getText(),
                etiqueta_22_campo.getText(),
                etiqueta_23_campo.getText(),
                etiqueta_13_campo.getText(),
                etiqueta_14_campo.getText(),
                usuarioRecuperado.getIdDatos());

    }

    
    /**
     * para pasar los datos y pintarlos desde la ventanaprincipal
     * @param rs 
     */
    public void setDatos(ResultSet rs) {
        rsUsuario = null;
        rsUsuario = rs;
        try {
            rsUsuario.next();
            crearUsuarioRecuperado();
            pintarDatos();

        } catch (SQLException ex) {
            Logger.getLogger(VSesion.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        pintarDatos();
    }

    /**
     * pintamos los datos
     */
    public void pintarDatos() {

        limpiarCampos();

        etiqueta_01_campo.setText(usuarioRecuperado.getNombre());
        etiqueta_02_campo.setText(usuarioRecuperado.getApellidos());
        etiqueta_03_campo.setText(usuarioRecuperado.getFechaNacimiento());
        // etiqueta_04_campo.setText(rsUsuario.getString(4));
        etiqueta_05_campo.setText(usuarioRecuperado.getFechaInicio());
        etiqueta_06_campo.setText(usuarioRecuperado.getFechaFin());
        etiqueta_07_campo.setText(usuarioRecuperado.getSesionesSemanales());
        etiqueta_08_campo.setText(usuarioRecuperado.getGradoDiscapacidad());
        etiqueta_09_campo.setText(usuarioRecuperado.getDni());
        etiqueta_10_campo.setText(usuarioRecuperado.getDireccion());
        etiqueta_11_campo.setText(usuarioRecuperado.getCiudad());
        etiqueta_12_campo.setText(usuarioRecuperado.getCp());
        etiqueta_13_campo.setText(usuarioRecuperado.getEmail());
        etiqueta_14_campo.setText(usuarioRecuperado.getTelefono());
        etiqueta_20_campo.setText(usuarioRecuperado.getDiagnostico());
        etiqueta_21_campo.setText(usuarioRecuperado.getMotivoConsulta());
        etiqueta_22_campo.setText(usuarioRecuperado.getObjetivos());
        etiqueta_23_campo.setText(usuarioRecuperado.getObservaciones());

    }

    
    /**
     * devuelve true si el patron coincide
     * @param dato
     * @param pat
     * @param mat
     * @return 
     */
    public boolean verificarPatron(String dato, Pattern pat, Matcher mat) {

        mat = pat.matcher(dato);

        if (mat.find()) {
            // Coincide con el patrón 
            verificarPatron = true;
            return verificarPatron;
        } else {
            // NO coincide con el patrón
            verificarPatron = false;
            return verificarPatron;
        }
    }

    /**
     * valida y da de alta un usuario nuevo
     */
    public void validarUsuarioNuevo() {

        validarCampos = true;
        validarTablas = true;
        validarOperacionSQL = true;

        fechaNacimiento = false;
        fechaInicio = false;
        fechaFin = false;
        dni = false;
        telefono = false;
        cpBoolean = false;
        email = false;

        
        validacionCamposUsuarioNuevoPatrones();

        //si falla algun campo
        if (!validarCampos) {
            mostrarMensaje(mensajeError);

            //si no falla ningun campo    
        } else {

            //comprobamos si existe ese nombre y apellidos
            if (VentanaPrincipal.consultaSQL(""
                    + "select * from datos where "
                    + "nombre =   '" + etiqueta_01_campo.getText() + "' and "
                    + "apellidos = '" + etiqueta_02_campo.getText() + "'")) {
                mostrarMensaje(MSG_Usuario_ya_existe);

                //si no existe ese nombre y apellido    
            } else {

                crearUsuarioNuevo();

                insertNuevoUsuario1();

                //si el los inserts anteriores han funcionado
                if (validarOperacionSQL) {
                    insertNuevoUsuario2();
                }

                //si el los inserts anteriores han funcionado
                if (validarOperacionSQL) {
                    insertNuevoUsuario3();
                }
                
                //si el los inserts anteriores han funcionado
                if (validarOperacionSQL) {
                    insertNuevoUsuario4();
                }

                //si se han insertado bien los pasos anteriores
                if (validarOperacionSQL) {
                    mostrarMensaje(MSG_Usuario_creado_correctamente);

                } else {
                    mostrarMensaje(MSG_Operacion_SQL_Erronea);

                }
            }

        }

    }

    /**
     * validamos si ya existe ese usuario con nombre y apellido 
     * validamos si el campo no esta vacio y no es importante, si los campos tienen un patron bueno
     */
    public void validacionCamposUsuarioNuevoPatrones() {

        mensajeError = "";
        ///////////////////////////////
        // validacion de nombre
        //////////////////////////////
        if (etiqueta_01_campo.getText().isEmpty()) {
            validarCampos = false;
            mensajeError = "El nombre no puede estar vacio.";
        } else {
            if (!verificarPatron(etiqueta_01_campo.getText(),
                    Pattern.compile("^([a-zA-Z]{2,}\\s?([a-zA-Z]{2,})?)+$"), mat)) {
                validarCampos = false;
                mensajeError = "El nombre no esta escrito correctamente.";
            }
        }

        ///////////////////////////////
        // validacion de apellidos
        //////////////////////////////
        if (etiqueta_02_campo.getText().isEmpty()) {
            validarCampos = false;
            mensajeError = mensajeError + "\n" + "Los apellidos no pueden estar vacios.";
        } else {
            if (!verificarPatron(etiqueta_02_campo.getText(),
                    Pattern.compile("^([a-zA-Z]{2,}\\s?([a-zA-Z]{2,})?)+$"), mat)) {
                validarCampos = false;
                mensajeError = mensajeError + "\n" + "Los apellidos no estan escritos corrrectamente.";
            }
        }

        ////////////////////////////
        //validacion fecha nacimiento
        ////////////////////////////
        if (!etiqueta_03_campo.getText().isEmpty()) {
            if (!verificarPatron(etiqueta_03_campo.getText(),
                    Pattern.compile("^[0-3][0-9]/[0-1][0-9]/(i?)(19|20|21)\\d{2}$"), mat)) {
                validarCampos = false;
                mensajeError = mensajeError + "\n" + "La fecha de nacimiento no tiene el formato DD/MM/AAAA.";
            } else {
                fechaNacimiento = true;
            }
        }

        ////////////////////////////
        // validacion fecha inicio
        ///////////////////////////
        if (!etiqueta_05_campo.getText()
                .isEmpty() && !verificarPatron(etiqueta_05_campo.getText(),
                        Pattern.compile("^[0-3][0-9]/[0-1][0-9]/(i?)(19|20|21)\\d{2}$"), mat)) {
            validarCampos = false;
            mensajeError = mensajeError + "\n" + "La fecha de inicio no tiene el formato correcto (DD/MM/AAAA).";
        }

        ////////////////////////////
        // validacion fecha fin
        ///////////////////////////
        if (!etiqueta_06_campo.getText()
                .isEmpty() && !verificarPatron(etiqueta_06_campo.getText(),
                        Pattern.compile("^[0-3][0-9]/[0-1][0-9]/(i?)(19|20|21)\\d{2}$"), mat)) {
            validarCampos = false;
            mensajeError = mensajeError + "\n" + "La fecha de fin no tiene el formato correcto(DD/MM/AAAA).";
        }

        ///////////////////////////
        // validacion DNI
        //////////////////////////
        if (!etiqueta_09_campo.getText()
                .isEmpty() && !verificarPatron(etiqueta_09_campo.getText(),
                        Pattern.compile("^\\d{8}[a-zA-Z]$"), mat)) {
            validarCampos = false;
            mensajeError = mensajeError + "\n" + "El DNI no esta escrito corrrectamente.";
        }
        ////////////////////////
        // validacion telefono
        ///////////////////////

        if (!etiqueta_14_campo.getText()
                .isEmpty() && !verificarPatron(etiqueta_14_campo.getText(),
                        Pattern.compile("^[0-9]{9}$"), mat)) {
            validarCampos = false;
            mensajeError = mensajeError + "\n" + "El telefono no esta escrito corrrectamente.";
        }
        //////////////////////
        // validacion cp
        //////////////////////

        if (!etiqueta_12_campo.getText()
                .isEmpty() && !verificarPatron(etiqueta_12_campo.getText(),
                        Pattern.compile("^[0-9]{5}$"), mat)) {
            validarCampos = false;
            mensajeError = mensajeError + "\n" + "El codogo postal no está escrito corrrectamente.";
        }
        /////////////////////////
        // validacion Email
        ////////////////////////

        if (!etiqueta_13_campo.getText()
                .isEmpty() && !verificarPatron(etiqueta_13_campo.getText(),
                        Pattern.compile("[^@]+@[^@]+\\.[a-zA-Z]"), mat)) {
            validarCampos = false;
            mensajeError = mensajeError + "\n" + "El email no está escrito correctamente.";
        }

    }

    /**
     * inserta telefono, email, ciudad y cp
     * despues si el campo no esta vacio, recupera el id
     */
    public void insertNuevoUsuario1() {
        Sentencia_SQL_nuevo_usuario = "";

        usuarioNuevo.setIdCp(
                validarCampo(etiqueta_12_campo.getText(),
                        "select id from datos_cp where cp = '" + etiqueta_12_campo.getText() + "'",
                        "INSERT INTO DATOS_CP (cp) VALUES ('" + etiqueta_12_campo.getText() + "');"
                ));

        usuarioNuevo.setIdCiudad(
                validarCampo(etiqueta_11_campo.getText(),
                        "select id from datos_ciudad where ciudad = '" + etiqueta_11_campo.getText() + "'",
                        "INSERT INTO DATOS_CIUDAD (ciudad) VALUES ('" + etiqueta_11_campo.getText() + "');"
                ));

        usuarioNuevo.setIdEmail(
                validarCampo(etiqueta_13_campo.getText(),
                        "select id from datos_email where email = '" + etiqueta_13_campo.getText() + "'",
                        "INSERT INTO DATOS_EMAIL (email) VALUES ('" + etiqueta_13_campo.getText() + "');"
                ));

        usuarioNuevo.setIdTelefono(
                validarCampo(etiqueta_14_campo.getText(),
                        "select id from datos_telefono where telefono = '" + etiqueta_14_campo.getText() + "'",
                        "INSERT INTO DATOS_TELEFONO (telefono) VALUES ('" + etiqueta_14_campo.getText() + "');"
                ));

        if (VentanaPrincipal.ejecutarSQL(Sentencia_SQL_nuevo_usuario).equals("insertado")) {
            System.out.println("se ha insertado1: " + Sentencia_SQL_nuevo_usuario);
            if (usuarioNuevo.getIdCp().isEmpty()) {
                usuarioNuevo.setIdCp(obtenerID("select id from datos_cp where cp = '" + etiqueta_12_campo.getText() + "'"));
            }
            System.out.println("USuario nuevo cp = " + usuarioNuevo.getIdCp());

            if (usuarioNuevo.getIdCiudad().isEmpty()) {
                usuarioNuevo.setIdCiudad(obtenerID("select id from datos_ciudad where ciudad = '" + etiqueta_11_campo.getText() + "'"));
            }
            System.out.println("USuario nuevo ciudad = " + usuarioNuevo.getIdCiudad());

            if (usuarioNuevo.getIdEmail().isEmpty()) {
                usuarioNuevo.setIdEmail(obtenerID("select id from datos_email where email = '" + etiqueta_13_campo.getText() + "'"));
            }
            System.out.println("USuario nuevo email = " + usuarioNuevo.getIdEmail());

            if (usuarioNuevo.getIdTelefono().isEmpty()) {
                usuarioNuevo.setIdTelefono(obtenerID("select id from datos_telefono where telefono = '" + etiqueta_14_campo.getText() + "'"));
            }
            System.out.println("USuario nuevo telefono2 = " + usuarioNuevo.getIdTelefono());

        } else {
            System.out.println("ha fallado 1" + Sentencia_SQL_nuevo_usuario);
            validarOperacionSQL = false;
        }

    }
    
    
    

    /**
     * inserta direccion
     * despues si el campo no esta vacio, recupera el id
     */
    public void insertNuevoUsuario2() {
        Sentencia_SQL_nuevo_usuario = "";

        usuarioNuevo.setIdDireccion(
                validarCampo(etiqueta_10_campo.getText(),
                        "select id from datos_direccion where direccion = '" + etiqueta_10_campo.getText() + "' "
                        + " and id_ciudad = " + usuarioNuevo.getIdCiudad()
                        + " and id_cp = " + usuarioNuevo.getIdCp(),
                        "INSERT INTO DATOS_DIRECCION (direccion, id_ciudad, id_cp) "
                        + "VALUES ('" + etiqueta_10_campo.getText() + "', "
                        + usuarioNuevo.getIdCiudad() + ", "
                        + usuarioNuevo.getIdCp() + ");"
                ));
//
        if (VentanaPrincipal.ejecutarSQL(Sentencia_SQL_nuevo_usuario).equals("insertado")) {
            System.out.println("se ha insertado2: " + Sentencia_SQL_nuevo_usuario);
            if (usuarioNuevo.getIdDireccion().isEmpty()) {

                String ciudad = "";
                String cp = "";
                if (usuarioNuevo.getIdCiudad().equals("null")) {
                    ciudad = "is null";
                } else {
                    ciudad = " = " + usuarioNuevo.getIdCiudad();
                }
                if (usuarioNuevo.getIdCp().equals("null")) {
                    cp = "is null";
                } else {
                    cp = " = " + usuarioNuevo.getIdCp();
                }
                usuarioNuevo.setIdDireccion(obtenerID("select id from datos_direccion where direccion = '"
                        + etiqueta_10_campo.getText() + "' "
                        + " and id_ciudad " + ciudad
                        + " and id_cp " + cp));
            }
            System.out.println("USuario nuevo DIRECCION = " + usuarioNuevo.getDireccion());

        } else {
            System.out.println("ha fallado 2" + Sentencia_SQL_nuevo_usuario);
            validarOperacionSQL = false;
        }

    }

    /**
     * inserta datos
     * despues si el campo no esta vacio, recupera el id
     */
    public void insertNuevoUsuario3() {
        Sentencia_SQL_nuevo_usuario = "";

        usuarioNuevo.setIdDatos(
                validarCampo("aaa",
                        "select nombre from datos where apellidos = 'nunca va a existir 777'",
                        "INSERT INTO DATOS (nombre, apellidos, dni, id_direccion,id_telefono, id_email) "
                        + "VALUES ('" + etiqueta_01_campo.getText() + "', "
                        + "'" + etiqueta_02_campo.getText() + "', "
                        + "'" + etiqueta_09_campo.getText() + "', "
                        + "" + usuarioNuevo.getIdDireccion() + ", "
                        + "" + usuarioNuevo.getIdTelefono() + ", "
                        + "" + usuarioNuevo.getIdEmail()
                        + ");"
                ));

        if (VentanaPrincipal.ejecutarSQL(Sentencia_SQL_nuevo_usuario).equals("insertado")) {
            System.out.println("se ha insertado3: " + Sentencia_SQL_nuevo_usuario);

            if (usuarioNuevo.getIdDatos().isEmpty()) {
                usuarioNuevo.setIdDatos(obtenerID("select id from datos "
                        + "where nombre =  '" + etiqueta_01_campo.getText() + "' "
                        + "and apellidos = '" + etiqueta_02_campo.getText() + "'"));
            }
            System.out.println("USuario nuevo DATOS = " + usuarioNuevo.getIdDatos());

        } else {
            System.out.println("ha fallado 3" + Sentencia_SQL_nuevo_usuario);
            validarOperacionSQL = false;
        }
    }

    /**
     * inserta el usuario
     * 
     */
    public void insertNuevoUsuario4() {
        Sentencia_SQL_nuevo_usuario = "";
        
        //para que no falle el insert, si no hay datos lo transformamos a null
        String a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;
        if (usuarioNuevo.getFechaNacimiento().isEmpty()) {
            a1 = "null";
        } else {
            a1 = "'" + usuarioNuevo.getFechaNacimiento() + "'";
        }
        if (usuarioNuevo.getFechaInicio().isEmpty()) {
            a2 = "null";
        } else {
            a2 = "'" + usuarioNuevo.getFechaInicio() + "'";
        }
        if (usuarioNuevo.getFechaFin().isEmpty()) {
            a3 = "null";
        } else {
            a3 = "'" + usuarioNuevo.getFechaFin() + "'";
        }

        if (usuarioNuevo.getSesionesSemanales().isEmpty()) {
            a5 = "null";
        } else {
            a5 = "'" + usuarioNuevo.getSesionesSemanales() + "'";
        }
        if (usuarioNuevo.getGradoDiscapacidad().isEmpty()) {
            a6 = "null";
        } else {
            a6 = "'" + usuarioNuevo.getGradoDiscapacidad() + "'";
        }
        if (usuarioNuevo.getDiagnostico().isEmpty()) {
            a7 = "null";
        } else {
            a7 = "'" + usuarioNuevo.getDiagnostico() + "'";

        }
        if (usuarioNuevo.getMotivoConsulta().isEmpty()) {
            a8 = "null";
        } else {
            a8 = "'" + usuarioNuevo.getMotivoConsulta() + "'";

        }
        if (usuarioNuevo.getObjetivos().isEmpty()) {
            a9 = "null";
        } else {
            a9 = "'" + usuarioNuevo.getObjetivos() + "'";

        }
        if (usuarioNuevo.getObservaciones().isEmpty()) {
            a10 = "null";
        } else {
            a10 = "'" + usuarioNuevo.getObservaciones() + "'";

        }

        usuarioNuevo.setId(
                validarCampo("aaa",
                        "select nombre from datos where apellidos = 'nunca va a existir 777'",
                        "INSERT INTO USUARIO "
                        + "(ACTIVO, "
                        + "ID_EMPLEADO, "
                        + "ID_DATOS, "
                        + "F_NACIMIENTO, "
                        + "FECHA_INICIO, "
                        + "FECHA_FIN, "
                        + "ID_DATOS_FACTURACION, "
                        + "SESIONES_SEMANALES, "
                        + "GRADO_DISCAPACIDAD, "
                        + "DIAGNOSTICO, "
                        + "MOTIVO_CONSULTA, "
                        + "OBJETIVOS, "
                        + "OBSERVACIONES) "
                        + "VALUES ("
                        + usuarioNuevo.getActivo() + ", "
                        + usuarioNuevo.getIdEmpleado() + ", "
                        + usuarioNuevo.getIdDatos() + ", "
                        + a1 + ", "
                        + a2 + ", "
                        + a3 + ", "
                        + usuarioNuevo.getIdDatosFacturacion() + ", "
                        + a5 + ", "
                        + a6 + ", "
                        + a7 + ", "
                        + a8 + ", "
                        + a9 + ", "
                        + a10 + ");"
                ));

        if (VentanaPrincipal.ejecutarSQL(Sentencia_SQL_nuevo_usuario).equals("insertado")) {
            System.out.println("se ha insertado4: " + Sentencia_SQL_nuevo_usuario);

            if (usuarioNuevo.getIdDatos().isEmpty()) {
                usuarioNuevo.setId(obtenerID("select id from datos "
                        + "where nombre =  '" + etiqueta_01_campo.getText() + "' "
                        + "and apellidos = '" + etiqueta_02_campo.getText() + "'"));
            }
            System.out.println("USuario nuevo DATOS = " + usuarioNuevo.getIdDatos());

        } else {
            System.out.println("ha fallado 4" + Sentencia_SQL_nuevo_usuario);
            validarOperacionSQL = false;
        }
    }

    
    /**
     * valida si existe el campo con esos datos
     * si no existe crea un string de la sentencia sql y nos lo devuelve
     * @param campo
     * @param consulta
     * @param insert
     * @return 
     */
    public String validarCampo(String campo, String consulta, String insert) {
        cpRes = "";
        if (!campo.equals("")) {
            if (VentanaPrincipal.consultaSQL2(consulta).equals("no existe")) {
                cpBoolean = false;
                Sentencia_SQL_nuevo_usuario = Sentencia_SQL_nuevo_usuario + "\n" + insert;

            } else {
                cpRes = VentanaPrincipal.consultaSQL2(consulta);
            }

        } else {
            cpRes = "null";
        }
        return cpRes;

    }

    
    /**
     * obtiene el id
     * @param consulta
     * @return 
     */
    public String obtenerID(String consulta) {
        String resultado = VentanaPrincipal.consultaSQL2(consulta);
        if (resultado.equals("no existe")) {
            resultado = "null";
        }
        return resultado;

    }

    /**
     * muestra mensaje por pantalla
     * @param mensaje lo que queremos mostrar por pantalla
     */
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Información del sistema",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiqueta_01 = new javax.swing.JLabel();
        etiqueta_01_campo = new javax.swing.JTextField();
        etiqueta_02 = new javax.swing.JLabel();
        etiqueta_02_campo = new javax.swing.JTextField();
        etiqueta_03 = new javax.swing.JLabel();
        etiqueta_03_campo = new javax.swing.JFormattedTextField();
        etiqueta_04 = new javax.swing.JLabel();
        etiqueta_04_campo = new javax.swing.JTextField();
        etiqueta_05 = new javax.swing.JLabel();
        etiqueta_05_campo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        etiqueta_06 = new javax.swing.JLabel();
        etiqueta_06_campo = new javax.swing.JTextField();
        etiqueta_07 = new javax.swing.JLabel();
        etiqueta_07_campo = new javax.swing.JTextField();
        etiqueta_08 = new javax.swing.JLabel();
        etiqueta_08_campo = new javax.swing.JTextField();
        etiqueta_20 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        etiqueta_20_campo = new javax.swing.JTextPane();
        etiqueta_21 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        etiqueta_21_campo = new javax.swing.JTextPane();
        etiqueta_22 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        etiqueta_22_campo = new javax.swing.JTextPane();
        boton_01 = new javax.swing.JButton();
        boton_02 = new javax.swing.JButton();
        etiqueta_23 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        etiqueta_23_campo = new javax.swing.JTextPane();
        etiqueta_10 = new javax.swing.JLabel();
        etiqueta_10_campo = new javax.swing.JTextField();
        etiqueta_11 = new javax.swing.JLabel();
        etiqueta_11_campo = new javax.swing.JFormattedTextField();
        etiqueta_12 = new javax.swing.JLabel();
        etiqueta_12_campo = new javax.swing.JTextField();
        etiqueta_09 = new javax.swing.JLabel();
        etiqueta_09_campo = new javax.swing.JTextField();
        etiqueta_13 = new javax.swing.JLabel();
        etiqueta_13_campo = new javax.swing.JTextField();
        etiqueta_14 = new javax.swing.JLabel();
        etiqueta_14_campo = new javax.swing.JTextField();
        boton_03 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMaximumSize(new java.awt.Dimension(900, 710));
        setPreferredSize(new java.awt.Dimension(900, 710));

        etiqueta_01.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        etiqueta_01.setText("etiqueta_01");

        etiqueta_01_campo.setDisabledTextColor(java.awt.Color.blue);

        etiqueta_02.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        etiqueta_02.setText("etiqueta_02");

        etiqueta_02_campo.setText(" ");
        etiqueta_02_campo.setDisabledTextColor(java.awt.Color.blue);

        etiqueta_03.setText("etiqueta_03");

        etiqueta_03_campo.setText(" ");
        etiqueta_03_campo.setDisabledTextColor(java.awt.Color.blue);

        etiqueta_04.setText("etiqueta_04");

        etiqueta_04_campo.setText(" ");
        etiqueta_04_campo.setDisabledTextColor(java.awt.Color.blue);

        etiqueta_05.setText("etiqueta_05");

        etiqueta_05_campo.setText(" ");
        etiqueta_05_campo.setDisabledTextColor(java.awt.Color.blue);

        etiqueta_06.setText("etiqueta_06");

        etiqueta_06_campo.setText(" ");
        etiqueta_06_campo.setDisabledTextColor(java.awt.Color.blue);
        etiqueta_06_campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etiqueta_06_campoActionPerformed(evt);
            }
        });

        etiqueta_07.setText("etiqueta_07");

        etiqueta_07_campo.setText(" ");
        etiqueta_07_campo.setDisabledTextColor(java.awt.Color.blue);

        etiqueta_08.setText("etiqueta_08");

        etiqueta_08_campo.setText(" ");
        etiqueta_08_campo.setDisabledTextColor(java.awt.Color.blue);

        etiqueta_20.setText("etiqueta_20");

        etiqueta_20_campo.setDisabledTextColor(java.awt.Color.blue);
        jScrollPane20.setViewportView(etiqueta_20_campo);

        etiqueta_21.setText("etiqueta_21");

        etiqueta_21_campo.setDisabledTextColor(java.awt.Color.blue);
        jScrollPane21.setViewportView(etiqueta_21_campo);

        etiqueta_22.setText("etiqueta_22");

        etiqueta_22_campo.setDisabledTextColor(java.awt.Color.blue);
        jScrollPane22.setViewportView(etiqueta_22_campo);

        boton_01.setText("boton_01");
        boton_01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_01ActionPerformed(evt);
            }
        });

        boton_02.setText("boton_02");
        boton_02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_02ActionPerformed(evt);
            }
        });

        etiqueta_23.setText("etiqueta_23");

        etiqueta_23_campo.setDisabledTextColor(java.awt.Color.blue);
        jScrollPane23.setViewportView(etiqueta_23_campo);

        etiqueta_10.setText("etiqueta_10");

        etiqueta_10_campo.setText(" ");
        etiqueta_10_campo.setDisabledTextColor(java.awt.Color.blue);

        etiqueta_11.setText("etiqueta_11");

        etiqueta_11_campo.setText(" ");
        etiqueta_11_campo.setDisabledTextColor(java.awt.Color.blue);

        etiqueta_12.setText("etiqueta_12");

        etiqueta_12_campo.setText(" ");
        etiqueta_12_campo.setDisabledTextColor(java.awt.Color.blue);

        etiqueta_09.setText("etiqueta_09");

        etiqueta_09_campo.setDisabledTextColor(java.awt.Color.blue);

        etiqueta_13.setText("etiqueta_13");

        etiqueta_13_campo.setText(" ");
        etiqueta_13_campo.setDisabledTextColor(java.awt.Color.blue);

        etiqueta_14.setText("etiqueta_14");

        etiqueta_14_campo.setText(" ");
        etiqueta_14_campo.setDisabledTextColor(java.awt.Color.blue);

        boton_03.setText("boton_03");
        boton_03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_03ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(etiqueta_22, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                    .addComponent(etiqueta_21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(etiqueta_20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(etiqueta_07, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(etiqueta_23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(etiqueta_07_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                                        .addComponent(etiqueta_08, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(etiqueta_08_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane23)
                                    .addComponent(jScrollPane22)
                                    .addComponent(jScrollPane21)
                                    .addComponent(jScrollPane20, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boton_03)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(boton_02)
                                .addGap(49, 49, 49)
                                .addComponent(boton_01))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiqueta_01, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etiqueta_02)
                                    .addComponent(etiqueta_03)
                                    .addComponent(etiqueta_05)
                                    .addComponent(etiqueta_09, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(etiqueta_02_campo, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(etiqueta_05_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(etiqueta_06)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(etiqueta_06_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(etiqueta_01_campo))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(etiqueta_03_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(etiqueta_04)
                                                .addGap(18, 18, 18)
                                                .addComponent(etiqueta_04_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(etiqueta_10)
                                                    .addComponent(etiqueta_11)
                                                    .addComponent(etiqueta_12)
                                                    .addComponent(etiqueta_13, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(17, 17, 17))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(etiqueta_14)
                                                .addGap(18, 18, 18))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(etiqueta_09_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(etiqueta_14_campo)
                                    .addComponent(etiqueta_10_campo, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                                    .addComponent(etiqueta_11_campo)
                                    .addComponent(etiqueta_12_campo)
                                    .addComponent(etiqueta_13_campo, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiqueta_01)
                            .addComponent(etiqueta_01_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiqueta_02_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiqueta_02))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiqueta_03_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiqueta_03)
                            .addComponent(etiqueta_04)
                            .addComponent(etiqueta_04_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiqueta_05_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiqueta_05)
                            .addComponent(etiqueta_06_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiqueta_06)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiqueta_14_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiqueta_14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiqueta_10_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiqueta_10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiqueta_11_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiqueta_11))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiqueta_12_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiqueta_12))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_09_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqueta_09)
                    .addComponent(etiqueta_13_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqueta_13))
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_08)
                    .addComponent(etiqueta_07)
                    .addComponent(etiqueta_07_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqueta_08_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiqueta_20)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etiqueta_23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(boton_01)
                                    .addComponent(boton_02)
                                    .addComponent(boton_03)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiqueta_22)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiqueta_21)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void etiqueta_06_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etiqueta_06_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etiqueta_06_campoActionPerformed

    private void boton_01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_01ActionPerformed

        switch (estado) {
            //modo edicion
            case texto_estado_editar:
                setEstadoVista();

                pintarDatos();
                break;

            //modo vista    
            case texto_estado_vista:

                setEstadoEditar();

                break;

            //modo nuevo    
            case texto_estado_nuevo:
                setEstadoVista();
                break;

        }


    }//GEN-LAST:event_boton_01ActionPerformed

    private void boton_02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_02ActionPerformed

        datosValidos = false;

        validarUsuarioNuevo();

        if (estado.equals(texto_Editar)) {
            crearUsuarioModificado();

        }

        if (estado.equals(texto_Nuevo)) {
            crearUsuarioNuevo();

        }

        if (VentanaPrincipal.consultaSQL("select * from usuario where id=1")) {
            System.out.println("existe");
        } else {
            System.out.println("No existe");
        }

        if (datosValidos) {
            mostrarMensaje(MSG_Usuario_modificado_correctamente);

        }

        //no es cancelar
        setEstadoVista();

        //2. si es fallida

    }//GEN-LAST:event_boton_02ActionPerformed

    private void boton_03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_03ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_03ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_01;
    private javax.swing.JButton boton_02;
    private javax.swing.JButton boton_03;
    private javax.swing.JLabel etiqueta_01;
    private javax.swing.JTextField etiqueta_01_campo;
    private javax.swing.JLabel etiqueta_02;
    private javax.swing.JTextField etiqueta_02_campo;
    private javax.swing.JLabel etiqueta_03;
    private javax.swing.JFormattedTextField etiqueta_03_campo;
    private javax.swing.JLabel etiqueta_04;
    private javax.swing.JTextField etiqueta_04_campo;
    private javax.swing.JLabel etiqueta_05;
    private javax.swing.JTextField etiqueta_05_campo;
    private javax.swing.JLabel etiqueta_06;
    private javax.swing.JTextField etiqueta_06_campo;
    private javax.swing.JLabel etiqueta_07;
    private javax.swing.JTextField etiqueta_07_campo;
    private javax.swing.JLabel etiqueta_08;
    private javax.swing.JTextField etiqueta_08_campo;
    private javax.swing.JLabel etiqueta_09;
    private javax.swing.JTextField etiqueta_09_campo;
    private javax.swing.JLabel etiqueta_10;
    private javax.swing.JTextField etiqueta_10_campo;
    private javax.swing.JLabel etiqueta_11;
    private javax.swing.JFormattedTextField etiqueta_11_campo;
    private javax.swing.JLabel etiqueta_12;
    private javax.swing.JTextField etiqueta_12_campo;
    private javax.swing.JLabel etiqueta_13;
    private javax.swing.JTextField etiqueta_13_campo;
    private javax.swing.JLabel etiqueta_14;
    private javax.swing.JTextField etiqueta_14_campo;
    private javax.swing.JLabel etiqueta_20;
    private javax.swing.JTextPane etiqueta_20_campo;
    private javax.swing.JLabel etiqueta_21;
    private javax.swing.JTextPane etiqueta_21_campo;
    private javax.swing.JLabel etiqueta_22;
    private javax.swing.JTextPane etiqueta_22_campo;
    private javax.swing.JLabel etiqueta_23;
    private javax.swing.JTextPane etiqueta_23_campo;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}

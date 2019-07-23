/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.*;
import Modelo.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Nacho
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private static ControlPrincipal controlador;

    private String estado;

    /**
     * Declaracion nombre botones
     */
    private final String Texto_Boton_00 = "Cerrar sesión";
    private final String Texto_Boton_01 = "Usuario";
    private final String Texto_Boton_02 = "Sesión";
    private final String Texto_Boton_03 = "Contactos";
    private final String Texto_Boton_04 = "Informes";
    private final String Texto_Boton_05 = "Agenda";
    private final String Texto_Boton_66 = "Administrar";
    private final String Texto_Boton_77 = "Opciones";
    private final String Texto_Boton_88 = "Login";
    private final String Texto_Boton_99 = "Salir";
    private final String Texto_Boton_Aux_01_Usuario = "Nuevo Usuario";
    private final String Texto_Boton_Aux_01_Contacto = "Nuevo Contacto";
    private final String Texto_Boton_Aux_01_Sesion = "Nueva Sesión";
    private final String Texto_Sin_Texto = " ";
    private final String Texto_CB_Inicio = "--- Selecciona un usuario ---";

    private ResultSet rsSesion;
    private ResultSet rsUsuario;
    private ResultSet rsContactos;
    private ResultSet rsOpcionesEmpleado;
    private ResultSet rsEmpresas;
    private ResultSet rsEmpleados;
    private static ResultSet rsConsulta;
    private static ResultSet rsEjecutar;

    private String aux = "";
    private String idUsuario;
    private String idEmpleado = "1";
    private String idEmpresa = "1";
    private static boolean existe;

    private JPanel logon;

    public VentanaPrincipal() {

        /**
         * obtenemos el controlador
         */
        controlador = ControlPrincipal.getInstanciaControl();

        initComponents();

        /**
         * Se pone el texto a los botones
         */
        boton_00.setText(Texto_Boton_00);
        boton_01.setText(Texto_Boton_01);
        boton_02.setText(Texto_Boton_02);
        boton_03.setText(Texto_Boton_03);
        boton_04.setText(Texto_Boton_04);
        boton_05.setText(Texto_Boton_05);
        boton_66.setText(Texto_Boton_66);
        boton_77.setText(Texto_Boton_77);
        boton_88.setText(Texto_Boton_88);
        boton_99.setText(Texto_Boton_99);
        boton_aux_01.setText(" ");

        jCBUsuario.removeAllItems();
        jCBUsuario.addItem(Texto_CB_Inicio);

        boton_aux_01.setEnabled(false);
        boton_00.setEnabled(false);
        boton_01.setEnabled(false);
        boton_02.setEnabled(false);
        boton_03.setEnabled(false);
        boton_04.setEnabled(false);
        boton_05.setEnabled(false);
        boton_66.setVisible(false);
        boton_77.setEnabled(false);
        jCBUsuario.setEnabled(false);

    }

    /**
     * pinta el checbox del usuario
     */
    public void pintarCheckbox() {

//        jCBUsuario.removeAllItems();
        jCBUsuario.addItem(Texto_CB_Inicio);
        try {

            rsUsuario = controlador.getConexion().getDatos(""
                    + "select "
                    + "USUARIO.ID,"
                    + "DATOS.NOMBRE,"
                    + "DATOS.APELLIDOS "
                    + "from USUARIO "
                    + "INNER JOIN DATOS ON USUARIO.ID_DATOS = DATOS.ID"
                    + " where id_empleado= " + idEmpleado
                    + " and activo = 1");

            while (rsUsuario.next()) {
                jCBUsuario.addItem(rsUsuario.getString(1) + ". " + rsUsuario.getString(2) + " " + rsUsuario.getString(3));

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    /**
     * pintamos el estado actual en la ventana
     *
     * @param estado depende del estado nos traemos un jpanel u otro
     */
    public void setEstado(String estado) {

        switch (estado) {
            case "usuario":
                boton_aux_01.setText(Texto_Boton_Aux_01_Usuario);
                boton_aux_01.setEnabled(true);
                jCBUsuario.setEnabled(true);
                panelPrincipal.removeAll();

                obtenerIDUsuario();

                System.out.println(idUsuario);

                try {

                    rsUsuario = controlador.getConexion().getDatos(""
                            + "SELECT                                                                                           \n"
                            + "usuario.id,                                                                              \n"
                            + "usuario.activo,                                                                          \n"
                            + "usuario.id_empleado,                                                                     \n"
                            + ""
                            + "(select nombre from datos where id= usuario.id_datos) as NOMBRE,                         \n"
                            + ""
                            + "(select apellidos from datos where id= usuario.id_datos) as APELLIDOS,                   \n"
                            + ""
                            + "(select dni from datos where id= usuario.id_datos) as DNI,                               \n"
                            + ""
                            + "(select direccion from datos_direccion where id=                                         \n"
                            + "		(select id_direccion from datos where id= usuario.id_datos)) as DIRECCION,      \n"
                            + ""
                            + "(select ciudad from datos_ciudad where id=                                               \n"
                            + "	(select id_ciudad from datos_direccion where id=                                        \n"
                            + "		(select id_direccion from datos where id= usuario.id_datos))) as CIUDAD,        \n"
                            + ""
                            + "(select cp from datos_cp where id=                                                       \n"
                            + "	(select id_cp from datos_direccion where id=                                            \n"
                            + "		(select id_direccion from datos where id= usuario.id_datos))) as CP,            \n"
                            + ""
                            + "usuario.f_Nacimiento,                                                                    \n"
                            + "usuario.fecha_Inicio,                                                                    \n"
                            + "usuario.fecha_Fin,                                                                       \n"
                            + "usuario.id_Datos_Facturacion,                                                            \n"
                            + "usuario.sesiones_Semanales,                                                              \n"
                            + "usuario.grado_Discapacidad,                                                              \n"
                            + "usuario.diagnostico,                                                                     \n"
                            + "usuario.motivo_Consulta,                                                                 \n"
                            + "usuario.objetivos,                                                                       \n"
                            + "usuario.observaciones,                                                                   \n"
                            + ""
                            + "(select	email from datos_email where id=                                                \n"
                            + "	(select id_email from datos where id = usuario.id_datos )) as EMAIL,                    \n"
                            + ""
                            + "(select	telefono from datos_telefono where id=                                          \n"
                            + "	(select id_telefono from datos where id= usuario.ID_DATOS ))as TELEFONO,                \n"
                            + ""
                            + "usuario.id_datos                                                                         \n"
                            + "from usuario                                                                             \n"
                            + " where usuario.id = " + idUsuario
                            + "       and usuario.activo=1");

                    controlador.getVentanaUsuarios().setDatos(rsUsuario);

                } catch (SQLException ex) {
                    Logger.getLogger(VSesion.class.getName()).log(Level.SEVERE, null, ex);
                }

                panelPrincipal.add(controlador.getVentanaUsuarios());
                pack();

                boton_01.setEnabled(false);
                boton_02.setEnabled(true);
                boton_03.setEnabled(true);
                boton_04.setEnabled(true);
                boton_05.setEnabled(true);

                panelPrincipal.repaint();
                repaint();
                break;

            case "sesion":
                boton_aux_01.setText(Texto_Boton_Aux_01_Sesion);
                boton_aux_01.setEnabled(true);
                jCBUsuario.setEnabled(true);
                panelPrincipal.removeAll();

                obtenerIDUsuario();

                System.out.println(idUsuario);

                try {
                    rsSesion = controlador.getConexion().getDatos(""
                            + "Select * from sesion "
                            + "where id_empleado=1 "
                            + "and id_usuario=" + idUsuario);

                    controlador.getVentanaSesion().setDatos(rsSesion);

                } catch (SQLException ex) {
                    Logger.getLogger(VSesion.class.getName()).log(Level.SEVERE, null, ex);
                }
                panelPrincipal.add(controlador.getVentanaSesion());
                pack();
                boton_01.setEnabled(true);
                boton_02.setEnabled(false);
                boton_03.setEnabled(true);
                boton_04.setEnabled(true);
                boton_05.setEnabled(true);
                panelPrincipal.repaint();
                repaint();
                break;

            case "contactos":
                boton_aux_01.setText(Texto_Boton_Aux_01_Contacto);
                boton_aux_01.setEnabled(true);
                jCBUsuario.setEnabled(true);
                panelPrincipal.removeAll();

                obtenerIDUsuario();

                System.out.println(idUsuario);

                try {
                    rsContactos = controlador.getConexion().getDatos(""
                            + "Select * from contactos_usuario "
                            + "where id_usuario_asociado=" + idUsuario);

                    controlador.getVentanaContactos().setDatos(rsContactos);

                } catch (SQLException ex) {
                    Logger.getLogger(VSesion.class.getName()).log(Level.SEVERE, null, ex);
                }
                panelPrincipal.add(controlador.getVentanaContactos());
                pack();

                boton_01.setEnabled(true);
                boton_02.setEnabled(true);
                boton_03.setEnabled(false);
                boton_04.setEnabled(true);
                boton_05.setEnabled(true);

                panelPrincipal.repaint();
                repaint();
                break;

            case "informes":
                boton_aux_01.setText(Texto_Sin_Texto);
                boton_aux_01.setEnabled(false);
                jCBUsuario.setEnabled(true);
                panelPrincipal.removeAll();
                panelPrincipal.add(controlador.getVentanaInformes());
                pack();

                boton_01.setEnabled(true);
                boton_02.setEnabled(true);
                boton_03.setEnabled(true);
                boton_04.setEnabled(false);
                boton_05.setEnabled(true);

                panelPrincipal.repaint();
                repaint();
                break;

            case "agenda":
                boton_aux_01.setText(Texto_Sin_Texto);
                boton_aux_01.setEnabled(false);
                jCBUsuario.setEnabled(true);
                panelPrincipal.removeAll();

                panelPrincipal.add(controlador.getVentanaAgenda());
                pack();

                boton_01.setEnabled(true);
                boton_02.setEnabled(true);
                boton_03.setEnabled(true);
                boton_04.setEnabled(true);
                boton_05.setEnabled(false);

                panelPrincipal.repaint();
                repaint();
                break;

            case "opcionesEmpleado":
                boton_aux_01.setText(Texto_Sin_Texto);
                boton_aux_01.setEnabled(false);
                jCBUsuario.setEnabled(false);
                panelPrincipal.removeAll();

                try {
                    rsOpcionesEmpleado = controlador.getConexion().getDatos(""
                            + "Select * from datos "
                            + "where id = "
                            + "(select id_datos from empleados "
                            + " where id = " + idEmpleado + " )");

                    System.out.println("datos obtenidos");

                    controlador.getVentanaOpcionesEmpleado().setDatos(rsOpcionesEmpleado);

                } catch (SQLException ex) {
                    Logger.getLogger(VSesion.class.getName()).log(Level.SEVERE, null, ex);
                }
                panelPrincipal.add(controlador.getVentanaOpcionesEmpleado());
                pack();

                boton_01.setEnabled(true);
                boton_02.setEnabled(true);
                boton_03.setEnabled(true);
                boton_04.setEnabled(true);
                boton_05.setEnabled(true);
                boton_66.setEnabled(false);
                boton_77.setEnabled(true);

                panelPrincipal.repaint();
                repaint();
                break;

            case "opcionesAdmin":
                boton_aux_01.setText(Texto_Sin_Texto);
                boton_aux_01.setEnabled(false);
                jCBUsuario.setEnabled(false);
                panelPrincipal.removeAll();

                try {
                    rsEmpresas = controlador.getConexion().getDatos(""
                            + "Select * from empresa");

                    controlador.getVentanaOpcionesAdmin().setDatos(rsEmpresas);

                    rsEmpleados = controlador.getConexion().getDatos(""
                            + "Select * from empleados ");

                    controlador.getVentanaOpcionesAdmin().setDatos2(rsEmpleados);

                } catch (SQLException ex) {
                    Logger.getLogger(VSesion.class.getName()).log(Level.SEVERE, null, ex);
                }
                panelPrincipal.add(controlador.getVentanaOpcionesAdmin());
                pack();

                boton_00.setEnabled(true);
                boton_01.setEnabled(false);
                boton_02.setEnabled(false);
                boton_03.setEnabled(false);
                boton_04.setEnabled(false);
                boton_05.setEnabled(false);
                boton_66.setEnabled(true);
                boton_77.setEnabled(false);

                panelPrincipal.repaint();
                repaint();
                break;

        }
    }

    /**
     * obtener el id del usuario desde el checkbox
     */
    public void obtenerIDUsuario() {

        aux = jCBUsuario.getSelectedItem().toString();
        String[] parts = aux.split("\\.");
        idUsuario = parts[0];
        System.out.println(idUsuario);

    }

    /**
     * verificamos si existen los datos en la consulta
     *
     * @param sql
     * @return
     */
    public static boolean consultaSQL(String sql) {
        existe = false;
        rsConsulta = null;

        try {
            rsConsulta = controlador.getConexion().getDatos(sql);

            if (rsConsulta.next()) {
                existe = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;

    }

    /**
     * verificamos si existen los datos en la consulta
     *
     * @param sql
     * @return
     */
    public static String consultaSQL2(String sql) {
        String res = "no existe";
        rsConsulta = null;

        try {
            rsConsulta = controlador.getConexion().getDatos(sql);

            if (rsConsulta.next()) {
                res = rsConsulta.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    
    /**
     * para insertar datos en la base de datos
     * @param sql
     * @return 
     */
    public static String ejecutarSQL(String sql) {
        String res = "no insertado";
        rsEjecutar = null;

        try {

            if (controlador.getConexion().insertar(sql)) {
                res = "insertado";
            }
        } catch (SQLException ex) {
            Logger.getLogger(VSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    /**
     * nos devuelve la conexion
     * @return 
     */
    public static Connection getConexion() {
        return controlador.getConexion().getConexion();
    }

    /**
     * muestra mensaje por pantalla
     * @param mensaje 
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

        boton_01 = new javax.swing.JButton();
        boton_02 = new javax.swing.JButton();
        boton_03 = new javax.swing.JButton();
        boton_04 = new javax.swing.JButton();
        jCBUsuario = new javax.swing.JComboBox<>();
        boton_aux_01 = new javax.swing.JButton();
        boton_66 = new javax.swing.JButton();
        boton_77 = new javax.swing.JButton();
        boton_99 = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTFUsuario = new javax.swing.JTextField();
        jTFContrasena = new javax.swing.JPasswordField();
        boton_88 = new javax.swing.JButton();
        boton_05 = new javax.swing.JButton();
        boton_00 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proyecto");
        setResizable(false);

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

        boton_03.setText("boton_03");
        boton_03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_03ActionPerformed(evt);
            }
        });

        boton_04.setText("boton_04");
        boton_04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_04ActionPerformed(evt);
            }
        });

        jCBUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCBUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCBUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBUsuarioActionPerformed(evt);
            }
        });

        boton_aux_01.setText("boton_aux_01");
        boton_aux_01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_aux_01ActionPerformed(evt);
            }
        });

        boton_66.setText("boton_66");
        boton_66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_66ActionPerformed(evt);
            }
        });

        boton_77.setText("boton_77");
        boton_77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_77ActionPerformed(evt);
            }
        });

        boton_99.setText("boton_99");
        boton_99.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_99ActionPerformed(evt);
            }
        });

        panelPrincipal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(1185, 677));

        jLabel1.setText("Usuario");

        jLabel2.setText("Contraseña");

        boton_88.setText("boton_88");
        boton_88.setToolTipText(" ");
        boton_88.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_88ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(365, 365, 365)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boton_88, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(jTFUsuario)
                    .addComponent(jTFContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                .addContainerGap(566, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(323, Short.MAX_VALUE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(boton_88)
                .addGap(249, 249, 249))
        );

        boton_05.setText("boton_05");
        boton_05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_05ActionPerformed(evt);
            }
        });

        boton_00.setText("boton_00");
        boton_00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_00ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(boton_01, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                        .addComponent(boton_02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boton_99, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boton_03, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(boton_04, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(boton_77, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_05, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(boton_66, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(boton_00, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCBUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(boton_aux_01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_aux_01)
                    .addComponent(boton_00))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boton_01)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boton_02)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boton_03)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boton_04)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boton_05)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boton_66)
                        .addGap(18, 18, 18)
                        .addComponent(boton_77)
                        .addGap(18, 18, 18)
                        .addComponent(boton_99))
                    .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Evento al pulsar el boton_01
     */
    private void boton_01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_01ActionPerformed
        estado = "usuario";
        setEstado(estado);


    }//GEN-LAST:event_boton_01ActionPerformed
    /**
     * Evento al pulsar el boton_02
     */
    private void boton_02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_02ActionPerformed
        estado = "sesion";
        setEstado(estado);


    }//GEN-LAST:event_boton_02ActionPerformed

    private void boton_aux_01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_aux_01ActionPerformed
        switch (estado) {
            case "usuario":
                panelPrincipal.removeAll();
                panelPrincipal.add(controlador.getVentanaUsuarios("Nuevo"));
                pack();
                panelPrincipal.repaint();
                repaint();
                break;

            case "contactos":
                panelPrincipal.removeAll();
                panelPrincipal.add(controlador.getVentanaContactos("Nuevo"));
                pack();
                panelPrincipal.repaint();
                repaint();
                break;

            case "sesion":
                panelPrincipal.removeAll();
                panelPrincipal.add(controlador.getVentanaSesion("Nuevo"));
                pack();
                panelPrincipal.repaint();
                repaint();
                break;

            case "agenda":
                panelPrincipal.removeAll();
                panelPrincipal.add(controlador.getVentanaAgenda());
                pack();
                panelPrincipal.repaint();
                repaint();
                break;

        }
    }//GEN-LAST:event_boton_aux_01ActionPerformed

    private void jCBUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBUsuarioActionPerformed

        if (jCBUsuario.getSelectedIndex() != 0) {

            boton_00.setEnabled(true);
            boton_01.setEnabled(true);
            boton_02.setEnabled(true);
            boton_03.setEnabled(true);
            boton_04.setEnabled(true);
            boton_05.setEnabled(true);

        }

        if (estado != null) {
            setEstado(estado);
        }


    }//GEN-LAST:event_jCBUsuarioActionPerformed

    private void boton_88ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_88ActionPerformed

        if (jTFUsuario.getText().equals("empleado")) {

            jCBUsuario.setEnabled(true);

            jCBUsuario.removeAllItems();

            pintarCheckbox();
            boton_00.setEnabled(true);
            boton_01.setEnabled(false);
            boton_02.setEnabled(false);
            boton_03.setEnabled(false);
            boton_04.setEnabled(false);
            boton_05.setEnabled(false);
            boton_77.setEnabled(true);

            panelPrincipal.removeAll();
            pack();
            panelPrincipal.repaint();
            repaint();

        } else if (jTFUsuario.getText().equals("admin")) {

            jCBUsuario.setEnabled(false);

            pintarCheckbox();

            boton_00.setEnabled(true);
            boton_01.setEnabled(false);
            boton_02.setEnabled(false);
            boton_03.setEnabled(false);
            boton_04.setEnabled(false);
            boton_05.setEnabled(false);

            boton_66.setVisible(true);
            boton_66.setEnabled(true);
            boton_77.setEnabled(false);

            panelPrincipal.removeAll();
            pack();
            panelPrincipal.repaint();
            repaint();
        } else {
            mostrarMensaje("Usuario no valido. \n"
                    + "Debe introducir empleado o admin");
        }


    }//GEN-LAST:event_boton_88ActionPerformed

    private void boton_99ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_99ActionPerformed
        controlador.getConexion().desconectar();

        System.exit(0);
    }//GEN-LAST:event_boton_99ActionPerformed

    private void boton_03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_03ActionPerformed
        estado = "contactos";
        setEstado(estado);


    }//GEN-LAST:event_boton_03ActionPerformed

    private void boton_04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_04ActionPerformed
        estado = "informes";
        setEstado(estado);

    }//GEN-LAST:event_boton_04ActionPerformed

    private void boton_77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_77ActionPerformed
        estado = "opcionesEmpleado";
        setEstado(estado);


    }//GEN-LAST:event_boton_77ActionPerformed

    private void boton_05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_05ActionPerformed
        estado = "agenda";
        setEstado(estado);

    }//GEN-LAST:event_boton_05ActionPerformed

    private void boton_66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_66ActionPerformed
        estado = "opcionesAdmin";
        setEstado(estado);

    }//GEN-LAST:event_boton_66ActionPerformed

    private void boton_00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_00ActionPerformed

        estado = null;

        panelPrincipal.removeAll();

        jCBUsuario.removeAllItems();
        jCBUsuario.addItem(Texto_CB_Inicio);

        boton_aux_01.setText(Texto_Sin_Texto);
        boton_aux_01.setEnabled(false);
        boton_00.setEnabled(false);
        boton_01.setEnabled(false);
        boton_02.setEnabled(false);
        boton_03.setEnabled(false);
        boton_04.setEnabled(false);
        boton_05.setEnabled(false);
        boton_66.setVisible(false);
        boton_77.setEnabled(false);
        jCBUsuario.setEnabled(false);

        panelPrincipal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(1185, 677));

        jLabel1.setText("Usuario");
        jTFUsuario.setText("");

        jLabel2.setText("Contraseña");
        jTFContrasena.setText("");

        boton_88.setText(Texto_Boton_88);
        boton_88.setToolTipText(" ");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
                panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGap(365, 365, 365)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(boton_88, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                        .addComponent(jTFUsuario)
                                        .addComponent(jTFContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                                .addContainerGap(566, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
                panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                                .addContainerGap(323, Short.MAX_VALUE)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTFContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(boton_88)
                                .addGap(249, 249, 249))
        );
        pack();
        panelPrincipal.repaint();
        repaint();    }//GEN-LAST:event_boton_00ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_00;
    private javax.swing.JButton boton_01;
    private javax.swing.JButton boton_02;
    private javax.swing.JButton boton_03;
    private javax.swing.JButton boton_04;
    private javax.swing.JButton boton_05;
    private javax.swing.JButton boton_66;
    private javax.swing.JButton boton_77;
    private javax.swing.JButton boton_88;
    private javax.swing.JButton boton_99;
    private javax.swing.JButton boton_aux_01;
    private javax.swing.JComboBox<String> jCBUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jTFContrasena;
    private javax.swing.JTextField jTFUsuario;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}

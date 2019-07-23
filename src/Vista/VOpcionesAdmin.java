/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Nacho
 */
public class VOpcionesAdmin extends javax.swing.JPanel {

    private final String texto_estado_vista = "vista";
    private final String texto_estado_editar = "editar";
    private final String texto_estado_nuevo = "nuevo";
    private final String texto_campo_vacio = "";
    private String estado = texto_estado_vista;

    //parte de datos
    private final String texto_etiqueta_00 = "-Empresa-";
    private final String texto_etiqueta_01 = "Nombre:   ";
    private final String texto_etiqueta_02 = "CIF:      ";
    private final String texto_etiqueta_03 = "Dirección: ";
    private final String texto_etiqueta_04 = "Ciudad:   ";
    private final String texto_etiqueta_05 = "CP:       ";
    private final String texto_etiqueta_06 = "Email:    ";
    private final String texto_etiqueta_07 = "Teléfono: ";

    private final String texto_etiqueta_10 = "-Empleado-";
    private final String texto_etiqueta_11 = "Nombre: ";
    private final String texto_etiqueta_12 = "Apellidos: ";
    private final String texto_etiqueta_13 = "DNI: ";
    private final String texto_etiqueta_14 = "Dirección: ";
    private final String texto_etiqueta_15 = "Ciudad: ";
    private final String texto_etiqueta_16 = "CP: ";
    private final String texto_etiqueta_17 = "Teléfono: ";
    private final String texto_etiqueta_18 = "Email: ";

    //parte de botones
    private final String texto_Crear = "Crear";
    private final String texto_Editar = "Editar";
    private final String texto_Guardar = "Guardar";
    private final String texto_Cancelar = "Cancelar";
    private final String texto_Borrar = "Borrar";

    //parte de mensajes
    private final String MSG_Usuario_modificado_correctamente
            = "El usuario ha sido modificado correctamente";

    
    private ResultSet rsEmpresas;
    private ResultSet rsEmpleados;
    /**
     * Creates new form vUsuarios
     */
    public VOpcionesAdmin() {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        setBounds(0, 0, 1185, 677);
        initComponents();


       
        etiqueta_00.setText(texto_etiqueta_00);
        etiqueta_01.setText(texto_etiqueta_01);
        etiqueta_02.setText(texto_etiqueta_02);
        etiqueta_03.setText(texto_etiqueta_03);
        etiqueta_04.setText(texto_etiqueta_04);
        etiqueta_05.setText(texto_etiqueta_05);
        etiqueta_06.setText(texto_etiqueta_06);
        etiqueta_07.setText(texto_etiqueta_07);

        etiqueta_10.setText(texto_etiqueta_10);
        etiqueta_11.setText(texto_etiqueta_11);
        etiqueta_12.setText(texto_etiqueta_12);
        etiqueta_13.setText(texto_etiqueta_13);
        etiqueta_14.setText(texto_etiqueta_14);
        etiqueta_15.setText(texto_etiqueta_15);
        etiqueta_16.setText(texto_etiqueta_16);
        etiqueta_17.setText(texto_etiqueta_17);
        etiqueta_18.setText(texto_etiqueta_18);

        boton_01.setText(texto_Crear);
        boton_02.setText(texto_Editar);
       // boton_02.setVisible(false);
        boton_03.setText(texto_Borrar);
        
        
        boton_04.setText(texto_Crear);
        boton_05.setText(texto_Editar);
        boton_06.setText(texto_Borrar);
        
     //   boton_05.setVisible(false);
        
        bloquearCampos();

    }

    public JPanel getVContactos() {
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
        
        etiqueta_11_campo.setEnabled(false);
        etiqueta_12_campo.setEnabled(false);
        etiqueta_13_campo.setEnabled(false);
        etiqueta_14_campo.setEnabled(false);
        etiqueta_15_campo.setEnabled(false);
        etiqueta_16_campo.setEnabled(false);
        etiqueta_17_campo.setEnabled(false);
        etiqueta_18_campo.setEnabled(false);
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
        etiqueta_11_campo.setEnabled(true);
        etiqueta_12_campo.setEnabled(true);
        etiqueta_13_campo.setEnabled(true);
        etiqueta_14_campo.setEnabled(true);
        etiqueta_15_campo.setEnabled(true);
        etiqueta_16_campo.setEnabled(true);
        etiqueta_17_campo.setEnabled(true);
        etiqueta_18_campo.setEnabled(true);
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
        etiqueta_11_campo.setText(texto_campo_vacio);
        etiqueta_12_campo.setText(texto_campo_vacio);
        etiqueta_13_campo.setText(texto_campo_vacio);
        etiqueta_14_campo.setText(texto_campo_vacio);
        etiqueta_15_campo.setText(texto_campo_vacio);
        etiqueta_16_campo.setText(texto_campo_vacio);
        etiqueta_17_campo.setText(texto_campo_vacio);
        etiqueta_18_campo.setText(texto_campo_vacio);
    }

//    public void setEstadoNuevo() {
//        desbloquearCampos();
//        limpiarCampos();
//        boton_04.setText(texto_Cancelar);
//        boton_05.setText(texto_Guardar);
//        boton_05.setVisible(true);
//        estado = texto_estado_nuevo;
//    }
//
//    public void setEstadoEditar() {
//        desbloquearCampos();
//        boton_04.setText(texto_Cancelar);
//        boton_05.setText(texto_Guardar);
//        boton_05.setVisible(true);
//        estado = texto_estado_editar;
//    }
//
//    public void setEstadoVista() {
//        bloquearCampos();
//        boton_04.setText(texto_Editar);
//        boton_05.setVisible(false);
//        estado = texto_estado_vista;
//    }
    
    public void setDatos(ResultSet Empresas) {
        rsEmpresas = Empresas;
        pintarDatos();
        
    }
    
    public void setDatos2(ResultSet Empleados) {
        rsEmpleados = Empleados;
        
        pintarDatos2();
    }

    public void pintarDatos() {

        try {
            jComboBox1.removeAllItems();
            
            etiqueta_01_campo.setText(rsEmpresas.getString(2));
            etiqueta_02_campo.setText(rsEmpresas.getString(3));
//            etiqueta_03_campo.setText(rsEmpresas.getString(3));
            etiqueta_03_campo.setText("CALLE CACERES, 52 ");
//            etiqueta_04_campo.setText(rsEmpresas.getString(4));
            etiqueta_04_campo.setText("CACERES");
//            etiqueta_05_campo.setText(rsEmpresas.getString(4));
            etiqueta_05_campo.setText("10001");
//            etiqueta_06_campo.setText(rsEmpresas.getString(4));
            etiqueta_06_campo.setText("612657812");
//            etiqueta_07_campo.setText(rsEmpresas.getString(4));
            etiqueta_07_campo.setText("GAIDE@GMAIL.COM");
            
            
            while (rsEmpresas.next()) {
                jComboBox1.addItem(rsEmpresas.getString(1) + ". " + rsEmpresas.getString(2) + " " + rsEmpresas.getString(3));

            }
            
            
            

        } catch (SQLException ex) {
            Logger.getLogger(VSesion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void pintarDatos2() {

        try {
            jComboBox2.removeAllItems();
            
            etiqueta_11_campo.setText(rsEmpleados.getString(1));
            etiqueta_12_campo.setText(rsEmpleados.getString(2));
            etiqueta_13_campo.setText(rsEmpleados.getString(3));
            etiqueta_14_campo.setText(rsEmpleados.getString(3));
            etiqueta_15_campo.setText(rsEmpleados.getString(3));
            etiqueta_16_campo.setText(rsEmpleados.getString(3));
            etiqueta_17_campo.setText(rsEmpleados.getString(3));
            etiqueta_18_campo.setText(rsEmpleados.getString(3));
            
            etiqueta_11_campo.setText("EMPLEADO1");
            etiqueta_12_campo.setText("EMPLEADO1");
            etiqueta_13_campo.setText("01234567A");
            etiqueta_14_campo.setText("CALLE CACERES, 52");
            etiqueta_15_campo.setText("CACERES");
            etiqueta_16_campo.setText("10001");
            etiqueta_17_campo.setText("612657812");
            etiqueta_18_campo.setText("EMPLEADO.UNO@GMAIL.COM");
            
            
            while (rsEmpleados.next()) {
//                jComboBox2.addItem(rsEmpleados.getString(1) + ". " + rsEmpleados.getString(2) + " " + rsEmpleados.getString(3));
                jComboBox2.addItem(rsEmpleados.getString(1) + ". " + "EMPLEADO"+ rsEmpleados.getString(1));

            }
            

        } catch (SQLException ex) {
            Logger.getLogger(VSesion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

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

        boton_04 = new javax.swing.JButton();
        boton_05 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        etiqueta_02 = new javax.swing.JLabel();
        etiqueta_02_campo = new javax.swing.JTextField();
        etiqueta_01 = new javax.swing.JLabel();
        etiqueta_01_campo = new javax.swing.JTextField();
        etiqueta_03 = new javax.swing.JLabel();
        etiqueta_03_campo = new javax.swing.JTextField();
        etiqueta_04 = new javax.swing.JLabel();
        etiqueta_04_campo = new javax.swing.JFormattedTextField();
        etiqueta_05 = new javax.swing.JLabel();
        etiqueta_05_campo = new javax.swing.JTextField();
        etiqueta_06 = new javax.swing.JLabel();
        etiqueta_06_campo = new javax.swing.JTextField();
        etiqueta_07 = new javax.swing.JLabel();
        etiqueta_07_campo = new javax.swing.JFormattedTextField();
        etiqueta_18_campo = new javax.swing.JTextField();
        etiqueta_13_campo = new javax.swing.JTextField();
        etiqueta_14 = new javax.swing.JLabel();
        etiqueta_14_campo = new javax.swing.JFormattedTextField();
        etiqueta_15 = new javax.swing.JLabel();
        etiqueta_15_campo = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        etiqueta_16 = new javax.swing.JLabel();
        etiqueta_12 = new javax.swing.JLabel();
        etiqueta_16_campo = new javax.swing.JTextField();
        etiqueta_12_campo = new javax.swing.JTextField();
        etiqueta_17 = new javax.swing.JLabel();
        etiqueta_11 = new javax.swing.JLabel();
        etiqueta_17_campo = new javax.swing.JFormattedTextField();
        etiqueta_11_campo = new javax.swing.JTextField();
        etiqueta_18 = new javax.swing.JLabel();
        etiqueta_13 = new javax.swing.JLabel();
        boton_01 = new javax.swing.JButton();
        boton_02 = new javax.swing.JButton();
        boton_03 = new javax.swing.JButton();
        boton_06 = new javax.swing.JButton();
        etiqueta_10 = new javax.swing.JLabel();
        etiqueta_00 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMaximumSize(new java.awt.Dimension(900, 710));
        setPreferredSize(new java.awt.Dimension(900, 710));

        boton_04.setText("boton_04");
        boton_04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_04ActionPerformed(evt);
            }
        });

        boton_05.setText("boton_05");
        boton_05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_05ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        etiqueta_02.setText("etiqueta_02");

        etiqueta_02_campo.setText(" ");
        etiqueta_02_campo.setDisabledTextColor(java.awt.Color.blue);
        etiqueta_02_campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etiqueta_02_campoActionPerformed(evt);
            }
        });

        etiqueta_01.setText("etiqueta_01");

        etiqueta_01_campo.setDisabledTextColor(java.awt.Color.blue);
        etiqueta_01_campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etiqueta_01_campoActionPerformed(evt);
            }
        });

        etiqueta_03.setText("etiqueta_03");

        etiqueta_03_campo.setText(" ");
        etiqueta_03_campo.setDisabledTextColor(java.awt.Color.blue);
        etiqueta_03_campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etiqueta_03_campoActionPerformed(evt);
            }
        });

        etiqueta_04.setText("etiqueta_04");

        etiqueta_04_campo.setText(" ");
        etiqueta_04_campo.setDisabledTextColor(java.awt.Color.blue);
        etiqueta_04_campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etiqueta_04_campoActionPerformed(evt);
            }
        });

        etiqueta_05.setText("etiqueta_05");

        etiqueta_05_campo.setDisabledTextColor(java.awt.Color.blue);
        etiqueta_05_campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etiqueta_05_campoActionPerformed(evt);
            }
        });

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
        etiqueta_07_campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etiqueta_07_campoActionPerformed(evt);
            }
        });

        etiqueta_18_campo.setText(" ");
        etiqueta_18_campo.setDisabledTextColor(java.awt.Color.blue);
        etiqueta_18_campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etiqueta_18_campoActionPerformed(evt);
            }
        });

        etiqueta_13_campo.setText(" ");
        etiqueta_13_campo.setDisabledTextColor(java.awt.Color.blue);
        etiqueta_13_campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etiqueta_13_campoActionPerformed(evt);
            }
        });

        etiqueta_14.setText("etiqueta_14");

        etiqueta_14_campo.setText(" ");
        etiqueta_14_campo.setDisabledTextColor(java.awt.Color.blue);

        etiqueta_15.setText("etiqueta_15");

        etiqueta_15_campo.setDisabledTextColor(java.awt.Color.blue);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        etiqueta_16.setText("etiqueta_16");

        etiqueta_12.setText("etiqueta_12");

        etiqueta_16_campo.setText(" ");
        etiqueta_16_campo.setDisabledTextColor(java.awt.Color.blue);
        etiqueta_16_campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etiqueta_16_campoActionPerformed(evt);
            }
        });

        etiqueta_12_campo.setText(" ");
        etiqueta_12_campo.setDisabledTextColor(java.awt.Color.blue);
        etiqueta_12_campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etiqueta_12_campoActionPerformed(evt);
            }
        });

        etiqueta_17.setText("etiqueta_17");

        etiqueta_11.setText("etiqueta_11");

        etiqueta_17_campo.setText(" ");
        etiqueta_17_campo.setDisabledTextColor(java.awt.Color.blue);

        etiqueta_11_campo.setDisabledTextColor(java.awt.Color.blue);
        etiqueta_11_campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etiqueta_11_campoActionPerformed(evt);
            }
        });

        etiqueta_18.setText("etiqueta_18");

        etiqueta_13.setText("etiqueta_13");

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

        boton_06.setText("boton_06");
        boton_06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_06ActionPerformed(evt);
            }
        });

        etiqueta_10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiqueta_10.setText("etiqueta_10");
        etiqueta_10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        etiqueta_00.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiqueta_00.setText("etiqueta_00");
        etiqueta_00.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(etiqueta_11)
                                    .addComponent(etiqueta_12)
                                    .addComponent(etiqueta_13)
                                    .addComponent(etiqueta_14)
                                    .addComponent(etiqueta_15)
                                    .addComponent(etiqueta_16)
                                    .addComponent(etiqueta_17)
                                    .addComponent(etiqueta_18))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(etiqueta_17_campo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                                    .addComponent(etiqueta_16_campo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiqueta_15_campo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiqueta_14_campo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiqueta_13_campo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiqueta_12_campo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiqueta_11_campo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiqueta_18_campo)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(etiqueta_07)
                                    .addGap(18, 18, 18)
                                    .addComponent(etiqueta_06_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(etiqueta_06)
                                    .addGap(18, 18, 18)
                                    .addComponent(etiqueta_07_campo))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(etiqueta_04)
                                        .addComponent(etiqueta_01)
                                        .addComponent(etiqueta_03))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(etiqueta_04_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(etiqueta_01_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(etiqueta_02)
                                                .addComponent(etiqueta_05))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(etiqueta_02_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(etiqueta_05_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(etiqueta_03_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boton_05, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_04, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_02, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_01, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_06, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etiqueta_10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etiqueta_00, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(263, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqueta_00))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiqueta_01_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiqueta_01)
                            .addComponent(etiqueta_02)
                            .addComponent(etiqueta_02_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiqueta_03_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiqueta_03))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiqueta_05_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiqueta_05)
                            .addComponent(etiqueta_04_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiqueta_04))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiqueta_06_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiqueta_07)
                            .addComponent(etiqueta_06)
                            .addComponent(etiqueta_07_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(boton_01)
                        .addGap(18, 18, 18)
                        .addComponent(boton_02)
                        .addGap(18, 18, 18)
                        .addComponent(boton_03)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiqueta_10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiqueta_11_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiqueta_11))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiqueta_12_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiqueta_12))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(etiqueta_13_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiqueta_13))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(boton_04)
                        .addGap(18, 18, 18)
                        .addComponent(boton_05)
                        .addGap(15, 15, 15)
                        .addComponent(boton_06)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_14_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqueta_14))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_15_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqueta_15))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_16_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqueta_16))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_17_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqueta_17))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_18_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqueta_18))
                .addContainerGap(87, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boton_04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_04ActionPerformed

        switch (estado) {
            //modo edicion
            case texto_estado_editar:
//                setEstadoVista();
                break;

            //modo vista    
            case texto_estado_vista:
//                setEstadoEditar();
                break;

            //modo nuevo    
            case texto_estado_nuevo:
//                setEstadoVista();
                break;

        }


    }//GEN-LAST:event_boton_04ActionPerformed

    private void boton_05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_05ActionPerformed

        

    }//GEN-LAST:event_boton_05ActionPerformed

    private void etiqueta_01_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etiqueta_01_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etiqueta_01_campoActionPerformed

    private void etiqueta_02_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etiqueta_02_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etiqueta_02_campoActionPerformed

    private void etiqueta_03_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etiqueta_03_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etiqueta_03_campoActionPerformed

    private void etiqueta_06_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etiqueta_06_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etiqueta_06_campoActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void etiqueta_18_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etiqueta_18_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etiqueta_18_campoActionPerformed

    private void etiqueta_13_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etiqueta_13_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etiqueta_13_campoActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        if (jComboBox2.getSelectedIndex()==1){
            etiqueta_11_campo.setText("EMPLEADO2");
            etiqueta_12_campo.setText("EMPLEADO2");
        } else {
            etiqueta_11_campo.setText("EMPLEADO1");
            etiqueta_12_campo.setText("EMPLEADO1");
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void etiqueta_16_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etiqueta_16_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etiqueta_16_campoActionPerformed

    private void etiqueta_12_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etiqueta_12_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etiqueta_12_campoActionPerformed

    private void etiqueta_11_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etiqueta_11_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etiqueta_11_campoActionPerformed

    private void etiqueta_05_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etiqueta_05_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etiqueta_05_campoActionPerformed

    private void etiqueta_04_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etiqueta_04_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etiqueta_04_campoActionPerformed

    private void etiqueta_07_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etiqueta_07_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etiqueta_07_campoActionPerformed

    private void boton_01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_01ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_01ActionPerformed

    private void boton_02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_02ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_02ActionPerformed

    private void boton_03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_03ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_03ActionPerformed

    private void boton_06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_06ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_06ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_01;
    private javax.swing.JButton boton_02;
    private javax.swing.JButton boton_03;
    private javax.swing.JButton boton_04;
    private javax.swing.JButton boton_05;
    private javax.swing.JButton boton_06;
    private javax.swing.JLabel etiqueta_00;
    private javax.swing.JLabel etiqueta_01;
    private javax.swing.JTextField etiqueta_01_campo;
    private javax.swing.JLabel etiqueta_02;
    private javax.swing.JTextField etiqueta_02_campo;
    private javax.swing.JLabel etiqueta_03;
    private javax.swing.JTextField etiqueta_03_campo;
    private javax.swing.JLabel etiqueta_04;
    private javax.swing.JFormattedTextField etiqueta_04_campo;
    private javax.swing.JLabel etiqueta_05;
    private javax.swing.JTextField etiqueta_05_campo;
    private javax.swing.JLabel etiqueta_06;
    private javax.swing.JTextField etiqueta_06_campo;
    private javax.swing.JLabel etiqueta_07;
    private javax.swing.JFormattedTextField etiqueta_07_campo;
    private javax.swing.JLabel etiqueta_10;
    private javax.swing.JLabel etiqueta_11;
    private javax.swing.JTextField etiqueta_11_campo;
    private javax.swing.JLabel etiqueta_12;
    private javax.swing.JTextField etiqueta_12_campo;
    private javax.swing.JLabel etiqueta_13;
    private javax.swing.JTextField etiqueta_13_campo;
    private javax.swing.JLabel etiqueta_14;
    private javax.swing.JFormattedTextField etiqueta_14_campo;
    private javax.swing.JLabel etiqueta_15;
    private javax.swing.JTextField etiqueta_15_campo;
    private javax.swing.JLabel etiqueta_16;
    private javax.swing.JTextField etiqueta_16_campo;
    private javax.swing.JLabel etiqueta_17;
    private javax.swing.JFormattedTextField etiqueta_17_campo;
    private javax.swing.JLabel etiqueta_18;
    private javax.swing.JTextField etiqueta_18_campo;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    // End of variables declaration//GEN-END:variables
}

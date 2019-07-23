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
public class VSesion extends javax.swing.JPanel {

    ResultSet rsSesiones;

    private final String texto_estado_vista = "vista";
    private final String texto_estado_editar = "editar";
    private final String texto_estado_nuevo = "nuevo";
    private final String texto_campo_vacio = "";
    private String estado = texto_estado_vista;

    private final String texto_etiqueta_01 = "Concepto: ";
    private final String texto_etiqueta_02 = "Fecha: ";
    private final String texto_etiqueta_03 = "Beca: ";
    private final String texto_etiqueta_04 = "Pagado: ";
    private final String texto_etiqueta_05 = "Observaciones: ";
    private final String texto_etiqueta_06 = "Hora: ";
    private final String texto_etiqueta_11 = "Objetivo 1: ";
    private final String texto_etiqueta_12 = "Objetivo 2: ";
    private final String texto_etiqueta_13 = "Objetivo 3: ";
    private final String texto_etiqueta_14 = "Objetivo 4: ";
    private final String texto_etiqueta_15 = "Objetivo 5: ";
    private final String texto_etiqueta_16 = "Objetivo 6: ";
    private final String texto_etiqueta_17 = "Objetivo 7: ";
    private final String texto_etiqueta_21 = "Actividad 1: ";
    private final String texto_etiqueta_22 = "Actividad 2: ";
    private final String texto_etiqueta_23 = "Actividad 3: ";
    private final String texto_etiqueta_24 = "Actividad 4: ";
    private final String texto_etiqueta_25 = "Actividad 5: ";
    private final String texto_etiqueta_26 = "Actividad 6: ";
    private final String texto_etiqueta_27 = "Actividad 7: ";
    private final String texto_etiqueta_31 = "Conclusión 1: ";
    private final String texto_etiqueta_32 = "Conclusión 2: ";
    private final String texto_etiqueta_33 = "Conclusión 3: ";
    private final String texto_etiqueta_34 = "Conclusión 4: ";
    private final String texto_etiqueta_35 = "Conclusión 5: ";
    private final String texto_etiqueta_36 = "Conclusión 6: ";
    private final String texto_etiqueta_37 = "Conclusión 7: ";
    private final String texto_etiqueta_indice = "Sesion 5 de 7";
    private final String Indice = "";

    //parte de botones
    private String texto_Editar = "Editar";
    private String texto_Guardar = "Guardar";
    private String texto_Cancelar = "Cancelar";
    private String texto_Borrar = "Borrar";

    //parte de mensajes
    private String MSG_Sesion_modificada_correctamente
            = "La sesióno ha sido modificada correctamente";

    public VSesion() {

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        setBounds(0, 0, 1185, 677);

        initComponents();

        etiqueta_01.setText(texto_etiqueta_01);
        etiqueta_02.setText(texto_etiqueta_02);

        etiqueta_03.setText(texto_etiqueta_03);
        etiqueta_04.setText(texto_etiqueta_04);

        etiqueta_05.setText(texto_etiqueta_05);
        etiqueta_06.setText(texto_etiqueta_06);

        etiqueta_11.setText(texto_etiqueta_11);
        etiqueta_12.setText(texto_etiqueta_12);
        etiqueta_13.setText(texto_etiqueta_13);
        etiqueta_14.setText(texto_etiqueta_14);

        etiqueta_21.setText(texto_etiqueta_21);
        etiqueta_22.setText(texto_etiqueta_22);
        etiqueta_23.setText(texto_etiqueta_23);
        etiqueta_24.setText(texto_etiqueta_24);

        etiqueta_31.setText(texto_etiqueta_31);
        etiqueta_32.setText(texto_etiqueta_32);
        etiqueta_33.setText(texto_etiqueta_33);
        etiqueta_34.setText(texto_etiqueta_34);

        boton_01.setText(texto_Editar);
        boton_02.setVisible(false);
        boton_02.setText(texto_Guardar);
        jLabelIndice.setText(texto_etiqueta_indice);

        bloquearCampos();

    }

  

    /**
     * Bloqueamos los campos para que no sean modificables
     */
    public void bloquearCampos() {

        etiqueta_01_campo.setEnabled(false);
        etiqueta_02_campo.setEnabled(false);
        etiqueta_03_campo_cb.setEnabled(false);
        etiqueta_04_campo_cb.setEnabled(false);

        etiqueta_11_campo.setEnabled(false);
        etiqueta_12_campo.setEnabled(false);
        etiqueta_13_campo.setEnabled(false);
        etiqueta_14_campo.setEnabled(false);

        etiqueta_21_campo.setEnabled(false);
        etiqueta_22_campo.setEnabled(false);
        etiqueta_23_campo.setEnabled(false);
        etiqueta_24_campo.setEnabled(false);

        etiqueta_31_campo.setEnabled(false);
        etiqueta_32_campo.setEnabled(false);
        etiqueta_33_campo.setEnabled(false);
        etiqueta_34_campo.setEnabled(false);

        etiqueta_05_campo.setEnabled(false);
        
        boton_03.setText(texto_Borrar);

    }

    /**
     * Desbloqueamos los campos para que sean modificables
     */
    public void desbloquearCampos() {

        etiqueta_01_campo.setEnabled(true);
        etiqueta_02_campo.setEnabled(true);
        etiqueta_03_campo_cb.setEnabled(true);
        etiqueta_04_campo_cb.setEnabled(true);

        etiqueta_11_campo.setEnabled(true);
        etiqueta_12_campo.setEnabled(true);
        etiqueta_13_campo.setEnabled(true);
        etiqueta_14_campo.setEnabled(true);

        etiqueta_21_campo.setEnabled(true);
        etiqueta_22_campo.setEnabled(true);
        etiqueta_23_campo.setEnabled(true);
        etiqueta_24_campo.setEnabled(true);

        etiqueta_31_campo.setEnabled(true);
        etiqueta_32_campo.setEnabled(true);
        etiqueta_33_campo.setEnabled(true);
        etiqueta_34_campo.setEnabled(true);

        etiqueta_05_campo.setEnabled(true);

    }

    /**
     * Limpia todos los campos
     */
    public void limpiarCampos() {

        etiqueta_01_campo.setText(texto_campo_vacio);
        etiqueta_02_campo.setText(texto_campo_vacio);
        etiqueta_03_campo_cb.setSelected(false);
        etiqueta_04_campo_cb.setSelected(false);

        etiqueta_11_campo.setText(texto_campo_vacio);
        etiqueta_12_campo.setText(texto_campo_vacio);
        etiqueta_13_campo.setText(texto_campo_vacio);
        etiqueta_14_campo.setText(texto_campo_vacio);

        etiqueta_21_campo.setText(texto_campo_vacio);
        etiqueta_22_campo.setText(texto_campo_vacio);
        etiqueta_23_campo.setText(texto_campo_vacio);
        etiqueta_24_campo.setText(texto_campo_vacio);

        etiqueta_31_campo.setText(texto_campo_vacio);
        etiqueta_32_campo.setText(texto_campo_vacio);
        etiqueta_33_campo.setText(texto_campo_vacio);
        etiqueta_34_campo.setText(texto_campo_vacio);

        etiqueta_05_campo.setText(texto_campo_vacio);

    }

    public void setEstadoNuevo() {
        desbloquearCampos();
        limpiarCampos();
        boton_01.setText(texto_Cancelar);
        boton_02.setText(texto_Guardar);
        boton_02.setVisible(true);
        estado = texto_estado_nuevo;
    }

    public void setEstadoEditar() {
        desbloquearCampos();
        boton_01.setText(texto_Cancelar);
        boton_02.setText(texto_Guardar);
        boton_02.setVisible(true);
        estado = texto_estado_editar;
    }

    public void setEstadoVista() {
        bloquearCampos();
        boton_01.setText(texto_Editar);
        boton_02.setVisible(false);
        estado = texto_estado_vista;
    }

    public void setDatos(ResultSet rs) {
        rsSesiones = rs;
        try {
            rsSesiones.next();

            System.out.println(rsSesiones.getRow());
        } catch (SQLException ex) {
            Logger.getLogger(VSesion.class.getName()).log(Level.SEVERE, null, ex);
        }

        pintarDatos();
    }

    public void pintarDatos() {

        try {
            etiqueta_01_campo.setText(rsSesiones.getString("CONCEPTO"));
            etiqueta_02_campo.setText(rsSesiones.getString("FECHA"));

            etiqueta_03_campo_cb.setSelected(false);
            etiqueta_04_campo_cb.setSelected(false);

            etiqueta_11_campo.setText(rsSesiones.getString("OBJETIVO_01"));
            etiqueta_12_campo.setText(rsSesiones.getString("OBJETIVO_02"));
            etiqueta_13_campo.setText(rsSesiones.getString("OBJETIVO_03"));
            etiqueta_14_campo.setText(rsSesiones.getString("OBJETIVO_04"));

            etiqueta_21_campo.setText(rsSesiones.getString("ACTIVIDAD_01"));
            etiqueta_22_campo.setText(rsSesiones.getString("ACTIVIDAD_02"));
            etiqueta_23_campo.setText(rsSesiones.getString("ACTIVIDAD_03"));
            etiqueta_24_campo.setText(rsSesiones.getString("ACTIVIDAD_04"));

            etiqueta_31_campo.setText(rsSesiones.getString("RESULTADO_01"));
            etiqueta_32_campo.setText(rsSesiones.getString("RESULTADO_02"));
            etiqueta_33_campo.setText(rsSesiones.getString("RESULTADO_03"));
            etiqueta_34_campo.setText(rsSesiones.getString("RESULTADO_04"));

            etiqueta_05_campo.setText(rsSesiones.getString("OBSERVACIONES"));
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

        boton_01 = new javax.swing.JButton();
        boton_02 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabelIndice = new javax.swing.JLabel();
        etiqueta_01 = new javax.swing.JLabel();
        etiqueta_01_campo = new javax.swing.JTextField();
        etiqueta_02 = new javax.swing.JLabel();
        etiqueta_02_campo = new javax.swing.JTextField();
        etiqueta_04 = new javax.swing.JLabel();
        etiqueta_03 = new javax.swing.JLabel();
        etiqueta_11 = new javax.swing.JLabel();
        etiqueta_03_campo_cb = new javax.swing.JCheckBox();
        etiqueta_04_campo_cb = new javax.swing.JCheckBox();
        etiqueta_21 = new javax.swing.JLabel();
        etiqueta_31 = new javax.swing.JLabel();
        etiqueta_22 = new javax.swing.JLabel();
        etiqueta_12 = new javax.swing.JLabel();
        etiqueta_32 = new javax.swing.JLabel();
        etiqueta_23 = new javax.swing.JLabel();
        etiqueta_13 = new javax.swing.JLabel();
        etiqueta_33 = new javax.swing.JLabel();
        etiqueta_24 = new javax.swing.JLabel();
        etiqueta_14 = new javax.swing.JLabel();
        etiqueta_34 = new javax.swing.JLabel();
        etiqueta_05 = new javax.swing.JLabel();
        jScrollPane05 = new javax.swing.JScrollPane();
        etiqueta_05_campo = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        etiqueta_11_campo = new javax.swing.JTextArea();
        jScrollPane21 = new javax.swing.JScrollPane();
        etiqueta_21_campo = new javax.swing.JTextArea();
        jScrollPane31 = new javax.swing.JScrollPane();
        etiqueta_31_campo = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        etiqueta_12_campo = new javax.swing.JTextArea();
        jScrollPane22 = new javax.swing.JScrollPane();
        etiqueta_22_campo = new javax.swing.JTextArea();
        jScrollPane32 = new javax.swing.JScrollPane();
        etiqueta_32_campo = new javax.swing.JTextArea();
        jScrollPane13 = new javax.swing.JScrollPane();
        etiqueta_13_campo = new javax.swing.JTextArea();
        jScrollPane23 = new javax.swing.JScrollPane();
        etiqueta_23_campo = new javax.swing.JTextArea();
        jScrollPane33 = new javax.swing.JScrollPane();
        etiqueta_33_campo = new javax.swing.JTextArea();
        jScrollPane14 = new javax.swing.JScrollPane();
        etiqueta_14_campo = new javax.swing.JTextArea();
        jScrollPane24 = new javax.swing.JScrollPane();
        etiqueta_24_campo = new javax.swing.JTextArea();
        jScrollPane34 = new javax.swing.JScrollPane();
        etiqueta_34_campo = new javax.swing.JTextArea();
        etiqueta_06 = new javax.swing.JLabel();
        etiqueta_06_campo = new javax.swing.JTextField();
        boton_03 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setToolTipText("Primera sesión");

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

        jButton3.setText("|<<");

        jButton4.setText("<");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText(">");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText(">>|");

        jLabelIndice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIndice.setText("jLabelIndice");

        etiqueta_01.setText("etiqueta_01");

        etiqueta_01_campo.setDisabledTextColor(java.awt.Color.blue);
        etiqueta_01_campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etiqueta_01_campoActionPerformed(evt);
            }
        });

        etiqueta_02.setText("etiqueta_02");

        etiqueta_02_campo.setText(" ");
        etiqueta_02_campo.setDisabledTextColor(java.awt.Color.blue);

        etiqueta_04.setText("etiqueta_04");

        etiqueta_03.setText("etiqueta_03");

        etiqueta_11.setText("etiqueta_11");

        etiqueta_03_campo_cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etiqueta_03_campo_cbActionPerformed(evt);
            }
        });

        etiqueta_21.setText("etiqueta_21");

        etiqueta_31.setText("etiqueta_31");

        etiqueta_22.setText("etiqueta_22");

        etiqueta_12.setText("etiqueta_12");

        etiqueta_32.setText("etiqueta_32");

        etiqueta_23.setText("etiqueta_23");

        etiqueta_13.setText("etiqueta_13");

        etiqueta_33.setText("etiqueta_33");

        etiqueta_24.setText("etiqueta_24");

        etiqueta_14.setText("etiqueta_14");

        etiqueta_34.setText("etiqueta_34");

        etiqueta_05.setText("etiqueta_05");

        etiqueta_05_campo.setColumns(20);
        etiqueta_05_campo.setRows(5);
        etiqueta_05_campo.setDisabledTextColor(java.awt.Color.blue);
        jScrollPane05.setViewportView(etiqueta_05_campo);

        etiqueta_11_campo.setColumns(20);
        etiqueta_11_campo.setRows(3);
        etiqueta_11_campo.setDisabledTextColor(java.awt.Color.blue);
        jScrollPane11.setViewportView(etiqueta_11_campo);

        etiqueta_21_campo.setColumns(20);
        etiqueta_21_campo.setRows(3);
        etiqueta_21_campo.setDisabledTextColor(java.awt.Color.blue);
        jScrollPane21.setViewportView(etiqueta_21_campo);

        etiqueta_31_campo.setColumns(20);
        etiqueta_31_campo.setRows(3);
        etiqueta_31_campo.setDisabledTextColor(java.awt.Color.blue);
        jScrollPane31.setViewportView(etiqueta_31_campo);

        etiqueta_12_campo.setColumns(20);
        etiqueta_12_campo.setRows(3);
        etiqueta_12_campo.setDisabledTextColor(java.awt.Color.blue);
        jScrollPane12.setViewportView(etiqueta_12_campo);

        etiqueta_22_campo.setColumns(20);
        etiqueta_22_campo.setRows(3);
        etiqueta_22_campo.setDisabledTextColor(java.awt.Color.blue);
        jScrollPane22.setViewportView(etiqueta_22_campo);

        etiqueta_32_campo.setColumns(20);
        etiqueta_32_campo.setRows(3);
        etiqueta_32_campo.setDisabledTextColor(java.awt.Color.blue);
        jScrollPane32.setViewportView(etiqueta_32_campo);

        etiqueta_13_campo.setColumns(20);
        etiqueta_13_campo.setRows(3);
        etiqueta_13_campo.setDisabledTextColor(java.awt.Color.blue);
        jScrollPane13.setViewportView(etiqueta_13_campo);

        etiqueta_23_campo.setColumns(20);
        etiqueta_23_campo.setRows(3);
        etiqueta_23_campo.setDisabledTextColor(java.awt.Color.blue);
        jScrollPane23.setViewportView(etiqueta_23_campo);

        etiqueta_33_campo.setColumns(20);
        etiqueta_33_campo.setRows(3);
        etiqueta_33_campo.setDisabledTextColor(java.awt.Color.blue);
        jScrollPane33.setViewportView(etiqueta_33_campo);

        etiqueta_14_campo.setColumns(20);
        etiqueta_14_campo.setRows(3);
        etiqueta_14_campo.setDisabledTextColor(java.awt.Color.blue);
        jScrollPane14.setViewportView(etiqueta_14_campo);

        etiqueta_24_campo.setColumns(20);
        etiqueta_24_campo.setRows(3);
        etiqueta_24_campo.setDisabledTextColor(java.awt.Color.blue);
        jScrollPane24.setViewportView(etiqueta_24_campo);

        etiqueta_34_campo.setColumns(20);
        etiqueta_34_campo.setRows(3);
        etiqueta_34_campo.setDisabledTextColor(java.awt.Color.blue);
        jScrollPane34.setViewportView(etiqueta_34_campo);

        etiqueta_06.setText("etiqueta_06");

        etiqueta_06_campo.setText(" ");
        etiqueta_06_campo.setDisabledTextColor(java.awt.Color.blue);

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etiqueta_05, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane24))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(etiqueta_14, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(148, 148, 148)
                                    .addComponent(etiqueta_24, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(etiqueta_23, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiqueta_33, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etiqueta_34, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(193, 193, 193))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                                .addComponent(jScrollPane33, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(193, 193, 193))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etiqueta_12, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiqueta_22, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(etiqueta_13, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiqueta_01, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(etiqueta_01_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(etiqueta_21, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(etiqueta_02)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(etiqueta_02_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(etiqueta_06)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(etiqueta_06_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jScrollPane21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(etiqueta_11, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiqueta_32, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(123, 123, 123)
                                            .addComponent(etiqueta_03)
                                            .addGap(18, 18, 18)
                                            .addComponent(etiqueta_03_campo_cb)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(etiqueta_04)
                                            .addGap(18, 18, 18)
                                            .addComponent(etiqueta_04_campo_cb))
                                        .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(etiqueta_31, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelIndice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)
                                .addGap(57, 57, 57)
                                .addComponent(boton_03)
                                .addGap(18, 18, 18)
                                .addComponent(boton_02)
                                .addGap(18, 18, 18)
                                .addComponent(boton_01))
                            .addComponent(jScrollPane05))
                        .addGap(256, 256, 256))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etiqueta_04_campo_cb)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(etiqueta_03_campo_cb, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(etiqueta_03, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiqueta_01_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiqueta_01)
                            .addComponent(etiqueta_02)
                            .addComponent(etiqueta_02_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiqueta_06)
                            .addComponent(etiqueta_06_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(etiqueta_04))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiqueta_11)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(etiqueta_21)
                        .addComponent(etiqueta_31)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_32)
                    .addComponent(etiqueta_22)
                    .addComponent(etiqueta_12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(jScrollPane32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqueta_23)
                    .addComponent(etiqueta_33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane33, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_14)
                    .addComponent(etiqueta_24)
                    .addComponent(etiqueta_34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane34, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(etiqueta_05)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane05, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_01)
                    .addComponent(boton_02)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jLabelIndice)
                    .addComponent(boton_03))
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boton_01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_01ActionPerformed
        switch (estado) {
            //modo edicion
            case texto_estado_editar:
                setEstadoVista();
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
        //verificacion campos vacios

        //enviamos datos a la base de datos
        //tratamos la devolucion de los datos
        //1. si es correcta
        mostrarMensaje(MSG_Sesion_modificada_correctamente);

        //no es cancelar
        setEstadoVista();

        //2. si es fallida

    }//GEN-LAST:event_boton_02ActionPerformed

    private void etiqueta_03_campo_cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etiqueta_03_campo_cbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etiqueta_03_campo_cbActionPerformed

    private void etiqueta_01_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etiqueta_01_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etiqueta_01_campoActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {

            if (rsSesiones.next()) {

                System.out.println(rsSesiones.getRow());
                pintarDatos();
            } else {
                
                System.out.println("fin");
            };

        } catch (SQLException ex) {
            Logger.getLogger(VSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            rsSesiones.previous();
            pintarDatos();

        } catch (SQLException ex) {
            Logger.getLogger(VSesion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

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
    private javax.swing.JCheckBox etiqueta_03_campo_cb;
    private javax.swing.JLabel etiqueta_04;
    private javax.swing.JCheckBox etiqueta_04_campo_cb;
    private javax.swing.JLabel etiqueta_05;
    private javax.swing.JTextArea etiqueta_05_campo;
    private javax.swing.JLabel etiqueta_06;
    private javax.swing.JTextField etiqueta_06_campo;
    private javax.swing.JLabel etiqueta_11;
    private javax.swing.JTextArea etiqueta_11_campo;
    private javax.swing.JLabel etiqueta_12;
    private javax.swing.JTextArea etiqueta_12_campo;
    private javax.swing.JLabel etiqueta_13;
    private javax.swing.JTextArea etiqueta_13_campo;
    private javax.swing.JLabel etiqueta_14;
    private javax.swing.JTextArea etiqueta_14_campo;
    private javax.swing.JLabel etiqueta_21;
    private javax.swing.JTextArea etiqueta_21_campo;
    private javax.swing.JLabel etiqueta_22;
    private javax.swing.JTextArea etiqueta_22_campo;
    private javax.swing.JLabel etiqueta_23;
    private javax.swing.JTextArea etiqueta_23_campo;
    private javax.swing.JLabel etiqueta_24;
    private javax.swing.JTextArea etiqueta_24_campo;
    private javax.swing.JLabel etiqueta_31;
    private javax.swing.JTextArea etiqueta_31_campo;
    private javax.swing.JLabel etiqueta_32;
    private javax.swing.JTextArea etiqueta_32_campo;
    private javax.swing.JLabel etiqueta_33;
    private javax.swing.JTextArea etiqueta_33_campo;
    private javax.swing.JLabel etiqueta_34;
    private javax.swing.JTextArea etiqueta_34_campo;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabelIndice;
    private javax.swing.JScrollPane jScrollPane05;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    // End of variables declaration//GEN-END:variables
}

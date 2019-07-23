/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Dialog;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Nacho
 */
public class VContactos extends javax.swing.JPanel {

    private final String texto_estado_vista = "vista";
    private final String texto_estado_editar = "editar";
    private final String texto_estado_nuevo = "nuevo";
    private final String texto_campo_vacio = "";
    private String estado = texto_estado_vista;

    private final String texto_etiqueta_11 = "Nombre: ";
    private final String texto_etiqueta_12 = "Apellidos: ";
    private final String texto_etiqueta_13 = "DNI: ";
    private final String texto_etiqueta_14 = "Dirección: ";
    private final String texto_etiqueta_15 = "Teléfono: ";
    private final String texto_etiqueta_16 = "Ciudad: ";
    private final String texto_etiqueta_17 = "Email: ";
    private final String texto_etiqueta_18 = "Rol: ";

    //parte de botones
    private final String texto_Editar = "Editar";
    private final String texto_Guardar = "Guardar";
    private final String texto_Cancelar = "Cancelar";
    private final String texto_Borrar = "Borrar";

    //parte de mensajes
    private final String MSG_Contacto_modificado_correctamente
            = "El contacto ha sido modificado correctamente";

    private ResultSet rs;

    /**
     * Creates new form vUsuarios
     */
    public VContactos() {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        setBounds(0, 0, 1185, 677);
        initComponents();

        etiqueta_11.setText(texto_etiqueta_11);
        etiqueta_12.setText(texto_etiqueta_12);
        etiqueta_13.setText(texto_etiqueta_13);
        etiqueta_14.setText(texto_etiqueta_14);
        etiqueta_15.setText(texto_etiqueta_15);
        etiqueta_16.setText(texto_etiqueta_16);
        etiqueta_17.setText(texto_etiqueta_17);
        etiqueta_18.setText(texto_etiqueta_18);

        boton_01.setText(texto_Editar);
        boton_02.setVisible(false);
        boton_02.setText(texto_Guardar);
        boton_03.setText(texto_Borrar);

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

        etiqueta_11_campo.setText(texto_campo_vacio);
        etiqueta_12_campo.setText(texto_campo_vacio);
        etiqueta_13_campo.setText(texto_campo_vacio);
        etiqueta_14_campo.setText(texto_campo_vacio);
        etiqueta_15_campo.setText(texto_campo_vacio);
        etiqueta_16_campo.setText(texto_campo_vacio);
        etiqueta_17_campo.setText(texto_campo_vacio);
        etiqueta_18_campo.setText(texto_campo_vacio);
    }

    public void setEstadoNuevo() {
        desbloquearCampos();
        limpiarCampos();
        jComboBox1.removeAllItems();
        boton_01.setText(texto_Cancelar);
        boton_02.setText(texto_Guardar);
        boton_03.setEnabled(false);
        boton_02.setVisible(true);
        estado = texto_estado_nuevo;
    }

    public void setEstadoEditar() {
        desbloquearCampos();
        boton_01.setText(texto_Cancelar);
        boton_02.setText(texto_Guardar);
        boton_02.setVisible(true);
        boton_03.setEnabled(true);

        estado = texto_estado_editar;
    }

    public void setEstadoVista() {
        bloquearCampos();
        boton_01.setText(texto_Editar);
        boton_02.setVisible(false);
        boton_03.setEnabled(true);

        estado = texto_estado_vista;
    }

    public void setDatos(ResultSet rs) {
        this.rs = rs;
        pintarDatos();
    }

    public void pintarDatos() {

        jComboBox1.removeAllItems();

        try {

            if (rs.next()) {

                etiqueta_11_campo.setText("CONTACTO");
                etiqueta_12_campo.setText("AAAAAAAA");
                etiqueta_13_campo.setText("12345678S");
                etiqueta_14_campo.setText("CALLE MADRID");
                etiqueta_15_campo.setText("666448855");
                etiqueta_16_campo.setText("CACERES");
                etiqueta_17_campo.setText("CONTACTO@GMAIL.COM");
                etiqueta_18_campo.setText("PADRE");

//                jComboBox1.addItem(rs.getString(1) + ". " + rs.getString(2) + " " + rs.getString(3));
                jComboBox1.addItem(rs.getString(1) + ". " + "CONTACTO" + rs.getString(1));

                while (rs.next()) {
//                    jComboBox1.addItem(rs.getString(1) + ". " + rs.getString(2) + " " + rs.getString(3));
                    jComboBox1.addItem(rs.getString(1) + ". " + "CONTACTO" + rs.getString(1));

                }

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

        boton_01 = new javax.swing.JButton();
        boton_02 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        etiqueta_12 = new javax.swing.JLabel();
        etiqueta_12_campo = new javax.swing.JTextField();
        etiqueta_11 = new javax.swing.JLabel();
        etiqueta_11_campo = new javax.swing.JTextField();
        etiqueta_13 = new javax.swing.JLabel();
        etiqueta_13_campo = new javax.swing.JTextField();
        etiqueta_14 = new javax.swing.JLabel();
        etiqueta_14_campo = new javax.swing.JFormattedTextField();
        etiqueta_15 = new javax.swing.JLabel();
        etiqueta_15_campo = new javax.swing.JTextField();
        etiqueta_16 = new javax.swing.JLabel();
        etiqueta_16_campo = new javax.swing.JTextField();
        etiqueta_17 = new javax.swing.JLabel();
        etiqueta_17_campo = new javax.swing.JFormattedTextField();
        etiqueta_18 = new javax.swing.JLabel();
        etiqueta_18_campo = new javax.swing.JTextField();
        boton_03 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMaximumSize(new java.awt.Dimension(900, 710));
        setPreferredSize(new java.awt.Dimension(900, 710));

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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        etiqueta_12.setText("etiqueta_12");

        etiqueta_12_campo.setText(" ");
        etiqueta_12_campo.setDisabledTextColor(java.awt.Color.blue);
        etiqueta_12_campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etiqueta_12_campoActionPerformed(evt);
            }
        });

        etiqueta_11.setText("etiqueta_11");

        etiqueta_11_campo.setDisabledTextColor(java.awt.Color.blue);
        etiqueta_11_campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etiqueta_11_campoActionPerformed(evt);
            }
        });

        etiqueta_13.setText("etiqueta_13");

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

        etiqueta_16.setText("etiqueta_16");

        etiqueta_16_campo.setText(" ");
        etiqueta_16_campo.setDisabledTextColor(java.awt.Color.blue);
        etiqueta_16_campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etiqueta_16_campoActionPerformed(evt);
            }
        });

        etiqueta_17.setText("etiqueta_17");

        etiqueta_17_campo.setText(" ");
        etiqueta_17_campo.setDisabledTextColor(java.awt.Color.blue);

        etiqueta_18.setText("etiqueta_18");

        etiqueta_18_campo.setText(" ");
        etiqueta_18_campo.setDisabledTextColor(java.awt.Color.blue);
        etiqueta_18_campo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                etiqueta_18_campoActionPerformed(evt);
            }
        });

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(boton_03)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boton_02)
                        .addGap(49, 49, 49)
                        .addComponent(boton_01))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(etiqueta_11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(etiqueta_12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(etiqueta_13))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(etiqueta_13_campo)
                                    .addComponent(etiqueta_12_campo)
                                    .addComponent(etiqueta_11_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(etiqueta_15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(etiqueta_16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(etiqueta_17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(etiqueta_14))
                                    .addComponent(etiqueta_18))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiqueta_14_campo)
                                    .addComponent(etiqueta_17_campo)
                                    .addComponent(etiqueta_18_campo)
                                    .addComponent(etiqueta_15_campo)
                                    .addComponent(etiqueta_16_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 268, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_11_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqueta_11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_12_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqueta_12))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiqueta_13_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiqueta_13))
                .addGap(18, 18, 18)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 320, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_01)
                    .addComponent(boton_02)
                    .addComponent(boton_03))
                .addContainerGap())
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
                setEstadoNuevo();
                break;

        }


    }//GEN-LAST:event_boton_01ActionPerformed

    private void boton_02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_02ActionPerformed

        mostrarMensaje(MSG_Contacto_modificado_correctamente);

        setEstadoVista();


    }//GEN-LAST:event_boton_02ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if (jComboBox1.getSelectedIndex() == -1) {
            limpiarCampos();
        } else {
            etiqueta_11_campo.setText("CONTACTO" + (jComboBox1.getSelectedIndex() + 1));
            etiqueta_12_campo.setText("AAAAAAAA");
            etiqueta_13_campo.setText("12345678S");
            etiqueta_14_campo.setText("CALLE MADRID");
            etiqueta_15_campo.setText("666448855");
            etiqueta_16_campo.setText("CACERES");
            etiqueta_17_campo.setText("CONTACTO." + (jComboBox1.getSelectedIndex() + 1) + "@GMAIL.COM");
            etiqueta_18_campo.setText("MADRE");
        }


    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void etiqueta_11_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etiqueta_11_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etiqueta_11_campoActionPerformed

    private void etiqueta_12_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etiqueta_12_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etiqueta_12_campoActionPerformed

    private void etiqueta_13_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etiqueta_13_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etiqueta_13_campoActionPerformed

    private void etiqueta_16_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etiqueta_16_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etiqueta_16_campoActionPerformed

    private void etiqueta_18_campoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_etiqueta_18_campoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_etiqueta_18_campoActionPerformed

    private void boton_03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_03ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_03ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_01;
    private javax.swing.JButton boton_02;
    private javax.swing.JButton boton_03;
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
    // End of variables declaration//GEN-END:variables
}

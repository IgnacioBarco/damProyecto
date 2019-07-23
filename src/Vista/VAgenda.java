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
public class VAgenda extends javax.swing.JPanel {

    private final String texto_estado_vista = "vista";
    private final String texto_estado_editar = "editar";
    private final String texto_estado_nuevo = "nuevo";
    private final String texto_campo_vacio = "";
    private String estado = texto_estado_vista;

    //parte de datos
    private final String texto_etiqueta_01 = "Nombre: ";
    private final String texto_etiqueta_02 = "Apellidos: ";
    private final String texto_etiqueta_03 = "F. Nacimiento: ";
    private final String texto_etiqueta_04 = "Edad: ";
    private final String texto_etiqueta_05 = "F. Inicio: ";
    private final String texto_etiqueta_06 = "F. Fin: ";

    //parte técnica
    private final String texto_etiqueta_07 = "Sesiones semanales: ";
    private final String texto_etiqueta_08 = "Grado de discapacidad: ";
    private final String texto_etiqueta_20 = "Diagnóstico: ";
    private final String texto_etiqueta_21 = "Motivo Consulta: ";
    private final String texto_etiqueta_22 = "Objetivos: ";
    private final String texto_etiqueta_23 = "Observaciones: ";

    //parte de los padres
    private final String texto_etiqueta_11 = "Nombre: ";
    private final String texto_etiqueta_12 = "DNI: ";
    private final String texto_etiqueta_13 = "Apellidos: ";
    private final String texto_etiqueta_14 = "Dirección: ";
    private final String texto_etiqueta_15 = "Teléfono: ";
    private final String texto_etiqueta_16 = "Ciudad: ";
    private final String texto_etiqueta_17 = "Email: ";

    //parte de botones
    private final String texto_Editar = "Editar";
    private final String texto_Guardar = "Guardar";
    private final String texto_Cancelar = "Cancelar";
    private final String texto_Borrar = "Borrar";

    //parte de mensajes
    private final String MSG_Usuario_modificado_correctamente
            = "El usuario ha sido modificado correctamente";

    
    private ResultSet rs;
    /**
     * Creates new form vUsuarios
     */
    public VAgenda() {
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        setBounds(0, 0, 1185, 677);
        initComponents();



        boton_01.setText(texto_Editar);
        boton_02.setVisible(false);
        boton_02.setText(texto_Guardar);

        
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


 
    }

    /**
     * Desbloqueamos los campos para que sean modificables
     */
    public void desbloquearCampos() {


    }

    /**
     * Limpia todos los campos
     */
    public void limpiarCampos() {


;
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
        this.rs = rs;
        try {
            rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(VSesion.class.getName()).log(Level.SEVERE, null, ex);
        }

        pintarDatos();
    }

    public void pintarDatos() {

        try {
            jComboBox1.removeAllItems();
     
            jComboBox1.addItem(rs.getString(1) + ". " + rs.getString(2) + " " + rs.getString(3));
            
            while (rs.next()) {
                jComboBox1.addItem(rs.getString(1) + ". " + rs.getString(2) + " " + rs.getString(3));

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semana Actual" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jScrollPane1.setPreferredSize(new java.awt.Dimension(469, 603));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"<9", "", null, null, null, null, null, null},
                {"9", null, null, null, null, null, null, null},
                {"10", null, null, null, null, "TUTOR PEPE", null, null},
                {"11", null, null, null, null, null, null, null},
                {"12", "EVALUACIÓN LUIS", "", null, null, null, null, null},
                {"13", null, null, null, null, null, null, null},
                {"14", "", null, null, null, null, null, null},
                {"15", null, null, null, null, null, null, null},
                {"16", null, null, null, null, null, null, null},
                {"17", null, null, null, null, null, null, null},
                {"18", "PEDRO", null, "LUIS", null, "PEPE", null, null},
                {"19", "", null, null, "PEDRO", null, null, null},
                {"20", null, "PEPE", null, null, null, null, null},
                {"21", "ANTONIO", null, "JUAN", "ANTONIO", null, null, null},
                {"22", null, null, null, null, null, null, null},
                {"23", null, null, null, null, null, null, null}
            },
            new String [] {
                "Horario", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado", "Domingo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setPreferredSize(new java.awt.Dimension(603, 576));
        jTable1.setRowHeight(36);
        jTable1.setRowSelectionAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(326, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(boton_02)
                        .addGap(94, 94, 94)
                        .addComponent(boton_01)
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton_01)
                    .addComponent(boton_02, javax.swing.GroupLayout.Alignment.TRAILING))
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
                setEstadoVista();
                break;

        }


    }//GEN-LAST:event_boton_01ActionPerformed

    private void boton_02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_02ActionPerformed

        //verificacion campos vacios
        //enviamos datos a la base de datos
        //tratamos la devolucion de los datos
        //1. si es correcta
        mostrarMensaje(MSG_Usuario_modificado_correctamente);

        //no es cancelar
        setEstadoVista();

        //2. si es fallida

    }//GEN-LAST:event_boton_02ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_01;
    private javax.swing.JButton boton_02;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

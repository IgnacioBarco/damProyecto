/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author nacho
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    private Connection conexion;
    private Statement consulta;
    private String ruta;
    private ResultSet resultado = null;
    private Statement stmt = null;

    /**
     * Constructor for objects of class Conexion
     */
    public Conexion() {
        //ruta = System.getProperty("user.dir") + "/db / datos.db";
        System.out.println(System.getProperty("user.dir"));
        ruta = "C:\\Proyecto\\bbdd\\bdempresa.db";
//        ruta = "D:\\programas\\JavaProgramas\\programacion\\Proyecto\\src\\bdempresa.db";
        conectar();
    }

    
    /**
     * conecta la base de datos
     */
    private void conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:" + ruta);
            System.out.println("nos conectamos a la base de datos");
            consulta = conexion.createStatement();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    
    /**
     * desconecta la base de datos
     */
    public void desconectar() {

        try {
            consulta.close();
            conexion.close();
            System.out.println("Desconectamos la base de datos");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//Insertar en la tabla
    public boolean insertar(String sql) throws SQLException {
        consulta = conexion.createStatement();
        boolean valor = true;
        try {
            consulta.executeUpdate(sql);
        } catch (SQLException e) {
            valor = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            try {
                consulta.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return valor;
    }

//Consultar en la tabla
    public ResultSet getDatos(String sql) throws SQLException {
        resultado = null;
        resultado = consulta.executeQuery(sql);
        System.out.println("ejecutamos consulta: " + sql);

        return resultado;
    }

    public String getRuta() {
        return ruta;
    }

    /**
     * devuelve la conexion
    */
    public Connection getConexion() {
        return conexion;
    }
}

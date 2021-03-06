/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author neo
 */
public class Conexion {
    
    private Connection conexion;
    public  String base_datos = "bd_siscon";
    public  String usuario = "mysql";//public static String usuario = "root";
    public  String contrasena = "mysql";//public static String contrasena = "";
    private String servidor = "jdbc:mysql://localhost:3306/"+base_datos;
    
    private PreparedStatement consulta;
    private ResultSet resultado;
    
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(servidor,usuario,contrasena);
            //System.out.println("la conexion fue un EXITO");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Imposible realizar conexion con la Base de Datos");
        }
    }
    public void cerrar_conexion(){
        try {
            if(resultado != null)
                resultado.close();
            if(consulta != null)
                consulta.close();
            if(conexion != null)
                conexion.close();
            //System.out.println("se cerro exitosamente la conexion");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection getConexion(){
        return conexion;
    }
    public String getUsername(){
        return usuario;
    }
    public String getPassword(){
        return contrasena;
    }
    public String getBD(){
        return base_datos;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.dao;

import com.siscon.bd.Conexion;
import com.siscon.model.Tabvar;
import com.siscon.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author neo
 */
public class UsuarioDao {
    
    public Usuario getUsuario(String sql){
        Conexion conexion = new Conexion();
        Usuario usuario = null;
        try {
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);            
            ResultSet rs = preparedStatement.executeQuery();            
            while(rs.next()){
                usuario = new Usuario(rs.getInt("ID"));
                usuario.setRazsoc(rs.getString("RAZSOC"));
                usuario.setNumusu(rs.getInt("NUMUSU"));
                usuario.setFecusu(rs.getString("FECUSU"));
                usuario.setTipcam(rs.getDouble("TIPCAM"));
                usuario.setCodjjc(rs.getInt("CODJJC"));
                usuario.setDirraz(rs.getString("DIRRAZ"));
                usuario.setNumnit(rs.getLong("NUMNIT"));                
            }            
        } catch (SQLException e) {
            System.out.println("Error...! getUsuario(): "+e.getMessage());
        }
        conexion.cerrar_conexion();
        return usuario;
    }
    public boolean saveUsuario(Usuario c){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO USUARIO VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);            
                        
            ps.setInt(1, c.getId());
            ps.setString(2, c.getRazsoc());
            ps.setInt(3, c.getNumusu());
            ps.setString(4, c.getFecusu());
            ps.setDouble(5, c.getTipcam());
            ps.setInt(6, c.getCodjjc());
            ps.setString(7, c.getDirraz());
            ps.setLong(8, c.getNumnit());
            
            int resultado = ps.executeUpdate();
            if(resultado > 0)
                verificador = true;
            
        } catch (SQLException e) {
            System.out.println("Error UsuarioDao.saveUsuario(): "+e.getMessage());
        }
        conexion.cerrar_conexion();
        return verificador;
    }
}

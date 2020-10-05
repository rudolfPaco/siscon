/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.dao;

import com.siscon.bd.Conexion;
import com.siscon.model.Tabvar;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author neo
 */
public class TabvarDao {
    public ArrayList<Tabvar> getAllList(String sql){
        Conexion conexion = new Conexion();
        ArrayList<Tabvar> lista = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);            
            ResultSet rs = preparedStatement.executeQuery();            
            Tabvar tabvar = null;
            while(rs.next()){
                tabvar = new Tabvar(rs.getInt("RECORD"));
                tabvar.setTipo(rs.getInt("TIPO"));
                tabvar.setNumero(rs.getInt("NUMERO"));
                tabvar.setDescri(rs.getString("DESCRI"));
                tabvar.setCodcon(rs.getInt("CODCON"));
                tabvar.setCorrel(rs.getInt("CORREL"));
                tabvar.setMonto(rs.getDouble("MONTO"));
                tabvar.setObserv(rs.getString("OBSERV"));
                tabvar.setFecha(rs.getString("FECHA"));
                tabvar.setFecha2(rs.getString("FECHA2"));
                tabvar.setMonto2(rs.getDouble("MONTO2"));
                tabvar.setTipcam(rs.getDouble("TIPCAM"));
                tabvar.setNumnit(rs.getInt("NUMNIT"));
                
                lista.add(tabvar);
            }            
        } catch (SQLException e) {
            System.out.println("Error...! TabvarDao.getAllList(): "+e.getMessage());
        }
        conexion.cerrar_conexion();
        return lista;
    }
    public Tabvar getTabvar(String sql){
        Conexion conexion = new Conexion();
        Tabvar tabvar = null;
        try {
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);            
            ResultSet rs = preparedStatement.executeQuery();            
            while(rs.next()){
                tabvar = new Tabvar(rs.getInt("RECORD"));
                tabvar.setTipo(rs.getInt("TIPO"));
                tabvar.setNumero(rs.getInt("NUMERO"));
                tabvar.setDescri(rs.getString("DESCRI"));
                tabvar.setCodcon(rs.getInt("CODCON"));
                tabvar.setCorrel(rs.getInt("CORREL"));
                tabvar.setMonto(rs.getDouble("MONTO"));
                tabvar.setObserv(rs.getString("OBSERV"));
                tabvar.setFecha(rs.getString("FECHA"));
                tabvar.setFecha2(rs.getString("FECHA2"));
                tabvar.setMonto2(rs.getDouble("MONTO2"));
                tabvar.setTipcam(rs.getDouble("TIPCAM"));
                tabvar.setNumnit(rs.getInt("NUMNIT"));
            }            
        } catch (SQLException e) {
            System.out.println("Error...! getTabVar(): "+e.getMessage());
        }
        conexion.cerrar_conexion();
        return tabvar;
    }    
    public boolean modifyTabvar(Tabvar c){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        String sql = "UPDATE TABVAR SET TIPO=?, NUMERO=?, DESCRI=?, CODCON=?, CORREL=?, MONTO=?, OBSERV=?, FECHA=?, FECHA2=?, MONTO2=?, TIPCAM=?, NUMNIT=? WHERE `RECORD`='"+c.getRecord()+"';";
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            
            ps.setInt(1, c.getTipo());
            ps.setInt(2, c.getNumero());
            ps.setString(3, c.getDescri());
            ps.setInt(4, c.getCodcon());
            ps.setInt(5, c.getCorrel());
            ps.setDouble(6, c.getMonto());
            ps.setString(7, c.getObserv());
            ps.setString(8, c.getFecha());
            ps.setString(9, c.getFecha2());
            ps.setDouble(10, c.getMonto2());
            ps.setDouble(11, c.getTipcam());
            ps.setInt(12, c.getNumnit());
            
            int estado = ps.executeUpdate();
            if(estado > 0)
                verificador = true;
        } catch (SQLException e) {
            System.out.println("Error TabvarDao.modifyTabvar(): "+e.getMessage());
        }
        return verificador;
    }
    public boolean deleteTabvar(Tabvar t){
        boolean verificador = false;
        String sql = "DELETE FROM TABVAR WHERE RECORD = "+t.getRecord();
        Conexion conexion = new Conexion();
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            int estado = ps.executeUpdate();
            if(estado > 0)
                verificador = true;
            
        } catch (SQLException e) {
            System.out.println("Error TabvarDao.deleteTabvar(): "+e.getMessage());
        }
        conexion.cerrar_conexion();
        return verificador;
    }
    public boolean saveTabvar(Tabvar c){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO TABVAR VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);            
                        
            ps.setInt(1, c.getRecord());
            ps.setInt(2, c.getTipo());
            ps.setInt(3, c.getNumero());
            ps.setString(4, c.getDescri());
            ps.setInt(5, c.getCodcon());
            ps.setInt(6, c.getCorrel());
            ps.setDouble(7, c.getMonto());
            ps.setString(8, c.getObserv());
            ps.setString(9, c.getFecha());
            ps.setString(10, c.getFecha2());
            ps.setDouble(11, c.getMonto2());
            ps.setDouble(12, c.getTipcam());
            ps.setInt(13, c.getNumnit());
            
            int resultado = ps.executeUpdate();
            if(resultado > 0)
                verificador = true;
            
        } catch (SQLException e) {
            System.out.println("Error TavbarDao.saveTabvar(): "+e.getMessage());
        }
        conexion.cerrar_conexion();
        return verificador;
    }
}

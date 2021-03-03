/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.dao;

import com.siscon.bd.Conexion;
import com.siscon.model.Conmae;
import com.siscon.model.Contra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author neo
 */
public class ContraDao {
    
    public boolean saveContra(Contra c){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO contra VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);            

            ps.setInt(1, c.getId());
            ps.setInt(2, c.getTipcon());
            ps.setInt(3, c.getNumcom());
            ps.setInt(4, c.getCorrel());
            ps.setString(5, c.getFecha());
            ps.setInt(6, c.getGrupo());
            ps.setInt(7, c.getSubgru());
            ps.setInt(8, c.getMayor());            
            ps.setInt(9, c.getCuenta());
            ps.setInt(10, c.getSubcta());
            ps.setInt(11, c.getApropi());
            ps.setDouble(12, c.getMonto1());
            ps.setDouble(13, c.getMonto2());
            ps.setDouble(14, c.getTipcam());
            ps.setInt(15, c.getIndica());
            ps.setString(16, c.getNombre());
            ps.setString(17, c.getGlosa());
            ps.setInt(18, c.getCheque());
            ps.setInt(19, c.getNumcue());
            ps.setLong(20, c.getCuetot());
            ps.setInt(21, c.getReduce());
            ps.setInt(22, c.getTipcom());
            ps.setInt(23, c.getIntern());
            ps.setInt(24, c.getNumint());
            ps.setInt(25, c.getEmpres());
            
            int resultado = ps.executeUpdate();
            if(resultado > 0)
                verificador = true;
            
        } catch (SQLException e) {
            System.out.println("Error ContraDao.saveContra(): "+e.getMessage());
        }
        conexion.cerrar_conexion();
        return verificador;
    }
    public Contra getContra(String sql){
        Conexion conexion = new Conexion();
        Contra c = null;
        try {
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                c = new Contra(rs.getInt("ID"));
                c.setTipcon(rs.getInt("TIPCON"));
                c.setNumcom(rs.getInt("NUMCOM"));
                c.setCorrel(rs.getInt("CORREL"));
                c.setFecha(rs.getString("FECHA"));
                c.setGrupo(rs.getInt("GRUPO"));
                c.setSubgru(rs.getInt("SUBGRU"));
                c.setMayor(rs.getInt("MAYOR"));
                c.setCuenta(rs.getInt("CUENTA"));
                c.setSubcta(rs.getInt("SUBCTA"));
                c.setApropi(rs.getInt("APROPI"));
                c.setMonto1(rs.getDouble("MONTO1"));
                c.setMonto2(rs.getDouble("MONTO2"));
                c.setTipcam(rs.getDouble("TIPCAM"));
                c.setIndica(rs.getInt("INDICA"));
                c.setNombre(rs.getString("NOMBRE"));
                c.setGlosa(rs.getString("GLOSA"));
                c.setCheque(rs.getInt("CHEQUE"));
                c.setNumcue(rs.getInt("NUMCUE"));
                c.setCuetot(rs.getLong("CUETOT"));
                c.setReduce(rs.getInt("REDUCE"));
                c.setTipcom(rs.getInt("TIPCOM"));
                c.setIntern(rs.getInt("INTERN"));
                c.setNumint(rs.getInt("NUMINT"));
                c.setEmpres(rs.getInt("EMPRES"));
            }            
        } catch (SQLException e) {
            System.out.println("Error...! ContraDao.getContra(): "+e.getMessage());
        }
        conexion.cerrar_conexion();
        return c;
    }
    public ArrayList<Contra> getAllList(String sql){
        Conexion conexion = new Conexion();
        ArrayList<Contra> lista = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);            
            ResultSet rs = preparedStatement.executeQuery();            
            Contra c = null;
            while(rs.next()){
                c = new Contra(rs.getInt("ID"));
                c.setTipcon(rs.getInt("TIPCON"));
                c.setNumcom(rs.getInt("NUMCOM"));
                c.setCorrel(rs.getInt("CORREL"));
                c.setFecha(rs.getString("FECHA"));
                c.setGrupo(rs.getInt("GRUPO"));
                c.setSubgru(rs.getInt("SUBGRU"));
                c.setMayor(rs.getInt("MAYOR"));
                c.setCuenta(rs.getInt("CUENTA"));
                c.setSubcta(rs.getInt("SUBCTA"));
                c.setApropi(rs.getInt("APROPI"));
                c.setMonto1(rs.getDouble("MONTO1"));
                c.setMonto2(rs.getDouble("MONTO2"));
                c.setTipcam(rs.getDouble("TIPCAM"));
                c.setIndica(rs.getInt("INDICA"));
                c.setNombre(rs.getString("NOMBRE"));
                c.setGlosa(rs.getString("GLOSA"));
                c.setCheque(rs.getInt("CHEQUE"));
                c.setNumcue(rs.getInt("NUMCUE"));
                c.setCuetot(rs.getLong("CUETOT"));
                c.setReduce(rs.getInt("REDUCE"));
                c.setTipcom(rs.getInt("TIPCOM"));
                c.setIntern(rs.getInt("INTERN"));
                c.setNumint(rs.getInt("NUMINT"));
                c.setEmpres(rs.getInt("EMPRES"));
                lista.add(c);
            }            
        } catch (SQLException e) {
            System.out.println("Error...! ContraDao.getAllList(): "+e.getMessage());
        }
        conexion.cerrar_conexion();
        return lista;
    }
    public boolean modifyContra(Contra c){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        String sql = "UPDATE contra SET TIPCON=?, NUMCOM=?, CORREL=?, FECHA=?, GRUPO=?, SUBGRU=?, MAYOR=?, CUENTA=?, SUBCTA=?, APROPI=?, MONTO1=?, MONTO2=?, TIPCAM=?, INDICA=?, NOMBRE=?, GLOSA=?, CHEQUE=?, NUMCUE=?, CUETOT=?, REDUCE=?, TIPCOM=?, INTERN=?, NUMINT=?, EMPRES=? WHERE `ID`='"+c.getId()+"';".toLowerCase();
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            
            ps.setInt(1, c.getTipcon());
            ps.setInt(2, c.getNumcom());
            ps.setInt(3, c.getCorrel());
            ps.setString(4, c.getFecha());
            ps.setInt(5, c.getGrupo());
            ps.setInt(6, c.getSubgru());
            ps.setInt(7, c.getMayor());            
            ps.setInt(8, c.getCuenta());
            ps.setInt(9, c.getSubcta());
            ps.setInt(10, c.getApropi());
            ps.setDouble(11, c.getMonto1());
            ps.setDouble(12, c.getMonto2());
            ps.setDouble(13, c.getTipcam());
            ps.setInt(14, c.getIndica());
            ps.setString(15, c.getNombre());
            ps.setString(16, c.getGlosa());
            ps.setInt(17, c.getCheque());
            ps.setInt(18, c.getNumcue());
            ps.setLong(19, c.getCuetot());
            ps.setInt(20, c.getReduce());
            ps.setInt(21, c.getTipcom());
            ps.setInt(22, c.getIntern());
            ps.setInt(23, c.getNumint());
            ps.setInt(24, c.getEmpres());
            
            int estado = ps.executeUpdate();
            if(estado > 0)
                verificador = true;
        } catch (SQLException e) {
            System.out.println("Error ContraDao.modifyContra(): "+e.getMessage());
        }
        conexion.cerrar_conexion();
        return verificador;
    }
    public boolean deleteContra(Contra c){
        boolean verificador = false;
        String sql = "DELETE FROM contra WHERE ID = "+c.getId();
        Conexion conexion = new Conexion();
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            int estado = ps.executeUpdate();
            if(estado > 0)
                verificador = true;
            
        } catch (SQLException e) {
            System.out.println("Error ContraDao.deleteContra(): "+e.getMessage());
        }
        conexion.cerrar_conexion();
        return verificador;
    }
    public boolean removeAll(){
        boolean verificador = false;
        String sql = "TRUNCATE TABLE contra";
        Conexion conexion = new Conexion();
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            int estado = ps.executeUpdate();
            if(estado > 0)
                verificador = true;
            
        } catch (SQLException e) {
            System.out.println("Error ContraDao.removeAll(): "+e.getMessage());
        }
        conexion.cerrar_conexion();
        return verificador;
    }
}

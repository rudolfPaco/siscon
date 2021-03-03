/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.dao;

import com.siscon.bd.Conexion;
import com.siscon.model.Conmae;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author neo
 */
public class ConmaeDao {
    
    public ArrayList<Conmae> getAllList(String sql){
        Conexion conexion = new Conexion();
        ArrayList<Conmae> lista = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);            
            ResultSet rs = preparedStatement.executeQuery();            
            Conmae c = null;
            while(rs.next()){
                c = new Conmae(rs.getInt("ID"));
                c.setGrup(rs.getInt("GRUP"));                
                c.setSubgru(rs.getInt("SUBGRU"));
                c.setMayor(rs.getInt("MAYOR"));
                c.setCuenta(rs.getInt("CUENTA"));
                c.setSubcta(rs.getInt("SUBCTA"));
                c.setCuetot(rs.getLong("CUETOT"));
                c.setNumcue(rs.getInt("NUMCUE"));
                c.setDescri(rs.getString("DESCRI"));
                c.setActivi(rs.getInt("ACTIVI"));
                c.setNivel(rs.getInt("NIVEL"));
                c.setLugar(rs.getInt("LUGAR"));
                c.setPresup(rs.getInt("PRESUP"));
                c.setSalini(rs.getDouble("SALINI"));
                c.setAntdia(rs.getDouble("ANTDIA"));
                c.setAntmes(rs.getDouble("ANTMES"));
                c.setSalact(rs.getDouble("SALACT"));
                c.setDebano(rs.getDouble("DEBANO"));
                c.setCreano(rs.getDouble("CREANO"));
                c.setDebmes(rs.getDouble("DEBMES"));
                c.setCremes(rs.getDouble("CREMES"));
                c.setDebdia(rs.getDouble("DEBDIA"));
                c.setCredia(rs.getDouble("CREDIA"));
                c.setIndica(rs.getInt("INDICA"));
                c.setSalin2(rs.getDouble("SALIN2"));
                c.setDebme2(rs.getDouble("DEBME2"));
                c.setAntme2(rs.getDouble("ANTME2"));
                c.setCreme2(rs.getDouble("CREME2"));
                c.setSalac2(rs.getDouble("SALAC2"));
                c.setFecha(rs.getString("FECHA"));
                c.setNompre(rs.getDouble("NOMPRE"));
                c.setDeban2(rs.getDouble("DEBAN2"));
                c.setCrean2(rs.getDouble("CREAN2"));
                c.setAntdi2(rs.getDouble("ANTDI2"));
                c.setDebdi2(rs.getDouble("DEBDI2"));
                c.setCredi2(rs.getDouble("CREDI2"));
                c.setFecha2(rs.getString("FECHA2"));
                lista.add(c);
            }            
        } catch (SQLException e) {
            System.out.println("Error...! ConmaeDao.getAllList(): "+e.getMessage());
        }
        conexion.cerrar_conexion();
        return lista;
    }
    public boolean saveConmae(Conmae c){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO conmae VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);            

            ps.setInt(1, c.getId());
            ps.setInt(2, c.getGrup());
            ps.setInt(3, c.getSubgru());
            ps.setInt(4, c.getMayor());
            ps.setInt(5, c.getCuenta());
            ps.setInt(6, c.getSubcta());
            ps.setLong(7, c.getCuetot());
            ps.setInt(8, c.getNumcue());            
            ps.setString(9, c.getDescri());
            ps.setInt(10, c.getActivi());
            ps.setInt(11, c.getNivel());
            ps.setInt(12, c.getLugar());
            ps.setInt(13, c.getPresup());
            ps.setDouble(14, c.getSalini());
            ps.setDouble(15, c.getAntdia());
            ps.setDouble(16, c.getAntmes());
            ps.setDouble(17, c.getSalact());
            ps.setDouble(18, c.getDebano());
            ps.setDouble(19, c.getCreano());
            ps.setDouble(20, c.getDebmes());
            ps.setDouble(21, c.getCremes());
            ps.setDouble(22, c.getDebdia());
            ps.setDouble(23, c.getCredia());
            ps.setInt(24, c.getIndica());
            ps.setDouble(25, c.getSalin2());
            ps.setDouble(26, c.getDebme2());
            ps.setDouble(27, c.getAntme2());
            ps.setDouble(28, c.getCreme2());
            ps.setDouble(29, c.getSalac2());
            ps.setString(30, c.getFecha());
            ps.setDouble(31, c.getNompre());
            ps.setDouble(32, c.getDeban2());
            ps.setDouble(33, c.getCrean2());
            ps.setDouble(34, c.getAntdi2());
            ps.setDouble(35, c.getDebdi2());
            ps.setDouble(36, c.getCredi2());
            ps.setString(37, c.getFecha2());
            int resultado = ps.executeUpdate();
            if(resultado > 0)
                verificador = true;
            
        } catch (SQLException e) {
            System.out.println("Error ConmaeDao.saveConmae(): "+e.getMessage());
        }
        conexion.cerrar_conexion();
        return verificador;
    }
    public Conmae getConmae(String sql){
        Conexion conexion = new Conexion();
        Conmae c = null;
        try {
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                c = new Conmae(rs.getInt("ID"));
                c.setGrup(rs.getInt("GRUP"));                
                c.setSubgru(rs.getInt("SUBGRU"));
                c.setMayor(rs.getInt("MAYOR"));
                c.setCuenta(rs.getInt("CUENTA"));
                c.setSubcta(rs.getInt("SUBCTA"));
                c.setCuetot(rs.getLong("CUETOT"));
                c.setNumcue(rs.getInt("NUMCUE"));
                c.setDescri(rs.getString("DESCRI"));
                c.setActivi(rs.getInt("ACTIVI"));
                c.setNivel(rs.getInt("NIVEL"));
                c.setLugar(rs.getInt("LUGAR"));
                c.setPresup(rs.getInt("PRESUP"));
                c.setSalini(rs.getDouble("SALINI"));
                c.setAntdia(rs.getDouble("ANTDIA"));
                c.setAntmes(rs.getDouble("ANTMES"));
                c.setSalact(rs.getDouble("SALACT"));
                c.setDebano(rs.getDouble("DEBANO"));
                c.setCreano(rs.getDouble("CREANO"));
                c.setDebmes(rs.getDouble("DEBMES"));
                c.setCremes(rs.getDouble("CREMES"));
                c.setDebdia(rs.getDouble("DEBDIA"));
                c.setCredia(rs.getDouble("CREDIA"));
                c.setIndica(rs.getInt("INDICA"));
                c.setSalin2(rs.getDouble("SALIN2"));
                c.setDebme2(rs.getDouble("DEBME2"));
                c.setAntme2(rs.getDouble("ANTME2"));
                c.setCreme2(rs.getDouble("CREME2"));
                c.setSalac2(rs.getDouble("SALAC2"));
                c.setFecha(rs.getString("FECHA"));
                c.setNompre(rs.getDouble("NOMPRE"));
                c.setDeban2(rs.getDouble("DEBAN2"));
                c.setCrean2(rs.getDouble("CREAN2"));
                c.setAntdi2(rs.getDouble("ANTDI2"));
                c.setDebdi2(rs.getDouble("DEBDI2"));
                c.setCredi2(rs.getDouble("CREDI2"));
                c.setFecha2(rs.getString("FECHA2"));
            }            
        } catch (SQLException e) {
            System.out.println("Error...! ConmaeDao.getConmae(): "+e.getMessage());
        }
        conexion.cerrar_conexion();
        return c;
    }
    public boolean modifyConmae(Conmae c){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        String sql = "UPDATE CONMAE SET GRUP=?, SUBGRU=?, MAYOR=?, CUENTA=?, SUBCTA=?, CUETOT=?, NUMCUE=?, DESCRI=?, ACTIVI=?, NIVEL=?, LUGAR=?, PRESUP=?, SALINI=?, ANTDIA=?, ANTMES=?, SALACT=?, DEBANO=?, CREANO=?, DEBMES=?, CREMES=?, DEBDIA=?, CREDIA=?, INDICA=?, SALIN2=?, DEBME2=?, ANTME2=?, CREME2=?, SALAC2=?, FECHA=?, NOMPRE=?, DEBAN2=?, CREAN2=?, ANTDI2=?, DEBDI2=?, CREDI2=?, FECHA2=? WHERE `ID`='"+c.getId()+"';".toLowerCase();
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            
            ps.setInt(1, c.getGrup());
            ps.setInt(2, c.getSubgru());
            ps.setInt(3, c.getMayor());
            ps.setInt(4, c.getCuenta());
            ps.setInt(5, c.getSubcta());
            ps.setLong(6, c.getCuetot());
            ps.setInt(7, c.getNumcue());            
            ps.setString(8, c.getDescri());
            ps.setInt(9, c.getActivi());
            ps.setInt(10, c.getNivel());
            ps.setInt(11, c.getLugar());
            ps.setInt(12, c.getPresup());
            ps.setDouble(13, c.getSalini());
            ps.setDouble(14, c.getAntdia());
            ps.setDouble(15, c.getAntmes());
            ps.setDouble(16, c.getSalact());
            ps.setDouble(17, c.getDebano());
            ps.setDouble(18, c.getCreano());
            ps.setDouble(19, c.getDebmes());
            ps.setDouble(20, c.getCremes());
            ps.setDouble(21, c.getDebdia());
            ps.setDouble(22, c.getCredia());
            ps.setInt(23, c.getIndica());
            ps.setDouble(24, c.getSalin2());
            ps.setDouble(25, c.getDebme2());
            ps.setDouble(26, c.getAntme2());
            ps.setDouble(27, c.getCreme2());
            ps.setDouble(28, c.getSalac2());
            ps.setString(29, c.getFecha());
            ps.setDouble(30, c.getNompre());
            ps.setDouble(31, c.getDeban2());
            ps.setDouble(32, c.getCrean2());
            ps.setDouble(33, c.getAntdi2());
            ps.setDouble(34, c.getDebdi2());
            ps.setDouble(35, c.getCredi2());
            ps.setString(36, c.getFecha2());
            
            int estado = ps.executeUpdate();
            if(estado > 0)
                verificador = true;
        } catch (SQLException e) {
            System.out.println("Error ConmaeDao.modifyConmae(): "+e.getMessage());
        }
        conexion.cerrar_conexion();
        return verificador;
    }
    public boolean deleteConmae(Conmae c){
        boolean verificador = false;
        String sql = "DELETE FROM conmae WHERE ID = "+c.getId();
        Conexion conexion = new Conexion();
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            int estado = ps.executeUpdate();
            if(estado > 0)
                verificador = true;
            
        } catch (SQLException e) {
            System.out.println("Error ConmaeDao.deleteConmae(): "+e.getMessage());
        }
        conexion.cerrar_conexion();
        return verificador;
    }
    public boolean removeAll(){
        boolean verificador = false;
        String sql = "TRUNCATE TABLE conmae";
        Conexion conexion = new Conexion();
        try {
            PreparedStatement ps = conexion.getConexion().prepareStatement(sql);
            int estado = ps.executeUpdate();
            if(estado > 0)
                verificador = true;
            
        } catch (SQLException e) {
            System.out.println("Error ConmaeDao.removeAll(): "+e.getMessage());
        }
        conexion.cerrar_conexion();
        return verificador;
    }
}

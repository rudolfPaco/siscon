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
import java.sql.SQLException;

/**
 *
 * @author neo
 */
public class ContraDao {
    
    public boolean saveContra(Contra c){
        boolean verificador = false;
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO CONTRA VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
}

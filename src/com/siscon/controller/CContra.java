/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.controller;

import com.siscon.dao.ConmaeDao;
import com.siscon.dao.ContraDao;
import com.siscon.model.Conmae;
import com.siscon.model.Contra;
import java.util.ArrayList;

/**
 *
 * @author neo
 */
public class CContra {


    public static boolean guardarContra(Contra contra){
        boolean verificador = false;
        ContraDao contraDao = new ContraDao();
        if(contraDao.saveContra(contra))
            verificador = true;
        return verificador;
    }
    public static boolean modificarContra(Contra contra){
        boolean verificador = false;
        ContraDao contraDao = new ContraDao();
        if(contraDao.modifyContra(contra))
            verificador = true;
        return verificador;
    }
    public static boolean eliminarContra(Contra contra){
        boolean verificador = false;
        ContraDao contraDao = new ContraDao();
        if(contraDao.deleteContra(contra))
            verificador = true;
        return verificador;
    }
    public static Contra getContra(String sql){
        ContraDao conmaeDao = new ContraDao();
        return conmaeDao.getContra(sql);
    }
    public static ArrayList<Contra> getListaContra(String sql){
        ContraDao contraDao = new ContraDao();
        return contraDao.getAllList(sql);
    }
    public static boolean eliminarTodoContra(){
        boolean verificador = false;
        ContraDao contraDao = new ContraDao();
        if(contraDao.removeAll())
            verificador = true;
        return verificador;
    }
}

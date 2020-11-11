/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.controller;

import com.siscon.dao.ConmaeDao;
import com.siscon.model.Conmae;
import java.util.ArrayList;

/**
 *
 * @author neo
 */
public class CConmae {
    
    public static ArrayList<Conmae> getLista(String sql){
        ConmaeDao conmaeDao = new ConmaeDao();
        return conmaeDao.getAllList(sql);
    }
    public static Conmae getConmae(String sql){
        ConmaeDao conmaeDao = new ConmaeDao();
        return conmaeDao.getConmae(sql);
    }
    public static boolean guardarConmae(Conmae conmae){
        boolean verificador = false;
        ConmaeDao conmaeDao = new ConmaeDao();
        if(conmaeDao.saveConmae(conmae))
            verificador = true;
        return verificador;
    }
    public static boolean modificarConmae(Conmae conmae){
        boolean verificador = false;
        ConmaeDao conmaeDao = new ConmaeDao();
        if(conmaeDao.modifyConmae(conmae))
            verificador = true;
        return verificador;
    }
    public static boolean eliminarConmae(Conmae conmae){
        boolean verificador = false;
        ConmaeDao conmaeDao = new ConmaeDao();
        if(conmaeDao.deleteConmae(conmae))
            verificador = true;
        return verificador;
    }
    public static boolean eliminarTodoConmae(){
        boolean verificador = false;
        ConmaeDao conmaeDao = new ConmaeDao();
        if(conmaeDao.removeAll())
            verificador = true;
        return verificador;
    }
}

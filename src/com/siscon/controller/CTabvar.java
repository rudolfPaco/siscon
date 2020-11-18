/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.controller;

import com.siscon.dao.TabvarDao;
import com.siscon.model.Tabvar;
import java.util.ArrayList;

/**
 *
 * @author neo
 */
public class CTabvar {

    public static ArrayList<Tabvar> getLista(String sql){
        TabvarDao tabvarDao = new TabvarDao();
        return tabvarDao.getAllList(sql);
    }
    
    public static Tabvar getTabvar(int tipo, int numero){
        TabvarDao tabvarDao = new TabvarDao();
        return tabvarDao.getTabvar("SELECT * FROM TABVAR WHERE TIPO = "+tipo+" AND NUMERO = "+numero);
    }
    public static Tabvar getTabvar(String sql){
        TabvarDao tabvarDao = new TabvarDao();
        return tabvarDao.getTabvar(sql);
    }
    public static String getObservacion(int tipo){
        String observacion = "";
        TabvarDao tabvarDao = new TabvarDao();        
        try {
            observacion = tabvarDao.getTabvar("SELECT * FROM TABVAR WHERE TIPO = "+tipo).getObserv();
        } catch (Exception e) {}        
        return observacion;
    }
    public static boolean guardarTabvar(Tabvar tabvar){
        boolean verificador = false;
        TabvarDao tabvarDao = new TabvarDao();
        if(tabvarDao.saveTabvar(tabvar))
            verificador = true;
        return verificador;
    }
    public static boolean modificarTabvar(Tabvar tabvar){
        boolean verificador = false;
        TabvarDao tabvarDao = new TabvarDao();
        if(tabvarDao.modifyTabvar(tabvar))
            verificador = true;
        return verificador;
    }
    public static boolean eliminarTabvar(Tabvar tabvar){
        boolean verificador = false;
        TabvarDao tabvarDao = new TabvarDao();
        if(tabvarDao.deleteTabvar(tabvar))
            verificador = true;
        return verificador;
    }
}

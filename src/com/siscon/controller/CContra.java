/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.controller;

import com.siscon.dao.ContraDao;
import com.siscon.model.Contra;

/**
 *
 * @author neo
 */
public class CContra {


    public static boolean guardarConmae(Contra contra){
        boolean verificador = false;
        ContraDao contraDao = new ContraDao();
        if(contraDao.saveContra(contra))
            verificador = true;
        return verificador;
    }
}

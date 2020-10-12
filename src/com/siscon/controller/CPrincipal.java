/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.controller;

import SIGU.main.Principal;
import com.siscon.view.VPrincipal;
import com.siscon.view.tabvar.VTabvar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author neo
 */
public class CPrincipal {
    
    public static void main(String[] arg){
        
        try {
            // setTheme(String themeName, String licenseKey, String logoString)
            //com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Green", "INSERT YOUR LICENSE KEY HERE", "my company");
            UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        VPrincipal iuPrincipal = new VPrincipal("SISTEMA CONTABILIDAD SISCON @Version v7.1. 2020", "/imagenes/icono.png");
        iuPrincipal.mostrar();
        
    }
    
}

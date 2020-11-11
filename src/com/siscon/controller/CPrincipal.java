/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.controller;

import SIGU.main.Principal;
import com.siscon.view.VLogueo;
import com.siscon.view.VPrincipal;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Green", "INSERT YOUR LICENSE KEY HERE", "my company");
            UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        VLogueo iuLogueo = new VLogueo(null, "Sistema Contable SISCON Ver. 7.2 ® Diseño: Juan Jose Caballero Reyna | Programacion: Rudolf Felipez Mancilla", "grande");
        iuLogueo.mostrarVentana();
        if(iuLogueo.getEstado()){
            VPrincipal iuPrincipal = new VPrincipal(iuLogueo.getTabvar(), iuLogueo.getUsuario(), "Sistema Contable SISCON Ver. 7.2 ® Diseño: Juan Jose Caballero Reyna | Programacion: Rudolf Felipez Mancilla" , "/imagenes/icono.png");
            iuPrincipal.mostrar();
        }        
    }
}

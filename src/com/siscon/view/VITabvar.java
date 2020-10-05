/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view;

import SIGU.paneles.SIUPanel;
import SIGU.recursos.Arena;
import SIGU.recursos.Grid;
import SIGU.ventanas.SIUSecundario;
import java.awt.Color;

/**
 *
 * @author neo
 */
public class VITabvar extends SIUSecundario{
    
    private SIUPanel panelTitulo;
    private SIUPanel panelDatos;
    private SIUPanel panelBotones;
    
    public VITabvar(VPrincipal ventanaPrincipal, String tipoSize) {
        super(ventanaPrincipal, tipoSize);
        
        construirPaneles();
    }
    private void construirPaneles(){
        panelTitulo = new SIUPanel(this, new Grid(0, 0, 12, 2));
        panelTitulo.setColorFondo(Color.orange, 1);
        
    }
}

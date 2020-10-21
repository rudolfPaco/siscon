/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.recursos;

import SIGU.etiquetas.SIUEtiqueta;
import SIGU.paneles.SIUPanel;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class SIULinea extends JSeparator{
    
    private SIUPanel panel;
    private SIUEtiqueta etiqueta;
    private Grid grid;
    private Color colorLinea;
    
    public SIULinea(SIUPanel panel, Grid grid, Color colorLinea){
        super(SwingConstants.HORIZONTAL);
        this.panel = panel;
        this.etiqueta = null;             
        this.grid = grid;
        this.colorLinea = colorLinea;
        
        construirLinea();
    }
    public SIULinea(SIUEtiqueta etiqueta, Grid grid, Color colorLinea){
        super(SwingConstants.HORIZONTAL);
        this.etiqueta = etiqueta;
        this.panel = null;
        this.grid = grid;
        this.colorLinea = colorLinea;
        
        construirLinea();
    }
    private void construirLinea(){
        if(panel != null)
            panel.agregar(this, grid);
        if(etiqueta != null)
            etiqueta.agregar(this, grid);
        
        setForeground(colorLinea);        
    }
}

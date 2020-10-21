/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.etiquetas;

import SIGU.paneles.IUPanel;
import SIGU.paneles.SIUPanel;
import SIGU.recursos.Area;
import SIGU.recursos.Grid;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class IULinea extends JSeparator{
    private IUPanel panel;
    private IUEtiqueta etiqueta;
    private Area area;
    private Color colorLinea;
    
    public IULinea(IUPanel panel, Area area, Color colorLinea){
        super(SwingConstants.HORIZONTAL);
        this.panel = panel;
        this.etiqueta = null;             
        this.area = area;
        this.colorLinea = colorLinea;
        
        construirLinea();
    }
    public IULinea(IUEtiqueta etiqueta, Area area, Color colorLinea){
        super(SwingConstants.HORIZONTAL);
        this.etiqueta = etiqueta;
        this.panel = null;
        this.area = area;
        this.colorLinea = colorLinea;
        
        construirLinea();
    }
    private void construirLinea(){
        if(panel != null)
            panel.agregar(this, area);
        if(etiqueta != null)
            etiqueta.agregar(this, area);
        
        setForeground(colorLinea);        
    }
}

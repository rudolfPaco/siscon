/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.campoTexto;

import SIGU.paneles.IUPanel;
import SIGU.recursos.Area;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 * 
 * @author rudolf
 */
public class IUAreaTexto extends JTextArea{
    
    private IUPanel panel;
    private Area area;
    private final int size;
    private Border bordeComponente;

    /**
     *
     * @param panel
     * @param area
     * @param texto
     * @param size
     */
    public IUAreaTexto(IUPanel panel, Area area, String texto, int size){
        super(texto);
        this.panel = panel;
        this.area = area;
        this.size = size;
                        
        construirAreaTexto();        
    }    
    private void construirAreaTexto(){       
        
        panel.agregar(this, area);
        setSelectionColor(new Color(0, 0, 0, 0));
        setFont(new Font("Verdana", Font.PLAIN, size));
        setSelectedTextColor(new Color(2, 67, 109));        
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(false);
        setForeground(new Color(2, 67, 109));        
        setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.WHITE, Color.LIGHT_GRAY, Color.WHITE));
        setBordeComponente(getBorder());
    }
    public void setTextoEditable(boolean editable){
        setEditable(editable);
        setFocusable(editable);
    }

    public Border getBordeComponente() {
        return bordeComponente;
    }

    public void setBordeComponente(Border bordeComponente) {
        this.bordeComponente = bordeComponente;
    }
    
}

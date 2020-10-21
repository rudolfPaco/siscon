/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.etiquetas;

import SIGU.paneles.IUPanel;
import SIGU.recursos.Area;
import SIGU.recursos.Grid;
import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author neo
 */
public class IUEtiqueta extends JLabel{
    private IUPanel panel;
    public Area area;
    private int size;
    private String posicion;
    private Color colorTexto;
    private IULinea linea;
    private boolean tachado = false;
    private boolean isBorde;
    private Border border = new LineBorder(Color.LIGHT_GRAY);
    
    public IUEtiqueta(String texto){
        super(texto);        
    }
    /**
     * Interfaz de Usuario Etiqueta, hereda atributos y metodos del componente JLabel.
     * @param panel componente padre
     * @param texto cadena de caractares, que se mostrara en el componente.
     * @param area sistema de posicion
     * @param size tamaño de letra
     * @param posicion LEFT, RIGHT, CENTER establece la pasicion horizontal
     * @param isBorde
     */
    public IUEtiqueta(IUPanel panel, String texto, Area area, int size, String posicion, boolean isBorde){
        super(texto);
        this.panel = panel;
        this.area = area;
        this.size = size;
        this.posicion = posicion;
        this.isBorde = isBorde;
        this.colorTexto = new Color(2, 67, 109);        
        construirEtiqueta();        
        
    }
    public IUEtiqueta(IUPanel panel, String texto, Area area, int size, String posicion, Color colorTexto){
        super(texto);
        this.panel = panel;
        this.area = area;
        this.size = size;
        this.posicion = posicion;
        this.colorTexto = colorTexto;
        
        construirEtiqueta();        
    }
    private void construirEtiqueta(){        
        panel.agregar(this, area);
        
        setOpaque(false);
        setLayout(null);
        setFocusable(false);
        setToolTipText("");
        switch(posicion){            
            case "LEFT":
                setHorizontalAlignment(SwingConstants.LEFT);
            break;
            case "RIGHT":
                setHorizontalAlignment(SwingConstants.RIGHT);
            break;
            case "CENTER":
                setHorizontalAlignment(SwingConstants.CENTER);
            break;
            
        }        
        if(isBorde){
            setBorder(border);
        }else{
            setBorder(null);
        }
        setFont(new Font("Verdana", Font.PLAIN, size));
        setForeground(colorTexto);
    } 
    public void agregar(JComponent componente, Area area){
        componente.setBounds(area.X(), area.Y(), area.An(), area.Al());
        add(componente);
    }
    public void setSubrayarTexto(boolean estado) {
        Map attributes = getFont().getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);        
        setFont(getFont().deriveFont(attributes));        
    }
    public void setTachar(boolean tachado){
        this.tachado = tachado;
        if(tachado){
            linea = new IULinea(this, new Area(0, 11, 12, 1), new Color(120, 0, 0));
        }else{
            linea = null;
        }
    }
}

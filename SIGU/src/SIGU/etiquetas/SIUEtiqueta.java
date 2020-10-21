/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.etiquetas;

import SIGU.paneles.SIUPanel;
import SIGU.recursos.Grid;
import SIGU.recursos.SIULinea;
import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class SIUEtiqueta extends JLabel{
    private SIUPanel panel;
    private Grid grid;
    private int size;
    private String posicion;
    private Color colorTexto;
    private SIULinea linea;
    private boolean tachado = false;
    
    /**
     * Interfaz de Usuario Etiqueta, hereda atributos y metodos del componente JLabel.
     * @param panel componente padre
     * @param texto cadena de caractares, que se mostrara en el componente.
     * @param grid sistema de posicion
     * @param size tamaño de letra
     * @param posicion LEFT, RIGHT, CENTER establece la pasicion horizontal
     */
    public SIUEtiqueta(SIUPanel panel, String texto, Grid grid, int size, String posicion){
        super(texto);
        this.panel = panel;
        this.grid = grid;
        this.size = size;
        this.posicion = posicion;
        this.colorTexto = new Color(2, 67, 109);
        
        construirEtiqueta();        
    }
    public SIUEtiqueta(SIUPanel panel, String texto, Grid grid, int size, String posicion, Color colorTexto){
        super(texto);
        this.panel = panel;
        this.grid = grid;
        this.size = size;
        this.posicion = posicion;
        this.colorTexto = colorTexto;
        
        construirEtiqueta();        
    }
    private void construirEtiqueta(){
        
        if(panel instanceof SIUPanel){
            ((SIUPanel)panel).agregar(this, grid);
        }        
        
        setOpaque(false);
        setLayout(null);
        setFocusable(false);
        setToolTipText("");
        switch(posicion){
            case "":
            break;
            
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
        setFont(new Font("Verdana", Font.PLAIN, size));
        setForeground(colorTexto);
    } 
    public void agregar(JComponent componente, Grid gridComponente){
        componente.setBounds(grid.getX(), grid.getY(), grid.getAncho(), grid.getAlto());
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
            linea = new SIULinea(this, new Grid(0, 11, 12, 1), new Color(120, 0, 0));
        }else{
            linea = null;
        }
    }
}

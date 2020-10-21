/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.botones;

import SIGU.paneles.IUPanel;
import SIGU.paneles.SIUPanel;
import SIGU.recursos.Area;
import SIGU.recursos.Grid;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

/**
 *
 * @author neo
 */
public class IUBotonRadio extends JRadioButton{
    private Color colorSeleccionado;
    private Color colorNoSeleccionado;
    private IUPanel panel;
    private Area area;
    private int size;
    
    public IUBotonRadio(IUPanel panel, Area area, String texto, int size, boolean estado){
        super(texto, estado);
        this.panel = panel;
        this.area = area;
        this.size = size;
        this.colorSeleccionado = new Color(2, 67, 109);
        this.colorNoSeleccionado = Color.LIGHT_GRAY;
        
        construirBotonRadio();
        agregarEvento();
        
    }
    private void construirBotonRadio(){        
        panel.agregar(this, area);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setHorizontalTextPosition(SwingConstants.RIGHT);
        setIconTextGap(7);
        setFocusable(false);        
        setOpaque(false);
        setFont(new Font("Verdana", Font.PLAIN, size));
        setMargin(new Insets(1, 1, 1, 1));
        //setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.WHITE, Color.LIGHT_GRAY, Color.WHITE));
        
        if(isSelected())
            setForeground(colorSeleccionado);        
        else
            setForeground(colorNoSeleccionado);
    }
    private void agregarEvento(){
        addItemListener((ItemEvent e) -> {
            if(isSelected())
                setForeground(colorSeleccionado);            
            else
                setForeground(colorNoSeleccionado);
        });
    }

    /**
     * metodo que modifica los colores al momento de seleccionar o deseleccionar el componente.
     * @param colorSeleccionado el componente se pinta del colorSeleccionado si y solamente si esta seleccionado.
     * @param colorNoSeleccionado el componente se pinta del colorNoSeleccionado si y solamente si no esta seleccionado.
     */
    public void setColoresEstado(Color colorSeleccionado, Color colorNoSeleccionado){
        this.colorSeleccionado = colorSeleccionado;
        this.colorNoSeleccionado = colorNoSeleccionado;
        construirBotonRadio();
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.paneles;

import SIGU.recursos.Area;
import SIGU.recursos.Grid;
import SIGU.ventanas.IUPrincipal;
import SIGU.ventanas.IUSecundario;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author neo
 */
public class IUPanel extends JPanel{
    private IUPrincipal ventana;
    private IUSecundario secundario;
    private IUPanel panel;
        
    private Color colorFondo;
    private int arco;
    private boolean isBorde = false;   

    private Border border = new LineBorder(Color.LIGHT_GRAY);
    public Area area;
    
    public IUPanel(){
        super(null);        
        this.colorFondo = Color.WHITE;
    }
    
    /**
     *
     * @param secundario
     * @param area
     * @param isBorde
     */
    public IUPanel(IUSecundario secundario, Area area, boolean isBorde){
        super(null);
        this.secundario = secundario;
        this.panel = null;
        this.ventana = null;
        this.area = area;
        this.isBorde = isBorde;
        this.colorFondo = Color.WHITE;
        construirPanel();        
    }
    
    /**
     * panel sin borde y sin el foco.
     * @param ventana
     * @param area     
     * @param isBorde     
     */
    public IUPanel(IUPrincipal ventana, Area area, boolean isBorde){
        super(null);
        this.ventana = ventana;
        this.panel = null;
        this.secundario = null;
        this.area = area;
        this.isBorde = isBorde;
        this.colorFondo = Color.WHITE;        
        construirPanel();        
    }
    
    /**     
     * @param panel
     * @param area
     * @param addBorde
     */
    public IUPanel(IUPanel panel, Area area, boolean addBorde){
        super(null);
        this.panel = panel;
        this.area = area;
        this.ventana = null;
        this.secundario = null;
        this.isBorde = addBorde;
        this.colorFondo = Color.WHITE;
        
        construirPanel();
    }

    /**
     *
     * @param panel
     * @param area
     * @param addBorde
     * @param colorFondo
     */
    public IUPanel(IUPanel panel, Area area, boolean addBorde, Color colorFondo){
        super(null);
        this.panel = panel;
        this.area = area;
        this.ventana = null;
        this.secundario = null;
        this.isBorde = addBorde;
        this.colorFondo = colorFondo;
        
        construirPanel();        
    }
    private void construirPanel(){
        if(ventana != null){            
            ventana.agregar(this, area);
        }
        if(secundario != null){            
            secundario.agregar(this, area);
        }
        if(panel != null){            
            panel.agregar(this, area);
        }
        setFocusable(false);        
        setBackground(colorFondo);
        if(isBorde){
            setBorder(border);
        }else{
            setBorder(null);
        }
    }   
    
    public void agregar(JComponent componente, Area area){
        componente.setBounds(area.X(), area.Y(), area.An(), area.Al());
        add(componente);        
    }
    
    public void mostrarDimensiones(){
        JLabel label = new JLabel("w:"+getWidth()+" h:"+getHeight());
        label.setFont(new Font("Arial", Font.PLAIN, 10));
        label.setBounds(getWidth() - 80, 0, 80, 10);
        add(label);        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.paneles;

import SIGU.etiquetas.IUEtiqueta;
import SIGU.recursos.Area;
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
public class IUPanelDobleEtiqueta extends JPanel{
    
    private IUPanel panel;
    private IUEtiqueta etiqueta1;
    private IUEtiqueta etiqueta2;
    private final int posicionHorizontal2;
        
    private Color colorFondo;
    private boolean isBorde = false;   

    private Border border = new LineBorder(Color.LIGHT_GRAY);
    public Area area;
    private String texto1;
    private final String texto2;
    private final Area areaEtiqueta;
    private final int anchoP1;
    private final int anchoP2;
    private int size;
    private int posicionHorizontal1;
           
    /**     
     * @param panel
     * @param area
     * @param texto1
     * @param texto2
     * @param areaEtiqueta
     * @param anchoP1
     * @param anchoP2
     * @param size
     * @param posicionHorizontal1
     * @param posicionHorizontal2
     * @param colorFondo
     * @param addBorde
     */
    public IUPanelDobleEtiqueta(IUPanel panel, Area area, String texto1, String texto2, Area areaEtiqueta, int anchoP1, int anchoP2, int size, int posicionHorizontal1, int posicionHorizontal2, Color colorFondo, boolean addBorde){
        super(null);
        this.panel = panel;
        this.area = area;
        this.texto1 = texto1;
        this.texto2 = texto2;
        this.areaEtiqueta = areaEtiqueta;
        this.anchoP1 = anchoP1;
        this.anchoP2 = anchoP2;
        this.size = size;
        this.posicionHorizontal1 = posicionHorizontal1;
        this.posicionHorizontal2 = posicionHorizontal2;
        this.colorFondo = colorFondo;
        this.isBorde = addBorde;
        
        construirPanel();
    }
    private void construirPanel(){
        panel.agregar(this, area);
        setFocusable(false);        
        setBackground(colorFondo);
        if(isBorde){
            setBorder(border);
        }else{
            setBorder(null);
        }
        etiqueta1 = new IUEtiqueta(texto1);
        etiqueta1.setLayout(null);
        etiqueta1.setBounds(areaEtiqueta.X(), areaEtiqueta.Y(), areaEtiqueta.AnP(anchoP1), areaEtiqueta.Al());
        etiqueta1.setForeground(new Color(2, 67, 109));
        etiqueta1.setFont(new Font("Verdana", Font.PLAIN, size));
        etiqueta1.setHorizontalAlignment(posicionHorizontal1);
        //etiqueta1.setBorder(new LineBorder(Color.BLUE));
        add(etiqueta1);
        
        etiqueta2 = new IUEtiqueta(texto2);
        etiqueta2.setLayout(null);
        etiqueta2.setBounds(areaEtiqueta.X(2) + areaEtiqueta.AnP(anchoP1), areaEtiqueta.Y(), areaEtiqueta.AnP(anchoP2), areaEtiqueta.Al());
        etiqueta2.setForeground(new Color(2, 67, 109));
        etiqueta2.setFont(new Font("Verdana", Font.PLAIN, size));
        etiqueta2.setHorizontalAlignment(posicionHorizontal2);
        //etiqueta2.setBorder(new LineBorder(Color.RED));
        add(etiqueta2);
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

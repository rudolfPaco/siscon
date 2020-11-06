/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.paneles;

import SIGU.etiquetas.IUEtiqueta;
import SIGU.recursos.Area;
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
public class IUPanelEtiqueta extends JPanel{
    private IUPanel panel;
    private IUEtiqueta etiqueta;
        
    private Color colorFondo;
    private boolean isBorde = false;   

    private Border border = new LineBorder(Color.LIGHT_GRAY);
    public Area area;
    private String texto;
    private int size;
    private int posicionHorizontal;
           
    /**     
     * @param panel
     * @param area
     * @param texto
     * @param size
     * @param posicionHorizontal
     * @param colorFondo
     * @param addBorde
     */
    public IUPanelEtiqueta(IUPanel panel, Area area, String texto, int size, int posicionHorizontal, Color colorFondo, boolean addBorde){
        super(null);
        this.panel = panel;
        this.area = area;
        this.texto = texto;
        this.size = size;
        this.posicionHorizontal = posicionHorizontal;
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
        etiqueta = new IUEtiqueta(texto);
        etiqueta.setLayout(null);
        etiqueta.setBounds(0, 0, getWidth(), getHeight());
        etiqueta.setForeground(new Color(2, 67, 109));
        etiqueta.setFont(new Font("Verdana", Font.PLAIN, size));
        etiqueta.setHorizontalAlignment(posicionHorizontal);
        add(etiqueta);
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
    public void setColores(Color colorTexto, Color colorFondo){
        etiqueta.setForeground(colorTexto);
        setBackground(colorFondo);
    }
    public void setFuente(Font fuente){
        etiqueta.setFont(fuente);
    }
    public String getTexto(){
        return etiqueta.getText();
    }
    public void setTexto(String texto){
        etiqueta.setText(texto);
    }
}

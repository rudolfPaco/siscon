/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.paneles;

import SIGU.recursos.Arena;
import SIGU.recursos.Grid;
import SIGU.ventanas.SIUPrincipal;
import SIGU.ventanas.SIUSecundario;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author rudolf
 */
public class SIUPanel extends JPanel{
    
    private SIUPrincipal ventana;
    private SIUSecundario secundario;
    private SIUPanel panel;
    
    private Grid grid;
    private boolean mostrarPuntos = false;
    private boolean mostrarColor = false;    
    private Color colorFondo;
    private int arco;
    private boolean addBorde = false;   

    private Border border = new LineBorder(Color.LIGHT_GRAY);
    
    public SIUPanel(SIUSecundario secundario, Grid grid){
        super(null);
        this.secundario = secundario;
        this.panel = null;
        this.grid = grid;
        
        construirPanel();
    }
    
    /**
     * panel sin borde y sin el foco.
     * @param ventana
     * @param grid     
     * @param addBorde     
     */
    public SIUPanel(SIUPrincipal ventana, Grid grid, boolean addBorde){
        super(null);
        this.ventana = ventana;
        this.panel = null;
        this.grid = grid;
        this.addBorde = addBorde;
        
        construirPanel();
    }
    
    /**     
     * @param panel
     * @param grid
     * @param addBorde
     */
    public SIUPanel(SIUPanel panel, Grid grid, boolean addBorde){
        super(null);
        this.panel = panel;
        this.ventana = null;
        this.grid = grid;
        this.addBorde = addBorde;
        
        construirPanel();        
    }
    private void construirPanel(){        
        if(panel != null){
            panel.agregar(this, grid);            
        }
        if(ventana != null){            
            ventana.agregar(this, grid);
        }
        if(secundario != null){            
            secundario.agregar(this, grid);
        }
        grid.setArea(new Arena(getWidth(), getHeight()));
        setFocusable(false);        
        setOpaque(false);        
        if(addBorde){
            setBorder(border);
        }else{
            setBorder(null);
        }
    }   
    
    public void agregar(JComponent componente, Grid gridComponente){
        componente.setBounds(grid.getAnchoCelda(gridComponente.getX()), grid.getAltoCelda(gridComponente.getY()), grid.getAnchoCelda(gridComponente.getAncho()), grid.getAltoCelda(gridComponente.getAlto()));
        add(componente);        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if(mostrarPuntos){
            g2.setColor( Color.BLACK);

            int[] filas = grid.getFilas();
            int[] columnas = grid.getColumnas(); 

            for (int i = 0; i < filas.length; i++) {
                for (int j = 0; j < columnas.length; j++) {
                    g2.drawString(".", columnas[j], filas[i]);
                }
            }
        }
        if(mostrarColor){
            GradientPaint gradiente = new GradientPaint( 0, 0, colorFondo, 0, getHeight(), colorFondo );

            g2.setPaint( gradiente );
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), arco, arco);
        }
    }
    public void mostrarPuntos(boolean mostrarPuntos){
        this.mostrarPuntos = mostrarPuntos;
        repaint();
    }
    public void setColorFondo(Color colorFondo, int arco){
        mostrarColor = true;
        this.colorFondo = colorFondo;
        this.arco = arco;
        repaint();
    }
    public void mostrarDimensiones(){
        JLabel label = new JLabel("w:"+getWidth()+" h:"+getHeight());
        label.setFont(new Font("Arial", Font.PLAIN, 10));
        label.setBounds(getWidth() - 80, 0, 80, 10);
        add(label);        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.ventanas;

import SIGU.paneles.SIUPanel;
import SIGU.recursos.Arena;
import SIGU.recursos.Grid;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author neo
 */
public class SIUPrincipal extends JFrame{  
    public SIUPanel contenedor;
    private final Arena area;
    private final Grid grid;
    private final int puntosHorizontales = 13;
    private final int puntoVerticales = 13;
    private final String urlIcono;
    
    public SIUPrincipal(String titulo, String urlIcono){
        super(titulo);        
        this.area = new Arena(1592, 871);
        this.grid = new Grid(area, puntosHorizontales, puntoVerticales);
        this.urlIcono = urlIcono;
        
        construirVentanaPrincipal();        
    }
    
    private void construirVentanaPrincipal(){        
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height));
        //setUndecorated(false);
        setAlwaysOnTop(true);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setIconImage(new ImageIcon(new ImageIcon(getClass().getResource(urlIcono)).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH)).getImage());
        
        contenedor = new SIUPanel(this, grid, true);
        contenedor.setBounds(0, 0, area.getAnchoArea(), area.getAltoArea());
        contenedor.setColorFondo(new Color(255, 255, 255), 1);        
        getContentPane().add(contenedor);
    }
    public void agregar(SIUPanel panel, Grid gridPanel){
        panel.setBounds(grid.getAnchoCelda(gridPanel.getX()), grid.getAltoCelda(gridPanel.getY()), grid.getAnchoCelda(gridPanel.getAncho()), grid.getAltoCelda(gridPanel.getAlto()));
        add(panel);        
    }
    public void mostrar(){
        setVisible(true);
    }
}

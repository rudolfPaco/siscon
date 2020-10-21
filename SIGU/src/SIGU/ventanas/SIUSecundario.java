/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.ventanas;

import SIGU.recursos.Arena;
import SIGU.recursos.Grid;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author neo
 */
public class SIUSecundario extends JDialog{
    
    private Arena area;
    private Grid grid;
    protected boolean estado;
    private int longitud = 13;
    private final String tipoSize;
    
    /**
     *
     * @param ventanaPrincipal
     * @param tipoSize
     */
    public SIUSecundario(JFrame ventanaPrincipal, String tipoSize){
        super(ventanaPrincipal, "ventana emergente", true);
        this.tipoSize = tipoSize;
        this.estado = false;
        
        construirVentanaSecundaria();        
    }
    private void construirVentanaSecundaria(){
        switch(tipoSize){
            case "grande":
                area = new Arena(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
            break;
            case "mediano":
                area = new Arena(Toolkit.getDefaultToolkit().getScreenSize().width - Toolkit.getDefaultToolkit().getScreenSize().width/7, Toolkit.getDefaultToolkit().getScreenSize().height - Toolkit.getDefaultToolkit().getScreenSize().height/7);
            break;
            case "intermedio":
                area = new Arena(Toolkit.getDefaultToolkit().getScreenSize().width - Toolkit.getDefaultToolkit().getScreenSize().width/3, Toolkit.getDefaultToolkit().getScreenSize().height - Toolkit.getDefaultToolkit().getScreenSize().height/7);
            break;
            case "pequeno":
                area = new Arena(Toolkit.getDefaultToolkit().getScreenSize().width/3 + Toolkit.getDefaultToolkit().getScreenSize().width/50, Toolkit.getDefaultToolkit().getScreenSize().height/2 + Toolkit.getDefaultToolkit().getScreenSize().height/50);
            break;
        }
        
        grid = new Grid(area, longitud, longitud);
        
        setSize(new Dimension(grid.getAnchoTotal(), grid.getAltoTota()));
        //setUndecorated(false);        
        setLocationRelativeTo(this);
        setAlwaysOnTop(true);        
        setResizable(false);
        setLayout(null);
    }
    public void agregar(JComponent componente, Grid gridComponente){
        componente.setBounds(grid.getX(), grid.getY(), grid.getAnchoTotal(), grid.getAltoTota());
        add(componente);        
    }
    public boolean getEstado(){
        return estado;
    }
    public void setEstado(boolean estado){        
        this.estado = estado;
    }
    public void mostrarVentana(){
        setVisible(true);
    }
}

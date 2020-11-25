/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.ventanas;

import SIGU.paneles.IUPanel;
import SIGU.recursos.Area;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author neo
 */
public class IUSecundario extends JDialog{
    private Area area;
    protected boolean estado;
    private final String tipoSize;
    
    /**
     *
     * @param ventanaPrincipal
     * @param titulo
     * @param tipoSize
     */
    public IUSecundario(JFrame ventanaPrincipal, String titulo, String tipoSize){
        super(ventanaPrincipal, titulo, true);
        this.tipoSize = tipoSize;
        this.estado = false;
        
        construirVentanaSecundaria();        
    }
    public IUSecundario(JDialog ventanaPrincipal, String titulo, String tipoSize){
        super(ventanaPrincipal, titulo, true);
        this.tipoSize = tipoSize;
        this.estado = false;
        
        construirVentanaSecundaria();        
    }
    private void construirVentanaSecundaria(){
        switch(tipoSize){
            case "grande":
                area = new Area(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
            break;
            case "semi-grande":
                area = new Area(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height - Toolkit.getDefaultToolkit().getScreenSize().height/7);
            break;
            case "medio-grande":
                area = new Area(Toolkit.getDefaultToolkit().getScreenSize().width - Toolkit.getDefaultToolkit().getScreenSize().width/2, Toolkit.getDefaultToolkit().getScreenSize().height);
            break;
            case "mediano":
                area = new Area(Toolkit.getDefaultToolkit().getScreenSize().width - Toolkit.getDefaultToolkit().getScreenSize().width/7, Toolkit.getDefaultToolkit().getScreenSize().height - Toolkit.getDefaultToolkit().getScreenSize().height/7);
            break;
            case "intermedio":
                area = new Area(Toolkit.getDefaultToolkit().getScreenSize().width - Toolkit.getDefaultToolkit().getScreenSize().width/3, Toolkit.getDefaultToolkit().getScreenSize().height - Toolkit.getDefaultToolkit().getScreenSize().height/7);
            break;
            case "pequeno":
                area = new Area(Toolkit.getDefaultToolkit().getScreenSize().width/3 + Toolkit.getDefaultToolkit().getScreenSize().width/50, Toolkit.getDefaultToolkit().getScreenSize().height/2 + Toolkit.getDefaultToolkit().getScreenSize().height/50);
            break;
            case "mini":
                area = new Area(Toolkit.getDefaultToolkit().getScreenSize().width/10, Toolkit.getDefaultToolkit().getScreenSize().height/20);
            break;
        }
        
        setSize(new Dimension(area.An(), area.Al()));
        setUndecorated(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(this);
        //setAlwaysOnTop(true);        
        setResizable(false);        
        setLayout(null);        
    }
    public void agregar(IUPanel panel, Area area){
        panel.setBounds(area.X(), area.Y(), area.An(), area.Al());
        add(panel);        
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
    public void cerrarVentana(){
        this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));        
    }
    public int An(){
        return area.An();
    }
    public int Al(){
        return area.Al();
    }
}

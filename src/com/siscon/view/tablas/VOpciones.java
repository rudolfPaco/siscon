/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.tablas;

import SIGU.botones.IUBoton;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.paneles.IUPanel;
import SIGU.paneles.IUPanelEtiqueta;
import SIGU.recursos.Area;
import SIGU.ventanas.IUSecundario;
import com.siscon.recursos.Ayuda;
import com.siscon.view.VPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class VOpciones extends IUSecundario{
    
    private VPrincipal ventanaPrincipal;
    
    private IUPanel panel;
        private IUPanelEtiqueta panelTitulo;        
        
    private IUPanel panelDatos;
        private IUBoton botonTabvar;
        private IUBoton botonConmae;
        
    private IUPanel panelBoton;
        private IUBoton botonSalir;
        
    private String titulo;
    private String OPCION;
    
    /**
     *
     * @param ventanaPrincipal
     * @param titulo
     * @param tipoSize
     */
    public VOpciones(VPrincipal ventanaPrincipal, String titulo, String tipoSize) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        this.titulo = titulo;
        this.OPCION = "PRIMERA";
        construirPaneles(new Area(An()-6, Al()-29));
        setEventos();
    }
    private void construirPaneles(Area a){
        panel = new IUPanel(this, new Area(a.X(), a.Y(), a.An(), a.Al()), true);        
        construirPanel(new Area(2, 2, panel.area.An() - 4, panel.area.Al() - 8));
    }
    private void construirPanel(Area a){
        
        panelTitulo = new IUPanelEtiqueta(panel, new Area(a.X(), a.Y(), a.An(), a.AlP(10)), "ELIJA UNA OPCION", 20, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        
        panelDatos = new IUPanel(panel, new Area(a.X(), a.Y(2) + a.AlP(10), a.An(), a.AlP(80)), true, Ayuda.COLOR_FONDO);
        construirPanelDatos(new Area(a.AnP(10), a.AlP(2), (panelDatos.area.An() - 2*a.AnP(10)), (panelDatos.area.Al() - 5*a.AlP(2))));        
        
        panelBoton = new IUPanel(panel, new Area(a.X(), a.Y(3) + a.AlP(90), a.An(), a.AlP(10)), true, Ayuda.COLOR_FONDO);
        construirPanelBoton(new Area(panelBoton.area.AnP(40), 2, panelBoton.area.An() - panelBoton.area.AnP(40)*2, panelBoton.area.Al() - 4));
    }
    private void construirPanelDatos(Area a){
        botonTabvar = new IUBoton(panelDatos, new Area(a.X(), a.Y(), a.An(), a.AlP(25)), "TABLA [TABVAR]", "/imagenes/table.png", 20, 50, 30, SwingConstants.RIGHT, SwingConstants.CENTER, '0', "");        
        botonTabvar.setBackground(Ayuda.COLOR_ATENCION);
        botonConmae = new IUBoton(panelDatos, new Area(a.X(), a.Y(2) + a.AlP(25), a.An(), a.AlP(25)), "TABLA [CONMAE]", "/imagenes/table.png", 20, 50, 30, SwingConstants.RIGHT, SwingConstants.CENTER, '0', "");
    }
    private void construirPanelBoton(Area a){
        botonSalir = new IUBoton(panelBoton, new Area(a.X(), a.Y(), a.An(), a.Al()), "Salir", "/imagenes/cerrar.png", 16, 30, 20, SwingConstants.RIGHT, SwingConstants.CENTER, '{', "");        
        botonSalir.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "ESC" );        
    }
    private void setEventos(){
        botonSalir.getActionMap().put( "ESC", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                botonSalir.doClick();
                dispose();
            }
        });
        botonSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
            }
        });
        panel.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_UP, 0 ), "UP" );
        panel.getActionMap().put( "UP", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                botonTabvar.setBackground(Ayuda.COLOR_ATENCION);
                botonConmae.setBackground(null);
                OPCION = "PRIMERA";
            }
        });
        panel.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_DOWN, 0 ), "DOWN" );
        panel.getActionMap().put( "DOWN", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                botonConmae.setBackground(Ayuda.COLOR_ATENCION);
                botonTabvar.setBackground(null);
                OPCION = "SEGUNDA";
            }
        });
        panel.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ENTER, 0 ), "ENTER" );
        panel.getActionMap().put( "ENTER", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                switch(OPCION){
                    case "PRIMERA":
                        VTablaTabvar  iuTabvar = new VTablaTabvar(ventanaPrincipal, titulo, "grande");
                        iuTabvar.mostrarVentana();
                        dispose();
                    break;
                    case "SEGUNDA":
                        VTablaConmae iuComnae = new VTablaConmae(ventanaPrincipal, titulo, "grande");
                        iuComnae.mostrarVentana();
                        dispose();
                    break;
                }
            }
        });        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.mensajes;

import SIGU.botones.IUBoton;
import SIGU.campoTexto.IUAreaTexto;
import SIGU.campoTexto.IUCampoTexto;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.paneles.IUPanel;
import SIGU.paneles.IUPanelEtiqueta;
import SIGU.recursos.Area;
import SIGU.recursos.Fecha;
import SIGU.ventanas.IUSecundario;
import com.siscon.model.Tabvar;
import com.siscon.model.Usuario;
import com.siscon.recursos.Ayuda;
import com.siscon.view.VPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author neo
 */
public class IUMensaje extends IUSecundario{
    private VPrincipal ventanaPrincipal;
    private String titulo;
    
    private IUPanel panel;
        private IUPanel panelDatos;
            private IUPanelEtiqueta iuTitulo;
            private IUEtiqueta iuSubTitulo;
            private IUAreaTexto iuMensaje;
            private IUBoton botonAceptar;
            private IUBoton botonNo;
            private IUBoton botonSi;
        
    private String mensaje;
    private String tipo;
    
    
    
    public IUMensaje(VPrincipal ventanaPrincipal, String titulo, String tipoSize, String mensaje, String tipo) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        this.mensaje = mensaje;
        this.tipo = tipo;
        
        construirPanel(new Area(An()-6, Al()-29));
        algoritmosInicial();
        
    }
    private void construirPanel(Area a){
        panel = new IUPanel(this, new Area(a.X(), a.Y(), a.An(), a.Al()), true);
        construirPaneles(new Area(panel.area.AnP(30), panel.area.AlP(25), panel.area.An() - panel.area.AnP(30)*2, panel.area.Al() - panel.area.AlP(25)*2));        
    }
    private void construirPaneles(Area a){        
        panelDatos = new IUPanel(panel, new Area(a.X(), a.Y(), a.An(), a.Al()), false, Ayuda.COLOR_FONDO);
        construirPanelDatos(new Area(panelDatos.area.AnP(1), panelDatos.area.AlP(1), panelDatos.area.An() - panelDatos.area.AnP(1)*2, panelDatos.area.Al() - panelDatos.area.AlP(1)*2));
    }
    private void construirPanelDatos(Area a){
        iuTitulo = new IUPanelEtiqueta(panelDatos, new Area(a.X(), a.Y(), a.An(), a.AlP(20)), tipo.toUpperCase(), 34, SwingConstants.CENTER, Ayuda.COLOR_FONDO, false);
        iuTitulo.setColores(Ayuda.COLOR_ROJO, Ayuda.COLOR_FONDO);
        
        iuMensaje = new IUAreaTexto(panelDatos, new Area(a.X() + a.AnP(10), a.Y(2) + a.AlP(30), a.An() - a.AnP(10)*2, a.AlP(30)), mensaje, 24);
        iuMensaje.setBorder(null);
        iuMensaje.setEditable(false);
        
        botonAceptar = new IUBoton(panelDatos, new Area(a.X() + a.AnP(25), a.Y(3) + a.AlP(70), a.AnP(50), a.AlP(20)), "aceptar", "", 24, 0, 0, SwingConstants.CENTER, SwingConstants.CENTER, '0', "");
        botonAceptar.setVisible(false);
        botonNo = new IUBoton(panelDatos, new Area(a.X() + a.AnP(20), a.Y(3) + a.AlP(70), a.AnP(20), a.AlP(20)), "NO", "", 24, 0, 0, SwingConstants.CENTER, SwingConstants.CENTER, '0', "");
        botonNo.setVisible(false);
        botonSi = new IUBoton(panelDatos, new Area(a.X() + a.AnP(60), a.Y(3) + a.AlP(70), a.AnP(20), a.AlP(20)), "SI", "", 24, 0, 0, SwingConstants.CENTER, SwingConstants.CENTER, '0', "");
        botonSi.setVisible(false);
        
    }
    private void algoritmosInicial(){
        panel.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "ESC" );
        panel.getActionMap().put( "ESC", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){
                dispose();
            }
        });
        
        botonAceptar.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ENTER, 0 ), "ENTER" );
        botonAceptar.getActionMap().put( "ENTER", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){
                setEstado(true);
                dispose();
            }
        });
        botonAceptar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setEstado(true);
                dispose();
            }
        });
        
        botonSi.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ENTER, 0 ), "ENTER" );
        botonSi.getActionMap().put( "ENTER", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){
                setEstado(true);
                dispose();
            }
        });
        botonSi.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setEstado(true);
                dispose();
            }
        });
        
        botonNo.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "ESC" );
        botonNo.getActionMap().put( "ESC", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                dispose();
            }
        });
        botonNo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
            }
        });
        switch(tipo){
            case "correcto":
                botonAceptar.setVisible(true);
            break;
            case "pregunta":
                botonSi.setVisible(true);
                botonNo.setVisible(true);
            break;
            case "error":
                botonAceptar.setVisible(true);
            break;
            case "informacion":
                botonAceptar.setVisible(true);
            break;
        }
    }
}

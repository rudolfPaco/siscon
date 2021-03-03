/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.integracionSistemas;

import SIGU.botones.IUBoton;
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
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class VIntegracionSistemas extends IUSecundario{
    private VPrincipal ventanaPrincipal;
    private String titulo;
    
    private IUPanel panel;
        private IUPanel panelTitulo;
        private IUEtiqueta iuTitulo;
    
    private IUPanel panelDatos;
        private IUPanel primerPanel;
            private IUPanel panelContenedor;
                private IUPanelEtiqueta panelTituloC;
                private IUPanel panelDatosC;
                    private IUBoton boton27_1;
                    private IUBoton boton27_2;
                    private IUBoton boton27_3;
                    private IUBoton boton27_4;
        
    private Usuario usuario;
    private Tabvar tabvar;
    
    public VIntegracionSistemas(VPrincipal ventanaPrincipal, String titulo, String tipoSize, Usuario usuario, Tabvar tabvar) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        this.usuario = usuario;
        this.tabvar = tabvar;
        
        construirPanel(new Area(An()-6, Al()-29));
        setEventos();
        algoritmosInicial();
    }
    private void construirPanel(Area a){
        panel = new IUPanel(this, new Area(a.X(), a.Y(), a.An(), a.Al()), true);
        construirPaneles(new Area(2, 2, panel.area.An() - 4, panel.area.Al() - 4));        
    }
    private void construirPaneles(Area a){
        panelTitulo = new IUPanel(panel, new Area(a.X(), a.Y(), a.An(), a.AlP(7)), true, Ayuda.COLOR_FONDO);
        construirPanelTitulo(new Area(panelTitulo.area.AnP(2), 2, panelTitulo.area.An() - panelTitulo.area.AnP(2)*4, panelTitulo.area.Al() - 4));
        
        panelDatos = new IUPanel(panel, new Area(a.X(), a.Y(2) + a.AlP(7), a.An(), a.AlP(93)), false, Ayuda.COLOR_FONDO);
        construirPanelDatos(new Area(2, 2, panelDatos.area.An() - 4, panelDatos.area.Al() - 6));
    }
    
    private void construirPanelTitulo(Area a){                
        iuTitulo = new IUEtiqueta(panelTitulo, usuario.getRazsoc(), new Area(a.X(), a.Y(), a.AnP(25), a.AlP(50)), 18, "LEFT", false);
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "INTEGRACION DE SISTEMAS", new Area(a.X(2) + a.AnP(30), a.Y(2) + a.AlP(40), a.AnP(40), a.AlP(50)), 18, "CENTER", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "Cochabamba, " + new Fecha().getFecha1(), new Area(a.X(3) + a.AnP(65), a.Y(), a.AnP(35), a.AlP(50)), 18, "RIGHT", false);        
        
        iuTitulo = new IUEtiqueta(panelTitulo, "Usuario: " + tabvar.getDescri(), new Area(a.X(), a.Y(2) + a.AlP(50), a.AnP(40), a.AlP(50)), 18, "LEFT", false);
        iuTitulo.setSubrayarTexto(true);        
    }
    private void construirPanelDatos(Area a){
        primerPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(), a.An(), a.Al()), false);
        construirPrimerPanel(new Area(primerPanel.area.AnP(20), primerPanel.area.AlP(10), primerPanel.area.An() - primerPanel.area.AnP(20)*2, primerPanel.area.Al() - primerPanel.area.AlP(10)*2));
                
    }
    private void construirPrimerPanel(Area a){
        panelContenedor = new IUPanel(primerPanel, new Area(a.X(), a.Y(), a.An(), a.Al()), true);
        construirPanelContenedor(new Area(2, 2, panelContenedor.area.An() - 4, panelContenedor.area.Al() - 6));
    }
    private void construirPanelContenedor(Area a){
        panelTituloC = new IUPanelEtiqueta(panelContenedor, new Area(a.X(), a.Y(), a.An(), a.AlP(10)), "Integracion de Sistemas", 26, SwingConstants.CENTER, Ayuda.COLOR_FONDO, new Color(120, 0, 0), true);        
        
        panelDatosC = new IUPanel(panelContenedor, new Area(a.X(), a.Y(2) + a.AlP(10), a.An(), a.AlP(90)), true);
        construirPanelDatosC(new Area(4, 10, panelDatosC.area.An() - 4*2, panelDatosC.area.Al() - 10*8));
    }   
    private void construirPanelDatosC(Area a){        
        boton27_1 = new IUBoton(panelDatosC, new Area(a.X() + a.AnP(10), a.Y() + a.AlP(5), a.AnP(80), a.AlP(10)), "    27.1. Subsistema de Control de Caja", "", 16, 0, 0, SwingConstants.LEFT, 0, '0', "");
        boton27_2 = new IUBoton(panelDatosC, new Area(a.X() + a.AnP(10), a.Y(2) + a.AlP(15), a.AnP(80), a.AlP(10)), "    27.2. Sistema de Inventario", "", 16, 0, 0, SwingConstants.LEFT, 0, '0', "");                
        boton27_3 = new IUBoton(panelDatosC, new Area(a.X() + a.AnP(10), a.Y(3) + a.AlP(25), a.AnP(80), a.AlP(10)), "    27.3. Libros de Compras", "", 16, 0, 0, SwingConstants.LEFT, 0, '0', "");
        boton27_4 = new IUBoton(panelDatosC, new Area(a.X() + a.AnP(10), a.Y(4) + a.AlP(35), a.AnP(80), a.AlP(10)), "    27.4. Libro de Ventas", "", 16, 0, 0, SwingConstants.LEFT, 0, '0', "");        
    }
    private void algoritmosInicial(){
        panel.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "ESC" );
        panel.getActionMap().put( "ESC", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){
                dispose();
            }
        });
    }
    private void setEventos(){
        boton27_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Ayuda.mensaje(ventanaPrincipal, "Estamos en Mantenimiento, Disculpenos por favor...!", "informacion");
            }
        });
        boton27_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Ayuda.mensaje(ventanaPrincipal, "Estamos en Mantenimiento, Disculpenos por favor...!", "informacion");
            }
        });
        boton27_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Ayuda.mensaje(ventanaPrincipal, "Estamos en Mantenimiento, Disculpenos por favor...!", "informacion");
            }
        });
        boton27_4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Ayuda.mensaje(ventanaPrincipal, "Estamos en Mantenimiento, Disculpenos por favor...!", "informacion");
            }
        });        
    }
}

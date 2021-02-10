/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.respaldo;

import SIGU.botones.IUBoton;
import SIGU.paneles.IUPanel;
import SIGU.paneles.IUPanelEtiqueta;
import SIGU.recursos.Area;
import SIGU.ventanas.IUSecundario;
import com.siscon.recursos.Ayuda;
import com.siscon.view.VPrincipal;
import com.siscon.view.tablas.VTablaConmae;
import com.siscon.view.tablas.VTablaContra;
import com.siscon.view.tablas.VTablaTabvar;
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
public class IUOpcionRespaldo extends IUSecundario{
    private VPrincipal ventanaPrincipal;
    
    private IUPanel panel;
        private IUPanelEtiqueta panelTitulo;        
        
    private IUPanel panelDatos;
        private IUBoton botonRestaurar;
        private IUBoton botonBackup;
        private IUBoton botonLimpiarBD;
        
    private IUPanel panelBoton;
        private IUBoton botonSalir;
        
    private String titulo;
    private String opcion;
    private int indice = 1;
    
    /**
     *
     * @param ventanaPrincipal
     * @param titulo
     * @param tipoSize
     */
    public IUOpcionRespaldo(VPrincipal ventanaPrincipal, String titulo, String tipoSize) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        this.titulo = titulo;
        this.opcion = "";
        construirPaneles(new Area(An()-6, Al()-29));
        setEventos();
        algoritmoInicial();
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
        botonRestaurar = new IUBoton(panelDatos, new Area(a.X(), a.Y(), a.An(), a.AlP(25)), "Restaurar B.D.", "/imagenes/restaurar.png", 20, 50, 30, SwingConstants.RIGHT, SwingConstants.CENTER, '0', "");        
        botonRestaurar.setBackground(Ayuda.COLOR_ATENCION);
        botonBackup = new IUBoton(panelDatos, new Area(a.X(), a.Y(2) + a.AlP(25), a.An(), a.AlP(25)), "Backup B.D.", "/imagenes/backup.png", 20, 50, 30, SwingConstants.RIGHT, SwingConstants.CENTER, '0', "");
        botonLimpiarBD = new IUBoton(panelDatos, new Area(a.X(), a.Y(3) + a.AlP(50), a.An(), a.AlP(25)), "Limpiar B.D.", "/imagenes/erase.png", 20, 50, 30, SwingConstants.RIGHT, SwingConstants.CENTER, '0', "");
    }
    private void construirPanelBoton(Area a){
        botonSalir = new IUBoton(panelBoton, new Area(a.X(), a.Y(), a.An(), a.Al()), "Salir", "/imagenes/cerrar.png", 16, 30, 20, SwingConstants.RIGHT, SwingConstants.CENTER, '{', "");        
        botonSalir.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "ESC" );        
    }
    private void algoritmoInicial(){
        botonRestaurar.requestFocus();
        botonRestaurar.setBackground(Ayuda.COLOR_ATENCION);
    }
    private void seleccionarBoton(){
        switch(indice){
            case 1:                
                botonRestaurar.setBackground(Ayuda.COLOR_ATENCION);
                botonBackup.setBackground(null);
                botonLimpiarBD.setBackground(null);
            break;
            case 2:                
                botonRestaurar.setBackground(null);
                botonBackup.setBackground(Ayuda.COLOR_ATENCION);
                botonLimpiarBD.setBackground(null);
            break;
            case 3:                
                botonRestaurar.setBackground(null);
                botonBackup.setBackground(null);
                botonLimpiarBD.setBackground(Ayuda.COLOR_ATENCION);
            break;
        }
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
        botonRestaurar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                opcion = botonRestaurar.getText();
                setEstado(true);
                dispose();
            }
        });
        botonBackup.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                opcion = botonBackup.getText();
                setEstado(true);
                dispose();
            }
        });
        botonLimpiarBD.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                opcion = botonLimpiarBD.getText();
                setEstado(true);
                dispose();
            }
        });
    }
    public String getOpcion(){
        return opcion;
    }
}

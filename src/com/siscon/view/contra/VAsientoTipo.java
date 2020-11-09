/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.contra;

import SIGU.campoTexto.IUCampoTexto;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.paneles.IUPanel;
import SIGU.paneles.IUPanelEtiqueta;
import SIGU.recursos.Area;
import SIGU.tablas.IUTabla;
import SIGU.tablas.ModeloTabla;
import SIGU.ventanas.IUSecundario;
import com.siscon.controller.CConmae;
import com.siscon.controller.CTabvar;
import com.siscon.model.Conmae;
import com.siscon.model.Tabvar;
import com.siscon.recursos.Ayuda;
import com.siscon.view.VPrincipal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author neo
 */
public class VAsientoTipo extends IUSecundario{
    
    private VPrincipal ventanaPrincipal;
    
    private IUPanel panel;
        private IUPanel panelTitulo;
            private IUEtiqueta iuTitulo;
    
        private IUPanel panelDatos;
            private IUPanel primerPanel;
                private IUTabla iuTabla1;
                private IUEtiqueta iuSimbolo;
                private IUTabla iuTabla2;
                
            private IUPanel segundoPanel;            
            private IUPanel tercerPanel;
                private IUEtiqueta iuTituloMensaje;
                private IUPanelEtiqueta iuMensaje;
                private IUPanelEtiqueta iuInformacion;
                private IUCampoTexto campoS_N;
    
    public VAsientoTipo(VPrincipal ventanaPrincipal, String titulo, String tipoSize) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        construirPanel(new Area(An()-6, Al()-29));
        algoritmoInicial();
    }
    private void construirPanel(Area a){
        panel = new IUPanel(this, new Area(a.X(), a.Y(), a.An(), a.Al()), true);        
        panel.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "ESC" );
        panel.getActionMap().put( "ESC", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                dispose();
            }
        });        
        
        construirPaneles(new Area(2, 2, panel.area.An() - 4, panel.area.Al() - 4));        
    }
    private void construirPaneles(Area a){
        panelTitulo = new IUPanel(panel, new Area(a.X(), a.Y(), a.An(), a.AlP(4)), true, Ayuda.COLOR_FONDO);
        construirPanelTitulo(new Area(2, 2, panelTitulo.area.An() - 4, panelTitulo.area.Al() - 4));
        
        panelDatos = new IUPanel(panel, new Area(a.X(), a.Y(2) + a.AlP(4), a.An(), a.AlP(96)), false);
        construirPanelDatos(new Area(2, 2, panelDatos.area.An() - 4, panelDatos.area.Al() - 6));
    }
    private void construirPanelTitulo(Area a){
        iuTitulo = new IUEtiqueta(panelTitulo, "CONSULTA DE CODIGOS PARA LOS ASIENTOS", new Area(a.X(), a.Y(), a.An(), a.Al()), 20, "CENTER", Ayuda.COLOR_ROJO);
        iuTitulo.setSubrayarTexto(true);        
    }
    private void construirPanelDatos(Area a){
        primerPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(), a.An(), a.AlP(85)), true);
        construirPrimerPanel(new Area(2, 2, primerPanel.area.An() - 6, primerPanel.area.Al() - 4));
                        
        tercerPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(2) + a.AlP(85), a.An(), a.AlP(15)), true);
        construirTercerPanel(new Area(2, 2, tercerPanel.area.An() - 6, tercerPanel.area.Al() - 8));
    }
    private void construirPrimerPanel(Area a){
        iuTabla1 = new IUTabla(
        primerPanel,
        new Area(a.X(), a.Y(), a.AnP(40), a.Al()), 
        new String[]{"NUMERO", "DESCRIPCION"}, 
        new Class[]{Integer.class, String.class}, 
        new int[]{30, 70}, 
        CTabvar.getLista("SELECT * FROM TABVAR WHERE TIPO >= 70 AND TIPO <= 90 GROUP BY OBSERV ORDER BY OBSERV DESC"), 
        new ModeloTabla<Tabvar>(){
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return lista.get(rowIndex).getTipo();
                    case 1:                
                        return lista.get(rowIndex).getObserv();
                    default:
                        return null;
                }
            }
        });        
        iuTabla1.setPosicionTextoHorizontal(1, SwingConstants.LEFT);
        
        iuSimbolo = new IUEtiqueta(primerPanel, "→", new Area(a.X(2) + a.AnP(40), a.AlP(43), a.AnP(10), a.AlP(10)), 20, "CENTER", false);//→►
        iuSimbolo.setFont(new Font("Arial", Font.PLAIN, 70));
        
        iuTabla2 = new IUTabla(
        primerPanel,
        new Area(a.X(2) + a.AnP(50), a.Y(), a.AnP(50), a.Al()), 
        new String[]{"NRO", "CODIGO", "DESCRIPCION"}, 
        new Class[]{Integer.class, Long.class, String.class}, 
        new int[]{15, 25, 60}, 
        new ArrayList(), 
        new ModeloTabla<Conmae>(){
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return rowIndex+1;
                    case 1:                
                        return lista.get(rowIndex).getCuetot();
                    case 2:
                        return lista.get(rowIndex).getDescri();
                    default:
                        return null;
                }
            }
        });        
        iuTabla2.setPosicionTextoHorizontal(1, SwingConstants.LEFT);
    }
    private void construirTercerPanel(Area a){
        iuTituloMensaje = new IUEtiqueta(tercerPanel, "Mensajes - Instrucciones", new Area(a.X(), a.Y(), a.AnP(97), a.AlP(20)), 16, "CENTER", false);
        iuTituloMensaje.setSubrayarTexto(true);        
        iuMensaje = new IUPanelEtiqueta(tercerPanel, new Area(a.X(), a.Y(2) + a.AlP(20), a.AnP(95), a.AlP(40)), "", 16, SwingConstants.LEFT, Ayuda.COLOR_ATENCION, true);
        iuMensaje.setColores(Color.WHITE, new Color(41, 66, 99));
        iuInformacion = new IUPanelEtiqueta(tercerPanel, new Area(a.X(), a.Y(3) + a.AlP(60), a.AnP(95), a.AlP(40)), "", 16, SwingConstants.LEFT, Ayuda.COLOR_FONDO, true);       
        iuInformacion.setColores(Color.BLACK, new Color(255, 210, 0));        
        campoS_N = new IUCampoTexto(tercerPanel, 1, 20, new Area(a.X(2) + a.AnP(95), a.Y(2) + a.AlP(20), a.AnP(5), a.AlP(40)), SwingConstants.CENTER);
        campoS_N.setVisible(false);
        campoS_N.setBorder(new LineBorder(Color.BLACK, 3));
        campoS_N.setBackground(new Color(255, 210, 0));
        campoS_N.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoS_N.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoS_N.setText("N");
                }
            }
        });
        campoS_N.setForeground(Color.BLACK);
    }
    private void algoritmoInicial(){
        focoCampoTabla1();
    }
    private void focoCampoTabla1(){
        iuTabla1.setFocusable(true);
        iuTabla1.requestFocus();
        iuInformacion.setVisible(true);
        iuMensaje.setTexto("CAMPO TABLA: Seleccione un Registro de ASIENTO TIPO. Utilize las Teclas con Flecha Arriba y Abajo.");
        iuInformacion.setTexto("ATENCION: ENTER=Aceptar Asiento Seleccionado, ESC=Suspender.");
        iuTabla1.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if(iuTabla1.isFilaSeleccionado()){
                
                Tabvar t = (Tabvar) iuTabla1.modeloTabla.getFila(iuTabla1.getSelectedRow());                
                ArrayList<Tabvar> listaTabvar = CTabvar.getLista("select * from tabvar where tipo = "+t.getTipo());
                ArrayList<Conmae> listaConmae = new ArrayList<>();
                listaTabvar.forEach((tabvar) -> {                    
                    Conmae c = CConmae.getConmae("SELECT * FROM CONMAE WHERE CUETOT = "+tabvar.getCodcon());
                    if(c != null){
                        listaConmae.add(CConmae.getConmae("SELECT * FROM CONMAE WHERE CUETOT = "+tabvar.getCodcon()));
                    }
                });
                iuTabla2.actualizarTabla(listaConmae);
                iuTabla2.setBackground(Color.GREEN);
            }
        });
        iuTabla1.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        iuTabla1.getActionMap().put("Enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(iuTabla1.isFilaSeleccionado()){
                    focoCampoN_S();                    
                }               
            }
        });
    }
    private void focoCampoN_S(){
        iuTabla1.setFocusable(false);
        iuTabla1.modeloTabla.fireTableDataChanged();
        campoS_N.setVisible(true);
        campoS_N.setEditar(true);
        campoS_N.requestFocus();
        campoS_N.setText("S");
        iuMensaje.setColores(Color.BLACK, new Color(255, 210, 0));
        iuMensaje.setTexto("CONFIRMACION: Esta seguro que desea Utilizar los ASIENTOS TIPO seleccionados.?  S/N");
        iuInformacion.setVisible(false);
        campoS_N.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch(campoS_N.getText()){
                    case "S":
                        setEstado(true);
                        dispose();
                    break;
                    case "N":
                        focoCampoTabla1();
                    break;
                }
            }
        });
    }
    public ArrayList<Conmae> getList(){
        return iuTabla2.modeloTabla.lista;
    }
}

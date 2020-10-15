/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.tabvar;

import SIGU.botones.IUBoton;
import SIGU.campoTexto.IUCampoTexto;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.paneles.IUPanel;
import SIGU.recursos.Area;
import SIGU.recursos.Fecha;
import SIGU.ventanas.IUSecundario;
import com.siscon.controller.CTabvar;
import com.siscon.model.Tabvar;
import com.siscon.view.VPrincipal;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author neo
 */
public class VTabvar extends IUSecundario{
    
    private VPrincipal ventanaPrincipal;
    
    private IUPanel panel;
        private IUPanel panelTitulo;
        private IUEtiqueta iuTitulo;
    
    private IUPanel panelDatos;
        private IUPanel panelPrincipal;
            private IUPanel panelTablaTabvar;    
                private IUEtiqueta iuTituloTabvar;    
                private IUPanel panelDatosTabvar;
                    private String OPCION = "GUARDAR";
                    private IUPanel panelTipo;
                    private IUEtiqueta iuTipo;
                    private IUCampoTexto campoTIPO;
                    private String tipo = "";
                    private IUPanel panelNumero;
                    private IUEtiqueta iuNumero;
                    private IUCampoTexto campoNUMERO;
                    private String numero = "";
                    private IUPanel panelDescripcion;
                    private IUEtiqueta iuDescripcion;
                    private IUCampoTexto campoDESCRIPCION;
                    private String descripcion = "";
                    
                private IUPanel panelDatosSecundariosTabvar;
                    private IUEtiqueta iuNOMBRE;
                    private IUCampoTexto campoNOMBRE;
                    private String nombre = "";
                    private IUEtiqueta iuCODCON;
                    private IUCampoTexto campoCODCON;                    
                    private String codcon = "";
                    private IUEtiqueta iuCORREL;
                    private IUCampoTexto campoCORREL;
                    private String correl = "";
                    private IUEtiqueta iuMONTO1;
                    private IUCampoTexto campoMONTO1;
                    private IUEtiqueta iuMONTO2;
                    private IUCampoTexto campoMONTO2;
                    private IUEtiqueta iuFECHA1;
                    private JDateChooser campoFECHA1 = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
                    private String fecha1 = "";
                    private IUEtiqueta iuFECHA2;
                    private JDateChooser campoFECHA2 = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
                
            private IUPanel panelInstrucciones; 
                private IUPanel panelTituloInstrucciones;
                    private IUEtiqueta iuIntrucciones;
                    private IUEtiqueta iuFormato;
                private IUPanel panelEtiquetaInstrucciones;
                    private IUEtiqueta etiquetaNOMBRE;
                    private IUEtiqueta etiquetaCODCON;
                    private IUEtiqueta etiquetaCORREL;
                    private IUEtiqueta etiquetaMONTO1;
                    private IUEtiqueta etiquetaFECHA1;
                    
                    private IUEtiqueta eNOMBRE;
                    private IUEtiqueta eCODCON;
                    private IUEtiqueta eCORREL;
                    private IUEtiqueta eMONTO1;
                    private IUEtiqueta eFECHA1;
        private IUPanel panelMensajes;
            private IUEtiqueta iuTituloMensajes;
            private IUPanel panelContenedorMensajes;
            private IUEtiqueta iuMensajes;
        
        private IUPanel panelBotonesInstrucciones;
            private IUCampoTexto campoOPCION1;
            private IUCampoTexto campoOPCION2;
            private IUCampoTexto campoOPCION3;
            private IUCampoTexto campoOPCION4;
            private IUCampoTexto campoOPCION5;
            private IUCampoTexto campoOPCION6;
            private IUCampoTexto campoOPCION7;
            private IUBoton botonF1;
            private IUBoton botonF2;
            private IUBoton botonF3;
            private IUBoton botonF4;
            private IUBoton botonF5;
            private IUBoton botonF6;
            private IUBoton botonF7;
            private IUBoton botonF8;
            private IUBoton botonF9;
            private IUBoton botonESC;
        
        private IUPanel panelBotones;
            private IUBoton botonSalir;            
            private IUBoton botonLimpiar;    
            private IUBoton botonEliminar;
            private IUBoton botonModificar;
            private IUBoton botonGrabar;
            private IUBoton botonMostrar;           
    
    private String estadoOp = "";
    
    public VTabvar(VPrincipal ventanaPrincipal, String tipoSize) {
        super(ventanaPrincipal, "", tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        
        construirPaneles();
        setEventos();
        setEventosTeclado();
        setEstadosIniciales(false);
        setEstadoBotonesIniciales(false);
    }
    private void construirPaneles(){
        panel = new IUPanel(this, new Area(0, 0, An()-6, Al()-29), true);
        
        panelTitulo = new IUPanel(panel, new Area(2, 2, panel.area.An() - 4, panel.area.Al()/10), true);
        panelTitulo.setBackground(new Color(232, 237, 244));
        construirPanelTitulo(new Area(3, 3, panelTitulo.area.An() - 12, panelTitulo.area.Al() - 9));
        
        panelDatos = new IUPanel(panel, new Area(2, 4 + panelTitulo.area.Al(), panelTitulo.area.An(), (panel.area.Al() - 6) - panelTitulo.area.Al()), false);
        construirPanelDatos(new Area(3, 2, (panelDatos.area.An() - 6), (panelDatos.area.Al() - 4)));
        
    }
    private void construirPanelTitulo(Area a){
        iuTitulo = new IUEtiqueta(panelTitulo, "CAMARA FORESTAL", new Area(a.X(), a.Y(), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "PROCESOS DE PARAMETROS - TABLAS", new Area(a.X(2) + a.AnP(25), a.Y(), a.AnP(35), a.AlP(50)), 16, "CENTER", false);
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "SISTEMA CONTABLE SISCON @v7.1. 2020", new Area(a.X(3) + a.AnP(60), a.Y(), a.AnP(40), a.AlP(50)), 16, "CENTER", false); 
        
        iuTitulo = new IUEtiqueta(panelTitulo, "EJECUTIVO", new Area(a.X(), a.Y(2) + a.AlP(50), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "FECHA: "+new Fecha().getFecha1(), new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(50), a.AnP(40), a.AlP(50)), 16, "CENTER", false);
    }
    private void construirPanelDatos(Area a){
        panelPrincipal = new IUPanel(panelDatos, new Area(a.X(), a.Y(), a.An(), a.AlP(60)), true);
        construirPanelTabvar(new Area(2, 2, panelPrincipal.area.An() - 6, panelPrincipal.area.Al() - 4));
        
        panelMensajes = new IUPanel(panelDatos, new Area(a.X(), a.Y(2) + a.AlP(60), a.An(), a.AlP(14)), true);
        panelMensajes.setBackground(new Color(232, 237, 244));
        construirPanelMensajes(new Area(8, 8, panelMensajes.area.An() - 16, panelMensajes.area.Al() - 24));
        
        panelBotonesInstrucciones = new IUPanel(panelDatos, new Area(a.X(), a.Y(2) + a.AlP(74), a.An(), a.AlP(8)), false);
        construirPanelBotonesInstrucciones(new Area(4, 4, panelBotonesInstrucciones.area.An() - 40, panelBotonesInstrucciones.area.Al() - 8));
        
        panelBotones = new IUPanel(panelDatos, new Area(a.X(), a.Y(1) + a.AlP(85), a.An(), a.AlP(15)), false);
        construirPanelBotones(new Area(4, 4, panelBotones.area.An() - 24, panelBotones.area.Al() - 12));
    }
    private void construirPanelTabvar(Area a){
        panelTablaTabvar = new IUPanel(panelPrincipal, new Area(a.X(), a.Y(), a.AnP(45), a.Al()), false);
        construirPanelPrincipal(new Area(2, 2, panelTablaTabvar.area.An() - 4, panelTablaTabvar.area.Al() - 6));
        
        panelInstrucciones = new IUPanel(panelPrincipal, new Area(a.X(2) + a.AnP(45), a.Y(), a.AnP(55), a.Al()), true);
        construirPanelInstrucciones(new Area(2, 2, panelInstrucciones.area.An() - 4, panelInstrucciones.area.Al() - 6));
    }
    private void construirPanelPrincipal(Area a){        
        panelDatosTabvar = new IUPanel(panelTablaTabvar, new Area(a.X(), a.Y(), a.An(), a.AlP(20)), false);
        construirPanelDatosTabvar(new Area(4, 4, panelDatosTabvar.area.An() - 16, panelDatosTabvar.area.Al() -8));
        
        panelDatosSecundariosTabvar = new IUPanel(panelTablaTabvar, new Area(a.X(), a.Y(2) + a.AlP(20), a.An(), a.AlP(80)), false);
        construirPanelDatosSecundariosTabvar(new Area(2, 4, panelDatosSecundariosTabvar.area.An() - 4, panelDatosSecundariosTabvar.area.Al() - 32));        
    }
    private void construirPanelDatosTabvar(Area a){
        panelTipo = new IUPanel(panelDatosTabvar, new Area(a.X(), a.Y(), a.AnP(15), a.AlP(40)), true);
        iuTipo = new IUEtiqueta(panelTipo, "TIPO", new Area(panelTipo.area.An(), panelTipo.area.Al()), 14, "CENTER", false);        
        campoTIPO = new IUCampoTexto(panelDatosTabvar, 2, 16, new Area(a.X(), a.Y() + a.AlP(40), a.AnP(15), a.AlP(60)));
        campoTIPO.setRestriccion("^([0-9]|[1-9][0-9])$");
        panelTipo.setBackground(new Color(232, 237, 244));
        
        panelNumero = new IUPanel(panelDatosTabvar, new Area(a.X(2) + a.AnP(15), a.Y(), a.AnP(20), a.AlP(40)), true);
        iuNumero = new IUEtiqueta(panelNumero, "NUMERO", new Area(panelNumero.area.An(), panelNumero.area.Al()), 14, "CENTER", false);                
        campoNUMERO = new IUCampoTexto(panelDatosTabvar, 3, 16, new Area(a.X(2) + a.AnP(15), a.Y() + a.AlP(40), a.AnP(20), a.AlP(60)));
        campoNUMERO.setRestriccion("^([0-9]|[1-9][0-9])$");
        panelNumero.setBackground(new Color(232, 237, 244));
        
        panelDescripcion = new IUPanel(panelDatosTabvar, new Area(a.X(3) + a.AnP(35), a.Y(), a.AnP(65), a.AlP(40)), true);
        iuDescripcion = new IUEtiqueta(panelDescripcion, "DESCRIPCION", new Area(panelDescripcion.area.An(), panelDescripcion.area.Al()), 14, "CENTER", false);        
        campoDESCRIPCION = new IUCampoTexto(panelDatosTabvar, 30, 16, new Area(a.X(3) + a.AnP(35), a.Y() + a.AlP(40), a.AnP(65), a.AlP(60)));
        campoDESCRIPCION.setRestriccion("[\\p{Alpha}\\p{Alnum}\\p{Space}\\.\\/\\(\\)\\-]");
        panelDescripcion.setBackground(new Color(232, 237, 244));
    } 
    private void construirPanelDatosSecundariosTabvar(Area a){
        int alto = 14;
        iuNOMBRE = new IUEtiqueta(panelDatosSecundariosTabvar, " a. Nombre:", new Area(a.X(), a.Y(), a.AnP(35), a.AlP(alto)), 16, "LEFT", true);
        campoNOMBRE = new IUCampoTexto(panelDatosSecundariosTabvar, 20, 16, new Area(a.X() + a.AnP(35), a.Y(), a.AnP(65), a.AlP(alto)));
        campoNOMBRE.setRestriccion("[\\p{Alpha}\\p{Alnum}\\p{Space}\\.\\/\\(\\)\\-]");
        
        iuCODCON = new IUEtiqueta(panelDatosSecundariosTabvar, " b. Cod. Contable:", new Area(a.X(), a.Y(2) + a.AlP(alto), a.AnP(35), a.AlP(alto)), 16, "LEFT", true);
        campoCODCON = new IUCampoTexto(panelDatosSecundariosTabvar, 30, 16, new Area(a.X() + a.AnP(35), a.Y(2) + a.AlP(alto), a.AnP(24), a.AlP(alto)));
        campoCODCON.setRestriccion("^([0-9]|[1-9][0-9])$");
        
        iuCORREL = new IUEtiqueta(panelDatosSecundariosTabvar, " c. Correlativo:", new Area(a.X(), a.Y(3) + a.AlP(2*alto), a.AnP(35), a.AlP(alto)), 16, "LEFT", true);
        campoCORREL = new IUCampoTexto(panelDatosSecundariosTabvar, 6, 16, new Area(a.X() + a.AnP(35), a.Y(3) + a.AlP(2*alto), a.AnP(20), a.AlP(alto)));
        campoCORREL.setRestriccion("^([0-9]|[1-9][0-9])$");
        
        iuMONTO1 = new IUEtiqueta(panelDatosSecundariosTabvar, " d. Monto 1.:", new Area(a.X(), a.Y(4) + a.AlP(3*alto), a.AnP(35), a.AlP(alto)), 16, "LEFT", true);
        campoMONTO1 = new IUCampoTexto(panelDatosSecundariosTabvar, 12, 16, new Area(a.X() + a.AnP(35), a.Y(4) + a.AlP(3*alto), a.AnP(30), a.AlP(alto)));
        campoMONTO1.setRestriccionNumeroDecimal(2);
        
        iuMONTO2 = new IUEtiqueta(panelDatosSecundariosTabvar, "              2.:", new Area(a.X(), a.Y(5) + a.AlP(4*alto), a.AnP(35), a.AlP(alto)), 16, "LEFT", true);
        campoMONTO2 = new IUCampoTexto(panelDatosSecundariosTabvar, 9, 16, new Area(a.X() + a.AnP(35), a.Y(5) + a.AlP(4*alto), a.AnP(35), a.AlP(alto)));
        campoMONTO2.setRestriccion("^([0-9]|[1-9][0-9])$");
        
        iuFECHA1 = new IUEtiqueta(panelDatosSecundariosTabvar, " d. Fecha 1.:", new Area(a.X(), a.Y(6) + a.AlP(5*alto), a.AnP(35), a.AlP(alto)), 16, "LEFT", true);        
        Area area = new Area(a.X() + a.AnP(35), a.Y(6) + a.AlP(5*alto), a.AnP(30), a.AlP(alto));
        campoFECHA1.setBounds(area.X(),area.Y(), area.An(), area.Al());        
        campoFECHA1.getDateEditor().getUiComponent().setFont(new Font("Verdana", Font.PLAIN, 16));
        campoFECHA1.getDateEditor().getUiComponent().setForeground(new Color(2, 67, 109));
        campoFECHA1.getCalendarButton().setVisible(false);
        campoFECHA1.getDateEditor().getUiComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){                    
                    campoFECHA1.getDateEditor().getUiComponent().transferFocus();
                }
                if(KeyEvent.VK_ESCAPE == e.getKeyCode())
                    campoFECHA1.getDateEditor().getUiComponent().transferFocusBackward();
            }
        });
        panelDatosSecundariosTabvar.add(campoFECHA1);
        
        iuFECHA2 = new IUEtiqueta(panelDatosSecundariosTabvar, " e.          2.:", new Area(a.X(), a.Y(7) + a.AlP(6*alto), a.AnP(35), a.AlP(alto)), 16, "LEFT", true);        
        Area area2 = new Area(a.X() + a.AnP(35), a.Y(7) + a.AlP(6*alto), a.AnP(30), a.AlP(alto));
        campoFECHA2.setBounds(area2.X(),area2.Y(), area2.An(), area2.Al());        
        campoFECHA2.getDateEditor().getUiComponent().setFont(new Font("Verdana", Font.PLAIN, 16));
        campoFECHA2.getDateEditor().getUiComponent().setForeground(new Color(2, 67, 109));
        campoFECHA2.getCalendarButton().setVisible(false);        
        panelDatosSecundariosTabvar.add(campoFECHA2);
    }
    private void construirPanelInstrucciones(Area a){
        panelTituloInstrucciones = new IUPanel(panelInstrucciones, new Area(a.X(), a.Y() + a.AlP(10), a.An(), a.AlP(10)), false);
        construirTituloInstrucciones(new Area(2, 2, panelTituloInstrucciones.area.An() - 6, panelTituloInstrucciones.area.Al() - 4));
        
        panelEtiquetaInstrucciones = new IUPanel(panelInstrucciones, new Area(a.X(), a.Y(2) + a.AlP(20), a.An(), a.AlP(80)), false);
        construirEtiquetasInstrucciones(new Area(2, 4, panelEtiquetaInstrucciones.area.An() - 6, panelEtiquetaInstrucciones.area.Al() - 32));
    }
    private void construirTituloInstrucciones(Area a){
        iuIntrucciones = new IUEtiqueta(panelTituloInstrucciones, "INSTRUCCIONES", new Area(a.X(), a.Y(), a.AnP(80), a.Al()), 18, "CENTER", true);
        iuFormato = new IUEtiqueta(panelTituloInstrucciones, "FORMATO", new Area(a.X(2) + a.AnP(80), a.Y(), a.AnP(20), a.Al()), 18, "CENTER", true);
    }
    private void construirEtiquetasInstrucciones(Area a){
        int alto = 14;
        etiquetaNOMBRE = new IUEtiqueta(panelEtiquetaInstrucciones, "Denominacion del Parametro - Tabla", new Area(a.X(), a.Y(), a.AnP(80), a.AlP(alto)), 16, "LEFT", true);
        etiquetaNOMBRE = new IUEtiqueta(panelEtiquetaInstrucciones, "x15", new Area(a.X(2) + a.AnP(80), a.Y(), a.AnP(20), a.AlP(alto)), 16, "CENTER", true);
        
        etiquetaCODCON = new IUEtiqueta(panelEtiquetaInstrucciones, "Campo para Integrar la Contabilidad", new Area(a.X(), a.Y(2) + a.AlP(alto), a.AnP(80), a.AlP(alto)), 16, "LEFT", true);
        etiquetaCODCON = new IUEtiqueta(panelEtiquetaInstrucciones, "n8", new Area(a.X(2) + a.AnP(80), a.Y(2) + a.AlP(alto), a.AnP(20), a.AlP(alto)), 16, "CENTER", true);
        
        etiquetaCORREL = new IUEtiqueta(panelEtiquetaInstrucciones, "Campo encargado de Numerar", new Area(a.X(), a.Y(3) + a.AlP(2*alto), a.AnP(80), a.AlP(alto)), 16, "LEFT", true);
        etiquetaCORREL = new IUEtiqueta(panelEtiquetaInstrucciones, "n6", new Area(a.X(2) + a.AnP(80), a.Y(3) + a.AlP(2*alto), a.AnP(20), a.AlP(alto)), 16, "CENTER", true);
        
        etiquetaMONTO1 = new IUEtiqueta(panelEtiquetaInstrucciones, "Rangos Monetarios", new Area(a.X(), a.Y(4) + a.AlP(3*alto), a.AnP(80), a.AlP(alto)), 16, "LEFT", true);
        etiquetaMONTO1 = new IUEtiqueta(panelEtiquetaInstrucciones, "n8,2", new Area(a.X(2) + a.AnP(80), a.Y(4) + a.AlP(3*alto), a.AnP(20), a.AlP(alto)), 16, "CENTER", true);
        
        etiquetaFECHA1 = new IUEtiqueta(panelEtiquetaInstrucciones, "Rango de Fechas", new Area(a.X(), a.Y(6) + a.AlP(5*alto), a.AnP(80), a.AlP(alto)), 16, "LEFT", true);
        etiquetaFECHA1 = new IUEtiqueta(panelEtiquetaInstrucciones, "dd/mm/aaaa", new Area(a.X(2) + a.AnP(80), a.Y(6) + a.AlP(5*alto), a.AnP(20), a.AlP(alto)), 16, "CENTER", true);
    }
    
    private void construirPanelMensajes(Area a){
        iuTituloMensajes = new IUEtiqueta(panelMensajes, "MENSAJES - INSTRUCCIONES", new Area(a.X(), a.Y(), a.An(), a.AlP(30)), 14, "CENTER", new Color(120, 0, 0));
        
        panelContenedorMensajes = new IUPanel(panelMensajes, new Area(a.X(), a.Y(2) + a.AlP(30), a.An(), a.AlP(70)), false);
        panelContenedorMensajes.setBackground(new Color(232, 237, 244));
        construirPanelContenedorMensajes(new Area(2, 2, panelContenedorMensajes.area.An() - 8, panelContenedorMensajes.area.Al() - 4));
    }
    private void construirPanelContenedorMensajes(Area a){
        iuMensajes = new IUEtiqueta(panelContenedorMensajes, "", new Area(a.X(), a.Y(), a.AnP(92), a.Al()), 20, "LEFT", false);
                
        campoOPCION1 = new IUCampoTexto(panelContenedorMensajes, 1, 16, new Area(a.X(3) + a.AnP(96), a.Y(2), a.AnP(4), a.Al()));        
        campoOPCION1.setText("S");
        campoOPCION1.setBorder(new LineBorder(Color.green, 2));
        campoOPCION1.setFont(new Font("Verdana", Font.PLAIN, 24));        
        campoOPCION1.setHorizontalAlignment(SwingConstants.CENTER);
        campoOPCION1.setVisible(false);
        
        campoOPCION2 = new IUCampoTexto(panelContenedorMensajes, 1, 16, new Area(a.X(3) + a.AnP(96), a.Y(2), a.AnP(4), a.Al()));        
        campoOPCION2.setText("S");
        campoOPCION2.setBorder(new LineBorder(Color.green, 2));
        campoOPCION2.setFont(new Font("Verdana", Font.PLAIN, 24));        
        campoOPCION2.setHorizontalAlignment(SwingConstants.CENTER);
        campoOPCION2.setVisible(false);
        
        campoOPCION3 = new IUCampoTexto(panelContenedorMensajes, 1, 16, new Area(a.X(3) + a.AnP(96), a.Y(2), a.AnP(4), a.Al()));        
        campoOPCION3.setText("S");
        campoOPCION3.setBorder(new LineBorder(Color.green, 2));
        campoOPCION3.setFont(new Font("Verdana", Font.PLAIN, 24));        
        campoOPCION3.setHorizontalAlignment(SwingConstants.CENTER);
        campoOPCION3.setVisible(false);
        
        campoOPCION4 = new IUCampoTexto(panelContenedorMensajes, 1, 16, new Area(a.X(3) + a.AnP(96), a.Y(2), a.AnP(4), a.Al()));        
        campoOPCION4.setText("S");
        campoOPCION4.setBorder(new LineBorder(Color.green, 2));
        campoOPCION4.setFont(new Font("Verdana", Font.PLAIN, 24));        
        campoOPCION4.setHorizontalAlignment(SwingConstants.CENTER);
        campoOPCION4.setVisible(false);
        
        campoOPCION5 = new IUCampoTexto(panelContenedorMensajes, 1, 16, new Area(a.X(3) + a.AnP(96), a.Y(2), a.AnP(4), a.Al()));        
        campoOPCION5.setText("S");
        campoOPCION5.setBorder(new LineBorder(Color.green, 2));
        campoOPCION5.setFont(new Font("Verdana", Font.PLAIN, 24));        
        campoOPCION5.setHorizontalAlignment(SwingConstants.CENTER);
        campoOPCION5.setVisible(false);
        
        campoOPCION6 = new IUCampoTexto(panelContenedorMensajes, 1, 16, new Area(a.X(3) + a.AnP(96), a.Y(2), a.AnP(4), a.Al()));        
        campoOPCION6.setText("S");
        campoOPCION6.setBorder(new LineBorder(Color.green, 2));
        campoOPCION6.setFont(new Font("Verdana", Font.PLAIN, 24));        
        campoOPCION6.setHorizontalAlignment(SwingConstants.CENTER);
        campoOPCION6.setVisible(false);
        
        campoOPCION7 = new IUCampoTexto(panelContenedorMensajes, 1, 16, new Area(a.X(3) + a.AnP(96), a.Y(2), a.AnP(4), a.Al()));        
        campoOPCION7.setText("S");
        campoOPCION7.setBorder(new LineBorder(Color.green, 2));
        campoOPCION7.setFont(new Font("Verdana", Font.PLAIN, 24));        
        campoOPCION7.setHorizontalAlignment(SwingConstants.CENTER);
        campoOPCION7.setVisible(false);
    }
    
    private void construirPanelBotonesInstrucciones(Area a){
        botonF1 = new IUBoton(panelBotonesInstrucciones, new Area(a.X(), a.Y(), a.AnP(5), a.Al()), "[F1]", "", 16, 30, 5, SwingConstants.RIGHT, SwingConstants.CENTER, ' ', "boton de ayuda.");
        botonF1.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_F1, 0 ), "F1" );
        
        botonF2 = new IUBoton(panelBotonesInstrucciones, new Area(a.X(2) + a.AnP(5), a.Y(), a.AnP(5), a.Al()), "[F2]", "", 16, 30, 5, SwingConstants.RIGHT, SwingConstants.CENTER, ' ', "boton de ayuda.");
        botonF2.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_F2, 0 ), "F2" );
        
        botonF3 = new IUBoton(panelBotonesInstrucciones, new Area(a.X(3) + a.AnP(10), a.Y(), a.AnP(5), a.Al()), "[F3]", "", 16, 30, 5, SwingConstants.RIGHT, SwingConstants.CENTER, ' ', "boton de ayuda.");
        botonF3.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_F3, 0 ), "F3" );
        
        botonF4 = new IUBoton(panelBotonesInstrucciones, new Area(a.X(4) + a.AnP(15), a.Y(), a.AnP(5), a.Al()), "[F4]", "", 16, 30, 5, SwingConstants.RIGHT, SwingConstants.CENTER, ' ', "boton de ayuda.");
        botonF4.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_F4, 0 ), "F4" );
        
        botonF5 = new IUBoton(panelBotonesInstrucciones, new Area(a.X(5) + a.AnP(20), a.Y(), a.AnP(5), a.Al()), "[F5]", "", 16, 30, 5, SwingConstants.RIGHT, SwingConstants.CENTER, ' ', "boton de ayuda.");
        botonF5.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_F5, 0 ), "F5" );
        
        botonF6 = new IUBoton(panelBotonesInstrucciones, new Area(a.X(6) + a.AnP(25), a.Y(), a.AnP(5), a.Al()), "[F6]", "", 16, 30, 5, SwingConstants.RIGHT, SwingConstants.CENTER, ' ', "boton de ayuda.");
        botonF6.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_F6, 0 ), "F6" );
        
        botonF7 = new IUBoton(panelBotonesInstrucciones, new Area(a.X(7) + a.AnP(30), a.Y(), a.AnP(5), a.Al()), "[F7]", "", 16, 30, 5, SwingConstants.RIGHT, SwingConstants.CENTER, ' ', "boton de ayuda.");
        botonF7.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_F7, 0 ), "F7" );
        
        botonF8 = new IUBoton(panelBotonesInstrucciones, new Area(a.X(8) + a.AnP(35), a.Y(), a.AnP(5), a.Al()), "[F8]", "", 16, 30, 5, SwingConstants.RIGHT, SwingConstants.CENTER, ' ', "boton de ayuda.");
        botonF8.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_F8, 0 ), "F8" );
        
        botonF9 = new IUBoton(panelBotonesInstrucciones, new Area(a.X(9) + a.AnP(40), a.Y(), a.AnP(5), a.Al()), "[F9]", "", 16, 30, 5, SwingConstants.RIGHT, SwingConstants.CENTER, ' ', "boton de ayuda.");
        botonF9.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_F9, 0 ), "F9" );                
    }
    
    private void construirPanelBotones(Area a){
        botonSalir = new IUBoton(panelBotones, new Area(a.X(5) + a.AnP(85), a.Y(2) + a.AlP(50), a.AnP(15), a.AlP(50)), "SALIR", "/imagenes/cerrar.png", 16, 30, 5, SwingConstants.RIGHT, SwingConstants.CENTER, 'S', "boton que cierrar la ventana emergente.");
        botonLimpiar = new IUBoton(panelBotones, new Area(a.X(4) + a.AnP(70), a.Y(2) + a.AlP(50), a.AnP(15), a.AlP(50)), "LIMPIAR", "/imagenes/erase.png", 16, 30, 5, SwingConstants.RIGHT, SwingConstants.CENTER, 'L', "boton que limpia los campos de datos.");
        botonEliminar = new IUBoton(panelBotones, new Area(a.X(3) + a.AnP(55), a.Y(2) + a.AlP(50), a.AnP(15), a.AlP(50)), "ELIMINAR", "/imagenes/delete.png", 16, 30, 5, SwingConstants.RIGHT, SwingConstants.CENTER, 'E', "boton que elimina un registro de la tabla TABVAR.");
        botonModificar = new IUBoton(panelBotones, new Area(a.X(2) + a.AnP(40), a.Y(2) + a.AlP(50), a.AnP(15), a.AlP(50)), "MODIFCAR", "/imagenes/edit.png", 16, 30, 5, SwingConstants.RIGHT, SwingConstants.CENTER, 'M', "boton que Modifica un registro de la tabla TABVAR.");
        botonGrabar = new IUBoton(panelBotones, new Area(a.X(1) + a.AnP(25), a.Y(2) + a.AlP(50), a.AnP(15), a.AlP(50)), "GRABAR", "/imagenes/save.png", 16, 30, 5, SwingConstants.RIGHT, SwingConstants.CENTER, 'G', "boton que guarda un nuevo registro a la Base de Datos.");
        botonMostrar = new IUBoton(panelBotones, new Area(a.X(), a.Y(2) + a.AlP(50), a.AnP(15), a.AlP(50)), "MOSTRAR", "/imagenes/ojos.png", 16, 30, 5, SwingConstants.RIGHT, SwingConstants.CENTER, 'O', "boton que muestra toda la tabla TABVAR.");
    }
    
    private void limpiarCampos(){
        estadoOp = "";
        OPCION = "";
        panelContenedorMensajes.setBackground(Color.WHITE);
        iuMensajes.setText("");
        habilitar_deshabilitarBotones(false);
        campoTIPO.setEditar(true);
        campoNUMERO.setEditar(true);
        campoTIPO.requestFocus();        
        campoTIPO.setText("");
        campoNUMERO.setText("");
        campoDESCRIPCION.setText("");
        campoNOMBRE.setText("");
        campoCODCON.setText("");
        campoCORREL.setText("");
        campoMONTO1.setText("");
        campoMONTO2.setText("");
        campoFECHA1.setCalendar(null);
        campoFECHA2.setCalendar(null);
        setEstadosIniciales(false);
        setEstadoBotonesIniciales(false);
    }
    private void setEstadosIniciales(boolean estado){
        campoDESCRIPCION.setEditar(estado);
        campoNOMBRE.setEditar(estado);
        campoCODCON.setEditar(estado);
        campoCORREL.setEditar(estado);
        campoMONTO1.setEditar(estado);
        campoMONTO2.setEditar(estado);
        campoFECHA1.getDateEditor().getUiComponent().setFocusable(estado);
        campoFECHA1.getDateEditor().getUiComponent().setEnabled(estado);
        campoFECHA2.getDateEditor().getUiComponent().setFocusable(estado);
        campoFECHA2.getDateEditor().getUiComponent().setEnabled(estado);
        
        campoDESCRIPCION.setText("");
        campoNOMBRE.setText("");
        campoCODCON.setText("");
        campoCORREL.setText("");
        campoMONTO1.setText("");
        campoMONTO2.setText("");
        campoFECHA1.setCalendar(null);
        campoFECHA2.setCalendar(null);
    }
    private void setEstadoBotonesIniciales(boolean estado){
        botonEliminar.setEnabled(estado);
        botonModificar.setEnabled(estado);
        botonGrabar.setEnabled(estado);
    }
    private void setCrearNuevoTabvar(){        
        if(estadoOp.isEmpty() || !estadoOp.equalsIgnoreCase("GRABAR")){
            setEstadosIniciales(true);
            botonGrabar.setEnabled(true);
            botonModificar.setEnabled(false);
            botonEliminar.setEnabled(false);
            campoDESCRIPCION.requestFocus();
            JOptionPane.showMessageDialog(ventanaPrincipal, "Lo siento, no existe ningun registro con los datos iniciales....\npodra grabar un nuevo registro...!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);            
        }
        estadoOp = "GRABAR";
        
    }
    private void mostrarDatosTabvar(Tabvar tabvar){        
        campoTIPO.setText(String.valueOf(tabvar.getTipo()));
        campoNUMERO.setText(String.valueOf(tabvar.getNumero()));
        campoDESCRIPCION.setText(tabvar.getDescri());
        campoNOMBRE.setText(tabvar.getObserv());
        
        campoCODCON.setText(String.valueOf(tabvar.getCodcon()));        
        campoCORREL.setText(String.valueOf(tabvar.getCorrel()));
        campoMONTO1.setText(String.valueOf(tabvar.getMonto()));
        campoMONTO2.setText(String.valueOf(tabvar.getMonto2()));

        if(tabvar.getFecha() == null)
            campoFECHA1.setCalendar(null);
        else
            campoFECHA1.setDate(new Fecha(tabvar.getFecha()).getDate());
        
        if(tabvar.getFecha2() == null)
            campoFECHA2.setCalendar(null);
        else
            campoFECHA2.setDate(new Fecha(tabvar.getFecha2()).getDate());        
    }
    private boolean noExistenCamposVacios(){
        boolean verificador = false;
        if(!campoTIPO.getText().isEmpty()){
            if(!campoNUMERO.getText().isEmpty()){
                verificador = true;
            }
        }
        return verificador;
    }
    private void eliminarRegistro(){        
        if(!campoTIPO.getText().isEmpty()){
            if(!campoNUMERO.getText().isEmpty()){
                int tipo = Integer.parseInt(campoTIPO.getText());
                int numero = Integer.parseInt(campoNUMERO.getText());
                if(tipo > 0 && numero > 0){
                    int resp = JOptionPane.showConfirmDialog(ventanaPrincipal, "¿Esta seguro que desea ELIMINAR el Registro...?", "Alerta!", JOptionPane.YES_NO_OPTION);
                    if(resp == 0){
                        Tabvar tabvar = CTabvar.getTabvar(tipo, numero);
                        if(tabvar == null){
                            JOptionPane.showMessageDialog(null, "Lo siento, pero no existe el registro TABVAR con TIPO = "+tipo+" y NUMERO = "+numero+" en la BASE DE DATOS....!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                        }else{
                            if(CTabvar.eliminarTabvar(tabvar)){
                                JOptionPane.showMessageDialog(ventanaPrincipal, "se ha eliminado los datos del registro TABVAR correctamente...!");
                                limpiarCampos();
                            }
                        }
                    }
                }
            }
        }
    }
    private void mostrarTabla(){
        VTabla iuTabla = new VTabla(ventanaPrincipal, "Tabla Principal TABVAR", "grande");
        iuTabla.mostrarVentana();
    }
    
    private void modificarDatosRegistro(){
        if(!campoTIPO.getText().isEmpty()){
            if(!campoNUMERO.getText().isEmpty()){
                int tipo = Integer.parseInt(campoTIPO.getText());
                int numero = Integer.parseInt(campoNUMERO.getText());
                if(tipo > 0 && numero > 0){

                    Tabvar tabvar = CTabvar.getTabvar(tipo, numero);
                    if(tabvar == null){
                        JOptionPane.showMessageDialog(null, "Lo siento, pero no existe el registro TABVAR con TIPO = "+tipo+" y NUMERO = "+numero+" en la BASE DE DATOS....!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    }else{
                        if(noExistenCamposVacios()){         
                            tabvar.setTipo(Integer.parseInt(campoTIPO.getText()));
                            tabvar.setNumero(Integer.parseInt(campoNUMERO.getText()));
                            tabvar.setDescri(campoDESCRIPCION.getText());
                            tabvar.setObserv(campoNOMBRE.getText());

                            if(campoCODCON.getText().isEmpty())
                                tabvar.setCodcon(0);
                            else
                                tabvar.setCodcon(Integer.parseInt(campoCODCON.getText()));

                            if(campoCORREL.getText().isEmpty())
                                tabvar.setCorrel(0);
                            else
                                tabvar.setCorrel(Integer.parseInt(campoCORREL.getText()));            

                            if(campoMONTO1.getText().isEmpty())
                                tabvar.setMonto(0);
                            else
                                tabvar.setMonto(Double.parseDouble(campoMONTO1.getText()));

                            if(campoMONTO2.getText().isEmpty())
                                tabvar.setMonto2(0);
                            else
                                tabvar.setMonto2(Double.parseDouble(campoMONTO2.getText()));

                            if(campoFECHA1.getDate() != null)
                                tabvar.setFecha(new Fecha().getFecha(campoFECHA1.getDate(), "yyyy-MM-dd"));
                            else
                                tabvar.setFecha(null);

                            if(campoFECHA2.getDate() != null)
                                tabvar.setFecha2(new Fecha().getFecha(campoFECHA2.getDate(), "yyyy-MM-dd"));
                            else
                                tabvar.setFecha2(null);

                            if(CTabvar.modificarTabvar(tabvar)){
                                JOptionPane.showMessageDialog(ventanaPrincipal, "se ha modiicado los datos del registro TABVAR correctamente...!");
                                limpiarCampos();
                            }
                        }
                    }
                }
            }
        }
    }
    private void guardarNuevoRegistro(){
        if(noExistenCamposVacios()){
            Tabvar tabvar = new Tabvar(0);
            tabvar.setTipo(Integer.parseInt(campoTIPO.getText()));
            tabvar.setNumero(Integer.parseInt(campoNUMERO.getText()));
            tabvar.setDescri(campoDESCRIPCION.getText());
            tabvar.setObserv(campoNOMBRE.getText());
            
            if(campoCODCON.getText().isEmpty())
                tabvar.setCodcon(0);
            else
                tabvar.setCodcon(Integer.parseInt(campoCODCON.getText()));
            
            if(campoCORREL.getText().isEmpty())
                tabvar.setCorrel(0);
            else
                tabvar.setCorrel(Integer.parseInt(campoCORREL.getText()));            
            
            if(campoMONTO1.getText().isEmpty())
                tabvar.setMonto(0);
            else
                tabvar.setMonto(Double.parseDouble(campoMONTO1.getText()));
            
            if(campoMONTO2.getText().isEmpty())
                tabvar.setMonto2(0);
            else
                tabvar.setMonto2(Double.parseDouble(campoMONTO2.getText()));
                        
            if(campoFECHA1.getDate() != null)
                tabvar.setFecha(new Fecha().getFecha(campoFECHA1.getDate(), "yyyy-MM-dd"));
            else
                tabvar.setFecha(null);
            
            if(campoFECHA2.getDate() != null)
                tabvar.setFecha2(new Fecha().getFecha(campoFECHA2.getDate(), "yyyy-MM-dd"));
            else
                tabvar.setFecha2(null);
            
            if(CTabvar.guardarTabvar(tabvar)){
                JOptionPane.showMessageDialog(ventanaPrincipal, "se ha guardado un nuevo registro de TABVAR correctamente...!");
                limpiarCampos();                
            }
        }
    }
    private void setEventos(){
        botonSalir.addActionListener((ActionEvent e) -> {
            dispose();
        });
        botonLimpiar.addActionListener((ActionEvent e) -> {
            limpiarCampos();
        });
        botonGrabar.addActionListener((ActionEvent e) -> {
            guardarNuevoRegistro();
        });
        botonModificar.addActionListener((ActionEvent e) -> {
            modificarDatosRegistro();
        });
        botonEliminar.addActionListener((ActionEvent e) -> {
            eliminarRegistro();
        });
        botonMostrar.addActionListener((ActionEvent e) -> {
            mostrarTabla();
        });        
                
        /*campoNumero.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {                
                if(!campoTipo.getText().isEmpty()){
                    if(!campoNumero.getText().isEmpty()){
                        int tipo = Integer.parseInt(campoTipo.getText());
                        int numero = Integer.parseInt(campoNumero.getText());
                        if(tipo > 0 && numero > 0){
                            
                            Tabvar tabvar = CTabvar.getTabvar(tipo, numero);
                            if(tabvar == null){
                                setCrearNuevoTabvar();
                            }else{
                                iuMensajes.setText("EXISTE DATOS DE TABLA: DESEA RECUPERAR S/N");
                                
                            }
                        }
                    }
                }
            }
        });*/
    }
    private void setEventosTeclado(){
        
        campoOPCION1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoOPCION1.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoOPCION1.setText("N");
                }
            }
        });
        campoOPCION2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoOPCION2.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoOPCION2.setText("N");
                }
            }
        });
        campoOPCION3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoOPCION3.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoOPCION3.setText("N");
                }
            }
        });
        campoOPCION4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoOPCION4.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoOPCION4.setText("N");
                }
            }
        });
        campoOPCION5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoOPCION5.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoOPCION5.setText("N");
                }
            }
        });
        campoOPCION6.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoOPCION6.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoOPCION6.setText("N");
                }
            }
        });
        campoOPCION7.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoOPCION7.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoOPCION7.setText("N");
                }
            }
        });
        
        campoTIPO.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {                
                focoCampoTIPO();
            }
        });
        campoTIPO.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!campoTIPO.getText().isEmpty()){
                        int tipo = Integer.parseInt(campoTIPO.getText());
                        String nombre = CTabvar.getObservacion(tipo);
                        if(!nombre.isEmpty()){
                            campoNOMBRE.setText(nombre);                            
                        }
                    }else{
                        campoTIPO.setText("0");
                    }
                    tipo = campoTIPO.getText();
                    campoTIPO.transferFocus();
                }
                if(KeyEvent.VK_F2 == e.getKeyCode())
                    campoTIPO.transferFocusBackward();
            }
        });
        
        campoNUMERO.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoNUMERO();
            }
        });
        campoNUMERO.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    
                    if(!campoTIPO.getText().isEmpty() && !campoNUMERO.getText().isEmpty()){
                        int tipo = Integer.parseInt(campoTIPO.getText());
                        int numero = Integer.parseInt(campoNUMERO.getText());
                        if(tipo > 0 && numero > 0){

                            Tabvar tabvar = CTabvar.getTabvar(tipo, numero);
                            if(tabvar != null){                                
                                recuperarTabla(tabvar);
                            }else{
                                OPCION = "GUARDAR";
                                campoCORREL.setText(campoNUMERO.getText());
                                focoCampoDESCRIPCION();
                                campoNUMERO.transferFocus();                                
                            }
                        }
                    }else{
                        campoNUMERO.transferFocus();
                    }
                    numero = campoNUMERO.getText();
                }
            }
        });
        
        campoDESCRIPCION.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    descripcion = campoDESCRIPCION.getText();
                    if(!campoDESCRIPCION.getText().isEmpty()){
                        focoCampoNOMBRE();
                    }                    
                }
            }
        });
        campoDESCRIPCION.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoDESCRIPCION();
            }
        });
        
        campoNOMBRE.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    nombre = campoNOMBRE.getText();
                    if(!campoNOMBRE.getText().isEmpty())
                        focoCampoCODCON();
                }
            }
        });
        campoNOMBRE.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoNOMBRE();
            }
        });
        
        campoCODCON.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    codcon = campoCODCON.getText();
                    if(campoCODCON.getText().isEmpty()){
                        int tipo = 0;
                        int numero = 0;
                        if(!campoTIPO.getText().isEmpty()){
                            tipo = Integer.parseInt(campoTIPO.getText());
                        }
                        if(!campoNUMERO.getText().isEmpty()){
                            numero = Integer.parseInt(campoNUMERO.getText());
                        }
                        int codcon = tipo*1000 + numero;
                        campoCODCON.setText(String.valueOf(codcon));                        
                    }
                    focoCampoCORREL();
                    campoCODCON.transferFocus();
                }
            }
        });
        campoCODCON.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoCODCON();
            }
        });
        
        campoCORREL.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){                    
                    if(campoCORREL.getText().isEmpty())
                        campoCORREL.setText("0");
                    correl = campoCORREL.getText();
                    focoCampoMONTO1();
                    campoCORREL.transferFocus();
                }
            }
        });
        campoCORREL.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoCORREL();
            }
        });
        
        campoMONTO1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    focoCampoMONTO2();
                    campoMONTO1.transferFocus();
                }
            }
        });
        campoMONTO1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoMONTO1();
            }
        });
        campoMONTO2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){                    
                    modificarFecha();
                    campoMONTO2.transferFocus();                    
                }
            }
        });
        campoMONTO2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if(campoMONTO2.getText().isEmpty())
                    campoMONTO2.setText("0");
            }
        });
        campoMONTO2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoMONTO2();
            }
        });        
        campoFECHA1.getDateEditor().getUiComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    try {
                        if(!new Fecha().getFecha(campoFECHA1.getDate(), "yyyy-MM-dd").isEmpty()){
                            focoCampoFECHA2();                            
                        }
                    } catch (Exception ex) {}
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    try {
                        if(!new Fecha().getFecha(campoFECHA1.getDate(), "yyyy-MM-dd").isEmpty()){
                            focoCampoFECHA2();
                            campoFECHA1.getDateEditor().getUiComponent().transferFocusBackward();
                        }
                    } catch (Exception ex) {}
                }
            }
        });
        campoFECHA1.getDateEditor().getUiComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoFECHA1();
            }
        });
        campoFECHA2.getDateEditor().getUiComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    try {
                        if(!new Fecha().getFecha(campoFECHA2.getDate(), "yyyy-MM-dd").isEmpty()){                            
                            switch(OPCION){                                
                                case "MODIFICAR":
                                    modificarDatosTabvar();
                                break;                                
                                case "GUARDAR":
                                    grabarDatosTabvar();
                                break;
                            }                            
                        }else{
                            campoFECHA2.setDateFormatString("yyyy-MM-dd");
                            campoFECHA2.setDate(new Date());
                        }
                    } catch (Exception ex) {System.out.println("Error: "+ex.getMessage());}
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    campoFECHA2.getDateEditor().getUiComponent().transferFocusBackward();
                }
            }            
        });
        campoFECHA2.getDateEditor().getUiComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoFECHA2();
            }
        });
    }
    private void habilitar_deshabilitarBotones(boolean estado){
        botonF1.setEnabled(estado);
        botonF2.setEnabled(estado);
        botonF3.setEnabled(estado);
        botonF4.setEnabled(estado);
        botonF5.setEnabled(estado);
        botonF6.setEnabled(estado);
        botonF7.setEnabled(estado);
        botonF8.setEnabled(estado);
        botonF9.setEnabled(estado);
        
        panelContenedorMensajes.setBackground(Color.WHITE);
        
        campoOPCION1.setVisible(estado);
        campoOPCION2.setVisible(estado);
        campoOPCION3.setVisible(estado);
        campoOPCION4.setVisible(estado);
        campoOPCION5.setVisible(estado);
        campoOPCION6.setVisible(estado);
        campoOPCION7.setVisible(estado);
    }
    private void recuperarTabla(Tabvar tabvar){        
        habilitar_deshabilitarBotones(false);
        
        panelContenedorMensajes.setBackground(new Color(255, 255, 159));
        iuMensajes.setText("ITEM DE TABLA YA EXISTE, RECUPERO?? ...S/N");
        
        campoOPCION1.setVisible(true);        
        campoOPCION1.requestFocus();
        
        campoOPCION1.setText("S");
        
        campoOPCION1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){                    
                    switch(campoOPCION1.getText()){
                        case "S":
                            campoTIPO.setEditar(false);
                            campoNUMERO.setEditar(false);
                            
                            mostrarDatosTabvar(tabvar);
                            explorarOpcionesTabla();
                        break;
                        case "N":
                            focoCampoNUMERO();
                        break;
                    }
                }
            }
        });
    }
    private void explorarOpcionesTabla(){
        habilitar_deshabilitarBotones(false);
        
        panelContenedorMensajes.setBackground(new Color(255, 255, 159));
        iuMensajes.setText("DESEA MODIFICAR ESTE ITEM.....S/N");                
        
        campoOPCION2.setVisible(true);
        campoOPCION2.requestFocus();
        
        campoOPCION2.setText("S");
        
        campoOPCION2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){                    
                    switch(campoOPCION2.getText()){
                        case "S":
                            OPCION = "MODIFICAR";
                            campoTIPO.setEditar(false);
                            campoNUMERO.setEditar(false);
                            focoCampoDESCRIPCION();
                        break;
                        case "N":                            
                            eliminarTablaTabvar();
                        break;
                    }
                }
            }
        });
    }
    private void eliminarTablaTabvar(){
        habilitar_deshabilitarBotones(false);
        
        panelContenedorMensajes.setBackground(new Color(255, 255, 159));
        iuMensajes.setText("ENTONCES DESEA ELIMINARLO........S/N");
        
        campoOPCION3.setVisible(true);
        campoOPCION3.requestFocus();
                
        campoOPCION3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoOPCION3.getText()){
                        case "S":
                            eliminarRegistro();
                        break;
                        case "N":
                            limpiarCampos();
                        break;
                    }
                }
            }
        });
    }
    private void modificarFecha(){        
        habilitar_deshabilitarBotones(false);
        
        panelContenedorMensajes.setBackground(new Color(255, 255, 159));
        iuMensajes.setText("DESEA MODIFICAR PARAMETROS FECHA???......S/N");
        
        campoOPCION4.setVisible(true);
        campoOPCION4.requestFocus();
        
        campoOPCION4.setText("N");
        
        campoOPCION4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    campoTIPO.setEditar(false);
                    campoNUMERO.setEditar(false);
                    campoDESCRIPCION.setEditar(false);
                    campoNOMBRE.setEditar(false);
                    campoCODCON.setEditar(false);
                    campoCORREL.setEditar(false);
                    campoMONTO1.setEditar(false);
                    campoMONTO2.setEditar(false);
                    
                    switch(campoOPCION4.getText()){
                        case "S":                            
                            focoCampoFECHA1();                            
                        break;
                        case "N":
                            if(OPCION.equalsIgnoreCase("MODIFICAR"))
                                modificarDatosTabvar();
                            if(OPCION.equalsIgnoreCase("GUARDAR"))
                                grabarDatosTabvar();                                                        
                        break;
                    }
                }
            }
        });
    }
    private void modificarDatosTabvar(){
        habilitar_deshabilitarBotones(false);
        
        panelContenedorMensajes.setBackground(new Color(255, 255, 159));
        iuMensajes.setText("DATOS LISTOS PARA MODIFICAR, MODIFICO?.......S/N");
        
        campoOPCION5.setVisible(true);
        campoOPCION5.requestFocus();
        
        campoOPCION5.setText("S");
        
        campoOPCION5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoOPCION5.getText()){
                        case "S":
                            modificarDatosRegistro();
                        break;
                        case "N":
                            campoFECHA1.getDateEditor().getUiComponent().setFocusable(false);
                            campoFECHA1.getDateEditor().getUiComponent().setEnabled(false);
                            campoFECHA2.getDateEditor().getUiComponent().setFocusable(false);
                            campoFECHA2.getDateEditor().getUiComponent().setEnabled(false);
                            campoTIPO.setEditar(true);
                            campoNUMERO.setEditar(true);
                            focoCampoTIPO();
                        break;
                    }
                }
            }
        });
    }
    private void grabarDatosTabvar(){        
        habilitar_deshabilitarBotones(false);                
        
        panelContenedorMensajes.setBackground(new Color(255, 255, 159));
        iuMensajes.setText("DATOS LISTOS PARA GRABAR, GRABO?.......S/N");
        
        campoOPCION6.setVisible(true);
        campoOPCION6.requestFocus();
        
        campoOPCION6.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoOPCION6.getText()){
                        case "S":
                            guardarNuevoRegistro();
                        break;
                        case "N":
                            campoNUMERO.setEditar(true);
                            campoDESCRIPCION.setEditar(true);
                            campoNOMBRE.setEditar(true);
                            campoCODCON.setEditar(true);
                            campoCORREL.setEditar(true);
                            campoMONTO1.setEditar(true);
                            campoMONTO2.setEditar(true);
                            focoCampoTIPO();
                        break;
                    }
                }
            }
        });
    }
    private void focoCampoTIPO(){
        OPCION = "";
        campoTIPO.setEditar(true);
        campoTIPO.requestFocus();
        iuMensajes.setText("campo TIPO:  [F1]=Ayuda, [F7]=Anterior o [F8]=Concluye");
        
        panelContenedorMensajes.setBackground(Color.WHITE);
        habilitar_deshabilitarBotones(false);
        
        botonF1.setEnabled(true);
        botonF7.setEnabled(true);
        botonF8.setEnabled(true);

        botonF1.getActionMap().put( "F1", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                botonF1.doClick();
                VAyuda iuAyuda = new VAyuda(ventanaPrincipal, "Tabla de Ayuda", "intermedio");
                iuAyuda.mostrarVentana();
            }
        });
        botonF7.getActionMap().put( "F7", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){      
                if(campoTIPO.isFocusable()){
                    botonF7.doClick();
                    campoTIPO.setText(tipo);
                }
            }
        });
        botonF8.getActionMap().put( "F8", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                botonF8.doClick();                
                dispose();
            }
        });
    }
    private void focoCampoNUMERO(){
        campoNUMERO.setEditar(true);
        campoNUMERO.requestFocus();        
        iuMensajes.setText("DIGITE No. ITEM:  [F1]=Ayuda, [F7]=Ultimo o [F8]=Incrementa");
        
        panelContenedorMensajes.setBackground(Color.WHITE);
        habilitar_deshabilitarBotones(false);
        
        botonF1.setEnabled(true);
        botonF7.setEnabled(true);
        botonF8.setEnabled(true);

        botonF1.getActionMap().put( "F1", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                botonF1.doClick();
            }
        });
        botonF7.getActionMap().put( "F7", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                if(campoNUMERO.isFocusable()){
                    botonF7.doClick();
                    campoNUMERO.setText(numero);
                }                
            }
        });
        botonF8.getActionMap().put( "F8", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                botonF8.doClick();  
                int numero = 0;
                if(!campoNUMERO.getText().isEmpty()){
                    numero = Integer.parseInt(campoNUMERO.getText()) + 1;
                    campoNUMERO.setText(String.valueOf(numero));
                }else{
                    numero++;
                    campoNUMERO.setText(String.valueOf(numero));
                }
            }
        });
    }
    private void focoCampoDESCRIPCION(){        
        panelContenedorMensajes.setBackground(Color.WHITE);
        iuMensajes.setText("DESCRIPCION DEL PARAMETRO (x25), [F7]=Anterior");
        
        campoDESCRIPCION.setEditar(true);
        campoDESCRIPCION.requestFocus();
        
        habilitar_deshabilitarBotones(false);
        botonF7.setEnabled(true);
        
        botonF7.getActionMap().put( "F7", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                if(campoDESCRIPCION.isFocusable()){
                    botonF7.doClick();                
                    campoDESCRIPCION.setText(descripcion);
                }                
            }
        });
        
    }
    private void focoCampoNOMBRE(){
        panelContenedorMensajes.setBackground(Color.WHITE);
        iuMensajes.setText("DESCRIPCION GENERICA DEL PARAMETRO(x20), [F7]=Anterior");
        
        campoNOMBRE.setEditar(true);
        campoNOMBRE.requestFocus();
        
        habilitar_deshabilitarBotones(false);
        
        botonF7.setEnabled(true);
        
        botonF7.getActionMap().put( "F7", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                if(campoNOMBRE.isFocusable()){
                    botonF7.doClick();                
                    campoNOMBRE.setText(nombre);
                }                
            }
        });        
    }
    private void focoCampoCODCON(){
        panelContenedorMensajes.setBackground(Color.WHITE);
        iuMensajes.setText("Cod.Cta Contable, [F1]=Ayuda, [F7]=Anterior, [F8]=Auto-Codifica");
        
        campoCODCON.setEditar(true);
        campoCODCON.requestFocus();
        
        habilitar_deshabilitarBotones(false);
        
        botonF1.setEnabled(true);
        botonF7.setEnabled(true);
        botonF8.setEnabled(true);
        
        botonF7.getActionMap().put( "F7", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                if(campoNOMBRE.isFocusable()){
                    botonF7.doClick();                
                    campoNOMBRE.setText(nombre);
                }                
            }
        });
        botonF8.getActionMap().put( "F8", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                if(campoNOMBRE.isFocusable()){
                    botonF8.doClick();               
                    int tipo = 0;
                    int numero = 0;
                    if(!campoTIPO.getText().isEmpty())
                        tipo = Integer.parseInt(campoTIPO.getText());
                    if(!campoNUMERO.getText().isEmpty())
                        numero = Integer.parseInt(campoNUMERO.getText());
                    int codcon = 1000*tipo + numero;                        
                    campoCODCON.setText(String.valueOf(codcon));
                    focoCampoCORREL();
                    campoCODCON.transferFocus();
                }                
            }
        });
    }
    private void focoCampoCORREL(){
        iuMensajes.setText("CONFIRME CORRELTV-NUMERADOR o [F7]=Auto-Codifica");
        
        campoCORREL.setEditar(true);
        campoCORREL.requestFocus();
        
        habilitar_deshabilitarBotones(false);
        
        botonF7.setEnabled(true);
        
        botonF7.getActionMap().put( "F7", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                if(campoNOMBRE.isFocusable()){
                    botonF7.doClick();                
                    int numero = Integer.parseInt(campoNUMERO.getText())*1000 + 1;
                    campoCORREL.setText(String.valueOf(numero));
                    focoCampoMONTO1();
                    campoCORREL.transferFocus();
                }                
            }
        });        
    }
    private void focoCampoMONTO1(){
        campoMONTO1.setEditar(true);
        iuMensajes.setText("INDIQUE PARAMETRO FINANCIERO 1 (Con Decimales)");
        habilitar_deshabilitarBotones(false);
    }
    private void focoCampoMONTO2(){        
        campoMONTO2.setEditar(true);
        iuMensajes.setText("INDIQUE PARAMETRO FINANCIERO 2 (Entero)");
        habilitar_deshabilitarBotones(false);
    }
    private void focoCampoFECHA1(){
        campoFECHA1.getDateEditor().getUiComponent().setFocusable(true);
        campoFECHA1.getDateEditor().getUiComponent().setEnabled(true);
        campoFECHA1.getDateEditor().getUiComponent().requestFocus();
                
        panelContenedorMensajes.setBackground(Color.WHITE);
        iuMensajes.setText("PROPORCIONE FECHA 1 o [F1]=Hoy........");        
        
        habilitar_deshabilitarBotones(false);
        
        botonF1.setEnabled(true);        
        botonF1.getActionMap().put( "F1", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                if(campoFECHA1.isFocusable()){
                    botonF7.doClick();                
                    campoFECHA1.setDateFormatString("yyyy-MM-dd");
                    campoFECHA1.setDate(new Date());
                }                
            }
        });
    }
    private void focoCampoFECHA2(){        
        campoFECHA2.getDateEditor().getUiComponent().setFocusable(true);
        campoFECHA2.getDateEditor().getUiComponent().setEnabled(true);
        campoFECHA2.getDateEditor().getUiComponent().requestFocus();
        
        iuMensajes.setText("PROPORCIONE FECHA 2........");        
        habilitar_deshabilitarBotones(false);
    }
}

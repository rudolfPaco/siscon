/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view;

import SIGU.botones.IUBoton;
import SIGU.botones.SIUBoton;
import SIGU.campoTexto.IUCampoTexto;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.paneles.IUPanel;
import SIGU.recursos.Area;
import SIGU.recursos.Fecha;
import SIGU.ventanas.IUSecundario;
import com.siscon.controller.CTabvar;
import com.siscon.model.Tabvar;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class VITabvar extends IUSecundario{
    
    private VPrincipal ventanaPrincipal;
    
    private IUPanel panel;
        private IUPanel panelTitulo;
        private IUEtiqueta iuTitulo;
    
    private IUPanel panelDatos;
        private IUPanel panelPrincipal;
            private IUPanel panelTablaTabvar;    
                private IUEtiqueta iuTituloTabvar;    
                private IUPanel panelDatosTabvar;
                    private IUPanel panelTipo;
                    private IUEtiqueta iuTipo;
                    private IUCampoTexto campoTipo;
                    private IUPanel panelNumero;
                    private IUEtiqueta iuNumero;
                    private IUCampoTexto campoNumero;
                    private IUPanel panelDescripcion;
                    private IUEtiqueta iuDescripcion;
                    private IUCampoTexto campoDescripcion;
                    
                private IUPanel panelDatosSecundariosTabvar;
                    private IUEtiqueta iuNOMBRE;
                    private IUCampoTexto campoNOMBRE;
                    private IUEtiqueta iuCODCON;
                    private IUCampoTexto campoCODCON;
                    private IUEtiqueta iuCORREL;
                    private IUCampoTexto campoCORREL;
                    private IUEtiqueta iuMONTO1;
                    private IUCampoTexto campoMONTO1;
                    private IUEtiqueta iuMONTO2;
                    private IUCampoTexto campoMONTO2;
                    private IUEtiqueta iuFECHA1;
                    private JDateChooser campoDate1 = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
                    private IUEtiqueta iuFECHA2;
                    private JDateChooser campoDate2 = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
                
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
        
        private IUPanel panelBotones;
            private IUBoton botonSalir;
            private IUBoton botonImprimir;
            private IUBoton botonLimpiar;    
            private IUBoton botonEliminar;
            private IUBoton botonModificar;
            private IUBoton botonGrabar;
            private IUBoton botonMostrar;
            private IUBoton botonCargar;
    
    private String estadoOp = "";
    
    public VITabvar(VPrincipal ventanaPrincipal, String tipoSize) {
        super(ventanaPrincipal, "", tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        
        construirPaneles();
        setEventos();
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
        panelPrincipal = new IUPanel(panelDatos, new Area(a.X(), a.Y(), a.An(), a.AlP(70)), true);
        construirPanelTabvar(new Area(2, 2, panelPrincipal.area.An() - 6, panelPrincipal.area.Al() - 4));
        
        panelMensajes = new IUPanel(panelDatos, new Area(a.X(), a.Y(2) + a.AlP(70), a.An(), a.AlP(15)), true);
        
        panelBotones = new IUPanel(panelDatos, new Area(a.X(), a.Y(1) + a.AlP(85), a.An(), a.AlP(15)), true);
        construirPanelBotones(new Area(4, 4, panelBotones.area.An() - 24, panelBotones.area.Al() - 12));
    }
    private void construirPanelTabvar(Area a){
        panelTablaTabvar = new IUPanel(panelPrincipal, new Area(a.X(), a.Y(), a.AnP(45), a.Al()), false);
        construirPanelPrincipal(new Area(2, 2, panelTablaTabvar.area.An() - 4, panelTablaTabvar.area.Al() - 8));
        
        panelInstrucciones = new IUPanel(panelPrincipal, new Area(a.X(2) + a.AnP(45), a.Y(), a.AnP(55), a.Al()), false);
        construirPanelInstrucciones(new Area(2, 2, panelInstrucciones.area.An() - 4, panelInstrucciones.area.Al() - 6));
    }
    private void construirPanelPrincipal(Area a){
        iuTituloTabvar = new IUEtiqueta(panelTablaTabvar, "TABLA PRINCIPAL 'TABVAR'", new Area(a.X(), a.Y(), a.An(), a.AlP(6)), 18, "CENTER", new Color(120, 0, 0));
        
        panelDatosTabvar = new IUPanel(panelTablaTabvar, new Area(a.X(), a.Y(2) + a.AlP(6), a.An(), a.AlP(14)), false);
        construirPanelDatosTabvar(new Area(4, 4, panelDatosTabvar.area.An() - 16, panelDatosTabvar.area.Al() -8));
        
        panelDatosSecundariosTabvar = new IUPanel(panelTablaTabvar, new Area(a.X(), a.Y(2) + a.AlP(20), a.An(), a.AlP(80)), false);
        construirPanelDatosSecundariosTabvar(new Area(2, 4, panelDatosSecundariosTabvar.area.An() - 4, panelDatosSecundariosTabvar.area.Al() - 32));        
    }
    private void construirPanelDatosTabvar(Area a){
        panelTipo = new IUPanel(panelDatosTabvar, new Area(a.X(), a.Y(), a.AnP(15), a.AlP(40)), true);
        iuTipo = new IUEtiqueta(panelTipo, "TIPO", new Area(panelTipo.area.An(), panelTipo.area.Al()), 14, "CENTER", false);        
        campoTipo = new IUCampoTexto(panelDatosTabvar, 4, 16, new Area(a.X(), a.Y() + a.AlP(40), a.AnP(15), a.AlP(60)));
        campoTipo.setRestriccion("^([0-9]|[1-9][0-9])$");
        panelTipo.setBackground(new Color(232, 237, 244));
        
        panelNumero = new IUPanel(panelDatosTabvar, new Area(a.X(2) + a.AnP(15), a.Y(), a.AnP(20), a.AlP(40)), true);
        iuNumero = new IUEtiqueta(panelNumero, "NUMERO", new Area(panelNumero.area.An(), panelNumero.area.Al()), 14, "CENTER", false);                
        campoNumero = new IUCampoTexto(panelDatosTabvar, 4, 16, new Area(a.X(2) + a.AnP(15), a.Y() + a.AlP(40), a.AnP(20), a.AlP(60)));
        campoNumero.setRestriccion("^([0-9]|[1-9][0-9])$");
        panelNumero.setBackground(new Color(232, 237, 244));
        
        panelDescripcion = new IUPanel(panelDatosTabvar, new Area(a.X(3) + a.AnP(35), a.Y(), a.AnP(65), a.AlP(40)), true);
        iuDescripcion = new IUEtiqueta(panelDescripcion, "DESCRIPCION", new Area(panelDescripcion.area.An(), panelDescripcion.area.Al()), 14, "CENTER", false);        
        campoDescripcion = new IUCampoTexto(panelDatosTabvar, 30, 16, new Area(a.X(3) + a.AnP(35), a.Y() + a.AlP(40), a.AnP(65), a.AlP(60)));
        campoDescripcion.setRestriccion("[\\p{Alpha}\\p{Alnum}\\p{Space}\\.\\/\\(\\)\\-]");
        panelDescripcion.setBackground(new Color(232, 237, 244));
    } 
    private void construirPanelDatosSecundariosTabvar(Area a){
        System.out.println("el area es: "+a);
        iuNOMBRE = new IUEtiqueta(panelDatosSecundariosTabvar, " a. Nombre:", new Area(a.X(), a.Y(), a.AnP(35), a.AlP(10)), 16, "LEFT", true);
        campoNOMBRE = new IUCampoTexto(panelDatosSecundariosTabvar, 20, 16, new Area(a.X() + a.AnP(35), a.Y(), a.AnP(65), a.AlP(10)));
        campoNOMBRE.setRestriccion("[\\p{Alpha}\\p{Alnum}\\p{Space}\\.\\/\\(\\)\\-]");
        
        iuCODCON = new IUEtiqueta(panelDatosSecundariosTabvar, " b. Cod. Contable:", new Area(a.X(), a.Y(2) + a.AlP(10), a.AnP(35), a.AlP(10)), 16, "LEFT", true);
        campoCODCON = new IUCampoTexto(panelDatosSecundariosTabvar, 30, 16, new Area(a.X() + a.AnP(35), a.Y(2) + a.AlP(10), a.AnP(24), a.AlP(10)));
        campoCODCON.setRestriccion("^([0-9]|[1-9][0-9])$");
        
        iuCORREL = new IUEtiqueta(panelDatosSecundariosTabvar, " c. Correlativo:", new Area(a.X(), a.Y(3) + a.AlP(20), a.AnP(35), a.AlP(10)), 16, "LEFT", true);
        campoCORREL = new IUCampoTexto(panelDatosSecundariosTabvar, 6, 16, new Area(a.X() + a.AnP(35), a.Y(3) + a.AlP(20), a.AnP(20), a.AlP(10)));
        campoCORREL.setRestriccion("^([0-9]|[1-9][0-9])$");
        
        iuMONTO1 = new IUEtiqueta(panelDatosSecundariosTabvar, " d. Monto 1.:", new Area(a.X(), a.Y(4) + a.AlP(30), a.AnP(35), a.AlP(10)), 16, "LEFT", true);
        campoMONTO1 = new IUCampoTexto(panelDatosSecundariosTabvar, 12, 16, new Area(a.X() + a.AnP(35), a.Y(4) + a.AlP(30), a.AnP(30), a.AlP(10)));
        campoMONTO1.setRestriccionNumeroDecimal();
        
        iuMONTO2 = new IUEtiqueta(panelDatosSecundariosTabvar, "              2.:", new Area(a.X(), a.Y(5) + a.AlP(40), a.AnP(35), a.AlP(10)), 16, "LEFT", true);
        campoMONTO2 = new IUCampoTexto(panelDatosSecundariosTabvar, 12, 16, new Area(a.X() + a.AnP(35), a.Y(5) + a.AlP(40), a.AnP(30), a.AlP(10)));
        campoMONTO2.setRestriccionNumeroDecimal();
        
        iuFECHA1 = new IUEtiqueta(panelDatosSecundariosTabvar, " d. Fecha 1.:", new Area(a.X(), a.Y(6) + a.AlP(50), a.AnP(35), a.AlP(10)), 16, "LEFT", true);        
        Area area = new Area(a.X() + a.AnP(35), a.Y(6) + a.AlP(50), a.AnP(30), a.AlP(10));
        campoDate1.setBounds(area.X(),area.Y(), area.An(), area.Al());        
        campoDate1.getDateEditor().getUiComponent().setFont(new Font("Verdana", Font.PLAIN, 16));
        campoDate1.getDateEditor().getUiComponent().setForeground(new Color(2, 67, 109));
        campoDate1.getDateEditor().getUiComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){                    
                    campoDate1.getDateEditor().getUiComponent().transferFocus();
                }
                if(KeyEvent.VK_ESCAPE == e.getKeyCode())
                    campoDate1.getDateEditor().getUiComponent().transferFocusBackward();
            }
        });
        panelDatosSecundariosTabvar.add(campoDate1);
        
        iuFECHA2 = new IUEtiqueta(panelDatosSecundariosTabvar, " e.          2.:", new Area(a.X(), a.Y(7) + a.AlP(60), a.AnP(35), a.AlP(10)), 16, "LEFT", true);        
        Area area2 = new Area(a.X() + a.AnP(35), a.Y(7) + a.AlP(60), a.AnP(30), a.AlP(10));
        campoDate2.setBounds(area2.X(),area2.Y(), area2.An(), area2.Al());        
        campoDate2.getDateEditor().getUiComponent().setFont(new Font("Verdana", Font.PLAIN, 16));
        campoDate2.getDateEditor().getUiComponent().setForeground(new Color(2, 67, 109));
        campoDate2.getDateEditor().getUiComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){                    
                    campoDate2.getDateEditor().getUiComponent().transferFocus();
                }
                if(KeyEvent.VK_ESCAPE == e.getKeyCode())
                    campoDate2.getDateEditor().getUiComponent().transferFocusBackward();
            }
        });
        panelDatosSecundariosTabvar.add(campoDate2);
    }
    private void construirPanelInstrucciones(Area a){
        panelTituloInstrucciones = new IUPanel(panelInstrucciones, new Area(a.X(), a.Y() + a.AlP(12), a.An(), a.AlP(8)), false);
        construirTituloInstrucciones(new Area(2, 2, panelTituloInstrucciones.area.An() - 6, panelTituloInstrucciones.area.Al() - 4));
        
        panelEtiquetaInstrucciones = new IUPanel(panelInstrucciones, new Area(a.X(), a.Y(2) + a.AlP(20), a.An(), a.AlP(79)), false);
        construirEtiquetasInstrucciones(new Area(2, 4, panelEtiquetaInstrucciones.area.An() - 6, panelEtiquetaInstrucciones.area.Al() - 32));
    }
    private void construirTituloInstrucciones(Area a){
        iuIntrucciones = new IUEtiqueta(panelTituloInstrucciones, "INSTRUCCIONES", new Area(a.X(), a.Y(), a.AnP(80), a.Al()), 18, "CENTER", true);
        iuFormato = new IUEtiqueta(panelTituloInstrucciones, "FORMATO", new Area(a.X(2) + a.AnP(80), a.Y(), a.AnP(20), a.Al()), 18, "CENTER", true);
    }
    private void construirEtiquetasInstrucciones(Area a){
        etiquetaNOMBRE = new IUEtiqueta(panelEtiquetaInstrucciones, "Denominacion del Parametro - Tabla", new Area(a.X(), a.Y(), a.AnP(80), a.AlP(10)), 16, "LEFT", true);
        etiquetaNOMBRE = new IUEtiqueta(panelEtiquetaInstrucciones, "x15", new Area(a.X(2) + a.AnP(80), a.Y(), a.AnP(20), a.AlP(10)), 16, "CENTER", true);
        
        etiquetaCODCON = new IUEtiqueta(panelEtiquetaInstrucciones, "Campo para Integrar la Contabilidad", new Area(a.X(), a.Y(2) + a.AlP(10), a.AnP(80), a.AlP(10)), 16, "LEFT", true);
        etiquetaCODCON = new IUEtiqueta(panelEtiquetaInstrucciones, "n8", new Area(a.X(2) + a.AnP(80), a.Y(2) + a.AlP(10), a.AnP(20), a.AlP(10)), 16, "CENTER", true);
        
        etiquetaCORREL = new IUEtiqueta(panelEtiquetaInstrucciones, "Campo encargado de Numerar", new Area(a.X(), a.Y(3) + a.AlP(20), a.AnP(80), a.AlP(10)), 16, "LEFT", true);
        etiquetaCORREL = new IUEtiqueta(panelEtiquetaInstrucciones, "n6", new Area(a.X(2) + a.AnP(80), a.Y(3) + a.AlP(20), a.AnP(20), a.AlP(10)), 16, "CENTER", true);
        
        etiquetaMONTO1 = new IUEtiqueta(panelEtiquetaInstrucciones, "Rangos Monetarios", new Area(a.X(), a.Y(4) + a.AlP(30), a.AnP(80), a.AlP(10)), 16, "LEFT", true);
        etiquetaMONTO1 = new IUEtiqueta(panelEtiquetaInstrucciones, "n8,2", new Area(a.X(2) + a.AnP(80), a.Y(4) + a.AlP(30), a.AnP(20), a.AlP(10)), 16, "CENTER", true);
        
        etiquetaFECHA1 = new IUEtiqueta(panelEtiquetaInstrucciones, "Rango de Fechas", new Area(a.X(), a.Y(6) + a.AlP(50), a.AnP(80), a.AlP(10)), 16, "LEFT", true);
        etiquetaFECHA1 = new IUEtiqueta(panelEtiquetaInstrucciones, "dd/mm/aaaa", new Area(a.X(2) + a.AnP(80), a.Y(6) + a.AlP(50), a.AnP(20), a.AlP(10)), 16, "CENTER", true);
    }
    private void construirPanelBotones(Area a){
        botonSalir = new IUBoton(panelBotones, new Area(a.X(5) + a.AnP(85), a.Y(2) + a.AlP(50), a.AnP(15), a.AlP(50)), "SALIR", "/imagenes/cerrar.png", 16, 30, 5, SwingConstants.RIGHT, SwingConstants.CENTER, 'S', "boton que cierrar la ventana emergente.");
        botonLimpiar = new IUBoton(panelBotones, new Area(a.X(4) + a.AnP(70), a.Y(2) + a.AlP(50), a.AnP(15), a.AlP(50)), "LIMPIAR", "/imagenes/erase.png", 16, 30, 5, SwingConstants.RIGHT, SwingConstants.CENTER, 'L', "boton que limpia los campos de datos.");
        botonEliminar = new IUBoton(panelBotones, new Area(a.X(3) + a.AnP(55), a.Y(2) + a.AlP(50), a.AnP(15), a.AlP(50)), "ELIMINAR", "/imagenes/delete.png", 16, 30, 5, SwingConstants.RIGHT, SwingConstants.CENTER, 'E', "boton que elimina un registro de la tabla TABVAR.");
        botonModificar = new IUBoton(panelBotones, new Area(a.X(2) + a.AnP(40), a.Y(2) + a.AlP(50), a.AnP(15), a.AlP(50)), "MODIFCAR", "/imagenes/edit.png", 16, 30, 5, SwingConstants.RIGHT, SwingConstants.CENTER, 'M', "boton que Modifica un registro de la tabla TABVAR.");
        botonGrabar = new IUBoton(panelBotones, new Area(a.X(1) + a.AnP(25), a.Y(2) + a.AlP(50), a.AnP(15), a.AlP(50)), "GRABAR", "/imagenes/save.png", 16, 30, 5, SwingConstants.RIGHT, SwingConstants.CENTER, 'G', "boton que guarda un nuevo registro a la Base de Datos.");
        
        botonCargar = new IUBoton(panelBotones, new Area(a.X(), a.Y(), a.AnP(15), a.AlP(50)), "CARGAR", "/imagenes/bajar.png", 16, 30, 5, SwingConstants.RIGHT, SwingConstants.CENTER, 'C', "boton que carga el archivo a la tabla TABVAR de la Base de Datos.");
        botonMostrar = new IUBoton(panelBotones, new Area(a.X(), a.Y(2) + a.AlP(50), a.AnP(15), a.AlP(50)), "MOSTRAR", "/imagenes/ojos.png", 16, 30, 5, SwingConstants.RIGHT, SwingConstants.CENTER, 'O', "boton que muestra toda la tabla TABVAR.");
    }
    
    private void limpiarCampos(){
        estadoOp = "";
        campoTipo.setText("");
        campoNumero.setText("");
        campoDescripcion.setText("");
        campoNOMBRE.setText("");
        campoCODCON.setText("");
        campoCORREL.setText("");
        campoMONTO1.setText("");
        campoMONTO2.setText("");
        campoDate1.setCalendar(null);
        campoDate2.setCalendar(null);
        setEstadosIniciales(false);
        setEstadoBotonesIniciales(false);
    }
    private void setEstadosIniciales(boolean estado){
        campoDescripcion.setEditar(estado);
        campoNOMBRE.setEditar(estado);
        campoCODCON.setEditar(estado);
        campoCORREL.setEditar(estado);
        campoMONTO1.setEditar(estado);
        campoMONTO2.setEditar(estado);
        campoDate1.getDateEditor().getUiComponent().setFocusable(estado);
        campoDate1.getDateEditor().getUiComponent().setEnabled(estado);
        campoDate2.getDateEditor().getUiComponent().setFocusable(estado);
        campoDate2.getDateEditor().getUiComponent().setEnabled(estado);
        
        campoDescripcion.setText("");
        campoNOMBRE.setText("");
        campoCODCON.setText("");
        campoCORREL.setText("");
        campoMONTO1.setText("");
        campoMONTO2.setText("");
        campoDate1.setCalendar(null);
        campoDate2.setCalendar(null);
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
            campoDescripcion.requestFocus();
            JOptionPane.showMessageDialog(ventanaPrincipal, "Lo siento, no existe ningun registro con los datos iniciales....\npodra grabar un nuevo registro...!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);            
        }
        estadoOp = "GRABAR";
        
    }
    private void mostrarDatosTabvar(Tabvar tabvar){        
        estadoOp = "MODIFICAR";        
        setEstadoBotonesIniciales(false);
        setEstadosIniciales(true);
        botonModificar.setEnabled(true);
        botonEliminar.setEnabled(true);
        
        campoTipo.setText(String.valueOf(tabvar.getTipo()));
        campoNumero.setText(String.valueOf(tabvar.getNumero()));
        campoDescripcion.setText(tabvar.getDescri());
        campoNOMBRE.setText(tabvar.getObserv());
        
        campoCODCON.setText(String.valueOf(tabvar.getCodcon()));        
        campoCORREL.setText(String.valueOf(tabvar.getCorrel()));
        campoMONTO1.setText(String.valueOf(tabvar.getMonto()));
        campoMONTO2.setText(String.valueOf(tabvar.getMonto2()));

        if(tabvar.getFecha() == null)
            campoDate1.setCalendar(null);
        else
            campoDate1.setDate(new Fecha(tabvar.getFecha()).getDate());
        
        if(tabvar.getFecha2() == null)
            campoDate2.setCalendar(null);
        else
            campoDate2.setDate(new Fecha(tabvar.getFecha2()).getDate());        
    }
    private boolean noExistenCamposVacios(){
        boolean verificador = false;
        if(!campoTipo.getText().isEmpty()){
            if(!campoNumero.getText().isEmpty()){
                verificador = true;
            }
        }
        return verificador;
    }
    private void eliminarRegistro(){        
        if(!campoTipo.getText().isEmpty()){
            if(!campoNumero.getText().isEmpty()){
                int tipo = Integer.parseInt(campoTipo.getText());
                int numero = Integer.parseInt(campoNumero.getText());
                if(tipo > 0 && numero > 0){
                    int resp = JOptionPane.showConfirmDialog(ventanaPrincipal, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
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
        if(!campoTipo.getText().isEmpty()){
            if(!campoNumero.getText().isEmpty()){
                int tipo = Integer.parseInt(campoTipo.getText());
                int numero = Integer.parseInt(campoNumero.getText());
                if(tipo > 0 && numero > 0){

                    Tabvar tabvar = CTabvar.getTabvar(tipo, numero);
                    if(tabvar == null){
                        JOptionPane.showMessageDialog(null, "Lo siento, pero no existe el registro TABVAR con TIPO = "+tipo+" y NUMERO = "+numero+" en la BASE DE DATOS....!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    }else{
                        if(noExistenCamposVacios()){         
                            tabvar.setTipo(Integer.parseInt(campoTipo.getText()));
                            tabvar.setNumero(Integer.parseInt(campoNumero.getText()));
                            tabvar.setDescri(campoDescripcion.getText());
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

                            if(campoDate1.getDate() != null)
                                tabvar.setFecha(new Fecha().getFecha(campoDate1.getDate(), "yyyy-MM-dd"));
                            else
                                tabvar.setFecha(null);

                            if(campoDate2.getDate() != null)
                                tabvar.setFecha2(new Fecha().getFecha(campoDate2.getDate(), "yyyy-MM-dd"));
                            else
                                tabvar.setFecha2(null);

                            //System.out.println("la tabvar PARA MODIFICAR ES: "+tabvar.toString());
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
            tabvar.setTipo(Integer.parseInt(campoTipo.getText()));
            tabvar.setNumero(Integer.parseInt(campoNumero.getText()));
            tabvar.setDescri(campoDescripcion.getText());
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
                        
            if(campoDate1.getDate() != null)
                tabvar.setFecha(new Fecha().getFecha(campoDate1.getDate(), "yyyy-MM-dd"));
            else
                tabvar.setFecha(null);
            
            if(campoDate2.getDate() != null)
                tabvar.setFecha2(new Fecha().getFecha(campoDate2.getDate(), "yyyy-MM-dd"));
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
        
        campoNumero.addFocusListener(new FocusAdapter() {
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
                                mostrarDatosTabvar(tabvar);
                            }
                        }
                    }
                }
            }
        });
    }
}

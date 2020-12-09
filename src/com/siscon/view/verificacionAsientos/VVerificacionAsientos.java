/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.verificacionAsientos;

import SIGU.campoTexto.IUAreaTexto;
import SIGU.campoTexto.IUCampoTexto;
import SIGU.comboBox.IUComboBox;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.paneles.IUPanel;
import SIGU.paneles.IUPanelEtiqueta;
import SIGU.recursos.Area;
import SIGU.recursos.Fecha;
import SIGU.tablas.IUTabla;
import SIGU.tablas.ModeloTabla;
import SIGU.ventanas.IUSecundario;
import com.siscon.controller.CConmae;
import com.siscon.controller.CContra;
import com.siscon.model.Conmae;
import com.siscon.model.Contra;
import com.siscon.model.Descuadre;
import com.siscon.model.Errores;
import com.siscon.model.Tabvar;
import com.siscon.model.Usuario;
import com.siscon.recursos.Ayuda;
import com.siscon.view.VPrincipal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author neo
 */
public class VVerificacionAsientos extends IUSecundario{
    private VPrincipal ventanaPrincipal;
    private String titulo;
    
    private IUPanel panel;
        private IUPanel panelTitulo;
        private IUEtiqueta iuTitulo;
    
    private IUEtiqueta iuTituloEmpresa;    
        
    private IUPanel panelDatos;
        private IUPanel primerPanel;
            private IUPanel panelContenido;
                private IUPanel panelUno;
                    private IUEtiqueta iuEtiquetaObjetivo;
                    private IUAreaTexto iuObjetivo;
                    private IUEtiqueta iuEtiquetaMoneda;
                    private IUComboBox iuMoneda;
                    
                    private IUPanelEtiqueta nroComprobante;
                    private IUCampoTexto iuNroComprobante;
                    private IUPanelEtiqueta cantComprobante;
                    private IUCampoTexto iuCantComprobante;
                    private IUPanelEtiqueta debe;
                    private IUCampoTexto iuDebe;
                    private IUPanelEtiqueta haber;
                    private IUCampoTexto iuHaber;
                                        
                    private IUEtiqueta iuDocumentosDescuadrados;
                    private IUTabla iuTablaDescuadrados;
                    
                    private IUPanelEtiqueta descuadreNroComprobante;
                    private IUCampoTexto iuDescuadreNroComprobante;
                    private IUPanelEtiqueta debitos;
                    private IUCampoTexto iuDebitos;
                    private IUPanelEtiqueta abonos;
                    private IUCampoTexto iuAbonos;
                    
                    private IUPanelEtiqueta leidos;
                    private IUCampoTexto iuLeidos;
                    private IUPanelEtiqueta nroDocumento;
                    private IUCampoTexto iuNroDocumento1;
                    private IUTabla iuTablaErrores;
                    private IUPanelEtiqueta hacia;
                    private IUCampoTexto iuNroDocuemnto2;
                    private IUPanelEtiqueta codigoCuenta;
                    private IUCampoTexto iuCodigoCuenta;
                    
                private IUPanel panelDos;                    
        
        private IUPanel segundoPanel;
            private IUEtiqueta iuTituloMensaje;
            private IUPanelEtiqueta iuMensaje;
            private IUPanelEtiqueta iuInformacion;
            private IUCampoTexto campoS_N1;
            private IUCampoTexto campoS_N2;
            private IUCampoTexto campoS_N3;
    
    private String moneda = "";
            
    private final Usuario usuario;
    private final Tabvar tabvar;
    
    public VVerificacionAsientos(VPrincipal ventanaPrincipal, String titulo, String tipoSize, Usuario usuario, Tabvar tabvar) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        this.usuario = usuario;
        this.tabvar = tabvar;
        
        construirPanel(new Area(An()-6, Al()-29));
        algoritmosInicial();
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
        panelTitulo = new IUPanel(panel, new Area(a.X(), a.Y(), a.An(), a.AlP(7)), true, Ayuda.COLOR_FONDO);
        construirPanelTitulo(new Area(panelTitulo.area.AnP(2), 2, panelTitulo.area.An() - panelTitulo.area.AnP(2)*4, panelTitulo.area.Al() - 4));
        
        iuTituloEmpresa = new IUEtiqueta(panel, Ayuda.getDatoCadena("DESCRI", "SELECT DESCRI FROM TABVAR WHERE TIPO = 10 AND NUMERO = 1"), new Area(a.X(), a.Y() + a.AlP(10), a.An(), a.AlP(5)), 20, "CENTER", Ayuda.COLOR_ROJO);
        iuTituloEmpresa.setSubrayarTexto(true);
        
        panelDatos = new IUPanel(panel, new Area(a.X(), a.Y(2) + a.AlP(7), a.An(), a.AlP(93)), false, Ayuda.COLOR_FONDO);
        construirPanelDatos(new Area(2, 2, panelDatos.area.An() - 4, panelDatos.area.Al() - 6));
    }
    
    private void construirPanelTitulo(Area a){
        iuTitulo = new IUEtiqueta(panelTitulo, usuario.getRazsoc(), new Area(a.X(), a.Y(), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "VERIFICACION DE ASIENTOS", new Area(a.X(2) + a.AnP(25), a.Y(), a.AnP(35), a.AlP(50)), 16, "CENTER", false);        
        iuTitulo.setSubrayarTexto(true);
        //iuTitulo = new IUEtiqueta(panelTitulo, "Por: GRUPO - NIVEL", new Area(a.X(2) + a.AnP(25), a.Y(2) + a.AlP(45), a.AnP(35), a.AlP(50)), 16, "CENTER", false);                
        //iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "SISTEMA CONTABLE SISCON @v7.2. 2020", new Area(a.X(3) + a.AnP(60), a.Y(), a.AnP(40), a.AlP(50)), 16, "RIGHT", false); 
        iuTitulo = new IUEtiqueta(panelTitulo, new Fecha().getFecha1(), new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(45), a.AnP(40), a.AlP(50)), 16, "RIGHT", false); 
        
        iuTitulo = new IUEtiqueta(panelTitulo, "Pantalla: VA ", new Area(a.X(), a.Y(2) + a.AlP(45), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
    }
    private void construirPanelDatos(Area a){
        primerPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(), a.An(), a.AlP(85)), false);
        construirPrimerPanel(new Area(a.AnP(20), a.AlP(10), primerPanel.area.An() - a.AnP(20)*2, primerPanel.area.Al() - a.AlP(10)*2));
        
        segundoPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(2) + a.AlP(85), a.An(), a.AlP(15)), false);
        construirSegundoPanel(new Area(8, 2, segundoPanel.area.An() - 24, segundoPanel.area.Al() - 8));
    }
    private void construirPrimerPanel(Area a){
        panelContenido = new IUPanel(primerPanel, new Area(a.X(), a.Y(), a.An(), a.Al()), true);
        construirPanelContenido(new Area(2, 2, a.An() - 4, a.Al() - 6));
    }
    private void construirPanelContenido(Area a){
        panelUno = new IUPanel(panelContenido, new Area(a.X(), a.Y(), a.An(), a.AlP(60)), false);
        construirPanelUno(new Area(2, 2, a.An() - 18, a.Al() - 8));
        
        panelDos = new IUPanel(panelContenido, new Area(a.X(), a.Y(2) + a.AlP(60), a.An(), a.AlP(40)), false);        
        construirPanelDos(new Area(2, 2, panelDos.area.An() - 18, panelDos.area.Al() - 8));
    }
    private void construirPanelUno(Area a){
        iuEtiquetaObjetivo = new IUEtiqueta(panelUno, "OBJETIVO:", new Area(a.X(), a.Y(), a.AnP(30), a.AlP(5)), 16, "CENTER", true);
        iuObjetivo = new IUAreaTexto(panelUno, new Area(a.X(2) + a.AnP(30), a.Y(), a.AnP(71), a.AlP(20)), "Este programa permite realizar una consulta del monto acumulado\n" +
                                                                                                          "en los Comprobantes Contables, los posibles descuadres, \n" +
                                                                                                          "verifica la consistencia de las Cuentas en el Codificador y su \n" +
                                                                                                          "respectiva Actividad..", 16);
        iuObjetivo.setTextoEditable(false);        
        iuObjetivo.setBorder(null);
        iuEtiquetaMoneda = new IUEtiqueta(panelUno, "MONEDA:", new Area(a.X(), a.Y(2) + a.AlP(25), a.AnP(30), a.AlP(5)), 16, "CENTER", true);
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add(Ayuda.getDatoCadena("descri", "select * from tabvar where tipo = 17 and numero = 1"));
        opciones.add(Ayuda.getDatoCadena("descri", "select * from tabvar where tipo = 17 and numero = 2"));
        iuMoneda = new IUComboBox(panelUno, opciones, new Area(a.X(2) + a.AnP(30), a.Y(2) + a.AlP(25), a.AnP(10), a.AlP(5)), 16, 10);                
        
        nroComprobante = new IUPanelEtiqueta(panelUno, new Area(a.X(), a.Y(3) + a.AlP(35), a.AnP(15), a.AlP(5)), "Nro Comp.", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuNroComprobante = new IUCampoTexto(panelUno, 20, 16, new Area(a.X(2) + a.AnP(15), a.Y(3) + a.AlP(35), a.AnP(10), a.AlP(5)), SwingConstants.CENTER);
        iuNroComprobante.setEditar(false);
        
        cantComprobante = new IUPanelEtiqueta(panelUno, new Area(a.X(), a.Y(4) + a.AlP(40), a.AnP(15), a.AlP(5)), "Cant Comp.", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuCantComprobante = new IUCampoTexto(panelUno, 10, 16, new Area(a.X(2) + a.AnP(15), a.Y(4) + a.AlP(40), a.AnP(10), a.AlP(5)), SwingConstants.CENTER);
        iuCantComprobante.setEditar(false);
        
        debe = new IUPanelEtiqueta(panelUno, new Area(a.X(3) + a.AnP(25), a.Y(3) + a.AlP(35), a.AnP(15), a.AlP(5)), "DEBE", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuDebe = new IUCampoTexto(panelUno, 20, 16, new Area(a.X(3) + a.AnP(25), a.Y(4) + a.AlP(40), a.AnP(15), a.AlP(5)), SwingConstants.CENTER);
        iuDebe.setEditar(false);
        
        haber = new IUPanelEtiqueta(panelUno, new Area(a.X(4) + a.AnP(40), a.Y(3) + a.AlP(35), a.AnP(15), a.AlP(5)), "DEBE", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuHaber = new IUCampoTexto(panelUno, 20, 16, new Area(a.X(4) + a.AnP(40), a.Y(4) + a.AlP(40), a.AnP(15), a.AlP(5)), SwingConstants.CENTER);
        iuHaber.setEditar(false);
        
        iuDocumentosDescuadrados = new IUEtiqueta(panelUno, "DOCUMENTOS DESCUADRADOS", new Area(a.X() + a.AnP(58), a.Y(2) + a.AlP(25), a.AnP(43), a.AlP(5)), 20, "CENTER", true);
        
        iuTablaDescuadrados = new IUTabla(panelUno, new Area(a.X() + a.AnP(58), a.Y(3) + a.AlP(30), a.AnP(43), a.AlP(25)),
        new String[]{"NRO.", "DEBITOS", "ABONOS"}, 
        new Class[]{String.class, String.class, String.class}, 
        new int[]{20, 40, 40}, 
        new ArrayList<Descuadre>(), new ModeloTabla<Descuadre>(){
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return lista.get(rowIndex).getNroComprobante();
                    case 1:                
                        return lista.get(rowIndex).getDebito();
                    case 2:
                        return lista.get(rowIndex).getAbono();
                    default:
                        return null;
                }
            }
        });
    }    
    private void construirPanelDos(Area a){
        descuadreNroComprobante = new IUPanelEtiqueta(panelUno, new Area(a.X() + a.AnP(58), a.Y(3) + a.AlP(35), a.AnP(13), a.AlP(5)), "Nro Comp.", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        descuadreNroComprobante.setVisible(false);
        iuDescuadreNroComprobante = new IUCampoTexto(panelUno, 10, 16, new Area(a.X() + a.AnP(58), a.Y(4) + a.AlP(40), a.AnP(13), a.AlP(5)), SwingConstants.CENTER);
        iuDescuadreNroComprobante.setEditar(false);
        iuDescuadreNroComprobante.setVisible(false);
        
        debitos = new IUPanelEtiqueta(panelUno, new Area(a.X(2) + a.AnP(71), a.Y(3) + a.AlP(35), a.AnP(15), a.AlP(5)), "DEBITOS", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        debitos.setVisible(false);
        iuDebitos = new IUCampoTexto(panelUno, 20, 16, new Area(a.X(2) + a.AnP(71), a.Y(4) + a.AlP(40), a.AnP(15), a.AlP(5)), SwingConstants.CENTER);
        iuDebitos.setEditar(false);
        iuDebitos.setVisible(false);
        
        abonos = new IUPanelEtiqueta(panelUno, new Area(a.X(3) + a.AnP(86), a.Y(3) + a.AlP(35), a.AnP(15), a.AlP(5)), "ABONOS", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        abonos.setVisible(false);
        iuAbonos = new IUCampoTexto(panelUno, 20, 16, new Area(a.X(3) + a.AnP(86), a.Y(4) + a.AlP(40), a.AnP(15), a.AlP(5)), SwingConstants.CENTER);
        iuAbonos.setEditar(false);
        iuAbonos.setVisible(false);
        
        leidos = new IUPanelEtiqueta(panelDos, new Area(a.X(), a.Y(), a.AnP(10), a.AlP(14)), "Leidos: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuLeidos = new IUCampoTexto(panelDos, 20, 16, new Area(a.X(2) + a.AnP(10), a.Y(), a.AnP(15), a.AlP(14)), SwingConstants.CENTER);
        iuLeidos.setEditar(false);
        
        nroDocumento = new IUPanelEtiqueta(panelDos, new Area(a.X(3) + a.AnP(25), a.Y(), a.AnP(20), a.AlP(14)), "Nro Documento: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);        
        iuNroDocumento1 = new IUCampoTexto(panelDos, 20, 16, new Area(a.X(4) + a.AnP(45), a.Y(), a.AnP(10), a.AlP(14)), SwingConstants.CENTER);
        iuNroDocumento1.setEditar(false);
        
        iuTablaErrores = new IUTabla(panelDos, new Area(a.X() + a.AnP(58), a.Y(), a.AnP(43), a.AlP(80)),
        new String[]{"CODIGO", "ERROR EN CONMAE"}, 
        new Class[]{String.class, String.class}, 
        new int[]{30, 70}, 
        new ArrayList<Errores>(), new ModeloTabla<Errores>(){
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return lista.get(rowIndex).getCuetot();
                    case 1:                
                        return lista.get(rowIndex).getError();
                    default:
                        return null;
                }
            }
        });
        iuTablaErrores.deslizador.setVisible(false);
        
        hacia = new IUPanelEtiqueta(panelUno, new Area(a.X(5) + a.AnP(55), a.Y(4) + a.AlP(60), a.AnP(5), a.AlP(5)), "a: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        hacia.setVisible(false);
        iuNroDocuemnto2 = new IUCampoTexto(panelUno, 20, 16, new Area(a.X(6) + a.AnP(60), a.Y(4) + a.AlP(60), a.AnP(10), a.AlP(5)), SwingConstants.CENTER);
        iuNroDocuemnto2.setEditar(false);
        iuNroDocuemnto2.setVisible(false);
        
        codigoCuenta = new IUPanelEtiqueta(panelUno, new Area(a.X(7) + a.AnP(70), a.Y(4) + a.AlP(60), a.AnP(15), a.AlP(5)), "Codigo Cta.: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        codigoCuenta.setVisible(false);
        iuCodigoCuenta = new IUCampoTexto(panelUno, 20, 16, new Area(a.X(8) + a.AnP(85), a.Y(4) + a.AlP(60), a.AnP(15), a.AlP(5)), SwingConstants.CENTER);
        iuCodigoCuenta.setEditar(false);
        iuCodigoCuenta.setVisible(false);
    }
    private void construirSegundoPanel(Area a){
        iuTituloMensaje = new IUEtiqueta(segundoPanel, "Mensajes - Instrucciones", new Area(a.X(), a.Y(), a.AnP(97), a.AlP(20)), 16, "CENTER", false);
        iuTituloMensaje.setSubrayarTexto(true);
        iuMensaje = new IUPanelEtiqueta(segundoPanel, new Area(a.X(), a.Y(2) + a.AlP(20), a.AnP(97), a.AlP(40)), "", 20, SwingConstants.LEFT, Color.BLACK, true);
        iuMensaje.setColores(Color.WHITE, new Color(41, 66, 99));
        iuInformacion = new IUPanelEtiqueta(segundoPanel, new Area(a.X(), a.Y(3) + a.AlP(60), a.AnP(97), a.AlP(40)), "", 20, SwingConstants.LEFT, Ayuda.COLOR_FONDO, true);       
        iuInformacion.setColores(Color.BLACK, new Color(255, 210, 0));        
        //iuInformacion.setFuente(new Font("LMicrosoft Sans Serif", Font.PLAIN, 16));
        
        campoS_N1 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N1.setVisible(false);
        campoS_N1.setBorder(new LineBorder(Color.BLACK, 3));
        campoS_N1.setBackground(new Color(255, 210, 0));        
        campoS_N1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoS_N1.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoS_N1.setText("N");
                }
            }
        });
        campoS_N1.setForeground(Color.BLACK);
        
        campoS_N2 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N2.setVisible(false);
        campoS_N2.setBorder(new LineBorder(Color.BLACK, 3));
        campoS_N2.setBackground(new Color(255, 210, 0));
        campoS_N2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoS_N2.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoS_N2.setText("N");
                }
            }
        });
        campoS_N2.setForeground(Color.BLACK);
        
        campoS_N3 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N3.setVisible(false);
        campoS_N3.setBorder(new LineBorder(Color.BLACK, 3));
        campoS_N3.setBackground(new Color(255, 210, 0));
        campoS_N3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoS_N3.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoS_N3.setText("N");
                }
            }
        });
        campoS_N3.setForeground(Color.BLACK);
    }
    private void algoritmosInicial(){                
        focoCampoMoneda();
    }
    private void focoCampoMoneda(){
        deshabilitarCampoS_N();
        iuMensaje.setTexto("Seleccione el TIPO DE MONEDA para realizar la verificacion de asientos.   Bs. = BOLIVIANOS | $us. = DOLARES");
        iuInformacion.setTexto("");
        iuMoneda.setEditar(true);
        iuMoneda.requestFocus();
        iuMoneda.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    moneda = iuMoneda.getSelectedItem().toString();
                    focoCampoS_N1();
                }
            }
        });
        limpiarCampos();
    }
    private void limpiarCampos(){
        iuMoneda.setBackground(null);
        iuNroComprobante.setBackground(null);
        iuCantComprobante.setBackground(null);
        iuDebe.setBackground(null);
        iuHaber.setBackground(null);
        iuLeidos.setBackground(null);
        iuDescuadreNroComprobante.setBackground(null);
        iuDebitos.setBackground(null);
        iuAbonos.setBackground(null);
        iuNroDocumento1.setBackground(null);
        iuCodigoCuenta.setBackground(null);
        
        iuNroComprobante.setText("");
        iuCantComprobante.setText("");
        iuDebe.setText("");
        iuHaber.setText("");
        iuLeidos.setText("");
        iuDescuadreNroComprobante.setText("");
        iuDebitos.setText("");
        iuAbonos.setText("");
        iuNroDocumento1.setText("");
        iuCodigoCuenta.setText("");
    }
    private void focoCampoS_N1(){
        deshabilitarCampoS_N();
        campoS_N1.setVisible(true);
        campoS_N1.setEditar(true);
        campoS_N1.requestFocus();
        campoS_N1.setText("S");
        iuMensaje.setTexto("COMIENZO CON EL PROCESO DE VERIFICACION DE DOCUMENTOS DESCUADRADOS  ?     S/N");
        iuInformacion.setTexto("");
        campoS_N1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N1.getText()){
                        case "S":
                            verificacionAsientos();                            
                        break;
                        case "N":
                            focoCampoSalir();
                        break;
                    }
                }
            }
        });        
    }
    private boolean existeCuetotTabla(long cuetot){
        boolean existe = false;
        int contador = 0;
        while (contador < iuTablaErrores.modeloTabla.lista.size() && !existe){
            Errores falla = (Errores)iuTablaErrores.modeloTabla.lista.get(contador);
            if(Long.parseLong(falla.getCuetot()) == cuetot){
                existe = true;
            }
            contador++;
        }
        return existe;
    }
    private void verificacionAsientos(){        
        
        JProgressBar progresoBar = new JProgressBar();
        progresoBar.setIndeterminate(true);
        progresoBar.setString("reconstruyendo campos acumulativos....".toUpperCase());
        progresoBar.setStringPainted(true);
        progresoBar.setBorderPainted(true);
        progresoBar.setBounds(0, 0, iuTituloMensaje.getWidth(), iuTituloMensaje.getHeight());        
        progresoBar.setVisible(true);
        iuTituloMensaje.add(progresoBar);
        
        final javax.swing.SwingWorker worker = new javax.swing.SwingWorker() {
            boolean error = false;
            @Override
            protected Object doInBackground() throws Exception {
                
                iuNroComprobante.setText("0");
                iuCantComprobante.setText("0");
                iuDebe.setText("0");
                iuHaber.setText("0");
                iuLeidos.setText("0");
                iuTablaErrores.modeloTabla.limpiarTabla();
                iuTablaErrores.deslizador.setVisible(true);
                iuTablaDescuadrados.modeloTabla.limpiarTabla();
                ArrayList<Contra> listaContras = new ArrayList<>();
                ArrayList<Contra> listaContrasDiferentes = CContra.getListaContra("SELECT * FROM CONTRA GROUP BY NUMCOM");

                String bolivianos = Ayuda.getDatoCadena("descri", "select * from tabvar where tipo = 17 and numero = 1");
                int cantComprobantes = 0;
                int ultimoComprobante = 0;
                double totalDebe = 0;
                double totalHaber = 0;
                int cantComprobantesLeidos = 0;

                if(listaContrasDiferentes.isEmpty()){
                    focoCampoSalir();
                }else{
                    for (int i = 0; i < listaContrasDiferentes.size(); i++) {
                        totalDebe = 0;
                        totalHaber = 0;
                        Contra contraUnico = listaContrasDiferentes.get(i);

                        ultimoComprobante = contraUnico.getNumcom();
                        iuNroComprobante.setText(String.valueOf(ultimoComprobante));

                        cantComprobantes++;
                        iuCantComprobante.setText(String.valueOf(cantComprobantes));

                        listaContras = CContra.getListaContra("SELECT * FROM CONTRA WHERE NUMCOM = "+ultimoComprobante);
                        if(listaContras.isEmpty()){
                            deshabilitarCampoS_N();
                            iuMensaje.setTexto("ERROR: NO EXISTE APROPIACIONES EN ESTE ASIENTO.");
                            iuInformacion.setTexto("ESC = SUSPENDER");
                            iuNroDocumento1.setText(String.valueOf(ultimoComprobante));
                            iuNroDocumento1.setBackground(Color.RED);
                            error = true;
                            break;
                        }else{
                            for (int j = 0; j < listaContras.size(); j++) {
                                cantComprobantesLeidos++;
                                Contra contra = listaContras.get(j);
                                //apropiacion = DEBE
                                if(contra.getApropi() == 1){
                                    if(moneda.equalsIgnoreCase(bolivianos)){
                                        totalDebe = Ayuda.acotarNumero(totalDebe + contra.getMonto1(), 2);
                                    }else{
                                        totalDebe = Ayuda.acotarNumero(totalDebe + contra.getMonto2(), 2);
                                    }
                                }else{
                                    //apropiacion = HABER
                                    if(moneda.equalsIgnoreCase(bolivianos)){
                                        totalHaber = Ayuda.acotarNumero(totalHaber + contra.getMonto1(), 2);
                                    }else{
                                        totalHaber = Ayuda.acotarNumero(totalHaber + contra.getMonto2(), 2);
                                    }
                                }
                                iuLeidos.setText(String.valueOf(cantComprobantesLeidos));
                                Conmae conmae = null;
                                try {
                                    conmae = CConmae.getConmae("SELECT * FROM CONMAE WHERE CUETOT = "+contra.getCuetot());
                                    if(conmae == null){
                                        deshabilitarCampoS_N();
                                        iuMensaje.setTexto("ERROR: NO EXISTE CUENTA EN (CONMAE).");
                                        iuInformacion.setTexto("ESC = SUSPENDER");

                                        if(!existeCuetotTabla(contra.getCuetot())){
                                            Errores falla = new Errores();
                                            falla.setCuetot(String.valueOf(contra.getCuetot()));
                                            falla.setError("NO EXISTE CUENTA (CONMAE)!!");
                                            iuTablaErrores.modeloTabla.setFila(falla);
                                        }
                                        iuCodigoCuenta.setText(String.valueOf(contra.getCuetot()));
                                        iuCodigoCuenta.setBackground(Color.RED);
                                        error = true;                                
                                    }else{
                                        if(conmae.getActivi() == 1){
                                            deshabilitarCampoS_N();
                                            iuMensaje.setTexto("ERROR: LA CUENTA NO TIENE MOVIMIENTO.");
                                            iuInformacion.setTexto("ESC = SUSPENDER");
                                            iuCodigoCuenta.setText(String.valueOf(contra.getCuetot()));

                                            if(!existeCuetotTabla(contra.getCuetot())){
                                                Errores falla = new Errores();
                                                falla.setCuetot(String.valueOf(contra.getCuetot()));
                                                falla.setError("CUENTA SIN MOVIMIENTO!!!");
                                                iuTablaErrores.modeloTabla.setFila(falla);
                                            }

                                            iuCodigoCuenta.setBackground(Color.RED);
                                            error = true;                                    
                                        }else{
                                            if(conmae.getNivel() != contra.getIndica()){
                                                deshabilitarCampoS_N();
                                                iuMensaje.setTexto("ERROR: NIVELES INCONSISTENTES.");
                                                iuInformacion.setTexto("ESC = SUSPENDER");
                                                iuCodigoCuenta.setText(String.valueOf(contra.getCuetot()));

                                                if(!existeCuetotTabla(contra.getCuetot())){
                                                    Errores falla = new Errores();
                                                    falla.setCuetot(String.valueOf(contra.getCuetot()));
                                                    falla.setError("NIVELES INCONSISTENTES!!");
                                                    iuTablaErrores.modeloTabla.setFila(falla);
                                                }                                        

                                                iuCodigoCuenta.setBackground(Color.RED);
                                                error = true;                                        
                                            }
                                        }
                                    }                        

                                } catch (Exception e) {}

                            }
                        }                                
                        if(totalDebe != totalHaber){                    
                            deshabilitarCampoS_N();
                            iuMensaje.setTexto("ATENCION: DOCUMENTO DESCUADRADO. Es apropiado hacer un ASIENTO DE AJUSTE, para controlar el DESCUADRE.");
                            iuInformacion.setTexto("ESC = SUSPENDER");

                            iuDescuadreNroComprobante.setText(String.valueOf(ultimoComprobante));
                            iuDebitos.setTextoD(String.valueOf(totalDebe));
                            iuAbonos.setTextoD(String.valueOf(totalHaber));                    

                            iuDescuadreNroComprobante.setBackground(Color.RED);
                            iuDebitos.setBackground(Color.RED);
                            iuAbonos.setBackground(Color.RED);

                            Descuadre des = new Descuadre();
                            des.setNroComprobante(String.valueOf(ultimoComprobante));
                            des.setDebito(String.valueOf(totalDebe));
                            des.setAbono(String.valueOf(totalHaber));

                            iuTablaDescuadrados.modeloTabla.setFila(des);

                            error = true;
                        }else{
                            totalDebe = totalDebe + Double.parseDouble(iuDebe.getText());
                            totalHaber = totalHaber + Double.parseDouble(iuHaber.getText());
                        }
                        iuDebe.setTextoD(String.valueOf(totalDebe));
                        iuHaber.setTextoD(String.valueOf(totalHaber));                                
                    }
                }
                return null;
            }
            @Override
            protected void done() {
                progresoBar.setVisible(false);
                if(!error){
                    iuMoneda.setBackground(Color.GREEN);
                    iuNroComprobante.setBackground(Color.GREEN);
                    iuCantComprobante.setBackground(Color.GREEN);
                    iuDebe.setBackground(Color.GREEN);
                    iuHaber.setBackground(Color.GREEN);
                    iuLeidos.setBackground(Color.GREEN);
                    focoCampoSalir();
                }        
                if(iuTablaErrores.modeloTabla.isVacia())
                    iuTablaErrores.deslizador.setVisible(false);                
                }
        };

        worker.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                progresoBar.setValue(worker.getProgress());//actualizamos el valor del progressBar
            }
        });

        worker.execute();
    }
    private void deshabilitarCampoS_N(){
        campoS_N1.setVisible(false);
        campoS_N1.setEditar(false);
        campoS_N2.setVisible(false);
        campoS_N2.setEditar(false);
        campoS_N3.setVisible(false);
        campoS_N3.setEditar(false);
    }
    private void focoCampoSalir(){
        deshabilitarCampoS_N();
        campoS_N2.setVisible(true);
        campoS_N2.setEditar(true);
        campoS_N2.requestFocus();
        campoS_N2.setText("S");
        iuMensaje.setTexto("DESEA SALIR DE LA VERIFICACION DE DOCUMENTOS DESCUADRADOS. ?     S/N");
        iuInformacion.setTexto("ATENCION: ESC = Suspender.");
        campoS_N2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N2.getText()){
                        case "S":
                            dispose();
                        break;
                        case "N":
                            focoCampoMoneda();
                        break;
                    }
                }
            }
        });
    }
}

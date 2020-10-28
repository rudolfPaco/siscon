/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.asientoSimple;

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
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author neo
 */
public class VAsientoSimple extends IUSecundario{
    
    private VPrincipal ventanaPrincipal;
    
    private String titulo;
    
    private IUPanel panel;
        private IUPanel panelTitulo;
        private IUEtiqueta iuTitulo;
    
    private IUPanel panelDatos;
        private IUPanel primerPanel;
            private IUPanel panelDocumento;
            
            private IUPanel panelComprobante;
                private IUPanel primerPanelC;
                    private IUPanelEtiqueta iuEtiquetaTipCom;
                    private IUCampoTexto iuTipCom;
                    private IUPanelEtiqueta iuEtiquetaCom;
                    private IUCampoTexto iuCom;
                    private IUPanelEtiqueta iuEtiquetaNum;
                    private IUCampoTexto iuNum;
                    private IUPanelEtiqueta iuEtiquetaFecha;
                    private IUPanelEtiqueta iuFecha;
                private IUPanel segundoPanelC;
                    private IUPanelEtiqueta iuEtiquetaDocRef;
                    private IUCampoTexto iuDocRef;
                    private IUPanelEtiqueta iuEtiquetaConcepto;
                    private IUCampoTexto iuConcepto;
                    private IUPanelEtiqueta iuEtiquetaTipCam;
                    private IUCampoTexto iuTipCam;
                    private IUPanelEtiqueta iuUnidad;
                private IUPanel tercerPanelC;
                
                    private IUEtiqueta iuTituloC;
                    private IUPanelEtiqueta iuEtiquetaNro;
                    private IUPanelEtiqueta iuEtiquetaCodigo;
                    private IUPanelEtiqueta iuEtiquetaCuenta;
                    private IUPanelEtiqueta iuEtiquetaDebe;
                    private IUPanelEtiqueta iuEtiquetaHaber;
                    private IUPanelEtiqueta iuEtiquetaMonto;
                    
                    private IUCampoTexto iuNro1;
                    private IUCampoTexto iuCodigo1;
                    private IUCampoTexto iuCuenta1;
                    private IUCampoTexto iuDebe1;
                    private IUCampoTexto iuHaber1;
                    private IUCampoTexto iuMonto1;
                    
                    private IUCampoTexto iuNro2;
                    private IUCampoTexto iuCodigo2;
                    private IUCampoTexto iuCuenta2;
                    private IUCampoTexto iuDebe2;
                    private IUCampoTexto iuHaber2;
                    private IUCampoTexto iuMonto2;
                    
                    private IUCampoTexto iuNro3;
                    private IUCampoTexto iuCodigo3;
                    private IUCampoTexto iuCuenta3;
                    private IUCampoTexto iuDebe3;
                    private IUCampoTexto iuHaber3;
                    private IUCampoTexto iuMonto3;
                    
                    private IUCampoTexto iuNro4;
                    private IUCampoTexto iuCodigo4;
                    private IUCampoTexto iuCuenta4;
                    private IUCampoTexto iuDebe4;
                    private IUCampoTexto iuHaber4;
                    private IUCampoTexto iuMonto4;
                    
                    private IUCampoTexto iuNro5;
                    private IUCampoTexto iuCodigo5;
                    private IUCampoTexto iuCuenta5;
                    private IUCampoTexto iuDebe5;
                    private IUCampoTexto iuHaber5;
                    private IUCampoTexto iuMonto5;
                    
                    private IUCampoTexto iuNro6;
                    private IUCampoTexto iuCodigo6;
                    private IUCampoTexto iuCuenta6;
                    private IUCampoTexto iuDebe6;
                    private IUCampoTexto iuHaber6;
                    private IUCampoTexto iuMonto6;
                    
                    private IUCampoTexto iuNro7;
                    private IUCampoTexto iuCodigo7;
                    private IUCampoTexto iuCuenta7;
                    private IUCampoTexto iuDebe7;
                    private IUCampoTexto iuHaber7;
                    private IUCampoTexto iuMonto7;
                    
                    private IUCampoTexto iuNro8;
                    private IUCampoTexto iuCodigo8;
                    private IUCampoTexto iuCuenta8;
                    private IUCampoTexto iuDebe8;
                    private IUCampoTexto iuHaber8;
                    private IUCampoTexto iuMonto8;
                    
                    private IUCampoTexto iuNro9;
                    private IUCampoTexto iuCodigo9;
                    private IUCampoTexto iuCuenta9;
                    private IUCampoTexto iuDebe9;
                    private IUCampoTexto iuHaber9;
                    private IUCampoTexto iuMonto9;
                    
                    private IUCampoTexto iuNro10;
                    private IUCampoTexto iuCodigo10;
                    private IUCampoTexto iuCuenta10;
                    private IUCampoTexto iuDebe10;
                    private IUCampoTexto iuHaber10;
                    private IUCampoTexto iuMonto10;
                    
                    private IUEtiqueta iuEtiquetaTotalC;
                    private IUCampoTexto iuTotalDebe;
                    private IUCampoTexto iuTotalHaber;
                    private IUCampoTexto iuTotalMonto;
                    
                private IUPanel cuartoPanelC;
                
        
        private IUPanel segundoPanel;
            private IUEtiqueta iuTituloMensaje;
            private IUPanelEtiqueta iuMensaje;
            private IUPanelEtiqueta iuInformacion;        
            private IUCampoTexto campoS_N1;
            private IUCampoTexto campoS_N2;
            private IUCampoTexto campoS_N3;
            private IUCampoTexto campoS_N4;
            private IUCampoTexto campoS_N5;
            private IUCampoTexto campoS_N6;
            private IUCampoTexto campoS_N7;
    
    private final Usuario usuario;
    private Tabvar tabvar;
    
    public VAsientoSimple(VPrincipal ventanaPrincipal, String titulo, String tipoSize, Usuario usuario, Tabvar tabvar) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        this.titulo = titulo;
        this.usuario = usuario;
        this.tabvar = tabvar;
        
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
        panelTitulo = new IUPanel(panel, new Area(a.X(), a.Y(), a.An(), a.AlP(7)), true, Ayuda.COLOR_FONDO);
        construirPanelTitulo(new Area(panelTitulo.area.AnP(2), 2, panelTitulo.area.An() - panelTitulo.area.AnP(2)*4, panelTitulo.area.Al() - 4));
        
        panelDatos = new IUPanel(panel, new Area(a.X(), a.Y(2) + a.AlP(7), a.An(), a.AlP(93)), false, Ayuda.COLOR_FONDO);
        construirPanelDatos(new Area(2, 2, panelDatos.area.An() - 4, panelDatos.area.Al() - 6));
    }
    
    private void construirPanelTitulo(Area a){
        iuTitulo = new IUEtiqueta(panelTitulo, usuario.getRazsoc(), new Area(a.X(), a.Y(), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "ASIENTO CONTABLE", new Area(a.X(2) + a.AnP(25), a.Y(2) + a.AlP(45), a.AnP(35), a.AlP(50)), 16, "CENTER", false);        
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "SISTEMA CONTABLE SISCON @v7.2. 2020", new Area(a.X(3) + a.AnP(60), a.Y(), a.AnP(40), a.AlP(50)), 16, "RIGHT", false); 
        
        iuTitulo = new IUEtiqueta(panelTitulo, "EJECUTIVO: "+tabvar.getDescri(), new Area(a.X(), a.Y(2) + a.AlP(45), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
        //iuTitulo = new IUEtiqueta(panelTitulo, "EMISION: "+new Fecha().getFecha1(), new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(45), a.AnP(40), a.AlP(50)), 16, "RIGHT", false);
    }
    private void construirPanelDatos(Area a){
        primerPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(), a.An(), a.AlP(85)), false);
        construirPrimerPanel(new Area(2, 2, primerPanel.area.An() - 4, primerPanel.area.Al() - 4));
        
        segundoPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(2) + a.AlP(85), a.An(), a.AlP(15)), false);
        construirSegundoPanel(new Area(2, 2, segundoPanel.area.An() - 6, segundoPanel.area.Al() - 8));
    }
    private void construirPrimerPanel(Area a){
        panelDocumento = new IUPanel(primerPanel, new Area(a.X(), a.Y(), a.An(), a.Al()), true, Color.orange);
        panelDocumento.setVisible(false);
        
        panelComprobante = new IUPanel(primerPanel, new Area(a.X(), a.Y(), a.An(), a.Al()), false);
        panelComprobante.setVisible(false);
        construirPanelComprobante(new Area(2, 2, panelComprobante.area.An() - 4, panelComprobante.area.Al() - 10));
    }
    private void construirSegundoPanel(Area a){
        iuTituloMensaje = new IUEtiqueta(segundoPanel, "Mensajes - Instrucciones", new Area(a.X(), a.Y(), a.AnP(97), a.AlP(20)), 16, "CENTER", false);
        iuTituloMensaje.setSubrayarTexto(true);
        iuMensaje = new IUPanelEtiqueta(segundoPanel, new Area(a.X(), a.Y(2) + a.AlP(20), a.AnP(97), a.AlP(40)), "", 16, SwingConstants.LEFT, Ayuda.COLOR_ATENCION, true);
        iuInformacion = new IUPanelEtiqueta(segundoPanel, new Area(a.X(), a.Y(3) + a.AlP(60), a.AnP(97), a.AlP(40)), "", 16, SwingConstants.LEFT, Ayuda.COLOR_FONDO, true);       
        campoS_N1 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N1.setVisible(false);
        campoS_N1.setBorder(new LineBorder(Color.GREEN, 3));
        campoS_N1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_C == e.getKeyCode()){
                    campoS_N1.setText("C");
                }
                if(KeyEvent.VK_D == e.getKeyCode()){
                    campoS_N1.setText("D");
                }
            }
        });
        campoS_N2 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N2.setVisible(false);
        campoS_N2.setBorder(new LineBorder(Color.GREEN, 3));
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
        campoS_N3 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N3.setVisible(false);
        campoS_N3.setBorder(new LineBorder(Color.GREEN, 3));
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
        campoS_N4 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N4.setVisible(false);
        campoS_N4.setBorder(new LineBorder(Color.GREEN, 3));
        campoS_N4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoS_N4.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoS_N4.setText("N");
                }
            }
        });
        campoS_N5 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N5.setVisible(false);
        campoS_N5.setBorder(new LineBorder(Color.GREEN, 3));
        campoS_N5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoS_N5.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoS_N5.setText("N");
                }
            }
        });
        campoS_N6 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N6.setVisible(false);
        campoS_N6.setBorder(new LineBorder(Color.GREEN, 3));
        campoS_N6.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoS_N6.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoS_N6.setText("N");
                }
            }
        });
        campoS_N7 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N7.setVisible(false);
        campoS_N7.setBorder(new LineBorder(Color.GREEN, 3));
        campoS_N7.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoS_N7.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoS_N7.setText("N");
                }
            }
        });        
    }
    private void construirPanelComprobante(Area a){
        primerPanelC = new IUPanel(panelComprobante, new Area(a.X(), a.Y(), a.An(), a.AlP(5)), false);
        construirPrimerPanelC(new Area(2, 2, primerPanelC.area.An() - 18, primerPanelC.area.Al() - 4));
        
        segundoPanelC = new IUPanel(panelComprobante, new Area(a.X(), a.Y(2) + a.AlP(5), a.An(), a.AlP(10)), false);
        construirSegundoPanelC(new Area(2, 2, segundoPanelC.area.An() - 12, segundoPanelC.area.Al() - 6));
        
        tercerPanelC = new IUPanel(panelComprobante, new Area(a.X(), a.Y(3) + a.AlP(15), a.An(), a.AlP(77)), true);
        construirTercerPanelC(new Area(tercerPanelC.area.AnP(1), 2, tercerPanelC.area.An() - tercerPanelC.area.AnP(1)*7, tercerPanelC.area.Al() - 26));
        
        //cuartoPanelC = new IUPanel(panelComprobante, new Area(a.X(), a.Y(4) + a.AlP(92), a.An(), a.AlP(8)), true, Color.WHITE);
    }
    private void construirPrimerPanelC(Area a){
        iuEtiquetaTipCom = new IUPanelEtiqueta(primerPanelC, new Area(a.X(), a.Y(), a.AnP(13), a.Al()), "Tipo Comprobante: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuTipCom = new IUCampoTexto(primerPanelC, 1, 16, new Area(a.X(2) + a.AnP(13), a.Y(), a.AnP(3), a.Al()), SwingConstants.CENTER);
        
        iuEtiquetaCom = new IUPanelEtiqueta(primerPanelC, new Area(a.X(3) + a.AnP(16), a.Y(), a.AnP(13), a.Al()), "COMPROBANTE de: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuCom = new IUCampoTexto(primerPanelC, 20, 16, new Area(a.X(4) + a.AnP(29), a.Y(), a.AnP(9), a.Al()), SwingConstants.CENTER);
        
        iuEtiquetaNum = new IUPanelEtiqueta(primerPanelC, new Area(a.X(5) + a.AnP(38), a.Y(), a.AnP(5), a.Al()), "No.: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuNum = new IUCampoTexto(primerPanelC, 8, 16, new Area(a.X(6) + a.AnP(42), a.Y(), a.AnP(8), a.Al()), SwingConstants.CENTER);
        
        iuEtiquetaFecha = new IUPanelEtiqueta(primerPanelC, new Area(a.X(7) + a.AnP(50), a.Y(), a.AnP(12), a.Al()), "Fecha Emision: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuFecha = new IUPanelEtiqueta(primerPanelC, new Area(a.X(8) + a.AnP(62), a.Y(), a.AnP(25), a.Al()), new Fecha().getFecha1(), 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
    }
    private void construirSegundoPanelC(Area a){
        iuEtiquetaDocRef = new IUPanelEtiqueta(segundoPanelC, new Area(a.X(), a.Y(), a.AnP(10), a.AlP(50)), "Doc. Ref.: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuDocRef = new IUCampoTexto(segundoPanelC, 10, 16, new Area(a.X(2) + a.AnP(10), a.Y(), a.AnP(15), a.AlP(50)), SwingConstants.CENTER);
        
        iuEtiquetaConcepto = new IUPanelEtiqueta(segundoPanelC, new Area(a.X(), a.Y(2) + a.AlP(50), a.AnP(10), a.AlP(50)), "Concepto: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuConcepto = new IUCampoTexto(segundoPanelC, 100, 16, new Area(a.X(2) + a.AnP(10), a.Y(2) + a.AlP(50), a.AnP(65), a.AlP(50)), SwingConstants.CENTER);
        
        iuEtiquetaTipCam = new IUPanelEtiqueta(segundoPanelC, new Area(a.X(3) + a.AnP(75), a.Y(2) + a.AlP(50), a.AnP(7), a.AlP(50)), "T/C: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuTipCam = new IUCampoTexto(segundoPanelC, 50, 16, new Area(a.X(4) + a.AnP(82), a.Y(2) + a.AlP(50), a.AnP(8), a.AlP(50)), SwingConstants.CENTER);
        iuUnidad = new IUPanelEtiqueta(segundoPanelC, new Area(a.X(5) + a.AnP(90), a.Y(2) + a.AlP(50), a.AnP(10), a.AlP(50)), "Bs.-/$us.-", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
    }
    private void construirTercerPanelC(Area a){
        
        iuTituloC = new IUEtiqueta(tercerPanelC, "TABLA - ASIENTO DE CUENTA", new Area(a.X(), a.Y() + a.AlP(4), a.An(), a.AlP(6)), 20, "CENTER", Ayuda.COLOR_ROJO);
        
        iuEtiquetaNro = new IUPanelEtiqueta(tercerPanelC, new Area(a.X(), a.Y(3) + a.AlP(10), a.AnP(5), a.AlP(7)), "Nro.", 18, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuEtiquetaCodigo = new IUPanelEtiqueta(tercerPanelC, new Area(a.X(2) + a.AnP(5), a.Y(3) + a.AlP(10), a.AnP(15), a.AlP(7)), "CODIGO", 18, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuEtiquetaNro = new IUPanelEtiqueta(tercerPanelC, new Area(a.X(3) + a.AnP(20), a.Y(3) + a.AlP(10), a.AnP(50), a.AlP(7)), "DESCRIPCION DE CUENTA", 18, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuEtiquetaNro = new IUPanelEtiqueta(tercerPanelC, new Area(a.X(4) + a.AnP(70), a.Y(3) + a.AlP(10), a.AnP(10), a.AlP(7)), "DEBE", 18, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuEtiquetaNro = new IUPanelEtiqueta(tercerPanelC, new Area(a.X(5) + a.AnP(80), a.Y(3) + a.AlP(10), a.AnP(10), a.AlP(7)), "HABER", 18, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuEtiquetaNro = new IUPanelEtiqueta(tercerPanelC, new Area(a.X(6) + a.AnP(90), a.Y(3) + a.AlP(10), a.AnP(10), a.AlP(7)), "MONTO $us", 18, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        
        iuNro1 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(), a.Y(4) + a.AlP(17), a.AnP(5), a.AlP(7)), SwingConstants.CENTER);
        iuCodigo1 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(2) + a.AnP(5), a.Y(4) + a.AlP(17), a.AnP(15), a.AlP(7)), SwingConstants.CENTER);
        iuCuenta1 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(3) + a.AnP(20), a.Y(4) + a.AlP(17), a.AnP(50), a.AlP(7)), SwingConstants.CENTER);
        iuDebe1 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(4) + a.AnP(70), a.Y(4) + a.AlP(17), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        iuHaber1 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(5) + a.AnP(80), a.Y(4) + a.AlP(17), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        iuMonto1 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(6) + a.AnP(90), a.Y(4) + a.AlP(17), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        
        iuNro2 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(), a.Y(5) + a.AlP(24), a.AnP(5), a.AlP(7)), SwingConstants.CENTER);
        iuCodigo2 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(2) + a.AnP(5), a.Y(5) + a.AlP(24), a.AnP(15), a.AlP(7)), SwingConstants.CENTER);
        iuCuenta2 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(3) + a.AnP(20), a.Y(5) + a.AlP(24), a.AnP(50), a.AlP(7)), SwingConstants.CENTER);
        iuDebe2 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(4) + a.AnP(70), a.Y(5) + a.AlP(24), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        iuHaber2 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(5) + a.AnP(80), a.Y(5) + a.AlP(24), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        iuMonto2 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(6) + a.AnP(90), a.Y(5) + a.AlP(24), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        
        iuNro3 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(), a.Y(6) + a.AlP(31), a.AnP(5), a.AlP(7)), SwingConstants.CENTER);
        iuCodigo3 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(2) + a.AnP(5), a.Y(6) + a.AlP(31), a.AnP(15), a.AlP(7)), SwingConstants.CENTER);
        iuCuenta3 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(3) + a.AnP(20), a.Y(6) + a.AlP(31), a.AnP(50), a.AlP(7)), SwingConstants.CENTER);
        iuDebe3 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(4) + a.AnP(70), a.Y(6) + a.AlP(31), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        iuHaber3 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(5) + a.AnP(80), a.Y(6) + a.AlP(31), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        iuMonto3 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(6) + a.AnP(90), a.Y(6) + a.AlP(31), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        
        iuNro4 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(), a.Y(7) + a.AlP(38), a.AnP(5), a.AlP(7)), SwingConstants.CENTER);
        iuCodigo4 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(2) + a.AnP(5), a.Y(7) + a.AlP(38), a.AnP(15), a.AlP(7)), SwingConstants.CENTER);
        iuCuenta4 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(3) + a.AnP(20), a.Y(7) + a.AlP(38), a.AnP(50), a.AlP(7)), SwingConstants.CENTER);
        iuDebe4 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(4) + a.AnP(70), a.Y(7) + a.AlP(38), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        iuHaber4 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(5) + a.AnP(80), a.Y(7) + a.AlP(38), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        iuMonto4 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(6) + a.AnP(90), a.Y(7) + a.AlP(38), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        
        iuNro5 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(), a.Y(8) + a.AlP(45), a.AnP(5), a.AlP(7)), SwingConstants.CENTER);
        iuCodigo5 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(2) + a.AnP(5), a.Y(8) + a.AlP(45), a.AnP(15), a.AlP(7)), SwingConstants.CENTER);
        iuCuenta5 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(3) + a.AnP(20), a.Y(8) + a.AlP(45), a.AnP(50), a.AlP(7)), SwingConstants.CENTER);
        iuDebe5 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(4) + a.AnP(70), a.Y(8) + a.AlP(45), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        iuHaber5 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(5) + a.AnP(80), a.Y(8) + a.AlP(45), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        iuMonto5 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(6) + a.AnP(90), a.Y(8) + a.AlP(45), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        
        iuNro6 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(), a.Y(9) + a.AlP(52), a.AnP(5), a.AlP(7)), SwingConstants.CENTER);
        iuCodigo6 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(2) + a.AnP(5), a.Y(9) + a.AlP(52), a.AnP(15), a.AlP(7)), SwingConstants.CENTER);
        iuCuenta6 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(3) + a.AnP(20), a.Y(9) + a.AlP(52), a.AnP(50), a.AlP(7)), SwingConstants.CENTER);
        iuDebe6 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(4) + a.AnP(70), a.Y(9) + a.AlP(52), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        iuHaber6 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(5) + a.AnP(80), a.Y(9) + a.AlP(52), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        iuMonto6 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(6) + a.AnP(90), a.Y(9) + a.AlP(52), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        
        iuNro7 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(), a.Y(10) + a.AlP(59), a.AnP(5), a.AlP(7)), SwingConstants.CENTER);
        iuCodigo7 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(2) + a.AnP(5), a.Y(10) + a.AlP(59), a.AnP(15), a.AlP(7)), SwingConstants.CENTER);
        iuCuenta7 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(3) + a.AnP(20), a.Y(10) + a.AlP(59), a.AnP(50), a.AlP(7)), SwingConstants.CENTER);
        iuDebe7 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(4) + a.AnP(70), a.Y(10) + a.AlP(59), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        iuHaber7 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(5) + a.AnP(80), a.Y(10) + a.AlP(59), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        iuMonto7 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(6) + a.AnP(90), a.Y(10) + a.AlP(59), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        
        iuNro8 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(), a.Y(11) + a.AlP(66), a.AnP(5), a.AlP(7)), SwingConstants.CENTER);
        iuCodigo8 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(2) + a.AnP(5), a.Y(11) + a.AlP(66), a.AnP(15), a.AlP(7)), SwingConstants.CENTER);
        iuCuenta8 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(3) + a.AnP(20), a.Y(11) + a.AlP(66), a.AnP(50), a.AlP(7)), SwingConstants.CENTER);
        iuDebe8 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(4) + a.AnP(70), a.Y(11) + a.AlP(66), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        iuHaber8 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(5) + a.AnP(80), a.Y(11) + a.AlP(66), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        iuMonto8 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(6) + a.AnP(90), a.Y(11) + a.AlP(66), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        
        iuNro9 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(), a.Y(12) + a.AlP(73), a.AnP(5), a.AlP(7)), SwingConstants.CENTER);
        iuCodigo9 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(2) + a.AnP(5), a.Y(12) + a.AlP(73), a.AnP(15), a.AlP(7)), SwingConstants.CENTER);
        iuCuenta9 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(3) + a.AnP(20), a.Y(12) + a.AlP(73), a.AnP(50), a.AlP(7)), SwingConstants.CENTER);
        iuDebe9 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(4) + a.AnP(70), a.Y(12) + a.AlP(73), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        iuHaber9 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(5) + a.AnP(80), a.Y(12) + a.AlP(73), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        iuMonto9 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(6) + a.AnP(90), a.Y(12) + a.AlP(73), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        
        iuNro10 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(), a.Y(13) + a.AlP(80), a.AnP(5), a.AlP(7)), SwingConstants.CENTER);
        iuCodigo10 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(2) + a.AnP(5), a.Y(13) + a.AlP(80), a.AnP(15), a.AlP(7)), SwingConstants.CENTER);
        iuCuenta10 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(3) + a.AnP(20), a.Y(13) + a.AlP(80), a.AnP(50), a.AlP(7)), SwingConstants.CENTER);
        iuDebe10 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(4) + a.AnP(70), a.Y(13) + a.AlP(80), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        iuHaber10 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(5) + a.AnP(80), a.Y(13) + a.AlP(80), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        iuMonto10 = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(6) + a.AnP(90), a.Y(13) + a.AlP(80), a.AnP(10), a.AlP(7)), SwingConstants.CENTER);
        
        iuEtiquetaTotalC = new IUEtiqueta(tercerPanelC, "Total Comprobante (en Bolivianos.)", new Area(a.X(3) + a.AnP(20), a.Y(15) + a.AlP(90), a.AnP(50), a.AlP(7)), 16, "RIGHT", false);
        iuEtiquetaTotalC.setFont(new Font("Verdana", Font.BOLD, 16));
        
        iuTotalDebe = new IUCampoTexto(tercerPanelC, 10, 16, new Area(a.X(4) + a.AnP(70), a.Y(15) + a.AlP(90), a.AnP(10), a.AlP(7)), SwingConstants.RIGHT);
        iuTotalHaber = new IUCampoTexto(tercerPanelC, 10, 16, new Area(a.X(5) + a.AnP(80), a.Y(15) + a.AlP(90), a.AnP(10), a.AlP(7)), SwingConstants.RIGHT);
        iuTotalMonto = new IUCampoTexto(tercerPanelC, 10, 16, new Area(a.X(6) + a.AnP(90), a.Y(15) + a.AlP(90), a.AnP(10), a.AlP(7)), SwingConstants.RIGHT);
    }
    
    private void algoritmoInicial(){
        iuMensaje.setTexto("Desea ELABORAR un (D)ocumento o (C)omprobante.......");
        iuInformacion.setTexto("");
        campoS_N1.setVisible(true);
        campoS_N1.requestFocus();
        campoS_N1.setText("C");
        campoS_N1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    campoS_N1.setEditar(false);
                    campoS_N1.setVisible(false);
                    switch(campoS_N1.getText()){
                        case "C":
                            mostrarPanelComprobante();
                        break;
                        case "D":
                            mostrarPanelDocumento();
                        break;
                    }
                }
            }
        });
    }
    private void mostrarPanelDocumento(){
        panelDocumento.setVisible(true);
        panelComprobante.setVisible(false);
    }
    private void mostrarPanelComprobante(){
        panelDocumento.setVisible(false);
        panelComprobante.setVisible(true);
    }
}

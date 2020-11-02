/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.contra;

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
import com.siscon.controller.CTabvar;
import com.siscon.model.Asiento;
import com.siscon.model.Conmae;
import com.siscon.model.Contra;
import com.siscon.model.Tabvar;
import com.siscon.model.Usuario;
import com.siscon.recursos.Ayuda;
import com.siscon.recursos.Numero_a_Letra;
import com.siscon.view.VPrincipal;
import com.siscon.view.conmae.VConmae;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author neo
 */
public class VContra extends IUSecundario{
    
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
                    private IUPanelEtiqueta iuEtiquetaTipDoc;
                    private IUComboBox iuTipDoc;
                    private IUPanelEtiqueta iuEtiquetaDoc;
                    private IUCampoTexto iuDoc;
                    private IUPanelEtiqueta iuEtiquetaNum;
                    private IUCampoTexto iuNum;
                    private IUPanelEtiqueta iuEtiquetaMonto;
                    private IUCampoTexto iuMonto;
                private IUPanel segundoPanelC;
                    private IUPanelEtiqueta iuEtiquetaDocRef;
                    private IUCampoTexto iuDocRef;
                    private IUPanelEtiqueta iuEtiquetaNumLiteral;
                    private IUCampoTexto iuNumLiteral;
                    private IUPanelEtiqueta iuEtiquetaTipCam;
                    private IUCampoTexto iuTipCam;
                    private IUPanelEtiqueta iuUnidad;
                private IUPanel tercerPanelC;
                    private IUPanelEtiqueta iuEtiquetaConcepto;
                    private IUCampoTexto iuConcepto;
                    private IUAreaTexto iuAreaGlosa;
                    private IUPanelEtiqueta iuEtiquetaCuenta;
                    private IUCampoTexto iuCuenta;
                    private IUPanelEtiqueta iuEtiquetaBanco;
                    private IUCampoTexto iuBanco;
                    private IUPanelEtiqueta iuEtiquetaCheque;
                    private IUCampoTexto iuCheque;
                    
                private IUPanel cuartoPanelC;
                    private IUPanel panelFila;
                        private IUPanelEtiqueta iuEtiquetaNro;
                        private IUCampoTexto iuNro;
                        private IUPanelEtiqueta iuEtiquetaCodigo;
                        private IUCampoTexto iuCodigo;
                        private IUPanelEtiqueta iuEtiquetaDescripcion;
                        private IUCampoTexto iuDescripcion;
                        private IUPanelEtiqueta iuEtiquetaDebe;
                        private IUCampoTexto iuDebe;
                        private IUPanelEtiqueta iuEtiquetaHaber;
                        private IUCampoTexto iuHaber;
                        private IUPanelEtiqueta iuEtiquetaMontoDolares;
                        private IUCampoTexto iuMontoDolares;
                    private IUTabla iuTabla;
                        private IUEtiqueta iuTotalComprobante;
                        private IUEtiqueta iuTotalDebe;
                        private IUEtiqueta iuTotalHaber;
                        private IUEtiqueta iuTotalMontoDolares;
                
                private IUPanel quintoPanelC;
                private IUPanel sextoPanelC;
                
        
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
    private ArrayList<Tabvar> listaTabvar;
    private final ArrayList<Asiento> listaAsientos;
    
    private int indice;
    private String opcion;
    
    public VContra(VPrincipal ventanaPrincipal, String titulo, String tipoSize, Usuario usuario, Tabvar tabvar) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        this.titulo = titulo;
        this.usuario = usuario;
        this.tabvar = tabvar;
        this.listaTabvar = CTabvar.getLista("SELECT * FROM TABVAR WHERE TIPO = 2");
        this.listaAsientos = new ArrayList<>();
        this.indice = 1;
        this.opcion = "";
        
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
        
        iuTitulo = new IUEtiqueta(panelTitulo, "USUARIO: "+tabvar.getDescri(), new Area(a.X(), a.Y(2) + a.AlP(45), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
        //iuTitulo = new IUEtiqueta(panelTitulo, "EMISION: "+new Fecha().getFecha1(), new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(45), a.AnP(40), a.AlP(50)), 16, "RIGHT", false);
    }
    private void construirPanelDatos(Area a){
        primerPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(), a.An(), a.AlP(85)), false);
        construirPrimerPanel(new Area(2, 2, primerPanel.area.An() - 4, primerPanel.area.Al() - 4));
        
        segundoPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(2) + a.AlP(85), a.An(), a.AlP(15)), false);
        construirSegundoPanel(new Area(2, 2, segundoPanel.area.An() - 6, segundoPanel.area.Al() - 8));
    }
    private void construirPrimerPanel(Area a){        
        panelComprobante = new IUPanel(primerPanel, new Area(a.X(), a.Y(), a.An(), a.Al()), false);
        construirPanelComprobante(new Area(2, 2, panelComprobante.area.An() - 4, panelComprobante.area.Al() - 14));
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
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoS_N1.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoS_N1.setText("N");
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
        construirPrimerPanelC(new Area(2, 2, primerPanelC.area.An() - 20, primerPanelC.area.Al() - 4));
        
        segundoPanelC = new IUPanel(panelComprobante, new Area(a.X(), a.Y(2) + a.AlP(5), a.An(), a.AlP(10)), false);
        construirSegundoPanelC(new Area(2, 2, segundoPanelC.area.An() - 12, segundoPanelC.area.Al() - 6));
        
        tercerPanelC = new IUPanel(panelComprobante, new Area(a.X(), a.Y(3) + a.AlP(15), a.An(), a.AlP(20)), true);
        construirTercerPanelC(new Area(2, 2, tercerPanelC.area.An() - 10, tercerPanelC.area.Al() - 10));
        
        cuartoPanelC = new IUPanel(panelComprobante, new Area(a.X(), a.Y(4) + a.AlP(35), a.An(), a.AlP(47)), true);
        construirCuartoPanelC(new Area(2, 2, cuartoPanelC.area.An() - 10, cuartoPanelC.area.Al() - 6));
        
        quintoPanelC = new IUPanel(panelComprobante, new Area(a.X(), a.Y(5) + a.AlP(82), a.An(), a.AlP(8)), true);
        construirQuintoPanelC(new Area(2, 0, quintoPanelC.area.An() - 14, quintoPanelC.area.Al()));
        
        sextoPanelC = new IUPanel(panelComprobante, new Area(a.X(), a.Y(6) + a.AlP(90), a.An(), a.AlP(10)), true);
    }
    private void construirPrimerPanelC(Area a){
        iuEtiquetaTipDoc = new IUPanelEtiqueta(primerPanelC, new Area(a.X(), a.Y(), a.AnP(13), a.Al()), "Tipo Documento: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuTipDoc = new IUComboBox(primerPanelC, Ayuda.aOpciones(Ayuda.getListColumnas("DESCRI", "SELECT DESCRI FROM TABVAR WHERE TIPO = 2 AND (NUMERO >= 1 AND NUMERO <= 3)"), "- Elija -"), new Area(a.X(2) + a.AnP(13), a.Y(), a.AnP(10), a.Al()), 16, 30);
        iuTipDoc.setEditar(false);
        iuTipDoc.setFont(new Font("Verdana", Font.PLAIN, 16));
        
        iuEtiquetaDoc = new IUPanelEtiqueta(primerPanelC, new Area(a.X(3) + a.AnP(23), a.Y(), a.AnP(13), a.Al()), "DOCUMENTO de: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuDoc = new IUCampoTexto(primerPanelC, 30, 16, new Area(a.X(4) + a.AnP(36), a.Y(), a.AnP(9), a.Al()), SwingConstants.CENTER);
        iuDoc.setEditar(false);
        iuDoc.setFont(new Font("Verdana", Font.BOLD, 16));
        
        iuEtiquetaNum = new IUPanelEtiqueta(primerPanelC, new Area(a.X(5) + a.AnP(45), a.Y(), a.AnP(7), a.Al()), "No.: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuNum = new IUCampoTexto(primerPanelC, 8, 16, new Area(a.X(6) + a.AnP(52), a.Y(), a.AnP(7), a.Al()), SwingConstants.CENTER);
        iuNum.setEditar(false);
        iuNum.setFont(new Font("Verdana", Font.BOLD, 16));
        
        iuEtiquetaMonto = new IUPanelEtiqueta(primerPanelC, new Area(a.X(7) + a.AnP(80), a.Y(), a.AnP(5), a.Al()), "Monto: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuMonto = new IUCampoTexto(primerPanelC, 14, 16, new Area(a.X(8) + a.AnP(85), a.Y(), a.AnP(10), a.Al()), SwingConstants.RIGHT);
        iuMonto.setRestriccionNumeroDecimal(2);
        iuMonto.setFont(new Font("Verdana", Font.BOLD, 16));
        iuEtiquetaNum = new IUPanelEtiqueta(primerPanelC, new Area(a.X(9) + a.AnP(95), a.Y(), a.AnP(5), a.Al()), "Bs.-", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
    }
    private void construirSegundoPanelC(Area a){
        //Recibido de: , Pagado a: , Por Concepto de: 
        iuEtiquetaDocRef = new IUPanelEtiqueta(segundoPanelC, new Area(a.X(), a.Y(), a.AnP(10), a.AlP(50)), "", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuDocRef = new IUCampoTexto(segundoPanelC, "", 16, new Area(a.X(2) + a.AnP(10), a.Y(), a.AnP(65), a.AlP(50)));
        iuDocRef.setFont(new Font("Verdana", Font.BOLD, 16));
        
        iuEtiquetaTipCam = new IUPanelEtiqueta(segundoPanelC, new Area(a.X(3) + a.AnP(75), a.Y(), a.AnP(7), a.AlP(50)), "T/C: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuTipCam = new IUCampoTexto(segundoPanelC, 50, 16, new Area(a.X(4) + a.AnP(82), a.Y(), a.AnP(8), a.AlP(50)), SwingConstants.CENTER);
        iuTipCam.setText(String.valueOf(usuario.getTipcam()));
        iuTipCam.setEditar(false);
        iuTipCam.setFont(new Font("Verdana", Font.BOLD, 16));
        iuUnidad = new IUPanelEtiqueta(segundoPanelC, new Area(a.X(5) + a.AnP(90), a.Y(), a.AnP(10), a.AlP(50)), "Bs.-/$us.-", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        
        iuEtiquetaNumLiteral = new IUPanelEtiqueta(segundoPanelC, new Area(a.X(), a.Y(2) + a.AlP(50), a.AnP(10), a.AlP(50)), "La suma de: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuNumLiteral = new IUCampoTexto(segundoPanelC, 100, 16, new Area(a.X(2) + a.AnP(10), a.Y(2) + a.AlP(50), a.AnP(80) + a.X(2), a.AlP(50)), SwingConstants.LEFT);
        iuNumLiteral.setFont(new Font("Verdana", Font.BOLD, 16));
        iuNumLiteral.setEditar(false);
        iuEtiquetaNumLiteral = new IUPanelEtiqueta(segundoPanelC, new Area(a.X(5) + a.AnP(90), a.Y(2) + a.AlP(50), a.AnP(10), a.AlP(50)), "Bolivianos", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);        
    }    
    private void construirTercerPanelC(Area a){
        iuEtiquetaConcepto = new IUPanelEtiqueta(tercerPanelC, new Area(a.X(), a.Y(), a.AnP(10), a.AlP(25)), "Por Concepto: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuConcepto = new IUCampoTexto(tercerPanelC, "", 16, new Area(a.X(2) + a.AnP(10), a.Y(), a.AnP(70), a.AlP(25)));
        iuConcepto.setFont(new Font("Verdana", Font.BOLD, 16));
        iuAreaGlosa = new IUAreaTexto(tercerPanelC, new Area(a.X(2) + a.AnP(10), a.Y(2) + a.AlP(25), a.AnP(70), a.AlP(75) + a.Y(2)), "", 16);
        iuAreaGlosa.setFont(new Font("Verdana", Font.BOLD, 16));
        
        iuEtiquetaCuenta = new IUPanelEtiqueta(tercerPanelC, new Area(a.X(3) + a.AnP(80), a.Y(2) + a.AlP(25), a.AnP(10), a.AlP(25)), " Cuenta Cte.:", 16, SwingConstants.LEFT, Ayuda.COLOR_FONDO, true);
        iuCuenta = new IUCampoTexto(tercerPanelC, 10, 16, new Area(a.X(4) + a.AnP(90), a.Y(2) + a.AlP(25), a.AnP(10), a.AlP(25)), SwingConstants.LEFT);
        iuCuenta.setFont(new Font("Verdana", Font.BOLD, 16));
        iuEtiquetaBanco = new IUPanelEtiqueta(tercerPanelC, new Area(a.X(3) + a.AnP(80), a.Y(3) + a.AlP(50), a.AnP(10), a.AlP(25)), " Banco.:", 16, SwingConstants.LEFT, Ayuda.COLOR_FONDO, true);        
        iuBanco = new IUCampoTexto(tercerPanelC, "", 16, new Area(a.X(4) + a.AnP(90), a.Y(3) + a.AlP(50), a.AnP(10), a.AlP(25)));
        iuBanco.setFont(new Font("Verdana", Font.BOLD, 16));
        iuEtiquetaCheque = new IUPanelEtiqueta(tercerPanelC, new Area(a.X(3) + a.AnP(80), a.Y(4) + a.AlP(75), a.AnP(10), a.AlP(25)), " Cheque No.:", 16, SwingConstants.LEFT, Ayuda.COLOR_FONDO, true);
        iuCheque = new IUCampoTexto(tercerPanelC, 10, 16, new Area(a.X(4) + a.AnP(90), a.Y(4) + a.AlP(75), a.AnP(10), a.AlP(25)), SwingConstants.LEFT);
        iuCheque.setFont(new Font("Verdana", Font.BOLD, 16));
    }
    private void construirCuartoPanelC(Area a){
        iuTabla = new IUTabla(
        cuartoPanelC,
        new Area(a.X(), a.Y(), a.An() + a.X(3), a.AlP(90)), 
        new String[]{"No", "CODIGO", "DESCRIPCION DE CUENTA", "DEBE", "HABER", "MONTO $us"}, 
        new Class[]{Integer.class, Long.class, String.class, Double.class, Double.class, Double.class}, 
        new int[]{5, 15, 50, 10, 10, 10}, 
        new ArrayList(), 
        new ModeloTabla<Asiento>(){
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return rowIndex + 1;
                    case 1:
                        return lista.get(rowIndex).getCodigo();
                    case 2:
                        return lista.get(rowIndex).getCuenta();
                    case 3:
                        return lista.get(rowIndex).getDeber();
                    case 4:
                        return lista.get(rowIndex).getHaber();
                    case 5:
                        return lista.get(rowIndex).getMonto();
                    default:
                        return null;
                }
            }
        });
        
        iuTotalComprobante = new IUEtiqueta(cuartoPanelC, "Total Comprobante (en Bolivianos)    ", new Area(a.X() + a.AnP(20), a.Y(2) + a.AlP(90), a.AnP(50), a.AlP(10)), 16, "RIGHT", Ayuda.COLOR_ROJO);
        iuTotalDebe = new IUEtiqueta(cuartoPanelC, "0.0", new Area(a.X(2) + a.AnP(70), a.Y(2) + a.AlP(90), a.AnP(10), a.AlP(10)), 16, "RIGHT", true);
        iuTotalHaber = new IUEtiqueta(cuartoPanelC, "0.0", new Area(a.X(3) + a.AnP(80), a.Y(2) + a.AlP(90), a.AnP(10), a.AlP(10)), 16, "RIGHT", true);
        iuTotalMontoDolares = new IUEtiqueta(cuartoPanelC, "0.0", new Area(a.X(4) + a.AnP(90), a.Y(2) + a.AlP(90), a.AnP(10), a.AlP(10)), 16, "RIGHT", true);
    }
    private void construirQuintoPanelC(Area a){
        iuEtiquetaNro = new IUPanelEtiqueta(quintoPanelC, new Area(a.X(), a.Y(), a.AnP(5), a.AlP(45)), "No", 14, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);        
        iuNro = new IUCampoTexto(quintoPanelC, 2, 16, new Area(a.X(), a.Y() + a.AlP(45), a.AnP(5), a.AlP(55)), SwingConstants.CENTER);
        iuNro.setEditar(false);
        
        iuEtiquetaCodigo = new IUPanelEtiqueta(quintoPanelC, new Area(a.X(2) + a.AnP(5), a.Y(), a.AnP(15), a.AlP(45)), "CODIGO", 14, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuCodigo = new IUCampoTexto(quintoPanelC, 2, 16, new Area(a.X(2) + a.AnP(5), a.Y() + a.AlP(45), a.AnP(15), a.AlP(55)), SwingConstants.CENTER);
        iuCodigo.setEditar(false);
        
        iuEtiquetaDescripcion = new IUPanelEtiqueta(quintoPanelC, new Area(a.X(3) + a.AnP(20), a.Y(), a.AnP(50), a.AlP(45)), "DESCRIPCION DE CUENTA", 14, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuDescripcion = new IUCampoTexto(quintoPanelC, 2, 16, new Area(a.X(3) + a.AnP(20), a.Y() + a.AlP(45), a.AnP(50), a.AlP(55)), SwingConstants.LEFT);
        iuDescripcion.setEditar(false);
        
        iuEtiquetaDebe = new IUPanelEtiqueta(quintoPanelC, new Area(a.X(4) + a.AnP(70), a.Y(), a.AnP(10), a.AlP(45)), "DEBE", 14, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuDebe = new IUCampoTexto(quintoPanelC, 2, 16, new Area(a.X(4) + a.AnP(70), a.Y() + a.AlP(45), a.AnP(10), a.AlP(55)), SwingConstants.CENTER);
        iuDebe.setEditar(false);
        
        iuEtiquetaHaber = new IUPanelEtiqueta(quintoPanelC, new Area(a.X(5) + a.AnP(80), a.Y(), a.AnP(10), a.AlP(45)), "HABER", 14, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuHaber = new IUCampoTexto(quintoPanelC, 2, 16, new Area(a.X(5) + a.AnP(80), a.Y() + a.AlP(45), a.AnP(10), a.AlP(55)), SwingConstants.CENTER);
        iuHaber.setEditar(false);
        
        iuEtiquetaMontoDolares = new IUPanelEtiqueta(quintoPanelC, new Area(a.X(6) + a.AnP(90), a.Y(), a.AnP(10), a.AlP(45)), "MONTO $us", 14, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuMontoDolares = new IUCampoTexto(quintoPanelC, 2, 16, new Area(a.X(6) + a.AnP(90), a.Y() + a.AlP(45), a.AnP(10), a.AlP(55)), SwingConstants.CENTER);
        iuMontoDolares.setEditar(false);
    }
    
    private void algoritmoInicial(){
        restringirCampos("TIPDOC", true);
        focoCampoTipoDocumento(); 
        
    }
    private void restringirCampos(String campo, boolean state){        
        iuTipDoc.setEditar(false);
        iuMonto.setEditar(false);
        iuDocRef.setEditar(false);
        iuConcepto.setEditar(false);
        iuAreaGlosa.setEditable(false);
        iuCuenta.setEditar(false);
        iuBanco.setEditar(false);        
        iuCheque.setEditar(false);
        iuNro.setEditar(false);
        iuCodigo.setEditar(false);
        iuDescripcion.setEditar(false);
        iuDebe.setEditar(false);
        iuHaber.setEditar(false);
        iuMontoDolares.setEditar(false);
        switch(campo){
            case"TIPDOC":
                iuTipDoc.setEditar(state);
            break;
            case"MONTO":
                iuMonto.setEditar(state);
            break;
            case"DOCREF":
                iuDocRef.setEditar(state);
            break;
            case"CONCEPTO":
                iuConcepto.setEditar(state);
            break;
            case"GLOSA":
                iuAreaGlosa.setEditable(state);
            break;
            case"CUENTA":
                iuCuenta.setEditar(state);
            break;
            case"BANCO":
                iuBanco.setEditar(state);
            break;
            case "CHEQUE":
                iuCheque.setEditar(state);
            break;
            case "NRO":
                iuNro.setEditar(state);
            break;
            case "CODIGO":
                iuCodigo.setEditar(state);
            break;
            case "DESCRIPCION":
                iuDescripcion.setEditar(state);
            break;
            case "DEBE":
                iuDebe.setEditar(state);
            break;
            case "HABER":
                iuHaber.setEditar(state);
            break;
            case "MONTO_DOLARES":
                iuMontoDolares.setEditar(state);
            break;
            default:                
            break;
        }
    }
    private void pintarBordeCampo(String campo){
        Border borde = new LineBorder(Color.GREEN);        
        
        iuTipDoc.setBorder(iuTipDoc.getBordeComponente());
        iuMonto.setBorder(iuMonto.getBordeComponente());
        iuDocRef.setBorder(iuDocRef.getBordeComponente());
        iuConcepto.setBorder(iuConcepto.getBordeComponente());
        iuAreaGlosa.setBorder(iuAreaGlosa.getBordeComponente());
        iuCuenta.setBorder(iuCuenta.getBordeComponente());
        iuBanco.setBorder(iuBanco.getBordeComponente());
        iuCheque.setBorder(iuCheque.getBordeComponente());
        iuNro.setBorder(iuNro.getBordeComponente());
        iuCodigo.setBorder(iuCodigo.getBordeComponente());
        iuDescripcion.setBorder(iuDescripcion.getBordeComponente());
        iuDebe.setBorder(iuDebe.getBordeComponente());
        iuHaber.setBorder(iuHaber.getBordeComponente());
        iuMontoDolares.setBorder(iuMontoDolares.getBordeComponente());
        iuTabla.setSelectionBackground(null);
        switch(campo){
            case"TIPDOC":
                iuTipDoc.setBorder(borde);
            break;
            case"MONTO":
                iuMonto.setBorder(borde);
            break;
            case"DOCREF":
                iuDocRef.setBorder(borde);
            break;
            case"CONCEPTO":
                iuConcepto.setBorder(borde);
            break;
            case"GLOSA":
                iuAreaGlosa.setBorder(borde);
            break;
            case"CUENTA":
                iuCuenta.setBorder(borde);
            break;
            case"BANCO":
                iuBanco.setBorder(borde);
            break;
            case "CHEQUE":
                iuCheque.setBorder(borde);
            break;
            case "TABLA": 
                iuTabla.setSelectionBackground(Color.GREEN);
            break;
            case "NRO":
                iuNro.setBorder(borde);
            break;
            case "CODIGO":
                iuCodigo.setBorder(borde);
            break;
            case "DESCRIPCION":
                iuDescripcion.setBorder(borde);
            break;
            case "DEBE":
                iuDebe.setBorder(borde);
            break;
            case "HABER":
                iuHaber.setBorder(borde);
            break;
            case "MONTO_DOLARES":
                iuMontoDolares.setBorder(borde);
            break;
            default:
            break;
        }        
    }
    private void focoCampoTipoDocumento(){
        pintarBordeCampo("TIPDOC");
        iuTipDoc.setEditar(true);        
        iuTipDoc.requestFocus();
        iuMensaje.setTexto("CAMPO TIPO DOCUMENTO: SELECCIONE UN TIPO DE DOCUMENTO. INGRESO, EGRESO, DIARIO.");
        iuInformacion.setTexto(" ATENCION: ENTER=Avanzar, ESC=Suspender");
        seleccionarTipoDocumento(iuTipDoc.getSelectedItem().toString());
        iuTipDoc.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String dato = e.getItem().toString();
                seleccionarTipoDocumento(dato);
            }
        });
        iuTipDoc.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!iuTipDoc.getTexto().isEmpty()  && !iuTipDoc.getSelectedItem().toString().equalsIgnoreCase("- Elija -")){
                        focoCampoMonto();
                    }
                }
            }
        });
    }
    private void seleccionarTipoDocumento(String tipdoc){
        boolean encontro = false;
        int contador = 0;
        while(contador < listaTabvar.size() && !encontro){
            Tabvar t = listaTabvar.get(contador);
            if(t.getTipo() == 2){                
                if(t.getDescri().equalsIgnoreCase(tipdoc)){
                    switch(tipdoc){
                        case "INGRESOS":
                            iuEtiquetaDocRef.setTexto("Recibido de: ");                            
                        break;
                        case "EGRESOS":
                            iuEtiquetaDocRef.setTexto("Pagado a: ");
                        break;
                        case "DIARIOS":
                            iuEtiquetaDocRef.setTexto("Por Concepto: ");
                        break;
                    }
                    encontro = true;
                    iuDoc.setText(t.getDescri());
                    iuNum.setText(String.valueOf(t.getCorrel()));
                }
            }
            contador++;
        }
    }
    private void focoCampoMonto(){
        pintarBordeCampo("MONTO");
        iuMonto.setEditar(true);
        iuMonto.requestFocus();
        iuMensaje.setTexto("CAMPO MONTO: Indique MONTO del Documento en BOLIVIANOS. (MONTO > 0)");
        iuInformacion.setTexto(" ATENCION: ENTER=Avanzar, F2=Retroceder, ESC=Suspender");
        iuMonto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!iuMonto.getText().isEmpty()){
                        if(Double.parseDouble(iuMonto.getText()) > 0){
                            iuNumLiteral.setText(Numero_a_Letra.Convertir(iuMonto.getText(), true));
                            focoCampoDocRef();
                        }
                    }
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoTipoDocumento();
                }
            }
        });
    }
    private void focoCampoDocRef(){
        pintarBordeCampo("DOCREF");
        iuDocRef.setEditar(true);
        iuDocRef.requestFocus();
        iuMensaje.setTexto("CAMPO "+iuEtiquetaDocRef.getTexto().toUpperCase()+"Digite el Nombre del Interesado.");
        iuInformacion.setTexto(" ATENCION: ENTER=Avanzar, F2=Retroceder, ESC=Suspender");
        iuDocRef.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!iuDocRef.getText().isEmpty()){
                        focoCampoConcepto();
                    }
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoMonto();
                }
            }
        });
    }
    private void focoCampoConcepto(){
        pintarBordeCampo("CONCEPTO");
        iuConcepto.setEditar(true);
        iuConcepto.requestFocus();
        iuMensaje.setTexto("CAMPO CONCEPTO: Resuma el CONCEPTO del Documento.");
        iuInformacion.setTexto(" ATENCION: ENTER=Avanzar, F2=Retroceder, ESC=Suspender");
        iuConcepto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!iuConcepto.getText().isEmpty()){
                        focoCampoGlosa();
                    }
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoDocRef();
                }
            }
        });
    }
    private void focoCampoGlosa(){
        pintarBordeCampo("GLOSA");
        iuAreaGlosa.setEditable(true);
        iuAreaGlosa.requestFocus();
        iuMensaje.setTexto("CAMPO GLOSA: Realize una Descripcion mas amplia.");
        iuInformacion.setTexto(" ATENCION: ENTER=Avanzar, F2=Retroceder, ESC=Suspender");
        iuAreaGlosa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!iuAreaGlosa.getText().isEmpty()){                        
                        switch(iuTipDoc.getTexto()){
                            case "INGRESOS":
                                iuEtiquetaDocRef.setTexto("Recibido de: ");
                                camposDocumentoConcluidos();
                            break;
                            case "EGRESOS":
                                iuEtiquetaDocRef.setTexto("Pagado a: ");
                                focoCampoCtaCte();
                            break;
                            case "DIARIOS":
                                iuEtiquetaDocRef.setTexto("Por Concepto: ");
                                focoCampoCtaCte();
                            break;
                        }
                    }
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoConcepto();
                }
            }
        });
    }
    private void focoCampoCtaCte(){
        pintarBordeCampo("CUENTA");
        iuCuenta.setEditar(true);
        iuCuenta.requestFocus();
        iuMensaje.setTexto("CAMPO CUENTA: Digite los NUMEROS pertenecientes a una cuenta corriente que emite el CHEQUE.");
        iuInformacion.setTexto(" ATENCION: ENTER=Avanzar, F2=Retroceder, F7=BANCO -A-, F8=BANCO -B-, ESC=Suspender");
        iuCuenta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    focoCampoBanco();
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoGlosa();
                }
                if(KeyEvent.VK_F7 == e.getKeyCode()){
                    Tabvar t = CTabvar.getTabvar(2, 10);
                    iuCuenta.setText(String.valueOf((int)t.getMonto()));
                    iuBanco.setText(t.getDescri());
                    iuCheque.setText(String.valueOf(t.getCorrel()));
                    focoCampoBanco();
                }
                if(KeyEvent.VK_F8 == e.getKeyCode()){
                    Tabvar t = CTabvar.getTabvar(2, 11);
                    iuCuenta.setText(String.valueOf((int)t.getMonto()));
                    iuBanco.setText(t.getDescri());
                    iuCheque.setText(String.valueOf(t.getCorrel()));
                    focoCampoBanco();
                }
            }
        });
    }
    private void focoCampoBanco(){
        pintarBordeCampo("BANCO");
        iuBanco.setEditar(true);
        iuBanco.requestFocus();
        iuMensaje.setTexto("CAMPO BANCO: Confirme la DENOMINACION del BANCO (x20).");
        iuInformacion.setTexto(" ATENCION: ENTER=Avanzar, F2=Retroceder, ESC=Suspencion DIRECTA");
        iuBanco.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    focoCampoCheque();
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoCtaCte();
                }
            }
        });
    }
    private void focoCampoCheque(){
        pintarBordeCampo("CHEQUE");
        iuCheque.setEditar(true);
        iuCheque.requestFocus();
        iuMensaje.setTexto("CAMPO CHEQUE: Confirme Digite el NUMERO de CHEQUE.");
        iuInformacion.setTexto(" ATENCION: ENTER=Avanzar, F2=Retroceder, ESC=Suspencion DIRECTA");
        iuCheque.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(iuCheque.getText().isEmpty()){
                        iuCheque.setText("0");                        
                    }
                    camposDocumentoConcluidos();
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoBanco();
                }
            }
        });
    }
    private void camposDocumentoConcluidos(){
        boolean verificador = false;
        if(!iuMonto.getText().isEmpty()){
            if(!iuDocRef.getText().isEmpty()){
                if(!iuConcepto.getText().isEmpty()){
                    verificador = true;
                }else{
                    iuMensaje.setTexto("el CAMPO CONCEPTO: NO puede estar vacio.");
                    focoCampoConcepto();
                }
            }else{
                iuMensaje.setTexto("el CAMPO "+iuEtiquetaDocRef.getTexto().toUpperCase()+" NO puede estar vacio.");
                focoCampoDocRef();
            }
        }else{
            iuMensaje.setTexto("el CAMPO MONTO: NO puede estar vacio. ");
            focoCampoMonto();
        }
        if(verificador){
            restringirCampos("", false);
            pintarBordeCampo("");
            campoS_N1.setVisible(true);
            campoS_N1.requestFocus();
            campoS_N1.setText("S");
            iuMensaje.setTexto("Esta CONFORME con los Datos Generales del Asiento Contable. ?    S/N");
            iuInformacion.setTexto("");
            campoS_N1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(KeyEvent.VK_ENTER == e.getKeyCode()){
                        switch(campoS_N1.getText()){
                            case "S":
                                deshabilitarCampoS_N();
                                focoCampoNro();
                                inhabilitarCampos();
                            break;
                            case "N":
                                focoCampoTipoDocumento();
                            break;                            
                            default:
                            break;
                        }
                    }
                }
            });
        }
    }
    private void focoCampoNro(){        
        pintarBordeCampo("NRO");
        iuNro.setEditar(true);
        iuNro.requestFocus();
        
        //iuCodigo.setText("");
        //iuDescripcion.setText("");
        //iuDebe.setText("");
        //iuHaber.setText("");
        //iuMontoDolares.setText("");
        
        iuMensaje.setTexto("CAMPO No: REGISTRO DEL COMPROBANTE.");
        iuInformacion.setTexto(" ATENCION: ENTER=Avanzar, ESC=Suspender");
        iuNro.setText(String.valueOf(indice));
        iuNro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){                    
                    focoCampoCodigo();
                }
            }
        });
    }
    private void focoCampoCodigo(){
        iuNro.setText(String.valueOf(indice));
        pintarBordeCampo("CODIGO");
        iuCodigo.setEditar(true);
        iuCodigo.requestFocus();
        iuMensaje.setTexto("CAMPO CODIGO DE CUENTA: En este Campo podra Crear cuenta, elegir Asientos Tipo y consultar a la Ayuda.");
        iuInformacion.setTexto(" ATENCION: ENTER=Avanzar, F1=Ayuda, F2=Retrocede, F7=Crear Cuenta, F8=ASIENTOS TIPO, ESC=Suspender");
        iuCodigo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    
                }
                if(KeyEvent.VK_F1 == e.getKeyCode()){
                    setOpacity(0.5f);
                    VAyudaContra iuAyuda = new VAyudaContra(ventanaPrincipal, titulo, "medio-grande");
                    iuAyuda.mostrarVentana();
                    if(iuAyuda.getEstado()){
                        Conmae c = iuAyuda.getConmae();
                        iuCodigo.setText(String.valueOf(c.getCuetot()));
                        iuDescripcion.setText(c.getDescri());
                        focoCampoDebe();
                    }                        
                    setOpacity(1f);
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoNro();
                }
                if(KeyEvent.VK_F7 == e.getKeyCode()){
                    Ayuda.mostrarMensajeInformacion(ventanaPrincipal, "Atencion: Para seleccionar el codigo de asiento NECESARIAMENTE DEBE CREAR UNA NUEVA CUENTA, en el plan de cuentas respectivamente.", "ADVERTENCIA");                    
                    setOpacity(0.6f);
                    VNuevoPlanCuentas vConmae = new VNuevoPlanCuentas(ventanaPrincipal, titulo, "grande", usuario, tabvar);
                    vConmae.mostrarVentana();
                    if(vConmae.getEstado()){
                        Conmae c = vConmae.getConmae();
                        iuCodigo.setText(String.valueOf(c.getCuetot()));
                        iuDescripcion.setText(c.getDescri());
                        focoCampoDebe();
                    }
                    setOpacity(1f);
                }
                if(KeyEvent.VK_F8 == e.getKeyCode()){
                    setOpacity(0.6f);
                    VAsientoTipo iuAsiento = new VAsientoTipo(ventanaPrincipal, titulo, "intermedio");
                    iuAsiento.mostrarVentana();                    
                    if(iuAsiento.getEstado()){
                        for (Tabvar t : iuAsiento.getList()) {
                            Asiento a = new Asiento(indice);
                            a.setCodigo(t.getCodcon());
                            a.setCuenta(t.getDescri());
                            listaAsientos.add(a);
                            iuTabla.modeloTabla.setFila(a);
                            indice++;
                        }                        
                    }
                    opcion = "ASIENTOS_TIPO";
                    focoCampoTabla();
                    setOpacity(1f);
                }
            }
        });        
    }
    private void focoCampoTabla(){
        pintarBordeCampo("TABLA");
        deshabilitarCampoS_N();
        
        iuNro.setBorder(new LineBorder(Color.GREEN));
        iuDescripcion.setBorder(new LineBorder(Color.GREEN));
        iuCodigo.setBorder(new LineBorder(Color.GREEN));
        iuDebe.setBorder(new LineBorder(Color.GREEN));        
        iuTabla.setFocusable(true);
        iuTabla.requestFocus();
        
        iuCodigo.setEditar(false);        
        
        iuMensaje.setTexto("CAMPO TABLA: Seleccione el registro que quiere modificar en el DEBE o HABER. (Utilize las teclas de flecha ARRIBA, ABAJO)");
        iuInformacion.setTexto("ATENCION: ENTER=Aceptar Registro, ESC=Suspender.");
        
        iuTabla.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if(iuTabla.isFilaSeleccionado()){
                Asiento a = (Asiento) iuTabla.modeloTabla.getFila(iuTabla.getSelectedRow());
                int nro = iuTabla.getSelectedRow() + 1;
                iuNro.setText(String.valueOf(nro));
                iuCodigo.setText(String.valueOf(a.getCodigo()));
                iuDescripcion.setText(a.getCuenta());
                iuDebe.setText(String.valueOf(a.getDeber()));
                iuHaber.setText(String.valueOf(a.getHaber()));
                iuMontoDolares.setText(String.valueOf(a.getMonto()));
            }
        });
        iuTabla.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        iuTabla.getActionMap().put("Enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(iuTabla.isFilaSeleccionado()){
                    iuTabla.modeloTabla.fireTableDataChanged();
                    iuTabla.setFocusable(false);
                    focoCampoDebe();
                }               
            }
        });
    }
    private void focoCampoDebe(){
        pintarBordeCampo("DEBE");
        deshabilitarCampoS_N();
        
        iuDebe.setEditar(true);
        iuDebe.requestFocus();
        iuMensaje.setTexto("CAMPO DEBE: Digite el Monto a DEBITAR, ");
        iuInformacion.setTexto(" ATENCION: ENTER=Avanzar, F7=87% de SI MISMO, F8=13%, ESC=Suspender");
        iuDebe.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!iuDebe.getText().isEmpty()){
                        if(Double.parseDouble(iuDebe.getText()) > 0){
                            double tc = usuario.getTipcam();
                            double debe = Double.parseDouble(iuDebe.getText());
                            double result = debe/tc;
                            double dolares = Ayuda.acotarNumero(result, 2);
                            iuHaber.setText("0.0");
                            iuMontoDolares.setText(String.valueOf(dolares));
                            focoCampoS_N();
                        }
                    }else{
                        iuDebe.setText("0.0");
                        focoCampoHaber();
                    }
                    //
                }
                if(KeyEvent.VK_F7 == e.getKeyCode()){
                    double monto = Double.parseDouble(iuMonto.getText());
                    double porcentaje = (monto*87)/100;
                    iuDebe.setText(String.valueOf(porcentaje));
                    
                    double tc = usuario.getTipcam();
                    double debe = Double.parseDouble(iuDebe.getText());
                    double result = debe/tc;
                    double dolares = Ayuda.acotarNumero(result, 2);
                    iuHaber.setText("0.0");
                    iuMontoDolares.setText(String.valueOf(dolares));
                    focoCampoS_N();                    
                }
                if(KeyEvent.VK_F8 == e.getKeyCode()){
                    double monto = Double.parseDouble(iuMonto.getText());
                    double porcentaje = (monto*13)/100;
                    iuDebe.setText(String.valueOf(porcentaje));
                    
                    double tc = usuario.getTipcam();
                    double debe = Double.parseDouble(iuDebe.getText());
                    double result = debe/tc;
                    double dolares = Ayuda.acotarNumero(result, 2);
                    iuHaber.setText("0.0");
                    iuMontoDolares.setText(String.valueOf(dolares));
                    focoCampoS_N();
                }
            }
        });
    }
    private void focoCampoHaber(){
        
    }
    private void sumarColumnasTotales(){
        ArrayList<Asiento> lista = iuTabla.modeloTabla.lista;
        double debe = 0;
        double haber = 0;
        for (Asiento a : lista) {
            debe = debe + a.getDeber();
            haber = haber + a.getHaber();            
        }
        double dolar = debe - haber;
        iuTotalDebe.setText(String.valueOf(debe));
        iuTotalHaber.setText(String.valueOf(haber));
        iuTotalMontoDolares.setText(String.valueOf(dolar));
    }
    private void focoCampoS_N(){
        pintarBordeCampo("DOLAR");
        iuDebe.setEditar(false);
        campoS_N1.setVisible(true);
        campoS_N1.setEditar(true);
        campoS_N1.requestFocus();
        campoS_N1.setText("S");
        iuMensaje.setTexto("Esta Conforme con el MONTO en DOLARES. ?");
        iuInformacion.setTexto("");
        campoS_N1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N1.getText()){
                        case "S":
                            switch(opcion){
                                case "ASIENTOS_TIPO":
                                    modificarRegistroTabla();
                                    sumarColumnasTotales();
                                    focoCampoTabla();
                                break;
                                case "":
                                    Asiento a = new Asiento(Integer.parseInt(iuNro.getText()));
                                    a.setCodigo(Long.parseLong(iuCodigo.getText()));
                                    a.setCuenta(iuDescripcion.getText());
                                    a.setDeber(Double.parseDouble(iuDebe.getText()));
                                    a.setHaber(Double.parseDouble(iuHaber.getText()));
                                    a.setMonto(Double.parseDouble(iuMontoDolares.getText()));
                                    iuTabla.modeloTabla.setFila(a);
                                    indice++;
                                    focoCampoNro();
                                break;
                            }
                        break;
                        case "N":
                            sumarColumnasTotales();
                            focoCampoDebe();
                        break;
                        default:
                        break;
                    }
                }
            }
        });
        
    }
    private void modificarRegistroTabla(){
        boolean encontro = false;
        int contador = 0;
                
        while(contador < iuTabla.modeloTabla.lista.size() && !encontro){
            if(!iuCodigo.getText().isEmpty()){
                if(((Asiento)iuTabla.modeloTabla.lista.get(contador)).getCodigo() == Long.parseLong(iuCodigo.getText())){
                    Asiento a = new Asiento(contador+1);
                    a.setCodigo(Long.parseLong(iuCodigo.getText()));
                    a.setCuenta(iuDescripcion.getText());
                    a.setDeber(Double.parseDouble(iuDebe.getText()));
                    a.setHaber(Double.parseDouble(iuHaber.getText()));
                    a.setMonto(Double.parseDouble(String.valueOf(iuMontoDolares.getText())));
                    iuTabla.modeloTabla.setUpdateFila(contador, a);                
                    encontro = true;
                }
                contador++;
            }else{
                System.out.println("EL CODIGO esta VACIO....."+iuCodigo.getText());
                encontro = true;
            }
        }
        System.out.println(listaAsientos.size());
        //iuTabla.actualizarTabla(listaAsientos);
    }
    private void inhabilitarCampos(){
        iuTipDoc.setEnabled(false);
        iuMonto.setEnabled(false);
        iuDoc.setEnabled(false);
        iuNum.setEnabled(false);
        iuDocRef.setEnabled(false);
        iuNumLiteral.setEnabled(false);
        iuConcepto.setEnabled(false);
        iuTipCam.setEnabled(false);
        iuAreaGlosa.setEnabled(false);
        iuCuenta.setEnabled(false);
        iuBanco.setEnabled(false);
        iuCheque.setEnabled(false);
    }
    private void deshabilitarCampoS_N(){
        campoS_N1.setEditar(false);
        campoS_N1.setVisible(false);
        
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.contra;

import SIGU.botones.IUBotonCheckBox;
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
import com.siscon.controller.CTabvar;
import com.siscon.model.Asiento;
import com.siscon.model.Conmae;
import com.siscon.model.Contra;
import com.siscon.model.Tabvar;
import com.siscon.model.Usuario;
import com.siscon.recursos.Ayuda;
import com.siscon.recursos.Numero_a_Letra;
import com.siscon.view.VPrincipal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author neo
 */
public class VContraDoble extends IUSecundario{
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
                    //private IUAreaTexto iuAreaGlosa;
                    //private IUPanelEtiqueta iuEtiquetaCuenta;
                    //private IUCampoTexto iuCuenta;
                    //private IUPanelEtiqueta iuEtiquetaBanco;
                    //private IUCampoTexto iuBanco;
                    //private IUPanelEtiqueta iuEtiquetaCheque;
                    //private IUCampoTexto iuCheque;
                    
                private IUPanel quintoPanelC;
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
                        private IUCampoTexto iuDolares;
                    private IUTabla iuTabla;
                        private IUEtiqueta iuTotalComprobante;
                        private IUEtiqueta iuTotalDebe;
                        private IUEtiqueta iuTotalHaber;
                        private IUEtiqueta iuTotalDolares;
                
                private IUPanel cuartoPanelC;
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
            private IUCampoTexto campoS_N8;
            private IUCampoTexto campoS_N9;
    
    private Usuario usuario;
    private Tabvar tabvar;
    private Tabvar tabvarCheque;
    private ArrayList<Tabvar> listaTabvar;
    private ArrayList<Asiento> listaAsientos;
    private ArrayList<Contra> listaContras;
    
    private Asiento asiento;
    
    private int indice;    
    private boolean modificable;
    private String concepto;
    private String tipoCampbio;
    
    public VContraDoble(VPrincipal ventanaPrincipal, String titulo, String tipoSize, Usuario usuario, Tabvar tabvar) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        this.titulo = titulo;
        this.usuario = usuario;
        this.tabvar = tabvar;
        this.tabvarCheque = null;
        this.listaTabvar = CTabvar.getLista("SELECT * FROM TABVAR WHERE TIPO = 2");
        this.listaAsientos = new ArrayList<>();
        this.listaContras = new ArrayList<>();
        this.indice = 1;
        this.asiento = new Asiento(0);
        this.modificable = false;
        this.tipoCampbio = "";
        this.concepto = "";
        
        construirPanel(new Area(An()-6, Al()-29));
        algoritmoInicial();
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
        iuTitulo = new IUEtiqueta(panelTitulo, usuario.getRazsoc(), new Area(a.X(), a.Y(), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "ASIENTO DE DIARIO", new Area(a.X(2) + a.AnP(25), a.Y(), a.AnP(35), a.AlP(50)), 16, "CENTER", false);        
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, Ayuda.getDatoCadena("DESCRI", "SELECT DESCRI FROM TABVAR WHERE TIPO = 10 AND NUMERO = 1"), new Area(a.X(2) + a.AnP(25), a.Y(2) + a.AlP(45), a.AnP(35), a.AlP(50)), 16, "CENTER", Ayuda.COLOR_ROJO);
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "SISTEMA CONTABLE SISCON @v7.2. 2020", new Area(a.X(3) + a.AnP(60), a.Y(), a.AnP(40), a.AlP(50)), 16, "RIGHT", false); 
        iuTitulo = new IUEtiqueta(panelTitulo, new Fecha().getFecha1(), new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(45), a.AnP(40), a.AlP(50)), 16, "RIGHT", false); 
        
        iuTitulo = new IUEtiqueta(panelTitulo, "USUARIO: "+tabvar.getDescri(), new Area(a.X(), a.Y(2) + a.AlP(45), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
    }
    private void construirPanelDatos(Area a){
        primerPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(), a.An(), a.AlP(85)), false);
        construirPrimerPanel(new Area(2, 2, primerPanel.area.An() - 4, primerPanel.area.Al() - 4));
        
        segundoPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(2) + a.AlP(85), a.An(), a.AlP(15)), false);
        construirSegundoPanel(new Area(8, 2, segundoPanel.area.An() - 24, segundoPanel.area.Al() - 8));        
    }
    private void construirPrimerPanel(Area a){        
        panelComprobante = new IUPanel(primerPanel, new Area(a.X(), a.Y(), a.An(), a.Al()), false);
        construirPanelComprobante(new Area(2, 2, panelComprobante.area.An() - 4, panelComprobante.area.Al() - 14));
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
                if (KeyEvent.VK_D == e.getKeyCode()){
                    campoS_N2.setText("D");
                }
                if(KeyEvent.VK_H == e.getKeyCode()){
                    campoS_N2.setText("H");
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
        
        campoS_N4 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N4.setVisible(false);
        campoS_N4.setBorder(new LineBorder(Color.BLACK, 3));
        campoS_N4.setBackground(new Color(255, 210, 0));
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
        campoS_N4.setForeground(Color.BLACK);
        
        campoS_N5 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N5.setVisible(false);
        campoS_N5.setBorder(new LineBorder(Color.BLACK, 3));
        campoS_N5.setBackground(new Color(255, 210, 0));
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
        campoS_N5.setForeground(Color.BLACK);
        
        campoS_N6 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N6.setVisible(false);
        campoS_N6.setBorder(new LineBorder(Color.BLACK, 3));
        campoS_N6.setBackground(new Color(255, 210, 0));
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
        campoS_N6.setForeground(Color.BLACK);
        
        campoS_N7 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N7.setVisible(false);
        campoS_N7.setBorder(new LineBorder(Color.BLACK, 3));
        campoS_N7.setBackground(new Color(255, 210, 0));
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
        campoS_N7.setForeground(Color.BLACK);
        
        campoS_N8 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N8.setVisible(false);
        campoS_N8.setBorder(new LineBorder(Color.BLACK, 3));
        campoS_N8.setBackground(new Color(255, 210, 0));        
        campoS_N8.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoS_N8.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoS_N8.setText("N");
                }
            }
        });
        campoS_N8.setForeground(Color.BLACK);
        
        campoS_N9 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N9.setVisible(false);
        campoS_N9.setBorder(new LineBorder(Color.BLACK, 3));
        campoS_N9.setBackground(new Color(255, 210, 0));        
        campoS_N9.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoS_N9.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoS_N9.setText("N");
                }
            }
        });
        campoS_N9.setForeground(Color.BLACK);
    }
    private void construirPanelComprobante(Area a){
        primerPanelC = new IUPanel(panelComprobante, new Area(a.X(), a.Y(), a.An(), a.AlP(5)), false);
        construirPrimerPanelC(new Area(2, 2, primerPanelC.area.An() - 20, primerPanelC.area.Al() - 4));
        
        segundoPanelC = new IUPanel(panelComprobante, new Area(a.X(), a.Y(2) + a.AlP(5), a.An(), a.AlP(10)), false);
        construirSegundoPanelC(new Area(2, 2, segundoPanelC.area.An() - 12, segundoPanelC.area.Al() - 6));
        
        tercerPanelC = new IUPanel(panelComprobante, new Area(a.X(), a.Y(3) + a.AlP(15), a.An(), a.AlP(15)), false);
        construirTercerPanelC(new Area(2, 2, tercerPanelC.area.An() - 14, tercerPanelC.area.Al() - 6));
                        
        iuTituloMensaje = new IUEtiqueta(panelComprobante, "↓", new Area(a.X(), a.Y(4) + a.AlP(30), a.AnP(3), a.AlP(5)), 20, "CENTER", Ayuda.COLOR_ROJO);
        iuTituloMensaje.setFont(new Font("Arial", Font.BOLD, 25));
        iuTituloMensaje = new IUEtiqueta(panelComprobante, "↓", new Area(a.X(2) + a.AnP(3), a.Y(4) + a.AlP(30), a.AnP(10), a.AlP(5)), 20, "CENTER", Ayuda.COLOR_ROJO);
        iuTituloMensaje.setFont(new Font("Arial", Font.BOLD, 25));
        iuTituloMensaje = new IUEtiqueta(panelComprobante, "↓", new Area(a.X(3) + a.AnP(13), a.Y(4) + a.AlP(30), a.AnP(63), a.AlP(5)), 20, "CENTER", Ayuda.COLOR_ROJO);
        iuTituloMensaje.setFont(new Font("Arial", Font.BOLD, 25));
        iuTituloMensaje = new IUEtiqueta(panelComprobante, "↓", new Area(a.X(4) + a.AnP(76), a.Y(4) + a.AlP(30), a.AnP(8), a.AlP(5)), 20, "CENTER", Ayuda.COLOR_ROJO);
        iuTituloMensaje.setFont(new Font("Arial", Font.BOLD, 25));
        iuTituloMensaje = new IUEtiqueta(panelComprobante, "↓", new Area(a.X(5) + a.AnP(84), a.Y(4) + a.AlP(30), a.AnP(8), a.AlP(5)), 20, "CENTER", Ayuda.COLOR_ROJO);
        iuTituloMensaje.setFont(new Font("Arial", Font.BOLD, 25));
        iuTituloMensaje = new IUEtiqueta(panelComprobante, "↓", new Area(a.X(6) + a.AnP(92), a.Y(4) + a.AlP(30), a.AnP(8), a.AlP(5)), 20, "CENTER", Ayuda.COLOR_ROJO);
        iuTituloMensaje.setFont(new Font("Arial", Font.BOLD, 25));
        
        quintoPanelC = new IUPanel(panelComprobante, new Area(a.X(), a.Y(5) + a.AlP(35), a.An(), a.AlP(65)), false);//82
        construirQuintoPanelC(new Area(2, 2, quintoPanelC.area.An() - 10, quintoPanelC.area.Al() - 6));
    }
    private void construirPrimerPanelC(Area a){
        iuEtiquetaTipDoc = new IUPanelEtiqueta(primerPanelC, new Area(a.X(), a.Y(), a.AnP(13), a.Al()), "Tipo Documento: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuEtiquetaTipDoc.setVisible(false);
        iuTipDoc = new IUComboBox(primerPanelC, Ayuda.aOpciones(Ayuda.getListColumnas("DESCRI", "SELECT DESCRI FROM TABVAR WHERE TIPO = 2 AND (NUMERO >= 1 AND NUMERO <= 3)"), "- Elija -"), new Area(a.X(2) + a.AnP(13), a.Y(), a.AnP(10), a.Al()), 16, 30);
        iuTipDoc.setEditar(false);
        iuTipDoc.setFont(new Font("Verdana", Font.PLAIN, 16));
        iuTipDoc.setVisible(false);
        
        iuEtiquetaDoc = new IUPanelEtiqueta(primerPanelC, new Area(a.X(3) + a.AnP(23), a.Y(), a.AnP(13), a.Al()), "DOCUMENTO de: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuDoc = new IUCampoTexto(primerPanelC, 30, 16, new Area(a.X(4) + a.AnP(36), a.Y(), a.AnP(9), a.Al()), SwingConstants.CENTER);
        iuDoc.setEditar(false);
        iuDoc.setFont(new Font("Verdana", Font.BOLD, 16));
        iuDoc.setText("DIARIOS");
        
        iuEtiquetaNum = new IUPanelEtiqueta(primerPanelC, new Area(a.X(5) + a.AnP(45), a.Y(), a.AnP(7), a.Al()), "No.: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuNum = new IUCampoTexto(primerPanelC, 8, 16, new Area(a.X(6) + a.AnP(52), a.Y(), a.AnP(7), a.Al()), SwingConstants.CENTER);
        iuNum.setFont(new Font("Verdana", Font.BOLD, 16));
        iuNum.setRestriccion("^([0-9]|[1-9][0-9])$");
        
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
        iuTipCam.setTextoD(String.valueOf(usuario.getTipcam()));
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
        iuEtiquetaNro = new IUPanelEtiqueta(tercerPanelC, new Area(a.X(), a.Y(), a.AnP(3), a.AlP(28)), "No", 14, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);        
        iuNro = new IUCampoTexto(tercerPanelC, 1, 16, new Area(a.X(), a.Y() + a.AlP(28), a.AnP(3), a.AlP(33)), SwingConstants.CENTER);
        //iuNro.setEditar(false);
        
        iuEtiquetaCodigo = new IUPanelEtiqueta(tercerPanelC, new Area(a.X(2) + a.AnP(3), a.Y(), a.AnP(10), a.AlP(28)), "CODIGO", 14, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuCodigo = new IUCampoTexto(tercerPanelC, 8, 16, new Area(a.X(2) + a.AnP(3), a.Y() + a.AlP(28), a.AnP(10), a.AlP(33)), SwingConstants.CENTER);
        iuCodigo.setEditar(false);
        iuCodigo.setRestriccion("^([0-9]|[1-9][0-9])$");
        
        iuEtiquetaDescripcion = new IUPanelEtiqueta(tercerPanelC, new Area(a.X(3) + a.AnP(13), a.Y(), a.AnP(63), a.AlP(28)), "DESCRIPCION DE CUENTA", 14, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuDescripcion = new IUCampoTexto(tercerPanelC, 0, 16, new Area(a.X(3) + a.AnP(13), a.Y() + a.AlP(28), a.AnP(63), a.AlP(33)), SwingConstants.LEFT);
        iuDescripcion.setEditar(false);
        
        iuEtiquetaDebe = new IUPanelEtiqueta(tercerPanelC, new Area(a.X(4) + a.AnP(76), a.Y(), a.AnP(8), a.AlP(28)), "DEBE", 14, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuDebe = new IUCampoTexto(tercerPanelC, 12, 16, new Area(a.X(4) + a.AnP(76), a.Y() + a.AlP(28), a.AnP(8), a.AlP(33)), SwingConstants.CENTER);
        iuDebe.setRestriccionNumeroDecimal(2);
        iuDebe.setEditar(false);
        
        iuEtiquetaHaber = new IUPanelEtiqueta(tercerPanelC, new Area(a.X(5) + a.AnP(84), a.Y(), a.AnP(8), a.AlP(28)), "HABER", 14, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuHaber = new IUCampoTexto(tercerPanelC, 12, 16, new Area(a.X(5) + a.AnP(84), a.Y() + a.AlP(28), a.AnP(8), a.AlP(33)), SwingConstants.CENTER);
        iuHaber.setEditar(false);
        iuHaber.setRestriccionNumeroDecimal(2);
        
        iuEtiquetaMontoDolares = new IUPanelEtiqueta(tercerPanelC, new Area(a.X(6) + a.AnP(92), a.Y(), a.AnP(8), a.AlP(28)), "MONTO $us", 14, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuDolares = new IUCampoTexto(tercerPanelC, 12, 16, new Area(a.X(6) + a.AnP(92), a.Y() + a.AlP(28), a.AnP(8), a.AlP(33)), SwingConstants.CENTER);
        iuDolares.setEditar(false);
        iuDolares.setRestriccionNumeroDecimal(2);
        /**********/
        
        iuEtiquetaConcepto = new IUPanelEtiqueta(tercerPanelC, new Area(a.X(), a.Y(2) + a.AlP(65), a.AnP(10), a.AlP(34)), "Por Concepto: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuConcepto = new IUCampoTexto(tercerPanelC, "", 16, new Area(a.X(2) + a.AnP(10), a.Y(2) + a.AlP(65), a.AnP(90) + a.X(3), a.AlP(34)));
        iuConcepto.setFont(new Font("Verdana", Font.BOLD, 16));
        
        /*iuAreaGlosa = new IUAreaTexto(tercerPanelC, new Area(a.X(2) + a.AnP(10), a.Y(2) + a.AlP(25), a.AnP(70), a.AlP(75) + a.Y(2)), "", 16);
        iuAreaGlosa.setFont(new Font("Verdana", Font.BOLD, 16));        
        iuAreaGlosa.setVisible(false);
        
        iuEtiquetaCuenta = new IUPanelEtiqueta(tercerPanelC, new Area(a.X(3) + a.AnP(80), a.Y(2) + a.AlP(25), a.AnP(10), a.AlP(25)), " Cuenta Cte.:", 16, SwingConstants.LEFT, Ayuda.COLOR_FONDO, true);
        iuCuenta = new IUCampoTexto(tercerPanelC, 10, 16, new Area(a.X(4) + a.AnP(90), a.Y(2) + a.AlP(25), a.AnP(10), a.AlP(25)), SwingConstants.LEFT);
        iuCuenta.setFont(new Font("Verdana", Font.BOLD, 16));
        iuEtiquetaBanco = new IUPanelEtiqueta(tercerPanelC, new Area(a.X(3) + a.AnP(80), a.Y(3) + a.AlP(50), a.AnP(10), a.AlP(25)), " Banco.:", 16, SwingConstants.LEFT, Ayuda.COLOR_FONDO, true);        
        iuBanco = new IUCampoTexto(tercerPanelC, "", 16, new Area(a.X(4) + a.AnP(90), a.Y(3) + a.AlP(50), a.AnP(10), a.AlP(25)));
        iuBanco.setFont(new Font("Verdana", Font.BOLD, 16));
        iuEtiquetaCheque = new IUPanelEtiqueta(tercerPanelC, new Area(a.X(3) + a.AnP(80), a.Y(4) + a.AlP(75), a.AnP(10), a.AlP(25)), " Cheque No.:", 16, SwingConstants.LEFT, Ayuda.COLOR_FONDO, true);
        iuCheque = new IUCampoTexto(tercerPanelC, 10, 16, new Area(a.X(4) + a.AnP(90), a.Y(4) + a.AlP(75), a.AnP(10), a.AlP(25)), SwingConstants.LEFT);
        iuCheque.setFont(new Font("Verdana", Font.BOLD, 16));
        
        iuEtiquetaCuenta.setVisible(false);
        iuCuenta.setVisible(false);
        iuEtiquetaBanco.setVisible(false);
        iuBanco.setVisible(false);
        iuEtiquetaCheque.setVisible(false);
        iuCheque.setVisible(false);*/
    }
    private void construirQuintoPanelC(Area a){
        iuTabla = new IUTabla(
        quintoPanelC,
        new Area(a.X(), a.Y(), a.An() + a.X(3), a.AlP(93)), 
        new String[]{"No", "CODIGO", "DESCRIPCION DE CUENTA", "GLOSA DE ASIENTO", "DEBE", "HABER", "MONTO $us"}, 
        new Class[]{Integer.class, Long.class, String.class, String.class, Double.class, Double.class, Double.class}, 
        new int[]{3, 10, 30, 33, 8, 8, 8}, 
        new ArrayList(), 
        new ModeloTabla<Asiento>(){
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return lista.get(rowIndex).getNro();
                    case 1:
                        return lista.get(rowIndex).getCodigo();
                    case 2:
                        return lista.get(rowIndex).getCuenta();
                    case 3:
                        return lista.get(rowIndex).getConcepto();
                    case 4:
                        return lista.get(rowIndex).getDebe();
                    case 5:
                        return lista.get(rowIndex).getHaber();
                    case 6:
                        return lista.get(rowIndex).getMonto();
                    default:
                        return null;
                }
            }
        });
        iuTabla.setPosicionTextoHorizontal(2, SwingConstants.LEFT);
        iuTabla.setPosicionTextoHorizontal(3, SwingConstants.LEFT);
        iuTabla.setPosicionTextoHorizontal(4, SwingConstants.RIGHT);
        iuTabla.setPosicionTextoHorizontal(5, SwingConstants.RIGHT);
        iuTabla.setPosicionTextoHorizontal(6, SwingConstants.RIGHT);
        iuTabla.setBackground(Ayuda.COLOR_ATENCION);        
        
        iuTotalComprobante = new IUEtiqueta(quintoPanelC, "Total Comprobante (en Bolivianos)    ", new Area(a.X() + a.AnP(20), a.Y(2) + a.AlP(93), a.AnP(50), a.AlP(7)), 16, "RIGHT", Ayuda.COLOR_ROJO);
        iuTotalDebe = new IUEtiqueta(quintoPanelC, "0.00", new Area(a.X(2) + a.AnP(70), a.Y(2) + a.AlP(93), a.AnP(10), a.AlP(7)), 18, "RIGHT", true);
        iuTotalDebe.setBorder(new LineBorder(Color.BLUE));
        iuTotalHaber = new IUEtiqueta(quintoPanelC, "0.00", new Area(a.X(3) + a.AnP(80), a.Y(2) + a.AlP(93), a.AnP(10), a.AlP(7)), 18, "RIGHT", true);
        iuTotalHaber.setBorder(new LineBorder(Color.BLUE));
        iuTotalDolares = new IUEtiqueta(quintoPanelC, "0.00", new Area(a.X(4) + a.AnP(90), a.Y(2) + a.AlP(93), a.AnP(10), a.AlP(7)), 18, "RIGHT", true);
        iuTotalDolares.setBorder(new LineBorder(Color.BLUE));        
    }
    
    private void algoritmoInicial(){
        //restringirCampos("TIPDOC", true);
        //focoCampoTipoDocumento();
        seleccionarTipoDocumento("DIARIOS");
        focoCampoNumero();
        
        panel.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "ESC" );
        panel.getActionMap().put( "ESC", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){
                dispose();
            }
        });
    }
    
    private void restringirCampos(String campo, boolean state){        
        iuTipDoc.setEditar(false);
        iuMonto.setEditar(false);
        iuDocRef.setEditar(false);
        iuTipCam.setEditar(false);
        iuConcepto.setEditar(false);        
        //iuAreaGlosa.setEditable(false);
        //iuCuenta.setEditar(false);
        //iuBanco.setEditar(false);        
        //iuCheque.setEditar(false);
        iuNro.setEditar(false);
        iuCodigo.setEditar(false);
        iuDescripcion.setEditar(false);
        iuDebe.setEditar(false);
        iuHaber.setEditar(false);
        iuDolares.setEditar(false);
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
            case"TIPCAM":
                iuTipCam.setEditar(state);
            break;
            case"CONCEPTO":
                iuConcepto.setEditar(state);
            break;
            /*case"GLOSA":
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
            break;*/
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
                iuDolares.setEditar(state);
            break;
            default:                
            break;
        }
    }
    private void pintarBordeCampo(String campo){
        Border borde = new LineBorder(Color.blue, 2);        
        
        iuTipDoc.setBorder(iuTipDoc.getBordeComponente());
        iuNum.setBorder(iuNum.getBordeComponente());
        iuMonto.setBorder(iuMonto.getBordeComponente());
        iuDocRef.setBorder(iuDocRef.getBordeComponente());
        iuTipCam.setBorder(iuTipCam.getBordeComponente());
        iuConcepto.setBorder(iuConcepto.getBordeComponente());
        //iuAreaGlosa.setBorder(iuAreaGlosa.getBordeComponente());
        //iuCuenta.setBorder(iuCuenta.getBordeComponente());
        //iuBanco.setBorder(iuBanco.getBordeComponente());
        //iuCheque.setBorder(iuCheque.getBordeComponente());
        
        iuNro.setBorder(iuNro.getBordeComponente());
        iuNro.setEditar(false);
        iuCodigo.setBorder(iuCodigo.getBordeComponente());
        iuCodigo.setEditar(false);
        iuDescripcion.setBorder(iuDescripcion.getBordeComponente());
        iuDescripcion.setEditar(false);
        iuDebe.setBorder(iuDebe.getBordeComponente());
        iuDebe.setEditar(false);
        iuHaber.setBorder(iuHaber.getBordeComponente());
        iuHaber.setEditar(false);
        iuDolares.setBorder(iuDolares.getBordeComponente());
        iuDolares.setEditar(false);
        iuTabla.setSelectionBackground(iuTabla.getSelectionBackground());
        iuTabla.setEnabled(false);
        switch(campo){
            case"TIPDOC":
                iuTipDoc.setBorder(borde);
            break;
            case"NUM":
                iuNum.setBorder(borde);
            break;
            case"MONTO":
                iuMonto.setBorder(borde);
            break;
            case"DOCREF":
                iuDocRef.setBorder(borde);
            break;
            case "TIPCAM":
                iuTipCam.setBorder(borde);
            break;
            case"CONCEPTO":
                iuConcepto.setBorder(borde);
            break;
            /*case"GLOSA":
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
            break;*/
            case "TABLA": 
                iuTabla.setSelectionBackground(Color.GREEN);
                iuTabla.setEnabled(true);
            break;
            case "NRO":
                iuNro.setBorder(borde);
                iuNro.setEditar(true);
            break;
            case "CODIGO":
                iuCodigo.setBorder(borde);
                iuCodigo.setEditar(true);
            break;
            case "DESCRIPCION":
                iuDescripcion.setBorder(borde);
                iuDescripcion.setEditar(true);
            break;
            case "DEBE":
                iuDebe.setBorder(borde);
                iuDebe.setEditar(true);
            break;
            case "HABER":
                iuHaber.setBorder(borde);
                iuHaber.setEditar(true);
            break;
            case "MONTO_DOLARES":
                iuDolares.setBorder(borde);
                iuDolares.setEditar(true);
            break;
            default:
            break;
        }        
    }
    private void focoCampoTipoDocumento(){
        pintarBordeCampo("TIPDOC");
        deshabilitarCampoS_N();        
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
                        focoCampoNumero();
                    }
                }
            }
        });
    }
    
    private void seleccionarTipoDocumento(String tipdoc){
        boolean encontro = false;
        int contador = 0;
        while(contador < listaTabvar.size() && !encontro){
            tabvar = listaTabvar.get(contador);            
            if(tabvar.getTipo() == 2){                
                if(tabvar.getDescri().equalsIgnoreCase(tipdoc)){
                    switch(tipdoc){
                        case "INGRESOS":
                            iuEtiquetaDocRef.setTexto("Recibido de: ");
                            iuDocRef.setText("");
                        break;
                        case "EGRESOS":
                            iuEtiquetaDocRef.setTexto("Pagado a: ");
                            iuDocRef.setText("");
                        break;
                        case "DIARIOS":
                            iuEtiquetaDocRef.setTexto("Por Concepto: ");
                            iuDocRef.setText(Ayuda.getDatoCadena("DESCRI", "select * from tabvar where tipo = 10 and numero = 1"));
                        break;
                    }
                    encontro = true;
                    iuDoc.setText(tabvar.getDescri());
                    //if(iuNum.getText().isEmpty())
                        iuNum.setText(String.valueOf(tabvar.getCorrel()));
                }
            }
            contador++;
        }
    }
    private void focoCampoNumero(){
        pintarBordeCampo("NUM");  
        deshabilitarCampoS_N();
        iuNum.setEditar(true);        
        iuNum.requestFocus();        
        iuMensaje.setTexto("CAMPO NUMERO: Digite un NUMERO de DOCUMENTO DE RESPALDO para la visualizacion.");
        iuInformacion.setTexto(" ATENCION: ENTER=Avanzar, ESC=Suspender");
        iuNum.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!iuNum.getText().isEmpty()){
                        if(CContra.getContra("SELECT * FROM CONTRA WHERE NUMCOM = "+iuNum.getText()) != null)
                            focoCampoS_N7();
                        else
                            focoCampoMonto();
                    }else
                        focoCampoMonto();
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    //focoCampoTipoDocumento();
                }
            }
        });
    }
    private void focoCampoS_N7(){
        restringirCampos("", false);
        deshabilitarCampoS_N();
        pintarBordeCampo("");
        actualizarPaneles();
        campoS_N7.setVisible(true);
        campoS_N7.setEditar(true);
        campoS_N7.requestFocus();
        campoS_N7.setText("S");
        iuMensaje.setColores(Color.BLACK, new Color(255, 210, 0));
        iuMensaje.setTexto("Desea Recuperar el ASIENTO. ?    S/N");
        iuInformacion.setVisible(false);
        campoS_N7.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N7.getText()){
                        case "S":
                            recuperarAsiento();
                            focoCampoS_N8();
                        break;
                        case "N":
                            inhabilitarCampos(true);
                            focoCampoNumero();
                            //focoCampoTipoDocumento();
                        break;
                        default:
                        break;
                    }
                }                
            }
        });
    }
    private void focoCampoS_N8(){
        restringirCampos("", false);
        deshabilitarCampoS_N();
        pintarBordeCampo("");
        actualizarPaneles();
        campoS_N8.setVisible(true);
        campoS_N8.setEditar(true);
        campoS_N8.requestFocus();
        campoS_N8.setText("S");
        iuMensaje.setColores(Color.BLACK, new Color(255, 210, 0));
        iuMensaje.setTexto("Desea Modificar el ASIENTO. ?    S/N");
        iuInformacion.setVisible(false);
        campoS_N8.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N8.getText()){
                        case "S":
                            campoModificables();
                            focoCampoMonto();
                        break;
                        case "N":
                            focoCampoS_N9();
                        break;
                        default:
                        break;
                    }
                }                
            }            
        });
    }
    private void focoCampoS_N9(){
        restringirCampos("", false);
        deshabilitarCampoS_N();
        pintarBordeCampo("");
        actualizarPaneles();
        campoS_N9.setVisible(true);
        campoS_N9.setEditar(true);
        campoS_N9.requestFocus();
        campoS_N9.setText("N");
        iuMensaje.setColores(Color.BLACK, new Color(255, 210, 0));
        iuMensaje.setTexto("Entonces Desea Eliminar el ASIENTO. ?    S/N");
        iuInformacion.setVisible(false);
        campoS_N9.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N9.getText()){
                        case "S":
                            Ayuda.mensaje(ventanaPrincipal, "Error: USTED NO PUEDE ELIMINAR EL ASIENTO. DEBE REALIZAR CONTRA ASIENTOS, PARA ESTA PROCEDEMIENTO.", "error");
                            actualizarPaneles();
                            inhabilitarCampos(true);
                            limpiarCampos();
                            focoCampoNumero();
                        break;
                        case "N":
                            actualizarPaneles();
                            inhabilitarCampos(true);
                            limpiarCampos();
                            focoCampoNumero();
                        break;
                        default:
                        break;
                    }
                }                
            }            
        });
    }
    private void focoCampoMonto(){
        pintarBordeCampo("MONTO");
        deshabilitarCampoS_N();
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
                            iuMonto.setTextoD(iuMonto.getText());
                            focoCampoDocRef();
                        }
                    }
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    if(!modificable)
                        focoCampoNumero();
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
                        focoTipoCambio();
                    }
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoMonto();
                }
            }
        });
    }
    private void focoTipoCambio(){
        pintarBordeCampo("TIPCAM");
        iuTipCam.setEditar(true);
        iuTipCam.requestFocus();
        iuMensaje.setTexto("Digite el TIPO de CAMBIO.");
        iuInformacion.setTexto(" ATENCION: ENTER=Avanzar, F2=Retroceder, F6=Anterior, F7=Actual, F8=Vigente a la FECHA, ESC=Suspender");
        iuTipCam.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!iuTipCam.getText().isEmpty()){
                        tipoCampbio = iuTipCam.getText();
                        campoS_N1();
                    }
                }
                if(KeyEvent.VK_F6 == e.getKeyCode()){
                    if(!tipoCampbio.isEmpty()){
                        iuTipCam.setTextoD(tipoCampbio);
                        campoS_N1();
                    }
                }
                if(KeyEvent.VK_F7 == e.getKeyCode()){
                    iuTipCam.setTextoD(String.valueOf(usuario.getTipcam()));
                    campoS_N1();
                }
                if(KeyEvent.VK_F8 == e.getKeyCode()){
                    iuTipCam.setTextoD(String.valueOf(Ayuda.getDatoDecimal("monto", "SELECT MONTO FROM TABVAR WHERE TIPO = 17 AND NUMERO = 3")));
                    tipoCampbio = iuTipCam.getText();
                    campoS_N1();
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoDocRef();
                }
            }
        });
    }
    private void focoCampoConcepto(){
        pintarBordeCampo("CONCEPTO");        
        iuConcepto.setEnabled(true);
        iuConcepto.setEditar(true);
        iuConcepto.requestFocus();
        
        iuConcepto.setText(concepto);
        
        iuMensaje.setTexto("CAMPO CONCEPTO: Indique el concepto del documento");
        iuInformacion.setTexto(" ATENCION: ENTER=Avanzar, F2=Retroceder, ESC=Suspender");
        iuConcepto.setText(concepto);
        iuConcepto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!iuConcepto.getText().isEmpty()){
                        concepto = iuConcepto.getText();
                        focoCampoS_N3();
                    }
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoNro();
                }
            }
        });
    }
    
    private void campoS_N1(){
        restringirCampos("", false);
        pintarBordeCampo("");
        campoS_N1.setVisible(true);
        campoS_N1.setEditar(true);
        campoS_N1.requestFocus();
        campoS_N1.setText("S");
        iuMensaje.setColores(Color.BLACK, new Color(255, 210, 0));
        iuMensaje.setTexto("Esta CONFORME con los Datos Generales del Asiento Contable. ?    S/N");
        iuInformacion.setVisible(false);
        campoS_N1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    iuMensaje.setColores(Color.WHITE, new Color(41, 66, 99));
                    iuInformacion.setVisible(true);
                    switch(campoS_N1.getText()){
                        case "S":
                            actualizarPaneles();
                            inhabilitarCampos(false);
                            focoCampoNro();
                        break;
                        case "N":
                            campoModificables();
                            focoCampoMonto();
                        break;                            
                        default:
                        break;
                    }
                }
            }
        });
    }
    private void deshabilitarCampoS_N(){
        campoS_N1.setEditar(false);
        campoS_N1.setVisible(false);
        campoS_N2.setEditar(false);
        campoS_N2.setVisible(false);
        campoS_N3.setEditar(false);
        campoS_N3.setVisible(false);
        campoS_N4.setEditar(false);
        campoS_N4.setVisible(false);
        campoS_N5.setEditar(false);
        campoS_N5.setVisible(false);
        campoS_N6.setEditar(false);
        campoS_N6.setVisible(false);
        campoS_N7.setEditar(false);
        campoS_N7.setVisible(false);
        campoS_N8.setEditar(false);
        campoS_N8.setVisible(false);
        campoS_N9.setEditar(false);
        campoS_N9.setVisible(false);
        iuInformacion.setVisible(true);
        iuInformacion.setColores(Color.BLACK, new Color(255, 210, 0));
        iuMensaje.setColores(Color.WHITE, new Color(41, 66, 99));
    }
    private void inhabilitarCampos(boolean foco){
        iuTipDoc.setEnabled(foco);
        iuMonto.setEnabled(foco);
        iuDoc.setEnabled(foco);
        iuNum.setEnabled(foco);
        iuDocRef.setEnabled(foco);
        iuNumLiteral.setEnabled(foco);
        iuConcepto.setEnabled(foco);
        iuTipCam.setEnabled(foco);
        //iuAreaGlosa.setEnabled(foco);
        //iuCuenta.setEnabled(foco);
        //iuBanco.setEnabled(foco);
        //iuCheque.setEnabled(foco);
    }
    private void habilitarCamposModificar(){
        switch(iuTipDoc.getTexto()){
            case "INGRESOS":
                //iuCuenta.setEnabled(false);
                //iuBanco.setEnabled(false);
                //iuCheque.setEnabled(false);
            break;
            default:
                //iuCuenta.setEnabled(true);
                //iuBanco.setEnabled(true);
                //iuCheque.setEnabled(true);                
            break;
        }
        iuMonto.setEnabled(true);        
        iuDocRef.setEnabled(true);
        iuNumLiteral.setEnabled(true);
        iuConcepto.setEnabled(true);
        iuTipCam.setEnabled(true);
        //iuAreaGlosa.setEnabled(true);
    }
    
    private void actualizarPaneles(){        
        asiento.setTipoDoc(iuTipDoc.getSelectedItem().toString());
        asiento.setDoc(iuDoc.getText());
        asiento.setNumero(iuNum.getText());
        asiento.setMontoIncial(iuMonto.getText());
        asiento.setOrigen(iuDocRef.getText());
        asiento.setMontoLiteral(iuNumLiteral.getText());        
        asiento.setConcepto(iuConcepto.getText());
        //asiento.setDescripcion(iuAreaGlosa.getText());
        //asiento.setNroCuenta(iuCuenta.getText());
        //asiento.setBanco(iuBanco.getText());
        //asiento.setCheque(iuCheque.getText());
        
        asiento.setLista(iuTabla.modeloTabla.lista);
        
        if(!iuNro.getText().isEmpty() && !iuCodigo.getText().isEmpty() && !iuDescripcion.getText().isEmpty()){
            asiento.setNro(Integer.parseInt(iuNro.getText()));
            asiento.setCodigo(Long.parseLong(iuCodigo.getText()));
            asiento.setCuenta(iuDescripcion.getText());            
            asiento.setDebe(0);
            asiento.setHaber(0);
            asiento.setMonto(0);
        }
        if(!iuDebe.getText().isEmpty())
            asiento.setDebe(Double.parseDouble(iuDebe.getText()));
        if(!iuHaber.getText().isEmpty())
            asiento.setHaber(Double.parseDouble(iuHaber.getText()));
        if(!iuDolares.getText().isEmpty())
            asiento.setMonto(Double.parseDouble(iuDolares.getText()));
        
        panel.removeAll();        
        construirPaneles(new Area(2, 2, panel.area.An() - 4, panel.area.Al() - 4));
        iuTabla.modeloTabla.fireTableDataChanged();
        panel.updateUI();
        
        iuTipDoc.setSelectedItem(asiento.getTipoDoc());
        iuDoc.setText(asiento.getDoc());
        iuNum.setText(String.valueOf(asiento.getNumero()));
        iuMonto.setText(String.valueOf(asiento.getMontoIncial()));
        iuDocRef.setText(asiento.getOrigen());
        iuNumLiteral.setText(asiento.getMontoLiteral());
        iuConcepto.setText(asiento.getConcepto());
        //iuAreaGlosa.setText(asiento.getDescripcion());
        //iuCuenta.setText(String.valueOf(asiento.getNroCuenta()));
        //iuBanco.setText(asiento.getBanco());
        //iuCheque.setText(String.valueOf(asiento.getCheque()));
        iuNro.setText(String.valueOf(asiento.getNro()));
        iuCodigo.setText(String.valueOf(asiento.getCodigo()));
        iuDescripcion.setText(asiento.getCuenta());
        iuDebe.setText(String.valueOf(asiento.getDebe()));
        iuHaber.setText(String.valueOf(asiento.getHaber()));
        iuDolares.setText(String.valueOf(asiento.getMonto()));  
        
        iuTabla.actualizarTabla(asiento.getLista());
        indice = iuTabla.modeloTabla.getRowCount() + 1;
        sumarColumnasTotales();
        inhabilitarCampos(false);
        switch(iuTipDoc.getSelectedItem().toString()){
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
    }
    
    //funcionalidad del programa
    private void focoCampoNro(){
        pintarBordeCampo("NRO");
        deshabilitarCampoS_N();
        
        iuNro.setEditar(true);
        iuNro.requestFocus();        
        
        iuMensaje.setTexto("CAMPO No: REGISTRO DEL COMPROBANTE.");
        iuInformacion.setTexto(" ATENCION: ENTER=Avanzar, F7=Finalizar, ESC=Suspender");
        iuNro.setText(String.valueOf(indice));        
        iuNro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){                    
                    focoCampoCodigo();
                }
                if(KeyEvent.VK_F7 == e.getKeyCode()){                    
                    if(!iuMonto.getText().isEmpty() && !iuTotalDebe.getText().isEmpty() && !iuTotalHaber.getText().isEmpty() && !iuTotalDolares.getText().isEmpty()){
                        double montoTotal = Double.parseDouble(iuMonto.getText());
                        double debeTotal = Double.parseDouble(iuTotalDebe.getText());
                        double haberTotal = Double.parseDouble(iuTotalHaber.getText());
                        double dolaresTotal = Double.parseDouble(iuTotalDolares.getText());
                        if((montoTotal == debeTotal && montoTotal  == haberTotal)){ // && dolaresTotal == 0
                            actualizarPaneles();
                            if(!modificable){
                                if(Ayuda.mensaje(ventanaPrincipal, "Se ha detectado una CUADRATURA del MONTO DEBE Y HABER CORRECTAMENTE, desea GUARDAR EL ASIENTO.?", "pregunta")){
                                    if(!getEstado()){
                                        setEstado(true);
                                        guardarContra();
                                        actualizarPaneles();
                                        Ayuda.mensaje(ventanaPrincipal, "Se ha GUARDADO CORRECTAMENTE...!", "correcto");   
                                        actualizarPaneles();
                                        dispose();
                                    }
                                }else
                                    focoCampoNro();
                            }else{
                                if(Ayuda.mensaje(ventanaPrincipal, "Se ha detectado una CUADRATURA del MONTO DEBE Y HABER CORRECTAMENTE, desea MODIFICAR EL ASIENTO.?", "pregunta")){
                                    if(!getEstado()){
                                        setEstado(true);
                                        desmayorizar();
                                        actualizarPaneles();
                                        modificarContra();
                                        guardarContra();
                                        Ayuda.mensaje(ventanaPrincipal, "Se ha MODIFICADO CORRECTAMENTE...!", "correcto");   
                                        actualizarPaneles();
                                        dispose();
                                    }
                                }
                            }                            
                        }else{
                            Ayuda.mensaje(ventanaPrincipal, "No puede Finalizar. por que EXISTE UN DESCUADRE en los TOTALES.", "error");
                        }
                    }
                }
            }
        });
    }
    private void focoCampoCodigo(){        
        iuNro.setText(String.valueOf(indice));
        deshabilitarCampoS_N();
        pintarBordeCampo("CODIGO");        
        iuCodigo.setEditar(true);
        iuCodigo.requestFocus();
        iuMensaje.setTexto("CAMPO CODIGO: Puede elegir Asientos Tipo o consultar a la Ayuda.");
        if(indice > 1)
            iuInformacion.setTexto(" ATENCION: ENTER=Avanzar, F1=Ayuda, F2=Retrocede, F10=BANCO, ESC=Suspender o Finalizar");
        else
            iuInformacion.setTexto(" ATENCION: ENTER=Avanzar, F1=Ayuda, F2=Retrocede, F8=ASIENTOS TIPO, ESC=Suspender o Finalizar");        
        iuCodigo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!iuCodigo.getText().isEmpty()){
                        if(!Ayuda.getDatoCadena("CUETOT", "SELECT CUETOT FROM CONMAE WHERE CUETOT = "+iuCodigo.getText()+" AND ACTIVI = 2").isEmpty()){
                            iuDescripcion.setText(Ayuda.getDatoCadena("descri", "SELECT DESCRI FROM CONMAE WHERE CUETOT = "+iuCodigo.getText()));
                            focoCampoS_N2();
                        }
                    }
                }                
                if(KeyEvent.VK_UP == e.getKeyCode() || KeyEvent.VK_DOWN == e.getKeyCode()){
                    if(!iuTabla.modeloTabla.isVacia())
                        focoCampoTabla();
                }
                if(KeyEvent.VK_F1 == e.getKeyCode()){
                    Conmae c = new Conmae(indice);
                    setOpacity(0.5f);
                    actualizarPaneles();
                    VAyudaContra iuAyuda = new VAyudaContra(ventanaPrincipal, titulo, "medio-grande", "SELECT * FROM CONMAE WHERE ACTIVI = 2 GROUP BY CUETOT");
                    iuAyuda.mostrarVentana();
                    if(iuAyuda.getEstado()){
                        c = iuAyuda.getConmae();                        
                    }
                    actualizarPaneles();
                    inhabilitarCampos(false);
                    iuNro.setText(String.valueOf(indice));
                    iuCodigo.setText(String.valueOf(c.getCuetot()));
                    iuDescripcion.setText(c.getDescri());
                    iuDebe.setText(String.valueOf(c.getSalini()));
                    iuHaber.setText(String.valueOf(c.getSalin2()));
                    if(!iuDescripcion.getText().isEmpty())
                        focoCampoS_N2();
                    else
                        focoCampoCodigo();
                    setOpacity(1f);
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoNro();
                }
                /*if(KeyEvent.VK_F7 == e.getKeyCode()){
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
                }*/
                if(indice > 1){
                    if(KeyEvent.VK_F10 == e.getKeyCode()){
                        Conmae c = CConmae.getConmae("select * from conmae where CUETOT = 11020100");
                        iuCodigo.setText(String.valueOf(c.getCuetot()));
                        iuDescripcion.setText(c.getDescri());
                        iuDebe.setText("0.0");
                        iuHaber.setText("0.0");
                        iuDolares.setText("0.0");
                        focoCampoS_N2();
                    }
                }else{                    
                    if(KeyEvent.VK_F8 == e.getKeyCode()){
                        setOpacity(0.6f);
                        actualizarPaneles();
                        VAsientoTipo iuAsiento = new VAsientoTipo(ventanaPrincipal, titulo, "intermedio");
                        iuAsiento.mostrarVentana(); 
                        iuTabla.modeloTabla.limpiarTabla();
                        if(iuAsiento.getEstado()){
                            for (Conmae t : iuAsiento.getList()) {
                                Asiento a = new Asiento(indice);
                                a.setCodigo(t.getCuetot());
                                a.setCuenta(t.getDescri());
                                iuTabla.modeloTabla.setFila(a);
                                indice++;
                            }
                        }
                        actualizarPaneles();                        
                        limpiarCamposFila();
                        focoCampoCodigo();
                        setOpacity(1f);
                    }
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
        iuHaber.setBorder(new LineBorder(Color.GREEN));
        iuDolares.setBorder(new LineBorder(Color.GREEN));
        
        iuTabla.setFocusable(true);
        iuTabla.requestFocus();
        
        iuCodigo.setEditar(false);        
        
        iuMensaje.setTexto("CAMPO TABLA: Seleccione el registro que quiere modificar en el DEBE o HABER. (Utilize las teclas de flecha ARRIBA, ABAJO)");
        iuInformacion.setTexto("ATENCION: ENTER=Aceptar Registro, F2=Retroceder, F3=Eliminar Fila, ESC=Suspender o Finalizar");
        
        iuTabla.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if(iuTabla.isFilaSeleccionado()){
                Asiento a = (Asiento) iuTabla.modeloTabla.getFila(iuTabla.getSelectedRow());
                int nro = iuTabla.getSelectedRow() + 1;
                iuNro.setText(String.valueOf(nro));
                iuCodigo.setText(String.valueOf(a.getCodigo()));
                iuDescripcion.setText(a.getCuenta());
                concepto = a.getConcepto();
                iuConcepto.setText(a.getConcepto());
                iuDebe.setText(String.valueOf(a.getDebe()));
                iuHaber.setText(String.valueOf(a.getHaber()));
                iuDolares.setText(String.valueOf(a.getMonto()));
            }
        });
        iuTabla.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        iuTabla.getActionMap().put("Enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(iuTabla.isFilaSeleccionado()){
                    focoCampoS_N2();
                }               
            }
        });
        iuTabla.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    actualizarPaneles();                    
                    focoCampoCodigo();
                }
                if(KeyEvent.VK_F3 == e.getKeyCode()){
                    focoCampoS_N4();
                }
                if(KeyEvent.VK_ADD == e.getKeyCode()){
                    if(!iuTotalDolares.getText().isEmpty() && !iuTotalDebe.getText().isEmpty() && !iuTotalHaber.getText().isEmpty()){
                        if((Double.parseDouble(iuTotalDebe.getText()) == Double.parseDouble(iuTotalHaber.getText())) ){
                            focoCampoS_N5SUMA();
                        }
                    }                    
                }
                if(KeyEvent.VK_SUBTRACT == e.getKeyCode() && !iuTotalDebe.getText().isEmpty() && !iuTotalHaber.getText().isEmpty()){                    
                    if(!iuTotalDolares.getText().isEmpty()){
                        if((Double.parseDouble(iuTotalDebe.getText()) == Double.parseDouble(iuTotalHaber.getText())) ){
                            focoCampoS_N6RESTA();
                        }
                    }                    
                }
            }
        });
    }
    private void focoCampoS_N6RESTA(){
        pintarBordeCampo("");        
        campoS_N6.setVisible(true);
        campoS_N6.setEditar(true);
        campoS_N6.requestFocus();
        campoS_N6.setText("S");
        iuMensaje.setColores(Color.BLACK, new Color(255, 210, 0));
        iuMensaje.setTexto("ATENCION: Esta seguro que desea agregar -0.01 a la fila de la tabla al CAMPO MONTO en DOLARES para el cuadraje correcto?    S/N");
        iuInformacion.setVisible(false);
        campoS_N6.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N6.getText()){
                        case "S":
                            if(iuTabla.isFilaSeleccionado()){                               
                                if(!iuDolares.getText().isEmpty()){
                                    double dolares = Double.parseDouble(iuDolares.getText());
                                    dolares = dolares - 0.01;
                                    iuDolares.setText(String.valueOf(Ayuda.acotarNumero(dolares, 2)));                                    
                                    modificarRegistroTabla();
                                    sumarColumnasTotales();
                                    actualizarPaneles();
                                    //limpiarCamposFila();
                                    focoCampoNro();
                                }
                            }
                        break;
                        case "N":
                            focoCampoTabla();
                        break;
                        default:
                        break;
                    }
                }
            }
        });
    }
    private void focoCampoS_N5SUMA(){
        pintarBordeCampo("");        
        campoS_N5.setVisible(true);
        campoS_N5.setEditar(true);
        campoS_N5.requestFocus();
        campoS_N5.setText("S");
        iuMensaje.setColores(Color.BLACK, new Color(255, 210, 0));
        iuMensaje.setTexto("ATENCION: Esta seguro que desea agregar 0.01 a la fila de la tabla al CAMPO MONTO en DOLARES para el cuadraje correcto?    S/N");
        iuInformacion.setVisible(false);
        campoS_N5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N5.getText()){
                        case "S":
                            if(iuTabla.isFilaSeleccionado()){                               
                                if(!iuDolares.getText().isEmpty()){
                                    double dolares = Double.parseDouble(iuDolares.getText());
                                    dolares = dolares + 0.01;
                                    iuDolares.setText(String.valueOf(Ayuda.acotarNumero(dolares, 2)));
                                    modificarRegistroTabla();
                                    sumarColumnasTotales();
                                    actualizarPaneles();
                                    //limpiarCamposFila();
                                    focoCampoNro();
                                }
                            }
                        break;
                        case "N":
                            focoCampoTabla();
                        break;
                        default:
                        break;
                    }
                }
            }
        });
    }
    private void focoCampoS_N4(){
        pintarBordeCampo("");        
        campoS_N4.setVisible(true);
        campoS_N4.setEditar(true);
        campoS_N4.requestFocus();
        campoS_N4.setText("S");
        iuMensaje.setColores(Color.BLACK, new Color(255, 210, 0));
        iuMensaje.setTexto("ATENCION: Esta seguro que desea eliminar esta FILA de la Tabla SELECCIONADA.?    S/N");
        iuInformacion.setVisible(false);
        
        campoS_N4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N4.getText()){
                        case "S":
                            if(iuTabla.isFilaSeleccionado()){                                
                                iuTabla.modeloTabla.removeFila(iuTabla.getSelectedRow());
                                sumarColumnasTotales();
                                actualizarPaneles();
                                limpiarCamposFila();
                                focoCampoNro();                                
                            }
                        break;
                        case "N":
                            focoCampoTabla();
                        break;
                        default:
                        break;
                    }
                }
            }
        });
    }
    private void focoCampoS_N2(){
        pintarBordeCampo("");
        deshabilitarCampoS_N();
        campoS_N2.setVisible(true);
        campoS_N2.setEditar(true);
        campoS_N2.requestFocus();
        campoS_N2.setText("D");
        iuMensaje.setColores(Color.BLACK, new Color(255, 210, 0));
        iuMensaje.setTexto("Desea editar en el campo DEBE o HABER.?    D/H");
        iuInformacion.setVisible(false);
        campoS_N2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N2.getText()){
                        case "D":
                            focoCampoDebe();
                        break;
                        case "H":
                            focoCampoHaber();
                        break;
                        default:
                        break;
                    }
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
        iuInformacion.setTexto(" ATENCION: ENTER=Avanzar, F2=Retrocede, F9=100%, F7=87% de SI MISMO, F8=13%, ESC=Suspender o Finalizar");        
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
                            iuHaber.setTextoD("0.0");
                            iuDolares.setTextoD(String.valueOf(dolares));                            
                            focoCampoConcepto();
                        }
                    }
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    actualizarPaneles();
                    focoCampoCodigo();
                }                
                if(KeyEvent.VK_F7 == e.getKeyCode()){
                    double monto = Double.parseDouble(iuMonto.getText());
                    double porcentaje = (monto*87)/100;
                    iuDebe.setTextoD(String.valueOf(porcentaje));
                    
                    double tc = usuario.getTipcam();
                    double debe = Double.parseDouble(iuDebe.getText());
                    double result = debe/tc;
                    double dolares = Ayuda.acotarNumero(result, 2);
                    iuHaber.setTextoD("0.0");
                    iuDolares.setTextoD(String.valueOf(dolares));
                    focoCampoConcepto();
                }
                if(KeyEvent.VK_F8 == e.getKeyCode()){
                    double monto = Double.parseDouble(iuMonto.getText());
                    double porcentaje = (monto*13)/100;
                    iuDebe.setTextoD(String.valueOf(porcentaje));
                    
                    double tc = usuario.getTipcam();
                    double debe = Double.parseDouble(iuDebe.getText());
                    double result = debe/tc;
                    double dolares = Ayuda.acotarNumero(result, 2);
                    iuHaber.setTextoD("0.0");
                    iuDolares.setTextoD(String.valueOf(dolares));
                    focoCampoConcepto();
                }
                if(KeyEvent.VK_F9 == e.getKeyCode()){
                    double monto = Double.parseDouble(iuMonto.getText());
                    iuDebe.setTextoD(String.valueOf(monto));
                    double tc = usuario.getTipcam();
                    double debe = Double.parseDouble(iuDebe.getText());
                    double result = debe/tc;
                    double dolares = Ayuda.acotarNumero(result, 2);
                    iuHaber.setTextoD("0.0");
                    iuDolares.setTextoD(String.valueOf(dolares));
                    focoCampoConcepto();
                }
            }
        });
    }
    private void focoCampoHaber(){
        pintarBordeCampo("HABER");
        deshabilitarCampoS_N();
        
        iuHaber.setEditar(true);
        iuHaber.requestFocus();
        iuMensaje.setTexto("CAMPO HABER: Digite el Monto para ABONAR, ");
        iuInformacion.setTexto(" ATENCION: ENTER=Avanzar, F2=Retrocede, F7=Duplica Monto-Total DEBE al HABER, ESC=Suspender o Finalizar");        
        iuHaber.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!iuHaber.getText().isEmpty()){
                        if(Double.parseDouble(iuHaber.getText()) > 0){
                            double haber = Double.parseDouble(iuHaber.getText());
                            double tc = usuario.getTipcam();                    
                            double result = haber/tc;
                            double dolares = Ayuda.acotarNumero(result, 2);
                            iuDebe.setTextoD("0.0");
                            iuDolares.setTextoD(String.valueOf(dolares));
                            focoCampoConcepto();
                        }
                    }
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    actualizarPaneles();
                    focoCampoCodigo();
                }
                if(KeyEvent.VK_F7 == e.getKeyCode()){
                    double haber = getMontoTotalDebe();
                    iuHaber.setTextoD(String.valueOf(haber));
                    double tc = usuario.getTipcam();                    
                    double result = haber/tc;
                    double dolares = Ayuda.acotarNumero(result, 2);
                    iuDebe.setTextoD("0.0");
                    iuDolares.setTextoD(String.valueOf(dolares));
                    focoCampoConcepto();
                }
            }
        });
    }
    private void modificarContra(){
        for (int i = 0; i < listaContras.size(); i++) {
            Contra contra = listaContras.get(i);
            CContra.eliminarContra(contra);
        }
        //tabvar.setCorrel(num);
        //CTabvar.modificarTabvar(tabvar);
        
        /*if(tabvarCheque != null){
            tabvarCheque.setCorrel(Integer.parseInt(iuCheque.getText()));
            CTabvar.modificarTabvar(tabvarCheque);
        }*/
    }
    private void desmayorizar(){
        JProgressBar progresoBar = new JProgressBar();
        progresoBar.setValue(0);
        //progresoBar.setString("Desmayorizando...");
        progresoBar.setStringPainted(true);
        progresoBar.setBounds(0, 0, iuTituloMensaje.getWidth(), iuTituloMensaje.getHeight());        
        progresoBar.setVisible(true);
        iuTituloMensaje.add(progresoBar);
        
        final javax.swing.SwingWorker worker = new javax.swing.SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                ArrayList<Asiento> lista = listaAsientos;
                int nivel = 0;
                setProgress(0);
                for (Asiento apropiacion : lista) {

                    long codigo = apropiacion.getCodigo();

                    Conmae conmae = CConmae.getConmae("SELECT * FROM CONMAE WHERE CUETOT = "+codigo);
                    nivel = conmae.getNivel();

                    double salact = conmae.getSalact();
                    double salac2 = conmae.getSalac2();

                    //debe
                    double debano = conmae.getDebano();
                    double debdia = conmae.getDebdia();
                    double debmes = conmae.getDebmes();

                    double deban2 = conmae.getDeban2();
                    double debme2 = conmae.getDebme2();
                    double debdi2 = conmae.getDebdi2();

                    //haber
                    double creano = conmae.getCreano();
                    double credia = conmae.getCredia();
                    double cremes = conmae.getCremes();

                    double crean2 = conmae.getCrean2();
                    double creme2 = conmae.getCreme2();
                    double credi2 = conmae.getCredi2();            
                    if(apropiacion.getDebe() > 0){
                        salact = salact - apropiacion.getDebe();
                        debano = debano - apropiacion.getDebe();
                        debdia = debdia - apropiacion.getDebe();
                        debmes = debmes - apropiacion.getDebe();

                        salac2 = salac2 - apropiacion.getMonto();
                        deban2 = deban2 - apropiacion.getMonto();
                        debme2 = debme2 - apropiacion.getMonto();
                        debdi2 = debdi2 - apropiacion.getMonto();

                    }else{
                        salact = salact + apropiacion.getHaber();
                        creano = creano - apropiacion.getHaber();
                        credia = credia - apropiacion.getHaber();
                        cremes = cremes - apropiacion.getHaber();

                        salac2 = salac2 + apropiacion.getMonto();
                        crean2 = crean2 - apropiacion.getMonto();
                        creme2 = creme2 - apropiacion.getMonto();
                        credi2 = credi2 - apropiacion.getMonto();

                    }

                    conmae.setSalact(salact);
                    conmae.setDebano(debano);
                    conmae.setDebdia(debdia);
                    conmae.setDebmes(debmes);

                    conmae.setSalac2(salac2);
                    conmae.setDeban2(deban2);
                    conmae.setDebme2(debme2);
                    conmae.setDebdi2(debdi2);

                    conmae.setCreano(creano);
                    conmae.setCredia(credia);
                    conmae.setCremes(cremes);

                    conmae.setCrean2(crean2);
                    conmae.setCreme2(creme2);
                    conmae.setCredi2(credi2);

                    //modifica el conmae y guarda el nuevo contra
                    if(CConmae.modificarConmae(conmae)){

                        for (int i = 1; i < nivel; i++) {

                            switch(conmae.getNivel()){
                                case 5:
                                    codigo = codigo - conmae.getSubcta();
                                break;
                                case 4:
                                    codigo = codigo - (conmae.getCuenta()*100);
                                break;
                                case 3:
                                    codigo = codigo - (conmae.getMayor()*10000);
                                break;
                                case 2:
                                    codigo = codigo - (conmae.getSubgru()*1000000);
                                break;
                                default:
                                break;
                            }
                            conmae = CConmae.getConmae("SELECT * FROM CONMAE WHERE CUETOT = "+codigo);

                            salact = conmae.getSalact();
                            salac2 = conmae.getSalac2();

                            //debe
                            debano = conmae.getDebano();
                            debdia = conmae.getDebdia();
                            debmes = conmae.getDebmes();

                            deban2 = conmae.getDeban2();
                            debme2 = conmae.getDebme2();
                            debdi2 = conmae.getDebdi2();

                            //haber
                            creano = conmae.getCreano();
                            credia = conmae.getCredia();
                            cremes = conmae.getCremes();

                            crean2 = conmae.getCrean2();
                            creme2 = conmae.getCreme2();
                            credi2 = conmae.getCredi2();

                            /************MAYORIZACION**************/
                            if(apropiacion.getDebe() > 0){                
                                salact = salact - apropiacion.getDebe();
                                debano = debano - apropiacion.getDebe();
                                debdia = debdia - apropiacion.getDebe();
                                debmes = debmes - apropiacion.getDebe();

                                salac2 = salac2 - apropiacion.getMonto();
                                deban2 = deban2 - apropiacion.getMonto();
                                debme2 = debme2 - apropiacion.getMonto();
                                debdi2 = debdi2 - apropiacion.getMonto();

                            }else{                
                                salact = salact + apropiacion.getHaber();
                                creano = creano - apropiacion.getHaber();
                                credia = credia - apropiacion.getHaber();
                                cremes = cremes - apropiacion.getHaber();

                                salac2 = salac2 + apropiacion.getMonto();
                                crean2 = crean2 - apropiacion.getMonto();
                                creme2 = creme2 - apropiacion.getMonto();
                                credi2 = credi2 - apropiacion.getMonto();
                            }
                            conmae.setSalact(salact);
                            conmae.setDebano(debano);
                            conmae.setDebdia(debdia);
                            conmae.setDebmes(debmes);

                            conmae.setSalac2(salac2);
                            conmae.setDeban2(deban2);
                            conmae.setDebme2(debme2);
                            conmae.setDebdi2(debdi2);

                            conmae.setCreano(creano);
                            conmae.setCredia(credia);
                            conmae.setCremes(cremes);

                            conmae.setCrean2(crean2);
                            conmae.setCreme2(creme2);
                            conmae.setCredi2(credi2);

                            CConmae.modificarConmae(conmae);  
                            setProgress(i*10);
                        }
                    }
                }
                return null;
            }
            @Override
            protected void done() {
                setProgress(100);  
                progresoBar.setVisible(false);
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
    private void guardarContra(){
        JProgressBar progresoBar = new JProgressBar();
        progresoBar.setValue(0);
        //progresoBar.setString("Desmayorizando...");
        progresoBar.setStringPainted(true);
        progresoBar.setBounds(0, 0, iuTituloMensaje.getWidth(), iuTituloMensaje.getHeight());        
        progresoBar.setVisible(true);
        iuTituloMensaje.add(progresoBar);
        
        final javax.swing.SwingWorker worker = new javax.swing.SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                ArrayList<Asiento> lista = iuTabla.modeloTabla.lista;
                int num = Integer.parseInt(iuNum.getText());
                int nivel = 0;
                for (Asiento apropiacion : lista) {

                    long codigo = apropiacion.getCodigo();

                    Conmae conmae = CConmae.getConmae("SELECT * FROM CONMAE WHERE CUETOT = "+codigo);
                    Contra contra = new Contra(0);            

                    nivel = conmae.getNivel();

                    int tipcon = 0;
                    switch(iuTipDoc.getSelectedItem().toString()){
                        case "INGRESOS":
                            tipcon = 1;
                        break;
                        case "EGRESOS":
                            tipcon = 2;
                        break;
                        case "DIARIOS":
                            tipcon = 3;
                        break;
                    }

                    contra.setTipcon(tipcon);
                    contra.setNumcom(num);
                    contra.setCorrel(apropiacion.getNro());
                    contra.setFecha(new Fecha().getFecha());
                    contra.setGrupo(conmae.getGrup());
                    contra.setSubgru(conmae.getSubgru());
                    contra.setMayor(conmae.getMayor());
                    contra.setCuenta(conmae.getCuenta());
                    contra.setSubcta(conmae.getSubcta());

                    int apropi = 0;
                    double salact = conmae.getSalact();
                    double salac2 = conmae.getSalac2();

                    //debe
                    double debano = conmae.getDebano();
                    double debdia = conmae.getDebdia();
                    double debmes = conmae.getDebmes();

                    double deban2 = conmae.getDeban2();
                    double debme2 = conmae.getDebme2();
                    double debdi2 = conmae.getDebdi2();

                    //haber
                    double creano = conmae.getCreano();
                    double credia = conmae.getCredia();
                    double cremes = conmae.getCremes();

                    double crean2 = conmae.getCrean2();
                    double creme2 = conmae.getCreme2();
                    double credi2 = conmae.getCredi2();

                    if(apropiacion.getDebe() > 0){
                        apropi = 1;
                        salact = salact + apropiacion.getDebe();
                        debano = debano + apropiacion.getDebe();
                        debdia = debdia + apropiacion.getDebe();
                        debmes = debmes + apropiacion.getDebe();

                        salac2 = salac2 + apropiacion.getMonto();
                        deban2 = deban2 + apropiacion.getMonto();
                        debme2 = debme2 + apropiacion.getMonto();
                        debdi2 = debdi2 + apropiacion.getMonto();

                        contra.setMonto1(apropiacion.getDebe());
                    }else{
                        apropi = 2;
                        salact = salact - apropiacion.getHaber();
                        creano = creano + apropiacion.getHaber();
                        credia = credia + apropiacion.getHaber();
                        cremes = cremes + apropiacion.getHaber();

                        salac2 = salac2 - apropiacion.getMonto();
                        crean2 = crean2 + apropiacion.getMonto();
                        creme2 = creme2 + apropiacion.getMonto();
                        credi2 = credi2 + apropiacion.getMonto();

                        contra.setMonto1(apropiacion.getHaber());
                    }
                    contra.setApropi(apropi);            
                    contra.setMonto2(apropiacion.getMonto());
                    contra.setTipcam(Double.parseDouble(iuTipCam.getText()));
                    contra.setIndica(nivel);
                    contra.setNombre(iuDocRef.getText());
                    contra.setGlosa(apropiacion.getConcepto());                    
                    contra.setCheque(0);
                    contra.setNumcue(0);
                    contra.setCuetot(conmae.getCuetot());
                    contra.setReduce(0);
                    contra.setTipcom(tipcon);
                    contra.setIntern(0);
                    contra.setNumint(0);
                    //guarda la empesa, donde se consigue del tabvar (10,1)
                    contra.setEmpres(1);

                    conmae.setSalact(salact);
                    conmae.setDebano(debano);
                    conmae.setDebdia(debdia);
                    conmae.setDebmes(debmes);

                    conmae.setSalac2(salac2);
                    conmae.setDeban2(deban2);
                    conmae.setDebme2(debme2);
                    conmae.setDebdi2(debdi2);

                    conmae.setCreano(creano);
                    conmae.setCredia(credia);
                    conmae.setCremes(cremes);

                    conmae.setCrean2(crean2);
                    conmae.setCreme2(creme2);
                    conmae.setCredi2(credi2);

                    //modifica el conmae y guarda el nuevo contra
                    if(CContra.guardarContra(contra)){
                        if(CConmae.modificarConmae(conmae)){

                            for (int i = 1; i < nivel; i++) {

                                switch(conmae.getNivel()){
                                    case 5:
                                        codigo = codigo - conmae.getSubcta();
                                    break;
                                    case 4:
                                        codigo = codigo - (conmae.getCuenta()*100);
                                    break;
                                    case 3:
                                        codigo = codigo - (conmae.getMayor()*10000);
                                    break;
                                    case 2:
                                        codigo = codigo - (conmae.getSubgru()*1000000);
                                    break;
                                    default:
                                    break;
                                }
                                conmae = CConmae.getConmae("SELECT * FROM CONMAE WHERE CUETOT = "+codigo);

                                salact = conmae.getSalact();
                                salac2 = conmae.getSalac2();

                                //debe
                                debano = conmae.getDebano();
                                debdia = conmae.getDebdia();
                                debmes = conmae.getDebmes();

                                deban2 = conmae.getDeban2();
                                debme2 = conmae.getDebme2();
                                debdi2 = conmae.getDebdi2();

                                //haber
                                creano = conmae.getCreano();
                                credia = conmae.getCredia();
                                cremes = conmae.getCremes();

                                crean2 = conmae.getCrean2();
                                creme2 = conmae.getCreme2();
                                credi2 = conmae.getCredi2();

                                /************MAYORIZACION**************/
                                if(apropiacion.getDebe() > 0){                
                                    salact = salact + apropiacion.getDebe();
                                    debano = debano + apropiacion.getDebe();
                                    debdia = debdia + apropiacion.getDebe();
                                    debmes = debmes + apropiacion.getDebe();

                                    salac2 = salac2 + apropiacion.getMonto();
                                    deban2 = deban2 + apropiacion.getMonto();
                                    debme2 = debme2 + apropiacion.getMonto();
                                    debdi2 = debdi2 + apropiacion.getMonto();

                                }else{                
                                    salact = salact - apropiacion.getHaber();
                                    creano = creano + apropiacion.getHaber();
                                    credia = credia + apropiacion.getHaber();
                                    cremes = cremes + apropiacion.getHaber();

                                    salac2 = salac2 - apropiacion.getMonto();
                                    crean2 = crean2 + apropiacion.getMonto();
                                    creme2 = creme2 + apropiacion.getMonto();
                                    credi2 = credi2 + apropiacion.getMonto();
                                }
                                conmae.setSalact(salact);
                                conmae.setDebano(debano);
                                conmae.setDebdia(debdia);
                                conmae.setDebmes(debmes);

                                conmae.setSalac2(salac2);
                                conmae.setDeban2(deban2);
                                conmae.setDebme2(debme2);
                                conmae.setDebdi2(debdi2);

                                conmae.setCreano(creano);
                                conmae.setCredia(credia);
                                conmae.setCremes(cremes);

                                conmae.setCrean2(crean2);
                                conmae.setCreme2(creme2);
                                conmae.setCredi2(credi2);

                                CConmae.modificarConmae(conmae);
                                //modificar el conmae   
                                setProgress(i);
                            }
                        }
                    }
                }
                num++;
                tabvar.setCorrel(num);
                CTabvar.modificarTabvar(tabvar);
                return null;
            }
            @Override
            protected void done() {
                setProgress(100);  
                progresoBar.setVisible(false);
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
    
    private void sumarColumnasTotales(){
        ArrayList<Asiento> lista = iuTabla.modeloTabla.lista;
        double debe = 0;
        double haber = 0;
        double dolares = 0;
        for (Asiento a : lista) {
            if(a.getDebe() > 0)
                dolares = dolares + a.getMonto();
            if(a.getHaber() > 0)
                dolares = dolares - a.getMonto();
            debe = debe + a.getDebe();
            haber = haber + a.getHaber();             
        }
        
        iuTotalDebe.setTextoD(String.valueOf(Ayuda.acotarNumero(debe, 2)));
        iuTotalHaber.setTextoD(String.valueOf(Ayuda.acotarNumero(haber, 2)));
        iuTotalDolares.setTextoD(String.valueOf(Ayuda.acotarNumero(dolares, 2)));
    }
    private boolean debeMenorIgualMonto(){
        boolean verificador = false;
        ArrayList<Asiento> lista = iuTabla.modeloTabla.lista;
        double debe = 0;        
        boolean modifico = false;
        if(!lista.isEmpty()){
            for (Asiento a : lista){
                if(a.getCodigo() == Long.valueOf(iuCodigo.getText())){
                    debe = debe + Double.parseDouble(iuDebe.getText());
                    modifico = true;
                }                    
                else
                    debe = debe + a.getDebe();
            }
        }else{
            if(!iuDebe.getText().isEmpty()){
                debe = Double.parseDouble(iuDebe.getText());
                modifico = true;
            }
                
        }
        if(modifico == false){
            if(!iuDebe.getText().isEmpty())
                debe = debe + Double.parseDouble(iuDebe.getText());
        }            
        double montoInicial = Double.parseDouble(iuMonto.getText());
                
        if(debe <= montoInicial)
            verificador = true;        
        return verificador;
    }
    private double getMontoTotalDebe(){
        ArrayList<Asiento> lista = iuTabla.modeloTabla.lista;
        double debe = 0;        
        for (Asiento a : lista)
            debe = debe + a.getDebe();        
        return debe;
    }
    private void focoCampoS_N3(){        
        pintarBordeCampo("");        
        campoS_N3.setVisible(true);
        campoS_N3.setEditar(true);
        campoS_N3.requestFocus();
        campoS_N3.setText("S");
        iuMensaje.setColores(Color.BLACK, new Color(255, 210, 0));
        iuMensaje.setTexto("Esta Conforme con el MONTO en DOLARES. ?");
        iuInformacion.setVisible(false);        
        campoS_N3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N3.getText()){
                        case "S":
                            //if(debeMenorIgualMonto()){
                                if(existeItemTabla(iuCodigo.getText())){                                
                                    if(Ayuda.mensaje(ventanaPrincipal, "Atencion: Esta APROPIACION ya existe en la TABLA.\n DESEA MODIFICAR ESTA APROPIACION. ?", "PRECAUCION")){
                                        modificarRegistroTabla();
                                        sumarColumnasTotales();
                                        actualizarPaneles();
                                        limpiarCamposFila();
                                        focoCampoNro();
                                    }else{                                
                                        Asiento a = new Asiento(Integer.parseInt(iuNro.getText()));
                                        if(!iuCodigo.getText().isEmpty() && !iuDebe.getText().isEmpty() && !iuHaber.getText().isEmpty() && !iuDolares.getText().isEmpty()){
                                            a.setCodigo(Long.parseLong(iuCodigo.getText()));
                                            a.setCuenta(iuDescripcion.getText());
                                            a.setConcepto(iuConcepto.getText());
                                            a.setDebe(Double.parseDouble(iuDebe.getText()));
                                            a.setHaber(Double.parseDouble(iuHaber.getText()));
                                            a.setMonto(Double.parseDouble(iuDolares.getText()));
                                            iuTabla.modeloTabla.setFila(a);
                                            sumarColumnasTotales();
                                            actualizarPaneles();
                                            limpiarCamposFila();
                                            focoCampoNro();
                                        }
                                    }
                                }else{                                
                                    Asiento a = new Asiento(Integer.parseInt(iuNro.getText()));
                                    if(!iuCodigo.getText().isEmpty() && !iuDebe.getText().isEmpty() && !iuHaber.getText().isEmpty() && !iuDolares.getText().isEmpty()){
                                        a.setCodigo(Long.parseLong(iuCodigo.getText()));
                                        a.setCuenta(iuDescripcion.getText());
                                        a.setConcepto(iuConcepto.getText());
                                        a.setDebe(Double.parseDouble(iuDebe.getText()));
                                        a.setHaber(Double.parseDouble(iuHaber.getText()));
                                        a.setMonto(Double.parseDouble(iuDolares.getText()));
                                        iuTabla.modeloTabla.setFila(a);
                                        sumarColumnasTotales();
                                        actualizarPaneles();
                                        limpiarCamposFila();
                                        focoCampoNro();
                                    }
                                }
                            /*}else{
                                JOptionPane.showMessageDialog( ventanaPrincipal, "Atencion: Usted NO debe ingresar un MONTO SUPERIOR al MONTO INCIAL.\nPor SEGURIDAD se borrara los campos ingresados.", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE );                                
                                actualizarPaneles();
                                limpiarCamposFila();
                                focoCampoCodigo();
                            }*/
                        break;
                        case "N":                            
                            focoCampoCodigo();
                        break;
                        default:
                        break;
                    }                    
                }
            }
        });        
    }
    private void limpiarCampos(){
        
        iuCodigo.setText("");
        iuDescripcion.setText("");
        iuDebe.setText("");
        iuHaber.setText("");
        iuDolares.setText("");
        
        iuMonto.setText("");
        iuDocRef.setText("");
        iuNumLiteral.setText("");
        iuConcepto.setText("");        
        //iuAreaGlosa.setText("");
        //iuCuenta.setText("");
        //iuBanco.setText("");
        //iuCheque.setText("");
        
        iuTabla.modeloTabla.limpiarTabla();
        sumarColumnasTotales();
        indice = 1;
    }
    private void limpiarCamposFila(){
        iuCodigo.setText("");
        iuDescripcion.setText("");
        iuDebe.setText("");
        iuHaber.setText("");
        iuDolares.setText("");
    }
    private boolean existeItemTabla(String codigo){
        boolean encontro = false;
        int contador = 0;
        if(!codigo.isEmpty()){
            while(contador < iuTabla.modeloTabla.lista.size() && !encontro){
                if(((Asiento)iuTabla.modeloTabla.lista.get(contador)).getCodigo() == Long.parseLong(codigo) && ((Asiento)iuTabla.modeloTabla.lista.get(contador)).getNro() == Integer.parseInt(iuNro.getText())){
                    encontro = true;
                }
                contador++;
            }
        }
        return encontro;
    }
    private void modificarRegistroTabla(){
        boolean encontro = false;
        int contador = 0;
                
        while(contador < iuTabla.modeloTabla.lista.size() && !encontro){
            if(!iuCodigo.getText().isEmpty()){
                if(((Asiento)iuTabla.modeloTabla.lista.get(contador)).getCodigo() == Long.parseLong(iuCodigo.getText()) && ((Asiento)iuTabla.modeloTabla.lista.get(contador)).getNro() == Integer.parseInt(iuNro.getText())){
                    Asiento a = new Asiento(contador+1);
                    a.setCodigo(Long.parseLong(iuCodigo.getText()));
                    a.setCuenta(iuDescripcion.getText());
                    a.setConcepto(iuConcepto.getText());
                    a.setDebe(Double.parseDouble(iuDebe.getText()));
                    a.setHaber(Double.parseDouble(iuHaber.getText()));
                    a.setMonto(Double.parseDouble(String.valueOf(iuDolares.getText())));
                    iuTabla.modeloTabla.setUpdateFila(contador, a);                
                    encontro = true;
                }                
            }
            contador++;
        }        
    } 
    private void campoModificables(){
        habilitarCamposModificar();
        modificable = true;
        
    }
    private void recuperarAsiento(){  
        actualizarPaneles();
        listaContras = CContra.getListaContra("select * from contra where numcom = "+iuNum.getText()+" order by correl asc");        
        listaAsientos.clear();
        ArrayList<Asiento> listaApropiaciones = new ArrayList<>();
        double monto = 0;
        for (int i = 0; i < listaContras.size(); i++) {
            Contra contra = listaContras.get(i);
            String tipo = "";
            switch(contra.getTipcon()){
                case 1:
                    tipo = "INGRESOS";
                break;
                case 2:
                    tipo = "EGRESOS";
                break;
                case 3:
                    tipo = "DIARIOS";
                break;
                default:
                break;
            }            
            seleccionarTipoDocumento(tipo);
            iuMonto.setText("");
            iuNum.setText(String.valueOf(contra.getNumcom()));
            iuDocRef.setText(contra.getNombre());
            iuNumLiteral.setText("");
            iuConcepto.setText("");
                        
            Conmae conmae = CConmae.getConmae("SELECT * FROM CONMAE WHERE CUETOT = "+contra.getCuetot());
            Asiento apropiacion = new Asiento(i+1);
            if(conmae != null){                
                apropiacion.setCodigo(contra.getCuetot());
                apropiacion.setCuenta(conmae.getDescri());
                apropiacion.setConcepto(contra.getGlosa());
                switch(contra.getApropi()){
                    case 1:
                        monto = monto + contra.getMonto1();
                        apropiacion.setDebe(contra.getMonto1());
                        apropiacion.setMonto(contra.getMonto2());
                    break;
                    case 2:
                        apropiacion.setHaber(contra.getMonto1());
                        apropiacion.setMonto(contra.getMonto2());
                    break;
                }
                
            }else{                
                apropiacion.setCodigo(contra.getCuetot());
                apropiacion.setCuenta("NO EXISTE!!! CUENTA EN EL PLAN DE CUENTAS");
                
                switch(contra.getApropi()){
                    case 1:
                        monto = monto + contra.getMonto1();
                        apropiacion.setDebe(contra.getMonto1());
                        apropiacion.setMonto(contra.getMonto2());
                    break;
                    case 2:
                        apropiacion.setHaber(contra.getMonto1());
                        apropiacion.setMonto(contra.getMonto2());
                    break;
                }
            }
            listaApropiaciones.add(apropiacion);            
            listaAsientos.add(apropiacion);
        }        
        iuTabla.actualizarTabla(listaApropiaciones);
        iuMonto.setText(String.valueOf(Ayuda.acotarNumero(monto, 2)));
        iuNumLiteral.setText(Numero_a_Letra.Convertir(String.valueOf(monto), true));
        inhabilitarCampos(false);
        sumarColumnasTotales();
        indice = iuTabla.modeloTabla.getRowCount() + 1;        
    }
}

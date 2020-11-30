/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.actualizacionDiferida;

import SIGU.campoTexto.IUAreaTexto;
import SIGU.campoTexto.IUCampoTexto;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.paneles.IUPanel;
import SIGU.paneles.IUPanelEtiqueta;
import SIGU.recursos.Area;
import SIGU.recursos.Fecha;
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
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author neo
 */
public class VActualizacionDiferida extends IUSecundario{
    
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
                    private IUEtiqueta iuEtiquetaProcedimiento;
                    private IUAreaTexto iuProcedimiento;
                    
                    private IUPanelEtiqueta cantCuentas;
                    private IUCampoTexto iuCantCuentas;
                    private IUPanelEtiqueta cuentaProcesada;
                    private IUCampoTexto iuCuentaProcesada;
                    
                    private IUEtiqueta iuEtiquetaFechas;
                    private IUEtiqueta iuEtiquetaDesde;
                    private IUCampoTexto iuDesde;
                    private IUEtiqueta iuEtiquetaHasta;
                    private IUCampoTexto iuHasta;
                private IUPanel panelDos;
                    private IUPanelEtiqueta iuPanelCant;
                    private IUPanelEtiqueta iuPanelDebe;
                    private IUPanelEtiqueta iuPanelHaber;
                    private IUCampoTexto iuCant;
                    private IUCampoTexto iuDebe;
                    private IUCampoTexto iuHaber;
        
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
    
    private final Usuario usuario;
    private final Tabvar tabvar;
    
    private boolean proceso;
    
    public VActualizacionDiferida(VPrincipal ventanaPrincipal, String titulo, String tipoSize, Usuario usuario, Tabvar tabvar) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        this.usuario = usuario;
        this.tabvar = tabvar;
        this.proceso = false;
        
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
        iuTitulo = new IUEtiqueta(panelTitulo, "ACTUALIZACION DIFERIDA", new Area(a.X(2) + a.AnP(25), a.Y(), a.AnP(35), a.AlP(50)), 16, "CENTER", false);        
        iuTitulo.setSubrayarTexto(true);
        //iuTitulo = new IUEtiqueta(panelTitulo, "Por: GRUPO - NIVEL", new Area(a.X(2) + a.AnP(25), a.Y(2) + a.AlP(45), a.AnP(35), a.AlP(50)), 16, "CENTER", false);                
        //iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "SISTEMA CONTABLE SISCON @v7.2. 2020", new Area(a.X(3) + a.AnP(60), a.Y(), a.AnP(40), a.AlP(50)), 16, "RIGHT", false); 
        iuTitulo = new IUEtiqueta(panelTitulo, new Fecha().getFecha1(), new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(45), a.AnP(40), a.AlP(50)), 16, "RIGHT", false); 
        
        iuTitulo = new IUEtiqueta(panelTitulo, "Pantalla: AD ", new Area(a.X(), a.Y(2) + a.AlP(45), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
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
        panelUno = new IUPanel(panelContenido, new Area(a.X(), a.Y(), a.An(), a.AlP(75)), false);
        construirPanelUno(new Area(2, 2, a.An() - 6, a.Al() - 8));
        
        panelDos = new IUPanel(panelContenido, new Area(a.X(), a.Y(2) + a.AlP(75), a.An(), a.AlP(25)), false);
        construirPanelDos(new Area(2, 2, a.An() - 8, a.Al() - 4));
    }
    private void construirPanelUno(Area a){
        iuEtiquetaObjetivo = new IUEtiqueta(panelUno, "OBJETIVO:", new Area(a.X(), a.Y(), a.AnP(30), a.AlP(5)), 16, "CENTER", true);
        iuObjetivo = new IUAreaTexto(panelUno, new Area(a.X(2) + a.AnP(30), a.Y(), a.AnP(70), a.AlP(20)), "la actualizacion direfida es una paso excepcional\n" +
                                                                                                            "ante fallas de saldos y consiste en MAYORIZAR\n" +
                                                                                                            "nuevamente los comprobantes contables.", 16);
        iuObjetivo.setTextoEditable(false);        
        iuEtiquetaProcedimiento = new IUEtiqueta(panelUno, "PROCEDIMIENTO:", new Area(a.X(), a.Y(2) + a.AlP(25), a.AnP(30), a.AlP(5)), 16, "CENTER", true);
        iuProcedimiento = new IUAreaTexto(panelUno, new Area(a.X(2) + a.AnP(30), a.Y(2) + a.AlP(25), a.AnP(70), a.AlP(35)), "- Prepara el Plan de Cuentas (CONMAE),\n" +
                                                                                                                            "	Borra = TODOS los Saldos en CERO.\n" +
                                                                                                                            "	Inicializa = SALDO Inicial activo\n" +
                                                                                                                            "- Verifica los Asientos Contables (CONTRA),\n" +
                                                                                                                            "- Ingresa las Cuentas Nuevas,\n" +
                                                                                                                            "- Finalmente, verifica los resultados.", 16);
        iuProcedimiento.setTextoEditable(false);        
        
        cantCuentas = new IUPanelEtiqueta(panelUno, new Area(a.X() + a.AnP(15), a.Y(4) + a.AlP(69), a.AnP(30), a.AlP(5)), "Cantidad Cuentas:", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        cantCuentas.setVisible(false);
        iuCantCuentas = new IUCampoTexto(panelUno, 20, 16, new Area(a.X(2) + a.AnP(45), a.Y(4) + a.AlP(69), a.AnP(20), a.AlP(5)), SwingConstants.CENTER);
        iuCantCuentas.setEditar(false);
        iuCantCuentas.setVisible(false);
        
        //iuEtiquetaFechas = new IUEtiqueta(panelUno, "RANGOS DE FECHAS:", new Area(a.X(), a.Y(4) + a.AlP(65), a.AnP(30), a.AlP(5)), 16, "CENTER", true);
        //iuEtiquetaDesde = new IUEtiqueta(panelUno, "DESDE:", new Area(a.X(2) + a.AnP(30), a.Y(4) + a.AlP(65), a.AnP(10), a.AlP(5)), 16, "CENTER", true);
        //iuDesde = new IUCampoTexto(panelUno, "", 20, new Area(a.X(2) + a.AnP(40), a.Y(4) + a.AlP(65), a.AnP(20), a.AlP(5)));
        //iuDesde.setEditar(false);
        //iuEtiquetaHasta = new IUEtiqueta(panelUno, "HASTA:", new Area(a.X(2) + a.AnP(60), a.Y(4) + a.AlP(65), a.AnP(10), a.AlP(5)), 16, "CENTER", true);
        //iuHasta = new IUCampoTexto(panelUno, "", 20, new Area(a.X(2) + a.AnP(70), a.Y(4) + a.AlP(65), a.AnP(20), a.AlP(5)));
        //iuHasta.setEditar(false);
    }
    private void construirPanelDos(Area a){
        iuPanelCant = new IUPanelEtiqueta(panelDos, new Area(a.X() + a.AnP(15), a.Y() + a.AlP(5), a.AnP(15), a.AlP(5)), "Cant. COMP.", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuPanelDebe = new IUPanelEtiqueta(panelDos, new Area(a.X(2) + a.AnP(30), a.Y() + a.AlP(5), a.AnP(30), a.AlP(5)), "DEBE", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuPanelHaber = new IUPanelEtiqueta(panelDos, new Area(a.X(3) + a.AnP(60), a.Y() + a.AlP(5), a.AnP(30), a.AlP(5)), "HABER", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        
        iuCant = new IUCampoTexto(panelDos, 50, 16, new Area(a.X() + a.AnP(15), a.Y(2) + a.AlP(10), a.AnP(15), a.AlP(5)), SwingConstants.CENTER);
        iuCant.setEditar(false);
        iuDebe = new IUCampoTexto(panelDos, 50, 16, new Area(a.X(2) + a.AnP(30), a.Y(2) + a.AlP(10), a.AnP(30), a.AlP(5)), SwingConstants.CENTER);
        iuDebe.setEditar(false);
        iuHaber = new IUCampoTexto(panelDos, 50, 16, new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(10), a.AnP(30), a.AlP(5)), SwingConstants.CENTER);
        iuHaber.setEditar(false);
        
        cuentaProcesada = new IUPanelEtiqueta(panelDos, new Area(a.X() + a.AnP(15), a.Y(2) + a.AlP(5), a.AnP(30), a.AlP(5)), "Ultima Cuenta Procesada:", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        cuentaProcesada.setVisible(false);
        iuCuentaProcesada = new IUCampoTexto(panelDos, 20, 16, new Area(a.X(2) + a.AnP(45), a.Y(2) + a.AlP(5), a.AnP(45), a.AlP(5)), SwingConstants.CENTER);
        iuCuentaProcesada.setEditar(false);
        iuCuentaProcesada.setVisible(false);
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
                if (KeyEvent.VK_B == e.getKeyCode()){
                    campoS_N1.setText("B");
                }
                if(KeyEvent.VK_I == e.getKeyCode()){
                    campoS_N1.setText("I");
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
    }
    private void algoritmosInicial(){
        cargarComprobantes();
        focoCampoS_N1();
    }
    private void cargarComprobantes(){
        ArrayList<Contra> listaContras = CContra.getListaContra("SELECT * FROM CONTRA");
        int cantComprobantes = CContra.getListaContra("SELECT * FROM CONTRA GROUP BY NUMCOM").size();
        double debe = 0;
        double haber = 0;
        for (int i = 0; i < listaContras.size(); i++) {
            Contra contra = listaContras.get(i);
            if(contra.getApropi() == 1){
                debe = debe + contra.getMonto1();
            }else{
                haber = haber + contra.getMonto1();
            }            
        }        
        iuCant.setText(String.valueOf(cantComprobantes));
        iuDebe.setTextoD(String.valueOf(debe));
        iuHaber.setTextoD(String.valueOf(haber));
        
        iuCant.setBackground(Color.GREEN);
        iuDebe.setBackground(Color.GREEN);
        iuHaber.setBackground(Color.GREEN);
    }
    private void focoCampoS_N1(){        
        camposInicio_Proceso("INICIO");
        deshabilitarCampoS_N();
        campoS_N1.setVisible(true);
        campoS_N1.setEditar(true);
        campoS_N1.requestFocus();            
        if(!getEstado()){
            campoS_N1.setText("B");
            iuMensaje.setTexto("Desea (B)orrar o (I)nicializar los SALDOS  ?     B/I");
            campoS_N1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(KeyEvent.VK_ENTER == e.getKeyCode()){
                        switch(campoS_N1.getText()){
                            case "B":
                                focoCampoS_N2();                            
                            break;
                            case "I":
                                focoCampoS_N4();
                            break;
                        }
                    }
                }
            });        
        }else{
            deshabilitarCampoS_N();
            iuMensaje.setTexto("ATENCION: YA REALIZÓ EL PROCESO DE ACTUALIZACION DIFERIDA. NECESARIAMENTE DEBE SALIR y VOLVER A ENTRAR.");
            iuInformacion.setTexto("ESC = SUSPENDER");
        }
    }
    private void focoCampoS_N4(){
        if(!proceso){
            camposInicio_Proceso("FINAL");
            deshabilitarCampoS_N();        
            campoS_N4.setVisible(true);
            campoS_N4.setEditar(true);
            campoS_N4.requestFocus();
            campoS_N4.setText("S");
            iuMensaje.setTexto("Comienzo a INICIALIZAR todos los SALDOS  ?     S/N");
            iuInformacion.setTexto("");
            campoS_N4.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(KeyEvent.VK_ENTER == e.getKeyCode()){
                        switch(campoS_N4.getText()){
                            case "S":
                                if(!proceso)
                                    inicializarSaldos();
                                focoCampoBorradoInicializarSaldos("Se ha INICIALIZADO TODOS LOS SALDOS CORRECTAMENTE.!  ENTER para continuar...     S/N");
                            break;
                            case "N":
                                focoCampoS_N1();
                            break;
                        }
                    }
                }
            });
        }else{
            deshabilitarCampoS_N();
            iuMensaje.setTexto("ATENCION: ESTE PROCESO YA REALIZO, DEBE ABANDONAR Y VOLVER A ENTRAR A ESTA FUNCION.");
            iuInformacion.setTexto("ESC = SUSPENDER");
        }
    }
    private void camposInicio_Proceso(String cambio){
        switch(cambio){
            case "INICIO":
                iuPanelCant.setVisible(true);
                iuPanelDebe.setVisible(true);
                iuPanelHaber.setVisible(true);
                iuCant.setVisible(true);
                iuDebe.setVisible(true);
                iuHaber.setVisible(true);

                cantCuentas.setVisible(false);
                iuCantCuentas.setVisible(false);
                cuentaProcesada.setVisible(false);
                iuCuentaProcesada.setVisible(false);
            break;
            case "FINAL":
                iuPanelCant.setVisible(false);
                iuPanelDebe.setVisible(false);
                iuPanelHaber.setVisible(false);
                iuCant.setVisible(false);
                iuDebe.setVisible(false);
                iuHaber.setVisible(false);

                cantCuentas.setVisible(true);
                iuCantCuentas.setVisible(true);
                cuentaProcesada.setVisible(true);
                iuCuentaProcesada.setVisible(true);
            break;
        }
    }
    private void focoCampoS_N2(){
        if(!proceso){
            camposInicio_Proceso("FINAL");
            deshabilitarCampoS_N();        
            campoS_N2.setVisible(true);
            campoS_N2.setEditar(true);
            campoS_N2.requestFocus();
            campoS_N2.setText("S");
            iuMensaje.setTexto("Comienzo a BORRAR todos los SALDOS  ?     S/N");
            campoS_N2.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(KeyEvent.VK_ENTER == e.getKeyCode()){
                        switch(campoS_N2.getText()){
                            case "S":
                                if(!proceso)
                                    borrarSaldos();
                                focoCampoBorradoInicializarSaldos("Se ha BORRADO TODOS LOS SALDOS CORRECTAMENTE.!  ENTER para continuar...     S/N");
                            break;
                            case "N":
                                focoCampoS_N1();
                            break;
                            default:
                            break;
                        }
                    }                
                }            
            });
        }else{
            deshabilitarCampoS_N();
            iuMensaje.setTexto("ATENCION: ESTE PROCESO YA REALIZO, DEBE ABANDONAR Y VOLVER A ENTRAR A ESTA FUNCION.");
            iuInformacion.setTexto("ESC = SUSPENDER");
            
        }        
    }
    private void borrarSaldos(){
        JProgressBar progresoBar = new JProgressBar();
        progresoBar.setValue(0);
        //progresoBar.setString("Desmayorizando...");
        progresoBar.setStringPainted(true);
        progresoBar.setBounds(0, 0, iuTituloMensaje.getWidth(), iuTituloMensaje.getHeight());        
        progresoBar.setVisible(true);
        iuTituloMensaje.add(progresoBar);
        
        
        final javax.swing.SwingWorker worker = new javax.swing.SwingWorker() {
            int cantidad = 0;
            String cuenta = "";
            @Override
            protected Object doInBackground() throws Exception {
                
                ArrayList<Conmae> lista = CConmae.getLista("SELECT * FROM CONMAE");
                
                for (Conmae c : lista) {
                    c.setSalini(0);            
                    c.setAntdia(0);
                    c.setAntmes(0);                                    
                    c.setSalact(0);
                    c.setDebano(0);
                    c.setCreano(0);
                    c.setDebmes(0);
                    c.setCremes(0);
                    c.setDebdia(0);
                    c.setCredia(0);

                    c.setSalin2(0);
                    c.setAntdi2(0);
                    c.setAntme2(0);                                    
                    c.setSalac2(0);
                    c.setDeban2(0);
                    c.setCrean2(0);
                    c.setDebme2(0);
                    c.setCreme2(0);
                    c.setDebdi2(0);
                    c.setCredi2(0);
                    CConmae.modificarConmae(c);

                    cantidad++;
                    cuenta = c.getDescri();
                    setProgress(cantidad);
                }                
                return null;
            }
            @Override
            protected void done() {
                setProgress(100);
                progresoBar.setVisible(false);
                iuCantCuentas.setText(String.valueOf(cantidad));
                iuCuentaProcesada.setText(cuenta);                
                proceso = true;                
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
    private void inicializarSaldos(){
        JProgressBar progresoBar = new JProgressBar();
        progresoBar.setValue(0);
        //progresoBar.setString("Desmayorizando...");
        progresoBar.setStringPainted(true);
        progresoBar.setBounds(0, 0, iuTituloMensaje.getWidth(), iuTituloMensaje.getHeight());        
        progresoBar.setVisible(true);
        iuTituloMensaje.add(progresoBar);
        
        
        final javax.swing.SwingWorker worker = new javax.swing.SwingWorker() {
            int cantidad = 0;
            String cuenta = "";
            @Override
            protected Object doInBackground() throws Exception {
                ArrayList<Conmae> lista = CConmae.getLista("SELECT * FROM CONMAE");                
                for (Conmae c : lista) {

                    c.setAntdia(c.getSalini());
                    c.setAntmes(c.getSalini());                                    
                    c.setSalact(c.getSalini());
                    c.setDebano(0);
                    c.setCreano(0);
                    c.setDebmes(0);
                    c.setCremes(0);
                    c.setDebdia(0);
                    c.setCredia(0);


                    c.setAntdi2(c.getSalin2());
                    c.setAntme2(c.getSalin2());                                    
                    c.setSalac2(c.getSalin2());
                    c.setDeban2(0);
                    c.setCrean2(0);
                    c.setDebme2(0);
                    c.setCreme2(0);
                    c.setDebdi2(0);
                    c.setCredi2(0);
                    CConmae.modificarConmae(c);
                    cantidad++;
                    cuenta = c.getDescri();
                    setProgress(cantidad);
                }
                return null;
            }
            @Override
            protected void done() {
                setProgress(100);
                progresoBar.setVisible(false);
                iuCantCuentas.setText(String.valueOf(cantidad));
                iuCuentaProcesada.setText(cuenta);                
                proceso = true;                
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
        campoS_N4.setVisible(false);
        campoS_N4.setEditar(false);
        campoS_N5.setVisible(false);
        campoS_N5.setEditar(false);
        campoS_N6.setVisible(false);
        campoS_N6.setEditar(false);
    }
    private void focoCampoBorradoInicializarSaldos(String mensaje){        
        deshabilitarCampoS_N();
        campoS_N2.setVisible(true);
        campoS_N2.setEditar(true);
        campoS_N2.requestFocus();
        campoS_N2.setText("S");
        iuMensaje.setTexto(mensaje);
        iuInformacion.setTexto("ATENCION: ESC = Suspender.");
        campoS_N2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N2.getText()){
                        case "S":                            
                            reconstruccionMayorizacion();
                        break;
                        case "N":
                            focoCampoSalir("DESEA SALIR DE LA ACTUALIZACION DIFERIDA. ?     S/N");
                        break;
                    }
                }
            }
        });
    }
    private void reconstruccionMayorizacion(){
        camposInicio_Proceso("INICIO");
        deshabilitarCampoS_N();
        campoS_N3.setVisible(true);
        campoS_N3.setEditar(true);
        campoS_N3.requestFocus();
        campoS_N3.setText("S");
        iuMensaje.setTexto("COMIENZO CON LA RECONSTRUCCION DE LOS CAMPOS ACUMULATIVOS. ?     S/N");
        iuInformacion.setTexto("ATENCION: ESC = Suspender.");
        campoS_N3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N3.getText()){
                        case "S":                            
                            reconstruccionCuentas();                            
                        break;
                        case "N":
                            focoCampoSalir("DESEA SALIR DE LA ACTUALIZACION DIFERIDA. ?     S/N");
                        break;
                    }
                }
            }
        });
    }
    private void focoCampoSalir(String mensaje){
        camposInicio_Proceso("INICIO");
        deshabilitarCampoS_N();
        campoS_N5.setVisible(true);
        campoS_N5.setEditar(true);
        campoS_N5.requestFocus();
        campoS_N5.setText("S");
        iuMensaje.setTexto(mensaje);
        iuInformacion.setTexto("ATENCION: ESC = Suspender.");
        campoS_N5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N5.getText()){
                        case "S":
                            dispose();
                        break;
                        case "N":
                            focoCampoS_N1();
                        break;
                    }
                }
            }
        });
    }
    private void reconstruccionCuentas(){
        
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
                int numero = 0;
                ArrayList<Contra> listaContras = CContra.getListaContra("SELECT * FROM CONTRA");                                                
                int nivel = 0;
                for (Contra contra : listaContras) {

                    long codigo = contra.getCuetot();

                    Conmae conmae = CConmae.getConmae("SELECT * FROM CONMAE WHERE CUETOT = "+codigo);

                    nivel = conmae.getNivel();
                    //la fecha del contra se mantiene

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

                    if(contra.getApropi() == 1){                        
                        salact = salact + contra.getMonto1();
                        debano = debano + contra.getMonto1();
                        debdia = debdia + contra.getMonto1();
                        debmes = debmes + contra.getMonto1();

                        salac2 = salac2 + contra.getMonto2();
                        deban2 = deban2 + contra.getMonto2();
                        debme2 = debme2 + contra.getMonto2();
                        debdi2 = debdi2 + contra.getMonto2();
                    }else{                        
                        salact = salact - contra.getMonto1();
                        creano = creano + contra.getMonto1();
                        credia = credia + contra.getMonto1();
                        cremes = cremes + contra.getMonto1();

                        salac2 = salac2 - contra.getMonto2();
                        crean2 = crean2 + contra.getMonto2();
                        creme2 = creme2 + contra.getMonto2();
                        credi2 = credi2 + contra.getMonto2();
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

                            numero++;
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
                            if(contra.getApropi() == 1){
                                salact = salact + contra.getMonto1();
                                debano = debano + contra.getMonto1();
                                debdia = debdia + contra.getMonto1();
                                debmes = debmes + contra.getMonto1();

                                salac2 = salac2 + contra.getMonto2();
                                deban2 = deban2 + contra.getMonto2();
                                debme2 = debme2 + contra.getMonto2();
                                debdi2 = debdi2 + contra.getMonto2();

                            }else{                
                                salact = salact - contra.getMonto1();
                                creano = creano + contra.getMonto1();
                                credia = credia + contra.getMonto1();
                                cremes = cremes + contra.getMonto1();

                                salac2 = salac2 - contra.getMonto2();
                                crean2 = crean2 + contra.getMonto2();
                                creme2 = creme2 + contra.getMonto2();
                                credi2 = credi2 + contra.getMonto2();
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
                            setProgress(numero+20);
                        }
                    }                    
                }                
                return null;
            }
            @Override
            protected void done() {
                setProgress(100);  
                progresoBar.setVisible(false);
                setEstado(true);
                proceso = true;
                focoCampoSalir("SE HA REALIZADO LA ACTUALIZACION DIFERIDA CORRECTAMENTE.!   DESEA ABANDONAR. ?     S/N");
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
}
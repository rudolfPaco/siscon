/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.conmae;

import SIGU.campoTexto.IUAreaTexto;
import SIGU.campoTexto.IUCampoTexto;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.paneles.IUPanel;
import SIGU.paneles.IUPanelEtiqueta;
import SIGU.recursos.Area;
import SIGU.recursos.Fecha;
import SIGU.ventanas.IUSecundario;
import com.siscon.controller.CConmae;
import com.siscon.model.Conmae;
import com.siscon.model.Tabvar;
import com.siscon.model.Usuario;
import com.siscon.recursos.Ayuda;
import com.siscon.view.VPrincipal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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
                    private IUEtiqueta iuEtiquetaFechas;
                    private IUEtiqueta iuEtiquetaDesde;
                    private IUCampoTexto iuDesde;
                    private IUEtiqueta iuEtiquetaHasta;
                    private IUCampoTexto iuHasta;
                private IUPanel panelDos;
                    private IUPanelEtiqueta iuComprobantes;
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
    
    private final Usuario usuario;
    private final Tabvar tabvar;
    
    public VActualizacionDiferida(VPrincipal ventanaPrincipal, String titulo, String tipoSize, Usuario usuario, Tabvar tabvar) {
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
        panelUno = new IUPanel(panelContenido, new Area(a.X(), a.Y(), a.An(), a.AlP(75)), true);
        construirPanelUno(new Area(2, 2, a.An() - 6, a.Al() - 8));
        
        panelDos = new IUPanel(panelContenido, new Area(a.X(), a.Y(2) + a.AlP(75), a.An(), a.AlP(25)), true);
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
        iuEtiquetaFechas = new IUEtiqueta(panelUno, "RANGOS DE FECHAS:", new Area(a.X(), a.Y(4) + a.AlP(65), a.AnP(30), a.AlP(5)), 16, "CENTER", true);
        iuEtiquetaDesde = new IUEtiqueta(panelUno, "DESDE:", new Area(a.X(2) + a.AnP(30), a.Y(4) + a.AlP(65), a.AnP(10), a.AlP(5)), 16, "CENTER", true);
        iuDesde = new IUCampoTexto(panelUno, "", 20, new Area(a.X(2) + a.AnP(40), a.Y(4) + a.AlP(65), a.AnP(20), a.AlP(5)));
        iuDesde.setEditar(false);
        iuEtiquetaHasta = new IUEtiqueta(panelUno, "HASTA:", new Area(a.X(2) + a.AnP(60), a.Y(4) + a.AlP(65), a.AnP(10), a.AlP(5)), 16, "CENTER", true);
        iuHasta = new IUCampoTexto(panelUno, "", 20, new Area(a.X(2) + a.AnP(70), a.Y(4) + a.AlP(65), a.AnP(20), a.AlP(5)));
        iuHasta.setEditar(false);
    }
    private void construirPanelDos(Area a){
        iuComprobantes = new IUPanelEtiqueta(panelDos, new Area(a.X(), a.Y() + a.AlP(5), a.AnP(30), a.AlP(5)), "Cant. COMPROBANTES", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuPanelDebe = new IUPanelEtiqueta(panelDos, new Area(a.X(2) + a.AnP(30), a.Y() + a.AlP(5), a.AnP(35), a.AlP(5)), "DEBE", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuPanelHaber = new IUPanelEtiqueta(panelDos, new Area(a.X(3) + a.AnP(65), a.Y() + a.AlP(5), a.AnP(35), a.AlP(5)), "HABER", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        
        iuCant = new IUCampoTexto(panelDos, "", 20, new Area(a.X(), a.Y(2) + a.AlP(10), a.AnP(30), a.AlP(5)));
        iuCant.setEditar(false);
        iuDebe = new IUCampoTexto(panelDos, "", 20, new Area(a.X(2) + a.AnP(30), a.Y(2) + a.AlP(10), a.AnP(35), a.AlP(5)));
        iuDebe.setEditar(false);
        iuHaber = new IUCampoTexto(panelDos, "", 20, new Area(a.X(3) + a.AnP(65), a.Y(2) + a.AlP(10), a.AnP(35), a.AlP(5)));
        iuHaber.setEditar(false);
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
    }
    private void algoritmosInicial(){                
        focoCampoS_N1();
    }
    private void focoCampoS_N1(){
        deshabilitarCampoS_N();
        campoS_N1.setVisible(true);
        campoS_N1.setEditar(true);
        campoS_N1.requestFocus();
        campoS_N1.setText("I");
        iuMensaje.setTexto("Desea (B)orrar o (I)nicializar los SALDOS  ?     B/I");
        campoS_N1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N1.getText()){
                        case "I":
                            setOpacity(0.5f);
                            if(Ayuda.mostrarMensajeConfirmacion(ventanaPrincipal, "Esta Seguro que desea INICIALIZAR todos los SALDOS poniendolos a CERO. ?", "ADVERTENCIA")){
                                ArrayList<Conmae> lista = CConmae.getLista("SELECT * FROM CONMAE");
                                for (Conmae c : lista) {
                                    c.setAntdia(0);
                                    c.setAntmes(0);                                    
                                    c.setSalact(0);
                                    c.setDebano(0);
                                    c.setCreano(0);
                                    c.setDebmes(0);
                                    c.setCremes(0);
                                    c.setDebdia(0);
                                    c.setCredia(0);
                                    
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
                                }
                                Ayuda.mostrarMensajeInformacion(ventanaPrincipal, "se ha CEREADO TODOS LOS CAMPOS de la tabla CONMAE", "CORRECTO");
                            }
                            setOpacity(1f);
                            focoCampoSalir();
                        break;
                        case "B":
                        break;
                    }
                }
            }
        });        
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
        iuMensaje.setTexto("Se ha BORRADO TODOS LOS SALDOS, Desea Salir de la INTERFAZ ACTUALIZACION DIFERIDA. ?     S/N");
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
                        break;
                    }
                }
            }
        });
    }
}
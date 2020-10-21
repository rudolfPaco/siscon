/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.conmae;

import SIGU.campoTexto.IUCampoTexto;
import SIGU.comboBox.IUComboBox;
import SIGU.comboBox.ModeloComboBox;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.paneles.IUPanel;
import SIGU.paneles.IUPanelEtiqueta;
import SIGU.recursos.Area;
import SIGU.recursos.Fecha;
import SIGU.tablas.IUTabla;
import SIGU.tablas.ModeloTabla;
import SIGU.ventanas.IUSecundario;
import com.siscon.controller.CConmae;
import com.siscon.model.Conmae;
import com.siscon.model.Tabvar;
import com.siscon.model.Usuario;
import com.siscon.recursos.Ayuda;
import com.siscon.view.VPrincipal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author neo
 */
public class VConmae extends IUSecundario{
    
    private VPrincipal ventanaPrincipal;
    private IUPanel panel;
        private IUPanel panelTitulo;
            private IUEtiqueta iuTitulo;
        private IUPanel panelDatos;
            private IUPanel primerPanel;
                private IUPanel panelCabecera;
                    private IUPanelEtiqueta etiquetaCodigo;
                    private IUPanelEtiqueta etiquetaDescripcion;
                    private IUPanelEtiqueta etiquetaNivel;
                    private IUPanelEtiqueta etiquetaActividad;
                    private IUPanelEtiqueta etiquetaPresup;
                private IUPanel panelPrimerRegistro;
                    private IUPanelEtiqueta etiquetaG;
                    private IUCampoTexto campoG;
                    private IUPanelEtiqueta etiquetaS;
                    private IUCampoTexto campoS;
                    private IUPanelEtiqueta etiquetaMy;
                    private IUCampoTexto campoMy;
                    private IUPanelEtiqueta etiquetaAn;
                    private IUCampoTexto campoAn;
                    private IUPanelEtiqueta etiquetaSa;
                    private IUCampoTexto campoSa;
                    private IUCampoTexto campoDescripcion;
                    private IUCampoTexto campoNivel;
                    private IUCampoTexto campoActividad;
                    private IUCampoTexto campoLugar;
            private IUPanel segundoPanel;
                private IUCampoTexto campoG1;
                private IUCampoTexto campoS1;
                private IUCampoTexto campoMy1;
                private IUCampoTexto campoAn1;
                private IUCampoTexto campoSa1;
                private IUCampoTexto campoDescripcion1;
                private IUCampoTexto campoNivel1;
                private IUCampoTexto campoActividad1;
                private IUCampoTexto campoLugar1;
                
                private IUCampoTexto campoG2;
                private IUCampoTexto campoS2;
                private IUCampoTexto campoMy2;
                private IUCampoTexto campoAn2;
                private IUCampoTexto campoSa2;
                private IUCampoTexto campoDescripcion2;
                private IUCampoTexto campoNivel2;
                private IUCampoTexto campoActividad2;
                private IUCampoTexto campoLugar2;
                
                private IUCampoTexto campoG3;
                private IUCampoTexto campoS3;
                private IUCampoTexto campoMy3;
                private IUCampoTexto campoAn3;
                private IUCampoTexto campoSa3;
                private IUCampoTexto campoDescripcion3;
                private IUCampoTexto campoNivel3;
                private IUCampoTexto campoActividad3;
                private IUCampoTexto campoLugar3;
                
                private IUCampoTexto campoG4;
                private IUCampoTexto campoS4;
                private IUCampoTexto campoMy4;
                private IUCampoTexto campoAn4;
                private IUCampoTexto campoSa4;
                private IUCampoTexto campoDescripcion4;
                private IUCampoTexto campoNivel4;
                private IUCampoTexto campoActividad4;
                private IUCampoTexto campoLugar4;
                
                private IUCampoTexto campoG5;
                private IUCampoTexto campoS5;
                private IUCampoTexto campoMy5;
                private IUCampoTexto campoAn5;
                private IUCampoTexto campoSa5;
                private IUCampoTexto campoDescripcion5;
                private IUCampoTexto campoNivel5;
                private IUCampoTexto campoActividad5;
                private IUCampoTexto campoLugar5;
                
            private IUPanel tercerPanel;
                private IUEtiqueta iuTituloMensaje;
                private IUPanelEtiqueta iuMensaje;
                private IUPanelEtiqueta iuInformacion;
                private IUCampoTexto campoS_N1;
                private IUCampoTexto campoS_N2;
                private IUCampoTexto campoS_N3;
                private IUCampoTexto campoS_N4;
                private IUCampoTexto campoS_N5;
            
            private IUPanel cuartoPanel;
                private IUEtiqueta iuTituloTabla;
                private IUTabla iuTabla;
        
    private int G;
    private int S;
    private int My;
    private int An;
    private int Sa;
    
    private int indice;
    private String descripcion;
    private String OPCION;
    
    private final Usuario usuario;
    private final Tabvar tabvar;
    private Conmae conmae;
    
    public VConmae(VPrincipal ventanaPrincipal, String titulo, String tipoSize, Usuario usuario, Tabvar tabvar) {
        super(ventanaPrincipal, titulo, tipoSize);
               
        this.ventanaPrincipal = ventanaPrincipal;
        this.usuario = usuario;
        this.tabvar = tabvar;
        this.conmae = null;
        this.G = 0;
        this.S = 0;
        this.My = 0;
        this.An = 0;
        this.Sa = 0;
        this.indice = 0;
        this.descripcion = "";
        this.OPCION = "";        
        construirPanel(new Area(An()-6, Al()-29));
        algoritmoInicial();
    }
    private void construirPanel(Area a){
        panel = new IUPanel(this, new Area(a.X(), a.Y(), a.An(), a.Al()), true);
        construirPaneles(new Area(2, 2, panel.area.An() - 4, panel.area.Al() - 4));
        panel.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "ESC" );
        panel.getActionMap().put( "ESC", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                dispose();
            }
        });
    }
    private void construirPaneles(Area a){
        panelTitulo = new IUPanel(panel, new Area(a.X(), a.Y(), a.An(), a.AlP(7)), true, Ayuda.COLOR_FONDO);
        construirPanelTitulo(new Area(2, 2, panelTitulo.area.An() - 4, panelTitulo.area.Al() - 4));
        
        panelDatos = new IUPanel(panel, new Area(a.X(), a.Y(2) + a.AlP(7), a.An(), a.AlP(93)), true, Ayuda.COLOR_FONDO);
        construirPanelDatos(new Area(2, 2, panelDatos.area.An() - 4, panelDatos.area.Al() - 10));
    }
    private void construirPanelTitulo(Area a){
        iuTitulo = new IUEtiqueta(panelTitulo, usuario.getRazsoc(), new Area(a.X(), a.Y(), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "PROCESOS PLAN DE CUENTAS", new Area(a.X(2) + a.AnP(25), a.Y(), a.AnP(35), a.AlP(50)), 16, "CENTER", false);
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "SISTEMA CONTABLE SISCON @v7.1. 2020", new Area(a.X(3) + a.AnP(60), a.Y(), a.AnP(40), a.AlP(50)), 16, "CENTER", false); 
        
        iuTitulo = new IUEtiqueta(panelTitulo, "USUARIO: "+tabvar.getDescri(), new Area(a.X(), a.Y(2) + a.AlP(50), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "FECHA: "+new Fecha().getFecha1(), new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(50), a.AnP(40), a.AlP(50)), 16, "CENTER", false);
    }
    private void construirPanelDatos(Area a){
        primerPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(), a.An(), a.AlP(12)), false, Ayuda.COLOR_FONDO);
        construirPrimerPanel(new Area(2, 2, primerPanel.area.An() - 4, primerPanel.area.Al() - 6));
        
        segundoPanel = new IUPanel(panelDatos, new Area(a.X(2), a.Y(2) + a.AlP(12), a.An() - a.X(2), a.AlP(21)), false, Ayuda.COLOR_FONDO);
        construirSegundoPanel(new Area(2, 2, segundoPanel.area.An() - 22, segundoPanel.area.Al() - 12));
        
        tercerPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(3) + a.AlP(33), a.An(), a.AlP(15)), false, Ayuda.COLOR_FONDO);
        construirTercerPanel(new Area(2, 2, tercerPanel.area.An() - 6, tercerPanel.area.Al() - 8));
        
        cuartoPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(4) + a.AlP(48), a.An(), a.AlP(52)), false, Ayuda.COLOR_FONDO);
        construirCuartoPanel(new Area(2, 2, cuartoPanel.area.An() - 4, cuartoPanel.area.Al() - 6));
    }
    private void construirPrimerPanel(Area a){
        panelCabecera = new IUPanel(primerPanel, new Area(a.X(), a.Y(), a.An(), a.AlP(35)), false, Ayuda.COLOR_FONDO);
        construirPanelCabecera(new Area(2, 2, panelCabecera.area.An() - 12, panelCabecera.area.Al() - 4));
        
        panelPrimerRegistro = new IUPanel(primerPanel, new Area(a.X(), a.Y(2) + a.AlP(35), a.An(), a.AlP(65)), false, Ayuda.COLOR_FONDO);
        construirPanelPrimerRegistro(new Area(2, 2, panelPrimerRegistro.area.An() - 20, panelPrimerRegistro.area.Al() - 6));
    }
    private void construirPanelCabecera(Area a){
        etiquetaCodigo = new IUPanelEtiqueta(panelCabecera, new Area(a.X(), a.Y(), a.AnP(26), a.Al()), "CODIGO", 18, SwingConstants.CENTER, Color.orange, true);
        etiquetaDescripcion = new IUPanelEtiqueta(panelCabecera, new Area(a.X(2) + a.AnP(26), a.Y(), a.AnP(44), a.Al()), "DESCRIPCION", 18, SwingConstants.CENTER, Color.orange, true);
        etiquetaNivel = new IUPanelEtiqueta(panelCabecera, new Area(a.X(3) + a.AnP(70), a.Y(), a.AnP(10), a.Al()), "NIVEL", 18, SwingConstants.CENTER, Color.orange, true);
        etiquetaActividad = new IUPanelEtiqueta(panelCabecera, new Area(a.X(4) + a.AnP(80), a.Y(), a.AnP(10), a.Al()), "ACTIVI", 18, SwingConstants.CENTER, Color.orange, true);
        etiquetaPresup = new IUPanelEtiqueta(panelCabecera, new Area(a.X(5) + a.AnP(90), a.Y(), a.AnP(10), a.Al()), "LUGAR", 18, SwingConstants.CENTER, Color.orange, true);
    }
    private void construirPanelPrimerRegistro(Area a){
        etiquetaG = new IUPanelEtiqueta(panelPrimerRegistro, new Area(a.X(2), a.Y(), a.AnP(5), a.AlP(40)), "G", 16, SwingConstants.CENTER, Color.orange, true);
        campoG = new IUCampoTexto(panelPrimerRegistro, 1, 16, new Area(a.X(2), a.Y(2) + a.AlP(40), a.AnP(5), a.AlP(60)), SwingConstants.CENTER);
        campoG.setRestriccion("^([1-4]|[1-4])$");
        
        etiquetaS = new IUPanelEtiqueta(panelPrimerRegistro, new Area(a.X(3) + a.AnP(5), a.Y(), a.AnP(5), a.AlP(40)), "S", 16, SwingConstants.CENTER, Color.orange, true);
        campoS = new IUCampoTexto(panelPrimerRegistro, 1, 16, new Area(a.X(3) + a.AnP(5), a.Y(2) + a.AlP(40), a.AnP(5), a.AlP(60)), SwingConstants.CENTER);
        campoS.setRestriccion("^([0-9]|[0-9])$");
        
        etiquetaMy = new IUPanelEtiqueta(panelPrimerRegistro, new Area(a.X(4) + a.AnP(10), a.Y(), a.AnP(5), a.AlP(40)), "My", 16, SwingConstants.CENTER, Color.orange, true);
        campoMy = new IUCampoTexto(panelPrimerRegistro, 2, 16, new Area(a.X(4) + a.AnP(10), a.Y(2) + a.AlP(40), a.AnP(5), a.AlP(60)), SwingConstants.CENTER);
        campoMy.setRestriccion("^([0-99]|[0-99])$");
        
        etiquetaAn = new IUPanelEtiqueta(panelPrimerRegistro, new Area(a.X(5) + a.AnP(15), a.Y(), a.AnP(5), a.AlP(40)), "An", 16, SwingConstants.CENTER, Color.orange, true);
        campoAn = new IUCampoTexto(panelPrimerRegistro, 2, 16, new Area(a.X(5) + a.AnP(15), a.Y(2) + a.AlP(40), a.AnP(5), a.AlP(60)), SwingConstants.CENTER);
        campoAn.setRestriccion("^([0-99]|[0-99])$");
        
        etiquetaSa = new IUPanelEtiqueta(panelPrimerRegistro, new Area(a.X(6) + a.AnP(20), a.Y(), a.AnP(5), a.AlP(40)), "Sa", 16, SwingConstants.CENTER, Color.orange, true);
        campoSa = new IUCampoTexto(panelPrimerRegistro, 2, 16, new Area(a.X(6) + a.AnP(20), a.Y(2) + a.AlP(40), a.AnP(5), a.AlP(60)), SwingConstants.CENTER);
        campoSa.setRestriccion("^([0-99]|[0-99])$");
        
        campoDescripcion = new IUCampoTexto(panelPrimerRegistro, 50, 16, new Area(a.X(7) + a.AnP(26), a.Y(2) + a.AlP(40), a.AnP(43), a.AlP(60)), SwingConstants.LEFT);
        campoDescripcion.setRestriccion("[\\p{Alpha}\\p{Alnum}\\p{Space}\\.\\/\\(\\)\\-]");
        
        campoNivel = new IUCampoTexto(panelPrimerRegistro, 1, 16, new Area(a.X(9) + a.AnP(72), a.Y(2) + a.AlP(40), a.AnP(5), a.AlP(60)), SwingConstants.CENTER);
        campoNivel.setRestriccion("^([1-5]|[1-5])$");
        campoNivel.setEditar(false);
        
        campoActividad = new IUCampoTexto(panelPrimerRegistro, 1, 16, new Area(a.X(10) + a.AnP(82), a.Y(2) + a.AlP(40), a.AnP(5), a.AlP(60)), SwingConstants.CENTER);
        campoActividad.setRestriccion("^([1-2]|[1-2])$");
        campoActividad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoActividad.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoActividad.setText("N");
                }
            }
        });
        
        campoLugar = new IUCampoTexto(panelPrimerRegistro, 2, 16, new Area(a.X(11) + a.AnP(92), a.Y(2) + a.AlP(40), a.AnP(5), a.AlP(60)), SwingConstants.CENTER);
        campoLugar.setRestriccion("^([0-99]|[0-99])$");
    }
    
    private void construirSegundoPanel(Area a){
        campoG1 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(2), a.Y(), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoS1 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(3) + a.AnP(5), a.Y(), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoMy1 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(4) + a.AnP(10), a.Y(), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoAn1 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(5) + a.AnP(15), a.Y(), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoSa1 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(6) + a.AnP(20), a.Y(), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoDescripcion1 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(7) + a.AnP(26), a.Y(), a.AnP(43), a.AlP(20)), SwingConstants.LEFT);
        campoNivel1 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(9) + a.AnP(72), a.Y(), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);        
        campoActividad1 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(11) + a.AnP(82), a.Y(), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoLugar1 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(12) + a.AnP(92), a.Y(), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoG1.setEditar(false);
        campoS1.setEditar(false);
        campoMy1.setEditar(false);
        campoAn1.setEditar(false);
        campoSa1.setEditar(false);
        campoDescripcion1.setEditar(false);
        campoNivel1.setEditar(false);
        campoActividad1.setEditar(false);
        campoLugar1.setEditar(false);
        
        campoG2 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(2), a.Y(2) + a.AlP(20), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoS2 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(3) + a.AnP(5), a.Y(2) + a.AlP(20), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoMy2 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(4) + a.AnP(10), a.Y(2) + a.AlP(20), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoAn2 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(5) + a.AnP(15), a.Y(2) + a.AlP(20), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoSa2 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(6) + a.AnP(20), a.Y(2) + a.AlP(20), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoDescripcion2 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(7) + a.AnP(29), a.Y(2) + a.AlP(20), a.AnP(40), a.AlP(20)), SwingConstants.LEFT);
        campoNivel2 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(9) + a.AnP(72), a.Y(2) + a.AlP(20), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);        
        campoActividad2 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(11) + a.AnP(82), a.Y(2) + a.AlP(20), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoLugar2 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(12) + a.AnP(92), a.Y(2) + a.AlP(20), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoG2.setEditar(false);
        campoS2.setEditar(false);
        campoMy2.setEditar(false);
        campoAn2.setEditar(false);
        campoSa2.setEditar(false);
        campoDescripcion2.setEditar(false);
        campoNivel2.setEditar(false);
        campoActividad2.setEditar(false);
        campoLugar2.setEditar(false);
        
        campoG3 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(2), a.Y(3) + a.AlP(40), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoS3 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(3) + a.AnP(5), a.Y(3) + a.AlP(40), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoMy3 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(4) + a.AnP(10), a.Y(3) + a.AlP(40), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoAn3 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(5) + a.AnP(15), a.Y(3) + a.AlP(40), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoSa3 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(6) + a.AnP(20), a.Y(3) + a.AlP(40), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoDescripcion3 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(7) + a.AnP(32), a.Y(3) + a.AlP(40), a.AnP(37), a.AlP(20)), SwingConstants.LEFT);
        campoNivel3 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(9) + a.AnP(72), a.Y(3) + a.AlP(40), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);        
        campoActividad3 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(11) + a.AnP(82), a.Y(3) + a.AlP(40), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoLugar3 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(12) + a.AnP(92), a.Y(3) + a.AlP(40), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoG3.setEditar(false);
        campoS3.setEditar(false);
        campoMy3.setEditar(false);
        campoAn3.setEditar(false);
        campoSa3.setEditar(false);
        campoDescripcion3.setEditar(false);
        campoNivel3.setEditar(false);
        campoActividad3.setEditar(false);
        campoLugar3.setEditar(false);
        
        campoG4 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(2), a.Y(4) + a.AlP(60), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoS4 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(3) + a.AnP(5), a.Y(4) + a.AlP(60), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoMy4 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(4) + a.AnP(10), a.Y(4) + a.AlP(60), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoAn4 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(5) + a.AnP(15), a.Y(4) + a.AlP(60), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoSa4 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(6) + a.AnP(20), a.Y(4) + a.AlP(60), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoDescripcion4 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(7) + a.AnP(35), a.Y(4) + a.AlP(60), a.AnP(34), a.AlP(20)), SwingConstants.LEFT);
        campoNivel4 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(9) + a.AnP(72), a.Y(4) + a.AlP(60), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);        
        campoActividad4 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(11) + a.AnP(82), a.Y(4) + a.AlP(60), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoLugar4 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(12) + a.AnP(92), a.Y(4) + a.AlP(60), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoG4.setEditar(false);
        campoS4.setEditar(false);
        campoMy4.setEditar(false);
        campoAn4.setEditar(false);
        campoSa4.setEditar(false);
        campoDescripcion4.setEditar(false);
        campoNivel4.setEditar(false);
        campoActividad4.setEditar(false);
        campoLugar4.setEditar(false);
        
        campoG5 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(2), a.Y(5) + a.AlP(80), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoS5 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(3) + a.AnP(5), a.Y(5) + a.AlP(80), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoMy5 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(4) + a.AnP(10), a.Y(5) + a.AlP(80), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoAn5 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(5) + a.AnP(15), a.Y(5) + a.AlP(80), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoSa5 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(6) + a.AnP(20), a.Y(5) + a.AlP(80), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoDescripcion5 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(7) + a.AnP(38), a.Y(5) + a.AlP(80), a.AnP(31), a.AlP(20)), SwingConstants.LEFT);
        campoNivel5 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(9) + a.AnP(72), a.Y(5) + a.AlP(80), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);        
        campoActividad5 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(11) + a.AnP(82), a.Y(5) + a.AlP(80), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoLugar5 = new IUCampoTexto(segundoPanel, 1, 16, new Area(a.X(12) + a.AnP(92), a.Y(5) + a.AlP(80), a.AnP(5), a.AlP(20)), SwingConstants.CENTER);
        campoG5.setEditar(false);
        campoS5.setEditar(false);
        campoMy5.setEditar(false);
        campoAn5.setEditar(false);
        campoSa5.setEditar(false);
        campoDescripcion5.setEditar(false);
        campoNivel5.setEditar(false);
        campoActividad5.setEditar(false);
        campoLugar5.setEditar(false);
    }
    
    private void construirTercerPanel(Area a){
        iuTituloMensaje = new IUEtiqueta(tercerPanel, "Mensajes - Instrucciones", new Area(a.X(), a.Y(), a.AnP(80), a.AlP(20)), 16, "CENTER", false);
        iuMensaje = new IUPanelEtiqueta(tercerPanel, new Area(a.X(), a.Y(2) + a.AlP(20), a.AnP(80), a.AlP(40)), "", 16, SwingConstants.LEFT, Ayuda.COLOR_ATENCION, true);
        iuInformacion = new IUPanelEtiqueta(tercerPanel, new Area(a.X(), a.Y(3) + a.AlP(60), a.AnP(80), a.AlP(40)), "", 16, SwingConstants.LEFT, Ayuda.COLOR_FONDO, true);
        campoS_N1 = new IUCampoTexto(tercerPanel, 1, 20, new Area(a.X(2) + a.AnP(80), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);        
        campoS_N1.setVisible(false);
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
        campoS_N2 = new IUCampoTexto(tercerPanel, 1, 20, new Area(a.X(2) + a.AnP(80), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);        
        campoS_N2.setVisible(false);
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
        campoS_N3 = new IUCampoTexto(tercerPanel, 1, 20, new Area(a.X(2) + a.AnP(80), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);        
        campoS_N3.setVisible(false);
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
        campoS_N4 = new IUCampoTexto(tercerPanel, 1, 20, new Area(a.X(2) + a.AnP(80), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);        
        campoS_N4.setVisible(false);
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
    }
    
    private void construirCuartoPanel(Area a){
        iuTituloTabla = new IUEtiqueta(cuartoPanel, "PLAN DE CUENTAS", new Area(a.X(), a.Y(), a.An(), a.AlP(5)), 16, "CENTER", false);
        iuTabla = new IUTabla(
        cuartoPanel, 
        new Area(a.X(), a.Y(2) + a.AlP(5), a.An(), a.AlP(95)), 
        new String[]{"CODIGO", "G", "S", "My", "An", "Sa", "DESCRIPCION", "NIVEL", "ACTIVIDAD", "LUGAR"}, new Class[]{Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, Integer.class, Integer.class, Integer.class}, 
        new int[]{11, 5, 5, 5, 5, 5, 37, 9, 9, 9}, new ArrayList(), new ModeloTabla<Conmae>(){
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return lista.get(rowIndex).getCuetot();
                    case 1:                
                        return lista.get(rowIndex).getGrup();
                    case 2:                
                        return lista.get(rowIndex).getSubgru();
                    case 3:
                        return lista.get(rowIndex).getMayor();
                    case 4:
                        return lista.get(rowIndex).getCuenta();
                    case 5:
                        return lista.get(rowIndex).getSubcta();    
                    case 6:
                        return lista.get(rowIndex).getDescri();
                    case 7:
                        return lista.get(rowIndex).getNivel();
                    case 8:
                        return lista.get(rowIndex).getActivi();
                    case 9:
                        return lista.get(rowIndex).getLugar();
                    default:
                        return null;
                }
            }
        });
        iuTabla.tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    private void algoritmoInicial(){
        campoDescripcion.setEditar(false);
        campoActividad.setEditar(false);
        campoLugar.setEditar(false);
        
        campoG.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoG();
            }
        });
        campoS.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoS();
            }
        });
        campoMy.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoMy();
            }
        });
        campoAn.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoAn();
            }
        });
        campoSa.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoSa();
            }
        });
    }
    private void focoCampoG(){
        iuMensaje.setTexto("Digite GRUPO (n1), [F1]=Ayuda, [F7]=Consulta o [F8]=Limpia Campos");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F2]=Retrocede o [Esc]=Suspende Programa.");
        
        campoG.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!campoG.getText().isEmpty()){
                        G = Integer.parseInt(campoG.getText());
                        
                        campoLugar.setText(String.valueOf(G));
                        campoNivel.setText("1");
                        
                        iuTabla.actualizarTabla(CConmae.getLista("SELECT * FROM CONMAE WHERE GRUP = "+G));                        
                        cargarDatos(CConmae.getConmae("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = "+S+" AND MAYOR = "+My+" AND CUENTA = "+An+" AND SUBCTA = "+Sa), 1);
                        campoG.transferFocus();
                    }
                }                
            }
        });
    }
    private void focoCampoS(){
        iuMensaje.setTexto("Digite el SUBGRUPO de la cuenta (n1).");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F2]=Retrocede, [Esc]=Suspende Programa o [F5]=Seleccionar Registro en la Tabla");
        campoS.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!campoS.getText().isEmpty()){
                        G = Integer.parseInt(campoG.getText());
                        S = Integer.parseInt(campoS.getText());
                        
                        campoLugar.setText(String.valueOf(G));
                        
                        campoActividad.setText("1");
                        
                        if(S > 0){
                            campoNivel.setText("2");
                            iuTabla.actualizarTabla(CConmae.getLista("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = "+S));
                            cargarDatos(CConmae.getConmae("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = "+S+" AND MAYOR = "+My+" AND CUENTA = "+An+" AND SUBCTA = "+Sa), 2);
                        }else{
                            iuTabla.actualizarTabla(new ArrayList());
                        }
                        campoS.transferFocus();
                    }
                }else
                    if(KeyEvent.VK_F5 == e.getKeyCode()){
                        focoCampoTabla("S", 1);
                    }
            }
        });
    }
    
    private void focoCampoMy(){
        iuMensaje.setTexto("Digite el MAYOR de la cuenta (n2).");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F2]=Retrocede, [Esc]=Suspende Programa o [F5]=Seleccionar Registro en la Tabla");
        campoMy.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!campoMy.getText().isEmpty()){
                        G = Integer.parseInt(campoG.getText());
                        S = Integer.parseInt(campoS.getText());
                        My = Integer.parseInt(campoMy.getText());
                        
                        campoActividad.setText("1");
                        
                        if(My > 0){
                            campoNivel.setText("3");
                            iuTabla.actualizarTabla(CConmae.getLista("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = "+S+" AND MAYOR = "+My));
                            cargarDatos(CConmae.getConmae("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = "+S+" AND MAYOR = "+My+" AND CUENTA = "+An+" AND SUBCTA = "+Sa), 3);
                        }else{
                            iuTabla.actualizarTabla(new ArrayList());
                        }                        
                        campoMy.transferFocus();
                    }
                }else
                    if(KeyEvent.VK_F5 == e.getKeyCode()){
                        focoCampoTabla("My", 2);
                    }
            }
        });
    }
    private void focoCampoAn(){
        iuMensaje.setTexto("Digite el ANALITICO de la cuenta (n2).");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F2]=Retrocede, [Esc]=Suspende Programa o [F5]=Seleccionar Registro en la Tabla");
        campoAn.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!campoAn.getText().isEmpty()){
                        G = Integer.parseInt(campoG.getText());
                        S = Integer.parseInt(campoS.getText());
                        My = Integer.parseInt(campoMy.getText());
                        An = Integer.parseInt(campoAn.getText());
                                                
                        campoActividad.setText("1");
                        
                        if(An > 0){
                            campoNivel.setText("4");
                            iuTabla.actualizarTabla(CConmae.getLista("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = "+S+" AND MAYOR = "+My+" AND CUENTA = "+An));
                            cargarDatos(CConmae.getConmae("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = "+S+" AND MAYOR = "+My+" AND CUENTA = "+An+" AND SUBCTA = "+Sa), 4);
                        }else{
                            iuTabla.actualizarTabla(new ArrayList());
                        }                        
                        campoAn.transferFocus();
                    }
                }else                    
                    if(KeyEvent.VK_F5 == e.getKeyCode()){
                        focoCampoTabla("An", 3);
                    }
            }
        });
    }
    private void focoCampoSa(){
        iuMensaje.setTexto("Confirme o Digite el SUBANALITICO de la cuenta (n2).");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F2]=Retrocede, [Esc]=Suspende Programa o [F5]=Seleccionar Registro en la Tabla");
        campoSa.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!campoSa.getText().isEmpty()){
                        G = Integer.parseInt(campoG.getText());
                        S = Integer.parseInt(campoS.getText());
                        My = Integer.parseInt(campoMy.getText());
                        An = Integer.parseInt(campoAn.getText());
                        Sa = Integer.parseInt(campoSa.getText());
                                                
                        campoActividad.setText("1");
                        
                        if(Sa > 0)
                            campoNivel.setText("5");                                                        
                        else
                            iuTabla.actualizarTabla(new ArrayList());
                        
                        iuTabla.actualizarTabla(CConmae.getLista("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = "+S+" AND MAYOR = "+My+" AND CUENTA = "+An+" AND SUBCTA = "+Sa));
                        Conmae conmae = CConmae.getConmae("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = "+S+" AND MAYOR = "+My+" AND CUENTA = "+An+" AND SUBCTA = "+Sa);
                        if(conmae != null){                                
                            focoCampoS_N1(conmae);
                        }else{
                            OPCION = "GUARDAR";
                            focoCampoDescripcion();
                        }
                    }
                }else
                    if(KeyEvent.VK_F5 == e.getKeyCode()){
                        focoCampoTabla("Sa", 4);
                    }
            }
        });
    }
    private void focoCampoDescripcion(){        
        restringirCampos("Descripcion", true);
        campoDescripcion.requestFocus();
        iuMensaje.setTexto("Digite DESCRIPCION  de la Cuenta (x28) o [F7]=Anterior");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [Esc]=Suspende Programa.");
        
        campoDescripcion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!campoDescripcion.getText().isEmpty()){
                        descripcion = campoDescripcion.getText();
                        focoCampoActividad();
                    }
                }
            }
        });
        campoDescripcion.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_F7, 0 ), "F7" );
        campoDescripcion.getActionMap().put( "F7", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                campoDescripcion.setText(descripcion);
            }
        });
    }
    private void focoCampoActividad(){
        restringirCampos("Descripcion", true);
        campoActividad.setEditar(true);
        campoActividad.requestFocus();
        iuMensaje.setTexto("Opciones: 1=NO Apropiable o 2=APROPIABLE en Comprobantes.");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F2]=Retrocede o [Esc]=Suspende Programa.");
        campoActividad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!campoActividad.getText().isEmpty()){
                        focoCampoLugar();
                    }
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoDescripcion();
                }
            }
        });
    }
    private void focoCampoLugar(){
        restringirCampos("Actividad", true);
        campoLugar.setEditar(true);
        campoLugar.requestFocus();
        iuMensaje.setTexto("Lugar en Flujo Fondos: 1=al DEBE o 2=al HABER.....");
        campoLugar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!campoLugar.getText().isEmpty()){
                        switch(OPCION){
                            case "MODIFICAR":
                                modificarConmae();                                
                            break;
                            case "GUARDAR":
                                guardarConmae();
                            break;
                        }
                    }
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoActividad();
                }
            }
        });
    }
    private void guardarConmae(){
        Conmae c = new Conmae(0);
        c.setGrup(Integer.parseInt(campoG.getText()));
        c.setSubgru(Integer.parseInt(campoS.getText()));
        c.setMayor(Integer.parseInt(campoMy.getText()));
        c.setCuenta(Integer.parseInt(campoAn.getText()));
        c.setSubcta(Integer.parseInt(campoSa.getText()));
        c.setCuetot(G*10000000 + S*1000000 + My*10000 + An*100 + Sa);
        c.setNumcue(0);
        c.setDescri(campoDescripcion.getText());
        c.setNivel(Integer.parseInt(campoNivel.getText()));
        c.setActivi(Integer.parseInt(campoActividad.getText()));
        c.setLugar(Integer.parseInt(campoLugar.getText()));
        c.setPresup(0);
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
        c.setIndica(0);
        c.setSalin2(0);
        c.setDebme2(0);
        c.setAntme2(0);
        c.setCreme2(0);
        c.setSalac2(0);
        c.setFecha(null);
        c.setNompre(0);
        c.setDeban2(0);
        c.setCrean2(0);
        c.setAntdi2(0);
        c.setDebdi2(0);
        c.setCredi2(0);
        c.setFecha2(null);
        
        setOpacity(0.5f);
        if(Ayuda.mostrarMensajeConfirmacion(ventanaPrincipal, "Esta seguro que quiere GUARDAR el nuevo Registro del PLAN DE CUENTAS...?", "CONFIRMACION")){
            if(CConmae.guardarConmae(c)){
                Ayuda.mostrarMensajeInformacion(ventanaPrincipal, "Se ha GUARDADO los datos del Registro CONMAE, CORRECTAMENTE....!", "CORRECTO");
                limpiarCampos();
                algoritmoInicial();
            }
        }
        setOpacity(1f);
    }
    private void modificarConmae(){
        conmae.setDescri(campoDescripcion.getText());
        conmae.setActivi(Integer.parseInt(campoActividad.getText()));
        conmae.setLugar(Integer.parseInt(campoLugar.getText()));
        
        setOpacity(0.5f);
        if(Ayuda.mostrarMensajeConfirmacion(ventanaPrincipal, "Esta seguro que desea MODIFICAR los datos del Registro PLAN DE CUENTAS...?", "CONFIRMACION")){
            if(CConmae.modificarConmae(conmae)){
                Ayuda.mostrarMensajeInformacion(ventanaPrincipal, "Se ha MODIFICADO los datos del Registro CONMAE, CORRECTAMENTE...!", "CORRECTO");
            }
        }
        setOpacity(1f);
        limpiarCampos();
        algoritmoInicial();
        
    }
    private void eliminarConmae(){
        setOpacity(0.5f);
        if(Ayuda.mostrarMensajeConfirmacion(ventanaPrincipal, "Esta seguro que desea ELIMINAR el Registro del PLAN DE CUENTAS....?", "CONFIRMACION")){
            if(CConmae.eliminarConmae(conmae)){
                Ayuda.mostrarMensajeInformacion(ventanaPrincipal, "Se ha ELIMINADO los datos del Registro CONMAE, CORRECTAMENTE...!", "CORRECTO");
            }
        }
        setOpacity(1f);
        limpiarCampos();
        algoritmoInicial();
    }
    private void focoCampoS_N1(Conmae c){
        restringirCampos("", false);
        campoS_N1.setVisible(true);
        campoS_N1.requestFocus();
        campoS_N1.setText("S");
        iuMensaje.setTexto("CUENTA EXISTE LA RECUPERO?? ....... S/N");        
        
        campoS_N1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N1.getText()){
                        case "S":
                            cargarDatos(c, 0);
                            campoS_N1.setVisible(false);
                            focoCampoS_N2(c);
                        break;
                        case "N":
                            limpiarCampos();
                        break;
                    }
                }
            }
        });
    }
    private void focoCampoS_N2(Conmae c){
        campoS_N2.setVisible(true);
        campoS_N2.requestFocus();
        campoS_N2.setText("S");
        iuMensaje.setTexto("DESEA MODIFICAR ....... S/N");
        
        campoS_N2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N2.getText()){
                        case "S":
                            OPCION = "MODIFICAR";
                            conmae = c;
                            campoS_N2.setVisible(false);
                            focoCampoDescripcion();
                        break;
                        case "N":
                            conmae = c;
                            campoS_N2.setVisible(false);
                            focoCampoS_N3();
                        break;
                    }
                }
            }
        });
    }
    private void focoCampoS_N3(){
        campoS_N3.setVisible(true);
        campoS_N3.requestFocus();
        campoS_N3.setText("N");
        iuMensaje.setTexto("ENTONCES ELIMINO???......S/N");
        campoS_N3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N3.getText()){
                        case "S":
                            eliminarConmae();
                        break;
                        case "N":
                            limpiarCampos();
                            algoritmoInicial();
                        break;
                    }
                }
            }
        });
    }
    private void limpiarCampos(){
        OPCION = "";        
        conmae = null;
        
        campoS_N1.setVisible(false);
        campoS_N2.setVisible(false);
        campoS_N3.setVisible(false);
        campoS_N4.setVisible(false);
        
        campoG.setText("");
        campoS.setText("");
        campoMy.setText("");
        campoAn.setText("");
        campoSa.setText("");
        campoDescripcion.setText("");
        campoNivel.setText("");
        campoActividad.setText("");
        campoLugar.setText("");
        iuTabla.actualizarTabla(new ArrayList());
        
        campoG.setEditar(true);
        campoS.setEditar(true);
        campoMy.setEditar(true);
        campoAn.setEditar(true);
        campoSa.setEditar(true);
        
        campoDescripcion.setEditar(false);
        campoActividad.setEditar(false);
        campoLugar.setEditar(false);
        
        campoG.requestFocus();
        
        G = 0;
        S = 0;
        My = 0;
        An = 0;
        Sa = 0;
        
        iuMensaje.setTexto("");
        iuInformacion.setTexto("");
        campoS_N1.setVisible(false);
        
        campoG1.setText("");
        campoS1.setText("");
        campoMy1.setText("");
        campoAn1.setText("");
        campoSa1.setText("");
        campoDescripcion1.setText("");
        campoNivel1.setText("");
        campoActividad1.setText("");
        campoLugar1.setText("");
        
        campoG2.setText("");
        campoS2.setText("");
        campoMy2.setText("");
        campoAn2.setText("");
        campoSa2.setText("");
        campoDescripcion2.setText("");
        campoNivel2.setText("");
        campoActividad2.setText("");
        campoLugar2.setText("");
        
        campoG3.setText("");
        campoS3.setText("");
        campoMy3.setText("");
        campoAn3.setText("");
        campoSa3.setText("");
        campoDescripcion3.setText("");
        campoNivel3.setText("");
        campoActividad3.setText("");
        campoLugar3.setText("");
        
        campoG4.setText("");
        campoS4.setText("");
        campoMy4.setText("");
        campoAn4.setText("");
        campoSa4.setText("");
        campoDescripcion4.setText("");
        campoNivel4.setText("");
        campoActividad4.setText("");
        campoLugar4.setText("");
        
        campoG5.setText("");
        campoS5.setText("");
        campoMy5.setText("");
        campoAn5.setText("");
        campoSa5.setText("");
        campoDescripcion5.setText("");
        campoNivel5.setText("");
        campoActividad5.setText("");
        campoLugar5.setText("");
    }
    private void restringirCampos(String campo, boolean respuesta){
        campoG.setEditar(false);
        campoS.setEditar(false);
        campoMy.setEditar(false);
        campoAn.setEditar(false);
        campoSa.setEditar(false);
        campoDescripcion.setEditar(false);
        campoNivel.setEditar(false);
        campoActividad.setEditar(false);
        campoLugar.setEditar(false);
        iuTabla.tabla.setFocusable(false);
        iuTabla.tabla.setEnabled(false);
        switch(campo){
            case "G":
                campoG.setEditar(respuesta);
            break;
            case "S":
                campoS.setEditar(respuesta);
            break;
            case "My":
                campoMy.setEditar(respuesta);
            break;
            case "An":
                campoAn.setEditar(respuesta);
            break;
            case "Sa":
                campoSa.setEditar(respuesta);
            break;
            case "Descripcion":
                campoDescripcion.setEditar(respuesta);
            break;
            case "Nivel":
                campoNivel.setEditar(respuesta);
            break;
            case "Actividad":
                campoActividad.setEditar(respuesta);
            break;
            case "Lugar":
                campoLugar.setEditar(respuesta);
            break;
            case "tabla":
                iuTabla.tabla.setFocusable(respuesta);
                iuTabla.tabla.setEnabled(respuesta);
            break;
            
            default:
            break;
        }
    }
    
    private void focoCampoTabla(String tipo, int numero){
        iuTabla.tabla.setFocusable(true);
        iuMensaje.setTexto("Navegue hacia arriba y abajo con las teclas [UP]=Arriba y [DOWN]=Abajo.");
        iuInformacion.setTexto("para seleccionar un registro presione la tecla [Enter]=Seleccionar");
        iuTabla.tabla.requestFocus();
        iuTabla.tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(iuTabla.isFilaSeleccionado()){
                    indice = iuTabla.tabla.getSelectedRow();
                }
            }
        });
        iuTabla.tabla.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        iuTabla.tabla.getActionMap().put("Enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switch(tipo){
                    case "S":
                        campoS.requestFocus();
                        cargarDatos((Conmae) iuTabla.modeloTabla.getFila(indice), numero);
                    break;
                    case "My":
                        campoMy.requestFocus();
                        cargarDatos((Conmae) iuTabla.modeloTabla.getFila(indice), numero);
                    break;
                    case "An":
                        campoAn.requestFocus();
                        cargarDatos((Conmae) iuTabla.modeloTabla.getFila(indice), numero);
                    break;
                    case "Sa":
                        campoSa.requestFocus();
                        cargarDatos((Conmae) iuTabla.modeloTabla.getFila(indice), numero);
                    break;
                }
                iuTabla.tabla.setFocusable(false);
                iuTabla.modeloTabla.fireTableDataChanged();
            }
        });
    }
    
    private void cargarDatos(Conmae c, int nroRegistro){
        if(c != null){
            switch(nroRegistro){
                case 0:
                    campoG.setText(String.valueOf(c.getGrup()));
                    campoS.setText(String.valueOf(c.getSubgru()));
                    campoMy.setText(String.valueOf(c.getMayor()));
                    campoAn.setText(String.valueOf(c.getCuenta()));
                    campoSa.setText(String.valueOf(c.getSubcta()));
                    campoDescripcion.setText(c.getDescri());
                    campoNivel.setText(String.valueOf(c.getNivel()));
                    campoActividad.setText(String.valueOf(c.getActivi()));
                    campoLugar.setText(String.valueOf(c.getLugar()));
                break;
                case 1:
                    campoG1.setText(String.valueOf(c.getGrup()));
                    campoS1.setText(String.valueOf(c.getSubgru()));
                    campoMy1.setText(String.valueOf(c.getMayor()));
                    campoAn1.setText(String.valueOf(c.getCuenta()));
                    campoSa1.setText(String.valueOf(c.getSubcta()));
                    campoDescripcion1.setText(c.getDescri());
                    campoNivel1.setText(String.valueOf(c.getNivel()));
                    campoActividad1.setText(String.valueOf(c.getActivi()));
                    campoLugar1.setText(String.valueOf(c.getLugar()));
                break;
                case 2:
                    campoG2.setText(String.valueOf(c.getGrup()));
                    campoS2.setText(String.valueOf(c.getSubgru()));
                    campoMy2.setText(String.valueOf(c.getMayor()));
                    campoAn2.setText(String.valueOf(c.getCuenta()));
                    campoSa2.setText(String.valueOf(c.getSubcta()));
                    campoDescripcion2.setText(c.getDescri());
                    campoNivel2.setText(String.valueOf(c.getNivel()));
                    campoActividad2.setText(String.valueOf(c.getActivi()));
                    campoLugar2.setText(String.valueOf(c.getLugar()));                
                break;
                case 3:
                    campoG3.setText(String.valueOf(c.getGrup()));
                    campoS3.setText(String.valueOf(c.getSubgru()));
                    campoMy3.setText(String.valueOf(c.getMayor()));
                    campoAn3.setText(String.valueOf(c.getCuenta()));
                    campoSa3.setText(String.valueOf(c.getSubcta()));
                    campoDescripcion3.setText(c.getDescri());
                    campoNivel3.setText(String.valueOf(c.getNivel()));
                    campoActividad3.setText(String.valueOf(c.getActivi()));
                    campoLugar3.setText(String.valueOf(c.getLugar()));                
                break;
                case 4:
                    campoG4.setText(String.valueOf(c.getGrup()));
                    campoS4.setText(String.valueOf(c.getSubgru()));
                    campoMy4.setText(String.valueOf(c.getMayor()));
                    campoAn4.setText(String.valueOf(c.getCuenta()));
                    campoSa4.setText(String.valueOf(c.getSubcta()));
                    campoDescripcion4.setText(c.getDescri());
                    campoNivel4.setText(String.valueOf(c.getNivel()));
                    campoActividad4.setText(String.valueOf(c.getActivi()));
                    campoLugar4.setText(String.valueOf(c.getLugar()));                
                break;
                case 5:
                    campoG5.setText(String.valueOf(c.getGrup()));
                    campoS5.setText(String.valueOf(c.getSubgru()));
                    campoMy5.setText(String.valueOf(c.getMayor()));
                    campoAn5.setText(String.valueOf(c.getCuenta()));
                    campoSa5.setText(String.valueOf(c.getSubcta()));
                    campoDescripcion5.setText(c.getDescri());
                    campoNivel5.setText(String.valueOf(c.getNivel()));
                    campoActividad5.setText(String.valueOf(c.getActivi()));
                    campoLugar5.setText(String.valueOf(c.getLugar()));                
                break;
                
                default:
                break;
            }
        }
        
    }    
}
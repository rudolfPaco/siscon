/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.conmae;

import SIGU.campoTexto.IUCampoTexto;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.paneles.IUPanel;
import SIGU.paneles.IUPanelEtiqueta;
import SIGU.recursos.Area;
import SIGU.tablas.ModeloTabla;
import SIGU.ventanas.IUSecundario;
import com.siscon.controller.CConmae;
import com.siscon.model.Conmae;
import com.siscon.model.Tabvar;
import com.siscon.model.Usuario;
import com.siscon.recursos.Ayuda;
import SIGU.tablas.RendererDatosTabla;
import SIGU.tablas.IUTabla;
import com.siscon.view.VPrincipal;
import java.awt.Color;
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
                    private IUCampoTexto campoPresup;
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
                
            private IUPanel cuartoPanel;
                private IUEtiqueta iuTituloMensaje;
                private IUPanelEtiqueta iuMensaje;
                private IUPanelEtiqueta iuInformacion;
                private IUCampoTexto campoS_N1;
                private IUCampoTexto campoS_N2;
                private IUCampoTexto campoS_N3;
                private IUCampoTexto campoS_N4;
                private IUCampoTexto campoS_N5;
            
            private IUPanel tercerPanel;
                private IUEtiqueta iuTituloTabla;
                private IUTabla iuTabla;
        
    private int G;
    private int S;
    private int My;
    private int An;
    private int Sa;
    
    private boolean restringir;
    private int indice;
    private String descripcion;
    private String OPCION;
    private String titulo;
    
    private final Usuario usuario;
    private final Tabvar tabvar;
    private Conmae conmae;
    private ArrayList<String> lista1 = new ArrayList<>();
    private ArrayList<String> lista2 = new ArrayList<>();
    private ArrayList<String> lista3 = new ArrayList<>();
    private ArrayList<String> lista4 = new ArrayList<>();
    private ArrayList<String> lista5 = new ArrayList<>();
    
    public VConmae(VPrincipal ventanaPrincipal, String titulo, String tipoSize, Usuario usuario, Tabvar tabvar) {
        super(ventanaPrincipal, titulo, tipoSize);
               
        this.ventanaPrincipal = ventanaPrincipal;
        this.titulo = titulo;
        this.usuario = usuario;
        this.tabvar = tabvar;
        this.conmae = null;
        this.G = 0;
        this.S = 0;
        this.My = 0;
        this.An = 0;
        this.Sa = 0;
        this.indice = 0;
        this.restringir = true;
        this.descripcion = "";
        this.OPCION = "";        
        construirPanel(new Area(An()-6, Al()-29));
        algoritmoInicial();
    }
    private void construirPanel(Area a){
        panel = new IUPanel(this, new Area(a.X(), a.Y(), a.An(), a.Al()), true);
        construirPaneles(new Area(2, 2, panel.area.An() - 4, panel.area.Al() - 4));
    }
    private void construirPaneles(Area a){
        panelTitulo = new IUPanel(panel, new Area(a.X(), a.Y(), a.An(), a.AlP(7)), true, Ayuda.COLOR_FONDO);
        construirPanelTitulo(new Area(2, 2, panelTitulo.area.An() - 4, panelTitulo.area.Al() - 4));
        
        panelDatos = new IUPanel(panel, new Area(a.X(), a.Y(2) + a.AlP(7), a.An(), a.AlP(93)), false);
        construirPanelDatos(new Area(2, 2, panelDatos.area.An() - 4, panelDatos.area.Al() - 10));
    }
    private void construirPanelTitulo(Area a){
        iuTitulo = new IUEtiqueta(panelTitulo, usuario.getRazsoc(), new Area(a.X(), a.Y(), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "PROCESOS PLAN DE CUENTAS", new Area(a.X(2) + a.AnP(25), a.Y(), a.AnP(35), a.AlP(50)), 16, "CENTER", false);
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, Ayuda.getDatoCadena("DESCRI", "SELECT DESCRI FROM TABVAR WHERE TIPO = 10 AND NUMERO = 1"), new Area(a.X(2) + a.AnP(25), a.Y(2) + a.AlP(50), a.AnP(35), a.AlP(50)), 16, "CENTER", Ayuda.COLOR_ROJO);
        iuTitulo.setSubrayarTexto(true);
        
        iuTitulo = new IUEtiqueta(panelTitulo, "SISTEMA CONTABLE SISCON @v7.2. 2020", new Area(a.X(3) + a.AnP(60), a.Y(), a.AnP(40), a.AlP(50)), 16, "CENTER", false); 
        
        iuTitulo = new IUEtiqueta(panelTitulo, "CONMAM1", new Area(a.X(), a.Y(2) + a.AlP(50), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
        //iuTitulo = new IUEtiqueta(panelTitulo, "FECHA: "+new Fecha().getFecha1(), new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(50), a.AnP(40), a.AlP(50)), 16, "CENTER", false);
    }
    private void construirPanelDatos(Area a){
        primerPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(), a.An(), a.AlP(12)), false);
        construirPrimerPanel(new Area(2, 2, primerPanel.area.An() - 4, primerPanel.area.Al() - 6));
        
        segundoPanel = new IUPanel(panelDatos, new Area(a.X(2), a.Y(2) + a.AlP(12), a.An() - a.X(2), a.AlP(21)), false);
        construirSegundoPanel(new Area(2, 2, segundoPanel.area.An() - 22, segundoPanel.area.Al() - 12));
        
        tercerPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(3) + a.AlP(33), a.An(), a.AlP(52)), false);
        construirTercerPanel(new Area(2, 2, tercerPanel.area.An() - 4, tercerPanel.area.Al() - 6));
        
        cuartoPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(4) + a.AlP(85), a.An(), a.AlP(15)), false);
        construirCuartoPanel(new Area(2, 2, cuartoPanel.area.An() - 6, cuartoPanel.area.Al() - 8));
    }
    
    private void construirPrimerPanel(Area a){
        panelCabecera = new IUPanel(primerPanel, new Area(a.X(), a.Y(), a.An(), a.AlP(35)), false);
        construirPanelCabecera(new Area(2, 2, panelCabecera.area.An() - 12, panelCabecera.area.Al() - 4));
        
        panelPrimerRegistro = new IUPanel(primerPanel, new Area(a.X(), a.Y(2) + a.AlP(35), a.An(), a.AlP(65)), false);
        construirPanelPrimerRegistro(new Area(2, 2, panelPrimerRegistro.area.An() - 20, panelPrimerRegistro.area.Al() - 6));
    }
    private void construirPanelCabecera(Area a){
        etiquetaCodigo = new IUPanelEtiqueta(panelCabecera, new Area(a.X(), a.Y(), a.AnP(26), a.Al()), "CODIGO", 18, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        etiquetaDescripcion = new IUPanelEtiqueta(panelCabecera, new Area(a.X(2) + a.AnP(26), a.Y(), a.AnP(44), a.Al()), "DESCRIPCION", 18, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        etiquetaNivel = new IUPanelEtiqueta(panelCabecera, new Area(a.X(3) + a.AnP(70), a.Y(), a.AnP(10), a.Al()), "NIVEL", 18, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        etiquetaActividad = new IUPanelEtiqueta(panelCabecera, new Area(a.X(4) + a.AnP(80), a.Y(), a.AnP(10), a.Al()), "ACTIVI", 18, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        etiquetaPresup = new IUPanelEtiqueta(panelCabecera, new Area(a.X(5) + a.AnP(90), a.Y(), a.AnP(10), a.Al()), "PRESUP", 18, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
    }
    private void construirPanelPrimerRegistro(Area a){
        etiquetaG = new IUPanelEtiqueta(panelPrimerRegistro, new Area(a.X(2), a.Y(), a.AnP(5), a.AlP(40)), "G", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        campoG = new IUCampoTexto(panelPrimerRegistro, 1, 16, new Area(a.X(2), a.Y(2) + a.AlP(40), a.AnP(5), a.AlP(60)), SwingConstants.CENTER);
        campoG.setRestriccion("^([1-4]|[1-4])$");
        
        etiquetaS = new IUPanelEtiqueta(panelPrimerRegistro, new Area(a.X(3) + a.AnP(5), a.Y(), a.AnP(5), a.AlP(40)), "S", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        campoS = new IUCampoTexto(panelPrimerRegistro, 1, 16, new Area(a.X(3) + a.AnP(5), a.Y(2) + a.AlP(40), a.AnP(5), a.AlP(60)), SwingConstants.CENTER);
        campoS.setRestriccion("^([0-9]|[0-9])$");
        
        etiquetaMy = new IUPanelEtiqueta(panelPrimerRegistro, new Area(a.X(4) + a.AnP(10), a.Y(), a.AnP(5), a.AlP(40)), "My", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        campoMy = new IUCampoTexto(panelPrimerRegistro, 2, 16, new Area(a.X(4) + a.AnP(10), a.Y(2) + a.AlP(40), a.AnP(5), a.AlP(60)), SwingConstants.CENTER);
        campoMy.setRestriccion("^([0-99]|[0-99])$");
        
        etiquetaAn = new IUPanelEtiqueta(panelPrimerRegistro, new Area(a.X(5) + a.AnP(15), a.Y(), a.AnP(5), a.AlP(40)), "An", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        campoAn = new IUCampoTexto(panelPrimerRegistro, 2, 16, new Area(a.X(5) + a.AnP(15), a.Y(2) + a.AlP(40), a.AnP(5), a.AlP(60)), SwingConstants.CENTER);
        campoAn.setRestriccion("^([0-99]|[0-99])$");
        
        etiquetaSa = new IUPanelEtiqueta(panelPrimerRegistro, new Area(a.X(6) + a.AnP(20), a.Y(), a.AnP(5), a.AlP(40)), "Sa", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
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
                if (KeyEvent.VK_1 == e.getKeyCode() || KeyEvent.VK_NUMPAD1 == e.getKeyCode()){
                    campoActividad.setText("1");
                }
                if(KeyEvent.VK_2 == e.getKeyCode() || KeyEvent.VK_NUMPAD2 == e.getKeyCode()){
                    campoActividad.setText("2");
                }
            }
        });
        
        campoPresup = new IUCampoTexto(panelPrimerRegistro, 1, 16, new Area(a.X(11) + a.AnP(92), a.Y(2) + a.AlP(40), a.AnP(5), a.AlP(60)), SwingConstants.CENTER);
        campoPresup.setRestriccion("^([0-1]|[0-1])$");
        campoPresup.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_0 == e.getKeyCode() || KeyEvent.VK_NUMPAD0 == e.getKeyCode()){
                    campoPresup.setText("0");
                }
                if(KeyEvent.VK_1 == e.getKeyCode() || KeyEvent.VK_NUMPAD1 == e.getKeyCode()){
                    campoPresup.setText("1");
                }
            }
        });
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
        iuTituloTabla = new IUEtiqueta(tercerPanel, "PLAN DE CUENTAS", new Area(a.X(), a.Y(), a.An(), a.AlP(5)), 16, "CENTER", false);
        iuTituloTabla.setSubrayarTexto(true);
        iuTabla = new IUTabla(
        tercerPanel, 
        new Area(a.X(), a.Y(2) + a.AlP(5), a.An(), a.AlP(95)), 
        new String[]{"CODIGO", "G", "S", "My", "An", "Sa", "DESCRIPCION", "NIVEL", "ACTIVIDAD", "SALDO"}, 
        new Class[]{Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, Integer.class, Integer.class, Double.class}, 
        new int[]{11, 5, 5, 5, 5, 5, 37, 9, 9, 9}, 
        new ArrayList(), 
        new ModeloTabla<Conmae>(){
            
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
                        return lista.get(rowIndex).getSalact();
                    default:
                        return null;
                }
            }
        });
        for (int i = 0; i < iuTabla.nombreCabecera.length; i++) {
            iuTabla.getColumnModel().getColumn(i).setCellRenderer(new RendererDatosTabla());
        }
    }
    
    private void construirCuartoPanel(Area a){
        iuTituloMensaje = new IUEtiqueta(cuartoPanel, "Mensajes - Instrucciones", new Area(a.X(), a.Y(), a.AnP(97), a.AlP(20)), 16, "CENTER", false);
        iuMensaje = new IUPanelEtiqueta(cuartoPanel, new Area(a.X(), a.Y(2) + a.AlP(20), a.AnP(97), a.AlP(40)), "", 16, SwingConstants.LEFT, Ayuda.COLOR_ATENCION, true);
        iuInformacion = new IUPanelEtiqueta(cuartoPanel, new Area(a.X(), a.Y(3) + a.AlP(60), a.AnP(97), a.AlP(40)), "", 16, SwingConstants.LEFT, Ayuda.COLOR_FONDO, true);
        campoS_N1 = new IUCampoTexto(cuartoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
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
        campoS_N2 = new IUCampoTexto(cuartoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);        
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
        campoS_N3 = new IUCampoTexto(cuartoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);        
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
        campoS_N4 = new IUCampoTexto(cuartoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);        
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
        campoS_N5 = new IUCampoTexto(cuartoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);        
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
    }
        
    private void algoritmoInicial(){
        campoDescripcion.setEditar(false);
        campoActividad.setEditar(false);
        campoPresup.setEditar(false);
        
        panel.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "ESC" );
        panel.getActionMap().put( "ESC", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                dispose();
            }
        });
        
        focoCampoG();
    }
    
    private void focoCampoG(){
        campoS_N1.setVisible(false);        
        campoG.setEditar(true);
        campoG.requestFocus();
        iuMensaje.setTexto("Digite GRUPO (n1)");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F3]=Limpia Campos o [Esc]=Suspende Programa.");          
        campoG.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!campoG.getText().isEmpty()){
                        G = Integer.parseInt(campoG.getText());
                        
                        //actualizarPaneles();
                        campoNivel.setText("1");
                        iuTabla.actualizarTabla(CConmae.getLista("SELECT * FROM CONMAE WHERE GRUP = "+G+" GROUP BY CUETOT "));                        
                        campoG.setText(String.valueOf(G));
                        
                        Conmae c = CConmae.getConmae("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = "+S+" AND MAYOR = "+My+" AND CUENTA = "+An+" AND SUBCTA = "+Sa);
                        if(c != null){
                            cargarDatos(CConmae.getConmae("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = "+S+" AND MAYOR = "+My+" AND CUENTA = "+An+" AND SUBCTA = "+Sa), 1);
                            descripcion = c.getDescri();
                        }
                        focoCampoS();
                    }
                }
                if(KeyEvent.VK_F3 == e.getKeyCode()){
                    limpiarCampos();
                }
                if(KeyEvent.VK_F7 == e.getKeyCode()){
                    campoG.setText(String.valueOf(G));
                    campoS.setText(String.valueOf(S));
                    campoMy.setText(String.valueOf(My));
                    campoAn.setText(String.valueOf(An));
                    campoSa.setText(String.valueOf(Sa));
                    cargarDatos(CConmae.getConmae("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = 0 AND MAYOR = 0 AND CUENTA = 0 AND SUBCTA = 0"), 1);
                    cargarDatos(CConmae.getConmae("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = "+S+" AND MAYOR = 0 AND CUENTA = 0 AND SUBCTA = 0"), 2);
                    cargarDatos(CConmae.getConmae("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = "+S+" AND MAYOR = "+My+" AND CUENTA = 0 AND SUBCTA = 0"), 3);
                    cargarDatos(CConmae.getConmae("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = "+S+" AND MAYOR = "+My+" AND CUENTA = "+An+" AND SUBCTA = "+Sa), 4);
                    focoCampoSa();
                }
            }
        });
    }
    private void focoCampoS(){ 
        campoS.setEditar(true);
        campoS.requestFocus();
        iuMensaje.setTexto("Digite el SUBGRUPO de la cuenta (n1).");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F2]=Retrocede, [F3]=Limpia Campos, [F5]=Seleccionar Registro en la Tabla o [Esc]=Suspende Programa");
        campoS.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!campoS.getText().isEmpty()){
                        G = Integer.parseInt(campoG.getText());
                        S = Integer.parseInt(campoS.getText());
                        
                        //actualizarPaneles();
                        campoPresup.setText("0");
                        campoActividad.setText("1");
                        
                        if(S > 0){
                            campoNivel.setText("2");
                            iuTabla.actualizarTabla(CConmae.getLista("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = "+S+" GROUP BY CUETOT "));                            
                            campoG.setText(String.valueOf(G));
                            campoS.setText(String.valueOf(S));
                            
                            cargarDatos(CConmae.getConmae("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = "+S+" AND MAYOR = "+My+" AND CUENTA = "+An+" AND SUBCTA = "+Sa), 2);
                        }else{
                            establecerNivel("S");
                            iuTabla.actualizarTabla(new ArrayList());
                        }
                        focoCampoMy();
                    }
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoG();
                }
                if(KeyEvent.VK_F3 == e.getKeyCode()){
                    limpiarCampos();
                }
                if(KeyEvent.VK_F5 == e.getKeyCode() || KeyEvent.VK_UP == e.getKeyCode() || KeyEvent.VK_DOWN == e.getKeyCode()){
                    focoCampoTabla("S", 1);
                }   
            }
        });
    }    
    private void focoCampoMy(){
        campoMy.setEditar(true);
        campoMy.requestFocus();        
        iuMensaje.setTexto("Digite el MAYOR de la cuenta (n2).");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F2]=Retrocede, [F3]=Limpia Campos, [F5]=Seleccionar Registro en la Tabla, [Esc]=Suspende Programa");
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
                            
                            //actualizarPaneles();
                            iuTabla.actualizarTabla(CConmae.getLista("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = "+S+" AND MAYOR = "+My+" GROUP BY CUETOT "));                            
                            campoG.setText(String.valueOf(G));
                            campoS.setText(String.valueOf(S));
                            campoMy.setText(String.valueOf(My));
                            
                            cargarDatos(CConmae.getConmae("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = "+S+" AND MAYOR = "+My+" AND CUENTA = "+An+" AND SUBCTA = "+Sa), 3);
                        }else{
                            establecerNivel("My");
                            iuTabla.actualizarTabla(new ArrayList());
                        }                        
                        focoCampoAn();
                    }
                }
                if(KeyEvent.VK_F3 == e.getKeyCode()){
                    limpiarCampos();
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoS();
                }
                if(KeyEvent.VK_F5 == e.getKeyCode() || KeyEvent.VK_UP == e.getKeyCode() || KeyEvent.VK_DOWN == e.getKeyCode()){
                    focoCampoTabla("My", 2);
                }
            }
        });
    }
    private void focoCampoAn(){
        campoAn.setEditar(true);
        campoAn.requestFocus();
        iuMensaje.setTexto("Digite el ANALITICO de la cuenta (n2).");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F2]=Retrocede, [F3]=Limpia Campos, [F5]=Seleccionar Registro en la Tabla, [Esc]=Suspende Programa");
        campoAn.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!campoAn.getText().isEmpty()){
                        G = Integer.parseInt(campoG.getText());
                        S = Integer.parseInt(campoS.getText());
                        My = Integer.parseInt(campoMy.getText());
                        An = Integer.parseInt(campoAn.getText());
                                                
                        //actualizarPaneles();
                        campoActividad.setText("1");
                        
                        if(An > 0){
                            campoNivel.setText("4");                            
                        }else{
                            establecerNivel("An");
                            iuTabla.actualizarTabla(new ArrayList());
                        }     
                        
                        
                        iuTabla.actualizarTabla(CConmae.getLista("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = "+S+" AND MAYOR = "+My+" AND CUENTA = "+An+" GROUP BY CUETOT "));                                                    
                        campoG.setText(String.valueOf(G));
                        campoS.setText(String.valueOf(S));
                        campoMy.setText(String.valueOf(My));
                        campoAn.setText(String.valueOf(An));
                        
                        Conmae conmae = CConmae.getConmae("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = "+S+" AND MAYOR = "+My+" AND CUENTA = "+An+" AND SUBCTA = "+Sa);
                        
                        if(conmae != null){
                            if(conmae.getActivi() == 2){
                                focoCampoS_N4(conmae);
                            }else{
                                cargarDatos(conmae, 4);
                                focoCampoSa();
                            }
                        }else
                            focoCampoSa();
                    }
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoMy();
                }
                if(KeyEvent.VK_F3 == e.getKeyCode()){
                    limpiarCampos();
                }
                if(KeyEvent.VK_F5 == e.getKeyCode() || KeyEvent.VK_UP == e.getKeyCode() || KeyEvent.VK_DOWN == e.getKeyCode()){
                    focoCampoTabla("An", 3);
                }
            }
        });
    }    
    private void focoCampoSa(){
        campoSa.setEditar(true);
        campoSa.requestFocus();
        iuMensaje.setTexto("Confirme o Digite el SUBANALITICO de la cuenta (n2).");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F2]=Retrocede, [F3]=Limpia Campos, [F5]=Seleccionar Registro en la Tabla, [Esc]=Suspende Programa");
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
                                                
                        //actualizarPaneles();
                        campoActividad.setText("1");
                        
                        if(Sa > 0){                            
                            campoNivel.setText("5");
                        }
                        else{
                            establecerNivel("Sa");
                            iuTabla.actualizarTabla(new ArrayList());
                        }
                            
                        
                        
                        iuTabla.actualizarTabla(CConmae.getLista("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = "+S+" AND MAYOR = "+My+" AND CUENTA = "+An+" AND SUBCTA = "+Sa+" GROUP BY CUETOT "));                        
                        campoG.setText(String.valueOf(G));
                        campoS.setText(String.valueOf(S));
                        campoMy.setText(String.valueOf(My));
                        campoAn.setText(String.valueOf(An));
                        campoSa.setText(String.valueOf(Sa));
                        
                        Conmae conmae = CConmae.getConmae("SELECT * FROM CONMAE WHERE GRUP = "+G+" AND SUBGRU = "+S+" AND MAYOR = "+My+" AND CUENTA = "+An+" AND SUBCTA = "+Sa);
                        if(conmae != null){
                            if(conmae.getActivi() == 2 && restringir){
                                iuMensaje.setTexto("ATENCION: la Cuenta tiene ACTIVIDAD, tome en cuenta a futuros procesos. Vuelva a presionar la tecla Enter.");
                                focoCampoDescripcion();
                                restringir = false;                                    
                            }else{
                                focoCampoS_N1(conmae);
                            }
                            
                        }else{
                            OPCION = "GUARDAR";
                            focoCampoDescripcion();
                        }
                    }
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoAn();
                }
                if(KeyEvent.VK_F3 == e.getKeyCode()){
                    limpiarCampos();
                }
                if(KeyEvent.VK_F5 == e.getKeyCode() || KeyEvent.VK_UP == e.getKeyCode() || KeyEvent.VK_DOWN == e.getKeyCode()){
                    focoCampoTabla("Sa", 4);
                }
            }
        });
    }
    private void establecerNivel(String nivel){
        switch(nivel){
            case "S":
                if(G > 0)
                    campoNivel.setText("1");
            break;
            case "My":
                if(S > 0)
                    campoNivel.setText("2");
                else
                    if(G > 0)
                        campoNivel.setText("1");
            break;
            case "An":
                if(My > 0)
                    campoNivel.setText("3");
                else
                    if(S > 0)
                        campoNivel.setText("2");
                    else
                        if(G > 0)
                            campoNivel.setText("1");
            break;
            case "Sa":
                if(An > 0)
                    campoNivel.setText("4");
                else
                    if(My > 0)
                        campoNivel.setText("3");
                    else
                        if(S > 0)
                            campoNivel.setText("2");
                        else
                            if(G > 0)
                                campoNivel.setText("1");
            break;
        }
    }
    private void focoCampoDescripcion(){        
        restringirCampos("Descripcion", true);
        campoDescripcion.setEditar(true);
        campoDescripcion.requestFocus();
        iuMensaje.setTexto("CAMPO DESCRIPCION: Digite DESCRIPCION  de la Cuenta (x28)");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F3]=Limpia Campos, [F7]=Anterior, [Esc]=Suspende Programa.");
        
        campoDescripcion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!campoDescripcion.getText().isEmpty()){
                        descripcion = campoDescripcion.getText();
                        focoCampoActividad();
                    }
                }
                if(KeyEvent.VK_F3 == e.getKeyCode()){
                    limpiarCampos();
                }
                if(KeyEvent.VK_F7 == e.getKeyCode()){
                    campoDescripcion.setText(descripcion);
                }
                
            }
        });        
    }
    private void focoCampoActividad(){
        restringirCampos("Descripcion", true);
        campoActividad.setEditar(true);
        campoActividad.requestFocus();
        iuMensaje.setTexto("Opciones: 1=NO Apropiable o 2=APROPIABLE en Comprobantes.");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F2]=Retrocede, [F3]=Limpia Campos o [Esc]=Suspende Programa.");
        campoActividad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!campoActividad.getText().isEmpty()){
                        focoCampoPresup();
                    }
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoDescripcion();
                }
                if(KeyEvent.VK_F3 == e.getKeyCode()){
                    limpiarCampos();
                }
            }
        });
    }
    private void focoCampoPresup(){
        restringirCampos("Actividad", true);
        campoPresup.setEditar(true);
        campoPresup.requestFocus();
        iuMensaje.setTexto("PRESUPUESTO de la Cuenta: 0=NO Tiene PRESUPUESTO o 1=SI Tiene PRESUPUESTO.....");
        iuInformacion.setTexto("ATENCION:  [F2]=Retrocede, [F3]=Limpia Campos o [Esc]=Suspende Programa.");
        campoPresup.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!campoPresup.getText().isEmpty()){
                        switch(OPCION){
                            case "MODIFICAR":
                                modificarConmae();                                
                            break;
                            case "GUARDAR":
                                guardarConmae();
                            break;
                            default:
                            break;
                        }
                    }
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoActividad();
                }
                if(KeyEvent.VK_F3 == e.getKeyCode()){
                    limpiarCampos();
                }
            }
        });
    }
    
    private void guardarConmae(){
        Conmae c = new Conmae(0);
        try {
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
            c.setLugar(0);
            c.setPresup(Integer.parseInt(campoPresup.getText()));
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
                }
            }
            setOpacity(1f);
        } catch (Exception e) {System.out.println("Error: "+e);iuMensaje.setTexto("ERROR: "+e);}
    }
    private void modificarConmae(){
        conmae.setDescri(campoDescripcion.getText());
        conmae.setActivi(Integer.parseInt(campoActividad.getText()));
        conmae.setPresup(Integer.parseInt(campoPresup.getText()));
        
        setOpacity(0.5f);
        if(Ayuda.mostrarMensajeConfirmacion(ventanaPrincipal, "Esta seguro que desea MODIFICAR los datos del Registro PLAN DE CUENTAS...?", "CONFIRMACION")){
            if(CConmae.modificarConmae(conmae)){
                Ayuda.mostrarMensajeInformacion(ventanaPrincipal, "Se ha MODIFICADO los datos del Registro CONMAE, CORRECTAMENTE...!", "CORRECTO");
            }
        }
        setOpacity(1f);
        limpiarCampos();
        
    }
    private void eliminarConmae(){
        setOpacity(0.5f);
        if(Ayuda.mostrarMensajeConfirmacion(ventanaPrincipal, "Esta seguro que desea ELIMINAR el Registro del PLAN DE CUENTAS....?", "CONFIRMACION")){
            double suma = Math.abs(conmae.getDebmes() + conmae.getCremes());
            if(suma > 0){
                Ayuda.mostrarMensajeError(ventanaPrincipal, "G-S-My-An-Sa = "+conmae.getCuetot()+"  descripcion = "+conmae.getDescri()+"\nEsta Cuenta NO SE PUEDE ELIMNAR POR QUE tiene MOVIMIENTO.", "Error");
            }else{
                if(CConmae.eliminarConmae(conmae)){
                    Ayuda.mostrarMensajeInformacion(ventanaPrincipal, "Se ha ELIMINADO los datos del Registro CONMAE, CORRECTAMENTE...!", "CORRECTO");
                }
            }
        }
        setOpacity(1f);
        limpiarCampos();
    }
    
    private void focoCampoS_N1(Conmae c){
        restringirCampos("", false);
        campoS_N1.setVisible(true);
        campoS_N1.requestFocus();
        campoS_N1.setText("S");
        iuMensaje.setTexto("CUENTA EXISTE LA RECUPERO?? ....... S/N");        
        iuInformacion.setTexto("");
        
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
                        default:
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
        iuInformacion.setTexto("");
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
                            focoCampoS_N3(c);
                        break;
                        default:
                        break;
                    }
                }
            }
        });
    }
    private void focoCampoS_N3(Conmae c){
        campoS_N3.setVisible(true);
        campoS_N3.requestFocus();
        campoS_N3.setText("N");
        iuMensaje.setTexto("DESEA ELIMINAR POR GRUPO DE CUENTAS?.......S/N");   
        iuInformacion.setTexto("");
        campoS_N3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {                
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N3.getText()){
                        case "S":
                            campoS_N3.setVisible(false);
                            eliminarGrupoPlanCuentas(c);
                        break;
                        case "N":
                            campoS_N3.setVisible(false);
                            focoCampoS_N5();
                        break;
                        default:
                        break;
                    }
                }
            }
        });
    }
    private void focoCampoS_N5(){
        campoS_N5.setVisible(true);
        campoS_N5.requestFocus();
        campoS_N5.setText("S");
        iuMensaje.setTexto("ENTONCES ELIMINO???......S/N");
        iuInformacion.setTexto("");
        campoS_N5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {                
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N5.getText()){
                        case "S":
                            campoS_N5.setVisible(false);
                            eliminarConmae();
                        break;
                        case "N":                            
                            limpiarCampos();
                        break;
                        default:
                        break;
                    }
                }
            }
        });
        
    }
    private void eliminarGrupoPlanCuentas(Conmae c){
        setOpacity(0.5f);
        VEliminarGrupoConmae iuEliminar = new VEliminarGrupoConmae(ventanaPrincipal, titulo, "semi-grande", c);
        iuEliminar.mostrarVentana();
        setOpacity(1f);
        limpiarCampos();
    }
    
    private void actualizarPaneles(){
        lista1.clear();
        lista2.clear();
        lista3.clear();
        lista4.clear();
        lista5.clear();
        
        if(!campoG1.getText().isEmpty()){
            lista1.add(campoG1.getText());
            lista1.add(campoS1.getText());
            lista1.add(campoMy1.getText());
            lista1.add(campoAn1.getText());
            lista1.add(campoSa1.getText());
            lista1.add(campoDescripcion1.getText());
            lista1.add(campoNivel1.getText());            
            lista1.add(campoActividad1.getText());
            lista1.add(campoLugar1.getText());
        }
        if(!campoG2.getText().isEmpty()){
            lista2.add(campoG2.getText());
            lista2.add(campoS2.getText());
            lista2.add(campoMy2.getText());
            lista2.add(campoAn2.getText());
            lista2.add(campoSa2.getText());
            lista2.add(campoDescripcion2.getText());
            lista2.add(campoNivel2.getText());            
            lista2.add(campoActividad2.getText());
            lista2.add(campoLugar2.getText());
        }
        if(!campoG3.getText().isEmpty()){
            lista3.add(campoG3.getText());
            lista3.add(campoS3.getText());
            lista3.add(campoMy3.getText());
            lista3.add(campoAn3.getText());
            lista3.add(campoSa3.getText());
            lista3.add(campoDescripcion3.getText());
            lista3.add(campoNivel3.getText());            
            lista3.add(campoActividad3.getText());
            lista3.add(campoLugar3.getText());
        }
        if(!campoG4.getText().isEmpty()){
            lista4.add(campoG4.getText());
            lista4.add(campoS4.getText());
            lista4.add(campoMy4.getText());
            lista4.add(campoAn4.getText());
            lista4.add(campoSa4.getText());
            lista4.add(campoDescripcion4.getText());
            lista4.add(campoNivel4.getText());            
            lista4.add(campoActividad4.getText());
            lista4.add(campoLugar4.getText());
        }
        if(!campoG5.getText().isEmpty()){
            lista5.add(campoG5.getText());
            lista5.add(campoS5.getText());
            lista5.add(campoMy5.getText());
            lista5.add(campoAn5.getText());
            lista5.add(campoSa5.getText());
            lista5.add(campoDescripcion5.getText());
            lista5.add(campoNivel5.getText());            
            lista5.add(campoActividad5.getText());
            lista5.add(campoLugar5.getText());
        }            
        
        panel.removeAll();
        construirPaneles(new Area(2, 2, panel.area.An() - 4, panel.area.Al() - 4));
        panel.updateUI();
        
        if(!lista1.isEmpty()){
            campoG1.setText(lista1.get(0));
            campoS1.setText(lista1.get(1));
            campoMy1.setText(lista1.get(2));
            campoAn1.setText(lista1.get(3));
            campoSa1.setText(lista1.get(4));
            campoDescripcion1.setText(lista1.get(5));
            campoNivel1.setText(lista1.get(6));
            campoActividad1.setText(lista1.get(7));
            campoLugar1.setText(lista1.get(8));            
        }
        if(!lista2.isEmpty()){
            campoG2.setText(lista2.get(0));
            campoS2.setText(lista2.get(1));
            campoMy2.setText(lista2.get(2));
            campoAn2.setText(lista2.get(3));
            campoSa2.setText(lista2.get(4));
            campoDescripcion2.setText(lista2.get(5));
            campoNivel2.setText(lista2.get(6));
            campoActividad2.setText(lista2.get(7));
            campoLugar2.setText(lista2.get(8));            
        }
        if(!lista3.isEmpty()){
            campoG3.setText(lista3.get(0));
            campoS3.setText(lista3.get(1));
            campoMy3.setText(lista3.get(2));
            campoAn3.setText(lista3.get(3));
            campoSa3.setText(lista3.get(4));
            campoDescripcion3.setText(lista3.get(5));
            campoNivel3.setText(lista3.get(6));
            campoActividad3.setText(lista3.get(7));
            campoLugar3.setText(lista3.get(8));            
        }
        if(!lista4.isEmpty()){
            campoG4.setText(lista4.get(0));
            campoS4.setText(lista4.get(1));
            campoMy4.setText(lista4.get(2));
            campoAn4.setText(lista4.get(3));
            campoSa4.setText(lista4.get(4));
            campoDescripcion4.setText(lista4.get(5));
            campoNivel4.setText(lista4.get(6));
            campoActividad4.setText(lista4.get(7));
            campoLugar4.setText(lista4.get(8));            
        }
        if(!lista5.isEmpty()){
            campoG5.setText(lista5.get(0));
            campoS5.setText(lista5.get(1));
            campoMy5.setText(lista5.get(2));
            campoAn5.setText(lista5.get(3));
            campoSa5.setText(lista5.get(4));
            campoDescripcion5.setText(lista5.get(5));
            campoNivel5.setText(lista5.get(6));
            campoActividad5.setText(lista5.get(7));
            campoLugar5.setText(lista5.get(8));            
        }
    }
    
    private void focoCampoS_N4(Conmae c){
        campoS_N4.setVisible(true);
        campoS_N4.requestFocus();
        campoS_N4.setText("S");
        iuMensaje.setTexto("ATENCION: la Cuenta tiene ACTIVIDAD, quiere MODIFICAR.?  S/N");
        iuInformacion.setTexto("");
        campoS_N4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N4.getText()){
                        case "S":
                            campoSa.setText("0");
                            focoCampoS_N1(c);
                        break;
                        case "N":
                            limpiarCampos();
                        break;
                        default:
                        break;
                    }
                }
            }
        });
    }
    
    private void limpiarCampos(){
        OPCION = "";        
        conmae = null;
        restringir = true;
        
        campoS_N1.setVisible(false);
        campoS_N2.setVisible(false);
        campoS_N3.setVisible(false);
        campoS_N4.setVisible(false);
        campoS_N5.setVisible(false);
        
        campoG.setText("");
        campoS.setText("");
        campoMy.setText("");
        campoAn.setText("");
        campoSa.setText("");
        campoDescripcion.setText("");
        campoNivel.setText("");
        campoActividad.setText("");
        campoPresup.setText("");
        iuTabla.actualizarTabla(new ArrayList());
        
        campoG.setEditar(true);
        campoS.setEditar(true);
        campoMy.setEditar(true);
        campoAn.setEditar(true);
        campoSa.setEditar(true);
        
        campoDescripcion.setEditar(false);
        campoActividad.setEditar(false);
        campoPresup.setEditar(false);
        
        /*G = 0;
        S = 0;
        My = 0;
        An = 0;
        Sa = 0;*/
        
        iuMensaje.setTexto("");
        iuInformacion.setTexto("");
        
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
 
        panel.removeAll();
        panel.updateUI();
        construirPaneles(new Area(2, 2, panel.area.An() - 4, panel.area.Al() - 4));        
 
        restringirCampos("G", true);
        focoCampoG();
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
        campoPresup.setEditar(false);
        iuTabla.setFocusable(false);
        iuTabla.setEnabled(false);
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
                campoPresup.setEditar(respuesta);
            break;
            case "tabla":
                iuTabla.setFocusable(respuesta);
                iuTabla.setEnabled(respuesta);
            break;
            
            default:
            break;
        }
    }    
    
    private void focoCampoTabla(String tipo, int numero){
        iuTabla.setFocusable(true);
        iuTabla.requestFocus();
        iuMensaje.setTexto("Navegue hacia arriba y abajo con las teclas [UP]=Arriba y [DOWN]=Abajo.");
        iuInformacion.setTexto("para seleccionar un registro presione la tecla [Enter]=Seleccionar. [F2]=Volver");        
        iuTabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(iuTabla.isFilaSeleccionado()){
                    indice = iuTabla.getSelectedRow();
                }
            }
        });
        iuTabla.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        iuTabla.getActionMap().put("Enter", new AbstractAction() {
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
                    default:
                    break;
                }
                iuTabla.setFocusable(false);
                iuTabla.modeloTabla.fireTableDataChanged();
            }
        });
        iuTabla.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "F2");
        iuTabla.getActionMap().put("F2", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                switch(tipo){
                    case "S":
                        campoS.requestFocus();
                    break;
                    case "My":
                        campoMy.requestFocus();
                    break;
                    case "An":
                        campoAn.requestFocus();
                    break;
                    case "Sa":
                        campoSa.requestFocus();
                    break;
                    default:
                    break;
                }
                iuTabla.setFocusable(false);
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
                    campoPresup.setText(String.valueOf(c.getPresup()));
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
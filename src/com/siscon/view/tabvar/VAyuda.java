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
import SIGU.paneles.IUPanelDobleEtiqueta;
import SIGU.paneles.IUPanelEtiqueta;
import SIGU.recursos.Area;
import SIGU.recursos.Fecha;
import SIGU.ventanas.IUSecundario;
import com.siscon.view.VPrincipal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class VAyuda extends IUSecundario{
    
    private VPrincipal ventanaPrincipal;
    
    private ArrayList<IUPanelDobleEtiqueta> iuLista;
    
    private IUPanel panel;
        private IUPanel panelTitulo;
        private IUEtiqueta iuTitulo;
    
    private IUPanel panelContenedor;
        private IUPanel panelDatos;
            private IUPanel panelDatosTitulo;
                private IUPanelEtiqueta iuCodigo1;
                private IUPanelEtiqueta iuDescripcion1;
                private IUPanelEtiqueta iuCodigo2;
                private IUPanelEtiqueta iuDescripcion2;
                private IUPanelEtiqueta iuCodigo3;
                private IUPanelEtiqueta iuDescripcion3;
            private IUPanel panelDatosContenedor;
                private IUPanel panelContenedor1;
                    private IUPanelDobleEtiqueta iuFila1;
                    private IUPanelDobleEtiqueta iuFila2;
                    private IUPanelDobleEtiqueta iuFila3;
                    private IUPanelDobleEtiqueta iuFila4;
                    private IUPanelDobleEtiqueta iuFila5;
                    private IUPanelDobleEtiqueta iuFila6;                    
                private IUPanel panelContenedor2;
                private IUPanel panelContenedor3;
        private IUPanel panelBotones;
            private IUPanel panelMensajes;
                private IUPanel panelContenedorMensaje;
                    private IUPanel iuPanelMensaje;
                    private IUEtiqueta iuTituloMensaje;
                    private IUEtiqueta iuMensaje;
                    private IUPanelEtiqueta iuTituloCodigo;
                    private IUCampoTexto iuCampoCodigo;
                private IUPanel panelContenedorCampos;
                    private IUPanelEtiqueta iuTituloDescripcion;
                    private IUCampoTexto iuCampoDescripcion;
            
            private IUPanel panelTeclas;
                private IUPanel panelContenedorBotones1;
                private IUEtiqueta iuTituloTeclas;
                private IUBoton botonFlechaI;
                private IUBoton botonFlechaD;
                private IUPanel panelContenedorBotones2;
                private IUBoton botonEsc;
                private IUBoton botonEnter;
            
    
    public VAyuda(VPrincipal ventanaPrincipal, String titulo, String tipoSize) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        this.iuLista = new ArrayList<>();
        
        construirPaneles();
        setEventos();
    }
    private void construirPaneles(){
        panel = new IUPanel(this, new Area(0, 0, An()-6, Al()-29), false);
        
        panelTitulo = new IUPanel(panel, new Area(2, 2, panel.area.An() - 4, panel.area.Al()/10), true);
        panelTitulo.setBackground(new Color(232, 237, 244));
        construirPanelTitulo(new Area(3, 3, panelTitulo.area.An() - 12, panelTitulo.area.Al() - 9));
        
        panelContenedor = new IUPanel(panel, new Area(2, 4 + panelTitulo.area.Al(), panelTitulo.area.An(), (panel.area.Al() - 6) - panelTitulo.area.Al()), false);
        construirPanelContenedor(new Area(3, 2, (panelContenedor.area.An() - 6), (panelContenedor.area.Al() - 4)));        
    }
    private void construirPanelTitulo(Area a){
        iuTitulo = new IUEtiqueta(panelTitulo, "CAMARA FORESTAL", new Area(a.X(), a.Y(), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "PROCESOS DE PARAMETROS - TABLAS", new Area(a.X(2) + a.AnP(25), a.Y(), a.AnP(35), a.AlP(50)), 16, "CENTER", false);
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "SISTEMA CONTABLE SISCON @v7.1. 2020", new Area(a.X(3) + a.AnP(60), a.Y(), a.AnP(40), a.AlP(50)), 16, "CENTER", false); 
        
        iuTitulo = new IUEtiqueta(panelTitulo, "EJECUTIVO", new Area(a.X(), a.Y(2) + a.AlP(50), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "FECHA: "+new Fecha().getFecha1(), new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(50), a.AnP(40), a.AlP(50)), 16, "CENTER", false);
    }
    private void construirPanelContenedor(Area a){
        panelDatos = new IUPanel(panelContenedor, new Area(a.X(), a.Y(), a.An(), a.AlP(80)), false);
        construirPanelDatos(new Area(8, 8, panelDatos.area.An() - 16, panelDatos.area.Al() - 24));
        
        panelBotones = new IUPanel(panelContenedor, new Area(a.X(), a.Y(2) + a.AlP(80), a.An(), a.AlP(20)), true);
        construirPanelBotones(new Area(panelBotones.area.An(), panelBotones.area.Al()));
    }
    private void construirPanelDatos(Area a){
        panelDatosTitulo = new IUPanel(panelDatos, new Area(a.X(), a.Y(), a.An(), a.AlP(7)), false);
        construirPanelDatosTitulo(new Area(4, 4, panelDatosTitulo.area.An() - 28, panelDatosTitulo.area.Al() - 8));
        
        panelDatosContenedor = new IUPanel(panelDatos, new Area(a.X(), a.Y(2) + a.AlP(7), a.An(), a.AlP(93)), false);
        construirPanelDatosContenedor(new Area(0, 4, panelDatosContenedor.area.An(), panelDatosContenedor.area.Al() - 8));
    }
    private void construirPanelDatosTitulo(Area a){
        iuCodigo1 = new IUPanelEtiqueta(panelDatosTitulo, new Area(a.X() + a.AnP(1), a.Y(), a.AnP(10), a.Al()), "CODIGO", 18, SwingConstants.CENTER, new Color(232, 237, 244), true);
        iuDescripcion1 = new IUPanelEtiqueta(panelDatosTitulo, new Area(a.X(2) + a.AnP(11), a.Y(), a.AnP(22), a.Al()), "DESCRIPCION", 18, SwingConstants.CENTER, new Color(232, 237, 244), true);
        
        iuCodigo2 = new IUPanelEtiqueta(panelDatosTitulo, new Area(a.X(3) + a.AnP(34), a.Y(), a.AnP(10), a.Al()), "CODIGO", 18, SwingConstants.CENTER, new Color(232, 237, 244), true);
        iuDescripcion2 = new IUPanelEtiqueta(panelDatosTitulo, new Area(a.X(4) + a.AnP(44), a.Y(), a.AnP(22), a.Al()), "DESCRIPCION", 18, SwingConstants.CENTER, new Color(232, 237, 244), true);
        
        iuCodigo3 = new IUPanelEtiqueta(panelDatosTitulo, new Area(a.X(5) + a.AnP(67), a.Y(), a.AnP(10), a.Al()), "CODIGO", 18, SwingConstants.CENTER, new Color(232, 237, 244), true);
        iuDescripcion3 = new IUPanelEtiqueta(panelDatosTitulo, new Area(a.X(6) + a.AnP(77), a.Y(), a.AnP(22), a.Al()), "DESCRIPCION", 18, SwingConstants.CENTER, new Color(232, 237, 244), true);
    }
    private void construirPanelDatosContenedor(Area a){
        panelContenedor1 = new IUPanel(panelDatosContenedor, new Area(4, a.Y(), a.AnP(33), a.Al()), false);
        construirPanelContenedor1(new Area(2, 2, panelContenedor1.area.An() - 4, panelContenedor1.area.Al() - 28));
        
        panelContenedor2 = new IUPanel(panelDatosContenedor, new Area(5 + a.AnP(33), a.Y(), a.AnP(33), a.Al()), false);
        construirPanelContenedor2(new Area(2, 2, panelContenedor2.area.An() - 4, panelContenedor2.area.Al() - 28));
        
        panelContenedor3 = new IUPanel(panelDatosContenedor, new Area(6 + a.AnP(66), a.Y(), a.AnP(33), a.Al()), false);
        construirPanelContenedor3(new Area(2, 2, panelContenedor3.area.An() - 4, panelContenedor3.area.Al() - 28));
    }
    private void construirPanelContenedor1(Area a){
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor1, new Area(a.X(), a.Y(), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, new Color(232, 237, 244), true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor1, new Area(a.X(), a.Y(2) + a.AlP(7), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, Color.WHITE, true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor1, new Area(a.X(), a.Y(3) + a.AlP(14), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, new Color(232, 237, 244), true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor1, new Area(a.X(), a.Y(4) + a.AlP(21), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, Color.WHITE, true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor1, new Area(a.X(), a.Y(5) + a.AlP(28), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, new Color(232, 237, 244), true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor1, new Area(a.X(), a.Y(7) + a.AlP(35), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, Color.WHITE, true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor1, new Area(a.X(), a.Y(8) + a.AlP(42), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, new Color(232, 237, 244), true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor1, new Area(a.X(), a.Y(9) + a.AlP(49), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, Color.WHITE, true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor1, new Area(a.X(), a.Y(10) + a.AlP(56), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, new Color(232, 237, 244), true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor1, new Area(a.X(), a.Y(11) + a.AlP(63), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, Color.WHITE, true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor1, new Area(a.X(), a.Y(12) + a.AlP(70), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, new Color(232, 237, 244), true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor1, new Area(a.X(), a.Y(13) + a.AlP(77), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, Color.WHITE, true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor1, new Area(a.X(), a.Y(14) + a.AlP(84), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, new Color(232, 237, 244), true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor1, new Area(a.X(), a.Y(15) + a.AlP(91), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, Color.WHITE, true));
    }
    private void construirPanelContenedor2(Area a){
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor2, new Area(a.X(), a.Y(), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, new Color(232, 237, 244), true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor2, new Area(a.X(), a.Y(2) + a.AlP(7), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, Color.WHITE, true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor2, new Area(a.X(), a.Y(3) + a.AlP(14), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, new Color(232, 237, 244), true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor2, new Area(a.X(), a.Y(4) + a.AlP(21), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, Color.WHITE, true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor2, new Area(a.X(), a.Y(5) + a.AlP(28), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, new Color(232, 237, 244), true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor2, new Area(a.X(), a.Y(7) + a.AlP(35), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, Color.WHITE, true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor2, new Area(a.X(), a.Y(8) + a.AlP(42), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, new Color(232, 237, 244), true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor2, new Area(a.X(), a.Y(9) + a.AlP(49), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, Color.WHITE, true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor2, new Area(a.X(), a.Y(10) + a.AlP(56), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, new Color(232, 237, 244), true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor2, new Area(a.X(), a.Y(11) + a.AlP(63), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, Color.WHITE, true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor2, new Area(a.X(), a.Y(12) + a.AlP(70), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, new Color(232, 237, 244), true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor2, new Area(a.X(), a.Y(13) + a.AlP(77), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, Color.WHITE, true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor2, new Area(a.X(), a.Y(14) + a.AlP(84), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, new Color(232, 237, 244), true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor2, new Area(a.X(), a.Y(15) + a.AlP(91), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, Color.WHITE, true));
    }
    private void construirPanelContenedor3(Area a){
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor3, new Area(a.X(), a.Y(), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, new Color(232, 237, 244), true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor3, new Area(a.X(), a.Y(2) + a.AlP(7), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, Color.WHITE, true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor3, new Area(a.X(), a.Y(3) + a.AlP(14), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, new Color(232, 237, 244), true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor3, new Area(a.X(), a.Y(4) + a.AlP(21), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, Color.WHITE, true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor3, new Area(a.X(), a.Y(5) + a.AlP(28), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, new Color(232, 237, 244), true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor3, new Area(a.X(), a.Y(7) + a.AlP(35), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, Color.WHITE, true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor3, new Area(a.X(), a.Y(8) + a.AlP(42), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, new Color(232, 237, 244), true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor3, new Area(a.X(), a.Y(9) + a.AlP(49), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, Color.WHITE, true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor3, new Area(a.X(), a.Y(10) + a.AlP(56), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, new Color(232, 237, 244), true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor3, new Area(a.X(), a.Y(11) + a.AlP(63), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, Color.WHITE, true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor3, new Area(a.X(), a.Y(12) + a.AlP(70), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, new Color(232, 237, 244), true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor3, new Area(a.X(), a.Y(13) + a.AlP(77), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, Color.WHITE, true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor3, new Area(a.X(), a.Y(14) + a.AlP(84), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, new Color(232, 237, 244), true));
        iuLista.add(new IUPanelDobleEtiqueta(panelContenedor3, new Area(a.X(), a.Y(15) + a.AlP(91), a.An(), a.AlP(7)), "", "", new Area(4, 4, a.An() - 12, a.AlP(7)- 8), 32, 68, 16, SwingConstants.RIGHT, SwingConstants.RIGHT, Color.WHITE, true));
    }
    
    private void construirPanelBotones(Area a){
        panelMensajes = new IUPanel(panelBotones, new Area(a.X(), a.Y(), a.AnP(74), a.Al()), true);
        construirPanelMensajes(new Area(panelMensajes.area.An(), panelMensajes.area.Al()));
        
        panelTeclas =  new IUPanel(panelBotones, new Area(a.X() + a.AnP(74), a.Y(), a.AnP(26), a.Al()), true);
        construirPanelTeclas(new Area(panelTeclas.area.An(), panelTeclas.area.Al()));
    }
    private void construirPanelMensajes(Area a){
        panelContenedorMensaje = new IUPanel(panelMensajes, new Area(a.X(), a.Y(), a.AnP(70), a.AlP(50)), true);
        construirContenedorMensaje(new Area(10, 4, panelContenedorMensaje.area.An() - 20, panelContenedorMensaje.area.Al() - 12));
        
        iuTituloCodigo = new IUPanelEtiqueta(panelMensajes, new Area(a.X(2) + a.AnP(70), a.Y(), a.AnP(30), a.AlP(20)), "CODIGO", 16, SwingConstants.CENTER, new Color(232, 237, 244), true);
        iuCampoCodigo = new IUCampoTexto(panelMensajes, 8, 16, new Area(a.X(2) + a.AnP(70), a.Y(2) + a.AlP(20), a.AnP(30), a.AlP(30)), SwingConstants.LEFT);
        
        panelContenedorCampos = new IUPanel(panelMensajes, new Area(a.X(), a.Y(2) + a.AlP(50), a.An(), a.AlP(50)), true);
        construirPanelContenedorCampos(new Area(4, 4, panelContenedorCampos.area.An() - 8, panelContenedorCampos.area.Al() - 8));
    }
    private void construirContenedorMensaje(Area a){
        iuTituloMensaje = new IUEtiqueta(panelContenedorMensaje, "MENSAJES - INSTRUCCIONES", new Area(a.X(), a.Y(), a.An(), a.AlP(30)), 14, "CENTER", new Color(120, 0, 0));
        iuPanelMensaje = new IUPanel(panelContenedorMensaje, new Area(a.X(), a.Y(2) + a.AlP(30), a.An(), a.AlP(70)), true);
        
        iuMensaje = new IUEtiqueta(iuPanelMensaje, "existe mas datos para visualizar...", new Area(iuPanelMensaje.area.An(), iuPanelMensaje.area.Al()), 16, "LEFT", false);
    }
    private void construirPanelContenedorCampos(Area a){
        iuTituloDescripcion = new IUPanelEtiqueta(panelContenedorCampos, new Area(a.X(2) + a.AnP(55), a.Y(), a.AnP(45), a.AlP(45)), "DESCRIPCION", 16, SwingConstants.CENTER, new Color(232, 237, 244), true);
        iuCampoDescripcion = new IUCampoTexto(panelContenedorCampos, "", 16, new Area(a.X(2) + a.AnP(55), a.Y() + a.AlP(45), a.AnP(45), a.AlP(55)));
        iuCampoDescripcion.setRestriccion("[\\p{Alpha}\\p{Alnum}\\p{Space}\\.\\/\\(\\)\\-]");
    }
    
    private void construirPanelTeclas(Area a){
        panelContenedorBotones1 = new IUPanel(panelTeclas, new Area(a.X(), a.Y(), a.An(), a.AlP(50)), true);
        construirPanelContenedorBotones1(new Area(10, 4, panelContenedorBotones1.area.An() - 30, panelContenedorBotones1.area.Al() - 8));
        
        panelContenedorBotones2 = new IUPanel(panelTeclas, new Area(a.X(), a.Y(2) + a.AlP(50), a.An(), a.AlP(50)), true);
        construirPanelContenedorBotones2(new Area(4, 4, panelContenedorBotones2.area.An() - 12, panelContenedorBotones2.area.Al() - 8));
    }
    private void construirPanelContenedorBotones1(Area a){
        botonFlechaI = new IUBoton(panelContenedorBotones1, new Area(a.X(), a.Y(), a.AnP(50), a.Al()), "←", "", 26, 0, 0, SwingConstants.CENTER, SwingConstants.CENTER, ' ', "");
        botonFlechaI.setFont(new Font("Arial", Font.BOLD, 26));
        botonFlechaI.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_LEFT, 0 ), "←" );
        
        botonFlechaD = new IUBoton(panelContenedorBotones1, new Area(a.X(2) + a.AnP(50), a.Y(), a.AnP(50), a.Al()), "→", "", 26, 0, 0, SwingConstants.CENTER, SwingConstants.CENTER, ' ', "");
        botonFlechaD.setFont(new Font("Arial", Font.BOLD, 26));
        botonFlechaD.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_RIGHT, 0 ), "→" );
    }
    private void construirPanelContenedorBotones2(Area a){
        botonEsc = new IUBoton(panelContenedorBotones2, new Area(a.X(), a.Y(), a.AnP(30), a.Al()), "ESC", "", 26, 0, 0, SwingConstants.CENTER, SwingConstants.CENTER, ' ', "");
        botonEsc.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "ESC" );
        
        botonEnter = new IUBoton(panelContenedorBotones2, new Area(a.X(2) + a.AnP(30), a.Y(), a.AnP(70), a.Al()), "ENTER", "", 26, 0, 0, SwingConstants.CENTER, SwingConstants.CENTER, ' ', "");
        botonEnter.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ENTER, 0 ), "ENTER" );
    }
    private void setEventos(){
        botonFlechaI.getActionMap().put( "←", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                botonFlechaI.doClick();                
            }
        });
        botonFlechaD.getActionMap().put( "→", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                botonFlechaD.doClick();                
            }
        });
        botonEsc.getActionMap().put( "ESC", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                botonEsc.doClick();      
                dispose();
            }
        });
        botonEnter.getActionMap().put( "ENTER", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                botonEnter.doClick();
            }
        });
    }
}

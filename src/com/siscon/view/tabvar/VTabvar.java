/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.tabvar;

import SIGU.campoTexto.IUCampoTexto;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.paneles.IUPanel;
import SIGU.paneles.IUPanelEtiqueta;
import SIGU.recursos.Area;
import SIGU.recursos.Fecha;
import SIGU.tablas.IUTabla;
import SIGU.tablas.ModeloTabla;
import SIGU.ventanas.IUSecundario;
import com.siscon.controller.CTabvar;
import com.siscon.model.Tabvar;
import com.siscon.model.Usuario;
import com.siscon.recursos.Ayuda;
import com.siscon.view.VPrincipal;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author neo
 */
public class VTabvar extends IUSecundario{
    private VPrincipal ventanaPrincipal;
    private String titulo;
    
    private IUPanel panel;
        private IUPanel panelTitulo;
        private IUEtiqueta iuTitulo;
    
    private IUPanel panelDatos;
        private IUPanel primerPanel;
            private IUPanel panelTablaTabvar;    
                private IUEtiqueta iuTituloTabvar;    
                private IUPanel panelDatosTabvar;
                    private String OPCION = "";
                    private IUPanel panelTipo;
                    private IUEtiqueta iuTipo;
                    private IUCampoTexto campoTIPO;
                    private String tipo = "";
                    private IUPanel panelNumero;
                    private IUEtiqueta iuNumero;
                    private IUCampoTexto campoNUMERO;
                    private String numero = "";
                    private IUPanel panelObservacion;
                    private IUEtiqueta iuObservacion;
                    private IUCampoTexto campoOBSERVACION;
                    private String observacion = "";
                    
                private IUPanel panelDatosSecundariosTabvar;
                    private IUEtiqueta iuDescripcion;
                    private IUCampoTexto campoDESCRIPCION;
                    private String descripcion = "";
                    private IUEtiqueta iuCODCON;
                    private IUCampoTexto campoCODCON;                    
                    private String codcon = "";
                    private IUEtiqueta iuCORREL;
                    private IUCampoTexto campoCORREL;
                    private String correl = "";
                    private IUEtiqueta iuMONTO1;
                    private IUCampoTexto campoMONTO1;
                    private IUEtiqueta iuMONTO2;
                    private IUCampoTexto campoMONTO2;
                    private IUEtiqueta iuFECHA1;
                    private JDateChooser campoFECHA1 = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
                    private String fecha1 = "";
                    private IUEtiqueta iuFECHA2;
                    private JDateChooser campoFECHA2 = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
                
            private IUPanel panelInstrucciones; 
                private IUPanel panelTituloInstrucciones;
                    private IUEtiqueta iuIntrucciones;
                    private IUEtiqueta iuFormato;
                private IUPanel panelEtiquetaInstrucciones;
                    private IUEtiqueta etiquetaDESCRIPCION;
                    private IUEtiqueta etiquetaCODCON;
                    private IUEtiqueta etiquetaCORREL;
                    private IUEtiqueta etiquetaMONTO1;
                    private IUEtiqueta etiquetaFECHA1;
                    
        private IUPanel segundoPanel;
        private IUEtiqueta iuTituloTabla;
        private IUTabla iuTabla;
                    
        private IUPanel tercerPanel;
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
    
    public VTabvar(VPrincipal ventanaPrincipal, String titulo, String tipoSize, Usuario usuario, Tabvar tabvar) {
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
        construirPanelTitulo(new Area(2, 2, panelTitulo.area.An() - 4, panelTitulo.area.Al() - 4));
        
        panelDatos = new IUPanel(panel, new Area(a.X(), a.Y(2) + a.AlP(7), a.An(), a.AlP(93)), false);
        construirPanelDatos(new Area(2, 2, panelDatos.area.An() - 4, panelDatos.area.Al() - 8));
    }
    
    private void construirPanelTitulo(Area a){
        iuTitulo = new IUEtiqueta(panelTitulo, usuario.getRazsoc(), new Area(a.X(), a.Y(), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "PROCESOS DE PARAMETROS - TABLAS", new Area(a.X(2) + a.AnP(25), a.Y(), a.AnP(35), a.AlP(50)), 16, "CENTER", false);
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "SISTEMA CONTABLE SISCON @v7.2. 2020", new Area(a.X(3) + a.AnP(60), a.Y(), a.AnP(40), a.AlP(50)), 16, "CENTER", false); 
        iuTitulo = new IUEtiqueta(panelTitulo, Ayuda.getDatoCadena("DESCRI", "SELECT DESCRI FROM TABVAR WHERE TIPO = 10 AND NUMERO = 1"), new Area(a.X(2) + a.AnP(25), a.Y(2) + a.AlP(50), a.AnP(35), a.AlP(50)), 16, "CENTER", Ayuda.COLOR_ROJO);
        iuTitulo.setSubrayarTexto(true);
        
        iuTitulo = new IUEtiqueta(panelTitulo, "EJECUTIVO: "+tabvar.getDescri(), new Area(a.X(), a.Y(2) + a.AlP(50), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "FECHA: "+new Fecha().getFecha1(), new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(50), a.AnP(40), a.AlP(50)), 16, "CENTER", false);
    }
    private void construirPanelDatos(Area a){
        primerPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(), a.An(), a.AlP(40)), true);
        construirPrimerPanel(new Area(2, 2, primerPanel.area.An() - 6, primerPanel.area.Al() - 4));
        
        segundoPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(2) + a.AlP(40), a.An(), a.AlP(45)), false);
        construirSegundoPanel(new Area(2, 2, segundoPanel.area.An() - 4, segundoPanel.area.Al() - 6));
        
        tercerPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(4) + a.AlP(85), a.An(), a.AlP(15)), false);
        construirTercerPanel(new Area(2, 2, tercerPanel.area.An() - 6, tercerPanel.area.Al() - 8));
    }
    
    private void construirPrimerPanel(Area a){
        panelTablaTabvar = new IUPanel(primerPanel, new Area(a.X(), a.Y(), a.AnP(45), a.Al()), false);
        construirPanelPrincipal(new Area(2, 2, panelTablaTabvar.area.An() - 4, panelTablaTabvar.area.Al() - 6));
        
        panelInstrucciones = new IUPanel(primerPanel, new Area(a.X(2) + a.AnP(45), a.Y(), a.AnP(55), a.Al()), false);
        construirPanelInstrucciones(new Area(2, 2, panelInstrucciones.area.An() - 4, panelInstrucciones.area.Al() - 6));
    }
    private void construirPanelPrincipal(Area a){        
        panelDatosTabvar = new IUPanel(panelTablaTabvar, new Area(a.X(), a.Y(), a.An(), a.AlP(20)), false);
        construirPanelDatosTabvar(new Area(4, 4, panelDatosTabvar.area.An() - 16, panelDatosTabvar.area.Al() -8));
        
        panelDatosSecundariosTabvar = new IUPanel(panelTablaTabvar, new Area(a.X(), a.Y(2) + a.AlP(20), a.An(), a.AlP(80)), false);
        construirPanelDatosSecundariosTabvar(new Area(2, 4, panelDatosSecundariosTabvar.area.An() - 4, panelDatosSecundariosTabvar.area.Al() - 32));        
    }
    private void construirPanelDatosTabvar(Area a){
        panelTipo = new IUPanel(panelDatosTabvar, new Area(a.X(), a.Y(), a.AnP(15), a.AlP(40)), true);
        iuTipo = new IUEtiqueta(panelTipo, "TIPO", new Area(panelTipo.area.An(), panelTipo.area.Al()), 14, "CENTER", false);        
        campoTIPO = new IUCampoTexto(panelDatosTabvar, 2, 16, new Area(a.X(), a.Y() + a.AlP(40), a.AnP(15), a.AlP(60)), SwingConstants.CENTER);
        campoTIPO.setRestriccion("^([0-9]|[1-9][0-9])$");
        panelTipo.setBackground(new Color(232, 237, 244));
        
        panelNumero = new IUPanel(panelDatosTabvar, new Area(a.X(2) + a.AnP(15), a.Y(), a.AnP(20), a.AlP(40)), true);
        iuNumero = new IUEtiqueta(panelNumero, "NUMERO", new Area(panelNumero.area.An(), panelNumero.area.Al()), 14, "CENTER", false);                
        campoNUMERO = new IUCampoTexto(panelDatosTabvar, 3, 16, new Area(a.X(2) + a.AnP(15), a.Y() + a.AlP(40), a.AnP(20), a.AlP(60)), SwingConstants.CENTER);
        campoNUMERO.setRestriccion("^([0-9]|[1-9][0-9])$");
        panelNumero.setBackground(new Color(232, 237, 244));
        
        panelObservacion = new IUPanel(panelDatosTabvar, new Area(a.X(3) + a.AnP(35), a.Y(), a.AnP(65), a.AlP(40)), true);
        iuObservacion = new IUEtiqueta(panelObservacion, "OBSERVACION", new Area(panelObservacion.area.An(), panelObservacion.area.Al()), 14, "CENTER", false);        
        campoOBSERVACION = new IUCampoTexto(panelDatosTabvar, 30, 16, new Area(a.X(3) + a.AnP(35), a.Y() + a.AlP(40), a.AnP(65), a.AlP(60)), SwingConstants.LEFT);
        campoOBSERVACION.setRestriccion("[\\p{Alpha}\\p{Alnum}\\p{Space}\\.\\/\\(\\)\\-]");
        
        panelObservacion.setBackground(new Color(232, 237, 244));
    } 
    private void construirPanelDatosSecundariosTabvar(Area a){
        int alto = 14;
        iuDescripcion = new IUEtiqueta(panelDatosSecundariosTabvar, " a. Descripcion:", new Area(a.X(), a.Y(), a.AnP(35), a.AlP(alto)), 16, "LEFT", true);        
        campoDESCRIPCION = new IUCampoTexto(panelDatosSecundariosTabvar, 20, 16, new Area(a.X() + a.AnP(35), a.Y(), a.AnP(65), a.AlP(alto)), SwingConstants.LEFT);
        campoDESCRIPCION.setRestriccion("[\\p{Alpha}\\p{Alnum}\\p{Space}\\.\\/\\(\\)\\-]");
        
        iuCODCON = new IUEtiqueta(panelDatosSecundariosTabvar, " b. Cod. Contable:", new Area(a.X(), a.Y(2) + a.AlP(alto), a.AnP(35), a.AlP(alto)), 16, "LEFT", true);
        campoCODCON = new IUCampoTexto(panelDatosSecundariosTabvar, 30, 16, new Area(a.X() + a.AnP(35), a.Y(2) + a.AlP(alto), a.AnP(24), a.AlP(alto)), SwingConstants.LEFT);
        campoCODCON.setRestriccion("^([0-9]|[1-9][0-9])$");
        
        iuCORREL = new IUEtiqueta(panelDatosSecundariosTabvar, " c. Correlativo:", new Area(a.X(), a.Y(3) + a.AlP(2*alto), a.AnP(35), a.AlP(alto)), 16, "LEFT", true);
        campoCORREL = new IUCampoTexto(panelDatosSecundariosTabvar, 6, 16, new Area(a.X() + a.AnP(35), a.Y(3) + a.AlP(2*alto), a.AnP(20), a.AlP(alto)), SwingConstants.LEFT);
        campoCORREL.setRestriccion("^([0-9]|[1-9][0-9])$");
        
        iuMONTO1 = new IUEtiqueta(panelDatosSecundariosTabvar, " d. Monto 1.:", new Area(a.X(), a.Y(4) + a.AlP(3*alto), a.AnP(35), a.AlP(alto)), 16, "LEFT", true);
        campoMONTO1 = new IUCampoTexto(panelDatosSecundariosTabvar, 12, 16, new Area(a.X() + a.AnP(35), a.Y(4) + a.AlP(3*alto), a.AnP(30), a.AlP(alto)), SwingConstants.LEFT);
        campoMONTO1.setRestriccionNumeroDecimal(2);
        
        iuMONTO2 = new IUEtiqueta(panelDatosSecundariosTabvar, "              2.:", new Area(a.X(), a.Y(5) + a.AlP(4*alto), a.AnP(35), a.AlP(alto)), 16, "LEFT", true);
        campoMONTO2 = new IUCampoTexto(panelDatosSecundariosTabvar, 9, 16, new Area(a.X() + a.AnP(35), a.Y(5) + a.AlP(4*alto), a.AnP(35), a.AlP(alto)), SwingConstants.LEFT);
        campoMONTO2.setRestriccion("^([0-9]|[1-9][0-9])$");
        
        iuFECHA1 = new IUEtiqueta(panelDatosSecundariosTabvar, " d. Fecha 1.:", new Area(a.X(), a.Y(6) + a.AlP(5*alto), a.AnP(35), a.AlP(alto)), 16, "LEFT", true);        
        Area area = new Area(a.X() + a.AnP(35), a.Y(6) + a.AlP(5*alto), a.AnP(30), a.AlP(alto));
        campoFECHA1.setBounds(area.X(),area.Y(), area.An(), area.Al());        
        campoFECHA1.getDateEditor().getUiComponent().setFont(new Font("Verdana", Font.PLAIN, 16));
        campoFECHA1.getDateEditor().getUiComponent().setForeground(new Color(2, 67, 109));
        campoFECHA1.getCalendarButton().setVisible(false);
        panelDatosSecundariosTabvar.add(campoFECHA1);
        
        iuFECHA2 = new IUEtiqueta(panelDatosSecundariosTabvar, " e.          2.:", new Area(a.X(), a.Y(7) + a.AlP(6*alto), a.AnP(35), a.AlP(alto)), 16, "LEFT", true);        
        Area area2 = new Area(a.X() + a.AnP(35), a.Y(7) + a.AlP(6*alto), a.AnP(30), a.AlP(alto));
        campoFECHA2.setBounds(area2.X(),area2.Y(), area2.An(), area2.Al());        
        campoFECHA2.getDateEditor().getUiComponent().setFont(new Font("Verdana", Font.PLAIN, 16));
        campoFECHA2.getDateEditor().getUiComponent().setForeground(new Color(2, 67, 109));
        campoFECHA2.getCalendarButton().setVisible(false);        
        panelDatosSecundariosTabvar.add(campoFECHA2);
    }
    private void construirPanelInstrucciones(Area a){
        panelTituloInstrucciones = new IUPanel(panelInstrucciones, new Area(a.X(), a.Y() + a.AlP(10), a.An(), a.AlP(10)), false);
        construirTituloInstrucciones(new Area(2, 2, panelTituloInstrucciones.area.An() - 6, panelTituloInstrucciones.area.Al() - 4));
        
        panelEtiquetaInstrucciones = new IUPanel(panelInstrucciones, new Area(a.X(), a.Y(2) + a.AlP(20), a.An(), a.AlP(80)), false);
        construirEtiquetasInstrucciones(new Area(2, 4, panelEtiquetaInstrucciones.area.An() - 6, panelEtiquetaInstrucciones.area.Al() - 32));
    }
    private void construirTituloInstrucciones(Area a){
        iuIntrucciones = new IUEtiqueta(panelTituloInstrucciones, "INSTRUCCIONES", new Area(a.X(), a.Y(), a.AnP(80), a.Al()), 18, "CENTER", true);
        iuFormato = new IUEtiqueta(panelTituloInstrucciones, "FORMATO", new Area(a.X(2) + a.AnP(80), a.Y(), a.AnP(20), a.Al()), 18, "CENTER", true);
    }
    private void construirEtiquetasInstrucciones(Area a){
        int alto = 14;
        etiquetaDESCRIPCION = new IUEtiqueta(panelEtiquetaInstrucciones, "Denominacion del Parametro - Tabla", new Area(a.X(), a.Y(), a.AnP(80), a.AlP(alto)), 16, "LEFT", true);
        etiquetaDESCRIPCION = new IUEtiqueta(panelEtiquetaInstrucciones, "x15", new Area(a.X(2) + a.AnP(80), a.Y(), a.AnP(20), a.AlP(alto)), 16, "CENTER", true);
        
        etiquetaCODCON = new IUEtiqueta(panelEtiquetaInstrucciones, "Campo para Integrar la Contabilidad", new Area(a.X(), a.Y(2) + a.AlP(alto), a.AnP(80), a.AlP(alto)), 16, "LEFT", true);
        etiquetaCODCON = new IUEtiqueta(panelEtiquetaInstrucciones, "n8", new Area(a.X(2) + a.AnP(80), a.Y(2) + a.AlP(alto), a.AnP(20), a.AlP(alto)), 16, "CENTER", true);
        
        etiquetaCORREL = new IUEtiqueta(panelEtiquetaInstrucciones, "Campo encargado de Numerar", new Area(a.X(), a.Y(3) + a.AlP(2*alto), a.AnP(80), a.AlP(alto)), 16, "LEFT", true);
        etiquetaCORREL = new IUEtiqueta(panelEtiquetaInstrucciones, "n6", new Area(a.X(2) + a.AnP(80), a.Y(3) + a.AlP(2*alto), a.AnP(20), a.AlP(alto)), 16, "CENTER", true);
        
        etiquetaMONTO1 = new IUEtiqueta(panelEtiquetaInstrucciones, "Rangos Monetarios", new Area(a.X(), a.Y(4) + a.AlP(3*alto), a.AnP(80), a.AlP(alto)), 16, "LEFT", true);
        etiquetaMONTO1 = new IUEtiqueta(panelEtiquetaInstrucciones, "n8,2", new Area(a.X(2) + a.AnP(80), a.Y(4) + a.AlP(3*alto), a.AnP(20), a.AlP(alto)), 16, "CENTER", true);
        
        etiquetaFECHA1 = new IUEtiqueta(panelEtiquetaInstrucciones, "Rango de Fechas", new Area(a.X(), a.Y(6) + a.AlP(5*alto), a.AnP(80), a.AlP(alto)), 16, "LEFT", true);
        etiquetaFECHA1 = new IUEtiqueta(panelEtiquetaInstrucciones, "dd/mm/aaaa", new Area(a.X(2) + a.AnP(80), a.Y(6) + a.AlP(5*alto), a.AnP(20), a.AlP(alto)), 16, "CENTER", true);
    }
    
    private void construirSegundoPanel(Area a){
        iuTituloTabla = new IUEtiqueta(segundoPanel, "TABLA - TABVAR", new Area(a.X(), a.Y(), a.An(), a.AlP(5)), 16, "CENTER", Ayuda.COLOR_ROJO);
        iuTituloTabla.setSubrayarTexto(true);
        iuTabla = new IUTabla(
        segundoPanel,
        new Area(a.X(), a.Y(2) + a.AlP(5), a.An(), a.AlP(95)), 
        new String[]{"TIPO", "NUMERO", "DESCRIPCION", "CODCON", "CORREL", "MONTO", "OBSERVACION", "FECHA", "FECHA2", "MONTO2", "TIPCAM", "NUMNIT"}, 
        new Class[]{Integer.class, Integer.class, String.class, Integer.class, Integer.class, Double.class, String.class, String.class, String.class, Double.class, Integer.class, Integer.class}, 
        new int[]{5,5,19,7,5,8,19,8,8,5,5,8}, 
        new ArrayList(), 
        new ModeloTabla<Tabvar>(){
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return lista.get(rowIndex).getTipo();
                    case 1:                
                        return lista.get(rowIndex).getNumero();
                    case 2:                
                        return lista.get(rowIndex).getDescri();
                    case 3:
                        return lista.get(rowIndex).getCodcon();
                    case 4:
                        return lista.get(rowIndex).getCorrel();
                    case 5:
                        return lista.get(rowIndex).getMonto();
                    case 6:
                        return lista.get(rowIndex).getObserv();
                    case 7:
                        return lista.get(rowIndex).getFecha();
                    case 8:
                        return lista.get(rowIndex).getFecha2();
                    case 9:
                        return lista.get(rowIndex).getMonto2();
                    case 10:
                        return lista.get(rowIndex).getTipcam();
                    case 11:
                        return lista.get(rowIndex).getNumnit();                    
                    default:
                        return null;
                }
            }
        });
    }
    
    private void construirTercerPanel(Area a){
        iuTituloMensaje = new IUEtiqueta(tercerPanel, "Mensajes - Instrucciones", new Area(a.X(), a.Y(), a.AnP(97), a.AlP(20)), 16, "CENTER", false);
        iuMensaje = new IUPanelEtiqueta(tercerPanel, new Area(a.X(), a.Y(2) + a.AlP(20), a.AnP(97), a.AlP(40)), "", 16, SwingConstants.LEFT, Ayuda.COLOR_ATENCION, true);
        iuInformacion = new IUPanelEtiqueta(tercerPanel, new Area(a.X(), a.Y(3) + a.AlP(60), a.AnP(97), a.AlP(40)), "", 16, SwingConstants.LEFT, Ayuda.COLOR_FONDO, true);       
        campoS_N1 = new IUCampoTexto(tercerPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
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
        campoS_N2 = new IUCampoTexto(tercerPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
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
        campoS_N3 = new IUCampoTexto(tercerPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
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
        campoS_N4 = new IUCampoTexto(tercerPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
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
        campoS_N5 = new IUCampoTexto(tercerPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
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
        campoS_N6 = new IUCampoTexto(tercerPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
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
        campoS_N7 = new IUCampoTexto(tercerPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
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
        
    private void limpiarCampos(){        
        OPCION = "";
        campoTIPO.setText("");
        campoNUMERO.setText("");
        campoOBSERVACION.setText("");
        campoDESCRIPCION.setText("");
        campoCODCON.setText("");
        campoCORREL.setText("");
        campoMONTO1.setText("");
        campoMONTO2.setText("");
        campoFECHA1.setCalendar(null);
        campoFECHA2.setCalendar(null);
        
        campoS_N1.setVisible(false);
        campoS_N2.setVisible(false);
        campoS_N3.setVisible(false);
        campoS_N4.setVisible(false);
        campoS_N5.setVisible(false);
        campoS_N6.setVisible(false);
        campoS_N7.setVisible(false);
        
        panel.removeAll();
        panel.updateUI();
        construirPaneles(new Area(2, 2, panel.area.An() - 4, panel.area.Al() - 4));
        
        restringirCampos("TIPO", true);
        focoCampoTIPO();
    }
    private void restringirCampos(String campo, boolean condicion){
        
        switch(campo){
            case "TIPO":
                campoTIPO.setEditar(condicion);
                campoNUMERO.setEditar(false);
                campoDESCRIPCION.setEditar(false);
                campoOBSERVACION.setEditar(false);
                campoCODCON.setEditar(false);
                campoCORREL.setEditar(false);
                campoMONTO1.setEditar(false);
                campoMONTO2.setEditar(false);
                campoFECHA1.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA1.getDateEditor().getUiComponent().setEnabled(false);
                campoFECHA2.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA2.getDateEditor().getUiComponent().setEnabled(false);
            break;
            case "NUMERO":
                campoTIPO.setEditar(false);
                campoNUMERO.setEditar(condicion);
                campoDESCRIPCION.setEditar(false);
                campoOBSERVACION.setEditar(false);
                campoCODCON.setEditar(false);
                campoCORREL.setEditar(false);
                campoMONTO1.setEditar(false);
                campoMONTO2.setEditar(false);
                campoFECHA1.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA1.getDateEditor().getUiComponent().setEnabled(false);
                campoFECHA2.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA2.getDateEditor().getUiComponent().setEnabled(false);
            break;
            case "NOMBRE":
                campoTIPO.setEditar(false);
                campoNUMERO.setEditar(false);
                campoDESCRIPCION.setEditar(condicion);
                campoOBSERVACION.setEditar(false);
                campoCODCON.setEditar(false);
                campoCORREL.setEditar(false);
                campoMONTO1.setEditar(false);
                campoMONTO2.setEditar(false);
                campoFECHA1.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA1.getDateEditor().getUiComponent().setEnabled(false);
                campoFECHA2.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA2.getDateEditor().getUiComponent().setEnabled(false);
            break;
            case "DESCRIPCION":
                campoTIPO.setEditar(false);
                campoNUMERO.setEditar(false);
                campoDESCRIPCION.setEditar(false);
                campoOBSERVACION.setEditar(condicion);
                campoCODCON.setEditar(false);
                campoCORREL.setEditar(false);
                campoMONTO1.setEditar(false);
                campoMONTO2.setEditar(false);
                campoFECHA1.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA1.getDateEditor().getUiComponent().setEnabled(false);
                campoFECHA2.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA2.getDateEditor().getUiComponent().setEnabled(false);
            break;
            case "CODCON":
                campoTIPO.setEditar(false);
                campoNUMERO.setEditar(false);
                campoDESCRIPCION.setEditar(false);
                campoOBSERVACION.setEditar(false);
                campoCODCON.setEditar(condicion);
                campoCORREL.setEditar(false);
                campoMONTO1.setEditar(false);
                campoMONTO2.setEditar(false);
                campoFECHA1.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA1.getDateEditor().getUiComponent().setEnabled(false);
                campoFECHA2.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA2.getDateEditor().getUiComponent().setEnabled(false);
            break;
            case "CORREL":
                campoTIPO.setEditar(false);
                campoNUMERO.setEditar(false);
                campoDESCRIPCION.setEditar(false);
                campoOBSERVACION.setEditar(false);
                campoCODCON.setEditar(false);
                campoCORREL.setEditar(condicion);
                campoMONTO1.setEditar(false);
                campoMONTO2.setEditar(false);
                campoFECHA1.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA1.getDateEditor().getUiComponent().setEnabled(false);
                campoFECHA2.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA2.getDateEditor().getUiComponent().setEnabled(false);
            break;
            case "MONTO1":
                campoTIPO.setEditar(false);
                campoNUMERO.setEditar(false);
                campoDESCRIPCION.setEditar(false);
                campoOBSERVACION.setEditar(false);
                campoCODCON.setEditar(false);
                campoCORREL.setEditar(false);
                campoMONTO1.setEditar(condicion);
                campoMONTO2.setEditar(false);
                campoFECHA1.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA1.getDateEditor().getUiComponent().setEnabled(false);
                campoFECHA2.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA2.getDateEditor().getUiComponent().setEnabled(false);
            break;
            case "MONTO2":
                campoTIPO.setEditar(false);
                campoNUMERO.setEditar(false);
                campoDESCRIPCION.setEditar(false);
                campoOBSERVACION.setEditar(false);
                campoCODCON.setEditar(false);
                campoCORREL.setEditar(false);
                campoMONTO1.setEditar(false);
                campoMONTO2.setEditar(condicion);
                campoFECHA1.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA1.getDateEditor().getUiComponent().setEnabled(false);
                campoFECHA2.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA2.getDateEditor().getUiComponent().setEnabled(false);
            break;
            case "FECHA1":
                campoTIPO.setEditar(false);
                campoNUMERO.setEditar(false);
                campoDESCRIPCION.setEditar(false);
                campoOBSERVACION.setEditar(false);
                campoCODCON.setEditar(false);
                campoCORREL.setEditar(false);
                campoMONTO1.setEditar(false);
                campoMONTO2.setEditar(false);
                campoFECHA1.getDateEditor().getUiComponent().setFocusable(condicion);
                campoFECHA1.getDateEditor().getUiComponent().setEnabled(condicion);
                campoFECHA2.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA2.getDateEditor().getUiComponent().setEnabled(false);
            break;
            case "FECHA2":
                campoTIPO.setEditar(false);
                campoNUMERO.setEditar(false);
                campoDESCRIPCION.setEditar(false);
                campoOBSERVACION.setEditar(false);
                campoCODCON.setEditar(false);
                campoCORREL.setEditar(false);
                campoMONTO1.setEditar(false);
                campoMONTO2.setEditar(false);
                campoFECHA1.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA1.getDateEditor().getUiComponent().setEnabled(false);
                campoFECHA2.getDateEditor().getUiComponent().setFocusable(condicion);
                campoFECHA2.getDateEditor().getUiComponent().setEnabled(condicion);
            break;
        }        
    }
    private void algoritmoInicial(){
        restringirCampos("TIPO", true);
        focoCampoTIPO();
    }
    private void mostrarDatosTabvar(Tabvar tabvar){        
        campoTIPO.setText(String.valueOf(tabvar.getTipo()));
        campoNUMERO.setText(String.valueOf(tabvar.getNumero()));
        campoDESCRIPCION.setText(tabvar.getDescri());
        campoOBSERVACION.setText(tabvar.getObserv());
        campoCODCON.setText(String.valueOf(tabvar.getCodcon()));        
        campoCORREL.setText(String.valueOf(tabvar.getCorrel()));
        campoMONTO1.setTextoD(String.valueOf(tabvar.getMonto()));
        campoMONTO2.setTextoD(String.valueOf(tabvar.getMonto2()));

        if(tabvar.getFecha() == null)
            campoFECHA1.setCalendar(null);
        else
            campoFECHA1.setDate(new Fecha(tabvar.getFecha()).getDate());
        
        if(tabvar.getFecha2() == null)
            campoFECHA2.setCalendar(null);
        else
            campoFECHA2.setDate(new Fecha(tabvar.getFecha2()).getDate());        
    }
    private boolean noExistenCamposVacios(){
        boolean verificador = false;
        if(!campoTIPO.getText().isEmpty()){
            if(!campoNUMERO.getText().isEmpty()){
                verificador = true;
            }
        }
        return verificador;
    }
    private void eliminarRegistro(Tabvar t){        
        if(t.getTipo() > 0 && t.getNumero() > 0){
            int resp = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea ELIMINAR el Registro...?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if(resp == 0){
                if(CTabvar.eliminarTabvar(t)){
                    JOptionPane.showMessageDialog(this, "se ha eliminado los datos del registro TABVAR correctamente...!");
                    limpiarCampos();
                }
            }
        }
    }
    private void modificarDatosRegistro(){
        if(!campoTIPO.getText().isEmpty()){
            if(!campoNUMERO.getText().isEmpty()){
                int campo_tipo = Integer.parseInt(campoTIPO.getText());
                int campo_numero = Integer.parseInt(campoNUMERO.getText());
                if(campo_tipo > 0 && campo_numero > 0){

                    Tabvar t = CTabvar.getTabvar(campo_tipo, campo_numero);
                    if(t == null){
                        JOptionPane.showMessageDialog(null, "Lo siento, pero no existe el registro TABVAR con TIPO = "+campo_tipo+" y NUMERO = "+campo_numero+" en la BASE DE DATOS....!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    }else{
                        if(noExistenCamposVacios()){         
                            t.setTipo(Integer.parseInt(campoTIPO.getText()));
                            t.setNumero(Integer.parseInt(campoNUMERO.getText()));
                            t.setDescri(campoDESCRIPCION.getText());
                            t.setObserv(campoOBSERVACION.getText());

                            if(campoCODCON.getText().isEmpty())
                                t.setCodcon(0);
                            else
                                t.setCodcon(Integer.parseInt(campoCODCON.getText()));

                            if(campoCORREL.getText().isEmpty())
                                t.setCorrel(0);
                            else
                                t.setCorrel(Integer.parseInt(campoCORREL.getText()));            

                            if(campoMONTO1.getText().isEmpty())
                                t.setMonto(0);
                            else
                                t.setMonto(Double.parseDouble(campoMONTO1.getText()));

                            if(campoMONTO2.getText().isEmpty())
                                t.setMonto2(0);
                            else
                                t.setMonto2(Double.parseDouble(campoMONTO2.getText()));

                            if(campoFECHA1.getDate() != null)
                                t.setFecha(new Fecha().getFecha(campoFECHA1.getDate(), "yyyy-MM-dd"));
                            else
                                t.setFecha(null);

                            if(campoFECHA2.getDate() != null)
                                t.setFecha2(new Fecha().getFecha(campoFECHA2.getDate(), "yyyy-MM-dd"));
                            else
                                t.setFecha2(null);

                            if(CTabvar.modificarTabvar(t)){
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
            Tabvar t = new Tabvar(0);
            t.setTipo(Integer.parseInt(campoTIPO.getText()));
            t.setNumero(Integer.parseInt(campoNUMERO.getText()));
            t.setDescri(campoDESCRIPCION.getText());
            t.setObserv(campoOBSERVACION.getText());
            
            if(campoCODCON.getText().isEmpty())
                t.setCodcon(0);
            else
                t.setCodcon(Integer.parseInt(campoCODCON.getText()));
            
            if(campoCORREL.getText().isEmpty())
                t.setCorrel(0);
            else
                t.setCorrel(Integer.parseInt(campoCORREL.getText()));            
            
            if(campoMONTO1.getText().isEmpty())
                t.setMonto(0);
            else
                t.setMonto(Double.parseDouble(campoMONTO1.getText()));
            
            if(campoMONTO2.getText().isEmpty())
                t.setMonto2(0);
            else
                t.setMonto2(Double.parseDouble(campoMONTO2.getText()));
                        
            if(campoFECHA1.getDate() != null)
                t.setFecha(new Fecha().getFecha(campoFECHA1.getDate(), "yyyy-MM-dd"));
            else
                t.setFecha(null);
            
            if(campoFECHA2.getDate() != null)
                t.setFecha2(new Fecha().getFecha(campoFECHA2.getDate(), "yyyy-MM-dd"));
            else
                t.setFecha2(null);
            
            if(CTabvar.guardarTabvar(t)){
                JOptionPane.showMessageDialog(ventanaPrincipal, "se ha guardado un nuevo registro de TABVAR correctamente...!");
                limpiarCampos();                
            }
        }
    }
    
    private void modificarDatosTabvar(){
        campoS_N5.setVisible(false);
        restringirCampos("TIPO", false);
        campoS_N6.setVisible(true);
        campoS_N6.requestFocus();
        iuMensaje.setTexto("DATOS LISTOS PARA MODIFICAR, MODIFICO?.......S/N");
        iuInformacion.setTexto("");
        campoS_N6.setText("S");
        
        campoS_N6.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N6.getText()){
                        case "S":
                            modificarDatosRegistro();
                        break;
                        case "N":
                            focoCampoTIPO();
                        break;
                    }
                }
            }
        });
    }
    private void grabarDatosTabvar(){        
        campoS_N6.setVisible(false);
        restringirCampos("TIPO", false);
        campoS_N7.setVisible(true);
        campoS_N7.requestFocus();
        campoS_N7.setText("S");
        iuMensaje.setTexto("DATOS LISTOS PARA GRABAR, GRABO?.......S/N");
        iuInformacion.setTexto("");
        campoS_N7.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N7.getText()){
                        case "S":
                            guardarNuevoRegistro();
                        break;
                        case "N":
                            focoCampoTIPO();
                        break;
                        default:
                        break;
                    }
                }
            }
        });
    }
    private void actualizarCamposConsultas(){
        panelDatosTabvar.removeAll();
        construirPanelDatosTabvar(new Area(4, 4, panelDatosTabvar.area.An() - 16, panelDatosTabvar.area.Al() -8));
        panelDatosTabvar.updateUI();
        
        campoTIPO.setText(tipo);
        campoNUMERO.setText(numero);
        campoDESCRIPCION.setText(descripcion);
    }
    private void focoCampoTIPO(){
        iuTabla.actualizarTabla(new ArrayList());
        campoTIPO.setEditar(true);
        campoTIPO.requestFocus();
        iuMensaje.setTexto("CAMPO TIPO:  digite un NUMERO ENTERO [1-99] ");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F2]=Retrocede, [F3]=Limpia Campos, [F7]=Anterior o [Esc]=Suspende Programa.");
        campoTIPO.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!campoTIPO.getText().isEmpty()){
                        tipo = campoTIPO.getText();
                        String campo_Observacion = CTabvar.getObservacion(Integer.parseInt(campoTIPO.getText()));
                        if(!campo_Observacion.isEmpty()){
                            campoOBSERVACION.setText(campo_Observacion);                            
                        }
                        iuTabla.actualizarTabla(CTabvar.getLista("SELECT * FROM tabvar WHERE TIPO = "+campoTIPO.getText()));                       
                        
                        actualizarCamposConsultas();                        
                        
                    }else{
                        campoTIPO.setText("0");
                    }
                    focoCampoNUMERO();
                }
                if(KeyEvent.VK_F2 == e.getKeyCode())
                    campoTIPO.transferFocusBackward();
                
                if(KeyEvent.VK_F3 == e.getKeyCode())
                    limpiarCampos();
                                
                if(KeyEvent.VK_F7 == e.getKeyCode())
                    campoTIPO.setText(tipo);
            }   
        });
    }
    private void focoCampoNUMERO(){
        campoS_N1.setVisible(false);
        campoNUMERO.setEditar(true);
        campoNUMERO.requestFocus();        
        iuMensaje.setTexto("CAMPO NUMERO: DIGITE UN NUMERO ENTERO [1-999].");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F2]=Retrocede, [F3]=Limpia Campos, [F5]=Navegar TABLA, [F7]=Anterior, [F8]=Incrementa o [Esc]=Suspende Programa.");
        
        campoNUMERO.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    
                    if(!campoTIPO.getText().isEmpty() && !campoNUMERO.getText().isEmpty()){
                        numero = campoNUMERO.getText();
                        int tipo = Integer.parseInt(campoTIPO.getText());
                        int numero = Integer.parseInt(campoNUMERO.getText());
                        if(tipo > 0 && numero > 0){
                            Tabvar t = CTabvar.getTabvar(tipo, numero);
                            if(t != null){                                
                                focoCampoN_S1(t);
                            }else{
                                OPCION = "GUARDAR";
                                campoCORREL.setText(campoNUMERO.getText());
                                focoCampoOBSERVACION();
                            }
                        }
                    }
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoTIPO();
                }
                if(KeyEvent.VK_F3 == e.getKeyCode()){
                    limpiarCampos();
                }
                if(KeyEvent.VK_F5 == e.getKeyCode()){
                    focoTabla("NUMERO");
                }
                if(KeyEvent.VK_F7 == e.getKeyCode()){
                    campoNUMERO.setText(numero);
                }
                if(KeyEvent.VK_F8 == e.getKeyCode()){
                    int numero = 0;
                    if(!campoNUMERO.getText().isEmpty()){
                        numero = Integer.parseInt(campoNUMERO.getText()) + 1;
                        campoNUMERO.setText(String.valueOf(numero));
                    }else{
                        numero++;
                        campoNUMERO.setText(String.valueOf(numero));
                    }
                }
            }
        });
    }
    private void focoCampoN_S1(Tabvar t){  
        restringirCampos("TIPO", false);
        campoS_N1.setVisible(true);
        campoS_N1.requestFocus();
        campoS_N1.setText("S");
        iuMensaje.setTexto("ITEM DE TABLA YA EXISTE, RECUPERO?? ...S/N");
        iuInformacion.setTexto("");
        campoS_N1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N1.getText()){
                        case "S":                            
                            focoCampoN_S2(t);
                        break;
                        case "N":
                            focoCampoNUMERO();
                        break;
                        default:
                        break;
                    }
                }
            }
        });
    }
    private void focoCampoN_S2(Tabvar t){
        campoS_N1.setVisible(false);
        mostrarDatosTabvar(t);        
        campoS_N2.setVisible(true);
        campoS_N2.requestFocus();
        campoS_N2.setText("S");
        iuMensaje.setTexto("DESEA MODIFICAR ESTE ITEM.....S/N");
        iuInformacion.setTexto("");
        campoS_N2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N2.getText()){
                        case "S":
                            OPCION = "MODIFICAR";
                            tabvar = t;
                            focoCampoOBSERVACION();
                        break;
                        case "N":                            
                            campoS_N2.setVisible(false);
                            focoCampoS_N3(t);
                        break;
                        default:
                        break;
                    }
                }
            }
        });
    }
    private void focoCampoS_N3(Tabvar t){        
        campoS_N3.setVisible(true);
        campoS_N3.requestFocus();
        campoS_N3.setText("S");
        iuMensaje.setTexto("DESEA ELIMINAR EL REGISTRO POR GRUPO........S/N");
        iuInformacion.setTexto("");
        campoS_N3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N3.getText()){
                        case "S":                            
                            campoS_N3.setVisible(false);
                            eliminarGrupoRegistros(t);
                        break;
                        case "N":
                            focoCampoS_N4(t);
                        break;
                        default:
                        break;
                    }
                }
            }
        });
    }
    private void eliminarGrupoRegistros(Tabvar t){        
        setOpacity(0.5f);
        VEliminarGrupoTabvar iuEliminar = new VEliminarGrupoTabvar(this, titulo, "semi-grande", t);
        iuEliminar.mostrarVentana();
        setOpacity(1f);
        limpiarCampos();
    }
    private void focoCampoS_N4(Tabvar t){
        campoS_N3.setVisible(false);
        campoS_N4.setVisible(true);
        campoS_N4.requestFocus();
        campoS_N4.setText("N");
        iuMensaje.setTexto("ENTONCES DESEA ELIMINAR........S/N");
        iuInformacion.setTexto("");
        campoS_N4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N4.getText()){
                        case "S":
                            eliminarRegistro(t);
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
    private void focoCampoOBSERVACION(){
        campoOBSERVACION.setEditar(true);
        campoOBSERVACION.requestFocus();
        iuMensaje.setTexto("CAMPO OBSERVACION: DESCRIPCION GENERICO DEL PARAMETRO(x20)");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F3]=Limpia Campos, [F5]=Navegar TABLA, [F7]=Anterior o [Esc]=Suspende Programa.");
        
        
        campoOBSERVACION.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    observacion = campoOBSERVACION.getText();
                    if(!campoOBSERVACION.getText().isEmpty()){
                        focoCampoDESCRIPCION();
                    }                    
                }                
                if(KeyEvent.VK_F3 == e.getKeyCode()){
                    limpiarCampos();
                }
                if(KeyEvent.VK_5 == e.getKeyCode()){
                    focoTabla("OBSERVACION");
                }
                if(KeyEvent.VK_F7 == e.getKeyCode()){
                    campoOBSERVACION.setText(observacion);
                }
            }
        });
    }
    private void focoCampoDESCRIPCION(){
        campoS_N2.setVisible(false);
        campoTIPO.setEditar(false);
        campoNUMERO.setEditar(false);
        
        campoDESCRIPCION.setEditar(true);
        campoDESCRIPCION.requestFocus();
        iuMensaje.setTexto("CAMPO DESCRIPCION: Digite caracteres ALPHA NUMERICOS, DESCRIPCION DEL PARAMETRO (x25)");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F2]=Retrocede, [F3]=Limpia Campos, [F5]=Navegar TABLA, [F7]=Anterior o [Esc]=Suspende Programa.");
        
        campoDESCRIPCION.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    descripcion = campoDESCRIPCION.getText();
                    if(!campoDESCRIPCION.getText().isEmpty())
                        focoCampoCODCON();
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoOBSERVACION();
                }
                if(KeyEvent.VK_F3 == e.getKeyCode()){
                    limpiarCampos();
                }
                if(KeyEvent.VK_F5 == e.getKeyCode()){
                    focoTabla("DESCRIPCION");
                }
                if(KeyEvent.VK_F7 == e.getKeyCode()){
                    campoDESCRIPCION.setText(descripcion);
                }
            }
        });
    }
    private void focoCampoCODCON(){
        campoCODCON.setEditar(true);
        campoCODCON.requestFocus();        
        iuMensaje.setTexto("CAMPO CODCON: Cod.Cta Contable digite Numeros Enteros ");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F2]=Retrocede, [F3]=Limpia Campos, [F5]=Navegar TABLA, [F7]=Anterior, [F8]=Auto-Codifica o [Esc]=Suspende Programa.");
        campoCODCON.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    codcon = campoCODCON.getText();
                    if(campoCODCON.getText().isEmpty()){
                        int tipo = 0;
                        int numero = 0;
                        if(!campoTIPO.getText().isEmpty()){
                            tipo = Integer.parseInt(campoTIPO.getText());
                        }
                        if(!campoNUMERO.getText().isEmpty()){
                            numero = Integer.parseInt(campoNUMERO.getText());
                        }
                        int codcon = tipo*1000 + numero;
                        campoCODCON.setText(String.valueOf(codcon));                        
                    }
                    focoCampoCORREL();                    
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoDESCRIPCION();
                }
                if(KeyEvent.VK_F3 == e.getKeyCode()){
                    limpiarCampos();
                }
                if(KeyEvent.VK_5 == e.getKeyCode()){
                    focoTabla("CODCON");
                }
                if(KeyEvent.VK_F7 == e.getKeyCode()){
                    campoCODCON.setText(codcon);
                }
                if(KeyEvent.VK_F8 == e.getKeyCode()){
                    int campo_tipo = 0;
                    int campo_numero = 0;
                    if(!campoTIPO.getText().isEmpty())
                        campo_tipo = Integer.parseInt(campoTIPO.getText());
                    if(!campoNUMERO.getText().isEmpty())
                        campo_numero = Integer.parseInt(campoNUMERO.getText());
                    int campo_codcon = 1000*campo_tipo + campo_numero;                        
                    campoCODCON.setText(String.valueOf(campo_codcon));
                    focoCampoCORREL();                    
                }
            }
        });
    }
    private void focoCampoCORREL(){
        campoCORREL.setEditar(true);
        campoCORREL.requestFocus();
        iuMensaje.setTexto("CAMPO CORRELATIVO: CONFIRME CORRELTV-NUMERADOR. Digite un Numero Entero");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F2]=Retrocede, [F3]=Limpia Campos, [F5]=Navegar TABLA, [F7]=Anterior, [F8]=Auto-Codifica o [Esc]=Suspende Programa.");
        campoCORREL.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){                    
                    if(campoCORREL.getText().isEmpty())
                        campoCORREL.setText("0");
                    correl = campoCORREL.getText();
                    focoCampoMONTO1();                    
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoCODCON();
                }
                if(KeyEvent.VK_F3 == e.getKeyCode()){
                    limpiarCampos();
                }
                if(KeyEvent.VK_5 == e.getKeyCode()){
                    focoTabla("CORREL");
                }
                if(KeyEvent.VK_F7 == e.getKeyCode()){
                    campoCORREL.setText(correl);
                }
                if(KeyEvent.VK_F8 == e.getKeyCode()){
                    int campo_numero = Integer.parseInt(campoNUMERO.getText())*1000 + 1;
                    campoCORREL.setText(String.valueOf(campo_numero));
                    focoCampoMONTO1();                    
                }
            }
        });        
    }
    private void focoCampoMONTO1(){
        campoMONTO1.setEditar(true);
        campoMONTO1.requestFocus();
        iuMensaje.setTexto("CAMPO MONTO1: INDIQUE PARAMETRO FINANCIERO 1, Digite numeros Decimales(Con Decimales)");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F2]=Retrocede, [F3]=Limpia Campos, [F5]=Navegar TABLA o [Esc]=Suspende Programa.");
        campoMONTO1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(campoMONTO1.getText().isEmpty())
                        campoMONTO1.setTextoD("0.00");
                    focoCampoMONTO2();
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoCORREL();
                }
                if(KeyEvent.VK_F3 == e.getKeyCode()){
                    limpiarCampos();
                }
                if(KeyEvent.VK_5 == e.getKeyCode()){
                    focoTabla("MONTO1");
                }
            }
        });
    }
    private void focoCampoMONTO2(){        
        campoMONTO2.setEditar(true);
        campoMONTO2.requestFocus();
        iuMensaje.setTexto("INDIQUE PARAMETRO FINANCIERO 2 (Entero)");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F2]=Retrocede, [F3]=Limpia Campos, [F5]=Navegar TABLA o [Esc]=Suspende Programa.");
        campoMONTO2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(campoMONTO2.getText().isEmpty())
                        campoMONTO2.setTextoD("0.00");
                    focoCampoN_S5();                    
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoMONTO1();
                }
                if(KeyEvent.VK_F3 == e.getKeyCode()){
                    limpiarCampos();
                }
                if(KeyEvent.VK_5 == e.getKeyCode()){
                    focoTabla("MONTO2");
                }
            }
        });
    }
    private void focoCampoN_S5(){        
        campoS_N4.setVisible(false); 
        restringirCampos("TIPO", false);
        campoS_N5.setVisible(true);
        campoS_N5.requestFocus();
        campoS_N5.setText("N");
        iuMensaje.setTexto("DESEA MODIFICAR PARAMETROS FECHA???......S/N");
        iuInformacion.setTexto("");
        campoS_N5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N5.getText()){
                        case "S":
                            focoCampoFECHA1();
                        break;
                        case "N":
                            if(OPCION.equalsIgnoreCase("MODIFICAR"))
                                modificarDatosTabvar();
                            if(OPCION.equalsIgnoreCase("GUARDAR"))
                                grabarDatosTabvar();
                        break;
                        default:
                        break;
                    }
                }
            }
        });        
    }
    private void focoCampoFECHA1(){
        campoS_N5.setVisible(false);
        campoFECHA1.getDateEditor().getUiComponent().setFocusable(true);
        campoFECHA1.getDateEditor().getUiComponent().setEnabled(true);
        campoFECHA1.getDateEditor().getUiComponent().requestFocus();                
        iuMensaje.setTexto("CAMPO FECHA1: PROPORCIONE FECHA 1 con Formato de Fecha dd/MM/yyyy");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F2]=Retrocede, [F3]=Limpia Campos, [F5]=Navegar TABLA, [F7]=Fecha de Hoy o [Esc]=Suspende Programa.");
        campoFECHA1.getDateEditor().getUiComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    try {
                        if(!new Fecha().getFecha(campoFECHA1.getDate(), "yyyy-MM-dd").isEmpty()){                            
                            focoCampoFECHA2();                            
                        }
                    } catch (Exception ex) {System.out.println("Error: en la Fecha1. "+ex.getMessage());}
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    try {
                        if(new Fecha().getFecha(campoFECHA1.getDate(), "yyyy-MM-dd").isEmpty()){
                            campoFECHA1.setCalendar(null);
                        }
                        focoCampoMONTO2();
                    } catch (Exception ex) {System.out.println("Error: en la Fecha1. "+ex.getMessage());}
                }
                if(KeyEvent.VK_F3 == e.getKeyCode()){
                    limpiarCampos();
                }
                if(KeyEvent.VK_F5 == e.getKeyCode()){
                    focoTabla("FECHA1");
                }
                if(KeyEvent.VK_F7 == e.getKeyCode()){
                    campoFECHA1.setDateFormatString("yyyy-MM-dd");
                    campoFECHA1.setDate(new Date());
                    campoFECHA2.setDateFormatString("yyyy-MM-dd");
                    campoFECHA2.setDate(new Date());
                    focoCampoFECHA2();
                }
            }
        });
    }
    private void focoCampoFECHA2(){
        campoFECHA2.getDateEditor().getUiComponent().setFocusable(true);
        campoFECHA2.getDateEditor().getUiComponent().setEnabled(true);
        campoFECHA2.getDateEditor().getUiComponent().requestFocus();
        iuMensaje.setTexto("PROPORCIONE FECHA 2........");
        iuInformacion.setTexto("ATENCION:  [Enter]=Avanza, [F2]=Retrocede, [F3]=Limpia Campos, [F5]=Navegar TABLA, [F7]=Fecha de Hoy o [Esc]=Suspende Programa.");
        campoFECHA2.getDateEditor().getUiComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    try {
                        if(!new Fecha().getFecha(campoFECHA2.getDate(), "yyyy-MM-dd").isEmpty()){                            
                            switch(OPCION){                                
                                case "MODIFICAR":
                                    modificarDatosTabvar();
                                break;                                
                                case "GUARDAR":
                                    grabarDatosTabvar();
                                break;
                                default:
                                break;
                            }                            
                        }else{
                            campoFECHA2.setDateFormatString("yyyy-MM-dd");
                            campoFECHA2.setDate(new Date());
                        }
                    } catch (Exception ex) {System.out.println("Error: "+ex.getMessage());}
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    try {
                        if(new Fecha().getFecha(campoFECHA2.getDate(), "yyyy-MM-dd").isEmpty()){
                            campoFECHA2.setCalendar(null);
                        }
                        focoCampoFECHA1();
                    } catch (Exception ex) {}
                }
                if(KeyEvent.VK_F3 == e.getKeyCode()){
                    limpiarCampos();
                }
                if(KeyEvent.VK_F5 == e.getKeyCode()){
                    focoTabla("FECHA2");
                }
                if(KeyEvent.VK_F7 == e.getKeyCode()){
                    campoFECHA2.setDateFormatString("yyyy-MM-dd");
                    campoFECHA2.setDate(new Date());
                }
            }            
        });
    }
    private void focoTabla(String campo){
        iuTabla.setFocusable(true);
        iuTabla.requestFocus();
        iuMensaje.setTexto("Navegue por la Tabla con la teclas de FLECHA [UP] y [DOWN] respectivamente.");
        iuInformacion.setTexto("para volver al CAMPO ANTERIOR presione la tecla [F2]=volver");
        iuTabla.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    switch(campo){
                        case "TIPO":
                            focoCampoTIPO();
                        break;
                        case "NUMERO":
                            focoCampoNUMERO();                            
                        break;
                        case "OBSERVACION":
                            focoCampoOBSERVACION();
                        break;
                        case "DESCRIPCION":
                            focoCampoDESCRIPCION();
                        break;                        
                        case "CODCON":
                            focoCampoCODCON();
                        break;
                        case "CORREL":
                            focoCampoCORREL();
                        break;
                        case "MONTO1":
                            focoCampoMONTO1();
                        break;
                        case "MONTO2":
                            focoCampoMONTO2();
                        break;
                        case "FECHA1":
                            focoCampoFECHA1();
                        break;
                        case "FECHA2":
                            focoCampoFECHA2();
                        break;
                        default:
                        break;
                    }
                    iuTabla.setFocusable(false);
                    iuTabla.modeloTabla.fireTableDataChanged();
                }
            }
        });
    }
}

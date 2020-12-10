/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.contra;

import SIGU.campoTexto.IUCampoTexto;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.paneles.IUPanel;
import SIGU.paneles.IUPanelEtiqueta;
import SIGU.recursos.Area;
import SIGU.tablas.IUTabla;
import SIGU.tablas.ModeloTabla;
import SIGU.ventanas.IUSecundario;
import com.siscon.controller.CConmae;
import com.siscon.model.Conmae;
import com.siscon.model.Tabvar;
import com.siscon.recursos.Ayuda;
import com.siscon.view.VPrincipal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author neo
 */
public class VAyudaContra extends IUSecundario{
    
    private VPrincipal ventanaPrincipal;
    
    private IUPanel panel;
        private IUPanel panelTitulo;
        private IUEtiqueta iuTitulo;
    
        private IUPanel panelDatos;
            private IUPanel primerPanel;
                private IUTabla iuTabla;
            private IUPanel segundoPanel;
                private IUEtiqueta iuEtiquetaBusqueda;
                private IUCampoTexto iuBusqueda;
                private IUPanelEtiqueta iuEtiquetaCodigo;
                private IUCampoTexto iuCodigo;
                private IUPanelEtiqueta iuEtiquetaDescripcion;
                private IUCampoTexto iuDescripcion;
            private IUPanel tercerPanel;
                private IUEtiqueta iuTituloMensaje;
                private IUPanelEtiqueta iuMensaje;
                private IUPanelEtiqueta iuInformacion;
                private IUCampoTexto campoS_N;
    private Conmae conmae;
    private final String SQL;
    
    /**
     *
     * @param ventanaPrincipal
     * @param titulo
     * @param tipoSize
     * @param SQL
     */
    public VAyudaContra(VPrincipal ventanaPrincipal, String titulo, String tipoSize, String SQL) {
        super(ventanaPrincipal, titulo, tipoSize);                
        this.ventanaPrincipal = ventanaPrincipal;
        this.conmae = new Conmae(0);
        this.SQL = SQL;
        
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
        panelTitulo = new IUPanel(panel, new Area(a.X(), a.Y(), a.An(), a.AlP(4)), true, Ayuda.COLOR_FONDO);
        construirPanelTitulo(new Area(2, 2, panelTitulo.area.An() - 4, panelTitulo.area.Al() - 4));
        
        panelDatos = new IUPanel(panel, new Area(a.X(), a.Y(2) + a.AlP(4), a.An(), a.AlP(96)), false);
        construirPanelDatos(new Area(panelDatos.area.AnP(5), 2, panelDatos.area.An() - panelDatos.area.AnP(5)*2, panelDatos.area.Al() - 8));
    }
    private void construirPanelTitulo(Area a){
        iuTitulo = new IUEtiqueta(panelTitulo, "CONSULTA DE CODIGOS PARA LOS ASIENTOS", new Area(a.X(), a.Y(), a.An(), a.Al()), 20, "CENTER", Ayuda.COLOR_ROJO);
        iuTitulo.setSubrayarTexto(true);        
    }
    private void construirPanelDatos(Area a){
        primerPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(), a.An(), a.AlP(70)), true);
        construirPrimerPanel(new Area(2, 2, primerPanel.area.An() - 4, primerPanel.area.Al() - 4));
        
        segundoPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(2) + a.AlP(70), a.An(), a.AlP(15)), true);
        construirSegundoPanel(new Area(2, 2, segundoPanel.area.An() - 6, segundoPanel.area.Al() - 6));
        
        tercerPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(3) + a.AlP(85), a.An(), a.AlP(15)), true);
        construirTercerPanel(new Area(2, 2, tercerPanel.area.An() - 6, tercerPanel.area.Al() - 8));
    }
    private void construirPrimerPanel(Area a){
        iuTabla = new IUTabla(
        primerPanel,
        new Area(a.X(), a.Y(), a.An(), a.Al()), 
        new String[]{"CODIGO", "DESCRIPCION"}, 
        new Class[]{Long.class, String.class}, 
        new int[]{30, 70}, 
        CConmae.getLista(SQL), 
        new ModeloTabla<Conmae>(){
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return lista.get(rowIndex).getCuetot();
                    case 1:                
                        return lista.get(rowIndex).getDescri().toUpperCase();
                    default:
                        return null;
                }
            }
        });        
        iuTabla.setPosicionTextoHorizontal(1, SwingConstants.LEFT);
    }
    private void construirSegundoPanel(Area a){
        iuEtiquetaBusqueda = new IUEtiqueta(segundoPanel, "busqueda por codigo o descripcion:", new Area(a.X(), a.Y(), a.AnP(70), a.AlP(30)), 16, "CENTER", true);
        iuBusqueda = new IUCampoTexto(segundoPanel, "", 16, new Area(a.X(2) + a.AnP(70), a.Y(), a.AnP(30), a.AlP(30)));
        
        iuEtiquetaCodigo = new IUPanelEtiqueta(segundoPanel, new Area(a.X(), a.Y(2) + a.AlP(30), a.AnP(30), a.AlP(35)), "CODIGO", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuCodigo = new IUCampoTexto(segundoPanel, 20, 16, new Area(a.X(), a.Y(2) + a.AlP(65), a.AnP(30), a.AlP(35)), SwingConstants.CENTER);
        
        iuEtiquetaDescripcion = new IUPanelEtiqueta(segundoPanel, new Area(a.X(2) + a.AnP(30), a.Y(2) + a.AlP(30), a.AnP(70), a.AlP(35)), "DESCRIPCION", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuDescripcion = new IUCampoTexto(segundoPanel, 20, 16, new Area(a.X(2) + a.AnP(30), a.Y(2) + a.AlP(65), a.AnP(70), a.AlP(35)), SwingConstants.CENTER);
    }
    private void construirTercerPanel(Area a){
        iuTituloMensaje = new IUEtiqueta(tercerPanel, "Mensajes - Instrucciones", new Area(a.X(), a.Y(), a.AnP(97), a.AlP(20)), 16, "CENTER", false);
        iuTituloMensaje.setSubrayarTexto(true);
        iuMensaje = new IUPanelEtiqueta(tercerPanel, new Area(a.X(), a.Y(2) + a.AlP(20), a.AnP(93), a.AlP(40)), "", 16, SwingConstants.LEFT, Ayuda.COLOR_ATENCION, true);
        iuMensaje.setColores(Color.WHITE, new Color(41, 66, 99));
        iuInformacion = new IUPanelEtiqueta(tercerPanel, new Area(a.X(), a.Y(3) + a.AlP(60), a.AnP(93), a.AlP(40)), "", 16, SwingConstants.LEFT, Ayuda.COLOR_FONDO, true);       
        iuInformacion.setColores(Color.BLACK, new Color(255, 210, 0));
        campoS_N = new IUCampoTexto(tercerPanel, 1, 20, new Area(a.X(2) + a.AnP(93), a.Y(2) + a.AlP(20), a.AnP(7), a.AlP(40)), SwingConstants.CENTER);
        campoS_N.setVisible(false);
        campoS_N.setBorder(new LineBorder(Color.BLACK, 3));
        campoS_N.setBackground(new Color(255, 210, 0));
        campoS_N.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoS_N.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoS_N.setText("N");
                }
            }
        });
        campoS_N.setForeground(Color.BLACK);
    }
    private void algoritmoInicial(){
        focoCampoBusqueda();
    }
    private void pintarBorde(String campo){        
        iuBusqueda.setBorder(iuBusqueda.getBordeComponente());
        iuTabla.setSelectionBackground(null);
        switch(campo){
            case "BUSQUEDA":
                iuBusqueda.setBorder(new LineBorder(Color.GREEN));
            break;
            case "TABLA":
                iuTabla.setSelectionBackground(Color.GREEN);
            break;
            default:
            break;
        }
    }
    private void focoCampoBusqueda(){
        pintarBorde("BUSQUEDA");
        campoS_N.setEditar(false);
        campoS_N.setVisible(false);        
        iuBusqueda.setEditar(true);
        iuBusqueda.requestFocus();
        //iuTabla.actualizarTabla(CConmae.getLista("SELECT * FROM CONMAE"));
        iuTabla.setFocusable(false);        
        iuInformacion.setVisible(true);
        iuMensaje.setTexto("CAMPO BUSQUEDA: Realize la busqueda por CODIGO o DESCRIPCION.");
        iuInformacion.setTexto("ATENCION: ENTER=Aceptar Codigo, F5=Navegar Tabla, ESC=Suspender.");
        iuBusqueda.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!iuCodigo.getText().isEmpty() && !iuDescripcion.getText().isEmpty()){
                        focoCampoN_S();
                    }
                }
                if(KeyEvent.VK_F5 == e.getKeyCode() || KeyEvent.VK_UP == e.getKeyCode() || KeyEvent.VK_DOWN == e.getKeyCode()){
                    focoCampoTabla();
                }                
            }
        });
        iuBusqueda.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                filtrarBusqueda(iuBusqueda.getText().toUpperCase());
            }
        });
        
    }
    private void focoCampoN_S(){        
        iuBusqueda.setBorder(iuBusqueda.getBordeComponente());
        
        iuBusqueda.setEditar(false);
        iuTabla.setFocusable(false);
        
        campoS_N.setVisible(true);
        campoS_N.setEditar(true);
        campoS_N.setText("S");
        campoS_N.requestFocus();
        iuMensaje.setColores(Color.BLACK, new Color(255, 210, 0));
        iuMensaje.setTexto("DESEA CONFIRMAR LA SELECCION DEL CODIGO Y DESCRIPCION?   S/N");
        iuInformacion.setVisible(false);
        iuInformacion.setTexto("");
        campoS_N.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    switch(campoS_N.getText()){
                        case "S":
                            setEstado(true);
                            dispose();
                        break;
                        case "N":
                            focoCampoBusqueda();                                    
                        break;
                        default:
                        break;
                    }
                }
            }
        });
    }
    private void filtrarBusqueda(String dato){
        final TableRowSorter<TableModel> sorter = new TableRowSorter<>(iuTabla.getModel());
        iuTabla.setRowSorter(sorter);
        try {
            sorter.setRowFilter(RowFilter.regexFilter(dato));            
        } catch (Exception ex) {System.out.println("Error: Tabla "+ex.getMessage());}
    }
    private void focoCampoTabla(){
        pintarBorde("TABLA");        
        iuTabla.setFocusable(true);
        iuTabla.requestFocus();
        iuMensaje.setTexto("CAMPO TABLA: Seleccione un CODIGO de la TABLA, y PRESIONE ENTER.");
        iuInformacion.setTexto("ATENCION: ENTER=Aceptar Codigo, F2=Retroceder, ESC=Suspender.");
        iuTabla.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        iuTabla.getActionMap().put("Enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(iuTabla.isFilaSeleccionado()){
                    if(iuTabla.getRowSorter() != null){
                        conmae = (Conmae) iuTabla.modeloTabla.getFila(iuTabla.getRowSorter().convertRowIndexToModel(iuTabla.getSelectedRow()));                            
                    }else{
                        conmae = (Conmae) iuTabla.modeloTabla.getFila(iuTabla.getSelectedRow());
                    }
                    iuCodigo.setText(String.valueOf(conmae.getCuetot()));
                    iuDescripcion.setText(conmae.getDescri());
                    iuCodigo.setBorder(new LineBorder(Color.GREEN));
                    iuDescripcion.setBorder(new LineBorder(Color.GREEN));                    
                    focoCampoN_S();
                }               
            }
        });
        iuTabla.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {                
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoBusqueda();
                }
            }
        });        
    }
    public Conmae getConmae(){
        return conmae;
    }
}

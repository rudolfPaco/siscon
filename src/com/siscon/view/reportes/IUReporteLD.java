/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.reportes;

import SIGU.campoTexto.IUCampoTexto;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.paneles.IUPanel;
import SIGU.recursos.Area;
import SIGU.tablas.IUTabla;
import SIGU.tablas.ModeloTabla;
import SIGU.tablas.RenderDatosDecimales;
import SIGU.ventanas.IUSecundario;
import com.siscon.controller.CConmae;
import com.siscon.controller.CContra;
import com.siscon.model.Contra;
import com.siscon.model.LibroDiario;
import com.siscon.model.Usuario;
import com.siscon.recursos.Ayuda;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class IUReporteLD extends IUSecundario{
    private RLibroDiario ventanaPrincipal;
    private String titulo;
    
    private IUPanel panel;
        private IUPanel panelTitulo;
        private IUEtiqueta iuTitulo;
    
    private IUPanel panelDatos;
        private IUPanel primerPanel;
            private IUTabla iuTabla;
            private IUPanel panelTotal;
                private IUEtiqueta iuTotal;
                private IUCampoTexto iuTotalDebitos;
                private IUCampoTexto iuTotalCreditos;
                private IUCampoTexto iuTotalSaldos;
    
    private final Usuario usuario;
    private final String moneda;
    private final String fechaInicial;
    private final String fechaFinal;
    
    public IUReporteLD(RLibroDiario ventanaPrincipal, String titulo, String tipoSize, Usuario usuario, String moneda, String fechaInicial, String fechaFinal) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        this.usuario = usuario;
        this.moneda = moneda;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        
        construirPanel(new Area(An()-6, Al()-29));
        algoritmosInicial();        
    }
    private void construirPanel(Area a){
        panel = new IUPanel(this, new Area(a.X(), a.Y(), a.An(), a.Al()), true);
        construirPaneles(new Area(2, 2, panel.area.An() - 4, panel.area.Al() - 4));
    }
    private void construirPaneles(Area a){
        panelTitulo = new IUPanel(panel, new Area(a.X(), a.Y(), a.An(), a.AlP(7)), false, Ayuda.COLOR_FONDO);
        construirPanelTitulo(new Area(panelTitulo.area.AnP(2), 2, panelTitulo.area.An() - panelTitulo.area.AnP(2)*4, panelTitulo.area.Al() - 4));
        
        panelDatos = new IUPanel(panel, new Area(a.X(), a.Y() + a.AlP(7), a.An(), a.AlP(93)), false, Ayuda.COLOR_FONDO);
        construirPanelDatos(new Area(2, 0, panelDatos.area.An() - 4, panelDatos.area.Al()));
    }
    
    private void construirPanelTitulo(Area a){
        iuTitulo = new IUEtiqueta(panelTitulo, usuario.getRazsoc(), new Area(a.X(), a.Y(), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "Form: LDC"+"   |   Tipo Cambio: "+Ayuda.formatearNumber(usuario.getTipcam()), new Area(a.X(), a.Y(2) + a.AlP(45), a.AnP(35), a.AlP(50)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "LIBRO DIARIO DE COMPROBANTES", new Area(a.X(2) + a.AnP(25), a.Y(), a.AnP(45), a.AlP(50)), 16, "CENTER", false);                
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "Del:  "+fechaInicial+"   al   "+fechaFinal, new Area(a.X(2) + a.AnP(35), a.Y(2) + a.AlP(45), a.AnP(35), a.AlP(50)), 16, "CENTER", false);
        
        iuTitulo = new IUEtiqueta(panelTitulo, "SISTEMA CONTABLE SISCON @v7.2. 2020", new Area(a.X(3) + a.AnP(60), a.Y(), a.AnP(40), a.AlP(50)), 16, "RIGHT", false); 
        iuTitulo = new IUEtiqueta(panelTitulo, "Moneda: "+moneda, new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(45), a.AnP(40), a.AlP(50)), 16, "RIGHT", false);
    }
    private void construirPanelDatos(Area a){
        //iuTitulo = new IUEtiqueta(panelDatos, "Form: BG   |    Nivel: "+fechaFinal, new Area(a.X() + a.AnP(2), a.Y(), a.AnP(50), a.AlP(4)), 16, "LEFT", false);
        //iuTitulo = new IUEtiqueta(panelDatos, "Moneda: "+fechaInicial, new Area(a.X() + a.AnP(50), a.Y(), a.AnP(48), a.AlP(4)), 16, "RIGHT", false);
        iuTabla = new IUTabla(
        panelDatos, 
        new Area(a.X(), a.Y(), a.An(), a.Al()), 
        new String[]{"FECHA", "COMPRB.", "ITM", "CODIGO", "CUENTA", "CONCEPTO", "DEBE", "HABER", "DOLARES"}, 
        new Class[]{String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}, 
        new int[]{10, 8, 3, 8, 20, 36, 10, 10, 10}, 
        new ArrayList(),
        new ModeloTabla<LibroDiario>(){
            
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return lista.get(rowIndex).getFecha();
                    case 1:
                        return lista.get(rowIndex).getComprobante();
                    case 2:
                        return lista.get(rowIndex).getItem();
                    case 3:
                        return lista.get(rowIndex).getCodigo();
                    case 4:
                        return lista.get(rowIndex).getCuenta();
                    case 5:                        
                        return lista.get(rowIndex).getConcepto();
                    case 6:
                        return lista.get(rowIndex).getDebe();
                    case 7:
                        return lista.get(rowIndex).getHaber();
                    case 8:
                        return lista.get(rowIndex).getDorales();
                    default:
                        return null;
                }
            }            
        });
        iuTabla.setPosicionTextoHorizontal(1, SwingConstants.LEFT);
        iuTabla.setPosicionTextoHorizontal(2, SwingConstants.RIGHT);
        iuTabla.setPosicionTextoHorizontal(3, SwingConstants.RIGHT);
        iuTabla.setPosicionTextoHorizontal(4, SwingConstants.RIGHT);        
        iuTabla.setFocusable(true);
        int[] columnas = {6, 7, 8};
        
        for (int i = 0; i < iuTabla.nombreCabecera.length; i++) {
            iuTabla.getColumnModel().getColumn(i).setCellRenderer(new RenderDatosDecimales(columnas));
        }
        iuTabla.setShowVerticalLines(false);
        iuTabla.setShowHorizontalLines(false);
        iuTabla.setShowGrid(false);
    }
    private void cargarDatosReporte(){
        ArrayList<Contra> listaContras = CContra.getListaContra("select * from contra where fecha >= "+fechaInicial+" or fecha < "+fechaFinal+" order by tipcon and numcom and correl");        
        ArrayList<LibroDiario> list = new ArrayList<>();
        
        double debe = 0;
        double haber = 0;
        
        double totalDebe = 0;
        double totalHaber = 0;
        
        for (int i = 0; i < listaContras.size(); i++) {
            Contra contra = listaContras.get(i);
            
            if(contra.getCorrel() == 1)
                list.add(todoRegistro(contra));
            else
                list.add(importanteRegistro(contra));
            
            switch(contra.getApropi()){
                case 1:
                    if(moneda.equalsIgnoreCase("(B)OLIVIANOS")){
                        debe = debe + contra.getMonto1();
                        totalDebe = totalDebe  + contra.getMonto1();
                    }else{
                        debe = debe + contra.getMonto2();
                        totalDebe = totalDebe  + contra.getMonto2();
                    }                    
                break;
                case 2:
                    if(moneda.equalsIgnoreCase("(B)OLIVIANOS")){
                        haber = haber + contra.getMonto1();
                        totalHaber = totalHaber  + contra.getMonto1();
                    }else{
                        haber = haber + contra.getMonto2();
                        totalHaber = totalHaber  + contra.getMonto2();
                    }
                    
                break;
            }
            
            if(i + 1 < listaContras.size()){
                Contra postContra = listaContras.get(i + 1);
                if(postContra.getCorrel() == 1){
                    list.add(new LibroDiario());
                    list.add(imprimirTotalComprobante(contra, debe, haber));
                    list.add(new LibroDiario());
                    list.add(new LibroDiario());
                    debe = 0;
                    haber = 0;
                }
            }else{
                list.add(new LibroDiario());
                list.add(imprimirTotalComprobante(contra, debe, haber));
                list.add(new LibroDiario());
                list.add(new LibroDiario());
                debe = 0;
                haber = 0;
            }
        }
        
        list.add(new LibroDiario());
        list.add(new LibroDiario());
        list.add(imprimirTotalReporte(totalDebe, totalHaber));
        list.add(new LibroDiario());
        list.add(new LibroDiario());
        
        iuTabla.actualizarTabla(list);
    }
    private LibroDiario imprimirTotalReporte(double totalDebe, double totalHaber){
        LibroDiario libro = new LibroDiario();
        libro.setConcepto("TOTAL MOVIMIENTO DEL "+fechaInicial+"   AL   "+fechaFinal+"   "+(moneda.equalsIgnoreCase("(B)OLIVIANOS")?"(Bs)":"($us)"));
        libro.setDebe(String.valueOf(totalDebe));
        libro.setHaber(String.valueOf(totalHaber));
        return libro;
    }
    private LibroDiario imprimirTotalComprobante(Contra c, double debe, double haber){
        LibroDiario libro = new LibroDiario();
        libro.setConcepto("TOTAL COMPROBANTE  "+c.getNumcom()+"  "+moneda);
        libro.setDebe(String.valueOf(debe));
        libro.setHaber(String.valueOf(haber));        
        return libro;
    }
    private LibroDiario importanteRegistro(Contra c){
        LibroDiario libro = new LibroDiario();
        libro.setItem(String.valueOf(c.getCorrel()));
        libro.setCodigo(String.valueOf(c.getCuetot()));
        libro.setCuenta(CConmae.getConmae("select * from conmae where cuetot = "+c.getCuetot()).getDescri());
        libro.setConcepto(c.getGlosa());
        switch(c.getApropi()){
            case 1:
                if(moneda.equalsIgnoreCase("(B)OLIVIANOS")){
                    libro.setDebe(String.valueOf(c.getMonto1()));
                }else{
                    libro.setDebe(String.valueOf(c.getMonto2()));
                }
                
            break;
            case 2:
                if(moneda.equalsIgnoreCase("(B)OLIVIANOS")){
                    libro.setHaber(String.valueOf(c.getMonto1()));
                }else{
                    libro.setHaber(String.valueOf(c.getMonto2()));
                }
                
            break;
        }
        if(moneda.equalsIgnoreCase("(B)OLIVIANOS")){
            libro.setDorales(String.valueOf(c.getMonto2()));
        }else{
            libro.setDorales(String.valueOf(c.getMonto1()));
        }
        
        return libro;
    }
    private LibroDiario todoRegistro(Contra c){
        LibroDiario libro = new LibroDiario();
        libro.setFecha(c.getFecha());        
        libro.setComprobante(Ayuda.getTipoDoc(c.getTipcon()).substring(0, 1).toUpperCase()+"-"+c.getNumcom());
        libro.setItem(String.valueOf(c.getCorrel()));
        libro.setCodigo(String.valueOf(c.getCuetot()));
        libro.setCuenta(CConmae.getConmae("select * from conmae where cuetot = "+c.getCuetot()).getDescri());
        libro.setConcepto(c.getGlosa());
        switch(c.getApropi()){
            case 1:
                if(moneda.equalsIgnoreCase("(B)OLIVIANOS")){
                    libro.setDebe(String.valueOf(c.getMonto1()));
                }else{
                    libro.setDebe(String.valueOf(c.getMonto2()));
                }
            break;
            case 2:
                if(moneda.equalsIgnoreCase("(B)OLIVIANOS")){
                    libro.setHaber(String.valueOf(c.getMonto1()));
                }else{
                    libro.setHaber(String.valueOf(c.getMonto2()));
                }
            break;
        }
        if(moneda.equalsIgnoreCase("(B)OLIVIANOS")){
            libro.setDorales(String.valueOf(c.getMonto2()));
        }else{
            libro.setDorales(String.valueOf(c.getMonto1()));
        }
        return libro;
    }
    private void algoritmosInicial(){
        panel.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "ESC" );
        panel.getActionMap().put( "ESC", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){
                dispose();
            }
        });
        
        panel.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_F10, 0 ), "F10" );
        panel.getActionMap().put( "F10", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){
                imprimir();
            }
        });
        
        cargarDatosReporte();
    }
    private void imprimir(){
        Ayuda.utilJTablePrint(iuTabla, "", "", true);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.reportes;

import SIGU.campoTexto.IUCampoTexto;
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
import com.siscon.model.Conmae;
import com.siscon.model.Contra;
import com.siscon.model.Tabvar;
import com.siscon.model.Usuario;
import com.siscon.recursos.Ayuda;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class IUReporteMAC extends IUSecundario{
    private RMayorAnaliticoCuenta ventanaPrincipal;
    private String titulo;
    
    private IUPanel panel;
        private IUPanel panelTitulo;
        private IUEtiqueta iuTitulo;
    
    private IUPanel panelDatos;
        private IUPanel primerPanel;
            private IUPanelEtiqueta movimientoBolivianos;
            private IUPanelEtiqueta movimientoDolares;
            
            private IUTabla iuTabla;
            private IUPanel panelTotal;
                private IUEtiqueta iuTotal;
                private IUCampoTexto iuTotalDebitos;
                private IUCampoTexto iuTotalCreditos;
                private IUCampoTexto iuTotalSaldos;
    
    private final Usuario usuario;
    private final Tabvar tabvar;
    private final String moneda;
    private String codigo;
    private String descripcion;
    private double saldo1;
    
    public IUReporteMAC(RMayorAnaliticoCuenta ventanaPrincipal, String titulo, String tipoSize, Usuario usuario, Tabvar tabvar, String moneda, String codigo, String descripcion) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        this.usuario = usuario;
        this.tabvar = tabvar;
        this.moneda = moneda;
        this.codigo = codigo;
        this.descripcion = descripcion;                
        this.saldo1 = 0.0;
        
        construirPanel(new Area(An()-6, Al()-29));
        algoritmosInicial();        
    }
    private void construirPanel(Area a){
        panel = new IUPanel(this, new Area(a.X(), a.Y(), a.An(), a.Al()), true);
        construirPaneles(new Area(2, 2, panel.area.An() - 4, panel.area.Al() - 4));
    }
    private void construirPaneles(Area a){
        panelTitulo = new IUPanel(panel, new Area(a.X(), a.Y(), a.An(), a.AlP(7)), true, Ayuda.COLOR_FONDO);
        construirPanelTitulo(new Area(panelTitulo.area.AnP(2), 2, panelTitulo.area.An() - panelTitulo.area.AnP(2)*4, panelTitulo.area.Al() - 4));
        
        panelDatos = new IUPanel(panel, new Area(a.X(), a.Y(2) + a.AlP(7), a.An(), a.AlP(93)), false, Ayuda.COLOR_FONDO);
        construirPanelDatos(new Area(2, 2, panelDatos.area.An() - 4, panelDatos.area.Al() - 4));
    }
    
    private void construirPanelTitulo(Area a){
        iuTitulo = new IUEtiqueta(panelTitulo, usuario.getRazsoc()+"  |  REPORTE: MAC ".toUpperCase(), new Area(a.X(), a.Y(), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "Moneda: "+moneda+"   |   Cuenta: "+codigo, new Area(a.X(), a.Y(2) + a.AlP(45), a.AnP(35), a.AlP(50)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "MAYOR ANALITICO", new Area(a.X(2) + a.AnP(25), a.Y(), a.AnP(45), a.AlP(50)), 16, "CENTER", false);                
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, descripcion.toUpperCase(), new Area(a.X(2) + a.AnP(35), a.Y(2) + a.AlP(45), a.AnP(35), a.AlP(50)), 16, "CENTER", true);
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "SISTEMA CONTABLE SISCON @v7.2. 2020", new Area(a.X(3) + a.AnP(60), a.Y(), a.AnP(40), a.AlP(50)), 16, "RIGHT", false); 
        iuTitulo = new IUEtiqueta(panelTitulo, new Fecha().getFecha1(), new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(45), a.AnP(40), a.AlP(50)), 16, "RIGHT", false);                 
    }
    private void construirPanelDatos(Area a){
        
        movimientoBolivianos = new IUPanelEtiqueta(panelDatos, new Area(a.X(2) + a.AnP(47) , a.Y(), a.AnP(24), a.AlP(5)), "MOVIMIENTO EN BOLIVIANOS", 24, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        movimientoDolares = new IUPanelEtiqueta(panelDatos, new Area(a.X(2) + a.AnP(71) , a.Y(), a.AnP(24), a.AlP(5)), "MOVIMIENTO EN DOLARES", 24, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);        
        
        iuTabla = new IUTabla(
        panelDatos, 
        new Area(a.X(), a.Y() + a.AlP(5), a.An(), a.AlP(95)), 
        new String[]{"FECHA", "NRO. DOC.", "CONCEPTO", "DEBE (BOB.)", "HABER (BOB.)", "SALDO (BOB.)", "DEBE ($US.)", "HABER ($US.)", "SALDO ($US.)", "T/C"}, 
        new Class[]{String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}, 
        new int[]{8, 8, 31, 8, 8, 8, 8, 8, 8, 5}, 
        CContra.getListaContra("SELECT * FROM CONTRA WHERE CUETOT = "+codigo), 
        new ModeloTabla<Contra>(){
            
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                
                Contra contra = lista.get(rowIndex);
                
                switch (columnIndex) {
                    case 0:
                        return contra.getFecha();
                    case 1:                
                        return Ayuda.getTipoDoc(contra.getTipcon())+"-"+contra.getNumcom();
                    case 2:                        
                        return contra.getGlosa();
                    case 3:                        
                        return contra.getDebeB();
                    case 4:                        
                        return contra.getHaberB();
                    case 5:
                        return contra.getTotalB();
                    case 6:
                        return contra.getDebeD();
                    case 7:
                        return contra.getHaberD();
                    case 8:                        
                        return contra.getTotalD();
                    case 9:
                        return contra.getTipcam();
                    default:
                        return null;                
                }
            }            
        });
        iuTabla.setPosicionTextoHorizontal(2, SwingConstants.LEFT);
        iuTabla.setPosicionTextoHorizontal(3, SwingConstants.RIGHT);
        iuTabla.setPosicionTextoHorizontal(4, SwingConstants.RIGHT);
        iuTabla.setPosicionTextoHorizontal(5, SwingConstants.RIGHT);
        iuTabla.setPosicionTextoHorizontal(6, SwingConstants.RIGHT);
        iuTabla.setPosicionTextoHorizontal(7, SwingConstants.RIGHT);
        iuTabla.setPosicionTextoHorizontal(8, SwingConstants.RIGHT);
        
        iuTabla.setFocusable(true);        
    }
    private void construirPanelTotal(Area a){
        iuTotal = new IUEtiqueta(panelTotal, "T O T A L E S "+moneda.toUpperCase(), new Area(a.X(), a.Y(), a.AnP(60), a.Al()), 20, "CENTER", true);
        iuTotalDebitos  = new IUCampoTexto(panelTotal, 20, 20, new Area(a.X(2) + a.AnP(70), a.Y(), a.AnP(10), a.Al()), SwingConstants.CENTER);
        iuTotalDebitos.setRestriccion("^\\d{0,5}(\\d\\.\\d?|\\.\\d)?\\d?$");
        iuTotalCreditos  = new IUCampoTexto(panelTotal, 20, 20, new Area(a.X(3) + a.AnP(80), a.Y(), a.AnP(10), a.Al()), SwingConstants.CENTER);
        iuTotalCreditos.setRestriccion("^\\d{0,5}(\\d\\.\\d?|\\.\\d)?\\d?$");
        iuTotalSaldos  = new IUCampoTexto(panelTotal, 20, 20, new Area(a.X(4) + a.AnP(90), a.Y(), a.AnP(10), a.Al()), SwingConstants.CENTER);
        iuTotalSaldos.setRestriccion("^\\d{0,5}(\\d\\.\\d?|\\.\\d)?\\d?$");
    }
    private void calcularReporte(){
        double totalBolivianos = 0;
        double totalDolares = 0;        
        
        ArrayList<Contra> listaContras = CContra.getListaContra("SELECT * FROM CONTRA WHERE CUETOT = "+codigo+" order by fecha");
        ArrayList<Contra> lista = new ArrayList<>();
        
        for (Contra contra : listaContras) {
            
            if(contra.getApropi() == 1){
                contra.setDebeB(Ayuda.acotarNumero(contra.getMonto1(), 2));                
                totalBolivianos = Ayuda.acotarNumero(totalBolivianos + contra.getMonto1(), 2);
                contra.setDebeD(contra.getMonto2());
                totalDolares = Ayuda.acotarNumero(totalDolares + contra.getMonto2(), 2);
            }                
            else{
                contra.setHaberB(Ayuda.acotarNumero(contra.getMonto1(), 2));
                totalBolivianos = Ayuda.acotarNumero(totalBolivianos - contra.getMonto1(), 2);
                contra.setHaberD(contra.getMonto2());
                totalDolares = Ayuda.acotarNumero(totalDolares + contra.getMonto2(), 2);
            }
            contra.setTotalB(totalBolivianos);
            contra.setTotalD(totalDolares);
            
            lista.add(contra);
        }
        iuTabla.actualizarTabla(lista);
    }
    private void algoritmosInicial(){
        panel.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "ESC" );
        panel.getActionMap().put( "ESC", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){
                dispose();
            }
        });  
        calcularReporte();
    }
}

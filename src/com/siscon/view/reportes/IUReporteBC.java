/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.reportes;

/**
 *
 * @author neo
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import SIGU.campoTexto.IUCampoTexto;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.paneles.IUPanel;
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
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class IUReporteBC extends IUSecundario{
    
    private RBalanceComprobacion ventanaPrincipal;
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
    private final Tabvar tabvar;
    private final String moneda;
    private final String forma;
    
    public IUReporteBC(RBalanceComprobacion ventanaPrincipal, String titulo, String tipoSize, Usuario usuario, Tabvar tabvar, String moneda, String forma) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        this.usuario = usuario;
        this.tabvar = tabvar;
        this.moneda = moneda;
        this.forma = forma;
        
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
        iuTitulo = new IUEtiqueta(panelTitulo, usuario.getRazsoc()+"  |  REPORTE: BC ".toUpperCase(), new Area(a.X(), a.Y(), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "Moneda: "+moneda+"   |   Forma: "+forma, new Area(a.X(), a.Y(2) + a.AlP(45), a.AnP(35), a.AlP(50)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "BALANCE DE COMPROBACION ACUMULACION POR RANGO DE FECHAS", new Area(a.X(2) + a.AnP(25), a.Y(), a.AnP(45), a.AlP(50)), 16, "CENTER", false);                
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "Por Cuentas Activas", new Area(a.X(2) + a.AnP(35), a.Y(2) + a.AlP(45), a.AnP(35), a.AlP(50)), 16, "CENTER", Ayuda.COLOR_ROJO);
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "SISTEMA CONTABLE SISCON @v7.2. 2020", new Area(a.X(3) + a.AnP(60), a.Y(), a.AnP(40), a.AlP(50)), 16, "RIGHT", false); 
        iuTitulo = new IUEtiqueta(panelTitulo, new Fecha().getFecha1(), new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(45), a.AnP(40), a.AlP(50)), 16, "RIGHT", false);                 
    }
    private void construirPanelDatos(Area a){
        iuTabla = new IUTabla(
        panelDatos, 
        new Area(a.X(), a.Y(), a.An(), a.AlP(95)), 
        new String[]{"Nro", "G-S-My-An-Sa", "DESCRIPCION", "SALDO INICIAL", "DEBITOS", "CREDITOS", "SALDO DEBE", "SALDO HABER"}, 
        new Class[]{Integer.class, String.class, String.class, Integer.class, Integer.class, Double.class, Double.class}, 
        new int[]{5, 15, 40, 10, 10, 10, 10}, 
        CConmae.getLista("SELECT * FROM CONMAE WHERE ACTIVI = 2 AND (ABS(DEBMES) > 0 OR ABS(CREMES) > 0 OR ABS(SALACT)) GROUP BY CUETOT"), 
        new ModeloTabla<Conmae>(){            
            
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                if(moneda.equalsIgnoreCase("(B)OLIVIANOS")){
                    String error = "(*)";
                        double saldo = lista.get(rowIndex).getDebmes() - lista.get(rowIndex).getCremes();

                        switch (columnIndex) {
                            case 0:
                                return rowIndex + 1;
                            case 1:                
                                return lista.get(rowIndex).getGrup()+"-"+lista.get(rowIndex).getSubgru()+"-"+String.format("%02d",lista.get(rowIndex).getMayor())+"-"+String.format("%02d",lista.get(rowIndex).getCuenta())+"-"+String.format("%02d",lista.get(rowIndex).getSubcta());
                            case 2:
                                if(saldo == lista.get(rowIndex).getSalact())
                                    error = "";
                                return lista.get(rowIndex).getDescri()+error;
                            case 3:
                                return lista.get(rowIndex).getSalini();
                            case 4:                        
                                return lista.get(rowIndex).getDebmes();
                            case 5:
                                return lista.get(rowIndex).getCremes();
                            case 6:
                                return lista.get(rowIndex).getSalact();
                            default:
                                return null;
                        }
                }else{
                    String error = "(*)";
                    double saldo2 = lista.get(rowIndex).getDebme2()- lista.get(rowIndex).getCreme2();

                    switch (columnIndex) {
                        case 0:
                            return rowIndex + 1;
                        case 1:                
                            return lista.get(rowIndex).getGrup()+"-"+lista.get(rowIndex).getSubgru()+"-"+String.format("%02d",lista.get(rowIndex).getMayor())+"-"+String.format("%02d",lista.get(rowIndex).getCuenta())+"-"+String.format("%02d",lista.get(rowIndex).getSubcta());
                        case 2:
                            if(saldo2 == lista.get(rowIndex).getSalac2())
                                error = "";
                            return lista.get(rowIndex).getDescri()+error;
                        case 3:
                            return lista.get(rowIndex).getSalin2();
                        case 4:                        
                            return lista.get(rowIndex).getDebme2();
                        case 5:
                            return lista.get(rowIndex).getCreme2();
                        case 6:
                            return lista.get(rowIndex).getSalac2();
                        default:
                            return null;
                    }
                }
            }
            
        });
        iuTabla.setPosicionTextoHorizontal(2, SwingConstants.LEFT);
        iuTabla.setFocusable(true);
        
        panelTotal = new IUPanel(panelDatos, new Area(a.X(), a.Y() + a.AlP(95), a.An(), a.AlP(5)), true, Ayuda.COLOR_ATENCION);
        construirPanelTotal(new Area(2, 2, panelTotal.area.An() - 12, panelTotal.area.Al() - 4));
        sumarTotales();
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
    private void sumarTotales(){
        double totalDebmes = 0;
        double totalCremes = 0;
        double totalSalact = 0;
        for (Iterator it = iuTabla.modeloTabla.lista.iterator(); it.hasNext();) {
            Conmae c = (Conmae) it.next();
            if(moneda.equalsIgnoreCase("(B)OLIVIANOS")){
                totalDebmes = totalDebmes + c.getDebmes();
                totalCremes = totalCremes + Math.abs(c.getCremes());
                totalSalact = totalSalact + c.getSalact();
            }else{
                totalDebmes = totalDebmes + c.getDebme2();
                totalCremes = totalCremes + Math.abs(c.getCreme2());
                totalSalact = totalSalact + c.getSalac2();
            }
            
        }
        
        iuTotalDebitos.setTextoD(String.valueOf(totalDebmes));
        iuTotalCreditos.setTextoD(String.valueOf(totalCremes));
        iuTotalSaldos.setTextoD(String.valueOf(totalSalact));
    }
    private void algoritmosInicial(){
        panel.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "ESC" );
        panel.getActionMap().put( "ESC", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){
                dispose();
            }
        });        
    }    
}


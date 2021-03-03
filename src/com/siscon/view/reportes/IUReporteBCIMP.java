/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.reportes;

import SIGU.botones.IUBoton;
import SIGU.campoTexto.IUCampoTexto;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.paneles.IUPanel;
import SIGU.recursos.Area;
import SIGU.recursos.Fecha;
import SIGU.tablas.IUTabla;
import SIGU.tablas.ModeloTabla;
import SIGU.tablas.RenderDatosDecimales;
import SIGU.ventanas.IUSecundario;
import com.siscon.controller.CConmae;
import com.siscon.model.Conmae;
import com.siscon.model.Tabvar;
import com.siscon.model.Usuario;
import com.siscon.recursos.Ayuda;
import com.siscon.recursos.ImprimirPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.Printable;
import java.text.MessageFormat;
import java.util.Iterator;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class IUReporteBCIMP extends IUSecundario{
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
                private IUCampoTexto iuTotalSaldosDebe;
                private IUCampoTexto iuTotalSaldosHaber;
    
    private final Usuario usuario;
    private final Tabvar tabvar;
    private final String moneda;
    private final String forma;
    private String header = "";
    
    private IUPanel panelBoton;
    private IUBoton botonImprimir;
    
    public IUReporteBCIMP(RBalanceComprobacion ventanaPrincipal, String titulo, Area area, Usuario usuario, Tabvar tabvar, String moneda, String forma) {
        super(ventanaPrincipal, titulo, area);
        this.ventanaPrincipal = ventanaPrincipal;
        this.usuario = usuario;
        this.tabvar = tabvar;
        this.moneda = moneda;
        this.forma = forma;
        
        construirPanel(new Area(An()-6, Al()-29));
        algoritmosInicial();
        setEventos();
    }
    private void construirPanel(Area a){
        panel = new IUPanel(this, new Area(0, 0, (int)Ayuda.fromCMToPPI(22), (int)Ayuda.fromCMToPPI(27)), false);
        construirPaneles(new Area(10, 10, panel.area.An() - 10*3, panel.area.Al() - 10*3));
        
        panelBoton = new IUPanel(this, new Area((int)Ayuda.fromCMToPPI(23) + 5, (int)Ayuda.fromCMToPPI(1), 130, 100), true);
        botonImprimir = new IUBoton(panelBoton, new Area(panelBoton.area.An(), panelBoton.area.Al()), "IMPRIMIR", "", 16, 0, 0, SwingConstants.CENTER, SwingConstants.CENTER, '0', "");
    }
    private void construirPaneles(Area a){
        panelTitulo = new IUPanel(panel, new Area(a.X(), a.Y(), a.An(), a.AlP(7)), true, Ayuda.COLOR_FONDO);
        construirPanelTitulo(new Area(panelTitulo.area.AnP(2), 2, panelTitulo.area.An() - panelTitulo.area.AnP(2)*4, panelTitulo.area.Al() - 4));
        
        panelDatos = new IUPanel(panel, new Area(a.X(), a.Y(2) + a.AlP(7), a.An(), a.AlP(93)), false, Ayuda.COLOR_FONDO);
        construirPanelDatos(new Area(2, 2, panelDatos.area.An() - 4, panelDatos.area.Al() - 4));
    }
    
    private void construirPanelTitulo(Area a){
        iuTitulo = new IUEtiqueta(panelTitulo, usuario.getRazsoc()+"  |  REPORTE: BC ".toUpperCase(), new Area(a.X(), a.Y(), a.AnP(25), a.AlP(50)), 8, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "Moneda: "+moneda+"   |   Forma: "+forma, new Area(a.X(), a.Y(2) + a.AlP(45), a.AnP(35), a.AlP(50)), 8, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "BALANCE DE COMPROBACION", new Area(a.X(2) + a.AnP(25), a.Y(), a.AnP(45), a.AlP(50)), 8, "CENTER", false);                
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "Por Cuentas Activas", new Area(a.X(2) + a.AnP(35), a.Y(2) + a.AlP(45), a.AnP(35), a.AlP(50)), 8, "CENTER", Ayuda.COLOR_ROJO);
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "SISTEMA CONTABLE SISCON @v7.2. 2020", new Area(a.X(3) + a.AnP(60), a.Y(), a.AnP(40), a.AlP(50)), 8, "RIGHT", false); 
        iuTitulo = new IUEtiqueta(panelTitulo, new Fecha().getFecha1(), new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(45), a.AnP(40), a.AlP(50)), 8, "RIGHT", false);                 
        header = "              BALANCE DE COMPROBACION             ";
    }
    private void construirPanelDatos(Area a){
        iuTabla = new IUTabla(
        panelDatos, 
        new Area(a.X(), a.Y(), a.An(), a.AlP(96)), 
        new String[]{"Nro", "G-S-My-An-Sa", "DESCRIPCION", "SALDO INICIAL", "DEBITOS", "CREDITOS", "SALDO DEBE", "SALDO HABER"}, 
        new Class[]{Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}, 
        new int[]{5, 10, 35, 10, 10, 10, 10, 10}, 
        CConmae.getLista("SELECT * FROM conmae WHERE ACTIVI = 2 AND (DEBMES > 0 OR CREMES > 0) ORDER BY CUETOT"),
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
                                if(lista.get(rowIndex).getSalini() > 0)
                                    return String.valueOf(lista.get(rowIndex).getSalini());
                                else
                                    return "";
                            case 4:                        
                                if(lista.get(rowIndex).getDebmes() > 0)
                                    return String.valueOf(lista.get(rowIndex).getDebmes());
                                else
                                    return "";
                            case 5:
                                if(lista.get(rowIndex).getCremes() > 0)
                                    return String.valueOf(lista.get(rowIndex).getCremes());
                                return "";
                            case 6:
                                double saldoDebe = lista.get(rowIndex).getSalact();
                                if(saldoDebe > 0)
                                    return String.valueOf(lista.get(rowIndex).getSalact());
                                else
                                    return "";
                            case 7:
                                double saldoHaber = lista.get(rowIndex).getSalact();
                                if(saldoHaber < 0)
                                    return String.valueOf(lista.get(rowIndex).getSalact());
                                else
                                    return "";
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
                            if(lista.get(rowIndex).getSalin2() > 0)
                                return String.valueOf(lista.get(rowIndex).getSalin2());
                            else
                                return "";
                        case 4:                        
                            if(lista.get(rowIndex).getDebme2() > 0)
                                return String.valueOf(lista.get(rowIndex).getDebme2());
                            else
                                return "";
                        case 5:
                            if(lista.get(rowIndex).getCreme2() > 0)
                                return String.valueOf(lista.get(rowIndex).getCreme2());
                            return "";
                        case 6:
                            double saldoDebe = lista.get(rowIndex).getSalac2();
                            if(saldoDebe > 0)
                                return String.valueOf(lista.get(rowIndex).getSalac2());
                            else
                                return "";
                        case 7:
                            double saldoHaber = lista.get(rowIndex).getSalac2();
                            if(saldoHaber < 0)
                                return String.valueOf(lista.get(rowIndex).getSalac2());
                            else
                                return "";
                        default:
                            return null;
                    }
                }
            }
            
        });
        iuTabla.setPosicionTextoHorizontal(2, SwingConstants.LEFT);
        iuTabla.setPosicionTextoHorizontal(3, SwingConstants.RIGHT);
        iuTabla.setPosicionTextoHorizontal(4, SwingConstants.RIGHT);
        iuTabla.setPosicionTextoHorizontal(5, SwingConstants.RIGHT);
        iuTabla.setPosicionTextoHorizontal(6, SwingConstants.RIGHT);
        iuTabla.setFocusable(true);
        
        int[] columnas = {3, 4, 5, 6, 7};
        for (int i = 0; i < iuTabla.nombreCabecera.length; i++) {
            iuTabla.getColumnModel().getColumn(i).setCellRenderer(new RenderDatosDecimales(columnas));
        }
        iuTabla.setFuente(new Font("Arial", Font.PLAIN, 7));
        iuTabla.setFuenteCabecera(new Font("Araial", Font.PLAIN, 7), Color.lightGray, Ayuda.COLOR_TEXTO, true, 7, Ayuda.COLOR_FONDO);
        panelTotal = new IUPanel(panelDatos, new Area(a.X(), a.Y() + a.AlP(96), a.An(), a.AlP(4)), true, Ayuda.COLOR_ATENCION);
        construirPanelTotal(new Area(2, 2, panelTotal.area.An() - 12, panelTotal.area.Al() - 4));
        sumarTotales();
    }
    private void construirPanelTotal(Area a){
        iuTotal = new IUEtiqueta(panelTotal, "T O T A L E S "+moneda.toUpperCase(), new Area(a.X(), a.Y(), a.AnP(60), a.Al()), 7, "CENTER", true);
        iuTotalDebitos  = new IUCampoTexto(panelTotal, 20, 7, new Area(a.X(2) + a.AnP(60), a.Y(), a.AnP(10), a.Al()), SwingConstants.CENTER);
        iuTotalDebitos.setRestriccion("^\\d{0,5}(\\d\\.\\d?|\\.\\d)?\\d?$");
        iuTotalCreditos  = new IUCampoTexto(panelTotal, 20, 7, new Area(a.X(3) + a.AnP(70), a.Y(), a.AnP(10), a.Al()), SwingConstants.CENTER);
        iuTotalCreditos.setRestriccion("^\\d{0,5}(\\d\\.\\d?|\\.\\d)?\\d?$");
        iuTotalSaldosDebe  = new IUCampoTexto(panelTotal, 20, 7, new Area(a.X(4) + a.AnP(80), a.Y(), a.AnP(10), a.Al()), SwingConstants.CENTER);
        iuTotalSaldosDebe.setRestriccion("^\\d{0,5}(\\d\\.\\d?|\\.\\d)?\\d?$");
        iuTotalSaldosHaber  = new IUCampoTexto(panelTotal, 20, 7, new Area(a.X(5) + a.AnP(90), a.Y(), a.AnP(10), a.Al()), SwingConstants.CENTER);
        iuTotalSaldosHaber.setRestriccion("^\\d{0,5}(\\d\\.\\d?|\\.\\d)?\\d?$");
    }
    private void sumarTotales(){
        double totalDebmes = 0;
        double totalCremes = 0;
        double totalSalactDebe = 0;
        double totalSalactHaber = 0;
        for (Iterator it = iuTabla.modeloTabla.lista.iterator(); it.hasNext();) {
            Conmae c = (Conmae) it.next();
            if(moneda.equalsIgnoreCase("(B)OLIVIANOS")){
                totalDebmes = totalDebmes + c.getDebmes();
                totalCremes = totalCremes + Math.abs(c.getCremes());
                if(c.getSalact() > 0)
                    totalSalactDebe = totalSalactDebe + c.getSalact();
                else
                    totalSalactHaber = totalSalactHaber + c.getSalact();
            }else{
                totalDebmes = totalDebmes + c.getDebme2();
                totalCremes = totalCremes + Math.abs(c.getCreme2());
                if(c.getSalac2() > 0)
                    totalSalactDebe = totalSalactDebe + c.getSalac2();
                else
                    totalSalactHaber = totalSalactHaber + c.getSalac2();
            }
            
        }        
        iuTotalDebitos.setText(String.valueOf(Ayuda.formatearNumber(totalDebmes)));
        iuTotalCreditos.setText(String.valueOf(Ayuda.formatearNumber(totalCremes)));
        iuTotalSaldosDebe.setText(String.valueOf(Ayuda.formatearNumber(totalSalactDebe)));
        iuTotalSaldosHaber.setText(String.valueOf(Ayuda.formatearNumber(totalSalactHaber)));
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
    private void setEventos(){
        botonImprimir.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setEstado(true);
                dispose();
            }
        });
    }
    public IUPanel getIUPanel(){
        return panel;
    }
}

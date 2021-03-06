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
import com.siscon.controller.CTabvar;
import com.siscon.model.Conmae;
import com.siscon.model.Tabvar;
import com.siscon.model.Usuario;
import com.siscon.recursos.Ayuda;
import com.siscon.recursos.TablePrintable;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.Printable;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class IUReporteEGPIMP extends IUSecundario{
    private REstadoPerdidaGanancia ventanaPrincipal;
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
    private String header = "";
    
    private IUPanel panelBoton;
    private IUBoton botonImprimir;
    
    public IUReporteEGPIMP(REstadoPerdidaGanancia ventanaPrincipal, String titulo, Area area, Usuario usuario, Tabvar tabvar, String forma, String moneda) {
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
        iuTitulo = new IUEtiqueta(panelTitulo, "ESTADO DE PERDIDAS Y GANACIAS", new Area(a.X(2) + a.AnP(25), a.Y(), a.AnP(45), a.AlP(50)), 8, "CENTER", false);                
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "", new Area(a.X(2) + a.AnP(35), a.Y(2) + a.AlP(45), a.AnP(35), a.AlP(50)), 8, "CENTER", Ayuda.COLOR_ROJO);
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "SISTEMA CONTABLE SISCON @v7.2. 2020", new Area(a.X(3) + a.AnP(60), a.Y(), a.AnP(40), a.AlP(50)), 8, "RIGHT", false); 
        iuTitulo = new IUEtiqueta(panelTitulo, new Fecha().getFecha1(), new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(45), a.AnP(40), a.AlP(50)), 8, "RIGHT", false);                 
        header = "              ESTADO DE PERDIDAS Y GANANCIAS              ";
    }
    private void construirPanelDatos(Area a){
        
        iuTabla = new IUTabla(
        panelDatos, 
        new Area(a.X(), a.Y(), a.An(), a.AlP(96)), 
        new String[]{"G-S-My-An-Sa", "DESCRIPCION", "PARCIAL", "SUBTOTAL", "TOTAL"}, 
        new Class[]{String.class, String.class, String.class, String.class, String.class}, 
        new int[]{15, 55, 10, 10, 10}, 
        CConmae.getLista("SELECT * FROM conmae WHERE GRUP >= 3 AND SALACT != 0 ORDER BY CUETOT"),
        new ModeloTabla<Conmae>(){            
            
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return lista.get(rowIndex).getCodigo();
                    case 1:
                        return lista.get(rowIndex).getDescripcion();
                    case 2:
                        return lista.get(rowIndex).getParcial();
                    case 3:
                        return lista.get(rowIndex).getSubTotal();
                    case 4:                        
                        return lista.get(rowIndex).getTotal();
                    default:
                        return null;
                }
            }
            
        }) {
            @Override
            public Printable getPrintable(JTable.PrintMode printMode, MessageFormat headerFormat, MessageFormat footerFormat) {
                MessageFormat messageHeader = new MessageFormat(header);
                return new TablePrintable(this, printMode, messageHeader, footerFormat);
            }
        };
        iuTabla.setPosicionTextoHorizontal(1, SwingConstants.LEFT);
        iuTabla.setPosicionTextoHorizontal(2, SwingConstants.RIGHT);
        iuTabla.setPosicionTextoHorizontal(3, SwingConstants.RIGHT);
        iuTabla.setPosicionTextoHorizontal(4, SwingConstants.RIGHT);        
        iuTabla.setFocusable(true);
        int[] columnas = {2, 3, 4};
        for (int i = 0; i < iuTabla.nombreCabecera.length; i++) {
            iuTabla.getColumnModel().getColumn(i).setCellRenderer(new RenderDatosDecimales(columnas));
        }
        iuTabla.setFuente(new Font("Arial", Font.PLAIN, 7));
        iuTabla.setFuenteCabecera(new Font("Araial", Font.PLAIN, 7), Color.lightGray, Ayuda.COLOR_TEXTO, true, 7, Ayuda.COLOR_FONDO);
        panelTotal = new IUPanel(panelDatos, new Area(a.X(), a.Y() + a.AlP(96), a.An(), a.AlP(4)), true, Ayuda.COLOR_ATENCION);
        construirPanelTotal(new Area(2, 2, panelTotal.area.An() - 12, panelTotal.area.Al() - 4));
    }    
    private void construirPanelTotal(Area a){
        String unidad = "";
        if(moneda.equalsIgnoreCase("(B)OLIVIANOS"))
            unidad = "Bs.";
        else
            unidad = "$us.";
        iuTotal = new IUEtiqueta(panelTotal, "UTILIDAD o (-PERDIDA)  "+unidad, new Area(a.X(2) + a.AnP(40), a.Y(), a.AnP(50), a.Al()), 7, "RIGHT", true);
        iuTotalDebitos  = new IUCampoTexto(panelTotal, 20, 7, new Area(a.X(2) + a.AnP(70), a.Y(), a.AnP(10), a.Al()), SwingConstants.CENTER);
        iuTotalDebitos.setRestriccion("^\\d{0,5}(\\d\\.\\d?|\\.\\d)?\\d?$");
        iuTotalDebitos.setVisible(false);
        iuTotalCreditos  = new IUCampoTexto(panelTotal, 20, 7, new Area(a.X(3) + a.AnP(80), a.Y(), a.AnP(10), a.Al()), SwingConstants.CENTER);
        iuTotalCreditos.setRestriccion("^\\d{0,5}(\\d\\.\\d?|\\.\\d)?\\d?$");
        iuTotalCreditos.setVisible(false);
        iuTotalSaldos  = new IUCampoTexto(panelTotal, 20, 7, new Area(a.X(4) + a.AnP(90), a.Y(), a.AnP(10), a.Al()), SwingConstants.CENTER);
        iuTotalSaldos.setRestriccion("^\\d{0,5}(\\d\\.\\d?|\\.\\d)?\\d?$");
        iuTotalSaldos.setEditar(false);
    }
    private void cargarDatosReporte(){
        ArrayList<Conmae> lista = CConmae.getLista("SELECT * FROM conmae WHERE GRUP >= 3 AND SALACT != 0 ORDER BY CUETOT");
        double toting = 0;
        double totgas = 0;
        String descripcion = "";
        String parcial = "";
        String subtotal = "";
        String total = "";
        double salact = 0;
        double salac2 = 0;
        
        ArrayList<Conmae> list = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            Conmae c = lista.get(i);
            Conmae conmae = new Conmae(0);
            
            salact = c.getSalact();
            salac2 = c.getSalac2();
            
            if(c.getGrup() == 3){
                salact = salact*(-1);
                salac2 = salac2*(-1);
            }
            if(moneda.equalsIgnoreCase("(B)OLIVIANOS")){
                
                if(c.getNivel() == 1){
                    Conmae conmae1 = new Conmae(0);
                    conmae1.setCodigo("");
                    conmae1.setDescripcion("");
                    conmae1.setParcial("");
                    conmae1.setSubTotal("");
                    conmae1.setTotal("");
                    list.add(conmae1);
                    
                    if(c.getGrup() == 3){
                        descripcion = c.getDescri();
                        toting = c.getSalact();
                    }else{
                        descripcion = c.getDescri()+"(menos)";
                        totgas = c.getSalact();
                    }
                    parcial = "";
                    subtotal = "";
                    total = String.valueOf(salact);
                    
                    Conmae coname2 = new Conmae(0);
                    coname2.setCodigo(c.getGrup()+"-"+c.getSubgru()+"-"+String.format("%02d",c.getMayor())+"-"+String.format("%02d",c.getCuenta())+"-"+String.format("%02d",c.getSubcta()));
                    coname2.setDescripcion(descripcion);
                    coname2.setParcial(parcial);
                    coname2.setSubTotal(subtotal);
                    coname2.setTotal(total);
                    list.add(coname2);                    
                    
                }else{
                    if(c.getNivel() == 2){
                        parcial = "";
                        subtotal = "";
                        total = String.valueOf(salact);                        
                    }else{
                        if(c.getNivel() == 3){
                            parcial = "";
                            subtotal = String.valueOf(salact);
                            total = "";
                        }else{
                            if(c.getNivel() >= 4){
                                parcial = String.valueOf(salact);
                                subtotal = "";
                                total = "";
                            }
                        }
                    }
                    conmae.setCodigo(c.getGrup()+"-"+c.getSubgru()+"-"+String.format("%02d",c.getMayor())+"-"+String.format("%02d",c.getCuenta())+"-"+String.format("%02d",c.getSubcta()));
                    conmae.setDescripcion(c.getDescri());
                    conmae.setParcial(parcial);
                    conmae.setSubTotal(subtotal);
                    conmae.setTotal(total);
                }
            }else{
                if(c.getNivel() == 1){
                    Conmae conmae1 = new Conmae(0);
                    conmae1.setCodigo("");
                    conmae1.setDescripcion("");
                    conmae1.setParcial("");
                    conmae1.setSubTotal("");
                    conmae1.setTotal("");
                    list.add(conmae1);
                    
                    if(c.getGrup() == 3){
                        descripcion = c.getDescri();
                        toting = c.getSalac2();
                    }else{
                        descripcion = c.getDescri()+"(menos)";
                        totgas = c.getSalac2();
                    }
                    parcial = "";
                    subtotal = "";
                    total = String.valueOf(salac2);
                    
                    Conmae coname2 = new Conmae(0);
                    coname2.setCodigo(c.getGrup()+"-"+c.getSubgru()+"-"+String.format("%02d",c.getMayor())+"-"+String.format("%02d",c.getCuenta())+"-"+String.format("%02d",c.getSubcta()));
                    coname2.setDescripcion(descripcion);
                    coname2.setParcial(parcial);
                    coname2.setSubTotal(subtotal);
                    coname2.setTotal(total);
                    list.add(coname2);                    
                    
                }else{
                    if(c.getNivel() == 2){
                        parcial = "";
                        subtotal = "";
                        total = String.valueOf(salac2);                        
                    }else{
                        if(c.getNivel() == 3){
                            parcial = "";
                            subtotal = String.valueOf(salac2);
                            total = "";
                        }else{
                            if(c.getNivel() >= 4){
                                parcial = String.valueOf(salac2);
                                subtotal = "";
                                total = "";
                            }
                        }
                    }
                    conmae.setCodigo(c.getGrup()+"-"+c.getSubgru()+"-"+String.format("%02d",c.getMayor())+"-"+String.format("%02d",c.getCuenta())+"-"+String.format("%02d",c.getSubcta()));
                    conmae.setDescripcion(c.getDescri());
                    conmae.setParcial(parcial);
                    conmae.setSubTotal(subtotal);
                    conmae.setTotal(total);
                }
            }
            list.add(conmae);
        }
        iuTabla.actualizarTabla(list);
        iuTotalSaldos.setText(String.valueOf(Ayuda.formatearNumber(Ayuda.acotarNumero(Math.abs(toting) - Math.abs(totgas), 2))));
        
        Tabvar t = CTabvar.getTabvar("SELECT * FROM tabvar where tipo = 2 and numero = 4");
        if(t != null){
            if(moneda.equalsIgnoreCase("(B)OLIVIANOS")){            
                t.setCorrel(1);            
            }else{
                t.setCorrel(2);            
            }
            t.setMonto(Ayuda.acotarNumero(Math.abs(toting) - Math.abs(totgas), 2));
            CTabvar.modificarTabvar(t);                
        }
        
    }    
    private void algoritmosInicial(){
        panel.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "ESC" );
        panel.getActionMap().put( "ESC", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){
                dispose();
            }
        });
        cargarDatosReporte();
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

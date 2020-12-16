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
import SIGU.recursos.Fecha;
import SIGU.recursos.Hora;
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
public class IUReporteBG extends IUSecundario {
    private RBalanceGeneral ventanaPrincipal;
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
    private final String nivel;
    private final String moneda;
    private final String forma;
    
    public IUReporteBG(RBalanceGeneral ventanaPrincipal, String titulo, String tipoSize, Usuario usuario, Tabvar tabvar, String forma, String nivel, String moneda) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        this.usuario = usuario;
        this.tabvar = tabvar;
        this.nivel = nivel;
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
        panelTitulo = new IUPanel(panel, new Area(a.X(), a.Y(), a.An(), a.AlP(7)), false, Ayuda.COLOR_FONDO);
        construirPanelTitulo(new Area(panelTitulo.area.AnP(2), 2, panelTitulo.area.An() - panelTitulo.area.AnP(2)*4, panelTitulo.area.Al() - 4));
        
        panelDatos = new IUPanel(panel, new Area(a.X(), a.Y() + a.AlP(7), a.An(), a.AlP(93)), false, Ayuda.COLOR_FONDO);
        construirPanelDatos(new Area(2, 0, panelDatos.area.An() - 4, panelDatos.area.Al()));
    }
    
    private void construirPanelTitulo(Area a){
        iuTitulo = new IUEtiqueta(panelTitulo, usuario.getRazsoc()+ " | No. NIT: "+usuario.getNumnit(), new Area(a.X(), a.Y(), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, usuario.getDirraz(), new Area(a.X(), a.Y(2) + a.AlP(45), a.AnP(35), a.AlP(50)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "BALANCE GENERAL", new Area(a.X(2) + a.AnP(25), a.Y(), a.AnP(45), a.AlP(50)), 16, "CENTER", false);                
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "", new Area(a.X(2) + a.AnP(35), a.Y(2) + a.AlP(45), a.AnP(35), a.AlP(50)), 16, "CENTER", Ayuda.COLOR_ROJO);
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "SISTEMA CONTABLE SISCON @v7.2. 2020", new Area(a.X(3) + a.AnP(60), a.Y(), a.AnP(40), a.AlP(50)), 16, "RIGHT", false); 
        iuTitulo = new IUEtiqueta(panelTitulo, "Emitido: "+new Fecha().getFecha1()+" "+new Hora().getHora()+" "+new Hora().getFormato(), new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(45), a.AnP(40), a.AlP(50)), 16, "RIGHT", false);
    }
    private void construirPanelDatos(Area a){
        iuTitulo = new IUEtiqueta(panelDatos, "Form: BG   |    Nivel: "+forma, new Area(a.X() + a.AnP(2), a.Y(), a.AnP(50), a.AlP(4)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelDatos, "Moneda: "+moneda, new Area(a.X() + a.AnP(50), a.Y(), a.AnP(48), a.AlP(4)), 16, "RIGHT", false);
        iuTabla = new IUTabla(
        panelDatos, 
        new Area(a.X(), a.Y()+a.AlP(4), a.An(), a.AlP(96)), 
        new String[]{"G-S-My-An-Sa", "CUENTA", "PARCIAL", "SUBTOTAL", "TOTAL"}, 
        new Class[]{String.class, String.class, String.class, String.class, String.class}, 
        new int[]{15, 55, 10, 10, 10}, 
        CConmae.getLista("SELECT * FROM CONMAE WHERE GRUP <= 2 AND NIVEL <= "+nivel+" AND SALACT != 0 ORDER BY CUETOT"),
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
            
        });
        iuTabla.setPosicionTextoHorizontal(1, SwingConstants.LEFT);
        iuTabla.setPosicionTextoHorizontal(2, SwingConstants.RIGHT);
        iuTabla.setPosicionTextoHorizontal(3, SwingConstants.RIGHT);
        iuTabla.setPosicionTextoHorizontal(4, SwingConstants.RIGHT);        
        iuTabla.setFocusable(true);
        int[] columnas = {2, 3, 4};
        for (int i = 0; i < iuTabla.nombreCabecera.length; i++) {
            iuTabla.getColumnModel().getColumn(i).setCellRenderer(new RenderDatosDecimales(columnas));
        }
        
        //panelTotal = new IUPanel(panelDatos, new Area(a.X(), a.Y() + a.AlP(96), a.An(), a.AlP(4)), true, Ayuda.COLOR_ATENCION);
        //construirPanelTotal(new Area(2, 2, panelTotal.area.An() - 12, panelTotal.area.Al() - 4));
    }    
    private void construirPanelTotal(Area a){
        iuTotal = new IUEtiqueta(panelTotal, "UTILIDAD o PERDIDA ("+moneda.toUpperCase()+")", new Area(a.X(2) + a.AnP(40), a.Y(), a.AnP(50), a.Al()), 16, "RIGHT", true);
        iuTotalDebitos  = new IUCampoTexto(panelTotal, 20, 20, new Area(a.X(2) + a.AnP(70), a.Y(), a.AnP(10), a.Al()), SwingConstants.CENTER);
        iuTotalDebitos.setRestriccion("^\\d{0,5}(\\d\\.\\d?|\\.\\d)?\\d?$");
        iuTotalDebitos.setVisible(false);
        iuTotalCreditos  = new IUCampoTexto(panelTotal, 20, 20, new Area(a.X(3) + a.AnP(80), a.Y(), a.AnP(10), a.Al()), SwingConstants.CENTER);
        iuTotalCreditos.setRestriccion("^\\d{0,5}(\\d\\.\\d?|\\.\\d)?\\d?$");
        iuTotalCreditos.setVisible(false);
        iuTotalSaldos  = new IUCampoTexto(panelTotal, 20, 18, new Area(a.X(4) + a.AnP(90), a.Y(), a.AnP(10), a.Al()), SwingConstants.RIGHT);
        iuTotalSaldos.setRestriccion("^\\d{0,5}(\\d\\.\\d?|\\.\\d)?\\d?$");
        iuTotalSaldos.setEditar(false);
    }
    private void cargarDatosReporte(){
        ArrayList<Conmae> lista = CConmae.getLista("SELECT * FROM CONMAE WHERE GRUP <= 2 AND NIVEL <= "+nivel+" AND SALACT != 0 ORDER BY CUETOT");
        double totact = 0;
        double totpas = 0;
        String descripcion = "";
        String parcial = "";
        String subtotal = "";
        String total = "";
        double salact = 0;
        double salac2 = 0;
        Tabvar t = CTabvar.getTabvar("SELECT * FROM TABVAR WHERE TIPO = 2 AND NUMERO = 4");
        ArrayList<Conmae> list = new ArrayList<>();
        
        if(t != null){
            for (int i = 0; i < lista.size(); i++) {
                Conmae c = lista.get(i);
                Conmae conmae = new Conmae(0);

                salact = c.getSalact();
                salac2 = c.getSalac2();

                if(c.getGrup() != 1){
                    salact = salact*(-1);
                    salac2 = salac2*(-1);
                }
                if(moneda.equalsIgnoreCase("(B)OLIVIANOS")){

                    if(c.getNivel() == 1){
                        if(c.getGrup() == 1){
                            descripcion = c.getDescri();
                            totact = c.getSalact();
                            parcial = "";
                            subtotal = "";
                            total = "";

                            Conmae coname2 = new Conmae(0);
                            coname2.setCodigo(c.getGrup()+"-"+c.getSubgru()+"-"+String.format("%02d",c.getMayor())+"-"+String.format("%02d",c.getCuenta())+"-"+String.format("%02d",c.getSubcta()));
                            coname2.setDescripcion(descripcion);
                            coname2.setParcial(parcial);
                            coname2.setSubTotal(subtotal);
                            coname2.setTotal(total);

                            list.add(coname2);
                        }else{
                            Conmae coname0 = new Conmae(0);
                            coname0.setCodigo("");
                            coname0.setDescripcion("");
                            coname0.setParcial("");
                            coname0.setSubTotal("");
                            coname0.setTotal("");
                            list.add(coname0);

                            Conmae coname1 = new Conmae(0);
                            coname1.setCodigo("");
                            coname1.setDescripcion("TOTAL ACTIVO "+moneda);
                            coname1.setParcial("");
                            coname1.setSubTotal("");
                            coname1.setTotal(String.valueOf(totact));
                            list.add(coname1);

                            Conmae coname2 = new Conmae(0);
                            coname2.setCodigo("");
                            coname2.setDescripcion("");
                            coname2.setParcial("");
                            coname2.setSubTotal("");
                            coname2.setTotal("");
                            list.add(coname2);

                            descripcion = c.getDescri()+"(menos)";
                            totpas = c.getSalact();

                            parcial = "";
                            subtotal = "";
                            total = "";

                            Conmae coname3 = new Conmae(0);
                            coname3.setCodigo(c.getGrup()+"-"+c.getSubgru()+"-"+String.format("%02d",c.getMayor())+"-"+String.format("%02d",c.getCuenta())+"-"+String.format("%02d",c.getSubcta()));
                            coname3.setDescripcion(descripcion);
                            coname3.setParcial(parcial);
                            coname3.setSubTotal(subtotal);
                            coname3.setTotal(total);

                            list.add(coname3);
                        }
                    }else{
                        if(c.getNivel() == 2){
                            descripcion = " "+c.getDescri();
                            parcial = "";
                            subtotal = "";
                            total = String.valueOf(salact);                        
                        }else{
                            if(c.getNivel() == 3){
                                descripcion = "   "+c.getDescri();
                                parcial = "";
                                subtotal = String.valueOf(salact);
                                total = "";
                            }else{
                                if(c.getNivel() >= 4){
                                    descripcion = "     "+c.getDescri();
                                    parcial = String.valueOf(salact);
                                    subtotal = "";
                                    total = "";
                                }
                            }
                        }
                        conmae.setCodigo(c.getGrup()+"-"+c.getSubgru()+"-"+String.format("%02d",c.getMayor())+"-"+String.format("%02d",c.getCuenta())+"-"+String.format("%02d",c.getSubcta()));
                        conmae.setDescripcion(descripcion);
                        conmae.setParcial(parcial);
                        conmae.setSubTotal(subtotal);
                        conmae.setTotal(total);
                        list.add(conmae);
                    }

                }else{
                    if(c.getNivel() == 1){
                        if(c.getGrup() == 1){
                            descripcion = c.getDescri();
                            totact = c.getSalac2();
                            parcial = "";
                            subtotal = "";
                            total = "";

                            Conmae coname2 = new Conmae(0);
                            coname2.setCodigo(c.getGrup()+"-"+c.getSubgru()+"-"+String.format("%02d",c.getMayor())+"-"+String.format("%02d",c.getCuenta())+"-"+String.format("%02d",c.getSubcta()));
                            coname2.setDescripcion(descripcion);
                            coname2.setParcial(parcial);
                            coname2.setSubTotal(subtotal);
                            coname2.setTotal(total);

                            list.add(coname2);
                        }else{
                            Conmae coname0 = new Conmae(0);
                            coname0.setCodigo("");
                            coname0.setDescripcion("");
                            coname0.setParcial("");
                            coname0.setSubTotal("");
                            coname0.setTotal("");
                            list.add(coname0);

                            Conmae coname1 = new Conmae(0);
                            coname1.setCodigo("");
                            coname1.setDescripcion("TOTAL ACTIVO "+moneda);
                            coname1.setParcial("");
                            coname1.setSubTotal("");
                            coname1.setTotal(String.valueOf(totact));
                            list.add(coname1);

                            Conmae coname2 = new Conmae(0);
                            coname2.setCodigo("");
                            coname2.setDescripcion("");
                            coname2.setParcial("");
                            coname2.setSubTotal("");
                            coname2.setTotal("");
                            list.add(coname2);

                            descripcion = c.getDescri()+"(menos)";
                            totpas = c.getSalac2();

                            parcial = "";
                            subtotal = "";
                            total = "";

                            Conmae coname3 = new Conmae(0);
                            coname3.setCodigo(c.getGrup()+"-"+c.getSubgru()+"-"+String.format("%02d",c.getMayor())+"-"+String.format("%02d",c.getCuenta())+"-"+String.format("%02d",c.getSubcta()));
                            coname3.setDescripcion(descripcion);
                            coname3.setParcial(parcial);
                            coname3.setSubTotal(subtotal);
                            coname3.setTotal(total);

                            list.add(coname3);
                        }
                    }else{
                        if(c.getNivel() == 2){
                            descripcion = " "+c.getDescri();
                            parcial = "";
                            subtotal = "";
                            total = String.valueOf(salac2);                        
                        }else{
                            if(c.getNivel() == 3){
                                descripcion = "   "+c.getDescri();
                                parcial = "";
                                subtotal = String.valueOf(salac2);
                                total = "";
                            }else{
                                if(c.getNivel() >= 4){
                                    descripcion = "     "+c.getDescri();
                                    parcial = String.valueOf(salac2);
                                    subtotal = "";
                                    total = "";
                                }
                            }
                        }
                        conmae.setCodigo(c.getGrup()+"-"+c.getSubgru()+"-"+String.format("%02d",c.getMayor())+"-"+String.format("%02d",c.getCuenta())+"-"+String.format("%02d",c.getSubcta()));
                        conmae.setDescripcion(descripcion);
                        conmae.setParcial(parcial);
                        conmae.setSubTotal(subtotal);
                        conmae.setTotal(total);
                        list.add(conmae);
                    }
                }                
            }
            Conmae coname0 = new Conmae(0);
            coname0.setCodigo("");
            coname0.setDescripcion("");
            coname0.setParcial("");
            coname0.setSubTotal("");
            coname0.setTotal("");
            list.add(coname0);

            Conmae coname1 = new Conmae(0);
            coname1.setCodigo("");
            coname1.setDescripcion("SUB TOTAL PASIVO "+moneda);
            coname1.setParcial("");
            coname1.setSubTotal("");
            coname1.setTotal(String.valueOf(totpas));
            list.add(coname1);

            Conmae coname01 = new Conmae(0);
            coname01.setCodigo("");
            coname01.setDescripcion("");
            coname01.setParcial("");
            coname01.setSubTotal("");
            coname01.setTotal("");
            list.add(coname01);
            
            double totalPasivo = 0;
            if(t.getMonto() > 0)
                descripcion = "GANANCIA "+moneda;
            else
                descripcion = "PERDIDA "+moneda;
                        
            Conmae coname2 = new Conmae(0);
            coname2.setCodigo("");
            coname2.setDescripcion(descripcion);
            coname2.setParcial("");
            coname2.setSubTotal("");
            coname2.setTotal(String.valueOf(t.getMonto()));
            list.add(coname2);
            
            
            Conmae coname02 = new Conmae(0);
            coname02.setCodigo("");
            coname02.setDescripcion("");
            coname02.setParcial("");
            coname02.setSubTotal("");
            coname02.setTotal("");
            list.add(coname02);
            
            totalPasivo = Math.abs(t.getMonto()) + Math.abs(totpas);
            descripcion = "TOTAL PASIVO "+moneda;
            
            Conmae coname3 = new Conmae(0);
            coname3.setCodigo("");
            coname3.setDescripcion(descripcion);
            coname3.setParcial("");
            coname3.setSubTotal("");
            coname3.setTotal(String.valueOf(totalPasivo));
            list.add(coname3);
        }else{
            Ayuda.mostrarMensajeError(null, "Error: No existe la tabla TABVAR...", "error");
        }
        
        
        iuTabla.actualizarTabla(list);
        //iuTotalSaldos.setText(String.valueOf(Ayuda.formatearNumber(Ayuda.acotarNumero(Math.abs(totact) - Math.abs(totpas), 2))));
                        
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
}

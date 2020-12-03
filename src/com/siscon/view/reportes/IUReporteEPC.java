/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.reportes;

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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class IUReporteEPC extends IUSecundario{
    
    private REmisionPC ventanaPrincipal;
    private String titulo;
    
    private IUPanel panel;
        private IUPanel panelTitulo;
        private IUEtiqueta iuTitulo;
    
    private IUPanel panelDatos;
        private IUPanel primerPanel;
            private IUTabla iuTabla;
    
    private final Usuario usuario;
    private final Tabvar tabvar;
    private final String nombreNivel;
    private final String nombreGrupo;
    private final String grupos;
    private final String nivel;
    
    public IUReporteEPC(REmisionPC ventanaPrincipal, String titulo, String tipoSize, Usuario usuario, Tabvar tabvar, String nombreNivel, String nombreGrupo, String grupos, String nivel) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        this.usuario = usuario;
        this.tabvar = tabvar;
        this.nombreNivel = nombreNivel;
        this.nombreGrupo = nombreGrupo;
        this.grupos = grupos;
        this.nivel = nivel;
        
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
        iuTitulo = new IUEtiqueta(panelTitulo, usuario.getRazsoc()+"  |  REPORTE: EPC ".toUpperCase(), new Area(a.X(), a.Y(), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "Nivel: "+nombreNivel+"   |   Cuenta: "+nombreGrupo, new Area(a.X(), a.Y(2) + a.AlP(45), a.AnP(45), a.AlP(50)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "PLAN DE CUENTAS", new Area(a.X(2) + a.AnP(45), a.Y(), a.AnP(35), a.AlP(50)), 16, "LEFT", false);                
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, Ayuda.getDatoCadena("DESCRI", "SELECT DESCRI FROM TABVAR WHERE TIPO = 10 AND NUMERO = 1"), new Area(a.X(2) + a.AnP(45), a.Y(2) + a.AlP(45), a.AnP(35), a.AlP(50)), 16, "CENTER", Ayuda.COLOR_ROJO);
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "SISTEMA CONTABLE SISCON @v7.2. 2020", new Area(a.X(3) + a.AnP(60), a.Y(), a.AnP(40), a.AlP(50)), 16, "RIGHT", false); 
        iuTitulo = new IUEtiqueta(panelTitulo, new Fecha().getFecha1(), new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(45), a.AnP(40), a.AlP(50)), 16, "RIGHT", false);                 
    }
    private void construirPanelDatos(Area a){
        iuTabla = new IUTabla(
        panelDatos, 
        new Area(a.X(), a.Y(), a.An(), a.Al()), 
        new String[]{"Nro", "G-S-My-An-Sa", "DESCRIPCION", "NIVEL", "ACTIVIDAD", "SALDO (Bs.-)"}, 
        new Class[]{Integer.class, String.class, String.class, Integer.class, Integer.class, Double.class}, 
        new int[]{5, 15, 50, 10, 10, 10}, 
        CConmae.getLista("SELECT * FROM CONMAE WHERE GRUP = "+grupos+" AND NIVEL <= "+nivel+" GROUP BY CUETOT"), 
        new ModeloTabla<Conmae>(){
            
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return rowIndex + 1;
                    case 1:                
                        return lista.get(rowIndex).getGrup()+"-"+lista.get(rowIndex).getSubgru()+"-"+String.format("%02d",lista.get(rowIndex).getMayor())+"-"+String.format("%02d",lista.get(rowIndex).getCuenta())+"-"+String.format("%02d",lista.get(rowIndex).getSubcta());
                    case 2:
                        return lista.get(rowIndex).getDescri();
                    case 3:
                        return lista.get(rowIndex).getNivel();
                    case 4:
                        return lista.get(rowIndex).getActivi();
                    case 5:
                        return lista.get(rowIndex).getSalact();
                    default:
                        return null;
                }
            }
            
        });
        iuTabla.setPosicionTextoHorizontal(2, SwingConstants.LEFT);
        iuTabla.setPosicionTextoHorizontal(5, SwingConstants.RIGHT);
        iuTabla.setFocusable(true);
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

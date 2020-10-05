/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view;

import SIGU.botones.SIUBoton;
import SIGU.etiquetas.SIUEtiqueta;
import SIGU.paneles.SIUPanel;
import SIGU.recursos.Grid;
import SIGU.tablas.ModeloTabla;
import SIGU.tablas.SIUTabla;
import SIGU.ventanas.SIUSecundario;
import com.siscon.controller.CTabvar;
import com.siscon.model.Tabvar;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class VMostrarTabvar extends SIUSecundario{
    
    private VPrincipal ventanaPrincipal;
    private SIUPanel panel;
    private SIUPanel panelTitulo;
    private SIUBoton botonSalir;
    private SIUEtiqueta iuTitulo;
    private SIUPanel panelTabla;
    private SIUTabla iuTabla;
    
    /**
     *
     * @param ventanaPrincipal
     * @param tipoSize
     */
    public VMostrarTabvar(VPrincipal ventanaPrincipal, String tipoSize) {
        super(ventanaPrincipal, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        construirPaneles();
        setEventos();
    }
    private void construirPaneles(){
        panel = new SIUPanel(this, new Grid(0, 0, 12, 12));
        panel.setColorFondo(Color.WHITE, 0);
        
        panelTitulo = new SIUPanel(panel, new Grid(51, 13, 0, 0, 12, 1), true);
        iuTitulo = new SIUEtiqueta(panelTitulo, "TABLA 'TABVAR'", new Grid(0, 0, 43, 12), 24, "CENTER", new Color(120, 0, 0));
        botonSalir = new SIUBoton(panelTitulo, new Grid(44, 2, 5, 8), "Salir", "/imagenes/cerrar.png", 16, 20, 8, SwingConstants.RIGHT, SwingConstants.CENTER, 'r', "salir de la ventana");
        
        panelTabla = new SIUPanel(panel, new Grid(0, 1, 12, 10), true);
        construirPanelTabla();
    }   
    private void construirPanelTabla(){
        ArrayList<Tabvar> lista = CTabvar.getLista();
        iuTabla = new SIUTabla(
                panelTabla, 
                new Grid(0, 0, 12, 12), 
                new String[]{"RECORD", "TIPO", "NUMERO", "DESCRI", "CODCON", "CORREL", "MONTO", "OBSERV", "FECHA", "FECHA2", "MONTO2", "TIPCAM", "NUMNIT"}, 
                new Class[]{Integer.class, Integer.class, Integer.class, String.class, Integer.class, Integer.class, Double.class, String.class, String.class, String.class, Double.class, Integer.class, Integer.class}, 
                new int[]{4,4,4,20,8,8,8,8,8,8,6,6,8}, 
                lista, new ModeloTabla<Tabvar>(){
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return lista.get(rowIndex).getRecord();
                    case 1:                
                        return lista.get(rowIndex).getTipo();
                    case 2:                
                        return lista.get(rowIndex).getNumero();
                    case 3:
                        return lista.get(rowIndex).getDescri();
                    case 4:
                        return lista.get(rowIndex).getCodcon();
                    case 5:
                        return lista.get(rowIndex).getCorrel();
                    case 6:
                        return lista.get(rowIndex).getMonto();
                    case 7:
                        return lista.get(rowIndex).getObserv();
                    case 8:
                        return lista.get(rowIndex).getFecha();
                    case 9:
                        return lista.get(rowIndex).getFecha2();
                    case 10:
                        return lista.get(rowIndex).getMonto2();
                    case 11:
                        return lista.get(rowIndex).getTipcam();
                    case 12:
                        return lista.get(rowIndex).getNumnit();
                    default:
                        return null;
                }
            }
        });
    }
    private void setEventos(){
        botonSalir.addActionListener((ActionEvent e) -> {
            dispose();
        });
    }
}

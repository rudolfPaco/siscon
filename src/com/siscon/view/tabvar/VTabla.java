/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.tabvar;

import SIGU.botones.IUBoton;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.paneles.IUPanel;
import SIGU.recursos.Area;
import SIGU.recursos.Fecha;
import SIGU.tablas.IUTabla;
import SIGU.tablas.ModeloTabla;
import SIGU.ventanas.IUSecundario;
import com.siscon.controller.CTabvar;
import com.siscon.model.Tabvar;
import com.siscon.recursos.Ayuda;
import com.siscon.view.VPrincipal;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class VTabla extends IUSecundario{
    
    private VPrincipal ventanaPrincipal;
    private IUPanel panel;
        private IUPanel panelTitulo;
            private IUEtiqueta iuTitulo;
            private IUPanel panelBotones;
                private IUBoton iuBotonReemplazar;
                private IUBoton iuBotonCargar;
                private IUBoton iuBotonSalir;
        private IUPanel panelTabla;
        private IUTabla iuTabla;
    
    public VTabla(VPrincipal ventanaPrincipal, String titulo, String tipoSize) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        construirPaneles();
        setEventos();
    }
    private void construirPaneles(){
        panel = new IUPanel(this, new Area(An()-6, Al()-29), true);
        
        panelTitulo = new IUPanel(panel, new Area(2, 2, panel.area.An() - 4, (panel.area.Al() - 6)/14), true);
        construirPanelTitulo(new Area(4, 4, panelTitulo.area.An() - 12, panelTitulo.area.Al() - 8));
        
        panelTabla = new IUPanel(panel, new Area(2, 4 + panelTitulo.area.Al(), panelTitulo.area.An(), panel.area.Al() - panelTitulo.area.Al() - 6), true);
        construirPanelTabla(new Area(4, 4, panelTabla.area.An() - 8, panelTabla.area.Al() - 8));
    }
    private void construirPanelTitulo(Area a){
        iuTitulo = new IUEtiqueta(panelTitulo, "TABLA PRINCIPAL 'TABVAR'", new Area(a.X(), a.Y(), a.AnP(50), a.Al()), 24, "CENTER", new Color(120, 0, 0));
        
        panelBotones = new IUPanel(panelTitulo, new Area(a.X(2) + a.AnP(50), a.Y(), a.AnP(50), a.Al()), true);
        construirPanelBotones(new Area(2, 2, panelBotones.area.An() - 8, panelBotones.area.Al() - 4));
    }
    private void construirPanelBotones(Area a){
        iuBotonReemplazar = new IUBoton(panelBotones, new Area(a.X(), a.Y(), a.AnP(30), a.Al()), "REEMPLAZAR", "/imagenes/edit.png", 16, 25, 10, SwingConstants.RIGHT, SwingConstants.CENTER, 'E', "boton que guarda todos los registros que estan en la tabla");
        iuBotonCargar = new IUBoton(panelBotones, new Area(a.X(2) + a.AnP(35), a.Y(), a.AnP(40), a.Al()), "CARGAR .TXT", "/imagenes/bajar.png", 16, 25, 10, SwingConstants.RIGHT, SwingConstants.CENTER, 'C', "boton que carga el archivo principal .txt");
        iuBotonSalir = new IUBoton(panelBotones, new Area(a.X(3) + a.AnP(80), a.Y(), a.AnP(20), a.Al()), "SALIR", "/imagenes/cerrar.png", 16, 25, 10, SwingConstants.RIGHT, SwingConstants.CENTER, 'S', "boton para salir de la ventana");
    }
    private void construirPanelTabla(Area a){
        ArrayList<Tabvar> lista = CTabvar.getLista();
        
        iuTabla = new IUTabla(panelTabla,
                new Area(a.X(), a.Y(), a.An(), a.Al()), 
                new String[]{"RECORD", "TIPO", "NUMERO", "DESCRI", "CODCON", "CORREL", "MONTO", "OBSERV", "FECHA", "FECHA2", "MONTO2", "TIPCAM", "NUMNIT"}, 
                new Class[]{Integer.class, Integer.class, Integer.class, String.class, Integer.class, Integer.class, Double.class, String.class, String.class, String.class, Double.class, Integer.class, Integer.class}, 
                new int[]{4,4,4,18,6,5,8,18,9,9,5,4,8}, 
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
        iuTabla.setPosicionTextoHorizontal(3, SwingConstants.LEFT);
        iuTabla.setPosicionTextoHorizontal(6, SwingConstants.RIGHT);
        iuTabla.setPosicionTextoHorizontal(7, SwingConstants.RIGHT);
        iuTabla.setPosicionTextoHorizontal(10, SwingConstants.RIGHT);
        iuTabla.setPosicionTextoHorizontal(11, SwingConstants.RIGHT);        
    }
    private void cargarArchivoTxt(){
        ArrayList<Tabvar> lista = new ArrayList<>();
        
        String urlArchivo = Ayuda.examinarArchivo(ventanaPrincipal, System.getProperties().getProperty("user.dir"));
        String nombreFichero = urlArchivo;
        //Declarar una variable BufferedReader
        BufferedReader br = null;
        try {
           //Crear un objeto BufferedReader al que se le pasa 
           //   un objeto FileReader con el nombre del fichero
           br = new BufferedReader(new FileReader(nombreFichero));
           //Leer la primera línea, guardando en un String
           String texto = br.readLine();
           //Repetir mientras no se llegue al final del fichero
           int RECORD = 1;
           while(texto != null){
               //Hacer lo que sea con la línea leída
               //System.out.println(texto);
               texto = texto.trim();
               ArrayList<String> registro = new ArrayList<>(Arrays.asList(texto.split(",")));
               if(!texto.isEmpty()){
                    Tabvar tabla = new Tabvar(RECORD);
                    tabla.setTipo(Integer.parseInt(registro.get(0)));
                    tabla.setNumero(Integer.parseInt(registro.get(1)));
                    tabla.setDescri(registro.get(2));
                    tabla.setCodcon(Integer.parseInt(registro.get(3)));
                    tabla.setCorrel(Integer.parseInt(registro.get(4)));
                    tabla.setMonto(Double.parseDouble(registro.get(5)));
                    tabla.setObserv(registro.get(6));
                    
                    System.out.println(String.valueOf(registro.get(7)));
                    String fecha1 = Ayuda.formatDate("01/01/2015");
                    System.out.println(String.valueOf(fecha1));
                    tabla.setFecha(fecha1);
                    
                    System.out.println(String.valueOf(registro.get(8)));
                    String fecha2 = Ayuda.formatDate("01/01/2015");
                    System.out.println("la fecha2: "+fecha2);
                    tabla.setFecha2(fecha2);
                    
                    tabla.setMonto2(Double.parseDouble(registro.get(9)));
                    tabla.setTipcam(Double.parseDouble(registro.get(10)));
                    tabla.setNumnit(Integer.parseInt(registro.get(11)));
                    
                    System.out.println("la tabla es: "+tabla.toString());
                    lista.add(tabla);
                    RECORD++;
               }
               //Leer la siguiente línea
               texto = br.readLine();
           }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: Fichero no encontrado");
            System.out.println(e.getMessage());
        }
        catch(IOException e) {
            System.out.println("Error de lectura del fichero");
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if(br != null)
                    br.close();
            }
            catch (IOException e) {
                System.out.println("Error al cerrar el fichero");
                System.out.println(e.getMessage());
            }
        }
        iuTabla.actualizarTabla(lista);
    }
    private void reemplazarArchivo(){
        ArrayList<Tabvar> listaTabvar = CTabvar.getLista();
        listaTabvar.forEach((tabvar) -> {
            CTabvar.eliminarTabvar(tabvar);
        });
        
        JOptionPane.showMessageDialog(ventanaPrincipal, "se ha eliminado todos los datos de la tabla TABVAR...!");
        
        for (int i = 0; i < iuTabla.modeloTabla.lista.size(); i++) {
            Object tabvar = iuTabla.modeloTabla.lista.get(i);
            CTabvar.guardarTabvar((Tabvar) tabvar);
        }
        
        JOptionPane.showMessageDialog(ventanaPrincipal, "se ha guardado todos los datos de la tabla TABVAR correctamente...!");
    }
    private void setEventos(){
        iuBotonSalir.addActionListener((ActionEvent e) -> {
            dispose();
        });
        iuBotonCargar.addActionListener((ActionEvent e) -> {
            cargarArchivoTxt();
        });
        iuBotonReemplazar.addActionListener((ActionEvent e) -> {
            reemplazarArchivo();
        });
    }
}

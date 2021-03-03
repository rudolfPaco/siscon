/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.tablas;

import SIGU.botones.IUBoton;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.paneles.IUPanel;
import SIGU.recursos.Area;
import SIGU.tablas.IUTabla;
import SIGU.tablas.ModeloTabla;
import SIGU.ventanas.IUSecundario;
import com.siscon.controller.CConmae;
import com.siscon.model.Conmae;
import com.siscon.recursos.Ayuda;
import com.siscon.view.VPrincipal;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author neo
 */
public class VTablaConmae extends IUSecundario{
    
    private VPrincipal ventanaPrincipal;
    private IUPanel panel;
        private IUPanel panelTitulo;
            private IUEtiqueta iuTitulo;
            private IUPanel panelBotones;
                private IUBoton iuBotonEliminar;
                private IUBoton iuBotonGrabar;
                private IUBoton iuBotonCargar;
                private IUBoton iuBotonSalir;
        private IUPanel panelTabla;
        private IUTabla iuTabla;
    
    public VTablaConmae(VPrincipal ventanaPrincipal, String titulo, String tipoSize) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        construirPaneles();
        setEventos();
    }
    private void construirPaneles(){
        panel = new IUPanel(this, new Area(An()-6, Al()-29), true);        
        panel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        panel.getActionMap().put("Enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {                
                iuTabla.setFocusable(false);
                iuTabla.modeloTabla.fireTableDataChanged();
            }
        });
        
        panelTitulo = new IUPanel(panel, new Area(2, 2, panel.area.An() - 4, (panel.area.Al() - 6)/14), true);
        construirPanelTitulo(new Area(4, 4, panelTitulo.area.An() - 12, panelTitulo.area.Al() - 8));
        
        panelTabla = new IUPanel(panel, new Area(2, 4 + panelTitulo.area.Al(), panelTitulo.area.An(), panel.area.Al() - panelTitulo.area.Al() - 6), true);
        construirPanelTabla(new Area(4, 4, panelTabla.area.An() - 8, panelTabla.area.Al() - 8));
    }
    private void construirPanelTitulo(Area a){
        iuTitulo = new IUEtiqueta(panelTitulo, "Tabla CONMAE (PLAN DE CUENTAS)", new Area(a.X(), a.Y(), a.AnP(50), a.Al()), 24, "CENTER", new Color(120, 0, 0));
        
        panelBotones = new IUPanel(panelTitulo, new Area(a.X(2) + a.AnP(50), a.Y(), a.AnP(50), a.Al()), true);
        construirPanelBotones(new Area(2, 2, panelBotones.area.An() - 10, panelBotones.area.Al() - 4));
    }
    private void construirPanelBotones(Area a){
        iuBotonEliminar = new IUBoton(panelBotones, new Area(a.X() + a.AnP(20), a.Y(), a.AnP(20), a.Al()), "F3 ELIMINAR", "/imagenes/delete.png", 16, 25, 10, SwingConstants.CENTER, SwingConstants.CENTER, 'E', "boton que elimina todos los registros de la tabla");
        iuBotonEliminar.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_F3, 0 ), "F3" );
        iuBotonEliminar.getActionMap().put( "F3", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                iuBotonEliminar.doClick();
                eliminarArchivo();
            }
        });
        
        iuBotonGrabar = new IUBoton(panelBotones, new Area(a.X(2) + a.AnP(40), a.Y(), a.AnP(20), a.Al()), "GRABAR", "/imagenes/save.png", 16, 25, 10, SwingConstants.CENTER, SwingConstants.CENTER, 'G', "boton que guarda todos los registros que estan en la tabla");
        iuBotonGrabar.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_G, 0 ), "G" );
        iuBotonGrabar.getActionMap().put( "G", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                iuBotonGrabar.doClick();
                if(Ayuda.mensaje(ventanaPrincipal, "Esta seguro que desea GUARDAR los REGISTROS DE LA TABLA...?", "pregunta")){
                    guardarArchivo();
                }                
            }
        });
        
        iuBotonCargar = new IUBoton(panelBotones, new Area(a.X(3) + a.AnP(60), a.Y(), a.AnP(20), a.Al()), "CARGAR .TXT", "/imagenes/bajar.png", 16, 25, 10, SwingConstants.CENTER, SwingConstants.CENTER, 'C', "boton que carga el archivo principal .txt");
        iuBotonCargar.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_C, 0 ), "C" );
        iuBotonCargar.getActionMap().put( "C", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                iuBotonCargar.doClick();
                cargarArchivoTxt();
            }
        });
        
        iuBotonSalir = new IUBoton(panelBotones, new Area(a.X(4) + a.AnP(80), a.Y(), a.AnP(20), a.Al()), "ESC", "/imagenes/cerrar.png", 16, 25, 10, SwingConstants.CENTER, SwingConstants.CENTER, 'S', "boton para salir de la ventana");        
        iuBotonSalir.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "ESC" );
        iuBotonSalir.getActionMap().put( "ESC", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                iuBotonSalir.doClick();
                dispose();
            }
        });
    }
    private void construirPanelTabla(Area a){
        ArrayList<Conmae> lista = CConmae.getLista("SELECT * FROM conmae");
        
        iuTabla = new IUTabla(panelTabla,
                new Area(a.X(), a.Y(), a.An(), a.Al()), 
                new String[]{"ID", "G", "S", "My", "An", "Sa", "CUETOT", "NUMCUE", "DESCRI", "ACTVI", "NIVEL", "LUGAR", "PRESUP", "SALINI", "ANTDIA", "ANTMES", "SALACT", "DEBANO", "CREANO", "DEBMES", "CREMES", "DEBDIA", "CREDIA", "INDICA", "SALIN2", "DEBME2", "ANTME2","CREME2", "SALAC2", "FECHA", "NOMPRE", "DEBAN2", "CREAN2", "ANTDI2", "DEBDI2", "CREDI2", "FECHA2"}, 
                new Class[]{Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Double.class, Integer.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Integer.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class}, 
                new int[]{2,2,2,2,2,2,6,2,16,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,5,2,2,2,2,2,2,5}, 
                lista, new ModeloTabla<Conmae>(){
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return lista.get(rowIndex).getId();
                    case 1:                
                        return lista.get(rowIndex).getGrup();
                    case 2:                
                        return lista.get(rowIndex).getSubgru();
                    case 3:
                        return lista.get(rowIndex).getMayor();
                    case 4:
                        return lista.get(rowIndex).getCuenta();
                    case 5:
                        return lista.get(rowIndex).getSubcta();
                    case 6:
                        return lista.get(rowIndex).getCuetot();
                    case 7:
                        return lista.get(rowIndex).getNumcue();
                    case 8:
                        return lista.get(rowIndex).getDescri();
                    case 9:
                        return lista.get(rowIndex).getActivi();
                    case 10:
                        return lista.get(rowIndex).getNivel();
                    case 11:
                        return lista.get(rowIndex).getLugar();
                    case 12:
                        return lista.get(rowIndex).getPresup();
                        
                    case 13:
                        return lista.get(rowIndex).getSalini();
                    case 14:
                        return lista.get(rowIndex).getAntdia();
                    case 15:
                        return lista.get(rowIndex).getAntmes();
                    case 16:
                        return lista.get(rowIndex).getSalact();
                    case 17:
                        return lista.get(rowIndex).getDebano();
                    case 18:
                        return lista.get(rowIndex).getCreano();
                    case 19:
                        return lista.get(rowIndex).getDebmes();
                    case 20:
                        return lista.get(rowIndex).getCremes();
                    case 21:
                        return lista.get(rowIndex).getDebdia();
                    case 22:
                        return lista.get(rowIndex).getCredia();
                    case 23:
                        return lista.get(rowIndex).getIndica();
                        
                    case 24:
                        return lista.get(rowIndex).getSalin2();
                    case 25:
                        return lista.get(rowIndex).getDebme2();
                    case 26:
                        return lista.get(rowIndex).getAntme2();
                    case 27:
                        return lista.get(rowIndex).getCreme2();
                    case 28:
                        return lista.get(rowIndex).getSalac2();
                    case 29:
                        return lista.get(rowIndex).getFecha();
                    case 30:
                        return lista.get(rowIndex).getNompre();
                    case 31:
                        return lista.get(rowIndex).getDeban2();
                    case 32:
                        return lista.get(rowIndex).getCrean2();
                    case 33:
                        return lista.get(rowIndex).getAntdi2();
                    case 34:
                        return lista.get(rowIndex).getDebdi2();
                    case 35:
                        return lista.get(rowIndex).getCredi2();
                    case 36:
                        return lista.get(rowIndex).getFecha2();                        
                    default:
                        return null;
                }
            }
        });
        iuTabla.setPosicionTextoHorizontal(0, SwingConstants.LEFT);
        iuTabla.setPosicionTextoHorizontal(6, SwingConstants.RIGHT);
        iuTabla.setPosicionTextoHorizontal(8, SwingConstants.LEFT);
        iuTabla.setFocusable(true);        
        
        if(!lista.isEmpty()){
            showHideBotones("LISTA_CON_DATOS");
        }else
            showHideBotones("LISTA_VACIA");
    }
    private void showHideBotones(String operacion){
        switch(operacion){
            case "GUARDAR":
                iuBotonGrabar.setEnabled(false);
                iuBotonCargar.setEnabled(false);
                iuBotonEliminar.setEnabled(true);
                
            break;
            case "LISTA_CON_DATOS":
                iuBotonCargar.setEnabled(false);
                iuBotonGrabar.setEnabled(false);
                iuBotonEliminar.setEnabled(true);                
            break;
            case "LISTA_VACIA":
                iuBotonCargar.setEnabled(true);
                iuBotonGrabar.setEnabled(false);
                iuBotonEliminar.setEnabled(false);
            break;
            case "ELIMINAR":
                iuBotonEliminar.setEnabled(false);
                iuBotonGrabar.setEnabled(false);
                iuBotonCargar.setEnabled(true);
                iuTabla.modeloTabla.limpiarTabla();
            break;
            case "CARGAR":
                iuBotonCargar.setEnabled(false);
                iuBotonGrabar.setEnabled(true);
                iuBotonEliminar.setEnabled(false);
            break;
        }
    }
    private void cargarArchivoTxt(){
        ArrayList<Conmae> lista = new ArrayList<>();
        
        String urlArchivo = Ayuda.examinarArchivo(ventanaPrincipal, System.getProperties().getProperty("user.dir"));
        //obtengo el nombre del archivo
        String nombreArchivo = urlArchivo.substring(urlArchivo.lastIndexOf('/')+1, urlArchivo.lastIndexOf('.'));
        
        if(nombreArchivo.equalsIgnoreCase("CONMAE")){
            //Declarar una variable BufferedReader
            BufferedReader br = null;
            try {
               //Crear un objeto BufferedReader al que se le pasa 
               //   un objeto FileReader con el nombre del fichero
               br = new BufferedReader(new FileReader(urlArchivo));
               //Leer la primera línea, guardando en un String
               String texto = br.readLine();
               //Repetir mientras no se llegue al final del fichero
               int id = 1;
               while(texto != null){
                   //Hacer lo que sea con la línea leída
                   //System.out.println(texto);
                   texto = texto.trim();
                   //ArrayList<String> registro = new ArrayList<>(Arrays.asList(texto.split(",")));
                   ArrayList<String> registro = Ayuda.splinter(texto);
                   if(!texto.isEmpty()){
    //cadena = registro.get(2).replaceAll("\"", "");
    //tabla.setDescri(cadena);
                        try {
                           //String cadena = "";
    //"ID", "G", "S", "My", "An", "Sa", 
                            Conmae conmae = new Conmae(id);
                            conmae.setGrup(Integer.parseInt(registro.get(0)));
                            conmae.setSubgru(Integer.parseInt(registro.get(1)));
                            conmae.setMayor(Integer.parseInt(registro.get(2)));                    
                            conmae.setCuenta(Integer.parseInt(registro.get(3)));
                            conmae.setSubcta(Integer.parseInt(registro.get(4)));
        //"CUETOT", "NUMCUE", "DESCRI", "ACTVI", "NIVEL", "LUGAR", "PRESUP", 
                            conmae.setCuetot(Long.parseLong(registro.get(5)));
                            conmae.setNumcue(Integer.parseInt(registro.get(6)));                        
                            //cadena = registro.get(7).replaceAll("\"", "");
                            conmae.setDescri(registro.get(7));
                            conmae.setActivi(Integer.parseInt(registro.get(8)));
                            conmae.setNivel(Integer.parseInt(registro.get(9)));
                            conmae.setLugar(Integer.parseInt(registro.get(10)));
                            conmae.setPresup(Integer.parseInt(registro.get(11)));
        //"SALINI", "ANTDIA", "ANTMES", "SALACT", "DEBANO", "CREANO", "DEBMES", "CREMES", "DEBDIA", "CREDIA", "INDICA",                     
                            conmae.setSalini(Double.parseDouble(registro.get(12)));
                            conmae.setAntdia(Double.parseDouble(registro.get(13)));
                            conmae.setAntmes(Double.parseDouble(registro.get(14)));
                            conmae.setSalact(Double.parseDouble(registro.get(15)));
                            conmae.setDebano(Double.parseDouble(registro.get(16)));
                            conmae.setCreano(Double.parseDouble(registro.get(17)));
                            conmae.setDebmes(Double.parseDouble(registro.get(18)));
                            conmae.setCremes(Double.parseDouble(registro.get(19)));
                            conmae.setDebdia(Double.parseDouble(registro.get(20)));
                            conmae.setCredia(Double.parseDouble(registro.get(21)));
                            conmae.setIndica(Integer.parseInt(registro.get(22)));
        //"SALIN2", "DEBME2", "ANTME2","CREME2", "SALAC2", "FECHA", "NOMPRE", "DEBAN2", "CREAN2", "ANTDI2", "DEBDI2", "CREDI2", "FECHA2"                    
                            conmae.setSalin2(Double.parseDouble(registro.get(23)));
                            conmae.setDebme2(Double.parseDouble(registro.get(24)));
                            conmae.setAntme2(Double.parseDouble(registro.get(25)));
                            conmae.setCreme2(Double.parseDouble(registro.get(26)));
                            conmae.setSalac2(Double.parseDouble(registro.get(27)));
                            //cadena = registro.get(28).replaceAll("\"", "");
                            conmae.setFecha(Ayuda.formatDate(registro.get(28)));
                            conmae.setNompre(Double.parseDouble(registro.get(29)));
                            conmae.setDeban2(Double.parseDouble(registro.get(30)));
                            conmae.setCrean2(Double.parseDouble(registro.get(31)));                        
                            conmae.setAntdi2(Double.parseDouble(registro.get(32)));
                            conmae.setDebdi2(Double.parseDouble(registro.get(33)));
                            conmae.setCredi2(Double.parseDouble(registro.get(34)));
                            //cadena = "";
                            //cadena = registro.get(35).replaceAll("\"", "");
                            //conmae.setFecha2(Ayuda.formatDate(cadena));
                            conmae.setFecha2("");
                            

                            lista.add(conmae);
                            id++;
                       } catch (NumberFormatException e) {System.out.println(e);System.out.println(registro);}
                        
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
            showHideBotones("CARGAR");
        }else{
            JOptionPane.showMessageDialog( ventanaPrincipal, "Error: El Archivo que cargo. no es un archivo con nombre CONMAE que pertenezca a la tabla...! \ningrese otro archivo con el nombre CONMAE", "ERROR DE ARCHIVO", JOptionPane.ERROR_MESSAGE );
        }        
    }
    private void eliminarArchivo(){
        if(Ayuda.mensaje(ventanaPrincipal, "Esta seguro que desea ELIMINAR TODOS LOS REGISTROS DE LA TABLA CONMAE....?", "pregunta")){
            /*ArrayList<Conmae> listaConmae = CConmae.getLista("SELECT * FROM CONMAE");
            listaConmae.forEach((conmae) -> {
                CConmae.eliminarConmae(conmae);
            });*/
            CConmae.eliminarTodoConmae();
            iuTabla.modeloTabla.limpiarTabla();
            JOptionPane.showMessageDialog(ventanaPrincipal, "se ha eliminado TODOS LOS REGISTROS DE LA TABLA CONMAE...!");
            showHideBotones("ELIMINAR");                        
        }
    }
    private void guardarArchivo(){ 
        JProgressBar progresoBar = new JProgressBar();
        progresoBar.setIndeterminate(true);
        progresoBar.setString("guardando datos....");
        progresoBar.setStringPainted(true);
        progresoBar.setBorderPainted(true);        
        progresoBar.setBounds(panel.getWidth()/2 - panel.getWidth()/8, panel.getHeight()/2 - panel.getHeight()/8, panel.getWidth()/8, panel.getHeight()/8);
        progresoBar.setVisible(true);
        panel.add(progresoBar);
        
        final javax.swing.SwingWorker worker = new javax.swing.SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {                
                    for (int i = 0; i < iuTabla.modeloTabla.lista.size(); i++) {                        
                        Conmae conmae = (Conmae)iuTabla.modeloTabla.lista.get(i);
                        try {
                            if(conmae.getFecha().isEmpty())
                                conmae.setFecha(null);
                        } catch (Exception e) {conmae.setFecha(null);}

                        try {
                            if(conmae.getFecha2().isEmpty())
                                conmae.setFecha2(null);
                        } catch (Exception e) {conmae.setFecha2(null);}

                        CConmae.guardarConmae(conmae);
                        //setProgress(i);
                    }                
                return null;
            }
            @Override
            protected void done() {
                //setProgress(100);
                progresoBar.setVisible(false);
                showHideBotones("GUARDAR");
                JOptionPane.showMessageDialog(ventanaPrincipal, "se ha guardado todos los datos de la tabla CONMAE correctamente...!");
            }
             //agregamos un escuchador de cambio de propiedad           
        };
        worker.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                progresoBar.setValue(worker.getProgress());//actualizamos el valor del progressBar
            }
        });

        worker.execute();
        
    }
    private void setEventos(){
        iuBotonSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dispose();
            }
        });
        iuBotonCargar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                cargarArchivoTxt();
            }
        });
        iuBotonGrabar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                guardarArchivo();
            }
        });
        iuBotonEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                eliminarArchivo();
            }
        });
    }
    
}

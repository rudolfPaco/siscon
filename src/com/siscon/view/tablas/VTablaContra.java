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
import com.siscon.controller.CContra;
import com.siscon.model.Conmae;
import com.siscon.model.Contra;
import com.siscon.recursos.Ayuda;
import com.siscon.view.VPrincipal;
import java.awt.Color;
import java.awt.event.ActionEvent;
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
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class VTablaContra extends IUSecundario{
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
    
    public VTablaContra(VPrincipal ventanaPrincipal, String titulo, String tipoSize) {
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
        iuTitulo = new IUEtiqueta(panelTitulo, "Tabla CONTRA (ASIENTOS CONTABLES)", new Area(a.X(), a.Y(), a.AnP(50), a.Al()), 24, "CENTER", new Color(120, 0, 0));
        
        panelBotones = new IUPanel(panelTitulo, new Area(a.X(2) + a.AnP(50), a.Y(), a.AnP(50), a.Al()), true);
        construirPanelBotones(new Area(2, 2, panelBotones.area.An() - 10, panelBotones.area.Al() - 4));
    }
    private void construirPanelBotones(Area a){
        iuBotonEliminar = new IUBoton(panelBotones, new Area(a.X() + a.AnP(20), a.Y(), a.AnP(20), a.Al()), "F3 ELIMINAR", "/imagenes/delete.png", 16, 25, 10, SwingConstants.RIGHT, SwingConstants.CENTER, 'E', "boton que elimina todos los registros de la tabla");
        iuBotonEliminar.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_F3, 0 ), "F3" );
        iuBotonEliminar.getActionMap().put( "F3", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                iuBotonEliminar.doClick();
                eliminarArchivo();
            }
        });
        
        iuBotonGrabar = new IUBoton(panelBotones, new Area(a.X(2) + a.AnP(40), a.Y(), a.AnP(20), a.Al()), "GRABAR", "/imagenes/save.png", 16, 25, 10, SwingConstants.RIGHT, SwingConstants.CENTER, 'G', "boton que guarda todos los registros que estan en la tabla");
        iuBotonGrabar.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_G, 0 ), "G" );
        iuBotonGrabar.getActionMap().put( "G", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                iuBotonGrabar.doClick();
                if(Ayuda.mostrarMensajeConfirmacion(ventanaPrincipal, "Esta seguro que desea GUARDAR los REGISTROS DE LA TABLA...?", "CONFIRMACION")){
                    guardarArchivo();
                }                
            }
        });
        
        iuBotonCargar = new IUBoton(panelBotones, new Area(a.X(3) + a.AnP(60), a.Y(), a.AnP(20), a.Al()), "CARGAR .TXT", "/imagenes/bajar.png", 16, 25, 10, SwingConstants.RIGHT, SwingConstants.CENTER, 'C', "boton que carga el archivo principal .txt");
        iuBotonCargar.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_C, 0 ), "C" );
        iuBotonCargar.getActionMap().put( "C", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                iuBotonCargar.doClick();
                cargarArchivoTxt();
            }
        });
        
        iuBotonSalir = new IUBoton(panelBotones, new Area(a.X(4) + a.AnP(80), a.Y(), a.AnP(20), a.Al()), "ESC", "/imagenes/cerrar.png", 16, 25, 10, SwingConstants.RIGHT, SwingConstants.CENTER, 'S', "boton para salir de la ventana");        
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
        ArrayList<Contra> lista = CContra.getListaContra("SELECT * FROM CONTRA");
        
        iuTabla = new IUTabla(panelTabla,
                new Area(a.X(), a.Y(), a.An(), a.Al()), 
                new String[]{"ID", "TIPCON", "NUMCOM", "CORREL", "FECHA", "GRUPO", "SUBGRU", "MAYOR", "CUENTA", "SUBCTA", "APROPI", "MONTO1", "MONTO2", "TIPCAM", "INDICA", "NOMBRE", "GLOSA", "CHEQUE", "NUMCUE", "CUETOT", "REDUCE", "TIPCOM", "INTERN", "NUMINT", "EMPRES"}, 
                new Class[]{Integer.class, Integer.class, Integer.class, Integer.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Double.class, Double.class, Double.class, Integer.class, String.class, String.class, Integer.class, Integer.class, Double.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class}, 
                new int[]{2,3,5,3,6,3,3,3,3,3,3,5,5,3 ,3,10,17,3,3,4,2,2,2,2,2}, 
                lista, new ModeloTabla<Contra>(){
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return lista.get(rowIndex).getId();
                    case 1:                
                        return lista.get(rowIndex).getTipcon();
                    case 2:                
                        return lista.get(rowIndex).getNumcom();
                    case 3:
                        return lista.get(rowIndex).getCorrel();
                    case 4:
                        return lista.get(rowIndex).getFecha();
                    case 5:
                        return lista.get(rowIndex).getGrupo();
                    case 6:
                        return lista.get(rowIndex).getSubgru();
                    case 7:
                        return lista.get(rowIndex).getMayor();
                    case 8:
                        return lista.get(rowIndex).getCuenta();
                    case 9:
                        return lista.get(rowIndex).getSubcta();
                    case 10:
                        return lista.get(rowIndex).getApropi();
                    case 11:
                        return lista.get(rowIndex).getMonto1();
                    case 12:
                        return lista.get(rowIndex).getMonto2();
                    case 13:
                        return lista.get(rowIndex).getTipcam();
                    case 14:
                        return lista.get(rowIndex).getIndica();
                    case 15:
                        return lista.get(rowIndex).getNombre();
                    case 16:
                        return lista.get(rowIndex).getGlosa();
                    case 17:
                        return lista.get(rowIndex).getCheque();
                    case 18:
                        return lista.get(rowIndex).getNumcue();
                    case 19:
                        return lista.get(rowIndex).getCuetot();
                    case 20:
                        return lista.get(rowIndex).getReduce();
                    case 21:
                        return lista.get(rowIndex).getTipcom();
                    case 22:
                        return lista.get(rowIndex).getIntern();
                    case 23:
                        return lista.get(rowIndex).getNumint();
                    case 24:
                        return lista.get(rowIndex).getEmpres();
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
        ArrayList<Contra> lista = new ArrayList<>();
        
        String urlArchivo = Ayuda.examinarArchivo(ventanaPrincipal, System.getProperties().getProperty("user.dir"));
        //obtengo el nombre del archivo
        String nombreArchivo = urlArchivo.substring(urlArchivo.lastIndexOf('/')+1, urlArchivo.lastIndexOf('.'));
        
        if(nombreArchivo.equalsIgnoreCase("CONTRA")){
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
                   ArrayList<String> registro = Ayuda.splinter(texto);
                   //System.out.println(registro);
                   if(!texto.isEmpty()){
                        try {
                           //String cadena = "";
                        Contra contra = new Contra(id);
                        contra.setTipcon(Integer.parseInt(registro.get(0)));
                        contra.setNumcom(Integer.parseInt(registro.get(1)));
                        contra.setCorrel(Integer.parseInt(registro.get(2)));
                        //cadena = registro.get(3).replaceAll("\"", "");
                        contra.setFecha(Ayuda.formatDate(registro.get(3)));
                        contra.setGrupo(Integer.parseInt(registro.get(4)));
                        contra.setSubgru(Integer.parseInt(registro.get(5)));
                        contra.setMayor(Integer.parseInt(registro.get(6)));                        
                        
                        contra.setCuenta(Integer.parseInt(registro.get(7)));
                        contra.setSubcta(Integer.parseInt(registro.get(8)));
                        contra.setApropi(Integer.parseInt(registro.get(9)));
                        contra.setMonto1(Double.parseDouble(registro.get(10)));
                        contra.setMonto2(Double.parseDouble(registro.get(11)));
                        contra.setTipcam(Double.parseDouble(registro.get(12)));
                        contra.setIndica(Integer.parseInt(registro.get(13)));
                        
                        //cadena = registro.get(14).replaceAll("\"", "");
                        contra.setNombre(registro.get(14));
                        
                        //cadena = registro.get(15).replaceAll("\"", "");                            
                        contra.setGlosa(registro.get(15));
                        
                        contra.setCheque(Integer.parseInt(registro.get(16)));
                        contra.setNumcue(Integer.parseInt(registro.get(17)));
                        contra.setCuetot(Long.parseLong(registro.get(18)));
                        contra.setReduce(Integer.parseInt(registro.get(19)));
                        contra.setTipcom(Integer.parseInt(registro.get(20)));
                        contra.setIntern(Integer.parseInt(registro.get(21)));
                        contra.setNumint(Integer.parseInt(registro.get(22)));
                        contra.setEmpres(Integer.parseInt(registro.get(23)));                        
                        lista.add(contra);
                        id++;
                       } catch (Exception e) {System.out.println(e);System.out.println(registro);}
                        
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
            JOptionPane.showMessageDialog( ventanaPrincipal, "Error: El Archivo que cargo. no es un archivo con nombre CONTRA que pertenezca a la tabla...! \ningrese otro archivo con el nombre CONMAE", "ERROR DE ARCHIVO", JOptionPane.ERROR_MESSAGE );
        }        
    }
    private void eliminarArchivo(){
        if(Ayuda.mostrarMensajeConfirmacion(ventanaPrincipal, "Esta seguro que desea ELIMINAR TODOS LOS REGISTROS DE LA TABLA CONTRA....?", "CONFIRMAR")){
            /*ArrayList<Conmae> listaConmae = CConmae.getLista("SELECT * FROM CONMAE");
            listaConmae.forEach((conmae) -> {
                CConmae.eliminarConmae(conmae);
            });*/
            CContra.eliminarTodoContra();
            iuTabla.modeloTabla.limpiarTabla();
            JOptionPane.showMessageDialog(ventanaPrincipal, "se ha eliminado TODOS LOS REGISTROS DE LA TABLA CONTRA...!");
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
                    Contra contra = (Contra)iuTabla.modeloTabla.lista.get(i);
                    try {
                        if(contra.getFecha().isEmpty())
                            contra.setFecha(null);
                    } catch (Exception e) {contra.setFecha(null);}

                    CContra.guardarContra(contra);                        
                }
                
                return null;
            }
            @Override
            protected void done() {
                progresoBar.setVisible(false);
                showHideBotones("GUARDAR");
                JOptionPane.showMessageDialog(ventanaPrincipal, "se ha guardado todos los datos de la tabla CONTRA correctamente...!");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.reportes;

import SIGU.campoTexto.IUCampoTexto;
import SIGU.comboBox.IUComboBox;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.paneles.IUPanel;
import SIGU.paneles.IUPanelEtiqueta;
import SIGU.recursos.Area;
import SIGU.recursos.Fecha;
import SIGU.ventanas.IUSecundario;
import com.siscon.bd.Conexion;
import com.siscon.controller.CConmae;
import com.siscon.model.Conmae;
import com.siscon.model.Tabvar;
import com.siscon.model.Usuario;
import com.siscon.recursos.Ayuda;
import com.siscon.view.VPrincipal;
import com.siscon.view.contra.VAyudaContra;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author neo
 */
public class REstadoCuenta extends IUSecundario{
    
    private VPrincipal ventanaPrincipal;
    private String titulo;
    
    private IUPanel panel;
        private IUPanel panelTitulo;
        private IUEtiqueta iuTitulo;
    
    private IUPanel panelDatos;
        private IUPanel primerPanel;
            private IUPanel panelContenedor;
                private IUPanel panelUno;
                    private IUEtiqueta iuEtiquetaTipo;
                    private IUComboBox iuTipo;
                    private IUEtiqueta iuEtiquetaGrupos;
                    private IUComboBox iuMoneda;
                    private IUEtiqueta iuEtiquetaNivel;
                    private IUCampoTexto iuCodigo;
                private IUPanel panelDos;
        
        private IUPanel segundoPanel;
            private IUEtiqueta iuTituloMensaje;
            private IUPanelEtiqueta iuMensaje;
            private IUPanelEtiqueta iuInformacion;
            private IUCampoTexto campoS_N1;
            private IUCampoTexto campoS_N2;
            private IUCampoTexto campoS_N3;
    
    private Usuario usuario;
    private Tabvar tabvar;
    private Conmae conmae;
    
    private String tipo;
    private String moneda;
    private String codigo;
    private String visualizar;
    
    public REstadoCuenta(VPrincipal ventanaPrincipal, String titulo, String tipoSize, Usuario usuario, Tabvar tabvar) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        this.usuario = usuario;
        this.tabvar = tabvar;
        this.conmae = null;
        
        this.tipo = "";
        this.moneda = "";
        this.codigo = "";
        this.visualizar = "";
        
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
        construirPanelDatos(new Area(2, 2, panelDatos.area.An() - 4, panelDatos.area.Al() - 6));
    }
    
    private void construirPanelTitulo(Area a){
        iuTitulo = new IUEtiqueta(panelTitulo, usuario.getRazsoc(), new Area(a.X(), a.Y(), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "ESTADO DE CUENTAS SUPERIORES", new Area(a.X(2) + a.AnP(25), a.Y(), a.AnP(35), a.AlP(50)), 16, "CENTER", false);        
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "Por: GRUPO - NIVEL 3", new Area(a.X(2) + a.AnP(25), a.Y(2) + a.AlP(45), a.AnP(35), a.AlP(50)), 16, "CENTER", false);                
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "SISTEMA CONTABLE SISCON @v7.2. 2020", new Area(a.X(3) + a.AnP(60), a.Y(), a.AnP(40), a.AlP(50)), 16, "RIGHT", false); 
        iuTitulo = new IUEtiqueta(panelTitulo, new Fecha().getFecha1(), new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(45), a.AnP(40), a.AlP(50)), 16, "RIGHT", false); 
        
        iuTitulo = new IUEtiqueta(panelTitulo, "REPORTE: ECS ", new Area(a.X(), a.Y(2) + a.AlP(45), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
    }
    private void construirPanelDatos(Area a){
        primerPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(), a.An(), a.AlP(85)), false);
        construirPrimerPanel(new Area(a.AnP(25), a.AlP(30), primerPanel.area.An() - a.AnP(25)*2, primerPanel.area.Al() - a.AlP(30)*2));
        
        segundoPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(2) + a.AlP(85), a.An(), a.AlP(15)), false);
        construirSegundoPanel(new Area(8, 2, segundoPanel.area.An() - 24, segundoPanel.area.Al() - 8));
    }
    private void construirPrimerPanel(Area a){
        panelContenedor = new IUPanel(primerPanel, new Area(a.X(), a.Y(), a.An(), a.Al()), true);
        construirPanelContenedor(new Area(2, 2, a.An() - 4, a.Al() - 6));
    }
    private void construirPanelContenedor(Area a){
        iuEtiquetaTipo = new IUEtiqueta(panelContenedor, "Tipo de Reporte que se Visualizara:", new Area(a.X(), a.Y(), a.AnP(60), a.AlP(33)), 18, "LEFT", false);
        iuEtiquetaTipo.setSubrayarTexto(true);
        ArrayList<String> tipos = new ArrayList<>();
        tipos.add("PANTALLA");
        tipos.add("EXPORTABLE");
        tipos.add("IMPRESORA");
        iuTipo = new IUComboBox(panelContenedor, tipos, new Area(a.X(2) + a.AnP(60), a.Y(), a.AnP(40), a.AlP(33)), 18, 50);
        iuTipo.setPosicionHorizontal(SwingConstants.CENTER);
        
        iuEtiquetaGrupos = new IUEtiqueta(panelContenedor, "Emision de Moneda Bolivianos/Dolares:", new Area(a.X(), a.Y(2) + a.AlP(33), a.AnP(60), a.AlP(33)), 18, "LEFT", false);
        iuEtiquetaGrupos.setSubrayarTexto(true);
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("(B)olivianos");
        opciones.add("(D)olares");        
        iuMoneda = new IUComboBox(panelContenedor, opciones, new Area(a.X(2) + a.AnP(60), a.Y(2) + a.AlP(33), a.AnP(40), a.AlP(33)), 18, 50);
        iuMoneda.setPosicionHorizontal(SwingConstants.CENTER);
        
        
        iuEtiquetaNivel = new IUEtiqueta(panelContenedor, "Ingrese el CODIGO de CUENTA: ", new Area(a.X(), a.Y(3) + a.AlP(66), a.AnP(60), a.AlP(33)), 18, "LEFT", false);
        iuEtiquetaNivel.setSubrayarTexto(true);        
        iuCodigo = new IUCampoTexto(panelContenedor, 8, 18, new Area(a.X(2) + a.AnP(60), a.Y(3) + a.AlP(66), a.AnP(40), a.AlP(33)), SwingConstants.CENTER);        
        iuCodigo.setRestriccion("^([0-9]|[1-9][0-9])$");
    }
    
    
    private void construirSegundoPanel(Area a){
        iuTituloMensaje = new IUEtiqueta(segundoPanel, "Mensajes - Instrucciones", new Area(a.X(), a.Y(), a.AnP(97), a.AlP(20)), 16, "CENTER", false);
        iuTituloMensaje.setSubrayarTexto(true);
        iuMensaje = new IUPanelEtiqueta(segundoPanel, new Area(a.X(), a.Y(2) + a.AlP(20), a.AnP(97), a.AlP(40)), "", 20, SwingConstants.LEFT, Color.BLACK, true);
        iuMensaje.setColores(Color.WHITE, new Color(41, 66, 99));
        iuInformacion = new IUPanelEtiqueta(segundoPanel, new Area(a.X(), a.Y(3) + a.AlP(60), a.AnP(97), a.AlP(40)), "", 20, SwingConstants.LEFT, Ayuda.COLOR_FONDO, true);       
        iuInformacion.setColores(Color.BLACK, new Color(255, 210, 0));        
        //iuInformacion.setFuente(new Font("LMicrosoft Sans Serif", Font.PLAIN, 16));
        
        campoS_N1 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N1.setVisible(false);
        campoS_N1.setBorder(new LineBorder(Color.BLACK, 3));
        campoS_N1.setBackground(new Color(255, 210, 0));        
        campoS_N1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoS_N1.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoS_N1.setText("N");
                }
            }
        });
        campoS_N1.setForeground(Color.BLACK);
        
        campoS_N2 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N2.setVisible(false);
        campoS_N2.setBorder(new LineBorder(Color.BLACK, 3));
        campoS_N2.setBackground(new Color(255, 210, 0));
        campoS_N2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoS_N2.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoS_N2.setText("N");
                }
            }
        });
        campoS_N2.setForeground(Color.BLACK);
        
        campoS_N3 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N3.setVisible(false);
        campoS_N3.setBorder(new LineBorder(Color.BLACK, 3));
        campoS_N3.setBackground(new Color(255, 210, 0));
        campoS_N3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoS_N3.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoS_N3.setText("N");
                }
            }
        });
        campoS_N3.setForeground(Color.BLACK);
    }    
    
    private void algoritmosInicial(){
        panel.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "ESC" );
        panel.getActionMap().put( "ESC", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){
                dispose();
            }
        });
        focoCampoTipo();
    }
    private void focoCampoTipo(){
        restringirCampos("TIPO", true);
        pintarBordeCampo("TIPO");
        deshabilitarCampoS_N();
        iuTipo.setEditar(true);
        iuTipo.requestFocus();
        iuMensaje.setTexto("ELIJA una de las OPCIONES. ENTER=Avanzar, ESC=Suspende");
        iuInformacion.setTexto(" ATENCION: los siguientes REPORTES SON: ARCHIVO o PANTALLA, EXPORTABLE, IMPRESORA");
        iuTipo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    tipo = iuTipo.getSelectedItem().toString();
                    focoCampoGrupos();
                }
            }
        });
    }
    private void focoCampoGrupos(){
        pintarBordeCampo("GRUPOS");
        deshabilitarCampoS_N();
        iuMoneda.setEditar(true);
        iuMoneda.requestFocus();
        iuMensaje.setTexto("ELIJA una de las OPCIONES. ENTER=Avanzar, F2=Retrocede, ESC=Suspende");
        iuInformacion.setTexto(" ATENCION: BOLIVIANOS (BOB)  o  DOLARES ($us).");
        iuMoneda.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    moneda = iuMoneda.getSelectedItem().toString();
                    focoCampoCodigo();
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoTipo();
                }
            }
        });
    }
    private void focoCampoCodigo(){
        pintarBordeCampo("NIVEL");
        deshabilitarCampoS_N();
        iuCodigo.setEditar(true);
        iuCodigo.requestFocus();
        iuMensaje.setTexto("Ingres el CODIOG de CUENTA. ");
        iuInformacion.setTexto(" ENTER=Avanzar, F1=Ayuda, F2=Retrocede, ESC=Suspende");
        iuCodigo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!iuCodigo.getText().isEmpty()){
                        codigo = iuCodigo.getText();
                        conmae = CConmae.getConmae("SELECT * FROM CONMAE WHERE CUETOT = "+codigo);
                        if(conmae != null){
                            if(conmae.getNivel() == 3)
                                focoCampoS_N2();
                            else
                                focoCampoS_N1();
                        }
                    }                    
                }
                if(KeyEvent.VK_F1 == e.getKeyCode()){
                    VAyudaContra iuAyuda = new VAyudaContra(ventanaPrincipal, titulo, "medio-grande", "SELECT * FROM CONMAE WHERE NIVEL <= 3 GROUP BY CUETOT");
                    iuAyuda.mostrarVentana();
                    if(iuAyuda.getEstado()){
                        codigo = String.valueOf(iuAyuda.getConmae().getCuetot());
                        iuCodigo.setText(codigo);
                    }
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoGrupos();
                }
            }
        });
    }
    private void focoCampoS_N2(){
        restringirCampos("", false);
        pintarBordeCampo("");
        campoS_N2.setVisible(true);
        campoS_N2.setEditar(true);
        campoS_N2.requestFocus();
        campoS_N2.setText("S");
        iuMensaje.setColores(Color.BLACK, new Color(255, 210, 0));
        iuMensaje.setTexto("Desea Visualizar las CUENTAS de NIVEL INFERIOR. ?    S/N");
        iuInformacion.setVisible(false);
        campoS_N2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    iuMensaje.setColores(Color.WHITE, new Color(41, 66, 99));
                    iuInformacion.setVisible(true);
                    switch(campoS_N2.getText()){
                        case "S":
                            visualizar = "SI";
                        break;
                        case "N":
                            visualizar = "NO";
                        break;
                        default:
                        break;
                    }
                    focoCampoS_N1();
                }
            }
        });
    }
    
    private void focoCampoS_N1(){
        restringirCampos("", false);
        pintarBordeCampo("");
        campoS_N1.setVisible(true);
        campoS_N1.setEditar(true);
        campoS_N1.requestFocus();
        campoS_N1.setText("S");
        iuMensaje.setColores(Color.BLACK, new Color(255, 210, 0));
        iuMensaje.setTexto("Esta CONFORME con los Datos Seleccionados. ?    S/N");
        iuInformacion.setVisible(false);
        campoS_N1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    iuMensaje.setColores(Color.WHITE, new Color(41, 66, 99));
                    iuInformacion.setVisible(true);
                    switch(campoS_N1.getText()){
                        case "S":           
                            actualizarPaneles();
                            emitirReporte();
                            actualizarPaneles();
                            focoCampoTipo();
                        break;
                        case "N":
                            actualizarPaneles();
                            focoCampoTipo();
                        break;                            
                        default:
                        break;
                    }
                }
            }
        });
    }
    private void emitirReporte(){        
        switch(tipo){
            case "PANTALLA":                
                actualizarPaneles();
                System.out.println(visualizar);
                IUReporteECS iuECS = new IUReporteECS(this, titulo, "grande", usuario, tabvar, visualizar, moneda, conmae);
                iuECS.mostrarVentana();
                actualizarPaneles();
            break;
            case "EXPORTABLE":
                dispose();
                //exportarArchivoTXT(Integer.parseInt(grupo), Integer.parseInt(nivel));
            break;
            case "IMPRESORA":                
                dispose();
                //reporte(Integer.parseInt(grupo), Integer.parseInt(nivel), nombreNivel);
            break;
            default:
            break;
        }
    }
    private void reporte(int grup, int niv, String nombreNivel){
        try {
            Conexion conexion = new Conexion();            
            String ruta = "/reportes/report1.jasper";            
            Map parametros = new HashMap();
            parametros.put("grup", grup);
            parametros.put("nivel", niv);
            parametros.put("plan", moneda);
            parametros.put("grupos", nombreNivel);
            JasperReport jasper = (JasperReport) JRLoader.loadObjectFromFile(getClass().getResource(ruta).getPath());
            JasperPrint informe = JasperFillManager.fillReport(jasper, parametros, conexion.getConexion());
            JasperViewer visor = new JasperViewer(informe, false);
            visor.setTitle("REPORTE: EMISION PLAN DE CUENTAS");
            visor.setAlwaysOnTop(true);
            visor.setVisible(true);
        } catch (JRException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
    }
    private void exportarArchivoTXT(int grup, int niv){
        ArrayList<Conmae> lista = CConmae.getLista("SELECT * FROM CONMAE WHERE GRUP = "+grup+" AND NIVEL <= "+niv+" GROUP BY CUETOT");
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos .TXT", "txt");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");        
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(ventanaPrincipal) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().getAbsolutePath();//toString().concat(".txt");
            try {
                File archivoTXT = new File(ruta);
                if (archivoTXT.exists()) {
                    archivoTXT.delete();
                }
                archivoTXT.createNewFile();
                BufferedWriter bfw = new BufferedWriter(new FileWriter(archivoTXT.getAbsolutePath()));

                for (int i = 0 ; i < lista.size(); i++) //realiza un barrido por filas.
                {
                    bfw.write(lista.get(i).getGrup()+"-"+lista.get(i).getSubgru()+"-"+String.format("%02d",lista.get(i).getMayor())+"-"+String.format("%02d",lista.get(i).getCuenta())+"-"+String.format("%02d",lista.get(i).getSubcta())+","+lista.get(i).getDescri()+","+lista.get(i).getNivel() + ","+lista.get(i).getActivi() + ","+lista.get(i).getSalact() + ",");
                    bfw.newLine(); //inserta nueva linea.
                }

                bfw.close(); //cierra archivo!            
                Desktop.getDesktop().open(archivoTXT);
            }catch (IOException | NumberFormatException e) {
                System.out.println("ERROR: Ocurrio un problema al GUARDAR el archivo!" + e.getMessage());
            }
        }
    }
    /*
    private void guardaTabla(){
        try {

            String sucursalesCSVFile = "src/archivos/DatosTabla.txt";
            BufferedWriter bfw = new BufferedWriter(new FileWriter(sucursalesCSVFile ));

            for (int i = 0 ; i < table.getRowCount(); i++) //realiza un barrido por filas.
            {
                for(int j = 0 ; j < table.getColumnCount();j++) //realiza un barrido por columnas.
                {
                    bfw.write((String)(table.getValueAt(i,j)));
                    if (j < table.getColumnCount() -1) { //agrega separador "," si no es el ultimo elemento de la fila.
                        bfw.write(",");
                    }
                }
                bfw.newLine(); //inserta nueva linea.
            }

            bfw.close(); //cierra archivo!
            System.out.println("El archivo fue salvado correctamente!");
        } catch (IOException e) {
            System.out.println("ERROR: Ocurrio un problema al salvar el archivo!" + e.getMessage());
        }
    }
    */
    private void restringirCampos(String campo, boolean state){
        iuTipo.setEditar(false);
        iuMoneda.setEditar(false);
        iuCodigo.setEditar(false);
        switch(campo){
            case "TIPO":
                iuTipo.setEditar(state);
            break;
            case "GRUPOS":
                iuMoneda.setEditar(state);
            break;
            case "NIVEL":
                iuCodigo.setEditar(state);
            break;
            default:
            break;
        }
    }
    private void pintarBordeCampo(String campo){
        Border borde = new LineBorder(Color.blue, 2); 
        
        iuTipo.setBorder(iuTipo.getBordeComponente());
        iuMoneda.setBorder(iuMoneda.getBordeComponente());
        iuCodigo.setBorder(iuCodigo.getBordeComponente());
        
        switch(campo){
            case "TIPO":
                iuTipo.setBorder(borde);
            break;
            case "GRUPOS":
                iuMoneda.setBorder(borde);
            break;
            case "NIVEL":
                iuCodigo.setBorder(borde);
            break;
            default:
            break;
        }
    }
    private void deshabilitarCampoS_N(){
        campoS_N1.setEditar(false);
        campoS_N1.setVisible(false);
        campoS_N2.setEditar(false);
        campoS_N2.setVisible(false);
        campoS_N3.setEditar(false);
        campoS_N3.setVisible(false);
        iuInformacion.setVisible(true);
        iuInformacion.setColores(Color.BLACK, new Color(255, 210, 0));
        iuMensaje.setColores(Color.WHITE, new Color(41, 66, 99));
    }    
    private void actualizarPaneles(){
        panel.removeAll();
        construirPaneles(new Area(2, 2, panel.area.An() - 4, panel.area.Al() - 4));
        panel.updateUI();
        algoritmosInicial();        
    }
}

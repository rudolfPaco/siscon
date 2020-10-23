/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view;

import SIGU.botones.IUBoton;
import SIGU.comboBox.IUComboBox;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.paneles.IUPanel;
import SIGU.paneles.IUPanelEtiqueta;
import SIGU.recursos.Area;
import SIGU.recursos.Fecha;
import SIGU.ventanas.IUPrincipal;
import com.siscon.view.tabvar.VTabvar;
import com.siscon.model.Tabvar;
import com.siscon.model.Usuario;
import com.siscon.recursos.Ayuda;
import com.siscon.view.conmae.VConmae;
import com.siscon.view.tablas.VOpciones;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class VPrincipal extends IUPrincipal{
    
    private VPrincipal ventanaPrincipal;
    private final String titulo;
    
    private IUPanel panel;
        private IUPanel panelTitulo;
        private IUEtiqueta iuTitulo;
    
    private IUPanel panelDatos;
        private IUPanel panelContenedor;
            private IUPanelEtiqueta panelAP;
            private IUEtiqueta tituloA;
            private IUPanel panelA;
            
            private IUPanelEtiqueta panelBA;
            private IUEtiqueta tituloB;
            private IUPanel panelB;
            
            private IUPanelEtiqueta panelCO;
            private IUEtiqueta tituloC;
            private IUPanel panelC;
            
        private IUPanel panelAbajo;
            private IUPanel panelMensajes;
                private IUEtiqueta iuMensajes;
            private IUPanel panelInformacion;
                private IUPanelEtiqueta iuFechaVigente;
                private IUEtiqueta iuFecha;
                private IUPanelEtiqueta iuEtiquetaTipoCambio;
                private IUEtiqueta iuTipoCambio;
            private IUPanel panelEntrada;
            private IUComboBox iuEntrada;
            //private IUBoton botonEsc;
                
            
    private ArrayList<IUPanelEtiqueta> iuLista;
    
    private final Tabvar tabvar;
    private final Usuario usuario;
    
    /**
     *
     * @param tabvar
     * @param usuario
     * @param titulo
     * @param urlIcono
     */
    public VPrincipal(Tabvar tabvar, Usuario usuario, String titulo, String urlIcono) {
        super(titulo, urlIcono);        
        this.tabvar = tabvar;
        this.usuario = usuario;
        this.titulo = titulo;
        this.iuLista = new ArrayList<>();
        construirPaneles(new Area(An()-6, Al()-29));        
        setEventos();
    }
    private void construirPaneles(Area a){
        panel = new IUPanel(this, new Area(a.X(), a.Y(), a.An(), a.Al()), true);
        construirPanel(new Area(2, 2, panel.area.An() - 4, panel.area.Al() - 6));
        panel.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "ESC" );
        panel.getActionMap().put( "ESC", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                salirSistema();
            }
        });
    }
    private void construirPanel(Area a){
        panelTitulo = new IUPanel(panel, new Area(a.X(), a.Y(), a.An(), a.AlP(8)), true, Ayuda.COLOR_FONDO);
        construirPanelTitulo(new Area(10, 3, panelTitulo.area.An() - 40, panelTitulo.area.Al() - 9));
        
        panelDatos = new IUPanel(panel, new Area(a.X(), a.Y(2) + a.AlP(8), a.An(), a.AlP(92)), true);
        construirPanelDatos(new Area(panelDatos.area.AnP(10), panelDatos.area.AlP(20), panelDatos.area.An() - panelDatos.area.AnP(10)*2, panelDatos.area.Al() - panelDatos.area.AlP(20)*2));
                
        //construirPanelMensajes(new Area(panelMensajes.area.AnP(10), panelMensajes.area.AlP(5), panelMensajes.area.An() - panelMensajes.area.AnP(10)*2, panelMensajes.area.Al() - panelMensajes.area.AlP(5)*2));
    }    
    private void construirPanelTitulo(Area a){
        iuTitulo = new IUEtiqueta(panelTitulo, usuario.getRazsoc(), new Area(a.X(), a.Y(), a.AnP(25), a.AlP(50)), 18, "LEFT", false);
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "SISTEMA DE CONTABILIDAD (SISCON @v7.1. 2020)", new Area(a.X(2) + a.AnP(30), a.Y(2) + a.AlP(40), a.AnP(40), a.AlP(50)), 18, "CENTER", false);        
        iuTitulo = new IUEtiqueta(panelTitulo, "Cochabamba, "+new Fecha().getFecha1(), new Area(a.X(3) + a.AnP(65), a.Y(), a.AnP(35), a.AlP(50)), 18, "RIGHT", false); 
        
        iuTitulo = new IUEtiqueta(panelTitulo, "Usuario: "+tabvar.getDescri(), new Area(a.X(), a.Y(2) + a.AlP(50), a.AnP(40), a.AlP(50)), 18, "LEFT", false);
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "Serie No. 07/a", new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(50), a.AnP(40), a.AlP(50)), 18, "RIGHT", false);
        iuTitulo.setSubrayarTexto(true);
    }
    private void construirPanelDatos(Area a){
        panelContenedor = new IUPanel(panelDatos, new Area(a.X(), a.Y(), a.An(), a.Al()), true);
        construirPanelContenedor(new Area(2, 2, panelContenedor.area.An() - 8, panelContenedor.area.Al() - 8));
    }
    private void construirPanelContenedor(Area a){
        panelAP = new IUPanelEtiqueta(panelContenedor, new Area(a.X(), a.Y(), a.AnP(33), a.AlP(5)), "A.  ARCHIVOS PRINCIPALES", 20, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        panelA = new IUPanel(panelContenedor, new Area(a.X(), a.Y(2) + a.AlP(5), a.AnP(33), a.AlP(80)), true, Ayuda.COLOR_FONDO);
        construirPanelA(new Area(4, 4, panelA.area.An() - 8, panelA.area.Al() - 40));
        
        panelBA = new IUPanelEtiqueta(panelContenedor, new Area(a.X(2) + a.AnP(33), a.Y(), a.AnP(33), a.AlP(5)), "B.  ARCHIVOS DE ASIENTOS", 20, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        panelB = new IUPanel(panelContenedor, new Area(a.X(2) + a.AnP(33), a.Y(2) + a.AlP(5), a.AnP(33), a.AlP(80)), true, Ayuda.COLOR_FONDO);
        construirPanelB(new Area(4, 4, panelB.area.An() - 8, panelB.area.Al() - 40));
        
        panelCO = new IUPanelEtiqueta(panelContenedor, new Area(a.X(3) + a.AnP(66), a.Y(), a.AnP(34), a.AlP(5)), "C.  OPCIONALES", 20, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        panelC = new IUPanel(panelContenedor, new Area(a.X(3) + a.AnP(66), a.Y(2) + a.AlP(5), a.AnP(34), a.AlP(80)), true, Ayuda.COLOR_FONDO);
        construirPanelC(new Area(4, 4, panelC.area.An() - 8, panelC.area.Al() - 40));
        
        panelAbajo = new IUPanel(panelContenedor, new Area(a.X(), a.Y(3) + a.AlP(85), a.An() + a.X(2), a.AlP(15)), true, Ayuda.COLOR_FONDO);
        construirPanelAbajo(new Area(2, 2, panelAbajo.area.An() - 6, panelAbajo.area.Al() - 6));
    }
    private void construirPanelA(Area a){
        tituloA = new IUEtiqueta(panelA, "PROCESOS", new Area(a.X() + a.AnP(30), a.Y(4), a.AnP(40), a.AlP(7)), 20, "CENTER", new Color(120, 0, 0));
        tituloA.setSubrayarTexto(true);
        iuLista.add(new IUPanelEtiqueta(panelA, new Area(a.X(), a.Y() + a.AlP(21), a.An(), a.AlP(7)), "01. Plan Cuentas", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelA, new Area(a.X(), a.Y(2) + a.AlP(28), a.An(), a.AlP(7)), "02. Presupuestos", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelA, new Area(a.X(), a.Y(3) + a.AlP(35), a.An(), a.AlP(7)), "03. Parametros - Tablas", 16, SwingConstants.LEFT, Color.WHITE, true));
        
        tituloA = new IUEtiqueta(panelA, "REPORTES", new Area(a.X() + a.AnP(30), a.Y(7) + a.AlP(42), a.AnP(40), a.AlP(7)), 20, "CENTER", new Color(120, 0, 0));
        tituloA.setSubrayarTexto(true);
        iuLista.add(new IUPanelEtiqueta(panelA, new Area(a.X(), a.Y(4) + a.AlP(63), a.An(), a.AlP(7)), "05. Emisn. Plan Cuentas", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelA, new Area(a.X(), a.Y(5) + a.AlP(70), a.An(), a.AlP(7)), "06. Control Presupuesto", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelA, new Area(a.X(), a.Y(7) + a.AlP(84), a.An(), a.AlP(7)), "08. Tipo de Cambio", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelA, new Area(a.X(), a.Y(8) + a.AlP(91), a.An(), a.AlP(7)), "09. Estado de Cuenta", 16, SwingConstants.LEFT, Color.WHITE, true));
    }
    private void construirPanelB(Area a){
        tituloB = new IUEtiqueta(panelB, "PROCESOS", new Area(a.X() + a.AnP(30), a.Y(4), a.AnP(40), a.AlP(7)), 20, "CENTER", new Color(120, 0, 0));
        tituloB.setSubrayarTexto(true);
        iuLista.add(new IUPanelEtiqueta(panelB, new Area(a.X(), a.Y() + a.AlP(21), a.An(), a.AlP(7)), "11. Asiento Simple", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelB, new Area(a.X(), a.Y(2) + a.AlP(28), a.An(), a.AlP(7)), "12. Asiento Multiple", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelB, new Area(a.X(), a.Y(3) + a.AlP(35), a.An(), a.AlP(7)), "13. Asiento de Ajuste", 16, SwingConstants.LEFT, Color.WHITE, true));
        
        tituloB = new IUEtiqueta(panelB, "REPORTES", new Area(a.X() + a.AnP(30), a.Y(7) + a.AlP(42), a.AnP(40), a.AlP(7)), 20, "CENTER", new Color(120, 0, 0));
        tituloB.setSubrayarTexto(true);
        iuLista.add(new IUPanelEtiqueta(panelB, new Area(a.X(), a.Y(4) + a.AlP(63), a.An(), a.AlP(7)), "15. Libro Diario", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelB, new Area(a.X(), a.Y(5) + a.AlP(70), a.An(), a.AlP(7)), "16. Libro Mayor...", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelB, new Area(a.X(), a.Y(6) + a.AlP(77), a.An(), a.AlP(7)), "17. Balance Comprobacion", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelB, new Area(a.X(), a.Y(7) + a.AlP(84), a.An(), a.AlP(7)), "18. Perdidas y Ganancias", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelB, new Area(a.X(), a.Y(8) + a.AlP(91), a.An(), a.AlP(7)), "19. Balance General", 16, SwingConstants.LEFT, Color.WHITE, true));
    }
    private void construirPanelC(Area a){
        iuLista.add(new IUPanelEtiqueta(panelC, new Area(a.X(), a.Y() + a.AlP(21), a.An(), a.AlP(7)), "21. Claves de Acceso", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelC, new Area(a.X(), a.Y(2) + a.AlP(28), a.An(), a.AlP(7)), "22. Manejo Archivos...", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelC, new Area(a.X(), a.Y(3) + a.AlP(35), a.An(), a.AlP(7)), "23. Indices - Estados...", 16, SwingConstants.LEFT, Color.WHITE, true));
        
        iuLista.add(new IUPanelEtiqueta(panelC, new Area(a.X(), a.Y(4) + a.AlP(63), a.An(), a.AlP(7)), "25. Actualizacion Diferida", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelC, new Area(a.X(), a.Y(5) + a.AlP(70), a.An(), a.AlP(7)), "26. Verificacion Asientos", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelC, new Area(a.X(), a.Y(6) + a.AlP(77), a.An(), a.AlP(7)), "27. Integracion Sistemas", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelC, new Area(a.X(), a.Y(7) + a.AlP(84), a.An(), a.AlP(7)), "28. Cargar Tablas al Sistema", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelC, new Area(a.X(), a.Y(8) + a.AlP(91), a.An(), a.AlP(7)), "30. Respaldo - Desplazo...", 16, SwingConstants.LEFT, Color.WHITE, true));
    }
    private void construirPanelAbajo(Area a){
        panelMensajes = new IUPanel(panelAbajo, new Area(a.X(), a.Y(), a.AnP(80), a.AlP(50)), false, Color.WHITE);
        construirPanelMensajes(new Area(panelMensajes.area.An() - 8, panelMensajes.area.Al()));
        
        panelInformacion = new IUPanel(panelAbajo, new Area(a.X(), a.Y(2) + a.AlP(50), a.AnP(80), a.AlP(50)), false, Ayuda.COLOR_FONDO);
        construirPanelInformacion(new Area(2, 2, panelInformacion.area.An() - 10, panelInformacion.area.Al() - 4));
        
        panelEntrada = new IUPanel(panelAbajo, new Area(a.X(2) + a.AnP(80), a.Y(), a.AnP(20), a.Al()), false, Ayuda.COLOR_FONDO);
        construirPanelEntrada(new Area(4, 4, panelEntrada.area.An() - 8, panelEntrada.area.Al() - 8));
    }
    private void construirPanelMensajes(Area a){
        iuMensajes = new IUEtiqueta(panelMensajes, "Digite UNA opcion y [Enter] o [Esc] = para Finalizar.......", new Area(a.An(), a.Al()), 16, "CENTER", false);
    }
    private void construirPanelInformacion(Area a){
        iuFechaVigente = new IUPanelEtiqueta(panelInformacion, new Area(a.X() + a.AnP(55), a.Y(), a.AnP(15), a.Al()), "Fecha Vigente: ", 16, SwingConstants.LEFT, Ayuda.COLOR_FONDO, true);
        iuFecha = new IUEtiqueta(panelInformacion, usuario.getFecusu(), new Area(a.X(2) + a.AnP(70), a.Y(), a.AnP(15), a.Al()), 16, "CENTER", true);
        
        iuEtiquetaTipoCambio = new IUPanelEtiqueta(panelInformacion, new Area(a.X(3) + a.AnP(85), a.Y(), a.AnP(5), a.Al()), "T/C: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuTipoCambio = new IUEtiqueta(panelInformacion, String.valueOf(usuario.getTipcam()), new Area(a.X(4) + a.AnP(90), a.Y(), a.AnP(10), a.Al()), 16, "CENTER", true);
    }
    private void construirPanelEntrada(Area a){
        iuEntrada = new IUComboBox(panelEntrada, getOpciones(), new Area(a.X(), a.Y(), a.AnP(30), a.AlP(50)), 16, 2);        
        
    }
    private void salirSistema(){
        setOpacity(0.6f);
        int resp = JOptionPane.showConfirmDialog( this , "Está seguro que desea salir del sistema?" , "Confirmación" , JOptionPane.YES_NO_OPTION );                    
        if( resp == 0 )
            System.exit(0);
        setOpacity(1f);
    }
    private ArrayList<String> getOpciones(){
        ArrayList<String> opciones = new ArrayList<>();
        iuLista.stream().map((iuDato) -> iuDato.getTexto().substring(0, 2)).forEachOrdered((dato) -> {
            opciones.add(dato);
        });
        return opciones;
    }
    private void setEventos(){
        iuEntrada.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String dato = e.getItem().toString();
                seleccionarOpcion(dato);
            }
        });
        iuEntrada.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    componenteSeleccionado(iuEntrada.getSelectedItem().toString());
                }
            }
        });
    }
    private void seleccionarOpcion(String opcion){
        iuLista.forEach((iuDato) -> {
            String dato = iuDato.getTexto().substring(0, 2);
            if(opcion.equalsIgnoreCase(dato)){
                iuDato.setBackground(Color.yellow);
            }else{
                iuDato.setBackground(Color.WHITE);
            }
        });
    }
    private void componenteSeleccionado(String opcion){
        switch(opcion){
            case "01":
                setOpacity(0.6f);
                VConmae vConmae = new VConmae(this, titulo, "grande", usuario, tabvar);
                vConmae.mostrarVentana();
                setOpacity(1f);
            break;
            case "03":
                setOpacity(0.6f);
                VTabvar vTabvar = new VTabvar(this, titulo, "grande", usuario, tabvar);
                vTabvar.mostrarVentana();
                setOpacity(1f);
            break;
            case "28":
                setOpacity(0.6f);
                VOpciones iuOpciones = new VOpciones(this, titulo, "pequeno");
                iuOpciones.mostrarVentana();
                if(iuOpciones.getEstado()){
                    
                }
                setOpacity(1f);
            break;
            default:
                Ayuda.mostrarMensajeInformacion(this, "usted selecciono la opcion: "+opcion, "informacion");
            break;
        }
    }
    
}

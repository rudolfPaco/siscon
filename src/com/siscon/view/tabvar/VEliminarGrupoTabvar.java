/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.tabvar;

import SIGU.campoTexto.IUCampoTexto;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.paneles.IUPanel;
import SIGU.paneles.IUPanelEtiqueta;
import SIGU.recursos.Area;
import SIGU.recursos.Fecha;
import SIGU.tablas.IUTabla;
import SIGU.tablas.ModeloTabla;
import SIGU.ventanas.IUSecundario;
import com.siscon.controller.CTabvar;
import com.siscon.model.Tabvar;
import com.siscon.model.Usuario;
import com.siscon.recursos.Ayuda;
import com.siscon.view.VPrincipal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author neo
 */
public class VEliminarGrupoTabvar extends IUSecundario{
    private IUSecundario ventanaPrincipal;
    
    private IUPanel panel;
        private IUPanel panelTitulo;
        private IUEtiqueta iuTitulo;
    
    private IUPanel panelDatos;
        private IUPanel primerPanel;
            private IUPanelEtiqueta etiquetaTipo;
            private IUEtiqueta iuTipo;            
            private IUPanelEtiqueta etiquetaNumero;
            private IUEtiqueta iuNumero;            
            private IUPanelEtiqueta etiquetaNombre;
            private IUEtiqueta iuNombre;
            private IUPanelEtiqueta etiquetaCodcon;
            private IUEtiqueta iuCodcon;
            private IUPanelEtiqueta etiquetaCorrel;
            private IUEtiqueta iuCorrel;
            private IUPanelEtiqueta etiquetaMonto;
            private IUEtiqueta iuMonto;            
            private IUPanelEtiqueta etiquetaDescripcion;
            private IUEtiqueta iuDescripcion;
            
        private IUPanel segundoPanel;
            private IUEtiqueta iuTituloTabla;
            private IUTabla iuTabla;
        
        private IUPanel tercerPanel;
            private IUEtiqueta iuTituloMensaje;
            private IUPanelEtiqueta iuMensaje;
            private IUPanelEtiqueta iuInformacion;
    
    private final Tabvar tabvar;
    
    public VEliminarGrupoTabvar(IUSecundario ventanaPrincipal, String titulo, String tipoSize, Tabvar tabvar) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        this.tabvar = tabvar;
        construirPanel(new Area(An()-6, Al()-29));
        algoritmoInicial();
    }
    private void construirPanel(Area a){
        panel = new IUPanel(this, new Area(a.X(), a.Y(), a.An(), a.Al()), true);        
        panel.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "ESC" );
        panel.getActionMap().put( "ESC", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                dispose();
            }
        });        
        
        construirPaneles(new Area(2, 2, panel.area.An() - 4, panel.area.Al() - 4));        
    }
    private void construirPaneles(Area a){
        panelTitulo = new IUPanel(panel, new Area(a.X(), a.Y(), a.An(), a.AlP(4)), true, Ayuda.COLOR_FONDO);
        construirPanelTitulo(new Area(2, 2, panelTitulo.area.An() - 4, panelTitulo.area.Al() - 4));
        
        panelDatos = new IUPanel(panel, new Area(a.X(), a.Y(2) + a.AlP(4), a.An(), a.AlP(96)), false);
        construirPanelDatos(new Area(2, 2, panelDatos.area.An() - 4, panelDatos.area.Al() - 8));
    }
    private void construirPanelTitulo(Area a){
        iuTitulo = new IUEtiqueta(panelTitulo, "ELIMINACION DE REGISTROS POR GRUPO", new Area(a.X(), a.Y(), a.An(), a.Al()), 20, "CENTER", Ayuda.COLOR_ROJO);
        iuTitulo.setSubrayarTexto(true);        
    }
    private void construirPanelDatos(Area a){
        primerPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(), a.An(), a.AlP(8)), true);
        construirPrimerPanel(new Area(2, 2, primerPanel.area.An() - 16, primerPanel.area.Al() - 4));
        
        segundoPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(2) + a.AlP(8), a.An(), a.AlP(77)), true);
        construirSegundoPanel(new Area(2, 2, segundoPanel.area.An() - 4, segundoPanel.area.Al() - 6));
        
        tercerPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(3) + a.AlP(85), a.An(), a.AlP(15)), true);
        construirTercerPanel(new Area(2, 2, tercerPanel.area.An() - 4, tercerPanel.area.Al() - 6));
    }
    private void construirPrimerPanel(Area a){
        etiquetaTipo = new IUPanelEtiqueta(primerPanel, new Area(a.X(), a.Y(), a.AnP(10), a.AlP(50)), "TIPO", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuTipo = new IUEtiqueta(primerPanel, String.valueOf(tabvar.getTipo()), new Area(a.X(), a.Y() + a.AlP(50), a.AnP(10), a.AlP(50)), 16, "CENTER", true);
        
        etiquetaNumero = new IUPanelEtiqueta(primerPanel, new Area(a.X(2) + a.AnP(10), a.Y(), a.AnP(10), a.AlP(50)), "NUMERO", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuNumero = new IUEtiqueta(primerPanel, String.valueOf(tabvar.getNumero()), new Area(a.X(2) + a.AnP(10), a.Y() + a.AlP(50), a.AnP(10), a.AlP(50)), 16, "CENTER", true);
        
        etiquetaNombre = new IUPanelEtiqueta(primerPanel, new Area(a.X(3) + a.AnP(20), a.Y(), a.AnP(20), a.AlP(50)), "NOMBRE", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuNombre = new IUEtiqueta(primerPanel, tabvar.getDescri(), new Area(a.X(3) + a.AnP(20), a.Y() + a.AlP(50), a.AnP(20), a.AlP(50)), 16, "CENTER", true);
        
        etiquetaCodcon = new IUPanelEtiqueta(primerPanel, new Area(a.X(4) + a.AnP(40), a.Y(), a.AnP(10), a.AlP(50)), "CODCON", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuCodcon = new IUEtiqueta(primerPanel, String.valueOf(tabvar.getCodcon()), new Area(a.X(4) + a.AnP(40), a.Y() + a.AlP(50), a.AnP(10), a.AlP(50)), 16, "CENTER", true);
        
        etiquetaCorrel = new IUPanelEtiqueta(primerPanel, new Area(a.X(5) + a.AnP(50), a.Y(), a.AnP(10), a.AlP(50)), "CORREL", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuCorrel = new IUEtiqueta(primerPanel, String.valueOf(tabvar.getCorrel()), new Area(a.X(5) + a.AnP(50), a.Y() + a.AlP(50), a.AnP(10), a.AlP(50)), 16, "CENTER", true);
        
        etiquetaMonto = new IUPanelEtiqueta(primerPanel, new Area(a.X(6) + a.AnP(60), a.Y(), a.AnP(10), a.AlP(50)), "MONTO", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuMonto = new IUEtiqueta(primerPanel, String.valueOf(tabvar.getMonto()), new Area(a.X(6) + a.AnP(60), a.Y() + a.AlP(50), a.AnP(10), a.AlP(50)), 16, "CENTER", true);
        
        etiquetaDescripcion = new IUPanelEtiqueta(primerPanel, new Area(a.X(7) + a.AnP(70), a.Y(), a.AnP(20), a.AlP(50)), "DESCRIPCION", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuDescripcion = new IUEtiqueta(primerPanel, tabvar.getObserv(), new Area(a.X(7) + a.AnP(70), a.Y() + a.AlP(50), a.AnP(20), a.AlP(50)), 16, "CENTER", true);
    }
    private void construirSegundoPanel(Area a){
        iuTituloTabla = new IUEtiqueta(segundoPanel, "TABLA - TABVAR", new Area(a.X(), a.Y(), a.An(), a.AlP(5)), 16, "CENTER", Ayuda.COLOR_ROJO);
        iuTituloTabla.setSubrayarTexto(true);
        iuTabla = new IUTabla(
        segundoPanel,
        new Area(a.X(), a.Y(2) + a.AlP(5), a.An(), a.AlP(95)), 
        new String[]{"TIPO", "NUMERO", "DESCRIPCION", "CODCON", "CORREL", "MONTO", "OBSERVACION", "FECHA", "FECHA2", "MONTO2", "TIPCAM", "NUMNIT"}, 
        new Class[]{Integer.class, Integer.class, String.class, Integer.class, Integer.class, Double.class, String.class, String.class, String.class, Double.class, Integer.class, Integer.class}, 
        new int[]{5,5,19,7,5,8,19,8,8,5,5,8}, 
        CTabvar.getLista("SELECT * FROM tabvar WHERE TIPO = "+tabvar.getTipo()), 
        new ModeloTabla<Tabvar>(){
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return lista.get(rowIndex).getTipo();
                    case 1:                
                        return lista.get(rowIndex).getNumero();
                    case 2:                
                        return lista.get(rowIndex).getDescri();
                    case 3:
                        return lista.get(rowIndex).getCodcon();
                    case 4:
                        return lista.get(rowIndex).getCorrel();
                    case 5:
                        return lista.get(rowIndex).getMonto();
                    case 6:
                        return lista.get(rowIndex).getObserv();
                    case 7:
                        return lista.get(rowIndex).getFecha();
                    case 8:
                        return lista.get(rowIndex).getFecha2();
                    case 9:
                        return lista.get(rowIndex).getMonto2();
                    case 10:
                        return lista.get(rowIndex).getTipcam();
                    case 11:
                        return lista.get(rowIndex).getNumnit();                    
                    default:
                        return null;
                }
            }
        });
        iuTabla.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }
    private void construirTercerPanel(Area a){
        iuTituloMensaje = new IUEtiqueta(tercerPanel, "Mensajes - Instrucciones", new Area(a.X(), a.Y(), a.AnP(97), a.AlP(20)), 16, "CENTER", false);
        iuMensaje = new IUPanelEtiqueta(tercerPanel, new Area(a.X(), a.Y(2) + a.AlP(20), a.AnP(97), a.AlP(40)), "", 16, SwingConstants.LEFT, Ayuda.COLOR_ATENCION, true);
        iuInformacion = new IUPanelEtiqueta(tercerPanel, new Area(a.X(), a.Y(3) + a.AlP(60), a.AnP(97), a.AlP(40)), "", 16, SwingConstants.LEFT, Ayuda.COLOR_FONDO, true);
    }
    private void algoritmoInicial(){
        iuTabla.setFocusable(true);
        iuTabla.requestFocus();
        iuMensaje.setTexto("Navegue por la tabla con las teclas Arriba y Abajo, seleccione registros utilizando la tecla CTRL y ESPACIO.");
        iuInformacion.setTexto("ATENCION: [ESPACIO]=Seleccion Registros, [ENTER]=Eliminar, [ESCAPE]=Suspender o Salir");
        iuTabla.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    int[] multipleSeleccion = iuTabla.getSelectedRows();
                    if(multipleSeleccion.length > 0){
                        int resp = JOptionPane.showConfirmDialog( ventanaPrincipal , "Esta seguro que quiere elminar los "+multipleSeleccion.length+" registros del TABVAR...?", "CONFIRMACION" , JOptionPane.YES_NO_OPTION );
                        if( resp == JOptionPane.YES_OPTION ){
                            for (int i = 0; i < multipleSeleccion.length; i++) {
                                int indice = multipleSeleccion[i];
                                Tabvar t = (Tabvar) iuTabla.modeloTabla.getFila(indice);
                                CTabvar.eliminarTabvar(t);
                            }
                            JOptionPane.showMessageDialog( ventanaPrincipal , "Se ha ELIMINADO LAS "+multipleSeleccion.length+" Registros de la TABLA TABVAR.", "CORRECTO" , JOptionPane.INFORMATION_MESSAGE );
                            iuTabla.actualizarTabla(CTabvar.getLista("SELECT * FROM tabvar WHERE TIPO = "+tabvar.getTipo()));
                        }
                    }
                }
            }
        });
    }
}

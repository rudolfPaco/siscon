/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.conmae;

import SIGU.etiquetas.IUEtiqueta;
import SIGU.paneles.IUPanel;
import SIGU.paneles.IUPanelEtiqueta;
import SIGU.recursos.Area;
import SIGU.tablas.IUTabla;
import SIGU.tablas.ModeloTabla;
import SIGU.tablas.RendererDatosTabla;
import SIGU.ventanas.IUSecundario;
import com.siscon.controller.CConmae;
import com.siscon.controller.CTabvar;
import com.siscon.model.Conmae;
import com.siscon.model.Tabvar;
import com.siscon.recursos.Ayuda;
import com.siscon.view.VPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class VEliminarGrupoConmae extends IUSecundario{
    private VPrincipal ventanaPrincipal;
    
    private IUPanel panel;
        private IUPanel panelTitulo;
        private IUEtiqueta iuTitulo;
    
    private IUPanel panelDatos;
        private IUPanel primerPanel;
            private IUPanelEtiqueta etiquetaCodigo;
            private IUEtiqueta iuCodigo;
            private IUPanelEtiqueta etiquetaG;
            private IUEtiqueta iuG;
            private IUPanelEtiqueta etiquetaS;
            private IUEtiqueta iuS;
            private IUPanelEtiqueta etiquetaMy;
            private IUEtiqueta iuMy;
            private IUPanelEtiqueta etiquetaAn;
            private IUEtiqueta iuAn;
            private IUPanelEtiqueta etiquetaSa;
            private IUEtiqueta iuSa;            
            private IUPanelEtiqueta etiquetaDescripcion;
            private IUEtiqueta iuDescripcion;
            private IUPanelEtiqueta etiquetaNivel;
            private IUEtiqueta iuNivel;
            private IUPanelEtiqueta etiquetaActividad;
            private IUEtiqueta iuActividad;
            private IUPanelEtiqueta etiquetaPresupuesto;
            private IUEtiqueta iuPresupuesto;
            
        private IUPanel segundoPanel;
            private IUEtiqueta iuTituloTabla;
            private IUTabla iuTabla;
        
        private IUPanel tercerPanel;
            private IUEtiqueta iuTituloMensaje;
            private IUPanelEtiqueta iuMensaje;
            private IUPanelEtiqueta iuInformacion;
    
    private final Conmae conmae;
    
    public VEliminarGrupoConmae(VPrincipal ventanaPrincipal, String titulo, String tipoSize, Conmae tabvar) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        this.conmae = tabvar;
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
        iuTitulo = new IUEtiqueta(panelTitulo, "ELIMINACION DE REGISTROS POR GRUPO PLAN DE CUENTAS", new Area(a.X(), a.Y(), a.An(), a.Al()), 20, "CENTER", Ayuda.COLOR_ROJO);
        iuTitulo.setSubrayarTexto(true);        
    }
    private void construirPanelDatos(Area a){
        primerPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(), a.An(), a.AlP(8)), true);
        construirPrimerPanel(new Area(2, 2, primerPanel.area.An() - 22, primerPanel.area.Al() - 4));
        
        segundoPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(2) + a.AlP(8), a.An(), a.AlP(77)), true);
        construirSegundoPanel(new Area(2, 2, segundoPanel.area.An() - 4, segundoPanel.area.Al() - 6));
        
        tercerPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(3) + a.AlP(85), a.An(), a.AlP(15)), true);
        construirTercerPanel(new Area(2, 2, tercerPanel.area.An() - 4, tercerPanel.area.Al() - 6));
    }
    private void construirPrimerPanel(Area a){
        etiquetaCodigo = new IUPanelEtiqueta(primerPanel, new Area(a.X(), a.Y(), a.AnP(15), a.AlP(50)), "CODIGO", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuCodigo = new IUEtiqueta(primerPanel, String.valueOf(conmae.getCuetot()), new Area(a.X(), a.Y() + a.AlP(50), a.AnP(15), a.AlP(50)), 16, "CENTER", true);
        
        etiquetaG = new IUPanelEtiqueta(primerPanel, new Area(a.X(2) + a.AnP(15), a.Y(), a.AnP(5), a.AlP(50)), "G", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuG = new IUEtiqueta(primerPanel, String.valueOf(conmae.getGrup()), new Area(a.X(2) + a.AnP(15), a.Y() + a.AlP(50), a.AnP(5), a.AlP(50)), 16, "CENTER", true);
        
        etiquetaS = new IUPanelEtiqueta(primerPanel, new Area(a.X(3) + a.AnP(20), a.Y(), a.AnP(5), a.AlP(50)), "S", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuS = new IUEtiqueta(primerPanel, String.valueOf(conmae.getSubgru()), new Area(a.X(3) + a.AnP(20), a.Y() + a.AlP(50), a.AnP(5), a.AlP(50)), 16, "CENTER", true);
        
        etiquetaMy = new IUPanelEtiqueta(primerPanel, new Area(a.X(4) + a.AnP(25), a.Y(), a.AnP(5), a.AlP(50)), "My", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuMy = new IUEtiqueta(primerPanel, String.valueOf(conmae.getMayor()), new Area(a.X(4) + a.AnP(25), a.Y() + a.AlP(50), a.AnP(5), a.AlP(50)), 16, "CENTER", true);
        
        etiquetaAn = new IUPanelEtiqueta(primerPanel, new Area(a.X(5) + a.AnP(30), a.Y(), a.AnP(5), a.AlP(50)), "An", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuAn = new IUEtiqueta(primerPanel, String.valueOf(conmae.getCuenta()), new Area(a.X(5) + a.AnP(30), a.Y() + a.AlP(50), a.AnP(5), a.AlP(50)), 16, "CENTER", true);
        
        etiquetaSa = new IUPanelEtiqueta(primerPanel, new Area(a.X(6) + a.AnP(35), a.Y(), a.AnP(5), a.AlP(50)), "Sa", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuSa = new IUEtiqueta(primerPanel, String.valueOf(conmae.getSubcta()), new Area(a.X(6) + a.AnP(35), a.Y() + a.AlP(50), a.AnP(5), a.AlP(50)), 16, "CENTER", true);
        
        etiquetaDescripcion = new IUPanelEtiqueta(primerPanel, new Area(a.X(7) + a.AnP(40), a.Y(), a.AnP(25), a.AlP(50)), "DESCRIPCION", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuDescripcion = new IUEtiqueta(primerPanel, conmae.getDescri(), new Area(a.X(7) + a.AnP(40), a.Y() + a.AlP(50), a.AnP(25), a.AlP(50)), 16, "CENTER", true);
        
        etiquetaNivel = new IUPanelEtiqueta(primerPanel, new Area(a.X(8) + a.AnP(65), a.Y(), a.AnP(15), a.AlP(50)), "NIVEL", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuNivel = new IUEtiqueta(primerPanel, String.valueOf(conmae.getNivel()), new Area(a.X(8) + a.AnP(65), a.Y() + a.AlP(50), a.AnP(15), a.AlP(50)), 16, "CENTER", true);
        
        etiquetaActividad = new IUPanelEtiqueta(primerPanel, new Area(a.X(9) + a.AnP(80), a.Y(), a.AnP(10), a.AlP(50)), "ACTIVIDAD", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuActividad = new IUEtiqueta(primerPanel, String.valueOf(conmae.getActivi()), new Area(a.X(9) + a.AnP(80), a.Y() + a.AlP(50), a.AnP(10), a.AlP(50)), 16, "CENTER", true);
        
        etiquetaPresupuesto = new IUPanelEtiqueta(primerPanel, new Area(a.X(10) + a.AnP(90), a.Y(), a.AnP(10), a.AlP(50)), "PRESUPUESTO", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuPresupuesto = new IUEtiqueta(primerPanel, String.valueOf(conmae.getPresup()), new Area(a.X(10) + a.AnP(90), a.Y() + a.AlP(50), a.AnP(10), a.AlP(50)), 16, "CENTER", true);
    }
    private void construirSegundoPanel(Area a){
        iuTituloTabla = new IUEtiqueta(segundoPanel, "PLAN DE CUENTAS", new Area(a.X(), a.Y(), a.An(), a.AlP(5)), 16, "CENTER", Ayuda.COLOR_ROJO);
        iuTituloTabla.setSubrayarTexto(true);
        iuTabla = new IUTabla(
        segundoPanel, 
        new Area(a.X(), a.Y(2) + a.AlP(5), a.An(), a.AlP(95)), 
        new String[]{"CODIGO", "G", "S", "My", "An", "Sa", "DESCRIPCION", "NIVEL", "ACTIVIDAD", "PRESUP"}, 
        new Class[]{Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class, Integer.class, Integer.class, Integer.class}, 
        new int[]{11, 5, 5, 5, 5, 5, 37, 9, 9, 9}, 
        CConmae.getLista("SELECT * FROM CONMAE WHERE GRUP = "+conmae.getGrup()), 
        new ModeloTabla<Conmae>(){
            
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return lista.get(rowIndex).getCuetot();
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
                        return lista.get(rowIndex).getDescri();
                    case 7:
                        return lista.get(rowIndex).getNivel();
                    case 8:
                        return lista.get(rowIndex).getActivi();
                    case 9:
                        return lista.get(rowIndex).getPresup();
                    default:
                        return null;
                }
            }
        });
        iuTabla.setPosicionTextoHorizontal(6, SwingConstants.LEFT);
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
        iuMensaje.setTexto("Navegue por la tabla con las teclas Arriba y Abajo, seleccione registros presionando la tecla CTRL sin soltar, luego presione la tecla ESPACIO.");
        iuInformacion.setTexto("ATENCION: [ESPACIO]=Seleccion Registros, [ENTER]=Eliminar, [ESCAPE]=Suspender o Salir");
        iuTabla.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    int[] multipleSeleccion = iuTabla.getSelectedRows();
                    if(multipleSeleccion.length > 0){
                        if(Ayuda.mostrarMensajeConfirmacion(ventanaPrincipal, "Esta seguro que quiere elminar los "+multipleSeleccion.length+" registros del PLAN DE CUENTAS...?", "CONFIRMACION")){
                            for (int i = 0; i < multipleSeleccion.length; i++) {
                                int indice = multipleSeleccion[i];
                                Conmae c = (Conmae) iuTabla.modeloTabla.getFila(indice);
                                CConmae.eliminarConmae(c);
                            }
                            Ayuda.mostrarMensajeInformacion(ventanaPrincipal, "Se ha ELIMINADO (EL) LOS "+multipleSeleccion.length+" Registros de la TABLA CONMAE.", "CORRECTO");
                            iuTabla.actualizarTabla(CConmae.getLista("SELECT * FROM CONMAE WHERE GRUP = "+conmae.getGrup()));
                        }                        
                    }
                }
            }
        });
    }
}

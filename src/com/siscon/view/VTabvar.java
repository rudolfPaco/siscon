/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view;

import SIGU.botones.SIUBoton;
import SIGU.campoTexto.SIUCampoTexto;
import SIGU.campoTexto.SIUFormatoCampoTexto;
import SIGU.etiquetas.SIUEtiqueta;
import SIGU.paneles.SIUPanel;
import SIGU.recursos.Arena;
import SIGU.recursos.Fecha;
import SIGU.recursos.Grid;
import SIGU.ventanas.SIUSecundario;
import com.siscon.controller.CTabvar;
import com.siscon.model.Tabvar;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author neo
 */
public class VTabvar extends SIUSecundario{
    
    private VPrincipal iuPrincipal;

    private SIUPanel panel;
    
    //construccion de panel1
    private SIUPanel panel1;    
    private SIUEtiqueta etiqueta1;
    private SIUEtiqueta etiqueta2;
    private SIUEtiqueta etiqueta3;
    private SIUEtiqueta etiqueta4;
    private SIUEtiqueta etiqueta5;
    
    //construccion de panel2
    private SIUPanel panel2;
    private SIUPanel panelTipo;
    private SIUPanel panelNumero;
    private SIUPanel panelDescripcion;
    private SIUPanel panelInstrucciones;
    private SIUCampoTexto campoTipo;
    private SIUCampoTexto campoNumero;
    private SIUCampoTexto campoDescripcion;
    
    private SIUPanel panelCampos;
    private SIUEtiqueta etiquetaNombre;
    private SIUCampoTexto campoNombre;
    private SIUEtiqueta etiquetaCodigoContable;
    private SIUCampoTexto campoCodigoContable;
    private SIUEtiqueta etiquetaCorrelativo;
    private SIUCampoTexto campoCorrelativo;
    private SIUEtiqueta etiquetaMonto1;
    private SIUFormatoCampoTexto campoMonto1;
    private SIUEtiqueta etiquetaMonto2;
    private SIUFormatoCampoTexto campoMonto2;
    private SIUEtiqueta etiquetaFecha1;
    private SIUFormatoCampoTexto campoFecha1;
    private JDateChooser campoDate1 = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
    private SIUEtiqueta etiquetaFecha2;
    private SIUFormatoCampoTexto campoFecha2;
    private JDateChooser campoDate2 = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
    
    private SIUPanel panelInstruccionesFormato;
    private SIUEtiqueta etiqueta6;
    
    private SIUPanel panel3;
    private SIUBoton botonCerrar;
    private SIUBoton botonImprimir;
    private SIUBoton botonLimpiar;    
    private SIUBoton botonEliminar;
    private SIUBoton botonModificar;
    private SIUBoton botonGrabar;
    private SIUBoton botonMostrar;
    
    private Color colorFondoTitulo = new Color(232, 237, 244);
    private Color colorFondoDatos = new Color(235, 235, 235);
    
    private String estadoOp = "";
    
    /**
     *
     * @param iuPrincipal
     * @param sizeView
     */
    public VTabvar(VPrincipal iuPrincipal, String sizeView) {
        super(iuPrincipal, sizeView);
        this.iuPrincipal = iuPrincipal;
        construirPaneles();
        setEventos();
        setEstadosIniciales(false);
        setEstadoBotonesIniciales(false);       
    }
    private void construirPaneles(){
        panel = new SIUPanel(this, new Grid(55, 30, 0, 0, 12, 12));        
        panel.setColorFondo(Color.WHITE, 0);
        
        panel1 = new SIUPanel(panel, new Grid(106, 7, 0, 0, 54, 3), true);
        panel1.setColorFondo(colorFondoTitulo, 0);
        construriPanel1();
        
        panel2 = new SIUPanel(panel, new Grid(106, 39, 1, 5, 53, 13), true);
        //panel2.mostrarPuntos(true);
        construirPanel2();
        
        panel3 = new SIUPanel(panel, new Grid(72, 12, 1, 26, 53, 2), false);
        construirPanel3();
    }
    private void construriPanel1(){
        etiqueta1 = new SIUEtiqueta(panel1, "CAMARA FORESTAL", new Grid(1, 1, 20, 2), 16, "LEFT");
        etiqueta2 = new SIUEtiqueta(panel1, "EJECUTIVO", new Grid(1, 3, 20, 2), 16, "LEFT");
        etiqueta3 = new SIUEtiqueta(panel1, "PROCESOS DE PARAMETROS - TABLAS", new Grid(21, 1, 50, 2), 16, "CENTER");
        etiqueta3.setSubrayarTexto(true);
        etiqueta4 = new SIUEtiqueta(panel1, "SISTEMA CONTABLE SISCON @v7.1. 2020", new Grid(73, 1, 33, 2), 16, "LEFT");
        etiqueta5 = new SIUEtiqueta(panel1, "FECHA: "+new Fecha().getFecha1(), new Grid(73, 3, 33, 2), 16, "LEFT");        
    }
    private void construirPanel2(){
        panelTipo = new SIUPanel(panel2, new Grid(0, 0, 5, 2), true);
        panelTipo.setColorFondo(colorFondoDatos, 0);
        etiqueta1 = new SIUEtiqueta(panelTipo, "TIPO", new Grid(0, 0, 12, 12), 11, "CENTER");
        
        panelNumero = new SIUPanel(panel2, new Grid(6, 0, 7, 2), true);
        panelNumero.setColorFondo(colorFondoDatos, 0);
        etiqueta2 = new SIUEtiqueta(panelNumero, "NUMERO", new Grid(0, 0, 12, 12), 11, "CENTER");
        
        panelDescripcion = new SIUPanel(panel2, new Grid(14, 0, 30, 2), true);
        panelDescripcion.setColorFondo(colorFondoDatos, 0);
        etiqueta3 = new SIUEtiqueta(panelDescripcion, "DESCRIPCION GENERICA", new Grid(0, 0, 12, 12), 11, "CENTER");
        
        campoTipo = new SIUCampoTexto(panel2, 2, 12, new Grid(0, 2, 5, 3));
        campoTipo.setRestriccion("^[0-9]+([,\\.][0-9]*)?$");
        campoNumero = new SIUCampoTexto(panel2, 2, 12, new Grid(6, 2, 7, 3));
        campoNumero.setRestriccion("^[0-9]+([,\\.][0-9]*)?$");
        campoDescripcion = new SIUCampoTexto(panel2, 30, 12, new Grid(14, 2, 30, 3));        
        campoDescripcion.setRestriccion("[\\p{Alpha}\\p{Alnum}\\p{Space}\\.\\/\\(\\)\\-]");
        
        panelInstrucciones = new SIUPanel(panel2, new Grid(46, 2, 58, 3), true);
        panelInstrucciones.setColorFondo(colorFondoDatos, 0);
        etiqueta4 = new SIUEtiqueta(panelInstrucciones, "INSTRUCCIONES FORMATO", new Grid(0, 0, 12, 12), 11, "CENTER");
        
        panelCampos = new SIUPanel(panel2, new Grid(132, 17, 0, 5, 44, 34), false);
        etiquetaNombre = new SIUEtiqueta(panelCampos, "a. Nombre:", new Grid(2, 2, 30, 2), 12, "LEFT");
        etiquetaNombre.setFont(new Font("Verdana", Font.BOLD, 12));
        etiquetaNombre.setBorder(new LineBorder(colorFondoDatos));
        
        etiquetaCodigoContable = new SIUEtiqueta(panelCampos, "b. Codigo Contable:", new Grid(2, 4, 35, 2), 12, "LEFT");
        etiquetaCodigoContable.setFont(new Font("Verdana", Font.BOLD, 12));
        etiquetaCodigoContable.setBorder(new LineBorder(colorFondoDatos));
        
        etiquetaCorrelativo = new SIUEtiqueta(panelCampos, "c. Correlativo:", new Grid(2, 6, 30, 2), 12, "LEFT");
        etiquetaCorrelativo.setFont(new Font("Verdana", Font.BOLD, 12));
        etiquetaCorrelativo.setBorder(new LineBorder(colorFondoDatos));
        
        etiquetaMonto1 = new SIUEtiqueta(panelCampos, "d. Monto1.:", new Grid(2, 8, 20, 2), 12, "LEFT");
        etiquetaMonto1.setFont(new Font("Verdana", Font.BOLD, 12));
        etiquetaMonto1.setBorder(new LineBorder(colorFondoDatos));
        
        etiquetaMonto2 = new SIUEtiqueta(panelCampos, "2.:", new Grid(2, 10, 19, 2), 12, "RIGHT");
        etiquetaMonto2.setFont(new Font("Verdana", Font.BOLD, 12));
        etiquetaMonto2.setBorder(new LineBorder(colorFondoDatos));
        
        etiquetaFecha1 = new SIUEtiqueta(panelCampos, "e. Fecha1.:", new Grid(2, 12, 19, 2), 12, "LEFT");
        etiquetaFecha1.setFont(new Font("Verdana", Font.BOLD, 12));
        etiquetaFecha1.setBorder(new LineBorder(colorFondoDatos));
        
        etiquetaFecha2 = new SIUEtiqueta(panelCampos, "2.:", new Grid(2, 14, 19, 2), 12, "RIGHT");
        etiquetaFecha2.setFont(new Font("Verdana", Font.BOLD, 12));
        //etiquetaFecha2.setBorder(new LineBorder(colorFondoDatos));
        
        campoNombre = new SIUCampoTexto(panelCampos, 20, 12, new Grid(42, 2, 90, 2));
        campoNombre.setRestriccion("[\\p{Alpha}\\p{Alnum}\\p{Space}\\.\\/\\(\\)\\-]");
        //campoNombre.setEditar(false);
        campoCodigoContable = new SIUCampoTexto(panelCampos, 8, 12, new Grid(42, 4, 30, 2));
        campoCodigoContable.setRestriccion("^[0-9]+([,\\.][0-9]*)?$");//"^[1-9][0-9]?$");
        //campoCodigoContable.setEditar(false);
        campoCorrelativo = new SIUCampoTexto(panelCampos, 6, 12, new Grid(42, 6, 30, 2));
        campoCorrelativo.setRestriccion("^[0-9]+([,\\.][0-9]*)?$");
        //campoCorrelativo.setEditar(false);
        campoMonto1 = new SIUFormatoCampoTexto(panelCampos, new Grid(42, 8, 30, 2), "#.##", 12, SwingConstants.LEFT);
        //campoMonto1.setEditar(false);
        campoMonto2 = new SIUFormatoCampoTexto(panelCampos, new Grid(42, 10, 30, 2), "#.##", 12, SwingConstants.LEFT);
        //campoMonto2.setEditar(false);
        campoFecha1 = new SIUFormatoCampoTexto(panelCampos, new Grid(42, 12, 30, 2), 12, SwingConstants.LEFT);
        campoFecha1.formatoFecha.setVisible(false);
        campoDate1.setBounds(campoFecha1.formatoFecha.getX(), campoFecha1.formatoFecha.getY(), campoFecha1.formatoFecha.getWidth(), campoFecha1.formatoFecha.getHeight());
        //campoDate1.getCalendarButton().setVisible(false);
        campoDate1.getDateEditor().getUiComponent().setForeground(new Color(2, 67, 109));
        campoDate1.getDateEditor().getUiComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){                    
                    campoDate1.getDateEditor().getUiComponent().transferFocus();
                }
                if(KeyEvent.VK_ESCAPE == e.getKeyCode())
                    campoDate1.getDateEditor().getUiComponent().transferFocusBackward();
            }
        });
        panelCampos.add(campoDate1);
        //campoFecha1.setEditar(false);
        campoFecha2 = new SIUFormatoCampoTexto(panelCampos, new Grid(42, 14, 30, 2), 12, SwingConstants.LEFT);
        campoFecha2.formatoFecha.setVisible(false);
        campoDate2.setBounds(campoFecha2.formatoFecha.getX(), campoFecha2.formatoFecha.getY(), campoFecha2.formatoFecha.getWidth(), campoFecha2.formatoFecha.getHeight());
        //campoDate2.getCalendarButton().setVisible(false);
        campoDate2.getDateEditor().getUiComponent().setForeground(new Color(2, 67, 109));
        campoDate2.getDateEditor().getUiComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    campoDate2.getDateEditor().getUiComponent().transferFocus();
                }
                if(KeyEvent.VK_ESCAPE == e.getKeyCode())
                    campoDate2.getDateEditor().getUiComponent().transferFocusBackward();
            }
        });
        panelCampos.add(campoDate2);
        
        panelInstruccionesFormato = new SIUPanel(panel2, new Grid(132, 17,46, 5, 58, 34), true);        
        etiqueta6 = new SIUEtiqueta(panelInstruccionesFormato, "Denominacion Parametro - Tabla x15", new Grid(2, 2, 128, 2), 14, "LEFT");
        etiqueta6.setFont(new Font("Verdana", Font.BOLD, 14));
        etiqueta6 = new SIUEtiqueta(panelInstruccionesFormato, "Campo de integracion Contable n8", new Grid(2, 4, 128, 2), 14, "LEFT");
        etiqueta6.setFont(new Font("Verdana", Font.BOLD, 14));
        etiqueta6 = new SIUEtiqueta(panelInstruccionesFormato, "Campo encargado de Numerar n6", new Grid(2, 6, 128, 2), 14, "LEFT");
        etiqueta6.setFont(new Font("Verdana", Font.BOLD, 14));
        etiqueta6 = new SIUEtiqueta(panelInstruccionesFormato, "Rangos Monetarios n8,2", new Grid(2, 8, 128, 2), 14, "LEFT");
        etiqueta6.setFont(new Font("Verdana", Font.BOLD, 14));
        etiqueta6 = new SIUEtiqueta(panelInstruccionesFormato, "Rango de Fechas dd/mm/aaaa", new Grid(2, 12, 128, 2), 14, "LEFT");
        etiqueta6.setFont(new Font("Verdana", Font.BOLD, 14));
    }
    private void construirPanel3(){
        botonCerrar = new SIUBoton(panel3, new Grid(66, 1, 6, 10), "CERRAR", "/imagenes/cerrar.png", 14, 20, 4, SwingConstants.RIGHT, SwingConstants.CENTER, 'C', "boton para cerrar la ventana");
        botonImprimir = new SIUBoton(panel3, new Grid(58, 1, 6, 10), "IMPRIMIR", "/imagenes/printer.png", 14, 20, 4, SwingConstants.RIGHT, SwingConstants.CENTER, 'P', "boton para imprimir");
        botonLimpiar = new SIUBoton(panel3, new Grid(50, 1, 6, 10), "LIMPIAR", "/imagenes/erase.png", 14, 20, 4, SwingConstants.RIGHT, SwingConstants.CENTER, 'L', "boton para limpiar la pantalla");
        botonEliminar = new SIUBoton(panel3, new Grid(42, 1, 6, 10), "ELIMINAR", "/imagenes/delete.png", 14, 20, 4, SwingConstants.RIGHT, SwingConstants.CENTER, 'E', "boton para eliminar un registro de la tabla");
        botonModificar = new SIUBoton(panel3, new Grid(32, 1, 8, 10), "MODIFICAR", "/imagenes/edit.png", 14, 20, 8, SwingConstants.RIGHT, SwingConstants.CENTER, 'O', "boton para limpiar la pantalla");
        botonGrabar = new SIUBoton(panel3, new Grid(24, 1, 6, 10), "GRABAR", "/imagenes/save.png", 14, 20, 4, SwingConstants.RIGHT, SwingConstants.CENTER, 'G', "boton para guardar el nuevo registro");
        botonMostrar = new SIUBoton(panel3, new Grid(16, 1, 6, 10), "MOSTRAR", "/imagenes/ojos.png", 14, 20, 4, SwingConstants.RIGHT, SwingConstants.CENTER, 'T', "boton para mostrar los registros");
    }
    private void limpiarCampos(){
        estadoOp = "";
        campoTipo.setText("");
        campoNumero.setText("");
        campoDescripcion.setText("");
        campoNombre.setText("");
        campoCodigoContable.setText("");
        campoCorrelativo.setText("");
        campoMonto1.formatoNumerico.setText("");
        campoMonto2.formatoNumerico.setText("");
        campoDate1.setCalendar(null);
        campoDate2.setCalendar(null);
        setEstadosIniciales(false);
        setEstadoBotonesIniciales(false);
    }
    private void setEstadosIniciales(boolean estado){
        campoDescripcion.setEditar(estado);
        campoNombre.setEditar(estado);
        campoCodigoContable.setEditar(estado);
        campoCorrelativo.setEditar(estado);
        campoMonto1.setEditarNumeros(estado);
        campoMonto2.setEditarNumeros(estado);
        campoDate1.getDateEditor().getUiComponent().setFocusable(estado);
        campoDate1.getDateEditor().getUiComponent().setEnabled(estado);
        campoDate2.getDateEditor().getUiComponent().setFocusable(estado);
        campoDate2.getDateEditor().getUiComponent().setEnabled(estado);
        
        campoDescripcion.setText("");
        campoNombre.setText("");
        campoCodigoContable.setText("");
        campoCorrelativo.setText("");
        campoMonto1.formatoNumerico.setText("");
        campoMonto2.formatoNumerico.setText("");
        campoDate1.setCalendar(null);
        campoDate2.setCalendar(null);
    }
    private void setEstadoBotonesIniciales(boolean estado){
        botonImprimir.setEnabled(estado);
        botonEliminar.setEnabled(estado);
        botonModificar.setEnabled(estado);
        botonGrabar.setEnabled(estado);
    }
    private void setCrearNuevoTabvar(){        
        if(estadoOp.isEmpty() || !estadoOp.equalsIgnoreCase("GRABAR")){
            setEstadosIniciales(true);
            botonGrabar.setEnabled(true);
            botonModificar.setEnabled(false);
            botonEliminar.setEnabled(false);
            campoDescripcion.requestFocus();
            JOptionPane.showMessageDialog(iuPrincipal, "Lo siento, no existe ningun registro con los datos iniciales....\npodra grabar un nuevo registro...!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);            
        }
        estadoOp = "GRABAR";
        
    }
    private void mostrarDatosTabvar(Tabvar tabvar){        
        estadoOp = "MODIFICAR";        
        setEstadoBotonesIniciales(false);
        setEstadosIniciales(true);
        botonModificar.setEnabled(true);
        botonEliminar.setEnabled(true);
        
        campoTipo.setText(String.valueOf(tabvar.getTipo()));
        campoNumero.setText(String.valueOf(tabvar.getNumero()));
        campoDescripcion.setText(tabvar.getDescri());
        campoNombre.setText(tabvar.getObserv());
        
        campoCodigoContable.setText(String.valueOf(tabvar.getCodcon()));        
        campoCorrelativo.setText(String.valueOf(tabvar.getCorrel()));
        campoMonto1.formatoNumerico.setText(String.valueOf(tabvar.getMonto()));
        campoMonto2.formatoNumerico.setText(String.valueOf(tabvar.getMonto2()));

        if(tabvar.getFecha() == null)
            campoDate1.setCalendar(null);
        else
            campoDate1.setDate(new Fecha(tabvar.getFecha()).getDate());
        
        if(tabvar.getFecha2() == null)
            campoDate2.setCalendar(null);
        else
            campoDate2.setDate(new Fecha(tabvar.getFecha2()).getDate());        
    }
    private boolean noExistenCamposVacios(){
        boolean verificador = false;
        if(!campoTipo.getText().isEmpty()){
            if(!campoNumero.getText().isEmpty()){
                verificador = true;
            }
        }
        return verificador;
    }
    private void eliminarRegistro(){        
        if(!campoTipo.getText().isEmpty()){
            if(!campoNumero.getText().isEmpty()){
                int tipo = Integer.parseInt(campoTipo.getText());
                int numero = Integer.parseInt(campoNumero.getText());
                if(tipo > 0 && numero > 0){
                    int resp = JOptionPane.showConfirmDialog(iuPrincipal, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
                    if(resp == 0){
                        Tabvar tabvar = CTabvar.getTabvar(tipo, numero);
                        if(tabvar == null){
                            JOptionPane.showMessageDialog(null, "Lo siento, pero no existe el registro TABVAR con TIPO = "+tipo+" y NUMERO = "+numero+" en la BASE DE DATOS....!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                        }else{
                            if(CTabvar.eliminarTabvar(tabvar)){
                                JOptionPane.showMessageDialog(iuPrincipal, "se ha eliminado los datos del registro TABVAR correctamente...!");
                                limpiarCampos();
                            }
                        }
                    }
                }
            }
        }
    }
    private void mostrarTabla(){
        VMostrarTabvar iuMostrar = new VMostrarTabvar(iuPrincipal, "mediano");
        iuMostrar.mostrarVentana();
    }
    
    private void modificarDatosRegistro(){
        if(!campoTipo.getText().isEmpty()){
            if(!campoNumero.getText().isEmpty()){
                int tipo = Integer.parseInt(campoTipo.getText());
                int numero = Integer.parseInt(campoNumero.getText());
                if(tipo > 0 && numero > 0){

                    Tabvar tabvar = CTabvar.getTabvar(tipo, numero);
                    if(tabvar == null){
                        JOptionPane.showMessageDialog(null, "Lo siento, pero no existe el registro TABVAR con TIPO = "+tipo+" y NUMERO = "+numero+" en la BASE DE DATOS....!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    }else{
                        if(noExistenCamposVacios()){         
                            tabvar.setTipo(Integer.parseInt(campoTipo.getText()));
                            tabvar.setNumero(Integer.parseInt(campoNumero.getText()));
                            tabvar.setDescri(campoDescripcion.getText());
                            tabvar.setObserv(campoNombre.getText());

                            if(campoCodigoContable.getText().isEmpty())
                                tabvar.setCodcon(0);
                            else
                                tabvar.setCodcon(Integer.parseInt(campoCodigoContable.getText()));

                            if(campoCorrelativo.getText().isEmpty())
                                tabvar.setCorrel(0);
                            else
                                tabvar.setCorrel(Integer.parseInt(campoCorrelativo.getText()));            

                            if(campoMonto1.formatoNumerico.getText().isEmpty())
                                tabvar.setMonto(0);
                            else
                                tabvar.setMonto(Double.parseDouble(campoMonto1.formatoNumerico.getText()));

                            if(campoMonto2.formatoNumerico.getText().isEmpty())
                                tabvar.setMonto2(0);
                            else
                                tabvar.setMonto2(Double.parseDouble(campoMonto2.formatoNumerico.getText()));

                            if(campoDate1.getDate() != null)
                                tabvar.setFecha(new Fecha().getFecha(campoDate1.getDate(), "yyyy-MM-dd"));
                            else
                                tabvar.setFecha(null);

                            if(campoDate2.getDate() != null)
                                tabvar.setFecha2(new Fecha().getFecha(campoDate2.getDate(), "yyyy-MM-dd"));
                            else
                                tabvar.setFecha2(null);

                            //System.out.println("la tabvar PARA MODIFICAR ES: "+tabvar.toString());
                            if(CTabvar.modificarTabvar(tabvar)){
                                JOptionPane.showMessageDialog(iuPrincipal, "se ha modiicado los datos del registro TABVAR correctamente...!");
                                limpiarCampos();
                            }
                        }
                    }
                }
            }
        }
    }
    private void guardarNuevoRegistro(){
        if(noExistenCamposVacios()){
            Tabvar tabvar = new Tabvar(0);
            tabvar.setTipo(Integer.parseInt(campoTipo.getText()));
            tabvar.setNumero(Integer.parseInt(campoNumero.getText()));
            tabvar.setDescri(campoDescripcion.getText());
            tabvar.setObserv(campoNombre.getText());
            
            if(campoCodigoContable.getText().isEmpty())
                tabvar.setCodcon(0);
            else
                tabvar.setCodcon(Integer.parseInt(campoCodigoContable.getText()));
            
            if(campoCorrelativo.getText().isEmpty())
                tabvar.setCorrel(0);
            else
                tabvar.setCorrel(Integer.parseInt(campoCorrelativo.getText()));            
            
            if(campoMonto1.formatoNumerico.getText().isEmpty())
                tabvar.setMonto(0);
            else
                tabvar.setMonto(Double.parseDouble(campoMonto1.formatoNumerico.getText()));
            
            if(campoMonto2.formatoNumerico.getText().isEmpty())
                tabvar.setMonto2(0);
            else
                tabvar.setMonto2(Double.parseDouble(campoMonto2.formatoNumerico.getText()));
                        
            if(campoDate1.getDate() != null)
                tabvar.setFecha(new Fecha().getFecha(campoDate1.getDate(), "yyyy-MM-dd"));
            else
                tabvar.setFecha(null);
            
            if(campoDate2.getDate() != null)
                tabvar.setFecha2(new Fecha().getFecha(campoDate2.getDate(), "yyyy-MM-dd"));
            else
                tabvar.setFecha2(null);
            
            System.out.println("la tabvar es: "+tabvar.toString());
            if(CTabvar.guardarTabvar(tabvar)){
                JOptionPane.showMessageDialog(iuPrincipal, "se ha guardado un nuevo registro de TABVAR correctamente...!");
                limpiarCampos();                
            }
        }
    }
    private void setEventos(){
        botonCerrar.addActionListener((ActionEvent e) -> {
            dispose();
        });
        botonLimpiar.addActionListener((ActionEvent e) -> {
            limpiarCampos();
        });
        botonGrabar.addActionListener((ActionEvent e) -> {
            guardarNuevoRegistro();
        });
        botonModificar.addActionListener((ActionEvent e) -> {
            modificarDatosRegistro();
        });
        botonEliminar.addActionListener((ActionEvent e) -> {
            eliminarRegistro();
        });
        botonMostrar.addActionListener((ActionEvent e) -> {
            mostrarTabla();
        });
        
        campoNumero.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if(!campoTipo.getText().isEmpty()){
                    if(!campoNumero.getText().isEmpty()){
                        int tipo = Integer.parseInt(campoTipo.getText());
                        int numero = Integer.parseInt(campoNumero.getText());
                        if(tipo > 0 && numero > 0){
                            
                            Tabvar tabvar = CTabvar.getTabvar(tipo, numero);
                            if(tabvar == null){
                                setCrearNuevoTabvar();
                            }else{
                                mostrarDatosTabvar(tabvar);
                            }
                        }
                    }
                }
            }
        });
    }
}

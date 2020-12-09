/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view;

import SIGU.botones.IUBoton;
import SIGU.campoTexto.IUCampoTexto;
import SIGU.comboBox.IUComboBox;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.paneles.IUPanel;
import SIGU.recursos.Area;
import SIGU.recursos.Fecha;
import SIGU.ventanas.IUSecundario;
import com.siscon.controller.CLogueo;
import com.siscon.model.Usuario;
import com.siscon.recursos.Ayuda;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class VNuevoUsuario extends IUSecundario{
    
    private VPrincipal ventanaPrincipal;
    
    private IUPanel panel;
        private IUPanel panelTitulo;
            private IUEtiqueta iuTitulo;

        private IUPanel panelDatos;
            private IUPanel panelContenedorDatos;
                private IUEtiqueta etiquetaRAZSOC;
                private IUCampoTexto campoRAZSOC;
                private IUEtiqueta etiquetaNUMERO;
                private IUComboBox campoNumero;
                private IUEtiqueta etiquetaNIVEL;
                private IUCampoTexto campoNIVEL;
                private IUEtiqueta etiquetaFECHA;
                private JDateChooser campoFECHA;
                private IUEtiqueta etiquetaTIPCAM;
                private IUCampoTexto campoTIPCAM;
                private IUEtiqueta etiquetaUNIDAD;
                private IUEtiqueta etiquetaDIRECCION;
                private IUCampoTexto campoDIRECCION;
                private IUEtiqueta etiquetaCODIGO;
                private IUCampoTexto campoCODIGO;
                private IUEtiqueta etiquetaNUMNIT;
                private IUCampoTexto campoNUMNIT;
                
                private IUBoton botonEsc;
                private IUBoton botonLimpiar;
                private IUBoton botonGrabar;
            
        private IUPanel panelBotones;
        private IUPanel panelMensajes;
            private IUPanel panelContenedorMensajes;
                private IUEtiqueta iuTituloMensajes;
                private IUPanel iuPanelMensajes;
                private IUEtiqueta iuMensajes;
    
    public VNuevoUsuario(VPrincipal ventanaPrincipal, String titulo, String tipoSize) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        
        construirPanel(new Area(An()-6, Al()-29));
        setEventos();
    }
    private void construirPanel(Area a){
        panel = new IUPanel(this, new Area(a.X(), a.Y(), a.An(), a.Al()), true);
        construirPaneles(new Area(2, 2, panel.area.An() - 4, panel.area.Al() - 10));
    }
    private void construirPaneles(Area a){
        panelTitulo = new IUPanel(panel, new Area(a.X(), a.Y(), a.An(), a.AlP(7)), true, Ayuda.COLOR_FONDO);
        construirPanelTitulo(new Area(2, 2, panelTitulo.area.An() - 4, panelTitulo.area.Al() - 4));
        
        panelDatos = new IUPanel(panel, new Area(a.X(), a.Y(2) + a.AlP(7), a.An(), a.AlP(80)), true, Color.WHITE);
        construirPanelDatos(new Area(panelDatos.area.AnP(25), panelDatos.area.AnP(5), panelDatos.area.An() - panelDatos.area.AnP(25)*2, panelDatos.area.Al() - 2*panelDatos.area.AnP(5)));
                        
        panelMensajes = new IUPanel(panel, new Area(a.X(), a.Y(4) + a.AlP(87), a.An(), a.AlP(13)), true, Ayuda.COLOR_FONDO);
        construirPanelMensajes(new Area(panelMensajes.area.AnP(1), 2, panelMensajes.area.An() - panelMensajes.area.AnP(1)*2, panelMensajes.area.Al() - 4));
    }
    private void construirPanelTitulo(Area a){
        iuTitulo = new IUEtiqueta(panelTitulo, "REGISTRO UNICO DE LA TABLA USUARIO", new Area(a.X(), a.Y(), a.An(), a.Al()), 20, "CENTER", Ayuda.COLOR_ROJO);
    }
    private void construirPanelDatos(Area a){
        panelContenedorDatos = new IUPanel(panelDatos, new Area(a.X(), a.Y(), a.An(), a.Al()), true, Ayuda.COLOR_FONDO);
        construirPanelContenedorDatos(new Area(10, 10, panelContenedorDatos.area.An() - 40, panelContenedorDatos.area.Al() - 60));
    }
    private boolean noExiteCamposVacios(){
        boolean verificador = false;
        if(!campoRAZSOC.getText().isEmpty())
            if(!campoNumero.getSelectedItem().toString().isEmpty())
                if(!campoTIPCAM.getText().isEmpty())
                    if(!campoDIRECCION.getText().isEmpty())
                        if(!campoCODIGO.getText().isEmpty())
                            if(!campoNUMNIT.getText().isEmpty())
                                verificador = true;
        return verificador;
    }
    private void grabarUsuario(){
        Usuario u = new Usuario(0);
        u.setRazsoc(campoRAZSOC.getText());
        u.setNumusu(Integer.parseInt(campoNumero.getSelectedItem().toString()));
        u.setFecusu(new Fecha().getFecha(campoFECHA.getDate(), "yyyy-MM-dd"));
        u.setTipcam(Double.parseDouble(campoTIPCAM.getText()));
        u.setDirraz(campoDIRECCION.getText());
        u.setCodjjc(Integer.parseInt(campoCODIGO.getText()));
        u.setNumnit(Long.parseLong(campoNUMNIT.getText()));
        if(CLogueo.guardarUsuario(u)){
            JOptionPane.showMessageDialog(ventanaPrincipal, "CORRECTO, se ha guardado en la Base de Datos el NUEVO REGISTRO USUARIO...!");
            setEstado(true);
            dispose();
        }else
            JOptionPane.showMessageDialog(ventanaPrincipal, "ATENCION: ERROR AL TRATAR DE GUARDAR LOS DATOS...!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
    }
    private void limpiarCampos(){
        campoRAZSOC.setText("");
        campoNumero.setSelectedIndex(0);
        campoFECHA.setCalendar(null);
        campoTIPCAM.setText("");
        campoDIRECCION.setText("");
        campoCODIGO.setText("");
        campoNUMNIT.setText("");
        campoRAZSOC.requestFocus();
    }
    private void construirPanelContenedorDatos(Area a){
        etiquetaRAZSOC = new IUEtiqueta(panelContenedorDatos, "Razon Social", new Area(a.X(), a.Y(2), a.An(), a.AlP(7)), 16, "LEFT", true);
        campoRAZSOC = new IUCampoTexto(panelContenedorDatos, 50, 16, new Area(a.X(), a.Y(2) + a.AlP(7), a.An(), a.AlP(7)), SwingConstants.LEFT);
        
        etiquetaNUMERO = new IUEtiqueta(panelContenedorDatos, "Numero", new Area(a.X(), a.Y(4) + a.AlP(14), a.AnP(15), a.AlP(7)), 16, "LEFT", true);
        campoNumero = new IUComboBox(panelContenedorDatos, Ayuda.getListColumnas("NUMERO", "SELECT NUMERO FROM TABVAR WHERE TIPO = 99"), new Area(a.X(), a.Y(4) + a.AlP(21), a.AnP(15), a.AlP(7)), 16, 1);
        
        etiquetaNIVEL = new IUEtiqueta(panelContenedorDatos, "Nivel de Acceso", new Area(a.X(2) + a.AnP(20), a.Y(4) + a.AlP(14), a.AnP(40), a.AlP(7)), 16, "LEFT", true);
        campoNIVEL = new IUCampoTexto(panelContenedorDatos, Ayuda.getDatoCadena("DESCRI", "SELECT DESCRI FROM TABVAR WHERE TIPO = 99 AND NUMERO = "+Integer.parseInt(campoNumero.getSelectedItem().toString())), 16, new Area(a.X(2) + a.AnP(20), a.Y(4) + a.AlP(21), a.AnP(40), a.AlP(7)));
        campoNIVEL.setEditar(false);
        
        etiquetaFECHA = new IUEtiqueta(panelContenedorDatos, "Fecha de Acceso", new Area(a.X(), a.Y(6) + a.AlP(28), a.AlP(40), a.AlP(7)), 16, "LEFT", true);
        campoFECHA = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        campoFECHA.setBounds(a.X(), a.Y(6) + a.AlP(35), a.AlP(40), a.AlP(7));        
        campoFECHA.getDateEditor().getUiComponent().setFont(new Font("Verdana", Font.PLAIN, 16));
        campoFECHA.getDateEditor().getUiComponent().setForeground(Ayuda.COLOR_TEXTO);
        campoFECHA.getCalendarButton().setVisible(true);
        panelContenedorDatos.add(campoFECHA);
        
        etiquetaTIPCAM = new IUEtiqueta(panelContenedorDatos, "Tipo Cambio", new Area(a.X(2) + a.AnP(40), a.Y(6) + a.AlP(28), a.AnP(25), a.AlP(7)), 16, "LEFT", true);
        campoTIPCAM = new IUCampoTexto(panelContenedorDatos, 8, 16, new Area(a.X(2) + a.AnP(40), a.Y(6) + a.AlP(35), a.AnP(25), a.AlP(7)), SwingConstants.LEFT);
        //campoTIPCAM.setRestriccionNumeroDecimal(4);
        etiquetaUNIDAD = new IUEtiqueta(panelContenedorDatos, "Bs/$us", new Area(a.X(2) + a.AnP(65), a.Y(6) + a.AlP(35), a.AnP(15), a.AlP(7)), 16, "CENTER", true);
        
        etiquetaDIRECCION = new IUEtiqueta(panelContenedorDatos, "Direccion", new Area(a.X(), a.Y(8) + a.AlP(42), a.An(), a.AlP(7)), 16, "LEFT", true);
        campoDIRECCION = new IUCampoTexto(panelContenedorDatos, 50, 16, new Area(a.X(), a.Y(8) + a.AlP(49), a.An(), a.AlP(7)), SwingConstants.LEFT);
        campoDIRECCION.setRestriccion("[\\p{Alpha}\\p{Alnum}\\p{Space}\\.\\/\\(\\)\\-]");
        
        etiquetaCODIGO = new IUEtiqueta(panelContenedorDatos, "Codigo JJC", new Area(a.X(), a.Y(10) + a.AlP(56), a.AnP(35), a.AlP(7)), 16, "LEFT", true);
        campoCODIGO = new IUCampoTexto(panelContenedorDatos, 6, 16, new Area(a.X(), a.Y(10) + a.AlP(63), a.AnP(35), a.AlP(7)), SwingConstants.LEFT);
        campoCODIGO.setRestriccion("^([0-9]|[1-9][0-9])$");
        
        etiquetaNUMNIT = new IUEtiqueta(panelContenedorDatos, "Numero Nit", new Area(a.X(3) + a.AnP(35), a.Y(10) + a.AlP(56), a.AnP(41), a.AlP(7)), 16, "LEFT", true);
        campoNUMNIT = new IUCampoTexto(panelContenedorDatos, 10, 16, new Area(a.X(3) + a.AnP(35), a.Y(10) + a.AlP(63), a.AnP(41), a.AlP(7)), SwingConstants.LEFT);
        campoNUMNIT.setRestriccion("^([0-9]|[1-9][0-9])$");
        
        botonGrabar = new IUBoton(panelContenedorDatos, new Area(a.X() + a.AnP(65), a.Y(8) + a.AlP(82), a.AnP(35), a.AlP(10)), "Grabar", "/imagenes/save.png", 16, 32, 12, SwingConstants.RIGHT, SwingConstants.CENTER, ' ', "");
        botonGrabar.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ENTER, 0 ), "ENTER" );
        botonGrabar.setVisible(false);
        
        botonLimpiar = new IUBoton(panelContenedorDatos, new Area(a.X() + a.AnP(30), a.Y(8) + a.AlP(82), a.AnP(30), a.AlP(10)), "Limpiar", "/imagenes/update.png", 16, 32, 12, SwingConstants.RIGHT, SwingConstants.CENTER, ' ', "");
        botonLimpiar.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_F3, 0 ), "F3" );
        
        botonEsc = new IUBoton(panelContenedorDatos, new Area(a.X(2), a.Y(8) + a.AlP(82), a.AnP(22), a.AlP(10)), "Salir", "/imagenes/cerrar.png", 16, 32, 12, SwingConstants.RIGHT, SwingConstants.CENTER, ' ', "");
        botonEsc.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "Esc" );
    }
    private void construirPanelMensajes(Area a){
        panelContenedorMensajes = new IUPanel(panelMensajes, new Area(a.X(), a.Y(), a.An(), a.Al()), false, Ayuda.COLOR_FONDO);
        construirPanelContenedorMensajes(new Area(4, 2, panelContenedorMensajes.area.An() - 8, panelContenedorMensajes.area.Al() - 6));
    }
    private void construirPanelContenedorMensajes(Area a){
        iuTituloMensajes = new IUEtiqueta(panelContenedorMensajes, "MENSAJES - INSTRUCCIONES", new Area(a.X(), a.Y(), a.An(), a.AlP(30)), 16, "CENTER", Ayuda.COLOR_ROJO);
        iuPanelMensajes = new IUPanel(panelContenedorMensajes, new Area(a.X(), a.Y(2) + a.AlP(30), a.An(), a.AlP(60)), true, Ayuda.COLOR_FONDO);
        iuMensajes = new IUEtiqueta(iuPanelMensajes, "", new Area(iuPanelMensajes.area.An(), iuPanelMensajes.area.Al()), 16, "LEFT", false);
    }
    private void setEventos(){
        campoNumero.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String dato = e.getItem().toString();
                campoNIVEL.setText(Ayuda.getDatoCadena("DESCRI", "SELECT DESCRI FROM TABVAR WHERE TIPO = 99 AND NUMERO = "+dato));
            }
        });
        botonGrabar.getActionMap().put( "ENTER", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                botonGrabar.doClick();
                if(noExiteCamposVacios())
                    grabarUsuario();
                else
                    JOptionPane.showMessageDialog(ventanaPrincipal, "ATENCION: Existen CAMPOS de DATOS VACIOS...!", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
        });
        botonLimpiar.getActionMap().put( "F3", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                botonLimpiar.doClick();
                limpiarCampos();
            }
        });
        botonEsc.getActionMap().put( "Esc", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                botonEsc.doClick();
                dispose();                
            }
        });
        campoRAZSOC.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoRAZSOC();
            }
        });
        campoNumero.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoNUMERO();
            }
        });
        campoFECHA.getDateEditor().getUiComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoFECHA();
            }
        });
        campoTIPCAM.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoTIPCAM();
            }
        });
        campoDIRECCION.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoDIRECCION();
            }
        });
        campoCODIGO.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoCODIGO();
            }
        });
        campoNUMNIT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoNUMNIT();
            }
        });
    }
    private void resetMensajes(){
        iuPanelMensajes.setBackground(Ayuda.COLOR_FONDO);
        iuMensajes.setText("");        
    }
    private void editarCampos(String CAMPO, boolean opcion){
        switch(CAMPO){
            case "RAZSOC":
                campoRAZSOC.setEditar(opcion);
                campoNumero.setEditar(false);
                campoFECHA.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA.getDateEditor().getUiComponent().setEnabled(false);
                campoTIPCAM.setEditar(false);
                campoDIRECCION.setEditar(false);
                campoCODIGO.setEditar(false);
                campoNUMNIT.setEditar(false);                
            break;
            case "NUMERO":
                campoRAZSOC.setEditar(false);
                campoNumero.setEditar(opcion);
                campoFECHA.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA.getDateEditor().getUiComponent().setEnabled(false);
                campoTIPCAM.setEditar(false);
                campoDIRECCION.setEditar(false);
                campoCODIGO.setEditar(false);
                campoNUMNIT.setEditar(false);
            break;
            case "FECHA":
                campoRAZSOC.setEditar(false);
                campoNumero.setEditar(false);
                campoFECHA.getDateEditor().getUiComponent().setFocusable(opcion);
                campoFECHA.getDateEditor().getUiComponent().setEnabled(opcion);
                campoTIPCAM.setEditar(false);
                campoDIRECCION.setEditar(false);
                campoCODIGO.setEditar(false);
                campoNUMNIT.setEditar(false);
            break;
            case "TIPCAM":
                campoRAZSOC.setEditar(false);
                campoNumero.setEditar(false);
                campoFECHA.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA.getDateEditor().getUiComponent().setEnabled(false);
                campoTIPCAM.setEditar(opcion);
                campoDIRECCION.setEditar(false);
                campoCODIGO.setEditar(false);
                campoNUMNIT.setEditar(false);
            break;
            case "DIRRAZ":
                campoRAZSOC.setEditar(false);
                campoNumero.setEditar(false);
                campoFECHA.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA.getDateEditor().getUiComponent().setEnabled(false);
                campoTIPCAM.setEditar(false);
                campoDIRECCION.setEditar(opcion);
                campoCODIGO.setEditar(false);
                campoNUMNIT.setEditar(false);
            break;
            case "CODJJC":
                campoRAZSOC.setEditar(false);
                campoNumero.setEditar(false);
                campoFECHA.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA.getDateEditor().getUiComponent().setEnabled(false);
                campoTIPCAM.setEditar(false);
                campoDIRECCION.setEditar(false);
                campoCODIGO.setEditar(opcion);
                campoNUMNIT.setEditar(false);
            break;
            case "NUMNIT":
                campoRAZSOC.setEditar(false);
                campoNumero.setEditar(false);
                campoFECHA.getDateEditor().getUiComponent().setFocusable(false);
                campoFECHA.getDateEditor().getUiComponent().setEnabled(false);
                campoTIPCAM.setEditar(false);
                campoDIRECCION.setEditar(false);
                campoCODIGO.setEditar(false);
                campoNUMNIT.setEditar(opcion);
            break;
        }
    }
    private void focoCampoRAZSOC(){        
        resetMensajes();
        iuMensajes.setText("Campo RAZON SOCIAL: Digite hasta 50 Caracteres Alpha Numeric.  [Enter] para Avanzar, [F2] para Retroceder");
        campoRAZSOC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!campoRAZSOC.getText().isEmpty()){
                        campoRAZSOC.transferFocus();
                    }else
                        iuPanelMensajes.setBackground(Ayuda.COLOR_ATENCION);
                }
                if(KeyEvent.VK_ESCAPE == e.getKeyCode()){
                    if(!campoRAZSOC.getText().isEmpty()){
                        campoRAZSOC.transferFocusBackward();
                    }else
                        iuPanelMensajes.setBackground(Ayuda.COLOR_ATENCION);
                }
            }
        });
    }
    private void focoCampoNUMERO(){
        resetMensajes();
        iuMensajes.setText("Campo NUMERO: Elija un NUMERO del 1-4.  [Enter] para Avanzar, [F2] para Retroceder");
        campoNumero.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    campoNumero.transferFocus();
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    campoNumero.transferFocusBackward();                    
                }
            }
        });
    }
    private void focoCampoFECHA(){
        resetMensajes();
        iuMensajes.setText("Campo FECHA: digite una fecha del tipo, dd/MM/yyyy. [Enter] para Avanzar, [F2] para Retroceder");        
        campoFECHA.getDateEditor().getUiComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    try {
                        if(!new Fecha().getFecha(campoFECHA.getDate(), "dd/MM/yyyy").isEmpty()){
                            campoFECHA.getDateEditor().getUiComponent().transferFocus();
                        }else
                            iuPanelMensajes.setBackground(Ayuda.COLOR_ATENCION);                    
                    } catch (Exception ex) {iuPanelMensajes.setBackground(Ayuda.COLOR_ATENCION);}
                    
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    try {
                        if(!new Fecha().getFecha(campoFECHA.getDate(), "dd/MM/yyyy").isEmpty()){
                            campoFECHA.getDateEditor().getUiComponent().transferFocusBackward();
                        }else
                            iuPanelMensajes.setBackground(Ayuda.COLOR_ATENCION);
                    } catch (Exception er) {iuPanelMensajes.setBackground(Ayuda.COLOR_ATENCION);}
                }
            }
        });
    }
    private void focoCampoTIPCAM(){
        resetMensajes();
        iuMensajes.setText("Campo TIPO CAMBIO: digite un numero con decimales.  [Enter] para Avanzar, [F2] para Retroceder");
        campoTIPCAM.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    campoTIPCAM.transferFocus();
                }
            }
        });
    }
    private void focoCampoDIRECCION(){
        resetMensajes();
        iuMensajes.setText("Campo DIRECCION: escriba una direccion de la empresa. hasta 50 caracteres alpha numeric. [Enter] para Avanzar, [F2] para Retroceder");
        campoDIRECCION.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!campoDIRECCION.getText().isEmpty())
                        campoDIRECCION.transferFocus();
                    else
                        iuPanelMensajes.setBackground(Ayuda.COLOR_ATENCION);
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    if(!campoDIRECCION.getText().isEmpty())
                        campoDIRECCION.transferFocusBackward();
                    else
                        iuPanelMensajes.setBackground(Ayuda.COLOR_ATENCION);
                }
            }
        });
    }
    private void focoCampoCODIGO(){
        resetMensajes();
        iuMensajes.setText("Campo CODIGO: escriba numeros enteros hasta 6 digitos. [Enter] para Avanzar, [F2] para Retroceder");
        campoCODIGO.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!campoCODIGO.getText().isEmpty()){
                        campoCODIGO.transferFocus();
                    }else{
                        iuPanelMensajes.setBackground(Ayuda.COLOR_ATENCION);
                    }
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    if(!campoCODIGO.getText().isEmpty())
                        campoCODIGO.transferFocusBackward();
                    else
                        iuPanelMensajes.setBackground(Ayuda.COLOR_ATENCION);
                }
            }
        });
    }
    private void focoCampoNUMNIT(){
        resetMensajes();
        iuMensajes.setText("Campo NUMERO NIT : digite numeros enteros hasta 10 digitos. [Enter] para Avanzar, [F2] para Retroceder");
        campoNUMNIT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!campoNUMNIT.getText().isEmpty()){
                        iuMensajes.setText("[F3] = Limpiar Campos, [Enter] = Grabar, guarda en la Base de Datos el NUEVO REGISTRO USUARIO.");
                        botonGrabar.setVisible(true);
                        editarCampos("NUMNIT", false);
                    }else
                        iuPanelMensajes.setBackground(Ayuda.COLOR_ATENCION);
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    if(!campoNUMNIT.getText().isEmpty())
                        campoNUMNIT.transferFocusBackward();
                    else
                        iuPanelMensajes.setBackground(Ayuda.COLOR_ATENCION);
                }
            }
        });
    }
}

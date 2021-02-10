/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view;

import SIGU.botones.IUBoton;
import SIGU.campoTexto.IUCampoPrivado;
import SIGU.campoTexto.IUCampoTexto;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.etiquetas.IUEtiquetaI;
import SIGU.paneles.IUPanel;
import SIGU.recursos.Area;
import SIGU.recursos.Fecha;
import SIGU.ventanas.IUSecundario;
import com.siscon.controller.CLogueo;
import com.siscon.controller.CPrincipal;
import com.siscon.controller.CTabvar;
import com.siscon.model.Tabvar;
import com.siscon.model.Usuario;
import com.siscon.recursos.Ayuda;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author neo
 */
public class VLogueo extends IUSecundario{
    
    private VPrincipal ventanaPrincipal;
    
    private IUPanel panel;
        private IUPanel panelTitulo;
        private IUEtiqueta iuTitulo;
    
    private IUEtiquetaI imagenLogo;
        
    private IUPanel panelDatos;
        private IUPanel panelContenedor;
            private IUEtiqueta etiquetaUsuario;
            private IUCampoTexto campoUsuario;
            private IUCampoTexto campoNivel;
            private IUEtiqueta etiquetaClave;
            private IUCampoPrivado campoClave;
            private IUEtiqueta etiquetaFecha;
            private JDateChooser campoFecha = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
            private IUEtiqueta etiquetaTipoCambio;
            private IUCampoTexto campoTipoCambio;
            private IUEtiqueta etiquetaUnidad;
            private IUBoton botonEsc;
            private IUBoton botonIngresar;
            private IUBoton botonLimpiar;
            private IUBoton botonRegistrarUsuario;
        
    private IUPanel panelMensajes;
        private IUPanel panelContenedorMensajes;
            private IUEtiqueta iuTituloMensajes;
            private IUPanel iuPanelMensajes;
            private IUEtiqueta iuMensajes;    
    private Tabvar tabvar;
    private Usuario usuario;
    
    public VLogueo(VPrincipal ventanaPrincipal, String titulo, String tipoSize) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        this.tabvar = null;
        this.usuario = null;
        construirPaneles(new Area(An()-6, Al()-29));
        setEventos();
        iniciarAlgoritmo();
    }
    private void construirPaneles(Area a){
        panel = new IUPanel(this, new Area(a.X(), a.Y(), a.An(), a.Al()), true);
        construirPanel(new Area(2, 2, panel.area.An() - 4, panel.area.Al() - 8));
    }
    private void construirPanel(Area a){
        panelTitulo = new IUPanel(panel, new Area(a.X(), a.Y(), a.An(), a.AlP(8)), true, Ayuda.COLOR_FONDO);
        construirPanelTitulo(new Area(10, 3, panelTitulo.area.An() - 40, panelTitulo.area.Al() - 9));
        
        imagenLogo = new IUEtiquetaI(panel, new Area(a.X(), a.Y() + a.AlP(8), a.AnP(10), a.AlP(18)), "/imagenes/imagenLogo.png");
        
        panelDatos = new IUPanel(panel, new Area(a.X(), a.Y(2) + a.AlP(8), a.An(), a.AlP(65)), false);
        construirPanelDatos(new Area(a.AnP(35), a.AlP(15), (panelDatos.area.An() - 2*a.AnP(35)), (panelDatos.area.Al() - 2*a.AlP(15))));
        
        panelMensajes = new IUPanel(panel, new Area(a.X(), a.Y(3) + a.AlP(73), a.An(), a.AlP(27)), true, Ayuda.COLOR_FONDO);
        construirPanelMensajes(new Area(panelMensajes.area.AnP(10), panelMensajes.area.AlP(5), panelMensajes.area.An() - panelMensajes.area.AnP(10)*2, panelMensajes.area.Al() - panelMensajes.area.AlP(5)*2));
    }
    private void construirPanelTitulo(Area a){
        iuTitulo = new IUEtiqueta(panelTitulo, "JJCR & ASOCIADOS S.R.L.", new Area(a.X(), a.Y(), a.AnP(25), a.AlP(50)), 18, "LEFT", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "CONTROL DE ACCESO AL SISTEMA", new Area(a.X(2) + a.AnP(30), a.Y(2) + a.AlP(40), a.AnP(40), a.AlP(50)), 18, "CENTER", false);
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "SISTEMA DE CONTABILIDAD", new Area(a.X(3) + a.AnP(65), a.Y(), a.AnP(35), a.AlP(50)), 18, "RIGHT", false); 
        
        iuTitulo = new IUEtiqueta(panelTitulo, "SISCON @v7.1. 2020", new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(50), a.AnP(40), a.AlP(50)), 18, "RIGHT", false);
    }
    private void construirPanelDatos(Area a){
        panelContenedor = new IUPanel(panelDatos, new Area(a.X(), a.Y(), a.An(), a.Al()), true, Ayuda.COLOR_FONDO);
        construirPanelContenedor(new Area(panelContenedor.area.AnP(5), panelContenedor.area.AlP(5), panelContenedor.area.An() - panelContenedor.area.AnP(5)*3, panelContenedor.area.Al() - panelContenedor.area.AlP(5)*2));
    }
    private void construirPanelContenedor(Area a){
        etiquetaUsuario = new IUEtiqueta(panelContenedor, "USUARIO: ", new Area(a.X(), a.Y(), a.AnP(35), a.AlP(10)), 16, "LEFT", false);
        campoUsuario = new IUCampoTexto(panelContenedor, 1, 16, new Area(a.X() + a.AnP(35), a.Y(), a.AnP(10), a.AlP(10)), SwingConstants.LEFT);
        campoUsuario.setRestriccion("^([0-9]|[1-9][0-9])$");        
        campoNivel = new IUCampoTexto(panelContenedor, "", 16, new Area(a.X() + a.AnP(35), a.Y() + a.AlP(10), a.AnP(60) + a.X(), a.AlP(10)));        
        campoNivel.setEditar(false);
        
        etiquetaClave = new IUEtiqueta(panelContenedor, "CLAVE: ", new Area(a.X(), a.Y(2) + a.AlP(20), a.AnP(35), a.AlP(10)), 16, "LEFT", false);        
        campoClave = new IUCampoPrivado(panelContenedor, 8, 16, new Area(a.X() + a.AnP(35), a.Y(2) + a.AlP(20), a.AnP(65), a.AlP(10)));
                
        etiquetaFecha = new IUEtiqueta(panelContenedor, "FECHA: ", new Area(a.X(), a.Y(3) + a.AlP(30), a.AnP(35), a.AlP(10)), 16, "LEFT", false);
        campoFecha.setBounds(a.X() + a.AnP(35), a.Y(3) + a.AlP(30), a.AnP(55), a.AlP(10));        
        campoFecha.getDateEditor().getUiComponent().setFont(new Font("Verdana", Font.PLAIN, 16));
        campoFecha.getDateEditor().getUiComponent().setForeground(Ayuda.COLOR_TEXTO);
        campoFecha.getCalendarButton().setVisible(false);
        campoFecha.getDateEditor().getUiComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {                
                if(KeyEvent.VK_F2 == e.getKeyCode())
                    campoFecha.getDateEditor().getUiComponent().transferFocusBackward();
            }
        });        
        panelContenedor.add(campoFecha);
        
        etiquetaTipoCambio = new IUEtiqueta(panelContenedor, "T.C.: ", new Area(a.X(), a.Y(4) + a.AlP(40), a.AnP(35), a.AlP(10)), 16, "LEFT", false);
        campoTipoCambio = new IUCampoTexto(panelContenedor, 8, 16, new Area(a.X() + a.AnP(35), a.Y(4) + a.AlP(40), a.AnP(35), a.AlP(10)), SwingConstants.LEFT);
        //campoTipoCambio.setRestriccionNumeroDecimal(4);
        
        etiquetaUnidad = new IUEtiqueta(panelContenedor, "Bs/$us", new Area(a.X() + a.AnP(70), a.Y(4) + a.AlP(40), a.AnP(30), a.AlP(10)), 16, "LEFT", false);
        
        botonEsc = new IUBoton(panelContenedor, new Area(a.X(), a.Y(5) + a.AlP(60), a.AnP(40), a.AlP(15)), "Esc", "/imagenes/cerrar.png", 16, 30, 10, SwingConstants.RIGHT, SwingConstants.CENTER, 'E', "");
        botonEsc.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "ESC" );
        
        botonIngresar = new IUBoton(panelContenedor, new Area(a.X(2) + a.AnP(60) , a.Y(5) + a.AlP(60), a.AnP(40), a.AlP(15)), "Aceptar", "/imagenes/aceptar.png", 16, 30, 10, SwingConstants.RIGHT, SwingConstants.CENTER, 'A', "");
        botonIngresar.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ENTER, 0 ), "ENTER" );
        botonIngresar.setVisible(false);
        
        botonLimpiar = new IUBoton(panelContenedor, new Area(a.X(2) + a.AnP(60) , a.Y(5) + a.AlP(60), a.AnP(40), a.AlP(15)), "F3", "/imagenes/update.png", 16, 30, 10, SwingConstants.RIGHT, SwingConstants.CENTER, 'F', "");
        botonLimpiar.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_F3, 0 ), "F3" );
        
        botonRegistrarUsuario = new IUBoton(panelContenedor, new Area(a.X(), a.Y(5) + a.AlP(60), a.An() + a.X(), a.AlP(15)), "Registrar Nuevo Usuario", "/imagenes/nuevo.png", 16, 30, 10, SwingConstants.RIGHT, SwingConstants.CENTER, '}', "");
        botonRegistrarUsuario.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ENTER, 0 ), "ENTER" );
        botonRegistrarUsuario.setVisible(false);
    }
    private void estadoCampos(boolean estadoCampos){
        campoUsuario.setEditar(estadoCampos);
        campoClave.setEditar(estadoCampos);
        campoFecha.getDateEditor().getUiComponent().setEnabled(estadoCampos);
        campoFecha.getDateEditor().getUiComponent().setFocusable(estadoCampos);
        campoTipoCambio.setEditar(estadoCampos);
    }
    private void limpiarDatos(){
        campoUsuario.setText("");
        campoUsuario.requestFocus();
        
        campoNivel.setText("");
        campoClave.setText("");
        campoFecha.setCalendar(null);
        campoTipoCambio.setText("");
    }
    private void resetearMensaje(){
        iuMensajes.setText("");
        iuPanelMensajes.setBackground(Ayuda.COLOR_FONDO);        
    }
    private void iniciarAlgoritmo(){
        if(CLogueo.getUsuario() != null){
            borrarBotonRegistroUsuario(true);
            estadoCampos(true);
            limpiarDatos();
            
        }else{
            estadoCampos(false);
            borrarBotonRegistroUsuario(false);            
        }
    }
    private boolean noExisteCamposVacios(){
        boolean verificador = false;
        if(!campoUsuario.getText().isEmpty()){
            if(!Ayuda.getParseCadena(campoClave.getPassword()).isEmpty()){
                if(campoFecha.getCalendar() != null){
                    if(!campoTipoCambio.getText().isEmpty()){
                        verificador = true;
                    }else{
                        JOptionPane.showMessageDialog( this , "Campo Tipo Cambio: EMPTY, No puede estar VACIO el campo TIPO CAMBIO.", "Advertencia" , JOptionPane.WARNING_MESSAGE );
                    }
                }else{
                    JOptionPane.showMessageDialog( this , "Campo Fecha: EMPTY - NULL, No puede estar VACIO o NULL el campo FECHA.", "Advertencia" , JOptionPane.WARNING_MESSAGE );
                }                
            }else{
                JOptionPane.showMessageDialog( this , "Campo Clave: EMPTY, No puede estar VACIO el campo CLAVE.", "Advertencia" , JOptionPane.WARNING_MESSAGE );
            }
        }else{
            JOptionPane.showMessageDialog( this , "Campo Usuario: EMPTY, No puede estar VACIO el campo USUARIO.", "Advertencia" , JOptionPane.WARNING_MESSAGE );
        }
        return verificador;
    }
    private void setEventos(){
        campoUsuario.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {                
                focoCampoUsuario();
            }
        });
        campoClave.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoClave();
            }
        });
        campoFecha.getDateEditor().getUiComponent().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoFecha();
            }
        });
        campoTipoCambio.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                focoCampoTipoCambio();
            }
        });
        
        botonLimpiar.getActionMap().put( "F3", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                botonLimpiar.doClick();                
                limpiarDatos();
            }
        });
        botonIngresar.getActionMap().put( "ENTER", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                botonIngresar.doClick();                
                setEstado(true);
                dispose();
            }
        });
        botonEsc.getActionMap().put( "ESC", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                botonEsc.doClick();                
                setOpacity(0.6f);
                boolean resp = Ayuda.mensaje(ventanaPrincipal, "Esta seguro que desea salir del sistema SISCON", "pregunta");//JOptionPane.showConfirmDialog( ventanaPrincipal , "Está seguro que desea salir del sistema?" , "Confirmación" , JOptionPane.YES_NO_OPTION );                    
                if( resp )
                    dispose();
                setOpacity(1f);
            }
        });
        botonRegistrarUsuario.getActionMap().put( "ENTER", new AbstractAction(){
            @Override
            public void actionPerformed( ActionEvent e ){                
                botonRegistrarUsuario.doClick();                
                borrarBotonRegistroUsuario(true);
                registrarNuevoUsuario();
            }
        });
    }    
    private void focoCampoUsuario(){
        resetearMensaje();
        iuMensajes.setText("Favor Identifiquese con su CODIGO de usuario o [Esc] Salir del Programa....");
        campoUsuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!campoUsuario.getText().isEmpty()){
                        int numero = Integer.parseInt(campoUsuario.getText());
                        if(numero > 0 && numero < 99){
                            tabvar = CTabvar.getTabvar(99, numero);
                            if(tabvar != null){
                                campoNivel.setText(tabvar.getDescri());
                                campoUsuario.transferFocus();
                            }                            
                        }else
                            iuPanelMensajes.setBackground(Ayuda.COLOR_ATENCION);
                    }else{
                        iuPanelMensajes.setBackground(Ayuda.COLOR_ATENCION);
                    }
                }
            }
        });
    }
    private void focoCampoClave(){
        resetearMensaje();
        iuMensajes.setText("Digite su CLAVE de ACCESO al Sistema.........[Enter]=Continua");
        campoClave.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    String clave = Ayuda.getParseCadena(campoClave.getPassword());
                    if(!clave.isEmpty() && !campoUsuario.getText().isEmpty()){
                        if(clave.equalsIgnoreCase(tabvar.getObserv())){
                            usuario = CLogueo.getUsuario();                            
                            campoFecha.setDate(new Fecha().getDate(usuario.getFecusu()));
                            campoTipoCambio.setText(String.valueOf(usuario.getTipcam()));
                            campoClave.transferFocus();
                        }else
                            Ayuda.mensaje(ventanaPrincipal, "Error: la clave de acceso no existe en la base de datos", "error");
                    }
                    iuPanelMensajes.setBackground(Ayuda.COLOR_ATENCION);
                }
            }
        });
    }
    private void focoCampoFecha(){
        resetearMensaje();
        iuMensajes.setText("Digite FECHA de PROCESO (DD/MM/AAAA),  F7=Fecha Actual de Hoy");
        campoFecha.getDateEditor().getUiComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!new Fecha().getFecha(campoFecha.getDate(), "dd/MM/yyyy").isEmpty()){
                        campoFecha.getDateEditor().getUiComponent().transferFocus();
                    }else
                        iuPanelMensajes.setBackground(Ayuda.COLOR_ATENCION);
                }
                if(KeyEvent.VK_F7 == e.getKeyCode()){
                    campoFecha.setDate(new Fecha().getDate(new Fecha().getFecha()));
                }
            }
        });
    }
    private void focoCampoTipoCambio(){
        resetearMensaje();
        iuMensajes.setText("Digite el TIPO de CAMBIO vigente en esta FECHA....");
        campoTipoCambio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(validarDatosEntrada()){
                        entrarSistema();
                    }
                }
            }
        });
    }
    private void entrarSistema(){
        deshabilitarCampos(false);
        botonLimpiar.setVisible(false);                
        botonIngresar.setVisible(true);
        botonIngresar.requestFocus();
        if(tabvar != null && usuario != null){
            setOpacity(0.5f);
            Ayuda.mensaje(ventanaPrincipal, "ACCESSO CORRECTO...! \nLa validacion ha sido un exito... ", "correcto");
            setOpacity(1f);        
        }        
    }
    private boolean validarDatosEntrada(){
        boolean verificador = false;
        if(!campoTipoCambio.getText().isEmpty()){
            if(noExisteCamposVacios()){      
                int numero = Integer.parseInt(campoUsuario.getText());
                if(numero > 0 && numero < 99){
                    String clave = Ayuda.getParseCadena(campoClave.getPassword());
                    if(clave.equalsIgnoreCase(tabvar.getObserv())){                        
                        verificador = true;
                    }else{
                        Ayuda.mensaje(ventanaPrincipal, "ERROR: LA CLAVE DE ACCESSO NO COINCIDE CON EL USUARIO....!", "error");
                        limpiarDatos();
                    }
                }else{
                    Ayuda.mensaje(ventanaPrincipal, "ERROR: EL NUMERO DE USUARIO NO CORRESPONDE A UN USUARIO ACTIVO EN EL SISTEMA....!", "error");
                    limpiarDatos();
                }
            }
        }else
            iuPanelMensajes.setBackground(Ayuda.COLOR_ATENCION);        
        return verificador;
    }
    private void deshabilitarCampos(boolean verificador){
        campoUsuario.setEditar(verificador);
        campoClave.setEditar(verificador);
        campoFecha.getDateEditor().getUiComponent().setFocusable(verificador);
        campoFecha.getDateEditor().getUiComponent().setEnabled(verificador);
        campoTipoCambio.setEditar(verificador);
    }
    private void construirPanelMensajes(Area a){
        panelContenedorMensajes = new IUPanel(panelMensajes, new Area(a.X(), a.Y(), a.An(), a.AlP(40)), false, Ayuda.COLOR_FONDO);
        construirPanelContenedorMensajes(new Area(4, 2, panelContenedorMensajes.area.An() - 8, panelContenedorMensajes.area.Al() - 6));
    }
    private void construirPanelContenedorMensajes(Area a){
        iuTituloMensajes = new IUEtiqueta(panelContenedorMensajes, "MENSAJES - INSTRUCCIONES", new Area(a.X(), a.Y(), a.An(), a.AlP(30)), 16, "CENTER", Ayuda.COLOR_ROJO);
        iuPanelMensajes = new IUPanel(panelContenedorMensajes, new Area(a.X(), a.Y(2) + a.AlP(30), a.An(), a.AlP(60)), true, Ayuda.COLOR_ATENCION);
        iuMensajes = new IUEtiqueta(iuPanelMensajes, "mensajes de instrucciones para el usuario", new Area(iuPanelMensajes.area.An(), iuPanelMensajes.area.Al()), 20, "LEFT", false);
    }
    private void registrarNuevoUsuario(){
        VNuevoUsuario iuNuevoUsuario = new VNuevoUsuario(ventanaPrincipal, "Registro de Datos - Tabla Usuario", "intermedio");
        iuNuevoUsuario.mostrarVentana();
        if(iuNuevoUsuario.getEstado()){            
            dispose();
            CPrincipal.main(null);            
        }else{
            borrarBotonRegistroUsuario(false);
        }  
    }
    private void borrarBotonRegistroUsuario(boolean verificador){
        if(verificador){
            iuPanelMensajes.setBackground(Ayuda.COLOR_FONDO);
            iuMensajes.setText("");
            botonEsc.setVisible(true);
            botonLimpiar.setVisible(true);
            botonRegistrarUsuario.setVisible(false);
        }else{
            botonRegistrarUsuario.setVisible(true);
            botonEsc.setVisible(false);
            botonLimpiar.setVisible(false);
            iuPanelMensajes.setBackground(Ayuda.COLOR_ATENCION);
            iuMensajes.setText("El sistema no encontro datos de la tabla USUARIO. PRESIONE [ENTER] para registrar un nuevo USUARIO...!");
        }
        
    }
    public Usuario getUsuario(){
        usuario.setUsername(campoNivel.getText());
        usuario.setPassword(campoUsuario.getText());
        usuario.setFecusu(new Fecha().getFecha());
        
        CLogueo.modificarUsuario(usuario);
        
        return usuario;
    }
    public Tabvar getTabvar(){
        return tabvar;
    }
}

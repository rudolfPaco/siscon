/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view.user;

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
import com.siscon.model.User;
import com.siscon.model.Usuario;
import com.siscon.recursos.Ayuda;
import com.siscon.view.VPrincipal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author neo
 */
public class VUsuario extends IUSecundario{
        
    private VPrincipal ventanaPrincipal;
    
    private IUPanel panel;
        private IUPanel panelTitulo;
        private IUEtiqueta iuTitulo;
    
    private IUPanel panelDatos;
        private IUPanel primerPanel;
            private IUPanel panelCampos;
                private IUPanelEtiqueta iuNro;
                private IUCampoTexto nro;            
                private IUPanelEtiqueta iuUsername;
                private IUCampoTexto username;
                private IUPanelEtiqueta iuPassword;
                private IUCampoTexto password;
            private IUPanel panelTabla;
                private IUTabla tabla;
        
        private IUPanel segundoPanel;
            private IUEtiqueta iuTituloMensaje;
            private IUPanelEtiqueta iuMensaje;
            private IUPanelEtiqueta iuInformacion;
            private IUCampoTexto campoS_N1;
            private IUCampoTexto campoS_N2;
            private IUCampoTexto campoS_N3;
            private IUCampoTexto campoS_N4;
            private IUCampoTexto campoS_N5;
            private IUCampoTexto campoS_N6;
            private IUCampoTexto campoS_N7;
    
    private final Usuario usuario;
    
    private User user;
    private int indice;
    
    public VUsuario(VPrincipal ventanaPrincipal, String titulo, String tipoSize, Usuario usuario) {
        super(ventanaPrincipal, titulo, tipoSize);
        this.ventanaPrincipal = ventanaPrincipal;
        this.usuario = usuario;
        this.indice = 1;
        this.user = null;
        
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
        iuTitulo = new IUEtiqueta(panelTitulo, "ADMINISTRACION DE USUARIOS", new Area(a.X(2) + a.AnP(25), a.Y(), a.AnP(35), a.AlP(50)), 16, "CENTER", false);        
        iuTitulo.setSubrayarTexto(true);
        //iuTitulo = new IUEtiqueta(panelTitulo, "Por: GRUPO - NIVEL", new Area(a.X(2) + a.AnP(25), a.Y(2) + a.AlP(45), a.AnP(35), a.AlP(50)), 16, "CENTER", false);                
        //iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "SISTEMA CONTABLE SISCON @v7.2. 2020", new Area(a.X(3) + a.AnP(60), a.Y(), a.AnP(40), a.AlP(50)), 16, "RIGHT", false); 
        iuTitulo = new IUEtiqueta(panelTitulo, new Fecha().getFecha1(), new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(45), a.AnP(40), a.AlP(50)), 16, "RIGHT", false); 
        
        //iuTitulo = new IUEtiqueta(panelTitulo, "REPORTE: EPC ", new Area(a.X(), a.Y(2) + a.AlP(45), a.AnP(25), a.AlP(50)), 16, "LEFT", false);
    }
    private void construirPanelDatos(Area a){
        primerPanel = new IUPanel(panelDatos, new Area(a.X() + a.AnP(15), a.Y() + a.AlP(15), a.An() - a.AnP(15)*2, a.AlP(85) - a.AlP(15)*2), true);
        construirPrimerPanel(new Area(2, 2, primerPanel.area.An() - 4, primerPanel.area.Al() - 4));
        
        segundoPanel = new IUPanel(panelDatos, new Area(a.X(), a.Y(2) + a.AlP(85), a.An(), a.AlP(15)), false);
        construirSegundoPanel(new Area(8, 2, segundoPanel.area.An() - 24, segundoPanel.area.Al() - 8));
    }
    private void construirPrimerPanel(Area a){
        panelCampos = new IUPanel(primerPanel, new Area(a.X(), a.Y(), a.An(), a.AlP(20)), true);
        construirPanelCampos(new Area(2, 2, panelCampos.area.An() - 8, panelCampos.area.Al() - 6));
        
        panelTabla = new IUPanel(primerPanel, new Area(a.X(), a.Y(2) + a.AlP(20), a.An(), a.AlP(80)), true);
        construirPanelTabla(new Area(panelTabla.area.An(), panelTabla.area.Al()));
    }
    private void construirPanelCampos(Area a){
        iuNro = new IUPanelEtiqueta(panelCampos, new Area(a.X(), a.Y(), a.AnP(8), a.AlP(40)), "Nro", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        nro = new IUCampoTexto(panelCampos, 2, 16, new Area(a.X(), a.Y(2) + a.AlP(40), a.AnP(8), a.AlP(60)), SwingConstants.CENTER);
        nro.setRestriccion("^([1-99])$");
        
        iuUsername = new IUPanelEtiqueta(panelCampos, new Area(a.X(2) + a.AnP(8), a.Y(), a.AnP(30), a.AlP(40)), "usuario", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        username = new IUCampoTexto(panelCampos, 50, 16, new Area(a.X(2) + a.AnP(8), a.Y(2) + a.AlP(40), a.AnP(30), a.AlP(60)), SwingConstants.CENTER);
        username.setRestriccion("[a-zA-Z0-9]|[ \\t\\r\\n]");
        
        iuPassword = new IUPanelEtiqueta(panelCampos, new Area(a.X(3) + a.AnP(38), a.Y(), a.AnP(30), a.AlP(40)), "contraseña", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        password = new IUCampoTexto(panelCampos, 50, 16, new Area(a.X(3) + a.AnP(38), a.Y(2) + a.AlP(40), a.AnP(30), a.AlP(60)), SwingConstants.CENTER);
    }
    private void construirPanelTabla(Area a){
        tabla = new IUTabla(panelTabla, 
                new Area(a.An(), a.Al()), 
                new String[]{"NRO", "USUARIO", "PASSWORD", "FECHA INI", "FECHA FIN"}, 
                new Class[]{String.class, String.class, String.class}, 
                new int[]{8, 25, 25, 21, 21}, new ArrayList(), 
                new ModeloTabla<User>(){
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                switch(columnIndex){
                    case 0:
                        return lista.get(rowIndex).getNro();
                    case 1:
                        return lista.get(rowIndex).getUsuario();
                    case 2:
                        return lista.get(rowIndex).getPassword();
                    case 3:
                        return lista.get(rowIndex).getFecha1();
                    case 4:
                        return lista.get(rowIndex).getFecha2();
                    default:
                        return null;
                }
            }
        });
    }
    private void construirSegundoPanel(Area a){
        iuTituloMensaje = new IUEtiqueta(segundoPanel, "Mensajes - Instrucciones", new Area(a.X(), a.Y(), a.AnP(97), a.AlP(20)), 16, "CENTER", false);
        iuTituloMensaje.setSubrayarTexto(true);
        iuMensaje = new IUPanelEtiqueta(segundoPanel, new Area(a.X(), a.Y(2) + a.AlP(20), a.AnP(97), a.AlP(40)), "", 20, SwingConstants.LEFT, Color.BLACK, true);
        iuMensaje.setColores(Color.WHITE, new Color(41, 66, 99));
        iuMensaje.setFuente(new Font("Monospaced 13", Font.PLAIN, 20));
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
        
        campoS_N4 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N4.setVisible(false);
        campoS_N4.setBorder(new LineBorder(Color.BLACK, 3));
        campoS_N4.setBackground(new Color(255, 210, 0));
        campoS_N4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoS_N4.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoS_N4.setText("N");
                }
            }
        });
        campoS_N4.setForeground(Color.BLACK);
        
        campoS_N5 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N5.setVisible(false);
        campoS_N5.setBorder(new LineBorder(Color.BLACK, 3));
        campoS_N5.setBackground(new Color(255, 210, 0));
        campoS_N5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoS_N5.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoS_N5.setText("N");
                }
            }
        });
        campoS_N5.setForeground(Color.BLACK);
        
        campoS_N6 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N6.setVisible(false);
        campoS_N6.setBorder(new LineBorder(Color.BLACK, 3));
        campoS_N6.setBackground(new Color(255, 210, 0));
        campoS_N6.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoS_N6.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoS_N6.setText("N");
                }
            }
        });
        campoS_N6.setForeground(Color.BLACK);
        
        campoS_N7 = new IUCampoTexto(segundoPanel, 1, 20, new Area(a.X(2) + a.AnP(97), a.Y(2) + a.AlP(20), a.AnP(3), a.AlP(40)), SwingConstants.CENTER);
        campoS_N7.setVisible(false);
        campoS_N7.setBorder(new LineBorder(Color.BLACK, 3));
        campoS_N7.setBackground(new Color(255, 210, 0));
        campoS_N7.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_S == e.getKeyCode()){
                    campoS_N7.setText("S");
                }
                if(KeyEvent.VK_N == e.getKeyCode()){
                    campoS_N7.setText("N");
                }
            }
        });
        campoS_N7.setForeground(Color.BLACK);
    }
    private void algoritmosInicial(){
        panel.getInputMap( JButton.WHEN_IN_FOCUSED_WINDOW ).put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "ESC" );
        panel.getActionMap().put( "ESC", new AbstractAction(){            
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        if(Integer.parseInt(usuario.getPassword()) == 1)
            cargarDatosTabla(CTabvar.getLista("SELECT * FROM tabvar WHERE TIPO = 99"));
        else
            cargarDatosTabla(CTabvar.getLista("select * from tabvar where tipo = 99 and numero = "+usuario.getPassword()));
        focoCampoNro();
    }
    private void cargarDatosTabla(ArrayList<Tabvar> lista){
        indice = 1;
        ArrayList<User> usuarios = new ArrayList<>();        
        for (Tabvar tabvar : lista) {
            User u = new User(tabvar.getRecord());
            u.setTipo(tabvar.getTipo());
            u.setNumero(tabvar.getNumero());
            u.setCodcon(tabvar.getCodcon());
            u.setCorrel(tabvar.getCorrel());
            u.setNro(String.valueOf(indice));
            u.setUsuario(tabvar.getDescri());
            u.setPassword(tabvar.getObserv());
            u.setFecha1(tabvar.getFecha());
            u.setFecha2(tabvar.getFecha2());
            indice++;
            usuarios.add(u);
        }
        tabla.actualizarTabla(usuarios);
    }
    private void cambiarEstado(String componente, boolean cambio){
        tabla.setEnabled(false);
        tabla.setFocusable(false);
        nro.setEditar(false);
        username.setEditar(false);
        password.setEditar(false);
        
        campoS_N1.setEditar(false);
        campoS_N1.setVisible(false);        
        campoS_N2.setEditar(false);
        campoS_N2.setVisible(false);
        campoS_N3.setEditar(false);
        campoS_N3.setVisible(false);
        campoS_N4.setEditar(false);
        campoS_N4.setVisible(false);
        campoS_N5.setEditar(false);
        campoS_N5.setVisible(false);
        campoS_N6.setEditar(false);
        campoS_N6.setVisible(false);
        campoS_N7.setEditar(false);
        campoS_N7.setVisible(false);
        switch(componente){
            case "tabla":
                tabla.setFocusable(cambio);
                tabla.setEnabled(cambio);
            break;
            case "nro":
                nro.setEditar(cambio);
            break;
            case "username":
                username.setEditar(cambio);
            break;
            case "password":
                password.setEditar(cambio);
            break;
            case "campo1":
                campoS_N1.setEditar(cambio);
                campoS_N1.setVisible(true);
            break;
            case "campo2":
                campoS_N2.setEditar(cambio);
                campoS_N2.setVisible(true);
            break;
            case "campo3":
                campoS_N3.setEditar(cambio);
                campoS_N3.setVisible(true);
            break;
            case "campo4":
                campoS_N4.setEditar(cambio);
                campoS_N4.setVisible(true);
            break;
            case "campo5":
                campoS_N5.setEditar(cambio);
                campoS_N5.setVisible(true);
            break;
            case "campo6":
                campoS_N6.setEditar(cambio);
                campoS_N6.setVisible(true);
            break;
            case "campo7":
                campoS_N7.setEditar(cambio);
                campoS_N7.setVisible(true);
            break;
        }
    }
    private void focoCampoTabla(){
        cambiarEstado("tabla", true);
        tabla.requestFocus();
        iuMensaje.setTexto("Seleccione una fila y presione ENTER.");
        iuInformacion.setTexto("ATENCION:  ESC=Suspender, F2=Atras, ENTER=Avanzar");
        tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(tabla.isFilaSeleccionado()){                    
                    indice = tabla.getSelectedRow();
                    user = (User) tabla.modeloTabla.getFila(tabla.getSelectedRow());
                    
                    nro.setText(String.valueOf(user.getNro()));
                    username.setText(user.getUsuario());
                    password.setText(user.getPassword());
                }
            }
        });
        tabla.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        tabla.getActionMap().put("Enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(tabla.isFilaSeleccionado()){
                    preguntaEditarDatosUsuario();
                }
            }
        });
        tabla.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "F2");
        tabla.getActionMap().put("F2", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {                
                limpiarCampos();
                focoCampoNro();
            }
        });
    }
    private void preguntaEditarDatosUsuario(){
        cambiarEstado("campo2", true);        
        campoS_N2.requestFocus();
        campoS_N2.setText("S");
        iuMensaje.setTexto("Desea EDITAR los datos del USUARIO seleccionado.?      S/N");
        iuInformacion.setTexto("");
        campoS_N2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){                    
                    if(!campoS_N2.getText().isEmpty()){
                        switch(campoS_N2.getText()){
                            case "S":
                                focoCampoUsername("modificar");
                            break;
                            case "N":
                                preguntarEliminarUsuario();
                            break;
                        }
                    }
                        
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoNro();
                }
            }
        });
    }
    private void preguntarEliminarUsuario(){
        cambiarEstado("campo5", true);        
        campoS_N5.requestFocus();
        campoS_N5.setText("S");
        iuMensaje.setTexto("Desea ELIMINAR el USUARIO seleccionado.?      S/N");
        iuInformacion.setTexto("");
        campoS_N5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){                    
                    if(!campoS_N5.getText().isEmpty()){
                        switch(campoS_N5.getText()){
                            case "S":
                                eliminarUsuario();
                            break;
                            case "N":
                                preguntarSalir();
                            break;
                        }
                    }
                        
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoNro();
                }
            }
        });
    }
    private boolean eliminarUsuario(){
        boolean respuesta = false;
        Tabvar tabvar = new Tabvar(user.getId());
        tabvar.setTipo(user.getTipo());
        tabvar.setNumero(user.getNumero());
        tabvar.setDescri(username.getText());
        tabvar.setCodcon(user.getCodcon());
        tabvar.setCorrel(user.getCorrel());
        tabvar.setMonto(0);
        tabvar.setObserv(password.getText());
        tabvar.setFecha(Ayuda.getDatoCadena("fecha", "select fecha from tabvar where tipo = 1 and numero = 1"));
        tabvar.setFecha2(Ayuda.getDatoCadena("fecha2", "select fecha2 from tabvar where tipo = 1 and numero = 12"));
        tabvar.setMonto2(0);
        tabvar.setTipcam(0);
        tabvar.setNumnit(0);
        if(CTabvar.eliminarTabvar(tabvar)){
            respuesta = true;
            Ayuda.mensaje(ventanaPrincipal, "en hora buena, se ha ELIMINADO el USUARIO seleccionado.!", "correcto");
            actualizarPaneles();
        }
            
        return respuesta;
    }
    private void focoCampoUsername(String objetivo){
        cambiarEstado("username", true);
        username.requestFocus();
        iuMensaje.setTexto("Digite el nombre de usuario o el cargo de usuario");
        iuInformacion.setTexto("ATENCION: ESC=Suspender, F2=Atras, ENTER=Avanzar");
        username.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!username.getText().isEmpty()){
                        focoCampoPassword(objetivo);
                    }
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    limpiarCampos();
                    focoCampoNro();
                }
            }
        });
    }
    private void focoCampoPassword(String objetivo){
        cambiarEstado("password", true);
        password.requestFocus();
        iuMensaje.setTexto("Digite el password de usuario");
        iuInformacion.setTexto("ATENCION: ESC=Suspender, F2=Atras, ENTER=Avanzar");
        password.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    if(!password.getText().isEmpty()){
                        switch(objetivo){
                            case "nuevo":
                                nuevoUsuario();
                            break;
                            case "modificar":
                                editarDatosUsuario();
                            break;
                        }
                    }
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){                    
                    focoCampoUsername(objetivo);
                }
            }
        });
    }
    private void focoCampoNro(){
        limpiarCampos();
        cambiarEstado("nro", true);
        nro.requestFocus();
        nro.setText(String.valueOf(indice));
        iuMensaje.setTexto("Use las teclas ↑ ↓ para seleccionar una fila de la tabla.");
        iuInformacion.setTexto("ATENCION:  ESC=Suspender, ENTER=Avanzar");
        nro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    nro.setText(String.valueOf(indice));
                    if(usuario.getNumusu() == 1)
                        preguntaNuevoUsuario();
                    else
                        Ayuda.mensaje(ventanaPrincipal, "ERROR: EL USUARIO DEL SISTEMA NO TIENE ACCESO  A CREAR USUARIOS", "error");
                }
                if(KeyEvent.VK_UP == e.getKeyCode() || KeyEvent.VK_DOWN == e.getKeyCode()){
                    if(!tabla.modeloTabla.isVacia())
                        focoCampoTabla();
                }
            }
        });
    }
    private void nuevoUsuario(){
        cambiarEstado("campo3", true);
        campoS_N3.setVisible(true);
        campoS_N3.requestFocus();
        campoS_N3.setText("S");
        iuMensaje.setTexto("Esta seguro que desea Guardar el NUEVO USUARIO.?      S/N");
        iuInformacion.setTexto("");
        campoS_N3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){                    
                    if(!campoS_N3.getText().isEmpty()){
                        switch(campoS_N3.getText()){
                            case "S":                                
                                guardarUsuario();
                            break;
                            case "N":
                                preguntarSalir();
                            break;
                        }
                    }
                        
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoNro();
                }
            }
        });
    }
    
    private void editarDatosUsuario(){
        cambiarEstado("campo4", true);
        campoS_N4.setVisible(true);
        campoS_N4.requestFocus();
        campoS_N4.setText("S");
        iuMensaje.setTexto("Esta seguro que desea MODIFICAR el USUARIO seleccionado.?      S/N");
        iuInformacion.setTexto("");
        campoS_N4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){                    
                    if(!campoS_N4.getText().isEmpty()){
                        switch(campoS_N4.getText()){
                            case "S":                                
                                modificarUsuario();
                            break;
                            case "N":
                                preguntarSalir();
                            break;
                        }
                    }
                        
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoNro();
                }
            }
        });
    }
    private void actualizarPaneles(){
        panel.removeAll();        
        construirPaneles(new Area(2, 2, panel.area.An() - 4, panel.area.Al() - 4));
        if(Integer.parseInt(usuario.getPassword()) == 1)
            cargarDatosTabla(CTabvar.getLista("SELECT * FROM tabvar WHERE TIPO = 99"));
        else
            cargarDatosTabla(CTabvar.getLista("select * from tabvar where tipo = 99 and numero = "+usuario.getPassword()));
        tabla.modeloTabla.fireTableDataChanged();
        panel.updateUI();
        algoritmosInicial();
        
    }
    private boolean guardarUsuario(){
        boolean respuesta = false;
        Tabvar tabvar = new Tabvar(0);
        tabvar.setTipo(99);
        tabvar.setNumero(Integer.parseInt(password.getText()));//Ayuda.getDatoEntero("numero", "select numero from tabvar where tipo = 99 order by numero desc limit 1")+1);
        tabvar.setDescri(username.getText());
        tabvar.setCodcon(Ayuda.getDatoEntero("codcon", "select codcon from tabvar where tipo = 99 order by codcon desc limit 1")+1);
        tabvar.setCorrel(Ayuda.getDatoEntero("correl", "select correl from tabvar where tipo = 99 order by correl desc limit 1")+1);
        tabvar.setMonto(0);
        tabvar.setObserv(password.getText());
        tabvar.setFecha(Ayuda.getDatoCadena("fecha", "select fecha from tabvar where tipo = 1 and numero = 1"));
        tabvar.setFecha2(Ayuda.getDatoCadena("fecha2", "select fecha2 from tabvar where tipo = 1 and numero = 12"));
        tabvar.setMonto2(0);
        tabvar.setTipcam(0);
        tabvar.setNumnit(0);
        if(CTabvar.guardarTabvar(tabvar)){
            Ayuda.mensaje(ventanaPrincipal, "En hora buena, se ha guardado el nuevo usuario correctamente.!", "correcto");
            actualizarPaneles();
        }
        
        return respuesta;
    }
    private boolean modificarUsuario(){
        boolean respuesta = false;
        Tabvar tabvar = new Tabvar(user.getId());
        tabvar.setTipo(user.getTipo());
        tabvar.setNumero(Integer.parseInt(user.getPassword()));
        tabvar.setDescri(username.getText());
        tabvar.setCodcon(user.getCodcon());
        tabvar.setCorrel(user.getCorrel());
        tabvar.setMonto(0);
        tabvar.setObserv(password.getText());
        tabvar.setFecha(Ayuda.getDatoCadena("fecha", "select fecha from tabvar where tipo = 1 and numero = 1"));
        tabvar.setFecha2(Ayuda.getDatoCadena("fecha2", "select fecha2 from tabvar where tipo = 1 and numero = 12"));
        tabvar.setMonto2(0);
        tabvar.setTipcam(0);
        tabvar.setNumnit(0);
        
        if(CTabvar.modificarTabvar(tabvar)){
            Ayuda.mensaje(ventanaPrincipal, "En hora buena, se ha modificado el usuario seleccionado.!", "correcto");
            actualizarPaneles();
        }
        return respuesta;
    }
    private void preguntaNuevoUsuario(){
        cambiarEstado("campo1", true);
        campoS_N1.setVisible(true);
        campoS_N1.requestFocus();
        campoS_N1.setText("S");
        iuMensaje.setTexto("Desea Crear un NUEVO USUARIO.?      S/N");
        iuInformacion.setTexto("");
        campoS_N1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){                    
                    if(!campoS_N1.getText().isEmpty()){
                        switch(campoS_N1.getText()){
                            case "S":
                                limpiarCampos();
                                focoCampoUsername("nuevo");
                            break;
                            case "N":
                                preguntarSalir();
                            break;
                        }
                    }
                        
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoNro();
                }
            }
        });
    }
    private void preguntarSalir(){
        cambiarEstado("campo6", true);
        campoS_N6.setVisible(true);
        campoS_N6.requestFocus();
        campoS_N6.setText("S");
        iuMensaje.setTexto("Desea SUSPENDER y SALIR del PROGRAMA.?      S/N");
        iuInformacion.setTexto("");
        campoS_N6.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){                    
                    if(!campoS_N6.getText().isEmpty()){
                        switch(campoS_N6.getText()){
                            case "S":
                                dispose();
                            break;
                            case "N":
                                focoCampoNro();
                            break;
                        }
                    }
                        
                }
                if(KeyEvent.VK_F2 == e.getKeyCode()){
                    focoCampoNro();
                }
            }
        });
    }
    private void limpiarCampos(){
        indice = tabla.getRowCount() + 1;
        nro.setText(String.valueOf(indice));
        username.setText("");
        password.setText("");
    }
}

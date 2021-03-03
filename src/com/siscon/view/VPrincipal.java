/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view;

import SIGU.comboBox.IUComboBox;
import SIGU.etiquetas.IUEtiqueta;
import SIGU.etiquetas.IUEtiquetaI;
import SIGU.paneles.IUPanel;
import SIGU.paneles.IUPanelEtiqueta;
import SIGU.recursos.Area;
import SIGU.recursos.Fecha;
import SIGU.ventanas.IUPrincipal;
import com.siscon.bd.Conexion;
import com.siscon.model.Tabvar;
import com.siscon.model.Usuario;
import com.siscon.recursos.Ayuda;
import com.siscon.view.actualizacionDiferida.VActualizacionDiferida;
import com.siscon.view.conmae.VConmae;
import com.siscon.view.contra.VContra;
import com.siscon.view.contra.VContraDoble;
import com.siscon.view.indicesEstados.VIndicesEstados;
import com.siscon.view.integracionSistemas.VIntegracionSistemas;
import com.siscon.view.reportes.RBalanceComprobacion;
import com.siscon.view.reportes.RBalanceGeneral;
import com.siscon.view.reportes.REmisionPC;
import com.siscon.view.reportes.REstadoCuenta;
import com.siscon.view.reportes.REstadoPerdidaGanancia;
import com.siscon.view.reportes.RLibroDiario;
import com.siscon.view.reportes.RMayorAnaliticoCuenta;
import com.siscon.view.respaldo.IUOpcionRespaldo;
import com.siscon.view.tablas.VOpciones;
import com.siscon.view.tabvar.VTabvar;
import com.siscon.view.user.VUsuario;
import com.siscon.view.verificacionAsientos.VVerificacionAsientos;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.speech.AudioException;
import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.EngineModeDesc;
import javax.speech.EngineStateError;
import javax.speech.recognition.GrammarException;
import javax.speech.recognition.Recognizer;
import javax.speech.recognition.Result;
import javax.speech.recognition.ResultAdapter;
import javax.speech.recognition.ResultEvent;
import javax.speech.recognition.ResultToken;
import javax.speech.recognition.RuleGrammar;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author neo
 */
public class VPrincipal extends IUPrincipal {

    private VPrincipal ventanaPrincipal;
    private final String titulo;

    private IUPanel panel;
    private IUPanel panelTitulo;
    private IUEtiqueta iuTitulo;

    private IUEtiqueta iuTituloEmpresa;

    private IUPanel panelDatos;
    private IUEtiquetaI imagenLogo;

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

    static Recognizer recognizer;
    String gst;

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
        construirPaneles(new Area(An() - 6, Al() - 29));
        setEventos();
        //reconocimientoVoz();
    }

    private void construirPaneles(Area a) {
        panel = new IUPanel(this, new Area(a.X(), a.Y(), a.An(), a.Al()), true);
        construirPanel(new Area(2, 2, panel.area.An() - 4, panel.area.Al() - 6));
        panel.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESC");
        panel.getActionMap().put("ESC", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salirSistema();
            }
        });

        panel.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "F1");
        panel.getActionMap().put("F1", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ayuda.abrir("manual20.docx");
            }
        });
    }

    private void construirPanel(Area a) {
        panelTitulo = new IUPanel(panel, new Area(a.X(), a.Y(), a.An(), a.AlP(8)), true, Ayuda.COLOR_FONDO);
        construirPanelTitulo(new Area(10, 3, panelTitulo.area.An() - 40, panelTitulo.area.Al() - 9));

        iuTituloEmpresa = new IUEtiqueta(panel, Ayuda.getDatoCadena("DESCRI", "SELECT DESCRI FROM TABVAR WHERE TIPO = 10 AND NUMERO = 1"), new Area(a.X(), a.Y() + a.AlP(15), a.An(), a.AlP(5)), 20, "CENTER", Ayuda.COLOR_ROJO);
        iuTituloEmpresa.setSubrayarTexto(true);

        imagenLogo = new IUEtiquetaI(panel, new Area(a.X(), a.Y() + a.AlP(8), a.AnP(10), a.AlP(18)), "/imagenes/imagenLogo.png");
        imagenLogo.setMovimiento();

        panelDatos = new IUPanel(panel, new Area(a.X(), a.Y(2) + a.AlP(8), a.An(), a.AlP(92)), true);
        construirPanelDatos(new Area(panelDatos.area.AnP(10), panelDatos.area.AlP(20), panelDatos.area.An() - panelDatos.area.AnP(10) * 2, panelDatos.area.Al() - panelDatos.area.AlP(20) * 2));

        //construirPanelMensajes(new Area(panelMensajes.area.AnP(10), panelMensajes.area.AlP(5), panelMensajes.area.An() - panelMensajes.area.AnP(10)*2, panelMensajes.area.Al() - panelMensajes.area.AlP(5)*2));
    }

    private void construirPanelTitulo(Area a) {
        iuTitulo = new IUEtiqueta(panelTitulo, usuario.getRazsoc(), new Area(a.X(), a.Y(), a.AnP(25), a.AlP(50)), 18, "LEFT", false);
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "SISTEMA DE CONTABILIDAD (SISCON @v7.1. 2020)", new Area(a.X(2) + a.AnP(30), a.Y(2) + a.AlP(40), a.AnP(40), a.AlP(50)), 18, "CENTER", false);
        iuTitulo = new IUEtiqueta(panelTitulo, "Cochabamba, " + new Fecha().getFecha1(), new Area(a.X(3) + a.AnP(65), a.Y(), a.AnP(35), a.AlP(50)), 18, "RIGHT", false);

        iuTitulo = new IUEtiqueta(panelTitulo, "Usuario: " + tabvar.getDescri(), new Area(a.X(), a.Y(2) + a.AlP(50), a.AnP(40), a.AlP(50)), 18, "LEFT", false);
        iuTitulo.setSubrayarTexto(true);
        iuTitulo = new IUEtiqueta(panelTitulo, "Serie No. 07/a", new Area(a.X(3) + a.AnP(60), a.Y(2) + a.AlP(50), a.AnP(40), a.AlP(50)), 18, "RIGHT", false);
        iuTitulo.setSubrayarTexto(true);
    }

    private void construirPanelDatos(Area a) {
        panelContenedor = new IUPanel(panelDatos, new Area(a.X(), a.Y(), a.An(), a.Al()), true);
        construirPanelContenedor(new Area(2, 2, panelContenedor.area.An() - 8, panelContenedor.area.Al() - 8));
    }

    private void construirPanelContenedor(Area a) {
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

    private void construirPanelA(Area a) {
        tituloA = new IUEtiqueta(panelA, "PROCESOS", new Area(a.X() + a.AnP(30), a.Y(4), a.AnP(40), a.AlP(7)), 20, "CENTER", new Color(120, 0, 0));
        tituloA.setSubrayarTexto(true);
        iuLista.add(new IUPanelEtiqueta(panelA, new Area(a.X(), a.Y() + a.AlP(21), a.An(), a.AlP(7)), "01. Plan Cuentas", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelA, new Area(a.X(), a.Y(2) + a.AlP(28), a.An(), a.AlP(7)), "02. Presupuestos", 16, SwingConstants.LEFT, Color.DARK_GRAY, Color.LIGHT_GRAY, true));
        iuLista.add(new IUPanelEtiqueta(panelA, new Area(a.X(), a.Y(3) + a.AlP(35), a.An(), a.AlP(7)), "03. Parametros - Tablas", 16, SwingConstants.LEFT, Color.WHITE, true));

        tituloA = new IUEtiqueta(panelA, "REPORTES", new Area(a.X() + a.AnP(30), a.Y(7) + a.AlP(42), a.AnP(40), a.AlP(7)), 20, "CENTER", new Color(120, 0, 0));
        tituloA.setSubrayarTexto(true);
        iuLista.add(new IUPanelEtiqueta(panelA, new Area(a.X(), a.Y(4) + a.AlP(63), a.An(), a.AlP(7)), "05. Emision Plan Cuentas", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelA, new Area(a.X(), a.Y(5) + a.AlP(70), a.An(), a.AlP(7)), "06. Control Presupuesto", 16, SwingConstants.LEFT, Color.DARK_GRAY, Color.LIGHT_GRAY, true));
        iuLista.add(new IUPanelEtiqueta(panelA, new Area(a.X(), a.Y(7) + a.AlP(84), a.An(), a.AlP(7)), "08. Tipo de Cambio", 16, SwingConstants.LEFT, Color.DARK_GRAY, Color.LIGHT_GRAY, true));
        iuLista.add(new IUPanelEtiqueta(panelA, new Area(a.X(), a.Y(8) + a.AlP(91), a.An(), a.AlP(7)), "09. Estado de Cuenta", 16, SwingConstants.LEFT, Color.WHITE, true));
    }

    private void construirPanelB(Area a) {
        tituloB = new IUEtiqueta(panelB, "PROCESOS", new Area(a.X() + a.AnP(30), a.Y(4), a.AnP(40), a.AlP(7)), 20, "CENTER", new Color(120, 0, 0));
        tituloB.setSubrayarTexto(true);
        iuLista.add(new IUPanelEtiqueta(panelB, new Area(a.X(), a.Y() + a.AlP(21), a.An(), a.AlP(7)), "11. Asiento Ingreso o Egreso", 16, SwingConstants.LEFT, Color.WHITE, true));
        //iuLista.add(new IUPanelEtiqueta(panelB, new Area(a.X(), a.Y(2) + a.AlP(28), a.An(), a.AlP(7)), "12. Asiento Multiple", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelB, new Area(a.X(), a.Y(3) + a.AlP(35), a.An(), a.AlP(7)), "13. Asiento de Diario", 16, SwingConstants.LEFT, Color.WHITE, true));

        tituloB = new IUEtiqueta(panelB, "REPORTES", new Area(a.X() + a.AnP(30), a.Y(7) + a.AlP(42), a.AnP(40), a.AlP(7)), 20, "CENTER", new Color(120, 0, 0));
        tituloB.setSubrayarTexto(true);
        iuLista.add(new IUPanelEtiqueta(panelB, new Area(a.X(), a.Y(4) + a.AlP(63), a.An(), a.AlP(7)), "15. Libro Diario", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelB, new Area(a.X(), a.Y(5) + a.AlP(70), a.An(), a.AlP(7)), "16. Libro Mayor...", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelB, new Area(a.X(), a.Y(6) + a.AlP(77), a.An(), a.AlP(7)), "17. Balance Comprobacion", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelB, new Area(a.X(), a.Y(7) + a.AlP(84), a.An(), a.AlP(7)), "18. Perdidas y Ganancias", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelB, new Area(a.X(), a.Y(8) + a.AlP(91), a.An(), a.AlP(7)), "19. Balance General", 16, SwingConstants.LEFT, Color.WHITE, true));
    }

    private void construirPanelC(Area a) {
        iuLista.add(new IUPanelEtiqueta(panelC, new Area(a.X(), a.Y() + a.AlP(21), a.An(), a.AlP(7)), "21. Claves de Acceso", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelC, new Area(a.X(), a.Y(2) + a.AlP(28), a.An(), a.AlP(7)), "22. Manejo Archivos...", 16, SwingConstants.LEFT, Color.DARK_GRAY, Color.LIGHT_GRAY, true));
        iuLista.add(new IUPanelEtiqueta(panelC, new Area(a.X(), a.Y(3) + a.AlP(35), a.An(), a.AlP(7)), "23. Indices - Estados...", 16, SwingConstants.LEFT, Color.WHITE, true));

        iuLista.add(new IUPanelEtiqueta(panelC, new Area(a.X(), a.Y(4) + a.AlP(63), a.An(), a.AlP(7)), "25. Verificacion Asientos", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelC, new Area(a.X(), a.Y(5) + a.AlP(70), a.An(), a.AlP(7)), "26. Actualizacion Diferida", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelC, new Area(a.X(), a.Y(6) + a.AlP(77), a.An(), a.AlP(7)), "27. Integracion Sistemas", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelC, new Area(a.X(), a.Y(7) + a.AlP(84), a.An(), a.AlP(7)), "28. Cargar Tablas al Sistema", 16, SwingConstants.LEFT, Color.WHITE, true));
        iuLista.add(new IUPanelEtiqueta(panelC, new Area(a.X(), a.Y(8) + a.AlP(91), a.An(), a.AlP(7)), "30. Respaldo - Desplazo...", 16, SwingConstants.LEFT, Color.WHITE, true));
    }

    private void construirPanelAbajo(Area a) {
        panelMensajes = new IUPanel(panelAbajo, new Area(a.X(), a.Y(), a.AnP(80), a.AlP(50)), false, Color.WHITE);
        construirPanelMensajes(new Area(panelMensajes.area.An() - 8, panelMensajes.area.Al()));

        panelInformacion = new IUPanel(panelAbajo, new Area(a.X(), a.Y(2) + a.AlP(50), a.AnP(80), a.AlP(50)), false, Ayuda.COLOR_FONDO);
        construirPanelInformacion(new Area(2, 2, panelInformacion.area.An() - 10, panelInformacion.area.Al() - 4));

        panelEntrada = new IUPanel(panelAbajo, new Area(a.X(2) + a.AnP(80), a.Y(), a.AnP(20), a.Al()), false, Ayuda.COLOR_FONDO);
        construirPanelEntrada(new Area(4, 4, panelEntrada.area.An() - 8, panelEntrada.area.Al() - 8));
    }

    private void construirPanelMensajes(Area a) {
        iuMensajes = new IUEtiqueta(panelMensajes, "Digite UNA opcion y [Enter], [F1]=Manual Usuario,  [Esc] = para Finalizar.......", new Area(a.An(), a.Al()), 16, "CENTER", false);
    }

    private void construirPanelInformacion(Area a) {
        iuFechaVigente = new IUPanelEtiqueta(panelInformacion, new Area(a.X() + a.AnP(55), a.Y(), a.AnP(15), a.Al()), "Fecha Vigente: ", 16, SwingConstants.LEFT, Ayuda.COLOR_FONDO, true);
        iuFecha = new IUEtiqueta(panelInformacion, usuario.getFecusu(), new Area(a.X(2) + a.AnP(70), a.Y(), a.AnP(15), a.Al()), 16, "CENTER", true);

        iuEtiquetaTipoCambio = new IUPanelEtiqueta(panelInformacion, new Area(a.X(3) + a.AnP(85), a.Y(), a.AnP(5), a.Al()), "T/C: ", 16, SwingConstants.CENTER, Ayuda.COLOR_FONDO, true);
        iuTipoCambio = new IUEtiqueta(panelInformacion, String.valueOf(usuario.getTipcam()), new Area(a.X(4) + a.AnP(90), a.Y(), a.AnP(10), a.Al()), 16, "CENTER", true);
    }

    private void construirPanelEntrada(Area a) {
        iuEntrada = new IUComboBox(panelEntrada, getOpciones(), new Area(a.X(), a.Y(), a.AnP(30), a.AlP(50)), 16, 2);
        
    }

    private void salirSistema() {
        setOpacity(0.6f);
        boolean resp = Ayuda.mensaje(this, "Está seguro que desea salir del sistema?", "pregunta");
        if (resp) {
            System.exit(0);
        }
        setOpacity(1f);
    }

    private ArrayList<String> getOpciones() {
        ArrayList<String> opciones = new ArrayList<>();
        iuLista.stream().map((iuDato) -> iuDato.getTexto().substring(0, 2)).forEachOrdered((dato) -> {
            opciones.add(dato);
        });
        return opciones;
    }

    private void setEventos() {
        iuEntrada.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String dato = e.getItem().toString();
                seleccionarOpcion(dato);
            }
        });
        iuEntrada.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (KeyEvent.VK_ENTER == e.getKeyCode()) {
                    String dato = iuEntrada.getSelectedItem().toString();
                    iuEntrada.hidePopup();
                    componenteSeleccionado(dato);
                }
            }
        });
    }

    private void seleccionarOpcion(String opcion) {
        iuLista.forEach((IUPanelEtiqueta iuDato) -> {
            String dato = iuDato.getTexto().substring(0, 2);
            if (opcion.equalsIgnoreCase(dato)) {
                iuDato.setBackground(Color.yellow);
            } else {
                if(dato.equalsIgnoreCase("02") || dato.equalsIgnoreCase("06") || dato.equalsIgnoreCase("08") || dato.equalsIgnoreCase("22"))
                    iuDato.setBackground(Color.DARK_GRAY);
                else
                    iuDato.setBackground(Color.WHITE);
            }
        });
    }

    private void componenteSeleccionado(String opcion) {
        switch (opcion) {
            case "01":
                setOpacity(0.6f);
                VConmae vConmae = new VConmae(this, titulo, "grande", usuario, tabvar);
                vConmae.mostrarVentana();
                setOpacity(1f);
                break;
            /*case "02":
                break;*/
            case "03":
                setOpacity(0.6f);
                VTabvar vTabvar = new VTabvar(this, titulo, "grande", usuario, tabvar);
                vTabvar.mostrarVentana();
                setOpacity(1f);
                break;
            case "05":
                setOpacity(0.6f);
                REmisionPC r = new REmisionPC(this, titulo, "grande", usuario, tabvar);
                r.mostrarVentana();
                setOpacity(1f);
                break;
            /*case "06":
                break;
            case "08":
                break;*/
            case "09":
                setOpacity(0.6f);
                REstadoCuenta estadoCuentas = new REstadoCuenta(this, titulo, "grande", usuario, tabvar);
                estadoCuentas.mostrarVentana();
                setOpacity(1f);
                break;
            case "11":
                setOpacity(0.6f);
                VContra iuSimple = new VContra(this, titulo, "grande", usuario, tabvar);
                iuSimple.mostrarVentana();
                setOpacity(1f);
                break;
            case "13":
                setOpacity(0.6f);
                VContraDoble iuDoble = new VContraDoble(this, titulo, "grande", usuario, tabvar);
                iuDoble.mostrarVentana();
                setOpacity(1f);
                break;
            case "15":
                setOpacity(0.6f);
                RLibroDiario iuLibro = new RLibroDiario(this, titulo, "grande", usuario);
                iuLibro.mostrarVentana();
                setOpacity(1f);
                break;
            case "16":
                setOpacity(0.6f);
                RMayorAnaliticoCuenta iuM = new RMayorAnaliticoCuenta(this, titulo, "grande", usuario, tabvar, "");
                iuM.mostrarVentana();
                setOpacity(1f);
                break;
            case "17":
                setOpacity(0.6f);
                RBalanceComprobacion iuBC = new RBalanceComprobacion(this, titulo, "grande", usuario, tabvar);
                iuBC.mostrarVentana();
                setOpacity(1f);
                break;
            case "18":
                setOpacity(0.6f);
                REstadoPerdidaGanancia iuEPG = new REstadoPerdidaGanancia(this, titulo, "grande", usuario, tabvar);
                iuEPG.mostrarVentana();
                setOpacity(1f);
                break;
            case "19":
                setOpacity(0.6f);
                RBalanceGeneral iuBG = new RBalanceGeneral(this, titulo, "grande", usuario);
                iuBG.mostrarVentana();
                setOpacity(1f);
                break;
            case "21":
                setOpacity(0.6f);
                VUsuario iuUsuario = new VUsuario(this, titulo, "grande", usuario);
                iuUsuario.mostrarVentana();
                setOpacity(1f);
                break;
            /*case "22":
                break;*/
            case "23":
                VIndicesEstados iuIE = new VIndicesEstados(this, titulo, "grande", usuario, tabvar);
                iuIE.mostrarVentana();
                break;
            case "25":
                VVerificacionAsientos iuVA = new VVerificacionAsientos(this, titulo, "grande", usuario, tabvar);
                iuVA.mostrarVentana();
                break;
            case "26":
                VActualizacionDiferida iuAD = new VActualizacionDiferida(this, titulo, "grande", usuario, tabvar);
                iuAD.mostrarVentana();
                break;
            case "27":
                VIntegracionSistemas iuIS = new VIntegracionSistemas(this, titulo, "grande", usuario, tabvar);
                iuIS.mostrarVentana();
                break;
            case "28":
                setOpacity(0.6f);
                VOpciones iuOpciones = new VOpciones(this, titulo, "pequeno");
                iuOpciones.mostrarVentana();
                setOpacity(1f);
                break;
            case "30":
                setOpacity(0.6f);
                IUOpcionRespaldo opcionBD = new IUOpcionRespaldo(this, "BASE DE DATOS", "pequeno");
                opcionBD.mostrarVentana();
                if (opcionBD.getEstado()) {
                    switch (opcionBD.getOpcion()) {
                        case "Restaurar B.D.":
                            
                            String ruta = "";
                            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de Imagen", "sql");
                            File archivo = new File(System.getProperty("user.dir"));
                            JFileChooser archivoRestaurar = new JFileChooser(archivo);
                            archivoRestaurar.setFileFilter(filter);
                            archivoRestaurar.setFileSelectionMode(JFileChooser.FILES_ONLY);
                            int se = archivoRestaurar.showOpenDialog(null);
                            if (se == JFileChooser.APPROVE_OPTION) {
                                ruta = archivoRestaurar.getSelectedFile().getPath();
                                importarBD(ruta);
                            }
                            
                            
                            break;
                        case "Backup B.D.":
                            
                            
                            String rutaBackup = "";
                            FileNameExtensionFilter filt = new FileNameExtensionFilter("Archivo de Imagen", "sql");
                            File arch = new File(System.getProperty("user.dir"));
                            JFileChooser archivoBackup = new JFileChooser(arch);
                            archivoBackup.setFileFilter(filt);
                            archivoBackup.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                            int respuesta = archivoBackup.showSaveDialog(null);
                            if (respuesta == JFileChooser.APPROVE_OPTION) {
                                rutaBackup = archivoBackup.getSelectedFile().getPath();
                                exportarBD(rutaBackup);
                            }

                            break;
                        case "Limpiar B.D.":
                            
                            if(Ayuda.mensaje(this, "Esta seguro que DESEA ELIMINAR los datos y las tablas del SISTEMA CONTABLE..? ", "pregunta")){
                                eliminarBD();
                            }
                            break;
                    }
                }
                setOpacity(1f);
                break;
            default:
                Ayuda.mensaje(this, "Modulo en Construccion, No disponible por ahora. \nGRACIAS...!: ", "informacion");
                break;
        }
    }
    private void eliminarBD(){
        if(Ayuda.deleteTable("DELETE FROM CONMAE")){
            if(Ayuda.deleteTable("DELETE FROM CONTRA")){
                //if(Ayuda.deleteTable("DROP TABLE TABVAR CASCADE")){
                    JOptionPane.showMessageDialog(null, "se ha ELIMINADO LAS TABLAS DE LA BASE DE DATOS CORRECTAMENTE...!");
                /*}else{
                    JOptionPane.showMessageDialog(null, "ERROR, existe un ERROR en la eliminacion de la tabla TABVAR...!");
                }*/
            }else{
                JOptionPane.showMessageDialog(null, "ERROR, existe un ERROR en la eliminacion de la tabla CONTRA...!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "ERROR, existe un ERROR en la eliminacion de la tabla CONMAE...!");
        }
    }

    private void importarBD(String direccion) {
        Conexion c = new Conexion();
        try {
            Process p = Runtime.getRuntime().exec("mysql -u "+c.getUsername()+" -p"+c.getPassword()+" "+c.getBD());
            
            OutputStream os = p.getOutputStream();
            FileInputStream fis = new FileInputStream(direccion);
            byte[] buffer = new byte[1000];

            int leido = fis.read(buffer);
            while (leido > 0) {
                os.write(buffer, 0, leido);
                leido = fis.read(buffer);
            }

            os.flush();
            os.close();
            fis.close();
            
            JOptionPane.showMessageDialog(null, "se ha RESTAURADO la base de datos correctamente...! en la ruta: " + direccion);

        } catch (IOException e) {System.out.println(e);}
    }

    private void exportarBD(String ruta) {
        Conexion c = new Conexion();
        
        int BUFFER = 10485760;
        //nombre de usuario de la base de datos
        String mysqluser = c.getUsername();
        //password del usuario
        String mysqlpassword = c.getPassword();
        //nombre de la base de datos
        String mysqldb = c.getBD();
        String dumpCommand = "";
        if(Ayuda.urlValidator("C:/xampp/mysql/bin/"))
            dumpCommand = "C:/xampp/mysql/bin/mysqldump -u " + mysqluser + " -p" + mysqlpassword + " --skip-comments --skip-triggers " + mysqldb;
        else
            dumpCommand = "mysqldump -u " + mysqluser + " -p" + mysqlpassword + " --skip-comments --skip-triggers " + mysqldb;
        System.out.println(dumpCommand);
        File tst = new File(ruta);
        FileWriter fw = null;
        try {
            fw = new FileWriter(tst);
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Runtime rt = Runtime.getRuntime();
        try {
            Process proc = rt.exec(dumpCommand);
            InputStream in = proc.getInputStream();
            InputStreamReader read = new InputStreamReader(in, "utf8");
            BufferedReader br = new BufferedReader(read);
            BufferedWriter bw = new BufferedWriter(new FileWriter(tst, true));
            String line = null;
            StringBuffer buffer = new StringBuffer();

            int count;
            char[] cbuf = new char[BUFFER];
            while ((count = br.read(cbuf, 0, BUFFER)) != -1) {
                buffer.append(cbuf, 0, count);
            }
            String toWrite = buffer.toString();
            bw.write(toWrite);
            bw.close();
            br.close();
            
            JOptionPane.showMessageDialog(null, "se ha creado un BACKUP de la base de datos correctamente...! en la ruta: " + ruta);                
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void escuchaComponentes(String opcion) {
        switch (opcion) {
            case "Plan Cuentas":

                VConmae vConmae = new VConmae(this, titulo, "grande", usuario, tabvar);
                vConmae.mostrarVentana();

                break;
            case "2":
                break;
            case "Parametros Tablas":

                VTabvar vTabvar = new VTabvar(this, titulo, "grande", usuario, tabvar);
                vTabvar.mostrarVentana();

                break;
            case "Emision Plan Cuentas":

                REmisionPC r = new REmisionPC(this, titulo, "grande", usuario, tabvar);
                r.mostrarVentana();

                break;
            case "Asiento Ingreso o Egreso":

                VContra iuSimple = new VContra(this, titulo, "grande", usuario, tabvar);
                iuSimple.mostrarVentana();

                break;
            case "Asiento de Diario":

                VContraDoble iuDoble = new VContraDoble(this, titulo, "grande", usuario, tabvar);
                iuDoble.mostrarVentana();

                break;
            case "Libro Diario":

                RLibroDiario iuLibro = new RLibroDiario(this, titulo, "grande", usuario);
                iuLibro.mostrarVentana();

                break;
            case "Libro Mayor":

                RMayorAnaliticoCuenta iuM = new RMayorAnaliticoCuenta(this, titulo, "grande", usuario, tabvar, "");
                iuM.mostrarVentana();

                break;
            case "Balance Comprobacion":

                RBalanceComprobacion iuBC = new RBalanceComprobacion(this, titulo, "grande", usuario, tabvar);
                iuBC.mostrarVentana();

                break;
            case "Perdidas y Ganancias":

                REstadoPerdidaGanancia iuEPG = new REstadoPerdidaGanancia(this, titulo, "grande", usuario, tabvar);
                iuEPG.mostrarVentana();

                break;
            case "Balance General":

                RBalanceGeneral iuBG = new RBalanceGeneral(this, titulo, "grande", usuario);
                iuBG.mostrarVentana();

                break;
            case "Claves de Acceso":

                VUsuario iuUsuario = new VUsuario(this, titulo, "grande", usuario);
                iuUsuario.mostrarVentana();

                break;
            case "Verificacion Asientos":
                VVerificacionAsientos iuVA = new VVerificacionAsientos(this, titulo, "grande", usuario, tabvar);
                iuVA.mostrarVentana();
                break;
            case "Actualizacion Diferida":
                VActualizacionDiferida iuAD = new VActualizacionDiferida(this, titulo, "grande", usuario, tabvar);
                iuAD.mostrarVentana();
                break;
            case "Cargar Tablas al Sistema":

                VOpciones iuOpciones = new VOpciones(this, titulo, "pequeno");
                iuOpciones.mostrarVentana();

                break;
            case "Respaldo":

                setOpacity(0.6f);
                IUOpcionRespaldo opcionBD = new IUOpcionRespaldo(this, "BASE DE DATOS", "pequeno");
                opcionBD.mostrarVentana();
                if (opcionBD.getEstado()) {
                    switch (opcionBD.getOpcion()) {
                        case "Restaurar B.D.":
                            
                            String ruta = "";
                            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de Imagen", "sql");
                            File archivo = new File(System.getProperty("user.dir"));
                            JFileChooser archivoRestaurar = new JFileChooser(archivo);
                            archivoRestaurar.setFileFilter(filter);
                            archivoRestaurar.setFileSelectionMode(JFileChooser.FILES_ONLY);
                            int se = archivoRestaurar.showOpenDialog(null);
                            if (se == JFileChooser.APPROVE_OPTION) {
                                ruta = archivoRestaurar.getSelectedFile().getPath();
                                importarBD(ruta);
                            }
                            
                            
                            break;
                        case "Backup B.D.":
                            
                            
                            String rutaBackup = "";
                            FileNameExtensionFilter filt = new FileNameExtensionFilter("Archivo de Imagen", "sql");
                            File arch = new File(System.getProperty("user.dir"));
                            JFileChooser archivoBackup = new JFileChooser(arch);
                            archivoBackup.setFileFilter(filt);
                            archivoBackup.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                            int respuesta = archivoBackup.showSaveDialog(null);
                            if (respuesta == JFileChooser.APPROVE_OPTION) {
                                rutaBackup = archivoBackup.getSelectedFile().getPath();
                                exportarBD(rutaBackup);
                            }

                            break;
                        case "Limpiar B.D.":
                            
                            if(Ayuda.mensaje(this, "Esta seguro que DESEA ELIMINAR los datos y las tablas del SISTEMA CONTABLE..? ", "pregunta")){
                                eliminarBD();
                            }
                            break;
                    }
                }
                setOpacity(1f);

                break;
            default:
                //Ayuda.mensaje(this, "usted selecciono la opcion: "+opcion, "informacion");
                break;
        }
    }
    private  void reconocimientoVoz() {
        //Escucha escucha = new Escucha();
        try {
            recognizer = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
            recognizer.allocate();

            FileReader grammar1 = new FileReader("libreria/diccionario.txt");

            RuleGrammar rg = recognizer.loadJSGF(grammar1);
            rg.setEnabled(true);
            
            Escucha escucha = new Escucha();
            recognizer.addResultListener(escucha);
            

            System.out.println("Empieze Dictado");
            recognizer.commitChanges();
            
            recognizer.requestFocus();
            recognizer.resume();
        } catch (IOException | IllegalArgumentException | SecurityException e) {
            System.out.println("Exception en " + e.toString());
            System.exit(0);
        } catch (EngineException | EngineStateError | GrammarException | AudioException ex) {
            Logger.getLogger(VPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    class Escucha extends ResultAdapter {
 
        String gst;
        public Escucha(){
            gst = "";
        }

        public void resultAccepted(ResultEvent re) {
            try {
                Result res = (Result) (re.getSource());
                ResultToken tokens[] = res.getBestTokens();
                
                String args[] = new String[1];
                args[0] = "";            
                gst = "";
                for (int i = 0; i < tokens.length; i++) {
                    gst = gst+" "+tokens[i].getSpokenText();
                    
                    //args[0] += gst + " ";
                    //System.out.print(gst + " ");
                }
                System.out.print(gst.trim());
                try {
                    escuchaComponentes(gst.trim());
                } catch (Exception e) {
                }
                
                
                
                System.out.println();
                
                
                if (gst.trim().equals("salir")) {
                    recognizer.deallocate();
                    args[0] = "Adios!";
                    System.out.println(args[0]);

                    System.exit(0);
                } else {
                    recognizer.suspend();
                    
                    recognizer.resume();
                }
            } catch (Exception ex) {
                System.out.println("Ha ocurrido algo inesperado " + ex);
            }
        }        
    }
}

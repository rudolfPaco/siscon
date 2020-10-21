/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.botones;

import SIGU.paneles.IUPanel;
import SIGU.paneles.SIUPanel;
import SIGU.recursos.Area;
import SIGU.recursos.Grid;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;

/**
 *
 * @author neo
 */
public class IUBoton extends JButton {

    private IUPanel panel;
    private Area area;
    private String urlImagen = "";
    private Color colorTexto = new Color(2, 67, 109);
    private int sizeText;
    private int sizeIcon;
    private int distanciaTextIcon;
    private int positionTextH;
    private int positionTextV;
    private char mnemonic;
    private String toolTipText;

    /**
     *
     * @param panel panel contenedor que el boton se establecera.
     * @param area la posicion en X, Y, el Ancho, Alto del Boton.
     * @param texto texto que se mostrara en el boton.
     * @param urlImagen la direccion de un icono que estara en el boton.
     * @param sizeText el tamaño del texto
     * @param sizeIcon el tamaño ancho y alto del icono.
     * @param distanciaTextIcon la distancia entre el texto y el icono.
     * @param positionTextH la posicion del texto en la parte horizontal,
     * Izquierda, Centro o Derecha.
     * @param positionTextV la posicion del texto en la parte vertical, Arriba,
     * Centro u Abajo.
     * @param mnemonic teclado rapido Alt+Letra que se activara para el
     * presionado del boton rapido.
     * @param toolTipText muestra una cadena de texto sobre la accion del boton.
     */
    public IUBoton(IUPanel panel, Area area, String texto, String urlImagen, int sizeText, int sizeIcon, int distanciaTextIcon, int positionTextH, int positionTextV, char mnemonic, String toolTipText) {
        super(texto);
        this.panel = panel;
        this.urlImagen = urlImagen;
        this.area = area;
        this.sizeText = sizeText;
        this.sizeIcon = sizeIcon;
        this.distanciaTextIcon = distanciaTextIcon;
        this.positionTextH = positionTextH;
        this.positionTextV = positionTextV;
        this.mnemonic = mnemonic;
        this.toolTipText = toolTipText;

        construirBoton();

    }

    private void construirBoton() {

        setOpaque(false);
        setToolTipText(toolTipText);
        setFocusable(false);
        setFont(new Font("Verdana", Font.PLAIN, sizeText));
        setForeground(colorTexto);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setHorizontalTextPosition(positionTextH);
        setVerticalTextPosition(positionTextV);
        setIconTextGap(distanciaTextIcon);
        setMnemonic(mnemonic);
        setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.WHITE, Color.LIGHT_GRAY, Color.WHITE));
        panel.agregar(this, area);

        if (!urlImagen.isEmpty()) {
            setIcon(new ImageIcon(new ImageIcon(getClass().getResource(urlImagen)).getImage().getScaledInstance(sizeIcon, sizeIcon, Image.SCALE_SMOOTH)));
        }
    }

    public void clickOnKey(String actionName, int key) {
        getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key, 0), actionName);

        getActionMap().put(actionName, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doClick();
            }
        });
    }
}

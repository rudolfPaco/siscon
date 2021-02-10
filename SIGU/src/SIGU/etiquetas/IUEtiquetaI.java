/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.etiquetas;

import SIGU.paneles.IUPanel;
import SIGU.recursos.Area;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author neo
 */
public class IUEtiquetaI extends JLabel{
    private IUPanel panel;
    private String urlImagen;
    private BufferedImage buffered;
    private Object objeto;
    private int inicioX;
    private int inicioY;
    private int x;
    private int y;
    private int moviendoX;
    private int moviendoY;
    private final Area area;
        
    /**
     * Interfaz de Usuario Etiqueta Imagen, hereda atributos y metodos del componente JLabel.
     * @param panel
     * @param urlImagen direccion de la imagen guardad en el disco.
     * @param area
     */
    public IUEtiquetaI(IUPanel panel, Area area, String urlImagen){
        this.panel = panel;
        this.area = area;
        this.urlImagen = urlImagen;
        this.buffered = null;
        this.objeto = null;
        
        construirEtiqueta();
    }
    private void construirEtiqueta(){
        panel.agregar(this, area);
        setOpaque(false);
        setToolTipText("");        
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.CENTER);
        setFocusable(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        construirImagen();           
    }
    private void construirImagen(){
        if(!urlImagen.isEmpty()){
            if (getClass().getResource(urlImagen) != null) {
                setIcon(new ImageIcon(new ImageIcon(getClass().getResource(urlImagen)).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)));
            } else {
                setIcon(new ImageIcon(new ImageIcon(urlImagen).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)));
            }
        }
    }    
    public void setUrlImagen(String urlImagen){
        this.urlImagen = urlImagen;
        construirImagen();
    }
    public String getUrlImagen(){
        return urlImagen;        
    }
    public BufferedImage getBuffered() {
        return buffered;
    }
    public void setBuffered(BufferedImage buffered) {
        this.buffered = buffered;        
    }
    public Object getObjeto() {
        return objeto;
    }
    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
    public void setMovimiento(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                inicioX = e.getX();
                inicioY = e.getY();                
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                moviendoX = e.getX();
                moviendoY = e.getY();

                int nuevaPosicionX = x + moviendoX - inicioX;
                int nuevaPosicionY = y + moviendoY - inicioY;

                // Movemos la etiqueta a la nueva posición
                setLocation( nuevaPosicionX,nuevaPosicionY );
                // Guarda la posición actual de la etiqueta
                x = nuevaPosicionX;
                y = nuevaPosicionY;
            }
        });
    }
}

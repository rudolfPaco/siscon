/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.campoTexto;

import SIGU.paneles.IUPanel;
import SIGU.recursos.Area;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;

/**
 *
 * @author neo
 */
public class IUCampoPrivado extends JPasswordField{
    
    private IUPanel panel;
    private int nroColumnas;
    private  int size;
    private Area area;
        
    /**
     * Interfaz de Usuario Campo de Texto, se crea el componente al inicio de tipo texto, pero se puede restringir los datos de entrada al campo de texto.
     * @param panel
     * @param texto cadena de caracteres que se mostraran al inicio en el componente.
     * @param size
     */
    public IUCampoPrivado(IUPanel panel, String texto, int size, Area area){
        super(texto);
        this.panel = panel;
        this.size = size;
        this.area = area;
        
        construirCampoTexto();
        agregarEventos();
    }

    /**
     *
     * @param panel
     * @param nroColumnas
     * @param size
     * @param area
     */
    public IUCampoPrivado(IUPanel panel, int nroColumnas, int size, Area area){
        super("");
        this.panel = panel;
        this.nroColumnas = nroColumnas;
        this.size = size;
        this.area = area;
        
        construirCampoTexto();
        agregarEventos();
    }
    private void construirCampoTexto(){
        
        panel.agregar(this, area);        
        setSelectedTextColor(new Color(2, 67, 109));
        setForeground(new Color(2, 67, 109));
        setFont(new Font("Verdana", Font.PLAIN, size));
        //setOpaque(false);
        setSelectionColor(new Color(0, 0, 0, 0));
        setMargin(new Insets(0, 0, 0, 0));
        setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.WHITE, Color.LIGHT_GRAY, Color.WHITE));        
    }    
    public void setEditar(boolean estado){
        setFocusable(estado);
        setEditable(estado);
    }
    private void agregarEventos(){
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //if(KeyEvent.VK_ENTER == e.getKeyCode()){
                //    transferFocus();
                //}
                if(KeyEvent.VK_F2 == e.getKeyCode())
                    transferFocusBackward();
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(getText().length() == nroColumnas)
                    e.consume();
            }
        });
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                setSelectionStart(0);
                setSelectionEnd(getText().length());
            }
        });
    }    
    public void setRestriccion(String restriccion){
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String cadena = Character.toString(e.getKeyChar());
                Pattern p = Pattern.compile(restriccion);
                Matcher matcher = p.matcher(cadena);  
                if(!matcher.find()) {
                    e.consume(); //hace que esa pulsación de tecla se rechace.                    
                    //Toolkit.getDefaultToolkit().beep();
                }
            }
        });        
    }
    public void setRestriccionNumeroDecimal(){
        
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                double number = 0.00;
                if(!getText().isEmpty()){
                    number = Double.parseDouble(getText());                
                    BigDecimal bd = new BigDecimal(number);
                    bd = bd.setScale(2, RoundingMode.HALF_UP);
                    setText(String.valueOf(bd.doubleValue()));
                }else{
                    BigDecimal bd = new BigDecimal(number);
                    bd = bd.setScale(2, RoundingMode.HALF_UP);
                    setText(String.valueOf(bd.doubleValue()));
                }                
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) 
                        && (caracter != KeyEvent.VK_BACK_SPACE)
                        && (caracter != '.' || getText().contains(".")) ) {
                            e.consume();
                }
                /*if(!Character.isDigit(e.getKeyChar()) && e.getKeyChar() != '.'){                    
                    e.consume();                    
                }
                if(e.getKeyChar() == '.' && getText().contains(".")){
                    e.consume();
                }*/
            }
        });
    }
}

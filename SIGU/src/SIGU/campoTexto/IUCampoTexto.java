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
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import sun.swing.SwingAccessor;

/**
 *
 * @author neo
 */
public class IUCampoTexto extends JTextField{
    private IUPanel panel;
    private int nroColumnas;
    private  int size;
    private Area area;
    private int posicionH = SwingConstants.LEFT;
    private Border bordeComponente;
        
    /**
     * Interfaz de Usuario Campo de Texto, se crea el componente al inicio de tipo texto, pero se puede restringir los datos de entrada al campo de texto.
     * @param panel
     * @param texto cadena de caracteres que se mostraran al inicio en el componente.
     * @param size
     * @param area
     */
    public IUCampoTexto(IUPanel panel, String texto, int size, Area area){
        super(texto);
        this.panel = panel;
        this.size = size;
        this.area = area;
        this.nroColumnas = 99999999;
        
        construirCampoTexto();
        agregarEventos();
    }

    /**
     *
     * @param panel
     * @param nroColumnas
     * @param size
     * @param area
     * @param posicionH
     */
    public IUCampoTexto(IUPanel panel, int nroColumnas, int size, Area area, int posicionH){
        super("");
        this.panel = panel;
        this.nroColumnas = nroColumnas;
        this.size = size;
        this.area = area;
        this.posicionH = posicionH;
        
        construirCampoTexto();
        agregarEventos();
        
    }
    private void construirCampoTexto(){
        
        panel.agregar(this, area);        
        setSelectedTextColor(getForeground());
        setForeground(new Color(2, 67, 109));
        setFont(new Font("Verdana", Font.PLAIN, size));
        setHorizontalAlignment(posicionH);
        setSelectionColor(new Color(0, 0, 0, 0));
        setMargin(new Insets(0, 0, 0, 0));
        setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.WHITE, Color.LIGHT_GRAY, Color.WHITE));        
        setBordeComponente(getBorder());
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
                //if(KeyEvent.VK_F2 == e.getKeyCode())
                    //transferFocusBackward();
            }
        });
        if(nroColumnas >= 0){
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if(getText().length() == nroColumnas)
                        e.consume();
                    
                }
            });
        }
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
    public void setRestriccionNumeroDecimal(int nroDecimal){
        
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                double number = 0.00;
                if(!getText().isEmpty()){
                    number = Double.parseDouble(getText());                
                    BigDecimal bd = new BigDecimal(number);
                    bd = bd.setScale(nroDecimal, RoundingMode.HALF_UP);
                    setText(String.valueOf(bd.doubleValue()));
                }else{
                    BigDecimal bd = new BigDecimal(number);
                    bd = bd.setScale(nroDecimal, RoundingMode.HALF_UP);
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

    public Border getBordeComponente() {
        return bordeComponente;
    }

    public void setBordeComponente(Border bordeComponente) {
        this.bordeComponente = bordeComponente;
    }
    
}

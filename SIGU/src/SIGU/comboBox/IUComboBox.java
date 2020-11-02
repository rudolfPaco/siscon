/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.comboBox;

import SIGU.paneles.IUPanel;
import SIGU.recursos.Area;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author neo
 */
public class IUComboBox extends JComboBox<String> {
    private IUPanel panel;
    private Area area;
    private String tipo;
    private boolean estadoTexto;
    private int size;
    private Color colorLetra = new Color(2, 67, 109);
    private ArrayList<String> opciones = new ArrayList<>();
    private int nroColumnas = 0;    
    private Border bordeComponente;
    
    /**
     * Interfaz de Usuario Combo Box, componente que hereda del JComboBox, recibe dos parametros; una lista de opciones y su limitacion. por defecto es editable, pero se puede restringir numeros decimales, enteros o letras, mayusculas.
     * @param panel
     * @param opciones lista de opciones que se reflejara en el componente.
     * @param area
     * @param size
     * @param nroColumnas
     */
    public IUComboBox(IUPanel panel, ArrayList<String> opciones, Area area, int size, int nroColumnas){
        super();        
        this.panel = panel;
        this.opciones = opciones;
        this.area = area;
        this.size = size;
        this.nroColumnas = nroColumnas;
        
        construirComboBox();
        setEventos();
    }
    public IUComboBox(IUPanel panel, ModeloComboBox modelo, Area area, int size){
        super(modelo);
        this.panel = panel;
        this.area = area;
        this.size = size;
        
        construirComboBox();
        //setEventos();
    }
    
    private void construirComboBox(){
        panel.agregar(this, area);
        opciones.forEach((item) -> this.addItem(item));
        setFocusable(true);
        //setEditable(true);        
        //setOpaque(false);        
        setFont(new Font("Verdana", Font.PLAIN, size));
        //setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.WHITE, Color.LIGHT_GRAY, Color.WHITE));
        //setColorLetra(colorLetra);
        setForeground(colorLetra);
        setTipo("");        
        setBordeComponente(getBorder());
        //setDeshabilitarTexto(true);
        //setOpacidad(false);                
    }

    /**
     *
     * @param opciones
     */
    public void actualizarOpciones(ArrayList<String> opciones){        
        removeAllItems();
        this.opciones = opciones;        
        this.opciones.forEach((item) -> this.addItem(item));
        
    }
    public void actualizarDatos(ModeloComboBox modelo){
        setModel(modelo);
    }

    public String getTexto(){
        return ((JTextField)getEditor().getEditorComponent()).getText();
    }
    public void setColorLetra(Color colorLetra){        
        ((JTextField)getEditor().getEditorComponent()).setForeground(colorLetra);
    }
    public void setOpacidad(boolean opacidad){
        ((JTextField)getEditor().getEditorComponent()).setOpaque(opacidad);
    }
    
    public void setEditar(boolean estado){
        setFocusable(estado);
        setEnabled(estado);
        ((JTextField)getEditor().getEditorComponent()).setEditable(estado);        
    }
    private void setEventos(){
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //if(KeyEvent.VK_ENTER == e.getKeyCode()){
                //    transferFocus();
                //}
                //if(KeyEvent.VK_F2 == e.getKeyCode())
                  //  transferFocusBackward();
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(getTexto().length() == nroColumnas)
                    e.consume();
            }
        });
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                ((JTextField)getEditor().getEditorComponent()).setSelectionStart(0);
                ((JTextField)getEditor().getEditorComponent()).setSelectionEnd(((JTextField)getEditor().getEditorComponent()).getText().length());
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
                if(!((JTextField)getEditor().getEditorComponent()).getText().isEmpty()){
                    number = Double.parseDouble(((JTextField)getEditor().getEditorComponent()).getText());                
                    BigDecimal bd = new BigDecimal(number);
                    bd = bd.setScale(nroDecimal, RoundingMode.HALF_UP);
                    ((JTextField)getEditor().getEditorComponent()).setText(String.valueOf(bd.doubleValue()));
                }else{
                    BigDecimal bd = new BigDecimal(number);
                    bd = bd.setScale(nroDecimal, RoundingMode.HALF_UP);
                    ((JTextField)getEditor().getEditorComponent()).setText(String.valueOf(bd.doubleValue()));
                }                
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) 
                        && (caracter != KeyEvent.VK_BACK_SPACE)
                        && (caracter != '.' || ((JTextField)getEditor().getEditorComponent()).getText().contains(".")) ) {
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

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public boolean isEstadoTexto() {
        return estadoTexto;
    }
    public void setDeshabilitarTexto(boolean estado) {
        this.estadoTexto = estado;
    }

    public Border getBordeComponente() {
        return bordeComponente;
    }

    public void setBordeComponente(Border bordeComponente) {
        this.bordeComponente = bordeComponente;
    }
    
}

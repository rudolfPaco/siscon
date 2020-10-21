/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.campoTexto;

import SIGU.paneles.IUPanel;
import SIGU.paneles.SIUPanel;
import SIGU.recursos.Area;
import SIGU.recursos.Grid;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JFormattedTextField;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author neo
 */
public class IUFormatoCampoTexto {
    
    private IUPanel panel;
    private String texto;
    private String restriccion;
    private int minimoDigitos;
    private int maximoDigitos;
    private int size;
    private Area area;
    private Color colorTexto = new Color(2, 67, 109);
    //private MaskFormatter mascara;
    public JFormattedTextField formatoNumerico = null;
    public JFormattedTextField formatoFecha = null;
    private int positionDato;

    /**
     * Creamos el formato de nuestra contraseña # -> un número U -> letra
     * mayúscula L -> letra minúscula. -> cualquier caracter ' -> caracteres de
     * escape. A -> cualquier letra o número ? -> cualquier caracter. H ->
     * cualquier caracter hexagonal (0-9, a-f or A-F).
     *
     * @param panel contendor para el FormatFieldText.
     * @param area determina la posicion X, Y, Ancho y Alto del componente
     * JFormatFieldText.
     * @param restriccion restrige el tipo de datos que se va a utilizar en este
     * componente.
     * @param size determina el tamaño de la letra del campo de texto.
     * @param positionDato posiciona el ingreso de datos en el campo de texto.
     */
    public IUFormatoCampoTexto(IUPanel panel, Area area, String restriccion, int size, int positionDato) {
        this.panel = panel;
        this.area = area;
        this.restriccion = restriccion;
        this.size = size;
        this.positionDato = positionDato;

        construirCampoTexto();
        addEventos();
    }

    /**
     *
     * @param panel
     * @param area
     * @param size
     * @param positionDato
     */
    public IUFormatoCampoTexto(IUPanel panel, Area area, int size, int positionDato) {
        this.panel = panel;
        this.area = area;
        this.size = size;
        this.positionDato = positionDato;
        
        construirFormatoFecha();
        addEventosFecha();
    }   
    private void construirFormatoFecha(){
        formatoFecha = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        formatoFecha.setFocusLostBehavior(JFormattedTextField.COMMIT);
        formatoFecha.setHorizontalAlignment(positionDato);
        panel.agregar(formatoFecha, area);
        formatoFecha.setSelectedTextColor(colorTexto);
        formatoFecha.setForeground(colorTexto);
        formatoFecha.setFont(new Font("Verdana", Font.PLAIN, size));
        //input.setOpaque(false);
        formatoFecha.setSelectionColor(new Color(0, 0, 0, 0));
        formatoFecha.setMargin(new Insets(0, 0, 0, 0));
        //input.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.WHITE, Color.LIGHT_GRAY, Color.WHITE));
        MaskFormatter mascara;
        // Entramos en un try/catch por alguna eventualidad
        try {
            // Creamos el formato de nuestra contraseña
            // # -> un número U -> letra mayúscula L -> letra minúscula
            // * -> cualquier caracter ' -> caracteres de escape
            // A -> cualquier letra o número ? -> cualquier caracter
            // H -> cualquier caracter hexagonal (0-9, a-f or A-F).
            mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            mascara.setAllowsInvalid(false);            
            mascara.install(formatoFecha);
        } catch (ParseException e) {
            System.out.println("error: "+e.getMessage());
        }        
    }
    private void construirCampoTexto() {
        DecimalFormat formato = (DecimalFormat) NumberFormat.getNumberInstance();
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
        otherSymbols.setDecimalSeparator('.');
        otherSymbols.setGroupingSeparator(',');
        formato.setDecimalFormatSymbols(otherSymbols);
        formato.applyPattern(restriccion);        
        //formato.setDecimalSeparatorAlwaysShown(true);
        //formato.setPositivePrefix("");        
        formato.setRoundingMode(RoundingMode.HALF_UP);
        //formato.setMaximumIntegerDigits(maximoDigitos);
        //formato.setMaximumFractionDigits(2);
        //formato.setMinimumIntegerDigits(minimoDigitos);        
        formatoNumerico = new JFormattedTextField(formato);            
        formatoNumerico.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
        formatoNumerico.setHorizontalAlignment(positionDato);
        panel.agregar(formatoNumerico, area);
        formatoNumerico.setSelectedTextColor(colorTexto);
        formatoNumerico.setForeground(colorTexto);
        formatoNumerico.setFont(new Font("Verdana", Font.PLAIN, size));
        formatoNumerico.setOpaque(false);
        formatoNumerico.setSelectionColor(new Color(0, 0, 0, 0));
        formatoNumerico.setMargin(new Insets(0, 0, 0, 0));
        formatoNumerico.setBorder(new BevelBorder(BevelBorder.RAISED, Color.LIGHT_GRAY, Color.WHITE, Color.LIGHT_GRAY, Color.WHITE));
    }
    private void addEventosFecha(){
        formatoFecha.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    formatoFecha.transferFocus();
                }
                if(KeyEvent.VK_ESCAPE == e.getKeyCode())
                    formatoFecha.transferFocusBackward();
            }
        });
    }
    private void addEventos(){
        formatoNumerico.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(KeyEvent.VK_ENTER == e.getKeyCode()){
                    formatoNumerico.transferFocus();
                }
                if(KeyEvent.VK_ESCAPE == e.getKeyCode())
                    formatoNumerico.transferFocusBackward();
            }
        });        
        formatoNumerico.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                formatoNumerico.setSelectionStart(0);
                formatoNumerico.setSelectionEnd(formatoNumerico.getText().length());
            }
        });
        /*formatoNumerico.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                Double amount = Double.parseDouble(formatoNumerico.getText());
                NumberFormat numberFormatter;
                String amountOut;

                numberFormatter = NumberFormat.getNumberInstance();
                numberFormatter.setMaximumFractionDigits(2);
                numberFormatter.setRoundingMode(RoundingMode.HALF_UP);
                amountOut = numberFormatter.format(amount);
                formatoNumerico.setText(amountOut);
            }
        });*/
    }
    public void setEditarNumeros(boolean estado){
        formatoNumerico.setEditable(estado);
        formatoNumerico.setFocusable(estado);
    }
    public void setEditarFechas(boolean estado){
        formatoFecha.setEditable(estado);
        formatoFecha.setFocusable(estado);
    }
}

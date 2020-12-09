/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.tablas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author neo
 */
public class RenderDatosDecimales extends DefaultTableCellRenderer{
    private int[] columnas;
    
    public RenderDatosDecimales(int[] columnas){
        this.columnas = columnas;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        Component c = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        int contador = 0;
        boolean encontrado = false;
        while(contador < columnas.length && !encontrado){
            if(columnas[contador] == column){
                DecimalFormat df = new DecimalFormat("#,###,##0.00");
                //DecimalFormatSymbols dfs = df.getDecimalFormatSymbols();
                //dfs.setDecimalSeparator('.');
                //df.setDecimalFormatSymbols(dfs);
                              
                if(!String.valueOf(value).isEmpty() && value != null){
                    try {
                        ((JLabel)c).setText(df.format(Double.parseDouble((String) value)));
                    } catch (NumberFormatException e) {System.out.println(e);}
                }                    
                ((JLabel)c).setHorizontalAlignment(SwingConstants.RIGHT);
            }
            contador++;
        }        
        return c;
    }
}

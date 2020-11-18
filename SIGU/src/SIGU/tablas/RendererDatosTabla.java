/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.tablas;

/**
 *
 * @author neo
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

public class RendererDatosTabla extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        Component c = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        if(isSelected){
            ((JLabel)c).setBorder(new LineBorder(new Color(2, 67, 109)));
            
            c.setFont(new Font("Verdana", Font.BOLD, 14));
            c.setForeground(new Color(2, 67, 109));//
            if((Integer)table.getValueAt(row, 8) == 1){
                c.setBackground(Color.WHITE);
            }else{
                c.setBackground(new Color(193, 255, 224));
            }
        }else{
            if((Integer)table.getValueAt(row, 8) == 1){
                c.setBackground(Color.WHITE);
            }else{
                c.setBackground(new Color(193, 255, 224));
            }
        }
        if(column == 6)
            ((JLabel)c).setHorizontalAlignment(SwingConstants.LEFT);
        else
            ((JLabel)c).setHorizontalAlignment(SwingConstants.CENTER);
        
        return c;
    }
}

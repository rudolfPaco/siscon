package SIGU.tablas;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 * Permite personalizar el encabezado de la tabla para definir el color que tendr� en las 
 * columnas
 * @author CHENAO
 *
 */
public class RenderCabeceraTabla  implements TableCellRenderer {

    private final Font fuente;

    private final Color colorCabecera;
    private final Color colorTexto;
    private final boolean pintar;
    private final int columna;
    private final Color colorColumna;
    
    public RenderCabeceraTabla(Font fuente, Color colorCabecera, Color colorTexto, boolean pintar, int columna, Color colorColumna){
        this.fuente = fuente;
        this.colorCabecera = colorCabecera;
        this.colorTexto = colorTexto;        
        this.pintar = pintar;
        this.columna = columna;
        this.colorColumna = colorColumna;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        Component c = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setBackground( colorCabecera );
        c.setForeground( colorTexto );
        c.setFont(fuente);
        ((JLabel)c).setHorizontalAlignment(SwingConstants.CENTER);
        ((JLabel)c).setBorder(new LineBorder(new Color(210, 210, 210)));
        if(pintar)
            if(column == columna)
                c.setBackground(colorColumna);
        
        return c;
    }


}

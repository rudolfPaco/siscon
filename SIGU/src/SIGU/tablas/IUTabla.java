/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.tablas;

import SIGU.paneles.IUPanel;
import SIGU.paneles.SIUPanel;
import SIGU.recursos.Area;
import SIGU.recursos.Grid;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author neo
 */
public class IUTabla {
    public JScrollPane deslizador;
    private IUPanel panel;
    public JTable tabla;
    public Area area;   
    
    public ModeloTabla modeloTabla = new ModeloTabla();
    
    private final String[] nombreCabecera;//{"ID","NOMBRE","TIPO","DIRECCION URL"};
    private ArrayList lista; //new ArrayList<>();
    private final Class[] tipos; //{Integer.class, String.class, String.class, String.class, String.class, String.class};
    private final int[] porcentajes; //{5, 30, 15, 50};
    
    private Color colorFondoCabecera = new Color(232, 237, 244);//new Color(2, 67, 109);
    private Color colorLetraCabecera = new Color(255, 255, 255);
    private Color colorSeleccionFondo = Color.YELLOW;//new Color(242, 238, 236);
    private Color colorLetra = new Color(2, 67, 109);
    private Color colorGrid = Color.LIGHT_GRAY;
    
    public IUTabla(IUPanel panel, Area area, String[] nombreCabecera, Class[] tipos, int[] porcentajes, ArrayList lista, ModeloTabla modelo){
        this.panel = panel;
        this.area = area;
        this.nombreCabecera = nombreCabecera;
        this.tipos = tipos;
        this.porcentajes = porcentajes;
        this.lista = lista;
        this.modeloTabla = modelo;
        
        construirTabla();        
    }
    private void construirTabla(){
        modeloTabla.setModelo(nombreCabecera, tipos, lista);
        
        tabla = new JTable(modeloTabla);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.setShowHorizontalLines(false);
        tabla.setShowVerticalLines(true);
        tabla.setFillsViewportHeight(true);
        tabla.setCursor(new Cursor(Cursor.HAND_CURSOR));        
        tabla.setFocusable(false);        
        tabla.setRowSelectionAllowed(true);
        tabla.setGridColor(colorGrid);
        tabla.setSelectionBackground(colorSeleccionFondo);        
        tabla.setForeground(colorLetra);
        for (int i = 0; i < nombreCabecera.length; i++) {
            setPosicionTextoHorizontal(i, SwingConstants.CENTER);
        }
        setFuenteCabecera(new Font("Verdana", Font.PLAIN, 14), colorFondoCabecera, colorLetraCabecera);
        setFuente(new Font("Verdana", Font.PLAIN, 14));
        agregarAnchoColumnas(porcentajes);
        
        /*final TableRowSorter<TableModel> sorter = new TableRowSorter<>(iuTabla.tabla.getModel());
        iuTabla.tabla.setRowSorter(sorter);
        try {
            sorter.setRowFilter(RowFilter.regexFilter(dato));
        } catch (Exception ex) {System.out.println("Error: Tabla Plan de Cuentas"+ex.getMessage());}*/
        
        
        /*iuTabla.tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e) {                
            }
        });*/
        
        deslizador = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        deslizador.setBorder(new BevelBorder(BevelBorder.RAISED, colorGrid, colorLetraCabecera, colorGrid, colorLetraCabecera));        
        deslizador.setFocusable(false);
        panel.agregar(deslizador, area);
    }
    public void actualizarTabla(ArrayList lista){
        this.lista = lista;
        modeloTabla.limpiarTabla();
        modeloTabla.setModelo(nombreCabecera, tipos, lista);        
    }
    public void setColorTabla(Color colorFondoCabecera, Color colorLetraCabecera, Color colorGrid, Color colorSeleccionFondo, Color colorLetra){
        this.colorFondoCabecera = colorFondoCabecera;
        this.colorLetraCabecera = colorLetraCabecera;
        this.colorGrid = colorGrid;
        this.colorSeleccionFondo = colorSeleccionFondo;
        this.colorLetra = colorLetra;
        construirTabla();
    }
    public void setColumnaRender(int columna){
        tabla.getColumnModel().getColumn(columna).setCellRenderer(tabla.getTableHeader().getDefaultRenderer());
    }
    public void setPosicionTextoHorizontal(int numeroColumna, int posicionHorizontal){
        if(numeroColumna < modeloTabla.getColumnCount()){
            DefaultTableCellRenderer columnaCeldasTabla = new DefaultTableCellRenderer();
            columnaCeldasTabla.setHorizontalAlignment(posicionHorizontal);
            tabla.getColumnModel().getColumn(numeroColumna).setCellRenderer(columnaCeldasTabla);
        }
    }
    public void setFuenteCabecera(Font fuente, Color colorCabecera, Color colorLetra){
        JTableHeader th = tabla.getTableHeader();          
        th.setBackground(colorCabecera);
        th.setForeground(colorLetra);
        th.setFont(fuente);
    }
    public void setCellRender(int numeroColumna, TableCellRenderer render){
        if(numeroColumna < modeloTabla.getColumnCount())
            tabla.getColumnModel().getColumn(numeroColumna).setCellRenderer(render);
    }
    public void agregarAnchoColumnas(int[] porcentajes) {
        int ancho = area.An();//panel.getGrid().getAncho(area.getNroColumnas());//deslizador.getWidth();
        int anchoColumna;
        TableColumnModel modeloColumna = tabla.getColumnModel();
        TableColumn columnaTabla;
        for (int i = 0; i < modeloTabla.getColumnCount(); i++) {
            columnaTabla = modeloColumna.getColumn(i);
            anchoColumna = (porcentajes[i] * ancho) / 100;            
            columnaTabla.setPreferredWidth(anchoColumna);
        }
    }
    public void setFuente(Font fuente_letra){
        tabla.setRowHeight(fuente_letra.getSize() + 7);
        tabla.setFont(fuente_letra);        
    }
    public boolean isFilaSeleccionado(){
        boolean filaSeleccionada = false;
        if(tabla.getSelectedRow() > -1)
            filaSeleccionada = true;
        return filaSeleccionada;
    }
    public void addEvento(MouseAdapter mouse){        
        tabla.addMouseListener(mouse);
        /*tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent Mouse_evt) {
                JTable table = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
                int row = table.rowAtPoint(point);

                if (row > -1) {

                }
            }
        });*/
    }
}

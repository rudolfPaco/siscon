/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.comboBox;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author neo
 */
public class ModeloComboBox extends AbstractListModel<String> implements ComboBoxModel<String>{
    
    private ArrayList<String> lista;
    private String itemSeleccion;
    
    public ModeloComboBox(ArrayList<String> lista){
        this.lista = lista;
        this.itemSeleccion = "";
    }

    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public String getElementAt(int index) {
        return lista.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.itemSeleccion = anItem.toString();
    }

    @Override
    public Object getSelectedItem() {
        return itemSeleccion;
    }    
}

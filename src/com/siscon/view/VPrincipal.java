/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.view;

import SIGU.recursos.Grid;
import SIGU.ventanas.SIUPrincipal;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author neo
 */
public class VPrincipal extends SIUPrincipal{
    
    private JMenuBar iuMenuBar;
    private JMenu iuMenuArchivos;
    private JMenuItem menuItemNuevo;
    private JMenuItem menuItemSalir;
    private JMenu iuMenuInformes;
    private JMenu iuMenuMiscelaneos;
    
    public VPrincipal(String titulo, String urlIcono) {
        super(titulo, urlIcono);
        
        construirMenuBar();
        addEventos();
    }    
    private void construirMenuBar(){        
        iuMenuBar = new JMenuBar();
        
        iuMenuArchivos = new JMenu("Archivos");
        iuMenuArchivos.setMnemonic(KeyEvent.VK_A);
        
        menuItemNuevo = new JMenuItem("Nuevo", new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/new.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        menuItemNuevo.setMnemonic(KeyEvent.VK_N);
        menuItemNuevo.setToolTipText("crear nueva tabla TAVBAR");
        
        menuItemSalir = new JMenuItem("Salir", new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/cerrar.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        menuItemSalir.setMnemonic(KeyEvent.VK_S);
        menuItemSalir.setToolTipText("Salir de la Aplicacion");
        
        iuMenuArchivos.add(menuItemNuevo);                
        iuMenuArchivos.add(menuItemSalir);
        
        iuMenuInformes = new JMenu("Informes");
        iuMenuInformes.setMnemonic(KeyEvent.VK_I);
        
        iuMenuMiscelaneos = new JMenu("Miscelaneos");
        iuMenuMiscelaneos.setMnemonic(KeyEvent.VK_M);
        
        iuMenuBar.add(iuMenuArchivos);
        iuMenuBar.add(iuMenuInformes);
        iuMenuBar.add(iuMenuMiscelaneos);
        
        setJMenuBar(iuMenuBar);
    }
    private void construirPaneles(){
        VTabvar iuTabvar = new VTabvar(this, "mediano");
        iuTabvar.setVisible(true);
        //VITabvar vTabvar = new VITabvar(this, "intermedio");
        //vTabvar.mostrarVentana();
    }
    private void addEventos(){
        menuItemNuevo.addActionListener((e) -> {
            construirPaneles();
        });
        menuItemSalir.addActionListener((e) -> System.exit(0));
    }    
}

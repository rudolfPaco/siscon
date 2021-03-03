/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.controller;

import com.siscon.dao.UsuarioDao;
import com.siscon.model.Usuario;

/**
 *
 * @author neo
 */
public class CLogueo {
    
    public static Usuario getUsuario(){
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = null;
        try {
            usuario = usuarioDao.getUsuario("SELECT * FROM usuario");
        } catch (Exception e) {
            System.out.println("Warning: no existe el usuario... getUsuario(): "+e.getMessage());
        }
        return usuario;
    }
    public static boolean guardarUsuario(Usuario usuario){
        boolean verificador = false;
        UsuarioDao usuarioDao = new UsuarioDao();
        if(usuarioDao.saveUsuario(usuario))
            verificador = true;
        return verificador;
    }
    public static boolean modificarUsuario(Usuario u){
        boolean verificador = false;
        UsuarioDao usuarioDao = new UsuarioDao();
        if(usuarioDao.modifyUsuario(u))
            verificador = true;
        return verificador;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.model;

/**
 *
 * @author neo
 */
public class User {
    private int id;
    private int tipo;
    private int numero;
    private int codcon;
    private int correl;
    
    private String nro;
    private String usuario;
    private String password;
    private String fecha1;
    private String fecha2;

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodcon() {
        return codcon;
    }

    public void setCodcon(int codcon) {
        this.codcon = codcon;
    }

    public int getCorrel() {
        return correl;
    }

    public void setCorrel(int correl) {
        this.correl = correl;
    }
    
    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFecha1() {
        return fecha1;
    }

    public void setFecha1(String fecha1) {
        this.fecha1 = fecha1;
    }

    public String getFecha2() {
        return fecha2;
    }

    public void setFecha2(String fecha2) {
        this.fecha2 = fecha2;
    }

    @Override
    public String toString() {
        return "User{" + "nro=" + nro + ", usuario=" + usuario + ", password=" + password + '}';
    }
    
    
}

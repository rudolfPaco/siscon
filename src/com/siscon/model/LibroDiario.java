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
public class LibroDiario {
    private String fecha;
    private String comprobante;
    private String item;
    private String codigo;
    private String cuenta;
    private String concepto;
    private String debe;
    private String haber;
    private String dorales;

    public LibroDiario(String fecha, String comprobante, String item, String codigo, String cuenta, String concepto, String debe, String haber, String dorales) {
        this.fecha = fecha;
        this.comprobante = comprobante;
        this.item = item;
        this.codigo = codigo;
        this.cuenta = cuenta;
        this.concepto = concepto;
        this.debe = debe;
        this.haber = haber;
        this.dorales = dorales;
    }
    public LibroDiario(){
        
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getDebe() {
        return debe;
    }

    public void setDebe(String debe) {
        this.debe = debe;
    }

    public String getHaber() {
        return haber;
    }

    public void setHaber(String haber) {
        this.haber = haber;
    }

    public String getDorales() {
        return dorales;
    }

    public void setDorales(String dorales) {
        this.dorales = dorales;
    }

    @Override
    public String toString() {
        return "LibroDiario{" + "fecha=" + fecha + ", comprobante=" + comprobante + ", item=" + item + ", codigo=" + codigo + ", cuenta=" + cuenta + ", concepto=" + concepto + ", debe=" + debe + ", haber=" + haber + ", dorales=" + dorales + '}';
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.model;

import java.util.ArrayList;

/**
 *
 * @author neo
 */
public class Asiento {
    
    private int id;
    private String tipoDoc;
    private String doc;
    private String numero;
    private String fecha;
    private String montoIncial;
    private String montoLiteral;
    private String origen;
    private String concepto;
    private String descripcion;
    private String nroCuenta;
    private String banco;
    private String cheque;
    
    private ArrayList<Asiento> lista = new ArrayList<>();
    
    private int nro;
    private long codigo;
    private String cuenta;
    private double debe;
    private double haber;
    private double monto;

    public Asiento(int nro) {
        this.nro = nro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public String getMontoIncial() {
        return montoIncial;
    }

    public void setMontoIncial(String montoIncial) {
        this.montoIncial = montoIncial;
    }

    public String getMontoLiteral() {
        return montoLiteral;
    }

    public void setMontoLiteral(String montoLiteral) {
        this.montoLiteral = montoLiteral;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getCheque() {
        return cheque;
    }

    public void setCheque(String cheque) {
        this.cheque = cheque;
    }

    public ArrayList<Asiento> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Asiento> lista) {
        this.lista = lista;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public double getDebe() {
        return debe;
    }

    public void setDebe(double debe) {
        this.debe = debe;
    }

    public double getHaber() {
        return haber;
    }

    public void setHaber(double haber) {
        this.haber = haber;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Asiento{" + "id=" + id + ", tipoDoc=" + tipoDoc + ", doc=" + doc + ", numero=" + numero + ", fecha=" + fecha + ", montoIncial=" + montoIncial + ", montoLiteral=" + montoLiteral + ", origen=" + origen + ", concepto=" + concepto + ", descripcion=" + descripcion + ", nroCuenta=" + nroCuenta + ", banco=" + banco + ", cheque=" + cheque + ", lista=" + lista + ", nro=" + nro + ", codigo=" + codigo + ", cuenta=" + cuenta + ", debe=" + debe + ", haber=" + haber + ", monto=" + monto + '}';
    }

}

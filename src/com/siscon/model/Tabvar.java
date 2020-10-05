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
public class Tabvar {
    
    private int record;
    private int tipo;
    private int numero;
    private String descri;
    private int codcon;
    private int correl;
    private double monto;
    private String observ;
    private String fecha;
    private String fecha2;
    private double monto2;
    private double tipcam;
    private int numnit;

    public Tabvar(int record) {
        this.record = record;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
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

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha2() {
        return fecha2;
    }

    public void setFecha2(String fecha2) {
        this.fecha2 = fecha2;
    }

    public double getMonto2() {
        return monto2;
    }

    public void setMonto2(double monto2) {
        this.monto2 = monto2;
    }

    public double getTipcam() {
        return tipcam;
    }

    public void setTipcam(double tipcam) {
        this.tipcam = tipcam;
    }

    public int getNumnit() {
        return numnit;
    }

    public void setNumnit(int numnit) {
        this.numnit = numnit;
    }

    @Override
    public String toString() {
        return "Tabvar{" + "record=" + record + ", tipo=" + tipo + ", numero=" + numero + ", descri=" + descri + ", codcon=" + codcon + ", correl=" + correl + ", monto=" + monto + ", observ=" + observ + ", fecha=" + fecha + ", fecha2=" + fecha2 + ", monto2=" + monto2 + ", tipcam=" + tipcam + ", numnit=" + numnit + '}';
    }
}

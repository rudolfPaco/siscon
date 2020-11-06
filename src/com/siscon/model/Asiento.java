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
public class Asiento {
    private int nro;
    private long codigo;
    private String cuenta;
    private double debe;
    private double haber;
    private double monto;

    public Asiento(int nro) {
        this.nro = nro;
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
        return "Asiento{" + "nro=" + nro + ", codigo=" + codigo + ", cuenta=" + cuenta + ", deber=" + debe + ", haber=" + haber + ", monto=" + monto + '}';
    }
}

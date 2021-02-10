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
public class Contra {
    private int id;
    private int tipcon;
    private int numcom;
    private int correl;
    private String fecha;
    private int grupo;
    private int subgru;
    private int mayor;
    private int cuenta;
    private int subcta;
    private int apropi;
    private double monto1;
    private double monto2;
    private double tipcam;
    private int indica;
    private String nombre;
    private String glosa;
    private int cheque;
    private int numcue;
    private long cuetot;
    private int reduce;
    private int tipcom;
    private int intern;
    private int numint;
    private int empres;
    
    private double debeB;
    private double haberB;
    private double totalB;
    
    private double debeD;
    private double haberD;
    private double totalD;
    
    private String comprobanteItem;
    private String codigo;
    private String debe;
    private String haber;
    private String dolares;
    
    public Contra(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipcon() {
        return tipcon;
    }

    public void setTipcon(int tipcon) {
        this.tipcon = tipcon;
    }

    public int getNumcom() {
        return numcom;
    }

    public void setNumcom(int numcom) {
        this.numcom = numcom;
    }

    public int getCorrel() {
        return correl;
    }

    public void setCorrel(int correl) {
        this.correl = correl;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public int getSubgru() {
        return subgru;
    }

    public void setSubgru(int subgru) {
        this.subgru = subgru;
    }

    public int getMayor() {
        return mayor;
    }

    public void setMayor(int mayor) {
        this.mayor = mayor;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public int getSubcta() {
        return subcta;
    }

    public void setSubcta(int subcta) {
        this.subcta = subcta;
    }

    public int getApropi() {
        return apropi;
    }

    public void setApropi(int apropi) {
        this.apropi = apropi;
    }

    public double getMonto1() {
        return monto1;
    }

    public void setMonto1(double monto1) {
        this.monto1 = monto1;
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

    public int getIndica() {
        return indica;
    }

    public void setIndica(int indica) {
        this.indica = indica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public int getCheque() {
        return cheque;
    }

    public void setCheque(int cheque) {
        this.cheque = cheque;
    }

    public int getNumcue() {
        return numcue;
    }

    public void setNumcue(int numcue) {
        this.numcue = numcue;
    }

    public long getCuetot() {
        return cuetot;
    }

    public void setCuetot(long cuetot) {
        this.cuetot = cuetot;
    }

    public int getReduce() {
        return reduce;
    }

    public void setReduce(int reduce) {
        this.reduce = reduce;
    }

    public int getTipcom() {
        return tipcom;
    }

    public void setTipcom(int tipcom) {
        this.tipcom = tipcom;
    }

    public int getIntern() {
        return intern;
    }

    public void setIntern(int intern) {
        this.intern = intern;
    }

    public int getNumint() {
        return numint;
    }

    public void setNumint(int numint) {
        this.numint = numint;
    }
    public int getEmpres() {
        return empres;
    }
    public void setEmpres(int empres) {
        this.empres = empres;
    }

    public double getDebeB() {
        return debeB;
    }

    public void setDebeB(double debeB) {
        this.debeB = debeB;
    }

    public double getHaberB() {
        return haberB;
    }

    public void setHaberB(double haberB) {
        this.haberB = haberB;
    }

    public double getTotalB() {
        return totalB;
    }

    public void setTotalB(double totalB) {
        this.totalB = totalB;
    }

    public double getDebeD() {
        return debeD;
    }

    public void setDebeD(double debeD) {
        this.debeD = debeD;
    }

    public double getHaberD() {
        return haberD;
    }

    public void setHaberD(double haberD) {
        this.haberD = haberD;
    }

    public double getTotalD() {
        return totalD;
    }

    public void setTotalD(double totalD) {
        this.totalD = totalD;
    }

    public String getComprobanteItem() {
        return comprobanteItem;
    }

    public void setComprobanteItem(String comprobanteItem) {
        this.comprobanteItem = comprobanteItem;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getDolares() {
        return dolares;
    }

    public void setDolares(String dolares) {
        this.dolares = dolares;
    }
    
    
    @Override
    public String toString() {
        return "Asiento{" + "id=" + id + ", tipcon=" + tipcon + ", numcom=" + numcom + ", correl=" + correl + ", fecha=" + fecha + ", grupo=" + grupo + ", subgru=" + subgru + ", mayor=" + mayor + ", cuenta=" + cuenta + ", subcta=" + subcta + ", apropi=" + apropi + ", monto1=" + monto1 + ", monto2=" + monto2 + ", tipcam=" + tipcam + ", indica=" + indica + ", nombre=" + nombre + ", glosa=" + glosa + ", cheque=" + cheque + ", numcue=" + numcue + ", cuetot=" + cuetot + ", reduce=" + reduce + ", tipcom=" + tipcom + ", intern=" + intern + ", numint=" + numint + ", empres=" + empres + '}';
    }
}

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
public class Usuario {

    private int id;
    private String razsoc;
    private int numusu;
    private String fecusu;
    private double tipcam;
    private int codjjc;
    private String dirraz;
    private long numnit;

    public Usuario(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazsoc() {
        return razsoc;
    }

    public void setRazsoc(String razsoc) {
        this.razsoc = razsoc;
    }

    public int getNumusu() {
        return numusu;
    }

    public void setNumusu(int numusu) {
        this.numusu = numusu;
    }

    public String getFecusu() {
        return fecusu;
    }

    public void setFecusu(String fecusu) {
        this.fecusu = fecusu;
    }

    public double getTipcam() {
        return tipcam;
    }

    public void setTipcam(double tipcam) {
        this.tipcam = tipcam;
    }

    public int getCodjjc() {
        return codjjc;
    }

    public void setCodjjc(int codjjc) {
        this.codjjc = codjjc;
    }

    public String getDirraz() {
        return dirraz;
    }

    public void setDirraz(String dirraz) {
        this.dirraz = dirraz;
    }

    public long getNumnit() {
        return numnit;
    }

    public void setNumnit(long numnit) {
        this.numnit = numnit;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", razsoc=" + razsoc + ", numusu=" + numusu + ", fecusu=" + fecusu + ", tipcam=" + tipcam + ", codjjc=" + codjjc + ", dirraz=" + dirraz + ", numnit=" + numnit + '}';
    }
    
}

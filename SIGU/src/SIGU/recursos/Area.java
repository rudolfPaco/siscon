/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SIGU.recursos;

/**
 *
 * @author neo
 */
public class Area {

    private int x;
    private int y;
    private int Ancho;
    private int Alto;

    public Area(int x, int y, int An, int Al) {
        this.x = x;
        this.y = y;
        this.Ancho = An;
        this.Alto = Al;
    }
    public Area(int An, int Al) {
        this.x = 0;
        this.y = 0;
        this.Ancho = An;
        this.Alto = Al;
    }

    public int X() {
        return x;
    }
    public int X(int veces){
        return x*veces;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int Y() {
        return y;
    }
    public int Y(int veces){
        return y*veces;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int An() {
        return Ancho;
    }
    public int An(int veces){
        return Ancho*veces;
    }

    public void setAncho(int Ancho) {
        this.Ancho = Ancho;
    }

    public int Al() {
        return Alto;
    }
    public int Al(int veces){
        return Alto*veces;
    }

    public void setAlto(int Alto) {
        this.Alto = Alto;
    }
    public int AnP(int p){
        return (p*Ancho)/100;
    }
    public int AlP(int p){
        return (p*Alto)/100;
    }

    @Override
    public String toString() {
        return "Area{" + "x=" + x + ", y=" + y + ", Ancho=" + Ancho + ", Alto=" + Alto + '}';
    }
    
}

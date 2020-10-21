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
public class Grid {
    
    private Arena area;
    private int puntosHorizontales = 13;
    private int puntoVerticales = 13;
    
    private  int[] columnas;
    private  int[] filas;
    
    private int anchoCelda;
    private int altoCelda;
    
    private int x;
    private int y;
    private int ancho;
    private int alto;
    
    public Grid(Arena area, int ladoHorizontal, int ladoVertical){
        this.area = area;
        this.puntosHorizontales = ladoHorizontal;
        this.puntoVerticales = ladoVertical;
        
        this.x = 0;
        this.y = 0;
        this.ancho = ladoHorizontal-1;
        this.alto = ladoVertical-1;
                
        construirGrid();
    }
    
    public Grid(Arena area, int x, int y, int ancho, int alto){
        this.area = area;
        
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto; 
        
        construirGrid();
    }
    
    public Grid(int puntosHorizontales, int puntosVerticales, int x, int y, int ancho, int alto){
        this.area = new Arena(0, 0);
        
        this.puntosHorizontales = puntosHorizontales;
        this.puntoVerticales = puntosVerticales;
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;                
        
        construirGrid();
    }
    
    public Grid(int columna, int fila, int nroColumnas, int nroFilas){
        this.area = new Arena(0, 0);
        
        this.x = columna;
        this.y = fila;
        this.ancho = nroColumnas;
        this.alto = nroFilas;                
    }
    
    private void construirGrid(){        
        columnas = new int[puntosHorizontales];
        filas  = new int[puntoVerticales];
        
        anchoCelda = area.getAnchoArea()/(puntosHorizontales-1);
        altoCelda = area.getAltoArea()/(puntoVerticales-1);
        
        for (int i = 0; i < puntosHorizontales; i++) {            
            columnas[i] = i*anchoCelda;            
        }
        for (int i = 0; i < puntoVerticales; i++) {
            filas[i] = i*altoCelda;
        }
    }

    /*GET y SET de la DIMENSION DEL GRID*/
    public Arena getArea() {
        return area;
    }
    public void setArea(Arena area) {
        this.area = area;        
        construirGrid();
    }
    /*---------------------------------------------*/    
       
    public int getAnchoTotal(){
        return area.getAnchoArea();
    }
    public int getAltoTota(){
        return area.getAltoArea();
    }
    /*GET y SET de COLUMNA, FILA, NROCOLUMNA, NROFILA*/
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getAncho() {
        return ancho;
    }
    public int getAlto() {
        return alto;
    }
    
    public int getAnchoCelda(int columna){
        return columnas[columna];
    }
    public int getAltoCelda(int fila){
        return filas[fila];
    }
    /*---------------------------------------------*/
    
    /*GET DEL ARREGLO DE FILAS y COLUMNAS*/
    public int[] getColumnas() {
        return columnas;
    }    
    public int[] getFilas() {    
        return filas;
    }
    /*---------------------------------------------*/
    
    
    /*GET y SET de LONGITUD*/
    public int getPuntosHorizontales() {
        return puntosHorizontales;
    }
    public void setPuntosHorizontales(int puntosHorizontales) {
        this.puntosHorizontales = puntosHorizontales;
    }
    /*---------------------------------------------*/

    @Override
    public String toString() {
        return "Grid{" + "area=" + area + ", ladoHorizontal=" + puntosHorizontales + ", ladoVertical=" + puntoVerticales + ", columnas=" + columnas + ", filas=" + filas + ", anchoCelda=" + anchoCelda + ", altoCelda=" + altoCelda + ", x=" + x + ", y=" + y + ", ancho=" + ancho + ", alto=" + alto + '}';
    }
}

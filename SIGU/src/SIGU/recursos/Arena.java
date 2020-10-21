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
public class Arena {
    
    private int anchoArea;
    private int altoArea;
    
    public Arena(int anchoTotal, int altoTotal){
        this.anchoArea = anchoTotal;
        this.altoArea = altoTotal;
    }

    public Arena() {
        
    }

    public int getAnchoArea() {
        return anchoArea;
    }
    public void setAnchoArea(int anchoArea) {
        this.anchoArea = anchoArea;
    }
    public int getAltoArea() {
        return altoArea;
    }
    public void setAltoArea(int altoArea) {
        this.altoArea = altoArea;
    }
}

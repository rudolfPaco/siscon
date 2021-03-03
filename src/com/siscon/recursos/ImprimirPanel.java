/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.recursos;

import SIGU.paneles.IUPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 *
 * @author Rudolf
 */
public class ImprimirPanel  implements Printable {

    private String tipoColor = "";
    private IUPanel panel;
    
    public ImprimirPanel(IUPanel panel){        
        this.panel = panel;
        
        PrinterJob pj = PrinterJob.getPrinterJob();
        PageFormat formatoPagina = pj.defaultPage();
        
        Paper paper = formatoPagina.getPaper();
        //le paso las dimensiones del papel, y el metodo fromCMToPPI() convierte de centimetros a pixeles.
        double width = fromCMToPPI(22);
        double height = fromCMToPPI(28);

        //establecemos el tamaño del papel, con un ancho y alto
        //paper.setSize(width, height);        
        //establecemos el area de impresion en el papel
        paper.setImageableArea(fromCMToPPI(0.0), fromCMToPPI(0.0), width - fromCMToPPI(0.0), height - fromCMToPPI(0.0));

        //establecemos la orientacion del papel... en este caso es vertical
        formatoPagina.setOrientation(PageFormat.PORTRAIT);
        //al formatoPapel le pasamos el papel configurado
        formatoPagina.setPaper(paper);
        
        Book book = new Book();
        book.append(this, formatoPagina);
        pj.setPageable(book);        

        try {    
            if(pj.printDialog()){
                pj.print();
            }            
        } catch (PrinterException ex) { System.out.println("Error.... ImprimirPanel(): "+ex.getMessage()); }
    }
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

        if (pageIndex > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }
        
        Graphics2D g2d = (Graphics2D) graphics;
         //Rectangle2D outline = new Rectangle2D.Double(pageFormat.getImageableX(), pageFormat.getImageableY(), pageFormat.getImageableWidth(), pageFormat.getImageableHeight());
        //g2d.draw(outline);
        
        panel.printAll(g2d);
        return PAGE_EXISTS;
    }
    protected static double fromCMToPPI(double cm) {
        return toPPI(cm * 0.393700787);
    }

    protected static double toPPI(double inch) {
        return inch * 72d;
    }
    private BufferedImage getBufferImagen(BufferedImage imageActual){
        switch(tipoColor){
            case "BLANCO_NEGRO":
                //Variables que almacenarán los píxeles
                int mediaPixel,colorSRGB;
                Color colorAux;

                //Recorremos la imagen píxel a píxel
                for( int i = 0; i < imageActual.getWidth(); i++ ){
                    for( int j = 0; j < imageActual.getHeight(); j++ ){
                        //Almacenamos el color del píxel
                        colorAux = new Color(imageActual.getRGB(i, j));
                        //Calculamos la media de los tres canales (rojo, verde, azul)
                        mediaPixel=(int)((colorAux.getRed()+colorAux.getGreen()+colorAux.getBlue())/3);
                        //Cambiamos a formato sRGB
                        colorSRGB=(mediaPixel << 16) | (mediaPixel << 8) | mediaPixel;
                        //Asignamos el nuevo valor al BufferedImage
                        imageActual.setRGB(i, j,colorSRGB);
                    }
                }
            break;
        }
        
        //Retornamos la imagen
        return imageActual;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.recursos;

import SIGU.recursos.Fecha;
import com.toedter.calendar.JCalendar;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author neo
 */
public class Ayuda {

    public static String examinarArchivo(JFrame ventanaPrincipal, String direccionBuscar) {

        String direccionArchivo = "";
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de Imagen", "jpg", "png", "txt");
        File archivo = new File(direccionBuscar);

        JFileChooser fileChooser = new JFileChooser(archivo);
        fileChooser.setFileFilter(filter);
        fileChooser.setVisible(true);

        int result = fileChooser.showOpenDialog(ventanaPrincipal);

        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                URL url = fileChooser.getSelectedFile().toURL();
                BufferedImage buffered = ImageIO.read(url);
                direccionArchivo = url.getPath();
            } catch (IOException ex) {
                System.err.println("Ayuda.examinarArchivo(): " + ex.getMessage());
            }
        }
        return direccionArchivo;
    }

    public static String cambiarFormatoFecha(String fecha) {
        System.out.println("la fecha es: "+fecha);
        if(!fecha.isEmpty()){
            try {            
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);//yyyy-MM-dd'T'HH:mm:ss                
                SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd");
                long date = sdf.parse(fecha).getTime();
                String formattedTime = output.format(date);
                return formattedTime;
            } catch (ParseException ex) {
                Logger.getLogger(Ayuda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        return fecha;
    }

    public static String formatDate(String fecha) {
        String resultado = "";
        String formatoInicial = "dd/MM/yyyy";
        String formatoFinal = "yyyy-MM-dd";
        if (!fecha.isEmpty()) {
            try {
                Date initDate = new SimpleDateFormat(formatoInicial).parse(fecha);
                SimpleDateFormat formatter = new SimpleDateFormat(formatoFinal);
                resultado = formatter.format(initDate);
            } catch (ParseException ex) {
                Logger.getLogger(Ayuda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    public static String FormateaFecha(String vFecha) {
        if(!vFecha.isEmpty()){
            String vDia, vMes, vAno;
            StringTokenizer tokens = new StringTokenizer(vFecha, "/");
            
            vDia = tokens.nextToken();
            vMes = tokens.nextToken();
            vAno = tokens.nextToken();
            return vAno + "-" + vMes + "-" + vDia;
        }else
            return "";        
    }

    public static void main(String[] arg) {
        String fecha = "01/01/2015";
        System.out.println("la fecha es: " + fecha);
        System.out.println("la convertimos: " + Ayuda.formatDate(fecha));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siscon.recursos;

import com.siscon.bd.Conexion;
import com.siscon.view.VPrincipal;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author neo
 */
public class Ayuda {
    public static Color COLOR_FONDO = new Color(232, 237, 244);
    public static Color COLOR_TEXTO = new Color(2, 67, 109);
    public static Color COLOR_ROJO = new Color(120, 0, 0);
    public static Color COLOR_ATENCION = new Color(255, 255, 159);

    public static String getTipoDoc(int numero){
        String tipcon = "";
        switch(numero){
            case 1: 
                tipcon = "I";
            break;
            case 2: 
                tipcon = "E";
            break;
            case 3: 
                tipcon = "D";
            break;            
        }
        return tipcon;
    }
    
    public static String getParseCadena(char[] caracteres){
        String dato = "";        
        for (int i = 0; i < caracteres.length; i++) {
            dato = dato + caracteres[i];
        }
        return dato;
    }
    public static void mostrarMensajeError(VPrincipal ventana, String mensaje, String titulo){
        JOptionPane.showMessageDialog( ventana, mensaje, titulo, JOptionPane.ERROR_MESSAGE );
    }
    public static void mostrarMensajeInformacion(VPrincipal ventana, String mensaje, String titulo){
        JOptionPane.showMessageDialog( ventana , mensaje , titulo , JOptionPane.INFORMATION_MESSAGE );
    }
    public static boolean mostrarMensajeConfirmacion(VPrincipal ventana, String mensaje, String titulo){
        boolean respuesta = false;
        int resp = JOptionPane.showConfirmDialog( ventana , mensaje , titulo , JOptionPane.YES_NO_OPTION );
        if( resp == JOptionPane.YES_OPTION ){
            respuesta = true;
        }
        return respuesta;
    }
    public static String[] toArreglo(ArrayList<String> lista){
        String[] arreglo = new String[lista.size()+1];
        int indice = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if(i == 0)
                arreglo[i] = "";
            else{
                arreglo[i] = lista.get(indice);
                indice++;
            }
        }
        return arreglo;
    }
    
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
    public static ArrayList<String> aOpciones(ArrayList<String> lista, String primeraOpcion){
        String[] arreglo = new String[lista.size()+1];
        int indice = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if(i == 0)
                arreglo[i] = primeraOpcion;
            else{
                arreglo[i] = lista.get(indice);
                indice++;
            }
        }
        ArrayList<String> opciones = new ArrayList<>();
        for (int i = 0; i < arreglo.length; i++) {
            String dato = arreglo[i];
            opciones.add(dato);
        }
        return opciones;
    }
    public static ArrayList<String> getListColumnas(String columna, String sql){        
        ArrayList<String> lista = new ArrayList<>();
        Conexion conexion = new Conexion();
        try {            
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();            
            while (rs.next()) {
                if(!rs.getString(columna).isEmpty())
                    lista.add(rs.getString(columna));
            }            
        } catch (SQLException e) {            
            System.out.println("Error Ayuda.getListColumnas: " + e.getMessage());            
        }
        conexion.cerrar_conexion();
        return lista;
    }
    public static String getDatoCadena(String columna, String sql){        
        Conexion conexion = new Conexion();
        String dato = "";
        try {            
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();            
            while (rs.next()) {
                dato = rs.getString(columna);
            }
        } catch (SQLException e) {            
            System.out.println("Error Ayuda.getDatoCadena: " + e.getMessage());            
        }
        conexion.cerrar_conexion();
        return dato;
    }
    
    public static int getDatoEntero(String columna, String sql){        
        Conexion conexion = new Conexion();
        int dato = 0;
        try {            
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();            
            while (rs.next()) {
                dato = rs.getInt(columna);
            }
        } catch (SQLException e) {            
            System.out.println("Error Ayuda.getDatoEntero: " + e.getMessage());            
        }
        conexion.cerrar_conexion();
        return dato;
    }
    
    public static double getDatoDecimal(String columna, String sql){        
        Conexion conexion = new Conexion();
        double dato = 0;
        try {            
            PreparedStatement preparedStatement = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();            
            while (rs.next()) {
                dato = rs.getDouble(columna);
            }
        } catch (SQLException e) {            
            System.out.println("Error Ayuda.getDatoEntero: " + e.getMessage());            
        }
        conexion.cerrar_conexion();
        return dato;
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
    public static double acotarNumero(double numero, int cota){
        BigDecimal big = new BigDecimal(numero);
        return big.setScale(cota, RoundingMode.HALF_UP).doubleValue();
    }
    public static String formatearNumber(double number){
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        return df.format(number);
    }
    public static ArrayList<String> splinter(String texto){
        String palabra = "";
        ArrayList<String> lista = new ArrayList<>();
        char[] c = texto.trim().toCharArray();
        boolean[] pasos = {false, true};
        boolean paso = true;
        int j = 0;
        for (int i = 0; i < c.length; i++){
            //System.out.println("i = "+i+"    "+c[i]);
            if(c[i] == '"'){                
                paso = pasos[j];
                if(paso == true)
                    j = 0;
                else
                    j = 1;
            }else{
                if(paso == true){
                    if(c[i] == ','){                        
                        lista.add(palabra);
                        palabra = "";
                    }else{
                        palabra = palabra+c[i];
                    }
                }else{
                    palabra = palabra+c[i];
                }
            }            
        }
        lista.add(palabra);        
        return lista;
    }
    /*public static void main(String[] arg) {
        String fecha = "01/01/2015";
        ArrayList<String> lista = Ayuda.splinter("3,19896,19,\"31/01/2011\",1,1,1,4,2,1,3520.00,500.00,7.04,5,\"\",\"DEPOSITO AMPARO TOKO, MARIA PARRADO, MA. RODRIGUEZ\",0,11,11010402,0,3,0,0,1");
        for (int i = 0; i < lista.size(); i++) {
            String cadena = lista.get(i);
            System.out.println(cadena);
        }
        
        System.out.println("la convertimos: " + Ayuda.formatDate(fecha));
    }*/
}

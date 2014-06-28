/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import dibujo.AreaDibujo;
import interfaz.Interfaz;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GuardarArchivo implements ActionListener{

    public AreaDibujo areaDibujo;
    public File file;
    public FileWriter myWriter;
    public PrintWriter escritor;
    public FileNameExtensionFilter filtro;
    public Estado estado;
    public JFileChooser fileChooser;
    public boolean flag;
            
    public GuardarArchivo(AreaDibujo areaDibujo){
        this.areaDibujo=areaDibujo;
        Interfaz.guardarArchivo.addActionListener(this);
        Interfaz.menuGuardar.addActionListener(this);
        fileChooser=new JFileChooser();
        filtro=new FileNameExtensionFilter("Archivo cgx","cgx","CGX");
        fileChooser.setFileFilter(filtro);
        estado=new Estado();
        file=null;
        flag=false;
    }
    
    public String obtener(){
        String ruta =new String();
        while(true){
         try{
                if(fileChooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
                    if(fileChooser.getSelectedFile().exists()==false){
                        ruta=fileChooser.getSelectedFile().getAbsolutePath()+".cgx";
                        break;
                    }else {
                        String mensaje=new String();
                        int respuesta;
                        mensaje=String.format("EL ARCHIVO QUE INTENTA GUARDAR YA EXISTE\n"
                                + "¿DESEA SOBREESCRIBIRLO?");
                        respuesta=JOptionPane.showConfirmDialog(areaDibujo, mensaje);
                        if(respuesta==JOptionPane.YES_OPTION){
                            ruta=fileChooser.getSelectedFile().getAbsolutePath();
                            fileChooser.getSelectedFile().delete();
                            break;   
                        }
                        if(respuesta==JOptionPane.CANCEL_OPTION){
                            flag=true;
                            return null;
                        }
                    }
                    
                       }else{
                    flag=true;
                    return null;
                }
            
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "ARCHIVO NO VALIDO");            
            }
        }
        return ruta;
    }
    
    public void guardarComo() throws IOException {
        int indicePuntos;
        int indiceAristas;
        String ruta= new String();
        estado.guardarDatos(areaDibujo);
        indicePuntos=estado.indicePuntos;
        indiceAristas=estado.indiceAristas;
        while(true){
            try{
            ruta=obtener();
            if(ruta==null){
                break;
            }
            else{
                 Interfaz.file=new File(ruta);
            }
            file=new File(ruta);
            myWriter=new FileWriter(file);
            escritor=new PrintWriter(myWriter);
            escritor.print(indicePuntos);
            escritor.println();
            escritor.print(indiceAristas);
            for(int i=0; i<=indicePuntos; i++){
                escritor.println();
                escritor.print(i);
                escritor.println();
                escritor.print(estado.puntos[i].getPosicion().x);
                escritor.println();
                escritor.print(estado.puntos[i].getPosicion().y);
                escritor.println();
                escritor.print(estado.puntos[i].colorPunto.getRed());
                escritor.println();
                escritor.print(estado.puntos[i].colorPunto.getGreen());
                escritor.println();
                escritor.print(estado.puntos[i].colorPunto.getBlue());
                escritor.println();
                escritor.print(estado.puntos[i].forma);
                escritor.println();
                escritor.print(estado.puntos[i].circle);
                escritor.println();
                if(estado.puntos[i].getEtiqueta().equals("")){
                    escritor.print(false);
                } else {
                    escritor.print(true);
                    escritor.println();
                    escritor.print(estado.puntos[i].getEtiqueta());
                }
                
            }
            for(int i=0; i<=indiceAristas; i++){
                escritor.println();
                escritor.print(i);
                escritor.println();
                escritor.print(estado.aristas[i].getOrigen());
                escritor.println();
                escritor.print(estado.aristas[i].getDestino());
                escritor.println();
                escritor.print(estado.aristas[i].esDirigida());
                escritor.println();
                escritor.print(estado.aristas[i].colorArista.getRed());
                escritor.println();
                escritor.print(estado.aristas[i].colorArista.getGreen());
                escritor.println();
                escritor.print(estado.aristas[i].colorArista.getBlue());
                escritor.println();
                escritor.print(estado.aristas[i].peso);
                escritor.println();
                escritor.print(estado.aristas[i].tamaño);
            }
            for(int i=0; i<10; i++){
                for(int j=0; j<10; j++){
                    escritor.println();
                    escritor.print(estado.matriz[i][j]);
                }
                
            }
            Interfaz.frameDibujo.setTitle(file.getName());
            myWriter.close();
            escritor.close();
            Interfaz.mensajeAcciones.setForeground(Color.green);
            Interfaz.mensajeAcciones.setText("ARCHIVO GUARDADO");
            break;
            } 
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "NO SE PUDE MODIFICAR EL ARCHIVO");  
            }
            finally{
                    try{
                        myWriter.close();
                        escritor.close();
                        break;
                    }
                    catch(NullPointerException n){
                        //return;
                    }
            }
        }
    
    }
    
    public void guardar() throws IOException{
        
        int indicePuntos;
        int indiceAristas;
        estado.guardarDatos(areaDibujo);
        indicePuntos=estado.indicePuntos;
        indiceAristas=estado.indiceAristas;
        file=Interfaz.file;
        myWriter=new FileWriter(file);
        escritor=new PrintWriter(myWriter);
        escritor.print(indicePuntos);
        escritor.println();
        escritor.print(indiceAristas);
        for(int i=0; i<=indicePuntos; i++){
            escritor.println();
            escritor.print(i);
            escritor.println();
            escritor.print(estado.puntos[i].getPosicion().x);
            escritor.println();
            escritor.print(estado.puntos[i].getPosicion().y);
               escritor.println();
                escritor.print(estado.puntos[i].colorPunto.getRed());
                escritor.println();
                escritor.print(estado.puntos[i].colorPunto.getGreen());
                escritor.println();
                escritor.print(estado.puntos[i].colorPunto.getBlue());
                escritor.println();
                escritor.print(estado.puntos[i].forma);
                escritor.println();
                escritor.print(estado.puntos[i].circle);
                escritor.println();
            if(estado.puntos[i].getEtiqueta().equals("")){
            escritor.print(false);
            } else {
                escritor.print(true);
                escritor.println();
                escritor.print(estado.puntos[i].getEtiqueta());
                }
                
            }
        for(int i=0; i<=indiceAristas; i++){
            escritor.println();
            escritor.print(i);
            escritor.println();
            escritor.print(estado.aristas[i].getOrigen());
            escritor.println();
            escritor.print(estado.aristas[i].getDestino());
            escritor.println();
            escritor.print(estado.aristas[i].esDirigida());
            escritor.println();
                escritor.print(estado.aristas[i].colorArista.getRed());
                escritor.println();
                escritor.print(estado.aristas[i].colorArista.getGreen());
                escritor.println();
                escritor.print(estado.aristas[i].colorArista.getBlue());
                escritor.println();
                escritor.print(estado.aristas[i].peso);
                escritor.println();
                escritor.print(estado.aristas[i].tamaño);
        }
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                escritor.println();
                escritor.print(estado.matriz[i][j]);
            }

        }
        Interfaz.frameDibujo.setTitle(file.getName());
        myWriter.close();
        escritor.close();
        Interfaz.mensajeAcciones.setForeground(Color.green);
        Interfaz.mensajeAcciones.setText("ARCHIVO GUARDADO");
    } 

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Interfaz.archivo==true){
            try {
                guardar();
            } catch (IOException ex) {
                Logger.getLogger(GuardarArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                guardarComo();
            } catch (IOException ex) {
                Logger.getLogger(GuardarArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(file!=null){
            Interfaz.file=file;
            Interfaz.archivo=true;
        } 
        if(flag=false){
            Interfaz.file=file;
            Interfaz.archivo=true;
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import dibujo.AreaDibujo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import interfaz.Interfaz;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author voragoth
 */
public class GuardarComo implements ActionListener{
    private AreaDibujo areaDibujo;
    private File file;
    private FileWriter myWriter;
    private PrintWriter escritor;
    private FileNameExtensionFilter filtro;
    private Estado estado;
    private JFileChooser fileChooser;
    private boolean flag;
    
    public GuardarComo(AreaDibujo areaDibujo){
        this.areaDibujo=areaDibujo;
        Interfaz.menuGuardarComo.addActionListener(this);
        fileChooser=new JFileChooser();
        filtro=new FileNameExtensionFilter("Archivo cgx","cgx","CGX");
        fileChooser.setFileFilter(filtro);
        estado=new Estado();
        file=null;
        flag=false;
    }
    
    public void guardar() throws IOException{
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
                }
            }
        }
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

            } else{
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
    

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            guardar();
        } catch (IOException ex) {
            Logger.getLogger(GuardarComo.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(flag=false){
        Interfaz.file=file;
        Interfaz.archivo=true;
        }
    }
    
}

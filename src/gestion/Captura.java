/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import interfaz.Interfaz;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import interfaz.Interfaz;
import javax.swing.JInternalFrame;
public class Captura{
   private Dimension screenSize ;
   private Point p;
   private String tipo = "jpg";
   private String path = "c:/";
   private JInternalFrame Screen;
     public void setpath(String f){
        this.path = f;
        
     }

    public void setdimension(Dimension d){
        this.screenSize = d;
    }

    public void setpoint(Point p){
            this.p = p;
    }

    public void settipo(String t){
        this.tipo = t;
    }

    public Captura(javax.swing.JInternalFrame Screen){
        int inf=0;
        this.screenSize = Screen.getSize();
        this.screenSize.height-=31;
        this.screenSize.width-=16;
        
        this.p =Screen.getLocationOnScreen();
        this.p.y+=25;
        this.p.x+=8;
        this.Screen=Screen;
         captureScreen();
  }

    public void captureScreen()  {
        try {
           
            Rectangle screenRectangle = new Rectangle(p, screenSize);
            Robot robot = new Robot();
            BufferedImage image = robot.createScreenCapture(screenRectangle);
             JFileChooser fileChooser = new JFileChooser();
     
        fileChooser.setFileFilter(new FileNameExtensionFilter("Mapa de bits (*.bmp)","bmp","BMP"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("PNG (*.png)","png","PNG"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("JPEG (*.jpg)","*.jpg","JPG"));
        
        if(fileChooser.showSaveDialog(Screen)==0){
        this.path=fileChooser.getSelectedFile().getAbsolutePath();
        
         if(fileChooser.getFileFilter().getDescription()=="Mapa de bits (*.bmp)")
          this.tipo = "bmp";
         if(fileChooser.getFileFilter().getDescription()=="JPEG (*.jpg)")
          this.tipo = "jpg";
         if(fileChooser.getFileFilter().getDescription()=="PNG (*.png)")
          this.tipo = "png";
        }
        else
         return;   
            ImageIO.write(image, tipo, new File(path + "." + tipo));
        } catch (IOException ex) {
            Logger.getLogger(Captura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AWTException ex) {
            Logger.getLogger(Captura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
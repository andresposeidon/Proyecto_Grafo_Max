
package dibujo;

import base.Extras;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import interfaz.Interfaz;
public class Arista {
    
    public Punto puntoA;
    public Punto puntoB;
    private Point inicio;
    private Point fin;
    private int posicion;
    boolean dirigido;
    public int peso=0;
    public Color colorArista=Color.BLACK;
    public Color colorArista2=Color.BLACK;
    final double ARISTA_FLECHA=Math.sqrt(80);
    public int tamaño=1;
    public Arista(Punto puntoA, Punto puntoB, boolean dirigido,int posicion){
        
        this.puntoA=puntoA;
        this.puntoB=puntoB;
        this.dirigido=dirigido;
        this.posicion=posicion;
    }
    
    public boolean esDirigida(){
        return dirigido;
    }
    
    public void setDirigida(boolean dirigido){
        this.dirigido=dirigido;
    }
    
    public boolean estaContenido(Point p){
        
        double x1=puntoA.getPosicion().x;
        double y1=puntoA.getPosicion().y;
        double x2=puntoB.getPosicion().x;
        double y2=puntoB.getPosicion().y;
        double x=p.getX();
        double y=p.getY();
        
        double xMayor=Extras.mayor(x1,x2);
        double xMenor=Extras.menor(x1,x2);
        double yMayor=Extras.mayor(y1,y2);
        double yMenor=Extras.menor(y1,y2);
        
       
         if(y1==y2)
        if(y<=y2+2&&y>=y2-2){
            if(x<xMayor&&x>xMenor){
                return true;
            }
        }
        if(x1==x2 || (xMayor-xMenor)<=10)
        if(x<=x1+2&&x>=x1-2){
            if(y<yMayor&&y>yMenor){
                 return true;
            }
        }

        if((x<=xMayor&&x>=xMenor)&&(y<=yMayor&&y>=yMenor)){
            double m=(y2-y1)/(x2-x1);
            double b=y1-m*x1;
            double z=y-m*x;
                if((z<=(b+5)) && (z>=(b-5))){
                        return true;
                        
                        
                    }
        }

        return false;
    }
    public void setTamaño(int n)
    {
    this.tamaño=n;
    }
    public void setPeso(int peso)
    {
    this.peso=peso;
    }        
    public void setColores(Color color)
    {
    this.colorArista=color;
    }
    public void pintarArista(Graphics g){
        
        inicio=puntoA.getPosicion();
        fin=puntoB.getPosicion();
        
        Graphics2D g2=(Graphics2D) g;
      
        g2.setColor(colorArista);
        
        try
        {
        if(AreaDibujo.aristas[posicion].tamaño==1)
         g2.setStroke(new BasicStroke(1.0f));
        if(AreaDibujo.aristas[posicion].tamaño==2)
         g2.setStroke(new BasicStroke(1.7f));
        if(AreaDibujo.aristas[posicion].tamaño==3)
         g2.setStroke(new BasicStroke(2.3f));
        if(AreaDibujo.aristas[posicion].tamaño==4)
         g2.setStroke(new BasicStroke(3.0f));
        }catch(Exception eo)
                {
                
                }
         g2.drawLine(inicio.x+4, inicio.y+4, fin.x+4, fin.y+4);
       
        if(dirigido==true){
            pintarFlecha(g, inicio, fin);
        }
       if(!Interfaz.ocultapesoaris.isSelected()){
           g2.setColor(Color.BLUE);
          g2.drawString(peso+"",(inicio.x+fin.x)/2,(inicio.y+fin.y)/2);
       }
    }
    
    public void pintarArista(Graphics g, Color color){
        
        inicio=puntoA.getPosicion();
        fin=puntoB.getPosicion();
        colorArista2=color;
        Graphics2D g2=(Graphics2D) g;
        
        g2.setColor(color);
        try
        {
        if(AreaDibujo.aristas[posicion].tamaño==1)
         g2.setStroke(new BasicStroke(1.0f));
        if(AreaDibujo.aristas[posicion].tamaño==2)
         g2.setStroke(new BasicStroke(1.7f));
        if(AreaDibujo.aristas[posicion].tamaño==3)
         g2.setStroke(new BasicStroke(2.3f));
        if(AreaDibujo.aristas[posicion].tamaño==4)
         g2.setStroke(new BasicStroke(3.0f));
        }
        catch(Exception e)
        {}
        g2.drawLine(inicio.x+4, inicio.y+4, fin.x+4, fin.y+4);
        
        if(dirigido==true){
            pintarFlecha(g, inicio, fin);
        }
        
    }
    public void pintarArista(Graphics g, int y){
        if(colorArista2!=colorArista){
            inicio=puntoA.getPosicion();
            fin=puntoB.getPosicion();
        
        Graphics2D g2=(Graphics2D) g;
      
        g2.setColor(colorArista);
        
        try
        {
        if(AreaDibujo.aristas[posicion].tamaño==1)
         g2.setStroke(new BasicStroke(1.0f));
        if(AreaDibujo.aristas[posicion].tamaño==2)
         g2.setStroke(new BasicStroke(1.7f));
        if(AreaDibujo.aristas[posicion].tamaño==3)
         g2.setStroke(new BasicStroke(2.3f));
        if(AreaDibujo.aristas[posicion].tamaño==4)
         g2.setStroke(new BasicStroke(3.0f));
        }catch(Exception eo)
                {
                
                }
         g2.drawLine(inicio.x+4, inicio.y+4, fin.x+4, fin.y+4);
       
        if(dirigido==true){
            pintarFlecha(g, inicio, fin);
        }
       if(!Interfaz.ocultapesoaris.isSelected()){
           g2.setColor(Color.BLUE);
          g2.drawString(peso+"",(inicio.x+fin.x)/2,(inicio.y+fin.y)/2);
       }
       colorArista2=colorArista;
       AreaDibujo.puntos[puntoA.getIndice()].pintarPunto(g);
       AreaDibujo.puntos[puntoB.getIndice()].pintarPunto(g);
        }
    }
    
    public int getOrigen(){
        return puntoA.getIndice();
    }
    
    public int getDestino(){
        return puntoB.getIndice();
    }
    

    public void pintarFlecha(Graphics g, Point origen, Point destino){
        
        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point();
        Point p4 = new Point();

        int xD=destino.x+4;
        int yD=destino.y+4;
        int xO=origen.x+4;
        int yO=origen.y+4;
        
        Graphics2D g2= (Graphics2D) g;
        
        if(xD==xO){
            //revisado
            p1.x=xD;
            p2.x=xD;
            p3.x=xD;
            p4.x=xD;

            if(yD<yO){
                p1.y=yD+10;
                p2.y=yD+12;
                p3.y=yD+14;
                p4.y=yD+16;
            }else{
                p1.y=yD-10;
                p2.y=yD-12;
                p3.y=yD-14;
                p4.y=yD-16;
            }

            
        } else {
            
            if(yD==yO){

                p1.y=yD;
                p2.y=yD;
                p3.y=yD;
                p4.y=yD;
                if(xD<xO){
                    p1.x=xD+10;
                    p2.x=xD+12;
                    p3.x=xD+14;
                    p4.x=xD+16;
                }else{
                    p1.x=xD-10;
                    p2.x=xD-12;
                    p3.x=xD-14;
                    p4.x=xD-16;
                }
            } else {
                
                double angulo;
                double longitudArista;
                        
                if((xO<xD) && (yO<yD)){
                    longitudArista=Math.sqrt(Math.pow(yD-yO,2)+Math.pow(xD-xO, 2));
                    angulo=Math.asin((yD-yO)/longitudArista);
                    p1.x=(int) (xD-10*Math.cos(angulo));
                    p1.y=(int) (yD-10*Math.sin(angulo));
                    p2.x=(int) (xD-12*Math.cos(angulo));
                    p2.y=(int) (yD-12*Math.sin(angulo));
                    p3.x=(int) (xD-14*Math.cos(angulo));
                    p3.y=(int) (yD-14*Math.sin(angulo));
                    p4.x=(int) (xD-16*Math.cos(angulo));
                    p4.y=(int) (yD-16*Math.sin(angulo));
                                        
                    //no tocar
                    //listo
                } 

                if((origen.x>destino.x) && (origen.y>destino.y)){
                    
                    longitudArista=Math.sqrt(Math.pow(yO-yD,2)+Math.pow(xO-xD, 2));
                    angulo=Math.asin((yO-yD)/longitudArista);
                    p1.x=(int) (xD+10*Math.cos(angulo));
                    p1.y=(int) (yD+10*Math.sin(angulo));
                    p2.x=(int) (xD+12*Math.cos(angulo));
                    p2.y=(int) (yD+12*Math.sin(angulo));
                    p3.x=(int) (xD+14*Math.cos(angulo));
                    p3.y=(int) (yD+14*Math.sin(angulo));
                    p4.x=(int) (xD+16*Math.cos(angulo));
                    p4.y=(int) (yD+16*Math.sin(angulo));
                    //listo, no cambiar aun(?)
                    
                }

                if((origen.x<destino.x) && (origen.y>destino.y)){
                    
                    longitudArista=Math.sqrt(Math.pow(yO-yD,2)+Math.pow(xD-xO, 2));
                    angulo=Math.asin((yO-yD)/longitudArista);
                    p1.x=(int) (xD-10*Math.cos(angulo));
                    p1.y=(int) (yD+10*Math.sin(angulo));
                    p2.x=(int) (xD-12*Math.cos(angulo));
                    p2.y=(int) (yD+12*Math.sin(angulo));
                    p3.x=(int) (xD-14*Math.cos(angulo));
                    p3.y=(int) (yD+14*Math.sin(angulo));         
                    p4.x=(int) (xD-16*Math.cos(angulo));
                    p4.y=(int) (yD+16*Math.sin(angulo));         
                }
                
                if((origen.x>destino.x) && (origen.y<destino.y)){
                    
                    longitudArista=Math.sqrt(Math.pow(yD-yO,2)+Math.pow(xO-xD, 2));
                    angulo=Math.asin((yO-yD)/longitudArista);
                    p1.x=(int) (xD+10*Math.cos(angulo));
                    p1.y=(int) (yD+10*Math.sin(angulo));
                    p2.x=(int) (xD+12*Math.cos(angulo));
                    p2.y=(int) (yD+12*Math.sin(angulo));
                    p3.x=(int) (xD+14*Math.cos(angulo));
                    p3.y=(int) (yD+14*Math.sin(angulo));         
                    p4.x=(int) (xD+16*Math.cos(angulo));
                    p4.y=(int) (yD+16*Math.sin(angulo)); 
                }          
            }
        }
        
        g2.setColor(colorArista);
        g2.setStroke(new BasicStroke(3.0f));
        g2.drawLine(p1.x, p1.y, p1.x, p1.y);
        g2.setStroke(new BasicStroke(4.0f));
        g2.drawLine(p2.x, p2.y, p2.x, p2.y);
        g2.setStroke(new BasicStroke(5.0f));
        g2.drawLine(p3.x, p3.y, p3.x, p3.y);
        g2.setStroke(new BasicStroke(6.0f));
        g2.drawLine(p4.x, p4.y, p4.x, p4.y);        
        g2.setStroke(new BasicStroke(1.0f));

    }
}


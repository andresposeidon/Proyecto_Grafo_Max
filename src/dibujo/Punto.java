
package dibujo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.BasicStroke;

public class Punto {
    
    public Point posicion;
    public int indice;
    public Point PBipar=new Point(0,0);
    private String etiqueta;
    public Color ColorGrupBipar=Color.BLACK;
    public Color colorPunto=Color.LIGHT_GRAY;
    public  Color colorPunto2=Color.LIGHT_GRAY;
    private Color Point;
    public int RADIO=10;
    public int circle=20;
    public String forma="Circulo";
    public Punto(int x, int y, int indice){
        
        posicion = new Point(x, y);
        this.indice = indice;
        etiqueta=new String();
        etiqueta="";
    }
    
    public void setPosicion(Point posicion){
        
        this.posicion=posicion;
    }
    
    public void setPosicion(int x, int y){
        posicion.x=x;
        posicion.y=y;
    }
    
    public void setIndice(int indice){
        
        this.indice=indice;
    }
    
    public void setColor(Color colorPunto){
        
        Point=colorPunto;
    }
    
    public void setColores(Color c)
    {
    this.colorPunto=c;
    }
    
    public void setForma(String forma)
    {
    this.forma=forma;
    }        
    
    public void setTamaño(int tam)
    {
    this.circle=tam;
    }
    public void setEtiqueta(String etiqueta){
        this.etiqueta=etiqueta;
    }
    
    public String getEtiqueta(){
        String e=new String();
        e=etiqueta;
        return etiqueta;
    }
    
    public boolean estaContenido(Point p){
        double cateto1=(posicion.getX()-p.getX())*(posicion.getX()-p.getX());
        double cateto2=(posicion.getY()-p.getY())*(posicion.getY()-p.getY());
        if(cateto1+cateto2 <= RADIO*RADIO){
            return true;
        }
        return false;
    }
    
    public int getIndice(){
        return indice;
    }
    
    public Point getPosicion(){
        return posicion;
    }

    public void pintarPunto(Graphics g){
            g.setColor(Color.WHITE);
            g.drawString(Integer.toString(indice), posicion.x+1,posicion.y+8);
            g.setColor(colorPunto);
            if("Circulo".equals(forma)){
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setColor(colorPunto);
                    g2d.fillOval(posicion.x-((circle/2)-4), posicion.y-((circle/2)-4),circle,circle);
                    g2d.setColor(Color.black);
                    float []dash={3.0f,3.0f,3.0f};
                    g2d.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,1.0f, dash, 0.0f));
                    g2d.drawOval(posicion.x-((circle/2)-4), posicion.y-((circle/2)-4),circle,circle);
            }
            else{
                    g.fillRect(posicion.x-((circle/2)-4), posicion.y-((circle/2)-4),circle,circle); 
            }
            g.setColor(Color.WHITE);
            g.drawString(Integer.toString(indice), posicion.x+1,posicion.y+8);
            g.setColor(Color.BLUE);
            if(etiqueta!=null){
                g.drawString(etiqueta, posicion.x-8, posicion.y-(circle/2));
            }
    }
    
    public void pintarPunto(Graphics g, int x){
         if(colorPunto2!=colorPunto){
                if("Circulo".equals(forma)){
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setColor(colorPunto);
                    g2d.fillOval(posicion.x-((circle/2)-4), posicion.y-((circle/2)-4),circle,circle);
                    g2d.setColor(Color.black);
                    float []dash={3.0f,3.0f,3.0f};
                    g2d.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,1.0f, dash, 0.0f));
                    g2d.drawOval(posicion.x-((circle/2)-4), posicion.y-((circle/2)-4),circle,circle);
                    colorPunto2=colorPunto;
                }
                else{
                    g.setColor(colorPunto);
                    g.fillRect(posicion.x-((circle/2)-4), posicion.y-((circle/2)-4),circle,circle); 
                }
                g.setColor(Color.WHITE);
                g.drawString(Integer.toString(indice), posicion.x+1,posicion.y+8);
                g.setColor(Color.BLUE);
                if(etiqueta!=null){
                    g.drawString(etiqueta, posicion.x-8, posicion.y-(circle/2));
                }
        }
    }
    
    public void pintarPunto(Graphics g, Color color){
            g.setColor(Color.WHITE);
            g.drawString(Integer.toString(indice), posicion.x+1,posicion.y+8);
            g.setColor(color);
            colorPunto2=color;
            if("Circulo".equals(forma)){
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(color);
                g2d.fillOval(posicion.x-((circle/2)-4), posicion.y-((circle/2)-4),circle,circle);
                g2d.setColor(Color.black);
                float []dash={3.0f,3.0f,3.0f};
                g2d.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,1.0f, dash, 0.0f));
                g2d.drawOval(posicion.x-((circle/2)-4), posicion.y-((circle/2)-4),circle,circle);
            }
            else{
                g.fillRect(posicion.x-((circle/2)-4), posicion.y-((circle/2)-4),circle,circle); 
            }
            g.setColor(Color.WHITE);
            g.drawString(Integer.toString(indice), posicion.x+1, posicion.y+8);
            g.setColor(Color.BLUE);
            if(etiqueta!=null){
                g.drawString(etiqueta, posicion.x-8, posicion.y-(circle/2));
            }
    }
}

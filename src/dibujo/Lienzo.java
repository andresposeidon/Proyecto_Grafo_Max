
package dibujo;

import java.awt.BasicStroke;
import base.Extras;
import base.Grafo;
import interfaz.Interfaz;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import javax.swing.JComponent;
public class Lienzo extends JComponent implements Printable{
    
    private Punto puntos[];
    private Arista aristas[];
    private Point a;
    private Point b;
    public boolean punto;
    private int indicePuntos;
    private int indiceAristas;
    final int MAX_PUNTOS=10;
    final int MAX_ARISTAS=45;
    private BufferedImage imagen;
    
    public Lienzo(){
        puntos=new Punto[10];
        aristas=new Arista[45];
        indicePuntos=-1;
        indiceAristas=-1;
        punto=false;
    }
    
    @Override
    public void paintComponent(Graphics g){
         Dimension k=this.getSize();   
         
         //agrega un fondo cuadriculado al lienzo
        if(Interfaz.Cuadricular.isSelected()==true){    
            g.setColor(Color.LIGHT_GRAY);
            for(int i =0; i<k.width; i=i+18)
            {
                g.drawLine(i,0,i,k.height);
            }
            for(int i=0;i<k.height;i=i+18)
            {
                g.drawLine(0, i, k.width, i);
            }
        }
        
        //agrega un fondo punteado al lienzo
        if(Interfaz.AreaPunteada.isSelected()==true){
            for(int i=0; i <=800; i=i+20){
                for(int j=0;j<=1500;j=j+20){
                    g.drawRect(j,i,1,1);
                }
            }
        }
        //crea una linea punteada verde para crear la arista
        if(punto==true){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.GREEN);
            float []dash={3.0f,3.0f,3.0f};
            Line2D lin = new Line2D.Float((int)a.getX()+4, (int)a.getY()+4, (int)b.getX(), (int)b.getY());
            g2d.setStroke(new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,1.0f, dash, 0.0f));
            g2d.draw(lin);
        }
        //Pinta los puntos y Aristas
        if(AreaDibujo.a==-1){
             for(int i=0; i<=indiceAristas; i++){
                Arista aristaAux=aristas[i];
                aristaAux.pintarArista(g);
            }
            for(int i=0; i<=indicePuntos; i++){
                Punto puntoAux=puntos[i];
                puntoAux.pintarPunto(g);
            }
        }
        else{ //Pinta los puntos y Aristas pero dejando selecionado un punto de color naranjo
            for(int i=0; i<=indiceAristas; i++){
                Arista aristaAux=aristas[i];
                aristaAux.pintarArista(g);
            }
            for (int i = 0; i <=indicePuntos; i++) {
                 if(AreaDibujo.a!=i){
                        Punto puntoAux=puntos[i];
                        puntoAux.pintarPunto(g);
                 }
                 else{
                        Punto puntoAux=puntos[i];
                        puntoAux.pintarPunto(g, Color.ORANGE);
                     }
            }
        }
       //crea un cuadrado azul trasparente para selecionar los puntos
        if (AreaDibujo.estaContenido==0) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.BLUE);
            Shape rectangulo = crearRectangulo(AreaDibujo.corX_presionado, AreaDibujo.corY_presionado, AreaDibujo.corX, AreaDibujo.corY);
            AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f);                     
            g2.setComposite(ac);
            g2.draw(rectangulo);
            g2.fill(rectangulo);
        }
        //Crea un cuadrado blanco con la informacion del punto
        if(AreaDibujo.a!=-1 ){
            Rectangle2D rectangulo;
            Graphics2D g2 = (Graphics2D)g;
            rectangulo = new Rectangle2D.Float(AreaDibujo.X-145, AreaDibujo.Y-70, 135, 65);
            g2.setColor(Color.WHITE);
            g2.fill(rectangulo);
            g2.setColor(Color.BLUE);
            g2.draw(rectangulo);
            g2.setColor(Color.black);
            g2.setFont(new Font("Arial", Font.ITALIC, 12));
            g2.drawString("Etiqueta: "+puntos[AreaDibujo.a].getEtiqueta(), AreaDibujo.X-140, AreaDibujo.Y-55);
            g2.drawString("Indice: "+puntos[AreaDibujo.a].getIndice(), AreaDibujo.X-140, AreaDibujo.Y-40);
            g2.drawString("Grados de Entrada: "+AreaDibujo.gradoEntrada, AreaDibujo.X-140, AreaDibujo.Y-25);
            g2.drawString("Grados de Salida:   "+AreaDibujo.gradoSalida, AreaDibujo.X-140, AreaDibujo.Y-10);
        }
    }
    
    public BufferedImage getImagen(){
        return imagen;
    }
    
    public void cambiarGrafo(Grafo nuevo){
        //pendiente de creacion
    }
    
    public void setAristas(Arista[] aristas, int indiceAristas){
        this.aristas=aristas;
        this.indiceAristas=indiceAristas;
    }
    
    public void setPuntos(Punto[] puntos, int indicePuntos){
        this.puntos=puntos;
        this.indicePuntos=indicePuntos;
    }
    
    public void setA(Point a){
        this.a=a;
        
    }
    
    public void setB(Point b){
        this.b=b;
    }
    
    public void ordenarPuntos(double ancho, double largo){
       Point puntoCentro=new Point((int)(largo/2),(int) (ancho/2));
        double radio=Extras.menor(largo/2-50, ancho/2-100);
        double angulo=360.0/(indicePuntos+1);
        if(indicePuntos>0){
            
            for(int i=0; i<=indicePuntos; i++){
                puntos[i].setPosicion((int)(puntoCentro.x+radio*Math.sin((Math.toRadians(angulo*i)))),(int)(puntoCentro.y+radio*Math.cos((Math.toRadians(angulo*i)))-36));
            
            }
        } else {
            if(indicePuntos==0){
                puntos[0].setPosicion(puntoCentro);
            }
        }
    }

    @Override
    public int print(Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if(pageIndex==0){
            for(int i=0; i<=indiceAristas; i++){
            
            Arista aristaAux=aristas[i];
                aristaAux.pintarArista(g);
            }
             for(int i=0; i<=indicePuntos; i++){
               
                Punto puntoAux=puntos[i];
                puntoAux.pintarPunto(g);
            }
            return PAGE_EXISTS;
        }
        return NO_SUCH_PAGE;
    }
     public Rectangle2D.Float crearRectangulo(int x1, int y1, int x2, int y2) {
        // ajusta el rectangulo
        return new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
    }


}


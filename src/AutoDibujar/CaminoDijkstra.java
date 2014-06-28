/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AutoDibujar;

import dibujo.AreaDibujo;
import interfaz.Interfaz;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import dibujo.Arista;
import gestion.Captura;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
public class CaminoDijkstra extends javax.swing.JDialog {

 public WalkingDijkstra Viajemos=new WalkingDijkstra();
 public WalkingDijkstra Elegido=new WalkingDijkstra();
 public WalkingDijkstra []Lista=new WalkingDijkstra[200000];
 int Cont=0;
 int Next=0;
 private int [][]matriz=new int[10][10];
 private int [][]Doble=new int[10][10];
    public CaminoDijkstra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconos/core32.png"));
        setIconImage(icon);
        setVisible(true);
        
 }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        Datos = new javax.swing.JInternalFrame();
        Inicio = new javax.swing.JTextField();
        Fin = new javax.swing.JTextField();
        Iniciar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        back = new javax.swing.JButton();
        next = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visualizador de Camino mínimo");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(1010, 675));

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(1010, 675));

        Datos.setResizable(true);
        Datos.setPreferredSize(new java.awt.Dimension(1010, 675));
        Datos.setVisible(true);
        Datos.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                DatosComponentMoved(evt);
            }
            public void componentResized(java.awt.event.ComponentEvent evt) {
                DatosComponentResized(evt);
            }
        });

        Iniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Button Reload_32.png"))); // NOI18N
        Iniciar.setToolTipText("Buscar");
        Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setAutoscrolls(true);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Button Previous_16.png"))); // NOI18N
        back.setToolTipText("Atrás");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Button Next_16.png"))); // NOI18N
        next.setToolTipText("Adelante");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        jLabel1.setText("Peso Total : ?");

        jLabel2.setText("Partida: ");

        jLabel3.setText("Termino: ");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/camera_32.png"))); // NOI18N
        jButton1.setToolTipText("Obtener Imagen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DatosLayout = new javax.swing.GroupLayout(Datos.getContentPane());
        Datos.getContentPane().setLayout(DatosLayout);
        DatosLayout.setHorizontalGroup(
            DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DatosLayout.createSequentialGroup()
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DatosLayout.createSequentialGroup()
                                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 690, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(DatosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DatosLayout.createSequentialGroup()
                        .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Inicio, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(Fin))
                        .addGap(18, 18, 18)
                        .addComponent(Iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DatosLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(22, 22, 22))))
            .addGroup(DatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap())
        );
        DatosLayout.setVerticalGroup(
            DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DatosLayout.createSequentialGroup()
                        .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 460, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DatosLayout.createSequentialGroup()
                        .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DatosLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(DatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(Fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(DatosLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(Iniciar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(23, 23, 23))))
        );

        Datos.setBounds(0, 0, 1010, 675);
        jLayeredPane1.add(Datos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
     public void paint(Graphics g)
    {
        
       super.paintComponents(g);
     
       Datos.setBackground(Color.WHITE); 
       pintar(Datos.getContentPane().getGraphics(),AreaDibujo.indicePuntos,Interfaz.CantidadAristasC);
       
    }
   
    public void pintar(Graphics g,int puntos,int aristas)
    {
         Graphics2D g2=(Graphics2D) g;
     
       for(int c=0;c<=AreaDibujo.indiceAristas;c++)
        {
          if(AreaDibujo.aristas[c].tamaño==1)
         g2.setStroke(new BasicStroke(1.0f));
         if(AreaDibujo.aristas[c].tamaño==2)
         g2.setStroke(new BasicStroke(1.7f));
         if(AreaDibujo.aristas[c].tamaño==3)
         g2.setStroke(new BasicStroke(2.3f));
         if(AreaDibujo.aristas[c].tamaño==4)
         g2.setStroke(new BasicStroke(3.0f));  
         g2.setColor(AreaDibujo.aristas[c].colorArista);
         g2.drawLine(AreaDibujo.aristas[c].puntoA.posicion.x+4,AreaDibujo.aristas[c].puntoA.posicion.y+4,AreaDibujo.aristas[c].puntoB.posicion.x+4,AreaDibujo.aristas[c].puntoB.posicion.y+4);
          if(AreaDibujo.aristas[c].esDirigida()==true){
           pintarFlecha(g2,AreaDibujo.aristas[c].puntoA.posicion,AreaDibujo.aristas[c].puntoB.posicion,AreaDibujo.aristas[c].colorArista);
        }
        }
        g2.setStroke(new BasicStroke(2.3f));
         g2.setColor(Color.yellow);
          for(int i=0;i<Next;i++)
           g2.drawLine(AreaDibujo.puntos[Elegido.Recorrido[i]].posicion.x+4,AreaDibujo.puntos[Elegido.Recorrido[i]].posicion.y+4,AreaDibujo.puntos[Elegido.Recorrido[i+1]].posicion.x+4,AreaDibujo.puntos[Elegido.Recorrido[i+1]].posicion.y+4);
        
       
        for(int c=0;c<=AreaDibujo.indicePuntos;c++)
        {
         g2.setColor(AreaDibujo.puntos[c].colorPunto);
         if("Circulo".equals(AreaDibujo.puntos[c].forma))
         g2.fillOval(AreaDibujo.puntos[c].posicion.x-((AreaDibujo.puntos[c].circle/2)-4),AreaDibujo.puntos[c].posicion.y-((AreaDibujo.puntos[c].circle/2)-4),AreaDibujo.puntos[c].circle,AreaDibujo.puntos[c].circle);
         else
         g2.fillRect(AreaDibujo.puntos[c].posicion.x-((AreaDibujo.puntos[c].circle/2)-4),AreaDibujo.puntos[c].posicion.y-((AreaDibujo.puntos[c].circle/2)-4),AreaDibujo.puntos[c].circle,AreaDibujo.puntos[c].circle); 
         
         g2.setColor(Color.WHITE);
         g2.drawString(Integer.toString(AreaDibujo.puntos[c].getIndice()),AreaDibujo.puntos[c].posicion.x+1,AreaDibujo.puntos[c].posicion.y+8);
         
         g2.setColor(Color.BLACK);
        if(AreaDibujo.puntos[c].getEtiqueta()!=null){
            g2.drawString(AreaDibujo.puntos[c].getEtiqueta(),AreaDibujo.puntos[c].posicion.x-8,AreaDibujo.puntos[c].posicion.y-((AreaDibujo.puntos[c].circle/2)));
        }
        }
       int i=0;
       
         for(int c=0;c<Next;c++)
        {
          g2.setColor(Color.green);   
         if("Circulo".equals(AreaDibujo.puntos[Elegido.Recorrido[i]].forma))
         g2.fillOval(AreaDibujo.puntos[Elegido.Recorrido[i]].posicion.x-((AreaDibujo.puntos[Elegido.Recorrido[i]].circle/2)-4),AreaDibujo.puntos[Elegido.Recorrido[i]].posicion.y-((AreaDibujo.puntos[Elegido.Recorrido[i]].circle/2)-4),AreaDibujo.puntos[Elegido.Recorrido[i]].circle,AreaDibujo.puntos[Elegido.Recorrido[i]].circle);
         else
         g2.fillRect(AreaDibujo.puntos[Elegido.Recorrido[i]].posicion.x-((AreaDibujo.puntos[Elegido.Recorrido[i]].circle/2)-4),AreaDibujo.puntos[Elegido.Recorrido[i]].posicion.y-((AreaDibujo.puntos[Elegido.Recorrido[i]].circle/2)-4),AreaDibujo.puntos[Elegido.Recorrido[i]].circle,AreaDibujo.puntos[Elegido.Recorrido[i]].circle);
          g2.setColor(Color.WHITE);
         g2.drawString(Integer.toString(AreaDibujo.puntos[Elegido.Recorrido[i]].getIndice()),AreaDibujo.puntos[Elegido.Recorrido[i]].posicion.x+1,AreaDibujo.puntos[Elegido.Recorrido[i]].posicion.y+8);
          
            
           i=c+1; 
        g2.setColor(Color.green);
         if("Circulo".equals(AreaDibujo.puntos[Elegido.Recorrido[i]].forma))
         g2.fillOval(AreaDibujo.puntos[Elegido.Recorrido[i]].posicion.x-((AreaDibujo.puntos[Elegido.Recorrido[i]].circle/2)-4),AreaDibujo.puntos[Elegido.Recorrido[i]].posicion.y-((AreaDibujo.puntos[Elegido.Recorrido[i]].circle/2)-4),AreaDibujo.puntos[Elegido.Recorrido[i]].circle,AreaDibujo.puntos[Elegido.Recorrido[i]].circle);
         else
         g2.fillRect(AreaDibujo.puntos[Elegido.Recorrido[i]].posicion.x-((AreaDibujo.puntos[Elegido.Recorrido[i]].circle/2)-4),AreaDibujo.puntos[Elegido.Recorrido[i]].posicion.y-((AreaDibujo.puntos[Elegido.Recorrido[i]].circle/2)-4),AreaDibujo.puntos[Elegido.Recorrido[i]].circle,AreaDibujo.puntos[Elegido.Recorrido[i]].circle);
         
         g2.setColor(Color.WHITE);
         g2.drawString(Integer.toString(AreaDibujo.puntos[Elegido.Recorrido[i]].getIndice()),AreaDibujo.puntos[Elegido.Recorrido[i]].posicion.x+1,AreaDibujo.puntos[Elegido.Recorrido[i]].posicion.y+8);
         
         g2.setColor(Color.BLACK);
        if(AreaDibujo.puntos[Elegido.Recorrido[i]].getEtiqueta()!=null){
            g2.drawString(AreaDibujo.puntos[Elegido.Recorrido[i]].getEtiqueta(),AreaDibujo.puntos[Elegido.Recorrido[i]].posicion.x-8,AreaDibujo.puntos[Elegido.Recorrido[i]].posicion.y-((AreaDibujo.puntos[Elegido.Recorrido[i]].circle/2)));
        }
        }
   
         g2.setColor(Color.BLUE);
         for(int c=0;c<=AreaDibujo.indiceAristas;c++)
         g2.drawString(AreaDibujo.aristas[c].peso+"",(AreaDibujo.aristas[c].puntoA.posicion.x+AreaDibujo.aristas[c].puntoB.posicion.x)/2,(AreaDibujo.aristas[c].puntoA.posicion.y+AreaDibujo.aristas[c].puntoB.posicion.y)/2);
        
        g2.setColor(Color.red);
        
       for(int j=0;j<=AreaDibujo.indiceAristas;j++)
        for(int w=0;w<Next;w++)
    if((AreaDibujo.aristas[j].puntoA.posicion.x==AreaDibujo.puntos[Elegido.Recorrido[w]].posicion.x &&
   AreaDibujo.aristas[j].puntoA.posicion.y==AreaDibujo.puntos[Elegido.Recorrido[w]].posicion.y &&
   AreaDibujo.aristas[j].puntoB.posicion.x==AreaDibujo.puntos[Elegido.Recorrido[w+1]].posicion.x &&
   AreaDibujo.aristas[j].puntoB.posicion.y==AreaDibujo.puntos[Elegido.Recorrido[w+1]].posicion.y)||
   (AreaDibujo.aristas[j].puntoB.posicion.x==AreaDibujo.puntos[Elegido.Recorrido[w]].posicion.x &&
   AreaDibujo.aristas[j].puntoB.posicion.y==AreaDibujo.puntos[Elegido.Recorrido[w]].posicion.y &&
   AreaDibujo.aristas[j].puntoA.posicion.x==AreaDibujo.puntos[Elegido.Recorrido[w+1]].posicion.x &&
   AreaDibujo.aristas[j].puntoA.posicion.y==AreaDibujo.puntos[Elegido.Recorrido[w+1]].posicion.y))
     g2.drawString(AreaDibujo.aristas[j].peso+"",(AreaDibujo.puntos[Elegido.Recorrido[w]].posicion.x+AreaDibujo.puntos[Elegido.Recorrido[w+1]].posicion.x)/2,(AreaDibujo.puntos[Elegido.Recorrido[w]].posicion.y+AreaDibujo.puntos[Elegido.Recorrido[w+1]].posicion.y)/2);
    
  }
    public void pintarFlecha(Graphics g, Point origen, Point destino,Color C){
        
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
        
        g2.setColor(C);
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

  
    private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarActionPerformed
        
        Cont=0;
        Next=0;
        next.setEnabled(true);
        back.setEnabled(false);
        jTextArea1.setText("");
        for(int i=0;i<200000;i++)
         Lista[i]=new WalkingDijkstra();
         try
         {
             if(0>Integer.parseInt(Fin.getText())|| Integer.parseInt(Fin.getText())>AreaDibujo.indicePuntos||0>Integer.parseInt(Inicio.getText())|| Integer.parseInt(Inicio.getText())>AreaDibujo.indicePuntos )
        {JOptionPane.showMessageDialog(null,"El rango es de 0 a "+AreaDibujo.indicePuntos,"Advertencia",JOptionPane.ERROR_MESSAGE);
        Next=0;
        Cont=0;
        repaint();
        return;
        }
          if(Integer.parseInt(Inicio.getText())==Integer.parseInt(Fin.getText()))
          {
            JOptionPane.showMessageDialog(null,"Números iguales.","Advertencia",JOptionPane.ERROR_MESSAGE);    
          Next=0;
          Cont=0;
         repaint();
          return;
          }  
             
          Viajemos.Recorrido[0]=Integer.parseInt(Inicio.getText());
         
    for(int i=0;i<AreaDibujo.indicePuntos+1;i++)
            for(int j=0;j<AreaDibujo.indicePuntos+1;j++)
            {
              matriz[i][j]=Integer.parseInt(AreaDibujo.matrizMostrada.matrizS[i][j]); 
              Doble[i][j]=Integer.parseInt(AreaDibujo.matrizMostrada.matrizS[i][j]);
            }
        
        Viajar(Integer.parseInt(Inicio.getText()),Integer.parseInt(Fin.getText()),matriz,AreaDibujo.indicePuntos+1); 
      
         if(Cont==0)
         JOptionPane.showMessageDialog(null,"No se encontró un camino.","No hay Datos",JOptionPane.INFORMATION_MESSAGE);               
          else
         {
          
        Seleccion();
         }
         }catch(Exception e)
         {
          JOptionPane.showMessageDialog(null,"Datos Incorrectos","No hay Datos",JOptionPane.ERROR_MESSAGE);  
         }
    }//GEN-LAST:event_IniciarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       try {
            Interfaz.frameDibujo.setMaximum(false);
            Datos.setMaximum(true);
            next.setEnabled(false);
            back.setEnabled(false);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(CrearCompletar.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
    }//GEN-LAST:event_formWindowActivated

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      try {
            Datos.setMaximum(false);
            Interfaz.frameDibujo.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(CrearCompletar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void DatosComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_DatosComponentResized
        repaint();
    }//GEN-LAST:event_DatosComponentResized

    private void DatosComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_DatosComponentMoved
      repaint();
    }//GEN-LAST:event_DatosComponentMoved

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
       if(Next==0)
            return;
        else{
            this.next.setEnabled(true);
            Next--;
            repaint();
        }
        if(Next==0)
            this.back.setEnabled(false);
    }//GEN-LAST:event_backActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        if(Next==Elegido.Cant-1)
          return;
       else{
           this.back.setEnabled(true);
           Next++;
       repaint();
       }
       if(Next==Elegido.Cant-1)
           this.next.setEnabled(false);
      
    }//GEN-LAST:event_nextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1.setVisible(false);
        back.setVisible(false);
        next.setVisible(false);
        Inicio.setVisible(false);
        Fin.setVisible(false);
        Iniciar.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        repaint();
        Timer t = new Timer();

        TimerTask timerTask = new TimerTask() {

            public void run() {
                new Captura(Datos);
                jButton1.setVisible(true);
                jButton1.setVisible(true);
                back.setVisible(true);
                next.setVisible(true);
                Inicio.setVisible(true);
                Fin.setVisible(true);
                Iniciar.setVisible(true);
                jLabel2.setVisible(true);
                jLabel3.setVisible(true);
                repaint();
            }
        };

        t.schedule(timerTask, 100);

    }//GEN-LAST:event_jButton1ActionPerformed
 


    void Viajar(int pizo,int fin,int matriz[][],int n)
{
    int []Rcopy=new int[100];
    
         for(int z=0;z<n;z++)
           Rcopy[z]=matriz[z][pizo];      
           
         for(int z=0;z<n;z++)              
           matriz[z][pizo]=0; 
                     
             for(int z=0;z<n;z++)
             if(Doble[pizo][fin]==1 && z==fin)
              {
             // vector[cont]=fin;
              // cont++;
              Viajemos.Recorrido[Viajemos.Cant]=fin;                     
              Viajemos.Cant++;
                  
               Lista[Cont].CopyAll(Viajemos);
               Cont++;
               //System.out.println(Cont);
               //  for(int i=0;i<cont;i++)
                //  Listado[Cant].camino[i]=vector[i];
                //  Listado[Cant].Cant=cont;
               //Cant++;
               Viajemos.Cant--;
              // cont--;
             }else
              if(matriz[pizo][z]==1)
                {
                  //vector[cont]=z;                  
                  //cont++;
                  Viajemos.Recorrido[Viajemos.Cant]=z;
                  Viajemos.Cant++;
                 Viajar(z,fin,matriz,n);
                  Viajemos.Cant--;
                  //cont--;
                }
           for(int i=0;i<n;i++)
               matriz[i][pizo]=Rcopy[i];        
         
}
     
    
void Seleccion()
  {
   
  for(int i=0;i<Cont;i++)
  {
    for(int j=0;j<=AreaDibujo.indiceAristas;j++)
     for(int w=0;w<Lista[i].Cant-1;w++)
if((AreaDibujo.aristas[j].puntoA.posicion.x==AreaDibujo.puntos[Lista[i].Recorrido[w]].posicion.x &&
   AreaDibujo.aristas[j].puntoA.posicion.y==AreaDibujo.puntos[Lista[i].Recorrido[w]].posicion.y &&
   AreaDibujo.aristas[j].puntoB.posicion.x==AreaDibujo.puntos[Lista[i].Recorrido[w+1]].posicion.x &&
   AreaDibujo.aristas[j].puntoB.posicion.y==AreaDibujo.puntos[Lista[i].Recorrido[w+1]].posicion.y)||
   (AreaDibujo.aristas[j].puntoB.posicion.x==AreaDibujo.puntos[Lista[i].Recorrido[w]].posicion.x &&
   AreaDibujo.aristas[j].puntoB.posicion.y==AreaDibujo.puntos[Lista[i].Recorrido[w]].posicion.y &&
   AreaDibujo.aristas[j].puntoA.posicion.x==AreaDibujo.puntos[Lista[i].Recorrido[w+1]].posicion.x &&
   AreaDibujo.aristas[j].puntoA.posicion.y==AreaDibujo.puntos[Lista[i].Recorrido[w+1]].posicion.y))
     {
     Lista[i].Suma+=AreaDibujo.aristas[j].peso;
         //System.out.print(AreaDibujo.aristas[j].peso+" + ");
     }
      //System.out.println(" :"+Lista[i].Suma);
  } 
   Elegido.CopyAll(Lista[0]);
    for(int j=0;j<Cont;j++)
        if(Elegido.Suma>Lista[j].Suma){
            Elegido.CopyAll(Lista[j]);
        }
    for(int j=0;j<Elegido.Cant-1;j++)
        if(Elegido.Cant>=5)
       jTextArea1.append("("+Elegido.Recorrido[j]+","+Elegido.Recorrido[j+1]+")\n");
          else
           jTextArea1.append(" ("+Elegido.Recorrido[j]+","+Elegido.Recorrido[j+1]+")\n"); 
    
    jLabel1.setText("Peso Total :"+Elegido.Suma);
    repaint();
}
    



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CaminoDijkstra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaminoDijkstra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaminoDijkstra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaminoDijkstra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                CaminoDijkstra dialog = new CaminoDijkstra(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame Datos;
    private javax.swing.JTextField Fin;
    private javax.swing.JButton Iniciar;
    private javax.swing.JTextField Inicio;
    private javax.swing.JButton back;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton next;
    // End of variables declaration//GEN-END:variables
}

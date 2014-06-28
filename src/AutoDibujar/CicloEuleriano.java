/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AutoDibujar;

import dibujo.AreaDibujo;
import interfaz.Interfaz;
import java.awt.*;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CicloEuleriano extends javax.swing.JDialog {

    int [][]Matriz= new int[10][10];
     int[]MiCamino=new int[100];
     int [][]GoBack=new int[10][10];
    int CantCamino=1;
    int total=0;
    int suma;
    public CicloEuleriano(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconos/core32.png"));
        setIconImage(icon);
        this.setLocationRelativeTo(null);
        setVisible(true);
    }
    public CicloEuleriano()
    {
     
    }    
    
    public boolean Freury()
    {
      
    for(int i=0;i<AreaDibujo.indicePuntos+1;i++){
            for(int j=0;j<AreaDibujo.indicePuntos+1;j++){
               Matriz[i][j]=Integer.parseInt(AreaDibujo.matrizMostrada.matrizS[i][j]);
               GoBack[i][j]=Integer.parseInt(AreaDibujo.matrizMostrada.matrizS[i][j]);
            }
     
    }
    
         this.MiCamino[0]=0;
         this.CantCamino=1;
      if(camino(0,Matriz,AreaDibujo.indicePuntos+1,0))
        return true;
      else
        return false;
      
       
    }
    
    public void paint(Graphics g)
    {
        
       super.paintComponents(g);
       jInternalFrame1.setBackground(Color.WHITE); 
       pintar(jInternalFrame1.getContentPane().getGraphics(),AreaDibujo.indicePuntos,Interfaz.CantidadAristasC);
       mensaje.setText("  La Distancia Recorrida es : "+suma);
    }
   
    public void pintar(Graphics g,int puntos,int aristas)
    { suma=0;
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
        suma=suma+AreaDibujo.aristas[c].peso;
       if(!Interfaz.ocultapesoaris.isSelected()){
           g2.setColor(Color.BLUE);
          g2.drawString(AreaDibujo.aristas[c].peso+"",(AreaDibujo.aristas[c].puntoA.posicion.x + AreaDibujo.aristas[c].puntoB.posicion.x)/2,(AreaDibujo.aristas[c].puntoA.posicion.y + AreaDibujo.aristas[c].puntoB.posicion.y)/2);
       }
        }
         g2.setStroke(new BasicStroke(2.3f));
         g2.setColor(Color.yellow);
          for(int i=0;i<total;i++)
           g2.drawLine(AreaDibujo.puntos[MiCamino[i]].posicion.x+4,AreaDibujo.puntos[MiCamino[i]].posicion.y+4,AreaDibujo.puntos[MiCamino[i+1]].posicion.x+4,AreaDibujo.puntos[MiCamino[i+1]].posicion.y+4);
        
       
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
         for(int c=0;c<total;c++)
        {
           i=c+1; 
         g2.setColor(Color.green);
         if("Circulo".equals(AreaDibujo.puntos[MiCamino[i]].forma))
         g2.fillOval(AreaDibujo.puntos[MiCamino[i]].posicion.x-((AreaDibujo.puntos[MiCamino[i]].circle/2)-4),AreaDibujo.puntos[MiCamino[i]].posicion.y-((AreaDibujo.puntos[MiCamino[i]].circle/2)-4),AreaDibujo.puntos[MiCamino[i]].circle,AreaDibujo.puntos[MiCamino[i]].circle);
         else
         g2.fillRect(AreaDibujo.puntos[MiCamino[i]].posicion.x-((AreaDibujo.puntos[MiCamino[i]].circle/2)-4),AreaDibujo.puntos[MiCamino[i]].posicion.y-((AreaDibujo.puntos[MiCamino[i]].circle/2)-4),AreaDibujo.puntos[MiCamino[i]].circle,AreaDibujo.puntos[MiCamino[i]].circle); 
         
         g2.setColor(Color.WHITE);
         g2.drawString(Integer.toString(AreaDibujo.puntos[MiCamino[i]].getIndice()),AreaDibujo.puntos[MiCamino[i]].posicion.x+1,AreaDibujo.puntos[MiCamino[i]].posicion.y+8);
         
         g2.setColor(Color.BLACK);
        if(AreaDibujo.puntos[MiCamino[i]].getEtiqueta()!=null){
            g2.drawString(AreaDibujo.puntos[MiCamino[i]].getEtiqueta(),AreaDibujo.puntos[MiCamino[i]].posicion.x-8,AreaDibujo.puntos[MiCamino[i]].posicion.y-((AreaDibujo.puntos[MiCamino[i]].circle/2)));
        }
        }
        
        
    }
    
 
    
  boolean camino(int pizo,int [][]matriz,int n,int CantCamino)
{
   int c,cont=0,i,j,back;
      
     for(i=0;i<n;i++)
      for(j=0;j<n;j++)
        if(matriz[i][j]==0)
          cont++;
     
      if(cont==(n*n) && this.MiCamino[0]==this.MiCamino[this.CantCamino-1])
      {
       this.CantCamino--;   
        return true;
      }
      
       for(c=0;c<n;c++)
       if(matriz[pizo][c]==1)
       {
        matriz[pizo][c]=0;
        back=matriz[c][pizo];
        matriz[c][pizo]=0;
        this.MiCamino[this.CantCamino]=c;
        this.CantCamino++;
          if(camino(c,matriz,n,this.CantCamino))
           return true;
          else
          {
                 this.CantCamino--;
                   matriz[pizo][c]=1;
                   matriz[c][pizo]=back;
         }
        }
return false;      
}
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        mensaje = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visor ciclo euleriano");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(1010, 675));

        jInternalFrame1.setResizable(true);
        jInternalFrame1.setPreferredSize(new java.awt.Dimension(1010, 675));
        jInternalFrame1.setVisible(true);
        jInternalFrame1.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                jInternalFrame1InternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        jInternalFrame1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jInternalFrame1MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jInternalFrame1MouseClicked(evt);
            }
        });
        jInternalFrame1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jInternalFrame1MouseDragged(evt);
            }
        });
        jInternalFrame1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jInternalFrame1ComponentMoved(evt);
            }
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jInternalFrame1ComponentResized(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setAutoscrolls(true);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Button Next_16.png"))); // NOI18N
        jButton1.setToolTipText("Adelante");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Button Previous_16.png"))); // NOI18N
        jButton2.setToolTipText("Atrás");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("El Recorrido es:");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 714, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 389, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jInternalFrame1.setBounds(0, 0, 1010, 675);
        jLayeredPane1.add(jInternalFrame1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jInternalFrame1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jInternalFrame1MouseDragged
      repaint();
    }//GEN-LAST:event_jInternalFrame1MouseDragged

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            Interfaz.frameDibujo.setMaximum(false);
            jInternalFrame1.setMaximum(true);
            this.jButton2.setEnabled(false);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(CrearCompletar.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      try {
            Interfaz.frameDibujo.setMaximum(false);
            jInternalFrame1.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(CrearCompletar.class.getName()).log(Level.SEVERE, null, ex);
        }
      Freury();
      
      for(int c=0;c<=AreaDibujo.indiceAristas;c++)
               if(AreaDibujo.indiceAristas>=5)
                jTextArea1.append(""+(c+1)+".-("+MiCamino[c]+","+MiCamino[c+1]+")\n");
                 else
                  jTextArea1.append(""+(c+1)+".-("+MiCamino[c]+","+MiCamino[c+1]+")\n");      
      
      repaint();
    }//GEN-LAST:event_formWindowOpened

    private void jInternalFrame1ComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jInternalFrame1ComponentMoved
     repaint();
    }//GEN-LAST:event_jInternalFrame1ComponentMoved

    private void jInternalFrame1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jInternalFrame1ComponentResized
      repaint();
    }//GEN-LAST:event_jInternalFrame1ComponentResized

    private void jInternalFrame1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jInternalFrame1MouseClicked
     repaint();
    }//GEN-LAST:event_jInternalFrame1MouseClicked

    private void jInternalFrame1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jInternalFrame1MouseReleased
    repaint();
    }//GEN-LAST:event_jInternalFrame1MouseReleased

    private void jInternalFrame1InternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_jInternalFrame1InternalFrameActivated
     repaint();
    }//GEN-LAST:event_jInternalFrame1InternalFrameActivated

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
  
    }//GEN-LAST:event_formWindowClosed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(total==this.CantCamino)
            return;
        else
        {
           this.jButton2.setEnabled(true);  
        this.total++;
           repaint();
        }
        if(total==this.CantCamino)
            this.jButton1.setEnabled(false);
          
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(total==0)
            return;
        else
        {
            this.jButton1.setEnabled(true);
        this.total--;
        repaint();
        }
            if(total==0)
                   this.jButton2.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
   try {
            jInternalFrame1.setMaximum(false);
            Interfaz.frameDibujo.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(CrearCompletar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(CicloEuleriano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CicloEuleriano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CicloEuleriano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CicloEuleriano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                CicloEuleriano dialog = new CicloEuleriano(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel mensaje;
    // End of variables declaration//GEN-END:variables
}

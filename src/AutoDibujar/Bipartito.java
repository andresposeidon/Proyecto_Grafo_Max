/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AutoDibujar;

import dibujo.AreaDibujo;
import gestion.Captura;
import interfaz.Interfaz;
import java.awt.*;
import java.beans.PropertyVetoException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Bipartito extends javax.swing.JDialog {

    
      int []A= new int[10];
      int []B= new int[10];
      int ContA=0,ContB=0,BandB=0,BandA=0;
      int [][]matriz=new int[10][10];
      int [][]matrix=new int[10][10];
      int totalaristas=0;
      int totalaristasB=0;
    public Bipartito(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconos/core32.png"));
         setIconImage(icon);
        setVisible(true);
   }
    public  Bipartito()
    {
        
    }

    
    
    @Override
     public void paint(Graphics g)
    {
        
       super.paintComponents(g);
        ContA=0;
        ContB=0;BandB=0;BandA=0;
        boolean Bipar = Bipar();
            
       jInternalFrame1.setBackground(Color.WHITE); 
       pintar(jInternalFrame1.getContentPane().getGraphics(),AreaDibujo.indicePuntos,Interfaz.CantidadAristasC);
    }
    
    public void trabla(){
        for(int w=0;w<ContA;w++){
             GrupoA.append("Punto "+A[w]+"\n");
         }
         for(int w=0;w<ContB;w++){
             GrupoB.append("Punto "+B[w]+"\n");
         } 
         //totalaristas=totalaristas/2;
         if(totalaristas==(ContA*ContB)){
             mensaje.setText("  EL Grafo Bipartito Completo");
         }
         else{
             mensaje.setText("  EL Grafo Bipartito Incompleto");
         }
    }
   
    public void pintar(Graphics g,int puntos,int aristas)
    {
         Graphics2D g2=(Graphics2D) g;
        int PotX=0,PotY=0,y1=10,y2=10,suma=0;
        if(ContA<=5)
            suma=70;
             else
              suma=50;
         for(int c=0;c<=AreaDibujo.indicePuntos;c++)
         {
         for(int w=0;w<ContA;w++) 
              if(c==A[w])
              {
               g2.setColor(Color.blue);   
               PotX=200;
               y1=y1+suma;
               AreaDibujo.puntos[c].ColorGrupBipar=Color.BLUE;
               AreaDibujo.puntos[c].PBipar.x=PotX;
               AreaDibujo.puntos[c].PBipar.y=y1;
               PotY=y1;
              } 
            for(int w=0;w<ContB;w++) 
              if(c==B[w])
              {
               PotX=600;
               y2=y2+suma;
               AreaDibujo.puntos[c].ColorGrupBipar=Color.RED;  
               AreaDibujo.puntos[c].PBipar.x=PotX;
               AreaDibujo.puntos[c].PBipar.y=y2;
               PotY=y2;
              }
         }

       totalaristas=0;
         g2.setColor(Color.black);
          for(int i=0;i<ContA;i++)
        for(int j=0;j<ContB;j++)
        {
          if(matrix[A[i]][B[j]]==1 || matrix[B[j]][A[i]]==1){  
             totalaristas++;
            g2.drawLine(AreaDibujo.puntos[A[i]].PBipar.x+4,AreaDibujo.puntos[A[i]].PBipar.y+4,AreaDibujo.puntos[B[j]].PBipar.x+4,AreaDibujo.puntos[B[j]].PBipar.y+4);
               if(matrix[A[i]][B[j]]==0 && matrix[B[j]][A[i]]==1){
                   //totalaristas++;
                    pintarFlecha(g2,AreaDibujo.puntos[A[i]].PBipar,AreaDibujo.puntos[B[j]].PBipar,Color.BLACK);
               }
               if(matrix[A[i]][B[j]]==1 && matrix[B[j]][A[i]]==0){
                   //totalaristas++;
                   pintarFlecha(g2,AreaDibujo.puntos[B[j]].PBipar,AreaDibujo.puntos[A[i]].PBipar,Color.BLACK);
               }    
              
           }
          }
        
        for(int c=0;c<=AreaDibujo.indicePuntos;c++)
        {
           
         g2.setColor(AreaDibujo.puntos[c].ColorGrupBipar); 
         if("Circulo".equals(AreaDibujo.puntos[c].forma))
         g2.fillOval(AreaDibujo.puntos[c].PBipar.x-((AreaDibujo.puntos[c].circle/2)-4),AreaDibujo.puntos[c].PBipar.y-((AreaDibujo.puntos[c].circle/2)-4),AreaDibujo.puntos[c].circle,AreaDibujo.puntos[c].circle);
         else
         g2.fillRect(AreaDibujo.puntos[c].PBipar.x-((AreaDibujo.puntos[c].circle/2)-4),AreaDibujo.puntos[c].PBipar.y-((AreaDibujo.puntos[c].circle/2)-4),AreaDibujo.puntos[c].circle,AreaDibujo.puntos[c].circle); 
         
         g2.setColor(Color.WHITE);
         g2.drawString(Integer.toString(AreaDibujo.puntos[c].getIndice()),AreaDibujo.puntos[c].PBipar.x+1,AreaDibujo.puntos[c].PBipar.y+8);
         
         g2.setColor(Color.BLACK);
        if(AreaDibujo.puntos[c].getEtiqueta()!=null){
            g2.drawString(AreaDibujo.puntos[c].getEtiqueta(),AreaDibujo.puntos[c].PBipar.x-8,AreaDibujo.puntos[c].PBipar.y-((AreaDibujo.puntos[c].circle/2)));
        }
        }  
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
    public boolean Bipar()
    {
        
      for(int i=0;i<AreaDibujo.indicePuntos+1;i++)
            for(int j=0;j<AreaDibujo.indicePuntos+1;j++)
            {matriz[j][i]=Integer.parseInt(AreaDibujo.matrizMostrada.matrizS[i][j]); 
            matrix[j][i]=Integer.parseInt(AreaDibujo.matrizMostrada.matrizS[i][j]); 
            }
      
      for(int i=0;i<AreaDibujo.indicePuntos+1;i++)
          for(int j=0;j<AreaDibujo.indicePuntos+1;j++)
               if((matriz[i][j]==1 && matriz[j][i]==0)||(matriz[i][j]==0 && matriz[j][i]==1))
               {
               matriz[i][j]=1;
               matriz[j][i]=1;
               }
      //   System.out.println("\n\n||Matriz||\n");
      /*for(int i=0;i<AreaDibujo.indicePuntos+1;i++){
            for(int j=0;j<AreaDibujo.indicePuntos+1;j++)
              System.out.print(matriz[i][j]); 
            System.out.println("");
      }
        System.out.println("");
      */
  
           
           for(int j=0;j<AreaDibujo.indicePuntos+1;j++)
              if(matriz[0][j]==1)
              {
                B[ContB]=j;
                ContB++;
              }
            else
              {
              A[ContA]=j;
              ContA++;
              }
           
           
           
           
        int NoCambiar1=0,NoCambiar2=0;    
           
       for(int i=0;i<ContA;i++){
           for(int j=0;j<ContA;j++)
              if(matriz[A[i]][A[j]]==1)
              {
               //   System.out.println("Cambiar entre :"+A[i]+","+A[j]);  
                  for(int w=0;w<ContB;w++)
                   if(matriz[A[j]][B[w]]==1||matriz[B[w]][A[j]]==1)
                   {
                 //   System.out.println("1º-Opcion1 :"+A[j]+","+B[w]+" Opcion 2 :"+B[w]+","+A[j]);  
                      NoCambiar1=1;
                   }
                  for(int w=0;w<ContB;w++)
                  {
                   if(matriz[A[i]][B[w]]==1||matriz[B[w]][A[i]]==1)
                   {
                //    System.out.println("2º-Opcion1 :"+A[i]+","+B[w]+" Opcion 2 :"+B[w]+","+A[i]);     
                      NoCambiar2=1;
                   }
                   }
                if(NoCambiar1==0 && NoCambiar2==0)
                  NoCambiar1=1;
                else
                if(NoCambiar1==1 && NoCambiar2==1)
                   return false; 
                
                if(NoCambiar1==0)
                {
                   B[ContB]=A[j]; 
             //      System.out.println("Hacer cambio para :"+A[j]);   
                 for(int w=0;w<ContA;w++)
                     if(A[w]==A[j])
                       for(int m=w;m<ContA-1;m++)  
                           A[m]=A[m+1];
                     ContA--;
                     ContB++;
                 }
                
                if(NoCambiar2==0){
                    B[ContB]=A[i];
               //       System.out.println("Hacer cambio para :"+A[i]);
                 for(int w=0;w<ContA;w++)
                     if(A[w]==A[i])
                      for(int m=w;m<ContA-1;m++)
                      {
                //          System.out.println(A[m]+"="+A[m+1]);  
                         A[m]=A[m+1];
                      }
                    ContA--;
                    ContB++;
                  
                }
             
                NoCambiar1=0;
                NoCambiar2=0;
              }
       }
       
       
        for(int i=0;i<ContB;i++){
           for(int j=0;j<ContB;j++)
              if(matriz[B[i]][B[j]]==1)
              {
                //  System.out.println("Cambiar entre :"+B[i]+","+B[j]);  
                  for(int w=0;w<ContA;w++)
                   if(matriz[B[j]][A[w]]==1||matriz[B[w]][A[j]]==1)
                   {
         //           System.out.println("1º-Opcion1 :"+B[j]+","+A[w]+" Opcion 2 :"+A[w]+","+B[j]);  
                      NoCambiar1=1;
                   }
                  for(int w=0;w<ContA;w++)
                  {
                   if(matriz[B[i]][A[w]]==1||matriz[A[w]][B[i]]==1)
                   {
                //    System.out.println("2º-Opcion1 :"+B[i]+","+A[w]+" Opcion 2 :"+A[w]+","+B[i]);     
                      NoCambiar2=1;
                   }
                   }
                if(NoCambiar1==0 && NoCambiar2==0)
                  NoCambiar1=1;
                else
                if(NoCambiar1==1 && NoCambiar2==1)
                   return false; 
                
                if(NoCambiar1==0)
                {
                   A[ContB]=B[j]; 
          //         System.out.println("Hacer cambio para :"+B[j]);   
                 for(int w=0;w<ContB;w++)
                     if(B[w]==B[j])
                       for(int m=w;m<ContB-1;m++)  
                           B[m]=B[m+1];
                     ContB--;
                     ContA++;
                 }
                
                if(NoCambiar2==0){
                    A[ContB]=B[i];
           //         System.out.println("Hacer cambio para :"+B[i]);
                 for(int w=0;w<ContB;w++)
                     if(B[w]==B[i])
                      for(int m=w;m<ContB-1;m++)
                      {
            //              System.out.println(B[m]+"="+B[m+1]);  
                         B[m]=B[m+1];
                      }
                    ContB--;
                    ContA++;
                  
                }
             
                NoCambiar1=0;
                NoCambiar2=0;
              }
        }
      
 return true;
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        GrupoA = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        GrupoB = new javax.swing.JTextArea();
        mensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visor bipartito");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(1010, 675));

        jInternalFrame1.setPreferredSize(new java.awt.Dimension(1010, 675));
        jInternalFrame1.setVisible(true);

        jLabel1.setText("Grupo A : Azul");

        jLabel2.setText("Grupo B : Rojo");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/camera_32.png"))); // NOI18N
        jButton2.setToolTipText("Obtener imagen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        GrupoA.setEditable(false);
        GrupoA.setColumns(20);
        GrupoA.setRows(5);
        GrupoA.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(GrupoA);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        GrupoB.setEditable(false);
        GrupoB.setColumns(20);
        GrupoB.setRows(5);
        GrupoB.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(GrupoB);

        mensaje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(600, 600, 600))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 416, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(45, 45, 45))
        );

        jScrollPane1.getAccessibleContext().setAccessibleName("");

        jInternalFrame1.setBounds(0, 0, 1010, 675);
        jLayeredPane1.add(jInternalFrame1, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            Interfaz.frameDibujo.setMaximum(false);
           jInternalFrame1.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(CrearCompletar.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"ERROR Iniciarse Bipartito");
        }
        repaint();
        trabla();
    }//GEN-LAST:event_formWindowActivated

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         try {
            jInternalFrame1.setMaximum(false);
            Interfaz.frameDibujo.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(CrearCompletar.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"ERROR Cerrarse Bipartito");
        }
    }//GEN-LAST:event_formWindowClosing

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          jButton2.setVisible(false);

        Timer t = new Timer();

        TimerTask timerTask = new TimerTask() {

            public void run() {
                new Captura(jInternalFrame1);
                jButton2.setVisible(true);
            }
        };

        t.schedule(timerTask, 100);



    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Bipartito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bipartito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bipartito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bipartito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Bipartito dialog = new Bipartito(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextArea GrupoA;
    private javax.swing.JTextArea GrupoB;
    private javax.swing.JButton jButton2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel mensaje;
    // End of variables declaration//GEN-END:variables
}

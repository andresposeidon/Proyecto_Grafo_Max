
package AutoDibujar;

import dibujo.AreaDibujo;
import dibujo.Arista;
import gestion.Captura;
import interfaz.Interfaz;
import java.awt.*;
import java.beans.PropertyVetoException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Kruskal extends javax.swing.JDialog {

    private int Cant=0;
    private int CantArista=0;
    //private int Camino=0;
    private int CantLista=0;
 //   private int []recorrido=new int[50];        
    private int []v=new int[50];
    Arista []Orden= new Arista[100];
    Arista []Lista=new Arista[100];
    public Kruskal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconos/core32.png"));
        setIconImage(icon);
        this.setLocationRelativeTo(null);
        setVisible(true);
        
    }
  public Kruskal()
  {}
  
  public void Usar()
  {
  CopyOrden();
  }
    public void CopyOrden()
    {
        
      int suma=0; 
      int [][]MatriX= new int[10][10];
      int [][]MatriX2=new int[10][10];
      
      for(int i=0;i<=AreaDibujo.indicePuntos;i++)
          for(int j=0;j<=AreaDibujo.indicePuntos;j++)
              MatriX[i][j]=0;
      
        for(int c=0;c<=AreaDibujo.indiceAristas;c++)
        {
          Orden[c]= new Arista(AreaDibujo.aristas[c].puntoA,AreaDibujo.aristas[c].puntoB,false,0);   
          Orden[c].colorArista=Color.BLUE;
          Orden[c].peso=AreaDibujo.aristas[c].peso;
        } 
       
        Arista aux;
        for(int i=0;i<=AreaDibujo.indiceAristas-1;i++)
            for(int j=i+1;j<=AreaDibujo.indiceAristas;j++)
                 if(Orden[i].peso>Orden[j].peso)
                 {
                 aux=Orden[i];
                 Orden[i]=Orden[j];
                 Orden[j]=aux;
                 }
           int stop1=0;
           int stop2=0;
           for(int i=0;i<=AreaDibujo.indiceAristas;i++)
           {  
                for(int j=0;j<Cant;j++)
                {
                 if(Orden[i].puntoA.indice==v[j])
                     stop1=1;
                 if(Orden[i].puntoB.indice==v[j])
                     stop2=1;
                }
                if(stop1==1 &&stop2==1)
                {
                    for(int q=0;q<=AreaDibujo.indicePuntos;q++)
                      for(int w=0;w<=AreaDibujo.indicePuntos;w++)
                               MatriX2[q][w]=MatriX[q][w];
                    
                    
                MatriX2[Orden[i].puntoA.indice][Orden[i].puntoB.indice]=1;
                MatriX2[Orden[i].puntoB.indice][Orden[i].puntoA.indice]=1;
                //    System.out.println("x :"+Orden[i].puntoA.indice+" y :"+Orden[i].puntoB.indice);
                Viajar(MatriX2,AreaDibujo.indicePuntos+1,Orden[i].puntoA.indice,Orden[i].puntoB.indice);
                  if(CantLista<=1)
                  {
                     // System.out.println("Cantidad Total :"+CantLista); 
                 MatriX[Orden[i].puntoA.indice][Orden[i].puntoB.indice]=1;
                 MatriX[Orden[i].puntoB.indice][Orden[i].puntoA.indice]=1;
                 Lista[CantArista]=new Arista(Orden[i].puntoA,Orden[i].puntoB,false,0);
                 Lista[CantArista].colorArista=Color.BLUE;
                 Lista[CantArista].peso=Orden[i].peso;  
                 suma+=Orden[i].peso;
                 CantArista++;
                 CantLista=0;
                  }  
                }else    
               if(stop1==0 || stop2==0)
               {
                  if(stop1==0) 
                  {
                  v[Cant]=Orden[i].puntoA.indice;
                   Cant++;
                  }
                      
                  if(stop2==0)
                  {
                   v[Cant]=Orden[i].puntoB.indice;
                   Cant++;
                  }   
                 MatriX[Orden[i].puntoA.indice][Orden[i].puntoB.indice]=1;
                 MatriX[Orden[i].puntoB.indice][Orden[i].puntoA.indice]=1;
                 Lista[CantArista]=new Arista(Orden[i].puntoA,Orden[i].puntoB,false,0);
                 Lista[CantArista].colorArista=Color.BLUE;
                 Lista[CantArista].peso=Orden[i].peso;  
                 suma+=Orden[i].peso;
                 CantArista++;
               }       
                stop1=0;
                stop2=0;
           }    CantLista=0;
           
          jLabel1.setText("Costo Total : "+suma); 
    }
    
     public void paint(Graphics g)
    {
        
       super.paintComponents(g);
       Cant=0;
       CantArista=0;
       CopyOrden();
       jInternalFrame1.setBackground(Color.WHITE); 
       pintar(jInternalFrame1.getContentPane().getGraphics(),AreaDibujo.indicePuntos,Interfaz.CantidadAristasC);
       
    }
   
    public void pintar(Graphics g,int puntos,int aristas)
    {
         Graphics2D g2=(Graphics2D) g;
     
       for(int c=0;c<=AreaDibujo.indiceAristas;c++)
        {
         g2.setColor(Color.pink);
         g2.drawLine(AreaDibujo.aristas[c].puntoA.posicion.x+4,AreaDibujo.aristas[c].puntoA.posicion.y+4,AreaDibujo.aristas[c].puntoB.posicion.x+4,AreaDibujo.aristas[c].puntoB.posicion.y+4);
        }
        
          g2.setStroke(new BasicStroke(2.5f));
          g2.setColor(Color.green);
          for(int i=0;i<CantArista;i++){
          g2.drawLine(Lista[i].puntoA.posicion.x+4,Lista[i].puntoA.posicion.y+4,Lista[i].puntoB.posicion.x+4,Lista[i].puntoB.posicion.y+4);
          }
          g2.setColor(Color.blue);
        for(int c=0;c<=AreaDibujo.indiceAristas;c++)
         g2.drawString(AreaDibujo.aristas[c].peso+"",(AreaDibujo.aristas[c].puntoA.posicion.x+AreaDibujo.aristas[c].puntoB.posicion.x+4)/2,(AreaDibujo.aristas[c].puntoA.posicion.y+AreaDibujo.aristas[c].puntoB.posicion.y)/2);
       
        for(int c=0;c<=AreaDibujo.indicePuntos;c++)
        {
          g2.setColor(Color.black);    
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
}

   void Viajar(int matriz[][],int n,int pizo,int fin)
 {
             for(int j=0;j<n;j++)
              {
              if(matriz[fin][pizo]==1 && j==fin)
              {
               CantLista++;
              }else
                if(matriz[j][pizo]==1)
                 {
                    matriz[pizo][j]=0;
                    matriz[j][pizo]=0; 
                    Viajar(matriz,n,j,fin);
                    matriz[pizo][j]=1;
                    matriz[j][pizo]=1;
                  }
               }
}    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visor de árbol recubridor mínimo");
        setPreferredSize(new java.awt.Dimension(1010, 675));
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

        jLabel1.setText("Costo Total :");

        jLabel2.setText("Camino escogido");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/camera_32.png"))); // NOI18N
        jButton1.setToolTipText("Obtener imagen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setAutoscrolls(true);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setPreferredSize(new java.awt.Dimension(164, 90));
        jScrollPane2.setViewportView(jTextArea2);

        jLabel4.setText("Verde");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4)))
                .addGap(801, 801, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addGap(0, 927, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );

        jInternalFrame1.setBounds(0, 0, 1010, 675);
        jLayeredPane1.add(jInternalFrame1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      try {
            Interfaz.frameDibujo.setMaximum(false);
           jInternalFrame1.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(CrearCompletar.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
        int primero=Lista[0].puntoA.indice;
        int total=0;
        for(int i=0;i<CantArista;i++){
                    jTextArea2.append(""+(i+1)+".-("+Lista[i].puntoA.indice+","+Lista[i].puntoB.indice+")\n");
          }
    }//GEN-LAST:event_formWindowActivated

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      try {
            jInternalFrame1.setMaximum(false);
            Interfaz.frameDibujo.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(CrearCompletar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       jButton1.setVisible(false);
              
               Timer t=new Timer();
 
		TimerTask timerTask = new TimerTask() 
	        { 
	            public void run()  
	            { 
                      new Captura(jInternalFrame1);
                      jButton1.setVisible(true);
	            } 
	        }; 
 
		t.schedule(timerTask,100);
        
              
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Kruskal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kruskal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kruskal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kruskal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Kruskal dialog = new Kruskal(new javax.swing.JFrame(), true);
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
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}

package AutoDibujar;

import base.Matriz;
import dibujo.Punto;
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

public class Arbol extends javax.swing.JDialog {
      int []A= new int[10];
      int []B= new int[10];
      int ContA=0,ContB=0,BandB=0,BandA=0;
      int [][]matriz=new int[10][10];
      int [][]matrix=new int[10][10];
      int totalaristas=0;
      int totalaristasB=0;
      private NodoArbol raiz;
      
      
                                   
 
    public Arbol(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.setLocationRelativeTo(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconos/core32.png"));
        setIconImage(icon);
        setVisible(true);
   }
    
    
	//contruir un arbol vacio
	public Arbol(){
		raiz = null;
	}
           

        public void Llenado(){
           Arbol arbol=new Arbol(); 
        for(int i = 0; i < AreaDibujo.indicePuntos + 1; i++) {     
            
 
        if(AreaDibujo.puntos[i].indice == raiz_t()){
            arbol.insertarNodo(AreaDibujo.puntos[i].indice);
         System.out.println( AreaDibujo.puntos[i].indice + " es la Raiz "); 
         jLabel4.setText(" "+AreaDibujo.puntos[i].indice );
         
          break;
        }
         
        }
        
 
       for(int j = 0; j < AreaDibujo.indicePuntos + 1; j++) {
       if(AreaDibujo.matrizMostrada.matrizAdyacencia[j][arbol.raiz.datos] == 1) ;
       if(AreaDibujo.puntos[j].indice<arbol.raiz.datos){
            arbol.insertarNodo(AreaDibujo.puntos[j].indice);
        }else{
           arbol.insertarNodo(AreaDibujo.puntos[j].indice);

        }
}

                 
		System.out.println("\n\nRecorrido preorden");
		arbol.recorridoPreorden();

		System.out.println("\n\nRecorrido inorden");
		arbol.recorridoInorden();

		System.out.println("\n\nRecorrido posorden");
		arbol.recorridoPosorden();
               
                        
                 
    }
        
        
 /*     
      public  void ArbolBase(int raize, Arbol arbol){
            int cont=0;
		for(int i = 0; i < AreaDibujo.indicePuntos +1; i++) {
                    if(AreaDibujo.matrizMostrada.matrizAdyacencia[raize][i] == 1) {
                        cont++;
                                  
                                   if(cont==1){
                                       arbol.insertarNodo(AreaDibujo.puntos[i].indice);
                                       ArbolBase(AreaDibujo.puntos[i].indice, arbol);
                                   }
                                   if(cont==2){
                                       arbol.insertarNodo(AreaDibujo.puntos[i].indice);
                                       ArbolBase(AreaDibujo.puntos[i].indice, arbol);
                                   }
                     }         
                }
                
                
    }
     

   */     
	//insertar un nuevo nodo en el arbol de busqueda binaria
	public synchronized void insertarNodo(int valorInsertar)
	{
		if(raiz == null)
			raiz = new NodoArbol(valorInsertar); //crea nodo raiz

		else
			raiz.insertar(valorInsertar); // llama al metodo insertar
	}

        
        
        
        
        
	//--------------- EMPESAR EL RECORRIDO EN PREORDEN-----------------------
	public synchronized void recorridoPreorden()
	{
		ayudantePreorden(raiz);
	}
	//metodo recursivo para recorrido en preorden

	private void ayudantePreorden(NodoArbol nodo)
	{
		if (nodo == null)
			return;
                
                System.out.print(nodo.datos + " "); // mostrar datos del nodo
		ayudantePreorden(nodo.nodoizquierdo); //recorre subarbol izquierdo
		ayudantePreorden(nodo.nododerecho); //recorre subarbol derecho
	}


	//--------------EMPEZAR RECORRIDO INORDEN-----------------------------------
	public synchronized void recorridoInorden()
	{
		ayudanteInorden(raiz);
	}

	// metodo recursivo para recorrido inorden

	private void ayudanteInorden(NodoArbol nodo)
	{
		if (nodo == null)
			return;

		ayudanteInorden(nodo.nodoizquierdo);
		System.out.print(nodo.datos + " ");
		ayudanteInorden(nodo.nododerecho);
	}

	//-----------------------------EMPEZAR RECORRIDO POSORDEN---------------------------------
	public synchronized void recorridoPosorden()
	{
		ayudantePosorden(raiz);
	}

	//metodo recursivo para recorrido posorden

	private void ayudantePosorden(NodoArbol nodo)
	{
		if (nodo == null)
			return;

		ayudantePosorden(nodo.nodoizquierdo);
		ayudantePosorden(nodo.nododerecho);
		System.out.print(nodo.datos + " ");
	}
        

//fin clase arbol


     public int raiz_t() {
    
    int raiz = -1;
    int var_t;
    final int max_n = AreaDibujo.indicePuntos;
    
    

    for(int i = 0; i < max_n + 1; i++) {
    var_t = 0;
    for(int j = 0; j < max_n + 1; j++) {
    if(AreaDibujo.matrizMostrada.matrizAdyacencia[i][j] == 1) var_t++;
    }

    if(var_t == 2) {
    raiz = i; break;
    }
    }

    if(raiz == -1) {
    for(int i = 0; i < max_n + 1; i++) {
    var_t = 0;
    for(int j = 0; j < max_n + 1; j++) {
    if(AreaDibujo.matrizMostrada.matrizAdyacencia[i][j] == 1) var_t++;
    }

    if(var_t == 1) {
    raiz = i; break;
    }
    }
    }

    return raiz;
    }



    @Override
      public void paint(Graphics g){
       super.paintComponents(g);
        ContA=0;ContB=0;
        BandB=0;BandA=0;    
       jInternalFrame1.setBackground(Color.WHITE); 
       pintar(jInternalFrame1.getContentPane().getGraphics(),AreaDibujo.indicePuntos,Interfaz.CantidadAristasC);
    }
    

    public void pintar(Graphics g,int puntos,int aristas){
         
        Graphics2D g2=(Graphics2D) g;
            for(int c=0;c<=AreaDibujo.indiceAristas;c++)
            {
                if(AreaDibujo.aristas[c].tamaño==1){
                    g2.setStroke(new BasicStroke(1.0f));
                }
                if(AreaDibujo.aristas[c].tamaño==2){
                    g2.setStroke(new BasicStroke(1.7f));
                }
                if(AreaDibujo.aristas[c].tamaño==3){
                    g2.setStroke(new BasicStroke(2.3f));
                }
                if(AreaDibujo.aristas[c].tamaño==4){
                    g2.setStroke(new BasicStroke(3.0f));  
                }
                g2.setColor(AreaDibujo.aristas[c].colorArista);
                g2.drawLine(AreaDibujo.aristas[c].puntoA.posicion.x+4,AreaDibujo.aristas[c].puntoA.posicion.y+4,AreaDibujo.aristas[c].puntoB.posicion.x+4,AreaDibujo.aristas[c].puntoB.posicion.y+4);
        }
            for(int c=0;c<=AreaDibujo.indicePuntos;c++)
        {
            g2.setColor(AreaDibujo.puntos[c].colorPunto);
            if("Circulo".equals(AreaDibujo.puntos[c].forma)){
                g2.fillOval(AreaDibujo.puntos[c].posicion.x-((AreaDibujo.puntos[c].circle/2)-4),AreaDibujo.puntos[c].posicion.y-((AreaDibujo.puntos[c].circle/2)-4),AreaDibujo.puntos[c].circle,AreaDibujo.puntos[c].circle);
            }
            else{
                g2.fillRect(AreaDibujo.puntos[c].posicion.x-((AreaDibujo.puntos[c].circle/2)-4),AreaDibujo.puntos[c].posicion.y-((AreaDibujo.puntos[c].circle/2)-4),AreaDibujo.puntos[c].circle,AreaDibujo.puntos[c].circle); 
            }
            g2.setColor(Color.WHITE);
            g2.drawString(Integer.toString(AreaDibujo.puntos[c].getIndice()),AreaDibujo.puntos[c].posicion.x+1,AreaDibujo.puntos[c].posicion.y+8);
         
            g2.setColor(Color.BLACK);
            if(AreaDibujo.puntos[c].getEtiqueta()!=null){
                g2.drawString(AreaDibujo.puntos[c].getEtiqueta(),AreaDibujo.puntos[c].posicion.x-8,AreaDibujo.puntos[c].posicion.y-((AreaDibujo.puntos[c].circle/2)));
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
   
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jButton2 = new javax.swing.JButton();
        mensaje = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visor bipartito");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
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

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(1010, 675));

        jInternalFrame1.setPreferredSize(new java.awt.Dimension(1010, 675));
        jInternalFrame1.setVisible(true);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/camera_32.png"))); // NOI18N
        jButton2.setToolTipText("Obtener imagen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        mensaje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("PreOrden");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("PostOrden");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("InOrden");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Altura: ");

        jLabel2.setText("Conexo: ");

        jLabel3.setText("Raiz: ");

        jLabel4.setText(" ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(232, 606, Short.MAX_VALUE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
        );

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
   
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
             Llenado();
              repaint();
    }//GEN-LAST:event_formWindowOpened

   
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
            java.util.logging.Logger.getLogger(Arbol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Arbol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Arbol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Arbol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Arbol dialog = new Arbol(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel mensaje;
    // End of variables declaration//GEN-END:variables
}
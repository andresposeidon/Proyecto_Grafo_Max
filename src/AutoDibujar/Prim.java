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


public class Prim extends javax.swing.JDialog {
        int[]MiCamino= new int [10];
     public  int Matrizresul [][];
        boolean[] marcados;
        int total=0;
        
    public Prim(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconos/core32.png"));
        setIconImage(icon);
        this.setLocationRelativeTo(null);
        setVisible(true);
    }
    public Prim()
    {
    }    
    
    public void Freury()
    {
     Matrizresul=AlgPrim(AreaDibujo.matrizAdyacencia);
     
     for(int i=0;i<10;i++){
       tabla.setValueAt("  "+i, i, 0);
     }
     for(int i=0;i<AreaDibujo.indicePuntos+1;i++){
            for(int j=0;j<AreaDibujo.indicePuntos+1;j++){
               tabla.setValueAt(""+Matrizresul[i][j], i, j+1);
            }
    }
     total=0;
     for(int i=0;i<=AreaDibujo.indicePuntos;i++)
     {
         if(marcados[i]==true)
         {
             MiCamino[total]=i;
             total++;
         }
     }
    }
    
    @Override
    public void paint(Graphics g)
    {
        
       super.paintComponents(g);
       jInternalFrame1.setBackground(Color.WHITE); 
       pintar(jInternalFrame1.getContentPane().getGraphics(),AreaDibujo.indicePuntos,Interfaz.CantidadAristasC);
       
    }
   
    public void pintar(Graphics g,int puntos,int aristas)
    {
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
         g2.setStroke(new BasicStroke(2.3f));
         g2.setColor(Color.yellow);
         
         if(total!=0){
            for(int i=0;i<=AreaDibujo.indicePuntos;i++){
                for(int j=0;j<=AreaDibujo.indicePuntos;j++){
                    if(Matrizresul[i][j]!=0){
                        g2.drawLine(AreaDibujo.puntos[i].posicion.x+4,AreaDibujo.puntos[i].posicion.y+4,AreaDibujo.puntos[j].posicion.x+4,AreaDibujo.puntos[j].posicion.y+4);
                    } 
                }
            }
         }
        g2.setColor(Color.blue);
        for(int c=0;c<=AreaDibujo.indiceAristas;c++){
            g2.drawString(AreaDibujo.aristas[c].peso+"",(AreaDibujo.aristas[c].puntoA.posicion.x+AreaDibujo.aristas[c].puntoB.posicion.x+4)/2,(AreaDibujo.aristas[c].puntoA.posicion.y+AreaDibujo.aristas[c].puntoB.posicion.y)/2);
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
        int i;
         for(int c=0;c<total;c++)
        {
           i=c+1; 
            g2.setColor(Color.green);
            if("Circulo".equals(AreaDibujo.puntos[MiCamino[i]].forma)){
                g2.fillOval(AreaDibujo.puntos[MiCamino[i]].posicion.x-((AreaDibujo.puntos[MiCamino[i]].circle/2)-4),AreaDibujo.puntos[MiCamino[i]].posicion.y-((AreaDibujo.puntos[MiCamino[i]].circle/2)-4),AreaDibujo.puntos[MiCamino[i]].circle,AreaDibujo.puntos[MiCamino[i]].circle);
            }
            else{
                g2.fillRect(AreaDibujo.puntos[MiCamino[i]].posicion.x-((AreaDibujo.puntos[MiCamino[i]].circle/2)-4),AreaDibujo.puntos[MiCamino[i]].posicion.y-((AreaDibujo.puntos[MiCamino[i]].circle/2)-4),AreaDibujo.puntos[MiCamino[i]].circle,AreaDibujo.puntos[MiCamino[i]].circle); 
            }
            g2.setColor(Color.WHITE);
            g2.drawString(Integer.toString(AreaDibujo.puntos[MiCamino[i]].getIndice()),AreaDibujo.puntos[MiCamino[i]].posicion.x+1,AreaDibujo.puntos[MiCamino[i]].posicion.y+8);
         
            g2.setColor(Color.BLACK);
            if(AreaDibujo.puntos[MiCamino[i]].getEtiqueta()!=null){
                g2.drawString(AreaDibujo.puntos[MiCamino[i]].getEtiqueta(),AreaDibujo.puntos[MiCamino[i]].posicion.x-8,AreaDibujo.puntos[MiCamino[i]].posicion.y-((AreaDibujo.puntos[MiCamino[i]].circle/2)));
            }
        }
    }
 
  public int[][] AlgPrim(int[][] Matriz) {  //Llega la matriz a la que le vamos a aplicar el algoritmo
        marcados = new boolean[10]; //Creamos un vector booleano, para saber cuales están marcados
        int vertice = 0; //Le introducimos un nodo aleatorio, o el primero
        return AlgPrim(Matriz, marcados, vertice, new int[AreaDibujo.indicePuntos+1][AreaDibujo.indicePuntos+1]); //Llamamos al método recursivo mandándole 
    }                                                                                     //un matriz nueva para que en ella nos 
                                                                                          //devuelva el árbol final
    private int[][] AlgPrim(int[][] Matriz, boolean[] marcados, int vertice, int[][] Final) {
        marcados[vertice] = true;//marcamos el primer nodo
        int aux = -1;
        if (!TodosMarcados(marcados)) { //Mientras que no todos estén marcados
            for (int i = 0; i < marcados.length; i++) { //Recorremos sólo las filas de los nodos marcados
                if (marcados[i]) {
                    for (int j = 0; j < Matriz.length; j++) {
                        if (Matriz[i][j] != 0) {        //Si la arista existe
                            if (!marcados[j]) {         //Si el nodo no ha sido marcado antes
                                if (aux == -1) {        //Esto sólo se hace una vez
                                    aux = Matriz[i][j];
                                } else {
                                    aux = Math.min(aux, Matriz[i][j]); //Encontramos la arista mínima
                                }
                            }
                        }
                    }
                }
            }
            //Aquí buscamos el nodo correspondiente a esa arista mínima (aux)
            for (int i = 0; i < marcados.length; i++) {
                if (marcados[i]) {
                    for (int j = 0; j < Matriz.length; j++) {
                        if (Matriz[i][j] == aux) {
                            if (!marcados[j]) { //Si no ha sido marcado antes
                                Final[i][j] = aux; //Se llena la matriz final con el valor
                                Final[j][i] = aux;//Se llena la matriz final con el valor
                                return AlgPrim(Matriz, marcados, j, Final); //se llama de nuevo al método con
                                                                                               //el nodo a marcar
                            }
                        }
                    }
                }
            }
        }
        return Final;
    }
    public boolean TodosMarcados(boolean[] vertice) { //Método para saber si todos están marcados
        for (boolean b : vertice) {
            if (!b) {
                return b;
            }
        }
        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Algoritmo de Prim");
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
        jInternalFrame1.setVisible(true);

        jLabel1.setText("Matriz Resultante de Prim");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Short.class, java.lang.Short.class, java.lang.Short.class, java.lang.Short.class, java.lang.Short.class, java.lang.Short.class, java.lang.Short.class, java.lang.Short.class, java.lang.Short.class, java.lang.Short.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setColumnSelectionAllowed(true);
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);
        tabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla.getColumnModel().getColumn(0).setResizable(false);
        tabla.getColumnModel().getColumn(1).setResizable(false);
        tabla.getColumnModel().getColumn(2).setResizable(false);
        tabla.getColumnModel().getColumn(3).setResizable(false);
        tabla.getColumnModel().getColumn(4).setResizable(false);
        tabla.getColumnModel().getColumn(5).setResizable(false);
        tabla.getColumnModel().getColumn(6).setResizable(false);
        tabla.getColumnModel().getColumn(7).setResizable(false);
        tabla.getColumnModel().getColumn(8).setResizable(false);
        tabla.getColumnModel().getColumn(9).setResizable(false);
        tabla.getColumnModel().getColumn(10).setResizable(false);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(758, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap(411, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jInternalFrame1.setBounds(0, 0, 1010, 680);
        jLayeredPane1.add(jInternalFrame1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
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
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      try {
            Interfaz.frameDibujo.setMaximum(false);
            jInternalFrame1.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(CrearCompletar.class.getName()).log(Level.SEVERE, null, ex);
        }
      Freury();
      repaint();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
  
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
   try {
            jInternalFrame1.setMaximum(false);
            Interfaz.frameDibujo.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(CrearCompletar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Prim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Prim dialog = new Prim(new javax.swing.JFrame(), true);
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
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}

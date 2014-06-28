/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import AutoDibujar.Bipartito;
import AutoDibujar.CicloEuleriano;
import dibujo.AreaDibujo;
import interfaz.Interfaz;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//import java.awt.event.InputEvent;
//import java.awt.event.KeyEvent;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import sun.applet.Main;

public class Matriz extends JPanel implements ActionListener{

    public int[][] matrizAdyacencia;
    public static int[][] matrizCopia;
    public String[][] matrizS;
    private JTextField[][] matrizMostrada;
    private JLabel[] horizontalTitles;
    private JLabel[] verticalTitles;
    public int Matriz[][]=new int[10][10];
    public int Camino[]=new int[15];
    private int n;
    public Grafo grafo;
    public static int [] vectorColorear ;
    public static int cantidaddecolores=4;
    
    public Matriz(int[][] matrizAdyacencia, String[][] matrizS) {
        super();
        this.matrizAdyacencia=matrizAdyacencia;
        matrizCopia = matrizAdyacencia;
        this.matrizS=matrizS;
        matrizMostrada=new JTextField[10][10];
        horizontalTitles=new JLabel[10];
        verticalTitles=new JLabel[10];
        crearMatrizMostrada();
        this.setLayout(null);
        Interfaz.menuActualizar.addActionListener(this);
        Interfaz.Actualizar.addActionListener(this);
        n=0;
        
    }
    
    private void crearMatrizMostrada(){
        
        for(int i=0; i<10; i++){
            for(int j=0; j<10;j++){
                matrizMostrada[i][j]=new JTextField();
                matrizMostrada[i][j].setBounds(i*20+25, j*20+25, 18,18 );
                matrizMostrada[i][j].setEditable(false);
                matrizMostrada[i][j].setVisible(true);
                this.add(matrizMostrada[i][j]);
                
            }
        }
        for(int i=0; i<10; i++){
            horizontalTitles[i]=new JLabel(Integer.toHexString(i));
            horizontalTitles[i].setBounds(4, i*20+25, 18, 18);
            horizontalTitles[i].setHorizontalAlignment(JLabel.RIGHT);
            verticalTitles[i]=new JLabel(Integer.toHexString(i));
            verticalTitles[i].setBounds(i*20+25, 9, 18, 18);
            verticalTitles[i].setHorizontalAlignment(JLabel.CENTER);
            this.add(verticalTitles[i]);
            this.add(horizontalTitles[i]);
            horizontalTitles[i].setVisible(true);            
        }

    }
    
    public void actualizarMatriz(){
        int cant=0,all=0,c=0;
        
        if(AreaDibujo.indiceAristas==-1)
        {
         Interfaz.aristaDirNueva.setEnabled(true);
         Interfaz.aristaNueva.setEnabled(true);
         Interfaz.BarAgregaArista.setEnabled(true);
         Interfaz.BaragreArisDir.setEnabled(true);
         Interfaz.borrarArista.setEnabled(false);
         Interfaz.BarElimiArista.setEnabled(false);
        }else
        { 
            Interfaz.borrarArista.setEnabled(true);
            Interfaz.BarElimiArista.setEnabled(true);
         if(AreaDibujo.aristas[0].esDirigida()){
            Interfaz.Dirigidos.setText("Dirigido : Si");
            Interfaz.botprim.setEnabled(false);
            Interfaz.barPrim.setEnabled(false);
            Interfaz.AlPrim.setEnabled(false);
         }
         else{
            Interfaz.Dirigidos.setText("Dirigido : No"); 
         }
        }   
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                matrizMostrada[i][j].setText(" "+matrizS[i][j]);
              if(!"".equals(matrizS[i][j]) && i!=j && (Integer.parseInt(matrizS[i][j])==1 ||Integer.parseInt(matrizS[i][j])==0) &&all==0)
              { 
                    if( Integer.parseInt(matrizS[j][i])==1 && Integer.parseInt(matrizS[i][j])==1){
                        cant++;       
                    }
                    if( Integer.parseInt(matrizS[j][i])==0 && Integer.parseInt(matrizS[i][j])==1){
                        cant++;
                    }
                    if( Integer.parseInt(matrizS[j][i])==1 && Integer.parseInt(matrizS[i][j])==0){
                        cant++;
                    }     
              }
           }
           if(cant%2!=0){
               all=1;
           }
           cant=0;
        }
        for(int j=0; j<10; j++){
                Interfaz.tablagrados.setValueAt("", 0, j);
                Interfaz.tablagrados.setValueAt("", 1, j);
            }
        if(AreaDibujo.indicePuntos>=0){
            int Vec1[];
            Vec1=new int[10];
            int Vec2[];
            Vec2=new int[10];
            for(int i=0; i<=AreaDibujo.indicePuntos; i++){
                for(int j=0; j<=AreaDibujo.indicePuntos; j++){
                    Vec1[i]=Vec1[i]+Integer.parseInt(matrizS[j][i]);
                    Vec2[i]=Vec2[i]+Integer.parseInt(matrizS[i][j]);
                }
            }
            for(int j=0; j<=AreaDibujo.indicePuntos; j++){
                 Interfaz.tablagrados.setValueAt(Vec1[j], 0, j);
                 Interfaz.tablagrados.setValueAt(Vec2[j], 1, j);
            }
        }
        if(all==0 && AreaDibujo.indiceAristas>=1)
        {
             
           CicloEuleriano cicloEuleriano = new CicloEuleriano();
          if(cicloEuleriano.Freury()){
            Interfaz.eulerians.setText("Euleriano : Si");
          }
          else{
              Interfaz.eulerians.setText("Euleriano : No");
          }   
        }       
        else{
              Interfaz.eulerians.setText("Euleriano : No");
        }
        all=0;
        for(c=0;!"".equals(matrizS[0][c]) && c<AreaDibujo.indicePuntos;c++){}
        
        for(int i=0 ; i<c+1;i++)
        {
            for(int j=0;j<c+1;j++)
               if(i!=j && "0".equals(matrizS[i][j]))
               {
               i=c;
               all=1;
               break;
               }
        }
            if(all==0 && AreaDibujo.indiceAristas>=0)
            Interfaz.completo.setText("Completo : Si");
            else
            Interfaz.completo.setText("Completo : No");    
            
        
        if("Euleriano : Si".equals(Interfaz.eulerians.getText())){
            Interfaz.CicloEulerians.setEnabled(true);
            Interfaz.boteule.setEnabled(true);
            Interfaz.barEule.setEnabled(true);
            AreaDibujo.Euleriano.setEnabled(true);
        }
        else{
              Interfaz.CicloEulerians.setEnabled(false);
              Interfaz.boteule.setEnabled(false);
              Interfaz.barEule.setEnabled(false);
              AreaDibujo.Euleriano.setEnabled(false);
        }
        
       Bipartito stars=new Bipartito();
      
        if(stars.Bipar())
        { 
            if(AreaDibujo.indiceAristas>=0){
                Interfaz.BuscarBipartito.setText("Bipartito : Si");
                Interfaz.Bipartito.setEnabled(true);
                Interfaz.botbipartito.setEnabled(true);
                Interfaz.BarBipartito.setEnabled(true);
                AreaDibujo.Bipartito.setEnabled(true);
            }
            else{
                Interfaz.BuscarBipartito.setText("Bipartito : No");
                Interfaz.Bipartito.setEnabled(false);
                Interfaz.botbipartito.setEnabled(false);
                Interfaz.BarBipartito.setEnabled(false);
                AreaDibujo.Bipartito.setEnabled(false);
            }
        }
        else
        {
            Interfaz.BuscarBipartito.setText("Bipartito : No");
            Interfaz.Bipartito.setEnabled(false);
            Interfaz.botbipartito.setEnabled(false);
            Interfaz.BarBipartito.setEnabled(false);
            AreaDibujo.Bipartito.setEnabled(false);
        }
        matrizAdy();
        RecHamil();
        ActivarKruskal();
        
    }
    
    
    
    
    public boolean esConexo(){
        for(n=0; n<10; n++){
            if(matrizAdyacencia[0][n]==-1){
                break;
            }
        }
        int matriz[][];
        int matrizInicial[][];
        int matrizAux[][];
        matriz=new int[n][n];
        matrizInicial=new int[n][n];
        matrizAux=new int[n][n];
        Extras.copiarMatriz(matrizInicial, matrizAdyacencia, n);
        Extras.matrizIdentidad(matriz, n);
        Extras.copiarMatriz(matrizAux, matrizAdyacencia, n);
        for(int i=1; i<=9; i++){
            matriz=Extras.sumarMatriz(matriz, matrizAux, n);
            matrizAux=Extras.productoMatriz(matrizInicial, matrizAux, n);
            Interfaz.progresoAcciones.setValue(2*i+99);
            Rectangle rc=Interfaz.progresoAcciones.getBounds();
            rc.x=0;
            rc.y=0;
            Interfaz.progresoAcciones.paintImmediately(rc);
            if(Extras.revisarMatriz(matriz, n)==true){
                return true;
            }
        }
        
        return false;
    }
      
    boolean hamMito(int pizo,int matriz[][],int n,int vector[],int cont,int v[])
{
    int Rcopy[]=new int[100];
 
       if((cont==n) && v[pizo]==1)
       {
         vector[cont]=0;
          cont++;            
          return true;
       }   
        
         for(int z=0;z<n;z++)
           Rcopy[z]=matriz[z][pizo];      
           
           if(pizo==0)
            for(int z=0;z<n;z++)              
               matriz[z][pizo]=0;         
                 else
                   for(int z=1;z<n;z++)              
                    matriz[z][pizo]=0; 
                     
             for(int z=0;z<n;z++)
              if(matriz[pizo][z]==1)
                {
                  vector[cont]=z;                  
                  cont++;                  
                   if(hamMito(z,matriz,n,vector,cont,v))
                     return true;
                   else{
                        cont--;
                        
                   }
                 }
           for(int i=0;i<n;i++)
                        matriz[i][pizo]=Rcopy[i];        
                     
return false;                
}

   public void RecHamil()
   {
   for(int i=0;i<AreaDibujo.indicePuntos+1;i++)
            for(int j=0;j<AreaDibujo.indicePuntos+1;j++)
               Matriz[i][j]=Integer.parseInt(matrizS[i][j]);
       
   
   
       if("Conexo : Si".equals(Interfaz.conexo.getText()) &&AreaDibujo.indicePuntos>=2 && AreaDibujo.indiceAristas>=2)
       {
         Camino[0]=0;
        
        int []v=new int[10];
        for(int x=0;x<AreaDibujo.indicePuntos+1;x++)
        v[x]=Matriz[x][0];
       
      if(hamMito(0,Matriz,AreaDibujo.indicePuntos+1,Camino,1,v))
      {
          Interfaz.CicloHamilt.setEnabled(true);
          Interfaz.barhamil.setEnabled(true);
          Interfaz.bothami.setEnabled(true);
          AreaDibujo.Hamiltoniano.setEnabled(true);
             Interfaz.hamilt.setText("Hamiltoniano : Si");
             
      }   else
      {
             Interfaz.CicloHamilt.setEnabled(false);
             Interfaz.barhamil.setEnabled(false);
             Interfaz.bothami.setEnabled(false);
             AreaDibujo.Hamiltoniano.setEnabled(false);
             Interfaz.hamilt.setText("Hamiltoniano : No");
      }
       }else
       {
            Interfaz.barhamil.setEnabled(false);
            AreaDibujo.Hamiltoniano.setEnabled(false);
            Interfaz.bothami.setEnabled(false);
            Interfaz.CicloHamilt.setEnabled(false);
            Interfaz.hamilt.setText("Hamiltoniano : No");
       }
           
        
   }
    void ActivarKruskal()
    {
      if("Conexo : Si".equals(Interfaz.conexo.getText())){
        Interfaz.Kruskal.setEnabled(true);
      Interfaz.BotKruska.setEnabled(true);
      Interfaz.jMenuItem2.setEnabled(true);
      }
      else{
          Interfaz.Kruskal.setEnabled(false); 
          Interfaz.BotKruska.setEnabled(false);
          Interfaz.jMenuItem2.setEnabled(false);
      }
    }
    
    public void actualizar()
    {
      if(!Interfaz.AutoActualizar.isSelected())
          return;
      
        this.actualizarMatriz();
        if(matrizAdyacencia[0][1]!=-1){
            if(this.esConexo()==true){
                Interfaz.conexo.setText("Conexo : Si");
                Interfaz.conexo87.setEnabled(true);
                     Interfaz.conex.setEnabled(true);
                     AreaDibujo.Conexo.setEnabled(true);
                 if(AreaDibujo.aristas[0].esDirigida()){
                     Interfaz.botprim.setEnabled(false);
                     Interfaz.barPrim.setEnabled(false);
                     Interfaz.AlPrim.setEnabled(false);
                    
                 }
                 else{
                     Interfaz.botprim.setEnabled(true);
                     Interfaz.barPrim.setEnabled(true);
                     Interfaz.AlPrim.setEnabled(true);
                   
                 }
            } else {
                Interfaz.conexo.setText("Conexo : No");
                Interfaz.botprim.setEnabled(false);
                Interfaz.barPrim.setEnabled(false);
                Interfaz.AlPrim.setEnabled(false);
                Interfaz.conexo87.setEnabled(false);
                Interfaz.conex.setEnabled(false);
                AreaDibujo.Conexo.setEnabled(false);
            }
        } else {
            Interfaz.conexo.setText("Conexo : No");
            Interfaz.botprim.setEnabled(false);
            Interfaz.barPrim.setEnabled(false);
            Interfaz.AlPrim.setEnabled(false);
            Interfaz.conexo87.setEnabled(false);
            Interfaz.conex.setEnabled(false);
            AreaDibujo.Conexo.setEnabled(false);
        }
        RecHamil();
        ActivarKruskal();
        for(int i=0; i<=29; i=i+10){
            Interfaz.progresoAcciones.setValue(130+i);
            Rectangle rc=Interfaz.progresoAcciones.getBounds();
            rc.x=0;
            rc.y=0;
            Interfaz.progresoAcciones.paintImmediately(rc);
        }
        Interfaz.progresoAcciones.setValue(0);
    }
    public static void colorearGrafo(){
        int contadorDisponible=0;
        int contadorNoDisponible=0;
        int contadorColores=0;
        int agregaVector=0;
        vectorColorear = new int[20];
        int [] clonaVector = new int [20];
        int [] vectorDisponible = new int[20];
        int [] vectorNoDisponible = new int[20];
        int i=0,primerDesbloq=0;
        int contaMatriz=0,puntoMenor=10,Minimo=0;
            for (int j=0;j<= AreaDibujo.indicePuntos;j++){
                 for (int k=0;k<=AreaDibujo.indicePuntos;k++){
                      if (matrizCopia[j][k]==1){
                          contaMatriz++;  
                        }
                  }    
                 if (contaMatriz<=puntoMenor){
                     puntoMenor=contaMatriz;
                     Minimo=j;
                 }
                 contaMatriz=0;
             }
             i=Minimo;
             for (int n=0;n<=AreaDibujo.indicePuntos;n++)clonaVector[n]=n;
                  while (contadorColores - agregaVector <= AreaDibujo.indicePuntos){ 
                         for (int j=0;j<= AreaDibujo.indicePuntos;j++){
                              if (matrizCopia[i][j]==1 && i!=j){
                                  if (clonaVector[j]!=-1){ 
                                      vectorNoDisponible[contadorNoDisponible]= j;
                                      contadorNoDisponible++;
                                   }
                               }
                              else if (i!=j && clonaVector[j]!=-1){
                                       vectorDisponible[contadorDisponible]= j;
                                       contadorDisponible++;
                               }
                          }
                          vectorNoDisponible[contadorNoDisponible]= i;
                          contadorNoDisponible++;
                          vectorColorear[contadorColores] = i;
                          for (int n=0;n<=AreaDibujo.indicePuntos;n++){
                               if (clonaVector[n]==i)clonaVector[n]=-1;
                          }
                          contadorColores++;  
                          int aux=-1,z;
                          for (int t=0;t<contadorDisponible;t++){
                               int cont=0;
                               for ( z=0;z<contadorNoDisponible;z++){
                                   if (vectorNoDisponible[z]== vectorDisponible[t])cont=1;
                               }
                               if (cont==0){
                                   aux=t;
                                   t=contadorDisponible;
                               }
                           }
                          if (aux==-1){
                              vectorColorear[contadorColores] = -1;
                              int num,conta=0,menor=10,l=0,valido=0,validoVector=0;
                              for (int h=0;h< contadorNoDisponible;h++){
                                   num=vectorNoDisponible[h];
                                   validoVector=0;
                                   for (int f=0;f<contadorColores;f++){
                                        if (num == vectorColorear[f])validoVector++;
                                   }
                                   if (num!=-1 && validoVector==0){
                                       for (l=0;l<=AreaDibujo.indicePuntos;l++){ 
                                            if (clonaVector[l]!=-1){
                                                valido=1;
                                                if (matrizCopia[num][l]==1){
                                                    conta++;
                                                }
                                            }
                                        }
                                        if (conta<=menor && valido==1){
                                            menor=conta;
                                            primerDesbloq=num;
                                            valido=0;
                                         }
                                         conta=0;
                                      }
                                   }
                                   contadorColores++;
                                   agregaVector++;
                                   vectorDisponible = new int[20];
                                   vectorNoDisponible = new int[20];
                                   contadorNoDisponible=0;
                                   contadorDisponible=0;
                                   i=primerDesbloq;
                             
                              }
                              else{
                                   i=vectorDisponible[aux];
                                   contadorDisponible=0;
                                   vectorDisponible = new int[20];
                              }
                                     
                  }
                  int ordenColor=0;
                  int contadorColor=0,verificarColor=0;;
                  for (int e = 0;e<contadorColores;e++){
                      if(vectorColorear[e]==-1)verificarColor++;
                  }
                  if (verificarColor<=cantidaddecolores){
                     for (int k = 0;k<contadorColores;k++){
                          if (vectorColorear[k]==-1)contadorColor++;
                          if (vectorColorear[k]!=-1){
                              ordenColor = vectorColorear[k];
                              if(contadorColor == 0)AreaDibujo.puntos[ordenColor].colorPunto = Color.RED;
                              else if(contadorColor == 1)AreaDibujo.puntos[ordenColor].colorPunto = Color.GREEN;
                              else if(contadorColor == 2)AreaDibujo.puntos[ordenColor].colorPunto = Color.BLUE;
                              else if(contadorColor == 3)AreaDibujo.puntos[ordenColor].colorPunto = Color.ORANGE;
                              else if(contadorColor == 4)AreaDibujo.puntos[ordenColor].colorPunto = Color.BLACK;
                              else if(contadorColor == 5)AreaDibujo.puntos[ordenColor].colorPunto = Color.YELLOW;
                              else if(contadorColor == 6)AreaDibujo.puntos[ordenColor].colorPunto = Color.PINK;
                              else if(contadorColor == 7)AreaDibujo.puntos[ordenColor].colorPunto = Color.GRAY;
                              else if(contadorColor == 8)AreaDibujo.puntos[ordenColor].colorPunto = Color.MAGENTA;
                              else if(contadorColor == 9)AreaDibujo.puntos[ordenColor].colorPunto = Color.CYAN;
                          }
                     }
                     AreaDibujo.lienzo.repaint();
                     Interfaz.mensajeAcciones.setForeground(Color.GREEN);
                     if(cantidaddecolores==4){
                        Interfaz.mensajeAcciones.setText("Se ha logrado colorear con 4 colores el grafo");
                     }
                     else{
                         Interfaz.mensajeAcciones.setText("Se ha logrado colorear con más colores el grafo");
                     }
                    
                 }
                 else{
                      Interfaz.mensajeAcciones.setForeground(Color.red);
                      Interfaz.mensajeAcciones.setText("No se Puede colorear, necesita más de 4 colores"); 
                    if(JOptionPane.showConfirmDialog(null, "No se Puede colorear, necesita más de 4 colores\n" + "¿Desea Colorear con más Colores?")==JOptionPane.YES_OPTION){
                        cantidaddecolores=10;
                        colorearGrafo();
                        cantidaddecolores=4;
                    }
                      
                      
                 } 
          }
    
     public void matrizAdy(){
           if(AreaDibujo.indicePuntos>=0){
                for(int i=0; i<10;i++){
                    for(int j=0; j<10;j++){
                        AreaDibujo.matrizAdyacencia[j][i]=0;
                    }
                }
               if(AreaDibujo.indiceAristas>=0 && AreaDibujo.aristas[0].esDirigida()==false){
                   for(int j=0; j<=AreaDibujo.indiceAristas; j++){
                       AreaDibujo.matrizAdyacencia[AreaDibujo.aristas[j].getDestino()][AreaDibujo.aristas[j].getOrigen()]=AreaDibujo.aristas[j].peso;
                        AreaDibujo.matrizAdyacencia[AreaDibujo.aristas[j].getOrigen()][AreaDibujo.aristas[j].getDestino()]=AreaDibujo.aristas[j].peso;
                    }
                }
           }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.actualizarMatriz();
        if(matrizAdyacencia[0][1]!=-1){
            if(this.esConexo()==true){
                Interfaz.conexo.setText("Conexo : Si");
            } else {
                Interfaz.conexo.setText("Conexo : No");
            }
        } else {
            Interfaz.conexo.setText("Conexo : No");
        }
       RecHamil();
       ActivarKruskal();
        for(int i=0; i<=29; i=i+10){
            Interfaz.progresoAcciones.setValue(130+i);
            Rectangle rc=Interfaz.progresoAcciones.getBounds();
            rc.x=0;
            rc.y=0;
            Interfaz.progresoAcciones.paintImmediately(rc);
        }
        Interfaz.progresoAcciones.setValue(0);
    }
}

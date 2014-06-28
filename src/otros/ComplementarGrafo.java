/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otros;

import dibujo.AreaDibujo;
import dibujo.Arista;
import gestion.Estado;
import interfaz.Interfaz;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import AutoDibujar.CrearCompletar;
import gestion.Captura;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author voragoth
 */
public class ComplementarGrafo implements ActionListener{
    AreaDibujo areaDibujo;
    Estado estado;
    
    public ComplementarGrafo(AreaDibujo areaDibujo){
        this.areaDibujo=areaDibujo;
        estado=new Estado();
   //     TablaAcciones.complementar.addActionListener(this);
    //     CrearCompletar.Transferir.addActionListener(this);
    }
    
    public void complementar(){
        int indicePuntos;
        estado.guardarDatos(areaDibujo);
        indicePuntos=estado.indicePuntos;
        if(indicePuntos>=1){
            for(int i=0; i<=estado.indiceAristas; i++){
                estado.aristas[i]=null;
            }
            estado.indiceAristas=-1;
            
            for(int i=0; i<=indicePuntos; i++){
                for(int j=0; j<=indicePuntos; j++){
                    if(estado.matriz[i][j]==1){
                        estado.matriz[i][j]=2;
                    }
                }
            }
            
            for(int i=0; i<=indicePuntos; i++){
                for(int j=0; j<=indicePuntos; j++){
                    if(j!=i){
                        if(estado.matriz[i][j]==0){
                            estado.matriz[i][j]=1;
                            estado.indiceAristas++;
                            if(estado.matriz[j][i]==0){
                                estado.aristas[estado.indiceAristas]=new Arista(estado.puntos[i], 
                                estado.puntos[j], false,estado.indiceAristas);
                                estado.matriz[j][i]=1;
                            } else {
                                estado.aristas[estado.indiceAristas]=new Arista(estado.puntos[i], 
                                estado.puntos[j], true,estado.indiceAristas);
                            }
                        }
                    }
                }
            }
            
            for(int i=0; i<=indicePuntos; i++){
                for(int j=0; j<=indicePuntos; j++){
                    if(estado.matriz[i][j]==2){
                        estado.matriz[i][j]=0;
                    }
                }
            }
            estado.cargarDatos(areaDibujo);
            areaDibujo.lienzo.setPuntos(areaDibujo.puntos, areaDibujo.indicePuntos);
            areaDibujo.lienzo.setAristas(areaDibujo.aristas, areaDibujo.indiceAristas);
            areaDibujo.lienzo.repaint();
            if(areaDibujo.grafo.getMatriz()[0][1]!=-1){
                if(areaDibujo.matrizMostrada.esConexo()==true){
                    Interfaz.conexo.setText("Conexo : Si");
                } else {
                    Interfaz.conexo.setText("Conexo : No");
                }
            } else {
                Interfaz.conexo.setText("Conexo : No");
            }     
        }
           areaDibujo.matrizMostrada.actualizarMatriz();
            Interfaz.progresoAcciones.setValue(150);
            Rectangle rc=Interfaz.progresoAcciones.getBounds();
            rc.x=0;
            rc.y=0;
            Interfaz.progresoAcciones.paintImmediately(rc);
            try {
                Thread.sleep(120);
            } catch (InterruptedException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
            Interfaz.progresoAcciones.setValue(0); 
          
             Timer t = new Timer();

        TimerTask timerTask = new TimerTask() {

            public void run() {
              if(AreaDibujo.indiceAristas==-1)
              {
               Interfaz.aristaDirNueva.setEnabled(true);  
              }
            }
        };

        t.schedule(timerTask, 100);
            
            
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Estado estadoAux=new Estado();
        estadoAux.guardarDatos(areaDibujo);
        areaDibujo.pilaRehacer.vaciar();
        areaDibujo.pilaDeshacer.push( estadoAux);
        areaDibujo.repetitivo=false;       
        complementar();
    }
    
}

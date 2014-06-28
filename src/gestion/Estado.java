
package gestion;

import dibujo.AreaDibujo;
import dibujo.Arista;
import dibujo.Punto;
import java.awt.Color;


public class Estado {
    public Punto[] puntos;
    public Arista[] aristas;
    public int indicePuntos;
    public int indiceAristas;
    public int matriz[][];
    final int MAX_ARISTAS=90;
    final int MAX_PUNTOS=10;
    
    
    public Estado(){
        puntos = new Punto[MAX_PUNTOS];
        aristas = new Arista[MAX_ARISTAS];
        indicePuntos=-1;
        indicePuntos=-1;
        matriz=new int[10][10];
    }
    
    public void guardarDatos(AreaDibujo a){
        indicePuntos=a.indicePuntos;
        indiceAristas=a.indiceAristas;
        for(int i=0; i<=indicePuntos; i++){
            puntos[i]=new Punto((int) a.puntos[i].getPosicion().getX(),
                            (int) a.puntos[i].getPosicion().getY(), i);
            puntos[i].setEtiqueta(a.puntos[i].getEtiqueta());
            puntos[i].setColores(a.puntos[i].colorPunto);
            puntos[i].setForma(a.puntos[i].forma);
            puntos[i].setTamaño(a.puntos[i].circle);
        
        }
        
        for(int i=0; i<=indiceAristas; i++){
            aristas[i]=new Arista(puntos[a.aristas[i].getOrigen()], 
                                     puntos[a.aristas[i].getDestino()], 
                                            a.aristas[i].esDirigida(),i);
            //***********Modo Prueba*************
            aristas[i].setColores(a.aristas[i].colorArista);
            aristas[i].setPeso(a.aristas[i].peso);
            aristas[i].setTamaño(a.aristas[i].tamaño);
        }
        
        matriz=a.grafo.clonarMatriz();
    }
    
    public void cargarDatos(AreaDibujo a){
        a.limpiarArea();
        a.indicePuntos=this.indicePuntos;
        a.indiceAristas=this.indiceAristas;
        for(int i=0; i<=indicePuntos; i++){
            a.puntos[i]=new Punto((int)puntos[i].getPosicion().getX(), 
                                            (int)puntos[i].getPosicion().getY(),
                                                        puntos[i].getIndice());
             a.puntos[i].setEtiqueta(puntos[i].getEtiqueta());
             a.puntos[i].setColores(puntos[i].colorPunto);
             a.puntos[i].setForma(puntos[i].forma);
             a.puntos[i].setTamaño(puntos[i].circle);
        }
        for(int i=0; i<=indiceAristas; i++){
            a.aristas[i]=new Arista(a.puntos[aristas[i].getOrigen()], 
                                            a.puntos[aristas[i].getDestino()], 
                                                       aristas[i].esDirigida(),i);
            //***********Modo Prueba*************
            a.aristas[i].setColores(aristas[i].colorArista);
            a.aristas[i].setPeso(aristas[i].peso);
            a.aristas[i].setTamaño(aristas[i].tamaño);
        }
        a.grafo.setMatriz(matriz, indicePuntos);
    }
    
}
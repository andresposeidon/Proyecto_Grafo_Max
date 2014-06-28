/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import dibujo.AreaDibujo;
import interfaz.Interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author voragoth
 */
public class Deshacer implements ActionListener {

    private AreaDibujo areaDibujo;
    
    public Deshacer(AreaDibujo areaDibujo){
        
        this.areaDibujo=areaDibujo;
        Interfaz.deshacer.addActionListener(this);
        Interfaz.menuDeshacer.addActionListener(this);
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(areaDibujo.pilaDeshacer.estaVacio()==false){
            Estado estado;
            Estado estadoAux;
            estadoAux=new Estado();
            estadoAux.guardarDatos(areaDibujo);
            estado=areaDibujo.pilaDeshacer.pop();
            areaDibujo.pilaRehacer.push(estadoAux);
           if(Interfaz.rehacer.isEnabled()==false){
                Interfaz.rehacer.setEnabled(true);
                Interfaz.menuRehacer.setEnabled(true);
            }
            estado.cargarDatos(areaDibujo);
            areaDibujo.lienzo.setPuntos(areaDibujo.puntos, areaDibujo.indicePuntos);
            areaDibujo.lienzo.setAristas(areaDibujo.aristas, areaDibujo.indiceAristas);
            areaDibujo.lienzo.repaint();
            AreaDibujo.matrizMostrada.actualizar();
            AreaDibujo.desactivar();
            if(areaDibujo.pilaDeshacer.estaVacio()){
                Interfaz.deshacer.setEnabled(false);
                Interfaz.menuDeshacer.setEnabled(false);
            }
            
        }
        else{
            Interfaz.deshacer.setEnabled(false);
                Interfaz.menuDeshacer.setEnabled(false);
            
        }
    }
}

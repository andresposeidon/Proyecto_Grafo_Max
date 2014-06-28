
package gestion;

import dibujo.AreaDibujo;
import interfaz.Interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Rehacer implements ActionListener{

    AreaDibujo areaDibujo;
    
    public Rehacer(AreaDibujo areaDibujo){
        this.areaDibujo=areaDibujo;
        Interfaz.rehacer.addActionListener(this);
        Interfaz.menuRehacer.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(areaDibujo.pilaRehacer.estaVacio()==false){
            Estado estado;
            Estado estadoAux;
            estadoAux=new Estado();
            estadoAux.guardarDatos(areaDibujo);
            estado=areaDibujo.pilaRehacer.pop();
            areaDibujo.pilaDeshacer.push(estadoAux);
            if(Interfaz.deshacer.isEnabled()==false){
                Interfaz.deshacer.setEnabled(true);
                Interfaz.menuDeshacer.setEnabled(true);
            }
            estado.cargarDatos(areaDibujo);
            areaDibujo.lienzo.setPuntos(areaDibujo.puntos, areaDibujo.indicePuntos);
            areaDibujo.lienzo.setAristas(areaDibujo.aristas, areaDibujo.indiceAristas);
            areaDibujo.lienzo.repaint();
            AreaDibujo.matrizMostrada.actualizar();
             AreaDibujo.desactivar();
             if(areaDibujo.pilaRehacer.estaVacio()){
                Interfaz.rehacer.setEnabled(false);
                Interfaz.menuRehacer.setEnabled(false);
            }
        }
        else{
            Interfaz.rehacer.setEnabled(false);
                Interfaz.menuRehacer.setEnabled(false);
        }
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otros;

import dibujo.AreaDibujo;
import interfaz.Interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

/**
 *
 * @author voragoth
 */
public class ImprimirGrafo implements ActionListener{
    
    AreaDibujo areaDibujo;
    
    
    public ImprimirGrafo(AreaDibujo areaDibujo){
        this.areaDibujo=areaDibujo;
        Interfaz.imprimir.addActionListener(this);
        Interfaz.Imprimir.addActionListener(this);
    }
    
    private void imprimir(){
        Interfaz.job.setPrintable(areaDibujo.lienzo);
        if(Interfaz.job.printDialog()){
            try{
                Interfaz.job.print();
            }catch(PrinterException e){
                
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        imprimir();
    }
    
}

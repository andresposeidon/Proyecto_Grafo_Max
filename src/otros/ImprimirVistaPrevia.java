/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package otros;

import dibujo.AreaDibujo;
import interfaz.Interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;

/**
 *
 * @author voragoth
 */
public class ImprimirVistaPrevia implements ActionListener{
    AreaDibujo areaDibujo;
    
    
    public ImprimirVistaPrevia(AreaDibujo areaDibujo){
        this.areaDibujo=areaDibujo;
        Interfaz.configurarPagina.addActionListener(this);
    }
    
    private void imprimir(){
        Interfaz.job.setPrintable(areaDibujo.lienzo);
        PageFormat format=new PageFormat();
        Interfaz.job.pageDialog(format);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        imprimir();
    }
    
}

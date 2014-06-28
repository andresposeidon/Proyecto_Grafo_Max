/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import dibujo.AreaDibujo;
import interfaz.Interfaz;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author voragoth
 */
public class NuevoDocumento implements ActionListener{
    AreaDibujo areaDibujo;
    
    public NuevoDocumento(AreaDibujo areaDibujo){
        this.areaDibujo=areaDibujo;
        Interfaz.nuevoDocumento.addActionListener(this);
        Interfaz.menuNuevo.addActionListener(this);
    }

    private void cerrarFrame(){
        if(JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO DE CERRAR EL ARCHIVO?\n"
            + "CUALQUIER DATO NO GUARDADO SE PERDERA")==JOptionPane.YES_OPTION){
            
            Interfaz.abierto=false;
            areaDibujo.limpiarArea();
            areaDibujo.grafo.destruirGrafo();
            areaDibujo.matrizMostrada.actualizarMatriz();
            if(areaDibujo.grafo.getMatriz()[0][1]!=-1){
                if(areaDibujo.matrizMostrada.esConexo()==true){
                    Interfaz.conexo.setText("Conexo : Si");
                } else {
                    Interfaz.conexo.setText("Conexo : No");
                }
            } else {
                Interfaz.conexo.setText("Conexo : No");
            }
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
            areaDibujo.pilaDeshacer.vaciar();
            areaDibujo.pilaRehacer.vaciar();
            Interfaz.colorearGrafos.setEnabled(false);
            Interfaz.nodoNuevo.setEnabled(true);
            Interfaz.borrarArista.setEnabled(false);
            Interfaz.BarElimiArista.setEnabled(false);
            Interfaz.borrarNodo.setEnabled(false);
            Interfaz.cambiarEtiqueta.setEnabled(false);
            Interfaz.guardarArchivo.setEnabled(true);
            Interfaz.menuGuardarComo.setEnabled(true);
            Interfaz.menuGuardar.setEnabled(true);
            Interfaz.deshacer.setEnabled(false);
            Interfaz.menuDeshacer.setEnabled(false);
            Interfaz.CicloEulerians.setEnabled(false);
            Interfaz.boteule.setEnabled(false);
            Interfaz.barEule.setEnabled(false);
            AreaDibujo.Euleriano.setEnabled(false);
            Interfaz.CicloHamilt.setEnabled(false);
            Interfaz.barhamil.setEnabled(false);
            AreaDibujo.Hamiltoniano.setEnabled(false);
            Interfaz.bothami.setEnabled(false);
            Interfaz.Bipartito.setEnabled(false);
            Interfaz.botbipartito.setEnabled(false);
            Interfaz.BarBipartito.setEnabled(false);
            AreaDibujo.Bipartito.setEnabled(false);
            Interfaz.Kruskal.setEnabled(false);
            Interfaz.BotKruska.setEnabled(false);
            Interfaz.jMenuItem2.setEnabled(false);
            Interfaz.BuscarBipartito.setText("Bipartito : No");
            Interfaz.hamilt.setText("Hamiltoniano : No");
            Interfaz.aristaDirNueva.setEnabled(true);
            Interfaz.aristaNueva.setEnabled(true);
            Interfaz.BarAgregaArista.setEnabled(true);
            Interfaz.BaragreArisDir.setEnabled(true);
            Interfaz.VisorComplet.setEnabled(false); 
            Interfaz.copiar.setEnabled(false);
            Interfaz.MenuCopiar.setEnabled(false);
            Interfaz.cortar.setEnabled(false);
            Interfaz.MenuCortar.setEnabled(false);
            Interfaz.pegar.setEnabled(false);
            Interfaz.MenuPegar.setEnabled(false);
            Interfaz.BotDijkstra.setEnabled(false);
            Interfaz.jButton2.setEnabled(false);
            Interfaz.vermatriz1.setEnabled(true);
            Interfaz.Cuadricular.setEnabled(true);
            Interfaz.Screen.setEnabled(true);
            Interfaz.guardarimagen.setEnabled(true);
            Interfaz.botdiametro.setEnabled(true);
            Interfaz.cuadri.setEnabled(true);
            Interfaz.AreaPunteada.setEnabled(true);
            Interfaz.MostarMatriz.setEnabled(true);
            Interfaz.menuActualizar.setEnabled(true);
            Interfaz.modificar.setSelected(true);
            Interfaz.InfoPuntos.setEnabled(true);
            Interfaz.ocultapesoaris.setEnabled(true);
            Interfaz.EliminDatos.setEnabled(false);
            Interfaz.BarAgregavertice.setEnabled(false);
            Interfaz.BarEliminavertice.setEnabled(false);
            Interfaz.botdiametro.setEnabled(false);
            Interfaz.bardiam.setEnabled(false);
            Interfaz.conexo87.setEnabled(false);
            Interfaz.conex.setEnabled(false);
            areaDibujo.Conexo.setEnabled(false);
            Interfaz.arbol.setEnabled(false);
                            Interfaz.barArbin.setEnabled(false);
                            Interfaz.botcamin.setEnabled(false);
                            Interfaz.barcamci.setEnabled(false);
            AreaDibujo.desactivar();
            for(int j=0; j<10; j++){
             Interfaz.tablagrados.setValueAt("", 0, j);
             Interfaz.tablagrados.setValueAt("", 1, j);
        }
        
        } else {
            Interfaz.frameDibujo.setVisible(true);
        }
        Interfaz.file=null;
        Interfaz.archivo=false;
        
    }
    
    private void nuevo(){

       
        if(Interfaz.abierto==false){
            Interfaz.nodoNuevo.setEnabled(true);
            Interfaz.colorearGrafos.setEnabled(false);
            Interfaz.aristaNueva.setEnabled(true);
            Interfaz.aristaDirNueva.setEnabled(true);
            Interfaz.BarAgregaArista.setEnabled(true);
            Interfaz.BaragreArisDir.setEnabled(true);
            Interfaz.configurarPagina.setEnabled(true);
            Interfaz.imprimir.setEnabled(true);
            Interfaz.Imprimir.setEnabled(true);
            Interfaz.borrarNodo.setEnabled(false);
            Interfaz.cambiarEtiqueta.setEnabled(false);
            Interfaz.guardarArchivo.setEnabled(true);
            Interfaz.menuGuardarComo.setEnabled(true);
            Interfaz.menuGuardar.setEnabled(true);
            Interfaz.Screen.setEnabled(true);
            Interfaz.guardarimagen.setEnabled(true);
            Interfaz.copiar.setEnabled(false);
            Interfaz.MenuCopiar.setEnabled(false);
            Interfaz.cortar.setEnabled(false);
            Interfaz.MenuCortar.setEnabled(false);
            Interfaz.pegar.setEnabled(false);
            Interfaz.MenuPegar.setEnabled(false);
            Interfaz.BotDijkstra.setEnabled(false);
            Interfaz.jButton2.setEnabled(false);
            Interfaz.vermatriz1.setEnabled(true);
            Interfaz.Cuadricular.setEnabled(true);
            Interfaz.botdiametro.setEnabled(true);
            Interfaz.frameDibujo.setVisible(true);
            Interfaz.cuadri.setEnabled(true);
            Interfaz.AreaPunteada.setEnabled(true);
            Interfaz.MostarMatriz.setEnabled(true);
            Interfaz.modificar.setSelected(true);
            Interfaz.menuActualizar.setEnabled(true);
            Interfaz.InfoPuntos.setEnabled(true);
            Interfaz.ocultapesoaris.setEnabled(true);
            Interfaz.EliminDatos.setEnabled(false);
            Interfaz.BarAgregavertice.setEnabled(false);
            Interfaz.BarEliminavertice.setEnabled(false);
            Interfaz.botdiametro.setEnabled(false);
            Interfaz.bardiam.setEnabled(false);
            Interfaz.conexo87.setEnabled(false);
            Interfaz.conex.setEnabled(false);
            areaDibujo.Conexo.setEnabled(false);
            Interfaz.arbol.setEnabled(false);
                            Interfaz.barArbin.setEnabled(false);
                            Interfaz.botcamin.setEnabled(false);
                            Interfaz.barcamci.setEnabled(false);
            AreaDibujo.desactivar();
            for(int j=0; j<10; j++){
             Interfaz.tablagrados.setValueAt("", 0, j);
             Interfaz.tablagrados.setValueAt("", 1, j);
        }
            try {
                    Interfaz.frameDibujo.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            Interfaz.frameDibujo.setTitle("Archivo_Sin_Nombre.cgx");
            Interfaz.abierto=true;
        } else {
            cerrarFrame();
            
            Interfaz.configurarPagina.setEnabled(true);
            Interfaz.imprimir.setEnabled(true);
            Interfaz.Imprimir.setEnabled(true);
            
            Interfaz.guardarArchivo.setEnabled(true);
            Interfaz.frameDibujo.setVisible(true);
            try {
                    Interfaz.frameDibujo.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            Interfaz.frameDibujo.setTitle("Archivo_Sin_Nombre.cgx");
            //areaDibujo.cargarArchivo(null);
            Interfaz.abierto=true;
            
        }
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        nuevo();
        Interfaz.file=null;
        Interfaz.archivo=false;
    }
    
}

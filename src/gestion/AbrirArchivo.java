/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import dibujo.AreaDibujo;
import dibujo.Arista;
import dibujo.Punto;
import interfaz.Interfaz;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author voragoth
 */
public class AbrirArchivo implements ActionListener{
    
    private AreaDibujo areaDibujo;
    private File file;
    private FileReader myReader;
    private BufferedReader lector;
    private FileNameExtensionFilter filtro;
    private Estado estado;
    private JFileChooser fileChooser;
            
    public AbrirArchivo(AreaDibujo areaDibujo){
        this.areaDibujo=areaDibujo;
        Interfaz.abrirDocumento.addActionListener(this);
        Interfaz.menuAbrir.addActionListener(this);
        fileChooser=new JFileChooser();
        filtro=new FileNameExtensionFilter("Archivo cgx","cgx","CGX");
        fileChooser.setFileFilter(filtro);
        estado=new Estado();
        file=null;
    }
    
    private String obtener(){
        String ruta=new String();
        try{
            if(fileChooser.showOpenDialog(null) ==JFileChooser.APPROVE_OPTION){
                ruta=fileChooser.getSelectedFile().getAbsolutePath();
            } else{
                return null;
            }
        }
        catch(Exception e){
            
        }
        return ruta;
    }
    
    private void abrir() throws FileNotFoundException, IOException, PropertyVetoException{
        while(true){
            try{
                
                String ruta;
                ruta=obtener();
                if(ruta==null){
                    return;
                }
                
                Interfaz.nodoNuevo.setEnabled(true);
                Interfaz.aristaNueva.setEnabled(true);
                Interfaz.aristaDirNueva.setEnabled(true);
                Interfaz.BarAgregaArista.setEnabled(true);
                Interfaz.BaragreArisDir.setEnabled(true);
                Interfaz.configurarPagina.setEnabled(true);
                Interfaz.imprimir.setEnabled(true);
                Interfaz.Imprimir.setEnabled(true);
                Interfaz.copiar.setEnabled(false);
                Interfaz.MenuCopiar.setEnabled(false);
                Interfaz.cortar.setEnabled(false);
                Interfaz.MenuCortar.setEnabled(false);
                Interfaz.pegar.setEnabled(false);
                Interfaz.MenuPegar.setEnabled(false);
                Interfaz.Cuadricular.setEnabled(true);
                Interfaz.BotDijkstra.setEnabled(false);
                Interfaz.jButton2.setEnabled(false);
                Interfaz.vermatriz1.setEnabled(true);
                Interfaz.Screen.setEnabled(true);
                Interfaz.botdiametro.setEnabled(true);
                Interfaz.guardarimagen.setEnabled(true);
                Interfaz.cuadri.setEnabled(true);
                Interfaz.AreaPunteada.setEnabled(true);
                Interfaz.MostarMatriz.setEnabled(true);
                Interfaz.modificar.setSelected(true);
                Interfaz.menuActualizar.setEnabled(true);
                Interfaz.InfoPuntos.setEnabled(true);
                Interfaz.ocultapesoaris.setEnabled(true);
                Interfaz.EliminDatos.setEnabled(false);
                Interfaz.botdiametro.setEnabled(false);
                Interfaz.bardiam.setEnabled(false);
                Interfaz.vermatriz1.setSelected(false);
                Interfaz.MostarMatriz.setSelected(false);
                
                            
                            
                file=new File(ruta);
                myReader=new FileReader(file);
                lector=new BufferedReader(myReader);
                estado.indicePuntos=Integer.parseInt(lector.readLine());
                estado.indiceAristas=Integer.parseInt(lector.readLine());
                for(int i=0; i<=estado.indicePuntos; i++){
                    int x, y;
                    if(i==Integer.parseInt(lector.readLine())){
                        x=Integer.parseInt(lector.readLine());
                        y=Integer.parseInt(lector.readLine());
                        estado.puntos[i]=new Punto(x,y,i);
                        estado.puntos[i].colorPunto=new Color(Integer.parseInt(lector.readLine()),Integer.parseInt(lector.readLine()),Integer.parseInt(lector.readLine()));
                        estado.puntos[i].forma=lector.readLine();
                        estado.puntos[i].circle=Integer.parseInt(lector.readLine());
                        if(Boolean.parseBoolean(lector.readLine())==true){
                            String etiqueta=new String();
                            etiqueta=lector.readLine();
                            estado.puntos[i].setEtiqueta(etiqueta);
                        }
                    }
                }
                for(int i=0; i<=estado.indiceAristas; i++){
                    int origen, destino;
                    boolean dir;
                    if(i==Integer.parseInt(lector.readLine())){
                        origen=Integer.parseInt(lector.readLine());
                        destino=Integer.parseInt(lector.readLine());
                        dir=Boolean.parseBoolean(lector.readLine());
                        estado.aristas[i]=new Arista(estado.puntos[origen], 
                                                   estado.puntos[destino], dir,i);
                        estado.aristas[i].colorArista=new Color(Integer.parseInt(lector.readLine()),Integer.parseInt(lector.readLine()),Integer.parseInt(lector.readLine()));
                        estado.aristas[i].setPeso(Integer.parseInt(lector.readLine()));
                        estado.aristas[i].setTamaño(Integer.parseInt(lector.readLine()));
                    }
                    
                }
                for(int i=0; i<10; i++){
                    for(int j=0; j<10; j++){
                        estado.matriz[i][j]=Integer.parseInt(lector.readLine());
                    }
                }
                estado.cargarDatos(areaDibujo);
                areaDibujo.lienzo.setPuntos(areaDibujo.puntos, areaDibujo.indicePuntos);
                areaDibujo.lienzo.setAristas(areaDibujo.aristas, areaDibujo.indiceAristas);
                areaDibujo.lienzo.repaint();
                areaDibujo.matrizMostrada.actualizarMatriz();
                if(AreaDibujo.aristas[0].esDirigida()){
                            Interfaz.botprim.setEnabled(false);
                            Interfaz.barPrim.setEnabled(false);
                            Interfaz.AlPrim.setEnabled(false);
                            
                        }
                if(areaDibujo.grafo.getMatriz()[0][1]!=-1){
                    if(areaDibujo.matrizMostrada.esConexo()==true){
                        Interfaz.conexo.setText("Conexo : Si");
                        Interfaz.conexo87.setEnabled(true);
                            Interfaz.conex.setEnabled(true);
                            areaDibujo.Conexo.setEnabled(true);
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
                        areaDibujo.Conexo.setEnabled(false);
                    }
                } else {
                    Interfaz.conexo.setText("Conexo : No");
                    Interfaz.botprim.setEnabled(false);
                    Interfaz.barPrim.setEnabled(false);
                    Interfaz.AlPrim.setEnabled(false);
                    Interfaz.conexo87.setEnabled(false);
                    Interfaz.conex.setEnabled(false);
                    areaDibujo.Conexo.setEnabled(false);
                }
                AreaDibujo.matrizMostrada.actionPerformed(null);
                Interfaz.progresoAcciones.setValue(150);
                Rectangle rc=Interfaz.progresoAcciones.getBounds();
                rc.x=0;
                rc.y=0;
                Interfaz.progresoAcciones.paintImmediately(rc);
                Interfaz.progresoAcciones.setValue(0);
                areaDibujo.pilaDeshacer.vaciar();
                areaDibujo.pilaRehacer.vaciar();
                //areaDibujo.lienzo.setPuntos(estado.puntos, estado.indicePuntos);
                //areaDibujo.lienzo.setAristas(estado.aristas, estado.indiceAristas);
                Interfaz.frameDibujo.setVisible(true);
                Interfaz.frameDibujo.setTitle(file.getName());
                Interfaz.frameDibujo.setMaximum(true);
                areaDibujo.lienzo.repaint();
                AreaDibujo.desactivar();
                lector.close();
                myReader.close();
                Interfaz.mensajeAcciones.setForeground(Color.green);
                Interfaz.mensajeAcciones.setText("ARCHIVO GUARDADO");
                Interfaz.abierto=true;
                if(file!=null){
                    Interfaz.archivo=true;
                    Interfaz.file=file;
                    if(Interfaz.guardarArchivo.isEnabled()==false){
                        Interfaz.guardarArchivo.setEnabled(true);
                        Interfaz.menuGuardarComo.setEnabled(true);
                        Interfaz.menuGuardar.setEnabled(true);
                }
        }
                break;
                
        } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR");
            } finally {
                try{
                    lector.close();
                    myReader.close();
                break;
                }
                catch(NullPointerException n){
                    
                }
            }
        }
    }
    private void cerrarFrame(){
            Interfaz.abierto=false;
            Interfaz.file=null;
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
            
            areaDibujo.desactivar();
            Interfaz.progresoAcciones.setValue(0);
            areaDibujo.pilaDeshacer.vaciar();
            areaDibujo.pilaRehacer.vaciar();
            Interfaz.guardarArchivo.setEnabled(false);
            Interfaz.guardarimagen.setEnabled(false);
            Interfaz.borrarArista.setEnabled(false);
            Interfaz.BarElimiArista.setEnabled(false);
            Interfaz.nodoNuevo.setEnabled(false);
            Interfaz.aristaNueva.setEnabled(false);
            Interfaz.aristaDirNueva.setEnabled(false);
            Interfaz.BaragreArisDir.setEnabled(false);
            Interfaz.BarAgregaArista.setEnabled(false);
            Interfaz.cambiarEtiqueta.setEnabled(false);
            Interfaz.configurarPagina.setEnabled(false);
            Interfaz.imprimir.setEnabled(false);
            Interfaz.Imprimir.setEnabled(false);
            Interfaz.ordenar.setEnabled(false);
            Interfaz.tabla.setVisible(false);
            Interfaz.jScrollPane1.setBounds(0, 0, 905, 625);
            Interfaz.boteule.setEnabled(false);
            Interfaz.barEule.setEnabled(false);
            Interfaz.barhamil.setEnabled(false);
            Interfaz.bothami.setEnabled(false);
            Interfaz.botbipartito.setEnabled(false);
            Interfaz.BarBipartito.setEnabled(false);
            Interfaz.Bipartito.setEnabled(false);
            Interfaz.jMenuItem2.setEnabled(false);
            Interfaz.BotKruska.setEnabled(false);
            Interfaz.VisorComplet.setEnabled(false);
            Interfaz.colorearGrafos.setEnabled(false);
            Interfaz.deshacer.setEnabled(false);
            Interfaz.rehacer.setEnabled(false);
            Interfaz.menuDeshacer.setEnabled(false);
            Interfaz.menuRehacer.setEnabled(false);
            Interfaz.Screen.setEnabled(false);
            Interfaz.MenuCortar.setEnabled(false);
            Interfaz.MenuCopiar.setEnabled(false);
            Interfaz.MenuPegar.setEnabled(false);
            Interfaz.cortar.setEnabled(false);
            Interfaz.copiar.setEnabled(false);
            Interfaz.pegar.setEnabled(false);
            Interfaz.progresoAcciones.setStringPainted(true);
            Interfaz.BotDijkstra.setEnabled(false);
            Interfaz.jButton2.setEnabled(false);
            Interfaz.vermatriz1.setEnabled(false);
            Interfaz.Cuadricular.setEnabled(false);
            Interfaz.botprim.setEnabled(false);
            Interfaz.botdiametro.setEnabled(false);
            Interfaz.editNodo1.setEnabled(false);
            Interfaz.editarista1.setEnabled(false);
            Interfaz.menuGuardarComo.setEnabled(false);
            Interfaz.menuGuardar.setEnabled(false);
            Interfaz.BarAgregavertice.setEnabled(false);
            Interfaz.BarEliminavertice.setEnabled(false);
            Interfaz.cuadri.setEnabled(false);
            Interfaz.AreaPunteada.setEnabled(false);
            Interfaz.MostarMatriz.setEnabled(false);
            Interfaz.barColorear.setEnabled(false);
            Interfaz.jMenuItem1.setEnabled(false);
            Interfaz.virgraf.setEnabled(false);
            Interfaz.menuOrdenar.setEnabled(false);
            Interfaz.menuActualizar.setEnabled(false);
            Interfaz.InfoPuntos.setEnabled(false);
            Interfaz.ocultapesoaris.setEnabled(false);
            Interfaz.CicloEulerians.setEnabled(false);
            Interfaz.CicloHamilt.setEnabled(false);
            Interfaz.Bipartito.setEnabled(false);
            Interfaz.Kruskal.setEnabled(false);
            Interfaz.barPrim.setEnabled(false);
            Interfaz.AlPrim.setEnabled(false);
            Interfaz.EliminDatos.setEnabled(false);
            Interfaz.BuscarBipartito.setText("Bipartito : No");
            Interfaz.hamilt.setText("Hamiltoniano : No");  
            Interfaz.VisorComplet.setEnabled(false);
            Interfaz.botdiametro.setEnabled(false);
            Interfaz.bardiam.setEnabled(false);
            Interfaz.conexo87.setEnabled(false);
            Interfaz.conex.setEnabled(false);
            areaDibujo.Conexo.setEnabled(false);
            Interfaz.vermatriz1.setSelected(false);
            Interfaz.MostarMatriz.setSelected(false);
            Interfaz.bardiam.setEnabled(false);
            Interfaz.arbol.setEnabled(false);
            Interfaz.botcamin.setEnabled(false);
            Interfaz.barArbin.setEnabled(false);
            Interfaz.barcamci.setEnabled(false);
            
            //AreaDibujo.desactivar();
            for(int j=0; j<10; j++){
             Interfaz.tablagrados.setValueAt("", 0, j);
             Interfaz.tablagrados.setValueAt("", 1, j);
            }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(Interfaz.abierto==true){
                if(JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO DE CERRAR EL ARCHIVO?\n" + "CUALQUIER DATO NO GUARDADO SE PERDERA")==JOptionPane.YES_OPTION){
                    Interfaz.frameDibujo.setVisible(false);
                    cerrarFrame();
                    abrir();
                }
                
            }
            else{
                abrir();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AbrirArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AbrirArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AbrirArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
}

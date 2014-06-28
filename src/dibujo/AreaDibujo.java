
package dibujo;

import AutoDibujar.Bipartito;
import AutoDibujar.CicloEuleriano;
import AutoDibujar.CicloHalmitoneano;
import base.Grafo;
import base.Matriz;
import gestion.AbrirArchivo;
import gestion.Deshacer;
import gestion.Estado;
import gestion.GuardarArchivo;
import gestion.GuardarComo;
import gestion.NuevoDocumento;
import gestion.PilaAcciones;
import gestion.Rehacer;
import interfaz.Interfaz;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyVetoException;
import java.io.File;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import otros.ComplementarGrafo;
import otros.CompletarGrafo;
import otros.ImprimirGrafo;
import otros.ImprimirVistaPrevia;

public class AreaDibujo extends Container implements MouseListener, MouseMotionListener, ActionListener {
    
    public static Punto[] puntos;
    public static Punto[] puntocopy;
    public static Punto[] puntocopy2;
    public static Arista[] aristas;
    public static Arista[] aristascopy;
    public static Arista[] aristascopy2;
    public static int totalpuntocopy2;
    public static int totalaristascopy2;
    public static String gradoEntrada="0";
    public static String gradoSalida="0";
    public int [] vectorColorear ;
    public Color vectorseleccolor[];
    public static int contadorselec=0;
    public static int contadorarista=0;
    public int vectorselec[];
    public int vectorarista[];
    public int tempv[];
    public Grafo grafo;
    final int MAX_PUNTOS = 10;
    final int MAX_ARISTAS = 90;
    public static int a=-1;
    public static int indiceAristas;
    public static int indicePuntos;
    public static Lienzo lienzo;
    public static Lienzo lienzocopy;
    private Punto puntoAux[];
    private int x, y;
    private int contador;
    private Punto movible;
    private boolean flag;
    public static int corX_presionado,corY_presionado;
    public static int corX,corY;
    public static int X,Y;
    public static int estaContenido;
    public static int estaarista;
    public static int aux;;
    public  static Matriz matrizMostrada;
    public PilaAcciones pilaDeshacer;
    public PilaAcciones pilaRehacer;
    private Deshacer deshacer;
    private Rehacer rehacer;
    public boolean moverpuntos;
    public boolean repetitivo=false;
    private GuardarArchivo guardar;
    private AbrirArchivo abrir;
    private NuevoDocumento nuevo;
    private GuardarComo guardarC;
    private ImprimirGrafo imprimir;
    private ImprimirVistaPrevia vistaP;
    public static  CompletarGrafo completar;
    public static ComplementarGrafo complementar;
    public static int matrizAdyacencia[][];
    
    // Menu del Lienzo Contextual
    public static JPopupMenu MenuLienzo = new JPopupMenu();
    public static JMenuItem agregararista = new JMenuItem("Agregar Arista");
    public static JMenuItem eliminararista = new JMenuItem("Eliminar Arista");
    public static JMenuItem ColoresArista = new JMenuItem("Colorear la Arista");
    public static JMenuItem TamanyoArista = new JMenuItem("Cambiar Tamaño de la Arista");
    public static JMenuItem Peso = new JMenuItem("Cambiar Peso de la Arista");
    public static JMenuItem Cortar = new JMenuItem("Cortar");
    public static JMenuItem Copiar = new JMenuItem("Copiar");
    public static JMenuItem Pegar= new JMenuItem("Pegar");
    public static JMenuItem EliminarSelec= new JMenuItem("Elliminar");
    public static JMenuItem agregarnodo = new JMenuItem("Agregar Nodo");
    public static JMenuItem eliminarnodo = new JMenuItem("Eliminar Nodo");
    public static JMenuItem Colores = new JMenuItem("Colorear el Nodo");
    public static JMenuItem Tamanyo = new JMenuItem("Cambiar Tamaño del Nodo");
    public static JMenuItem Forma = new JMenuItem("Cambiar Forma del Nodo");
    public static JMenuItem Etiqueta= new JMenuItem("Cambiar Etiqueta del Nodo");
    public static JMenuItem Posicion= new JMenuItem("Cambiar Posición del Nodo");
    // Menu del Lienzo Contextual secundario
    public static JMenu MenuEdicion = new JMenu("Edición de Grafo");
    public static JMenuItem tabla = new JMenuItem("Tabla de Grados");
    public static JMenuItem completitud = new JMenuItem("Completitud");
    public static JMenuItem Bipartito= new JMenuItem("Bipartito");
    public static JMenuItem Conexo= new JMenuItem("Conexo");
    public static JMenuItem Euleriano= new JMenuItem("Ciclos Eulerianos");
    public static JMenuItem Hamiltoniano= new JMenuItem("Caminos Hamiltonianos");
    public static JMenuItem Alinerar= new JMenuItem("Alinerar Grafo");
    public static JMenuItem Completar= new JMenuItem("Completar o Complementar Grafo");
    
    //----------------------------------------------------------------------------
    public static Color FullColor;
    public static int valor=-1;
    public static int valorArista=-1;
    public static int AristaoPunto=-1;
    private int Px=0;
    private int Py=0;
    
    public AreaDibujo() {
        
        matrizAdyacencia=new int[MAX_PUNTOS][MAX_PUNTOS];
        puntos = new Punto[10];
        puntocopy = new Punto[10];
        puntocopy2 = new Punto[10];
        vectorselec=new int[10];
        vectorarista=new int[90];
        tempv=new int[10];
        vectorseleccolor=new Color[10];
        aristas = new Arista[90];
        aristascopy = new Arista[90];
        aristascopy2 = new Arista[90];
        grafo = new Grafo();
        indiceAristas = -1;
        indicePuntos = -1;
        pilaRehacer=new PilaAcciones();
        pilaDeshacer=new PilaAcciones();
        deshacer= new Deshacer(this);
        rehacer= new Rehacer(this);
        lienzo = new Lienzo();
        lienzocopy = new Lienzo();
        lienzo.setBounds(0, 0, 1366, 768);
        this.setLayout(null);
        this.add(lienzo);
        lienzo.setBackground(Color.WHITE);
        this.setBackground(Color.WHITE);
        lienzo.addMouseListener(this);
        lienzo.addMouseMotionListener(this);
   //----------------------*****Menu del Lienzo Contextual*****----------------------     
        eliminarnodo.setSize(15,15);
        agregarnodo.setSize(15,15); 
         Colores.setSize(15,15);
         Tamanyo.setSize(15,15);
         Forma.setSize(15,15);
         Etiqueta.setSize(15,15);
         Posicion.setSize(15,15);
         agregararista.setSize(15,15);
         eliminararista.setSize(15,15);
         ColoresArista.setSize(15,15);
         TamanyoArista.setSize(15, 15);
         Peso.setSize(15,15);
         Cortar.setSize(15,15);
         Copiar.setSize(15, 15);
         Pegar.setSize(15,15);
         EliminarSelec.setSize(15,15);
         MenuLienzo.setSize(20,10);
         MenuEdicion.setSize(20,10);
         MenuLienzo.getLocale();
         MenuLienzo.add(MenuEdicion);
         MenuLienzo.addSeparator();
         MenuLienzo.add(agregarnodo);
         MenuLienzo.add(eliminarnodo);
         MenuLienzo.add(Posicion);
         MenuLienzo.add(Etiqueta);
         MenuLienzo.add(Colores);
         MenuLienzo.add(Tamanyo);
         MenuLienzo.add(Forma);
         MenuLienzo.addSeparator();
         MenuLienzo.add(agregararista);
         MenuLienzo.add(eliminararista);
         MenuLienzo.add(ColoresArista);
         MenuLienzo.add(TamanyoArista);
         MenuLienzo.add(Peso);
         MenuLienzo.addSeparator();
         Cortar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
         MenuLienzo.add(Cortar);
         Copiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
         MenuLienzo.add(Copiar);
         Pegar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
         MenuLienzo.add(Pegar);
         EliminarSelec.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
         MenuLienzo.add(EliminarSelec);
         MenuLienzo.addMouseListener(this);
         EliminarSelec.setEnabled(false);
         Pegar.setEnabled(false);
         Bipartito.setEnabled(false);
         Euleriano.setEnabled(false);
         Hamiltoniano.setEnabled(false);
         agregarnodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/esfera16.png")));
         eliminarnodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/esfera216.png")));
         Posicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/posicion16.png")));
         Etiqueta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/texto16.png")));
         Colores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/colores-icono-5416-16.png")));
         Forma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cuadrado-16.png")));
         Tamanyo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cambiar-el-tamano16.png")));
         agregararista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/esfera316.png")));
         eliminararista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/esfera516.png")));
         TamanyoArista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cambiar-el-tamano16.png")));
         ColoresArista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/colores-icono-5416-16.png")));
         Peso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/balanza16.png")));
         Cortar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Cut-16.png")));
         Copiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Copy-16.png")));
         Pegar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Paste-16.png")));
         EliminarSelec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/papelera16.png")));
         //----------------------*****Menu del Lienzo Contextual secundario*****---------------------- 
         tabla.setSize(15,15);
         completitud.setSize(15,15);
         Bipartito.setSize(15,15);
         Conexo.setSize(15,15);
         Euleriano.setSize(15,15);
         Hamiltoniano.setSize(15,15);
         Alinerar.setSize(15,15);
         Completar.setSize(15,15);
         MenuEdicion.add(tabla);
         MenuEdicion.add(completitud);
         MenuEdicion.addSeparator();
         MenuEdicion.add(Bipartito);
         MenuEdicion.add(Euleriano);
         MenuEdicion.add(Hamiltoniano);
         MenuEdicion.add(Conexo);
         MenuEdicion.addSeparator();
         MenuEdicion.add(Alinerar);
         MenuEdicion.add(Completar);
         tabla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/matriz16.png")));
         Bipartito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Bipartito16.png")));
         Conexo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/caminos16.png")));
         Euleriano.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Eule16.png")));
         Hamiltoniano.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Hamilto16.png")));
         Alinerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ordenar16.png")));
         Completar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/reciclado-icono-7781-16.png")));
       //-------------------------------------------------------   
        Conexo.setEnabled(false);
        completitud.setEnabled(false);
         eliminarnodo.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            Eliminarnodo(X, Y);
            }
        });
         
         agregarnodo.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            agregarnodo(X, Y);
            }
        });
         
        Colores.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            AristaoPunto=0;   
            new PaletaDeColores().setVisible(true); 
            lienzo.repaint();
            }
        }); 
          
        Tamanyo.addActionListener( new ActionListener(){
            @Override
              public void actionPerformed(ActionEvent e) {
              AristaoPunto=0;   
              Tamaño star = new Tamaño(new javax.swing.JFrame(), true,Px,Py);
              lienzo.repaint();
            }
        }); 
          
        Forma.addActionListener( new ActionListener(){
            @Override
              public void actionPerformed(ActionEvent e) {
              AristaoPunto=0;   
              Forma Tansformar = new Forma(new javax.swing.JFrame(),true,Px,Py); 
              lienzo.repaint(); 
            }
        }); 
        
        Posicion.addActionListener( new ActionListener(){
            @Override
              public void actionPerformed(ActionEvent e) {
              AristaoPunto=0;   
              Posicion prox = new Posicion(new javax.swing.JFrame(),true,Px,Py); 
              lienzo.repaint();
            }
        }); 
        
        Interfaz.colorearGrafos.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 Coloreargrafo4();  
            }
        });
        
        Interfaz.barColorear.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 Coloreargrafo4();  
            }
        });
        
        Interfaz.cortar.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                copiar();    
                cortar();
            }
        }); 
        
        Interfaz.MenuCortar.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                copiar();
                cortar();
            }
        });
                
          Cortar.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                copiar();
                cortar();
            }
        });
          
          Interfaz.copiar.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            copiar();
            repintarcopia();
            contadorselec=0;
            }
        }); 
        
        Interfaz.MenuCopiar.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            copiar();
            repintarcopia();
            contadorselec=0;
            }
        });
                
          Copiar.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             copiar();
             repintarcopia();
             contadorselec=0;
            }
        });
          
          Interfaz.MenuPegar.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            pegar(10,10);
            }
        });
          
          Interfaz.pegar.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            pegar(10,10);
            }
        }); 
          
          Pegar.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             pegar(X,Y);
            }
        });
        
  //llama a la Funcion para cambiar etiqueta del nodo
         Etiqueta.addActionListener( new ActionListener(){
             @Override
              public void actionPerformed(ActionEvent e) {
             cambiaretiqueta();
                }
        }); 
         
           
            //-----------------------------------------------
         
         agregararista.addActionListener( new ActionListener(){
            
             @Override
              public void actionPerformed(ActionEvent e) {
                 Interfaz.aristaNueva.setSelected(true);
                 Interfaz.BarAgregaArista.setEnabled(true);
                 if(Interfaz.aristaNueva.isEnabled()){
                     
                    Interfaz.BaragreArisDir.setEnabled(false);
                    Interfaz.VisorComplet.setEnabled(true);    
                    Interfaz.aristaDirNueva.setEnabled(false);
                    Interfaz.colorearGrafos.setEnabled(true);
                }
                else{
                     Interfaz.BaragreArisDir.setEnabled(true);
                     Interfaz.aristaDirNueva.setSelected(true);
                     Interfaz.VisorComplet.setEnabled(false);
                     Interfaz.BarAgregaArista.setEnabled(false);
                    Interfaz.aristaNueva.setEnabled(false);
                    Interfaz.colorearGrafos.setEnabled(false);
                }
                 
            }
        }); 
         
         eliminararista.addActionListener( new ActionListener(){
            
             @Override
              public void actionPerformed(ActionEvent e) {
                 Eliminaarista(X, Y);
            }
        }); 
         
         Peso.addActionListener( new ActionListener(){
            
             @Override
              public void actionPerformed(ActionEvent e) {
                 AristaoPunto=1; 
                 Peso Extrax= new Peso(new javax.swing.JFrame(),true,Px,Py);
                 lienzo.repaint();
            }
        }); 
        ColoresArista.addActionListener( new ActionListener(){
            
            @Override
              public void actionPerformed(ActionEvent e) {
              AristaoPunto=1;   
            
            new PaletaDeColores().setVisible(true);      
            }
        }); 
          
         TamanyoArista.addActionListener( new ActionListener(){
             @Override
              public void actionPerformed(ActionEvent e) {
               TamañoArista stars = new TamañoArista(new javax.swing.JFrame(), true,Px,Py);
               }
        });
         
        //-------------------------------------------------------------//
         Completar.addActionListener( new ActionListener(){
             @Override
              public void actionPerformed(ActionEvent e) {
               Interfaz.completar();
               }
        });
         Hamiltoniano.addActionListener( new ActionListener(){
             @Override
              public void actionPerformed(ActionEvent e) {
               CicloHalmitoneano VamosDibuja= new CicloHalmitoneano(new javax.swing.JFrame(), true);
               }
        });
         Euleriano.addActionListener( new ActionListener(){
             @Override
              public void actionPerformed(ActionEvent e) {
               CicloEuleriano Indica= new CicloEuleriano(new javax.swing.JFrame(), true);
               }
        });
         Bipartito.addActionListener( new ActionListener(){
             @Override
              public void actionPerformed(ActionEvent e) {
               Bipartito bipartito = new Bipartito(new javax.swing.JFrame(), true);
               }
        });
         tabla.addActionListener( new ActionListener(){
             @Override
              public void actionPerformed(ActionEvent e) {
                 if(Interfaz.vermatriz1.isSelected()==false){
                        Interfaz.tabla.setVisible(true);
                        Interfaz.MostarMatriz.setSelected(true);
                        Interfaz.vermatriz1.setSelected(true);
                        Interfaz.jScrollPane1.setBounds(0, 0, 650, 625);
                 }
                 else{
                        Interfaz.tabla.setVisible(false);
                        Interfaz.MostarMatriz.setSelected(false);
                        Interfaz.vermatriz1.setSelected(false);
                        Interfaz.jScrollPane1.setBounds(0, 0, 905, 625);
                 }
            
               }
        });
         
         Interfaz.EliminDatos.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                aux=0;
                repintarselec();
                cortar();
                Pegar.setEnabled(false);
                Interfaz.pegar.setEnabled(false);
                Interfaz.MenuPegar.setEnabled(false);
                Interfaz.EliminDatos.setEnabled(false);
                EliminarSelec.setEnabled(false);
            }
        });
         
         EliminarSelec.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                aux=0;
                repintarselec();
                cortar();
                Pegar.setEnabled(false);
                Interfaz.pegar.setEnabled(false);
                Interfaz.MenuPegar.setEnabled(false);
                Interfaz.EliminDatos.setEnabled(false);
                EliminarSelec.setEnabled(false);
            }
        });
         
         Conexo.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
        if("Conexo : Si".equals(Interfaz.conexo.getText())&& aristas[0].esDirigida()==true){
            JOptionPane.showMessageDialog(null,"El Grafo es Fuertemente Conexo","",JOptionPane.INFORMATION_MESSAGE);  
        } 
        
        if("Conexo : Si".equals(Interfaz.conexo.getText())&& aristas[0].esDirigida()==false  && "Hamiltoniano : Si".equals(Interfaz.hamilt.getText())==false){
            JOptionPane.showMessageDialog(null,"El Grafo es Débilmente Conexo","",JOptionPane.INFORMATION_MESSAGE); 
            
        }
        if("Conexo : Si".equals(Interfaz.conexo.getText())&& aristas[0].esDirigida()==false  && "Hamiltoniano : Si".equals(Interfaz.hamilt.getText())==true){
            JOptionPane.showMessageDialog(null,"El Grafo es Fuertemente Conexo","",JOptionPane.INFORMATION_MESSAGE);  
        }
        
            }
        });
   //----------------------*****Menu*****----------------------        
        puntoAux = new Punto[2];
        contador = 0;
        flag = false;
        matrizMostrada=new Matriz(grafo.getMatriz(), grafo.getMatrizS());
        matrizMostrada.setVisible(true);
        Interfaz.ordenar.addActionListener(this);
        Interfaz.menuOrdenar.addActionListener(this);
        Alinerar.addActionListener(this);
        repetitivo=false;
        guardar = new GuardarArchivo(this);
        abrir = new AbrirArchivo(this);
        nuevo = new NuevoDocumento(this);
        guardarC=new GuardarComo(this);
        imprimir=new ImprimirGrafo(this);
        vistaP=new ImprimirVistaPrevia(this);
        completar=new CompletarGrafo(this);
        complementar=new ComplementarGrafo(this);
        
    }

    private void eliminarPunto(int indice){
        for(int i=0; i<=indiceAristas; i++){
            
            if(aristas[i].getDestino()==indice){
                eliminarArista(i);
                i--;
            } else{
                if(aristas[i].getOrigen()==indice){
                    eliminarArista(i);
                    i--;
                }
            }
        }
        
        for(int i=indice; i<indicePuntos; i++){
            puntos[i]=puntos[i+1];
            puntos[i].setIndice(i);
            
        }
        puntos[indicePuntos]=null;
        indicePuntos--;
    }

    private void eliminarArista(int indice){
        for(int i=indice; i<indiceAristas; i++){
            aristas[i]=aristas[i+1];
        }
        aristas[indiceAristas]=null;
        indiceAristas--;
    }

    public void limpiarArea(){
        for(int i=0; i<=indicePuntos; i++){
            puntos[i]=null;
        }
        for(int i=0; i<=indiceAristas; i++){
            aristas[i]=null;
        }
        indiceAristas=-1;
        indicePuntos=-1;
        lienzo.setPuntos(puntos, indicePuntos);
        lienzo.setAristas(aristas, indiceAristas);
        lienzo.repaint();
       
    }
   
    @Override
    public void mouseClicked(MouseEvent e) {
        if (Interfaz.nodoNuevo.isSelected() == true && indicePuntos >=MAX_PUNTOS-1 && e.isMetaDown() == false) {
             JOptionPane.showMessageDialog(null,"No se puede Crear más Nodos\n"+"Se ha alcanzado el Limite");
             Interfaz.modificar.setSelected(true);
        }
        
        if (Interfaz.nodoNuevo.isSelected() == true && indicePuntos < MAX_PUNTOS-1 && e.isMetaDown() == false) {
             agregarnodo(e.getX()-5, e.getY()-5);
        }
        
        if(Interfaz.borrarNodo.isSelected()==true && e.isMetaDown() == false ){
                Eliminarnodo(e.getX()-5, e.getY()-5);
        }
        if(Interfaz.borrarArista.isSelected()==true && e.isMetaDown() == false){
            Eliminaarista(e.getX()-3, e.getY()-3);
        }
      
        if(Interfaz.cambiarEtiqueta.isSelected()==true && e.isMetaDown() == false){
            
            for(int i=0; i<=indicePuntos; i++){
                if(puntos[i].estaContenido(new Point(e.getX()-5, e.getY()-5))==true){
                    final Estado estadoAux=new Estado();
                    estadoAux.guardarDatos(this);
                    pilaDeshacer.push(estadoAux);
                    Interfaz.mensajeAcciones.setForeground(Color.red);
                    Interfaz.mensajeAcciones.setText("ARCHIVO NO GUARDADO");
                    pilaRehacer.vaciar();
                    repetitivo=false;
                    if(Interfaz.deshacer.isEnabled()==false){
                        Interfaz.deshacer.setEnabled(true);      
                        Interfaz.menuDeshacer.setEnabled(true);
                    }
                    if(Interfaz.rehacer.isEnabled()==true){
                        Interfaz.rehacer.setEnabled(false);
                        Interfaz.menuRehacer.setEnabled(false);
                    }
                    String oracion=JOptionPane.showInputDialog("ETIQUETA");
                    if(oracion!=null)
                    puntos[i].setEtiqueta(oracion);
                    
                    lienzo.repaint();  
                }
            }
        }
    }
        
    @Override
    public void mousePressed(MouseEvent e) {
        contador = 0;
        estaContenido=1;
        moverpuntos=false;
       
        if (Interfaz.aristaNueva.isSelected() == true && e.isMetaDown() == false || Interfaz.aristaDirNueva.isSelected()==true && e.isMetaDown() == false) {
            for (int i = 0; i <= indicePuntos; i++) {
                if (puntos[i].estaContenido(new Point(e.getX() - 5, e.getY() - 5)) == true) {
                    x = puntos[i].getPosicion().x;
                    y = puntos[i].getPosicion().y;
                    puntoAux[0] = puntos[i];
                    contador++;
                    break;
                }
            }
        }
        if (Interfaz.modificar.isSelected() == true && e.isMetaDown() == false && contadorselec==0) {
            for (int i = 0; i <= indicePuntos; i++) {
                if (puntos[i].estaContenido(new Point(e.getX() - 5, e.getY() - 5)) == true) {
                    final Estado estadoAux=new Estado();
                    estadoAux.guardarDatos(this);
                    pilaDeshacer.push(estadoAux);
                    Interfaz.mensajeAcciones.setForeground(Color.red);
                    Interfaz.mensajeAcciones.setText("ARCHIVO NO GUARDADO");
                    pilaRehacer.vaciar();
                    //repetitivo=false;
                    if(Interfaz.deshacer.isEnabled()==false){
                        Interfaz.deshacer.setEnabled(true);
                        Interfaz.menuDeshacer.setEnabled(true);
                    }
                    if(Interfaz.rehacer.isEnabled()==true){
                        Interfaz.rehacer.setEnabled(false);
                        Interfaz.menuRehacer.setEnabled(false);
                    }
                    movible = puntos[i];
                    flag = true;
                    break;
                }
            }
        }
        if (Interfaz.modificar.isSelected() == true && e.isMetaDown() == false && contadorselec!=0){
            for (int i = 0; i <= indicePuntos; i++) {
                if (puntos[i].estaContenido(new Point(e.getX() - 5, e.getY() - 5)) == true) {
                    for (int k = 0; k < contadorselec; k++){
                            if(vectorselec[k]==i){
                                aux=0;
                                repintarselec();
                                final Estado estadoAux = new Estado();
                                estadoAux.guardarDatos(this);
                                pilaDeshacer.push(estadoAux);
                                pilaRehacer.vaciar();
                                moverpuntos=true;
                                break;
                            }
                        }
                    break;
                }
            }
        }
            
        int result=e.getButton();
        if(Interfaz.modificar.isSelected()==true && MenuLienzo.isPopupTrigger(e)==false && e.BUTTON3!=result){ 
                estaContenido=0;
                for (int h=0;h<=indicePuntos;h++){        
                    if (puntos[h].estaContenido(new Point(e.getX() - 5, e.getY() - 5)) == true) {
                        estaContenido++; 
                        h=indicePuntos;
                    }
                }
                if(estaContenido==0){
                        repintarselec(); 
                        corX_presionado=e.getX()-5;
                        corY_presionado=e.getY()-5;
                }
        }
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void mouseReleased(MouseEvent e) {
        aux=0;
        
        
          
        //Menu Lienzo contextual
        if(MenuLienzo.isPopupTrigger(e)&& Interfaz.modificar.isSelected() == true  ){
            aux=1;
            a=-1;
            Cortar.setFont(new java.awt.Font("Segoe UI", 0, 12));
            Cortar.setEnabled(false);
            Copiar.setFont(new java.awt.Font("Segoe UI", 0, 12));
            Copiar.setEnabled(false);
            Colores.setFont(new java.awt.Font("Segoe UI", 0, 12));
            Colores.setEnabled(false);
            Tamanyo.setFont(new java.awt.Font("Segoe UI", 0, 12));
            Tamanyo.setEnabled(false);
            Forma.setFont(new java.awt.Font("Segoe UI", 0, 12));
            Forma.setEnabled(false);
            Etiqueta.setFont(new java.awt.Font("Segoe UI", 0, 12));
            Etiqueta.setEnabled(false);
            Posicion.setFont(new java.awt.Font("Segoe UI", 0, 12));
            Posicion.setEnabled(false);
            ColoresArista.setFont(new java.awt.Font("Segoe UI", 0, 12));
            ColoresArista.setEnabled(false);
            TamanyoArista.setFont(new java.awt.Font("Segoe UI", 0, 12));
            TamanyoArista.setEnabled(false);
            Peso.setFont(new java.awt.Font("Segoe UI", 0, 12));
            Peso.setEnabled(false);
            eliminarnodo.setFont(new java.awt.Font("Segoe UI", 0, 12));
             eliminarnodo.setEnabled(false);
            agregarnodo.setFont(new java.awt.Font("Segoe UI", 1, 12));
            agregarnodo.setEnabled(true);
            agregararista.setFont(new java.awt.Font("Segoe UI", 0, 12));
            agregararista.setEnabled(false);
            eliminararista.setFont(new java.awt.Font("Segoe UI", 0, 12));
            eliminararista.setEnabled(false);
            EliminarSelec.setFont(new java.awt.Font("Segoe UI", 0, 12));
            EliminarSelec.setEnabled(false);
            X=e.getX() - 5;
            Y=e.getY() - 5;
            if(contadorselec!=0 && estaContenido!=0){
                    Cortar.setFont(new java.awt.Font("Segoe UI", 1, 12));
                    Cortar.setEnabled(true);
                    Copiar.setFont(new java.awt.Font("Segoe UI", 1, 12));
                    Copiar.setEnabled(true);
                    EliminarSelec.setFont(new java.awt.Font("Segoe UI", 1, 12));
                    EliminarSelec.setEnabled(true);
             }
            if(contadorselec==0){
                int temp=0;
                for(int i=0;i<=indicePuntos;i++){
                    if(puntos[i].estaContenido(new Point(e.getX() - 5, e.getY() - 5)) == true){
                            X=e.getX() - 5;
                            Y=e.getY() - 5;
                            agregararista.setFont(new java.awt.Font("Segoe UI", 1, 12));
                            agregararista.setEnabled(true);
                            eliminarnodo.setFont(new java.awt.Font("Segoe UI", 1, 12));
                            eliminarnodo.setEnabled(true);
                            agregarnodo.setFont(new java.awt.Font("Segoe UI", 0, 12));
                            agregarnodo.setEnabled(false);
                            Colores.setFont(new java.awt.Font("Segoe UI", 1, 12));
                            Colores.setEnabled(true);
                            Tamanyo.setFont(new java.awt.Font("Segoe UI", 1, 12));
                            Tamanyo.setEnabled(true);
                            Forma.setFont(new java.awt.Font("Segoe UI", 1, 12));
                            Forma.setEnabled(true);
                            Etiqueta.setFont(new java.awt.Font("Segoe UI", 1, 12));
                            Etiqueta.setEnabled(true);
                            Posicion.setFont(new java.awt.Font("Segoe UI", 1, 12));
                            Posicion.setEnabled(true);
                            Px=e.getX()+6;
                            Py=e.getY()+25;
                            valor=i;
                            temp=1;
                            i=indicePuntos;
                    }
                }
                if(temp==0){
                  for(int i=0; i<=indiceAristas; i++){
                     if(aristas[i].estaContenido(new Point(e.getX()-3, e.getY()-3))==true){
                            Px=e.getX()+6;
                            Py=e.getY()+25;
                            valorArista=i;
                            X=e.getX() - 3;
                            Y=e.getY() - 3;
                            agregararista.setFont(new java.awt.Font("Segoe UI", 0, 12));
                            agregararista.setEnabled(false);
                            agregarnodo.setFont(new java.awt.Font("Segoe UI", 0, 12));
                            agregarnodo.setEnabled(false);
                            Cortar.setFont(new java.awt.Font("Segoe UI", 0, 12));
                            Cortar.setEnabled(false);
                            Copiar.setFont(new java.awt.Font("Segoe UI", 0, 12));
                            Copiar.setEnabled(false);
                            eliminararista.setFont(new java.awt.Font("Segoe UI", 1, 12));
                            eliminararista.setEnabled(true);
                            ColoresArista.setFont(new java.awt.Font("Segoe UI", 1, 12));
                            ColoresArista.setEnabled(true);
                            TamanyoArista.setFont(new java.awt.Font("Segoe UI", 1, 12));
                            TamanyoArista.setEnabled(true);
                            Peso.setFont(new java.awt.Font("Segoe UI", 1, 12));
                            Peso.setEnabled(true);
                            i=indiceAristas;
                    }
                    }
                }
            }
            MenuLienzo.show(Interfaz.frameDibujo,e.getX()+6,e.getY()+25);
            MenuLienzo.setVisible(true);
        }
        
        if(estaContenido==0 ){
            contadorselec=0;
            contadorarista=0;
            corX=e.getX()-5;
            corY=e.getY()-5;
            seleccionar(); 
        }
        //mover puntos seleccionados
        if(contadorselec!=0 && Interfaz.modificar.isSelected() == true && moverpuntos==true){
            
            moverpuntos(e.getX()-5,e.getY()-5);
            
            moverpuntos=false;
            contadorselec=0;
        }
        
        if(contadorselec!=0 && Interfaz.modificar.isSelected() == true){
               Interfaz.cortar.setEnabled(true);
               Interfaz.MenuCortar.setEnabled(true);
               Interfaz.copiar.setEnabled(true);
               Interfaz.MenuCopiar.setEnabled(true);
               Interfaz.EliminDatos.setEnabled(true);
        }
        else{
               Interfaz.cortar.setEnabled(false);
               Interfaz.MenuCortar.setEnabled(false);
               Interfaz.copiar.setEnabled(false);
               Interfaz.MenuCopiar.setEnabled(false);
               Interfaz.EliminDatos.setEnabled(false);
        }
        lienzo.punto = false;
        lienzo.repaint();
        
        if (puntoAux[0]!=null&&puntoAux[1]!=null&&puntoAux[0]!=puntoAux[1]) {
                final Estado estadoAux = new Estado();
                estadoAux.guardarDatos(this);
                indiceAristas++;
                aristas[indiceAristas] = new Arista(puntoAux[0], puntoAux[1], Interfaz.aristaDirNueva.isSelected(),indiceAristas);
                if(grafo.agregarEnlace(puntoAux[0].getIndice(),puntoAux[1].getIndice(), Interfaz.aristaDirNueva.isSelected())==true){
                    lienzo.setAristas(aristas, indiceAristas);
                    pilaDeshacer.push(estadoAux);
                    Interfaz.mensajeAcciones.setForeground(Color.red);
                    Interfaz.mensajeAcciones.setText("ARCHIVO NO GUARDADO");
                    pilaRehacer.vaciar();
                    repetitivo=false;
                    if(Interfaz.deshacer.isEnabled()==false){
                        Interfaz.deshacer.setEnabled(true);
                        Interfaz.menuDeshacer.setEnabled(true);
                    }
                    if(Interfaz.rehacer.isEnabled()==true){
                        Interfaz.rehacer.setEnabled(false);
                        Interfaz.menuDeshacer.setEnabled(false);
                    }
                    puntoAux[0].setColor(Color.ORANGE);
                    puntoAux[1].setColor(Color.ORANGE);
                } 
                else {
                    aristas[indiceAristas]=null;
                    indiceAristas--;
                }
                puntoAux[1] = null;
                puntoAux[0] = null;
                matrizMostrada.actualizar();
                desactivar();
        }
        if (flag == true) {
            movible = null;
            flag = false;
        }
        
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(contadorselec!=0 && Interfaz.modificar.isSelected() == true && moverpuntos==true){
            moverpuntos(e.getX()-5,e.getY()-5);
        }
        // puntos iniciales del cuadrado seleccionador
        if(estaContenido==0 && Interfaz.modificar.isSelected()==true){
            corX= e.getX();
            corY = e.getY();
        }
        if(Interfaz.InfoPuntos.isSelected()==true){
            a=-1;
        } 
        
        if (Interfaz.aristaNueva.isSelected() == true || Interfaz.aristaDirNueva.isSelected()==true) {
            if (contador == 1) {
                for (int i = 0; i <= indicePuntos; i++) {

                    if (puntos[i].estaContenido(new Point(e.getX() - 5, e.getY() - 5)) == true) {
                        puntoAux[contador] = puntos[i];
                        puntos[i].setColor(Color.ORANGE);
                    } else {
                        if (puntos[i] != puntoAux[0]) {
                            puntos[i].setColor(Color.ORANGE);
                        }
                    }
                }
                if (contador == 1) {
                    lienzo.punto = true;
                    lienzo.setA(new Point(x, y));
                    lienzo.setB(e.getPoint());
                    lienzo.repaint();
                }
            }
        }

        if (Interfaz.modificar.isSelected() == true && flag == true && e.getX()>movible.RADIO && e.getY()>movible.RADIO && e.getX()<900-movible.RADIO && e.getY()<600-movible.RADIO && contadorselec==0) {
            Point ubicacion = new Point(e.getX() - 5, e.getY() - 5);
            //movible.pintarPunto(lienzo.getGraphics(), Color.ORANGE);
            movible.setPosicion(ubicacion);
             X=e.getX() - 5;
             Y=e.getY() - 5;
             if(X<150){
                            X=X+160;
              }
             if(Y<80){
                 Y=Y+90;
             }
        }
        lienzo.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e){
        int vandera=0;
        int b=-1;
        a=-1;
        
        if (Interfaz.modificar.isSelected() == true && indicePuntos>=0 && contadorselec==0 && MenuLienzo.isVisible()==false && e.getX()>=0 && e.getY()>=0 && e.getX()<=900 && e.getY()<=600) {
                for (int i = 0; i <=indicePuntos; i++) {
                        if (puntos[i].estaContenido(new Point(e.getX() - 5, e.getY() - 5))) {
                                a=i;
                                i=indicePuntos;
                                vandera=1;
                         }
                }
                if( vandera==0 && indiceAristas>=0 && a==-1 ){
                        for (int i = 0; i <=indiceAristas; i++){
                            if (aristas[i].estaContenido(new Point(e.getX() - 3, e.getY() - 3))) {
                                    b=i;
                                    i=indiceAristas;
                             } 
                        }
                }
                if(b!=-1){
                        for (int i = 0; i <=indiceAristas; i++) {
                            if(b!=i){
                                aristas[i].pintarArista(lienzo.getGraphics(),1);
                            }
                            else{
                                aristas[i].pintarArista(lienzo.getGraphics(), Color.GREEN);
                                puntos[aristas[i].getOrigen()].pintarPunto(lienzo.getGraphics());
                                puntos[aristas[i].getDestino()].pintarPunto(lienzo.getGraphics());
                            }
                        }
                }
                else{
                        if(indiceAristas>=0){
                            for (int i = 0; i <=indiceAristas; i++) {
                                aristas[i].pintarArista(lienzo.getGraphics(),1);
                            }
                        }
                }
                if(a!=-1){
                        for (int i = 0; i <=indicePuntos; i++) {
                            if(a!=i){
                                puntos[i].pintarPunto(lienzo.getGraphics(),1);
                            }
                            else{
                                puntos[i].pintarPunto(lienzo.getGraphics(), Color.ORANGE);
                            }
                        }
                }
                else{
                        if(indicePuntos>=0){
                            for (int i = 0; i <=indicePuntos; i++) {
                                puntos[i].pintarPunto(lienzo.getGraphics(),1);
                            }
                        }
                }
            }
              if(Interfaz.InfoPuntos.isSelected()==false && Interfaz.modificar.isSelected() == true && indicePuntos>=0 && contadorselec==0 && MenuLienzo.isVisible()==false && e.getX()>=0 && e.getY()>=0 && e.getX()<=900 && e.getY()<=600 && b==-1){
                    if(a!=-1 )
                    {   
                        X=e.getX() - 5;
                        Y=e.getY() - 5;
                        if(X<150){
                            X=X+160;
                        }
                        if(Y<80){
                            Y=Y+90;
                        }
                        gradoEntrada=grafo.getGradoEntrada(a);
                        gradoSalida=grafo.getGradoSalida(a);
                        Px=e.getX()+6;
                        Py=e.getY()+25;
                        valor=a;
                    }
                    lienzo.repaint();
            }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(repetitivo==false){
        final Estado estadoAux=new Estado();
        estadoAux.guardarDatos(this);
        pilaDeshacer.push(estadoAux);
        Interfaz.mensajeAcciones.setForeground(Color.red);
        Interfaz.mensajeAcciones.setText("ARCHIVO NO GUARDADO");
        pilaRehacer.vaciar();
       // repetitivo=true;
        }
        if(Interfaz.deshacer.isEnabled()==false){
            Interfaz.deshacer.setEnabled(true);
            Interfaz.menuDeshacer.setEnabled(true);
        }
        if(Interfaz.rehacer.isEnabled()==true){
            Interfaz.rehacer.setEnabled(false);
        }
        lienzo.ordenarPuntos(Interfaz.frameDibujo.getHeight(), Interfaz.frameDibujo.getWidth());
        lienzo.repaint();
        
        
    }
    
    public void cargarArchivo(File file){
        if(file==null){
            this.limpiarArea();
            grafo.destruirGrafo();
        }
    }
    
    @SuppressWarnings("empty-statement")
    public void seleccionar(){
           if(corX_presionado<corX && corY_presionado>corY ){
                for(int k=0;k<=indicePuntos;k++){   
                    for(int i=corX_presionado;i<=corX;i++ ){  
                        for(int j=corY;j<=corY_presionado;j++){
                            if (puntos[k].estaContenido(new Point(i , j )) == true) {
                                puntocopy[contadorselec]=new Punto(puntos[k].getPosicion().x, puntos[k].getPosicion().y, contadorselec);;
                                puntocopy[contadorselec].setColores(puntos[k].colorPunto);
                                puntocopy[contadorselec].setEtiqueta(puntos[k].getEtiqueta());
                                vectorselec[contadorselec]=k;
                                puntos[k].colorPunto=Color.PINK;
                                j=corY_presionado+1;
                                i=corX+1;
                                contadorselec++;
                                lienzo.repaint();
                            }
                        }
                    }
                }
                for(int k=0;k<=indiceAristas;k++){
                    for(int i=corX_presionado;i<=corX;i++ ){  
                        for(int j=corY;j<=corY_presionado;j++){
                            if (aristas[k].estaContenido(new Point(i , j )) == true) {
                                int verdad1=0;
                                int verdad2=0;
                                for (int l = 0; l < contadorselec; l++){
                                    if (vectorselec[l]==aristas[k].getOrigen()) {
                                        verdad1=1;
                                    }
                                    if (vectorselec[l]==aristas[k].getDestino()) {
                                        verdad2=1;
                                    } 
                                }
                                if(verdad1==1 && verdad2==1){
                                    aristascopy[contadorarista] = new Arista(puntos[aristas[k].getOrigen()], puntos[aristas[k].getDestino()], aristas[k].esDirigida(),contadorarista);
                                    aristascopy[contadorarista].setColores(aristas[k].colorArista);
                                    aristascopy[contadorarista].setPeso(aristas[k].peso);
                                    aristas[k].colorArista=Color.GREEN;
                                    vectorarista[contadorarista]=k;
                                    j=corY_presionado+1;
                                    i=corX+1;
                                    contadorarista++;
                                    lienzo.repaint();
                                }
                            }
                        }
                    }
                    
                }
            }
           if(corX_presionado>corX && corY_presionado<corY ){
                for(int k=0;k<=indicePuntos;k++){   
                    for(int i=corX;i<=corX_presionado;i++ ){  
                        for(int j=corY_presionado;j<=corY;j++){
                            if (puntos[k].estaContenido(new Point(i , j )) == true) {
                                puntocopy[contadorselec]=new Punto(puntos[k].getPosicion().x, puntos[k].getPosicion().y, contadorselec);;
                                puntocopy[contadorselec].setColores(puntos[k].colorPunto);
                                puntocopy[contadorselec].setEtiqueta(puntos[k].getEtiqueta());
                                vectorselec[contadorselec]=k;
                                puntos[k].colorPunto=Color.PINK;
                                j=corY+1;
                                i=corX_presionado+1;
                                contadorselec++;
                                lienzo.repaint();
                            }
                        }
                    }
                }
                for(int k=0;k<=indiceAristas;k++){
                    for(int i=corX;i<=corX_presionado;i++ ){  
                        for(int j=corY_presionado;j<=corY;j++){
                            if (aristas[k].estaContenido(new Point(i , j )) == true) {
                                int verdad1=0;
                                int verdad2=0;
                                for (int l = 0; l < contadorselec; l++){
                                    if (vectorselec[l]==aristas[k].getOrigen()) {
                                        verdad1=1;
                                    }
                                    if (vectorselec[l]==aristas[k].getDestino()) {
                                        verdad2=1;
                                    } 
                                }
                                if(verdad1==1 && verdad2==1){
                                    aristascopy[contadorarista] = new Arista(puntos[aristas[k].getOrigen()], puntos[aristas[k].getDestino()], aristas[k].esDirigida(),contadorarista);
                                    aristascopy[contadorarista].setColores(aristas[k].colorArista);
                                    aristascopy[contadorarista].setPeso(aristas[k].peso);
                                    aristas[k].colorArista=Color.GREEN;
                                    vectorarista[contadorarista]=k;
                                    j=corY+1;
                                    i=corX_presionado+1;
                                    contadorarista++;
                                    lienzo.repaint();
                                }
                            }
                        }
                    }
                }
           }
           
           if(corX_presionado>corX && corY_presionado>corY ){
                for(int k=0;k<=indicePuntos;k++){   
                    for(int i=corX;i<=corX_presionado;i++ ){  
                        for(int j=corY;j<=corY_presionado;j++){
                            if (puntos[k].estaContenido(new Point(i , j )) == true) {
                                puntocopy[contadorselec]=new Punto(puntos[k].getPosicion().x, puntos[k].getPosicion().y, contadorselec);;
                                puntocopy[contadorselec].setColores(puntos[k].colorPunto);
                                puntocopy[contadorselec].setEtiqueta(puntos[k].getEtiqueta());
                                vectorselec[contadorselec]=k;
                                puntos[k].colorPunto=Color.PINK;
                                j=corY_presionado+1;
                                i=corX_presionado+1;
                                contadorselec++;
                                lienzo.repaint();
                            }
                        }
                    }
                }
                for(int k=0;k<=indiceAristas;k++){
                    for(int i=corX;i<=corX_presionado;i++ ){  
                        for(int j=corY;j<=corY_presionado;j++){
                            if (aristas[k].estaContenido(new Point(i , j )) == true) {
                                int verdad1=0;
                                int verdad2=0;
                                for (int l = 0; l < contadorselec; l++){
                                    if (vectorselec[l]==aristas[k].getOrigen()) {
                                        verdad1=1;
                                    }
                                    if (vectorselec[l]==aristas[k].getDestino()) {
                                        verdad2=1;
                                    } 
                                }
                                if(verdad1==1 && verdad2==1){
                                    aristascopy[contadorarista] = new Arista(puntos[aristas[k].getOrigen()], puntos[aristas[k].getDestino()], aristas[k].esDirigida(),contadorarista);
                                    aristascopy[contadorarista].setColores(aristas[k].colorArista);
                                    aristascopy[contadorarista].setPeso(aristas[k].peso);
                                    aristas[k].colorArista=Color.GREEN;
                                    vectorarista[contadorarista]=k;
                                    j=corY_presionado+1;
                                    i=corX_presionado+1;
                                    contadorarista++;
                                    lienzo.repaint();
                                }
                            }
                        }
                    }
                }
           }
           if(corX_presionado<corX && corY_presionado<corY ){
                for(int k=0;k<=indicePuntos;k++){   
                    for(int i=corX_presionado;i<=corX;i++ ){  
                        for(int j=corY_presionado;j<=corY;j++){
                            if (puntos[k].estaContenido(new Point(i , j )) == true) {
                                puntocopy[contadorselec]=new Punto(puntos[k].getPosicion().x, puntos[k].getPosicion().y, contadorselec);;
                                puntocopy[contadorselec].setColores(puntos[k].colorPunto);
                                puntocopy[contadorselec].setEtiqueta(puntos[k].getEtiqueta());
                                vectorselec[contadorselec]=k;
                                puntos[k].colorPunto=Color.PINK;
                                j=corY+1;
                                i=corX+1;
                                contadorselec++;
                                lienzo.repaint();
                            }
                        }
                    }
                }
                for(int k=0;k<=indiceAristas;k++){
                    for(int i=corX_presionado;i<=corX;i++ ){  
                        for(int j=corY_presionado;j<=corY;j++){
                            if (aristas[k].estaContenido(new Point(i , j )) == true) {
                                int verdad1=0;
                                int verdad2=0;
                                for (int l = 0; l < contadorselec; l++){
                                    if (vectorselec[l]==aristas[k].getOrigen()) {
                                        verdad1=1;
                                    }
                                    if (vectorselec[l]==aristas[k].getDestino()) {
                                        verdad2=1;
                                    } 
                                }
                                if(verdad1==1 && verdad2==1){
                                    aristascopy[contadorarista] = new Arista(puntos[aristas[k].getOrigen()], puntos[aristas[k].getDestino()], aristas[k].esDirigida(),contadorarista);
                                    aristascopy[contadorarista].setColores(aristas[k].colorArista);
                                    aristascopy[contadorarista].setPeso(aristas[k].peso);
                                    aristas[k].colorArista=Color.GREEN;
                                    vectorarista[contadorarista]=k;
                                    j=corY+1;
                                    i=corX+1;
                                    contadorarista++;
                                    lienzo.repaint();
                                }
                            }
                        }
                    }
                }
           } 
           estaContenido=1;
    }
    
    public void repintarselec(){
        if(indicePuntos>=0){
            if(contadorselec!=0 && aux==0){
                for (int i = 0; i <= indicePuntos; i++) {
                        for (int k = 0; k < contadorselec; k++){
                               // if (puntos[i].estaContenido(new Point(puntocopy[k].getPosicion().x, puntocopy[k].getPosicion().y)) == true) {
                                        puntos[vectorselec[k]].setColores(puntocopy[k].colorPunto);
                        }
                }
            }
            if(indiceAristas>=0){
                if(contadorarista!=0 && aux==0){
                    for (int i = 0; i <= indiceAristas; i++) {
                        for (int k = 0; k < contadorarista; k++){
                               // if (aristas[i].estaContenido(new Point(puntos[aristascopy[k].getOrigen()].getPosicion().x , puntos[aristascopy[k].getOrigen()].getPosicion().y )) == true && aristas[i].estaContenido(new Point(puntos[aristascopy[k].getDestino()].getPosicion().x , puntos[aristascopy[k].getDestino()].getPosicion().y )) == true) {
                                        aristas[vectorarista[k]].setColores(aristascopy[k].colorArista);
                               // } 
                        }
                    }
                }
            }
        }
    }
    
    public void repintarcopia(){
                for (int i = 0; i <= indicePuntos; i++) {
                        for (int k = 0; k < totalpuntocopy2; k++){
                                if (puntos[i].estaContenido(new Point(puntocopy2[k].getPosicion().x, puntocopy2[k].getPosicion().y)) == true) {
                                        puntos[i].setColores(puntocopy2[k].colorPunto);
                                } 
                        }
                }
              for (int i = 0; i <= indiceAristas; i++) {
                        for (int k = 0; k < totalaristascopy2; k++){
                                if (aristas[i].estaContenido(new Point(puntos[aristascopy2[k].getOrigen()].getPosicion().x , puntos[aristascopy2[k].getOrigen()].getPosicion().y )) == true && aristas[i].estaContenido(new Point(puntos[aristascopy2[k].getDestino()].getPosicion().x , puntos[aristascopy2[k].getDestino()].getPosicion().y )) == true) {
                                        aristas[i].setColores(aristascopy2[k].colorArista);
                                } 
                        }
                }
              lienzo.repaint();
    }
    
    public void cortar(){
            if(contadorselec!=0){
                
                    repintarcopia();
                    
                    final Estado estadoAux=new Estado();
                    estadoAux.guardarDatos(this);
                    pilaDeshacer.push(estadoAux);
                    Interfaz.mensajeAcciones.setForeground(Color.red);
                    Interfaz.mensajeAcciones.setText("ARCHIVO NO GUARDADO");
                    pilaRehacer.vaciar();
                    if(Interfaz.deshacer.isEnabled()==false){
                        Interfaz.deshacer.setEnabled(true);
                        Interfaz.menuDeshacer.setEnabled(true);
                    }
                    if(Interfaz.rehacer.isEnabled()==true){
                        Interfaz.rehacer.setEnabled(false);
                        Interfaz.menuRehacer.setEnabled(false);
                    } 
                    for (int i = 0; i <= indicePuntos; i++) {
                        for (int k = 0; k < contadorselec; k++){
                            if (puntos[i].estaContenido(new Point(puntocopy[k].getPosicion().x, puntocopy[k].getPosicion().y)) == true) {
                                eliminarPunto(i);
                                lienzo.setPuntos(puntos, indicePuntos);
                                lienzo.setAristas(aristas, indiceAristas);
                                grafo.eliminarNodo(i);
                                lienzo.repaint();
                            } 
                         }
                    }
                    //estaContenido=0;
                    contadorselec=0;
                    matrizMostrada.actualizar();
                    desactivar();
                    Pegar.setFont(new java.awt.Font("Segoe UI", 1, 12));
                    Pegar.setEnabled(true);
                    Interfaz.cortar.setEnabled(false);
                    Interfaz.MenuCortar.setEnabled(false);
                    Interfaz.copiar.setEnabled(false);
                    Interfaz.MenuCopiar.setEnabled(false);
                    Interfaz.pegar.setEnabled(true);
                    Interfaz.MenuPegar.setEnabled(true);
            }
    }
    
    @SuppressWarnings("empty-statement")
    public void copiar(){ 
        if(contadorselec!=0){
            for (int k = 0; k < contadorselec; k++){
                    puntocopy2[k]=new Punto(puntocopy[k].getPosicion().x, puntocopy[k].getPosicion().y, k);
                    puntocopy2[k].setColores(puntocopy[k].colorPunto);
                    puntocopy2[k].setEtiqueta(puntocopy[k].getEtiqueta()); 
            }
            totalpuntocopy2=contadorselec;
            for (int k = 0; k < contadorarista; k++){  
                    aristascopy2[k] = new Arista(puntos[aristascopy[k].getOrigen()], puntos[aristascopy[k].getDestino()], aristascopy[k].esDirigida(),k);
                    aristascopy2[k].setColores(aristascopy[k].colorArista);
                    aristascopy2[k].setPeso(aristascopy[k].peso);
            }
            totalaristascopy2=contadorarista;
            Pegar.setFont(new java.awt.Font("Segoe UI", 1, 12));
            Pegar.setEnabled(true);
            Interfaz.cortar.setEnabled(false);
            Interfaz.MenuCortar.setEnabled(false);
            Interfaz.copiar.setEnabled(false);
            Interfaz.MenuCopiar.setEnabled(false);
            Interfaz.pegar.setEnabled(true);
            Interfaz.MenuPegar.setEnabled(true);
        }
    }
    
    public void pegar(int Xp, int Yp){
        int si=1;
        if(indicePuntos < MAX_PUNTOS-1){
            if(totalpuntocopy2+indicePuntos>MAX_PUNTOS-1){
                if(JOptionPane.showConfirmDialog(null, "No se Puede Pegar todos los Nodos\n" + "¿Desea Pegar los que Alcancen?")==JOptionPane.YES_OPTION){
                        si=1;
                    }
                else{
                    si=0;
                }
            }
            if(si==1){
             final Estado estadoAux=new Estado();   
             estadoAux.guardarDatos(this);
             pilaDeshacer.push(estadoAux);
             Interfaz.mensajeAcciones.setForeground(Color.red);
             Interfaz.mensajeAcciones.setText("ARCHIVO NO GUARDADO");
             pilaRehacer.vaciar();
             if(Interfaz.deshacer.isEnabled()==false){
                    Interfaz.deshacer.setEnabled(true);
                    Interfaz.menuDeshacer.setEnabled(true);
             }
             if(Interfaz.rehacer.isEnabled()==true){
                    Interfaz.rehacer.setEnabled(false);
                    Interfaz.menuRehacer.setEnabled(false);
              }
             int tempcont=0;
              for (int k = 0; k < totalpuntocopy2; k++){
                    if(indicePuntos < MAX_PUNTOS-1){
                        if(grafo.agregarNodo()==true){
                        indicePuntos++;
                        Point pun =new Point(puntocopy2[k].getPosicion().x, puntocopy2[k].getPosicion().y);
                        Punto punto = new Punto(pun.x, pun.y, indicePuntos);
                        punto.setColores(puntocopy2[k].colorPunto);
                        punto.setEtiqueta(puntocopy2[k].getEtiqueta());
                        puntos[indicePuntos] = punto;
                        lienzo.setPuntos(puntos, indicePuntos);
                        tempv[tempcont]=indicePuntos;
                        tempcont++;
                        }
                    }
               }
              for(int j=0; j<totalaristascopy2; j++){
                    for(int i=0; i<tempcont; i++){
                      if(puntos[tempv[i]].estaContenido(new Point(aristascopy2[j].puntoA.getPosicion().x,aristascopy2[j].puntoA.getPosicion().y))==true){
                            for(int k=0; k<tempcont; k++){
                                    if(puntos[tempv[k]].estaContenido(new Point(aristascopy2[j].puntoB.getPosicion().x,aristascopy2[j].puntoB.getPosicion().y))==true){
                                            x = puntos[tempv[i]].getPosicion().x;
                                            y = puntos[tempv[i]].getPosicion().y;
                                            puntoAux[0] = puntos[tempv[i]];//inicial
                                            contador++;
                                            puntoAux[1]=puntos[tempv[k]]; //final
                                            lienzo.setA(new Point(x, y));
                                            lienzo.setB(new Point(puntos[tempv[k]].getPosicion().x,puntos[tempv[k]].getPosicion().y));
                                            
                                            indiceAristas++;
                                            Arista ariataaux = new Arista(puntoAux[0], puntoAux[1], aristascopy2[j].esDirigida(),indiceAristas);
                                            aristas[indiceAristas] = ariataaux; 
                                            aristas[indiceAristas].setPeso(aristascopy2[j].peso);
                                            aristas[indiceAristas].setColores(aristascopy2[j].colorArista);
                                            if(grafo.agregarEnlace(puntoAux[0].getIndice(),puntoAux[1].getIndice(), aristascopy2[j].esDirigida())==true){
                                                lienzo.setAristas(aristas, indiceAristas);
                                            } 
                                            puntoAux[1] = null;
                                            puntoAux[0] = null;
                                            
                                    }
                            }
                      }
                  }
              }
            int menor , temp;
            int indice[];
            int indice2[];
            indice =new int[10];
            indice2 =new int[10];
            menor=puntos[tempv[0]].getPosicion().x;
            temp=0;
            for (int k = 0; k < tempcont; k++){
                    if(puntos[tempv[k]].getPosicion().x<=menor){
                        menor=puntos[tempv[k]].getPosicion().x;
                        temp=k;
                    }
            }
            for (int k = 0; k < tempcont; k++){
                    if(k!=temp){
                        indice[k]=puntos[tempv[k]].getPosicion().x-puntos[tempv[temp]].getPosicion().x;
                    }
                    if(k==temp){
                        indice[k]=0;
                    }
            }
            menor=puntos[tempv[0]].getPosicion().y;
            temp=0;
            for (int k = 0; k < tempcont; k++){
                    
                    if(puntos[tempv[k]].getPosicion().y<=menor){
                        menor=puntos[tempv[k]].getPosicion().y;
                        temp=k;
                    }
            }
            for (int k = 0; k < tempcont; k++){
                    
                    if(k!=temp){
                        indice2[k]=puntos[tempv[k]].getPosicion().y-puntos[tempv[temp]].getPosicion().y;
                    }
                    if(k==temp){
                        indice2[k]=0;
                    }
            }
            for (int k = 0; k < tempcont; k++){
                    puntos[tempv[k]].setPosicion(Xp+indice[k],Yp+indice2[k]);
            }
            lienzo.repaint();
            desactivar();
            Pegar.setFont(new java.awt.Font("Segoe UI", 0, 12));
            Pegar.setEnabled(false);
            Interfaz.cortar.setEnabled(false);
            Interfaz.MenuCortar.setEnabled(false);
            Interfaz.copiar.setEnabled(false);
            Interfaz.MenuCopiar.setEnabled(false);
            Interfaz.pegar.setEnabled(false);
            Interfaz.MenuPegar.setEnabled(false);
            matrizMostrada.actualizar();
            }
         }
        else{
            JOptionPane.showMessageDialog(null,"No se puede Pegar más Nodos\n"+"Se ha alcanzado el Limite");
        }
    }
    
    public void Coloreargrafo4() {
                    final Estado estadoAux=new Estado();
                    estadoAux.guardarDatos(this);
                    pilaDeshacer.push(estadoAux);
                    Interfaz.mensajeAcciones.setForeground(Color.red);
                    Interfaz.mensajeAcciones.setText("ARCHIVO NO GUARDADO");
                    pilaRehacer.vaciar();
                    if(Interfaz.deshacer.isEnabled()==false){
                        Interfaz.deshacer.setEnabled(true);
                        Interfaz.menuDeshacer.setEnabled(true);
                    }
                    if(Interfaz.rehacer.isEnabled()==true){
                        Interfaz.rehacer.setEnabled(false);
                        Interfaz.menuRehacer.setEnabled(false);
                    }
                    Matriz.colorearGrafo();
    }
    
    public void cambiaretiqueta(){
                   AristaoPunto=0;   
                    final Estado estadoAux=new Estado();
                    estadoAux.guardarDatos(this);
                    pilaDeshacer.push(estadoAux);
                    Interfaz.mensajeAcciones.setForeground(Color.red);
                    Interfaz.mensajeAcciones.setText("ARCHIVO NO GUARDADO");
                    pilaRehacer.vaciar();
                    //repetitivo=false;
                    if(Interfaz.deshacer.isEnabled()==false){
                        Interfaz.deshacer.setEnabled(true);      
                        Interfaz.menuDeshacer.setEnabled(true);
                    }
                    if(Interfaz.rehacer.isEnabled()==true){
                        Interfaz.rehacer.setEnabled(false);
                        Interfaz.menuRehacer.setEnabled(false);
                    }
                    String oracion=JOptionPane.showInputDialog("ETIQUETA");
                    if(oracion!=null){
                    puntos[valor].setEtiqueta(oracion);
                    }
                   lienzo.repaint(); 
    }
    
    public void agregarnodo(int x, int y){
        int yaesta;
        final Estado estadoAux=new Estado();   
             estadoAux.guardarDatos(this);
             indicePuntos++;
            if(grafo.agregarNodo()==true){
                pilaDeshacer.push(estadoAux);
                Interfaz.mensajeAcciones.setForeground(Color.red);
                Interfaz.mensajeAcciones.setText("ARCHIVO NO GUARDADO");
                pilaRehacer.vaciar();
                //repetitivo=false;
                if(Interfaz.deshacer.isEnabled()==false){
                    Interfaz.deshacer.setEnabled(true);
                    Interfaz.menuDeshacer.setEnabled(true);
                }
                if(Interfaz.rehacer.isEnabled()==true){
                    Interfaz.rehacer.setEnabled(false);
                    Interfaz.menuRehacer.setEnabled(false);
                }
                Point pun =new Point(x, y);
                yaesta=0;
                while(yaesta==0){
                for (int i = 0; i <indicePuntos; i++) {
                        if (puntos[i].estaContenido(pun)==true) {
                               yaesta=1;                
                        }
                }
                if(yaesta==1){
                    pun =new Point(pun.x+1, pun.y +1);
                    yaesta=0;
                }
                else{
                    yaesta=1;
                }
            }
                
                
                Punto punto = new Punto(pun.x, pun.y, indicePuntos);
                punto.pintarPunto(lienzo.getGraphics());
                puntos[indicePuntos] = punto;
                lienzo.setPuntos(puntos, indicePuntos);
            }else{
                indicePuntos--;
                JOptionPane.showMessageDialog(null,"No se puede Crear más Nodos\n"+"Se ha alcanzado el Limite");

            }
            desactivar();
             matrizMostrada.actualizar();
    }
    
    public void Eliminarnodo(int x, int y){
        for(int i=0; i<=indicePuntos; i++){
                if(puntos[i].estaContenido(new Point(x,y))==true){
                    final Estado estadoAux=new Estado();
                    estadoAux.guardarDatos(this);
                    pilaDeshacer.push(estadoAux);
                    Interfaz.mensajeAcciones.setForeground(Color.red);
                    Interfaz.mensajeAcciones.setText("ARCHIVO NO GUARDADO");
                    pilaRehacer.vaciar();
                    //repetitivo=false;
                    if(Interfaz.deshacer.isEnabled()==false){
                        Interfaz.deshacer.setEnabled(true);
                        Interfaz.menuDeshacer.setEnabled(true);
                    }
                    if(Interfaz.rehacer.isEnabled()==true){
                        Interfaz.rehacer.setEnabled(false);
                        Interfaz.menuRehacer.setEnabled(false);
                    }                    
                    eliminarPunto(i);
                    lienzo.setPuntos(puntos, indicePuntos);
                    lienzo.setAristas(aristas, indiceAristas);
                    grafo.eliminarNodo(i);
                    repaint();
                    matrizMostrada.actualizar();
                    desactivar();
                    break;
                }
            }
    }
    
    public void Eliminaarista(int x, int y){
        for(int i=0; i<=indiceAristas; i++){
                if(aristas[i].estaContenido(new Point(x, y))==true){
                    final Estado estadoAux=new Estado();
                    estadoAux.guardarDatos(this);
                    pilaDeshacer.push(estadoAux);
                    Interfaz.mensajeAcciones.setForeground(Color.red);
                    Interfaz.mensajeAcciones.setText("ARCHIVO NO GUARDADO");
                    pilaRehacer.vaciar();
                    //repetitivo=false;
                    if(Interfaz.deshacer.isEnabled()==false){
                        Interfaz.deshacer.setEnabled(true);
                        Interfaz.menuDeshacer.setEnabled(true);
                    }
                    if(Interfaz.rehacer.isEnabled()==true){
                        Interfaz.rehacer.setEnabled(false);
                        Interfaz.menuRehacer.setEnabled(false);
                    }
                    grafo.eliminarEnlace(aristas[i].getOrigen(), aristas[i].getDestino(), aristas[i].esDirigida());
                    eliminarArista(i);
                    lienzo.setAristas(aristas, indiceAristas);
                     matrizMostrada.actualizar();
                    lienzo.repaint();
                    desactivar();
                    if(AreaDibujo.indiceAristas==-1){
                        Interfaz.modificar.setSelected(true);
                    }
                    break;  
                }
            }
    }
    
    public static void desactivar(){
        if(indicePuntos==-1){ 
                Interfaz.modificar.setSelected(true);
                Completar.setEnabled(false);
                Interfaz.virgraf.setEnabled(false);
                Interfaz.VisorComplet.setEnabled(false);
                Interfaz.borrarNodo.setEnabled(false);
                Interfaz.cambiarEtiqueta.setEnabled(false);
                Interfaz.aristaDirNueva.setEnabled(false);
                Interfaz.aristaNueva.setEnabled(false);
                Interfaz.BarAgregaArista.setEnabled(false);
                Interfaz.BaragreArisDir.setEnabled(false);
                Interfaz.borrarArista.setEnabled(false);
                Interfaz.BarElimiArista.setEnabled(false);
                Interfaz.BotDijkstra.setEnabled(false);
                Interfaz.jMenuItem1.setEnabled(false);
                Interfaz.jButton2.setEnabled(false);
                Interfaz.colorearGrafos.setEnabled(false);
                Interfaz.barColorear.setEnabled(false);
                Interfaz.editNodo1.setEnabled(false);
                Interfaz.editarista1.setEnabled(false);
                Interfaz.ordenar.setEnabled(false);
                Interfaz.menuOrdenar.setEnabled(false);
                Alinerar.setEnabled(false);
                Interfaz.BarAgregavertice.setEnabled(true);
                Interfaz.BarEliminavertice.setEnabled(false);
                Interfaz.botdiametro.setEnabled(false);
                Interfaz.bardiam.setEnabled(false);
                Interfaz.arbol.setEnabled(false);
                Interfaz.botcamin.setEnabled(false);
                Interfaz.barArbin.setEnabled(false);
                Interfaz.barcamci.setEnabled(false);
                
         }
         else{
                        Interfaz.editNodo1.setEnabled(true);
                        Completar.setEnabled(true);
                        Interfaz.virgraf.setEnabled(true);
                        Interfaz.VisorComplet.setEnabled(true); 
                        Interfaz.borrarNodo.setEnabled(true); 
                        Interfaz.cambiarEtiqueta.setEnabled(true);
                        Interfaz.ordenar.setEnabled(true);
                        Interfaz.menuOrdenar.setEnabled(true);
                        Alinerar.setEnabled(true);
                        Interfaz.BarAgregavertice.setEnabled(true);
                        Interfaz.BarEliminavertice.setEnabled(true);
                        
                        if(AreaDibujo.indiceAristas==-1){
                            Interfaz.editarista1.setEnabled(false);
                            Interfaz.aristaDirNueva.setEnabled(true);
                            Interfaz.aristaNueva.setEnabled(true);
                            Interfaz.BarAgregaArista.setEnabled(true);
                            Interfaz.BaragreArisDir.setEnabled(true);
                            Interfaz.borrarArista.setEnabled(false);
                            Interfaz.BarElimiArista.setEnabled(false);
                            Interfaz.jMenuItem1.setEnabled(false);
                            Interfaz.BotDijkstra.setEnabled(false);
                            Interfaz.jButton2.setEnabled(false);
                            Interfaz.colorearGrafos.setEnabled(false);
                            Interfaz.barColorear.setEnabled(false);
                            Interfaz.botdiametro.setEnabled(false);
                            Interfaz.bardiam.setEnabled(false);
                            Interfaz.arbol.setEnabled(false);
                            Interfaz.botcamin.setEnabled(false);
                            Interfaz.barArbin.setEnabled(false);
                            Interfaz.barcamci.setEnabled(false);
                        }
                        else{
                            
                            Interfaz.botcamin.setEnabled(true);
                            Interfaz.barcamci.setEnabled(true);
                            Interfaz.botdiametro.setEnabled(true);
                            Interfaz.bardiam.setEnabled(true);
                            Interfaz.editarista1.setEnabled(true);
                            Interfaz.jMenuItem1.setEnabled(true);
                            Interfaz.BotDijkstra.setEnabled(true);
                            Interfaz.jButton2.setEnabled(true);
                            Interfaz.borrarArista.setEnabled(true);
                            Interfaz.BarElimiArista.setEnabled(true);
                            if(aristas[0].esDirigida()){
                                Interfaz.arbol.setEnabled(false);
                            Interfaz.barArbin.setEnabled(false);
                                Interfaz.aristaNueva.setEnabled(false);
                                Interfaz.BarAgregaArista.setEnabled(false);
                                Interfaz.VisorComplet.setEnabled(false);
                                Interfaz.virgraf.setEnabled(false);
                                Completar.setEnabled(false);
                                Interfaz.BaragreArisDir.setEnabled(true);
                                Interfaz.aristaDirNueva.setEnabled(true);
                                Interfaz.colorearGrafos.setEnabled(false);
                                Interfaz.barColorear.setEnabled(false);
                            }else {
                                Interfaz.arbol.setEnabled(true);
                                Interfaz.barArbin.setEnabled(true);
                                Interfaz.aristaDirNueva.setEnabled(false);
                                Interfaz.BaragreArisDir.setEnabled(false);
                                Interfaz.aristaNueva.setEnabled(true);
                                Interfaz.BarAgregaArista.setEnabled(true);
                                Interfaz.VisorComplet.setEnabled(true);
                                Interfaz.virgraf.setEnabled(true);
                                Completar.setEnabled(true);
                                Interfaz.colorearGrafos.setEnabled(true);
                                Interfaz.barColorear.setEnabled(true);
                            }   
                        }
            }
    }
    
    public void moverpuntos(int X,int Y){
        int menor , temp;
            int indice[];
            int indice2[];
            indice =new int[10];
            indice2 =new int[10];
            menor=puntos[vectorselec[0]].getPosicion().x;
            temp=0;
            for (int k = 0; k < contadorselec; k++){
                    if(puntos[vectorselec[k]].getPosicion().x<=menor){
                        menor=puntos[vectorselec[k]].getPosicion().x;
                        temp=k;
                    }
            }
            for (int k = 0; k < contadorselec; k++){
                    if(k!=temp){
                        indice[k]=puntos[vectorselec[k]].getPosicion().x-puntos[vectorselec[temp]].getPosicion().x;
                    }
                    if(k==temp){
                        indice[k]=0;
                    }
            }
            menor=puntos[vectorselec[0]].getPosicion().y;
            temp=0;
            for (int k = 0; k < contadorselec; k++){
                    
                    if(puntos[vectorselec[k]].getPosicion().y<=menor){
                        menor=puntos[vectorselec[k]].getPosicion().y;
                        temp=k;
                    }
            }
            for (int k = 0; k < contadorselec; k++){
                    
                    if(k!=temp){
                        indice2[k]=puntos[vectorselec[k]].getPosicion().y-puntos[vectorselec[temp]].getPosicion().y;
                    }
                    if(k==temp){
                        indice2[k]=0;
                    }
            }
            for (int k = 0; k < contadorselec; k++){
                    puntos[vectorselec[k]].setPosicion(X+indice[k],Y+indice2[k]);
            }
            //lienzo.repaint();
    }
    
    public static boolean esArbin(Grafo grafo) {
    int var_t = 0; /* Aristas contadas en una fila */
    final int max_n = grafo.indiceNodos; /* Nodos del grafo -1 */

    for(int i = 0; i < max_n + 1; i++) {
    for(int j = 0; j < max_n + 1; j++) {
    /* Iteracion de contar las aristas de una fila */
    if(grafo.matrizAdyacencia[i][j] == 1) var_t++;
    }
    }

    /* Si la cantidad de aristas / 2 es mayor que el numero de nodos -1
    quiere decir que en alguna parte del grafo existen ciclos, por lo tanto
    retornamos false */

    if((double) var_t / 2 > max_n) return false;

    return true;
    }

   

    


    public boolean gradoArbol(){
             
        for(int i = 0; i < AreaDibujo.indicePuntos +1; i++) {
            int var_t = 0;
            for(int j = 0; j < AreaDibujo.indicePuntos +1; j++) {
                if(AreaDibujo.matrizMostrada.matrizAdyacencia[i][j] == 1) 
                var_t++;
            }
            if(var_t>3){
                return false;
            }
            
            
        
        }
        return true;
        }


    
}

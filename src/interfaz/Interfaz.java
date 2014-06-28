
package interfaz;
import AutoDibujar.*;
import Editado.*;
import base.Matriz;
import dibujo.*;
import gestion.Captura;
import java.awt.*;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import otros.Informacion;
//import org.edisoncor.gui.util.WindowDragger;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.Graphics;
//import java.beans.PropertyVetoException;
//import dibujo.Lienzo;

public class Interfaz extends javax.swing.JFrame {

     AreaDibujo areaDibujo;
     public static boolean abierto;
     public static boolean archivo;
     public static File file;
     public static PrinterJob job;
    // public static TablaAcciones Acciones;
     public static Arista listaC[]=new Arista[100];
     public static Arista listaCM[]=new Arista[100];
     public static int CantidadAristasC=0;
     public static int CantidadAristasCM=0;
     public static int colorearGrafo =0;
      Matriz matriz;
    public Interfaz(){
     //    setUndecorated(true);
       Image icon;
        icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconos/core32.png"));
       setIconImage(icon);
     
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
 
  try
   {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JDialog.setDefaultLookAndFeelDecorated(true);
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
   }
    catch (Exception e)
     {
      e.printStackTrace();}
          
         initComponents();
         //WindowDragger bartar=new WindowDragger(this,barraMenuPrincipal);

       // x:1010 y:650
         //setExtendedState();
         setLocationRelativeTo(null);
        areaDibujo=new AreaDibujo();
        areaDibujo.setBounds(baseDerecha.getBounds());
        frameDibujo.add(areaDibujo , java.awt.BorderLayout.CENTER);
        frameDibujo.setBackground(Color.WHITE);
        areaDibujo.setVisible(true);
        areaDibujo.setBackground(Color.WHITE);
        baseIzquierda.add(areaDibujo.matrizMostrada);
        areaDibujo.matrizMostrada.setBounds(baseIzquierda.getBounds());
        areaDibujo.matrizMostrada.setVisible(true);
        frameDibujo.getContentPane().setBackground(Color.WHITE);
        frameDibujo.setVisible(false);
        borrarNodo.setEnabled(false);
        borrarArista.setEnabled(false);
        BarElimiArista.setEnabled(false);
        nodoNuevo.setEnabled(false);
        aristaNueva.setEnabled(false);
        aristaDirNueva.setEnabled(false);
        BaragreArisDir.setEnabled(false);
        BarAgregaArista.setEnabled(false);
        cambiarEtiqueta.setEnabled(false);
        configurarPagina.setEnabled(false);
        imprimir.setEnabled(false);
        Imprimir.setEnabled(false);
        ordenar.setEnabled(false);
        tabla.setVisible(false);
        jScrollPane1.setBounds(0, 0, 905, 625);
        boteule.setEnabled(false);
        barEule.setEnabled(false);
        CicloEulerians.setEnabled(false);
        CicloHamilt.setEnabled(false);
        barhamil.setEnabled(false);
        bothami.setEnabled(false);
        botbipartito.setEnabled(false);
        BarBipartito.setEnabled(false);
        Bipartito.setEnabled(false);
        Kruskal.setEnabled(false);
        jMenuItem2.setEnabled(false);
        BotKruska.setEnabled(false);
        VisorComplet.setEnabled(false);
        colorearGrafos.setEnabled(false);
        deshacer.setEnabled(false);
        rehacer.setEnabled(false);
        menuDeshacer.setEnabled(false);
        menuRehacer.setEnabled(false);
        Screen.setEnabled(false);
        abierto=false;
        MenuCortar.setEnabled(false);
        MenuCopiar.setEnabled(false);
        MenuPegar.setEnabled(false);
        cortar.setEnabled(false);
        copiar.setEnabled(false);
        pegar.setEnabled(false);
        guardarArchivo.setEnabled(false);
        progresoAcciones.setStringPainted(true);
        BotDijkstra.setEnabled(false);
        jButton2.setEnabled(false);
        vermatriz1.setEnabled(false);
        Cuadricular.setEnabled(false);
        botprim.setEnabled(false);
        botcamin.setEnabled(false);
        arbol.setEnabled(false);
        editNodo1.setEnabled(false);
        editarista1.setEnabled(false);
        menuGuardarComo.setEnabled(false);
        menuGuardar.setEnabled(false);
        guardarimagen.setEnabled(false);
        BarAgregavertice.setEnabled(false);
        BarEliminavertice.setEnabled(false);
        cuadri.setEnabled(false);
        AreaPunteada.setEnabled(false);
        MostarMatriz.setEnabled(false);
        barColorear.setEnabled(false);
        jMenuItem1.setEnabled(false);
        virgraf.setEnabled(false);
        menuOrdenar.setEnabled(false);
        menuActualizar.setEnabled(false);
        InfoPuntos.setEnabled(false);
        ocultapesoaris.setEnabled(false);
        barPrim.setEnabled(false);
        AlPrim.setEnabled(false);
        EliminDatos.setEnabled(false);
        botdiametro.setEnabled(false);
        bardiam.setEnabled(false);
        conexo87.setEnabled(false);
        conex.setEnabled(false);
        barArbin.setEnabled(false);
        barcamci.setEnabled(false);
        archivo=false;
        file=null;
        menuNuevo.addActionListener(nuevoDocumento.getAction());
        mensajeAcciones.setHorizontalAlignment(SwingConstants.RIGHT);
        job=PrinterJob.getPrinterJob(); 
  }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoPaleta = new javax.swing.ButtonGroup();
        buttonbarra = new javax.swing.ButtonGroup();
        basePrincipal = new javax.swing.JPanel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        barraHerramientas = new javax.swing.JToolBar();
        deshacer = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        nuevoDocumento = new javax.swing.JButton();
        abrirDocumento = new javax.swing.JButton();
        guardarArchivo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        imprimir = new javax.swing.JButton();
        Screen = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        cortar = new javax.swing.JButton();
        copiar = new javax.swing.JButton();
        pegar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        arbol = new javax.swing.JButton();
        botcamin = new javax.swing.JButton();
        botdiametro = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        botbipartito = new javax.swing.JButton();
        boteule = new javax.swing.JButton();
        bothami = new javax.swing.JButton();
        barraHerramientas2 = new javax.swing.JToolBar();
        rehacer = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        modificar = new javax.swing.JToggleButton();
        nodoNuevo = new javax.swing.JToggleButton();
        borrarNodo = new javax.swing.JToggleButton();
        aristaNueva = new javax.swing.JToggleButton();
        aristaDirNueva = new javax.swing.JToggleButton();
        borrarArista = new javax.swing.JToggleButton();
        cambiarEtiqueta = new javax.swing.JToggleButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        ordenar = new javax.swing.JButton();
        colorearGrafos = new javax.swing.JButton();
        VisorComplet = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        Cuadricular = new javax.swing.JToggleButton();
        vermatriz1 = new javax.swing.JToggleButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        BotDijkstra = new javax.swing.JButton();
        BotKruska = new javax.swing.JButton();
        botprim = new javax.swing.JButton();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        baseDerecha = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        frameDibujo = new javax.swing.JInternalFrame();
        tabla = new javax.swing.JTabbedPane();
        baseIzquierda = new javax.swing.JPanel();
        Actualizar = new javax.swing.JButton();
        AutoActualizar = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        AlPrim = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Kruskal = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        eulerians = new javax.swing.JLabel();
        hamilt = new javax.swing.JLabel();
        completo = new javax.swing.JLabel();
        conexo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        BuscarBipartito = new javax.swing.JLabel();
        Dirigidos = new javax.swing.JLabel();
        CicloHamilt = new javax.swing.JButton();
        Bipartito = new javax.swing.JButton();
        CicloEulerians = new javax.swing.JButton();
        conexo87 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablagrados = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        mensajeAcciones = new javax.swing.JTextField();
        progresoAcciones = new javax.swing.JProgressBar(0, 150);
        mensaje2 = new javax.swing.JLabel();
        barraMenuPrincipal = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuNuevo = new javax.swing.JMenuItem();
        menuAbrir = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        menuGuardar = new javax.swing.JMenuItem();
        menuGuardarComo = new javax.swing.JMenuItem();
        guardarimagen = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        Imprimir = new javax.swing.JMenuItem();
        configurarPagina = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        menuSalir = new javax.swing.JMenuItem();
        menuEditar = new javax.swing.JMenu();
        menuDeshacer = new javax.swing.JMenuItem();
        menuRehacer = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        BarSelec = new javax.swing.JCheckBoxMenuItem();
        editVertices = new javax.swing.JMenu();
        BarAgregavertice = new javax.swing.JCheckBoxMenuItem();
        BarEliminavertice = new javax.swing.JCheckBoxMenuItem();
        editNodo1 = new javax.swing.JMenuItem();
        EditArista = new javax.swing.JMenu();
        BarAgregaArista = new javax.swing.JCheckBoxMenuItem();
        BaragreArisDir = new javax.swing.JCheckBoxMenuItem();
        BarElimiArista = new javax.swing.JCheckBoxMenuItem();
        editarista1 = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        MenuCortar = new javax.swing.JMenuItem();
        MenuCopiar = new javax.swing.JMenuItem();
        MenuPegar = new javax.swing.JMenuItem();
        EliminDatos = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        Ver = new javax.swing.JMenu();
        cuadri = new javax.swing.JCheckBoxMenuItem();
        AreaPunteada = new javax.swing.JCheckBoxMenuItem();
        MostarMatriz = new javax.swing.JCheckBoxMenuItem();
        jSeparator18 = new javax.swing.JPopupMenu.Separator();
        InfoPuntos = new javax.swing.JCheckBoxMenuItem();
        ocultapesoaris = new javax.swing.JCheckBoxMenuItem();
        herramientas = new javax.swing.JMenu();
        menuActualizar = new javax.swing.JMenuItem();
        jSeparator19 = new javax.swing.JPopupMenu.Separator();
        menuOrdenar = new javax.swing.JMenuItem();
        virgraf = new javax.swing.JMenuItem();
        barColorear = new javax.swing.JMenuItem();
        bardiam = new javax.swing.JMenuItem();
        barArbin = new javax.swing.JMenuItem();
        Algoritmos = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        barPrim = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        barcamci = new javax.swing.JMenuItem();
        BarBipartito = new javax.swing.JMenuItem();
        barEule = new javax.swing.JMenuItem();
        conex = new javax.swing.JMenuItem();
        barhamil = new javax.swing.JMenuItem();
        menuAyuda = new javax.swing.JMenu();
        menuItemAyuda = new javax.swing.JMenuItem();
        Acerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("Grafo Max");
        setForeground(new java.awt.Color(102, 153, 255));
        setMinimumSize(new java.awt.Dimension(1010, 700));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        basePrincipal.setLayout(new java.awt.BorderLayout());

        barraHerramientas.setBackground(new java.awt.Color(153, 220, 255));
        barraHerramientas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        barraHerramientas.setFloatable(false);
        barraHerramientas.setForeground(new java.awt.Color(153, 220, 255));
        barraHerramientas.setOrientation(javax.swing.SwingConstants.VERTICAL);
        barraHerramientas.setRollover(true);
        barraHerramientas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        deshacer.setBackground(new java.awt.Color(153, 220, 255));
        deshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Button Previous_32.png"))); // NOI18N
        deshacer.setToolTipText("Deshacer CRTL+Z");
        deshacer.setFocusable(false);
        deshacer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deshacer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraHerramientas.add(deshacer);
        barraHerramientas.add(jSeparator10);

        nuevoDocumento.setBackground(new java.awt.Color(153, 220, 255));
        nuevoDocumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Page-32.png"))); // NOI18N
        nuevoDocumento.setToolTipText("Nuevo Grafo");
        nuevoDocumento.setFocusable(false);
        nuevoDocumento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nuevoDocumento.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraHerramientas.add(nuevoDocumento);

        abrirDocumento.setBackground(new java.awt.Color(153, 220, 255));
        abrirDocumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Folder-32.png"))); // NOI18N
        abrirDocumento.setToolTipText("Abrir Grafo");
        abrirDocumento.setFocusable(false);
        abrirDocumento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        abrirDocumento.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraHerramientas.add(abrirDocumento);

        guardarArchivo.setBackground(new java.awt.Color(153, 220, 255));
        guardarArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Download-32.png"))); // NOI18N
        guardarArchivo.setToolTipText("Guardar Grafo");
        guardarArchivo.setFocusable(false);
        guardarArchivo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guardarArchivo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraHerramientas.add(guardarArchivo);
        barraHerramientas.add(jSeparator1);

        imprimir.setBackground(new java.awt.Color(153, 220, 255));
        imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Print_32.png"))); // NOI18N
        imprimir.setToolTipText("Imprimir");
        imprimir.setFocusable(false);
        imprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        imprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraHerramientas.add(imprimir);

        Screen.setBackground(new java.awt.Color(153, 220, 255));
        Screen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/camera_32.png"))); // NOI18N
        Screen.setToolTipText("Obtener Imagen");
        Screen.setFocusable(false);
        Screen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Screen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Screen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ScreenMouseClicked(evt);
            }
        });
        Screen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScreenActionPerformed(evt);
            }
        });
        barraHerramientas.add(Screen);
        barraHerramientas.add(jSeparator2);

        cortar.setBackground(new java.awt.Color(153, 220, 255));
        cortar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Cut-32.png"))); // NOI18N
        cortar.setToolTipText("Cortar grafo seleccionado");
        cortar.setFocusable(false);
        cortar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cortar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraHerramientas.add(cortar);

        copiar.setBackground(new java.awt.Color(153, 220, 255));
        copiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Copy-32.png"))); // NOI18N
        copiar.setToolTipText("Copiar Grafo Seleccionado");
        copiar.setFocusable(false);
        copiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        copiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraHerramientas.add(copiar);

        pegar.setBackground(new java.awt.Color(153, 220, 255));
        pegar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Paste-32.png"))); // NOI18N
        pegar.setToolTipText("Pegar Grafo Seleccionado");
        pegar.setFocusable(false);
        pegar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pegar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraHerramientas.add(pegar);
        barraHerramientas.add(jSeparator3);

        arbol.setBackground(new java.awt.Color(153, 220, 255));
        arbol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Binary_tree_Icon_32.png"))); // NOI18N
        arbol.setToolTipText("Mostrar Árbol Binario");
        arbol.setBorderPainted(false);
        arbol.setFocusable(false);
        arbol.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        arbol.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        arbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arbolActionPerformed(evt);
            }
        });
        barraHerramientas.add(arbol);

        botcamin.setBackground(new java.awt.Color(153, 220, 255));
        botcamin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ciclos32.png"))); // NOI18N
        botcamin.setToolTipText("Mostrar Caminos o Ciclos");
        botcamin.setFocusable(false);
        botcamin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botcamin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botcamin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botcaminActionPerformed(evt);
            }
        });
        barraHerramientas.add(botcamin);

        botdiametro.setBackground(new java.awt.Color(153, 220, 255));
        botdiametro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regla32.png"))); // NOI18N
        botdiametro.setToolTipText("Mostrar Diámetro del Grafo");
        botdiametro.setBorderPainted(false);
        botdiametro.setFocusable(false);
        botdiametro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botdiametro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botdiametro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botdiametroActionPerformed(evt);
            }
        });
        barraHerramientas.add(botdiametro);
        barraHerramientas.add(jSeparator7);

        botbipartito.setBackground(new java.awt.Color(153, 220, 255));
        botbipartito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Bipartito32.png"))); // NOI18N
        botbipartito.setToolTipText("Mostar Grafo Bípartito");
        botbipartito.setBorderPainted(false);
        botbipartito.setFocusable(false);
        botbipartito.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botbipartito.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botbipartito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botbipartitoActionPerformed(evt);
            }
        });
        barraHerramientas.add(botbipartito);

        boteule.setBackground(new java.awt.Color(153, 220, 255));
        boteule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Eule32.png"))); // NOI18N
        boteule.setToolTipText("Mostrar Ciclos Eulerianos");
        boteule.setBorderPainted(false);
        boteule.setFocusable(false);
        boteule.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boteule.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boteule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boteuleActionPerformed(evt);
            }
        });
        barraHerramientas.add(boteule);

        bothami.setBackground(new java.awt.Color(153, 220, 255));
        bothami.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Hamilto32.png"))); // NOI18N
        bothami.setToolTipText("Mostrar Caminos Hamiltonianos");
        bothami.setBorderPainted(false);
        bothami.setFocusable(false);
        bothami.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bothami.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bothami.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bothamiActionPerformed(evt);
            }
        });
        barraHerramientas.add(bothami);

        barraHerramientas.setBounds(0, 0, 50, 630);
        jLayeredPane3.add(barraHerramientas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        barraHerramientas2.setBackground(new java.awt.Color(153, 220, 255));
        barraHerramientas2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        barraHerramientas2.setFloatable(false);
        barraHerramientas2.setForeground(new java.awt.Color(153, 220, 255));
        barraHerramientas2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        barraHerramientas2.setRollover(true);
        barraHerramientas2.setToolTipText("");
        barraHerramientas2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        rehacer.setBackground(new java.awt.Color(153, 220, 255));
        rehacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Button Next_32.png"))); // NOI18N
        rehacer.setToolTipText("Rehacer CTRL+Y");
        rehacer.setFocusable(false);
        rehacer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rehacer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraHerramientas2.add(rehacer);
        barraHerramientas2.add(jSeparator9);

        modificar.setBackground(new java.awt.Color(153, 220, 255));
        grupoPaleta.add(modificar);
        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/modificar.png"))); // NOI18N
        modificar.setSelected(true);
        modificar.setToolTipText("Modificar");
        modificar.setFocusable(false);
        modificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        modificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        barraHerramientas2.add(modificar);

        nodoNuevo.setBackground(new java.awt.Color(153, 220, 255));
        grupoPaleta.add(nodoNuevo);
        nodoNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/esfera.png"))); // NOI18N
        nodoNuevo.setToolTipText("Nuevo Nodo");
        nodoNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        nodoNuevo.setFocusable(false);
        nodoNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nodoNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nodoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nodoNuevoActionPerformed(evt);
            }
        });
        barraHerramientas2.add(nodoNuevo);

        borrarNodo.setBackground(new java.awt.Color(153, 220, 255));
        grupoPaleta.add(borrarNodo);
        borrarNodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/esfera2.png"))); // NOI18N
        borrarNodo.setToolTipText("Eliminar Nodo");
        borrarNodo.setFocusable(false);
        borrarNodo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        borrarNodo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        borrarNodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarNodoActionPerformed(evt);
            }
        });
        barraHerramientas2.add(borrarNodo);

        aristaNueva.setBackground(new java.awt.Color(153, 220, 255));
        grupoPaleta.add(aristaNueva);
        aristaNueva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/esfera3.png"))); // NOI18N
        aristaNueva.setToolTipText("Nueva Arista No Dirigida");
        aristaNueva.setFocusable(false);
        aristaNueva.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        aristaNueva.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        aristaNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aristaNuevaActionPerformed(evt);
            }
        });
        barraHerramientas2.add(aristaNueva);

        aristaDirNueva.setBackground(new java.awt.Color(153, 220, 255));
        grupoPaleta.add(aristaDirNueva);
        aristaDirNueva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/esfera4.png"))); // NOI18N
        aristaDirNueva.setToolTipText("Nueva Arista Dirigida");
        aristaDirNueva.setFocusable(false);
        aristaDirNueva.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        aristaDirNueva.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        aristaDirNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aristaDirNuevaActionPerformed(evt);
            }
        });
        barraHerramientas2.add(aristaDirNueva);

        borrarArista.setBackground(new java.awt.Color(153, 220, 255));
        grupoPaleta.add(borrarArista);
        borrarArista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/esfera5.png"))); // NOI18N
        borrarArista.setToolTipText("Eliminar Arista");
        borrarArista.setFocusable(false);
        borrarArista.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        borrarArista.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        borrarArista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarAristaActionPerformed(evt);
            }
        });
        barraHerramientas2.add(borrarArista);

        cambiarEtiqueta.setBackground(new java.awt.Color(153, 220, 255));
        grupoPaleta.add(cambiarEtiqueta);
        cambiarEtiqueta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/applix.png"))); // NOI18N
        cambiarEtiqueta.setToolTipText("Agregar/Cambiar Etiqueta");
        cambiarEtiqueta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cambiarEtiqueta.setFocusable(false);
        cambiarEtiqueta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cambiarEtiqueta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cambiarEtiqueta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarEtiquetaActionPerformed(evt);
            }
        });
        barraHerramientas2.add(cambiarEtiqueta);
        barraHerramientas2.add(jSeparator4);

        ordenar.setBackground(new java.awt.Color(153, 220, 255));
        ordenar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/kfouleggs.png"))); // NOI18N
        ordenar.setToolTipText("Ordenar nodos en forma circular");
        barraHerramientas2.add(ordenar);

        colorearGrafos.setBackground(new java.awt.Color(153, 220, 255));
        colorearGrafos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/color.png"))); // NOI18N
        colorearGrafos.setToolTipText("Colorear con 4 colores al Grafo");
        colorearGrafos.setFocusable(false);
        colorearGrafos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorearGrafos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraHerramientas2.add(colorearGrafos);

        VisorComplet.setBackground(new java.awt.Color(153, 220, 255));
        VisorComplet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/katomic.png"))); // NOI18N
        VisorComplet.setToolTipText("Visor Grafo Completo/Complementario");
        VisorComplet.setFocusable(false);
        VisorComplet.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        VisorComplet.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        VisorComplet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisorCompletActionPerformed(evt);
            }
        });
        barraHerramientas2.add(VisorComplet);
        barraHerramientas2.add(jSeparator11);

        Cuadricular.setBackground(new java.awt.Color(153, 220, 255));
        Cuadricular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Grid-32.png"))); // NOI18N
        Cuadricular.setToolTipText("Cuadricular Pantalla");
        Cuadricular.setFocusable(false);
        Cuadricular.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Cuadricular.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Cuadricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuadricularActionPerformed(evt);
            }
        });
        barraHerramientas2.add(Cuadricular);

        vermatriz1.setBackground(new java.awt.Color(153, 220, 255));
        vermatriz1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/appointment.png"))); // NOI18N
        vermatriz1.setToolTipText("Mostar Matriz");
        vermatriz1.setFocusable(false);
        vermatriz1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        vermatriz1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        vermatriz1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vermatriz1ActionPerformed(evt);
            }
        });
        barraHerramientas2.add(vermatriz1);
        barraHerramientas2.add(jSeparator6);

        BotDijkstra.setBackground(new java.awt.Color(153, 220, 255));
        BotDijkstra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/algoritmonD32.png"))); // NOI18N
        BotDijkstra.setToolTipText("Aplicar algoritmo Dijkstra");
        BotDijkstra.setBorderPainted(false);
        BotDijkstra.setFocusable(false);
        BotDijkstra.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        BotDijkstra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotDijkstra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotDijkstraActionPerformed(evt);
            }
        });
        barraHerramientas2.add(BotDijkstra);

        BotKruska.setBackground(new java.awt.Color(153, 220, 255));
        BotKruska.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/algoritmonK32.png"))); // NOI18N
        BotKruska.setToolTipText("Aplicar algoritmo Kruskal");
        BotKruska.setBorderPainted(false);
        BotKruska.setFocusable(false);
        BotKruska.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotKruska.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotKruska.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotKruskaActionPerformed(evt);
            }
        });
        barraHerramientas2.add(BotKruska);

        botprim.setBackground(new java.awt.Color(153, 220, 255));
        botprim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/algoritmonP32.png"))); // NOI18N
        botprim.setToolTipText("Aplicar algoritmo Prim");
        botprim.setBorderPainted(false);
        botprim.setFocusable(false);
        botprim.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botprim.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botprim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botprimActionPerformed(evt);
            }
        });
        barraHerramientas2.add(botprim);

        barraHerramientas2.setBounds(50, 0, 50, 630);
        jLayeredPane3.add(barraHerramientas2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane3.setBounds(0, 0, 100, 630);
        jLayeredPane4.add(jLayeredPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        baseDerecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        baseDerecha.setPreferredSize(new java.awt.Dimension(600, 375));
        baseDerecha.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        frameDibujo.setBackground(new java.awt.Color(255, 255, 255));
        frameDibujo.setBorder(null);
        frameDibujo.setClosable(true);
        frameDibujo.setAutoscrolls(true);
        frameDibujo.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Page-16.png"))); // NOI18N
        frameDibujo.setPreferredSize(new java.awt.Dimension(900, 625));
        frameDibujo.setVisible(true);
        frameDibujo.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                frameDibujoInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        frameDibujo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frameDibujoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(frameDibujo);
        try {
            frameDibujo.setIcon(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jScrollPane1.setBounds(0, 0, 650, 625);
        jLayeredPane2.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        baseIzquierda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        baseIzquierda.setPreferredSize(new java.awt.Dimension(300, 600));

        Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Button Reload_16.png"))); // NOI18N
        Actualizar.setText("Actualizar");

        AutoActualizar.setSelected(true);
        AutoActualizar.setToolTipText("Mantener siempre actualizado");
        AutoActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutoActualizarActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "¿Usar algún algoritmo?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 153, 153)));

        jLabel1.setText("Dijkstra :");

        AlPrim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/algoritmonP16.png"))); // NOI18N
        AlPrim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlPrimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(AlPrim, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(AlPrim, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Kruskal:");

        jLabel3.setText("Prim:");

        Kruskal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/algoritmonK16.png"))); // NOI18N
        Kruskal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KruskalActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/algoritmonD16.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Kruskal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Kruskal, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información Grafo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 153, 153)));

        eulerians.setText("Euleriano : No");

        hamilt.setText("Hamiltoniano : No");

        completo.setText("Completo : No");

        conexo.setText("Conexo : No");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        BuscarBipartito.setText("Bipartito : No");

        Dirigidos.setText("Dirigido : No");

        CicloHamilt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Hamilto16.png"))); // NOI18N
        CicloHamilt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CicloHamiltActionPerformed(evt);
            }
        });

        Bipartito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Bipartito16.png"))); // NOI18N
        Bipartito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BipartitoActionPerformed(evt);
            }
        });

        CicloEulerians.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Eule16.png"))); // NOI18N
        CicloEulerians.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CicloEuleriansActionPerformed(evt);
            }
        });

        conexo87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/caminos16.png"))); // NOI18N
        conexo87.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conexo87ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(conexo87, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BuscarBipartito)
                                    .addComponent(Bipartito, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(conexo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hamilt, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eulerians, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CicloHamilt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CicloEulerians, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(completo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Dirigidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BuscarBipartito)
                    .addComponent(eulerians))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Bipartito, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CicloEulerians, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conexo)
                    .addComponent(hamilt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(conexo87, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CicloHamilt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(completo)
                    .addComponent(Dirigidos))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablagrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.Short.class, java.lang.Short.class, java.lang.Short.class, java.lang.Short.class, java.lang.Short.class, java.lang.Short.class, java.lang.Short.class, java.lang.Short.class, java.lang.Short.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablagrados.setToolTipText("");
        tablagrados.setColumnSelectionAllowed(true);
        tablagrados.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablagrados);
        tablagrados.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablagrados.getColumnModel().getColumn(0).setResizable(false);
        tablagrados.getColumnModel().getColumn(1).setResizable(false);
        tablagrados.getColumnModel().getColumn(2).setResizable(false);
        tablagrados.getColumnModel().getColumn(3).setResizable(false);
        tablagrados.getColumnModel().getColumn(4).setResizable(false);
        tablagrados.getColumnModel().getColumn(5).setResizable(false);
        tablagrados.getColumnModel().getColumn(6).setResizable(false);
        tablagrados.getColumnModel().getColumn(7).setResizable(false);
        tablagrados.getColumnModel().getColumn(8).setResizable(false);
        tablagrados.getColumnModel().getColumn(9).setResizable(false);

        jLabel5.setText(" Entrada");

        jLabel6.setText(" Salida");

        jLabel7.setText("Tabla de Grados");

        jLabel8.setText("Matriz de Adyacencias");

        javax.swing.GroupLayout baseIzquierdaLayout = new javax.swing.GroupLayout(baseIzquierda);
        baseIzquierda.setLayout(baseIzquierdaLayout);
        baseIzquierdaLayout.setHorizontalGroup(
            baseIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseIzquierdaLayout.createSequentialGroup()
                .addGroup(baseIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(baseIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, baseIzquierdaLayout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(baseIzquierdaLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(baseIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(baseIzquierdaLayout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(Actualizar)
                                    .addGap(18, 18, 18)
                                    .addComponent(AutoActualizar))
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(baseIzquierdaLayout.createSequentialGroup()
                        .addGroup(baseIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(baseIzquierdaLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, baseIzquierdaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        baseIzquierdaLayout.setVerticalGroup(
            baseIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseIzquierdaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(5, 5, 5)
                .addGroup(baseIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(baseIzquierdaLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(baseIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AutoActualizar)))
        );

        tabla.addTab("Información", baseIzquierda);

        tabla.setBounds(650, 0, 250, 630);
        jLayeredPane2.add(tabla, javax.swing.JLayeredPane.DEFAULT_LAYER);

        baseDerecha.add(jLayeredPane2, java.awt.BorderLayout.CENTER);

        baseDerecha.setBounds(0, 0, 910, 630);
        jLayeredPane5.add(baseDerecha, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane5.setBounds(100, 0, 910, 630);
        jLayeredPane4.add(jLayeredPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        mensajeAcciones.setBackground(new java.awt.Color(240, 240, 240));
        mensajeAcciones.setBorder(null);
        mensajeAcciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mensajeAcciones.setMinimumSize(new java.awt.Dimension(300, 20));
        mensajeAcciones.setPreferredSize(new java.awt.Dimension(300, 20));
        mensajeAcciones.setRequestFocusEnabled(false);
        mensajeAcciones.setEditable(false);
        mensajeAcciones.setBounds(670, 630, 330, 25);
        jLayeredPane4.add(mensajeAcciones, javax.swing.JLayeredPane.DEFAULT_LAYER);
        progresoAcciones.setBounds(100, 632, 160, 15);
        jLayeredPane4.add(progresoAcciones, javax.swing.JLayeredPane.DEFAULT_LAYER);

        mensaje2.setText("   PROCESO...");
        mensaje2.setBounds(10, 630, 90, 20);
        jLayeredPane4.add(mensaje2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        basePrincipal.add(jLayeredPane4, java.awt.BorderLayout.CENTER);

        getContentPane().add(basePrincipal, java.awt.BorderLayout.CENTER);

        barraMenuPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barraMenuPrincipal.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraMenuPrincipalMouseDragged(evt);
            }
        });

        menuArchivo.setText("Archivo");

        menuNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Page-16.png"))); // NOI18N
        menuNuevo.setText("Nuevo Grafo");
        menuNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuArchivo.add(menuNuevo);

        menuAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Folder-16.png"))); // NOI18N
        menuAbrir.setText("Abrir grafo");
        menuAbrir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuArchivo.add(menuAbrir);
        menuArchivo.add(jSeparator13);

        menuGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Download-16.png"))); // NOI18N
        menuGuardar.setText("Guardar");
        menuGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuArchivo.add(menuGuardar);

        menuGuardarComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuGuardarComo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/guardarcomo16.png"))); // NOI18N
        menuGuardarComo.setText("Guardar Como...");
        menuGuardarComo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuArchivo.add(menuGuardarComo);

        guardarimagen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        guardarimagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/camera_16.png"))); // NOI18N
        guardarimagen.setText("Guardar Imagen Como...");
        guardarimagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarimagenActionPerformed(evt);
            }
        });
        menuArchivo.add(guardarimagen);
        menuArchivo.add(jSeparator14);

        Imprimir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        Imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Print_16.png"))); // NOI18N
        Imprimir.setText("Imprimir...");
        Imprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuArchivo.add(Imprimir);

        configurarPagina.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        configurarPagina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Print_setup16.png"))); // NOI18N
        configurarPagina.setText("Configurar Pagina...");
        configurarPagina.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuArchivo.add(configurarPagina);
        menuArchivo.add(jSeparator15);

        menuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        menuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Delete_16.png"))); // NOI18N
        menuSalir.setText("Salir");
        menuSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(menuSalir);

        barraMenuPrincipal.add(menuArchivo);

        menuEditar.setText("Editar");

        menuDeshacer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        menuDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Button Previous_16.png"))); // NOI18N
        menuDeshacer.setText("Deshacer");
        menuDeshacer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuEditar.add(menuDeshacer);

        menuRehacer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        menuRehacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Button Next_16.png"))); // NOI18N
        menuRehacer.setText("Rehacer");
        menuRehacer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuEditar.add(menuRehacer);
        menuEditar.add(jSeparator8);

        buttonbarra.add(BarSelec);
        BarSelec.setSelected(true);
        BarSelec.setText("Mouse Selecionador");
        BarSelec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/modificar16.png"))); // NOI18N
        BarSelec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarSelecActionPerformed(evt);
            }
        });
        menuEditar.add(BarSelec);

        editVertices.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/exec16.png"))); // NOI18N
        editVertices.setText("Editar Nodos");

        buttonbarra.add(BarAgregavertice);
        BarAgregavertice.setText("Agregar Nodo");
        BarAgregavertice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/esfera16.png"))); // NOI18N
        BarAgregavertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarAgregaverticeActionPerformed(evt);
            }
        });
        editVertices.add(BarAgregavertice);

        buttonbarra.add(BarEliminavertice);
        BarEliminavertice.setText("Eliminar Nodo");
        BarEliminavertice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/esfera216.png"))); // NOI18N
        BarEliminavertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarEliminaverticeActionPerformed(evt);
            }
        });
        editVertices.add(BarEliminavertice);

        editNodo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/editar16.png"))); // NOI18N
        editNodo1.setText("Editar Propiedades del Nodo");
        editNodo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editNodo1ActionPerformed(evt);
            }
        });
        editVertices.add(editNodo1);

        menuEditar.add(editVertices);

        EditArista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/exec16.png"))); // NOI18N
        EditArista.setText("Editar Aristas");

        buttonbarra.add(BarAgregaArista);
        BarAgregaArista.setText("Agregar Arista No Dirigida");
        BarAgregaArista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/esfera316.png"))); // NOI18N
        BarAgregaArista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarAgregaAristaActionPerformed(evt);
            }
        });
        EditArista.add(BarAgregaArista);

        buttonbarra.add(BaragreArisDir);
        BaragreArisDir.setText("Agragar Arista Dirigida");
        BaragreArisDir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/esfera416.png"))); // NOI18N
        BaragreArisDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaragreArisDirActionPerformed(evt);
            }
        });
        EditArista.add(BaragreArisDir);

        buttonbarra.add(BarElimiArista);
        BarElimiArista.setText("Eliminar Arista");
        BarElimiArista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/esfera516.png"))); // NOI18N
        BarElimiArista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarElimiAristaActionPerformed(evt);
            }
        });
        EditArista.add(BarElimiArista);

        editarista1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/editar16.png"))); // NOI18N
        editarista1.setText("Editar Propiedades Arista");
        editarista1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarista1ActionPerformed(evt);
            }
        });
        EditArista.add(editarista1);

        menuEditar.add(EditArista);
        menuEditar.add(jSeparator16);

        MenuCortar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        MenuCortar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Cut-16.png"))); // NOI18N
        MenuCortar.setText("Cortar");
        MenuCortar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuEditar.add(MenuCortar);

        MenuCopiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        MenuCopiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Copy-16.png"))); // NOI18N
        MenuCopiar.setText("Copiar");
        MenuCopiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuEditar.add(MenuCopiar);

        MenuPegar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        MenuPegar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Paste-16.png"))); // NOI18N
        MenuPegar.setText("Pegar");
        MenuPegar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuEditar.add(MenuPegar);

        EliminDatos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        EliminDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/papelera16.png"))); // NOI18N
        EliminDatos.setText("Elliminar  datos Selecionados");
        menuEditar.add(EliminDatos);
        menuEditar.add(jSeparator12);

        barraMenuPrincipal.add(menuEditar);

        Ver.setText("Ver");

        cuadri.setText("Mostrar Fondo Cuadriculado");
        cuadri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Grid-16.png"))); // NOI18N
        cuadri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuadriActionPerformed(evt);
            }
        });
        Ver.add(cuadri);

        AreaPunteada.setText("Mostrar Fondo Punteado");
        AreaPunteada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/punteada16.png"))); // NOI18N
        AreaPunteada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AreaPunteadaActionPerformed(evt);
            }
        });
        Ver.add(AreaPunteada);

        MostarMatriz.setText("Mostrar Matriz de datos");
        MostarMatriz.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MostarMatriz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/matriz16.png"))); // NOI18N
        MostarMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostarMatrizActionPerformed(evt);
            }
        });
        Ver.add(MostarMatriz);
        Ver.add(jSeparator18);

        InfoPuntos.setText("Desactivar Información Punto");
        InfoPuntos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        InfoPuntos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Flag-blue-16.png"))); // NOI18N
        Ver.add(InfoPuntos);

        ocultapesoaris.setText("Desactivar Información de los Pesos de la Aristas");
        ocultapesoaris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Flag-blue-16.png"))); // NOI18N
        ocultapesoaris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ocultapesoarisActionPerformed(evt);
            }
        });
        Ver.add(ocultapesoaris);

        barraMenuPrincipal.add(Ver);

        herramientas.setText("Herramientas");

        menuActualizar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        menuActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Button Reload_16.png"))); // NOI18N
        menuActualizar.setText("Actualizar");
        menuActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        herramientas.add(menuActualizar);
        herramientas.add(jSeparator19);

        menuOrdenar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        menuOrdenar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ordenar16.png"))); // NOI18N
        menuOrdenar.setText("Ordenar");
        menuOrdenar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        herramientas.add(menuOrdenar);

        virgraf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/completar16.png"))); // NOI18N
        virgraf.setText("Visor Grafo Completo/Complementario");
        herramientas.add(virgraf);

        barColorear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/color16.png"))); // NOI18N
        barColorear.setText("Colorear Grafo");
        herramientas.add(barColorear);

        bardiam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/regla16.png"))); // NOI18N
        bardiam.setText("Obtener Diámetro del Garfo");
        bardiam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bardiamActionPerformed(evt);
            }
        });
        herramientas.add(bardiam);

        barArbin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Binary_tree_Icon_16.png"))); // NOI18N
        barArbin.setText("Obtener Árbol Binario");
        barArbin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barArbinActionPerformed(evt);
            }
        });
        herramientas.add(barArbin);

        barraMenuPrincipal.add(herramientas);

        Algoritmos.setText("Algoritmos");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/algoritmonD16.png"))); // NOI18N
        jMenuItem1.setText("Aplicar algoritmo Dijkstra");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Algoritmos.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/algoritmonK16.png"))); // NOI18N
        jMenuItem2.setText("Aplicar algoritmo Kruskal");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Algoritmos.add(jMenuItem2);

        barPrim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/algoritmonP16.png"))); // NOI18N
        barPrim.setText("Aplicar algoritmo Prim");
        barPrim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barPrimActionPerformed(evt);
            }
        });
        Algoritmos.add(barPrim);
        Algoritmos.add(jSeparator5);

        barcamci.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ciclos16.png"))); // NOI18N
        barcamci.setText("Mostrar Caminos o Ciclos");
        Algoritmos.add(barcamci);

        BarBipartito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Bipartito16.png"))); // NOI18N
        BarBipartito.setText("Mostrar Grafo Bipartito");
        BarBipartito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarBipartitoActionPerformed(evt);
            }
        });
        Algoritmos.add(BarBipartito);

        barEule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Eule16.png"))); // NOI18N
        barEule.setText("Mostrar Ciclos Eulerianos");
        barEule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barEuleActionPerformed(evt);
            }
        });
        Algoritmos.add(barEule);

        conex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/caminos16.png"))); // NOI18N
        conex.setText("Mostrar el Gardo de Conexo");
        conex.setToolTipText("");
        conex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conexActionPerformed(evt);
            }
        });
        Algoritmos.add(conex);

        barhamil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Hamilto16.png"))); // NOI18N
        barhamil.setText("Mostrar Caminos Hamiltonianos");
        barhamil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barhamilActionPerformed(evt);
            }
        });
        Algoritmos.add(barhamil);

        barraMenuPrincipal.add(Algoritmos);

        menuAyuda.setText("Ayuda");

        menuItemAyuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        menuItemAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Help-16.png"))); // NOI18N
        menuItemAyuda.setText("Manual de Ayuda");
        menuItemAyuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuItemAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAyudaActionPerformed(evt);
            }
        });
        menuAyuda.add(menuItemAyuda);

        Acerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/logoU16.png"))); // NOI18N
        Acerca.setText("Acerca de");
        Acerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcercaActionPerformed(evt);
            }
        });
        menuAyuda.add(Acerca);

        barraMenuPrincipal.add(menuAyuda);

        setJMenuBar(barraMenuPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void frameDibujoInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_frameDibujoInternalFrameClosed
        cerrarFrame();
        file=null;
        archivo=false;
    }//GEN-LAST:event_frameDibujoInternalFrameClosed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
    
        if(abierto==true)
        { 
            if(JOptionPane.showConfirmDialog(null, "¿Esta seguro de cerrar el Programa?\n"
                                    + "cualquier dato no guardado se perdera")==JOptionPane.YES_OPTION){
                System.exit(0);
            }
           
        }
        else{
            System.exit(0);
        }
    }//GEN-LAST:event_menuSalirActionPerformed

    private void barraMenuPrincipalMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraMenuPrincipalMouseDragged
 
    }//GEN-LAST:event_barraMenuPrincipalMouseDragged

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       
    }//GEN-LAST:event_formWindowActivated

    private void frameDibujoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frameDibujoMouseClicked
      
    }//GEN-LAST:event_frameDibujoMouseClicked

    private void vermatriz1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vermatriz1ActionPerformed
       if(vermatriz1.isSelected()){
                tabla.setVisible(true);
                MostarMatriz.setSelected(true);
                jScrollPane1.setBounds(0, 0, 650, 625);
        }
        else{
                tabla.setVisible(false);
                MostarMatriz.setSelected(false);
                jScrollPane1.setBounds(0, 0, 905, 625);
          }
        repaint(); 
    }//GEN-LAST:event_vermatriz1ActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        if(modificar.isSelected()){
            BarSelec.setSelected(true);
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void nodoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nodoNuevoActionPerformed
            if(nodoNuevo.isSelected()){
            BarAgregavertice.setSelected(true);
        }
    }//GEN-LAST:event_nodoNuevoActionPerformed

    private void CuadricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuadricularActionPerformed
       if(Cuadricular.isSelected()){
            cuadri.setSelected(true);
        }
        else{
                cuadri.setSelected(false);
        }
        AreaDibujo.lienzo.repaint(); 
    }//GEN-LAST:event_CuadricularActionPerformed

    private void menuItemAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAyudaActionPerformed
        try{
            //File directorio = new File("temp"); //Creas un nuevo directorio a nivel de tu jar.
            //directorio.mkdirs();
            //directorio.setWritable(true);
            //copias la direccion
            String archivo = "ayuda.pdf";
            //nuevo archivo en esa direccion
            File temp = new File(archivo);
            InputStream is = this.getClass().getResourceAsStream("/PDFs/ayuda.pdf");
            FileOutputStream archivoDestino = new FileOutputStream(temp);
            FileWriter fw = new FileWriter(temp);
            byte[] buffer = new byte[512*1024];
            //lees el archivo hasta que se acabe...
            int nbLectura;
            while ((nbLectura = is.read(buffer)) != -1)
            archivoDestino.write(buffer, 0, nbLectura);
            //cierras el archivo,el inputS y el FileW
            fw.close();
            archivoDestino.close();
            is.close();
            //abres el archivo temporal
            Desktop.getDesktop().open(temp);
        } catch (IOException ex) {
            System.out.println("Problema abriendo el pdf");
        }
    }//GEN-LAST:event_menuItemAyudaActionPerformed

    private void ocultapesoarisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ocultapesoarisActionPerformed
        if(!Interfaz.ocultapesoaris.isSelected()){
            AreaDibujo.lienzo.paintComponent(AreaDibujo.lienzo.getGraphics());
        }
        else{
            AreaDibujo.lienzo.repaint();
        }
    }//GEN-LAST:event_ocultapesoarisActionPerformed

    private void MostarMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostarMatrizActionPerformed
        if(MostarMatriz.isSelected()){
                tabla.setVisible(true);
                vermatriz1.setSelected(true);
                jScrollPane1.setBounds(0, 0, 650, 625);
        }
        else{
                tabla.setVisible(false);
                vermatriz1.setSelected(false);
                jScrollPane1.setBounds(0, 0, 905, 625);
        }
        repaint();
    }//GEN-LAST:event_MostarMatrizActionPerformed

    private void AreaPunteadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AreaPunteadaActionPerformed
        AreaDibujo.lienzo.repaint();
    }//GEN-LAST:event_AreaPunteadaActionPerformed

    private void cuadriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuadriActionPerformed
        
        if(cuadri.isSelected()){
            Cuadricular.setSelected(true);
        }
        else{
                Cuadricular.setSelected(false);
        }
        AreaDibujo.lienzo.repaint();
    }//GEN-LAST:event_cuadriActionPerformed

    private void AcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcercaActionPerformed
        Informacion Desarrolladores = new Informacion(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_AcercaActionPerformed

    private void BarAgregaverticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarAgregaverticeActionPerformed
        if(BarAgregavertice.isSelected()){
            nodoNuevo.setSelected(true);
        }
    }//GEN-LAST:event_BarAgregaverticeActionPerformed

    private void BarEliminaverticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarEliminaverticeActionPerformed
        if(BarEliminavertice.isSelected()){
            borrarNodo.setSelected(true);
        }
    }//GEN-LAST:event_BarEliminaverticeActionPerformed

    private void borrarNodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarNodoActionPerformed
        if(borrarNodo.isSelected()){
            BarEliminavertice.setSelected(true);
        }
    }//GEN-LAST:event_borrarNodoActionPerformed

    private void BarSelecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarSelecActionPerformed
        if(BarSelec.isSelected()){
            modificar.setSelected(true);
        }
    }//GEN-LAST:event_BarSelecActionPerformed

    private void cambiarEtiquetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarEtiquetaActionPerformed
        if(cambiarEtiqueta.isSelected()){
        }
    }//GEN-LAST:event_cambiarEtiquetaActionPerformed

    private void BarAgregaAristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarAgregaAristaActionPerformed
        if(BarAgregaArista.isSelected()){
            aristaNueva.setSelected(true);
        }
    }//GEN-LAST:event_BarAgregaAristaActionPerformed

    private void aristaNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aristaNuevaActionPerformed
        if(aristaNueva.isSelected()){
            BarAgregaArista.setSelected(true);
        }
    }//GEN-LAST:event_aristaNuevaActionPerformed

    private void BaragreArisDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaragreArisDirActionPerformed
        if(BaragreArisDir.isSelected()){
            aristaDirNueva.setSelected(true);
        }
    }//GEN-LAST:event_BaragreArisDirActionPerformed

    private void aristaDirNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aristaDirNuevaActionPerformed
        if(aristaDirNueva.isSelected()){
            BaragreArisDir.setSelected(true);
        }
    }//GEN-LAST:event_aristaDirNuevaActionPerformed

    private void BarElimiAristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarElimiAristaActionPerformed
        if(BarElimiArista.isSelected()){
            borrarArista.setSelected(true);
        }
    }//GEN-LAST:event_BarElimiAristaActionPerformed

    private void borrarAristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarAristaActionPerformed
        if(borrarArista.isSelected()){
            BarElimiArista.setSelected(true);
        }
    }//GEN-LAST:event_borrarAristaActionPerformed

    private void guardarimagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarimagenActionPerformed
 
                  Timer t=new Timer();
		TimerTask timerTask = new TimerTask() 
	        { 
                    @Override
	            public void run()  
	            { 
                     Captura cap=new Captura(frameDibujo);
	            } 
	        }; 
 
		t.schedule(timerTask,100);

    }//GEN-LAST:event_guardarimagenActionPerformed

    private void BotDijkstraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotDijkstraActionPerformed
       CaminoDijkstra camm= new CaminoDijkstra(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_BotDijkstraActionPerformed

    private void ScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScreenActionPerformed

    }//GEN-LAST:event_ScreenActionPerformed

    private void ScreenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScreenMouseClicked

        if(Screen.isEnabled()==true)
        {
            Timer t=new Timer();
            TimerTask timerTask = new TimerTask()
            {
                @Override
                public void run()
                {
                    Captura cap=new Captura(frameDibujo);
                }
            };

            t.schedule(timerTask,100);
        }
    }//GEN-LAST:event_ScreenMouseClicked

    private void VisorCompletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisorCompletActionPerformed
    completar();
    }//GEN-LAST:event_VisorCompletActionPerformed

    private void BotKruskaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotKruskaActionPerformed
        Kruskal Arbol= new Kruskal(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_BotKruskaActionPerformed

    private void botbipartitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botbipartitoActionPerformed
       Bipartito bipartito = new Bipartito(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_botbipartitoActionPerformed

    private void BarBipartitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarBipartitoActionPerformed
        Bipartito bipartito = new Bipartito(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_BarBipartitoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        CaminoDijkstra camm= new CaminoDijkstra(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Kruskal Arbol= new Kruskal(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void boteuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boteuleActionPerformed
        CicloEuleriano Indica= new CicloEuleriano(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_boteuleActionPerformed

    private void barEuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barEuleActionPerformed
        CicloEuleriano Indica= new CicloEuleriano(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_barEuleActionPerformed

    private void bothamiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bothamiActionPerformed
       CicloHalmitoneano VamosDibuja= new CicloHalmitoneano(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_bothamiActionPerformed

    private void barhamilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barhamilActionPerformed
        CicloHalmitoneano VamosDibuja= new CicloHalmitoneano(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_barhamilActionPerformed

    private void botdiametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botdiametroActionPerformed
       Diametro Diam = new Diametro(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_botdiametroActionPerformed

    private void botcaminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botcaminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botcaminActionPerformed

    private void CicloEuleriansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CicloEuleriansActionPerformed
        CicloEuleriano Indica= new CicloEuleriano(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_CicloEuleriansActionPerformed

    private void BipartitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BipartitoActionPerformed
        Bipartito bipartito = new Bipartito(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_BipartitoActionPerformed

    private void CicloHamiltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CicloHamiltActionPerformed
        CicloHalmitoneano VamosDibuja= new CicloHalmitoneano(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_CicloHamiltActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CaminoDijkstra caminn =  new CaminoDijkstra(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void KruskalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KruskalActionPerformed
        Kruskal Arbol= new Kruskal(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_KruskalActionPerformed

    private void AutoActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutoActualizarActionPerformed
        if(AutoActualizar.isSelected())
        {
            JOptionPane.showMessageDialog(null,"Al activar esta opción el rendimiento de ejecución puede variar.","Advertencia",JOptionPane.PLAIN_MESSAGE);
            AreaDibujo.matrizMostrada.actionPerformed(null);
        }
    }//GEN-LAST:event_AutoActualizarActionPerformed

    private void editNodo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editNodo1ActionPerformed
      EditPuntos editpuntos=new EditPuntos(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_editNodo1ActionPerformed

    private void editarista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarista1ActionPerformed
   EditAristas editarista=new EditAristas(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_editarista1ActionPerformed

    private void botprimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botprimActionPerformed
         Prim prim= new Prim(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_botprimActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(abierto==true)
        { 
            if(JOptionPane.showConfirmDialog(null, "¿Esta seguro de cerrar el Programa?\n"
                                    + "cualquier dato no guardado se perdera")==JOptionPane.YES_OPTION){
                System.exit(0);
            }
           
        }
        else{
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void bardiamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bardiamActionPerformed
         Diametro Diam = new Diametro(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_bardiamActionPerformed

    private void conexo87ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conexo87ActionPerformed
       
        if("Conexo : Si".equals(conexo.getText())&& AreaDibujo.aristas[0].esDirigida()==true){
            JOptionPane.showMessageDialog(null,"El Grafo es Fuertemente Conexo","",JOptionPane.INFORMATION_MESSAGE);  
        } 
        
        if("Conexo : Si".equals(conexo.getText())&& AreaDibujo.aristas[0].esDirigida()==false  && "Hamiltoniano : Si".equals(hamilt.getText())==false){
            JOptionPane.showMessageDialog(null,"El Grafo es Débilmente Conexo","",JOptionPane.INFORMATION_MESSAGE); 
            
        }
        if("Conexo : Si".equals(conexo.getText())&& AreaDibujo.aristas[0].esDirigida()==false  && "Hamiltoniano : Si".equals(hamilt.getText())==true){
            JOptionPane.showMessageDialog(null,"El Grafo es Fuertemente Conexo","",JOptionPane.INFORMATION_MESSAGE);  
        }
        
    }//GEN-LAST:event_conexo87ActionPerformed

    private void AlPrimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlPrimActionPerformed
        Prim prim= new Prim(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_AlPrimActionPerformed

    private void barPrimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barPrimActionPerformed
        Prim prim= new Prim(new javax.swing.JFrame(), true);
    }//GEN-LAST:event_barPrimActionPerformed

    private void conexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conexActionPerformed
       
        
        if("Conexo : Si".equals(conexo.getText())&& AreaDibujo.aristas[0].esDirigida()==true){
            JOptionPane.showMessageDialog(null,"El Grafo es Fuertemente Conexo","",JOptionPane.INFORMATION_MESSAGE);  
        } 
        
        if("Conexo : Si".equals(conexo.getText())&& AreaDibujo.aristas[0].esDirigida()==false  && "Hamiltoniano : Si".equals(hamilt.getText())==false){
            JOptionPane.showMessageDialog(null,"El Grafo es Débilmente Conexo","",JOptionPane.INFORMATION_MESSAGE); 
            
        }
        if("Conexo : Si".equals(conexo.getText())&& AreaDibujo.aristas[0].esDirigida()==false  && "Hamiltoniano : Si".equals(hamilt.getText())==true){
            JOptionPane.showMessageDialog(null,"El Grafo es Fuertemente Conexo","",JOptionPane.INFORMATION_MESSAGE);  
        }
        
   
    }//GEN-LAST:event_conexActionPerformed

    private void arbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arbolActionPerformed
       if("Conexo : Si".equals(conexo.getText()) && areaDibujo.indicePuntos>=1 && AreaDibujo.aristas[0].esDirigida()==false&&areaDibujo.gradoArbol()==true && "Hamiltoniano : Si".equals(hamilt.getText())==false){
          JOptionPane.showMessageDialog(null,"Es Arbol Binario.","Advertencia",JOptionPane.PLAIN_MESSAGE);           
            Arbol Arb = new Arbol(new javax.swing.JFrame(), true);  
        }
      else{
      JOptionPane.showMessageDialog(null,"No es Arbol Binario, no cumple con los requerimientos.","Advertencia",JOptionPane.PLAIN_MESSAGE); 
     }
    }//GEN-LAST:event_arbolActionPerformed

    private void barArbinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barArbinActionPerformed
        if("Conexo : Si".equals(conexo.getText()) && areaDibujo.indicePuntos>=1 && AreaDibujo.aristas[0].esDirigida()==false&&areaDibujo.gradoArbol()==true && "Hamiltoniano : Si".equals(hamilt.getText())==false){
          JOptionPane.showMessageDialog(null,"Es Arbol Binario.","Advertencia",JOptionPane.PLAIN_MESSAGE);           
            Arbol Arb = new Arbol(new javax.swing.JFrame(), true);  
        }
      else{
      JOptionPane.showMessageDialog(null,"No es Arbol Binario, no cumple con los requerimientos.","Advertencia",JOptionPane.PLAIN_MESSAGE); 
     }
    }//GEN-LAST:event_barArbinActionPerformed


    public void cerrarFrame(){
       
        if(JOptionPane.showConfirmDialog(null, "¿Esta seguro de cerrar el archivo?\n"
                                    + "cualquier dato no guardado se perdera")==JOptionPane.YES_OPTION){
            
            abierto=false;
            areaDibujo.limpiarArea();
            areaDibujo.grafo.destruirGrafo();
            
            areaDibujo.matrizMostrada.actualizarMatriz();
            if(areaDibujo.grafo.getMatriz()[0][1]!=-1){
                if(areaDibujo.matrizMostrada.esConexo()==true){
                   conexo.setText("Conexo : Si");
                } else {
                    conexo.setText("Conexo : No");
                }
            } else {
                conexo.setText("Conexo : No");
            }
            progresoAcciones.setValue(150);
            Rectangle rc=Interfaz.progresoAcciones.getBounds();
            rc.x=0;
            rc.y=0;
            Interfaz.progresoAcciones.paintImmediately(rc);
            try {
                Thread.sleep(120);
            } catch (InterruptedException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
            areaDibujo.desactivar();
            progresoAcciones.setValue(0);
            areaDibujo.pilaDeshacer.vaciar();
            areaDibujo.pilaRehacer.vaciar();
            guardarArchivo.setEnabled(false);
            guardarimagen.setEnabled(false);
            borrarArista.setEnabled(false);
            BarElimiArista.setEnabled(false);
            nodoNuevo.setEnabled(false);
            aristaNueva.setEnabled(false);
            aristaDirNueva.setEnabled(false);
            BaragreArisDir.setEnabled(false);
            BarAgregaArista.setEnabled(false);
            cambiarEtiqueta.setEnabled(false);
            configurarPagina.setEnabled(false);
            imprimir.setEnabled(false);
            Imprimir.setEnabled(false);
            ordenar.setEnabled(false);
            tabla.setVisible(false);
            jScrollPane1.setBounds(0, 0, 905, 625);
            boteule.setEnabled(false);
            barEule.setEnabled(false);
            barhamil.setEnabled(false);
            bothami.setEnabled(false);
            botbipartito.setEnabled(false);
            BarBipartito.setEnabled(false);
            Bipartito.setEnabled(false);
            jMenuItem2.setEnabled(false);
            BotKruska.setEnabled(false);
            VisorComplet.setEnabled(false);
            colorearGrafos.setEnabled(false);
            deshacer.setEnabled(false);
            rehacer.setEnabled(false);
            menuDeshacer.setEnabled(false);
            menuRehacer.setEnabled(false);
            Screen.setEnabled(false);
            MenuCortar.setEnabled(false);
            MenuCopiar.setEnabled(false);
            MenuPegar.setEnabled(false);
            cortar.setEnabled(false);
            copiar.setEnabled(false);
            pegar.setEnabled(false);
            progresoAcciones.setStringPainted(true);
            BotDijkstra.setEnabled(false);
            jButton2.setEnabled(false);
            vermatriz1.setEnabled(false);
            Cuadricular.setEnabled(false);
            botprim.setEnabled(false);
            botdiametro.setEnabled(false);
            bardiam.setEnabled(false);
            botcamin.setEnabled(false);
            arbol.setEnabled(false);
            editNodo1.setEnabled(false);
            editarista1.setEnabled(false);
            menuGuardarComo.setEnabled(false);
            menuGuardar.setEnabled(false);
            BarAgregavertice.setEnabled(false);
            BarEliminavertice.setEnabled(false);
            cuadri.setEnabled(false);
            AreaPunteada.setEnabled(false);
            MostarMatriz.setEnabled(false);
            barColorear.setEnabled(false);
            jMenuItem1.setEnabled(false);
            virgraf.setEnabled(false);
            menuOrdenar.setEnabled(false);
            menuActualizar.setEnabled(false);
            InfoPuntos.setEnabled(false);
            ocultapesoaris.setEnabled(false);
            CicloEulerians.setEnabled(false);
            CicloHamilt.setEnabled(false);
            Bipartito.setEnabled(false);
            Kruskal.setEnabled(false);
            barPrim.setEnabled(false);
            AlPrim.setEnabled(false);
            EliminDatos.setEnabled(false);
            conexo87.setEnabled(false);
            conex.setEnabled(false);
            barArbin.setEnabled(false);
            barcamci.setEnabled(false);
            BuscarBipartito.setText("Bipartito : No");
            hamilt.setText("Hamiltoniano : No");  
            VisorComplet.setEnabled(false); 
        } else {
            frameDibujo.setVisible(true);
        }
    }
    public static void completar(){
            CantidadAristasC=0;
            int band=0;
            for(int i=0;i<=AreaDibujo.indicePuntos-1;i++){
                for(int j=i+1;j<=AreaDibujo.indicePuntos;j++)
                {
                    for(int z=0;z<=AreaDibujo.indiceAristas;z++){
                        if((AreaDibujo.aristas[z].puntoA.posicion.x==AreaDibujo.puntos[i].posicion.x && AreaDibujo.aristas[z].puntoA.posicion.y==AreaDibujo.puntos[i].posicion.y && AreaDibujo.aristas[z].puntoB.posicion.x==AreaDibujo.puntos[j].posicion.x && AreaDibujo.aristas[z].puntoB.posicion.y==AreaDibujo.puntos[j].posicion.y) ||(AreaDibujo.aristas[z].puntoA.posicion.x==AreaDibujo.puntos[j].posicion.x && AreaDibujo.aristas[z].puntoA.posicion.y==AreaDibujo.puntos[j].posicion.y &&AreaDibujo.aristas[z].puntoB.posicion.x==AreaDibujo.puntos[i].posicion.x && AreaDibujo.aristas[z].puntoB.posicion.y==AreaDibujo.puntos[i].posicion.y))
                        {
                            listaC[CantidadAristasC]=new Arista(AreaDibujo.puntos[i],AreaDibujo.puntos[j],false,0);
                            listaC[CantidadAristasC].setPeso(AreaDibujo.aristas[z].peso);
                            listaC[CantidadAristasC].setTamaño(AreaDibujo.aristas[z].tamaño);
                            listaC[CantidadAristasC].setColores(AreaDibujo.aristas[z].colorArista);
                            band=1;
                            break;
                        }
                    }
                    if(band==0){
                        listaC[CantidadAristasC]=new Arista(AreaDibujo.puntos[i],AreaDibujo.puntos[j],false,0);
                    }else{
                        band=0;
                    }
                    CantidadAristasC++;
                }
            }

        //*****************************************Complementario*******************

        CantidadAristasCM=0;
        band=0;
        for(int i=0;i<=AreaDibujo.indicePuntos-1;i++){
            for(int j=i+1;j<=AreaDibujo.indicePuntos;j++)
            {
                for(int z=0;z<=AreaDibujo.indiceAristas;z++){
                    if((AreaDibujo.aristas[z].puntoA.posicion.x==AreaDibujo.puntos[i].posicion.x && AreaDibujo.aristas[z].puntoA.posicion.y==AreaDibujo.puntos[i].posicion.y && AreaDibujo.aristas[z].puntoB.posicion.x==AreaDibujo.puntos[j].posicion.x && AreaDibujo.aristas[z].puntoB.posicion.y==AreaDibujo.puntos[j].posicion.y) || (AreaDibujo.aristas[z].puntoA.posicion.x==AreaDibujo.puntos[j].posicion.x && AreaDibujo.aristas[z].puntoA.posicion.y==AreaDibujo.puntos[j].posicion.y && AreaDibujo.aristas[z].puntoB.posicion.x==AreaDibujo.puntos[i].posicion.x && AreaDibujo.aristas[z].puntoB.posicion.y==AreaDibujo.puntos[i].posicion.y))
                    {
                        band=1;
                        break;
                    }
                }
                 if(band==0){
                    listaCM[CantidadAristasCM]=new Arista(AreaDibujo.puntos[i],AreaDibujo.puntos[j],false,0);
                    CantidadAristasCM++;
                 }
                 band=0;
            }
        }
        CrearCompletar iniciarDibujo= new CrearCompletar(new javax.swing.JFrame(), true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                
                new Interfaz().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Acerca;
    public static javax.swing.JButton Actualizar;
    public static javax.swing.JButton AlPrim;
    public static javax.swing.JMenu Algoritmos;
    public static javax.swing.JCheckBoxMenuItem AreaPunteada;
    public static javax.swing.JCheckBox AutoActualizar;
    public static javax.swing.JCheckBoxMenuItem BarAgregaArista;
    public static javax.swing.JCheckBoxMenuItem BarAgregavertice;
    public static javax.swing.JMenuItem BarBipartito;
    public static javax.swing.JCheckBoxMenuItem BarElimiArista;
    public static javax.swing.JCheckBoxMenuItem BarEliminavertice;
    public static javax.swing.JCheckBoxMenuItem BarSelec;
    public static javax.swing.JCheckBoxMenuItem BaragreArisDir;
    public static javax.swing.JButton Bipartito;
    public static javax.swing.JButton BotDijkstra;
    public static javax.swing.JButton BotKruska;
    public static javax.swing.JLabel BuscarBipartito;
    public static javax.swing.JButton CicloEulerians;
    public static javax.swing.JButton CicloHamilt;
    public static javax.swing.JToggleButton Cuadricular;
    public static javax.swing.JLabel Dirigidos;
    public static javax.swing.JMenu EditArista;
    public static javax.swing.JMenuItem EliminDatos;
    public static javax.swing.JMenuItem Imprimir;
    public static javax.swing.JCheckBoxMenuItem InfoPuntos;
    public static javax.swing.JButton Kruskal;
    public static javax.swing.JMenuItem MenuCopiar;
    public static javax.swing.JMenuItem MenuCortar;
    public static javax.swing.JMenuItem MenuPegar;
    public static javax.swing.JCheckBoxMenuItem MostarMatriz;
    public static javax.swing.JButton Screen;
    public static javax.swing.JMenu Ver;
    public static javax.swing.JButton VisorComplet;
    public static javax.swing.JButton abrirDocumento;
    public static javax.swing.JButton arbol;
    public static javax.swing.JToggleButton aristaDirNueva;
    public static javax.swing.JToggleButton aristaNueva;
    public static javax.swing.JMenuItem barArbin;
    public static javax.swing.JMenuItem barColorear;
    public static javax.swing.JMenuItem barEule;
    public static javax.swing.JMenuItem barPrim;
    public static javax.swing.JMenuItem barcamci;
    public static javax.swing.JMenuItem bardiam;
    public static javax.swing.JMenuItem barhamil;
    public static javax.swing.JToolBar barraHerramientas;
    public javax.swing.JToolBar barraHerramientas2;
    private javax.swing.JMenuBar barraMenuPrincipal;
    public static javax.swing.JPanel baseDerecha;
    public static javax.swing.JPanel baseIzquierda;
    private javax.swing.JPanel basePrincipal;
    public static javax.swing.JToggleButton borrarArista;
    public static javax.swing.JToggleButton borrarNodo;
    public static javax.swing.JButton botbipartito;
    public static javax.swing.JButton botcamin;
    public static javax.swing.JButton botdiametro;
    public static javax.swing.JButton boteule;
    public static javax.swing.JButton bothami;
    public static javax.swing.JButton botprim;
    private javax.swing.ButtonGroup buttonbarra;
    public static javax.swing.JToggleButton cambiarEtiqueta;
    public static javax.swing.JButton colorearGrafos;
    public static javax.swing.JLabel completo;
    public static javax.swing.JMenuItem conex;
    public static javax.swing.JLabel conexo;
    public static javax.swing.JButton conexo87;
    public static javax.swing.JMenuItem configurarPagina;
    public static javax.swing.JButton copiar;
    public static javax.swing.JButton cortar;
    public static javax.swing.JCheckBoxMenuItem cuadri;
    public static javax.swing.JButton deshacer;
    public static javax.swing.JMenuItem editNodo1;
    public static javax.swing.JMenu editVertices;
    public static javax.swing.JMenuItem editarista1;
    public static javax.swing.JLabel eulerians;
    public static javax.swing.JInternalFrame frameDibujo;
    private javax.swing.ButtonGroup grupoPaleta;
    public static javax.swing.JButton guardarArchivo;
    public static javax.swing.JMenuItem guardarimagen;
    public static javax.swing.JLabel hamilt;
    public static javax.swing.JMenu herramientas;
    public static javax.swing.JButton imprimir;
    public static javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    public static javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator18;
    private javax.swing.JPopupMenu.Separator jSeparator19;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    public static javax.swing.JLabel mensaje2;
    public static javax.swing.JTextField mensajeAcciones;
    public static javax.swing.JMenuItem menuAbrir;
    public static javax.swing.JMenuItem menuActualizar;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    public static javax.swing.JMenuItem menuDeshacer;
    private javax.swing.JMenu menuEditar;
    public static javax.swing.JMenuItem menuGuardar;
    public static javax.swing.JMenuItem menuGuardarComo;
    private javax.swing.JMenuItem menuItemAyuda;
    public static javax.swing.JMenuItem menuNuevo;
    public static javax.swing.JMenuItem menuOrdenar;
    public static javax.swing.JMenuItem menuRehacer;
    private javax.swing.JMenuItem menuSalir;
    public static javax.swing.JToggleButton modificar;
    public static javax.swing.JToggleButton nodoNuevo;
    public static javax.swing.JButton nuevoDocumento;
    public static javax.swing.JCheckBoxMenuItem ocultapesoaris;
    public static javax.swing.JButton ordenar;
    public static javax.swing.JButton pegar;
    public static javax.swing.JProgressBar progresoAcciones;
    public static javax.swing.JButton rehacer;
    public static javax.swing.JTabbedPane tabla;
    public static javax.swing.JTable tablagrados;
    public static javax.swing.JToggleButton vermatriz1;
    public static javax.swing.JMenuItem virgraf;
    // End of variables declaration//GEN-END:variables
}

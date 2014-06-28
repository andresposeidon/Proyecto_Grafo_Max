package dibujo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import dibujo.AreaDibujo;
public class PaletaDeColores extends JDialog implements ChangeListener,ActionListener{

public static JColorChooser jcc;
JButton jb;

public PaletaDeColores(){


jcc = new JColorChooser();
jb = new JButton("Cerrar");
jb.setSize(20,10);
jcc.getSelectionModel().addChangeListener(this);

jb.addActionListener(this);

jcc.setMaximumSize(new Dimension(100,100));
setLayout(new BorderLayout());
add(jcc, BorderLayout.CENTER);
add(jb, BorderLayout.SOUTH);
pack();
setLocationRelativeTo(null);
}
public void stateChanged(ChangeEvent e){
jb.setForeground(jcc.getColor());
if(AreaDibujo.AristaoPunto==0)
AreaDibujo.puntos[AreaDibujo.valor].colorPunto=jcc.getColor();
else
AreaDibujo.aristas[AreaDibujo.valorArista].colorArista=jcc.getColor();    
}

public void actionPerformed(ActionEvent e){
this.dispose();
}


}
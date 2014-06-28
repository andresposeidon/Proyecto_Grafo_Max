
package AutoDibujar;

public class WalkingDijkstra {

public int []Recorrido=new int [100];
public int Cant=1;
public int Suma=0;
public WalkingDijkstra()
{}

public void CopyAll(WalkingDijkstra h)
{
  Cant=h.Cant;
  Suma=h.Suma;
  System.arraycopy(h.Recorrido, 0, Recorrido, 0, Cant);
 
}
}

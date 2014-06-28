
package gestion;


import java.util.Stack;

public class PilaAcciones {
    
    private Stack<Estado> pila;
    
    public PilaAcciones(){
        pila=new Stack<Estado>();
    }
    
    public void push(Estado estate){
        pila.push(estate);
    }
    
    public Estado pop(){
        return pila.pop();
    }
    
    public Estado peek(){
        return pila.peek();
    }
    
    public boolean estaVacio(){
        if(pila.isEmpty()==true){
            return true;
        }
        return false;
    }
    
    public void vaciar(){
        pila.clear();
    }
}

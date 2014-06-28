
package base;


public class Grafo {
    
    public int matrizAdyacencia[][];
    final int MAX_NODOS=10;
    private String matrizString[][];
    public int indiceNodos;
    
    public Grafo(){
        
        matrizAdyacencia=new int[MAX_NODOS][MAX_NODOS];
        matrizString=new String[MAX_NODOS][MAX_NODOS];
        initMS();
        Extras.inicializarMatriz(matrizAdyacencia, MAX_NODOS);
        indiceNodos=-1;
        
    }
    
    public boolean agregarNodo(){
        indiceNodos++;
        if(indiceNodos<MAX_NODOS){
            for(int i=0; i<=indiceNodos; i++){
                matrizAdyacencia[i][indiceNodos]=0;
                matrizAdyacencia[indiceNodos][i]=0;
                matrizString[i][indiceNodos]="0";
                matrizString[indiceNodos][i]="0";
            }
            //matrizAdyacencia[indiceNodos][indiceNodos]=0;
            return true;
        } else {
            indiceNodos--;
        }
        return false;
    }
    
    public void eliminarNodo(int indice){
        if(indice==(indiceNodos)){
            for(int i=0; i<=indiceNodos; i++){
                matrizAdyacencia[i][indice]=-1;
                matrizAdyacencia[indice][i]=-1;
                matrizString[i][indice]="";
                matrizString[indice][i]="";

            }
            matrizAdyacencia[indiceNodos][indiceNodos]=-1;
            matrizString[indiceNodos][indiceNodos]="";
            indiceNodos--;
            
        } else {
            for(int i=0; i<=indiceNodos; i++){
                for(int j=indice; j<indiceNodos; j++ ){
                    matrizAdyacencia[i][j]=matrizAdyacencia[i][j+1];
                    matrizString[i][j]=matrizString[i][j+1];
                }
            }
            for(int i=indice; i<indiceNodos; i++){
                System.arraycopy(matrizAdyacencia[i+1], 0, matrizAdyacencia[i], 0, indiceNodos);
                System.arraycopy(matrizString[i+1], 0, matrizString[i], 0, indiceNodos);
            }
                for(int i=0; i<=indiceNodos; i++){
                    matrizAdyacencia[indiceNodos][i]=-1;
                    matrizAdyacencia[i][indiceNodos]=-1;
                    matrizString[i][indiceNodos]="";
                    matrizString[indiceNodos][i]="";
                }
            
            indiceNodos--;
            
        }
    
    }
    
    public boolean agregarEnlace(int origen, int destino, boolean dirigido){
        
        if(origen<MAX_NODOS&&destino<MAX_NODOS){
            if(dirigido==false){
                if((matrizAdyacencia[destino][origen]==0)
                        &&(matrizAdyacencia[origen][destino]==0)){
                    matrizAdyacencia[destino][origen]=1;
                    matrizAdyacencia[origen][destino]=1;
                    matrizString[destino][origen]="1";
                    matrizString[origen][destino]="1";
                    return true;
                    
                } 
                    
            } else{
                if(matrizAdyacencia[origen][destino]==0){
                    matrizAdyacencia[origen][destino]=1;
                    matrizString[origen][destino]="1";
                    return true;
                }
                    
            }
            
        }
        return false;
    }
    
    public void eliminarEnlace(int origen, int destino, boolean dirigido){
        if(origen<=indiceNodos&&destino<=indiceNodos){
            matrizAdyacencia[origen][destino]=0;
            matrizString[origen][destino]="0";
            
            if(dirigido==false){
                matrizAdyacencia[destino][origen]=0;
                matrizString[destino][origen]="0";
            }
        }
    }
    
    public void destruirGrafo(){
        
        for(int i=0; i<=indiceNodos; i++){
            for(int j=0; j<=indiceNodos; j++){
                matrizAdyacencia[i][j]=-1;
                matrizString[i][j]="";
            }
        }
        indiceNodos=-1;
    }
    
    public String getGradoEntrada(int indice){
        int gE=0;
        for(int i=0; i<=indiceNodos; i++){
            gE=gE+matrizAdyacencia[i][indice];
        }
        return Integer.toString(gE);
    }
    
    public String getGradoSalida(int indice){
        int gS=0;
        for(int i=0; i<=indiceNodos; i++){
            gS=gS+matrizAdyacencia[indice][i];
        }
        return Integer.toString(gS);
    }
    
    public int[][] getMatriz(){
        return matrizAdyacencia;
    }
    
    public String[][] getMatrizS(){
        return matrizString;
    }
    
    public String[][] clonarMatrizS(){
        
        String matrizS[][]= new String[10][10];
        for(int i=0; i<10; i++){
            System.arraycopy(matrizString[i], 0, matrizS[i], 0, 10);
        }
        return matrizS;
    }
    
    public void setMatrizS(String matrizS[][]){
        this.matrizString=matrizS;
    }
    
    public int[][] clonarMatriz(){
        int matriz[][]=new int[10][10];
        for(int i=0; i<10; i++){
            //System.arraycopy(matrizAdyacencia[i], 0, matriz[i], 0, 10);
        for(int j=0; j<10; j++){
                matriz[i][j]=matrizAdyacencia[i][j];
            }
        }
        return matriz;
    }
    
    public void setMatriz(int matriz[][], int indiceNodos){
        for(int i=0; i<10; i++){
            //System.arraycopy(matriz[i], 0, matrizAdyacencia[i], 0, 10);
            for(int j=0; j<10; j++){
                matrizAdyacencia[i][j]=matriz[i][j];
            }
        }
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(matrizAdyacencia[i][j]==-1){
                    matrizString[i][j]="";
                }
                if(matrizAdyacencia[i][j]==1){
                    matrizString[i][j]="1";
                }
                if(matrizAdyacencia[i][j]==0){
                    matrizString[i][j]="0";
                }
            }
        }
        this.indiceNodos=indiceNodos;
    }
    
    public void initMS(){
        for(int i=0; i<MAX_NODOS; i++){
            for(int j=0; j<MAX_NODOS; j++){
                matrizString[i][j]="";
            }
        }
    }

}


package base;

public final class Extras {
    
    public Extras(){}
    
    public static void inicializarMatriz(int matriz[][], int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matriz[i][j]=-1;
            }
        }
    }
    
    public static double mayor(double a, double b){
        if(a>b){
            return a;
        }
        return b;
    }
    
    public static double menor(double a, double b){
        if(a<b){
            return a;
        }
        return b;
    }
    
    public static int[][] sumarMatriz(int matriz1[][], int matriz2[][], int n){
        int matriz[][];
        matriz=new int[n][n];
        
        for(int i=0; i<n; i++){
            
            for(int j=0; j<n; j++){
            
                matriz[i][j]=matriz1[i][j]+matriz2[i][j];
            }        
            
        }
        return matriz;
    } 
    
    public static void matrizIdentidad(int matriz[][], int n){
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(j==i){
                    matriz[i][j]=1;
                } else {
                    matriz[i][j]=0;
                }
            }
        }
    }
    
    public static int[][] productoMatriz(int matriz1[][], int matriz2[][], int n){
        int matriz[][];
        matriz=new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matriz[i][j]=0;
                for(int k=0; k<n; k++){
                    if(matriz[i][j]==1){
                        break;
                    }
                    matriz[i][j]=matriz[i][j]+matriz1[i][k]*matriz2[k][j];
                }
            }
        }
        
        return matriz;
    }

    public static boolean revisarMatriz(int matriz[][], int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matriz[i][j]<=0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void setearMatriz(int matriz[][], int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                
                matriz[i][j]=0;
            }
        }
    }
    
    public static void copiarMatriz(int matriz1[][], int matriz2[][], int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matriz1[i][j]=matriz2[i][j];
            }
        }
    }

    public static void mostrarMatriz(int matriz[][], int n){
        for(int i=0; i<n; i++){
            
            for(int j=0; j<n; j++){
                
                System.out.printf("[%d]", matriz[i][j]);
                
            }
            System.out.println();
        }
    }
}


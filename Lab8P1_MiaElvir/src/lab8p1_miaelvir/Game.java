
package lab8p1_miaelvir;

import java.util.ArrayList;


public class Game {
    
    int num_rondas;
    ArrayList <String> coordenadas = new ArrayList<>(); 
    int [][] matriz_actual; 
    int [][] matriz_sig; 

    public Game() {
    }

    public int getNum_rondas() {
        return num_rondas;
    }

    public void setNum_rondas(int num_rondas) {
        this.num_rondas = num_rondas;
    }

    public ArrayList<String> getCoordendas() {
        return coordenadas;
    }

    public void setCoordendas(ArrayList<String> coordendas) {
        this.coordenadas = coordendas;
    }

    public int[][] getMatriz_actual() {
        return matriz_actual;
    }

    public void setMatriz_actual(int[][] matriz_actual) {
        this.matriz_actual = matriz_actual;
    }

    public int[][] getMatriz_sig() {
        return matriz_sig;
    }

    public void setMatriz_sig(int[][] matriz_sig) {
        this.matriz_sig = matriz_sig;
    }
    
    public void nextGen(){
        int cont1 = 0; 
        int [][] temp = new int [10][10]; 
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cont1 = 0;
                if(i==0 || j == 0 || j==9 || i == 9){
                     
                }else{
                    int [] evaluar = {matriz_actual[i-1][j-1],matriz_actual[i-1][j],matriz_actual[i-1][j+1],matriz_actual[i][j-1],
                         matriz_actual[i][j+1],matriz_actual[i+1][j-1],matriz_actual[i+1][j],matriz_actual[i+1][j+1]};

                    if (this.matriz_actual[i][j]==1){
                        
                        for (int k = 0; k < evaluar.length; k++) {
                            if(evaluar[k]==1){
                                cont1++; 
                            }
                        }
                        //System.out.println("0 y " + Integer.toString(cont1) + " i: " + Integer.toString(i) + " j: " + Integer.toString(j));
                        if(cont1<2 || cont1>3){
                            matriz_sig[i][j]=0;    
                        }else{
                            matriz_sig[i][j]=1;
                            this.coordenadas.add(Integer.toString(j)+":"+Integer.toString(i));
                        } 
                         
                        
                    }else{
                        for (int k = 0; k < evaluar.length; k++) {
                            if(evaluar[k]==1){
                                cont1++; 
                            }
                        }
                        //System.out.println("0 y " + Integer.toString(cont1) + " i: " + Integer.toString(i) + " j: " + Integer.toString(j));
                        if(cont1==3){
                            matriz_sig[i][j]=1; 
                            this.coordenadas.add(Integer.toString(j)+":"+Integer.toString(i));
                        }
                    }
                     
                    matriz_actual=matriz_sig; 
                    matriz_sig=temp; 
                    
                }
            }
        }
    
    }//nextgen
    
    public void print(ArrayList<String>a){
        int [][] temp = new int [10][10]; 
        //System.out.println(a);
        for (int i = 0; i < a.size(); i++) {
            int x; 
            int y; 
            String coords = a.get(i); 
            x = (int) coords.charAt(0) - '0'; 
            y = (int) coords.charAt(2) - '0';    
            temp[x][y]=1; 
        }
        for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    System.out.print("["+temp[j][k]+"]");
                }
                System.out.println();
        }
        System.out.println();
    }//print
    
    //imprimiendo primera ronda
    public void jugar(int x){
        for (int i = 0; i < x; i++) {
            if (i == 0) {
                for (int j = 0; j < matriz_actual.length; j++) {
                    for (int k = 0; k < matriz_actual[0].length; k++) {
                        System.out.print('[' + Integer.toString(matriz_actual[j][k]) + ']');
                    }
                    System.out.println();
                }
                System.out.println();
            }
            nextGen();
            print(coordenadas); 
        }
    }
    
    
    
}//fin clase

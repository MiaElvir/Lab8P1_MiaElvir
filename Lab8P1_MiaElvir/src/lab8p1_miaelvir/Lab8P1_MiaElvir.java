

package lab8p1_miaelvir;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Lab8P1_MiaElvir {

   static Scanner papoy = new Scanner(System.in); 
   static Random ran = new Random(); 
   
   
    public static void main(String[] args) {
        
        System.out.println("---- MENU ----\n1. Game of life\n2. Salir");
        int opcion = papoy.nextInt(); 
        Game g = new Game(); 
        
        while (opcion > 0 && opcion < 2){
            switch (opcion){
                case 1: 
                    
                    //Ocupamos: Matriz actual, Matriz siguiente, Numero de rondas
                    System.out.println("-------- Game of Life --------\nIngrese el numero de Rondas: ");
                    int num_rondas = papoy.nextInt();
                    int [][] matriz_actual = new int [10][10]; 
                    int [][] matriz_sig = new int [10][10]; 
                    ArrayList<String> coordenadas = new ArrayList <>(); 
                    g.setCoordenadas(coordenadas);
                    g.setMatriz_actual(GenMatrizActual(matriz_actual));
                    g.setMatriz_sig(matriz_sig);
                    g.setNum_rondas(num_rondas);
                    //imprimir_matriz(GenMatrizActual(matriz_actual, matriz_sig, num_rondas)); --prueba--
                   
                    g.jugar(num_rondas);
                    
                    break; 
                    
            }//fin switch
            System.out.println();
            System.out.println("---- MENU ----\n1. Game of life\n2. Salir");
            opcion = papoy.nextInt(); 
        
        }//fin while
        
       
        
        
    }//fin main
    
    public static int [][] GenMatrizActual(int x[][]){
        int [][] temp = new int [10][10]; 
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (i == 0 || j == 0 || i == temp.length-1 || j == temp.length-1){
                    temp [i][j] = 0; 
                }else{
                    temp [i][j] = ran.nextInt(2); 
                }
            }
            
        }   
        return temp; 
    }
    
    public static void imprimir_matriz(int x[][]){
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("["+x[i][j]+"] ");
            }
            System.out.println();   
        }
    }
}//fin class



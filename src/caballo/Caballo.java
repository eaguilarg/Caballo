

package caballo;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Caballo {
    public Caballo(){
        
    }
    public void imprimeMatriz(int[][] matriz) {
        for (int x = 0; x < matriz.length; x++) {

            for (int y = 0; y < matriz[x].length; y++) {
                System.out.print(matriz[x][y]);
                if (y != matriz[x].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
        System.out.println("");
    }
    
    public boolean RecorrerCaballo(int [][] tablero, int x, int y, int val ){
        
       if(val<(tablero.length)*(tablero.length))
            imprimeMatriz(tablero);
        
         if(x>=tablero.length || y>=tablero.length)
             return false;
         
         if(x<0|| y<0)
             return false;
        if(tablero[x][y]!=0)
             return false;
   
        tablero[x][y]=val;
        
  
        if(RecorrerCaballo(tablero,x-2,y+1,val+1))//arriba-derecha
            return true;        
        if(RecorrerCaballo(tablero,x-2,y-1,val+1))//arriba-izquierda
            return true;
        if(RecorrerCaballo(tablero,x-1,y+2,val+1))//derecha-arriba
            return true;
        if(RecorrerCaballo(tablero,x-1,y-2,val+1))//izquierda-arriba
            return true;
        if(RecorrerCaballo(tablero,x+1,y+2,val+1))//derecha-abajo
            return true;
        if(RecorrerCaballo(tablero,x+1,y-2,val+1))//izquierda-abajo
            return true; 
         if(RecorrerCaballo(tablero,x+2,y+1,val+1))//abajo-derecha
            return true;
        if(RecorrerCaballo(tablero,x+2,y-1,val+1))//abajo-izquierda
            return true;
        
        
            
       tablero[x][y]=0;
            return false;
        
       
            
                      
    }

    
    public static void main(String[] args){
        Caballo c= new Caballo();
        Scanner lectura=new Scanner(System.in);
        int resp = 0,x,y;
        
        System.out.println("Ingresa tamaño tablero:");
       try{
           resp=lectura.nextInt();
       }catch(InputMismatchException e){
         throw new Unchecked1("No ingresar Double o String");
       }
       
         System.out.println("Ingresa posicion inicial:");
         System.out.print("X:");
         
       try{
        x=lectura.nextInt();
        }catch(InputMismatchException e){
        throw new Unchecked1("No ingresar Double o String");
       }
       
       System.out.print("Y:");
       try{
        y=lectura.nextInt();
        }catch(InputMismatchException e){
        throw new Unchecked1("No ingresar Double o String");
       }
        int [][] tablero=new int [resp][resp];
        c.RecorrerCaballo(tablero, x, y, y);
        
       
        
        
        
        
    }
    
}

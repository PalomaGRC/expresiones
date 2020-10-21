/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresiones;

import java.util.Scanner;

/**
 *
 * @author Paloma
 */
public class Expresiones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        
        boolean continuar = true;
        int opcion;
        
        while(continuar){
            
            System.out.println("");
            System.out.println("1.- Expresión aritmética");
            System.out.println("2.- Expresión lógica");
            System.out.println("3.- Expresión lógica V2");
            System.out.println("4.- Salir");
            opcion = leer.nextInt();
            
            switch(opcion){
                
                case 1:
                    ExpresionAritmetica x = new ExpresionAritmetica();
                    break;
                    
                case 2:
                   ExpresionLogicaV y = new ExpresionLogicaV();
                    break;
                    
                case 3:
                    ExpresionLogicaV2 x2 = new ExpresionLogicaV2();
                    break;
                    
                case 4:
                    continuar = false;
                            break;
                default:
                    System.out.println("La opción que elgiste es incorrecta, favor de seleccionar");
                    break;
            }
        }
    }
    
}

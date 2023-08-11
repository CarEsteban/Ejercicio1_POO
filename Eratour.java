/** Autor: Esteban enrique Cárcamo Urízar
 *  Fecha de creación: 11/08/23 ; Hora: 8:05
 *  Última fecha de modificación: 
 *  Descripción: Juego de pig con objetos en java
 */

import java.util.Random;
import java.util.Scanner;

public class Eratour{
    public static void main(String[] args) {
        

        Scanner scan = new Scanner(System.in);
        Random ticket = new Random();
        Random a = new Random();
        Random b = new Random();
        int menu, decision=0;

        while(decision!=6){
            
            System.out.println("\nBIENVENDIOS AL PROGRAMA DE ERAS TOUR\n");
            System.out.println("====================================\n");
            System.out.println("Este es el menu, ingrese la opcion:\n\t1. Nuevo Comprador\n\t2. Nueva solicitud de boletos:\n\t3. Consultar disponibilidad total\n\t4. Consultar disponibilidad individual\n\t5. Reporte de caja\n\t6. Salir");
            
            menu=scan.nextInt();
            scan.nextLine();

            switch(menu){
                case 1:
                    System.out.println("Bienvenido a 'Nuevo comprador'");

                    System.out.println("Ingrese el nombre");
                    String nombre=scan.nextLine();
                    
                    System.out.println("Ingrese el email");
                    String email=scan.nextLine();
                    
                    System.out.println("Ingrese la cantidad de boletos a comprar");
                    int cantidad=scan.nextInt();
                    
                    System.out.println("Ingrese su presupuesto máximo de compra");
                    int presupuesto=scan.nextInt();
                    
                    System.out.println("---------------------------------------");
                    Comprador comprador = new Comprador(nombre, email, cantidad, presupuesto);

                    System.out.println(comprador);

                    break;

                case 2:
                    System.out.println("Bienvenido a 'Nueva solicitud de boletos'");
                    break;

                case 3:
                    System.out.println("Bienvenido a 'Consultar disponibilidad total'");
                    break;

                case 4:
                    System.out.println("Bienvenido a 'Consultar disponibilidad individual'");
                    break;

                case 5:
                    System.out.println("Bienvenido a 'Reporte de caja'");
                    break;

                case 6:
                    System.out.println("Saliendo.....");
                    break;
                
            }//switch

            System.out.println("Desea repetir el menu? 1=Si ; 6=No");
            decision=scan.nextInt();


        }//while

        System.out.println("Acaba de salir del programa, bye");

    }//main
}//class
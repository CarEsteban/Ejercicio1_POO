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
        Random rnd = new Random();
        int menu, decision=0;
        Comprador comprador = null;
        Localidad localidad_1 = new Localidad(1, 20, 100);
        Localidad localidad_2 = new Localidad(5, 20, 500);
        Localidad localidad_3 = new Localidad(10, 20, 1000);

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
                    comprador = new Comprador(nombre, email, cantidad, presupuesto);

                    System.out.println(comprador);

                    break;

                case 2:
                    System.out.println("Bienvenido a 'Nueva solicitud de boletos'");

                    System.out.println("==========================================");
                    System.out.println("Validaremos si su ticket es apto para comprar boletos");

                    int ticket = rnd.nextInt(14999)+1; 

                    int a = rnd.nextInt(14999)+1; 

                    int b = rnd.nextInt(14999)+1; 

                    if(ticket>=a && ticket<=b || ticket>=b && ticket<=a){
                        System.out.println("Valor del tiket: " + ticket + "\nValor de A: " + a + "\nValor de B: " + b + "\n\n");
                        System.out.println(comprador.getNombre() + " su tiket es válido, puede comprar su(s) boleto(s)");
                        System.out.println("==========================================");
                    }else{
                        System.out.println("Valor del tiket: " + ticket + "\nValor de A: " + a + "\nValor de B: " + b + "\n\n");
                        System.out.println(comprador.getNombre() + ", Ticket NO válido");
                        System.out.println("==========================================");
                        break;
                    }

                    
                    System.out.println("==========================================");
                    System.out.println("Asignando su localidad.........");

                    int numLocalidad = rnd.nextInt(3)+1;

                    if(numLocalidad==1){
                        comprador.setLocalidad(localidad_1.getTipo());
                        System.out.println("Estimado(a) " + comprador.getNombre() + " su localidad será la tipo " + comprador.getLocalidad());

                        if(localidad_1.getEspacio()>0){
                            System.out.println("Todavía hay espacios para poder asignarles\nEspacio total: " + localidad_1.getEspacio() + " espacios.");
                            
                            if(localidad_1.getEspacio()<comprador.getCantidadBoletos()){
                                System.out.println("Lo siento, no hay mas espacios para la cantidad de boletos que desea\nBoletos deseados: " + comprador.getCantidadBoletos()+ "\nEspacio: " + localidad_1.getEspacio());
                                break;
                            }else{
                                System.out.println("Correcto, si le podemos vender la cantidad de boletos que desea\nBoletos deseados: " + comprador.getCantidadBoletos()+ "\nEspacio: " + localidad_1.getEspacio());
                                int precioBoletos = comprador.getCantidadBoletos() * localidad_1.getPrecio();
                                if(comprador.getPresupuesto()<=precioBoletos){
                                    System.out.println("Lo siento, no podemos venderle los boletos, su presupuesto no se adecuado al precio total de los boletos\nPresupuesto de " + comprador.getNombre() + ": " + comprador.getPresupuesto() + "\nPrecio total de boletos: "+precioBoletos);
                                    break;
                                }else{
                                    System.out.println("FELICIDADES, si podemos venderlo los boletos");
                                    System.out.println("Boletos vendidos:" + comprador.getCantidadBoletos());
                                    localidad_1.setEspacio(comprador.getCantidadBoletos());







                                }
                            
                            }
                        
                        }else{
                            System.out.println("Lo siento, no hay más espacios en esta localidad\nEspacio total: " + localidad_1.getEspacio() + " espacios.");
                            break;
                        }


                    }else if(numLocalidad==2){
                        comprador.setLocalidad(localidad_2.getTipo());
                        System.out.println("Estimado(a) " + comprador.getNombre() + " su localidad será la tipo " + comprador.getLocalidad());
                    }else if(numLocalidad==3){
                        comprador.setLocalidad(localidad_3.getTipo());
                        System.out.println("Estimado(a) " + comprador.getNombre() + " su localidad será la tipo " + comprador.getLocalidad());
                    }else{
                        System.out.println("Imposible, venciste al sistema :O");
                        break;
                    }

                    





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
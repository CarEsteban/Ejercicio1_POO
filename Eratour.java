/** 
 *  @author: Esteban enrique Cárcamo Urízar
 *  Fecha de creación: 11/08/23 ; Hora: 8:05 am
 *  Última fecha de modificación: 13 de agosto 5:35 pm
 *  Descripción:
    * El punto de entrada del programa Eratour consite en un progra que permita a los usuarios interactuar
    * con el sistema para registrar compradores, solicitar boletos, comprarlos y hacer sus respectivas validaciones, también
    * consultar la disponibilidad y generar informes de caja.

    @param args Los argumentos de línea de comandos (no se utilizan).
    @throws InterruptedException Si se produce una interrupción en el hilo mientras el programa espera.
 */

import java.util.Random;
import java.util.Scanner;

public class Eratour{
    public static void main(String[] args) throws InterruptedException {
        
        //declaración de variables e instancias
        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();

        Comprador comprador =null;
        Caja caja = new Caja();
        Localidad localidad_1 = new Localidad(1, 20, 100);
        Localidad localidad_2 = new Localidad(5, 20, 500);
        Localidad localidad_3 = new Localidad(10, 20, 1000);

        int menu, precioBoletos, boletosVendidos, opc,decision=0;

        //inicio del ciclo para el menu
        while(decision!=6){
            System.out.println("\nBIENVENDIOS AL PROGRAMA DE ERAS TOUR\n");
            System.out.println("====================================\n");
            System.out.println("Este es el menu, ingrese la opcion:\n\t1. Nuevo Comprador\n\t2. Nueva solicitud de boletos:\n\t3. Consultar disponibilidad total\n\t4. Consultar disponibilidad individual\n\t5. Reporte de caja\n\t6. Salir");
            
            menu=scan.nextInt();
            scan.nextLine();

            //casos del menu
            switch(menu){
                case 1:
                    //registro del comprador
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
                    //comprobación si el usuario es nuevo, si es así salir del case y pedir que ingrese un usuario
                    if(comprador==null){
                        System.out.println("Porfavor registrar un nuevo comprador");
                        break;
                    }

                    System.out.println("Bienvenido a 'Nueva solicitud de boletos'");

                    System.out.println("==========================================");
                    System.out.println("Validaremos si su ticket es apto para comprar boletos");

                    //numeros random para validacion
                    int ticket = rnd.nextInt(14999)+1; 

                    int a = rnd.nextInt(14999)+1; 

                    int b = rnd.nextInt(14999)+1; 

                    //validación entre el rango
                    if(ticket>=a && ticket<=b || ticket>=b && ticket<=a){
                        System.out.println("Valor del ticket: " + ticket);
                        Thread.sleep(1000);
                        System.out.println("Rango de validación:\n\tValor de A: " + a + "\n\tValor de B: " + b + "\n\n");
                        Thread.sleep(2000);
                        System.out.println(comprador.getNombre() + " su tiket es válido, puede comprar su(s) boleto(s)");
                        System.out.println("==========================================");
                    }else{
                        //si no está en el rango salirse del case
                        System.out.println("Valor del ticket: " + ticket);
                        Thread.sleep(1000);
                        System.out.println("Rango de validación:\n\tValor de A: " + a + "\n\tValor de B: " + b + "\n\n");
                        Thread.sleep(2000);
                        System.out.println(comprador.getNombre() + ", Ticket NO válido");
                        System.out.println("==========================================");
                        break;
                    }

                    //asigna la localidad de forma random
                    System.out.println("==========================================");
                    System.out.println("Asignando su localidad.........");

                    Thread.sleep(4000);

                    int numLocalidad = rnd.nextInt(3)+1;


                    if(numLocalidad==1){
                        comprador.setLocalidad(localidad_1.getTipo());
                        System.out.println("Estimado(a) " + comprador.getNombre() + " su localidad será la tipo " + comprador.getLocalidad());

                        Thread.sleep(2000);
                        System.out.println("Verificando si hay espacios en la localidad "+ comprador.getLocalidad()+"....");
                        
                        Thread.sleep(4000);

                        if(localidad_1.getEspacio()>0){
                            System.out.println("Todavía hay espacios para poder asignarle\nEspacio total: " + localidad_1.getEspacio() + " espacios.");
                            System.out.println("-----------------------------------------------------");
                            Thread.sleep(2000);
                            System.out.println("Verificando si hay espacio respecto a sus boletos deseados....");

                            Thread.sleep(4000);

                            if(localidad_1.getEspacio()<comprador.getCantidadBoletos()){
                                System.out.println("Lo siento, no hay mas espacios para la cantidad de boletos que desea\nBoletos deseados: " + comprador.getCantidadBoletos()+ "\nEspacio: " + localidad_1.getEspacio());
                                //vender la cantidad de boletos que sobren
                                System.out.println("-----------------------------------------------------");
                            }else{
                                System.out.println("Correcto, si le podemos vender la cantidad de boletos que desea\nBoletos deseados: " + comprador.getCantidadBoletos()+ "\nEspacio: " + localidad_1.getEspacio());
                                precioBoletos = comprador.getCantidadBoletos() * localidad_1.getPrecio();
                                System.out.println("-----------------------------------------------------");
                                System.out.println("Verificando su presupuesto con el total a comprar...");
                                
                                Thread.sleep(4000);

                                if(comprador.getPresupuesto()<=precioBoletos){
                                    System.out.println("Lo siento, no podemos venderle los boletos, su presupuesto no es adecuado al precio total de los boletos\nPresupuesto de " + comprador.getNombre() + ": " + comprador.getPresupuesto() + "\nPrecio total de boletos: "+precioBoletos);
                                    System.out.println("-----------------------------------------------------");
                                }else{
                                    System.out.println("FELICIDADES, si podemos venderlo los boletos\nPresupuesto de " + comprador.getNombre() + ": " + comprador.getPresupuesto() + "\nPrecio total de boletos: "+precioBoletos);
                                    System.out.println("Boletos vendidos: " + comprador.getCantidadBoletos());
                                    localidad_1.setEspacio(comprador.getCantidadBoletos());
                                    //Se agregó la clase caja para poder manejar el reporte de la caja
                                    caja.setCaja(precioBoletos);
                                    System.out.println("Saliendo del sistema....");
                                    System.out.println("-----------------------------------------------------");
                                    Thread.sleep(4000);
                                }
                            
                            }
                        
                        }else{
                            System.out.println("Lo siento, no hay más espacios en esta localidad\nEspacio total: " + localidad_1.getEspacio() + " espacios.");
                            break;
                        }
                        
                        


                    }else if(numLocalidad==2){
                        comprador.setLocalidad(localidad_2.getTipo());
                        System.out.println("Estimado(a) " + comprador.getNombre() + " su localidad será la tipo " + comprador.getLocalidad());

                        Thread.sleep(2000);
                        System.out.println("Verificando si hay espacios en la localidad "+ comprador.getLocalidad()+"....");
                        
                        Thread.sleep(4000);

                        if(localidad_2.getEspacio()>0){
                            System.out.println("Todavía hay espacios para poder asignarle\nEspacio total: " + localidad_2.getEspacio() + " espacios.");
                            System.out.println("-----------------------------------------------------");
                            Thread.sleep(2000);
                            System.out.println("Verificando si hay espacio respecto a sus boletos deseados....");

                            Thread.sleep(4000);

                            if(localidad_2.getEspacio()<comprador.getCantidadBoletos()){
                                System.out.println("Lo siento, no hay mas espacios para la cantidad de boletos que desea\nBoletos deseados: " + comprador.getCantidadBoletos()+ "\nEspacio: " + localidad_2.getEspacio());
                                //vender la cantidad de boletos que sobren
                                System.out.println("-----------------------------------------------------");
                            }else{
                                System.out.println("Correcto, si le podemos vender la cantidad de boletos que desea\nBoletos deseados: " + comprador.getCantidadBoletos()+ "\nEspacio: " + localidad_2.getEspacio());
                                precioBoletos = comprador.getCantidadBoletos() * localidad_2.getPrecio();
                                System.out.println("-----------------------------------------------------");
                                System.out.println("Verificando su presupuesto con el total a comprar...");
                                
                                Thread.sleep(4000);

                                if(comprador.getPresupuesto()<=precioBoletos){
                                    System.out.println("Lo siento, no podemos venderle los boletos, su presupuesto no se adecuado al precio total de los boletos\nPresupuesto de " + comprador.getNombre() + ": " + comprador.getPresupuesto() + "\nPrecio total de boletos: "+precioBoletos);
                                    System.out.println("-----------------------------------------------------");
                                }else{
                                    System.out.println("FELICIDADES, si podemos venderlo los boletos\nPresupuesto de " + comprador.getNombre() + ": " + comprador.getPresupuesto() + "\nPrecio total de boletos: "+precioBoletos);
                                    System.out.println("Boletos vendidos: " + comprador.getCantidadBoletos());
                                    localidad_2.setEspacio(comprador.getCantidadBoletos());
                                    //Se agregó la clase caja para poder manejar el reporte de la caja
                                    caja.setCaja(precioBoletos);
                                    System.out.println("Saliendo del sistema....");
                                    System.out.println("-----------------------------------------------------");
                                    Thread.sleep(4000);
                                }
                            
                            }
                        
                        }else{
                            System.out.println("Lo siento, no hay más espacios en esta localidad\nEspacio total: " + localidad_2.getEspacio() + " espacios.");
                            break;
                        }


                        

                    }else if(numLocalidad==3){
                        comprador.setLocalidad(localidad_3.getTipo());
                        System.out.println("Estimado(a) " + comprador.getNombre() + " su localidad será la tipo " + comprador.getLocalidad());

                        Thread.sleep(2000);
                        System.out.println("Verificando si hay espacios en la localidad "+ comprador.getLocalidad()+"....");
                        
                        Thread.sleep(4000);

                        if(localidad_3.getEspacio()>0){
                            System.out.println("Todavía hay espacios para poder asignarle\nEspacio total: " + localidad_3.getEspacio() + " espacios.");
                            System.out.println("-----------------------------------------------------");
                            Thread.sleep(2000);
                            System.out.println("Verificando si hay espacio respecto a sus boletos deseados....");

                            Thread.sleep(4000);

                            if(localidad_3.getEspacio()<comprador.getCantidadBoletos()){
                                System.out.println("Lo siento, no hay mas espacios para la cantidad de boletos que desea\nBoletos deseados: " + comprador.getCantidadBoletos()+ "\nEspacio: " + localidad_3.getEspacio());
                                //vender la cantidad de boletos que sobren
                                System.out.println("-----------------------------------------------------");
                            }else{
                                System.out.println("Correcto, si le podemos vender la cantidad de boletos que desea\nBoletos deseados: " + comprador.getCantidadBoletos()+ "\nEspacio: " + localidad_3.getEspacio());
                                precioBoletos = comprador.getCantidadBoletos() * localidad_3.getPrecio();
                                System.out.println("-----------------------------------------------------");
                                System.out.println("Verificando su presupuesto con el total a comprar...");
                                
                                Thread.sleep(4000);

                                if(comprador.getPresupuesto()<=precioBoletos){
                                    System.out.println("Lo siento, no podemos venderle los boletos, su presupuesto no se adecuado al precio total de los boletos\nPresupuesto de " + comprador.getNombre() + ": " + comprador.getPresupuesto() + "\nPrecio total de boletos: "+precioBoletos);
                                    System.out.println("-----------------------------------------------------");
                                }else{
                                    System.out.println("FELICIDADES, si podemos venderlo los boletos\nPresupuesto de " + comprador.getNombre() + ": " + comprador.getPresupuesto() + "\nPrecio total de boletos: "+precioBoletos);
                                    System.out.println("Boletos vendidos: " + comprador.getCantidadBoletos());
                                    localidad_3.setEspacio(comprador.getCantidadBoletos());
                                    //Se agregó la clase caja para poder manejar el reporte de la caja
                                    caja.setCaja(precioBoletos);
                                    System.out.println("Saliendo del sistema....");
                                    System.out.println("-----------------------------------------------------");
                                    Thread.sleep(4000);
                                }
                            
                            }
                        
                        }else{
                            System.out.println("Lo siento, no hay más espacios en esta localidad\nEspacio total: " + localidad_3.getEspacio() + " espacios.");
                            
                        }

                        
                    
                    }else{
                        System.out.println("Imposible, venciste al sistema :O");
                        break;
                    }
                    comprador=null;
                    break;

                case 3:
                    System.out.println("Bienvenido a 'Consultar disponibilidad total'");

                    System.out.println("================================================");
                    System.out.println("Disponibilidad de la localidad número 1, tipo "+ localidad_1.getTipo()+" :");
                    boletosVendidos = 20 - localidad_1.getEspacio();
                    System.out.println("Boletos vendidos en esta localidad: " + boletosVendidos +"");
                    System.out.println("Boletos disponibles: "+ localidad_1.getEspacio());
                    System.out.println("================================================");


                    System.out.println("================================================");
                    System.out.println("Disponibilidad de la localidad número 2, tipo "+ localidad_2.getTipo()+" :");
                    boletosVendidos = 20 - localidad_2.getEspacio();
                    System.out.println("Boletos vendidos en esta localidad: " + boletosVendidos +"");
                    System.out.println("Boletos disponibles: "+ localidad_2.getEspacio());
                    System.out.println("================================================");


                    System.out.println("================================================");
                    System.out.println("Disponibilidad de la localidad número 3, tipo "+ localidad_3.getTipo()+" :");
                    boletosVendidos = 20 - localidad_3.getEspacio();
                    System.out.println("Boletos vendidos en esta localidad: " + boletosVendidos +"");
                    System.out.println("Boletos disponibles: "+ localidad_3.getEspacio());
                    System.out.println("================================================");



                    break;

                case 4:
                    System.out.println("Bienvenido a 'Consultar disponibilidad individual'");

                    System.out.println("Ingrese la localidad que desea ver:\n1)Localidad tipo 1\n2)Localidad tipo 5\n3)Localidad tipo10");
                    opc = scan.nextInt();

                    switch(opc){
                        case 1:

                            System.out.println("Boletos disponibles: "+ localidad_1.getEspacio());
                            break;
                        case 2:

                            System.out.println("Boletos disponibles: "+ localidad_2.getEspacio());
                            break;
                        case 3:

                            System.out.println("Boletos disponibles: "+ localidad_3.getEspacio());

                            break;
                        default:
                            System.out.println("Ya no existen más localidades");
                            break;
                    }




                    break;

                case 5:
                    System.out.println("Bienvenido a 'Reporte de caja'");

                    System.out.println("Entre las 3 localidades se ha vendido un total de Q"+caja.getCaja());

                    break;

                case 6:
                    System.out.println("Saliendo.....");
                    Thread.sleep(3000);
                    break;
                
            }//switch
        
            System.out.println("Desea repetir el menu? 1=Si ; 6=No");
            decision=scan.nextInt();


        }//while
        
        Thread.sleep(3000);
        System.out.println("Acaba de salir del programa, bye");
        scan.close();
    }//main
}//class
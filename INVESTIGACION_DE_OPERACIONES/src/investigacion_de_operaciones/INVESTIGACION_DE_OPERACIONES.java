
package investigacion_de_operaciones;
import java.util.Scanner;


public class INVESTIGACION_DE_OPERACIONES {


    public static void main(String[] args) {
        //Creacion del escaner 
        Scanner scanner = new Scanner(System.in);
        METODOSIMPLEX simplex=new METODOSIMPLEX();
        MetodoGrafico grafico=new MetodoGrafico();
        MetodoVogel vogel=new MetodoVogel();
        EsquinaSuperior esqSup=new EsquinaSuperior();
        SeccionDorada secDor=new SeccionDorada();
        MetodoDicotomo dicotomo=new MetodoDicotomo();
        //Declaracion de las variables
        int opcion;
        do{
            System.out.println("==========================================");
            System.out.println("MENU DE UNIDADES");
            System.out.println("1-UNIDAD 1");
            System.out.println("2-UNIDAD 2");
            System.out.println("3-UNIDAD 3");
            System.out.println("4-UNIDAD 4");
            System.out.println("5-UNIDAD 5");
            System.out.println("0-SALIR DEL MENU");
            System.out.println("SELECCIONA UNA OPCION");

        opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
            
        switch (opcion) {//switch-case inicio
            case 1:
                int metodoUnidad1;
                    do {
                        System.out.println("==========================================");
                        System.err.println("UNIDAD 1");
                        System.out.println("1=METODO SIMPLEX");
                        System.out.println("2=METODO GRAFICO");
                        System.out.println("0-REGRESAR AL MENU PRINCIPAL");
                        System.out.println("SELECCIONA UNA OPCION:");

                        metodoUnidad1 = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer

                        switch (metodoUnidad1) {
                            case 1:
                                System.out.println("==========================================");
                                System.out.println("METODO SIMPLEX");
                                simplex.ejecusionSimplex();
                                break;
                            case 2:
                                System.out.println("==========================================");
                                System.err.println("METODO GRAFICO");
                                grafico.ejecusionGrafico();
                                // Código para método gráfico en unidad 1
                                
                                break;
                            case 0:
                                // Regresar al menú principal
                                break;
                            default:
                                System.out.println("Opción inválida");
                                break;
                        }
                    } while (metodoUnidad1 != 0);
                    break;
                
            case 2:
                int metodoUnidad2;
                    do {
                        System.out.println("==========================================");
                        System.err.println("UNIDAD 2");
                        System.out.println("1=METODO DE ESQUINA SUPERIOR");
                        System.out.println("2=METODO DE VOGEL");
                        System.out.println("0-REGRESAR AL MENU PRINCIPAL");
                        System.out.println("SELECCIONA UNA OPCION:");

                        metodoUnidad2 = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer

                        switch (metodoUnidad2) {
                            case 1:
                                System.out.println("==========================================");
                                System.out.println("METODO DE ESQUINA SUPERIOR");
                                // Código para método de esquina superior en unidad 2
                                esqSup.ejecusionEsquinaSuperior();
                                break;
                            case 2:
                                System.out.println("==========================================");
                                System.out.println("METODO DE VOGEL");
                                // Código para método de Vogel en unidad 2
                                vogel.ejecusionvogel();
                                break;
                            case 0:
                                // Regresar al menú principal
                                break;
                            default:
                                System.out.println("Opción inválida");
                                break;
                        }
                    } while (metodoUnidad2 != 0);
                    break;
                
            case 3:
                int metodoUnidad3;
                    do {
                        System.out.println("==========================================");
                        System.out.println("UNIDAD 3");
                        System.out.println("1=METODO DE DICOTOMO");
                        System.out.println("2=METODO DE SECCION DORADA");
                        System.out.println("0-REGRESAR AL MENU PRINCIPAL");
                        System.out.println("SELECCIONA UNA OPCION:");

                        metodoUnidad3 = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer

                        switch (metodoUnidad3) {
                            case 1:
                                System.out.println("==========================================");
                                System.out.println("METODO DE DICOTOMO");
                                // Código para método de dicotomo en unidad 3
                                dicotomo.ejecusionDicotomo();
                                break;
                            case 2:
                                System.out.println("==========================================");
                                System.out.println("METODO DE SECCION DORADA");
                                // Código para método de sección dorada en unidad 3
                                secDor.ejecusionSeccionDorada();
                                break;
                            case 0:
                                // Regresar al menú principal
                                break;
                            default:
                                System.out.println("Opción inválida");
                                break;
                        }
                    } while (metodoUnidad3 != 0);
                    break;
            case 4:
                System.out.println("=========================================="); 
                System.err.println("UNIDAD 4");
                System.out.println("METODO DE EOQ");
                
                Scanner teclado = new Scanner (System.in);
                //declaracion de variables 
                double demanda, retencion, pedido, tiempo, diaria;
                double punorden,demdiaria,Npedidos, opdem;
                double opdemanda,invpromedio, invpromedio1,cosorden, manpedidoi;

                System.out.println("DAME LA TASA DE DEMANDA (D)");
                demanda=teclado.nextDouble();// Lee la tasa de demanda desde el teclado
       
                System.out.println("DAME EL COSTO DE RETENCION (h)");
                retencion=teclado.nextDouble(); // Lee el costo de retención desde el teclado
        
                System.out.println("DAME EL COSTO POR PERDIDO (K)");
                pedido=teclado.nextDouble();// Lee el costo por pedido desde el teclado     
        
                System.out.println("DAME LE TIEMPO DE ESPERA (L)");
                tiempo=teclado.nextDouble();// Lee el tiempo de espera desde el teclado
        
                System.out.println("DAME LA DEMANDIA DIARIA (d)");
                diaria=teclado.nextDouble();// Lee la demanda diaria desde el teclado
        
                System.err.println("\nCANTIDAD OPTIMA DE PEDIDO");
                opdem=2*(pedido * demanda) / retencion; // Calcula la cantidad óptima de pedido
                opdemanda= Math.sqrt(opdem);// Calcula la raíz cuadrada de la cantidad óptima
                System.out.println("La cantidad optima de pedido es: y=" +String.format("%.2f", opdemanda));
                //se imprime la cantidad optma de pedido
                System.out.println("La cantidad optima de pedido es (redondeado):" + Math.round(opdemanda));
                //se imprime el resultado redondeado
                
                System.err.println("\n PUNTO DE ORDEN");           
                demdiaria= demanda/diaria;//calcula la demanda diaria
                System.out.println("La demanda diaria es: D=" + String.format("%.2f", demdiaria));
                //impresion del resultado de la demanda diaria
                punorden=demdiaria*tiempo;//calcula el punto de orden
                System.out.println("EL PUNTO DE RETENCION ES: R="+ String.format("%.2f", punorden));
                //se imprime el resultado del puno de orden
                 
                System.err.println("\nTIEMPO DE CICLO EN INVENTARIO PROMEDIO");
                invpromedio= opdemanda / demanda;//calcula TIEMPO DE CICLO EN INVENTARIO PROMEDIO
                invpromedio1= opdemanda / 2;//calcula TIEMPO DE CICLO EN INVENTARIO PROMEDIO
                System.out.println("CICLO EN INVENTARIO PROMEDIO ES:  to=" + String.format("%.2f", invpromedio));
                //impresion del resultado
                System.out.println("to=" + String.format("%.2f", invpromedio1));
                //impresion de resultado
                  
                System.err.println("\nNUMERO DE PEDIDOS");
                Npedidos= demanda / opdemanda; //calcula NUMERO DE PEDIDOS
                System.out.println("EL NUMERO DE PEDIDOS ES:  N=" + String.format("%.2f", Npedidos));
                //imprime el rsultado de NUMERO DE PEDIDOS
                System.out.println("EL NUMERO DE PEDIDOS ES (redondeado):  y=" + Math.round( Npedidos));
                //imprime el resultado rendondeado
                
                System.err.println("\nCOSTO DE ORDEN");
                cosorden= pedido * (demanda / opdemanda);//calcula COSTO DE ORDEN
                System.out.println("EL COSTO DE ORDEN ES :" + String.format("%.2f", cosorden));
                //imprime el resultado de COSTO DE ORDEN
                
                System.err.println("\n MANTENER EL PEDIDO");
                manpedidoi= retencion * (invpromedio1);//clacula el MANTENER EL PEDIDO
                System.out.println("Mantener el pedido es: " + String.format("%.2f", manpedidoi));
                //impresion del resultado de MANTENER EL PEDIDO
                
                break;
                
            case 5:
                System.out.println("=========================================="); 
                System.err.println("UNIDAD 5");
                System.out.println("METODO DE LINEA DE ESPERA");
                Scanner teclado5 = new Scanner (System.in);
        
                //creacion de las variables 
                int espera, llegada, n;
                double unidades, tiempo5, promedio, filaf,probabilidad,elementos ;
        
                System.out.println("Dame la frecuencia de Llegada (i)");
                espera = teclado5.nextInt();
                System.out.println("------------------------------------");
                System.out.println("Dame la frecuencia de Salida (M)");
                llegada = teclado5.nextInt();
                System.out.println("-----------------------------------------------");
                System.out.println("Dame n");
                n=teclado5.nextInt();
                System.out.println("----------------------------------------------------------");
         
                // Solicitar al usuario ingresar la frecuencia de llegada (i)
                System.err.println("NUMERO DE UNIDADES EN EL SISTEMA");
                unidades = llegada-espera;
                double unidades2;
                unidades2 = espera / unidades; 
                System.out.println("Las unidad en el sistemas es: " + String.format("%.2f", unidades2));         
                System.out.println("------------------------------------------------------------------------");
         
                // Calcular el tiempo en el cual una unidad está en el sistema
                System.err.println("TIEMPO EN EL CUAL UNA UNIDAD ESTA EN EL SISTEMA");
                tiempo5 = (llegada-espera)/ 1;
                System.out.println("El tiempo en el cual la unidad esta en el sistema es: " +String.format("%.4f", tiempo5));
                System.out.println("------------------------------------------------------------------------");
         
                // Calcular el número promedio de unidades esperando en el sistema
                System.err.println("NUMERO PROMEDIO DE UNIDADES ESPERANDO EN EL SISTEMA");
                double elevado= Math.pow(espera, 2);
                promedio = elevado/ (llegada)*(llegada-espera);        
                System.out.println("El numero promedio de unidades esperando es de: " +String.format("%.4f", promedio));
                System.out.println("El numero promedio de unidades esperando es de (redondeado): " + Math.round(promedio));
                System.out.println("------------------------------------------------------------------------");
                // Calcular el tiempo en que una unidad espera en la fila
                System.err.println("TIEMPO EN QUE UNA UNIDAD ESPERE EN LA FILA");
                filaf = (llegada)*(llegada-espera);
                double filaf2 = espera/ filaf;
                System.out.println("El tiempo de una unidad espere en la fila es: " +String.format("%.4f", filaf2));
                System.out.println("------------------------------------------------------------------------");
         
                // Calcular el factor de uso del sistema
                System.err.println("FACTOR DE USO DEL SISTEMA");
                double factor = espera *(1); 
                double fac = factor / llegada;
                double factor2 = fac * 100;
                System.out.println("El factor de uso del sistema es: " + String.format("%.4f", fac));
                System.out.println("El factor de uso del sistema es(x 100): " + String.format("%.4f", factor2));
                System.out.println("------------------------------------------------------------------------");
         
                // Calcular la probabilidad de que ninguna unidad se encuentre en el sistema
                System.err.println("PROBABILIDAD DE QUE NINGUNA UNIDAD SE ENCUENTRE EN EL SISTEMA");
                probabilidad = 1- fac;
                double probabilidad2 = probabilidad * 100;
                System.out.println("La probabilida es: " + String.format("%.4f", probabilidad));
                System.out.println("La probabilidad es (x 100)" +String.format("%.4f", probabilidad2));
                System.out.println("------------------------------------------------------------------------");
        
                // Calcular la probabilidad de que se encuentren n elementos en el sistema
                System.err.println("PROBABILIAD QUE SE ENCUENTRE N ELEMENTOS EN EL SISTEMA");
                double factorp,elementos2, elem ;
                factorp = Math.pow(fac, n);
                elementos = 1-fac;
                elem= elementos * factorp;
                elementos2 = elem * 100;
                System.out.println("La probabilidad que se encuentre n elemenos es el sistema: " +String.format("%.4f", elem));
                System.out.println("La probabilidad que se encuentre n elemenos es el sistema: " + String.format("%.4f", elementos2));
                System.out.println("------------------------------------------------------------------------");
                break;
            case 0: // Salir
                    System.out.println("Saliendo del programa");
                    break;//roptura
                default:
                    System.out.println("Opción inválida");
                    break;//roptura    
       
                
        }    
        }while (opcion!=0);//Salida bucle do-while
        
        
        
        
    }
    
}

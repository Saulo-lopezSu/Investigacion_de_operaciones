//METODO DE ESQUINA SUPERIOR CORRRESPONDIENTE A LA UNIDAD 2
package investigacion_de_operaciones;

import java.util.Scanner;

public class EsquinaSuperior {
    public void ejecusionEsquinaSuperior() {// Inicio del método main
        try (Scanner scanner = new Scanner(System.in)){// Inicio del bloque try-with-resources para gestionar el Scanner
            // Solicitar y almacenar la cantidad de ofertas
            int ofertaPuntos = getIntegerInput(scanner, "Ingrese la cantidad de ofertas que se tiene:");
             // Solicitar y almacenar la cantidad de demandas
            int demandPuntos = getIntegerInput(scanner, "Ingrese la cantidad de demandas que se tiene:");
            // Solicitar y almacenar un arreglo de ofertas 
            int [] oferta = getInputArray(scanner, ofertaPuntos, "oferta-->");
             // Solicitar y almacenar un arreglo de demandas
            int [] demand = getInputArray(scanner, demandPuntos, "demanda-->");
             // Solicitar y almacenar una matriz de costos
            int [][] costMatrix = getCostMatrix(scanner, ofertaPuntos,demandPuntos);
            
            int [][] solucion = solveTransportProblem(costMatrix, oferta, demand);// Resolver el problema de transporte
            
            int minCost = calculateMinimumCost(costMatrix, solucion); // Calcular el costo mínimo
            System.out.println("\n Z minimo:"+minCost+"\n"); // Imprimir el costo mínimo
            
            printSolutionMatrix(solucion);// Imprimir la matriz de asignación
            
        }catch (Exception e){// Capturar y manejar excepciones
            System.out.println("Error:"+ e.getMessage()); // Imprimir un mensaje de error en caso de excepción  
        }
    }
    // Este método solicita un número entero al usuario y lo devuelve.
        private static int getIntegerInput(Scanner scanner, String prompt){
            System.out.println(prompt);// Muestra el mensaje de solicitud al usuario.
            return scanner.nextInt(); // Lee y devuelve un valor entero ingresado por el usuario.
        }    
        // Este método solicita al usuario un arreglo de números enteros y lo devuelve.
        private static int [] getInputArray(Scanner scanner, int length, String name){
            int [] array = new int [length];// Crea un arreglo de enteros de la longitud especificada.
            for (int i= 0; i< length; i++){
                  // Solicita al usuario la cantidad de un elemento específico en un punto dado.
                array[i] = getIntegerInput(scanner,"Ingrese la cantidad de la " + name +"en el punto " + (i + 1)+ ":");
            }
            return array;// Devuelve el arreglo lleno con los valores ingresados por el usuario.
        }
        // Este método solicita al usuario una matriz de costos y la devuelve.
        private static int [][]  getCostMatrix(Scanner scaner, int ofertaPoints, int demandPoints){
            int [][] matrix = new int [ofertaPoints] [demandPoints]; // Crea una matriz de enteros con las dimensiones especificadas.
            for (int i= 0; i < ofertaPoints; i++){
                for (int j= 0; j< demandPoints; j++){
                     // Solicita al usuario el costo de una ruta específica.
                    matrix [i][j] = getIntegerInput(scaner, "ingrese el costo de la ruta-> "+ (i + 1)+ "-"+ (j + i)+ ":");
                    
                }
            }
            return matrix;// Devuelve la matriz de costos completa.
        }
        // Este método resuelve el problema de transporte utilizando las matrices de costos, ofertas y demandas.
        private static int [][] solveTransportProblem (int[][] costMatrix, int [] oferta, int[] demand){
         int puntosOferta = oferta.length;
        int puntosDemanda = demand.length;
        int[][] solucion = new int[puntosOferta][puntosDemanda];// Crea una matriz de solución.
        int i = 0, j = 0;// Índices para recorrer la matriz de solución.

        while (i < puntosOferta && j < puntosDemanda) {
             // Encontrar la asignación mínima entre oferta y demanda en el punto actual.
            int asignacion = Math.min(oferta[i], demand[j]);

           // Realizar la asignación en la matriz de solución y actualizar oferta y demanda restantes.
            solucion[i][j] = asignacion;
            oferta[i] -= asignacion;
            demand[j] -= asignacion;

            // Mover a la siguiente fila o columna según sea necesario.
            if (oferta[i] == 0) {
                i++;
            }
            if (demand[j] == 0) {
                j++;
            }
        }

        return solucion;// Devuelve la matriz de solución resultante.
            
 
       }
        // Este método calcula el costo mínimo basado en la solución del problema de transporte.
        private static int calculateMinimumCost(int [][] costMatrix, int[][] solution){
        int zMin = 0;// Inicializa el costo mínimo en cero.
        int puntosOferta = costMatrix.length;
        int puntosDemanda = costMatrix[0].length;

        for (int i = 0; i < puntosOferta; i++) {
            for (int j = 0; j < puntosDemanda; j++) {
                // Multiplica la asignación en la solución por el costo correspondiente y suma al costo mínimo.
                zMin += solution[i][j] * costMatrix[i][j];
            }
        }

        return zMin;// Devuelve el costo mínimo calculado.
            
        }
        // Este método imprime la matriz de asignación en la consola.
        private static void printSolutionMatrix(int [][] solution){
            System.out.println("Matriz de asignacion");// Muestra un encabezado.
            for(int[] row: solution){
            for (int value : row){
                System.out.println(value + ""); // Imprime cada valor de la matriz con un espacio.
            }
            System.out.println();// Agrega una nueva línea después de imprimir una fila completa.
        }
        }
}

//METODO DE VOGEL CORRRESPONDIENTE A LA UNIDAD 2
package investigacion_de_operaciones;

import java.util.Scanner;

public class MetodoVogel {
    public void ejecusionvogel() {//inicia el metodo main
        // Se crea un objeto Scanner llamado scanner para leer datos de la entrada estándar.
        Scanner scanner = new Scanner (System.in);
        // Se llama a la función resolverProblema y se le pasa el objeto scanner como argumento.
        resolverProblema(scanner);
    }
    //método que coordina la resolución del problema y otras funciones para obtener datos, calcular asignaciones y mostrar resultados.
    public static void resolverProblema(Scanner scanner){
        int origenes = obtenerOrigenes(scanner);
        //Llama al método obtenerOrigenes para obtener el número de orígenes.
        int destinos = obtenerDestinos(scanner);
        //Llama al método obtenerDestinos para obtener el número de destinos.
        int [][] valores = obtenerValores(scanner, origenes, destinos);
        //Llama al método obtenerValores para obtener una matriz de costos.
        int [] oferta = obtenerOferta(scanner, origenes);
        //Llama al método obtenerOferta para obtener las ofertas.
        int [] demanda = obtenerDemandas(scanner, destinos);
        //Llama al método obtenerDemandas para obtener las demandas.
        imprimirValores(origenes, destinos, valores);
        //Llama al método imprimirValores para mostrar la matriz de costos.
        int [] res = calcularAsignacion(origenes, destinos, valores, oferta, demanda);
        //Llama al método calcularAsignacion para calcular la asignación.
        imprimirResultados(res, origenes, destinos, valores);
        //Llama al método imprimirResultados para mostrar los resultados.
    }
    //método se utiliza para solicitar una entrada entera al usuario y manejar excepciones en caso de entrada no válida.
    public static int verificarEntradaEntera(Scanner scanner, String prompt){
        while (true){//Un bucle infinito para continuar solicitando entrada hasta que sea válida.
            try{//: Intenta realizar la siguiente acción.
                System.out.println(prompt);//Muestra el mensaje de solicitud al usuario.
                return Integer.parseInt(scanner.nextLine());
                //Intenta convertir la entrada del usuario en un entero y lo devuelve.
            }catch (NumberFormatException e){
                //Captura una excepción si la entrada no se puede convertir en un entero.
                    System.out.println("Por favor ingrese un numero valido");
                    //Muestra un mensaje de error si la entrada no es válida.
            }
        }
    }
    //método se utiliza para obtener la matriz de costos a través de la entrada del usuario.
    public static int [][] obtenerValores(Scanner scanner, int origenes, int destinos){
        int [][] valores = new int [origenes][destinos];//Crea una matriz para almacenar los valores de costos.
        for (int x = 0; x< origenes; x++){//Un bucle que recorre los orígenes.
            for (int y = 0; y < destinos; y++){// Un bucle que recorre los destinos.
                valores[x][y] = verificarEntradaEntera(scanner, "introducir el valor del origen "+ (x + 1) + " al destino " + (y + +1)
                        + ":");
        //Utiliza el método verificarEntradaEntera para obtener y asignar cada valor de costos a la matriz valores.
            }
            
        }
        return valores;
    }
    // método se utiliza para obtener las ofertas de los orígenes a través de la entrada del usuario.
    public static int [] obtenerOferta(Scanner scanner, int origenes){
        int [] oferta = new int [origenes];//Crea un arreglo para almacenar las ofertas.
        for (int x = 0; x < origenes; x++){//Un bucle que recorre los orígenes.
            oferta [x] = verificarEntradaEntera(scanner, "introducor la oferta del origen " + (x + 1) + ":" );
            // Llama a la función verificarEntradaEntera para obtener el valor de oferta para cada origen.
        }
        return oferta;// Retorna el arreglo de ofertas.
    }
    //Este metodoDefine una función que recibe un objeto Scanner y la cantidad de destinos como un arreglo de demandas.
    public static int [] obtenerDemandas(Scanner scanner, int destinos){
        int[] demanda = new int [destinos];
        // Crea un arreglo de enteros llamado demanda con un tamaño igual a la cantidad de destinos.
        for(int y = 0; y< destinos; y++){// recorre cada destino (desde 0 hasta destinos - 1
            demanda[y] = verificarEntradaEntera(scanner, "Introducir la demanda del origen " + (y + 1) + " :");
    //Para cada destino, llama a la función verificarEntradaEntera para obtener el valor de la demanda desde la entrada del usuario.
        }
        return demanda;//Retorna el arreglo demanda que contiene las demandas de todos los destinos.
    } 
    //metodo que recibe un objeto Scanner y se utiliza para obtener el número de destinos desde la entrada del usuario.
    public static int obtenerDestinos(Scanner scanner){
        int aux;//declara aux
        while (true){
            //para repetir la solicitud hasta que se ingrese un número igual o mayor a 2.
            aux = verificarEntradaEntera(scanner, "Introducir el numero de destinos");
           //Llama a la función verificarEntradaEntera para obtener el número de destinos desde la entrada del usuario.
            if(aux >= 2){
                break;
            }
            System.out.println("Escribir un numero igual o mayor a dos");
        }
        return aux;//: Retorna el número de destinos ingresado.
    }
    //metodo que recibe un objeto Scanner y se utiliza para obtener el número de orígenes desde la entrada del usuario.
    public static int obtenerOrigenes(Scanner scanner){
        int aux; 
        while (true){
            //se utiliza un bucle while (true) para repetir la solicitud hasta que se ingrese un número igual o mayor a 2.
            aux = verificarEntradaEntera(scanner, "Introducir el numero de origenes: ");
            //Llama a la función verificarEntradaEntera para obtener el número de orígenes desde la entrada del usuario.
            if (aux >= 2 ){//Si el número ingresado (aux) es mayor o igual a 2, se sale del bucle while.
                break;
            }
            System.out.println("Escribir un numero igual o mayor a dos");
        }
        return aux;//Retorna el número de orígenes ingresado.
    }
    //metodo que Define una función para imprimir la matriz de costos en la consola.
    public static void imprimirValores (int origenes, int destinos, int[][] valores){
             System.out.println("Matriz de costos:");//mprime un encabezado para indicar que se muestra la matriz de costos.
             //Se utiliza un bucle anidado para recorrer cada elemento de la matriz valores.
        for (int i = 0; i < origenes; i++) {
            for (int j = 0; j < destinos; j++) {
                System.out.print(valores[i][j] + "\t");
                //Imprime cada valor de la matriz seguido de un tabulador para formatear la salida.
            }
            System.out.println();//Imprime un salto de línea para pasar a la siguiente fila de la matriz.
        }
    }
    public static int[] calcularAsignacion(int origenes, int destinos, int[][] valores, int[] oferta, int[] demanda){
    int[] res = new int[origenes * destinos];// Crea un arreglo para almacenar la asignación de unidades.
    int x = 0; // Inicializa una variable x para rastrear los orígenes.
    int y = 0;// Inicializa una variable y para rastrear los destinos.

    while (x < origenes && y < destinos) {// Inicia un bucle que se ejecuta mientras haya orígenes y destinos por asignar.
        int[] penalizacionesFilas = calcularPenalizacionesFilas(valores, oferta, demanda, origenes, destinos);
        // Calcula las penalizaciones por fila.
        int[] penalizacionesColumnas = calcularPenalizacionesColumnas(valores, oferta, demanda, origenes, destinos);
         // Calcula las penalizaciones por columna.

        int[] maxDifPenalizacion = encontrarMaxDifPenalizacion(penalizacionesFilas, penalizacionesColumnas, origenes, destinos);
        // Encuentra la mayor diferencia de penalización.
        int filaElegida = maxDifPenalizacion[0];// Obtiene la fila seleccionada.
        int columnaElegida = maxDifPenalizacion[1];// Obtiene la columna seleccionada

        if (filaElegida != -1 && columnaElegida != -1) {// Verifica si se pudo encontrar una asignación válida.
            int asignacion = Math.min(oferta[filaElegida], demanda[columnaElegida]);
            // Calcula la cantidad a asignar (la mínima entre oferta y demanda).
            res[filaElegida * destinos + columnaElegida] = asignacion;
            // Registra la asignación en la matriz de resultados.
            oferta[filaElegida] -= asignacion;// Actualiza la oferta restante.
            demanda[columnaElegida] -= asignacion;// Actualiza la demanda restante.

            //// Marca la fila como completa si se asignó toda la oferta.
            if (oferta[filaElegida] == 0) {
                penalizacionesFilas[filaElegida] = -1;
            }
            //// Marca la columna como completa si se asignó toda la demanda.
            if (demanda[columnaElegida] == 0) {
                penalizacionesColumnas[columnaElegida] = -1;
            }
        } else {
            break;//no se puede realizar una asignación válida, se sale del bucle.
        }
    }

    return res;// Retorna la matriz de asignación resultante
    } 
    //Define una función que calcula las penalizaciones por filas en la matriz de costos.
    public static int [] calcularPenalizacionesFilas (int[][] valores, int[] oferta, int[] demanda, int origenes, int destinos){
       int[] penalizacionesFilas = new int[origenes];//// Crea un arreglo para almacenar las penalizaciones por filas.
    
    for (int i = 0; i < origenes; i++) {// Inicia un bucle que recorre los orígenes.
        if (oferta[i] > 0) {// Verifica si hay oferta disponible en el origen.
            int min1 = Integer.MAX_VALUE;// Inicializa un valor mínimo 1 como máximo posible.
            int min2 = Integer.MAX_VALUE;// Inicializa un valor mínimo 2 como máximo posible.

            for (int j = 0; j < destinos; j++) {// Inicia un bucle que recorre los destinos.
                if (valores[i][j] < min1) {// Compara el valor actual con el mínimo 1.
                    min2 = min1;// Actualiza el mínimo 2 con el valor actual de mínimo 1.
                    min1 = valores[i][j]; // Actualiza el mínimo 1 con el nuevo valor mínimo.
                } else if (valores[i][j] < min2) {// Compara el valor actual con el mínimo 2.
                    min2 = valores[i][j];// Actualiza el mínimo 2 con el nuevo valor mínimo.
                }
            }

            penalizacionesFilas[i] = min2 - min1;// Calcula la penalización para la fila y la almacena en el arreglo.
        } else {
            penalizacionesFilas[i] = -1;// Si no hay oferta en el origen, se marca la fila con -1 (no se puede asignar).
        }
    }
    
    return penalizacionesFilas;// Retorna el arreglo de penalizaciones por filas resultante.
    }
    
//Metodo que define una función que calcula las penalizaciones por columnas en la matriz de costos
        public static int[] calcularPenalizacionesColumnas(int[][] valores, int[] oferta, int[] demanda, int origenes, int destinos){
              int[] penalizacionesColumnas = new int[destinos];// Crea un arreglo para almacenar las penalizaciones por columnas.

        for (int j = 0; j < destinos; j++) {// Inicia un bucle que recorre los destinos.
            if (demanda[j] > 0) {// Verifica si hay demanda disponible en el destino.
                int min1 = Integer.MAX_VALUE; // Inicializa un valor mínimo 1 como máximo posible.
                int min2 = Integer.MAX_VALUE;// Inicializa un valor mínimo 2 como máximo posible.

                for (int i = 0; i < origenes; i++) {// Inicia un bucle que recorre los orígenes.
                    if (valores[i][j] < min1) {// Compara el valor actual con el mínimo 1.
                        min2 = min1;// Actualiza el mínimo 2 con el valor actual de mínimo 1.
                        min1 = valores[i][j]; // Actualiza el mínimo 1 con el nuevo valor mínimo.
                    } else if (valores[i][j] < min2) {// Compara el valor actual con el mínimo 2.
                        min2 = valores[i][j];  // Actualiza el mínimo 2 con el nuevo valor mínimo.
                    }
                }

                penalizacionesColumnas[j] = min2 - min1; // Calcula la penalización para la columna y la almacena en el arreglo.
            } else {
                penalizacionesColumnas[j] = -1;
                // Si no hay demanda en el destino, se marca la columna con -1 (no se puede asignar).
            }
        }

        return penalizacionesColumnas;// Retorna el arreglo de penalizaciones por columnas resultante.
        }
 // Metodo que Define una función que busca la máxima diferencia de penalización y retorna la fila y la columna seleccionadas.     
    public static int[] encontrarMaxDifPenalizacion(int[] penalizacionesFilas, int[] penalizacionesColumnas, int origenes, 
            int destinos){
       int maxDifPenalizacion = 0;// Inicializa la variable para el valor máximo de diferencia de penalización.
    int filaElegida = -1;// Inicializa la variable para la fila elegida con -1 (sin selección).
    int columnaElegida = -1;// Inicializa la variable para la fila elegida con -1 (sin selección).
    for (int i = 0; i < origenes; i++) {// Inicia un bucle que recorre los orígenes.
        for (int j = 0; j < destinos; j++) {//Inicia un bucle que recorre los destinos.
            if (penalizacionesFilas[i] != -1 && penalizacionesColumnas[j] != -1) {
                //// Verifica que no haya penalizaciones marcadas con -1.
                int difPenalizacion = penalizacionesFilas[i] + penalizacionesColumnas[j];
                //// Calcula la diferencia de penalización sumando las penalizaciones de fila y columna.
                if (difPenalizacion > maxDifPenalizacion) {//// Compara la diferencia de penalización con el valor máximo actual.
                    maxDifPenalizacion = difPenalizacion;// Actualiza el valor máximo de diferencia de penalización.
                    filaElegida = i;// Almacena la fila elegida.
                    columnaElegida = j;// Almacena la columna elegida.
                }
            }
        }
    }
    
    return new int[]{filaElegida, columnaElegida};// Retorna un arreglo de dos enteros con la fila y columna elegidas.
        }
    //Metodo que define una función que calcula y retorna la suma mínima Z.   
    public static int calcularSumaZMinima(int[][] valores, int[] res){
        int sumaZMinima = 0;// Inicializa la variable para almacenar la suma mínima Z.
        System.out.println("\n Operacion");// Imprime una etiqueta para indicar que se mostrarán las operaciones.
        for (int i = 0; i < valores.length; i++ ){// Inicia un bucle que recorre las filas de la matriz "valores".
            for (int j = 0; j < valores[i].length; j++ ){
                //// Inicia un bucle anidado que recorre las columnas de la matriz "valores".
                int producto = valores[i][j] * res[i * valores[i].length + j];
                //// Calcula el producto de los valores de "valores" y "res" en la posición actual.
                System.out.println("Valor[" + i +"]["+ j +"] * Res["+ i +"]["+ j +"] =" + valores[i][j] + "*" + res[i * 
                valores[i].length + j] + " = " + producto);//// Imprime la operación actual.
                sumaZMinima += producto;// Agrega el producto actual a la suma total de Z mínima.
            }
        }
        return sumaZMinima; // Retorna el valor de la suma mínima Z.
    }
      public static void imprimirResultados(int[] res, int origenes, int destinos, int[][] valores) {
        // Imprimir la matriz de asignación
        System.out.println("\nMatriz de asignación:");
        for (int i = 0; i < origenes; i++) {
            // Inicia un bucle que recorre las filas de la matriz de asignación. La variable i representa la fila actual.
            for (int j = 0; j < destinos; j++) {
          //Inicia un bucle anidado que recorre las columnas de la matriz de asignación. La variable j representa la columna actual.
                System.out.print(res[i * destinos + j] + "\t");
                //: Imprime el valor de asignación en la posición correspondiente de la matriz de asignación.
            }
            System.out.println();
            //Agrega un salto de línea para pasar a la siguiente fila de la matriz de asignación.
        }

        // Calcular e imprimir la suma mínima Z
        int sumaZMinima = calcularSumaZMinima(valores, res);
        System.out.println("\nZ minimo: " + sumaZMinima);
        //Imprime la suma mínima Z en la consola, indicando su valor.
    }
}

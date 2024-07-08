//METODO SIMPLEX CORRRESPONDIENTE A LA UNIDAD 1
package investigacion_de_operaciones;

import java.util.Scanner;

public class METODOSIMPLEX {
    public void ejecusionSimplex (){
    Scanner scanner = new Scanner(System.in);

        resolverProblema(scanner);

        scanner.close();
    }

    public static void resolverProblema(Scanner scanner) {
        System.out.print("Ingrese el número de restricciones: ");
        int numRestricciones = scanner.nextInt();
        System.out.print("Ingrese el número de variables: ");
        int numVariables = scanner.nextInt();

        double[][] matrizSimplex = new double[numRestricciones + 1][numVariables + numRestricciones + 1];

        System.out.println("Ingrese los coeficientes de la función objetivo:");
        for (int i = 0; i < numVariables; i++) {
            System.out.print("Coeficiente x" + (i + 1) + ": ");
            matrizSimplex[0][i] = scanner.nextDouble();
        }

        for (int i = 1; i <= numRestricciones; i++) {
            System.out.println("Ingrese los coeficientes de la restricción " + i + ":");
            for (int j = 0; j < numVariables; j++) {
                System.out.print("Coeficiente x" + (j + 1) + ": ");
                matrizSimplex[i][j] = scanner.nextDouble();
            }
            matrizSimplex[i][numVariables + i - 1] = 1;
            System.out.print("Lado derecho de la restricción " + i + ": ");
            matrizSimplex[i][numVariables + numRestricciones] = scanner.nextDouble();
        }

        System.out.print("¿Desea maximizar (1) o minimizar (0)? ");
        int opcion = scanner.nextInt();
        if (opcion == 1) {
            for (int i = 0; i < numVariables; i++) {
                matrizSimplex[0][i] = -matrizSimplex[0][i];
            }
            System.out.println("Tabla Inicial:");
            mostrarTabla(matrizSimplex);

            boolean continuar = true;
            while (continuar) {
                int columnaPivote = encontrarColumnaPivote(matrizSimplex);
                if (columnaPivote == -1) {
                    continuar = false;
                } else {
                    int filaPivote = encontrarFilaPivote(matrizSimplex, columnaPivote);
                    if (filaPivote == -1) {
                        System.out.println("El problema no tiene solución óptima.");
                        return;
                    }
                    pivotar(matrizSimplex, filaPivote, columnaPivote);
                    System.out.println("Tabla Actual:");
                    mostrarTabla(matrizSimplex);
                }
            }

            System.out.println("Solución óptima:");
            mostrarTabla(matrizSimplex);
        } else {
            System.out.println("Esta implementación solo admite la maximización. Por favor, reinicie y seleccione maximizar (1).");
        }
    }
     public static void mostrarTabla(double[][] tabla) {
        int numFilas = tabla.length;
        int numColumnas = tabla[0].length;

        for (int j = 0; j < numColumnas; j++) {
            System.out.print("+---------------");
        }
        System.out.println("+");

        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                System.out.print("|");
                System.out.printf("%15.2f", tabla[i][j]);
            }
            System.out.println("|");
            for (int j = 0; j < numColumnas; j++) {
                System.out.print("+---------------");
            }
            System.out.println("+");
        }
    }

    public static int encontrarColumnaPivote(double[][] tabla) {
        int numColumnas = tabla[0].length;
        int columnaPivote = -1;
        double menorCoeficiente = Double.MAX_VALUE;
        for (int j = 0; j < numColumnas - 1; j++) {
            if (tabla[0][j] < menorCoeficiente) {
                menorCoeficiente = tabla[0][j];
                columnaPivote = j;
            }
        }
        if (menorCoeficiente >= 0) {
            return -1;
        }
        return columnaPivote;
    }

    public static int encontrarFilaPivote(double[][] tabla, int columnaPivote) {
        int numFilas = tabla.length - 1;
        int filaPivote = -1;
        double cocienteMinimo = Double.MAX_VALUE;
        for (int i = 1; i <= numFilas; i++) {
            if (tabla[i][columnaPivote] > 0) {
                double cociente = tabla[i][tabla[0].length - 1] / tabla[i][columnaPivote];
                if (cociente < cocienteMinimo) {
                    cocienteMinimo = cociente;
                    filaPivote = i;
                }
            }
        }
        if (filaPivote == -1) {
            return -1;
        }
        return filaPivote;
    }

    public static void pivotar(double[][] tabla, int filaPivote, int columnaPivote) {
        int numFilas = tabla.length;
        int numColumnas = tabla[0].length;

        double pivote = tabla[filaPivote][columnaPivote];
        for (int j = 0; j < numColumnas; j++) {
            tabla[filaPivote][j] /= pivote;
        }

        for (int i = 0; i < numFilas; i++) {
            if (i != filaPivote) {
                double factor = tabla[i][columnaPivote];
                for (int j = 0; j < numColumnas; j++) {
                    tabla[i][j] -= factor * tabla[filaPivote][j];
                }
            }
        }
    }
    
}

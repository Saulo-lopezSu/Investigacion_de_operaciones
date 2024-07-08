//METODO DE SECCION DORADA CORRRESPONDIENTE A LA UNIDAD 3
package investigacion_de_operaciones;

import java.util.ArrayList;
import java.util.Scanner;

public class SeccionDorada {
   
    public static double f(double x) {
        return Math.pow(x, 4) - 14 * Math.pow(x, 3) + 60 * Math.pow(x, 2) - 70 * x;
    }

    public void ejecusionSeccionDorada() {
        Scanner scanner = new Scanner(System.in);

        // Constante de la proporción áurea
        double phi = (1 + Math.sqrt(5)) / 2;

        // Definir los valores de a y b
        System.out.print("Ingrese el valor de a: ");
        double a = scanner.nextDouble();
        System.out.print("Ingrese el valor de b: ");
        double b = scanner.nextDouble();

        // Precisión deseada
        double precision = 0.3;

        // Iniciar el algoritmo de sección dorada
        int iteraciones = 0;
        ArrayList<Double> valores_f = new ArrayList<>();
        while ((b - a) > precision) {
            iteraciones++;
            double x1 = b - (b - a) / phi;
            double x2 = a + (b - a) / phi;
            if (f(x1) < f(x2)) {
                a = x1;
            } else {
                b = x2;
            }
            valores_f.add(f(x1));
        }

        // El resultado es el punto medio del intervalo final
        double resultado = (a + b) / 2;

        // Imprimir el resultado
        System.out.println("El valor de x que maximiza f(x) en el intervalo [a, b] es: " + resultado);

        // Imprimir las iteraciones realizadas
        System.out.println("Se realizaron " + iteraciones + " iteraciones.");

        // Imprimir los valores de f(x) en cada iteración
        System.out.println("Los valores de f(x) en cada iteración son: " + valores_f);
    }
}

//METODO GRAFICO CORRRESPONDIENTE A LA UNIDAD 1
package investigacion_de_operaciones;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MetodoGrafico {
    
    
    public void ejecusionGrafico () {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de restricciones: ");
        int n = scanner.nextInt();

        List<List<Double>> a = new ArrayList<>();
        List<Double> C = new ArrayList<>();

        System.out.print("¿Desea minimizar? (1 para Sí, 0 para No): ");
        boolean minimizar = scanner.nextInt() == 1;

        System.out.print("Ingrese la función objetivo (como lista separada por espacios): ");
        List<Double> z = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            z.add(scanner.nextDouble());
        }

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese los coeficientes de la restricción " + (i + 1) + " (como lista separada por espacios): ");
            List<Double> coeficientes = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                coeficientes.add(scanner.nextDouble());
            }
            a.add(coeficientes);
            System.out.print("Ingrese el valor de C para la restricción " + (i + 1) + ": ");
            C.add(scanner.nextDouble());
        }

        List<Double> puntoOptimo = metodoGrafico(a, C, n, minimizar, z);

        if (puntoOptimo != null) {
            System.out.println("Punto Optimo [x, y]: " + puntoOptimo);
            System.out.println("Valor de Z en punto Optimo: " + valorFuncionObjetivo(puntoOptimo, z));
        } else {
            System.out.println("No se encontró un punto óptimo.");
        }
    }

    public static List<Double> metodoGrafico(List<List<Double>> a, List<Double> C, int n, boolean minimizar, List<Double> z) {
        List<Double> m = new ArrayList<>();
        List<Double> b = new ArrayList<>();
        List<List<Double>> y = new ArrayList<>();
        List<List<Double>> A = new ArrayList<>();
        List<Double> a1 = new ArrayList<>();
        List<Double> a2 = new ArrayList<>();
        List<Double> c = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a1.add(a.get(i).get(0));
            a2.add(a.get(i).get(1));
            c.add(C.get(i));
        }

        a1.add(0.0);
        a2.add(1.0);
        a1.add(0.0);
        a2.add(0.0);
        c.add(0.0);
        c.add(0.0);

        for (int i = 0; i < n + 2; i++) {
            if (a2.get(i) == 0) {
                m.add(Double.POSITIVE_INFINITY);
                b.add(c.get(i));
                List<Double> aux = new ArrayList<>();
                aux.add(m.get(0));
                aux.add(b.get(0));
                A.add(aux);
            } else {
                m.add(-a1.get(i) / a2.get(i));
                b.add(c.get(i) / a2.get(i));
                List<Double> aux = new ArrayList<>();
                aux.add(m.get(i));
                aux.add(b.get(i));
                A.add(aux);
            }
        }

        List<List<Double>> puntos = encontrarPuntos(m, b, n + 2);
        List<List<Double>> puntosExtremo = encontrarPuntosExtremo(puntos, a1, a2, c, n);

        int funcionObjetivo;
        int puntoOptimoIdx;
        if (minimizar) {
            funcionObjetivo = Integer.MAX_VALUE;
            puntoOptimoIdx = -1;
            for (int i = 0; i < puntosExtremo.size(); i++) {
                double valorFuncion = (z.get(0) * puntosExtremo.get(i).get(0)) + (z.get(1) * puntosExtremo.get(i).get(1));
                if (valorFuncion < funcionObjetivo) {
                    funcionObjetivo = (int) valorFuncion;
                    puntoOptimoIdx = i;
                }
            }
        } else {
            funcionObjetivo = Integer.MIN_VALUE;
            puntoOptimoIdx = -1;
            for (int i = 0; i < puntosExtremo.size(); i++) {
                double valorFuncion = (z.get(0) * puntosExtremo.get(i).get(0)) + (z.get(1) * puntosExtremo.get(i).get(1));
                if (valorFuncion > funcionObjetivo) {
                    funcionObjetivo = (int) valorFuncion;
                    puntoOptimoIdx = i;
                }
            }
        }

        if (puntoOptimoIdx != -1) {
            return puntosExtremo.get(puntoOptimoIdx);
        } else {
            return null;
        }
    }

    public static List<List<Double>> encontrarPuntos(List<Double> m, List<Double> b, int n) {
        List<List<Double>> puntos = new ArrayList<>();
        int numPuntos = 0;

        for (int i = 0; i < n; i++) {
            if (Double.isInfinite(m.get(i))) {
                for (int j = 0; j < n; j++) {
                    if (!m.get(i).equals(m.get(j))) {
                        double puntoY = (b.get(i) * m.get(j)) + b.get(j);
                        if (!puntos.contains(Arrays.asList(b.get(i), puntoY)) && !Double.isNaN(puntoY)) {
                            puntos.add(Arrays.asList(b.get(i), puntoY));
                            numPuntos++;
                        }
                    }
                }
            } else {
                for (int j = 0; j < n - i - 1; j++) {
                    if (!m.get(i).equals(m.get(j + i))) {
                        double puntoX = (b.get(j + i) - b.get(i)) / (m.get(i) - m.get(j + i));
                        double puntoY = (puntoX * m.get(j + i)) + b.get(j + i);
                        if (!puntos.contains(Arrays.asList(puntoX, puntoY)) && !Double.isNaN(puntoY)) {
                            puntos.add(Arrays.asList(puntoX, puntoY));
                            numPuntos++;
                        }
                    }
                }
            }
        }
        return puntos;
    }

    public static List<List<Double>> encontrarPuntosExtremo(List<List<Double>> puntos, List<Double> a1, List<Double> a2, List<Double> c, int n) {
        List<List<Double>> puntosExtremo = new ArrayList<>();
        int numPuntosExtremos = 0;

        for (List<Double> punto : puntos) {
            int cont = 0;
            for (int j = 0; j < n; j++) {
                if (punto.get(0) < 0 || punto.get(1) < 0 || Double.isNaN(punto.get(0)) || Double.isNaN(punto.get(1))) {
                    cont++;
                } else {
                    if ((a1.get(j) * punto.get(0)) + (a2.get(j) * punto.get(1)) > c.get(j)) {
                        cont++;
                    }
                }
            }
            if (cont == 0) {
                puntosExtremo.add(punto);
                numPuntosExtremos++;
            }
        }

        Collections.sort(puntosExtremo, new Comparator<List<Double>>() {
            @Override
            public int compare(List<Double> p1, List<Double> p2) {
                return p1.get(0).compareTo(p2.get(0));
            }
        });

        return puntosExtremo;
    }

    public static double valorFuncionObjetivo(List<Double> punto, List<Double> z) {
        return z.get(0) * punto.get(0) + z.get(1) * punto.get(1);
    }
}
    
    
    


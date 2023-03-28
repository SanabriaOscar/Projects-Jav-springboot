package com.example.AlgoritmosYMas;

public class AlgoritmoBusqueda {
    public static void main(String[] args) {
// Algoritmo de Búsqueda en Java
// Paso 1: Declarar una lista de enteros y asignar valores
        int[] lista = { 2, 3, 7, 15, 20 };
// Paso 2: Declarar el valor a buscar
        int valor = 15;
// Paso 3: Establecer un índice inicial en 0
        int i = 0;
// Paso 4: Recorrer la lista
        while (i < lista.length) {
            // Paso 5: Comparar el valor con el elemento actual
            if (valor == lista[i]) {
                // Paso 6: Si el valor coincide con el elemento, imprimir el índice
                System.out.println("El valor se encuentra en el índice: " + i);
                break;
            }
            // Paso 7: Incrementar el índice
            i++;
        }


    }
}
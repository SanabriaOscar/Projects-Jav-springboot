package com.example.AlgoritmosYMas;

public class AlgoritmoBurbuja {
    public static void main(String[] args) {

        int[] array = {3,60,35,2,45,320,5};
        // Paso 1: Establecemos el número de pasadas
        int numPasadas = array.length - 1;
        // Paso 2: Repetimos el proceso de ordenación
        for (int i = 0; i < numPasadas; i++) {
            // Paso 3: Compara cada elemento con el siguiente
            for (int j = 0; j < numPasadas - i; j++) {
                // Paso 4: Si el elemento de la izquierda es mayor que el de la derecha, intercambiamos los valores
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        // Paso 5: Imprimimos el resultado
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }
}

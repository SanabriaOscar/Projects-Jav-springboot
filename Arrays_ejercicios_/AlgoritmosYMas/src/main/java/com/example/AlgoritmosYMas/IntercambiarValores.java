package com.example.AlgoritmosYMas;

public class IntercambiarValores {
    public static void main(String[] args) {


       // 1. Dado un array de enteros, escribir una función para intercambiar los valores de dos índices.


        int array[]={3,2,5,5,6};

        for (int i=0;  i<array.length; i++){
            System.out.println("test "+ array[i]);

            for (int j=0; j<array.length-i; j++){
                int order= array[i];

            }

        }

        for (int i=0; i <array.length; i++){
            System.out.println("resul"+ array[i]);
        }
        intercambiarValores(new int[]{3, 4, 6, 7}, 0, 2);
    }
    public static void intercambiarValores(int[] array, int indice1, int indice2) {
        int auxiliar = array[indice1];
        array[indice1] = array[indice2];
        array[indice2] = auxiliar;
        System.out.println("auxiliar"+ auxiliar);
        System.out.println("array[indice1]"+ array[indice1]);
        System.out.println("array[indice2]"+ array[indice2]);

       for (int i=0; i<array.length;i++){
           System.out.println("array"+ array[i]);
       }
    }
}

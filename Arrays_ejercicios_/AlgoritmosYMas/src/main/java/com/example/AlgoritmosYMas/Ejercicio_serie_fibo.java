package com.example.AlgoritmosYMas;

import ch.qos.logback.core.status.OnConsoleStatusListener;

public class Ejercicio_serie_fibo {
    public static void main(String[] args) {
        printSerie(2);
        sumafibo();
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int multiplicador = 2;

        int filas = matriz.length;
        int columnas = matriz[0].length;

        int[][] resultado = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz[i][j] * multiplicador;
            }
        }

        // Imprimir la matriz resultante
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static Object printSerie(int num){

        int [] testnew = new int[num];
        for (int i=0; i<testnew.length; i++) {
            testnew[i]=i+1;

        }
        for (int i=0; i<testnew.length; i++){
            System.out.println(testnew[i]);
        }
        return  null;
    }
    public  static Object sumafibo(){
        int num=12;
        for (int i=0; i<num; i++){
            while(i<num);
            System.out.println("print"+i);
        }
        return null;
    }
}

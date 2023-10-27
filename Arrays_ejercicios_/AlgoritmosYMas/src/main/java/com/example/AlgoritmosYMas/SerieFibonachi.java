package com.example.AlgoritmosYMas;

public class SerieFibonachi {
    public static void main(String[] args) {

        fibo(6);
    }

    public static int fibo(int num) {
        int a = 0;
        int b = 1;
        int suma = a;

        System.out.print(suma + " ");

        for (int i = 0; i < num; i++) {
            int c = a + b;
            suma += c;

            System.out.print(suma + " ");

            a = b;
            b = c;
        }


        System.out.println(suma);
        return suma;
    }
}

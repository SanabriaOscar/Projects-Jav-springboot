package com.example.AlgoritmosYMas;

public class BuscarUnCaracterRepetido {
    public static void main(String[] args) {
        contarCaracteres(new char[]{2,3,4,4,8,5,3,4}, (char) 4);
    }
    public static int contarCaracteres(char[] array, char caracterABuscar) {
        int contador = 0;

        for(int i = 0; i < array.length; i++) {
            if(array[i] == caracterABuscar) {
                contador++;
            }
        }
        System.out.println("repetido "+contador);
        return contador;
    }
}

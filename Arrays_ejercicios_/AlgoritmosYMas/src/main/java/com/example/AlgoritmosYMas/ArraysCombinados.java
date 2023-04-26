package com.example.AlgoritmosYMas;

public class ArraysCombinados {
   /* public static void main(String[] args) {
        combinarArrays(new int[]{2,4,5,6}, new int[]{2,4,5,6} );
    }*/
    public static int[] combinarArrays(int[] array1, int[] array2) {
        int[] combinado = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, combinado, 0, array1.length);
        System.arraycopy(array2, 0, combinado, array1.length, array2.length);
        return combinado;
    }
}

package com.example.AlgoritmosYMas;

public class Comparar2Arrays {
    public static void main(String[] args) {

        commonElements(new int[]{2,3,5,4,5}, new int[]{5,6,7, 5,8});
    }

    public static void commonElements(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    System.out.println(array1[i]);
                }
            }
        }
    }
}

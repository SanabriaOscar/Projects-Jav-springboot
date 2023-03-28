package com.example.AlgoritmosYMas;

public class NumeroMayorArray {
    public static void main(String[] args) {
        numeromayor(new int[]{3,5,7,9});
    }

    public  static int numeromayor(int[]array) {
        int max=array[0];
        for(int i=0; i<array.length;i++){
            if (array[i]>max) {
                max=array[i];
            }

        }
       System.out.println("numero mayor"+max);
        return max;
    }
}

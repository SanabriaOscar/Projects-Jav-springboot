package com.example.AlgoritmosYMas;

public class SumaNumerosArray {
    public static void main(String[] args) {
        sumarNumeros(new int[]{3,4,6,7,7,9});
    }
   public  static int sumarNumeros(int []array){
       int result=0;
        for (int i=0; i<array.length; i++){
            result += array[i];

       }
       System.out.println("este es el resultado"+result);
        return result;
   }
}

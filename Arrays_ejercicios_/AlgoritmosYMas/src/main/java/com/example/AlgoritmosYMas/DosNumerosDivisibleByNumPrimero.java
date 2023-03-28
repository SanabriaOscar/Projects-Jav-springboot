package com.example.AlgoritmosYMas;

public class DosNumerosDivisibleByNumPrimero {
    public static void main(String[] args) {
        numDivisble(20, 5);
    }

    public static boolean  numDivisble(int num1, int num2){

        boolean result=num1 % num2 == 0;

        if(result==true){
            System.out.println("si es divisible");
        }
        else {
            System.out.println("no jodimos no es divisible");
        }
     return result;


    }
}

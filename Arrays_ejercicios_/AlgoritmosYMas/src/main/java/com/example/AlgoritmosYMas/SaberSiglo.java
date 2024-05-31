package com.example.AlgoritmosYMas;

public class SaberSiglo {
    public static void main(String[] args) {
        findSiglo(1999);
    }
    public static  int findSiglo(int year){
        int num=(year+99)/100;
        System.out.println("este es el siglo "+num);
        return num;
    }
}

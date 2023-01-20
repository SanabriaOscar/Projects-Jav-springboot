package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	int num1 =0;
        int num2 =0;
        int res =0;

        Scanner op =new Scanner(System.in);
        System.out.println("Ingresar el primer numero");
        num1=op.nextInt();
        System.out.println("Ingresar el segundo numero");
        num2=op.nextInt();
        res=(num1+num2);
        System.out.println("El resutado es "+ res);


    }
}

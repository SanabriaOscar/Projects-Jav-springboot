package com.example.challengespringboottesting.model;

import java.text.DecimalFormat;

public class test {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0000000");

    Long num=1L;
            System.out.println("the format is rigth: "+df.format(num));
    }
}

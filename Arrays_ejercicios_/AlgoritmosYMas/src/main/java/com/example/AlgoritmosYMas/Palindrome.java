package com.example.AlgoritmosYMas;

public class Palindrome {
    public static void main(String[] args) {
        isPalindrome("clocomotora");

    }
    public static boolean isPalindrome(String letra){
        int i=0;
        int j=letra.length()-1;
       while (i<j){
           if (letra.charAt(i)!=letra.charAt(j) ){
               System.out.println("no es palindrome");
               return false;
           }
           i++;
           j--;
       }
        System.out.println("si es palindrome");
        return true;
    }
}

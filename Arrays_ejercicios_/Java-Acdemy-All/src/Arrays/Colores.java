package Arrays;

import java.util.Arrays;

public class Colores {
    public static void main(String[] args) {
       // String [] colores =new String[]{"blur", "yellow", "black"};
        String [] colores =new String[2];

//        System.out.println(colores[0]);
//        System.out.println(colores[1]);
//        System.out.println(colores[2]);
//        System.out.println(Arrays.toString(colores));
        colores[0]="red";
        colores[1]="green";

        for (int i = 0; i < colores.length; i++) {
            System.out.println(colores[i]);
        }

    }
}

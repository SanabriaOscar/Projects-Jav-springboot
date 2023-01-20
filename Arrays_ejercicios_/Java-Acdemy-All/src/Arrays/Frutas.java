package Arrays;

import java.util.Arrays;

public class Frutas {
    public static void main(String[] args) {
        String frutas2[]=new  String[]{"fresa","pera"};

        System.out.println(frutas2.length);
        System.out.println(Arrays.toString(frutas2));
        System.out.println(frutas2[0]);
        System.out.println(frutas2[1]);
        System.out.println("\n");
        System.out.println( "////////////////////");
        String frutas[] =new String[3];

        frutas[0]="lulo";
        frutas[1]="mora";
        frutas[2]="banano";

        for (int i = 0; i < frutas.length; i++) {
            System.out.println(frutas[i]);
        }
    }

}

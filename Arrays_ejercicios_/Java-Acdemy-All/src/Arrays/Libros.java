package Arrays;

import java.util.Arrays;

public class Libros {
    public static void main(String[] args) {
      /*  String libros[]=new String[5];

        libros[0]="principito";
        libros[1]="100 años de soledad";
        libros[2]="algebra";
        libros[3]="el quijote";
        libros[4]="el señor de los anillos";

        for (int i = 0; i < libros.length ; i++) {
            System.out.println(libros[i]);
        }
        System.out.println("\n");
        System.out.println(libros[3]);*/

        String libros[]=new String[]{"algebra", "quimica", "fisica"};

        for (int i = 0; i <libros.length ; i++) {
            System.out.println(libros[i]);
        }
        System.out.println(Arrays.toString(libros));

    }
}

package Arrays;

public class Animales {
    //public static String[]animales=new String[]{"perro", "gato", "paloma"};
    public  static String[]animales =new  String[3];
    public static void main(String[] args) {
     /*   System.out.println(animales[0]);
        System.out.println(animales[1]);
        System.out.println(animales[2]);*/

        animales[0]="perro";
        animales[1]="gato";

        for (int i = 0; i < animales.length; i++) {
            System.out.println(animales[i]);
        }
    }

}

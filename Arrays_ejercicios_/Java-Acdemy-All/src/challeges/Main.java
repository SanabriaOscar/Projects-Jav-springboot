package challeges;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);

        System.out.println();

        Memory memory =new Memory();
        memory.printMemory();

        SystemProcess systemProcess= new SystemProcess();
        AplicationProcess aplicationProcess= new AplicationProcess();
        System.out.println("digite un valor");
        String first1 = scanner.next();

        System.out.println(first1);
        memory.addproces(systemProcess);
        System.out.println("lllll");
        memory.addproces(aplicationProcess);
        System.out.println("lllll");
        System.out.println("se está borrando");
       memory.deleteProces(aplicationProcess.getId());

        //System.out.println(systemProcess.getFormatId());
       // System.out.println(aplicationProcess.getFormatId());
    }
}

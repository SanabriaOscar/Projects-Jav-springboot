import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PasswordCracker {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("insert into password");

        List <String> pass= Arrays.asList(scanner.nextLine().toLowerCase().split("\\s+"));
        System.out.println(pass);
        System.out.println("insert into second  password");
        String secondPass=scanner.nextLine();
        System.out.print("Common elements: " +pass.stream().filter(secondPass::contains).collect(Collectors.toList()));

    }




}

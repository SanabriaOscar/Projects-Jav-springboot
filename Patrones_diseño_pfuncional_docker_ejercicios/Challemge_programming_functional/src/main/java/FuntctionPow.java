import java.text.DecimalFormat;
import java.util.Scanner;

public class FuntctionPow {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.0000");
        Scanner scanner =new Scanner(System.in);

        System.out.printf("Add input data count");
        int input=scanner.nextInt();

        double num;

        for (int i = 0; i < input; i++) {
            System.out.println("Add number for evaluate");
            num= scanner.nextDouble();
            System.out.println(df.format(evaluate(num, 9)));
        }
//        System.out.println(df.format(evaluate(20.0000, 9)));
//        System.out.println(df.format(evaluate(5.0000, 9)));
//        System.out.println(df.format(evaluate(0.5000, 9)));
//        System.out.println(df.format(evaluate(-0.5000, 9)));
    }


    static Double evaluate(double x, int power){
         if(power == 0) {
             return 1.0;
        } else{
            return Power(x, power)/factorial(power) + evaluate(x, power - 1);
        }

    }

    static Integer factorial(int number){
        if(number == 1){
            return 1;
        }else{
            return factorial(number -1 ) * number;
        }
    }

    static Double Power(double base, int pow){
        if(pow == 0){
            return 1.0;
        }else{
            return base * Power(base, pow -1);
        }
    }
















}

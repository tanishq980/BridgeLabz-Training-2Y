import java.util.Scanner;

public class java3 {
    public static void main(String[] args) {
        System.out.println("temperature in Celsius as input:");
        Scanner sc=new Scanner(System.in);
        float temp1=sc.nextFloat();
        System.out.printf("Fahrenheit Temperature: %f",((temp1*9)/5)+32);
    }
}
    


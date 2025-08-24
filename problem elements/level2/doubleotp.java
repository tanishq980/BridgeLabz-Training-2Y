import java.util.Scanner;

public class doubleotp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number 1 as input:");
        double a=sc.nextFloat();
        System.out.println("Enter number 2 as input:");
        double b=sc.nextFloat();
        System.out.println("Enter number 3 as input:");
        double c=sc.nextFloat();
        System.out.printf("The results of Int Operations are  %.2f, %.2f, %.2f and %.2f",a + b *c, a * b + c, c + a /b, a % b + c);
    }

}
import java.util.Scanner;

public class power {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("base as input:");
        double b=sc.nextFloat();
        System.out.println("exponent as input:");
        double e=sc.nextFloat();
        System.out.printf("Perimeter: %.2f",Math.pow(b,e));
    }
}
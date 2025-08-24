import java.util.Scanner;

public class java5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Radius as input:");
        float r=sc.nextFloat();
        System.out.println("height as input:");
        float h=sc.nextFloat();
        System.out.printf("Volume of a Cylinder: %.2f",Math.PI* r *r  * h);
    }
}
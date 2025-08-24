import java.util.Scanner;

public class intoperations {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number 1 as input:");
        int a=sc.nextInt();
        System.out.println("Enter number 2 as input:");
        int b=sc.nextInt();
        System.out.println("Enter number 3 as input:");
        int c=sc.nextInt();
        System.out.printf("The results of Int Operations are  %d, %d, %d and %d",a + b *c, a * b + c, c + a /b, a % b + c);
    }

}
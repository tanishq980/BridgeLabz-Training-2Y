import java.util.Scanner;

public class simpleinterest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Principal as input:");
        float p=sc.nextFloat();
        System.out.println("Rate as input:");
        float r=sc.nextFloat();
        System.out.println("Time as input:");
        float t=sc.nextFloat();
        System.out.printf("Simple Interest: %.2f",p*t*r/100);
    }
}
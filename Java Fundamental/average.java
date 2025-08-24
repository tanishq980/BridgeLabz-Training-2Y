import java.util.Scanner;

public class average {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Num 1 as input:");
        float n1=sc.nextFloat();
        System.out.println("Num 2 as input:");
        float n2=sc.nextFloat();
        System.out.println("Num 3 as input:");
        float n3=sc.nextFloat();
        System.out.printf("Simple Interest: %.2f",(n1+n2+n3)/3);
    }
}
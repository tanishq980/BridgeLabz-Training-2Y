import java.util.Scanner;

public class operations2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number 1 as input:");
        int t=sc.nextInt();
        System.out.println("Enter number 2 as input:");
        int t1=sc.nextInt();
        System.out.printf("The Quotient is %d and Reminder is %d of two number %d and %d",t/t1,t%t1,t,t1);
    }

}
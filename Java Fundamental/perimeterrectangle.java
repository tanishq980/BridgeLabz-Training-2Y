import java.util.Scanner;

public class perimeterrectangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("length as input:");
        float l=sc.nextFloat();
        System.out.println("width as input:");
        float w=sc.nextFloat();
        System.out.printf("Perimeter: %.2f",2*(l+w));
    }
}
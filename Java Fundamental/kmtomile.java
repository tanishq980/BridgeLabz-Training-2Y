import java.util.Scanner;

public class kmtomile {
    public static void main(String[] args) {
        System.out.println("Enter km as input:");
        Scanner sc=new Scanner(System.in);
        double km=sc.nextDouble();
        System.out.printf("the distance %.2f km in miles is %.2f. ",km,km*0.62137);
    }

}
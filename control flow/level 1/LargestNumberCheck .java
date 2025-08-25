import java.util.Scanner;

public class LargestNumberCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter the first number: ");
        double number1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double number2 = scanner.nextDouble();

        System.out.print("Enter the third number: ");
        double number3 = scanner.nextDouble();

        // Find the largest number
        double max = Math.max(number1, Math.max(number2, number3));

        // Output
        System.out.println("Is the first number the largest? " + (number1 == max ? "Yes" : "No"));
        System.out.println("Is the second number the largest? " + (number2 == max ? "Yes" : "No"));
        System.out.println("Is the third number the largest? " + (number3 == max ? "Yes" : "No"));
        
        scanner.close();
    }
}

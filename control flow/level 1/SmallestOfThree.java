import java.util.Scanner;

public class SmallestOfThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter first number: ");
        int number1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int number2 = scanner.nextInt();

        System.out.print("Enter third number: ");
        int number3 = scanner.nextInt();

        // Check if first number is the smallest
        boolean isSmallest = number1 < number2 && number1 < number3;

        // Output
        System.out.println("Is the first number the smallest? " + isSmallest);

        scanner.close();
    }
}

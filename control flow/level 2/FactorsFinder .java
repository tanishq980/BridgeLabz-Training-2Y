import java.util.Scanner;

public class FactorsFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter a number
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Validate input
        if (number <= 0) {
            System.out.println("Please enter a valid positive integer.");
        } else {
            System.out.println("Factors of " + number + " are:");
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    System.out.print(i + " ");
                }
            }
        }

        scanner.close();
    }
}

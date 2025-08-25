import java.util.Scanner;

public class GreatestFactorWhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Validate input
        if (number <= 1) {
            System.out.println("No proper factors exist for " + number + ".");
        } else {
            int i = number - 1;
            int greatestFactor = 1;

            // Loop to find the greatest factor using while
            while (i >= 1) {
                if (number % i == 0) {
                    greatestFactor = i;
                    break; // First (largest) factor found
                }
                i--;
            }

            // Output
            System.out.println("Greatest factor of " + number + " (excluding itself) is: " + greatestFactor);
        }

        scanner.close();
    }
}

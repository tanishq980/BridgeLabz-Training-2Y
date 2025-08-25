import java.util.Scanner;

public class GreatestFactorFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Validate input
        if (number <= 1) {
            System.out.println("No proper factors exist for " + number + ".");
        } else {
            int greatestFactor = 1;

            // Loop from number - 1 down to 1
            for (int i = number - 1; i >= 1; i--) {
                if (number % i == 0) {
                    greatestFactor = i;
                    break;  // First (largest) factor found
                }
            }

            // Output
            System.out.println("Greatest factor of " + number + " (excluding itself) is: " + greatestFactor);
        }

        scanner.close();
    }
}

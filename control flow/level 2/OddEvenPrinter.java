import java.util.Scanner;

public class OddEvenPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        System.out.println("\nEven numbers from 1 to " + number + ":");
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println("\n\nOdd numbers from 1 to " + number + ":");
        for (int i = 1; i <= number; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }

        scanner.close();
    }
}

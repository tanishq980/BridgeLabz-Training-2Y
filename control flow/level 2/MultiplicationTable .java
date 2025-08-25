import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter a number
        System.out.print("Enter a number to print its multiplication table (from 6 to 9): ");
        int number = scanner.nextInt();

        System.out.println("\nMultiplication Table of " + number + " (from 6 to 9):");
        for (int i = 6; i <= 9; i++) {
            int result = number * i;
            System.out.println(number + " x " + i + " = " + result);
        }

        scanner.close();
    }
}

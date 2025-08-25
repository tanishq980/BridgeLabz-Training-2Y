import java.util.Scanner;

public class PowerCalculatorWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input base and exponent
        System.out.print("Enter the base number: ");
        double base = scanner.nextDouble();

        System.out.print("Enter the exponent (integer): ");
        int exponent = scanner.nextInt();

        double result = 1;
        int absExponent = Math.abs(exponent);
        int count = 0;

        // Calculate power using while loop
        while (count < absExponent) {
            result *= base;
            count++;
        }

        // Handle negative exponents
        if (exponent < 0) {
            result = 1 / result;
        }

        System.out.println(base + " raised to the power " + exponent + " is: " + result);

        scanner.close();
    }
}

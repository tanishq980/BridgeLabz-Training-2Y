import java.util.Scanner;

public class PowerCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input base and exponent
        System.out.print("Enter the base number: ");
        double base = scanner.nextDouble();

        System.out.print("Enter the exponent (integer): ");
        int exponent = scanner.nextInt();

        double result = 1;

        // Handle negative exponents
        int absExponent = Math.abs(exponent);

        for (int i = 1; i <= absExponent; i++) {
            result *= base;
        }

        if (exponent < 0) {
            result = 1 / result;
        }

        System.out.println(base + " raised to the power " + exponent + " is: " + result);

        scanner.close();
    }
}

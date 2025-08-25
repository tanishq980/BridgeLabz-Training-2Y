import java.util.Scanner;

public class SumNaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number n: ");
        int n = scanner.nextInt();

        // Sum using while loop
        int sumWhile = 0;
        int i = 1;
        while (i <= n) {
            sumWhile += i;
            i++;
        }

        // Sum using formula
        int sumFormula = n * (n + 1) / 2;

        // Display results
        System.out.println("Sum calculated using while loop: " + sumWhile);
        System.out.println("Sum calculated using formula: " + sumFormula);

        if (sumWhile == sumFormula) {
            System.out.println("Both results are correct and equal.");
        } else {
            System.out.println("Results differ! Check the calculations.");
        }

        scanner.close();
    }
}

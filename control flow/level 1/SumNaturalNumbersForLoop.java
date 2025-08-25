import java.util.Scanner;

public class SumNaturalNumbersForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number n: ");
        int n = scanner.nextInt();

        int sumFor = 0;
        for (int i = 1; i <= n; i++) {
            sumFor += i;
        }

        int sumFormula = n * (n + 1) / 2;

        System.out.println("Sum calculated using for loop: " + sumFor);
        System.out.println("Sum calculated using formula: " + sumFormula);

        if (sumFor == sumFormula) {
            System.out.println("Both results are correct and equal.");
        } else {
            System.out.println("Results differ! Check the calculations.");
        }

        scanner.close();
    }
}

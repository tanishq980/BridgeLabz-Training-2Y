import java.util.Scanner;

public class DivisibleByFive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Check divisibility
        boolean isDivisible = number % 5 == 0;

        // Output
        System.out.println("Is the number " + number + " divisible by 5? " + isDivisible);

        scanner.close();
    }
}


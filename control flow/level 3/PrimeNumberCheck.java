import java.util.Scanner;

public class PrimeNumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // A number less than or equal to 1 is NOT a prime number
        boolean isPrime = true;

        if (number <= 1) {
            isPrime = false;
        } else {
            // Check divisibility from 2 to number-1
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;  // No need to check further if divisible
                }
            }
        }

        // Display result
        if (isPrime) {
            System.out.println(number + " is a Prime Number.");
        } else {
            System.out.println(number + " is NOT a Prime Number.");
        }

        sc.close();
    }
}
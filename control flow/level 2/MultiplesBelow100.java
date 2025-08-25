import java.util.Scanner;

public class MultiplesBelow100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            System.out.println("Multiples of " + number + " below 100 are:");
            int multiple = number;
            while (multiple < 100) {
                System.out.print(multiple + " ");
                multiple += number;
            }
        }

        scanner.close();
    }
}

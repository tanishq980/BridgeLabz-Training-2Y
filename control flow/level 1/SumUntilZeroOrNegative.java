import java.util.Scanner;

public class SumUntilZeroOrNegative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        System.out.println("Enter numbers to sum (enter 0 or negative number to stop):");

        while (true) {
            int number = scanner.nextInt();

            if (number <= 0) {  // stops if 0 or negative number is entered
                break;
            }

            sum += number;
        }

        System.out.println("The sum of the entered numbers is: " + sum);

        scanner.close();
    }
}

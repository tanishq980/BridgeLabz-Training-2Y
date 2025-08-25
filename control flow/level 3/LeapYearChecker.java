import java.util.Scanner;

public class LeapYearChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        boolean isLeapYear;

        // Leap year logic
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            isLeapYear = true;
        } else {
            isLeapYear = false;
        }

        // Output
        if (isLeapYear) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is NOT a Leap Year.");
        }

        scanner.close();
    }
}

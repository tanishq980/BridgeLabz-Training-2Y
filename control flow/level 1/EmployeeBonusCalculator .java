import java.util.Scanner;

public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input employee details
        System.out.print("Enter years of service: ");
        int years = scanner.nextInt();

        System.out.print("Enter current salary: ");
        double salary = scanner.nextDouble();

        double bonus = 0;

        // Calculate bonus based on years of service
        if (years < 2) {
            bonus = 0;
        } else if (years <= 5) {
            bonus = salary * 0.05;
        } else if (years <= 10) {
            bonus = salary * 0.10;
        } else {
            bonus = salary * 0.15;
        }

        System.out.printf("Bonus based on %d years of service is: %.2f%n", years, bonus);

        scanner.close();
    }
}

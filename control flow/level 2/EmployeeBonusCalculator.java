import java.util.Scanner;

public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input salary and years of service
        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();

        System.out.print("Enter years of service: ");
        int years = scanner.nextInt();

        // Calculate bonus
        if (years > 5) {
            double bonus = salary * 0.10;  // 10% bonus
            System.out.println("Bonus is: $" + bonus);
        } else {
            System.out.println("No bonus. Minimum 6 years of service required.");
        }

        scanner.close();
    }
}

import java.util.Scanner;

public class RocketLaunchCountdown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the countdown start number: ");
        int number = scanner.nextInt();

        System.out.println("Rocket Launch Countdown:");

        while (number >= 1) {
            System.out.println(number);
            number--;
        }

        System.out.println("Liftoff!");

        scanner.close();
    }
}

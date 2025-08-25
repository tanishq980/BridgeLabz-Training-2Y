import java.util.Scanner;

public class RocketLaunchCountdown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the countdown start number: ");
        int number = scanner.nextInt();

        System.out.println("Rocket Launch Countdown:");

        for (int i = number; i >= 1; i--) {
            System.out.println(i);
        }

        System.out.println("Liftoff!");

        scanner.close();
    }
}

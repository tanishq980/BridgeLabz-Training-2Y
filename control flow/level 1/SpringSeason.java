public class SpringSeason {
    public static void main(String[] args) {
        // Check if exactly 2 arguments are passed
        if (args.length != 2) {
            System.out.println("Please provide month and day as command-line arguments.");
            return;
        }

        // Parse command-line arguments
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        // Check if it's a Spring season
        boolean isSpring = false;

        if ((month == 3 && day >= 20 && day <= 31) ||    // March 20 to March 31
            (month == 4 && day >= 1 && day <= 30) ||     // April
            (month == 5 && day >= 1 && day <= 31) ||     // May
            (month == 6 && day >= 1 && day <= 20)) {     // June 1 to June 20
            isSpring = true;
        }

        // Output result
        if (isSpring) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }
}

public class AlgoProperties {

    public static void main(String[] args) {

        int[] temperature = {20, 25, 22, 24, 21};
        int n = temperature.length;

        int total = 0;                  //algo a
        for (int t : temperature) total += t;
        double avgA = (double) total / n;

        double sum = temperature[0];     //algo b
        for (int i = 1; i < n; i++) sum += temperature[i];
        for (int i = 0; i < n; i++) sum /= n;
        double resultB = sum;

        System.out.println("Algorithm A Average = " + avgA);
        System.out.println("Algorithm B Result = " + resultB);

        System.out.println("\nAlgorithm A: Correct, simple, O(n)");
        System.out.println("Algorithm B: Incorrect (repeated division)");

        System.out.println("\nError in B: sum is divided by n inside a loop, giving sum/(n^n)");

        System.out.println("\nTest Cases:");
        System.out.println("[20,25,22,24,21] -> 22.4");
        System.out.println("[30] -> 30");
        System.out.println("[-5,0,5] -> 0");

        System.out.println("\nConclusion: Use Algorithm A.");
    }
}
public class SpaceComplex {

    public static void main(String[] args) {

        int n = 40;  
        int m = 5;   
        int students = 100000;

        System.out.println("Time Complexity:");
        System.out.println("Implementation A (Nested Loop) = O(n * m)");
        System.out.println("Implementation B (HashSet) = O(n + m)");

        System.out.println("\nSpace Complexity:");
        System.out.println("Implementation A = O(1)");
        System.out.println("Implementation B = O(n)");

        int comparisonsA = n * m * students;
        int memoryB = n * 8 * students;

        System.out.println("\nTotal Comparisons per day (Implementation A) = " + comparisonsA);
        System.out.println("Total Memory usage per day (Implementation B) = " + memoryB + " bytes");

        double timePerComparison = 0.1; 
        double totalTime = (n * m) * timePerComparison;

        System.out.println("\nTime per request using Implementation A = " + totalTime + " microseconds");
        System.out.println("Response limit = 100 ms");

        System.out.println("\nBetter choice: Implementation B (HashSet)");

        System.out.println("\nHybrid Strategy:");
        System.out.println("If prerequisites <= 2 → use Nested Loop");
        System.out.println("If prerequisites > 2 → use HashSet");
    }
}
public class TimeComplex {

    public static void main(String[] args) {

        int n = 10000000; 

        int linearSearch = n;   
        int binarySearch = 24;   
        int hashSearch = 1;     

        System.out.println("Worst Case Comparisons:");
        System.out.println("Linear Search = " + linearSearch);
        System.out.println("Binary Search ≈ " + binarySearch);
        System.out.println("Hash Table = " + hashSearch);

        System.out.println("\nTime Complexity:");
        System.out.println("Linear Search : O(n)");
        System.out.println("Binary Search : O(log n)");
        System.out.println("Hash Table : O(1)");

        System.out.println("\nn\tLinear\tBinary\tHash");

        int[] values = {100,1000,10000,100000,1000000,10000000};

        for(int i=0;i<values.length;i++)
        {
            int binary = (int)(Math.log(values[i]) / Math.log(2));
            System.out.println(values[i] + "\t" + values[i] + "\t" + binary + "\t1");
        }

        long linearOps = 50000L * n;
        long binaryOps = 50000L * binarySearch;
        long hashOps = 50000;

        System.out.println("\nOperations per second:");
        System.out.println("Linear = " + linearOps);
        System.out.println("Binary = " + binaryOps);
        System.out.println("Hash = " + hashOps);

        System.out.println("\nBest choice: Hash Table Lookup");
    }
}
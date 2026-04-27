
import java.util.Scanner;
class TableRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[4];

        for(int i=6;i<=9;i++){
            arr[i-6] = n*i;
        }

        for(int i=6;i<=9;i++){
            System.out.println(n+" * "+i+" = "+arr[i-6]);
        }
        sc.close();
    }
}

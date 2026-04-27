
import java.util.Scanner;
class Table {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[10];

        for(int i=1;i<=10;i++){
            arr[i-1] = n*i;
        }

        for(int i=1;i<=10;i++){
            System.out.println(n+" * "+i+" = "+arr[i-1]);
        }
        sc.close();
    }
}

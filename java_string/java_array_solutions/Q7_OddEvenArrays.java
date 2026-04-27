
import java.util.Scanner;
class OddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n <= 0){
            System.out.println("Invalid");
            return;
        }

        int[] even = new int[n];
        int[] odd = new int[n];
        int e=0,o=0;

        for(int i=1;i<=n;i++){
            if(i%2==0) even[e++] = i;
            else odd[o++] = i;
        }

        System.out.println("Even:");
        for(int i=0;i<e;i++) System.out.print(even[i]+" ");

        System.out.println("
Odd:");
        for(int i=0;i<o;i++) System.out.print(odd[i]+" ");

        sc.close();
    }
}

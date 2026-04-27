
import java.util.Scanner;
class ReverseNumber {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[10];
        int i=0;
        while(n>0){
            arr[i++]=n%10;
            n/=10;
        }
        for(int j=0;j<i;j++){
            System.out.print(arr[j]);
        }
        sc.close();
    }
}

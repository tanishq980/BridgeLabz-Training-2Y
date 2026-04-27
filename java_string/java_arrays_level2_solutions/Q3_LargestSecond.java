
import java.util.Scanner;
class LargestDigits {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[10];
        int i=0;
        while(n>0 && i<10){
            arr[i++]=n%10;
            n/=10;
        }
        int max=0,sec=0;
        for(int j=0;j<i;j++){
            if(arr[j]>max){
                sec=max;
                max=arr[j];
            } else if(arr[j]>sec){
                sec=arr[j];
            }
        }
        System.out.println(max+" "+sec);
        sc.close();
    }
}

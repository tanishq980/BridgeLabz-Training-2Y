
import java.util.Scanner;
class DynamicDigits {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int size=10,i=0;
        int[] arr=new int[size];

        while(n>0){
            if(i==size){
                size*=2;
                int[] temp=new int[size];
                for(int j=0;j<i;j++) temp[j]=arr[j];
                arr=temp;
            }
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

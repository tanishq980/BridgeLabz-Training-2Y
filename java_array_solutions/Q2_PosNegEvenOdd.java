
import java.util.Scanner;
class CheckNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        for(int i=0;i<5;i++){
            arr[i] = sc.nextInt();

            if(arr[i] > 0){
                if(arr[i] % 2 == 0)
                    System.out.println(arr[i]+" is positive even");
                else
                    System.out.println(arr[i]+" is positive odd");
            } else if(arr[i] < 0){
                System.out.println(arr[i]+" is negative");
            } else {
                System.out.println("Zero");
            }
        }

        if(arr[0] == arr[4])
            System.out.println("Equal");
        else if(arr[0] > arr[4])
            System.out.println("First greater");
        else
            System.out.println("Last greater");

        sc.close();
    }
}

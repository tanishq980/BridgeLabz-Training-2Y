
import java.util.Scanner;
class SumArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] arr = new double[10];
        double sum = 0;
        int i = 0;

        while(true){
            double x = sc.nextDouble();
            if(x <= 0 || i == 10) break;
            arr[i++] = x;
        }

        for(int j=0;j<i;j++){
            sum += arr[j];
        }

        System.out.println("Sum = "+sum);
        sc.close();
    }
}

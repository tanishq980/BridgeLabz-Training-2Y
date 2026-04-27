
import java.util.Scanner;
class BMIArray {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double[] w=new double[n];
        double[] h=new double[n];
        for(int i=0;i<n;i++){
            w[i]=sc.nextDouble();
            h[i]=sc.nextDouble();
        }
        for(int i=0;i<n;i++){
            double bmi=w[i]/((h[i]/100)*(h[i]/100));
            System.out.println("BMI: "+bmi);
        }
        sc.close();
    }
}

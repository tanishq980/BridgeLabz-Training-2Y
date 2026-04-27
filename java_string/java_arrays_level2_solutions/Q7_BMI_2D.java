
import java.util.Scanner;
class BMI2D {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double[][] data=new double[n][3];
        for(int i=0;i<n;i++){
            data[i][0]=sc.nextDouble();
            data[i][1]=sc.nextDouble();
            data[i][2]=data[i][0]/((data[i][1]/100)*(data[i][1]/100));
        }
        for(int i=0;i<n;i++){
            System.out.println(data[i][2]);
        }
        sc.close();
    }
}

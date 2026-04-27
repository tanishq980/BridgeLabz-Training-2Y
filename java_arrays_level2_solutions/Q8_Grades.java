
import java.util.Scanner;
class Grades {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double[] per=new double[n];
        for(int i=0;i<n;i++){
            int p=sc.nextInt(),c=sc.nextInt(),m=sc.nextInt();
            per[i]=(p+c+m)/3.0;
            if(per[i]>=80) System.out.println("A");
            else if(per[i]>=70) System.out.println("B");
            else if(per[i]>=60) System.out.println("C");
            else if(per[i]>=50) System.out.println("D");
            else if(per[i]>=40) System.out.println("E");
            else System.out.println("R");
        }
        sc.close();
    }
}

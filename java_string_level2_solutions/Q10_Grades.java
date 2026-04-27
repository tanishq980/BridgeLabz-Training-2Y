
import java.util.*;
class Grades {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int p=sc.nextInt(),c=sc.nextInt(),m=sc.nextInt();
            double per=(p+c+m)/3.0;
            if(per>=80) System.out.println("A");
            else if(per>=70) System.out.println("B");
            else if(per>=60) System.out.println("C");
            else if(per>=50) System.out.println("D");
            else if(per>=40) System.out.println("E");
            else System.out.println("R");
        }
        sc.close();
    }
}


import java.util.Scanner;
class Friends {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] age=new int[3];
        double[] height=new double[3];
        for(int i=0;i<3;i++){
            age[i]=sc.nextInt();
            height[i]=sc.nextDouble();
        }
        int min=age[0],maxHIndex=0;
        for(int i=1;i<3;i++){
            if(age[i]<min) min=age[i];
            if(height[i]>height[maxHIndex]) maxHIndex=i;
        }
        System.out.println("Youngest age: "+min);
        System.out.println("Tallest height: "+height[maxHIndex]);
        sc.close();
    }
}

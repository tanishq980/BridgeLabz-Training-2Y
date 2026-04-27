
import java.util.Scanner;
class Grades2D {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] marks=new int[n][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                marks[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            double per=(marks[i][0]+marks[i][1]+marks[i][2])/3.0;
            System.out.println(per);
        }
        sc.close();
    }
}

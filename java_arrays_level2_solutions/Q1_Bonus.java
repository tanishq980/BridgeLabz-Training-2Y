
import java.util.Scanner;
class Bonus {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double[] salary=new double[10];
        double[] years=new double[10];
        double totalBonus=0;

        for(int i=0;i<10;i++){
            salary[i]=sc.nextDouble();
            years[i]=sc.nextDouble();
        }

        for(int i=0;i<10;i++){
            double bonus=(years[i]>5)?salary[i]*0.05:salary[i]*0.02;
            totalBonus+=bonus;
            System.out.println("Bonus: "+bonus);
        }
        System.out.println("Total Bonus: "+totalBonus);
        sc.close();
    }
}

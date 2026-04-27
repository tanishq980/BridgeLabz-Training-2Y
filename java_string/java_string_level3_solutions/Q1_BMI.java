
import java.util.Scanner;
class BMI {
    static String getStatus(double bmi){
        if(bmi<18.5) return "Underweight";
        else if(bmi<25) return "Normal";
        else return "Overweight";
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double[][] data=new double[10][2];
        for(int i=0;i<10;i++){
            data[i][0]=sc.nextDouble(); // weight
            data[i][1]=sc.nextDouble(); // height cm
        }
        for(int i=0;i<10;i++){
            double h=data[i][1]/100;
            double bmi=data[i][0]/(h*h);
            System.out.println("BMI="+bmi+" "+getStatus(bmi));
        }
        sc.close();
    }
}

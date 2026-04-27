
import java.util.Scanner;
class NumberFormatDemo {
    static void handle(String s){
        try{
            int x=Integer.parseInt(s);
            System.out.println(x);
        }catch(Exception e){
            System.out.println("Handled");
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        handle(s);
        sc.close();
    }
}

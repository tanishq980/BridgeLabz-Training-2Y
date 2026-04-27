
import java.util.Scanner;
class StringIndexDemo {
    static void handle(String s){
        try{
            System.out.println(s.charAt(100));
        }catch(StringIndexOutOfBoundsException e){
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

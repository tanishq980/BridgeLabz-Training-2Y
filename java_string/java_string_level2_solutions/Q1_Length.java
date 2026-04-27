
import java.util.Scanner;
class Length {
    static int len(String s){
        int i=0;
        try{
            while(true){
                s.charAt(i);
                i++;
            }
        }catch(Exception e){}
        return i;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(len(s)+" "+s.length());
        sc.close();
    }
}

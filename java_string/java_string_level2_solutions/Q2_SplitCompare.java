
import java.util.*;
class SplitCompare {
    static String[] splitManual(String s){
        return s.split(" ");
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] a=splitManual(s);
        String[] b=s.split(" ");
        System.out.println(Arrays.equals(a,b));
        sc.close();
    }
}

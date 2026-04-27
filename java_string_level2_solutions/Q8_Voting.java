
import java.util.*;
class Voting {
    public static void main(String[] args){
        Random r=new Random();
        int[] age=new int[10];
        for(int i=0;i<10;i++) age[i]=r.nextInt(100);
        for(int a:age){
            System.out.println(a+" -> "+(a>=18));
        }
    }
}

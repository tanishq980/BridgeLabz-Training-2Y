
import java.util.*;
class WordsLength {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] words=s.split(" ");
        for(String w:words){
            System.out.println(w+" "+w.length());
        }
        sc.close();
    }
}

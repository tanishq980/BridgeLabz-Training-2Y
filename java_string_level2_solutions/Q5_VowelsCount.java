
import java.util.Scanner;
class VowelsCount {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int v=0,c=0;
        for(char ch:s.toCharArray()){
            if("aeiouAEIOU".indexOf(ch)!=-1) v++;
            else if(Character.isLetter(ch)) c++;
        }
        System.out.println("Vowels="+v+" Consonants="+c);
        sc.close();
    }
}

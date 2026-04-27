
import java.util.Scanner;
class VowelType {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        for(char ch:s.toCharArray()){
            if("aeiouAEIOU".indexOf(ch)!=-1)
                System.out.println(ch+" Vowel");
            else if(Character.isLetter(ch))
                System.out.println(ch+" Consonant");
            else
                System.out.println(ch+" Not Letter");
        }
        sc.close();
    }
}


import java.util.Scanner;
class Uppercase {
    static String manual(String s){
        String res="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c>='a'&&c<='z') c=(char)(c-32);
            res+=c;
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(manual(s).equals(s.toUpperCase()));
        sc.close();
    }
}

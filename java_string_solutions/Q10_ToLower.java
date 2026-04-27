
import java.util.Scanner;
class Lowercase {
    static String manual(String s){
        String res="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c>='A'&&c<='Z') c=(char)(c+32);
            res+=c;
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(manual(s).equals(s.toLowerCase()));
        sc.close();
    }
}

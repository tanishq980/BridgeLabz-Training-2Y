
import java.util.Scanner;
class SubstringDemo {
    static String sub(String s,int start,int end){
        String res="";
        for(int i=start;i<end;i++){
            res+=s.charAt(i);
        }
        return res;
    }
    static boolean compare(String a,String b){
        if(a.length()!=b.length()) return false;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)) return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int start=sc.nextInt();
        int end=sc.nextInt();
        String m=sub(s,start,end);
        String b=s.substring(start,end);
        System.out.println(compare(m,b));
        sc.close();
    }
}

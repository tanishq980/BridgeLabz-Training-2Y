
import java.util.Scanner;
class UniqueChars {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        for(int i=0;i<s.length();i++){
            boolean unique=true;
            for(int j=0;j<i;j++){
                if(s.charAt(i)==s.charAt(j)){
                    unique=false;
                    break;
                }
            }
            if(unique) System.out.print(s.charAt(i)+" ");
        }
        sc.close();
    }
}

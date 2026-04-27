
import java.util.Scanner;
class TrimManual {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int start=0,end=s.length()-1;
        while(start<=end && s.charAt(start)==' ') start++;
        while(end>=start && s.charAt(end)==' ') end--;
        String res="";
        for(int i=start;i<=end;i++) res+=s.charAt(i);
        System.out.println(res.equals(s.trim()));
        sc.close();
    }
}

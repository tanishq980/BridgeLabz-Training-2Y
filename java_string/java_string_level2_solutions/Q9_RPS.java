
import java.util.*;
class RPS {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] choices={"rock","paper","scissors"};
        int user=0,comp=0;
        Random r=new Random();
        for(int i=0;i<n;i++){
            String u=choices[r.nextInt(3)];
            String c=choices[r.nextInt(3)];
            if(u.equals(c)){}
            else if((u.equals("rock")&&c.equals("scissors"))||
                    (u.equals("paper")&&c.equals("rock"))||
                    (u.equals("scissors")&&c.equals("paper"))) user++;
            else comp++;
        }
        System.out.println("User:"+user+" Comp:"+comp);
        sc.close();
    }
}

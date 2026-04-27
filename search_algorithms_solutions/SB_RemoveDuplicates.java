
import java.util.*;
class SBRemoveDuplicates {
    public static void main(String[] args){
        String s="programming";
        StringBuilder sb=new StringBuilder();
        HashSet<Character> set=new HashSet<>();
        for(char c:s.toCharArray()){
            if(!set.contains(c)){
                set.add(c);
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}

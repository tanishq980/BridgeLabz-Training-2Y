
class Search2D {
    public static void main(String[] args){
        int[][] mat={{1,3,5},{7,9,11}};
        int target=9;
        int r=mat.length,c=mat[0].length;
        int l=0,h=r*c-1;
        while(l<=h){
            int m=(l+h)/2;
            int val=mat[m/c][m%c];
            if(val==target){
                System.out.println(true);
                return;
            } else if(val<target) l=m+1;
            else h=m-1;
        }
        System.out.println(false);
    }
}

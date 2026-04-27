
class FirstLast {
    static int first(int[] arr,int x){
        int l=0,r=arr.length-1,res=-1;
        while(l<=r){
            int m=(l+r)/2;
            if(arr[m]==x){res=m;r=m-1;}
            else if(arr[m]<x) l=m+1;
            else r=m-1;
        }
        return res;
    }
    static int last(int[] arr,int x){
        int l=0,r=arr.length-1,res=-1;
        while(l<=r){
            int m=(l+r)/2;
            if(arr[m]==x){res=m;l=m+1;}
            else if(arr[m]<x) l=m+1;
            else r=m-1;
        }
        return res;
    }
    public static void main(String[] args){
        int[] arr={1,2,2,2,3};
        System.out.println(first(arr,2)+" "+last(arr,2));
    }
}

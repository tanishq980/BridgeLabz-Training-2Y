
class RotationPoint {
    public static void main(String[] args){
        int[] arr={4,5,6,1,2,3};
        int l=0,r=arr.length-1;
        while(l<r){
            int m=l+(r-l)/2;
            if(arr[m]>arr[r]) l=m+1;
            else r=m;
        }
        System.out.println(l);
    }
}

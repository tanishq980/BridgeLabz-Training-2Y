
class PeakElement {
    public static void main(String[] args){
        int[] arr={1,3,20,4,1};
        int l=0,r=arr.length-1;
        while(l<r){
            int m=l+(r-l)/2;
            if(arr[m]<arr[m+1]) l=m+1;
            else r=m;
        }
        System.out.println(arr[l]);
    }
}

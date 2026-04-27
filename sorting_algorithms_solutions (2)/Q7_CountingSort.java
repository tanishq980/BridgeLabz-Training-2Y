
class CountingSort {
    public static void main(String[] args){
        int[] arr={12,15,10,18,12,14};
        int max=18,min=10;
        int[] count=new int[max+1];
        for(int x:arr) count[x]++;
        for(int i=min;i<=max;i++){
            while(count[i]-- >0){
                System.out.print(i+" ");
            }
        }
    }
}

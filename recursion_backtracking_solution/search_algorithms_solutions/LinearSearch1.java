
class LinearSearch1 {
    public static void main(String[] args){
        int[] arr={1,2,-3,4};
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}

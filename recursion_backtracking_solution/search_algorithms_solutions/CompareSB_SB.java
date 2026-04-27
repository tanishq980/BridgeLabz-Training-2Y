
class CompareSB {
    public static void main(String[] args){
        long start=System.nanoTime();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<100000;i++) sb.append("hello");
        long end=System.nanoTime();
        System.out.println("StringBuilder: "+(end-start));

        start=System.nanoTime();
        StringBuffer sbf=new StringBuffer();
        for(int i=0;i<100000;i++) sbf.append("hello");
        end=System.nanoTime();
        System.out.println("StringBuffer: "+(end-start));
    }
}

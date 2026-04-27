
class IllegalArgumentDemo {
    static void handle(String s){
        try{
            System.out.println(s.substring(5,2));
        }catch(Exception e){
            System.out.println("Handled");
        }
    }
    public static void main(String[] args){
        handle("hello");
    }
}

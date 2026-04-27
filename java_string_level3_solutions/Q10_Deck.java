
class Deck {
    public static void main(String[] args){
        String[] suits={"Hearts","Diamonds","Clubs","Spades"};
        String[] ranks={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
        int n=suits.length*ranks.length;
        String[] deck=new String[n];
        int k=0;
        for(String s:suits){
            for(String r:ranks){
                deck[k++]=r+" of "+s;
            }
        }
        for(int i=0;i<n;i++){
            int rand=i+(int)(Math.random()*(n-i));
            String temp=deck[i];
            deck[i]=deck[rand];
            deck[rand]=temp;
        }
        for(int i=0;i<5;i++){
            System.out.println(deck[i]);
        }
    }
}

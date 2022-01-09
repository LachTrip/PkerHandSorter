public class Card implements Comparable<Card>{
    private Integer num;
    private int suite; 

    public Card(String s){
        int n = s.toCharArray()[0] - '0';
        if(n > 1 && n < 10) {
            num = n;
        }
        if(s.toCharArray()[0] == 'T') {
            num = 10;
        }
        if(s.toCharArray()[0] == 'J') {
            num = 11;
        }
        if(s.toCharArray()[0] == 'Q') {
            num = 12;
        }
        if(s.toCharArray()[0] == 'K') {
            num = 13;
        }
        if(s.toCharArray()[0] == 'A') {
            num = 14;
        }

        if(s.toCharArray()[1] == 'D') {
            suite = 0;
        }
        if(s.toCharArray()[1] == 'H') {
            suite = 1;
        }
        if(s.toCharArray()[1] == 'S') {
            suite = 2;
        }
        if(s.toCharArray()[1] == 'C') {
            suite = 3;
        }

    }

    public int getNum(){
        return num;
    }

    public int getSuite(){
        return suite;
    }

    @Override
    public int compareTo(Card c) {
        return this.num.compareTo(c.num);
    }
}

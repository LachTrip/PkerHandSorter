import java.util.Arrays;
import java.util.Scanner;

public class Hand {
    private Card[] cards;
    private int rank;

    public Hand(Scanner scanner){
        cards = new Card[5];
        for (int i = 0; i < 5; i++){
            cards[i] = new Card(scanner.next());
        }
        Arrays.sort(cards);
        rank = rankNSort();
    }

    private int rankNSort(){
        if (isStraightFlush()){
            return 8;
        } else if (isFourKind()){
            if (cards[3].getNum() > cards[4].getNum()){
                Card swap = cards[4];
                cards[4] = cards[0];
                cards[0] = swap;
            }
            return 7;
        } else if (isFullHouse()){
            return 6;
        } else if (isFlush()){
            return 5;
        } else if (isStraight()){
            return 4;
        } else if (isThreeKind()){
            if (cards[2].getNum() > cards[3].getNum()) {
                Card swap = cards[3];
                cards[3] = cards[0];
                cards[0] = swap;
            }
            if (cards[3].getNum() > cards[4].getNum()) {
                Card swap = cards[4];
                cards[4] = cards[1];
                cards[1] = swap;
            }
            return 3;
        } else if (isTwoPair()){
            if (cards[3].getNum() > cards[4].getNum()){
                Card swap = cards[4];
                cards[4] = cards[2];
                cards[2] = cards[0];
                cards[0] = swap;
            }
            return 2;
        } else if (isPair()){
            if (cards[0].getNum() == cards[1].getNum()) {
                Card swap0 = cards[0];
                Card swap1 = cards[1];
                cards[0] = cards[2];
                cards[1] = cards[3];
                cards[2] = cards[4];
                cards[3] = swap0;
                cards[4] = swap1;
            }
            if (cards[1].getNum() == cards[2].getNum()) {
                Card swap1 = cards[1];
                Card swap2 = cards[2];
                cards[1] = cards[3];
                cards[2] = cards[4];
                cards[3] = swap1;
                cards[4] = swap2;
            }
            if (cards[2].getNum() == cards[3].getNum()) {
                Card swap2 = cards[2];
                cards[2] = cards[4];
                cards[4] = cards[3];
                cards[3] = swap2;
            }
            return 1;
        } else {
            return 0;
        }
    }

    public boolean isStraightFlush(){
        return isStraight() && isFlush();
    }

    public boolean isFourKind(){
        return (cards[0].getNum() == cards[1].getNum() && cards[1].getNum() == cards[2].getNum() && cards[2].getNum() == cards[3].getNum())
            || (cards[1].getNum() == cards[2].getNum() && cards[2].getNum() == cards[3].getNum() && cards[3].getNum() == cards[4].getNum());
    }
    
    public boolean isFullHouse(){
        return (cards[0].getNum() == cards[1].getNum() && cards[1].getNum() != cards[2].getNum() && cards[2].getNum() == cards[3].getNum() && cards[3].getNum() == cards[4].getNum())
            || (cards[0].getNum() == cards[1].getNum() && cards[1].getNum() == cards[2].getNum() && cards[2].getNum() != cards[3].getNum() && cards[3].getNum() == cards[4].getNum());
    }
    
    public boolean isFlush(){
        return (cards[0].getSuite() == cards[1].getSuite() && cards[1].getSuite() == cards[2].getSuite() && cards[2].getSuite() == cards[3].getSuite() && cards[3].getSuite() == cards[4].getSuite());
    }
    
    public boolean isStraight(){
        return (cards[0].getNum() == cards[1].getNum() + 1 && cards[1].getNum() == cards[2].getNum() + 1 && cards[2].getNum() == cards[3].getNum() + 1 && cards[3].getNum() == cards[4].getNum() + 1);
    }
    
    public boolean isThreeKind(){
        return (cards[0].getNum() == cards[1].getNum() && cards[1].getNum() == cards[2].getNum() && cards[2].getNum() != cards[3].getNum() && cards[3].getNum() != cards[4].getNum())
            || (cards[0].getNum() == cards[1].getNum() && cards[1].getNum() != cards[2].getNum() && cards[2].getNum() != cards[3].getNum() && cards[3].getNum() == cards[4].getNum())
            || (cards[0].getNum() != cards[1].getNum() && cards[1].getNum() != cards[2].getNum() && cards[2].getNum() == cards[3].getNum() && cards[3].getNum() == cards[4].getNum());
    }
    
    public boolean isTwoPair(){
        return (cards[0].getNum() == cards[1].getNum() && cards[1].getNum() != cards[2].getNum() && cards[2].getNum() == cards[3].getNum() && cards[3].getNum() != cards[4].getNum())
            || (cards[0].getNum() == cards[1].getNum() && cards[1].getNum() != cards[2].getNum() && cards[2].getNum() != cards[3].getNum() && cards[3].getNum() == cards[4].getNum())
            || (cards[0].getNum() != cards[1].getNum() && cards[1].getNum() == cards[2].getNum() && cards[2].getNum() != cards[3].getNum() && cards[3].getNum() == cards[4].getNum());
    }

    public boolean isPair(){
        return (cards[0].getNum() == cards[1].getNum() && cards[1].getNum() != cards[2].getNum() && cards[2].getNum() != cards[3].getNum() && cards[3].getNum() != cards[4].getNum())
            || (cards[0].getNum() != cards[1].getNum() && cards[1].getNum() == cards[2].getNum() && cards[2].getNum() != cards[3].getNum() && cards[3].getNum() != cards[4].getNum())
            || (cards[0].getNum() != cards[1].getNum() && cards[1].getNum() != cards[2].getNum() && cards[2].getNum() == cards[3].getNum() && cards[3].getNum() != cards[4].getNum())
            || (cards[0].getNum() != cards[1].getNum() && cards[1].getNum() != cards[2].getNum() && cards[2].getNum() != cards[3].getNum() && cards[3].getNum() == cards[4].getNum());
    }

    public int compare(Hand p2){
        if (rank > p2.rank){
            return 1;
        }
        if (rank < p2.rank){
            return 2;
        }

        for (int i = 4; i >= 0 ; i--){
            if (cards[i].getNum() > p2.cards[i].getNum()){
                return 1;
            }
            if (cards[i].getNum() < p2.cards[i].getNum()){
                return 2;
            }
        }
        
        return 0;
    }
}

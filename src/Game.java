import java.util.Scanner;

public class Game {
    private Hand player1;
    private Hand player2;
    private Scanner scanner;

    public Game(String line){
        scanner = new Scanner(line);
        scanner.useDelimiter(" ");
        player1 = new Hand(scanner);
        player2 = new Hand(scanner);
    }

    public int getWinner(){
        return player1.compare(player2);
    }
}

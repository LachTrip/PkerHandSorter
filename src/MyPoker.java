import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyPoker {
    static BufferedReader din;
    static Game game;
    static String line;
    static int wins1 = 0;
    static int wins2 = 0;
    public static void main(String[] args) {
        try {
            if(args.length == 0){
                din = new BufferedReader(new InputStreamReader(System.in));
            } else {
                din = new BufferedReader(new FileReader(args[0]));
            }
            while ((line = din.readLine()) != null){
                game = new Game(line);
                if (game.getWinner() != 0) {
                    if (game.getWinner() == 1) {
                        wins1++;
                    } else {
                        wins2++;
                    }
                }
            }
            System.out.println("Player 1: " + wins1 + "\n");
            System.out.println("Player 2: " + wins2);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
package rob.nonMainGames.sideGames.TextGame;

import java.util.Scanner;

public class Player {
    public String name;
    private Scanner input = new Scanner(System.in);

    public Player() {
    }

    public String getName() {
        System.out.println("What is your name?");
        return input.next();
    }
}

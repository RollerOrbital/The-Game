package rob.nonMainGames.sideGames.TextGame;

import java.util.Scanner;

public class Player {
    public String name, region;
    public int seed1, seed2, seed;
    private Scanner input = new Scanner(System.in);

    public Player() {
    }

    public String getName() {
        System.out.println("What is your name?");
        String nam = input.next();
        seed1 = nam.hashCode();
        return nam;
    }

    public String getRegion() {
        System.out.println("Where are you from?");
        String reg = input.next();
        seed2 = reg.hashCode();
        return reg;
    }
}

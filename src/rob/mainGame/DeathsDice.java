package rob.mainGame;

import java.util.Random;
import java.util.Scanner;

public class DeathsDice {
    static Scanner time = new Scanner(System.in);
    static Random randomNum = new Random();

    public static void die(PlayerAtt player) {
        player.hp = player.basehp;
        System.out.println("You open your eyes and realise that you're not dead...");
        time.next();
        System.out.println("You think \"This cannot be possible.\"");
        time.next();
        System.out.println("You aren't wrong...");
        time.next();
        System.out.println("You see a ghostly figure walk down the set of helical stairs at the end of the room");
        time.next();
        System.out.println("He says to you, \"I am death. And I can make you go back to the world you know.. But...\"");
        time.next();
        System.out.println("\"I will only take you back there if you beat me at 1 of my 6 favourite games.\"");
        time.next();
        System.out.println("\"The game we play will be determined by this die\"");
        time.next();
        System.out.println("\"So then. Lets roll the dice eh?");
        time.next();
        System.out.println("\"Looks like I rolled a " + rollDice() + "\"");
        time.next();
    }

    private static int rollDice() {
        int rolledScore = randomNum.nextInt(6) + 1;
        return (rolledScore);
    }
}

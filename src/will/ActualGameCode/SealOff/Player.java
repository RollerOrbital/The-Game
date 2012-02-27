package will.ActualGameCode.SealOff;

import java.util.Scanner;

public class Player {
    String playerName;
    static Boolean alive;
    static int playerhp = 100;
    Scanner scan = new Scanner(System.in);

    public void name() {
        System.out.println("Hello there, what is your name?");
        System.out.println();
        playerName = scan.next();
        System.out.println();
        System.out.println("Hello " + playerName + " and welcome to Seal Off!");
        System.out.println();
    }
}



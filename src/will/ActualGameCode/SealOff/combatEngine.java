package will.ActualGameCode.SealOff;

import java.util.Scanner;

import static will.ActualGameCode.SealOff.Player.playerhp;

public class combatEngine {

    Scanner scan = new Scanner(System.in);
    boolean alive = true;


    public void intro() {

        System.out.println("You have " + playerhp + " hp");
        System.out.println();
        System.out.println(Enemy.name + " has " + Enemy.enemyHp + " hp");
        System.out.println();
    }

    public void moveChoice() {
        System.out.println("You have four moves: ");
        System.out.println();
        System.out.println("1) Fin Slap");
        System.out.println();
        System.out.println("2) Tail Bite");
        System.out.println();
        System.out.println("3) Water Blast");
        System.out.println();
        System.out.println("4) Seal Zen");
        System.out.println();

        System.out.println("Enter the number of the move you would like to make: ");
        System.out.println();

        int move = scan.nextInt();

        //if statements about move choice go here!!!


    }

}

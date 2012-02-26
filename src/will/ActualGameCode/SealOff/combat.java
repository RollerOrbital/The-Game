package will.ActualGameCode.SealOff;

import java.util.Random;
import java.util.Scanner;


public class combat {


    static Scanner scan = new Scanner(System.in);
    static Random r = new Random();

    static int playerhp = 100;
    static int enemyhp = 100;
    static int attack1stat = 6;
    static int attack2stat = 6;
    static int attack3stat = 15;

    static String attack1 = "Fin Slap";
    static String attack2 = "Tail bite";
    static String attack3 = "Water Blast";
    static String attack4 = "Zen";

    public combat() {

        while (enemyhp > 0) {
            System.out.println("You have " + playerhp + " hp");
            System.out.println("You have four attacks: ");
            System.out.println("1) " + attack1);
            System.out.println("2) " + attack2);
            System.out.println("3) " + attack3);
            System.out.println("4) " + attack4);

            System.out.println("Type the number of the attack that you would like to use: \n");

            int attack = scan.nextInt();
            int extra = r.nextInt(5);

            if (attack == 1) {
                attack1stat += extra;


                System.out.println("You reach out and slap your foe for " + attack1stat + "damage!");

                enemyhp -= attack1stat;
                System.out.println("He now has " + enemyhp + " hp");
            } else if (attack == 2) {
                attack2stat += extra;

                System.out.println("You sneakily reach down and bite at the opponents tail for " + attack2stat);

                enemyhp -= attack2stat;
                System.out.println("He now has " + enemyhp + " hp");
            } else if (attack == 3) {
                attack3stat += extra;

                System.out.println("You throw your head back, gargling water in your mouth, then look at your opponent and hit him with a blast of salty water for " + attack3stat);

                enemyhp -= attack3stat;
                System.out.println("He now has " + enemyhp + " hp");
            }
        }

    }

}

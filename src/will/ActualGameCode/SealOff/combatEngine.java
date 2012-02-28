package will.ActualGameCode.SealOff;

import java.util.Random;
import java.util.Scanner;

import static will.ActualGameCode.SealOff.Player.playerhp;

public class combatEngine {

    Scanner scan = new Scanner(System.in);
    Random r = new Random();
    Random x = new Random();
    int finSlap = 8;
    int tailBite = 8;
    int waterBlast = 15;
    String enemyAttack1 = "Gargle Blaster";
    String enemyAttack2 = "Tail Whip";
    String enemyAttack3 = "Splash";
    int enemyAttack1Damage = 7;
    int enemyAttack2Damage = 6;
    int enemyAttack3Damage = 2;


    public void intro() {

        System.out.println("You have " + playerhp + " hp");
        System.out.println();
        System.out.println(Enemy.name + " has " + Enemy.enemyHp + " hp");
        System.out.println();
    }

    public void fight() {
        int i = 1;

        while (1 == 1 && Enemy.enemyHp > 0) {
            if (i / 2 * 2 == i) {
                moveChoice();
                i++;
            }
            if (i / 2 * 2 != i && Enemy.enemyHp > 0) {
                enemyMove();
                i++;
            }
        }
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

        if (move == 1) {
            this.move1();
        } else if (move == 2) {
            this.move2();
        } else if (move == 3) {
            this.move3();
        } else if (move == 4) {
            this.move4();
        }


    }

    public void move1() {
        //fin slap

        int extra = r.nextInt(6) + 1;
        finSlap += extra;
        System.out.println("You reach out and slap your opponents face for " + finSlap + " damage");
        Enemy.enemyHp -= finSlap;
        if (Enemy.enemyHp < 0) {
            Enemy.enemyHp = 0;
        }
        System.out.println(Enemy.name + " now has " + (Enemy.enemyHp) + " hp!");
        finSlap -= extra;

    }

    public void move2() {
        //tail bite

        int extra = r.nextInt(6) + 1;
        tailBite += extra;
        System.out.println("You bend down and gnaw at your opponents tail for " + tailBite + " damage");
        Enemy.enemyHp -= tailBite;
        if (Enemy.enemyHp < 0) {
            Enemy.enemyHp = 0;
        }
        System.out.println(Enemy.name + " now has " + (Enemy.enemyHp) + " hp!");

        tailBite -= extra;
    }

    public void move3() {
        //water blast
        //requires one turn to be lost for the gargling!!
    }

    public void move4() {
        //seal zen
        //requires one turn to be lost to dodge
    }


    public void enemyMove() {
        System.out.println("Hello!!!");
        int enemyMoveChoice = x.nextInt(3) + 1;
        if (enemyMoveChoice == 1) {
        }
    }

    //if statements about enemy's move go here

    public void enemyMove1() {
        int extra = r.nextInt(6) + 1;
        this.enemyAttack1Damage += extra;

        System.out.println(Enemy.name + " flicks his head at you, spraying water out, doing " + this.enemyAttack1Damage + " damage");
        Player.playerhp -= this.enemyAttack1Damage;
        if (Player.playerhp < 0) {
            playerhp = 0;
        }
        System.out.println("You now have " + playerhp + " hp");

    }


}

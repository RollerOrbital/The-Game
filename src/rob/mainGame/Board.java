package rob.mainGame;

import java.util.Random;
import java.util.Scanner;

public class Board {
    static Scanner input = new Scanner(System.in);
    static Random randomNum = new Random();

    static Board board = new Board();

    private int xBoardMax = 5;
    private int yBoardMax = 5;

    public static void playerMove(Player player, Enemy enemy, Board board) {
        System.out.println("What is the xco of where you want to go?");
        int yco = input.nextInt();
        System.out.println("What is the yco of where you want to go?");
        int xco = input.nextInt();
        if (xco - 1 < board.xBoardMax && yco - 1 < board.yBoardMax) {
            if (yco - 1 != enemy.ypos || xco - 1 != enemy.xpos) {
                player.xpos = xco - 1;
                player.ypos = yco - 1;
                System.out.println("You are now at position (" + yco + "," + xco + ")");
            } else {
                System.out.println("On top of enemy -__-");
                System.out.println("You are now at position (" + player.ypos + "," + player.xpos + ")");
            }
        } else {
            System.out.println("Out of range -__-");
            System.out.println("You are now at position (" + player.ypos + "," + player.xpos + ")");
        }
    }

    public static void displayBoard(Player player, Enemy enemy, Board board) {
        for (int x = 0; x < board.xBoardMax; x++) {
            for (int i = 0; i < board.yBoardMax; i++) {
                if (x < board.xBoardMax) {
                    if (x == player.xpos && i == player.ypos) {
                        System.out.print("P\t");
                        i++;
                    }
                    if (x == enemy.xpos && i == enemy.ypos) {
                        System.out.print("E\t");
                        i++;
                    }
                    if (i != 5) {
                        System.out.print(".\t");
                    }
                    if (i >= 4) {
                        System.out.println();
                    }
                }
            }
        }
    }

    public static void enemyAIMove(Player player, Enemy enemy) {

        int stepsRequiredRight = Math.abs(player.xpos + 1 - enemy.xpos) + Math.abs(player.ypos - enemy.ypos);
        int stepsRequiredLeft = Math.abs(player.xpos - 1 - enemy.xpos) + Math.abs(player.ypos - enemy.ypos);
        int stepsRequiredDown = Math.abs(player.xpos - enemy.xpos) + Math.abs(player.ypos + 1 - enemy.ypos);
        int stepsRequiredUp = Math.abs(player.xpos - enemy.xpos) + Math.abs(player.ypos - 1 - enemy.ypos);

        int stepsRequiredx = player.xpos - enemy.xpos;
        int stepsRequiredy = player.ypos - enemy.ypos;

        if (canGoNextToPlayer(Player.player, Enemy.enemyYouFight)) {
            if (stepsRequiredRight <= enemy.pace) {
                enemy.xpos = player.xpos + 1;
                enemy.ypos = player.ypos;
            } else if (stepsRequiredLeft <= enemy.pace) {
                enemy.xpos = player.xpos - 1;
                enemy.ypos = player.ypos;
            } else if (stepsRequiredDown <= enemy.pace) {
                enemy.xpos = player.xpos;
                enemy.ypos = player.ypos + 1;
            } else if (stepsRequiredUp <= enemy.pace) {
                enemy.xpos = player.xpos;
                enemy.ypos = player.ypos - 1;
            } else {
                goRandomPlace(enemy);
            }
        } else if (canGoInLineWithPlayer(player, enemy)) {
            if (stepsRequiredx <= enemy.pace) {
                enemy.xpos = player.ypos;
            } else if (stepsRequiredy <= enemy.pace) {
                enemy.ypos = player.ypos;
            }
        } else {
            goRandomPlace(enemy);
        }
    }

    public static boolean isNextToPlayer(Player player, Enemy enemy) {
        return player.xpos == enemy.xpos && Math.abs(player.ypos - enemy.ypos) == 1 || (player.ypos == enemy.ypos && Math.abs(enemy.xpos - player.xpos) == 1);
    }

    public static boolean isNextToEnemy(Player player, Enemy enemy) {
        return player.xpos == enemy.xpos && Math.abs(enemy.ypos - player.ypos) == 1 || (player.ypos == enemy.ypos && Math.abs(enemy.xpos - player.xpos) == 1);
    }

    private static boolean canGoNextToPlayer(Player player, Enemy enemy) {
        int stepsRequiredRight = Math.abs(player.xpos + 1 - enemy.xpos) + Math.abs(player.ypos - enemy.ypos);
        int stepsRequiredLeft = Math.abs(player.xpos - 1 - enemy.xpos) + Math.abs(player.ypos - enemy.ypos);
        int stepsRequiredDown = Math.abs(player.xpos - enemy.xpos) + Math.abs(player.ypos + 1 - enemy.ypos);
        int stepsRequiredUp = Math.abs(player.xpos - enemy.xpos) + Math.abs(player.ypos - 1 - enemy.ypos);

        return stepsRequiredRight <= enemy.pace || stepsRequiredLeft <= enemy.pace || stepsRequiredDown <= enemy.pace || stepsRequiredUp <= enemy.pace;
    }

    private static void goRandomPlace(Enemy enemy) {
        enemy.xpos = randomNum.nextInt(enemy.pace - 1) % board.xBoardMax;
        enemy.ypos = randomNum.nextInt(enemy.pace - 1) % board.yBoardMax;
    }

    private static boolean canGoInLineWithPlayer(Player player, Enemy enemy) {
        int stepsRequiredx = player.xpos - enemy.xpos;
        int stepsRequiredy = player.ypos - enemy.ypos;

        return stepsRequiredx <= enemy.pace || stepsRequiredy <= enemy.pace;
    }
}

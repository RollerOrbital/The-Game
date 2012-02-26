package rob.mainGame;

import java.util.Random;
import java.util.Scanner;

public class Board {
    static Scanner input = new Scanner(System.in);
    static Random randomNum = new Random();

    private int xBoardMax = 5;
    private int yBoardMax = 5;

    public void playerMove(Player player, Enemy enemy) {
        System.out.println("What is the xco of where you want to go?");
        int xco = input.nextInt();
        System.out.println("What is the yco of where you want to go?");
        int yco = input.nextInt();

        int stepsRequired = Math.abs(yco - player.ypos) + Math.abs(xco - 1 - player.xpos);

        if (yco - 1 < xBoardMax && xco - 1 < yBoardMax) {
            if (stepsRequired <= player.pace) {
                if (xco - 1 != enemy.ypos || yco - 1 != enemy.xpos) {
                    System.out.println();
                    player.ypos = yco - 1;
                    player.xpos = xco - 1;
                    System.out.println("You are now at position (" + xco + "," + yco + ")");
                } else {
                    System.out.println();
                    System.out.println("On top of enemy -__-");
                    System.out.println("You are now at position (" + player.xpos + "," + player.ypos + ")");
                }
            } else {
                System.out.println();
                System.out.println("You don't have a high enough pace skill -__-");
                System.out.println("You are now at position (" + player.xpos + "," + player.ypos + ")");
            }
        } else {
            System.out.println("Out of range -__-");
            System.out.println("You are now at position (" + player.xpos + "," + player.ypos + ")");
        }
    }

    public void displayBoard(Player player, Enemy enemy) {
        for (int x = 0; x < xBoardMax; x++) {
            for (int i = 0; i < yBoardMax; i++) {
                if (x < xBoardMax) {
                    if (x == player.ypos && i == player.xpos) {
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

    public void enemyAIMove(Player player, Enemy enemy) {
        int stepsRequiredRight = Math.abs(player.ypos + 1 - enemy.xpos) + Math.abs(player.xpos - enemy.ypos);
        int stepsRequiredLeft = Math.abs(player.ypos - 1 - enemy.xpos) + Math.abs(player.xpos - enemy.ypos);
        int stepsRequiredDown = Math.abs(player.ypos - enemy.xpos) + Math.abs(player.xpos + 1 - enemy.ypos);
        int stepsRequiredUp = Math.abs(player.ypos - enemy.xpos) + Math.abs(player.xpos - 1 - enemy.ypos);

        int stepsRequiredx = player.ypos - enemy.xpos;
        int stepsRequiredy = player.xpos - enemy.ypos;

        if (canGoNextToPlayer(Player.player, Enemy.enemyYouFight)) {
            if (stepsRequiredRight <= enemy.pace) {
                enemy.xpos = player.ypos + 1;
                enemy.ypos = player.xpos;
            } else if (stepsRequiredLeft <= enemy.pace) {
                enemy.xpos = player.ypos - 1;
                enemy.ypos = player.xpos;
            } else if (stepsRequiredDown <= enemy.pace) {
                enemy.xpos = player.ypos;
                enemy.ypos = player.xpos + 1;
            } else if (stepsRequiredUp <= enemy.pace) {
                enemy.xpos = player.ypos;
                enemy.ypos = player.xpos - 1;
            } else {
                goRandomPlace(enemy);
            }
        } else if (canGoInLineWithPlayer(player, enemy)) {
            if (stepsRequiredx <= enemy.pace) {
                enemy.xpos = player.xpos;
            } else if (stepsRequiredy <= enemy.pace) {
                enemy.ypos = player.xpos;
            }
        } else {
            goRandomPlace(enemy);
        }
    }

    public static boolean isNextToPlayer(Player player, Enemy enemy) {
        return player.ypos == enemy.xpos && Math.abs(player.xpos - enemy.ypos) == 1 || (player.xpos == enemy.ypos && Math.abs(enemy.xpos - player.ypos) == 1);
    }

    public static boolean isNextToEnemy(Player player, Enemy enemy) {
        return player.ypos == enemy.xpos && Math.abs(enemy.ypos - player.xpos) == 1 || (player.xpos == enemy.ypos && Math.abs(enemy.xpos - player.ypos) == 1);
    }

    private static boolean canGoNextToPlayer(Player player, Enemy enemy) {
        int stepsRequiredRight = Math.abs(player.ypos + 1 - enemy.xpos) + Math.abs(player.xpos - enemy.ypos);
        int stepsRequiredLeft = Math.abs(player.ypos - 1 - enemy.xpos) + Math.abs(player.xpos - enemy.ypos);
        int stepsRequiredDown = Math.abs(player.ypos - enemy.xpos) + Math.abs(player.xpos + 1 - enemy.ypos);
        int stepsRequiredUp = Math.abs(player.ypos - enemy.xpos) + Math.abs(player.xpos - 1 - enemy.ypos);

        return stepsRequiredRight <= enemy.pace || stepsRequiredLeft <= enemy.pace || stepsRequiredDown <= enemy.pace || stepsRequiredUp <= enemy.pace;
    }

    private void goRandomPlace(Enemy enemy) {
        enemy.xpos = randomNum.nextInt(enemy.pace - 1) % xBoardMax;
        enemy.ypos = randomNum.nextInt(enemy.pace - 1) % yBoardMax;
    }

    private static boolean canGoInLineWithPlayer(Player player, Enemy enemy) {
        int stepsRequiredx = player.ypos - enemy.xpos;
        int stepsRequiredy = player.xpos - enemy.ypos;

        return stepsRequiredx <= enemy.pace || stepsRequiredy <= enemy.pace;
    }
}

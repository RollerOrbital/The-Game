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

        int stepsRequired = Math.abs(yco - player.y) + Math.abs(xco - 1 - player.x);

        if (yco - 1 < xBoardMax && xco - 1 < yBoardMax) {
            if (stepsRequired <= player.pace) {
                if (xco - 1 != enemy.xpos || yco - 1 != enemy.ypos) {
                    System.out.println();
                    player.y = yco - 1;
                    player.x = xco - 1;
                    System.out.println("You are now at position (" + xco + "," + yco + ")");
                } else {
                    System.out.println();
                    System.out.println("On top of enemy -__-");
                    System.out.println("You are now at position (" + player.x + "," + player.y + ")");
                }
            } else {
                System.out.println();
                System.out.println("You don't have a high enough pace skill -__-");
                System.out.println("You are now at position (" + player.x + "," + player.y + ")");
            }
        } else {
            System.out.println("Out of range -__-");
            System.out.println("You are now at position (" + player.x + "," + player.y + ")");
        }
    }

    public void displayBoard(Player player, Enemy enemy) {
        for (int x = 0; x < xBoardMax; x++) {
            for (int i = 0; i < yBoardMax; i++) {
                if (x < xBoardMax) {
                    if (x == player.y && i == player.x) {
                        System.out.print("P\t");
                        i++;
                    }
                    if (x == enemy.ypos && i == enemy.xpos) {
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
        int stepsRequiredRight = Math.abs(player.y + 1 - enemy.ypos) + Math.abs(player.x - enemy.xpos);
        int stepsRequiredLeft = Math.abs(player.y - 1 - enemy.ypos) + Math.abs(player.x - enemy.xpos);
        int stepsRequiredDown = Math.abs(player.y - enemy.ypos) + Math.abs(player.x + 1 - enemy.xpos);
        int stepsRequiredUp = Math.abs(player.y - enemy.ypos) + Math.abs(player.x - 1 - enemy.xpos);

        int stepsRequiredx = player.y - enemy.ypos;
        int stepsRequiredy = player.x - enemy.xpos;

        if (canGoNextToPlayer(Player.player, Enemy.enemyYouFight)) {
            if (stepsRequiredRight <= enemy.pace) {
                enemy.ypos = player.y + 1;
                enemy.xpos = player.x;
            } else if (stepsRequiredLeft <= enemy.pace) {
                enemy.ypos = player.y - 1;
                enemy.xpos = player.x;
            } else if (stepsRequiredDown <= enemy.pace) {
                enemy.ypos = player.y;
                enemy.xpos = player.x + 1;
            } else if (stepsRequiredUp <= enemy.pace) {
                enemy.ypos = player.y;
                enemy.xpos = player.x - 1;
            } else {
                goRandomPlace(enemy);
            }
        } else if (canGoInLineWithPlayer(player, enemy)) {
            if (stepsRequiredx <= enemy.pace) {
                enemy.ypos = player.x;
            } else if (stepsRequiredy <= enemy.pace) {
                enemy.xpos = player.x;
            }
        } else {
            goRandomPlace(enemy);
        }
    }

    public static boolean areNextToEachOther(Player player, Enemy enemy) {
        return player.y == enemy.ypos && Math.abs(player.x - enemy.xpos) == 1 || (player.x == enemy.xpos && Math.abs(enemy.ypos - player.y) == 1);
    }

    private static boolean canGoNextToPlayer(Player player, Enemy enemy) {
        int stepsRequiredRight = Math.abs(player.y + 1 - enemy.ypos) + Math.abs(player.x - enemy.xpos);
        int stepsRequiredLeft = Math.abs(player.y - 1 - enemy.ypos) + Math.abs(player.x - enemy.xpos);
        int stepsRequiredDown = Math.abs(player.y - enemy.ypos) + Math.abs(player.x + 1 - enemy.xpos);
        int stepsRequiredUp = Math.abs(player.y - enemy.ypos) + Math.abs(player.x - 1 - enemy.xpos);

        return stepsRequiredRight <= enemy.pace || stepsRequiredLeft <= enemy.pace || stepsRequiredDown <= enemy.pace || stepsRequiredUp <= enemy.pace;
    }

    private void goRandomPlace(Enemy enemy) {
        enemy.ypos = randomNum.nextInt(enemy.pace - 1) % xBoardMax;
        enemy.xpos = randomNum.nextInt(enemy.pace - 1) % yBoardMax;
    }

    private static boolean canGoInLineWithPlayer(Player player, Enemy enemy) {
        int stepsRequiredx = player.y - enemy.ypos;
        int stepsRequiredy = player.x - enemy.xpos;

        return stepsRequiredx <= enemy.pace || stepsRequiredy <= enemy.pace;
    }
}

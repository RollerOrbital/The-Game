import java.util.Random;
import java.util.Scanner;

public class CombatOptions {
    static Random randomNum = new Random();
    static Scanner input = new Scanner(System.in);

    private int combatChoice(Enemy enemy, PlayerAtt player) {
        System.out.println("What will you do?");
        System.out.println("Melee");
        System.out.println("Range");
        System.out.println("Magic");
        System.out.println("Run");
        int choice = input.nextInt();
        return (choice);
    }

    private void combatRun(Enemy enemy, PlayerAtt player) {

    }


    private void ifYouWinOrLose(Enemy enemy, PlayerAtt player) {
        int xpGained = (randomNum.nextInt(PlayerAtt.luck) + (enemy.pace + enemy.aegis + enemy.agility + (enemy.cognition / 10) + enemy.scope + enemy.vigor) / 6 * enemy.baseYield) - ((PlayerAtt.level - enemy.level) * (PlayerAtt.level - enemy.level));

        switch (lowerZero(player.hp)) {
            case 0:
                System.out.println("The world goes black and you enter hell...");
                break;
            default:
                System.out.println("You defeat the " + enemy.name + " and you are very happy about this :)");
                System.out.println("You gain " + xpGained + " xp");
                player.xp += xpGained;
                System.out.println("You now have " + player.xp + " xp");
                break;
        }
    }

    private static int whoGoesFirst(int playerAgility, int enemyAgility) {
        if (playerAgility >= enemyAgility) {
            return (0);
        } else {
            return (1);
        }
    }

    private static int lowerZero(int x) {
        if (x < 0) {
            return (0);
        } else {
            return (x);
        }
    }

    private static int lowerOne(int x) {
        if (x < 1) {
            return (1);
        } else {
            return (x);
        }
    }

    private static void levelUp(PlayerAtt player) {
        if (player.xp >= player.levelUpxp) {
            System.out.println("You levelled up!");
            PlayerAtt.level++;
            player.xp -= player.xp;
            player.sp += 3;
            spSpend(PlayerAtt.player);
        }
    }

    private static int spChoice(PlayerAtt player) {
        Scanner input = new Scanner(System.in);
        System.out.println("Which skill would you like to advance? (1-8)");
        System.out.println("hp");
        System.out.println("ep");
        System.out.println("vigor");
        System.out.println("pace");
        System.out.println("agility");
        System.out.println("cognition");
        System.out.println("scope");
        System.out.println("aegis");
        int choice = input.nextInt();
        return (choice);
    }

    private static void spSpend(PlayerAtt player) {
        Scanner time = new Scanner(System.in);
        time.nextInt();
        while (player.sp > 0) {
            switch (spChoice(PlayerAtt.player)) {
                case 1:
                    System.out.println("hp was increased by 5");
                    player.hp += 5;
                    player.sp--;
                    break;
                case 2:
                    System.out.println("ep was increased by 5");
                    player.ep += 5;
                    player.sp--;
                    break;
                case 3:
                    System.out.println("vigor was increased by 2");
                    player.vigor += 2;
                    player.sp--;
                    break;
                case 4:
                    System.out.println("pace was increased by 1");
                    player.pace++;
                    player.sp--;
                    break;
                case 5:
                    System.out.println("agility was increased by 1");
                    player.agility++;
                    player.sp--;
                    break;
                case 6:
                    System.out.println("cognition was increased by 3");
                    player.cognition += 3;
                    player.sp--;
                    break;
                case 7:
                    System.out.println("scope was increased by 1");
                    player.scope++;
                    player.sp--;
                    break;
                case 8:
                    System.out.println("aegis was increased by 2");
                    player.aegis += 2;
                    player.sp--;
                    break;
                default:
                    spSpend(PlayerAtt.player);
            }
        }
    }
}
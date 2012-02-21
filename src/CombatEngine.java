import java.util.Random;
import java.util.Scanner;

public class CombatEngine {
    static Random randomNum = new Random();
    static Scanner input = new Scanner(System.in);
    static Scanner time = new Scanner(System.in);

    private static int playerCombatChoice() {
        System.out.println("What will you do; Melee, Range or Magic?");
        int choice = input.nextInt();
        return (choice);
    }

    private static void playerCombatRun(Enemy enemy, PlayerAtt player) {
        int meleeDamageDealt = lowerOne(randomNum.nextInt(10) + player.vigor + player.Mweapon.damage - randomNum.nextInt(enemy.aegis));
        int rangeDamageDealt = lowerOne(randomNum.nextInt(15) + player.scope + player.Rweapon.damage - randomNum.nextInt(enemy.aegis));
        int didMagicWork;
        int magicDamageDealt;
        if (randomNum.nextInt(101) < player.cognition) {
            magicDamageDealt = lowerOne(randomNum.nextInt(25) + ((player.cognition / 10) * 3));
            didMagicWork = 1;
        } else {
            magicDamageDealt = 0;
            didMagicWork = 0;
        }
        switch (lowerZero(player.hp)) {
            case 0:
                System.out.print("");
                break;
            default:
                switch (playerCombatChoice()) {
                    case 1:
                        System.out.println("You strike your enemy with your " + player.Mweapon.name + " for " + meleeDamageDealt + " damage");
                        time.next();
                        enemy.hp -= meleeDamageDealt;
                        System.out.println("Your opponent has " + lowerZero(enemy.hp) + " hp remaining");
                        time.next();
                        break;
                    case 2:
                        System.out.println("You fire your " + player.Rweapon.name + " at the enemy for " + rangeDamageDealt + " damage");
                        time.next();
                        enemy.hp -= rangeDamageDealt;
                        System.out.println("Your opponent has " + lowerZero(enemy.hp) + " hp remaining");
                        time.next();
                        break;
                    case 3:
                        switch (didMagicWork) {
                            case 1:
                                System.out.println("You fire a spell at your opponent and it does " + magicDamageDealt + " damage");
                                time.next();
                                enemy.hp -= magicDamageDealt;
                                System.out.println("Your opponent has " + lowerZero(enemy.hp) + " hp remaining");
                                time.next();
                                break;
                            default:
                                System.out.println("Your spell fizzles out...");
                                time.next();
                                break;
                        }
                        break;

                    default:
                        System.out.println("You strike your enemy with your " + player.Mweapon.name + " for " + meleeDamageDealt + " damage");
                        time.next();
                        enemy.hp -= meleeDamageDealt;
                        System.out.println("Your opponent has " + lowerZero(enemy.hp) + " hp remaining");
                        time.next();
                        break;
                }
        }
    }

    private static int enemyCombatChoice() {
        int enemyChoice = lowerOne(randomNum.nextInt(4));
        return (enemyChoice);
    }

    private static void enemyCombatRun(Enemy enemy, PlayerAtt player) {
        int meleeDamageDealt = lowerOne(randomNum.nextInt(15) + enemy.vigor - randomNum.nextInt(player.aegis));
        int rangeDamageDealt = lowerOne(randomNum.nextInt(10) + enemy.scope + enemy.agility - randomNum.nextInt(player.aegis));
        int didMagicWork;
        int magicDamageDealt;

        if (randomNum.nextInt(101) < enemy.cognition) {
            magicDamageDealt = lowerOne(randomNum.nextInt(25) + ((enemy.cognition / 10) * 3));
            didMagicWork = 1;
        } else {
            magicDamageDealt = 0;
            didMagicWork = 0;
        }
        switch (lowerZero(enemy.hp)) {
            case 0:
                System.out.print("");
                break;
            default:
                switch (enemyCombatChoice()) {
                    case 1:
                        System.out.println("Your enemy strikes you for " + meleeDamageDealt + " damage");
                        time.nextInt();
                        player.hp -= meleeDamageDealt;
                        System.out.println("You have " + lowerZero(player.hp) + " hp remaining");
                        time.next();
                        break;
                    case 2:
                        System.out.println("Your enemy fires their weapon for " + rangeDamageDealt + " damage");
                        time.next();
                        player.hp -= rangeDamageDealt;
                        System.out.println("You have " + lowerZero(player.hp) + " hp remaining");
                        time.next();
                        break;
                    case 3:
                        if (didMagicWork == 1) {
                            System.out.println("Your enemy fires a spell for " + magicDamageDealt + " damage");
                            time.next();
                            player.hp -= magicDamageDealt;
                            System.out.println("You have " + lowerZero(player.hp) + " hp remaining");
                            time.next();
                        } else {
                            System.out.println("Your enemy's spell fizzles out!");
                            time.next();
                        }
                        break;
                    default:
                        System.out.println("Your enemy strikes you for " + meleeDamageDealt + " damage");
                        time.next();
                        player.hp -= meleeDamageDealt;
                        System.out.println("You have " + lowerZero(player.hp) + " hp remaining");
                        time.next();
                        break;
                }
        }
    }

    private static void ifYouWinOrLose(Enemy enemy, PlayerAtt player) {
        int xpGained = (randomNum.nextInt(PlayerAtt.luck) + (enemy.pace + enemy.aegis + enemy.agility + (enemy.cognition / 10) + enemy.scope + enemy.vigor) / 6 * enemy.baseYield) - ((PlayerAtt.level - enemy.level) * (PlayerAtt.level - enemy.level));

        switch (lowerZero(player.hp)) {
            case 0:
                System.out.println("The world goes black and you enter the underworld...");
                time.next();
                DeathsDice.die(player);
                break;
            default:
                System.out.println("You defeat the " + enemy.name + " and you are very happy about this :)");
                time.next();
                System.out.println("You gain " + xpGained + " xp");
                time.next();
                player.xp += xpGained;
                System.out.println("You now have " + player.xp + " xp");
                levelUp(player);
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
            time.next();
            PlayerAtt.level++;
            player.xp -= player.xp;
            player.sp += 3;
            spSpend(PlayerAtt.player);
        }
    }

    private static int spChoice() {
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
        time.next();
        while (player.sp > 0) {
            switch (spChoice()) {
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
                    System.out.println("cognition was increased by 2");
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

    public static void combatTurn(Enemy enemy, PlayerAtt player) {
        System.out.println(PlayerAtt.name + "! You are in a battle with a " + enemy.name + "!");
        time.next();
        switch (whoGoesFirst(player.agility, enemy.agility)) {
            case 0:
                while (player.hp > 0 && enemy.hp > 0) {
                    playerCombatRun(enemy, player);
                    enemyCombatRun(enemy, player);
                }
                break;
            case 1:
                while (player.hp > 0 && enemy.hp > 0) {
                    enemyCombatRun(enemy, player);
                    playerCombatRun(enemy, player);
                }
                break;
        }
        ifYouWinOrLose(enemy, player);
    }
}
//
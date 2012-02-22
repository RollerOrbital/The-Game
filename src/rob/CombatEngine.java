package rob;

import java.util.Random;
import java.util.Scanner;

public class CombatEngine {
    static Random randomNum = new Random();
    static Scanner input = new Scanner(System.in);
    static Scanner time = new Scanner(System.in);

    private static int playerCombatChoice() {
        System.out.println("What will you do; Melee, Range, Magic or Healing Item?");
        int choice = input.nextInt();
        return (choice);
    }

    private static void playerCombatRun(Enemy enemy, PlayerAtt player) {
        int meleeDamageDealt = lowerOne(randomNum.nextInt(PlayerAtt.fortune + 5) + player.vigor + player.Mweapon.damage - randomNum.nextInt(enemy.aegis));
        int rangeDamageDealt = lowerOne(randomNum.nextInt(PlayerAtt.fortune) + player.scope + player.Rweapon.damage - randomNum.nextInt(enemy.aegis));
        int didMagicWork;
        if (randomNum.nextInt(101) < player.cognition) {
            didMagicWork = 1;
        } else {
            didMagicWork = 0;
        }

        switch (lowerZero(player.hp)) {
            case 0:
                System.out.print("");
                break;
            default:
                switch (playerCombatChoice()) {
                    case 1:
                        System.out.println("You strike your enemy with your " + meleeWeaponChoice().name + " for " + meleeDamageDealt + " damage");
                        time.next();
                        enemy.hp -= meleeDamageDealt;
                        System.out.println("Your opponent has " + lowerZero(enemy.hp) + " hp remaining");
                        time.next();
                        break;
                    case 2:
                        System.out.println("You fire your " + rangeWeaponChoice().name + " at the enemy for " + rangeDamageDealt + " damage");
                        time.next();
                        enemy.hp -= rangeDamageDealt;
                        System.out.println("Your opponent has " + lowerZero(enemy.hp) + " hp remaining");
                        time.next();
                        break;
                    case 3:
                        switch (whichTypeOfMagic()) {
                            case 1:
                                DamageMagic damageSpell = damageMagicChoice();
                                if (player.mp >= damageSpell.mpCost) {
                                    int magicDamageDealt = lowerOne(randomNum.nextInt(PlayerAtt.fortune + 15) + ((player.cognition / 10)) + damageSpell.damage);

                                    switch (didMagicWork) {
                                        case 1:
                                            damageSpellWorks(damageSpell, player, enemy, magicDamageDealt);
                                            break;
                                        default:
                                            System.out.println("Your spell fizzles out...");
                                            time.next();
                                            break;
                                    }
                                } else {
                                    System.out.println("You don't have enough mp to cast " + damageSpell.name);
                                }
                                break;
                            case 2:
                                HealingMagic healingSpell = healingMagicChoice();
                                if (player.mp >= healingSpell.mpCost) {
                                    int healthRestored = healingSpell.healthRestored + randomNum.nextInt(PlayerAtt.fortune);

                                    switch (didMagicWork) {
                                        case 1:
                                            healingSpellWorks(healingSpell, player, healthRestored);
                                            break;
                                        default:
                                            System.out.println("Your spell fizzles out...");
                                            time.next();
                                            break;
                                    }
                                } else {
                                    System.out.println("You don't have enough mp to cast " + healingSpell.name);
                                }
                        }
                        break;

                    case 4:
                        HealingItem healingItem = healingItemChoice();
                        System.out.println("You use your " + healingItem.name + " to heal " + healingItem.healthRestored + " health");
                        time.nextInt();
                        lowerThan(player.hp += healingItem.healthRestored, player.basehp);
                        System.out.println("You now have " + lowerZero(player.hp) + " hp remaining");
                        time.nextInt();
                        break;
                    default:
                        System.out.println("You strike your enemy with your " + meleeWeaponChoice().name + " for " + meleeDamageDealt + " damage");
                        time.next();
                        enemy.hp -= meleeDamageDealt;
                        System.out.println("Your opponent has " + lowerZero(enemy.hp) + " hp remaining");
                        time.next();
                        break;
                }
        }
    }

    private static void damageSpellWorks(DamageMagic damageSpell, PlayerAtt player, Enemy enemy, int magicDamageDealt) {
        System.out.println("You cast " + damageSpell.name + " and it does " + magicDamageDealt + " damage");
        player.mp -= damageSpell.mpCost;
        time.next();
        System.out.println("You have " + lowerZero(player.mp) + " mp remaining");
        enemy.hp -= magicDamageDealt;
        time.next();
        System.out.println("Your opponent has " + lowerZero(enemy.hp) + " hp remaining");
        time.next();
    }

    private static void healingSpellWorks(HealingMagic healingSpell, PlayerAtt player, int healthRestored) {
        System.out.println("You cast " + healingSpell.name + " to heal you for " + healthRestored + "hp");
        time.nextInt();
        System.out.println("It costs you " + healingSpell.mpCost + " mp points");
        player.mp -= healingSpell.mpCost;
        time.next();
        System.out.println("You have " + lowerZero(player.mp) + " mp remaining");
        time.nextInt();
        lowerThan(player.hp += healthRestored, player.basehp);
        System.out.println("You now have " + lowerZero(player.hp) + " hp remaining");
        time.nextInt();
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
        int xpGained = (randomNum.nextInt(PlayerAtt.fortune) + (enemy.pace + enemy.aegis + enemy.agility + (enemy.cognition / 10) + enemy.scope + enemy.vigor) / 6 * enemy.baseYield) - ((PlayerAtt.level - enemy.level) * (PlayerAtt.level - enemy.level));

        switch (lowerZero(player.hp)) {
            case 0:
                System.out.println("The world goes black and you enter the underworld...");
                time.next();
                DeathsDice.die(player);
                break;
            default:
                System.out.println("You defeat the " + enemy.name + " and you are very happy about this");
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

    private static int lowerThan(int number, int upperLimit) {
        if (number >= upperLimit) {
            return (upperLimit);
        } else {
            return (number);
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
        System.out.println("Which skill would you like to advance? (1-9)");
        System.out.println("HP");
        System.out.println("MP");
        System.out.println("Vigor");
        System.out.println("Pace");
        System.out.println("Twitch");
        System.out.println("Cognition");
        System.out.println("Scope");
        System.out.println("Aegis");
        System.out.println("Fortune");
        int choice = input.nextInt();
        return (choice);
    }

    private static void spSpend(PlayerAtt player) {
        time.next();
        while (player.sp > 0) {
            switch (spChoice()) {
                case 1:
                    System.out.println("HP was increased by 5");
                    player.hp += 5;
                    player.sp--;
                    break;
                case 2:
                    System.out.println("MP was increased by 5");
                    player.mp += 5;
                    player.sp--;
                    break;
                case 3:
                    System.out.println("Vigor was increased by 2");
                    player.vigor += 2;
                    player.sp--;
                    break;
                case 4:
                    System.out.println("Pace was increased by 1");
                    player.pace++;
                    player.sp--;
                    break;
                case 5:
                    System.out.println("Twitch was increased by 1");
                    player.twitch++;
                    player.sp--;
                    break;
                case 6:
                    System.out.println("Cognition was increased by 2");
                    player.cognition += 3;
                    player.sp--;
                    break;
                case 7:
                    System.out.println("Scope was increased by 1");
                    player.scope++;
                    player.sp--;
                    break;
                case 8:
                    System.out.println("Aegis was increased by 2");
                    player.aegis += 2;
                    player.sp--;
                    break;
                case 9:
                    System.out.println("Fortune was increased by 1");
                    PlayerAtt.fortune += 2;
                    player.sp--;
                    break;
                default:
                    spSpend(PlayerAtt.player);
            }
        }
    }

    private static MeleeWeapon meleeWeaponChoice() {
        System.out.println("Which weapon would you like to use?");
        try {
            for (int x = 0; x < 100; x++) {
                System.out.println(PlayerAtt.MweaponInventory[x].name);
            }
        } catch (Exception e) {
            System.out.print("");
        }
        int choice = input.nextInt();
        try {
            return (PlayerAtt.MweaponInventory[choice - 1]);
        } catch (Exception e) {
            return (PlayerAtt.MweaponInventory[0]);
        }
    }

    private static HealingItem healingItemChoice() {
        System.out.println("Which healing item would you like to use?");
        try {
            for (int x = 0; x < 100; x++) {
                System.out.println(PlayerAtt.HIInventory[x].name);
            }
        } catch (Exception e) {
            System.out.print("");
        }
        int choice = input.nextInt();
        try {
            return (PlayerAtt.HIInventory[choice - 1]);
        } catch (Exception e) {
            return (PlayerAtt.HIInventory[0]);
        }
    }

    private static RangeWeapon rangeWeaponChoice() {
        System.out.println("Which weapon would you like to use?");
        try {
            for (int x = 0; x < 100; x++) {
                System.out.println(PlayerAtt.RweaponInventory[x].name);
            }
        } catch (Exception e) {
            System.out.print("");
        }
        int choice = input.nextInt();
        try {
            return (PlayerAtt.RweaponInventory[choice - 1]);
        } catch (Exception e) {
            return (PlayerAtt.RweaponInventory[0]);
        }
    }

    private static int whichTypeOfMagic() {
        System.out.println("Which type of magic would you like to use?");
        System.out.println("Damaging");
        System.out.println("Healing");
        int choice = input.nextInt();
        return (choice);
    }

    private static HealingMagic healingMagicChoice() {
        System.out.println("Which spell would you like to use?");
        try {
            for (int x = 0; x < 100; x++) {
                System.out.println(PlayerAtt.HMInventory[x].name);
            }
        } catch (Exception e) {
            System.out.print("");
        }
        int choice = input.nextInt();
        try {
            return (PlayerAtt.HMInventory[choice - 1]);
        } catch (Exception e) {
            return (PlayerAtt.HMInventory[0]);
        }
    }

    private static DamageMagic damageMagicChoice() {
        System.out.println("Which spell would you like to use?");
        try {
            for (int x = 0; x < 100; x++) {
                System.out.println(PlayerAtt.DMInventory[x].name);
            }
        } catch (Exception e) {
            System.out.print("");
        }
        int choice = input.nextInt();
        try {
            return (PlayerAtt.DMInventory[choice - 1]);
        } catch (Exception e) {
            return (PlayerAtt.DMInventory[0]);
        }
    }

    public static void combatTurn(Enemy enemy, PlayerAtt player) {
        System.out.println(PlayerAtt.name + "! You are in a battle with a " + enemy.name + "!");
        time.next();
        switch (whoGoesFirst(player.twitch, enemy.agility)) {
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
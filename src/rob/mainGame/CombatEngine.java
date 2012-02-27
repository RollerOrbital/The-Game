package rob.mainGame;

import java.util.Random;
import java.util.Scanner;

public class CombatEngine {
    static Random randomNum = new Random();
    static Scanner input = new Scanner(System.in);
    static Scanner time = new Scanner(System.in);

    private static int playerCombatChoice() {
        System.out.println("What will you do; Melee, Range, Magic, Healing Item?");
        int choice = input.nextInt();
        return (choice);
    }

    private static void playerCombatRun(Enemy enemy, Player player, Board board) {
        int meleeDamageDealt = lowerOne(randomNum.nextInt(Player.fortune + 5) + player.vigor + player.Mweapon.damage - randomNum.nextInt(enemy.aegis));
        int rangeDamageDealt = lowerOne(randomNum.nextInt(Player.fortune) + player.scope + player.Rweapon.damage - randomNum.nextInt(enemy.aegis));
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
                System.out.println();
                board.playerMove(player, enemy);
                board.displayBoard(player, enemy);
                switch (playerCombatChoice()) {
                    case 1:
                        playerMeleeStrike(enemy, meleeDamageDealt, player);
                        break;
                    case 2:
                        playerFireRangeWeapon(enemy, rangeDamageDealt, player);
                        break;
                    case 3:
                        switch (whichTypeOfMagic()) {
                            case 1:
                                DamageMagic damageSpell = damageMagicChoice();
                                if (player.mp >= damageSpell.mpCost) {
                                    int magicDamageDealt = lowerOne(randomNum.nextInt(Player.fortune + 15) + ((player.cognition / 10)) + damageSpell.damage);

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
                                    switch (didMagicWork) {
                                        case 1:
                                            healingSpellWorks(healingSpell, player);
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
                        useHealingItem(player);
                        break;
                    default:
                        playerMeleeStrike(enemy, meleeDamageDealt, player);
                        break;
                }
        }
    }

    private static void playerFireRangeWeapon(Enemy enemy, int rangeDamageDealt, Player player) {
        if (player.y == enemy.y || player.x == enemy.x) {
            System.out.println("You fire your " + rangeWeaponChoice().name + " at the enemy for " + rangeDamageDealt + " damage");
            time.next();
            enemy.hp -= rangeDamageDealt;
            System.out.println("Your opponent has " + lowerZero(enemy.hp) + " hp remaining");
            time.next();
        } else {
            System.out.println("You can't because you aren't in line with the enemy -__-");
        }
    }

    private static void playerMeleeStrike(Enemy enemy, int meleeDamageDealt, Player player) {
        if (Board.areNextToEachOther(player, enemy)) {
            System.out.println("You strike your enemy with your " + meleeWeaponChoice().name + " for " + meleeDamageDealt + " damage");
            time.next();
            enemy.hp -= meleeDamageDealt;
            System.out.println("Your opponent has " + lowerZero(enemy.hp) + " hp remaining");
            time.next();
        } else {
            System.out.println("You can't because you aren't next to the enemy -__-");
        }
    }

    private static void useHealingItem(Player player) {
        HealingItem healingItem = healingItemChoice();
        System.out.println("You use your " + healingItem.name + " to heal " + healingItem.healthRestored + " health");
        time.nextInt();
        player.hp += healingItem.healthRestored;
        if (player.hp > player.basehp) {
            player.hp = player.basehp;
        }
        System.out.println("You now have " + player.hp + " hp remaining");
        time.nextInt();
    }

    private static void damageSpellWorks(DamageMagic damageSpell, Player player, Enemy enemy, int magicDamageDealt) {
        if (player.y == enemy.y || player.x == enemy.x) {
            System.out.println("You cast " + damageSpell.name + " and it does " + magicDamageDealt + " damage");
            player.mp -= damageSpell.mpCost;
            time.next();
            System.out.println("You have " + lowerZero(player.mp) + " mp remaining");
            enemy.hp -= magicDamageDealt;
            time.next();
            System.out.println("Your opponent has " + lowerZero(enemy.hp) + " hp remaining");
            time.next();
        } else {
            System.out.println("You can't because you aren't in line with the enemy -__-");
        }
    }

    private static void healingSpellWorks(HealingMagic healingSpell, Player player) {
        System.out.println("You cast " + healingSpell.name + " to heal you for " + healingSpell.healthRestored + randomNum.nextInt(Player.fortune) + "hp");
        time.nextInt();
        System.out.println("It costs you " + healingSpell.mpCost + " mp points");
        player.mp -= healingSpell.mpCost;
        time.next();
        System.out.println("You have " + lowerZero(player.mp) + " mp remaining");
        time.nextInt();
        lower(player.hp += healingSpell.healthRestored + randomNum.nextInt(Player.fortune), player.basehp);
        System.out.println("You now have " + lowerZero(player.hp) + " hp remaining");
        time.nextInt();
    }

    private static int enemyCombatChoice(Player player, Enemy enemy) {
        int rangeOrMagic = randomNum.nextInt(101);
        int returnThing;

        if (Board.areNextToEachOther(player, enemy)) {
            returnThing = 1;
        } else if (player.y == enemy.y || player.x == enemy.x) {
            if (rangeOrMagic <= 50) {
                returnThing = 2;
            } else {
                returnThing = 3;
            }
        } else {
            returnThing = 1;
        }
        return returnThing;
    }

    private static void enemyCombatRun(Enemy enemy, Player player, Board board) {
        int meleeDamageDealt = lowerOne(randomNum.nextInt(15) + enemy.vigor - randomNum.nextInt(player.aegis));
        int rangeDamageDealt = lowerOne(randomNum.nextInt(10) + enemy.scope + enemy.twitch - randomNum.nextInt(player.aegis));
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
                System.out.println();
                board.enemyAIMove(player, enemy);
                board.displayBoard(player, enemy);
                switch (enemyCombatChoice(player, enemy)) {
                    case 1:
                        enemyMeleeStrike(player, meleeDamageDealt, enemy);
                        break;
                    case 2:
                        enemyFireRangeWeapon(player, rangeDamageDealt, enemy);
                        break;
                    case 3:
                        if (didMagicWork == 1) {
                            enemyDamageSpellFire(player, magicDamageDealt, enemy);
                        } else {
                            System.out.println("Your enemy's spell fizzles out!");
                            time.next();
                        }
                        break;
                    default:
                        enemyMeleeStrike(player, meleeDamageDealt, enemy);
                        break;
                }
        }
    }

    private static void enemyDamageSpellFire(Player player, int magicDamageDealt, Enemy enemy) {
        if (player.y == enemy.y || player.x == enemy.x) {
            System.out.println("Your enemy fires a spell for " + magicDamageDealt + " damage");
            time.next();
            player.hp -= magicDamageDealt;
            System.out.println("You have " + lowerZero(player.hp) + " hp remaining");
            time.next();
        }
    }

    private static void enemyFireRangeWeapon(Player player, int rangeDamageDealt, Enemy enemy) {
        if (player.y == enemy.y || player.x == enemy.x) {
            System.out.println("Your enemy fires their weapon for " + rangeDamageDealt + " damage");
            time.next();
            player.hp -= rangeDamageDealt;
            System.out.println("You have " + lowerZero(player.hp) + " hp remaining");
            time.next();
        }
    }

    private static void enemyMeleeStrike(Player player, int meleeDamageDealt, Enemy enemy) {
        if (Board.areNextToEachOther(player, enemy)) {
            System.out.println("Your enemy strikes you for " + meleeDamageDealt + " damage");
            time.nextInt();
            player.hp -= meleeDamageDealt;
            System.out.println("You have " + lowerZero(player.hp) + " hp remaining");
            time.next();
        }
    }

    private static void ifYouWinOrLose(Enemy enemy, Player player) {
        int xpGained = (randomNum.nextInt(Player.fortune) + (enemy.pace + enemy.aegis + enemy.twitch + (enemy.cognition / 10) + enemy.scope + enemy.vigor) / 6 * enemy.baseYield) - ((Player.level - enemy.level) * (Player.level - enemy.level));

        switch (lowerZero(player.hp)) {
            case 0:
                System.out.println("The world goes black and you enter the underworld...");
                time.next();
                DeathsDice.die(player);
                break;
            default:
                System.out.println("You defeat the " + enemy.name + " and you are very happy about this");
                time.next();
                System.out.println("You gain " + xpGained + " exp");
                time.next();
                player.exp += xpGained;
                System.out.println("You now have " + player.exp + " exp");
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

    private static int lower(int number, int upperLimit) {
        if (number >= upperLimit) {
            return (upperLimit);
        } else {
            return (number);
        }
    }

    private static void levelUp(Player player) {
        if (player.exp >= player.levelUpxp) {
            System.out.println("You levelled up!");
            time.next();
            Player.level++;
            player.exp -= player.exp;
            player.sp += 3;
            spSpend(Player.player);
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

    private static void spSpend(Player player) {
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
                    Player.fortune += 2;
                    player.sp--;
                    break;
                default:
                    spSpend(Player.player);
            }
        }
    }

    private static MeleeWeapon meleeWeaponChoice() {
        System.out.println("Which weapon would you like to use?");
        try {
            for (int x = 0; x < 100; x++) {
                System.out.println(Player.MweaponInventory[x].name);
            }
        } catch (Exception e) {
            System.out.print("");
        }
        int choice = input.nextInt();
        try {
            return (Player.MweaponInventory[choice - 1]);
        } catch (Exception e) {
            return (Player.MweaponInventory[0]);
        }
    }

    private static HealingItem healingItemChoice() {
        System.out.println("Which healing item would you like to use?");
        try {
            for (int x = 0; x < 100; x++) {
                System.out.println(Player.HIInventory[x].name);
            }
        } catch (Exception e) {
            System.out.print("");
        }
        int choice = input.nextInt();
        try {
            return (Player.HIInventory[choice - 1]);
        } catch (Exception e) {
            return (Player.HIInventory[0]);
        }
    }

    private static RangeWeapon rangeWeaponChoice() {
        System.out.println("Which weapon would you like to use?");
        try {
            for (int x = 0; x < 100; x++) {
                System.out.println(Player.RweaponInventory[x].name);
            }
        } catch (Exception e) {
            System.out.print("");
        }
        int choice = input.nextInt();
        try {
            return (Player.RweaponInventory[choice - 1]);
        } catch (Exception e) {
            return (Player.RweaponInventory[0]);
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
                System.out.println(Player.HMInventory[x].name);
            }
        } catch (Exception e) {
            System.out.print("");
        }
        int choice = input.nextInt();
        try {
            return (Player.HMInventory[choice - 1]);
        } catch (Exception e) {
            return (Player.HMInventory[0]);
        }
    }

    private static DamageMagic damageMagicChoice() {
        System.out.println("Which spell would you like to use?");
        try {
            for (int x = 0; x < 100; x++) {
                System.out.println(Player.DMInventory[x].name);
            }
        } catch (Exception e) {
            System.out.print("");
        }
        int choice = input.nextInt();
        try {
            return (Player.DMInventory[choice - 1]);
        } catch (Exception e) {
            return (Player.DMInventory[0]);
        }
    }

    public static void combatTurn(Enemy enemy, Player player, Board board) {
        System.out.println(Player.name + "! You are in a battle with a " + enemy.name + "!");
        board.displayBoard(player, enemy);
        System.out.println();
        time.next();
        switch (whoGoesFirst(player.twitch, enemy.twitch)) {
            case 0:
                while (player.hp > 0 && enemy.hp > 0) {
                    playerCombatRun(enemy, player, board);
                    enemyCombatRun(enemy, player, board);
                }
                break;
            case 1:
                while (player.hp > 0 && enemy.hp > 0) {
                    enemyCombatRun(enemy, player, board);
                    playerCombatRun(enemy, player, board);
                }
                break;
        }
        ifYouWinOrLose(enemy, player);
    }
}
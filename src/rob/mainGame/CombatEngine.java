package rob.mainGame;

import java.util.Random;

public class CombatEngine {

    Random random = new Random();
    public static String playerStrikes = "";
    public static String enemyStrikes = "";
    public static String playerShoots = "";
    public static String enemyShoots = "";
    public static String playerMages = "";
    public static String enemyMages = "";
    private int moves;
    private Player p;
    private IDroid i;

    public int lowerZero(int x) {
        if (x < 0) {
            return 0;
        } else {
            return x;
        }
    }

    public CombatEngine() {
        moves = 0;
        p = Map.player;
        i = Map.iDroid;
    }

    public void playerStrike() {
        int damage = p.vigor + random.nextInt(p.fortune) - random.nextInt(i.aegis);
        i.hp -= damage;
        playerStrikes = "You strike your opponent for " + damage + " damage.\nThey have " + lowerZero(i.hp) + " hp remaining";
    }

    public void enemyStrikes() {
        int damage = i.vigor + random.nextInt(i.fortune) - random.nextInt(p.aegis);
        p.hp -= damage;
        enemyStrikes = "Your opponent strikes you for " + damage + " damage.\nYou have " + lowerZero(p.hp) + " hp remaining";
    }

    public void playerShoots() {
        int damage = p.scope + random.nextInt(p.fortune) - random.nextInt(i.aegis);
        i.hp -= damage;
        playerShoots = "You shoot your opponent for " + damage + " damage.\nThey have " + lowerZero(i.hp) + " hp remaining";
    }

    public void enemyShoots() {
        int damage = i.scope + random.nextInt(i.fortune) - random.nextInt(p.aegis);
        p.hp -= damage;
        enemyShoots = "Your opponent shoots you for " + damage + " damage.\nYou have " + lowerZero(p.hp) + " hp remaining";
    }

    public void playerMages() {
        int damage = p.cognition / 2 + random.nextInt(p.fortune);
        i.hp -= damage;
        p.mp -= 30;
        playerMages = "You fire a spell at your opponent for " + damage + " damage.\nThey have " + lowerZero(i.hp) + " hp remaining.\nYou have " + lowerZero(p.mp) + " mp remaining";
    }

    public void enemyMages() {
        int damage = i.cognition / 2 + random.nextInt(i.fortune);
        p.hp -= damage;
        i.mp -= 30;
        enemyMages = "Your opponent fires a spell at you for " + damage + " damage.\nYou have " + lowerZero(p.hp) + " hp remaining";
    }

    public void basicCombat() {
        if (!(p.twitch > i.twitch)) {
            playerMove();
            playerCombatRun();
            enemyMove();
            enemyCombatRun();
        } else {
            enemyMove();
            enemyCombatRun();
            playerMove();
            playerCombatRun();
        }
    }

    private void enemyCombatRun() {
        if (Math.abs(p.x - i.x) <= 40 && Math.abs(p.y - i.y) <= 40) {
            enemyStrikes();
        } else if (Math.abs(p.x - i.x) <= 40 || Math.abs(p.y - i.y) <= 40) {
            enemyShoots();
        } else {
            enemyMages();
        }
    }

    private void playerCombatRun() {
        if (Math.abs(p.x - i.x) <= 40 && Math.abs(p.y - i.y) <= 40) {
            playerStrike();
        } else if (Math.abs(p.x - i.x) <= 40 || Math.abs(p.y - i.y) <= 40) {
            playerShoots();
        } else {
            playerMages();
        }
    }

    public void playerMove() {
        if (moves <= p.pace) {
            p.move();
            moves++;
        }
    }

    public void enemyMove() {
        int stepsReqR = Math.abs(p.x + 32 - i.x) + Math.abs(p.y - i.y);
        int stepsReqL = Math.abs(p.x - 32 - i.x) + Math.abs(p.y - i.y);
        int stepsReqU = Math.abs(p.x - i.x) + Math.abs(p.y - 32 - i.y);
        int stepsReqD = Math.abs(p.x - i.x) + Math.abs(p.y + 32 - i.y);

        if (stepsReqR <= i.pace * 32) {
            i.x = p.x + 32;
            i.y = p.y;
        } else if (stepsReqL <= i.pace * 32) {
            i.x = p.x - 32;
            i.y = p.y;
        } else if (stepsReqU <= i.pace * 32) {
            i.x = p.x;
            i.y = p.y - 32;
        } else if (stepsReqD <= i.pace * 32) {
            i.x = p.x;
            i.y = p.y + 32;
        }
    }
}

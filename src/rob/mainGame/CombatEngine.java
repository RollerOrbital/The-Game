package rob.mainGame;

import java.util.Random;

public class CombatEngine {


    public static String playerStrikes = "";
    public static String enemyStrikes = "";
    public static String playerShoots = "";
    public static String enemyShoots = "";
    public static String playerMages = "";
    public static String enemyMages = "";

    int moves = 0;

    Random random = new Random();
    Player p;
    IDroid e;

    public int lowerZero(int x) {
        if (x < 0) {
            return 0;
        } else {
            return x;
        }
    }

    public void playerStrike() {
        int damage = p.vigor + random.nextInt(p.fortune) - random.nextInt(e.aegis);
        e.hp -= damage;
        playerStrikes = "You strike your opponent for " + damage + " damage.\nThey have " + lowerZero(e.hp) + " hp remaining";
    }

    public void enemyStrikes() {
        int damage = e.vigor + random.nextInt(e.fortune) - random.nextInt(p.aegis);
        p.hp -= damage;
        enemyStrikes = "Your opponent strikes you for " + damage + " damage.\nYou have " + lowerZero(p.hp) + " hp remaining";
    }

    public void playerShoots() {
        int damage = p.scope + random.nextInt(p.fortune) - random.nextInt(e.aegis);
        e.hp -= damage;
        playerShoots = "You shoot your opponent for " + damage + " damage.\nThey have " + lowerZero(e.hp) + " hp remaining";
    }

    public void enemyShoots() {
        int damage = e.scope + random.nextInt(e.fortune) - random.nextInt(p.aegis);
        p.hp -= damage;
        enemyShoots = "Your opponent shoots you for " + damage + " damage.\nYou have " + lowerZero(p.hp) + " hp remaining";
    }

    public void playerMages() {
        int damage = p.cognition / 2 + random.nextInt(p.fortune);
        e.hp -= damage;
        playerMages = "You fire a spell at your opponent for " + damage + " damage.\nThey have " + lowerZero(e.hp) + " hp remaining";
    }

    public void enemyMages() {
        int damage = e.cognition / 2 + random.nextInt(e.fortune);
        p.hp -= damage;
        enemyMages = "Your opponent fires a spell at you for " + damage + " damage.\nYou have " + lowerZero(p.hp) + " hp remaining";
    }

    public void basicCombat() {
        if (p.twitch >= e.twitch) {
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
        if (Math.abs(p.x - e.x) <= 40 && Math.abs(p.y - e.y) <= 40) {
            enemyStrikes();
        } else if (Math.abs(p.x - e.x) <= 40 || Math.abs(p.y - e.y) <= 40) {
            enemyShoots();
        } else {
            enemyMages();
        }
    }

    private void playerCombatRun() {
        if (Math.abs(p.x - e.x) <= 40 && Math.abs(p.y - e.y) <= 40) {
            playerStrike();
        } else if (Math.abs(p.x - e.x) <= 40 || Math.abs(p.y - e.y) <= 40) {
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
        int stepsReqR = Math.abs(p.x + 1 - e.x) + Math.abs(p.y - e.y);
        int stepsReqL = Math.abs(p.x - 1 - e.x) + Math.abs(p.y - e.y);
        int stepsReqU = Math.abs(p.x - e.x) + Math.abs(p.y - 1 - e.y);
        int stepsReqD = Math.abs(p.x - e.x) + Math.abs(p.y + 1 - e.y);

        if (stepsReqR <= e.pace) {
            e.x = p.x + 1;
            e.y = p.y;
        } else if (stepsReqL <= e.pace) {
            e.x = p.x - 1;
            e.y = p.y;
        } else if (stepsReqU <= e.pace) {
            e.x = p.x;
            e.y = p.y - 1;
        } else if (stepsReqD <= e.pace) {
            e.x = p.x;
            e.y = p.y + 1;
        }
    }
}

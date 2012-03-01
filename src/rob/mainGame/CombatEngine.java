package rob.mainGame;

import java.util.Random;

public class CombatEngine {

    public String playerStrikes = "";
    public String enemyStrikes = "";
    public String playerShoots = "";
    public String enemyShoots = "";

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
        playerShoots = "You fire a spell at your opponent for " + damage + " damage.\nThey have " + lowerZero(e.hp) + " hp remaining";
    }

    public void enemyMages() {
        int damage = e.cognition / 2 + random.nextInt(e.fortune);
        p.hp -= damage;
        enemyShoots = "Your opponent fires a spell at you for " + damage + " damage.\nYou have " + lowerZero(p.hp) + " hp remaining";
    }

    public void basicCombat() {
        if (p.twitch >= e.twitch) {
            if (Math.abs(p.x - e.x) <= 40 && Math.abs(p.y - e.y) <= 40) {
                playerStrike();
            } else if (Math.abs(p.x - e.x) <= 40 || Math.abs(p.y - e.y) <= 40) {
                playerShoots();
            } else {
                playerMages();
            }
        } else {
            if (Math.abs(p.x - e.x) <= 40 && Math.abs(p.y - e.y) <= 40) {
                enemyStrikes();
            } else if (Math.abs(p.x - e.x) <= 40 || Math.abs(p.y - e.y) <= 40) {
                enemyShoots();
            } else {
                enemyMages();
            }
        }
    }

}

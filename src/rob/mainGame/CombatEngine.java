package rob.mainGame;

import java.util.Random;

public class CombatEngine {//

    Random random = new Random();
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
        p = new Player();
        i = new IDroid();
    }

    public void playerStrike() {
        int damage = p.vigor + random.nextInt(p.fortune) - random.nextInt(i.aegis);
        i.hp -= damage;
        System.out.println("You strike your opponent for " + damage + " damage.\nThey have " + lowerZero(i.hp) + " hp remaining");
    }

    public void enemyStrikes() {
        int damage = i.vigor + random.nextInt(i.fortune) - random.nextInt(p.aegis);
        p.hp -= damage;
        System.out.println("Your opponent strikes you for " + damage + " damage.\nYou have " + lowerZero(p.hp) + " hp remaining");
    }

    public void playerShoots() {
        int damage = p.scope + random.nextInt(p.fortune) - random.nextInt(i.aegis);
        i.hp -= damage;
        System.out.println("You shoot your opponent for " + damage + " damage.\nThey have " + lowerZero(i.hp) + " hp remaining");
    }

    public void enemyShoots() {
        int damage = i.scope + random.nextInt(i.fortune) - random.nextInt(p.aegis);
        p.hp -= damage;
        System.out.println("Your opponent shoots you for " + damage + " damage.\nYou have " + lowerZero(p.hp) + " hp remaining");
    }

    public void playerMages() {
        if (p.cognition >= 30) {
            int damage = p.cognition / 2 + random.nextInt(p.fortune);
            i.hp -= damage;
            p.mp -= 30;
            System.out.println("You fire a spell at your opponent for " + damage + " damage.\nThey have " + lowerZero(i.hp) + " hp remaining.\nYou have " + lowerZero(p.mp) + " mp remaining");
        }
    }

    public void enemyMages() {
        if (i.cognition >= 30) {
            int damage = i.cognition / 2 + random.nextInt(i.fortune);
            p.hp -= damage;
            i.mp -= 30;
            System.out.println("Your opponent fires a spell at you for " + damage + " damage.\nYou have " + lowerZero(p.hp) + " hp remaining");
        }
    }

    public void basicCombat() {
        playerMove();
        if (p.dialogContinue)
            playerCombatRun();
        if (p.dialogContinue)
            enemyMove();
        if (p.dialogContinue)
            enemyCombatRun();
        p.inCombat = false;
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

    public boolean playerMove() {
        if (moves <= p.pace) {
            p.move();
            moves++;
        }
        return true;
    }

    public boolean enemyMove() {
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
        return true;
    }
}

package rob.nonMainGames.sideGames.TextGame;

import java.util.Random;

public class Troll implements Enemy {
    private int x, y, dx, dy;
    private Random random = new Random();
    private Player player;

    public Troll() {
        x = random.nextInt(10);
        y = random.nextInt(10);
        player = new Player();
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void move() {
        x += dx;
        y += dy;
    }

    @Override
    public void getMove() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void getEnemyTurn() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

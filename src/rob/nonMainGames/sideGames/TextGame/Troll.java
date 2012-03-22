package rob.nonMainGames.sideGames.TextGame;

import java.util.Random;

public class Troll implements Enemy {
    private int x, y, dx, dy;
    private Player player;

    public Troll() {
        Random random = new Random();
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
        if (!player.canGo) {
            x += dx;
            y += dy;
        }
    }

    @Override
    public void getMove() {
        if (!player.canGo) {
            if (player.getX() > x) {
                dx = 1;
            } else if (player.getX() < x) {
                dx = -1;
            }
            if (player.getY() > y) {
                dy = -1;
            } else if (player.getY() < y) {
                dy = 1;
            }
        }
    }

    public void getTrollTurn() {
        getMove();
        move();
    }
}

package rob.nonMainGames.sideGames.TextGame;

import java.util.Random;

public class Troll implements Enemy {
    private int x, y, dx, dy;
    private Player player;
    public boolean canGo;

    public Troll() {
        Random random = new Random();
        x = random.nextInt(9);
        y = random.nextInt(9);
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
        dx = 0;
        dy = 0;
        if (canGo) {
            System.out.println("Troll's move...");
            try {
                Thread.sleep(500, 0);
            } catch (Exception ignored) {
            }
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
            canGo = false;
        }
    }

    public void getTrollTurn() {
        getMove();//BAD THINGS
        move();
    }
}

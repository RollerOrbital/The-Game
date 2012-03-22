package rob.nonMainGames.sideGames.TextGame;

import java.util.Scanner;

public class Player {
    private Scanner input = new Scanner(System.in);
    private int x, y, dx, dy;
    public boolean canGo;

    public Player() {
        canGo = true;
        x = 0;
        y = 4;
    }

    public int getX() {
        return y;
    }

    public int getY() {
        return x;
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public void getMove() {
        if (canGo) {
            String direction = input.nextLine();
            if (direction.equals("w")) {
                dy = -1;
            } else if (direction.equals("s")) {
                dy = 1;
            } else if (direction.equals("a")) {
                dx = -1;
            } else if (direction.equals("d")) {
                dx = 1;
            }
            canGo = false;
        }
    }

    public void getPlayerTurn() {
        getMove();
        move();
    }
}

package pierce.Liberation;

import java.util.Random;

public class BadSoul {
    Random random = new Random();
    public static int x, y;
    public int dx, dy;

    public BadSoul() {
        dx = (GoodSoul.lowerOne(random.nextInt(4)) * -1) - 1;
        dy = 0;//lowerOne(random.nextInt(4));
        x = 700;
        y = (58 * 4) + 16;//random.nextInt(300) + 50;
    }

    public void move() {
        x += dx;
        y += dy;

        if (y <= 10 || y >= 350) {
            dy *= -1;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

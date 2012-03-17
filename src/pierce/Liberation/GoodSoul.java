package pierce.Liberation;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GoodSoul {
    Random random = new Random();
    public static int x, y;
    public int dx, dy;

    public GoodSoul() {
        dx = (lowerOne(random.nextInt(3))*-1)-1;
        dy = 0;//lowerOne(random.nextInt(4));
        x = 700;
        y = (58*4)+16;//random.nextInt(300) + 50;
    }

    public void move() {
        x += dx;
        y += dy;

        if (y <= 10 || y >= 350) {
            dy *= -1;
        }
    }

    public static int lowerOne(int x) {
        if (x < 1) {
            return 1;
        } else {
            return x;
        }
    }

    public static int lowerZero(int x) {
        if (x < 1) {
            return 0;
        } else {
            return x;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
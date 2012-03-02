package minigames.soulCatcherGame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GoodSoul {
    Random random = new Random();
    public static int x, y;
    public int dx, dy;
    private Image image;

    public GoodSoul() {
        dx = lowerOne(random.nextInt(4));
        dy = lowerOne(random.nextInt(4));
        x = 0;
        y = random.nextInt(300) + 50;
        ImageIcon i = new ImageIcon(this.getClass().getResource("goodSoul.png"));
        image = i.getImage();
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

    public Image getImage() {
        return image;
    }
}
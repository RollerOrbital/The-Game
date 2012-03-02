package minigames.catcherGame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BadSoul {
    Random random = new Random();
    public static int x, y;
    public int dx, dy;
    private Image image;

    public BadSoul() {
        dx = GoodSoul.lowerOne(random.nextInt(4));
        dy = GoodSoul.lowerOne(random.nextInt(4));
        x = 0;
        y = random.nextInt(300) + 50;
        ImageIcon i = new ImageIcon(this.getClass().getResource("badSoul.png"));
        image = i.getImage();
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

    public Image getImage() {
        return image;
    }
}

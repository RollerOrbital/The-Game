package rob.mazeGame;

import javax.swing.*;
import java.awt.*;

public class Scythe2 {
    public static int x, y;
    private Image image;
    int dx = 2;
    int dy = 2;

    public Scythe2() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("scythe.png"));
        image = ii.getImage();
        x = 0;
        y = 200;
    }

    public void move() {
        x += dx;
        y += dy;
        if (x <= 0 || x >= 700) {
            dx *= -1;
        } else if (y <= 0 || y >= 350) {
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

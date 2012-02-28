package rob.bombGame;

import javax.swing.*;
import java.awt.*;

public class Bomb {
    private int x, y, dx, dy;
    private Image image;

    public Bomb() {
        x = 0;
        y = 0;
        ImageIcon i = new ImageIcon(this.getClass().getResource("bomb.png"));
        image = i.getImage();
    }

    public void move() {
        x += dx;
        y += dy;
        if (x <= 0) {
            x = 0;
        } else if (x >= 725) {
            x = 725;
        } else if (y <= 0) {
            y = 0;
        } else if (y >= 425) {
            y = 425;
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

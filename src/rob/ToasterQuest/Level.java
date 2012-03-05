package rob.ToasterQuest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Level {
    private ImageIcon ii;
    private Image image;
    private int levelNumber, length, height, x, y, dx, dy;

    public Level() {
        levelNumber = 1;
        ii = new ImageIcon(getClass().getResource("level" + levelNumber));
        image = ii.getImage();
        length = 1250;
        height = 400;
        x = 0;
        y = 0;
        dx = 0;
        dy = 0;
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

    public void move() {
        x += dx;
        y += dy;
        if (y >= 380) {
            y = 380;
        } else if (y <= 0) {
            y = 0;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dy = -2;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }
    }
}

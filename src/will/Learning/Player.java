package will.Learning;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    int x, dx, y;
    Image background;

    public Player() {
        ImageIcon i = new ImageIcon("C:/player.png");
        background = i.getImage();
        x = 10;
        y = 290;
    }

    public void move() {
        if (x + 4 * dx > 0) {
            if (x + 4 * dx < 1100) {
                x = x + 4 * dx;
            } else {
                x = 1100;
            }
        } else {
            x = 0;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return background;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }
}
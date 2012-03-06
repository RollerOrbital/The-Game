package rob.ToasterQuest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Level {
    private Image image;
    private int x;
    public int y;
    private int dx;
    private int dy;

    public boolean left, up, right;

    public Level() {
        ImageIcon ii = new ImageIcon(getClass().getResource("level1.png"));
        image = ii.getImage();
        x = -1 * Player.distance;
        y = -1 * Player.altitude;
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
        if (right) {
            y -= dy;
            x -= dx;
        } else if (left) {
            y -= dy;
            x -= dx;
        } else {
            y -= dy;
        }
        if (x <= -1020) {
            x = -1019;
        } else if (x >= 199) {
            x = 198;
        } else if (y <= -325) {
            dy = 0;
            y = -326;
        }
    }

    public void moveUp() {
        y += 1;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dy = -2;
            up = true;
        } else if (key == KeyEvent.VK_LEFT) {
            dy = 2;
            dx = -2;
            left = true;
            up = false;
        } else if (key == KeyEvent.VK_RIGHT) {
            dy = 2;
            dx = 2;
            right = true;
            up = false;

        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dy = 0;
            up = false;
        } else if (key == KeyEvent.VK_LEFT) {
            dx = 0;
            left = false;
        } else if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
            right = false;
        }
    }
}

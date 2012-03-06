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
        int counter = 0;
        if (up) {
            y -= dy;
        } else if (right) {
            x -= dx;
        } else if (left) {
            x += dx;
        } else {
            if (counter % 40 == 0) {
                dy = 3;
                y -= dy;
            }
        }
        if (x <= -1020) {
            x = -1019;
        } else if (x >= 200) {
            x = 199;
        } else if (y <= -325) {
            dy = 0;
            y = -326;
        }
        counter++;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dy = -2;
            up = true;
        } else if (key == KeyEvent.VK_LEFT) {
            dx = -2;
            left = true;
        } else if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
            right = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dy = 0;
        } else if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        } else if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }
}

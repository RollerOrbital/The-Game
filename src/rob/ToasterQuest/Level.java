package rob.ToasterQuest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Level {
    private Image image;
    private int x, y, dx, dy;
    private Player player;

    public Level() {
        player = new Player();
        ImageIcon ii = new ImageIcon(getClass().getResource("level1.png"));
        image = ii.getImage();
        x = -1 * player.distance;
        y = -1 * player.height;
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
        int h = player.height;
        x -= dx;
        player.height += dy;
        player.distance += dx;
        if (x <= -1020) {
            x = -1019;
        } else if (x >= 200) {
            x = 199;
        }
        if (player.height > h + 50) {
            dy = 3;
        } else {
            y -= dy;
        }
        if (y <= -325) {
            dy = 0;
            y = -326;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dy = -2;
        } else if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        } else if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dy = 3;
        } else if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        } else if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }
}

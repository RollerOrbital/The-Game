package rob.mazeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    private String player = "craft.png";
    private int fouls;
    private int dx;
    private int dy;
    private int x;
    private int y;
    private int width;
    private int height;
    private Image image;

    public Player() {
        fouls = 0;
        ImageIcon i = new ImageIcon(this.getClass().getResource(player));
        image = i.getImage();
        x = 10;
        y = 10;
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public void move() {
        x += dx;
        y += dy;
        if (y > 350) {
            y = 350;
        } else if (y < 0) {
            y = 0;
        }
        if (x < 0) {
            x = 0;
        } else if (x > 621) {
            x = 621;
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

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
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

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
package rob.catcherGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    public static int souls;
    public static int score;
    private int dy;
    public int x;
    public int y;
    private Image image;

    public Player() {
        souls = 0;
        score = 0;
        String player = "player.png";
        ImageIcon i = new ImageIcon(this.getClass().getResource(player));
        image = i.getImage();
        x = 600;
        y = 212;
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
        y += dy;
        if (y >= 350) {
            y = 350;
        } else if (y <= 5) {
            y = 5;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dy = -2;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }
        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
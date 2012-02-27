package will.ActualGameCode.MainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Sprite {

    private String sprite = "spr_test.jpg";

    private int dx, dy, x, y;
    private Image image;

    public Sprite() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource((sprite)));
        image = ii.getImage();
        x = 40;
        y = 60;
    }

    public void move() {
        x += dx;
        y += dy;

        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }

        if (x > 570) {
            x = 570;
        }

        if (y > 250) {
            y = 250;
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
}


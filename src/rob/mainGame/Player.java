package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    private int x, y, dx, dy;
    private int direction, UP, RIGHT, LEFT, DOWN;
    private Image image;
    private int frameNumber;

    public Player() {
        x = 0;
        y = 0;
        dx = 0;
        dy = 0;
        DOWN = 0;
        LEFT = 1;
        UP = 2;
        RIGHT = 3;
        direction = DOWN;
        ImageIcon playerSheet = new ImageIcon(getClass().getResource("player.png"));
        image = playerSheet.getImage();
        frameNumber = 0;
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

    public int getWidth() {
        return 12;
    }

    public int getHeight() {
        return 18;
    }

    public int getFrame() {
        return frameNumber;
    }

    public int getDirection() {
        return direction;
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            dy = -1;
        } else if (key == KeyEvent.VK_A) {
            dx = -1;
        } else if (key == KeyEvent.VK_S) {
            dy = 1;
        } else if (key == KeyEvent.VK_D) {
            dx = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = (e.getKeyCode());
        if (key == KeyEvent.VK_W) {
            dy = 0;
        } else if (key == KeyEvent.VK_A) {
            dx = 0;
        } else if (key == KeyEvent.VK_S) {
            dy = 0;
        } else if (key == KeyEvent.VK_D) {
            dx = 0;
        }
    }
}

package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    private int x, y, dx, dy;
    private int direction, UP, RIGHT, LEFT, DOWN;
    private Image image;
    private int frameNumber;
    private int[] frameArray;
    private int isMoving, MOVING, STILL;

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
        frameArray = new int[]{0, 1, 0, 2};
        MOVING = 1;
        STILL = 0;
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
        return frameArray[frameNumber % 4] * getWidth();
    }

    public int getDirection() {
        return direction * getHeight();
    }

    public void setDirection() {
        if (dx > 0) {
            direction = RIGHT;
        } else if (dx < 0) {
            direction = LEFT;
        } else if (dy > 0) {
            direction = DOWN;
        } else if (dy < 0) {
            direction = UP;
        }
    }

    public void move() {
        setDirection();
        if (dy == 0) {
            x += dx;
        } else if (dx == 0) {
            y += dy;
        }
        if (isMoving == MOVING) {
            frameNumber = (frameNumber % 4) + 1;
        } else if (isMoving == STILL) {
            frameNumber = 0;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            dy = -1;
            direction = UP;
            isMoving = MOVING;
        } else if (key == KeyEvent.VK_A) {
            dx = -1;
            direction = LEFT;
            isMoving = MOVING;
        } else if (key == KeyEvent.VK_S) {
            dy = 1;
            direction = DOWN;
            isMoving = MOVING;
        } else if (key == KeyEvent.VK_D) {
            dx = 1;
            direction = RIGHT;
            isMoving = MOVING;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = (e.getKeyCode());
        if (key == KeyEvent.VK_W) {
            dy = 0;
            isMoving = STILL;
        } else if (key == KeyEvent.VK_A) {
            dx = 0;
            isMoving = STILL;
        } else if (key == KeyEvent.VK_S) {
            dy = 0;
            isMoving = STILL;
        } else if (key == KeyEvent.VK_D) {
            dx = 0;
            isMoving = STILL;
        }
    }
}
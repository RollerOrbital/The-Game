package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

public class Player {
    private int x, y;

    private final int UP, RIGHT, LEFT, DOWN;
    private int direction;
    private int dx, dy;
    private final int MOVING, STILL;
    private int isMoving;

    private final Image image;
    private int frameNumber;
    private final int[] frameArray;
    public boolean isMenuOpen;
    private final StartMenu startMenu;
    public String menuAction;

    public Player() {
        startMenu = new StartMenu();
        isMenuOpen = false;
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

    public void move() {
        if (isMenuOpen) {
            dx = 0;
            dy = 0;
        } else {
            x += dx;
            y += dy;
            if (isMoving == MOVING) {
                frameNumber = (frameNumber % 4) + 1;
            } else if (isMoving == STILL) {
                frameNumber = 0;
            }
        }
    }

    private void onKeyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W && !isMenuOpen) {
            dy = -1;
            direction = UP;
            isMoving = MOVING;
        } else if (key == KeyEvent.VK_A && !isMenuOpen) {
            dx = -1;
            direction = LEFT;
            isMoving = MOVING;
        } else if (key == KeyEvent.VK_S && !isMenuOpen) {
            dy = 1;
            direction = DOWN;
            isMoving = MOVING;
        } else if (key == KeyEvent.VK_D && !isMenuOpen) {
            dx = 1;
            direction = RIGHT;
            isMoving = MOVING;
        } else if (key == KeyEvent.VK_ENTER) {
            if (isMenuOpen) {
                isMenuOpen = false;
                isMoving = MOVING;
            } else {
                isMenuOpen = true;
                isMoving = STILL;
            }
        } else if (key == KeyEvent.VK_Z && isMenuOpen) {
            menuAction = startMenu.getMenuAction(startMenu.getCursorPosition());
        }
    }

    private void onKeyReleased(KeyEvent e) {
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

    public void draw(Graphics graphics, ImageObserver imageObserver) {
        graphics.drawImage(getImage(), getX(), getY(), getX() + getWidth() * 2, getY() + getHeight() * 2, getFrame(), getDirection(), getFrame() + getWidth(), getDirection() + getHeight(), imageObserver);
    }

    public KeyAdapter keyListener() {
        return new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                onKeyPressed(e);
            }

            public void keyReleased(KeyEvent e) {
                onKeyReleased(e);
            }
        };
    }
}
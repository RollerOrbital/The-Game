package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

public class Player {
    private int x, y;

    private static enum FacingDirection {
        UP(2, KeyEvent.VK_W, 0, -1),
        RIGHT(3, KeyEvent.VK_D, 1, 0),
        LEFT(1, KeyEvent.VK_A, -1, 0),
        DOWN(0, KeyEvent.VK_S, 0, 1);

        public final int frameRow;
        public final int dx;
        public final int dy;
        private final int key;

        FacingDirection(int frameRow, int key, int dx, int dy) {
            this.frameRow = frameRow;
            this.key = key;
            this.dx = dx;
            this.dy = dy;
        }

        public static FacingDirection forKey(int key) {
            FacingDirection[] values = values();
            for (FacingDirection direction : values) {
                if (direction.key == key) {
                    return direction;
                }
            }
            return null;
        }
    }

    private FacingDirection direction;
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
        direction = FacingDirection.DOWN;
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

    private int frameX() {
        return frameArray[frameNumber % 4] * getWidth();
    }

    public int frameY() {
        return direction.frameRow * getHeight();
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
        FacingDirection facingDirection = FacingDirection.forKey(key);
        if (facingDirection != null && !isMenuOpen) {
            direction = facingDirection;
            dx = facingDirection.dx;
            dy = facingDirection.dy;
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
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_A || key == KeyEvent.VK_S || key == KeyEvent.VK_D) {
            dy = 0;
            dx = 0;
            isMoving = STILL;
        }
    }

    public void draw(Graphics graphics, ImageObserver imageObserver) {
        graphics.drawImage(getImage(), getX(), getY(), getX() + getWidth() * 2, getY() + getHeight() * 2, frameX(), frameY(), frameX() + getWidth(), frameY() + getHeight(), imageObserver);
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
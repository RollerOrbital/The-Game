package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Room {
    private Image image;
    private Player player;

    private int[] spriteFrame;

    public int y, jumpHeight;
    public int x;
    private int dx;
    private int width;
    private int height;
    private int frameNumber;
    private int direction;
    private int dy;

    public boolean left;
    public boolean right;
    public boolean up;
    public boolean down;

    public int limit = 0;

    public Room() {
        player = new Player();
        ImageIcon ii = new ImageIcon(getClass().getResource("testRoom.png"));
        image = ii.getImage();
        x = -1 * player.x;
        y = -1 * player.y;
        dx = 0;
        dy = 0;

        jumpHeight = 100;

        width = 12;
        height = 18;
        spriteFrame = new int[4];
        spriteFrame[0] = 0;
        spriteFrame[1] = 1;
        spriteFrame[2] = 0;
        spriteFrame[3] = 2;
        direction = 3;
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

    public void move() {
        x += dx;
        y += dy;
        getDirection();
        basicBounds();
    }

    private void getDirection() {
        if (up) {
            direction = 2;
        } else if (down) {
            direction = 0;
        } else if (left) {
            direction = 1;
        } else if (right) {
            direction = 3;
        }
    }

    private void basicBounds() {
        if (x <= -333) {
            x = -332;
        } else if (x >= 199) {
            x = 198;
        } else if (y <= -193) {
            y = -193;
        } else if (y >= 121) {
            y = 120;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        final int limiter;
        if (key == KeyEvent.VK_UP) {
            up = true;
            limiter = y - 32;
            limit = limiter;
            dy = 1;
        } else if (key == KeyEvent.VK_LEFT) {
            left = true;
            limiter = x - 32;
            limit = limiter;
            dx = 1;
        } else if (key == KeyEvent.VK_RIGHT) {
            right = true;
            limiter = x + 32;
            limit = limiter;
            dx = -1;
        } else if (key == KeyEvent.VK_DOWN) {
            down = true;
            limiter = y + 32;
            limit = limiter;
            dy = -1;
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
        } else if (key == KeyEvent.VK_DOWN) {
            dy = 0;
            down = false;
        }
    }

    public int getPWidth() {
        return width;
    }

    public int getPHeight() {
        return height;
    }

    public int getSprFrame() {
        return (spriteFrame[frameNumber] * width);
    }

    public int getSprDir() {
        return (direction * height);
    }

    public Image getPImage() {
        return player.image;
    }
}

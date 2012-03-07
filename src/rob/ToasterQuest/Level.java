package rob.ToasterQuest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Level {
    private Image image;
    private int x;
    public int y;
    private int dx;
    public int dy;
    private int width, height;
    private int[] spriteFrame;
    public int frameNumber;
    public int direction;
    private Player player;

    public boolean left, up, right;

    public Level() {
        player = new Player();
        ImageIcon ii = new ImageIcon(getClass().getResource("level1.png"));
        image = ii.getImage();
        x = -1 * Player.distance;
        y = -1 * Player.altitude;
        dx = 0;
        dy = 0;

        width = 12;
        height = 18;
        spriteFrame = new int[4];
        spriteFrame[0] = 0;
        spriteFrame[1] = 1;
        spriteFrame[2] = 0;
        spriteFrame[3] = 2;
        direction = 0;
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
        if (right) {
            y -= dy;
            x -= dx;
        } else if (left) {
            y -= dy;
            x -= dx;
        } else {
            y -= dy;
        }
        if (x <= -1020) {
            x = -1019;
        } else if (x >= 199) {
            x = 198;
        } else if (y <= -325) {
            dy = 0;
            y = -326;
        }
    }

    public void moveUp() {
        y += 1;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dy = -2;
            up = true;
            frameNumber = 1;
        } else if (key == KeyEvent.VK_LEFT) {
            dy = 2;
            dx = -2;
            left = true;
            up = false;
            direction = 1;
            frameNumber = 0;
        } else if (key == KeyEvent.VK_RIGHT) {
            dy = 2;
            dx = 2;
            right = true;
            up = false;
            direction = 3;
            frameNumber = 0;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dy = 3;
            up = false;
        } else if (key == KeyEvent.VK_LEFT) {
            dx = 0;
            left = false;
        } else if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
            right = false;
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

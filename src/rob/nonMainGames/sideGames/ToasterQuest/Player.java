package rob.nonMainGames.sideGames.ToasterQuest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

public class Player {
    private final Image image;

    public int x, y, dx, dy;
    private int frameNumber, direction;
    public int jumpHeight;

    private int state, MOVING, RISING, STILL, FALLING;

    public boolean up, upHeld, canJump, canGoDown;
    private boolean left, right;

    public Player() {
        x = 0;
        y = 0;
        dx = 0;
        dy = 0;
        canGoDown = true;
        jumpHeight = 80;
        upHeld = false;
        canJump = true;
        direction = 3;
        frameNumber = 0;
        MOVING = 0;
        RISING = 1;
        STILL = 2;
        FALLING = 3;
        state = STILL;
        ImageIcon ii = new ImageIcon(getClass().getResource("player.png"));
        image = ii.getImage();
    }

    public int getWidth() {
        return 12;
    }

    public int getHeight() {
        return 18;
    }

    public int getFrameNumber() {
        return frameNumber % 3 * getWidth();
    }

    public int getDirection() {
        return direction * getHeight();
    }

    private Image getImage() {
        return image;
    }

    public void draw(Graphics g, ImageObserver imageObserver) {
        g.drawImage(getImage(), 200, 150, 200 + getWidth() * 2, 150 + getHeight() * 2, getFrameNumber(), getDirection(), getFrameNumber() + getWidth(), getDirection() + getHeight(), imageObserver);
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
        } else if (key == KeyEvent.VK_LEFT) {
        } else if (key == KeyEvent.VK_RIGHT) {
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
        } else if (key == KeyEvent.VK_LEFT) {
        } else if (key == KeyEvent.VK_RIGHT) {
        }
    }
}

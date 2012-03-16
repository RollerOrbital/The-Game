package rob.mainGame.Screen;

import rob.mainGame.Chars.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Room {
    private Image image;
    private Player player;
    private int[] spriteFrame;
    public int y, x, dy, dx, width, height, frameNumber, direction;
    public int stopl, stopr, stopu, stopd;
    public boolean left, right, up, down, isMoving;

    public Room() {
        player = new Player();
        ImageIcon ii = new ImageIcon(getClass().getResource("testRoom.png"));
        image = ii.getImage();
        x = -1 * player.x;
        y = -1 * player.y;
        dx = 0;
        dy = 0;
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

    public int getFrameNumber(int frameNumber) {
        if (frameNumber == 0) {
            frameNumber = 1;
        } else if (frameNumber > 0) {
            frameNumber++;
        } else if (frameNumber == 3) {
            frameNumber = 0;
        }
        return frameNumber;
    }

    public void move() {
        getDirection();
        frameNumber = 0;
        if (x < stopl && direction == 1) {
            x += dx;
            getFrame();
        } else if (x > stopr && direction == 3) {
            x += dx;
            getFrame();
        } else if (y < stopu && direction == 2) {
            y += dy;
            getFrame();
        } else if (y > stopd && direction == 0) {
            y += dy;
            getFrame();
            if (frameNumber > 4) {
                frameNumber = 0;
            }
            basicBounds();
        }
    }

    private void getFrame() {
        if (isMoving) {
            frameNumber = getFrameNumber(frameNumber);
        }
        isMoving = false;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        final int stopLeft = x + 32;
        final int stopUp = y + 32;
        final int stopRight = x - 32;
        final int stopDown = y - 32;
        stopl = stopLeft;
        stopu = stopUp;
        stopd = stopDown;
        stopr = stopRight;
        if (key == KeyEvent.VK_UP) {
            dy = 1;
            isMoving = true;
            up = true;
            left = false;
            right = false;
            down = false;
        } else if (key == KeyEvent.VK_LEFT) {
            dx = 1;
            isMoving = true;
            left = true;
            up = false;
            right = false;
            down = false;
        } else if (key == KeyEvent.VK_RIGHT) {
            dx = -1;
            isMoving = true;
            right = true;
            left = false;
            up = false;
            down = false;
        } else if (key == KeyEvent.VK_DOWN) {
            dy = -1;
            isMoving = true;
            down = true;
            left = false;
            right = false;
            up = false;
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
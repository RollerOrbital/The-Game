package rob.ToasterQuest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Level {
    private Image image;
    private Player player;

    private int[] spriteFrame;

    public int y, jumpHeight;
    private int x, dx, width, height, frameNumber, direction, dy;

    public boolean up, canJump;
    private boolean isMoving, isRising, upHeld, left, right;

    public Level() {
        player = new Player();
        ImageIcon ii = new ImageIcon(getClass().getResource("level1.png"));
        image = ii.getImage();
        x = -1 * Player.distance;
        y = -1 * Player.altitude;
        dx = 0;
        dy = 0;

        jumpHeight = 100;
        upHeld = false;
        canJump = true;

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
        if (!up) {
            dy = 3;
        }
        if (frameNumber == 3) {
            frameNumber = 0;
        }
        if (right) {
            y -= dy;
            x -= dx;
        } else if (left) {
            y -= dy;
            x -= dx;
        } else {
            y -= dy;
        }

        basicBounds();

        if (upHeld) {
            dy = 0;
        }
        if (isMoving) {
            frameNumber++;
        }
        if (isRising) {
            frameNumber = 1;
        }
        if (!isMoving) {
            frameNumber = 0;
        }
    }

    private void basicBounds() {
        if (x <= -4000) {
            x = -4019;
        } else if (x >= 199) {
            x = 198;
        } else if (y <= -500) {
            dy = 0;
            y = -500;
            isRising = false;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            if (up) {
                up = false;
                upHeld = true;
            } else {
                if (canJump) {
                    jumpHeight = y + 100;
                    dy = -2;
                    up = true;
                    isRising = true;
                } else {
                    y++;
                }
            }
        } else if (key == KeyEvent.VK_LEFT) {
            dx--;
            left = true;
            direction = 1;
            isMoving = true;
        } else if (key == KeyEvent.VK_RIGHT) {
            dx++;
            right = true;
            direction = 3;
            isMoving = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dy = 3;
        } else if (key == KeyEvent.VK_LEFT) {
            dx = 0;
            left = false;
            isMoving = false;
        } else if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
            right = false;
            isMoving = false;
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

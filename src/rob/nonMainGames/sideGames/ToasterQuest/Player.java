package rob.nonMainGames.sideGames.ToasterQuest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

public class Player {
    private final Image image;

    private int x, y, dx, dy;
    private int frameNumber, direction, LEFT, RIGHT;

    public int state, MOVING, STILL, JUMPING, FALLING, stepCount, stepSpeed;
    private int jumpSpeed, gravityStrength;
    public int keyHeld, UP, NONE, jumpHeight, maxJump;

    public Player() {
        x = -195;
        y = 405;
        dx = 0;
        dy = 0;
        jumpHeight = 100;
        UP = 1;
        NONE = 0;
        keyHeld = NONE;
        jumpSpeed = -1;
        gravityStrength = 1;
        stepSpeed = 60;
        stepCount = 0;
        RIGHT = 3;
        LEFT = 1;
        direction = RIGHT;
        frameNumber = 0;
        MOVING = 0;
        STILL = 1;
        JUMPING = 2;
        FALLING = 3;
        state = STILL;
        ImageIcon ii = new ImageIcon(getClass().getResource("player.png"));
        image = ii.getImage();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return 12;
    }

    public int getHeight() {
        return 18;
    }

    public int getFrameNumber() {
        getFrame();
        return frameNumber % 3 * getWidth();
    }

    private void getFrame() {
        if (state == MOVING) {
            stepCount++;
            if (stepCount % stepSpeed < stepSpeed / 4) {
                frameNumber = 0;
            } else if (stepCount % stepSpeed >= stepSpeed / 4 && stepCount % stepSpeed < stepSpeed / 2) {
                frameNumber = 1;
            } else if (stepCount % stepSpeed >= stepSpeed / 2 && stepCount % stepSpeed < (stepSpeed * 3) / 4) {
                frameNumber = 0;
            } else if (stepCount % stepSpeed >= (stepSpeed * 3) / 4 && stepCount % stepSpeed <= stepSpeed) {
                frameNumber = 2;
            }
        } else if (state == STILL) {
            frameNumber = 0;
        } else if (state == JUMPING || state == FALLING) {
            frameNumber = 1;
        }
    }

    private void getJump() {
        if (x < maxJump) {
            dy = gravityStrength;
            state = FALLING;
        }
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
            if (keyHeld != UP) {
                maxJump = x - jumpHeight;
                state = JUMPING;
            }
            state = JUMPING;
            dy = jumpSpeed;
            keyHeld = UP;
            getJump();
        } else if (key == KeyEvent.VK_LEFT) {
            if (keyHeld == NONE) {
                direction = LEFT;
                dx = -1;
                state = MOVING;
            }
        } else if (key == KeyEvent.VK_RIGHT) {
            if (keyHeld == NONE) {
                direction = RIGHT;
                dx = 1;
                state = MOVING;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            keyHeld = NONE;
            if (state == JUMPING) {
                state = FALLING;
                dy = gravityStrength;
            }
        } else if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            if (state != JUMPING || state != FALLING) {
                dx = 0;
                state = STILL;
            }
        }
    }
}

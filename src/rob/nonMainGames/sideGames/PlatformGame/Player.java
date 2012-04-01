package rob.nonMainGames.sideGames.PlatformGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

public class Player {
    private int x, y, dx, dy;
    private int state, MOVING, STILL, JUMPING, stepCount;
    private int direction, frameNumber, RIGHT, LEFT;

    private final Image image;

    private int gravityStrength;
    private int jumpSpeed;

    public Player() {
        //direction constants
        RIGHT = 3;
        LEFT = 1;
        //variables
        frameNumber = 0;
        direction = RIGHT;
        jumpSpeed = 1;
        gravityStrength = 1;
        //state variables
        STILL = 0;
        MOVING = 1;
        JUMPING = 2;
        state = STILL;
        //positional variables
        x = 0;
        y = 220;
        dx = 0;
        dy = 0;
        //image constant
        ImageIcon ii = new ImageIcon(getClass().getResource("player.png"));
        image = ii.getImage();
    }

    //all of the getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private Image getImage() {
        return image;
    }

    private int getDirection() {
        return direction * getHeight();
    }

    private int getFrameNumber() {
        if (state == MOVING) {
            stepCount++;
            int stepSpeed = 60;
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
        } else if (state == JUMPING) {
            frameNumber = 1;
        }
        return frameNumber * getWidth();
    }


    private int getWidth() {
        return 12;
    }

    private int getHeight() {
        return 18;
    }

    //gets the global boundaries of the map
    private void getBounds() {
        if (x < 0) {
            x = 0;
        }
        if (x > 375) {
            x = 375;
        }
        if (y >= 260) {
            y = 260;
        }
    }

    public void draw(Graphics g, ImageObserver imageObserver) {
        g.drawImage(getImage(), getX(), getY(), getX() + getWidth() * 2, getY() + getHeight() * 2, getFrameNumber(), getDirection(), getFrameNumber() + getWidth(), getDirection() + getHeight(), imageObserver);

    }

    public void move() {
        x += dx;
        y += dy;
        getBounds();
    }

    //keyPressed and keyReleased methods
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
            direction = LEFT;
            state = MOVING;
        } else if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
            direction = RIGHT;
            state = MOVING;
        } else if (key == KeyEvent.VK_UP) {
            dy = -jumpSpeed;
            state = JUMPING;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
            state = STILL;
        } else if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
            state = STILL;
        } else if (key == KeyEvent.VK_UP) {
            dy = gravityStrength;
        }
    }
}

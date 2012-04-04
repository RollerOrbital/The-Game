package rob.nonMainGames.sideGames.ToasterQuest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

public class Player {

    private static enum currentState {
        //These are all currentState type objects (I think)
        LEFT(-1, 0, 1, 0, KeyEvent.VK_LEFT),
        RIGHT(1, 0, 3, 0, KeyEvent.VK_RIGHT),
        STILL(0, 0, 0, 0, 0),
        JUMPING(0, -1, 0, 1, KeyEvent.VK_UP),      //jumpSpeed = 1
        FALLING(0, 1, 0, 1, 0);      //gravityStrength = 1

        public final int key;
        public final int frameNumber;
        public final int direction;
        public final int dx;
        public final int dy;

        //currentState object constructor
        currentState(int dx, int dy, int direction, int frameNumber, int key) {
            this.frameNumber = frameNumber;
            this.direction = direction;
            this.key = key;
            this.dx = dx;
            this.dy = dy;
        }
    }

    //position
    private int x, y, dx, dy;
    //vertical
    private boolean canJump;
    private int newMaxHeight;
    //horizontal
    private int stepSpeed, stepCount;
    //frameNumber
    private int frameNumber;
    //direction
    private int direction;
    //state
    private currentState state;
    //image
    private final Image image;

    public Player() {
        //position
        x = -195;
        y = 405;
        dx = 0;
        dy = 0;
        //vertical
        canJump = true;
        newMaxHeight = 600;
        //horizontal
        stepSpeed = 100;
        stepCount = 0;
        //direction
        direction = currentState.RIGHT.direction;
        //frameNumber
        frameNumber = 0;
        //offGround
        state = currentState.STILL;
        //image
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
        if (!canJump) {
            frameNumber = 1;
        } else {
            getFrame();
        }
        return frameNumber % 3 * getWidth();
    }

    private void getFrame() {
        if (state == currentState.STILL) {
            frameNumber = currentState.STILL.frameNumber;
        } else if (state == currentState.JUMPING || state == currentState.FALLING) {
            frameNumber = 1;
        } else {
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
        }
    }

    public int getDirection() {
        return direction * getHeight();
    }

    private Image getImage() {
        return image;
    }

    private void getFloor() {
        if (y >= 405) {
            y = 405;
            canJump = true;
        }
    }

    private void getRoof() {
        if (y <= newMaxHeight) {
            state = currentState.FALLING;
            dy = currentState.FALLING.dy;
            canJump = false;
        }
    }

    public void draw(Graphics g, ImageObserver imageObserver) {
        g.drawImage(getImage(), 200, 150, 200 + getWidth() * 2, 150 + getHeight() * 2, getFrameNumber(), getDirection(), getFrameNumber() + getWidth(), getDirection() + getHeight(), imageObserver);
    }

    public void move() {
        getRoof();
        getFloor();
        x += dx;
        y += dy;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP && canJump) {
            newMaxHeight = y - 70;
            canJump = false;
            state = currentState.JUMPING;
            canJump = false;
            dy = currentState.JUMPING.dy;
            frameNumber = currentState.JUMPING.frameNumber;
        } else if (key == KeyEvent.VK_LEFT) {
            state = currentState.LEFT;
            dx = currentState.LEFT.dx;
            direction = currentState.LEFT.direction;
        } else if (key == KeyEvent.VK_RIGHT) {
            state = currentState.RIGHT;
            dx = currentState.RIGHT.dx;
            direction = currentState.RIGHT.direction;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            state = currentState.FALLING;
            dy = currentState.FALLING.dy;
        } else if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            if (canJump) {
                state = currentState.STILL;
            }
            dx = currentState.STILL.dx;
        }
    }
}

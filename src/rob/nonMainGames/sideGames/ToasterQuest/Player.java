package rob.nonMainGames.sideGames.ToasterQuest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

public class Player {

    //My rather poor attempt at using enums...
    private static enum currentState {
        //These are all 'currentState' type objects (I think)
        LEFT(0, -1, 0),
        RIGHT(0, 1, 0),
        STILL(1, 0, 0),
        JUMPING(2, 0, -1),
        FALLING(3, 0, 1);

        public final int stateNumber;
        public final int dx;
        public final int dy;

        //Current state object constructor
        currentState(int stateNumber, int dx, int dy) {
            this.stateNumber = stateNumber;
            this.dx = dx;
            this.dy = dy;
        }

        //This determines the values of each of the things from knowing which state the player is in
        public static currentState forState(int state) {
            currentState[] values = values();
            for (currentState c : values) {
                if (c.stateNumber == state) {
                    return c;
                }
            }
            return null;
        }
    }

    //position
    private int x, y, dx, dy;
    //vertical
    public int jumpSpeed, gravityStrength;
    //horizontal
    public int stepSpeed, stepCount;
    //direction
    public int direction, LEFT, RIGHT;
    //frameNumber
    private int frameNumber;
    //stateNumber
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
        jumpSpeed = -1;
        gravityStrength = 1;
        //horizontal
        stepSpeed = 60;
        stepCount = 0;
        //direction
        LEFT = 1;
        RIGHT = 3;
        direction = RIGHT;
        //frameNumber
        frameNumber = 0;
        //stateNumber
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
        getFrame();
        return frameNumber % 3 * getWidth();
    }

    private void getFrame() {
        if (state == currentState.LEFT || state == currentState.RIGHT) {
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
        } else if (state == currentState.STILL) {
            frameNumber = 0;
        } else if (state == currentState.JUMPING || state == currentState.FALLING) {
            frameNumber = 1;
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
            state = currentState.JUMPING;
            dy = currentState.JUMPING.dy;
        } else if (key == KeyEvent.VK_LEFT) {
            direction = LEFT;
            state = currentState.LEFT;
            dx = currentState.LEFT.dx;
        } else if (key == KeyEvent.VK_RIGHT) {
            direction = RIGHT;
            state = currentState.RIGHT;
            dx = currentState.RIGHT.dx;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            state = currentState.FALLING;
            dy = currentState.FALLING.dy;
        } else if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            state = currentState.STILL;
            dx = currentState.STILL.dx;
        }
    }
}

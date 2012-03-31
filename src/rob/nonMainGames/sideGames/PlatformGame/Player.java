package rob.nonMainGames.sideGames.PlatformGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    private int x, y, dx, dy;
    private int stateOfBeing, MOVING, STILL, JUMPING, FALLING;

    private Image image;

    private int gravityStrength;
    private int jumpSpeed;

    public Player() {
        MOVING = 0;
        STILL = 1;
        JUMPING = 2;
        FALLING = 3;
        stateOfBeing = STILL;
        jumpSpeed = 1;
        gravityStrength = 2;
        x = 0;
        y = 0;
        dx = 0;
        dy = 0;
        ImageIcon ii = new ImageIcon(getClass().getResource("player.png"));
        image = ii.getImage();
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

    public int getState() {
        return stateOfBeing;
    }

    public void getGravitation() {
        if (dy == 0) {
            dy = gravityStrength;
            stateOfBeing = FALLING;
        }
    }

    private void getBounds() {
        if (x < 0) {
            x = 0;
            stateOfBeing = STILL;
        }
        if (x > 330) {
            x = 330;
            stateOfBeing = STILL;
        }
        if (y > 195) {
            y = 195;
            stateOfBeing = STILL;
        }
    }

    public void move() {
        getGravitation();
        x += dx;
        y += dy;
        getBounds();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
            stateOfBeing = MOVING;
        } else if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
            stateOfBeing = MOVING;
        } else if (key == KeyEvent.VK_UP) {
            dy = -jumpSpeed;
            stateOfBeing = JUMPING;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
            stateOfBeing = STILL;
        } else if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
            stateOfBeing = STILL;
        } else if (key == KeyEvent.VK_UP) {
            dy = 0;
            stateOfBeing = FALLING;
        }
    }
}

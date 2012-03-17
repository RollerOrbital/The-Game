package rob.SealOffGame;

import javax.swing.*;
import java.awt.*;

public class Enemy {
    static int x;
    public int health, baseDamage, defense, direction;
    public boolean isHitting, isBlocking;
    private Player player;
    private ImageIcon leftStand, leftBlock, leftPunch;

    public Enemy() {
        health = 200;
        baseDamage = 0;
        defense = 0;
        isHitting = false;
        x = 300;
        leftStand = new ImageIcon(getClass().getResource("leftStand.png"));
        leftPunch = new ImageIcon(getClass().getResource("leftPunch.png"));
        leftBlock = new ImageIcon(getClass().getResource("leftblock.png"));
        player = new Player();
        direction = 1;
    }

    public int getX() {
        return x;
    }

    public Image getImage() {
        Image returnThing;
        if (direction == 1) {
            if (isHitting && !isBlocking) {
                returnThing = leftPunch.getImage();
            } else if (isBlocking && !isHitting) {
                returnThing = leftBlock.getImage();
            } else {
                returnThing = leftStand.getImage();
            }
        } else if (direction == 3) {
            if (isHitting && !isBlocking) {
                returnThing = leftPunch.getImage();
            } else if (isBlocking && !isHitting) {
                returnThing = leftBlock.getImage();
            } else {
                returnThing = leftStand.getImage();
            }
        } else {
            returnThing = leftStand.getImage();
        }
        return returnThing;
    }

    public void move() {
        int dx;
        if (x < player.x) {
            dx = -1;
        } else {
            dx = 1;
        }
        x += dx;
        basicBounds();
    }


    private void basicBounds() {
        if (x <= 0) {
            x = 0;
        } else if (x >= 400) {
            x = 400;
        }
    }
}

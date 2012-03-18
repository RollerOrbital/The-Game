package rob.SealOffGame;

import javax.swing.*;
import java.awt.*;

public class Enemy {
    public int x;
    private int dx;
    private int rage;
    public int health, baseDamage, defense, direction;
    public boolean isHitting, isBlocking;
    private ImageIcon leftStand, leftBlock, leftPunch;
    private ImageIcon rightStand, rightBlock, rightPunch;
    private int LEFT, RIGHT;

    public Enemy() {
        x = 400 - 45;
        LEFT = 1;
        RIGHT = 3;
        health = 200;
        rage = 0;
        baseDamage = 5;
        defense = 0;
        isHitting = false;
        isBlocking = false;
        //imageIcons START
        leftStand = new ImageIcon(getClass().getResource("leftStand.png"));
        leftPunch = new ImageIcon(getClass().getResource("leftPunch.png"));
        leftBlock = new ImageIcon(getClass().getResource("leftBlock.png"));
        rightStand = new ImageIcon(getClass().getResource("rightStand.png"));
        rightPunch = new ImageIcon(getClass().getResource("rightPunch.png"));
        rightBlock = new ImageIcon(getClass().getResource("rightBlock.png"));
        //imageIcons END
        direction = 1;
        //left = 1, right = 3;
    }

    public int getX() {
        return x;
    }

    public Image getImage() {
        Image returnThing;
        if (direction == LEFT) {
            if (isHitting && !isBlocking) {
                returnThing = leftPunch.getImage();
                rage += 5;
                isHitting = false;
                getDamage();
            } else if (isBlocking && !isHitting) {
                returnThing = leftBlock.getImage();
                rage -= 3;
                isBlocking = false;
            } else {
                returnThing = leftStand.getImage();
            }
        } else if (direction == RIGHT) {
            if (isHitting && !isBlocking) {
                returnThing = rightPunch.getImage();
                rage += 5;
                isHitting = false;
                getDamage();
            } else if (isBlocking && !isHitting) {
                returnThing = rightBlock.getImage();
                rage -= 3;
                isBlocking = false;
            } else {
                returnThing = rightStand.getImage();
            }
        } else {
            returnThing = rightStand.getImage();
        }
        return returnThing;
    }

    private void getDamage() {
        if (rage >= 100) {
            baseDamage += 10;
            rage = 0;
        }
        if (Player.isBlocking) {
            baseDamage = 2;
        }
        Player.health -= baseDamage;
        baseDamage = 5;
    }

    public void move() {
        decideMove();
        x += dx;
        basicBounds();
    }


    private void basicBounds() {
        if (x <= -Player.width) {
            x = -Player.width;
        } else if (x >= 551) {
            x = 551;
        }
    }

    public void decideMove() {
        if (x + Player.width <= Player.x) {
            dx = 1;
            direction = RIGHT;
            isHitting = false;
            isBlocking = false;
        } else if (x >= Player.x + Player.width) {
            dx = -1;
            direction = LEFT;
            isHitting = false;
            isBlocking = false;
        } else {
            dx = 0;
            decideStrike();
        }
    }

    public void decideStrike() {
        if (Player.isHitting) {
            isBlocking = true;
        } else {
            isHitting = true;
        }
    }
}
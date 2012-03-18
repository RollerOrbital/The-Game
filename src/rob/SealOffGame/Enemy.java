package rob.SealOffGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Enemy {
    public int x;
    private int dx;
    private int rage;
    private int health;
    private int baseDamage;
    private int defense;
    private int direction;
    private boolean isHitting;
    public boolean isBlocking;
    private ImageIcon leftStand, leftBlock, leftPunch;
    private ImageIcon rightStand, rightBlock, rightPunch;
    private int width;

    public Enemy() {
        width = 45;
        health = 200;
        rage = 0;
        baseDamage = 0;
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
        if (direction == 1) {
            if (isHitting && !isBlocking) {
                returnThing = leftPunch.getImage();
                getDamage();
            } else if (isBlocking && !isHitting) {
                returnThing = leftBlock.getImage();
            } else {
                returnThing = leftStand.getImage();
            }
        } else if (direction == 3) {
            if (isHitting && !isBlocking) {
                returnThing = rightPunch.getImage();
                getDamage();
            } else if (isBlocking && !isHitting) {
                returnThing = rightBlock.getImage();
            } else {
                returnThing = rightStand.getImage();
            }
        } else {
            returnThing = rightStand.getImage();
        }
        return returnThing;
    }

    private void getDamage() {
        if (isNextToEnemy()) {
            baseDamage = 5;
            if (rage >= 100) {
                baseDamage += 10;
            }
            health -= baseDamage;
            baseDamage = 0;
        }
    }

    public void move() {
        x += dx;
        if (dx < 0) {
            direction = 1;
        } else if (dx > 0) {
            direction = 3;
        }
        basicBounds();
        enemyBounds();
    }


    private void basicBounds() {
        if (x <= -width) {
            x = -width;
        } else if (x >= 551) {
            x = 551;
        }
    }

    private void enemyBounds() {
        if (Player.x + width > x && Player.x < x) {
            Player.x = x - width;
        } else if (Player.x < x + width && Player.x > x) {
            Player.x = x + width;
        }
    }

    private boolean isNextToEnemy() {
        return (((Player.x + width > x && Player.x < x) || (Player.x < x + width && Player.x > x)));
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_D && !isHitting && !isBlocking) {
            dx = 1;
        } else if (key == KeyEvent.VK_A && !isHitting && !isBlocking) {
            dx = -1;
        } else if (key == KeyEvent.VK_Z) {
            rage += 5;
            baseDamage = 5;
            isHitting = true;
        } else if (key == KeyEvent.VK_X) {
            rage -= 3;
            defense = 5;
            isBlocking = true;
        } else if (key == KeyEvent.VK_ENTER) {
            if (rage == 100) {
                rage = 0;
                baseDamage = 20;
                isHitting = true;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_D) {
            dx = 0;
        } else if (key == KeyEvent.VK_A) {
            dx = 0;
        } else if (key == KeyEvent.VK_Z) {
            baseDamage = 0;
            isHitting = false;
        } else if (key == KeyEvent.VK_X) {
            defense = 0;
            isBlocking = false;
        } else if (key == KeyEvent.VK_ENTER) {
            baseDamage = 0;
            isHitting = false;
        }
    }
}
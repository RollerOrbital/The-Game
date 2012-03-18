package rob.SealOffGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    private Enemy enemy;
    public static int x;
    private int dx;
    private int rage;
    public static int health;
    public int baseDamage;
    public int defense;
    static int direction;
    public static boolean isHitting;
    public boolean isBlocking;
    private ImageIcon leftStand, leftBlock, leftPunch;
    private ImageIcon rightStand, rightBlock, rightPunch;
    static int width;

    public Player() {
        width = 45;
        enemy = new Enemy();
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
            } else if (isBlocking && !isHitting) {
                returnThing = leftBlock.getImage();
            } else {
                returnThing = leftStand.getImage();
            }
        } else if (direction == 3) {
            if (isHitting && !isBlocking) {
                returnThing = rightPunch.getImage();
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
        if (x <= 0) {
            x = 0;
        } else if (x >= 551) {
            x = 551;
        }
    }

    private void enemyBounds() {
        if (x + width > enemy.x && x < enemy.x) {
            x = enemy.x - width;
        } else if (x < enemy.x + width && x > enemy.x) {
            x = enemy.x + width;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT && !isHitting && !isBlocking) {
            dx = 3;
        } else if (key == KeyEvent.VK_LEFT && !isHitting && !isBlocking) {
            dx = -3;
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
        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        } else if (key == KeyEvent.VK_LEFT) {
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

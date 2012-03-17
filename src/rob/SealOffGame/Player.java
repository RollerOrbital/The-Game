package rob.SealOffGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    public int x;
    private int dx;
    private int rage;
    public int health, baseDamage, defense, direction;
    public boolean isHitting;
    private Image image;
    private Image powImage;
    private ImageIcon left, right;

    public Player() {
        health = 200;
        rage = 0;
        baseDamage = 0;
        defense = 0;
        isHitting = false;
        left = new ImageIcon(getClass().getResource("sealLeft.png"));
        right = new ImageIcon(getClass().getResource("sealRight.png"));
        ImageIcon pow = new ImageIcon(getClass().getResource("powImage.png"));
        powImage = pow.getImage();
        direction = 1;
        //left = 1, right = 3;
    }

    public int getX() {
        return x;
    }

    public Image getImage() {
        Image returnThing;
        if (direction == 1) {
            returnThing = image = left.getImage();
        } else {
            returnThing = image = right.getImage();
        }
        return returnThing;
    }

    public Image getPowImage() {
        return powImage;
    }

    public void move() {
        x += dx;
        if (dx < 0) {
            direction = 1;
        } else if (dx > 0) {
            direction = 3;
        }
        basicBounds();
    }


    private void basicBounds() {
        if (x <= 0) {
            x = 0;
        } else if (x >= 400) {
            x = 400;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT && !isHitting) {
            dx = 3;
        } else if (key == KeyEvent.VK_LEFT && !isHitting) {
            dx = -3;
        } else if (key == KeyEvent.VK_Z) {
            rage += 5;
            baseDamage = 5;
            isHitting = true;
        } else if (key == KeyEvent.VK_X) {
            rage -= 3;
            defense = 5;
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
        } else if (key == KeyEvent.VK_ENTER) {
            baseDamage = 0;
            isHitting = false;
        }
    }
}

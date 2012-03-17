package rob.SealOffGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    //z = hit, x = block, enter = special???
    public int x, y, dx, dy, health, rage, baseDamage, defense;
    public boolean isHitting;
    private Image image;
    private Image powImage;

    public Player() {
        x = 0;
        y = 250;
        dx = 0;
        health = 200;
        rage = 0;
        baseDamage = 0;
        defense = 0;
        isHitting = false;
        ImageIcon ii = new ImageIcon(getClass().getResource("player.png"));
        ImageIcon aa = new ImageIcon(getClass().getResource("pow.png"));
        image = ii.getImage();
        powImage = aa.getImage();
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

    public Image getPowImage() {
        return powImage;
    }

    public void move() {
        x += dx;
        basicBounds();
    }

    private void basicBounds() {
        if (x <= -333) {
            x = -332;
        } else if (x >= 199) {
            x = 198;
        } else if (y <= -193) {
            y = -193;
        } else if (y >= 121) {
            y = 120;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        } else if (key == KeyEvent.VK_LEFT) {
            dx = -1;
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

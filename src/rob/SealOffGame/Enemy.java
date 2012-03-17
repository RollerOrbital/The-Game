package rob.SealOffGame;

import javax.swing.*;
import java.awt.*;

public class Enemy {
    static int x;
    private int dx;
    public int health, baseDamage, defense, direction;
    public boolean isHitting;
    private Image image;
    private Image powImage;
    private Player player;
    private ImageIcon left, right;

    public Enemy() {
        health = 200;
        baseDamage = 0;
        defense = 0;
        isHitting = false;
        x = 300;
        left = new ImageIcon(getClass().getResource("sealLeft.png"));
        right = new ImageIcon(getClass().getResource("sealRight.png"));
        ImageIcon pow = new ImageIcon(getClass().getResource("powImage.png"));
        powImage = pow.getImage();
        player = new Player();
        direction = 1;
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

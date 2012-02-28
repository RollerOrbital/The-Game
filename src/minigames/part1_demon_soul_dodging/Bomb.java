package minigames.part1_demon_soul_dodging;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Bomb {
    Random random = new Random();
    public int x, y;
    public int dx;
    private Image image;

    public Bomb() {
        dx = 2;
        x = 0;
        y = random.nextInt(300) + 50;
        ImageIcon i = new ImageIcon(this.getClass().getResource("bomb.png"));
        image = i.getImage();
    }

    public void move() {
        x += dx;
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
}
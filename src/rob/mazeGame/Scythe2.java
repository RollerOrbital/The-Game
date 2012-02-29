package rob.mazeGame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Scythe2 {
    Random random = new Random();
    public static int x, y;
    private Image image;
    int dx = 1;
    int dy = 3;

    public Scythe2() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("scythe.png"));
        image = ii.getImage();
        edgeChoice();
    }

    public void move() {
        x += dx;
        y += dy;
        if (x <= 0 || x >= 700) {
            dx *= -1;
        } else if (y <= 0 || y >= 350) {
            dy *= -1;
        }
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

    private void edgeChoice() {
        int x = random.nextInt(700);
        int y = random.nextInt(360);

        if (y != 0 && x != 0) {
            int choice = random.nextInt(2);
            if (choice == 0) {
                y = 0;
            } else {
                x = 0;
            }
        }
    }
}

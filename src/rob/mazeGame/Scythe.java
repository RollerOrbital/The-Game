package rob.mazeGame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Scythe {
    Random random = new Random();
    public static int x, y;
    private Image image;

    public Scythe() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("scythe.png"));
        image = ii.getImage();
        int dx = random.nextInt(5) + 1;
        int dy = random.nextInt(5) + 1;
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

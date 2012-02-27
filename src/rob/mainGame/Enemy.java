package rob.mainGame;

import javax.swing.*;
import java.awt.*;

public class Enemy {
    private int x;
    private int y;
    private Image image;

    public Enemy() {
        String enemy = "enemy.png";
        ImageIcon i = new ImageIcon(this.getClass().getResource(enemy));
        image = i.getImage();
        x = 540;
        y = 290;
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

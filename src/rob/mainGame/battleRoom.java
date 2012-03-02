package rob.mainGame;

import javax.swing.*;
import java.awt.*;

public class battleRoom {
    private Image image;
    public static int x, y;
    public int width, height;

    public battleRoom() {
        ImageIcon i = new ImageIcon(this.getClass().getResource("battleRoom.png"));
        image = i.getImage();
        x = 0;
        y = 0;
        width = 320;
        height = 200;
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

package rob.mainGame;

import javax.swing.*;
import java.awt.*;

public class TestRoom {
    private Image image;
    public static int x, y;

    public TestRoom() {
        ImageIcon i = new ImageIcon(this.getClass().getResource("testRoom.png"));
        image = i.getImage();
        x = 0;
        y = 0;
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

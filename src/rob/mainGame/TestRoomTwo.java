package rob.mainGame;

import javax.swing.*;
import java.awt.*;

public class TestRoomTwo {
    private Image image;
    public static int x, y;

    public TestRoomTwo() {
        ImageIcon i = new ImageIcon(this.getClass().getResource("testRoomTwo.png"));
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

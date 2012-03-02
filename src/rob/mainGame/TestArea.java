package rob.mainGame;

import javax.swing.*;
import java.awt.*;

public class TestArea {

    private int x;
    private int y;
    private Image image;
    public int width, height;

    public TestArea() {
        ImageIcon i = new ImageIcon(this.getClass().getResource("testArea.png"));
        image = i.getImage();
        x = 0;
        y = 0;
        width = 606;
        height = 353;
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

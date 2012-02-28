package rob.mainGame;

import javax.swing.*;
import java.awt.*;

public class TestArea {

    private int x;
    private int y;
    private Image image;

    public TestArea() {
        ImageIcon i = new ImageIcon(this.getClass().getResource("GameTestArea.png"));
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

package rob.mainGame;

import javax.swing.*;
import java.awt.*;

public class Map {
    private Image testArea;

    public Map() {
        testArea = (new ImageIcon(getClass().getResource("testArea.png"))).getImage();
    }

    public Image getTestArea() {
        return testArea;
    }
}

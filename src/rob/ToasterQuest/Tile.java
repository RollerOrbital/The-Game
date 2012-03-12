package rob.ToasterQuest;

import javax.swing.*;
import java.awt.*;

public class Tile {
    private Image image;

    public Tile() {
        ImageIcon ii = new ImageIcon((getClass().getResource("tiles.png")));
        image = ii.getImage();
    }

    public Image getImage() {
        return image;
    }
}

package rob.ToasterQuest;

import javax.swing.*;
import java.awt.*;

public class Tile {
    private Image image;
    private Level level;

    public Tile() {
        ImageIcon ii = new ImageIcon((getClass().getResource("tile.png")));
        image = ii.getImage();
        level = new Level();
    }

    public Image getImage() {
        return image;
    }
}

package rob.ToasterQuest;

import javax.swing.*;
import java.awt.*;

public class Tile {
    private Image image;
    private Level level;

    public Tile() {
        ImageIcon ii = new ImageIcon((getClass().getResource("tiles.png")));
        image = ii.getImage();
        level = new Level();
    }

    public Image getImage() {
        return image;
    }

    public void boundary() {
        if (level.x < 32 * 5 && level.y < -325 - 32) {

        }
        if (level.x > 65) {

        }
    }
}

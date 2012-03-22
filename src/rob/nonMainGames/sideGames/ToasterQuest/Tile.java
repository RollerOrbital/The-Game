package rob.nonMainGames.sideGames.ToasterQuest;

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

/*
tile = new Tile(16*16, 16);
    if(level.x >= tile.right || level.x <= tile.left && level.y < tile.bottom ||level.y > tile.top
 */

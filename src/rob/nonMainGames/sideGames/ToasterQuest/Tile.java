package rob.nonMainGames.sideGames.ToasterQuest;

import javax.swing.*;
import java.awt.*;

public class Tile {
    private Image image;

    public Tile() {
        ImageIcon ii = new ImageIcon((getClass().getResource("tile.png")));
        image = ii.getImage();
    }

    public Image getImage() {
        return image;
    }
}

/*
tile = new Tile(16*16, 16);
    if(player.x >= tile.right || player.x <= tile.left && player.y < tile.bottom ||player.y > tile.top
 */

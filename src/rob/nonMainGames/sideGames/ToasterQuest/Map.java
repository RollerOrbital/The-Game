package rob.nonMainGames.sideGames.ToasterQuest;

import javax.swing.*;
import java.awt.*;

public class Map {
    public Image image;
    private final Player player;

    public Map() {
        ImageIcon ii = new ImageIcon(getClass().getResource("level.png"));
        image = ii.getImage();
        player = new Player();
    }

    private Image getImage() {
        return image;
    }

    private int getX() {
        return -player.x;
    }

    private int getY() {
        return -player.y;
    }
}

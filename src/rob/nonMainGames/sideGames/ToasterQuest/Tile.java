package rob.nonMainGames.sideGames.ToasterQuest;

import javax.swing.*;
import java.awt.*;

public class Tile {
    private final Player player;
    private int x, y;
    private final Image image;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        player = new Player();
        ImageIcon ii = new ImageIcon(getClass().getResource("tile.png"));
        image = ii.getImage();
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

    public Rectangle getBounds() {
        return (new Rectangle(getX(), getY(), 18, 16));
    }
}

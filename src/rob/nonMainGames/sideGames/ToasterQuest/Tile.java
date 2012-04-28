package rob.nonMainGames.sideGames.ToasterQuest;

import javax.swing.*;
import java.awt.*;

//tiles draw from the BOTTOM LEFT
public class Tile {
    private int x, y;
    private final Image image;
    private static Tile t1 = new Tile(18 * 5, 405);
    private static Tile t2 = new Tile(18 * 6, 405);
    private static Tile t3 = new Tile(18 * 7, 405);
    private static Tile t4 = new Tile(18 * 8, 405);
    private static Tile t5 = new Tile(18 * 13, 405);
    private static Tile t6 = new Tile(18 * 14, 405);
    private static Tile t7 = new Tile(18 * 15, 405);
    private static Tile t8 = new Tile(18 * 16, 405);
    private static Tile t9 = new Tile(18 * 14, 405 - 16);
    private static Tile t10 = new Tile(18 * 15, 405 - 16);
    private static Tile t11 = new Tile(18 * 16, 405 - 16);
    private static Tile t12 = new Tile(18 * 15, 405 - 16 * 2);
    private static Tile t13 = new Tile(18 * 16, 405 - 16 * 2);
    private static Tile t14 = new Tile(18 * 16, 405 - 16 * 3);
    private static Tile t15 = new Tile(18 * 20, 405 - 16 * 5);
    public static Tile[] tiles = new Tile[]{t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15};

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
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
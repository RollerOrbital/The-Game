package rob.ToasterQuest;

import javax.swing.*;
import java.awt.*;

public class Player {
    public int height;
    public int distance;
    private ImageIcon ii;
    private Image image;

    public Player() {
        height = 326;
        distance = -200;
        ii = new ImageIcon(getClass().getResource("player.png"));
        image = ii.getImage();
    }

    public Image getImage() {
        return image;
    }
}

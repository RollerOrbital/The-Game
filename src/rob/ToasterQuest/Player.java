package rob.ToasterQuest;

import javax.swing.*;
import java.awt.*;

public class Player {
    public int height;
    public int distance;
    private Image image;

    public Player() {
        height = 326;
        distance = -200;
        ImageIcon ii = new ImageIcon(getClass().getResource("player.png"));
        image = ii.getImage();
    }

    public Image getImage() {
        return image;
    }
}

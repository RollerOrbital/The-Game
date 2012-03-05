package rob.ToasterQuest;

import javax.swing.*;
import java.awt.*;

public class Player {
    private int height, distance;
    private ImageIcon ii;
    private Image image;

    public Player() {
        height = 20;
        distance = 50;
        ii = new ImageIcon(getClass().getResource("player.png"));
        image = ii.getImage();
    }
}

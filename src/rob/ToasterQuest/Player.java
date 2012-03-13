package rob.ToasterQuest;

import javax.swing.*;
import java.awt.*;

public class Player {
    public static int altitude;
    public static int distance;
    public Image image;
    public int width, height;
    public int direction;

    public Player() {
        altitude = Panel.lowerBound;
        distance = -200;
        ImageIcon ii = new ImageIcon(getClass().getResource("player.png"));
        image = ii.getImage();
        width = 12;
        height = 18;
        direction = 0;
    }
}

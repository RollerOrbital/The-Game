package rob.nonMainGames.sideGames.ToasterQuest;

import javax.swing.*;
import java.awt.*;

public class Player {
    public static int altitude;
    public static int distance;
    public Image image;
    public int width, height;
    public int direction;

    public Player() {
        altitude = Panel.lowerBound + 850;
        distance = -190;
        ImageIcon ii = new ImageIcon(getClass().getResource("player.png"));
        image = ii.getImage();
        width = 12;
        height = 18;
        direction = 0;
    }
}

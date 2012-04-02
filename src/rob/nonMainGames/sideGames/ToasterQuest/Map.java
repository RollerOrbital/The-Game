package rob.nonMainGames.sideGames.ToasterQuest;

import javax.swing.*;
import java.awt.*;

public class Map {
    private Image image;

    public Map() {
        ImageIcon ii = new ImageIcon(getClass().getResource("level.png"));
        image = ii.getImage();
    }

    public Image getImage() {
        return image;
    }
}

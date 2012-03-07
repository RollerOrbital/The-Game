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
        altitude = 326;
        distance = -200;
        ImageIcon ii = new ImageIcon(getClass().getResource("player.png"));
        image = ii.getImage();
        width = 12;
        height = 18;
        int[] spriteFrame = new int[4];
        spriteFrame[0] = 0;
        spriteFrame[1] = 1;
        spriteFrame[2] = 0;
        spriteFrame[3] = 2;
        direction = 0;
    }
}

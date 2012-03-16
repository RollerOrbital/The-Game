package rob.mainGame;

import javax.swing.*;
import java.awt.*;

public class Player {
    public Image image;
    public int width, height;
    public int direction;
    public int x, y;
    public String room;

    public Player() {
        ImageIcon ii = new ImageIcon(getClass().getResource("player.png"));
        image = ii.getImage();
        x = 200;
        y = 150;
        width = 12;
        height = 18;
        direction = 0;
        room = "testRoom";
    }
}

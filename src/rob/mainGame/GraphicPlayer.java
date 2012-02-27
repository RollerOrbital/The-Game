package rob.mainGame;

import javax.swing.*;
import java.awt.*;

public class GraphicPlayer {
    public int x;
    public int y;
    private Image image;

    public GraphicPlayer() {
        String player = "player.png";
        ImageIcon i = new ImageIcon(this.getClass().getResource(player));
        image = i.getImage();
        x = 40;
        y = 10;
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
}
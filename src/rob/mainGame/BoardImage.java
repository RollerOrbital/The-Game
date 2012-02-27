package rob.mainGame;

import javax.swing.*;
import java.awt.*;

public class BoardImage {

    private String bi = "combatBoard.png";
    private int x;
    private int y;
    private Image image;

    public BoardImage() {
        ImageIcon i = new ImageIcon(this.getClass().getResource(bi));
        image = i.getImage();
        x = 0;
        y = 0;
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

package rob.mainGame;

import javax.swing.*;
import java.awt.*;

public class CombatBoard {
    private String cb = "combatBoard.png";
    private int x;
    private int y;
    private Image image;

    public CombatBoard() {
        ImageIcon i = new ImageIcon(this.getClass().getResource(cb));
        image = i.getImage();
        x = 10;
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

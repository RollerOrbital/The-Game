package pierce;

import javax.swing.*;
import java.awt.*;

public class PlayerSquare {

    private Image image;

    public PlayerSquare() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("sqr_player.png"));
        image = ii.getImage();
    }

    public Image getImage() {
        return image;
    }
}
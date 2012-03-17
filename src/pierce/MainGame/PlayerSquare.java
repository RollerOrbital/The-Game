package pierce.MainGame;

import javax.swing.*;
import java.awt.*;

public class PlayerSquare {

    private Image image;
//    private int x;
//    private int y;
//    private int width;
//    private int height;

    public PlayerSquare() {
//       x = 0;
//       y = 0;
//        width = image.getWidth(null);
//        height = image.getHeight(null);
        ImageIcon ii = new ImageIcon(this.getClass().getResource("sqr_player.png"));
        image = ii.getImage();
    }

    public Image getImage() {
        return image;
    }
}
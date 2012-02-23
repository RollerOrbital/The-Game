package will;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    Image bedmap_incomplete;

    public Board() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("bedmap_incomplete.jpg"));
        bedmap_incomplete = ii.getImage();
    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bedmap_incomplete, 0, 0, null);

    }


}

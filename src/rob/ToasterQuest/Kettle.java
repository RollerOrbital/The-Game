package rob.ToasterQuest;

import javax.swing.*;
import java.awt.*;

public class Kettle {
    public int x, y, dx, stopxs, stopxe;
    public Image image;

    public Kettle(int x, int y, int dx, int stopxs, int stopxe) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.stopxs = stopxs;
        this.stopxe = stopxe;
        ImageIcon ii = new ImageIcon(getClass().getResource("kettle.png"));
        image = ii.getImage();
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

    public void move() {
        x += dx;
        if (x > stopxe) {
            x = stopxe;
            dx *= -1;
        } else if (x < stopxs) {
            x = stopxs;
            dx *= -1;
        }
    }

    static Kettle k1 = new Kettle(16 * 34, 16, 1, 16 * 24, 16 * 34);
    static Kettle k2 = new Kettle(16 * 66, 16, 1, 16 * 37, 16 * 66);
}

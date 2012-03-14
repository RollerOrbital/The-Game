package rob.ToasterQuest;

import javax.swing.*;
import java.awt.*;

public class Toast {
    public int x, y, points;
    public Image image;

    public Toast(int x, int y, int points) {
        this.x = x;
        this.y = y;
        this.points = points;
        ImageIcon ii = new ImageIcon(getClass().getResource("toast.png"));
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

    static Toast t1 = new Toast(16 * 45, 16 * 2, 3);
    static Toast t2 = new Toast(16 * 72, 16 * 2, 2);
    static Toast t3 = new Toast(16 * 47, 16 * 13, 5);

}

package rob.bombGame;

import javax.swing.*;
import java.awt.*;

public class Bomb {
    private static final int xstep = 5;
    private static final int ystep = 5;
    protected int x, y;
    protected int dx, dy;

    public Bomb() {
        x = x;
        y = y;
        dx = xstep;
        dy = ystep;
        ImageIcon i = new ImageIcon(this.getClass().getResource("Bomb.png"));
        Image image = i.getImage();
    }

    public void move() {
        x += dx;
        y += dy;
        if (x <= 0) {
            x = 0;
        } else if (x >= 580) {
            x = 580;
        } else if (y <= 0) {
            y = 0;
        } else if (y >= 309) {
            y = 309;
        }
    }
}

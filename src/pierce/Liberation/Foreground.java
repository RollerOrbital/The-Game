package pierce.Liberation;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Foreground {
    public static int x, y;

    public Foreground() {
        x = (154*4);
        y = (58*4)+66;//random.nextInt(300) + 50;
    }

    public void move() {
        x -= 1;
        if (x <= 0) {
            x=(154*4);
        }
    }

    public int getX() {
        return x-((154*4));
    }

    public int getY() {
        return y;
    }
}

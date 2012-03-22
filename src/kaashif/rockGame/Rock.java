package kaashif.rockGame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Rock {

    private int dx;
    private int dy;
    public int x;

    public int y = 0;

    private int width;
    private int height;
    private Image image;
    private boolean vis;

    public Rock() {
        Random random = new Random();
        ImageIcon ii = new ImageIcon(this.getClass().getResource("rock.gif"));
        image = ii.getImage();
        vis = true;
        dx = random.nextInt(5) - 3;
        dy = 5;
        width = image.getWidth(null);
        height = image.getHeight(null);
        x = random.nextInt(416);

    }

    public void setVis(Boolean vis) {
        this.vis = vis;
    }

    public void move() {
        y += dy;
        x += dx;
        if (y > 750) {
            vis = false;
        } else if (x <= 0) {
            dx *= -1;
        } else if (x >= 416) {
            dx *= -1;
        }
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

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public boolean getVis() {
        return vis;
    }
}
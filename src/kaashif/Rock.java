package kaashif;

import java.awt.*;

import javax.swing.ImageIcon;

public class Rock implements Runnable{

    private String craft = "rock.gif";

    private int dx;
    private int dy;
    private int x;
    private int y;
    private int width;
    private int height;
    private Image image;

    public Rock() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
        image = ii.getImage();
        dx = 0;
        dy = 5;
        run();

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }


    public void run() {
        x += dx;
        y += dy;

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
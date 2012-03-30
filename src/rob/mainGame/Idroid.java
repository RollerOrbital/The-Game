package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Idroid {
    private int x, y;
    private final Image image;
    private int direction, frameNumber;

    public Idroid(int direction, int x, int y, int frameNumber) {
        this.direction = direction;
        this.y = y;
        this.x = x;
        this.frameNumber = frameNumber;
        ImageIcon ii = new ImageIcon(getClass().getResource("iDroid.png"));
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

    public int getDirection() {
        return direction;
    }

    public int getWidth() {
        return 12;
    }

    public int getHeight() {
        return 18;
    }

    public int getFrameNumber() {
        return frameNumber;
    }

    public void drawIdroid(Graphics g, ImageObserver imageObserver) {
        g.drawImage(getImage(), getX(), getY(), getX() + getWidth() * 2, getY() + getHeight() * 2, getDirection(), getFrameNumber(), getFrameNumber() + getWidth(), getDirection() + getHeight(), imageObserver);

    }
}

package rob.mainGame;

import javax.swing.*;
import java.awt.*;

public class IDroid {
    //movement stats:
    public int dx;
    public int dy;
    public int x;
    public int y;
    private int movex;
    private int movey;
    private int width;
    private int height;
    private int sprframe;
    private int sprdir;
    private int[] AnimationFrame;
    private int AnimationCounter;
    private int AnimationSpeed;

    public int vigor;
    public int pace;
    public int fortune;
    public int twitch;
    public int aegis;
    public int scope;
    public int cognition;

    public int hp;
    public int basehp;
    public int mp;
    public int basemp;
    public int baseYield;

    private Image image;

    public IDroid() {
        ImageIcon i = new ImageIcon(this.getClass().getResource("idroid.png"));
        image = i.getImage();

        baseYield = 5;

        scope = 5;
        vigor = 5;
        pace = 3;
        fortune = 5;
        twitch = 15;
        aegis = 5;
        cognition = 30;

        hp = 40;
        basehp = 40;
        mp = 40;
        basemp = 40;

        x = 100;
        y = 100;

        AnimationFrame = new int[4];
        AnimationFrame[0] = 0;
        AnimationFrame[1] = 1;
        AnimationFrame[2] = 0;
        AnimationFrame[3] = 2;
        AnimationCounter = 0;
        AnimationSpeed = 1;
        sprframe = 0;
        sprdir = 0;
        dx = 0;
        dy = 0;
        width = 12;
        height = 18;
    }

    public void move() {
        if (movex != 0) {
            x += dx;
            movex -= dx;
        } else if (movey != 0) {
            y += dy;
            movey -= dy;
        }

        if (AnimationCounter == 16) {
            if ((sprframe + AnimationSpeed) > 3) {
                sprframe = 0;
            } else {
                sprframe += AnimationSpeed;
            }
            AnimationCounter = 0;
        } else {
            AnimationCounter += 1;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSprFrame() {
        return (AnimationFrame[sprframe] * width);
    }

    public int getSprDir() {
        return (sprdir * height);
    }

    public Image getImage() {
        return image;
    }
}

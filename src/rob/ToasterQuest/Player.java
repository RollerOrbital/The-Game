package rob.ToasterQuest;

import javax.swing.*;
import java.awt.*;

public class Player {
    public static int altitude;
    public static int distance;
    private Image image;
    private int width, height;
    private int[] spriteFrame;
    public int frameNumber;
    public int direction;

    public Player() {
        altitude = 326;
        distance = -200;
        ImageIcon ii = new ImageIcon(getClass().getResource("player.png"));
        image = ii.getImage();
        width = 12;
        height = 18;
        spriteFrame = new int[4];
        spriteFrame[0] = 0;
        spriteFrame[1] = 1;
        spriteFrame[2] = 0;
        spriteFrame[3] = 2;
        direction = 0;
    }

    Level level = new Level();

    public void move() {
        if (level.left) {
            direction = 1;
            frameNumber = 1;
        } else if (level.right) {
            direction = 3;
            frameNumber = 1;
        } else if (level.up) {
            direction = 2;
            frameNumber = 1;
        } else {
            level.up = false;
            level.right = false;
            level.left = false;
        }
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSprFrame() {
        return (spriteFrame[frameNumber] * width);
    }

    public int getSprDir() {
        return (direction * height);
    }

    public Image getImage() {
        return image;
    }
}

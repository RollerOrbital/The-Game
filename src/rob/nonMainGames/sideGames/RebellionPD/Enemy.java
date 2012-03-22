package rob.nonMainGames.sideGames.RebellionPD;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Enemy {
    Random random = new Random();
    private int x, dx;
    private ImageIcon libya;
    private int frameNumber, crouching, stepCount;

    public Enemy() {
        crouching = random.nextInt(2);
        frameNumber = 0;
        x = 400;
        dx = -1;
        libya = new ImageIcon(getClass().getResource("libyaGuy.png"));
    }

    public int getX() {
        return x;
    }

    public Image getImage() {
        return libya.getImage();
    }

    public int getCrouching() {
        return crouching * 35;
    }

    public int getFrame() {
        return frameNumber * 42;
    }

    public void move() {
        x += dx;
        stepCount++;
        if (stepCount % 100 < 50) {
            frameNumber = 0;
        } else {
            frameNumber = 1;
        }
    }
}

package rob.nonMainGames.sideGames.RebellionPD;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Enemy {
    private Random random;
    public ImageIcon egypt, libya, gov;
    private ImageIcon enemy;
    private Player player = new Player();
    private int x, dx;
    private int crouching, stepCount, frameNumber;

    public Enemy() {
        random = new Random();
        stepCount = 0;
        frameNumber = 0;
        getEnemyAttributes();
        //ImageIcons START
        libya = new ImageIcon(getClass().getResource("libyaGuy.png"));
        //ImageIcons END
    }

    private void getEnemyAttributes() {
        if (player.getImage() == libya.getImage() || player.getImage() == egypt.getImage()) {
            enemy = gov;
        } else {
            int choice = random.nextInt(1);
            if (choice == 0) {
                enemy = libya;
            } else {
                enemy = egypt;
            }
        }
        int choice2 = random.nextInt(3);
        if (choice2 == 0) {
            crouching = 0;
        } else {
            crouching = 1;
        }
    }

    public Image getImage() {
        return enemy.getImage();
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

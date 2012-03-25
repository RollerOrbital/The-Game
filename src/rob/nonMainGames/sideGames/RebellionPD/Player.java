package rob.nonMainGames.sideGames.RebellionPD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    public ImageIcon egypt, libya, gov;
    public boolean isChoosing, isFiring;
    public int crouching, CROUCH, STAND;
    private int frameNumber, stepCount;
    public int kills;
    private ImageIcon player;

    public Player() {
        isFiring = false;
        stepCount = 0;
        CROUCH = 0;
        STAND = 1;
        frameNumber = 0;
        crouching = 1;
        isChoosing = true;
        libya = new ImageIcon(getClass().getResource("libyaGuy.png"));
    }

    public Image getImage() {
        return player.getImage();
    }

    public int getCrouching() {
        return crouching * 35;
    }

    public int getFrame() {
        return frameNumber * 42;
    }

    public void move() {
        stepCount++;
        if (stepCount % 100 < 50) {
            frameNumber = 0;
        } else {
            frameNumber = 1;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (isChoosing) {
            if (key == KeyEvent.VK_E) {
                player = egypt;
                isChoosing = false;
            } else if (key == KeyEvent.VK_G) {
                player = gov;
                isChoosing = false;
            } else if (key == KeyEvent.VK_L) {
                player = libya;
                isChoosing = false;
            }
        } else {
            if (key == KeyEvent.VK_DOWN) {
                crouching = CROUCH;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        frameNumber = 0;
        if (key == KeyEvent.VK_DOWN) {
            crouching = STAND;
        }
    }
}

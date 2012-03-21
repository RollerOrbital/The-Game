package rob.nonMainGames.sideGames.RebellionPD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    private int health;
    private ImageIcon egypt, libya, gov;
    private ImageIcon player;
    public boolean isChoosing;
    public int crouching;
    public int CROUCH, STAND;
    private int WIDTH;
    private int frameNumber;
    private int stepCount;

    public Player() {
        stepCount = 0;
        CROUCH = 0;
        STAND = 1;
        frameNumber = 0;
        WIDTH = 50;
        crouching = 1;
        isChoosing = true;
        //ImageIcons START
        libya = new ImageIcon(getClass().getResource("libyaGuy.png"));
        //ImageIcons END
    }

    public Image getImage() {
        try {
            return player.getImage();
        } catch (Exception e) {
            return libya.getImage();
        }
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
            } else if (key == KeyEvent.VK_G) {
                player = gov;
            } else if (key == KeyEvent.VK_L) {
                player = libya;
            }
            isChoosing = false;
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

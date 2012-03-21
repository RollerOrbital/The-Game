package rob.nonMainGames.sideGames.RebellionPD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    private int x, dx, health;
    private ImageIcon egypt, libya, gov;
    private ImageIcon player;
    public boolean isChoosing;
    private boolean isCrouching;
    private int WIDTH;

    public Player() {
        WIDTH = 50;
        isCrouching = false;
        isChoosing = true;
        x = 0;
        dx = 0;
        //ImageIcons START
        libya = new ImageIcon(getClass().getResource("libyaGuy.png"));
        //ImageIcons END
    }

    public Image getImage() {
        return player.getImage();
    }

    public int getX() {
        return x;
    }

    public void getBounds() {
        if (x <= 0) {
            x = 0;
        } else if (x >= 400 - WIDTH) {
            x = 400 - WIDTH;
        }
    }

    public void move() {
        getBounds();
        x += dx;
        getBounds();
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
                isCrouching = true;
            } else if (key == KeyEvent.VK_RIGHT) {
                dx = 1;
            } else if (key == KeyEvent.VK_LEFT) {
                dx = -1;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_DOWN) {
            isCrouching = false;
        } else if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        } else if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }
    }
}

package rob.nonMainGames.sideGames.RebellionPD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    private int x, dx, health;
    private ImageIcon rs, rc, ss, sc;
    private String charChoice;
    private boolean isChoosing, isCrouching;
    private int WIDTH;

    public Player() {
        WIDTH = 50;
        isCrouching = false;
        isChoosing = true;
        x = 0;
        dx = 0;
        //ImageIcons START
        //ImageIcons END
    }

    public Image getImage() {
        if (charChoice.equals("sniper")) {
            if (isCrouching) {
                return sc.getImage();
            } else {
                return ss.getImage();
            }
        } else {
            if (isCrouching) {
                return rc.getImage();
            } else {
                return rs.getImage();
            }
        }
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
        if (key == KeyEvent.VK_DOWN) {
            isCrouching = true;
        } else if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        } else if (key == KeyEvent.VK_LEFT) {
            dx = -1;
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

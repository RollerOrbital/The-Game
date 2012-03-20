package rob.nonMainGames.sideGames.RebellionPD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    private int x, dx, health;
    private Image image;
    private ImageIcon rs, rc, ss, sc;
    private String charChoice;
    private boolean isChoosing, isCrouching;

    public Player() {
        isCrouching = false;
        isChoosing = true;
        x = 0;
        dx = 0;
        //ImageIcons START
        //ImageIcons END
    }

    public Image getImage() {
        if (charChoice == "sniper") {
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

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
    }
}

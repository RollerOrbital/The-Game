package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class fireBallSpell {
    private Player p;
    private IDroid i;
    private int x, y;
    public int dx, dy;
    private Image image;

    public fireBallSpell() {
        p = Map.player;
        i = Map.iDroid;
        x = 0;
        y = 0;
        dx = 0;
        dy = 0;
        ImageIcon i = new ImageIcon(this.getClass().getResource("fireballSpell"));
        image = i.getImage();
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

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            if (p.direction == 0) {
                dy++;
            } else if (p.direction == 1) {
                dx--;
            } else if (p.direction == 2) {
                dy--;
            } else if (p.direction == 3) {
                dx++;
            }
        }
    }
}

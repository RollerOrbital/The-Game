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
        x = -10;
        y = -10;
        dx = 0;
        dy = 0;
        ImageIcon i = new ImageIcon(this.getClass().getResource("fireballSpell.png"));
        image = i.getImage();
    }

    public void move() {
        x += dx;
        y += dy;
        if (Math.abs(p.x - x) > p.pace * 32 || Math.abs(i.x - x) <= 30) {
            x = -10;
            y = -10;
            dx = 0;
            dy = 0;
        }
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
                x = p.x - 10;
                y = p.y;
                dy++;
            } else if (p.direction == 1) {
                x = p.x;
                y = p.y - 10;
                dx--;
            } else if (p.direction == 2) {
                x = p.x;
                y = p.y + 10;
                dy--;
            } else if (p.direction == 3) {
                x = p.x + 10;
                y = p.y;
                dx++;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
    }
}

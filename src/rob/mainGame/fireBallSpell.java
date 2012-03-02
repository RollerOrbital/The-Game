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
        p = new Player();
        i = new IDroid();
        x = -20;
        y = -20;
        dx = 0;
        dy = 0;
        ImageIcon i = new ImageIcon(this.getClass().getResource("fireballSpell.png"));
        image = i.getImage();
    }

    public void move() {
        if (Math.abs(p.x - x) > p.pace * 32 || Math.abs(i.x - x) <= 30) {
            x = -10;
            y = -10;
            dx = 0;
            dy = 0;
        }
        x += dx;
        y += dy;
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

        if (key == KeyEvent.VK_Z) {
            if (p.direction == 0) {
                x = Map.player.x + 10;
                y = Map.player.y;
                dy = 1;
                dx = 0;
            } else if (p.direction == 1) {
                x = Map.player.x + 10;
                y = Map.player.y;
                dx = -1;
                dy = 0;
            } else if (p.direction == 2) {
                x = Map.player.x + 10;
                y = Map.player.y;
                dy = -1;
                dx = 0;
            } else if (p.direction == 3) {
                x = Map.player.x + 10;
                y = Map.player.y;
                dx = 1;
                dy = 0;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
    }
}

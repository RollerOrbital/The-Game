package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class CombatCursor {

    private int dx;
    private int dy;
    public int x;
    public int y;
    private Image image;

    public CombatCursor() {
        String cc = "combatCursor.png";
        ImageIcon i = new ImageIcon(this.getClass().getResource(cc));
        image = i.getImage();
        x = 270;
        y = 160;
    }

    public void move() {
        x += dx;
        y += dy;
        if (y >= (CombatBoard.player.pace * 71)) {
            y = CombatBoard.player.pace * 71;
        }
        if (x < 0) {
            x = 0;
        } else if (y < 0) {
            y = 0;
        } else if (x > CombatBoard.player.pace * 125) {
            x = CombatBoard.player.pace * 125;
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

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
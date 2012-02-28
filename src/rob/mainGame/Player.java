package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    public int pace;
    public int x;
    public int y;
    private Image image;

    public Player() {
        String player = "Bomb.png";
        ImageIcon i = new ImageIcon(this.getClass().getResource(player));
        image = i.getImage();
        x = 40;
        y = 10;
        pace = 3;
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
            if (Math.abs(CombatBoard.cursor.x - x) <= pace * 125) {
                x = CombatBoard.cursor.x;
            }
            if (Math.abs(CombatBoard.cursor.y - y) <= pace * 71) {
                y = CombatBoard.cursor.y;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_Z) {
        }
    }
}
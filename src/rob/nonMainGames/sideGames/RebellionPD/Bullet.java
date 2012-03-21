package rob.nonMainGames.sideGames.RebellionPD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Bullet {
    private Image image;
    private int x, dx;
    private Player player;

    public Bullet() {
        player = new Player();
        x = 100;
        dx = 0;
        ImageIcon ii = new ImageIcon(getClass().getResource("bullets.png"));
        image = ii.getImage();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return 190;
    }

    public Image getImage() {
        return image;
    }

    public void move() {
        x += dx;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_Z) {
            dx = 1;
        }
    }
}

package rob.mazeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    private int fouls = 0;
    private String player = "craft.png";
    private int dx;
    private int dy;
    private int x;
    private int y;
    private int width;
    private int height;
    private Image image;

    public Player() {
        ImageIcon i = new ImageIcon(this.getClass().getResource(player));
        image = i.getImage();
        x = 40;
        y = 40;
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public void move() {
        x += dx;
        y += dy;
        if (y > 425) {
            y = 425;
            fouls++;
        } else if (y < 0) {
            y = 0;
            fouls++;

            //Horizontal Lines
        } else if ((x >= -10 && x < 100) && (y <= 100 && y >= 90)) {
            if (y > 95) {
                y = 100;
            } else if (y < 95) {
                y = 90;
            }
            fouls++;
        } else if ((x >= -10 && x < 100) && (y <= 300 && y >= 290)) {
            if (y > 295) {
                y = 300;
            } else if (y < 295) {
                y = 290;
            }
            fouls++;
        }

        if (x < 0) {
            x = 0;
            fouls++;
        } else if (x > 725) {
            x = 725;
            fouls++;
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

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
package rob.mazeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {


    public static int fouls = 0;
    private int dx;
    private int dy;
    public static int x;
    public static int y;
    private Image image;

    public Player() {
        String player = "PLAYER.png";
        ImageIcon i = new ImageIcon(this.getClass().getResource(player));
        image = i.getImage();
        x = 40;
        y = 40;
    }

    public void move() {
        x += dx;
        y += dy;
        if (y >= 200) {
            y = 200;
            fouls++;
        } else if (x >= 690) {
            x = 690;
            fouls++;
        } else if (x <= 10) {
            x = 10;
            fouls++;
        } else if (y <= 10) {
            y = 10;
            fouls++;
        }
        hwall(-10, 100, 90, 80);
        hwall(-10, 100, 270, 260);
        hwall(90, 320, 195, 185);
        hwall(150, 370, 50, 40);
        hwall(150, 370, 120, 110);
        hwall(-10, 100, 100, 90);
        hwall(150, 465, 300, 290);
        hwall(380, 465, 230, 220);
        hwall(465, 650, 140, 130);
        hwall(500, 690, 200, 190);
        hwall(370, 530, 80, 70);
        vwall(40, 140, 150, 140);
        vwall(120, 550, 450, 440);
        vwall(-20, 100, 500, 490);
        vwall(20, 170, 590, 580);
        vwall(170, 300, 530, 520);
        vwall(240, 500, 600, 590);
    }

    private void hwall(int xs, int xe, int ys, int ye) {
        if ((x >= xs && x < xe) && (y <= ys && y >= ye)) {
            if (y > (ys + ye) / 2) {
                y = ys;
            } else if (y < (ys + ye) / 2) {
                y = ye;
            }
            fouls++;
        }
    }

    public void vwall(int ys, int ye, int xs, int xe) {
        if ((y >= ys && y < ye) && (x <= xs && x >= xe)) {
            if (x > (xs + xe) / 2) {
                x = xs;
            } else if (x < (xs + xe) / 2) {
                x = xe;
            }
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
}
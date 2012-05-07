package pierce.MainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    private int dx;
    private int dy;
    private int x;
    private int y;
    private int movex;
    private int movey;
    private int width;
    private int height;
    private Image image;
    private int sprframe;
    private int sprdir;
    private int xbound;
    private int ybound;
    private int xbox;
    private int ybox;
    private int[] AnimationFrame;
    private int AnimationCounter;
    private int AnimationSpeed;
    private boolean upheld;
    private boolean downheld;
    private boolean leftheld;
    private boolean rightheld;

    public Player() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("char_playerdefault.png"));
        image = ii.getImage();
        x = (4*16*2);
        y = (3*12*2);
        dx = 0;
        dy = 0;
        movex = 0;
        movey = 0;
        width = 12; //image.getWidth(null);
        height = 18; //image.getAltitude(null);
        xbound = 16;
        ybound = 12;
        xbox = (x/xbound);
        ybox = (y/ybound);
        sprframe = 0;
        sprdir = 0;
        AnimationFrame = new int[4];
        AnimationFrame[0] = 0;
        AnimationFrame[1] = 1;
        AnimationFrame[2] = 0;
        AnimationFrame[3] = 2;
        AnimationCounter = 0;
        AnimationSpeed = 1;
    }

    public void move() {
        //if RoomHolder.board[0][1][1] =
        
        if (movex != 0) {
            x += dx;
            movex -= dx;
        } else if (movey != 0) {
            y += dy;
            movey -= dy;
        } else if (leftheld) {
            AnimationSpeed = 1;
            dx = -1;
            sprdir = 1;
            movex = -32;
        } else if (rightheld) {
            AnimationSpeed = 1;
            dx = 1;
            sprdir = 3;
            movex = 32;
        } else if (upheld) {
            dy = -1;
            sprdir = 2;
            movey = -24;
        } else if (downheld) {
            dy = 1;
            sprdir = 0;
            movey = 24;
        } else {
            dx = 0;
            dy = 0;
        }

        //Animation speed
        if ((rightheld) || (leftheld) || (upheld) || (downheld)) {
            if (AnimationSpeed == 0) {
                AnimationSpeed = 1;
            }
        } else {
            if ((movex == 0) && (movey == 0)) {
                AnimationSpeed = 0;
                if (sprframe != 0 && sprframe != 2) {
                    sprframe--;
                }
            }
        }
        //Animation counter
        if (AnimationCounter == 16) {
            if ((sprframe + AnimationSpeed) > 3) {
                sprframe = 0;
            } else {
                sprframe += AnimationSpeed;
            }
            AnimationCounter = 0;
        } else {
            AnimationCounter += 1;
        }

        //Setting rectangle location (for collision)
        xbox = (x/xbound);
        ybox = (y/ybound);

        /*if (y > (110 - ybound) * 2) {
            y = (110 - ybound) * 2;
        } else if (y < 0) {
            y = 0;
        }
        if (x < 0) {
            x = 0;
        } else if (x > (180 - xbound) * 2) {
            x = (180 - xbound) * 2;
        }*/
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getXsquare() {
        return (x / (xbound * 2) * xbound) * 2;
    }

    public int getYsquare() {
        return (y / (ybound * 2) * ybound) * 2;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSprFrame() {
        return (AnimationFrame[sprframe] * width);
    }

    public int getSprDir() {
        return (sprdir * height);
    }

    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        leftheld = (key == KeyEvent.VK_LEFT);
        rightheld = (key == KeyEvent.VK_RIGHT);
        upheld = (key == KeyEvent.VK_UP);
        downheld = (key == KeyEvent.VK_DOWN);
    }

    public void keyReleased(KeyEvent e) {
        int key = 1 - (e.getKeyCode());

        leftheld = (key == KeyEvent.VK_LEFT);
        rightheld = (key == KeyEvent.VK_RIGHT);
        upheld = (key == KeyEvent.VK_UP);
        downheld = (key == KeyEvent.VK_DOWN);
    }
}
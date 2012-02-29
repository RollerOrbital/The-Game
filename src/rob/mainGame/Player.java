package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    public String room;
    public int dx;
    private int dy;
    public int x;
    private int y;
    private int movex;
    private int movey;
    private int width;
    private int height;
    private Image image;
    private int sprframe;
    private int sprdir;
    private int[] AnimationFrame;
    private int AnimationCounter;
    private int AnimationSpeed;
    private boolean upheld;
    private boolean downheld;
    private boolean leftheld;
    private boolean rightheld;

    public Player() {
        room = "testArea";
        ImageIcon ii = new ImageIcon(this.getClass().getResource("char_playerdefault.png"));
        image = ii.getImage();
        x = 80;
        y = 80;
        dx = 0;
        dy = 0;
        movex = 0;
        movey = 0;
        width = 12; //image.getWidth(null);
        height = 18; //image.getHeight(null);
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
//xbound = 16;
//ybound = 12;

    public void move() {
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

        //boundaries

        //constant
        if (y > 320) {
            y = 320;
        } else if (y < 10) {
            y = 10;
        }
        if (x < 10) {
            x = 10;
        } else if (x > 550) {
            x = 550;
        }

        //testArea
        if (room == "testArea") {
            hwall(32 * 2, 32 * 7, 32 * 3, 32 * 3 - 10);
            hwall(32 * 2, 32 * 7, 32 * 5, 32 * 5 - 10);

            vwall(32 * 3, 32 * 5, 32 * 7, 32 * 7 - 10);
        }
    }

    public void hwall(int xs, int xe, int ys, int ye) {
        if ((x >= xs && x < xe) && (y <= ys && y >= ye)) {
            if (y > (ys + ye) / 2) {
                y = ys;
            } else if (y < (ys + ye) / 2) {
                y = ye;
            }
        }
    }

    public void vwall(int ys, int ye, int xs, int xe) {
        if ((y >= ys && y < ye) && (x <= xs && x >= xe)) {
            if (x > (xs + xe) / 2) {
                x = xs;
            } else if (x < (xs + xe) / 2) {
                x = xe;
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
package rob.scytheGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    public static int fouls = 0;
    public int dx;
    public int dy;
    public int x;
    public int y;
    private int xspeed;
    private int yspeed;
    private int width;
    private int height;
    private Image image;
    private int frameNumber;
    public int direction;
    private int[] AnimationFrame;
    private int AnimationCounter;
    private int AnimationSpeed;
    private boolean upheld;
    private boolean downheld;
    private boolean leftheld;
    private boolean rightheld;

    public Player() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("player.png"));
        image = ii.getImage();
        x = 32;
        y = 32;
        dx = 0;
        dy = 0;
        xspeed = 0;
        yspeed = 0;
        width = 12;
        height = 18;
        frameNumber = 0;
        direction = 0;
        AnimationFrame = new int[4];
        AnimationFrame[0] = 0;
        AnimationFrame[1] = 1;
        AnimationFrame[2] = 0;
        AnimationFrame[3] = 2;
        AnimationCounter = 0;
        AnimationSpeed = 1;
    }

    public void move() {
        if (xspeed != 0) {
            x += dx;
            xspeed -= dx;
        } else if (yspeed != 0) {
            y += dy;
            yspeed -= dy;
        } else if (leftheld) {
            AnimationSpeed = 1;
            dx = -1;
            direction = 1;
            xspeed = -32;
        } else if (rightheld) {
            AnimationSpeed = 1;
            dx = 1;
            direction = 3;
            xspeed = 32;
        } else if (upheld) {
            dy = -1;
            direction = 2;
            yspeed = -24;
        } else if (downheld) {
            dy = 1;
            direction = 0;
            yspeed = 24;
        } else {
            dx = 0;
            dy = 0;
        }
        findAnimationSpeed();
        setAnimationSpeed();
        standardBounds();
        mazeWalls();
    }

    private void mazeWalls() {
        hwall(-10, 800, 367, 363);
        hwall(-10, 100, 87, 83);
        hwall(-10, 100, 267, 263);
        hwall(110, 320, 199, 195);
        hwall(150, 350, 53, 49);
        hwall(150, 370, 117, 113);
        hwall(-10, 100, 97, 93);
        hwall(170, 450, 295, 291);
        hwall(380, 450, 243, 239);
        hwall(440, 650, 156, 152);
        hwall(530, 690, 197, 193);
        hwall(380, 530, 88, 84);

        vwall(-10, 500, 697, 693);
        vwall(40, 120, 154, 150);
        vwall(150, 550, 447, 443);
        vwall(-10, 80, 515, 511);
        vwall(40, 153, 599, 583);
        vwall(200, 300, 527, 523);
        vwall(260, 500, 597, 593);
    }

    private void standardBounds() {
        if (y > 400) {
            y = 400;
        } else if (y < 10) {
            y = 10;
        }
        if (x < 10) {
            x = 10;
        } else if (x > 710) {
            x = 710;
        }
    }

    private void setAnimationSpeed() {
        if (AnimationCounter == 16) {
            if ((frameNumber + AnimationSpeed) > 3) {
                frameNumber = 0;
            } else {
                frameNumber += AnimationSpeed;
            }
            AnimationCounter = 0;
        } else {
            AnimationCounter += 1;
        }
    }

    private void findAnimationSpeed() {
        if ((rightheld) || (leftheld) || (upheld) || (downheld)) {
            if (AnimationSpeed == 0) {
                AnimationSpeed = 1;
            }
        } else {
            if ((xspeed == 0) && (yspeed == 0)) {
                AnimationSpeed = 0;
                if (frameNumber != 0 && frameNumber != 2) {
                    frameNumber--;
                }
            }
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
        return (AnimationFrame[frameNumber] * width);
    }

    public int getSprDir() {
        return (direction * height);
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

//    public static int fouls = 0;
//    private int dx;
//    private int dy;
//    public static int x;
//    public static int y;
//    private Image image;
//
//    public Player() {
//        String player = "PLAYER.png";
//        ImageIcon i = new ImageIcon(this.getClass().getResource(player));
//        image = i.getImage();
//        x = 40;
//        y = 40;
//    }
//
//    public void move() {
//        x += dx;
//        y += dy;
//
//    }
//
//
//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public Image getImage() {
//        return image;
//    }
//
//    public void keyPressed(KeyEvent e) {
//
//        int key = e.getKeyCode();
//
//        if (key == KeyEvent.VK_LEFT) {
//            dx = -1;
//        }
//
//        if (key == KeyEvent.VK_RIGHT) {
//            dx = 1;
//        }
//
//        if (key == KeyEvent.VK_UP) {
//            dy = -1;
//        }
//
//        if (key == KeyEvent.VK_DOWN) {
//            dy = 1;
//        }
//    }
//
//    public void keyReleased(KeyEvent e) {
//        int key = e.getKeyCode();
//
//        if (key == KeyEvent.VK_LEFT) {
//            dx = 0;
//        }
//
//        if (key == KeyEvent.VK_RIGHT) {
//            dx = 0;
//        }
//
//        if (key == KeyEvent.VK_UP) {
//            dy = 0;
//        }
//
//        if (key == KeyEvent.VK_DOWN) {
//            dy = 0;
//        }
//    }
//}
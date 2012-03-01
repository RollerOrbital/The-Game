package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    public String room;
    public int dx;
    public int dy;
    public int x;
    public int y;
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

    public static boolean inCombat = false;

    public int vigor;
    public int pace;
    public int fortune;
    public int twitch;
    public int aegis;
    public int scope;
    public int cognition;
    public int xp;
    public int level;
    public int levelUpxp;
    public int hp;
    public int basehp;
    public int mp;
    public int basemp;

    public Player() {
        hp = 100;
        basehp = 100;
        mp = 100;
        basemp = 100;
        vigor = 15;
        pace = 3;
        fortune = 10;
        twitch = 10;
        aegis = 5;
        scope = 10;
        cognition = 50;
        xp = 0;
        level = 1;
        levelUpxp = level * level + 40;
        room = "battleRoom";
        ImageIcon ii = new ImageIcon(this.getClass().getResource("player.png"));
        image = ii.getImage();
        x = 10;
        y = 20;
        dx = 0;
        dy = 0;
        movex = 0;
        movey = 0;
        width = 12;
        height = 18;
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
        findAnimationSpeed();
        setAnimationSpeed();
        standardBounds();
        roomWalls();
    }

    private void standardBounds() {
        if (y > 350) {
            y = 350;
        } else if (y < 10) {
            y = 10;
        }
        if (x < 10) {
            x = 10;
        } else if (x > 550) {
            x = 550;
        }
    }

    private void roomWalls() {
        if (room.equals("testArea")) {
            hwall(64, 224, 96, 86);
            hwall(64, 224, 160, 150);
            vwall(96, 160, 224, 214);
        } else if (room.equals("testRoom")) {
            hwall(576, 768, 128, 118);
            vwall(0, 128, 576, 566);
        } else if (room.equals("battleRoom")) {
            hwall(0, 300, 10, 0);
            hwall(0, 300, 180, 170);
            vwall(0, 180, 10, 0);
            vwall(0, 180, 300, 290);
        }
    }

    private void setAnimationSpeed() {
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
    }

    private void findAnimationSpeed() {
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
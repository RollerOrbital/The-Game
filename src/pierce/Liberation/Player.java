package pierce.Liberation;

import java.awt.event.KeyEvent;

public class Player {
    public static int souls;
    public static int score;
    public static int health;
    public static int bullets;
    private int dy;
    public int x;
    public int y;
    private int canJump;
    private int step;
    private int frame;
    public boolean titlescreen;

    public Player() {
        souls = 0;
        health = 5;
        score = 0;
        bullets = 15;
        canJump = 1;
        titlescreen = true;//false;
        x = 58 * 2;
        y = (58 * 4) + 16;
        step = 0;
        frame = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getFrame() {
        return frame * 23;
    }

    public void move() {
        if ((y + dy) < (58 * 4) + 16) {
            y += dy;
        } else {
            y = 58 * 4 + 16;
        }
        if (step == 0) {
            if ((canJump == 0) && (dy != 4) && (y != (58 * 4) + 16)) {
                dy++;
            }
            if (y >= (58 * 4) + 16) {
                y = (58 * 4) + 16;
                dy = 0;
                canJump = 1;
            }
        }
        if (step < 16) {
            step++;
        } else {
            step = 0;
            if (frame < 1) {
                frame++;
            } else {
                frame = 0;
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if ((key == KeyEvent.VK_UP) && (canJump == 1) && (dy == 0) && (y == (58 * 4) + 16)) {
            dy = -4;
            canJump = 0;
        } else if (key == KeyEvent.VK_RIGHT) {
            if (titlescreen) {
                titlescreen = false;
                Arena.playSound("shoot.wav");
            } else {
                if ((Player.bullets > 0) && (Player.health > 0) && (Bullet.x > 500)) {
                    new Bullet();
                    Bullet.x = 216;
                    Bullet.y = (getY() + 52);
                    Player.bullets--;
                    Arena.playSound("shoot.wav");
                } else if (Player.health <= 0) {
                    new Player();
                    Player.health = 5;
                    Player.souls = 0;
                    Player.bullets = 15;
                    Player.score = 0;
                    Arena.playSound("shoot.wav");
                }
/*        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }*/
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            //dy = 0;
        }
    }
}
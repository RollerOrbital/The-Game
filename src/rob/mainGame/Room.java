package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Room {
    private Image image;
    private Player player;

    private int[] spriteFrame;

    public int y, jumpHeight;
    private int x, dx, width, height, frameNumber, direction, dy;

    public boolean canJump;

    private boolean left, right, up, down;

    public Room() {
        player = new Player();
        ImageIcon ii = new ImageIcon(getClass().getResource("testRoom.png"));
        image = ii.getImage();
        x = -1 * player.x;
        y = -1 * player.y;
        dx = 0;
        dy = 0;

        jumpHeight = 100;
        canJump = true;

        width = 12;
        height = 18;
        spriteFrame = new int[4];
        spriteFrame[0] = 0;
        spriteFrame[1] = 1;
        spriteFrame[2] = 0;
        spriteFrame[3] = 2;
        direction = 3;
        frameNumber = 0;
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

    public void move() {
        getDirection();
        basicBounds();
    }

    private void getDirection() {
        if (dy > 0) {
            direction = 2;
        } else if (dy < 0) {
            direction = 0;
        } else if (dx > 0) {
            direction = 1;
        } else if (dx < 0) {
            direction = 3;
        }
    }

    private void basicBounds() {
        if (x <= -333) {
            x = -332;
        } else if (x >= 199) {
            x = 198;
        } else if (y <= -193) {
            y = -193;
        } else if (y >= 121) {
            y = 120;
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        final int limit;
        if (key == KeyEvent.VK_UP) {
            limit = y - 32;
            if (up) {
                y += dy;
                if (y < limit) {
                    dy = 0;
                    up = false;
                }
            }
            if (!up) {
                dy = 1;
                up = true;
            } else {
                dy = 0;
            }
        } else if (key == KeyEvent.VK_LEFT) {
            limit = x - 32;
            if (left) {
                x += dx;
                if (x < limit) {
                    dx = 0;
                    left = false;
                }
            }
            if (!left) {
                dx = 1;
                left = true;
            } else {
                dx = 0;
            }
        } else if (key == KeyEvent.VK_RIGHT) {
            limit = x + 32;
            if (right) {
                x += dx;
                if (x > limit) {
                    dx = 0;
                    right = false;
                }
            }
            if (!right) {
                dx = -1;
                right = true;
            } else {
                dx = 0;
            }
        } else if (key == KeyEvent.VK_DOWN) {
            limit = y + 32;
            if (down) {
                y += dy;
                if (y > limit) {
                    dy = 0;
                    down = false;
                }
            }
            if (!down) {
                dy = -1;
                down = true;
            } else {
                dy = 0;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            dy = 0;
            up = false;
        } else if (key == KeyEvent.VK_LEFT) {
            dx = 0;
            left = false;
        } else if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
            right = false;
        } else if (key == KeyEvent.VK_DOWN) {
            dy = 0;
            down = false;
        }
    }

    public int getPWidth() {
        return width;
    }

    public int getPHeight() {
        return height;
    }

    public int getSprFrame() {
        return (spriteFrame[frameNumber] * width);
    }

    public int getSprDir() {
        return (direction * height);
    }

    public Image getPImage() {
        return player.image;
    }
}

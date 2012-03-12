package rob.mainGame;

import javax.swing.*;
import java.awt.*;

public class Enemy {
    public int x, y, dx, dy, width, height, direction, frameNumber;
    public Image image;
    public int[] spriteFrame;
    Player player;

    public Enemy(int x, int y, String imageName) {
        this.x = x;
        this.y = y;
        ImageIcon ii = new ImageIcon(getClass().getResource(imageName));
        image = ii.getImage();
        width = 12;
        height = 18;
        spriteFrame = new int[4];
        spriteFrame[0] = 0;
        spriteFrame[1] = 1;
        spriteFrame[2] = 0;
        spriteFrame[3] = 2;
        direction = 3;
        frameNumber = 0;
        player = new Player();

    }

    //Enemies
    public Enemy idroid = new Enemy(100, 100, "idroid");

    //Methods
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
        x += dx;
        y += dy;
    }

    public void moveAi() {
        final int ydiff = player.y - y;
        final int xdiff = player.x - x;

        if (xdiff < 0 && x > xdiff) {
            dx = -1;
        }
    }
}

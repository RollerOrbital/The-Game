package pierce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    private int dx;
    private int dy;
    private int x;
    private int y;
    private int width;
    private int height;
    private Image image;
    private int sprframe;
    private int sprdir;
    private int xbound;
    private int ybound;
    private int[] AnimationFrame;
    private int AnimationCounter;
    
    public Player() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("char_playerdefault.png"));
        image = ii.getImage();
        x = 0;
        y = 0;
        width = 12; //image.getWidth(null);
        height = 18; //image.getHeight(null);
        xbound = 16;
        ybound = 16;
        sprframe = 0;
        sprdir = 0;
        AnimationFrame = new int[4];
        AnimationFrame[0] = 0;
        AnimationFrame[1] = 1;
        AnimationFrame[2] = 0;
        AnimationFrame[3] = 2;
        AnimationCounter = 0;
    }
    
    public void move() {
        x += dx;
        y += dy;

        if (AnimationCounter==16) {
            if (sprframe+(dx*dx)+(dy*dy)>3) {sprframe=0;} else {sprframe += (dx*dx)+(dy*dy);} AnimationCounter = 0;}
        else {AnimationCounter += 1;}

        if (y>(110-ybound)*2){
            y=(110-ybound)*2;
        } else if (y<0){
            y=0;
        }
        if(x<0){
            x=0;
        }else if(x>(180-xbound)*2){
            x=(180-xbound)*2;
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
        return (AnimationFrame[sprframe]*width);
    }

    public int getSprDir() {
        return (sprdir*height);
    }
    
    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
            dy = 0;
            sprdir = 1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
            dy = 0;
            sprdir = 3;
        }

        if (key == KeyEvent.VK_UP) {
            dx = 0;
            dy = -1;
            sprdir = 2;
        }

        if (key == KeyEvent.VK_DOWN) {
            dx = 0;
            dy = 1;
            sprdir = 0;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
            sprframe = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
            sprframe = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
            sprframe = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
            sprframe = 0;
        }
    }
}
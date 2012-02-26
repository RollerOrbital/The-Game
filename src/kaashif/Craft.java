package kaashif;

import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Craft {

    private String craft = "craft.png";

    private int dx;
    private int dy;
    private int x;
    private int y;
    private int width;
    private int height;
    private Image image;
    private boolean vis = true;

    public Craft() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
        image = ii.getImage();
        x = 168;
        y = 600;
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public void move() {
        x += dx;
        y += dy;
        if (y>700){
            y=700;
        } else if (y<0){
            y=0;
        }
        if(x<0){
            x=0;
        }else if(x>378){
            x=378;
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
    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }
    public void setVis(boolean vis){
        this.vis = vis;

    }
    public boolean getVis(){
        return vis;
    }
}
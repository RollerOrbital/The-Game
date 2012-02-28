package kaashif;

import javax.swing.*;
import java.awt.*;

public class Rock{

    private String craft = "rock.gif";

    private int dx;
    private int dy;
    public int x = getRandomX();

    private int getRandomX() {
        int xx = (int)(Math.random()*416);
        return xx;
    }

    public int y = 0;

    private int width;
    private int height;
    private Image image;
    private boolean vis;

    public Rock() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
        image = ii.getImage();
        vis = true;
        dx = 0;
        dy = 1;
        width = image.getWidth(null);
        height = image.getHeight(null);

    }



    public void setVis(Boolean vis){
        this.vis = vis;
    }

    public void move(){
        y+=dy;
        if(y>750){
            vis = false;

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
    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }
    public boolean getVis (){
        return vis;
    }
}
package kaashif;

import java.awt.*;

import javax.swing.ImageIcon;

public class Rock{

    private String craft = "rock.gif";

    private int dx;
    private int dy;
    private int x;
    private int y;
    private int width;
    private int height;
    private Image image;
    private boolean vis;

    public Rock() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
        image = ii.getImage();
        vis = true;
        dx = 0;
        dy = 5;
        width = image.getWidth(null);
        height = image.getHeight(null);

    }

    public void setVis(Boolean vis){
        this.vis = vis;
    }

    public void move(){
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
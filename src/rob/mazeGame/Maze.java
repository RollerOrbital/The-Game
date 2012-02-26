package rob.mazeGame;

import javax.swing.*;
import java.awt.*;

public class Maze {

    private String maze = "mazePic.png";
    private int x;
    private int y;
    private int width;
    private int height;
    private Image image;

    public Maze() {
        ImageIcon i = new ImageIcon(this.getClass().getResource(maze));
        image = i.getImage();
        x = 10;
        y = 10;
        width = image.getWidth(null);
        height = image.getHeight(null);
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
}
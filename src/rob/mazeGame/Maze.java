package rob.mazeGame;

import javax.swing.*;
import java.awt.*;

public class Maze {

    private int x;
    private int y;
    private Image image;

    public Maze() {
        String maze = "mazePic.png";
        ImageIcon i = new ImageIcon(this.getClass().getResource(maze));
        image = i.getImage();
        x = 10;
        y = 10;
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
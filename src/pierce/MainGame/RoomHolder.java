package pierce.MainGame;

import javax.swing.*;
import java.awt.*;

public class RoomHolder {

    private Image image;
    private int x;
    private int y;
    private int width;
    private int height;
    private int rnum;
    private int board[][][] = new int[16][16][16];
    final int blank = 0; // empty
    final int box = 1;  // can't enter
    final int lbox = 2;  // can't enter going left
    final int rbox = 3;   // can't enter going right
    final int ubox = 4; //can't enter going up
    final int dbox = 5; //can't enter going down

    public RoomHolder() {
        x = 0;
        y = 0;
        rnum = 0;
        width = 163;
        height = 80;
        ImageIcon ii = new ImageIcon(this.getClass().getResource("room_001.png"));
        image = ii.getImage();
        for (int w=0; w < 11; w++)
            for (int h=0; h < 9; h++)
                board[0][w][h] = blank;
        board[0][1][1] = box;
        board[0][1][2] = box;
    }

    public void step() {
        if (rnum==0){x=160;y=72;}
    }

    public Image getImage() {
        return image;
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
    
    public int getSpace(int xbox, int ybox) {
        return board[rnum][xbox][ybox];
    }
}

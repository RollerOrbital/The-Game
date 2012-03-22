package rob.nonMainGames.sideGames.ToasterQuest;

import javax.swing.*;
import java.awt.*;

public class Toast {
    public int x;
    public int y;
    public static int score;
    public int points;
    public boolean isVis;
    public Image image;
    private Level level;

    public Toast(int x, int y, int points) {
        this.x = x;
        this.y = y;
        this.points = points;
        ImageIcon ii = new ImageIcon(getClass().getResource("toast.png"));
        image = ii.getImage();
        level = new Level();
        isVis = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        getToast();
        return image;
    }

    public void getToast() {
        if (-level.x >= x + 10 - (13 * 16) && -level.x <= -x - 10 - (13 * 16)) {
            score += points;
            isVis = false;
        }

    }

    static Toast t1 = new Toast(16 * 45, 16 * 2, 3);
    static Toast t2 = new Toast(16 * 72, 16 * 2, 2);
    static Toast t3 = new Toast(16 * 47, 16 * 13, 5);

}

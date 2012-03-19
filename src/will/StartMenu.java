package will;

import javax.swing.*;
import java.awt.*;

public class StartMenu {
    private Image image;
    private Image cursorImage;
    static int x, y;
    static String menuChoice;

    static int STATS, LOG, SAVE, CANCEL, ITEM;

    public StartMenu() {
        ImageIcon ii = new ImageIcon(getClass().getResource("startMenu.png"));
        image = ii.getImage();
        ImageIcon ii2 = new ImageIcon(getClass().getResource("startMenuCursor.png"));
        cursorImage = ii2.getImage();
        x = 270;
        y = 0;
        STATS = 0;
        LOG = 1;
        ITEM = 2;
        SAVE = 3;
        CANCEL = 4;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getMenuImage() {
        return image;
    }

    public Image getCursorImage() {
        return cursorImage;
    }
}
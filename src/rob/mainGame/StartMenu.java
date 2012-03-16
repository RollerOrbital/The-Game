package rob.mainGame;

import javax.swing.*;
import java.awt.*;

public class StartMenu {
    private Image image;
    private Image cursorImage;
    private int x, y;
    private boolean isOpen;

    private int STATS, LOG, SAVE, CANCEL, ITEM;

    public StartMenu() {
        ImageIcon ii = new ImageIcon(getClass().getResource("startMenu.png"));
        image = ii.getImage();
        ImageIcon ii2 = new ImageIcon(getClass().getResource("startMenuCursor.png"));
        cursorImage = ii2.getImage();
        x = 0;
        y = 0;
        isOpen = false;
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


    public void menu() {
        cursorMove();
    }

    public void cursorMove() {
        if (isOpen) {
            cursorSelect();
        }
    }

    public void cursorSelect() {
        if (y == STATS) {

        } else if (y == LOG) {

        } else if (y == ITEM) {

        } else if (y == SAVE) {

        } else if (y == CANCEL) {
            isOpen = false;
        }
    }

}

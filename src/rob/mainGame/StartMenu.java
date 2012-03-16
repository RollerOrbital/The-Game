package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class StartMenu {
    private Image image;
    private Image cursorImage;
    private int x, y;
    public String menuChoice;
    private Room r;

    private int STATS, LOG, SAVE, CANCEL, ITEM;

    public StartMenu() {
        ImageIcon ii = new ImageIcon(getClass().getResource("startMenu.png"));
        image = ii.getImage();
        ImageIcon ii2 = new ImageIcon(getClass().getResource("startMenuCursor.png"));
        cursorImage = ii2.getImage();
        r = new Room();
        x = 300;
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

    public String cursorSelect() {
        String returnThing = "";
        if (y == STATS * 50) {
            returnThing = "You have 100 hp and 100 mp";
        } else if (y == LOG * 50) {
            returnThing = "You have no jobs at the moment";
        } else if (y == ITEM * 50) {
            returnThing = "You have a bandage and a laser";
        } else if (y == SAVE * 50) {
            returnThing = "No save function is implemented yet";
        } else if (y == CANCEL * 50) {
            r.isSmOpen = false;
        }
        return returnThing;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (r.isSmOpen) {
            if (key == KeyEvent.VK_DOWN) {
                y += 50;
            } else if (key == KeyEvent.VK_UP) {
                y -= 50;
            } else if (key == KeyEvent.VK_Z) {
                menuChoice = cursorSelect();
            }
        }
    }
}
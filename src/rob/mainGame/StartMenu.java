package rob.mainGame;

import javax.swing.*;
import java.awt.*;

public class StartMenu {
    private ImageIcon cursor;

    public StartMenu() {
        cursor = new ImageIcon(getClass().getResource("cursor.png"));
    }

    public int getMenuX() {
        return 250;
    }

    public Image getCursorImage() {
        return cursor.getImage();
    }

    public String getMenuAction(int input) {
        if (input == 0) {
            return "You have 100hp and 100mp";
        } else if (input == 1) {
            return "You have a potion and an axe";
        } else if (input == 2) {
            return "You have quests available at the moment";
        } else if (input == 3) {
            return "You have no active quest";
        } else if (input == 4) {
            return "There is no save feature yet";
        } else if (input == 5) {
            Player.isMenuOpen = false;
            return "Cancel";
        } else {
            return "Problem";
        }
    }
}
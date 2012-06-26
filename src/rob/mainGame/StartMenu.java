package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

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

    public String getMenuAction(int input, Player player) {
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
            player.setIsMenuOpen(false);
            return "Cancel";
        } else {
            return "Problem";
        }
    }

    public void drawStartMenu(Graphics g, Player player, ImageObserver imageObserver) {
        g.drawRect(getMenuX() - 1, -11, 112, 202);
        g.setColor(Color.WHITE);
        g.fillRect(getMenuX(), -10, 110, 200);
        g.setColor(Color.BLACK);
        g.drawImage(getCursorImage(), getMenuX() - 32, (player.getCursorPosition() * 30) + 10, imageObserver);
        g.drawString("Stats", getMenuX(), 24);
        g.drawString("Item", getMenuX(), 54);
        g.drawString("Quests", getMenuX(), 84);
        g.drawString("Active Quest", getMenuX(), 114);
        g.drawString("Save", getMenuX(), 144);
        g.drawString("Cancel", getMenuX(), 174);
        if (player.selectedMenuIcon) {
            g.drawString(getMenuAction(player.getCursorPosition(), player), 10, 280);
        }
    }
}
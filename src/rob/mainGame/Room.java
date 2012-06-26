package rob.mainGame;

import java.awt.*;
import java.awt.image.ImageObserver;

public interface Room {
    Rectangle getBounds(Player player);

    void draw(Graphics g, ImageObserver imageObserver, Player player);
}
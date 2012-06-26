package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class TestArea implements Room {
    private final Image image;

    public TestArea() {
        image = (new ImageIcon(getClass().getResource("testArea.png"))).getImage();
    }

    @Override
    public Rectangle getBounds(Player player) {
        return new Rectangle(-player.getX(), -player.getY(), 606, 353);
    }

    @Override
    public void draw(Graphics g, ImageObserver imageObserver, Player player) {
        g.drawImage(image, -player.getX(), -player.getY(), imageObserver);
    }
}

package rob.ToasterQuest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel implements ActionListener {
    private Level level;
    private Tile tile;
    private Kettle k1;
    private Kettle k2;
    private Toast t1;
    private Toast t2;
    private Toast t3;
    public static int lowerBound = -430;

    public Panel() {
        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);

        t1 = Toast.t1;
        t2 = Toast.t2;
        t3 = Toast.t3;
        k1 = Kettle.k1;
        k2 = Kettle.k2;
        tile = new Tile();
        level = new Level();
        Timer timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        //Drawing the map
        g2d.drawImage(level.getImage(), level.getX(), level.getY(), this);
        //Drawing the toast
        g2d.drawImage(t1.getImage(), level.getX() + t1.getX(), level.getY() - lowerBound + 167 - t1.getY(), this);
        g2d.drawImage(t2.getImage(), level.getX() + t2.getX(), level.getY() - lowerBound + 167 - t2.getY(), this);
        g2d.drawImage(t3.getImage(), level.getX() + t3.getX(), level.getY() - lowerBound + 167 - t3.getY(), this);
        //Drawing the player
        g2d.drawImage(level.getPImage(), 204, 130, (200 + 4 + (level.getPWidth() * 2)), (150 + (level.getPHeight() * 2) - 20), level.getSprFrame(), level.getSprDir(), (level.getSprFrame() + level.getPWidth()), (level.getSprDir() + level.getPHeight()), this);
        //Drawing the tiles
        getFloorTiles(g2d);
        getTiles(g2d);
        //Drawing the kettles
        g2d.drawImage(k1.getImage(), level.getX() + k1.getX(), level.getY() - lowerBound + 167 - k1.getY(), this);
        g2d.drawImage(k2.getImage(), level.getX() + k2.getX(), level.getY() - lowerBound + 167 - k2.getY(), this);
        //Drawing the testing Numbers
        g2d.drawString("Height = " + (level.getY() / 16 + 27), 100, 100);
        g2d.drawString("Distance = " + (-level.getX() / 16 + 13), 200, 150);
        //Idk its from Kris
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    private void getFloorTiles(Graphics2D g2d) {
        for (int i = 0; i < 78; i++) {
            g2d.drawImage(tile.getImage(), level.getX() + (i * 16), level.getY() - lowerBound + 167, this);
        }
    }

    private void getTiles(Graphics2D g2d) {
        g2d.drawImage(tile.getImage(), level.getX() + (16 * 16), level.getY() - lowerBound + 167 - 16, this);
        g2d.drawImage(tile.getImage(), level.getX() + (17 * 16), level.getY() - lowerBound + 167 - 16 * 2, this);
        g2d.drawImage(tile.getImage(), level.getX() + (18 * 16), level.getY() - lowerBound + 167 - 16 * 3, this);
        g2d.drawImage(tile.getImage(), level.getX() + (21 * 16), level.getY() - lowerBound + 167 - 16 * 5, this);
        g2d.drawImage(tile.getImage(), level.getX() + (23 * 16), level.getY() - lowerBound + 167 - 16, this);
        g2d.drawImage(tile.getImage(), level.getX() + (36 * 16), level.getY() - lowerBound + 167 - 16, this);
        g2d.drawImage(tile.getImage(), level.getX() + (36 * 16), level.getY() - lowerBound + 167 - 16 * 2, this);
        g2d.drawImage(tile.getImage(), level.getX() + (36 * 16), level.getY() - lowerBound + 167 - 16 * 3, this);
        g2d.drawImage(tile.getImage(), level.getX() + (39 * 16), level.getY() - lowerBound + 167 - 16 * 6, this);
        g2d.drawImage(tile.getImage(), level.getX() + (40 * 16), level.getY() - lowerBound + 167 - 16 * 6, this);
        g2d.drawImage(tile.getImage(), level.getX() + (43 * 16), level.getY() - lowerBound + 167 - 16 * 8, this);
        g2d.drawImage(tile.getImage(), level.getX() + (44 * 16), level.getY() - lowerBound + 167 - 16 * 8, this);
        g2d.drawImage(tile.getImage(), level.getX() + (47 * 16), level.getY() - lowerBound + 167 - 16 * 10, this);
        g2d.drawImage(tile.getImage(), level.getX() + (48 * 16), level.getY() - lowerBound + 167 - 16 * 10, this);
        g2d.drawImage(tile.getImage(), level.getX() + (68 * 16), level.getY() - lowerBound + 167 - 16, this);
        g2d.drawImage(tile.getImage(), level.getX() + (69 * 16), level.getY() - lowerBound + 167 - 16 * 2, this);
        g2d.drawImage(tile.getImage(), level.getX() + (70 * 16), level.getY() - lowerBound + 167 - 16 * 3, this);
        g2d.drawImage(tile.getImage(), level.getX() + (71 * 16), level.getY() - lowerBound + 167 - 16 * 4, this);
        g2d.drawImage(tile.getImage(), level.getX() + (72 * 16), level.getY() - lowerBound + 167 - 16 * 4, this);
    }

    public void actionPerformed(ActionEvent e) {
        if (level.up) {
            level.y += 1;
            if (level.y > level.maxJumpHeight) {
                level.up = false;
                level.y += 1;
                level.canJump = false;
            }
        } else {
            level.y -= 1;
        }
        if (!level.canGoDown) {
            level.canJump = true;
        }
        level.move();
        k2.move();
        k1.move();
        repaint();
    }

    private class adapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            level.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            level.keyReleased(e);
        }
    }
}

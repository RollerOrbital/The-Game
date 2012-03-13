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
    public static int lowerBound = -430;

    public Panel() {
        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);

        tile = new Tile();
        level = new Level();
        Timer timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(level.getImage(), level.getX(), level.getY(), this);
        for (int i = 0; i < 78; i++) {
            g2d.drawImage(tile.getImage(), level.getX() + (i * 16), level.getY() - lowerBound + 167, this);
        }
        tileBounds(g2d);
        g2d.drawImage(level.getPImage(), 204, 130, (200 + 4 + (level.getPWidth() * 2)), (150 + (level.getPHeight() * 2) - 20), level.getSprFrame(), level.getSprDir(), (level.getSprFrame() + level.getPWidth()), (level.getSprDir() + level.getPHeight()), this);
        g2d.drawString("Height = " + level.getY(), 100, 100);
        g2d.drawString("Distance = " + -level.getX(), 100, 150);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    private void tileBounds(Graphics2D g2d) {
        g2d.drawImage(tile.getImage(), level.getX() + (16 * 16), level.getY() - lowerBound + 167 - 16, this);
        g2d.drawImage(tile.getImage(), level.getX() + (17 * 16), level.getY() - lowerBound + 167 - 16 * 2, this);
        g2d.drawImage(tile.getImage(), level.getX() + (18 * 16), level.getY() - lowerBound + 167 - 16 * 3, this);
        g2d.drawImage(tile.getImage(), level.getX() + (21 * 16), level.getY() - lowerBound + 167 - 16 * 5, this);
        g2d.drawImage(tile.getImage(), level.getX() + (23 * 16), level.getY() - lowerBound + 167 - 16, this);
        g2d.drawImage(tile.getImage(), level.getX() + (36 * 16), level.getY() - lowerBound + 167 - 16, this);
        g2d.drawImage(tile.getImage(), level.getX() + (36 * 16), level.getY() - lowerBound + 167 - 16 * 2, this);
        g2d.drawImage(tile.getImage(), level.getX() + (36 * 16), level.getY() - lowerBound + 167 - 16 * 3, this);
        g2d.drawImage(tile.getImage(), level.getX() + (40 * 16), level.getY() - lowerBound + 167 - 16 * 6, this);
        g2d.drawImage(tile.getImage(), level.getX() + (41 * 16), level.getY() - lowerBound + 167 - 16 * 6, this);
        g2d.drawImage(tile.getImage(), level.getX() + (44 * 16), level.getY() - lowerBound + 167 - 16 * 8, this);
        g2d.drawImage(tile.getImage(), level.getX() + (45 * 16), level.getY() - lowerBound + 167 - 16 * 8, this);
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
            level.y += 2;
            if (level.y > level.maxJumpHeight) {
                level.up = false;
                level.y += 2;
                level.canJump = false;
            }
        } else {
            level.y -= 2;
        }
        if (!level.canGoDown) {
            level.canJump = true;
        }
        level.move();
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

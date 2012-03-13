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
        for (int i = 0; i < 38; i++) {
            g2d.drawImage(tile.getImage(), level.getX() + (i * 16), level.getY() - lowerBound + 167, this);
        }
        g2d.drawImage(level.getPImage(), 200 + 4, 150 - 20, (200 + 4 + (level.getPWidth() * 2)), (150 + (level.getPHeight() * 2) - 20), level.getSprFrame(), level.getSprDir(), (level.getSprFrame() + level.getPWidth()), (level.getSprDir() + level.getPHeight()), this);
        g2d.drawString("Height = " + level.getY(), 100, 100);
        g2d.drawString("Distance = " + level.getX(), 100, 150);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
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

package rob.nonMainGames.sideGames.ToasterQuest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel implements ActionListener {
    private Player player;
    private Tile tile;
    public static int lowerBound = -430;

    public Panel() {
        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        tile = new Tile();
        player = new Player();
        Timer timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        //Drawing the map
        g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);
        //Drawing the player
        g2d.drawImage(player.getPImage(), 204, 130, (200 + 4 + (player.getPWidth() * 2)), (150 + (player.getPHeight() * 2) - 20), player.getSprFrame(), player.getSprDir(), (player.getSprFrame() + player.getPWidth()), (player.getSprDir() + player.getPHeight()), this);
        //Drawing the tiles
        getFloorTiles(g2d);
        getTiles(g2d);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    private void getFloorTiles(Graphics2D g2d) {
        for (int i = 0; i < 78; i++) {
            g2d.drawImage(tile.getImage(), player.getX() + (i * 16), player.getY() - lowerBound + 167, this);
        }
    }

    private void getTiles(Graphics2D g2d) {
        g2d.drawImage(tile.getImage(), player.getX() + (16 * 16), player.getY() - lowerBound + 167 - 16, this);
        g2d.drawImage(tile.getImage(), player.getX() + (17 * 16), player.getY() - lowerBound + 167 - 16 * 2, this);
        g2d.drawImage(tile.getImage(), player.getX() + (18 * 16), player.getY() - lowerBound + 167 - 16 * 3, this);
        g2d.drawImage(tile.getImage(), player.getX() + (21 * 16), player.getY() - lowerBound + 167 - 16 * 5, this);
        g2d.drawImage(tile.getImage(), player.getX() + (23 * 16), player.getY() - lowerBound + 167 - 16, this);
        g2d.drawImage(tile.getImage(), player.getX() + (36 * 16), player.getY() - lowerBound + 167 - 16, this);
        g2d.drawImage(tile.getImage(), player.getX() + (36 * 16), player.getY() - lowerBound + 167 - 16 * 2, this);
        g2d.drawImage(tile.getImage(), player.getX() + (36 * 16), player.getY() - lowerBound + 167 - 16 * 3, this);
        g2d.drawImage(tile.getImage(), player.getX() + (39 * 16), player.getY() - lowerBound + 167 - 16 * 6, this);
        g2d.drawImage(tile.getImage(), player.getX() + (40 * 16), player.getY() - lowerBound + 167 - 16 * 6, this);
        g2d.drawImage(tile.getImage(), player.getX() + (43 * 16), player.getY() - lowerBound + 167 - 16 * 8, this);
        g2d.drawImage(tile.getImage(), player.getX() + (44 * 16), player.getY() - lowerBound + 167 - 16 * 8, this);
        g2d.drawImage(tile.getImage(), player.getX() + (47 * 16), player.getY() - lowerBound + 167 - 16 * 10, this);
        g2d.drawImage(tile.getImage(), player.getX() + (48 * 16), player.getY() - lowerBound + 167 - 16 * 10, this);
        g2d.drawImage(tile.getImage(), player.getX() + (68 * 16), player.getY() - lowerBound + 167 - 16, this);
        g2d.drawImage(tile.getImage(), player.getX() + (69 * 16), player.getY() - lowerBound + 167 - 16 * 2, this);
        g2d.drawImage(tile.getImage(), player.getX() + (70 * 16), player.getY() - lowerBound + 167 - 16 * 3, this);
        g2d.drawImage(tile.getImage(), player.getX() + (71 * 16), player.getY() - lowerBound + 167 - 16 * 4, this);
        g2d.drawImage(tile.getImage(), player.getX() + (72 * 16), player.getY() - lowerBound + 167 - 16 * 4, this);
    }

    public void actionPerformed(ActionEvent e) {
        player.move();
        repaint();
    }

    private class adapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }
    }
}

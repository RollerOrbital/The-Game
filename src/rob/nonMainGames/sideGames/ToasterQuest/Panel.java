package rob.nonMainGames.sideGames.ToasterQuest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel implements ActionListener {
    private final Player player;
    private final Map map;

    public Panel() {
        addKeyListener(new Adapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        player = new Player();
        map = new Map();
        Timer timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(map.getImage(), -player.getX(), -player.getY(), this);
        player.draw(g, this);
        for (Tile tile : Tile.tiles) {
            g.drawImage(tile.getImage(), -player.getX() + tile.getX() + 203, -player.getY() + tile.getY() + 172, this);
        }
        g.drawString("X         = " + player.getX(), 100, 100);
        g.drawString("Y         = " + player.getY(), 100, 110);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        player.move();
        repaint();
    }

    private class Adapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }
    }
}
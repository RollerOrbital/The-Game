package rob.nonMainGames.sideGames.ToasterQuest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel implements ActionListener {
    private Player player;

    public Panel() {
        addKeyListener(new Adapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        player = new Player();
        Timer timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        player.draw(g, this);
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

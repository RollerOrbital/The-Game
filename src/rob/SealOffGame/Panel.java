package rob.SealOffGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel implements ActionListener {
    private Player player;

    public Panel() {
        player = new Player();
        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        Timer timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(player.getPowImage(), player.getX(), 200, this);
        g2d.drawString("X = " + player.getX(), 100, 150);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
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

package rob.SealOffGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel implements ActionListener {
    private Player player;
    private Enemy enemy;

    public Panel() {
        player = new Player();
        enemy = new Enemy();
        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        Timer timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        ImageIcon ii = new ImageIcon(getClass().getResource("jimsKebabs.png"));
        Image stage = ii.getImage();
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(stage, 0, 0, this);
        g2d.drawImage(enemy.getImage(), enemy.getX(), 150, this);
        g2d.drawImage(player.getImage(), player.getX(), 150, this);
        g2d.drawString("X = " + player.getX(), 100, 150);
        g2d.drawString(" Your Health = " + lowerZero(Player.health), 50, 50);
        g2d.drawString("Enemy Health = " + lowerZero(enemy.health), 200, 50);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    private int lowerZero(int x) {
        if (x <= 0) {
            return 0;
        } else {
            return x;
        }
    }

    public void actionPerformed(ActionEvent e) {
        player.move();
        enemy.move();
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

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
        ImageIcon ii = new ImageIcon(getClass().getResource("jimKebabs.png"));
        Image stage = ii.getImage();
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(stage, 0, 0, this);
        g2d.drawImage(enemy.getImage(), enemy.getX(), 150, this);
        g2d.drawImage(player.getImage(), player.getX(), 150, this);
        g2d.setColor(Color.RED);
        g2d.fill(new Rectangle(10, 5, Player.health / 10, 20));
        g2d.fill(new Rectangle(250, 5, Enemy.health / 10, 20));
        g2d.setColor(Color.BLACK);
        g2d.drawString("PLAYER HEALTH", 10, 20);
        g2d.drawString("ENEMY HEALTH", 250, 20);
        g2d.drawString("X = " + player.getX(), 100, 150);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        player.move();
        enemy.move();
        repaint();
    }

    private class adapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
            enemy.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
            enemy.keyReleased(e);
        }
    }
}
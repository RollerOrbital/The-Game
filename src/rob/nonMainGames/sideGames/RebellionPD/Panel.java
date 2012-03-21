package rob.nonMainGames.sideGames.RebellionPD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel implements ActionListener {
    private Player player;
    private Bullet bullet;
    private int WIDTH, HEIGHT;
    private int Y, X;

    public Panel() {
        Y = 150;
        X = 50;
        WIDTH = 42;
        HEIGHT = 35;
        player = new Player();
        bullet = new Bullet();
        addKeyListener(new Adapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setVisible(true);
        setDoubleBuffered(true);
        Timer timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D d = (Graphics2D) g;
        if (player.isChoosing) {
            d.drawString("Which character will you be?:", 100, 50);
            d.setColor(Color.RED);
            d.drawString("LIBYAN REBEL", 300, 100);
            d.drawImage(player.libya.getImage(), 300, Y, 300 + HEIGHT * 2, Y + WIDTH * 2, player.getFrame(), player.getCrouching(), player.getFrame() + WIDTH, player.getCrouching() + HEIGHT, this);
            d.setColor(Color.BLUE);
            d.drawString("GOVERNMENT SNIPER", 150, 100);
            //d.drawImage(player.gov.getImage(), 5, 120, this);
            d.setColor(Color.GREEN);
            d.drawString("EGYPTIAN PROTESTER", 5, 100);
            //d.drawImage(player.egypt.getImage(), 5, 120, this);
            d.setColor(Color.BLACK);
            d.drawString("Press \"E\"", 5, 120);
            d.drawString("Press \"G\"", 150, 120);
            d.drawString("Press \"L\"", 300, 120);
        } else {
            d.drawImage(player.getImage(), X, Y, X + HEIGHT * 2, Y + WIDTH * 2, player.getFrame(), player.getCrouching(), player.getFrame() + WIDTH, player.getCrouching() + HEIGHT, this);
            if (bullet.getX() > 100) {
                if (player.crouching == player.STAND) {
                    if (bullet.getX() < 400) {
                        d.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), this);
                    }
                } else {
                    if (bullet.getX() < 400) {
                        d.drawImage(bullet.getImage(), bullet.getX(), bullet.getY() - 15, this);
                    }
                }
            }
        }
        if (bullet.getX() > 400) {
            bullet = new Bullet();
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        player.move();
        bullet.move();
        repaint();
    }

    private class Adapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
            bullet.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }
    }
}

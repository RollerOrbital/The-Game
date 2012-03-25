package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel implements ActionListener {
    private Player player;

    public Panel() {
        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        player = new Player();
        Timer timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(player.getImage(), player.getX(), player.getY(), player.getX() + player.getWidth() * 2, player.getY() + player.getHeight() * 2, player.getFrame(), player.getDirection(), player.getFrame() + player.getWidth(), player.getDirection() + player.getHeight(), this);
        if (player.isMenuOpen) {
            StartMenu startMenu = new StartMenu();
            g2d.drawRect(startMenu.getMenuX(), 10, 400 - 290, 150);
            g2d.drawImage(startMenu.getCursorImage(), startMenu.getMenuX(), startMenu.getCursorPosition(), this);
//            g2d.drawString(player.menuAction, startMenu.getMenuX() - 50, 50);
        }
        g2d.drawString("X = " + player.getX(), 100, 100);
        g2d.drawString("Y = " + player.getY(), 100, 130);
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
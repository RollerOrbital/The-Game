package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel implements ActionListener {
    private final Player player;

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
        player.draw(g, this);
        if (player.isMenuOpen) {
            StartMenu startMenu = new StartMenu();
            g.drawRect(startMenu.getMenuX(), 10, 400 - 290, 150);
            g.drawImage(startMenu.getCursorImage(), startMenu.getMenuX(), startMenu.getCursorPosition(), this);
//            g2d.drawString(player.menuAction, startMenu.getMenuX() - 50, 50);
        }
        g.drawString("X = " + player.getX(), 100, 100);
        g.drawString("Y = " + player.getY(), 100, 130);
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
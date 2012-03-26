package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel {
    private final Player player;

    public Panel() {
        player = new Player();
        addKeyListener(player.keyListener());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        Timer timer = new Timer(5, new PlayerMove());
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        player.draw(g, this);
        if (player.isMenuOpen) {
            StartMenu startMenu = new StartMenu();
            g.drawRect(startMenu.getMenuX(), 10, 400 - 290, 150);
            g.drawImage(startMenu.getCursorImage(), startMenu.getMenuX(), startMenu.getCursorPosition(), this);
        }
        g.drawString("X = " + player.getX(), 100, 100);
        g.drawString("Y = " + player.getY(), 100, 130);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    private class PlayerMove implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            player.move();
            repaint();
        }
    }
}
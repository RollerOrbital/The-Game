package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel {
    private final Player player;
    private final Map map;

    public Panel() {
        map = new Map();
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
        Graphics2D d = (Graphics2D) g;
        g.drawImage(map.getTestArea(), -player.getX(), -player.getY(), this);
        new Idroid(0, -player.getX() + 100, -player.getY() + 100, 0).drawIdroid(g, this);
        player.drawPlayer(g, this);
        if (Player.isMenuOpen) {
            StartMenu startMenu = new StartMenu();
            startMenu.drawStartMenu(g, d, player, this);
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
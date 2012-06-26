package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel {
    private final Player player;
    private final TestArea testArea;

    public Panel() {
        player = new Player();
        testArea = new TestArea();
        addKeyListener(player.keyListener());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        Timer timer = new Timer(5, new PlayerMove());
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        testArea.draw(g, this, player);
        player.draw(g, this);
        getStartMenu(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 270, 400, 30);
        g.drawString("X = " + player.getX(), 100, 100);
        g.drawString("Y = " + player.getY(), 100, 130);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    private void getStartMenu(Graphics g) {
        if (player.isMenuOpen) {
            StartMenu startMenu = new StartMenu();
            startMenu.drawStartMenu(g, player, this);
        }
    }

    private class PlayerMove implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            player.move();
            repaint();
        }
    }
}
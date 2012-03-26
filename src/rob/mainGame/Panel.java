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
        if (Player.isMenuOpen) {
            StartMenu startMenu = new StartMenu();
            g.drawRect(startMenu.getMenuX(), -10, 110, 200);
            g.drawImage(startMenu.getCursorImage(), startMenu.getMenuX() - 32, (player.getCursorPosition() * 30) + 10, this);
            g.drawString("Stats", startMenu.getMenuX(), 24);
            g.drawString("Item", startMenu.getMenuX(), 54);
            g.drawString("Quests", startMenu.getMenuX(), 84);
            g.drawString("Active Quest", startMenu.getMenuX(), 114);
            g.drawString("Save", startMenu.getMenuX(), 144);
            g.drawString("Cancel", startMenu.getMenuX(), 174);
            if (player.selectedMenuIcon) {
                g.drawString(startMenu.getMenuAction(player.getCursorPosition()), startMenu.getMenuX() - 100, player.getCursorPosition() * 30 + 10);
            }
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
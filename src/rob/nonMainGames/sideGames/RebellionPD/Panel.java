package rob.nonMainGames.sideGames.RebellionPD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel implements ActionListener {
    static String charChoice;
    private Player player;
    private int WIDTH, HEIGHT;
    private int Y, X;

    public Panel() {
        Y = 150;
        X = 50;
        WIDTH = 42;
        HEIGHT = 35;
        player = new Player();
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
            d.setColor(Color.BLUE);
            d.drawString("GOVERNMENT SNIPER", 150, 100);
            d.setColor(Color.GREEN);
            d.drawString("EGYPTIAN PROTESTER", 5, 100);
            d.setColor(Color.BLACK);
            d.drawString("Press \"E\"", 5, 120);
            d.drawString("Press \"G\"", 150, 120);
            d.drawString("Press \"L\"", 300, 120);
        } else {
            d.drawImage(player.getImage(), X, Y, X + HEIGHT * 2, Y + WIDTH * 2, player.getFrame(), player.getCrouching(), player.getFrame() + WIDTH, player.getCrouching() + HEIGHT, this);
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        player.move();
        repaint();
    }

    private class Adapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }
    }
}

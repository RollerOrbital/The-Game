package rob.mazeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements ActionListener {

    private Player player;
    private Maze maze;
    String win = "";

    public Board() {
        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        maze = new Maze();
        player = new Player();

        Timer timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        g2d.drawImage(maze.getImage(), maze.getX(), maze.getY(), this);
        g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);
        g2d.drawString("P = " + Player.x + ", " + Player.y, 100, 100);
        g2d.drawString("" + (lowerZero(1000 - Player.fouls)), 50, 100);
        g2d.drawString(win, 50, 200);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        player.move();
        if (Player.x > 600 && Player.x < 740 && Player.y > 250 && Player.y < 400) {
            win = "YOU WIN, YOUR SCORE WAS " + (lowerZero(1000 - Player.fouls));
        }
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

    private int lowerZero(int x) {
        if (x < 0) {
            return 0;
        } else {
            return x;
        }
    }
}
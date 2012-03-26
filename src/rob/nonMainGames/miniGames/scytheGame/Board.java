package rob.nonMainGames.miniGames.scytheGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements ActionListener {

    private Scythe1 s1;
    private Scythe2 s2;
    private Player player;
    private Maze maze;
    String win = "";

    public Board() {
        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        s2 = new Scythe2();
        s1 = new Scythe1();
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
        g2d.drawImage(player.getImage(), player.getX() + 4, player.getY() - 20, (player.getX() + 4 + (player.getWidth() * 2)), (player.getY() + (player.getHeight() * 2) - 20), player.getSprFrame(), player.getSprDir(), (player.getSprFrame() + player.getWidth()), (player.getSprDir() + player.getHeight()), this);
        g2d.drawImage(s1.getImage(), s1.getX(), s1.getY(), this);
        g2d.drawImage(s2.getImage(), s2.getX(), s2.getY(), this);
        g2d.drawString(("Position = " + player.getX() + ", " + player.getY()), 10, 315);
        g2d.drawString("" + lowerZero(1000 - Player.fouls), 50, 100);
        g2d.drawString(win, 50, 200);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        player.move();
        s1.move();
        s2.move();
        if (Math.abs(player.x - Scythe1.x) < 40 && Math.abs(player.y - Scythe1.y) < 40) {
            Player.fouls += 3;
        }
        if (Math.abs(player.x - Scythe2.x) < 40 && Math.abs(player.y - Scythe2.y) < 40) {
            Player.fouls += 3;
        }

        if (player.x > 600 && player.x < 740 && player.y > 250 && player.y < 400) {
            final int score = 1000 - Player.fouls;
            win = "YOU WIN, YOUR SCORE WAS " + lowerZero(score);
            Scythe1.x = -90;
            Scythe2.x = -90;
            s1.dx = 0;
            s1.dy = 0;
            s2.dx = 0;
            s2.dy = 0;
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
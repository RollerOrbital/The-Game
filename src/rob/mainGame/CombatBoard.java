package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CombatBoard extends JPanel implements ActionListener {

    public static Player player;
    private Enemy enemy;
    private BoardImage board;
    public static CombatCursor cursor;

    public CombatBoard() {
        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        player = new Player();
        enemy = new Enemy();
        board = new BoardImage();
        cursor = new CombatCursor();

        Timer timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(board.getImage(), board.getX(), board.getY(), this);
        g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);
        g2d.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);
        g2d.drawImage(cursor.getImage(), cursor.getX(), cursor.getY(), this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        cursor.move();
        repaint();
    }

    private class adapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
            cursor.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
            cursor.keyReleased(e);
        }
    }
}
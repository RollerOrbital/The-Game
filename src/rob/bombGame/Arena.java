package rob.bombGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Arena extends JPanel implements ActionListener {

    private Player player;
    private Bomb bomb;

    public Arena() {
        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);

        player = new Player();

        bomb = new Bomb();

        Timer timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);
        g2d.drawImage(bomb.getImage(), bomb.getX(), bomb.getY(), this);
        g2d.drawString("YOUR SCORE: " + player.score, 100, 100);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        bomb.move();
        player.move();
        if (Player.bombs <= 10) {
            if (Math.abs(player.x - bomb.x) < 5) {
                if (Math.abs(player.y - bomb.y) < 20) {
                    Player.score++;
                }
                Player.bombs++;
                bomb = new Bomb();
            }
            repaint();
        }
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

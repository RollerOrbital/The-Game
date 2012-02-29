package rob.bombGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Arena extends JPanel implements ActionListener {
    private Player player;
    private GoodSoul goodSoul;
    private BadSoul badSoul;

    public Arena() {
        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);

        player = new Player();
        goodSoul = new GoodSoul();
        badSoul = new BadSoul();

        Timer timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(goodSoul.getImage(), goodSoul.getX(), goodSoul.getY(), this);
        g2d.drawImage(badSoul.getImage(), badSoul.getX(), badSoul.getY(), this);
        g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);
        g2d.drawString("YOUR SCORE: " + Player.score, 100, 100);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        badSoul.move();
        goodSoul.move();
        player.move();
        if (Math.abs(player.x - GoodSoul.x) <= 15 && Math.abs(player.y - GoodSoul.y) <= 15) {
            Player.score++;
            new GoodSoul();
        } else if (GoodSoul.x >= 600) {
            new GoodSoul();
        }
        if (Math.abs(player.x - BadSoul.x) <= 15 && Math.abs(player.y - BadSoul.y) <= 15) {
            Player.score--;
            new BadSoul();
        } else if (BadSoul.x >= 600) {
            new BadSoul();
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
}
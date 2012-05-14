package rob.nonMainGames.miniGames.catcherGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Panel extends JPanel implements ActionListener {
    private Player player;
    private GoodSoul goodSoul;
    private BadSoul badSoul;
    Random random = new Random();

    public Panel() {
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
        ImageIcon ii = new ImageIcon(getClass().getResource("background.png"));
        Image back = ii.getImage();
        g2d.drawImage(back, 0, 0, this);
        g2d.drawImage(goodSoul.getImage(), goodSoul.getX(), goodSoul.getY(), this);
        g2d.drawImage(badSoul.getImage(), badSoul.getX(), badSoul.getY(), this);
        g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);
        g2d.drawString("YOUR SCORE: " + GoodSoul.lowerZero(Player.score), 100, 100);
        if (Player.score >= 10) {
            g2d.drawString("YOU WON!", 100, 125);
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        badSoul.move();
        goodSoul.move();
        player.move();
        if (Player.score < 10) {
            if (Math.abs(player.x - GoodSoul.x) <= 25 && Math.abs(player.y - GoodSoul.y) <= 25) {
                Player.score++;
                new GoodSoul();
                goodSoul.dx = GoodSoul.lowerOne(random.nextInt(4));
                goodSoul.dy = GoodSoul.lowerOne(random.nextInt(4));
            } else if (GoodSoul.x >= 700) {
                new GoodSoul();
                goodSoul.dx = GoodSoul.lowerOne(random.nextInt(4));
                goodSoul.dy = GoodSoul.lowerOne(random.nextInt(4));
            }
            if (Math.abs(player.x - BadSoul.x) <= 25 && Math.abs(player.y - BadSoul.y) <= 25) {
                Player.score--;
                new BadSoul();
                badSoul.dx = GoodSoul.lowerOne(random.nextInt(4));
                badSoul.dy = GoodSoul.lowerOne(random.nextInt(4));
            } else if (BadSoul.x >= 700) {
                new BadSoul();
                badSoul.dx = GoodSoul.lowerOne(random.nextInt(4));
                badSoul.dy = GoodSoul.lowerOne(random.nextInt(4));
            }
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
package pierce.Liberation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Arena extends JPanel implements ActionListener {
    private Player player;
    private GoodSoul goodSoul;
    private BadSoul badSoul;
    private Foreground foreground;
    private Bullet bullet;
    private Image image;
    Random random = new Random();

    public Arena() {
        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);

        player = new Player();
        goodSoul = new GoodSoul();
        badSoul = new BadSoul();
        foreground = new Foreground();
        bullet = new Bullet();
        ImageIcon i = new ImageIcon(this.getClass().getResource("liberationsheet.png"));
        image = i.getImage();

        Timer timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        int fontSize = 20;

        g.setFont(new Font("Courier", Font.PLAIN, fontSize));

        g.setColor(Color.yellow);

        /*Background*/
        g2d.drawImage(image, 0, 0, (154 * 4) + 16, (80 * 4) + 37 * 4, 0, 92, 154, 172, this);
        /*Foreground1*/
        g2d.drawImage(image, foreground.getX(), foreground.getY(), (foreground.getX() + (154 * 4)), (foreground.getY() + (33 * 4)), 0, 59, 154, 59 + 33, this);
        /*Foreground2*/
        g2d.drawImage(image, foreground.getX() - (154 * 4), foreground.getY(), (foreground.getX()), (foreground.getY() + (33 * 4)), 0, 59, 154, 59 + 33, this);
        /*Foreground4*/
        g2d.drawImage(image, foreground.getX() + (154 * 4), foreground.getY(), (foreground.getX() + (154 * 8)), (foreground.getY() + (33 * 4)), 0, 59, 154, 59 + 33, this);
        /*Child*/
        g2d.drawImage(image, goodSoul.getX(), goodSoul.getY(), (goodSoul.getX() + 23 * 4), (goodSoul.getY() + 25 * 4), player.getFrame() + 46, 34, player.getFrame() + 23 + 46, 59, this);
        /*Enemy*/
        g2d.drawImage(image, badSoul.getX(), badSoul.getY(), (badSoul.getX() + 23 * 4), (badSoul.getY() + 25 * 4), player.getFrame() + (46 * 2), 34, player.getFrame() + 23 + (46 * 2), 59, this);
        /*Bullet*/
        g2d.drawImage(image, bullet.getX(), bullet.getY(), (bullet.getX() + 4 * 4), (bullet.getY() + 4 * 4), 176, 2, 180, 6, this);
        if (Player.health > 0) {
            /*Player*/
            g2d.drawImage(image, player.getX(), player.getY(), (player.getX() + 23 * 4), (player.getY() + 25 * 4), player.getFrame(), 34, player.getFrame() + 23, 59, this);
        }
        /*Saves*/
        g2d.drawString("SAVES: " + GoodSoul.lowerZero(Player.score), 16, 30);
        /*Kills*/
        g2d.drawString("KILLS: " + GoodSoul.lowerZero(Player.souls), (154 * 4) - 112, 30);
        /*Saves*/
        g2d.drawString("HEALTH: " + GoodSoul.lowerZero(Player.health), 16, 60);
        /*Bullets*/
        g2d.drawString("AMMO: " + GoodSoul.lowerZero(Player.bullets), (154 * 4) - 112, 60);
        /*Logo*/
        g2d.drawImage(image, 30 * 4 + 16, 8, (117 * 4) + 16, (20 * 4) - 8, 0, 0, 173, 33, this);

        if (Player.health == 0) {
            g2d.drawString("You have done the best you can, and saved " + GoodSoul.lowerZero(Player.score) + " children from", 16 + 24, 90);
            g2d.drawString("Kony's grasp. You have taken " + GoodSoul.lowerZero(Player.souls) + " lives away,", 16 + 82, 120);
            g2d.drawString("but you did what you had to do.", 16 + 139, 150);
            g2d.drawString("Press Spacebar to restart", 232 - 39, 405);
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        badSoul.move();
        goodSoul.move();
        player.move();
        bullet.move();
        if (Player.health > 0) {
            foreground.move();
            if (Math.abs(player.x - GoodSoul.x) <= 25 && Math.abs(player.y - GoodSoul.y) <= 25) {
                Player.score++;
                new GoodSoul();
                goodSoul.dx = (GoodSoul.lowerOne(random.nextInt(4)) * -1);
            } else if (Math.abs(Bullet.x - GoodSoul.x) <= 25 && Math.abs(Bullet.y - (GoodSoul.y + 64)) <= 25) {
                Player.souls++;
                if (Player.score - 1 >= 0) {
                    Player.score--;
                }
                new GoodSoul();
                new Bullet();
                Bullet.x = 1337;
                goodSoul.dx = (GoodSoul.lowerOne(random.nextInt(4)) * -1);
            } else if (GoodSoul.x <= -23 * 4) {
                new GoodSoul();
                goodSoul.dx = (GoodSoul.lowerOne(random.nextInt(4)) * -1);
            }
            if (Math.abs(player.x - BadSoul.x) <= 25 && Math.abs(player.y - BadSoul.y) <= 25) {
                Player.health--;
                new BadSoul();
                badSoul.dx = (GoodSoul.lowerOne(random.nextInt(4)) * -1);
            } else if (Math.abs(Bullet.x - BadSoul.x) <= 25 && Math.abs(Bullet.y - (BadSoul.y + 52)) <= 25) {
                Player.souls++;
                new BadSoul();
                new Bullet();
                Bullet.x = 1337;
                badSoul.dx = (GoodSoul.lowerOne(random.nextInt(4)) * -1);
            } else if (BadSoul.x <= -23 * 4) {
                new BadSoul();
                badSoul.dx = (GoodSoul.lowerOne(random.nextInt(4)) * -1);
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
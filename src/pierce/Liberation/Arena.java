package pierce.Liberation;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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

    public static synchronized void playSound(final String string) {
        new Thread(
                new Runnable() {
                    public void run() {
                        try {
                            Clip clip = AudioSystem.getClip();
                            AudioInputStream inputStream = AudioSystem.getAudioInputStream(MainClass.class.getResource(string));
                            clip.open(inputStream);
                            clip.start();
                        } catch (Exception e) {
                            System.out.println("No clip found");
                        }
                    }
                }
        )
                .start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        int fontSize = 20;

        g.setFont(new Font("Courier", Font.PLAIN, fontSize));

        g.setColor(Color.yellow);

        /*Background*/
        g2d.drawImage(image, 0, 0, (154 * 4) + 16, (80 * 4) + 37 * 4, 0, 92, 154, 172, this);
        /*Foreground*/
        g2d.drawImage(image, foreground.getX(), foreground.getY(), (foreground.getX() + (154 * 4)), (foreground.getY() + (33 * 4)), 0, 59, 154, 59 + 33, this);
        g2d.drawImage(image, foreground.getX() - (154 * 4), foreground.getY(), (foreground.getX()), (foreground.getY() + (33 * 4)), 0, 59, 154, 59 + 33, this);
        g2d.drawImage(image, foreground.getX() + (154 * 4), foreground.getY(), (foreground.getX() + (154 * 8)), (foreground.getY() + (33 * 4)), 0, 59, 154, 59 + 33, this);
        /*Logo*/
        g2d.drawImage(image, 30 * 4 + 16, 8, (117 * 4) + 16, (20 * 4) - 8, 0, 0, 173, 33, this);
        if (!player.titlescreen) {
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

            if (Player.health == 0) {
                g2d.drawString("You have done the best you can, and saved " + GoodSoul.lowerZero(Player.score) + " children from", 24 + 16, 90);
                g2d.drawString("Kony's grasp. You have taken " + GoodSoul.lowerZero(Player.souls) + " lives away,", 16 + 82, 120);
                g2d.drawString("but you did what you had to do.", 16 + 139, 150);
                g2d.drawString("Press right to restart", 232 - 25, 405);
            }
        } else {
            /*Controls*/
            g2d.drawImage(image, 40, 281 - 32, 40 + (32 * 4), 281 + (41 * 4) - 32, 154, 59, 154 + 32, 59 + 41, this);
            g2d.drawImage(image, 464, 281 - 32, 592, 281 + (41 * 4) - 32, 154, 59 + 41, 154 + 32, 59 + 82, this);
            g2d.drawString("You are an American soldier solicited to save as many children", 24 + 16, 90);
            g2d.drawString("as possible from the grasp of Kony. You are", 16 + 82, 120);
            g2d.drawString("allowed to use force, but you shouldn't.", 139, 150);
            g2d.drawString("Press right to start", 232 - 17, 405);
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        if (!player.titlescreen) {
            badSoul.move();
            goodSoul.move();
            player.move();
            bullet.move();
            if (Player.health > 0) {
                foreground.move();
                if (Math.abs(player.x - GoodSoul.x) <= 25 && Math.abs(player.y - GoodSoul.y) <= 25) {
                    Player.score++;
                    new GoodSoul();
                    goodSoul.dx = (GoodSoul.lowerOne(random.nextInt(4)) * -1) - 1;
                    playSound("save.wav");
                } else if (Math.abs(Bullet.x - GoodSoul.x) <= 25 && Math.abs(Bullet.y - (GoodSoul.y + 64)) <= 25) {
                    Player.souls++;
                    if (Player.score - 1 >= 0) {
                        Player.score--;
                    }
                    new GoodSoul();
                    new Bullet();
                    Bullet.x = 1337;
                    goodSoul.dx = (GoodSoul.lowerOne(random.nextInt(4)) * -1) - 1;
                    playSound("enemydie.wav");
                } else if (GoodSoul.x <= -23 * 4) {
                    new GoodSoul();
                    goodSoul.dx = (GoodSoul.lowerOne(random.nextInt(4)) * -1) - 1;
                }
                if (Math.abs(player.x - BadSoul.x) <= 25 && Math.abs(player.y - BadSoul.y) <= 25) {
                    Player.health--;
                    new BadSoul();
                    badSoul.dx = (GoodSoul.lowerOne(random.nextInt(4)) * -1) - 1;
                    if (Player.health < 0) {
                        playSound("hurt.wav");
                    } else {
                        playSound("deathplayer.wav");
                    }
                } else if (Math.abs(Bullet.x - BadSoul.x) <= 25 && Math.abs(Bullet.y - (BadSoul.y + 52)) <= 25) {
                    Player.souls++;
                    new BadSoul();
                    new Bullet();
                    Bullet.x = 1337;
                    badSoul.dx = (GoodSoul.lowerOne(random.nextInt(4)) * -1) - 1;
                    playSound("enemydie.wav");
                } else if (BadSoul.x <= -23 * 4) {
                    new BadSoul();
                    badSoul.dx = (GoodSoul.lowerOne(random.nextInt(4)) * -1) - 1;
                }
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
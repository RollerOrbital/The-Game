package rob.nonMainGames.sideGames.RebellionPD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel implements ActionListener {
    private Player player;
    private Bullet bullet;
    private Enemy enemy;
    private int WIDTH, HEIGHT;
    private int Y, X;
    public static int textSlide;

    public Panel() {
        Y = 150;
        X = 50;
        WIDTH = 42;
        HEIGHT = 35;
        player = new Player();
        bullet = new Bullet();
        enemy = new Enemy();
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
        ImageIcon fbg = new ImageIcon(getClass().getResource("firstBackground.png"));
        ImageIcon sbg = new ImageIcon(getClass().getResource("secondBackground.png"));
        ImageIcon tbg = new ImageIcon(getClass().getResource("thirdBackground.png"));
        if (player.isChoosing) {
            titleScreen(d);
        } else {
            getBackground(d, fbg, sbg, tbg);
            d.drawImage(player.getImage(), X, Y, X + HEIGHT * 2, Y + WIDTH * 2, player.getFrame(), player.getCrouching(), player.getFrame() + WIDTH, player.getCrouching() + HEIGHT, this);
            getBullet(d);
            d.drawImage(enemy.getImage(), enemy.getX(), Y, enemy.getX() + HEIGHT * 2, Y + WIDTH * 2, enemy.getFrame(), enemy.getCrouching(), enemy.getFrame() + WIDTH, enemy.getCrouching() + HEIGHT, this);
            if (enemy.getX() < X) {
                enemy = new Enemy();
            } else if ((Math.abs(bullet.getX() - enemy.getX()) < 5) && didHit()) {
                enemy = new Enemy();
                bullet = new Bullet();
                player.kills++;
            }
        }
        if (bullet.getX() > 400) {
            bullet = new Bullet();
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    private void getBackground(Graphics2D d, ImageIcon fbg, ImageIcon sbg, ImageIcon tbg) {
        d.setFont(new Font("Courier", Font.PLAIN, 10));
        String[] slides = new String[]{"THE ARAB SPRING INTERACTIVE", "PRESENTATION", "BY ROBM AND KEMH", "WE WILL COVER THE COUNTRIES",
                "EGYPT, LIBYA AND SYRIA", "WE HOPE YOU ENJOY :)", "IN EGYPT THE ARMY REFUSES", "TO FIGHT WHICH MEANS THAT", "THE PEOPLE OF EGYPT WERE FREE",
                "TO PROTEST ABOUT THE OPPRESSIVE", "REGIME OF ", "MUHAMMED HOSNI EL SAYED MUBARAK.", "MUBARAK STEPS DOWN WITHIN",
                "A FEW MONTHS DUE TO", "PROTESTS AND INTERNATIONAL", "PRESSURE.", "EGYPT IS AN EXCELLENT", "EGYPT IS AN EXCELLENT",
                "EXAMPLE OF POPULAR", "DEMONSTRATION BRINGING", "ABOUT JUSTICE AND DEMOCRACY.", "HOWEVER IN LIGHT OF THIS",
                "SUCCESS THERE WAS VIOLENCE", "DURING THE TIME BEFORE", "MUBARAK'S RESIGNATION AND", "PEOPLE DID DIE.",
                "ALSO THE MUSLIM BROTHERHOOD", "-BELIEVED TO BE LINKED WITH", "AL-QAEDA DID BECOME POPULAR", "WHICH COULD HAVE BECOME A",
                "SECURITY THREAT", "OVERALL IN EGYPT THE RESULT", "WAS POSITIVE FOR THE PEOPLE", "AND FOR JUSTICE", "IN LIBYA THE CONFLICT",
                "WAS MORE VIOLENT.", "ALTHOUGH GADDAFI DID", "HEAVILY USE PROPAGANDA", "HIS USE OF THE MILITARY", "WAS MORE VISIBLE", "TO US LOOKING AT OUR",
                "TELEVISIONS.", "THE BATTLE BETWEEN THE REBEL", "FORCES AND THE GOVERNMENT", "FORCES WAS FOUGHT", "IN A GUERRILLA SURROUNDING",
                "THIS MEANT THAT NUMBERS", " WERE LESS IMPORTANT IN THE", "CONFLICT WHICH IS WHY AT", "THE BEGINNING THE REBELS",
                "WERE ABLE TO STAY 'IN IT'", "AFTER THIS IN AREAS", "LIKE TRIPOLI", "THE FIGHTING BECAME MORE", "INTENSE AND THE", "REBELS SEEMED TO BE",
                "SO CLOSE TO VICTORY", "FOR SO LONG", "THE TEMPO OF THE FIGHTING", "SLOWED CONSIDERABLY", "TOWARDS THE END OF", "THE FIGHTING.",
                "Libya was a success in terms", "of overthrowing the old government", ",however the way in which it", "did it caused many people to", "lose their lives.",
        };
        if (player.kills < 20) {
            d.drawImage(fbg.getImage(), 3, 3, this);
            d.drawString(slides[textSlide], 90, 80);
        } else if (player.kills >= 20 && player.kills < 40) {
            d.drawImage(sbg.getImage(), 0, 0, this);
            d.drawString(slides[textSlide], 85, 20);
        } else if (player.kills >= 40 && player.kills < 50) {
            d.drawImage(tbg.getImage(), 0, 0, this);
            d.drawString(slides[textSlide], 100, 70);
        } else {
            d.drawImage(fbg.getImage(), 0, 0, this);
            d.drawString(slides[textSlide], 90, 80);
        }
    }

    private boolean didHit() {
        return (enemy.getCrouching() / 35 == player.crouching || enemy.getCrouching() / 35 == player.crouching);
    }

    private void getBullet(Graphics2D d) {
        if (bullet.getX() > 95 && bullet.getX() < 400) {
            d.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), this);
        }
    }

    private void titleScreen(Graphics2D d) {
        d.drawString("Which character will you be?:", 100, 50);
        d.setColor(Color.RED);
        d.drawString("LIBYAN REBEL", 300, 100);
        d.drawImage(player.libya.getImage(), 300, Y, 300 + HEIGHT * 2, Y + WIDTH * 2, player.getFrame(), player.getCrouching(), player.getFrame() + WIDTH, player.getCrouching() + HEIGHT, this);
        d.setColor(Color.BLUE);
        d.drawString("GOVERNMENT SNIPER", 150, 100);
        //d.drawImage(player.gov.getImage(), 300, Y, 300 + HEIGHT * 2, Y + WIDTH * 2, player.getFrame(), player.getCrouching(), player.getFrame() + WIDTH, player.getCrouching() + HEIGHT, this);
        d.setColor(Color.GREEN);
        d.drawString("EGYPTIAN PROTESTER", 5, 100);
        d.drawImage(player.egypt.getImage(), 5, Y, 5 + HEIGHT * 2, Y + WIDTH * 2, player.getFrame(), player.getCrouching(), player.getFrame() + WIDTH, player.getCrouching() + HEIGHT, this);
        d.setColor(Color.BLACK);
        d.drawString("Press \"E\"", 5, 120);
        d.drawString("Press \"G\"", 150, 120);
        d.drawString("Press \"L\"", 300, 120);
    }

    public void actionPerformed(ActionEvent e) {
        player.move();
        bullet.move();
        enemy.move();
        repaint();
    }

    private class Adapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
            bullet.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }
    }
}

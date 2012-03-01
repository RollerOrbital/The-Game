package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Map extends JPanel implements ActionListener {

    private CombatEngine ce;
    private battleRoom tr2;
    private TestRoom tr;
    private TestArea ta;
    public static Player player;
    public static IDroid droid;

    public Map() {

        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        ce = new CombatEngine();
        tr2 = new battleRoom();
        tr = new TestRoom();
        ta = new TestArea();
        droid = new IDroid();
        player = new Player();

        Timer timer = new Timer(5, this);
        timer.start();

    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        if (player.room.equals("testArea")) {
            g2d.drawImage(ta.getImage(), ta.getX(), ta.getY(), this);
        } else if (player.room.equals("testRoom")) {
            g2d.drawImage(tr.getImage(), tr.getX(), tr.getY(), this);
        } else if (player.room.equals("battleRoom")) {
            Player.inCombat = true;
            g2d.drawImage(tr2.getImage(), ta.getX(), ta.getY(), this);
        }

        g2d.drawLine(0, 300, 650, 300);
        g2d.setColor(Color.BLUE);
        g2d.drawString(CombatEngine.playerStrikes, 100, 315);
        g2d.drawString(CombatEngine.playerShoots, 100, 315);
        g2d.drawString(CombatEngine.playerMages, 100, 315);
        g2d.drawString(CombatEngine.enemyStrikes, 100, 315);
        g2d.drawString(CombatEngine.enemyShoots, 100, 315);
        g2d.drawString(CombatEngine.enemyMages, 100, 315);
        if (player.room.equals(droid.room)) {
            g2d.drawImage(droid.getImage(), droid.getX() + 4, droid.getY() - 20, (droid.getX() + 4 + (droid.getWidth() * 2)), (droid.getY() + (droid.getHeight() * 2) - 20), droid.getSprFrame(), droid.getSprDir(), (droid.getSprFrame() + droid.getWidth()), (droid.getSprDir() + droid.getHeight()), this);
        }
        g2d.drawImage(player.getImage(), player.getX() + 4, player.getY() - 20, (player.getX() + 4 + (player.getWidth() * 2)), (player.getY() + (player.getHeight() * 2) - 20), player.getSprFrame(), player.getSprDir(), (player.getSprFrame() + player.getWidth()), (player.getSprDir() + player.getHeight()), this);
        g2d.drawString(("Position = " + player.getX() + ", " + player.getY()), 10, 315);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
        if (!Player.inCombat) {
            player.move();
            if (player.getX() == 10 && player.getY() >= 75 && player.getY() < 95 && player.dx < 0 && player.room.equals("testArea")) {
                player.x = 700;
                player.room = "testRoom";
            } else if (player.getX() == 550 && player.getY() > 78 && player.getY() < 90 && player.dx > 0 && player.room.equals("testRoom")) {
                player.x = 10;
                player.room = "testArea";
            } else if (player.getY() == 350 && player.getX() > 200 && player.getX() < 240 && player.dy > 0 && player.room.equals("testRoom")) {
                player.y = 10;
                player.x = 110;
                player.room = "battleRoom";
            } else if (player.getY() == 10 && player.getX() > 95 && player.getX() < 135 && player.dy < 0 && player.room.equals("battleRoom")) {
                player.y = 350;
                player.x = 210;
                player.room = "testRoom";
            }
        } else {
            player.mp = player.basemp;
            droid.mp = droid.basemp;
            player.hp = player.basehp;
            droid.hp = droid.basehp;
            while (player.hp > 0 && droid.hp > 0) {
                ce.basicCombat();
            }
            player.xp += (droid.aegis + droid.cognition / 10 + droid.fortune + droid.pace + droid.twitch + droid.scope + droid.vigor) / 7 * droid.baseYield;
            if (player.xp >= player.levelUpxp) {
                player.level++;
            }
            Player.inCombat = false;
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
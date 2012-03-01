package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;


public class Map extends JPanel implements ActionListener {

    private Random random = new Random();

    private CombatEngine ce;
    private battleRoom br;
    private TestRoom tr;
    private TestArea ta;
    public static Player player;
    public static IDroid iDroid;

    public Map() {

        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        ce = new CombatEngine();
        br = new battleRoom();
        tr = new TestRoom();
        ta = new TestArea();
        iDroid = new IDroid();
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
            g2d.drawImage(br.getImage(), ta.getX(), ta.getY(), this);
        }

        g2d.drawLine(0, 300, 650, 300);
        g2d.setColor(Color.BLUE);
        if (player.room.equals(iDroid.room)) {
            g2d.drawImage(iDroid.getImage(), iDroid.getX() + 4, iDroid.getY() - 20, (iDroid.getX() + 4 + (iDroid.getWidth() * 2)), (iDroid.getY() + (iDroid.getHeight() * 2) - 20), iDroid.getSprFrame(), iDroid.getSprDir(), (iDroid.getSprFrame() + iDroid.getWidth()), (iDroid.getSprDir() + iDroid.getHeight()), this);
        }
        g2d.drawImage(player.getImage(), player.getX() + 4, player.getY() - 20, (player.getX() + 4 + (player.getWidth() * 2)), (player.getY() + (player.getHeight() * 2) - 20), player.getSprFrame(), player.getSprDir(), (player.getSprFrame() + player.getWidth()), (player.getSprDir() + player.getHeight()), this);
        g2d.drawString(("Position = " + player.getX() + ", " + player.getY()), 10, 315);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
        player.move();
        if (player.getX() == 10 && player.getY() >= 70 && player.getY() < 100 && player.dx < 0 && player.room.equals("testArea")) {
            player.x = 700;
            player.room = "testRoom";
        } else if (player.getX() == 550 && player.getY() > 75 && player.getY() < 100 && player.dx > 0 && player.room.equals("testRoom")) {
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
//        } else {
//            player.mp = player.basemp;
//            iDroid.mp = iDroid.basemp;
//            player.hp = player.basehp;
//            iDroid.hp = iDroid.basehp;
//            while (player.hp > 0 && iDroid.hp > 0) {
//                ce.basicCombat();
//            }
//            if (player.hp > 0) {
//                player.xp += (iDroid.aegis + iDroid.cognition / 10 + iDroid.fortune + iDroid.pace + iDroid.twitch + iDroid.scope + iDroid.vigor) / 7 * iDroid.baseYield;
//                if (player.xp >= player.levelUpxp) {
//                    player.level++;
//                    System.out.println("You leveled up!\nYou are now level " + player.level + "!");
//                }
//            } else {
//                String[] asd = {"a"};
//                System.out.println("You are dead and now will face a minigame...");
//                int choice = random.nextInt(3);
//                if(choice == 0){
//                    minigames.scytheGame.MainClass.main(asd);
//                }else if(choice == 1){
//                    minigames.rockGame.MainClass.main(asd);
//                }else if(choice == 2){
//                    minigames.catcherGame.MainClass.main(asd);
//                }
//            }
//            Player.inCombat = false;
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
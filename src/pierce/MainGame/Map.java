package pierce.MainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Map extends JPanel implements ActionListener {

    private Player player;
    //private PlayerSquare psquare;
    private RoomHolder roomholder;


    public Map() {

        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        player = new Player();
        //psquare = new PlayerSquare();
        roomholder = new RoomHolder();

        Timer timer = new Timer(5, this);
        timer.start();

    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        //g2d.drawImage(rock.getImage(), rock.getX(), rock.getY(), this);
        g2d.drawImage(roomholder.getImage(), roomholder.getX()-(player.getX() + 4), roomholder.getY()-(player.getY() - 20), (roomholder.getX()+roomholder.getWidth()*2)-(player.getX() + 4), (roomholder.getY()+roomholder.getHeight()*2)-(player.getY() - 20), 0, 0, roomholder.getWidth(), roomholder.getHeight(), this);
//        g2d.drawImage(psquare.getImage(), player.getXsquare(), player.getYsquare(), player.getXsquare() + 16 * 2, player.getYsquare() + 12 * 2, 0, 0, 16, 12, this);
//        g2d.drawImage(player.getImage(), player.getX() + 4, player.getY() - 20, (player.getX() + 4 + (player.getWidth() * 2)), (player.getY() + (player.getHeight() * 2) - 20), player.getSprFrame(), player.getSprDir(), (player.getSprFrame() + player.getWidth()), (player.getSprDir() + player.getHeight()), this);
        g2d.drawImage(player.getImage(), (175-player.getWidth()), (94-player.getHeight()), (175+player.getWidth()), (94 + player.getHeight()), player.getSprFrame(), player.getSprDir(), (player.getSprFrame() + player.getWidth()), (player.getSprDir() + player.getHeight()), this);


        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
        player.move();
        roomholder.step();
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
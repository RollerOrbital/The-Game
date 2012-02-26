package pierce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Map extends JPanel implements ActionListener {

    private Timer timer;
    private Player player;
    private Rock rock;


    public Map() {

        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        player = new Player();
        rock = new Rock();

        timer = new Timer(5, this);
        timer.start();

    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(rock.getImage(), rock.getX(), rock.getY(), this);
        g2d.drawImage(player.getImage(), player.getX(), player.getY()-4, (player.getX()+(player.getWidth()*2)), (player.getY()+(player.getHeight()*2)-4), player.getSprFrame(), player.getSprDir(), (player.getSprFrame()+player.getWidth()), (player.getSprDir()+player.getHeight()), this);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
        player.move();
        repaint();
    }


    private class adapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
        
        public void keyReleased(KeyEvent e){
            player.keyReleased(e);
        }
    }

}
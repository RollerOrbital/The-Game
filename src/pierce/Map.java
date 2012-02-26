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
        g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);
        
        if(rock.getVis()==true){
        g2d.drawImage(rock.getImage(), rock.getX(), rock.getY(), this);
        }

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
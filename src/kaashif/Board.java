package kaashif;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Craft craft;
    private Rock rock;


    public Board() {

        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        craft = new Craft();
        rock = new Rock();

        timer = new Timer(5, this);
        timer.start();

    }



    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
        
        if(rock.getVis()==true){
        g2d.drawImage(rock.getImage(), rock.getX(), rock.getY(), this);
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
        craft.move();
        repaint();
    }


    private class adapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
        
        public void keyReleased(KeyEvent e){
            craft.keyReleased(e);
        }
    }

}
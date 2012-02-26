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
    private ArrayList rocks;
    int sq = 32;
    int[][] pos =
            {{32,32},{64,32}};

    int i = 0;



    public Board() {

        

        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        craft = new Craft();
        rock = new Rock(pos[i][0], pos[i][1]);

        timer = new Timer(5, this);
        timer.start();

        startRocks();

        

    }

    public void startRocks(){
        rocks = new ArrayList();
        for (int i=0; i<pos.length; i++ ) {
            rocks.add(new Rock(pos[i][0], pos[i][1]));
        }
    }



    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        if(craft.getVis()){
            g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
        }


        for (int i = 0; i < rocks.size(); i++) {
            Rock r = (Rock)rocks.get(i);
            if (r.getVis()) {
                g2d.drawImage(r.getImage(), r.getX(), r.getY(), this);
            }
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
        craft.move();
        repaint();
        collide();
    }

    public void collide() {
        Rectangle rect1 = craft.getBounds();
        Rectangle rect2 = rock.getBounds();
        for (int j = 0; j<rocks.size(); j++) {
            Rock r = (Rock) rocks.get(j);
            Rectangle r2 = r.getBounds();

            if (rect1.intersects(rect2)) {
                craft.setVis(false);
                r.setVis(false);
            }
        }
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
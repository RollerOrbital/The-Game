package kaashif;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Board extends JPanel implements ActionListener {

    private Timer timer;
    public Craft craft;
    public Rock rock;
    public boolean lost;
    int i = 0;



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
        if(craft.getVis()){
            g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
            g2d.drawImage(rock.getImage(), rock.getX(), rock.getY(), this);
        }
        if(lost){
            g2d.setColor(Color.white);
            g2d.drawString("You suck", 175, 350);
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
        craft.move();
        rock.move();
        repaint();
        collide();
    }

    public void collide() {
        Rectangle rect1 = craft.getBounds();
        Rectangle rect2 = rock.getBounds();


        if (!rock.getVis())  {
            rock = new Rock();
        }

            if (rect1.intersects(rect2)) {
                craft.setVis(false);
                rock.setVis(false);
                lost = true;
                rock = new Rock();
                
            }


        }
    class adapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }

        public void keyReleased(KeyEvent e){
            craft.keyReleased(e);
        }
    }


}



    

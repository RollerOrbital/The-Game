package pierce.TerminalVelocity;

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
    public long score;
    public int realscore;

    public Board() {
        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        craft = new Craft();
        rock = new Rock();
        timer = new Timer(5, this);
        timer.start();
        score = 0;
        realscore = 0;
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        g2d.drawString("Score:" + score, 0, 15);
        if (craft.getVis()) {
            g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), (craft.getX() + craft.getWidth()), (craft.getY() + craft.getHeight()), craft.getFrame(), 0, (craft.getFrame() + craft.getWidth()), craft.getHeight(), this);
            g2d.drawImage(rock.getImage(), rock.getX(), rock.getY(), this);
        }
        if (lost) {
            g2d.setColor(Color.white);
            g2d.drawString("Your score was: " + score, 175, 350);
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        craft.move();
        rock.move();
        realscore++;
        score = realscore / 20;
        if (!craft.getVis()) {
            timer.stop();
        }
        repaint();
        collide();
    }

    public void collide() {
        Rectangle rect1 = craft.getBounds();
        Rectangle rect2 = rock.getBounds();
        if (!rock.getVis()) {
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

        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }
    }
}



    

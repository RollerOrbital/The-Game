package will.ActualGameCode.MainGame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Sprite sprite;
    Image img = Toolkit.getDefaultToolkit().createImage("bedmap_incomplete.jpg");


    public Board() {


        addKeyListener(new TAdapter());
        setFocusable(true);

        setDoubleBuffered(true);

        sprite = new Sprite();

        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(sprite.getImage(), sprite.getX(), sprite.getY(), this);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        sprite.move();
        repaint();
    }

    private class TAdapter extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
            sprite.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            sprite.keyPressed(e);
        }
    }

}
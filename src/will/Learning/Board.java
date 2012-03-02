package will.Learning;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements ActionListener {

    Player p;
    public Image img;
    Timer time;

    public Board() {
        p = new Player();
        addKeyListener(new AL());
        setFocusable(true);
        ImageIcon i = new ImageIcon("C:/background.png");
        img = i.getImage();
        time = new Timer(1, this);
        time.start();
    }

    public void actionPerformed(ActionEvent e) {
        p.move();
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(img, 0, 0, null);
        g2d.drawImage(p.getImage(), p.getX(), p.getY(), null);
    }

    private class AL extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
            p.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            p.keyPressed(e);

        }
    }
}

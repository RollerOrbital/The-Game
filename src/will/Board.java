package will;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {

    Image star;
    Timer timer;
    int x, y;

    public Board() {
        setBackground(Color.BLACK);

        ImageIcon ii =
                new ImageIcon(this.getClass().getResource("Young Mage.jpg"));
        star = ii.getImage();

        setDoubleBuffered(true);

        x = 10;
        y = 0;
        timer = new Timer(1, this);
        timer.start();
    }


    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {

        x += 1;
        y += 0;

        if (y > 1280) {
            y = -45;
            x = -45;
        }
        repaint();
    }
}
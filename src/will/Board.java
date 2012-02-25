package will;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel implements Runnable {

    private Image sprite;
    private Thread animator;
    private int x, y;
    private final int DELAY = 50;

    public Board() {
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        ImageIcon ii = new ImageIcon(this.getClass().getResource("spr_test.jpg"));
        sprite = ii.getImage();

        x = y = 10;
    }

    public void addNotify() {
        super.addNotify();
        animator = new Thread(this);
        animator.start();
    }


    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(sprite, x, y, this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void cycle() {

        x += 1;
        y += 1;

        if (y > 480) {
            y = -45;
            x = -45;
        }
    }

    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {
            cycle();
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0)
                sleep = 2;
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }

            beforeTime = System.currentTimeMillis();


        }
    }
}
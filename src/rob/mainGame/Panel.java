package rob.mainGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel implements ActionListener {
    private Room room;
    private StartMenu sm;

    public Panel() {

        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        sm = new StartMenu();
        room = new Room();
        Timer timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(room.getImage(), room.getX(), room.getY(), this);
        g2d.drawImage(room.getPImage(), 200 + 4, 150 - 20, (200 + 4 + (room.getPWidth() * 2)), (150 + (room.getPHeight() * 2) - 20), room.getSprFrame(), room.getSprDir(), (room.getSprFrame() + room.getPWidth()), (room.getSprDir() + room.getPHeight()), this);
        if (room.isSmOpen) {
            g2d.drawImage(sm.getCursorImage(), room.cursorX, room.cursorY, this);
            g2d.drawImage(sm.getMenuImage(), 300, 0, this);
            g2d.drawString("" + StartMenu.menuChoice, 100, 200);
        }
        g2d.drawString("Height = " + room.getY(), 100, 100);
        g2d.drawString("Distance = " + room.getX(), 100, 150);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        room.move();
        repaint();
    }

    private class adapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            room.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            room.keyReleased(e);
        }
    }
}

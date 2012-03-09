package rob.ToasterQuest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel implements ActionListener {
    private Level level;

    public Panel() {
        addKeyListener(new adapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        level = new Level();
        Timer timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(level.getImage(), level.getX(), level.getY(), this);
        g2d.drawImage(level.getPImage(), 200 + 4, 150 - 20, (200 + 4 + (level.getPWidth() * 2)), (150 + (level.getPHeight() * 2) - 20), level.getSprFrame(), level.getSprDir(), (level.getSprFrame() + level.getPWidth()), (level.getSprDir() + level.getPHeight()), this);
        g2d.drawString("Height = " + level.getY(), 100, 100);
        g2d.drawString("Distance = " + level.getX(), 100, 150);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        //jump pseudoCode
        //max-jump-height = 50
        //if the player is holding the up key
        //the up key is no longer being pressed
        //to do this make an 'isJumping' boolean and when the key is pressed 'up' becomes true
        //if up is true already then 'isJumping' is false
        //DONE
        //The player goes up until they reach their jumpHeight at which point up becomes false
        //their jumpHeight is determined by their height + 50
        //this is assigned when they press the up key
        //DONE
        //if up is true the player just goes up
        //the player goes up until they reach y == jumpHeight
        //when y == jumpHeight
        //up is false
        //the player goes down again
        if (level.up) {
            level.y++;
            if (level.y >= level.jumpHeight) {
                level.canJump = false;
                level.y += 3;
                level.up = false;
            }
        } else {
            level.y -= 3;
        }
        level.canJump = true;
        level.move();
        repaint();
    }

    private class adapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            level.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            level.keyReleased(e);
        }
    }
}

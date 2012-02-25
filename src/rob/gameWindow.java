package rob;

import javax.swing.*;
import java.awt.event.ActionListener;

public class gameWindow extends JFrame implements ActionListener {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Resist");
        frame.setSize(200, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel title = new JLabel("~~~~~Resist~~~~~");

        panel.add(title);
        frame.add(panel);
    }

}

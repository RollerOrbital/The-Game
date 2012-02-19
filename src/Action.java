import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Action implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame("clicked");
        frame.setVisible(true);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("clicked");

        panel.add(label);
        frame.add(panel);
    }
}

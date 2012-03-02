package will.Learning;

import javax.swing.*;

public class Frame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Seal Off");
        frame.add(new Board());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 540);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}

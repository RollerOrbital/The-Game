package rob.mazeGame;

import javax.swing.*;

public class GraphicsEngine {
    public static void getFrame() {
        JFrame frame = new JFrame(" Resist");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(621, 350);
        frame.dispose();

        JPanel panel = new JPanel();

        frame.add(panel);
    }
}

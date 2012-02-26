package rob.mazeGame;

import javax.swing.*;

public class GraphicsEngine {
    public static void getFrame() {
        JFrame frame = new JFrame("Maze Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(274, 176);
    }

    public static void getPanel() {
        JPanel panel = new JPanel();
    }
}

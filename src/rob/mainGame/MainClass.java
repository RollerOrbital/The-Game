package rob.mainGame;

import javax.swing.*;

public class MainClass {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new Panel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setTitle("RESIST");
        frame.setVisible(true);
        frame.setResizable(true);
    }
}
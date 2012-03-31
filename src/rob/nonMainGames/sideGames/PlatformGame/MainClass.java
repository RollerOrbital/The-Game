package rob.nonMainGames.sideGames.PlatformGame;

import javax.swing.*;

public class MainClass {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Platform");
        frame.add(new Panel());
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

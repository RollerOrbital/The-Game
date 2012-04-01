package rob.nonMainGames.sideGames.ToasterQuest;

import javax.swing.*;

public class MainClass {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Platformer von Rob");
        frame.add(new Panel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}

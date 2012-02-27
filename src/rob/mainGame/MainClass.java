package rob.mainGame;

import javax.swing.*;

public class MainClass extends JFrame {

    public MainClass() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(725, 425);
        setLocationRelativeTo(null);
        setTitle("Maze Game");
        setResizable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainClass();
    }
}

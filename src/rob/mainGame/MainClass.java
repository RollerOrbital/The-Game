package rob.mainGame;

import javax.swing.*;

public class MainClass extends JFrame {

    public MainClass() {

        add(new Map());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize((180 * 2) + 6, (110 * 2) + 28);
        setLocationRelativeTo(null);
        setTitle("RESIST");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainClass();
    }
}
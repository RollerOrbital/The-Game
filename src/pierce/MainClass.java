package pierce;

import javax.swing.*;

public class MainClass extends JFrame {

    public MainClass() {

        add(new Map());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 700);
        setLocationRelativeTo(null);
        setTitle("Rock Game");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainClass();
    }
}
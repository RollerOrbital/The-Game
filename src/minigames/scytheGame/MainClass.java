package minigames.scytheGame;

import javax.swing.*;

public class MainClass extends JFrame {

    public int sq;

    public MainClass() {

        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sq = 32;
        setSize(sq * 23, sq * 14);
        setLocationRelativeTo(null);
        setTitle("Scythe Game");
        setResizable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainClass();
    }
}
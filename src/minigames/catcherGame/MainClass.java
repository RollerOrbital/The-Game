package minigames.catcherGame;

import javax.swing.*;

public class MainClass extends JFrame {

    public int sq;

    public MainClass() {
        add(new Arena());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sq = 32;
        setSize(sq * 23, sq * 14);
        setLocationRelativeTo(null);
        setTitle("Catcher Game");
        setResizable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainClass();
    }
}
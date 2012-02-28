package minigames.part1_demon_soul_dodging;

import javax.swing.*;

public class MainClass extends JFrame {
    public MainClass() {
        add(new Arena());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(725, 425);
        setLocationRelativeTo(null);
        setTitle("Bomb Game");
        setResizable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainClass();
    }
}
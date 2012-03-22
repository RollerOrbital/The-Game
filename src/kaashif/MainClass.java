package kaashif;

import javax.swing.*;

public class MainClass extends JFrame {

    public int sq;

    public MainClass() {

        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sq = 32;
        setSize(13 * sq, 22 * sq);
        setLocationRelativeTo(null);
        setTitle("Rock Game");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainClass();
    }
}
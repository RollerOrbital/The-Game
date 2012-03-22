package pierce.Liberation;

import javax.swing.*;

public class MainClass extends JFrame {

    public int sq;

    public MainClass() {
        add(new Arena());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sq = 32;
        setSize((154 * 4) + 16, (80 * 4) + 37 * 4);
        setLocationRelativeTo(null);
        setTitle("LIBERATION");
        setResizable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainClass();
    }
}
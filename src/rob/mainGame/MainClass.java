package rob.mainGame;

import javax.swing.*;

public class MainClass extends JFrame {
    public MainClass() {
        add(new Panel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setTitle("Resist");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainClass();
    }
}

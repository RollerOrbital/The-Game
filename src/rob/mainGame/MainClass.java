package rob.mainGame;

import javax.swing.*;

public class MainClass extends JFrame {
    public MainClass() {
        add(new Panel());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setTitle("RESIST");
        setVisible(true);
        setResizable(true);
    }

    public static void main(String[] args) {
        new MainClass();
    }
}

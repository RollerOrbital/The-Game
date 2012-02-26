package pierce;

import javax.swing.JFrame;

public class MainClass extends JFrame {

    public MainClass() {

        add(new Board());

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
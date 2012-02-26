package rob.mazeGame;

import javax.swing.*;

public class MainClass extends JFrame {

    public MainClass() {

        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(621, 350);
        setLocationRelativeTo(null);
        setTitle("Maze Game");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainClass();
    }
}
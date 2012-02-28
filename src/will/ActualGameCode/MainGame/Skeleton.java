package will.ActualGameCode.MainGame;

import javax.swing.*;

public class Skeleton extends JFrame {

    public Skeleton() {

        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(621, 350);
        setLocationRelativeTo(null);
        setTitle("Resist");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Skeleton();
    }
}
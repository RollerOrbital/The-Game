package will;

import javax.swing.*;

public class Skeleton extends JFrame {

    public Skeleton() {
        add(new Board());
        setTitle("Game Window");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(280, 240);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Skeleton();
    }
}

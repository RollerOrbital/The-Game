package will;

import javax.swing.*;

public class Skeleton extends JFrame {

    public Skeleton() {
        add(new Board());
        setTitle("Game Window");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Skeleton();
    }
}

package rob.mainGame;

import javax.swing.*;

public class MainClass {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new Panel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setTitle("RESIST");
        frame.setVisible(true);
        frame.setResizable(true);
    }
}
//task:
/*
1.  Make it so that the player can talk to people if they are a certain proximity away from them._Working on this
2.  Make it so different people say different things.
3.  Make it so people can move.
4.  Make people hit detection positive.
5.  Move on to a new topic - decided when you get here.
*/
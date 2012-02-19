import javax.swing.*;
import java.awt.*;

public class Screen {

    public static void screen() {
        //game screen
        JFrame frame = new JFrame("The Game");
        frame.setVisible(true);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //screen panel
        JPanel panel = new JPanel(new GridBagLayout());
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        GridBagConstraints c = new GridBagConstraints();

        //title and buttons
        //title
        JLabel gameName = new JLabel("The Game");
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 10, 10);
        panel.add(gameName, c);
        //start game
        JButton startGame = new JButton("Start Game");
        c.gridx = 0;
        c.gridy = 2;
        startGame.addActionListener(new Action());
        panel.add(startGame, c);
        //instructions
        JButton instructions = new JButton("Instructions");
        c.gridx = 0;
        c.gridy = 3;
        panel.add(instructions, c);
        //credits
        JButton credits = new JButton("Credits");
        c.gridx = 0;
        c.gridy = 4;
        panel.add(credits, c);

        //add panel to frame
        frame.add(panel);
    }
}
//
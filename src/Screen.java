import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen {

    public static JFrame screen() {
        //game screen
        JFrame gameWindow = new JFrame("The Game");
        gameWindow.setVisible(true);
        gameWindow.setSize(400, 400);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //screen titleScreenPanel
        JPanel titleScreenPanel = new JPanel(new GridBagLayout());
        gameWindow.getContentPane().add(titleScreenPanel, BorderLayout.CENTER);
        GridBagConstraints c = new GridBagConstraints();

        //title and buttons
        //title
        JLabel gameName = new JLabel("The Game");
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(10, 10, 10, 10);
        titleScreenPanel.add(gameName, c);
        //start game
        JButton startGame = new JButton("Start Game");
        c.gridx = 0;
        c.gridy = 2;
        startGame.addActionListener(new Action());
        titleScreenPanel.add(startGame, c);
        //instructions
        JButton instructions = new JButton("Instructions");
        c.gridx = 0;
        c.gridy = 3;
        titleScreenPanel.add(instructions, c);
        //credits
        JButton credits = new JButton("Credits");
        c.gridx = 0;
        c.gridy = 4;
        titleScreenPanel.add(credits, c);

        //add titleScreenPanel to gameWindow
        gameWindow.add(titleScreenPanel);
        return gameWindow;
    }

    public static class Action implements ActionListener {
        private void gameStartedScreen() {
            JPanel introScreen = new JPanel();
            screen().add(introScreen);

        }

        public void actionPerformed(ActionEvent e) {
            gameStartedScreen();
        }
    }
}
//
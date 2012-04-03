package rob.nonMainGames.sideGames.ToasterQuest;

import javax.swing.*;

public class MainClass {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Platformer von Rob");
        frame.add(new Panel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
/*
Make the jumping system work and be elegant and easily understandable
Make the tiles so that each new tile is a barrier for the player so you
don't draw the tiles then set the bounds separately. Once those 2 are done
do a little trimming and neatening to make the programs design more elegant
and understandable again

PROBLEM 1:
I need to make 'stateNumber' an enum and I don't know how to :/ - this is in order
so that the player can only be going up if they are pressing or have recently
pressed the up key and at no other time may they go up.
*/

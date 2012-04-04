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
Screw the last remaining bug - it's only visual anyway...

I will now make tiles so that each tile object automatically generates a wall so the player cannot pass through it

Make the jumping system work and be elegant and easily understandable
Make the tiles so that each new tile is a barrier for the player so you
don't draw the tiles then set the bounds separately. Once those 2 are done
do a little trimming and neatening to make the programs design more elegant
and understandable again.
*/

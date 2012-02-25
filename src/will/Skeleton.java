package will;  //my package

import javax.swing.*;

public class Skeleton extends JFrame {

    public Skeleton() {   //new skeleton object
        add(new Board()); //create a new panel "board"
        setTitle("Game Window");    //set the title on the top of the frame
        setDefaultCloseOperation(EXIT_ON_CLOSE); //what should happen if it closes
        setSize(480, 360);   //set size, can change to what is needed
        setLocationRelativeTo(null);  //not in a relative location
        setVisible(true);      //make it visible
    }

    public static void main(String[] args) {    //main method
        new Skeleton();           //output the object that we just made "skeleton"
    }
}

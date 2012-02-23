package will;


import javax.swing.*;

public class gui extends JFrame {
    public gui(){
        setTitle("Game Window");
        setSize(256, 256);
        setLookAndFeel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    
    }    
        private void setLookAndFeel(){
                         try {
                             UIManager.setLookAndFeel(
                                     "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
                             );
                         } catch (Exception exc){
                             //ignore error
                         }
    }
        
        public static void main (String[] args){
            gui gui = new gui();

        }
    }


package rob.nonMainGames.sideGames.RebellionPD;

import javax.swing.*;
import java.awt.*;

public class Screen {
    private ImageIcon back;
    private Image backI;

    public Screen() {
        //ImageIcons START
        back = new ImageIcon(getClass().getResource("bg.png"));
        backI = back.getImage();
        //ImageIcons END
    }

    public Image getImage() {
        return backI;
    }
}

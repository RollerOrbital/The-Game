package will.ActualGameCode.SealOff;

import java.util.Random;

public class Enemy {

    Random r = new Random();
    String SlappySam = "Slappy Sam";
    String FreddyFin = "Freddy Fin";
    String FergusFlipper = "Fergus Flipper";
    String ThomasTail = "Thomas Tail";
    String name;

    public void enemyName() {
        int nameNum = r.nextInt(4) + 1;

        if (nameNum == 1) {
            name = SlappySam;
        } else if (nameNum == 2) {
            name = FreddyFin;
        } else if (nameNum == 3) {
            name = FergusFlipper;
        } else if (nameNum == 4) {
            name = ThomasTail;
        }

        System.out.println("You will be facing " + name + " !");
    }

}

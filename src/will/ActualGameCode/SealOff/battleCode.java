package will.ActualGameCode.SealOff;

import java.util.Random;

public class battleCode {

    Random r = new Random();

    int enemynum = r.nextInt(3) + 1;

    String enemy;
    String BigFin = "Bigfin";
    String SammySeal = "Sammy Seal";
    String SlappyJoe = "Slappy Joe";

    public battleCode() {
        System.out.println("Battle has begun...");

        if (enemynum == 1) {
            enemy = "BigFin";
        } else if (enemynum == 2) {
            enemy = "Sammy Seal";
        } else if (enemynum == 3) {
            enemy = "Slappy Joe";
        }

        System.out.println("You will be fighting " + enemy);
        System.out.println("You each circle each other, staring into each others eyes. You realise your body is morphing and changing into that of a seal's!");
        System.out.println("A large seal stands in the middle, looks at both of you and then bellows 'Baaa, be, naadaaaaa', which, when roughly translated into english means'lets get ready to rumble!' ");


        combat newFight = new combat();

    }

}

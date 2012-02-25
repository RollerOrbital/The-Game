package rob.mazeGame;

import java.util.Random;

public class Decision {
    static Random randomNum = new Random();

    private static int numPaths() {
        int choice = randomNum.nextInt(101);
        int returnThing;

        if (choice > 70) {
            returnThing = 2;
        } else if (choice > 40) {
            returnThing = 3;
        } else if (choice > 20) {
            returnThing = 4;
        } else {
            returnThing = 2;
        }
        return returnThing;
    }

    int numberOfPaths;

    public Decision(int numberOfPaths) {
        this.numberOfPaths = numberOfPaths;
    }

    static Decision a = new Decision(numPaths());
    static Decision b = new Decision(numPaths());
    static Decision c = new Decision(numPaths());
    static Decision d = new Decision(numPaths());
    static Decision e = new Decision(numPaths());
    static Decision f = new Decision(numPaths());
    static Decision g = new Decision(numPaths());
    static Decision h = new Decision(numPaths());
    static Decision i = new Decision(numPaths());
    static Decision j = new Decision(numPaths());
    static Decision k = new Decision(numPaths());
    static Decision l = new Decision(numPaths());
    static Decision m = new Decision(numPaths());
    static Decision n = new Decision(numPaths());
    static Decision o = new Decision(numPaths());
    static Decision p = new Decision(numPaths());
    static Decision q = new Decision(numPaths());
    static Decision r = new Decision(numPaths());
    static Decision s = new Decision(numPaths());
    static Decision t = new Decision(numPaths());
    static Decision u = new Decision(numPaths());
}
//decision has direction, number of paths
//number of paths has a greater chance to be 2 then 3 then 4.
//10, 20, 30, 40
//70, 45, 25, 5
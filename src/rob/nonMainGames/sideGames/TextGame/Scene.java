package rob.nonMainGames.sideGames.TextGame;

public class Scene {
    Player player = new Player();

    public void describeArea(int areaNum) {
        if (areaNum == 1) {
            System.out.println("You are inside an AUDI car dealership." +
                    " There is a door outside onto the road on the far right corner of the room nearest the glass exterior.");
        } else if (areaNum == 2) {
            System.out.println("You appear to be in an indoor SPORTING COMPLEX of some kind - there are two exits to the room you are in, " +
                    "one on the left of the room and the other at the end of the room also on the left.");
        } else if (areaNum == 3) {
            System.out.println("You are in a park inside a play area. There are a lot of trees and there are two paths from your " +
                    "current location. One in the left corner - nearest to the ice-cream van and the other is in the opposite corner " +
                    "of the area. In the right corner.");
        } else {
            System.out.println("Problem");
        }
    }
}

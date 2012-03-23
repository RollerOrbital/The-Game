package rob.nonMainGames.sideGames.TextGame;

public class Scene {
    public void describeArea(int areaNum) {
        if (areaNum == 1) {
            System.out.println("You are inside an AUDI dealership.\n" +
                    "There is a door outside onto the road on the far right\ncorner of the room nearest the glass exterior.");
        } else if (areaNum == 2) {
            System.out.println("You appear to be in an indoor SPORT complex of some kind.\nThere are two exits to the room you are in, " +
                    "one on the left of the room\nand the other at the end of the room also on the left.");
        } else if (areaNum == 3) {
            System.out.println("You are in a PARK inside a play area.\nThere are a lot of trees and there are two paths from your " +
                    "current location.\nOne in the left corner - nearest to the ice-cream van\nand the other is in the opposite corner " +
                    "of the area. In the right corner.");
        } else {
            System.out.println("player.areaNum is not 1, 2 or 3");
        }
    }
}
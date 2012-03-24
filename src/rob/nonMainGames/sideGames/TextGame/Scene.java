package rob.nonMainGames.sideGames.TextGame;

public class Scene {
    public void describeArea(int areaNum) {
        if (areaNum == 1) {
            System.out.println("This is an AUDI dealership.\n" +
                    "There is a door outside onto the road on the far right\ncorner of the room nearest the glass exterior.");
        } else if (areaNum == 2) {
            System.out.println("This appears to be an indoor SPORT complex of some kind.\nThere are two exits to the room, " +
                    "one on the left of the room\nand the other at the end of the room also on the left.");
        } else if (areaNum == 3) {
            System.out.println("This is a play area inside a PARK.\nThere are a lot of trees and there are two paths from here. " +
                    "\nOne in the left corner - nearest to the ice-cream van\nand the other is in the opposite corner " +
                    "of the area in the right corner.");
        } else {
            System.out.println("player.areaNum is not 1, 2 or 3");
        }
    }

    public void describeSpecArea(int areaNum, int x, int y) {
        if (areaNum == 1) {
            if (x >= 2 && y <= 3) {
                System.out.println("There is a door to the road just west of where you are now.");
            } else {
                System.out.println("There area a lot of nice cars. Although there appear to be no keys to the cars.\n" +
                        "There is a door in the far corner.");
            }
        } else if (areaNum == 3) {
            if (x >= 5 && y >= 9) {
                System.out.println("There is an ice-cream van near to you. There is a door next to the ice-cream van\n" +
                        " that leads to the road that goes west from here.");
            } else {
                System.out.println("There are lots of screaming and crying and playing children everywhere.\nIt is extremely loud");
            }
        } else if (areaNum == 2) {
            if (y <= 6) {
                if (x <= 6) {
                    System.out.println("There is a curtain to the west of you. There also a door on the opposite " +
                            "side of the room from the curtain.");
                } else {
                    System.out.println("There is a curtain to the east. There is also a door on the south side of the room.");
                }
            } else if (y < 15 && x <= 3) {
                System.out.println("You are in a short passageway. There is a door to the left side of the corridor (west).");
            } else if (y <= 13 && y >= 15 && x <= 16 && x >= 3) {
                System.out.println("You are in a long passageway. There are no doors but at the end the passage forks.");
            } else if (y >= 9 && y <= 13 && x >= 12 && x <= 15) {
                System.out.println("The passage you are in has a door on it's left side (east).");
            } else if (y <= 8 && x >= 12 && x <= 14) {
                System.out.println("There is a passage way to the south and the west.");
            } else if (y <= 8 && x >= 14 && x <= 18) {
                System.out.println("You are in a very short corridor.\nAt one end is a left turn and the other there appears to be " +
                        "some kind of reception/secretary office.");
            } else if (y <= 16 && x >= 18 && x <= 21) {
                System.out.println("You are in what appears to be the reception of the sport complex.");
            } else if (y >= 15 && y <= 22 && x >= 12 && x <= 16) {
                System.out.println("Oh no! You have gone to a dead end! You will have to turn back and find a different route.");
            } else {
                System.out.println("player.x or player.y are out of bounds.");
            }
        } else {
            System.out.println("player.areaNum is not 1, 2 or 3 OR x or y are out of bounds");
        }
    }
}
package rob.nonMainGames.sideGames.TextGame;

import java.util.Scanner;

public class Player {
    public String name, region;
    public int seed1, seed2, seed;
    public int abilityNum, areaNum, targetArea;
    public int x, y;
    private Scanner input = new Scanner(System.in);

    public Player() {
    }

    public String getName() {
        System.out.println("What is your name?");
        String nam = input.next();
        seed1 = nam.hashCode();
        return nam;
    }

    public String getRegion() {
        System.out.println("Where are you from?");
        String reg = input.next();
        seed2 = reg.hashCode();
        return reg;
    }

    public int getAbilityNum(int seed) {
        if (seed > 75 && seed < 101) {
            return 1;
        } else if (seed > 50 && seed < 76) {
            return 2;
        } else if (seed > 25 && seed < 51) {
            return 3;
        } else {
            return 4;
        }
    }

    public int getAreaNum(int seed) {
        if (seed % 3 == 0) {
            return 1;
        } else if (seed % 3 == 1) {
            return 2;
        } else {
            return 3;
        }
    }

    public int getTargetArea(int areaNum) {
        if (areaNum == 1) {
            return 2;
        } else if (areaNum == 2) {
            return 3;
        } else {
            return 1;
        }
    }

    public void getInstructions() {
        System.out.println("The commands are NOT case sensitive.");
        input.next();
        System.out.println("Any command that refers to an object that should be near the player\ni.e. pick up\n" +
                "will be done only if the player is on top (same x and y co-ordinates) of the object the player is attempting " +
                "to access.");
        input.next();
        System.out.println("To do:\t\t\tType:\n");
        System.out.println("Move North\t\t\t\tmn");
        System.out.println("Move South\t\t\t\tms");
        System.out.println("Move West\t\t\t\tmw");
        System.out.println("Move East\t\t\t\tme");
        System.out.println("General Area Check\t\tgc");
        System.out.println("Specific Area Check\t\tsc");
        System.out.println("Pick up\t\t\t\t\tpu");
        System.out.println("Eat\t\t\t\t\t\teat");
        System.out.println("Hit\t\t\t\t\t\thit");
        System.out.println("Help\t\t\t\t\thelp");
    }
}
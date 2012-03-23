package rob.nonMainGames.sideGames.TextGame;

import java.util.Scanner;

public class Player {
    public String name, region;
    public int seed1, seed2, seed;
    public int abilityNum, areaNum, targetArea;
    public String area;
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

    public int lowerOne(int x) {
        if (x < 1) {
            x = 1;
        }
        return x;
    }
}

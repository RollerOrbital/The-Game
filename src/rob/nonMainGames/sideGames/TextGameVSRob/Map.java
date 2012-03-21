package rob.nonMainGames.sideGames.TextGameVSRob;

import java.util.Random;

public class Map {
    private Random random;
    private int days;
    private String[][] map;

    public Map() {
        random = new Random();
        days = 0;
        map = new String[10][10];
    }

    public void printMap() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j] = ".";
                map[random.nextInt(10)][random.nextInt(10)] = "A";
                if (j == 9) {
                    System.out.println();
                } else {
                    System.out.print(map[i][j] + "\t");
                }
            }
        }
    }

    //make a method that:
    //start 'A' in a random position
    //every time "days"
}

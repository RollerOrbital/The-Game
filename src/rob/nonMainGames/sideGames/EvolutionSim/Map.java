package rob.nonMainGames.sideGames.EvolutionSim;

import java.util.Random;

public class Map {
    private Random random;
    private String[][] map;

    public Map() {
        random = new Random();
        map = new String[10][10];
        getStartMap();
        getMap(5);
    }

    private void getStartMap() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j] = ".";
            }
        }
    }

    public void printMap() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
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
    //every time "generations" increases - there is a random chance that another 'A' will spawn next to it
    //this continues for every 'A' on the board
    private void setMap(int gens, int x, int y) {
        int days = 0;
        while (days < gens) {
            int chanceToIncrease = random.nextInt(80);
            if (chanceToIncrease % 5 == 0) {
                try {
                    if (chanceToIncrease % 4 == 0) {
                        map[x + 1][y] = "A";
                    } else if (chanceToIncrease % 4 == 1) {
                        map[x - 1][y] = "A";
                    } else if (chanceToIncrease % 4 == 2) {
                        map[x][y + 1] = "A";
                    } else if (chanceToIncrease % 4 == 3) {
                        map[x][y - 1] = "A";
                    }
                } catch (Exception ignored) {
                }
                days++;
            }
        }
    }

    private void getMap(int generations) {
        int startx = random.nextInt(10);
        int starty = random.nextInt(10);
        map[startx][starty] = "A";
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j].equals("A")) {
                    setMap(generations, i, j);
                }
            }
        }
    }
}

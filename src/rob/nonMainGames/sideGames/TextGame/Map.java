package rob.nonMainGames.sideGames.TextGame;

public class Map {
    int[][] area;
    private Player player;

    public Map() {
        area = new int[10][10];
        player = new Player();
        getMap();
        printMap();
    }

    public void getMap() {
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area.length; j++) {
                area[i][j] = 0;
                area[player.getX()][player.getY()] = 1;
            }
        }
    }

    private void printMap() {
        for (int row = 0; row < area.length; row++) {
            for (int column = 0; column < area.length; column++) {
                if (column == 9) {
                    System.out.println();
                } else {
                    String squareIdentity;
                    if (area[row][column] == 1) {
                        squareIdentity = "P\t";
                    } else if (area[row][column] == 2) {
                        squareIdentity = "W\t";
                    } else {
                        squareIdentity = ".\t";
                    }
                    System.out.print(squareIdentity);
                }
            }
        }
    }
}

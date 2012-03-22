package rob.nonMainGames.sideGames.TextGame;

public class Map {
    int[][] area;
    private Player player;
    private Troll troll;

    public Map() {
        area = new int[10][10];
        player = new Player();
        troll = new Troll();
        getTurn();
    }

    public void getTurn() {
        getMap();
        printMap();
        player.canGo = true;
        player.getPlayerTurn();
        player.canGo = false;
        troll.canGo = true;
        troll.getTrollTurn();
        troll.canGo = false;
        getMap();
        printMap();
    }

    public void getMap() {
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area.length; j++) {
                area[i][j] = 0;
                area[troll.getX()][troll.getY()] = 3;
                area[player.getX()][player.getY()] = 1;
            }
        }
    }

    private void printMap() {
        for (int[] row : area) {
            for (int column = 0; column < area.length; column++) {
                if (column == 9) {
                    System.out.println();
                } else {
                    String squareIdentity;
                    if (row[column] == 1) {
                        squareIdentity = "P\t";
                    } else if (row[column] == 2) {
                        squareIdentity = "W\t";
                    } else if (row[column] == 3) {
                        squareIdentity = "T\t";
                    } else {
                        squareIdentity = ".\t";
                    }
                    System.out.print(squareIdentity);
                }
            }
        }
    }
}

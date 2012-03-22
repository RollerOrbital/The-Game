package robD;

public class Turn {
    public Turn(String PlayerName, boolean alive, int power, int x, int y, int z) {
        DescribePlacex(x, y);

    }

    private void DescribePlacex(int x, int y) {
        if (x == 0) {
            System.out.println("There is a wall to your North");
        } else if (x == 16) {
            System.out.println("There is a wall to your South");
        }
    }
}


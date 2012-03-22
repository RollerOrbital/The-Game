package robD;


public class Player {
    public static int x, y, z, power;
    public static boolean alive;
    public static String PlayerName;

    public Player(String PlayerName, boolean alive, int power, int x, int y, int z) {

    }

    public static Player getPlayer() {
        return new Player(PlayerName, alive, power, x, y, z);
    }
}


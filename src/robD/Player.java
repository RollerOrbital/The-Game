package robD;

public class Player {
    private static int position[];
    private static int effects[];
    private static int power;
    private static boolean alive;
    private static String PlayerName;

    public Player(boolean alive1, int power1, int x1, int y1, int z1) {
        alive = alive1;
        power = power1;
        position = new int[3];
        position[1] = x1;
        position[2] = y1;
        position[3] = z1;
        effects = new int[4];
        effects[1] = 0;
        effects[2] = 0;
        effects[3] = 0;
        effects[4] = 0;

    }


    public static int getPower() {
        return power;
    }

    public static int[] getPosition() {
        return position;
    }

    public static boolean getAlive() {
        return alive;
    }

    public static int[] getEffects() {
        return effects;

    }


}

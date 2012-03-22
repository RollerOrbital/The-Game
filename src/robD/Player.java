package robD;


public class Player {
    public static int x;
    public static int y;
    public static int z;
    public static int power;
    public static boolean alive;
    public static String PlayerName;
    public Player(String PlayerName,boolean alive, int power,int x, int y, int z){

    }

    public static Player getPlayer(){
        return new Player(PlayerName,alive,power,x,y,z);
    }
}


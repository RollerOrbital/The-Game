package rob.nonMainGames.sideGames.TextGame;

import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to KettleQuest!");
        input.next();
        Player player = new Player();
        player.name = player.getName();
        System.out.println("So you are " + player.name + "!");
    }
}

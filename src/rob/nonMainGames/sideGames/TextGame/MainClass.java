package rob.nonMainGames.sideGames.TextGame;

import java.util.Random;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Welcome to KettleQuest!");
        input.next();
        Player player = new Player();
        player.name = player.getName();
        System.out.println("So you are " + player.name + "!");
        input.next();
        player.region = player.getRegion();
        System.out.println("So you are from " + player.region + "!");
        input.next();
        player.seed = Math.abs((player.seed1 + player.seed2 + random.nextInt()) % 100);
        System.out.println("Your seed = " + player.seed);
        input.next();
        player.abilityNum = player.getAbilityNum(player.seed);
        System.out.println("Your abilityNum = " + player.abilityNum);
        input.next();
        player.areaNum = player.getAreaNum(player.seed);
        player.targetArea = (player.areaNum + 1) % 3;
        System.out.println("Your areaNum = " + player.areaNum);
        System.out.println("Your targetArea = " + player.targetArea);
    }
}

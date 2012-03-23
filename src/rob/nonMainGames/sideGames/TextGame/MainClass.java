package rob.nonMainGames.sideGames.TextGame;

import java.util.Random;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        Player player = new Player();
        Scene scene = new Scene();

        System.out.println("Welcome to KettleQuest!");
        input.next();

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
        player.targetArea = player.lowerOne((player.areaNum + 1) % 3);
        System.out.println("Your areaNum = " + player.areaNum);
        System.out.println("Your targetArea = " + player.targetArea);
        input.next();

        scene.describeArea(player.areaNum);
        input.next();

        System.out.println("I don't care whether or not you want to - your seeing the instructions :P");
        input.next();
        System.out.println("You have a set of commands...I will tell you them:");
        input.next();
        System.out.println("When given the prompt \"?-\" You may type your command.\nOtherwise the thing to do will be specified.");
        input.next();
        player.getInstructions();
        input.next();
    }
}

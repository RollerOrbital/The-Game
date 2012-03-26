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
        player.targetArea = player.getTargetArea(player.areaNum);
        System.out.println("Your areaNum = " + player.areaNum);
        System.out.println("Your targetArea = " + player.targetArea);
        input.next();
        System.out.println("I don't care whether or not you want to - your seeing the instructions :P");
        input.next();
        System.out.println("You have a set of commands...I will tell you them:");
        input.next();
        System.out.println("When given the prompt \"?-\" You may type your command.\nOtherwise the thing to do will be specified.");
        input.next();
        player.getInstructions();
        input.next();
        scene.describeArea(player.areaNum);
        input.next();
        scene.describeSpecArea(player.areaNum, player.x, player.y);
        input.next();
        System.out.println("The game is on. Your goal is to reach area " + player.targetArea + ".\n" +
                "It is a secret compound that is known because of it's descriptions by others that have ventured there...\n" +
                "One description goes:");
        scene.describeArea(player.targetArea);
        input.next();
        System.out.println("A man is pushed into the room with you...");
        input.next();
        System.out.println("He starts babbling about a place he claims to have visited before...");
        input.next();
        System.out.print("\"");
        scene.describeArea(player.areaNum);
        scene.describeSpecArea(player.targetArea, 20, 17);
        System.out.println("It was scary... so loud and scary...");
        System.out.print("\"");
        input.next();
        System.out.println("The man proceeds to break down emotionally... He has come from area " + player.targetArea + "...");
        input.next();
        System.out.println("You are frightened by the prospect of going there...but you know that you must.");
        input.next();
    }
}
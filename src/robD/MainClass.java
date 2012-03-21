package robD;

import java.util.Scanner;
import java.util.Random;
import java.util.Set;

public class MainClass{
    public static void main (String args[]){
        new MainClass();
        }

    public void MainClass(){
        System.out.println("Welcome to the GAME!!!!!");
        System.out.println("Enter your name");
        Scanner keyboard = new Scanner(System.in);
        String PlayerName = keyboard.nextLine();
        System.out.printf("Welcome %s", PlayerName);
        System.out.println("You may now choose a power that you can use 3 times in the game to bypass difficult obstacles");
        System.out.println("1 = LAZOR!!!!");
        System.out.println("2 = THREW IT ON THE GROUND!!!!!");
        System.out.println("3 = SUMMON ROBOT DRAGON!!!!!!!!");
        System.out.println("4 = SUMMON WAKELING!!!!!");
        System.out.println("5 = ARROW TO THE KNEE!!!!!");
        System.out.println("6 = HARDCORE MODE (NO POWER!!)");
        int choice1 = keyboard.nextInt();
        Choices ChoiceObject = new Choices();
        new Player (PlayerName,true,ChoiceObject.getChoice1();,0,0,0);
        System.out.printf("You can chosen option %s",ChoiceObject.getChoice1());
        System.out.println("Do you wish for help before you start the game?");
;


        }
}
package rob;

import java.util.Scanner;

public class MainClass {
    public static void main(String args[]) {
        //TitleScreenCredits.titleRun();
        game();
    }

    static Scanner input = new Scanner(System.in);

    public static void game() {
        //System.out.println(rob.PlayerAtt.name);
        //CombatEngine.combatTurn(Enemy.enemyYouFight, PlayerAtt.player);
        String[][] board = new String[5][5];
        Board.setBoard(2, 1);
        Board.setAll(board, "O");
        int x = 0;
        while (x < 100) {
            Board.stepsRequired(2, 1, PlayerAtt.player, board);
        }
        System.out.println("Program Terminated");
    }
    //I need to make a method that finds out how many steps it will require to get to a position a,b from position x,y.

    //Find x-a; that is how many along it will have to go to get in line
    //Find (x-a) + (y-b) that is how many steps it will require to get from a,b to x,y!!!

    //WIN
}
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
        CombatEngine.move(board, 2, 1, PlayerAtt.player);
        System.out.println("Program Terminated");
    }
    //right = board[x][y+1]
    //left = board[x][y-1]
    //down = board[x+1][y]
    //up = board[x-1][y]
}
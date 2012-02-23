package rob;

public class MainClass {
    public static void main(String args[]) {
        //TitleScreenCredits.titleRun();
        game();
    }

    public static void game() {
        //System.out.println(rob.PlayerAtt.name);
        //CombatEngine.combatTurn(Enemy.enemyYouFight, PlayerAtt.player);
        String[][] board = new String[7][7];
        Board.setAll(board, "X");
        board[3][1] = "P";
        board[3][5] = "E";
        Board.displayBoard(board);
        System.out.println("Program Terminated");
    }
}
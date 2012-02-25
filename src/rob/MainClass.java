package rob;

public class MainClass {
    public static void main(String args[]) {
        TitleScreenCredits.titleRun();
    }

    public static void game() {
        System.out.println(rob.PlayerAtt.name);
        CombatEngine.combatTurn(Enemy.enemyYouFight, PlayerAtt.player, Board.board);
        System.out.println("Program Terminated");
    }
}

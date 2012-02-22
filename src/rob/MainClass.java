package rob;

public class MainClass {
    public static void main(String args[]) {
        TitleScreenCredits.titleRun();
    }

    public static void game() {
        //System.out.println(rob.PlayerAtt.name);
        //CombatBoard.boardDisplay();
        CombatEngine.combatTurn(Enemy.enemyYouFight, PlayerAtt.player);
        System.out.println("Program Terminated");
    }
}
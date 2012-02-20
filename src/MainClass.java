public class MainClass {
    public static void main(String args[]) {
        //TitleScreenCredits.titleRun();
        game();
    }

    public static void game() {
        //System.out.println(PlayerAtt.name);
        //CombatOptions.meleeFight(Enemy.enemyYouFight, PlayerAtt.player);
        //CombatBoard.boardDisplay();
        CombatOptions.combatTurn(Enemy.enemyYouFight, PlayerAtt.player);
        System.out.println("Program Terminated");
    }
}
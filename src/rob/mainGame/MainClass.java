package rob.mainGame;

public class MainClass {
    public static void main(String args[]) {
        TitleScreenCredits.titleRun();
    }

    public static void game() {
        System.out.println(Player.name);
        CombatEngine.combatTurn(Enemy.enemyYouFight, Player.player, new GameBoard());
        System.out.println("Program Terminated");
    }
}

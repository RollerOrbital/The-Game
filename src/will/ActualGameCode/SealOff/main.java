package will.ActualGameCode.SealOff;

public class main {

    public static void main(String[] args) {

        Player player = new Player();
        player.name();

        Enemy enemy = new Enemy();
        enemy.enemyName();

        combatEngine combatEngine = new combatEngine();
        combatEngine.intro();

        while (Player.playerhp > 0) {
            while (Enemy.enemyHp > 0) {
                combatEngine.fight();
            }
        }

        // combatEngine.win()???
    }
}

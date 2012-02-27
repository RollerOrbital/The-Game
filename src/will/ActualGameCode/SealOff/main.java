package will.ActualGameCode.SealOff;

public class main {

    public static void main(String[] args) {

        Player player = new Player();
        player.name();
        player.isAlive();

        Enemy enemy = new Enemy();
        enemy.enemyName();

        combatEngine combatEngine = new combatEngine();
        combatEngine.intro();


        while (Player.alive) {
            while (Enemy.enemyIsAlive)
                combatEngine.moveChoice();
        }
    }

}

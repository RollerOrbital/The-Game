package rob;

public class MainClass {
    public static void main(String args[]) {
        //TitleScreenCredits.titleRun();
        game();
    }

    public static void game() {
        System.out.println(rob.PlayerAtt.name);
        CombatEngine.combatTurn(Enemy.enemyYouFight, PlayerAtt.player, Board.board);
        System.out.println("Program Terminated");
    }

    //Bug 1

//    What is the xco of where you want to go?
//    1
//    What is the yco of where you want to go?
//    1
//    You are now at position (1,1)
//    O	O	O	O	O
//    O	P	O	O	E	O	O	O	O	O	O
//    O	O	O	O	O
//    O	O	O	O	O

    //what is THIS?!


    //Bug 2

//    The player can still go on top of the enemy without contest -__-
}

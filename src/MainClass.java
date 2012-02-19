public class MainClass {
	public static void main(String args[]){
		TitleScreenCredits.titleRun();
	}
	public static void game(){
		//System.out.println(PlayerAtt.name);
		//MeleeBattle.meleeFight(Enemy.enemyYouFight, PlayerAtt.player);
		CombatBoard.boardDisplay();
		System.out.println("Program Terminated");
	}
}
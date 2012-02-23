package rob;

import java.util.Random;

public class Enemy {
    String name;
    int scope, aegis, pace, twitch, cognition, vigor, hp, basehp, mp, basemp, luck, baseYield, level;

    public Enemy(String name, int scope, int aegis, int pace, int twitch, int cognition, int vigor, int hp, int basehp, int mp, int basemp, int luck, int baseYield, int level) {
        this.name = name;
        this.scope = scope;
        this.aegis = aegis;
        this.pace = pace;
        this.twitch = twitch;
        this.cognition = cognition;
        this.vigor = vigor;
        this.hp = hp;
        this.basehp = basehp;
        this.mp = mp;
        this.basemp = basemp;
        this.luck = luck;
        this.baseYield = baseYield;
        this.level = level;
    }

    //mafia enemies
    static Enemy mafia_grunt = new Enemy("Mafia Grunt", 4, 4, 4, 8, 20, 8, 60, 60, 20, 20, 6, 6, 3);
    static Enemy mafia_executive = new Enemy("Mafia Executive", 5, 20, 5, 15, 60, 35, 150, 150, 70, 70, 20, 20, 10);
    //ipod enemies
    static Enemy shuffle_drone = new Enemy("Shuffle drone", 1, 3, 3, 12, 40, 7, 40, 40, 30, 30, 6, 4, 2);
    static Enemy nano_drone = new Enemy("Nano drone", 3, 7, 3, 15, 50, 12, 60, 60, 50, 50, 8, 10, 5);
    //police enemies
    static Enemy police_trooper = new Enemy("Police Trooper", 4, 5, 3, 15, 30, 10, 60, 60, 40, 40, 10, 3, 1);
    static Enemy police_riotshield = new Enemy("Police Riotshield", 1, 25, 2, 6, 30, 10, 120, 120, 20, 20, 3, 8, 4);


    static Random randomNum = new Random();
    static int randomEnemy = randomNum.nextInt(6);
    static Enemy enemies[] = {mafia_grunt, mafia_executive, shuffle_drone, nano_drone, police_trooper, police_riotshield};
    static Enemy enemyYouFight = enemies[randomEnemy];
}
//
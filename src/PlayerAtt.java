import java.util.Scanner;

public class PlayerAtt {

    private String name() {
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = input.nextLine();
        return (name);
    }

    MeleeWeapon Mweapon;
    RangeWeapon Rweapon;
    static String name;
    int scope, aegis, pace, agility, cognition, vigor, xp, hp, basehp, ep, baseep, levelUpxp, sp;
    static int luck, level;static {
        luck = 10;
        level = 1;
    }

    public PlayerAtt(MeleeWeapon Mweapon, RangeWeapon Rweapon, int scope, int aegis, int pace, int agility, int cognition, int vigor, int xp, int hp, int basehp, int ep, int baseep, int levelUpxp, int sp) {
        this.Mweapon = Mweapon;
        this.Rweapon = Rweapon;
        PlayerAtt.name = name();
        this.scope = scope;
        this.aegis = aegis;
        this.pace = pace;
        this.agility = agility;
        this.cognition = cognition;
        this.vigor = vigor;
        this.xp = xp;
        this.hp = hp;
        this.basehp = basehp;
        this.ep = ep;
        this.baseep = baseep;
        this.levelUpxp = levelUpxp;
        this.sp = sp;
    }

    static PlayerAtt player = new PlayerAtt(MeleeWeapon.fists, RangeWeapon.bb_gun, 2, 5, 5, 10, 30, 15, 0, 100, 100, 50, 50, (level * level) + 40, 0);

}

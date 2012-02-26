package rob.mainGame;

import java.util.Scanner;

public class Player {

    private String name() {
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = input.nextLine();
        return (name);
    }

    MeleeWeapon Mweapon;
    RangeWeapon Rweapon;
    static String name;
    int scope, aegis, pace, twitch, cognition, vigor, exp, hp, basehp, mp, basemp, levelUpxp, sp, xpos, ypos;
    static int fortune, level;static {
        fortune = 10;
        level = 1;
    }

    public Player(MeleeWeapon Mweapon, RangeWeapon Rweapon, int scope, int aegis, int pace, int twitch, int cognition, int vigor, int exp, int hp, int basehp, int mp, int basemp, int levelUpxp, int sp, int xpos, int ypos) {
        this.Mweapon = Mweapon;
        this.Rweapon = Rweapon;
        Player.name = name();
        this.scope = scope;
        this.aegis = aegis;
        this.pace = pace;
        this.twitch = twitch;
        this.cognition = cognition;
        this.vigor = vigor;
        this.exp = exp;
        this.hp = hp;
        this.basehp = basehp;
        this.mp = mp;
        this.basemp = basemp;
        this.levelUpxp = levelUpxp;
        this.sp = sp;
        this.xpos = xpos;
        this.ypos = ypos;
    }

    static Player player = new Player(MeleeWeapon.fists, RangeWeapon.bb_gun, 2, 5, 5, 10, 30, 15, 0, 100, 100, 50, 50, (level * level) + 40, 0, 0, 0);

    public static MeleeWeapon MweaponInventory[] = {MeleeWeapon.fists, MeleeWeapon.police_baton};
    public static RangeWeapon RweaponInventory[] = {RangeWeapon.bb_gun, RangeWeapon.revolver};
    public static HealingItem HIInventory[] = {HealingItem.bandages, HealingItem.potion};
    public static DamageMagic DMInventory[] = {DamageMagic.fireball, DamageMagic.thunder_bolt};
    public static HealingMagic HMInventory[] = {HealingMagic.basic_heal, HealingMagic.recover};
}
